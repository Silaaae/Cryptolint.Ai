from pathlib import Path
from datetime import datetime

def generate_report(findings: list, apk_name: str, output_path: str = "output/rapport_cryptolint.html"):
    now = datetime.now().strftime("%d/%m/%Y %H:%M")
    critiques = [f for f in findings if f['severity'] == 'critique']
    majeurs = [f for f in findings if f['severity'] == 'majeur']
    masvs1 = [f for f in findings if f['masvs'] == 'MASVS-CRYPTO-1']
    masvs2 = [f for f in findings if f['masvs'] == 'MASVS-CRYPTO-2']
    masvs1_status = "ECHOUE" if masvs1 else "PASSE"
    masvs2_status = "ECHOUE" if masvs2 else "PASSE"
    masvs1_color = "#ef4444" if masvs1 else "#22c55e"
    masvs2_color = "#ef4444" if masvs2 else "#22c55e"

    score = max(0, 100 - (len(critiques) * 15 + len(majeurs) * 7))
    score_color = "#ef4444" if score < 40 else "#f97316" if score < 70 else "#22c55e"
    score_label = "CRITIQUE" if score < 40 else "RISQUE ELEVE" if score < 70 else "BON"

    findings_rows = ""
    for i, f in enumerate(findings):
        sev_color = "#ef4444" if f['severity'] == 'critique' else "#f97316"
        sev_bg = "rgba(239,68,68,0.08)" if f['severity'] == 'critique' else "rgba(249,115,22,0.08)"
        correctif = f.get('ai_correctif', f.get('fix', '')).replace('\n', '<br>')
        explication = f.get('ai_explication', f.get('description', ''))
        impact = f.get('ai_impact', '-')
        fname = Path(f['file']).name if f.get('file') else '-'
        findings_rows += f"""
        <div class="finding-card" style="border-left: 3px solid {sev_color}; background: {sev_bg};">
            <div class="finding-header">
                <div class="finding-left">
                    <span class="finding-num">#{i+1:02d}</span>
                    <div>
                        <div class="finding-title">{f['name']}</div>
                        <div class="finding-meta">
                            <span class="chip-sev" style="color:{sev_color};border-color:{sev_color}30;background:{sev_color}10">{f['severity'].upper()}</span>
                            <span class="chip-masvs">{f['masvs']}</span>
                            <span class="chip-file">📄 {fname} : {f['line']}</span>
                        </div>
                    </div>
                </div>
                <a href="{f.get('owasp_link','#')}" target="_blank" class="owasp-ref">OWASP ↗</a>
            </div>
            <div class="finding-body">
                <div class="finding-code">
                    <div class="code-label">CODE VULNÉRABLE</div>
                    <code>{f.get('code','')}</code>
                </div>
                <div class="finding-grid">
                    <div class="finding-section">
                        <div class="section-label">🧠 ANALYSE IA</div>
                        <p>{explication}</p>
                    </div>
                    <div class="finding-section">
                        <div class="section-label">⚠️ IMPACT</div>
                        <p>{impact}</p>
                    </div>
                </div>
                <div class="finding-fix">
                    <div class="section-label">✅ CORRECTIF RECOMMANDÉ</div>
                    <code class="fix-code">{correctif}</code>
                </div>
            </div>
        </div>"""

    html = f"""<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>CryptoLint AI — Rapport de Sécurité — {apk_name}</title>
<link href="https://fonts.googleapis.com/css2?family=Space+Mono:wght@400;700&family=DM+Sans:wght@300;400;500;600;700&display=swap" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"></script>
<style>
:root {{
    --bg: #06090f;
    --bg2: #0d1421;
    --bg3: #111927;
    --border: rgba(255,255,255,0.07);
    --text: #e2e8f0;
    --text2: #64748b;
    --text3: #94a3b8;
    --blue: #60a5fa;
    --green: #4ade80;
    --red: #ef4444;
    --orange: #f97316;
    --mono: 'Space Mono', monospace;
    --sans: 'DM Sans', sans-serif;
}}

* {{ box-sizing: border-box; margin: 0; padding: 0; }}
body {{ font-family: var(--sans); background: var(--bg); color: var(--text); min-height: 100vh; }}

/* PRINT BUTTON */
.print-bar {{
    position: fixed;
    top: 0; left: 0; right: 0;
    background: rgba(6,9,15,0.95);
    backdrop-filter: blur(20px);
    border-bottom: 1px solid var(--border);
    padding: 12px 40px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    z-index: 1000;
}}

.print-title {{ font-family: var(--mono); font-size: 13px; color: var(--text3); }}
.print-title span {{ color: var(--blue); }}

.btn-pdf {{
    background: linear-gradient(135deg, #1d4ed8, #3b82f6);
    color: white;
    border: none;
    padding: 10px 24px;
    border-radius: 8px;
    font-family: var(--sans);
    font-size: 14px;
    font-weight: 600;
    cursor: pointer;
    display: flex;
    align-items: center;
    gap: 8px;
    transition: all 0.2s;
}}

.btn-pdf:hover {{ transform: translateY(-1px); box-shadow: 0 4px 20px rgba(59,130,246,0.4); }}

/* MAIN CONTENT */
#report-content {{ padding: 80px 60px 60px; max-width: 1100px; margin: 0 auto; }}

/* COVER */
.cover {{
    min-height: 420px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    border: 1px solid var(--border);
    border-radius: 24px;
    padding: 60px;
    margin-bottom: 40px;
    position: relative;
    overflow: hidden;
    background: linear-gradient(135deg, #0d1421 0%, #060c18 100%);
}}

.cover::before {{
    content: '';
    position: absolute;
    top: -100px; right: -100px;
    width: 400px; height: 400px;
    background: radial-gradient(circle, rgba(96,165,250,0.08) 0%, transparent 70%);
}}

.cover-badge {{
    display: inline-flex;
    align-items: center;
    gap: 8px;
    background: rgba(96,165,250,0.08);
    border: 1px solid rgba(96,165,250,0.2);
    border-radius: 20px;
    padding: 6px 16px;
    font-size: 11px;
    color: var(--blue);
    font-family: var(--mono);
    letter-spacing: 1px;
    width: fit-content;
    margin-bottom: 32px;
}}

.cover-title {{
    font-size: 48px;
    font-weight: 700;
    line-height: 1.1;
    letter-spacing: -2px;
    margin-bottom: 8px;
}}

.cover-title .accent {{
    background: linear-gradient(135deg, var(--blue), var(--green));
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
    background-clip: text;
}}

.cover-sub {{ color: var(--text3); font-size: 18px; margin-bottom: 40px; }}

.cover-meta {{ display: flex; gap: 32px; flex-wrap: wrap; }}

.meta-item {{ display: flex; flex-direction: column; gap: 4px; }}
.meta-label {{ font-size: 11px; color: var(--text2); text-transform: uppercase; letter-spacing: 0.8px; font-family: var(--mono); }}
.meta-value {{ font-size: 14px; font-weight: 600; color: var(--text); }}

/* SCORE */
.score-section {{
    display: grid;
    grid-template-columns: auto 1fr;
    gap: 32px;
    background: var(--bg2);
    border: 1px solid var(--border);
    border-radius: 20px;
    padding: 32px 40px;
    margin-bottom: 24px;
    align-items: center;
}}

.score-circle {{
    width: 120px;
    height: 120px;
    border-radius: 50%;
    border: 4px solid {score_color};
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    background: {score_color}15;
    flex-shrink: 0;
}}

.score-num {{ font-family: var(--mono); font-size: 36px; font-weight: 700; color: {score_color}; line-height: 1; }}
.score-label-small {{ font-size: 10px; color: var(--text2); font-family: var(--mono); margin-top: 2px; }}

.score-info h3 {{ font-size: 22px; font-weight: 700; margin-bottom: 8px; }}
.score-info p {{ color: var(--text3); font-size: 14px; line-height: 1.6; }}

.score-verdict {{
    display: inline-block;
    padding: 4px 14px;
    border-radius: 20px;
    font-size: 12px;
    font-weight: 700;
    font-family: var(--mono);
    background: {score_color}15;
    color: {score_color};
    border: 1px solid {score_color}30;
    margin-bottom: 12px;
}}

/* STATS */
.stats-grid {{
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 16px;
    margin-bottom: 24px;
}}

.stat-box {{
    background: var(--bg2);
    border: 1px solid var(--border);
    border-radius: 16px;
    padding: 24px;
    position: relative;
    overflow: hidden;
}}

.stat-box::after {{
    content: '';
    position: absolute;
    bottom: 0; left: 0; right: 0;
    height: 2px;
}}

.stat-box.red::after {{ background: var(--red); }}
.stat-box.orange::after {{ background: var(--orange); }}
.stat-box.blue::after {{ background: var(--blue); }}
.stat-box.green::after {{ background: var(--green); }}

.stat-n {{ font-family: var(--mono); font-size: 42px; font-weight: 700; line-height: 1; margin-bottom: 6px; }}
.stat-box.red .stat-n {{ color: var(--red); }}
.stat-box.orange .stat-n {{ color: var(--orange); }}
.stat-box.blue .stat-n {{ color: var(--blue); }}
.stat-box.green .stat-n {{ color: var(--green); }}
.stat-lbl {{ color: var(--text2); font-size: 12px; font-weight: 500; text-transform: uppercase; letter-spacing: 0.5px; }}

/* MASVS */
.masvs-row {{
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 16px;
    margin-bottom: 40px;
}}

.masvs-box {{
    background: var(--bg2);
    border-radius: 16px;
    padding: 24px 28px;
}}

.masvs-box.fail {{ border: 1px solid rgba(239,68,68,0.3); }}
.masvs-box.pass {{ border: 1px solid rgba(74,222,128,0.3); }}

.masvs-top {{ display: flex; justify-content: space-between; align-items: flex-start; margin-bottom: 12px; }}
.masvs-id {{ font-family: var(--mono); font-size: 16px; font-weight: 700; }}
.masvs-box.fail .masvs-id {{ color: var(--red); }}
.masvs-box.pass .masvs-id {{ color: var(--green); }}

.status-tag {{
    padding: 4px 12px;
    border-radius: 20px;
    font-size: 11px;
    font-weight: 700;
    font-family: var(--mono);
}}

.status-tag.fail {{ background: rgba(239,68,68,0.1); color: var(--red); border: 1px solid rgba(239,68,68,0.2); }}
.status-tag.pass {{ background: rgba(74,222,128,0.1); color: var(--green); border: 1px solid rgba(74,222,128,0.2); }}

.masvs-req {{ color: var(--text3); font-size: 13px; line-height: 1.5; margin-bottom: 12px; font-style: italic; }}
.masvs-count {{ color: var(--text2); font-size: 13px; }}
.masvs-count strong {{ color: var(--text); }}

/* SECTION TITLE */
.section-title {{
    font-size: 11px;
    font-weight: 700;
    color: var(--text2);
    text-transform: uppercase;
    letter-spacing: 1.5px;
    font-family: var(--mono);
    margin-bottom: 20px;
    padding-bottom: 12px;
    border-bottom: 1px solid var(--border);
    display: flex;
    align-items: center;
    gap: 10px;
}}

.section-title::before {{
    content: '';
    width: 3px;
    height: 14px;
    background: var(--blue);
    border-radius: 2px;
}}

/* FINDING CARDS */
.findings-list {{ display: flex; flex-direction: column; gap: 16px; margin-bottom: 40px; }}

.finding-card {{
    border-radius: 16px;
    overflow: hidden;
    border: 1px solid var(--border);
    background: var(--bg2);
}}

.finding-header {{
    padding: 20px 24px;
    display: flex;
    align-items: flex-start;
    justify-content: space-between;
    border-bottom: 1px solid var(--border);
}}

.finding-left {{ display: flex; align-items: flex-start; gap: 14px; }}

.finding-num {{
    font-family: var(--mono);
    font-size: 12px;
    color: var(--text2);
    background: var(--bg3);
    padding: 4px 8px;
    border-radius: 6px;
    flex-shrink: 0;
    margin-top: 2px;
}}

.finding-title {{ font-size: 15px; font-weight: 600; margin-bottom: 8px; }}

.finding-meta {{ display: flex; align-items: center; gap: 8px; flex-wrap: wrap; }}

.chip-sev {{
    padding: 2px 8px;
    border-radius: 4px;
    font-size: 10px;
    font-weight: 700;
    font-family: var(--mono);
    border: 1px solid;
}}

.chip-masvs {{
    background: rgba(96,165,250,0.08);
    color: var(--blue);
    border: 1px solid rgba(96,165,250,0.15);
    padding: 2px 8px;
    border-radius: 4px;
    font-size: 10px;
    font-weight: 600;
    font-family: var(--mono);
}}

.chip-file {{ color: var(--text2); font-size: 12px; font-family: var(--mono); }}

.owasp-ref {{
    color: var(--blue);
    font-size: 12px;
    text-decoration: none;
    font-family: var(--mono);
    border: 1px solid rgba(96,165,250,0.2);
    padding: 4px 10px;
    border-radius: 6px;
    flex-shrink: 0;
    transition: all 0.2s;
}}

.owasp-ref:hover {{ background: rgba(96,165,250,0.08); }}

.finding-body {{ padding: 20px 24px; display: flex; flex-direction: column; gap: 16px; }}

.finding-code {{
    background: #060912;
    border: 1px solid var(--border);
    border-radius: 10px;
    padding: 16px 20px;
    overflow-x: auto;
}}

.code-label {{
    font-size: 10px;
    font-weight: 600;
    color: var(--text2);
    letter-spacing: 1px;
    font-family: var(--mono);
    margin-bottom: 10px;
}}

.finding-code code {{
    font-family: var(--mono);
    font-size: 13px;
    color: #f97316;
    white-space: pre-wrap;
    word-break: break-all;
}}

.finding-grid {{ display: grid; grid-template-columns: 1fr 1fr; gap: 16px; }}

.finding-section {{
    background: var(--bg3);
    border-radius: 10px;
    padding: 16px;
}}

.section-label {{
    font-size: 10px;
    font-weight: 700;
    color: var(--text2);
    letter-spacing: 1px;
    font-family: var(--mono);
    margin-bottom: 10px;
}}

.finding-section p {{ color: var(--text3); font-size: 13px; line-height: 1.6; }}

.finding-fix {{
    background: rgba(74,222,128,0.04);
    border: 1px solid rgba(74,222,128,0.15);
    border-radius: 10px;
    padding: 16px 20px;
}}

.fix-code {{
    font-family: var(--mono);
    font-size: 12px;
    color: #4ade80;
    white-space: pre-wrap;
    word-break: break-all;
    line-height: 1.6;
}}

/* COMPARISON TABLE */
.comparison-section {{
    background: var(--bg2);
    border: 1px solid var(--border);
    border-radius: 20px;
    overflow: hidden;
    margin-bottom: 40px;
}}

.comp-table {{ width: 100%; border-collapse: collapse; }}
.comp-table th {{
    background: var(--bg3);
    padding: 14px 20px;
    text-align: left;
    font-size: 11px;
    font-weight: 600;
    color: var(--text2);
    text-transform: uppercase;
    letter-spacing: 0.8px;
    border-bottom: 1px solid var(--border);
}}

.comp-table th:first-child {{ color: var(--blue); }}
.comp-table td {{ padding: 14px 20px; border-bottom: 1px solid rgba(255,255,255,0.03); font-size: 13px; }}
.comp-table tr:last-child td {{ border-bottom: none; }}
.comp-table tr:hover td {{ background: rgba(255,255,255,0.02); }}

.check {{ color: var(--green); font-weight: 700; }}
.cross {{ color: var(--red); }}
.partial {{ color: var(--orange); }}
.highlight {{ color: var(--blue); font-weight: 600; font-family: var(--mono); }}

/* FOOTER */
.report-footer {{
    padding: 32px 40px;
    border: 1px solid var(--border);
    border-radius: 16px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    background: var(--bg2);
}}

.footer-left {{ font-family: var(--mono); font-size: 12px; color: var(--text2); line-height: 1.8; }}
.footer-right {{ text-align: right; }}
.footer-logo {{ font-family: var(--mono); font-size: 18px; font-weight: 700; color: var(--blue); }}
.footer-sub {{ color: var(--text2); font-size: 12px; margin-top: 4px; }}

@media print {{
    .print-bar {{ display: none; }}
    #report-content {{ padding: 40px; }}
    body {{ background: white; color: black; }}
}}
</style>
</head>
<body>

<div class="print-bar">
    <div class="print-title">🔐 <span>CryptoLint AI</span> — Rapport de Sécurité Mobile</div>
    <button class="btn-pdf" onclick="generatePDF()">📄 Télécharger PDF</button>
</div>

<div id="report-content">

    <!-- COVER -->
    <div class="cover">
        <div class="cover-badge">⚡ RAPPORT D'AUDIT SÉCURITÉ MOBILE — CONFIDENTIEL</div>
        <div class="cover-title">Rapport d'Analyse<br><span class="accent">Cryptographique</span></div>
        <div class="cover-sub">Audit statique aligné OWASP MASVS-CRYPTO</div>
        <div class="cover-meta">
            <div class="meta-item">
                <span class="meta-label">Application analysée</span>
                <span class="meta-value">{apk_name}</span>
            </div>
            <div class="meta-item">
                <span class="meta-label">Date d'analyse</span>
                <span class="meta-value">{now}</span>
            </div>
            <div class="meta-item">
                <span class="meta-label">Outil</span>
                <span class="meta-value">CryptoLint AI v1.0.0</span>
            </div>
            <div class="meta-item">
                <span class="meta-label">Moteur IA</span>
                <span class="meta-value">LLaMA 3.3 70B (Groq)</span>
            </div>
            <div class="meta-item">
                <span class="meta-label">Standard</span>
                <span class="meta-value">OWASP MASVS v2.0</span>
            </div>
        </div>
    </div>

    <!-- SCORE -->
    <div class="score-section">
        <div class="score-circle">
            <div class="score-num">{score}</div>
            <div class="score-label-small">/100</div>
        </div>
        <div class="score-info">
            <div class="score-verdict">{score_label}</div>
            <h3>Score de Sécurité Cryptographique</h3>
            <p>L'application présente <strong>{len(critiques)} vulnérabilité(s) critique(s)</strong> et <strong>{len(majeurs)} majeure(s)</strong> 
            liées à l'utilisation de primitives cryptographiques non conformes aux standards OWASP MASVS. 
            Une remédiation immédiate est recommandée pour les findings critiques.</p>
        </div>
    </div>

    <!-- STATS -->
    <div class="stats-grid">
        <div class="stat-box red">
            <div class="stat-n">{len(critiques)}</div>
            <div class="stat-lbl">Findings critiques</div>
        </div>
        <div class="stat-box orange">
            <div class="stat-n">{len(majeurs)}</div>
            <div class="stat-lbl">Findings majeurs</div>
        </div>
        <div class="stat-box blue">
            <div class="stat-n">{len(findings)}</div>
            <div class="stat-lbl">Total détectés</div>
        </div>
        <div class="stat-box green">
            <div class="stat-n">{score}</div>
            <div class="stat-lbl">Score /100</div>
        </div>
    </div>

    <!-- MASVS CONFORMITY -->
    <div class="section-title">Conformité OWASP MASVS-CRYPTO</div>
    <div class="masvs-row">
        <div class="masvs-box {'fail' if masvs1 else 'pass'}">
            <div class="masvs-top">
                <div class="masvs-id">MASVS-CRYPTO-1</div>
                <span class="status-tag {'fail' if masvs1 else 'pass'}">{masvs1_status}</span>
            </div>
            <div class="masvs-req">"L'app n'utilise pas de primitives cryptographiques faibles ou dépréciées pour des opérations cryptographiques."</div>
            <div class="masvs-count"><strong>{len(masvs1)}</strong> violation(s) détectée(s)</div>
        </div>
        <div class="masvs-box {'fail' if masvs2 else 'pass'}">
            <div class="masvs-top">
                <div class="masvs-id">MASVS-CRYPTO-2</div>
                <span class="status-tag {'fail' if masvs2 else 'pass'}">{masvs2_status}</span>
            </div>
            <div class="masvs-req">"L'app utilise des implémentations éprouvées de primitives cryptographiques."</div>
            <div class="masvs-count"><strong>{len(masvs2)}</strong> violation(s) détectée(s)</div>
        </div>
    </div>

    <!-- FINDINGS -->
    <div class="section-title">Findings détectés — Analyse détaillée</div>
    <div class="findings-list">
        {findings_rows}
    </div>

    <!-- COMPARISON -->
    <div class="section-title">Comparaison avec MobSF</div>
    <div class="comparison-section">
        <table class="comp-table">
            <thead>
                <tr>
                    <th>Critère</th>
                    <th>CryptoLint AI</th>
                    <th>MobSF</th>
                    <th>CryptoGuard</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Mapping MASVS-CRYPTO-1</td>
                    <td class="check">✅ Oui</td>
                    <td class="partial">⚡ Partiel</td>
                    <td class="cross">❌ Non</td>
                </tr>
                <tr>
                    <td>Mapping MASVS-CRYPTO-2</td>
                    <td class="check">✅ Oui</td>
                    <td class="partial">⚡ Partiel</td>
                    <td class="cross">❌ Non</td>
                </tr>
                <tr>
                    <td>Analyse IA avec corrections</td>
                    <td class="check">✅ LLaMA 3.3 70B</td>
                    <td class="cross">❌ Non</td>
                    <td class="cross">❌ Non</td>
                </tr>
                <tr>
                    <td>Score de sécurité</td>
                    <td class="check">✅ Oui</td>
                    <td class="check">✅ Oui</td>
                    <td class="cross">❌ Non</td>
                </tr>
                <tr>
                    <td>Rapport HTML interactif</td>
                    <td class="check">✅ Oui</td>
                    <td class="check">✅ Oui</td>
                    <td class="cross">❌ Non</td>
                </tr>
                <tr>
                    <td>Export PDF intégré</td>
                    <td class="check">✅ Oui</td>
                    <td class="partial">⚡ Partiel</td>
                    <td class="cross">❌ Non</td>
                </tr>
                <tr>
                    <td>Déduplication findings</td>
                    <td class="check">✅ Oui</td>
                    <td class="partial">⚡ Partiel</td>
                    <td class="check">✅ Oui</td>
                </tr>
                <tr>
                    <td>Interface web moderne</td>
                    <td class="check">✅ Oui</td>
                    <td class="check">✅ Oui</td>
                    <td class="cross">❌ Non</td>
                </tr>
                <tr>
                    <td>Docker ready</td>
                    <td class="check">✅ Oui</td>
                    <td class="check">✅ Oui</td>
                    <td class="cross">❌ Non</td>
                </tr>
                <tr>
                    <td>Temps d'analyse</td>
                    <td class="highlight">&lt; 2 min</td>
                    <td class="highlight">3-5 min</td>
                    <td class="highlight">5-10 min</td>
                </tr>
            </tbody>
        </table>
    </div>

    <!-- FOOTER -->
    <div class="report-footer">
        <div class="footer-left">
            Rapport généré le {now}<br>
            Analystes : Nisrine Gorfti, Oussama El Arif<br>
            Superviseur : Mohamed Lachgar — EMSI Marrakech<br>
            Référentiel : OWASP MASVS v2.0 | MASTG
        </div>
        <div class="footer-right">
            <div class="footer-logo">🔐 CryptoLint AI</div>
            <div class="footer-sub">v1.0.0 — Powered by LLaMA 3.3 70B</div>
        </div>
    </div>

</div>

<script>
function generatePDF() {{
    const btn = document.querySelector('.btn-pdf');
    btn.textContent = '⏳ Génération...';
    btn.disabled = true;
    const opt = {{
        margin: [10, 10],
        filename: 'rapport_cryptolint.pdf',
        image: {{ type: 'jpeg', quality: 0.98 }},
        html2canvas: {{ scale: 2, useCORS: true, backgroundColor: '#06090f' }},
        jsPDF: {{ unit: 'mm', format: 'a4', orientation: 'landscape' }}
    }};
    html2pdf().set(opt).from(document.getElementById('report-content')).save().then(() => {{
        btn.textContent = '📄 Télécharger PDF';
        btn.disabled = false;
    }});
}}
</script>
</body>
</html>"""

    output = Path(output_path)
    output.parent.mkdir(parents=True, exist_ok=True)
    output.write_text(html, encoding="utf-8")
    print("[+] Rapport genere : " + str(output.resolve()))