import re
from pathlib import Path

RULES = [
    {
        "id": "MASVS-CRYPTO-1-001",
        "name": "MD5 — Algorithme de hachage cassé",
        "pattern": r'MD5',
        "severity": "critique",
        "masvs": "MASVS-CRYPTO-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-1/",
        "owasp_text": "L'app n'utilise pas de primitives cryptographiques faibles ou dépréciées.",
        "description": "MD5 est cryptographiquement cassé depuis 2004.",
        "fix": "Utiliser SHA-256 (MessageDigest.getInstance('SHA-256'))"
    },
    {
        "id": "MASVS-CRYPTO-1-002",
        "name": "SHA-1 — Algorithme déprécié",
        "pattern": r'SHA-1|SHA1',
        "severity": "critique",
        "masvs": "MASVS-CRYPTO-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-1/",
        "owasp_text": "L'app n'utilise pas de primitives cryptographiques faibles ou dépréciées.",
        "description": "SHA-1 est vulnérable aux attaques par collision depuis 2017.",
        "fix": "Utiliser SHA-256 minimum."
    },
    {
        "id": "MASVS-CRYPTO-1-003",
        "name": "AES/ECB — Mode non sécurisé",
        "pattern": r'AES/ECB|ECB',
        "severity": "critique",
        "masvs": "MASVS-CRYPTO-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-1/",
        "owasp_text": "L'app n'utilise pas de primitives cryptographiques faibles ou dépréciées.",
        "description": "AES/ECB révèle les patterns des données chiffrées.",
        "fix": "Utiliser AES/GCM/NoPadding avec IV aléatoire."
    },
    {
        "id": "MASVS-CRYPTO-1-004",
        "name": "Clé cryptographique hardcodée",
        "pattern": r'SecretKeySpec|IvParameterSpec',
        "severity": "critique",
        "masvs": "MASVS-CRYPTO-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-1/",
        "owasp_text": "L'app n'utilise pas de primitives cryptographiques faibles ou dépréciées.",
        "description": "Clé cryptographique définie en dur dans le code source.",
        "fix": "Utiliser Android Keystore System."
    },
    {
        "id": "MASVS-CRYPTO-1-005",
        "name": "Random() — Générateur non cryptographique",
        "pattern": r'new Random\(',
        "severity": "majeur",
        "masvs": "MASVS-CRYPTO-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-1/",
        "owasp_text": "L'app n'utilise pas de primitives cryptographiques faibles ou dépréciées.",
        "description": "java.util.Random est prédictible.",
        "fix": "Utiliser java.security.SecureRandom."
    },
    {
        "id": "MASVS-CRYPTO-2-001",
        "name": "Cipher sans mode spécifié",
        "pattern": r'Cipher\.getInstance\s*\(\s*"AES"\s*\)',
        "severity": "majeur",
        "masvs": "MASVS-CRYPTO-2",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-2/",
        "owasp_text": "L'app utilise des implémentations éprouvées de primitives cryptographiques.",
        "description": "Cipher.getInstance('AES') utilise ECB par défaut.",
        "fix": "Cipher.getInstance('AES/GCM/NoPadding')"
    },
    {
        "id": "MASVS-CRYPTO-2-002",
        "name": "DES — Algorithme obsolète",
        "pattern": r'"DES"|DESede',
        "severity": "critique",
        "masvs": "MASVS-CRYPTO-2",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-2/",
        "owasp_text": "L'app utilise des implémentations éprouvées de primitives cryptographiques.",
        "description": "DES utilise une clé 56-bit, cassable en quelques heures.",
        "fix": "Utiliser AES-256-GCM."
    },
    {
        "id": "MASVS-CRYPTO-2-003",
        "name": "RC4 — Chiffrement stream cassé",
        "pattern": r'"RC4"|"ARCFOUR"',
        "severity": "critique",
        "masvs": "MASVS-CRYPTO-2",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-2/",
        "owasp_text": "L'app utilise des implémentations éprouvées de primitives cryptographiques.",
        "description": "RC4 est cassé et interdit dans TLS.",
        "fix": "Utiliser AES-GCM ou ChaCha20-Poly1305."
    },
]

def scan_file(file_path: Path) -> list:
    findings = []
    try:
        content = file_path.read_text(encoding="utf-8", errors="ignore")
        lines = content.splitlines()
        for rule in RULES:
            for i, line in enumerate(lines, start=1):
                if re.search(rule["pattern"], line):
                    findings.append({
                        "file": str(file_path),
                        "line": i,
                        "code": line.strip(),
                        "rule_id": rule["id"],
                        "name": rule["name"],
                        "severity": rule["severity"],
                        "masvs": rule["masvs"],
                        "owasp_link": rule["owasp_link"],
                        "owasp_text": rule["owasp_text"],
                        "description": rule["description"],
                        "fix": rule["fix"]
                    })
    except Exception as e:
        print(f"[!] Erreur lecture {file_path}: {e}")
    return findings

def scan_all(files: list) -> list:
    all_findings = []
    for f in files:
        print(f"[*] Scan : {f}")
        all_findings.extend(scan_file(Path(f)))
    seen = set()
    unique = []
    for f in all_findings:
        key = (f["rule_id"], f["file"], f["line"])
        if key not in seen:
            seen.add(key)
            unique.append(f)
    print(f"[+] {len(unique)} findings détectés (après déduplication)")
    return unique