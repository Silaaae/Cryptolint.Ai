# 🔐 CryptoLint AI

Outil d'analyse statique cryptographique pour applications Android, aligné sur les contrôles **OWASP MASVS-CRYPTO-1** et **MASVS-CRYPTO-2**.

## Description

CryptoLint AI automatise la détection des mauvaises pratiques cryptographiques dans les APKs Android. Il décompile l'APK avec JADX, scanne le code Java avec des règles alignées OWASP MASVS, puis utilise un LLM (LLaMA 3.3 70B via Groq) pour expliquer chaque vulnérabilité et proposer un correctif. Le résultat est un rapport HTML interactif avec export PDF intégré.

## Fonctionnalités

- Décompilation automatique d'APK via JADX
- 8 règles de détection alignées OWASP MASVS-CRYPTO-1 et MASVS-CRYPTO-2
- Déduplication des findings
- Analyse IA par LLaMA 3.3 70B (Groq API) avec corrections basées sur OWASP
- Rapport HTML avec tableau de bord de conformité MASVS
- Export PDF depuis le navigateur
- Interface CLI simple

## Prérequis

- Python >= 3.10
- JADX >= 1.5.5 installé et dans le PATH
- Clé API Groq (gratuite sur https://console.groq.com)

## Installation

```bash
git clone https://github.com/Silaaae/Cryptolint.Ai.git
cd Cryptolint.Ai
pip install requests python-dotenv
```

Crée un fichier `.env` :
GROQ_API_KEY=cle_groq_ai_ici

## Utilisation

```bash
python cryptolint.py --apk monapp.apk
```

Sans analyse IA (plus rapide) :
```bash
python cryptolint.py --apk monapp.apk --no-ai
```

## Contrôles OWASP couverts

| Contrôle | Description |
|---|---|
| MASVS-CRYPTO-1 | L'app n'utilise pas de primitives cryptographiques faibles ou dépréciées |
| MASVS-CRYPTO-2 | L'app utilise des implémentations éprouvées de primitives cryptographiques |

## Vulnérabilités détectées

| ID | Contrôle | Description | Sévérité |
|---|---|---|---|
| MASVS-CRYPTO-1-001 | MASVS-CRYPTO-1 | MD5 | Critique |
| MASVS-CRYPTO-1-002 | MASVS-CRYPTO-1 | SHA-1 déprécié | Critique |
| MASVS-CRYPTO-1-003 | MASVS-CRYPTO-1 | AES/ECB non sécurisé | Critique |
| MASVS-CRYPTO-1-004 | MASVS-CRYPTO-1 | Clé hardcodée | Critique |
| MASVS-CRYPTO-1-005 | MASVS-CRYPTO-1 | Random() non cryptographique | Majeur |
| MASVS-CRYPTO-2-001 | MASVS-CRYPTO-2 | Cipher sans mode spécifié | Majeur |
| MASVS-CRYPTO-2-002 | MASVS-CRYPTO-2 | DES obsolète | Critique |
| MASVS-CRYPTO-2-003 | MASVS-CRYPTO-2 | RC4 cassé | Critique |

## Licence

MIT License

## Auteurs

- Nisrine Gorfti
- Oussama El Arif
- Superviseur : Mohamed Lachgar — EMSI Marrakech
