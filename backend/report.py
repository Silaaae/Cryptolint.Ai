from pathlib import Path
from datetime import datetime

def generate_report(findings: list, apk_name: str, output_path: str = "output/rapport_cryptolint.html"):
    now = datetime.now().strftime("%d/%m/%Y %H:%M")
    critiques = [f for f in findings if f['severity'] == 'critique']
    majeurs = [f for f in findings if f['severity'] == 'majeur']
    masvs1 = [f for f in findings if f['masvs'] == 'MASVS-CRYPTO-1']
    masvs2 = [f for f in findings if f['masvs'] == 'MASVS-CRYPTO-2']
    masvs1_color = "#ff4444" if masvs1 else "#a8ff78"
    masvs2_color = "#ff4444" if masvs2 else "#a8ff78"
    masvs1_status = "ECHOUE" if masvs1 else "PASSE"
    masvs2_status = "ECHOUE" if masvs2 else "PASSE"

    rows = ""
    for f in findings:
        color = "#ff4444" if f['severity'] == 'critique' else "#ff8800"
        correctif = f.get('ai_correctif', f.get('fix','')).replace('\n', '<br>').replace(' ', '&nbsp;')
        rows += f"""
        <tr>
            <td><span class="badge" style="background:{color}">{f['severity'].upper()}</span></td>
            <td><a class="masvs-tag" href="{f['owasp_link']}" target="_blank">{f['masvs']}</a></td>
            <td><strong>{f['name']}</strong><br><small style="color:#8b949e">{f['owasp_text']}</small></td>
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
    <title>CryptoLint AI - Rapport</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"></script>
    <style>
        * {{ box-sizing: border-box; margin: 0; padding: 0; }}
        body {{ font-family: 'Segoe UI', Arial, sans-serif; background: #0d1117; color: #c9d1d9; padding: 40px; }}
        .header {{ display: flex; justify-content: space-between; align-items: center; margin-bottom: 30px; padding-bottom: 20px; border-bottom: 2px solid #58a6ff; }}
        .header h1 {{ font-size: 28px; color: #58a6ff; }}
        .header h1 span {{ color: #a8ff78; }}
        .btn-pdf {{ background: #58a6ff; color: white; padding: 10px 20px; border-radius: 8px; font-weight: bold; font-size: 14px; cursor: pointer; border: none; }}
        .btn-pdf:hover {{ background: #388bfd; }}
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
        .masvs-tag {{ background: #1f3a5f; color: #58a6ff; padding: 2px 8px; border-radius: 4px; font-size: 11px; font-weight: 600; text-decoration: none; }}
        .mono {{ font-family: 'Courier New', monospace; font-size: 11px; color: #f0883e; }}
        .conformity-box {{ display: flex; gap: 16px; margin-bottom: 30px; }}
        .conformity-card {{ flex: 1; padding: 16px 20px; border-radius: 10px; }}
        .status {{ font-size: 13px; font-weight: 700; padding: 4px 12px; border-radius: 20px; display: inline-block; }}
        footer {{ margin-top: 40px; text-align: center; color: #8b949e; font-size: 12px; border-top: 1px solid #21262d; padding-top: 20px; }}
    </style>
</head>
<body>
<div id="content">
    <div class="header">
        <div>
            <h1>CryptoLint <span>AI</span></h1>
            <p style="color:#8b949e;font-size:13px">Analyse cryptographique OWASP MASVS/MASTG</p>
        </div>
        <div style="text-align:right">
            <p style="color:#8b949e;font-size:13px">APK : <strong style="color:#c9d1d9">{apk_name}</strong></p>
            <p style="color:#8b949e;font-size:13px">Genere le {now}</p>
            <button class="btn-pdf" onclick="downloadPDF()">Telecharger PDF</button>
        </div>
    </div>
    <div class="cards">
        <div class="card rouge"><h2>{len(critiques)}</h2><p>Critique</p></div>
        <div class="card orange"><h2>{len(majeurs)}</h2><p>Majeur</p></div>
        <div class="card bleu"><h2>{len(findings)}</h2><p>Total</p></div>
    </div>
    <div class="section-title">Conformite OWASP MASVS</div>
    <div class="conformity-box">
        <div class="conformity-card" style="background:#1a1a2e; border:1px solid {masvs1_color}">
            <h3 style="color:{masvs1_color}">MASVS-CRYPTO-1</h3>
            <p style="color:#8b949e;font-size:12px;margin:8px 0">L'app n'utilise pas de primitives cryptographiques faibles.</p>
            <span class="status" style="background:{masvs1_color}22;color:{masvs1_color};border:1px solid {masvs1_color}">
                {masvs1_status} - {len(masvs1)} violation(s)
            </span>
        </div>
        <div class="conformity-card" style="background:#1a1a2e; border:1px solid {masvs2_color}">
            <h3 style="color:{masvs2_color}">MASVS-CRYPTO-2</h3>
            <p style="color:#8b949e;font-size:12px;margin:8px 0">L'app utilise des implementations eprouvees.</p>
            <span class="status" style="background:{masvs2_color}22;color:{masvs2_color};border:1px solid {masvs2_color}">
                {masvs2_status} - {len(masvs2)} violation(s)
            </span>
        </div>
    </div>
    <div class="section-title">Findings detectes</div>
    <table>
        <tr>
            <th>Severite</th><th>Controle OWASP</th><th>Vulnerabilite</th>
            <th>Fichier</th><th>Ligne</th><th>Code</th>
            <th>Explication IA</th><th>Impact</th><th>Correctif IA</th>
        </tr>
        {rows}
    </table>
    <footer>CryptoLint AI v1.0.0 - OWASP MASVS/MASTG - LLaMA 3.3 70B (Groq API)</footer>
</div>
<script>
function downloadPDF() {{
    var btn = document.querySelector('.btn-pdf');
    btn.style.display = 'none';
    html2pdf().set({{
        margin: 10,
        filename: 'rapport_cryptolint.pdf',
        image: {{ type: 'jpeg', quality: 0.98 }},
        html2canvas: {{ scale: 2 }},
        jsPDF: {{ unit: 'mm', format: 'a4', orientation: 'landscape' }}
    }}).from(document.getElementById('content')).save().then(function() {{
        btn.style.display = 'inline-block';
    }});
}}
</script>
</body>
</html>"""

    output = Path(output_path)
    output.parent.mkdir(parents=True, exist_ok=True)
    output.write_text(html, encoding="utf-8")
    print("[+] Rapport genere : " + str(output.resolve()))