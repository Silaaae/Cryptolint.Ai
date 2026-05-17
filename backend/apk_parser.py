import subprocess
import shutil
from pathlib import Path

BASE_DIR = Path(__file__).parent


def _find_jadx() -> str:
    import os
    env_path = os.environ.get("JADX_PATH")
    if env_path and Path(env_path).exists():
        return env_path

    jadx = shutil.which("jadx")
    if jadx:
        return jadx

    linux_paths = ["/opt/jadx/bin/jadx", "/usr/local/bin/jadx", "/usr/bin/jadx"]
    for p in linux_paths:
        if Path(p).exists():
            return p

    windows_paths = [r"C:\jadx\bin\jadx.bat", r"C:\tools\jadx\bin\jadx.bat"]
    for p in windows_paths:
        if Path(p).exists():
            return p

    raise FileNotFoundError(
        "JADX introuvable. Définissez JADX_PATH dans .env\n"
        "Docker : automatique | Local : https://github.com/skylot/jadx/releases"
    )


def decompile_apk(apk_path: str, output_dir: str = None) -> Path:
    apk_path = Path(apk_path)
    if not apk_path.exists():
        raise FileNotFoundError(f"APK introuvable : {apk_path}")

    if output_dir is None:
        output_path = BASE_DIR / "output" / "decompiled" / apk_path.stem
    else:
        output_path = Path(output_dir)

    output_path.mkdir(parents=True, exist_ok=True)

    jadx = _find_jadx()
    print(f"[*] JADX : {jadx}")
    print(f"[*] Décompilation de {apk_path.name} ...")

    command = [jadx, "--deobf", "--show-bad-code", "-d", str(output_path), str(apk_path)]
    result = subprocess.run(command, capture_output=True, text=True, timeout=180)

    if result.returncode != 0:
        print(f"[!] Avertissement JADX :\n{result.stderr[:500]}")
    else:
        print(f"[+] Décompilation réussie !")

    return output_path


def collect_java_files(decompiled_dir: Path) -> list:
    files = list(decompiled_dir.rglob("*.java")) + list(decompiled_dir.rglob("*.kt"))
    files = [
        f for f in files
        if not any(part in str(f) for part in [
            "android/support", "android/arch", "androidx",
            "com/google/android", "kotlin/", "kotlinx/"
        ])
    ]
    print(f"[+] {len(files)} fichiers sources trouvés (libs exclues)")
    return files


def parse_apk(apk_path: str) -> list:
    output_dir = decompile_apk(apk_path)
    return collect_java_files(output_dir)