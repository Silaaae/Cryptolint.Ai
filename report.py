from pathlib import Path
from datetime import datetime
from apk_parser import parse_apk
from scanner import scan_all, RULES
from ai_analyzer import analyze_all

def generate_report(findings: list, apk_name: str):
    now = datetime.now().strftime("%d/%m/%Y %H:%M")
    critiques = [f for f in findings if f['severity'] == 'critique']
    majeurs = [f for f in findings if f['severity'] == 'majeur']

    # Conformité MASVS
    masvs1_findings = [f for f in findings if f['masvs'] == 'MASVS-CRYPTO-1']
    masvs2_findings = [f for f in findings if f['masvs'] == 'MASVS-CRYPTO-2']
    masvs1_status = "ÉCHOUÉ" if masvs1_findings else "PASSÉ"
    masvs2_status = "ÉCHOUÉ" if masvs2_findings else "PASSÉ"
    masvs1_color = "#ff4444" if masvs1_findings else "#a8ff78"
    masvs2_color = "#ff4444" if masvs2_findings else "#a8ff78"

    rows = ""
    for f in findings:
        color = "#ff4444" if f['severity'] == 'critique' else "#ff8800"
        correctif = f.get('ai_correctif', f.get('fix','')).replace('\n', '<br>').replace(' ', '&nbsp;')
        rows += f"""
        <tr>
            <td><span class="badge" style="background:{color}">{f['severity'].upper()}</span></td>
            <td><a class="masvs-tag" href="{f['owasp_link']}" target="_blank">{f['masvs']}</a></td>
            <td>
                <strong>{f['name']}</strong><br>
                <small style="color:#8b949e;font-style:italic">"{f['owasp_text']}"</small>
            </td>
            <td class="mono">{Path(f['file']).name}</td>
            <td style="text-align:center">{f['line']}</td>
            <td class="mono">{f['code']}</td>
            <td>{f.get('ai_explication', f['description'])}</td>
            <td>{f.get('ai_impact', '-')}</td>
            <td class="mono" style="color:#a8ff78">{correctif}</td>
        </tr>"""

    html = f"""<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>CryptoLint AI — Rapport MASVS</title>
    <style>
        * {{ box-sizing: border-box; margin: 0; padding: 0; }}
        body {{ font-family: 'Segoe UI', Arial, sans-serif; background: #0d1117; color: #c9d1d9; padding: 40px; }}
        .header {{ display: flex; justify-content: space-between; align-items: center; margin-bottom: 30px; padding-bottom: 20px; border-bottom: 2px solid #58a6ff; }}
        .header h1 {{ font-size: 28px; color: #58a6ff; }}
        .header h1 span {{ color: #a8ff78; }}
        .meta {{ color: #8b949e; font-size: 13px; }}
        .cards {{ display: flex; gap: 16px; margin-bottom: 30px; }}
        .card {{ flex: 1; padding: 20px; border-radius: 10px; text-align: center; }}
        .card h2 {{ font-size: 42px; font-weight: 700; }}
        .card p {{ font-size: 13px; margin-top: 4px; color: #8b949e; }}
        .rouge {{ background: #2d1515; border: 1px solid #ff4444; }}
        .rouge h2 {{ color: #ff4444; }}
        .orange {{ background: #2d1f0f; border: 1px solid #ff8800; }}
        .orange h2 {{ color: #ff8800; }}
        .bleu {{ background: #0f1f2d; border: 1px solid #58a6ff; }}
        .bleu h2 {{ color: #58a6ff; }}
        .section-title {{ font-size: 18px; font-weight: 600; color: #58a6ff; margin: 30px 0 15px; padding-bottom: 8px; border-bottom: 1px solid #21262d; }}
        table {{ width: 100%; border-collapse: collapse; font-size: 12px; }}
        th {{ background: #161b22; padding: 12px 10px; text-align: left; color: #58a6ff; font-weight: 600; border-bottom: 2px solid #58a6ff; }}
        td {{ padding: 10px; border-bottom: 1px solid #21262d; vertical-align: top; }}
        tr:hover td {{ background: #161b22; }}
        .badge {{ padding: 3px 10px; border-radius: 20px; font-size: 11px; font-weight: 700; color: white; }}
        .masvs-tag {{ background: #1f3a5f; color: #58a6ff; padding: 2px 8px; border-radius: 4px; font-size: 11px; font-weight: 600; white-space: nowrap; text-decoration: none; }}
        .masvs-tag:hover {{ background: #2d4f7f; }}
        .mono {{ font-family: 'Courier New', monospace; font-size: 11px; color: #f0883e; }}
        .conformity-box {{ display: flex; gap: 16px; margin-bottom: 30px; }}
        .conformity-card {{ flex: 1; padding: 16px 20px; border-radius: 10px; }}
        .conformity-card h3 {{ font-size: 15px; margin-bottom: 6px; }}
        .conformity-card p {{ font-size: 12px; color: #8b949e; margin-bottom: 8px; }}
        .conformity-card a {{ font-size: 11px; color: #58a6ff; }}
        .status {{ font-size: 13px; font-weight: 700; padding: 4px 12px; border-radius: 20px; display: inline-block; }}
        .owasp-box {{ background: #161b22; border: 1px solid #30363d; border-radius: 8px; padding: 16px; margin-bottom: 20px; }}
        .owasp-box h3 {{ color: #58a6ff; margin-bottom: 8px; }}
        .owasp-box p {{ color: #8b949e; font-size: 13px; line-height: 1.6; }}
        .owasp-box a {{ color: #a8ff78; }}
        footer {{ margin-top: 40px; text-align: center; color: #8b949e; font-size: 12px; border-top: 1px solid #21262d; padding-top: 20px; }}
    </style>
</head>
<body>

    <div class="header">
        <div>
            <h1>🔐 CryptoLint <span>AI</span></h1>
            <p class="meta">Analyse cryptographique statique — Aligné OWASP MASVS/MASTG</p>
        </div>
        <div style="text-align:right">
            <p class="meta">APK : <strong style="color:#c9d1d9">{apk_name}</strong></p>
            <p class="meta">Généré le {now}</p>
        </div>
    </div>

    <div class="cards">
        <div class="card rouge"><h2>{len(critiques)}</h2><p>🔴 Critique</p></div>
        <div class="card orange"><h2>{len(majeurs)}</h2><p>🟠 Majeur</p></div>
        <div class="card bleu"><h2>{len(findings)}</h2><p>📊 Total findings</p></div>
    </div>

    <div class="section-title">📋 Conformité OWASP MASVS</div>
    <div class="conformity-box">
        <div class="conformity-card" style="background:#1a1a2e; border: 1px solid {masvs1_color}">
            <h3 style="color:{masvs1_color}">MASVS-CRYPTO-1</h3>
            <p>L'app n'utilise pas de primitives cryptographiques faibles ou dépréciées.</p>
            <a href="https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-1/" target="_blank">→ Voir contrôle OWASP officiel</a><br><br>
            <span class="status" style="background:{masvs1_color}22; color:{masvs1_color}; border: 1px solid {masvs1_color}">
                {masvs1_status} — {len(masvs1_findings)} violation(s)
            </span>
        </div>
        <div class="conformity-card" style="background:#1a1a2e; border: 1px solid {masvs2_color}">
            <h3 style="color:{masvs2_color}">MASVS-CRYPTO-2</h3>
            <p>L'app utilise des implémentations éprouvées de primitives cryptographiques.</p>
            <a href="https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-2/" target="_blank">→ Voir contrôle OWASP officiel</a><br><br>
            <span class="status" style="background:{masvs2_color}22; color:{masvs2_color}; border: 1px solid {masvs2_color}">
                {masvs2_status} — {len(masvs2_findings)} violation(s)
            </span>
        </div>
    </div>

    <div class="owasp-box">
        <h3>📖 Référentiel OWASP utilisé</h3>
        <p>
            Les vulnérabilités sont mappées selon 
            <a href="https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-1/" target="_blank">MASVS-CRYPTO-1</a> et 
            <a href="https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-2/" target="_blank">MASVS-CRYPTO-2</a> 
            du standard OWASP MASVS. Chaque finding cite le texte exact du contrôle OWASP violé.
            Les corrections sont générées par IA (LLaMA 3.3 70B) basées sur les recommandations MASTG officielles.
        </p>
    </div>

    <div class="section-title">🔍 Findings détectés</div>
    <div style="overflow-x:auto">
    <table>
        <tr>
            <th>Sévérité</th>
            <th>Contrôle OWASP</th>
            <th>Vulnérabilité</th>
            <th>Fichier</th>
            <th>Ligne</th>
            <th>Code vulnérable</th>
            <th>Explication IA</th>
            <th>Impact</th>
            <th>Correctif IA</th>
        </tr>
        {rows}
    </table>
    </div>

    <footer>
        CryptoLint AI v0.1.0 — 
        <a href="https://mas.owasp.org/MASVS/" style="color:#58a6ff">OWASP MASVS</a> / 
        <a href="https://mas.owasp.org/MASTG/" style="color:#58a6ff">MASTG</a> — 
        Analyse IA par LLaMA 3.3 70B (Groq API)
    </footer>

</body>
</html>"""

    output = Path("output/rapport_cryptolint.html")
    output.parent.mkdir(exist_ok=True)
    output.write_text(html, encoding="utf-8")
    print(f"[+] Rapport HTML généré : {output.resolve()}")


if __name__ == "__main__":
    files = parse_apk(r"C:\Users\NISRINE\cryptolint-ai\UnCrackable-Level1.apk")
    findings = scan_all(files)
    findings = analyze_all(findings)
    generate_report(findings, "UnCrackable-Level1.apk")