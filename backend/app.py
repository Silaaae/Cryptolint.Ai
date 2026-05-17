from flask import Flask, request, jsonify, send_from_directory
from flask_cors import CORS
from pathlib import Path
import subprocess
import shutil
import uuid
import json
import os
from datetime import datetime

from scanner import scan_all, scan_dex, RULES
from ai_analyzer import analyze_all
from report import generate_report

app = Flask(__name__)
CORS(app)

UPLOAD_DIR = Path("uploads")
UPLOAD_DIR.mkdir(exist_ok=True)
HISTORY_FILE = Path("history.json")


def load_history():
    if HISTORY_FILE.exists():
        try:
            return json.loads(HISTORY_FILE.read_text())
        except:
            return []
    return []


def save_history(history):
    HISTORY_FILE.write_text(json.dumps(history, ensure_ascii=False, indent=2))


def decompile_apk(apk_path: Path, output_dir: Path) -> list:
    """Decompile APK with jadx if available, else extract as zip."""
    java_files = []

    # Try JADX first
    jadx_bin = shutil.which("jadx")
    if jadx_bin:
        try:
            result = subprocess.run(
                [jadx_bin, "-d", str(output_dir), str(apk_path)],
                capture_output=True, text=True, timeout=120
            )
            java_files = list(output_dir.rglob("*.java"))
            xml_files = list(output_dir.rglob("*.xml"))
            print(f"[+] JADX: {len(java_files)} Java + {len(xml_files)} XML")
            if java_files:
                return java_files + xml_files
        except (FileNotFoundError, subprocess.TimeoutExpired) as e:
            print(f"[!] JADX failed: {e}")

    # Fallback: extract APK as zip
    try:
        import zipfile
        with zipfile.ZipFile(apk_path, 'r') as z:
            z.extractall(output_dir)
        smali = list(output_dir.rglob("*.smali"))
        xml = list(output_dir.rglob("*.xml"))
        dex = list(output_dir.rglob("*.dex"))
        print(f"[+] ZIP fallback: {len(smali)} smali, {len(xml)} xml, {len(dex)} dex")
        return smali + xml
    except Exception as e2:
        print(f"[!] ZIP failed: {e2}")
        return []


@app.route("/api/analyze", methods=["POST"])
def analyze():
    if "apk" not in request.files:
        return jsonify({"error": "Aucun fichier APK fourni"}), 400

    apk_file = request.files["apk"]
    if not apk_file.filename.endswith(".apk"):
        return jsonify({"error": "Fichier doit etre un .apk"}), 400

    scan_id = str(uuid.uuid4())[:8]
    scan_dir = UPLOAD_DIR / scan_id
    scan_dir.mkdir(parents=True, exist_ok=True)

    apk_path = scan_dir / apk_file.filename
    apk_file.save(str(apk_path))
    size_kb = apk_path.stat().st_size // 1024
    print(f"[+] APK: {apk_path} ({size_kb} KB)")

    # Decompile
    decompiled_dir = scan_dir / "decompiled"
    decompiled_dir.mkdir(exist_ok=True)
    text_files = decompile_apk(apk_path, decompiled_dir)

    # Scan text files (Java, Smali, XML)
    findings = scan_all([str(f) for f in text_files])

    # Also scan DEX directly for string patterns
    dex_files = list(decompiled_dir.rglob("*.dex"))
    # If not extracted yet, try the APK itself
    if not dex_files:
        import zipfile
        try:
            with zipfile.ZipFile(apk_path, 'r') as z:
                for name in z.namelist():
                    if name.endswith(".dex"):
                        out = decompiled_dir / name
                        out.parent.mkdir(parents=True, exist_ok=True)
                        out.write_bytes(z.read(name))
                        dex_files.append(out)
        except Exception as e:
            print(f"[!] DEX extract: {e}")

    for dex in dex_files:
        dex_findings = scan_dex(dex)
        findings.extend(dex_findings)
        print(f"[+] DEX {dex.name}: {len(dex_findings)} findings")

    # Also scan the APK binary itself as last resort
    apk_findings = scan_dex(apk_path)
    findings.extend(apk_findings)

    # Deduplicate
    seen = set()
    unique = []
    for f in findings:
        key = (f["rule_id"], f["file"], f["line"])
        if key not in seen:
            seen.add(key)
            unique.append(f)
    findings = unique
    print(f"[+] {len(findings)} findings uniques")

    # AI Analysis (optional)
    use_ai = bool(os.environ.get("GROQ_API_KEY", ""))
    if use_ai and findings:
        findings = analyze_all(findings[:20])
        print(f"[+] IA appliquee sur {min(20, len(findings))} findings")

    # Generate HTML report
    report_path = scan_dir / "rapport.html"
    generate_report(findings, apk_file.filename, str(report_path))

    # Compute stats
    critiques = sum(1 for f in findings if f["severity"] == "critique")
    majeurs = sum(1 for f in findings if f["severity"] == "majeur")
    mineurs = sum(1 for f in findings if f["severity"] == "mineur")
    score = max(0, 100 - (critiques * 15 + majeurs * 7 + mineurs * 2))

    # Save to history
    history = load_history()
    entry = {
        "id": scan_id,
        "apk_name": apk_file.filename,
        "apk_size": f"{size_kb} KB",
        "date": datetime.now().strftime("%d/%m/%Y %H:%M"),
        "total": len(findings),
        "critiques": critiques,
        "majeurs": majeurs,
        "mineurs": mineurs,
        "score": score,
        "report_url": f"/api/report/{scan_id}"
    }
    history.insert(0, entry)
    save_history(history)

    return jsonify({
        "success": True,
        "scan_id": scan_id,
        "apk_name": apk_file.filename,
        "findings": findings,
        "stats": {
            "total": len(findings),
            "critiques": critiques,
            "majeurs": majeurs,
            "mineurs": mineurs,
            "score": score
        },
        "report_url": f"/api/report/{scan_id}"
    })


@app.route("/api/history", methods=["GET"])
def get_history():
    return jsonify(load_history())


@app.route("/api/history/<scan_id>", methods=["DELETE"])
def delete_history(scan_id):
    history = [h for h in load_history() if h["id"] != scan_id]
    save_history(history)
    scan_dir = UPLOAD_DIR / scan_id
    if scan_dir.exists():
        shutil.rmtree(scan_dir)
    return jsonify({"success": True})


@app.route("/api/report/<scan_id>", methods=["GET"])
def get_report(scan_id):
    scan_dir = UPLOAD_DIR / scan_id
    if not (scan_dir / "rapport.html").exists():
        return jsonify({"error": "Rapport non trouve"}), 404
    return send_from_directory(str(scan_dir.resolve()), "rapport.html")


@app.route("/api/health", methods=["GET"])
def health():
    return jsonify({
        "status": "ok",
        "jadx": shutil.which("jadx") is not None,
        "groq": bool(os.environ.get("GROQ_API_KEY")),
        "rules": len(RULES)
    })


@app.route("/", methods=["GET"])
def root():
    return jsonify({"name": "CryptoLint AI", "version": "2.0.0", "status": "running"})


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000, debug=True)