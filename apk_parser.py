import subprocess
from pathlib import Path

JADX_PATH = r"C:\jadx\bin\jadx.bat"

def decompile_apk(apk_path: str, output_dir: str = "output/decompiled") -> Path:
    apk_path = Path(apk_path)
    output_path = Path(output_dir)
    if not apk_path.exists():
        raise FileNotFoundError(f"APK introuvable : {apk_path}")
    output_path.mkdir(parents=True, exist_ok=True)
    print(f"[*] Décompilation de {apk_path.name} ...")
    command = [JADX_PATH, "--deobf", "--show-bad-code", "-d", str(output_path), str(apk_path)]
    result = subprocess.run(command, capture_output=True, text=True, timeout=120)
    if result.returncode != 0:
        print(f"[!] Erreur JADX :\n{result.stderr}")
    else:
        print(f"[+] Décompilation réussie !")
    return output_path

def collect_java_files(decompiled_dir: Path) -> list:
    files = list(decompiled_dir.rglob("*.java")) + list(decompiled_dir.rglob("*.kt"))
    print(f"[+] {len(files)} fichiers trouvés")
    return files

def parse_apk(apk_path: str) -> list:
    output_dir = decompile_apk(apk_path)
    return collect_java_files(output_dir)