import requests
import json
import os 
GROQ_API_KEY = os.environ.get("GROQ_API_KEY", "")
GROQ_URL = "https://api.groq.com/openai/v1/chat/completions"

def analyze_finding(finding: dict) -> dict:
    prompt = f"""Tu es un expert en sécurité mobile Android certifié OWASP.
Analyse cette vulnérabilité selon le standard MASVS/MASTG officiel OWASP.
Réponds UNIQUEMENT en JSON, rien d'autre :
{{
  "explication": "explication technique précise du risque selon OWASP",
  "impact": "quel est l'impact concret si exploité",
  "correctif": "code Java Android corrigé et complet",
  "reference_owasp": "{finding['masvs']}"
}}

Vulnérabilité détectée :
- Contrôle MASVS : {finding['masvs']}
- Règle : {finding['name']}
- Code vulnérable : {finding['code']}
- Description : {finding['description']}
- Correctif suggéré : {finding['fix']}

IMPORTANT : Le correctif doit être du vrai code Java Android fonctionnel, pas du texte générique."""

    headers = {
        "Authorization": f"Bearer {GROQ_API_KEY}",
        "Content-Type": "application/json"
    }

    body = {
        "model": "llama-3.3-70b-versatile",
        "messages": [{"role": "user", "content": prompt}],
        "temperature": 0.1
    }

    try:
        response = requests.post(GROQ_URL, headers=headers, json=body, timeout=30)
        content = response.json()["choices"][0]["message"]["content"]
        content = content.strip().replace("```json", "").replace("```", "")
        content = content.replace('\n', ' ').replace('\r', ' ').replace('\t', ' ')
        result = json.loads(content)
        finding["ai_explication"] = result.get("explication", "")
        finding["ai_impact"] = result.get("impact", "")
        finding["ai_correctif"] = result.get("correctif", "")
        finding["ai_reference"] = result.get("reference_owasp", finding["masvs"])
        print(f"[+] IA analysé : {finding['name']} ({finding['masvs']})")
    except Exception as e:
        print(f"[!] Erreur IA : {e}")
        finding["ai_explication"] = finding["description"]
        finding["ai_impact"] = "Non disponible"
        finding["ai_correctif"] = finding["fix"]
        finding["ai_reference"] = finding["masvs"]

    return finding


def analyze_all(findings: list) -> list:
    print(f"[*] Analyse IA OWASP de {len(findings)} findings...")
    return [analyze_finding(f) for f in findings]