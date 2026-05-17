package com.google.android.gms.analytics.internal;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public class zzn extends zzd {
    private volatile String zzJd;
    private Future<String> zzKG;

    protected zzn(zzf zzfVar) {
        super(zzfVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean zzg(Context context, String str) {
        boolean z = false;
        com.google.android.gms.common.internal.zzu.zzcj(str);
        com.google.android.gms.common.internal.zzu.zzbZ("ClientId should be saved from worker thread");
        FileOutputStream fileOutputStreamOpenFileOutput = 0;
        fileOutputStreamOpenFileOutput = 0;
        fileOutputStreamOpenFileOutput = 0;
        try {
            try {
                try {
                    zza("Storing clientId", str);
                    fileOutputStreamOpenFileOutput = context.openFileOutput("gaClientId", 0);
                    fileOutputStreamOpenFileOutput.write(str.getBytes());
                    z = true;
                    fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                    if (fileOutputStreamOpenFileOutput != 0) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                            fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                        } catch (IOException e) {
                            zze("Failed to close clientId writing stream", e);
                            fileOutputStreamOpenFileOutput = "Failed to close clientId writing stream";
                        }
                    }
                } catch (Throwable th) {
                    if (fileOutputStreamOpenFileOutput != 0) {
                        try {
                            fileOutputStreamOpenFileOutput.close();
                        } catch (IOException e2) {
                            zze("Failed to close clientId writing stream", e2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e3) {
                zze("Error writing to clientId file", e3);
                fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                if (fileOutputStreamOpenFileOutput != 0) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                        fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                    } catch (IOException e4) {
                        zze("Failed to close clientId writing stream", e4);
                        fileOutputStreamOpenFileOutput = "Failed to close clientId writing stream";
                    }
                }
            }
        } catch (FileNotFoundException e5) {
            zze("Error creating clientId file", e5);
            fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
            if (fileOutputStreamOpenFileOutput != 0) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                    fileOutputStreamOpenFileOutput = fileOutputStreamOpenFileOutput;
                } catch (IOException e6) {
                    zze("Failed to close clientId writing stream", e6);
                    fileOutputStreamOpenFileOutput = "Failed to close clientId writing stream";
                }
            }
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String zziS() {
        String strZziT = zziT();
        try {
            return !zzg(zzhS().getContext(), strZziT) ? "0" : strZziT;
        } catch (Exception e) {
            zze("Error saving clientId file", e);
            return "0";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0074 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x008d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x008b -> B:63:0x002e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x008d -> B:63:0x002e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0092 -> B:63:0x002e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected String zzX(Context context) throws Throwable {
        ?? OpenFileInput;
        Throwable th;
        ?? r1;
        String str = null;
        com.google.android.gms.common.internal.zzu.zzbZ("ClientId should be loaded from worker thread");
        try {
            try {
                OpenFileInput = context.openFileInput("gaClientId");
                try {
                    byte[] bArr = new byte[36];
                    int i = OpenFileInput.read(bArr, 0, bArr.length);
                    if (OpenFileInput.available() > 0) {
                        zzaW("clientId file seems corrupted, deleting it.");
                        OpenFileInput.close();
                        context.deleteFile("gaClientId");
                        OpenFileInput = OpenFileInput;
                        if (OpenFileInput != 0) {
                            try {
                                OpenFileInput.close();
                                OpenFileInput = OpenFileInput;
                            } catch (IOException e) {
                                zze("Failed to close client id reading stream", e);
                                OpenFileInput = "Failed to close client id reading stream";
                            }
                        }
                    } else if (i < 14) {
                        zzaW("clientId file is empty, deleting it.");
                        OpenFileInput.close();
                        context.deleteFile("gaClientId");
                        OpenFileInput = OpenFileInput;
                        if (OpenFileInput != 0) {
                            try {
                                OpenFileInput.close();
                                OpenFileInput = OpenFileInput;
                            } catch (IOException e2) {
                                zze("Failed to close client id reading stream", e2);
                                OpenFileInput = "Failed to close client id reading stream";
                            }
                        }
                    } else {
                        OpenFileInput.close();
                        String str2 = new String(bArr, 0, i);
                        zza("Read client id from disk", str2);
                        ?? r2 = OpenFileInput;
                        if (OpenFileInput != 0) {
                            try {
                                OpenFileInput.close();
                                r2 = OpenFileInput;
                            } catch (IOException e3) {
                                zze("Failed to close client id reading stream", e3);
                                r2 = "Failed to close client id reading stream";
                            }
                        }
                        str = str2;
                        OpenFileInput = r2;
                    }
                } catch (FileNotFoundException e4) {
                    r1 = OpenFileInput;
                    if (r1 != 0) {
                        try {
                            r1.close();
                        } catch (IOException e5) {
                            zze("Failed to close client id reading stream", e5);
                        }
                    }
                    return str;
                } catch (IOException e6) {
                    e = e6;
                    zze("Error reading client id file, deleting it", e);
                    context.deleteFile("gaClientId");
                    OpenFileInput = OpenFileInput;
                    if (OpenFileInput != 0) {
                        try {
                            OpenFileInput.close();
                            OpenFileInput = OpenFileInput;
                        } catch (IOException e7) {
                            zze("Failed to close client id reading stream", e7);
                            OpenFileInput = "Failed to close client id reading stream";
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (OpenFileInput != 0) {
                    try {
                        OpenFileInput.close();
                    } catch (IOException e8) {
                        zze("Failed to close client id reading stream", e8);
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e9) {
            r1 = 0;
            if (r1 != 0) {
            }
            return str;
        } catch (IOException e10) {
            e = e10;
            OpenFileInput = 0;
            zze("Error reading client id file, deleting it", e);
            context.deleteFile("gaClientId");
            OpenFileInput = OpenFileInput;
            if (OpenFileInput != 0) {
            }
            return str;
        } catch (Throwable th3) {
            OpenFileInput = 0;
            th = th3;
            if (OpenFileInput != 0) {
            }
            throw th;
        }
        return str;
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zzhn() {
    }

    public String zziP() {
        String str;
        zzia();
        synchronized (this) {
            if (this.zzJd == null) {
                this.zzKG = zzhS().zzb(new Callable<String>() { // from class: com.google.android.gms.analytics.internal.zzn.1
                    @Override // java.util.concurrent.Callable
                    /* JADX INFO: renamed from: zziU, reason: merged with bridge method [inline-methods] */
                    public String call() throws Exception {
                        return zzn.this.zziR();
                    }
                });
            }
            if (this.zzKG != null) {
                try {
                    this.zzJd = this.zzKG.get();
                } catch (InterruptedException e) {
                    zzd("ClientId loading or generation was interrupted", e);
                    this.zzJd = "0";
                } catch (ExecutionException e2) {
                    zze("Failed to load or generate client id", e2);
                    this.zzJd = "0";
                }
                if (this.zzJd == null) {
                    this.zzJd = "0";
                }
                zza("Loaded clientId", this.zzJd);
                this.zzKG = null;
                str = this.zzJd;
            } else {
                str = this.zzJd;
            }
        }
        return str;
    }

    String zziQ() {
        synchronized (this) {
            this.zzJd = null;
            this.zzKG = zzhS().zzb(new Callable<String>() { // from class: com.google.android.gms.analytics.internal.zzn.2
                @Override // java.util.concurrent.Callable
                /* JADX INFO: renamed from: zziU, reason: merged with bridge method [inline-methods] */
                public String call() throws Exception {
                    return zzn.this.zziS();
                }
            });
        }
        return zziP();
    }

    String zziR() throws Throwable {
        String strZzX = zzX(zzhS().getContext());
        return strZzX == null ? zziS() : strZzX;
    }

    protected String zziT() {
        return UUID.randomUUID().toString().toLowerCase();
    }
}
