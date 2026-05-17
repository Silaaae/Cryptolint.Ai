package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class zzcb {
    private final Context mContext;
    private final String zzqr;
    private int zzuA;
    private int zzuB;
    private int zzuC;
    private String zzuD;
    private BlockingQueue<zzce> zzuF;
    private ExecutorService zzuG;
    private LinkedHashMap<String, String> zzuH = new LinkedHashMap<>();
    private AtomicBoolean zzuI;
    private File zzuJ;
    private int zzuz;

    public zzcb(Context context, String str, String str2, int i, int i2, int i3, int i4, Map<String, String> map, int i5) {
        File externalStorageDirectory;
        this.mContext = context;
        this.zzqr = str;
        this.zzuD = str2;
        this.zzuA = i;
        this.zzuB = i2;
        this.zzuC = i3;
        zzq(i4);
        this.zzuI = new AtomicBoolean(false);
        this.zzuI.set(zzbz.zzub.get().booleanValue());
        if (this.zzuI.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzuJ = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            zzd(entry.getKey(), entry.getValue());
        }
        if (i5 == 1) {
            zzdj();
        }
        if (i5 == 2) {
            zzdk();
        }
        init();
    }

    private void init() {
        this.zzuF = new ArrayBlockingQueue(this.zzuA);
        this.zzuG = Executors.newSingleThreadExecutor();
        this.zzuG.execute(new Runnable() { // from class: com.google.android.gms.internal.zzcb.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                zzcb.this.zzdl();
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x003a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void zza(File file, String str) throws Throwable {
        ?? r1;
        FileOutputStream fileOutputStream;
        if (file == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("CsiReporter: File doesn't exists. Cannot write CSI data to file.");
            return;
        }
        try {
            try {
                fileOutputStream = new FileOutputStream(file, true);
                try {
                    fileOutputStream.write(str.getBytes());
                    fileOutputStream.write(10);
                    r1 = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            r1 = fileOutputStream;
                        } catch (IOException e) {
                            com.google.android.gms.ads.internal.util.client.zzb.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e);
                            r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt.";
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("CsiReporter: Cannot write to file: sdk_csi_data.txt.", e);
                    r1 = fileOutputStream;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                            r1 = fileOutputStream;
                        } catch (IOException e3) {
                            com.google.android.gms.ads.internal.util.client.zzb.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e3);
                            r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt.";
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e4) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("CsiReporter: Cannot close file: sdk_csi_data.txt.", e4);
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            r1 = 0;
            if (r1 != 0) {
            }
            throw th;
        }
    }

    private void zzb(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzd("eid", TextUtils.join(",", list));
    }

    private boolean zzc(Map<String, String> map) throws Throwable {
        boolean z = false;
        for (int i = 0; !z && i < this.zzuB; i++) {
            try {
                Thread.sleep(this.zzuC);
                String strZza = zza(this.zzuD, map);
                if (this.zzuI.get()) {
                    zza(this.zzuJ, strZza);
                } else {
                    com.google.android.gms.ads.internal.zzo.zzbv().zzc(this.mContext, this.zzqr, strZza);
                }
                z = true;
            } catch (InterruptedException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("CsiReporter: interrupted in sendReport()", e);
                Thread.currentThread().interrupt();
            }
        }
        return z;
    }

    private void zzdj() {
        zzb(zzbz.zzdb());
    }

    private void zzdk() {
        zzb(zzbz.zzx(this.mContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzdl() throws Throwable {
        while (true) {
            try {
                List<zzce> listZzp = zzp(this.zzuz);
                if (listZzp != null) {
                    Iterator<Map<String, String>> it = zzc(listZzp).values().iterator();
                    while (it.hasNext()) {
                        zzc(it.next());
                    }
                }
            } catch (InterruptedException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    private List<zzce> zzp(int i) throws InterruptedException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(this.zzuF.take());
        }
        return arrayList;
    }

    private void zzq(int i) {
        if (i < 1) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("CsiReporter - too small batch size :" + i + ", changed to 1");
            i = 1;
        }
        if (i > this.zzuA) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("CsiReporter - batch size :" + i + " bigger than buffer size, change to buffer limit");
            i = this.zzuA;
        }
        this.zzuz = i;
    }

    String zza(String str, Map<String, String> map) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builderBuildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return builderBuildUpon.build().toString();
    }

    public boolean zza(zzce zzceVar) {
        return this.zzuF.offer(zzceVar);
    }

    Map<String, Map<String, String>> zzc(List<zzce> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (zzce zzceVar : list) {
            String strZzdr = zzceVar.zzdr();
            if (linkedHashMap.containsKey(strZzdr)) {
                ((List) linkedHashMap.get(strZzdr)).add(zzceVar);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(zzceVar);
                linkedHashMap.put(strZzdr, arrayList);
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap3 = new LinkedHashMap(this.zzuH);
            try {
                linkedHashMap3.putAll(zzce.zza((zzce[]) list2.toArray(new zzce[list2.size()])));
                linkedHashMap2.put(entry.getKey(), linkedHashMap3);
            } catch (IllegalArgumentException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("CsiReporter:failed to merge tickers:" + list2, e);
            }
        }
        return linkedHashMap2;
    }

    void zzd(String str, String str2) {
        this.zzuH.put(str, str2);
    }
}
