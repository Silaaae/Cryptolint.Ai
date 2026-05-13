import pdfkit

def export_pdf(html_path: str = r"C:\Users\NISRINE\cryptolint-ai\output\rapport_cryptolint.html",
               pdf_path: str = r"C:\Users\NISRINE\cryptolint-ai\output\rapport_cryptolint.pdf"):

    config = pdfkit.configuration(
        wkhtmltopdf=r"C:\Program Files\wkhtmltopdf\bin\wkhtmltopdf.exe"
    )
    print(f"[*] Génération du PDF...")
    pdfkit.from_file(html_path, pdf_path, configuration=config)
    print(f"[+] PDF généré : {pdf_path}")

if __name__ == "__main__":
    export_pdf()