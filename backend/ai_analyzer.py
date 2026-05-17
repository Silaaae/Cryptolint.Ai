import requests
import json
import os
import re
from dotenv import load_dotenv

load_dotenv()

GROQ_API_KEY = os.environ.get("GROQ_API_KEY", "")
GROQ_URL = "https://api.groq.com/openai/v1/chat/completions"

def analyze_finding(finding: dict) -> dict:
    prompt = f"""Tu es un expert en securite mobile Android certifie OWASP.
Analyse cette vulnerabilite selon le standard OWASP MASVS/MASTG.
Reponds UNIQUEMENT en JSON :
{{
  "explication": "explication technique selon OWASP",
  "impact": "impact concret si exploite",
  "correctif": "code Java Android corrige et complet"
}}
Controle MASVS : {finding['masvs']}
Exigence OWASP : {finding['owasp_text']}
Code vulnerable : {finding['code']}
Correction suggeree : {finding['fix']}"""

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
        try:
            result = json.loads(content)
        except:
            content_clean = re.sub(r'[\x00-\x1f\x7f]', '', content)
            result = json.loads(content_clean)
        finding["ai_explication"] = result.get("explication", "")
        finding["ai_impact"] = result.get("impact", "")
        finding["ai_correctif"] = result.get("correctif", "")
        print(f"[+] IA analysé : {finding['name']} ({finding['masvs']})")
    except Exception as e:
        print(f"[!] Erreur IA : {e}")
        finding["ai_explication"] = finding["description"]
        finding["ai_impact"] = "Non disponible"
        finding["ai_correctif"] = finding["fix"]
    return finding

def analyze_all(findings: list) -> list:
    print(f"[*] Analyse IA OWASP de {len(findings)} findings...")
    return [analyze_finding(f) for f in findings]