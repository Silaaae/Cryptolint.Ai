import argparse
import sys
from pathlib import Path
from apk_parser import parse_apk
from scanner import scan_all
from ai_analyzer import analyze_all
from report import generate_report

def main():
    parser = argparse.ArgumentParser(
        prog="CryptoLint AI",
        description="Analyse cryptographique statique d'APK Android — Aligné OWASP MASVS"
    )
    parser.add_argument("--apk", required=True, help="Chemin vers le fichier APK")
    parser.add_argument("--no-ai", action="store_true", help="Désactiver l'analyse IA")
    args = parser.parse_args()

    apk_path = Path(args.apk)
    if not apk_path.exists():
        print(f"[!] Erreur : APK introuvable : {apk_path}")
        sys.exit(1)

    print(f"""
╔═══════════════════════════════════════╗
║         CryptoLint AI v0.1.0          ║
║  Analyse MASVS-CRYPTO — OWASP MASTG   ║
╚═══════════════════════════════════════╝
    """)

    print(f"[*] APK cible : {apk_path.name}")
    files = parse_apk(str(apk_path))
    findings = scan_all(files)

    if not findings:
        print("[+] Aucune vulnérabilité détectée !")
        sys.exit(0)

    if not args.no_ai:
        findings = analyze_all(findings)

    generate_report(findings, apk_path.name)

    critiques = [f for f in findings if f['severity'] == 'critique']
    majeurs = [f for f in findings if f['severity'] == 'majeur']

    print(f"""
╔═══════════════════════════════════════╗
║            RÉSUMÉ FINAL               ║
╠═══════════════════════════════════════╣
║  🔴 Critique : {str(len(critiques)).ljust(25)}║
║  🟠 Majeur   : {str(len(majeurs)).ljust(25)}║
║  📊 Total    : {str(len(findings)).ljust(25)}║
╚═══════════════════════════════════════╝
    """)

if __name__ == "__main__":
    main()