import re
from pathlib import Path

RULES = [
    # ──── MASVS-CRYPTO-1 : Primitives faibles ────
    {
        "id": "MASVS-CRYPTO-1-001",
        "name": "MD5 — Algorithme de hachage cassé",
        "pattern": r'MD5|MessageDigest\.getInstance\s*\(\s*["\']MD5["\']\s*\)',
        "severity": "critique",
        "masvs": "MASVS-CRYPTO-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-1/",
        "owasp_text": "L'app n'utilise pas de primitives cryptographiques faibles ou dépréciées.",
        "description": "MD5 est cryptographiquement cassé depuis 2004. Susceptible aux collisions.",
        "fix": "Utiliser SHA-256 (MessageDigest.getInstance('SHA-256'))"
    },
    {
        "id": "MASVS-CRYPTO-1-002",
        "name": "SHA-1 — Algorithme déprécié",
        "pattern": r'SHA-1|SHA1|getInstance\s*\(\s*["\']SHA-1["\']\s*\)',
        "severity": "critique",
        "masvs": "MASVS-CRYPTO-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-1/",
        "owasp_text": "L'app n'utilise pas de primitives cryptographiques faibles ou dépréciées.",
        "description": "SHA-1 est vulnérable aux collisions (SHAttered 2017). Interdit par NIST.",
        "fix": "Utiliser SHA-256 minimum."
    },
    {
        "id": "MASVS-CRYPTO-1-003",
        "name": "AES/ECB — Mode non sécurisé",
        "pattern": r'AES/ECB|ECB|getInstance\s*\(\s*["\']AES/ECB',
        "severity": "critique",
        "masvs": "MASVS-CRYPTO-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-1/",
        "owasp_text": "L'app n'utilise pas de primitives cryptographiques faibles ou dépréciées.",
        "description": "AES/ECB révèle les patterns des données chiffrées (attaque Penguin).",
        "fix": "Utiliser AES/GCM/NoPadding avec IV aléatoire (SecureRandom)."
    },
    {
        "id": "MASVS-CRYPTO-1-004",
        "name": "Clé cryptographique hardcodée",
        "pattern": r'SecretKeySpec\s*\(|new\s+SecretKeySpec|IvParameterSpec\s*\(',
        "severity": "critique",
        "masvs": "MASVS-CRYPTO-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-1/",
        "owasp_text": "L'app n'utilise pas de primitives cryptographiques faibles ou dépréciées.",
        "description": "Clé ou IV cryptographique défini statiquement dans le code source.",
        "fix": "Utiliser Android Keystore System pour générer et stocker les clés."
    },
    {
        "id": "MASVS-CRYPTO-1-005",
        "name": "Random() — Générateur non cryptographique",
        "pattern": r'new\s+Random\s*\(|java\.util\.Random',
        "severity": "majeur",
        "masvs": "MASVS-CRYPTO-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-1/",
        "owasp_text": "L'app n'utilise pas de primitives cryptographiques faibles ou dépréciées.",
        "description": "java.util.Random est prédictible via son seed linéaire.",
        "fix": "Utiliser java.security.SecureRandom."
    },
    # ──── MASVS-CRYPTO-2 : Implémentations éprouvées ────
    {
        "id": "MASVS-CRYPTO-2-001",
        "name": "Cipher sans mode spécifié",
        "pattern": r'Cipher\.getInstance\s*\(\s*"AES"\s*\)',
        "severity": "majeur",
        "masvs": "MASVS-CRYPTO-2",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-2/",
        "owasp_text": "L'app utilise des implémentations éprouvées de primitives cryptographiques.",
        "description": "Cipher.getInstance('AES') utilise ECB par défaut sur Android.",
        "fix": "Cipher.getInstance('AES/GCM/NoPadding')"
    },
    {
        "id": "MASVS-CRYPTO-2-002",
        "name": "DES — Algorithme obsolète",
        "pattern": r'"DES"|DESede|getInstance\s*\(\s*["\']DES',
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
        "pattern": r'"RC4"|"ARCFOUR"|RC4',
        "severity": "critique",
        "masvs": "MASVS-CRYPTO-2",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-2/",
        "owasp_text": "L'app utilise des implémentations éprouvées de primitives cryptographiques.",
        "description": "RC4 est cassé et interdit dans TLS (RFC 7465).",
        "fix": "Utiliser AES-GCM ou ChaCha20-Poly1305."
    },
    {
        "id": "MASVS-CRYPTO-2-004",
        "name": "RSA sans OAEP",
        "pattern": r'RSA/ECB/PKCS1Padding|getInstance\s*\(\s*["\']RSA["\']',
        "severity": "majeur",
        "masvs": "MASVS-CRYPTO-2",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CRYPTO-2/",
        "owasp_text": "L'app utilise des implémentations éprouvées de primitives cryptographiques.",
        "description": "RSA/PKCS1 est vulnérable aux attaques Bleichenbacher.",
        "fix": "Utiliser RSA/ECB/OAEPWithSHA-256AndMGF1Padding."
    },
    # ──── MASVS-STORAGE : Stockage local ────
    {
        "id": "MASVS-STORAGE-1-001",
        "name": "SharedPreferences — Stockage de données sensibles",
        "pattern": r'getSharedPreferences|SharedPreferences|putString|putInt',
        "severity": "mineur",
        "masvs": "MASVS-STORAGE-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-STORAGE-1/",
        "owasp_text": "L'app stocke les données sensibles de façon sécurisée.",
        "description": "SharedPreferences stocke en clair dans un fichier XML accessible.",
        "fix": "Utiliser EncryptedSharedPreferences (Jetpack Security)."
    },
    {
        "id": "MASVS-STORAGE-1-002",
        "name": "Log sensible — Données exposées dans les logs",
        "pattern": r'Log\.(d|i|v|w|e)\s*\(|System\.out\.print',
        "severity": "mineur",
        "masvs": "MASVS-STORAGE-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-STORAGE-1/",
        "owasp_text": "L'app stocke les données sensibles de façon sécurisée.",
        "description": "Les logs Android sont lisibles par d'autres apps sur les devices rootés.",
        "fix": "Désactiver les logs en production (BuildConfig.DEBUG)."
    },
    # ──── MASVS-NETWORK : Réseau ────
    {
        "id": "MASVS-NETWORK-1-001",
        "name": "HTTP — Communication non chiffrée",
        "pattern": r'http://|HttpURLConnection|new\s+URL\s*\(\s*"http:',
        "severity": "critique",
        "masvs": "MASVS-NETWORK-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-NETWORK-1/",
        "owasp_text": "L'app chiffre toutes les communications réseau.",
        "description": "Communication HTTP en clair, susceptible aux attaques MitM.",
        "fix": "Utiliser HTTPS uniquement. Ajouter android:usesCleartextTraffic=false."
    },
    {
        "id": "MASVS-NETWORK-1-002",
        "name": "SSL/TLS — Validation désactivée",
        "pattern": r'TrustAllCerts|ALLOW_ALL_HOSTNAME|setHostnameVerifier|X509TrustManager',
        "severity": "critique",
        "masvs": "MASVS-NETWORK-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-NETWORK-1/",
        "owasp_text": "L'app chiffre toutes les communications réseau.",
        "description": "Validation SSL désactivée, l'app accepte tout certificat.",
        "fix": "Utiliser la validation SSL standard. Network Security Config pour le pinning."
    },
    # ──── MASVS-CODE : Code sécurisé ────
    {
        "id": "MASVS-CODE-1-001",
        "name": "Hardcoded secret — Clé/mot de passe en dur",
        "pattern": r'password\s*=\s*["\'][^"\']{4,}["\']|api[_-]?key\s*=\s*["\'][^"\']{8,}["\']|secret\s*=\s*["\'][^"\']{4,}["\']',
        "severity": "critique",
        "masvs": "MASVS-CODE-1",
        "owasp_link": "https://mas.owasp.org/MASVS/controls/MASVS-CODE-1/",
        "owasp_text": "L'app ne contient pas de secrets hardcodés.",
        "description": "Secret, mot de passe ou clé API hardcodé dans le code source.",
        "fix": "Utiliser des variables d'environnement ou Android Keystore."
    },
]


def scan_file(file_path: Path) -> list:
    findings = []
    try:
        content = file_path.read_text(encoding="utf-8", errors="ignore")
        lines = content.splitlines()
        for rule in RULES:
            pattern = re.compile(rule["pattern"], re.IGNORECASE)
            for i, line in enumerate(lines, start=1):
                if pattern.search(line):
                    findings.append({
                        "file": str(file_path),
                        "line": i,
                        "code": line.strip()[:200],
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
        all_findings.extend(scan_file(Path(f)))
    # Deduplicate
    seen = set()
    unique = []
    for f in all_findings:
        key = (f["rule_id"], f["file"], f["line"])
        if key not in seen:
            seen.add(key)
            unique.append(f)
    print(f"[+] {len(unique)} findings (texte)")
    return unique


def scan_dex(dex_path: Path) -> list:
    """Extract printable strings from binary (DEX/APK) and scan them."""
    findings = []
    try:
        content = dex_path.read_bytes()
        # Extract printable ASCII strings (min length 5)
        strings = re.findall(b'[\x20-\x7e]{5,}', content)
        text = b'\n'.join(strings).decode('ascii', errors='ignore')
        lines = text.splitlines()
        for rule in RULES:
            pattern = re.compile(rule["pattern"], re.IGNORECASE)
            for i, line in enumerate(lines, start=1):
                if pattern.search(line):
                    findings.append({
                        "file": str(dex_path),
                        "line": i,
                        "code": line.strip()[:200],
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
        print(f"[!] Erreur scan binaire {dex_path}: {e}")
    return findings