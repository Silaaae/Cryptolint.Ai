package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzdt;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzie;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public final class zzgf extends zzi.zza {
    private static zzgf zzDv;
    private static final Object zzoW = new Object();
    private final Context mContext;
    private final zzge zzDw;
    private final zzbr zzDx;
    private final zzdt zzqC;

    zzgf(Context context, zzbr zzbrVar, zzge zzgeVar) {
        this.mContext = context;
        this.zzDw = zzgeVar;
        this.zzDx = zzbrVar;
        this.zzqC = new zzdt(context.getApplicationContext() != null ? context.getApplicationContext() : context, new VersionInfoParcel(7571000, 7571000, true), zzbrVar.zzcW(), new zzdt.zzb<zzbb>() { // from class: com.google.android.gms.internal.zzgf.5
            @Override // com.google.android.gms.internal.zzdt.zzb
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            public void zzc(zzbb zzbbVar) {
                zzbbVar.zza("/log", zzdf.zzwc);
            }
        }, new zzdt.zzc());
    }

    private static AdResponseParcel zza(final Context context, final zzdt zzdtVar, final zzbr zzbrVar, zzge zzgeVar, final AdRequestInfoParcel adRequestInfoParcel) {
        String string;
        com.google.android.gms.ads.internal.util.client.zzb.zzay("Starting ad request from service.");
        zzbz.zzw(context);
        final zzce zzceVar = new zzce("load_ad");
        zzcd zzcdVarZzdo = zzceVar.zzdo();
        zzgeVar.zzDs.init();
        zzgk zzgkVarZzC = com.google.android.gms.ads.internal.zzo.zzbB().zzC(context);
        if (zzgkVarZzC.zzEy == -1) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Device is offline.");
            return new AdResponseParcel(2);
        }
        String string2 = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzCE : UUID.randomUUID().toString();
        final zzgh zzghVar = new zzgh(string2, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzCm.extras != null && (string = adRequestInfoParcel.zzCm.extras.getString("_ad")) != null) {
            return zzgg.zza(context, adRequestInfoParcel, string);
        }
        Location locationZzc = zzgeVar.zzDs.zzc(250L);
        String strZzc = zzgeVar.zzDt.zzc(context, adRequestInfoParcel.zzCn.packageName);
        JSONObject jSONObjectZza = zzgg.zza(adRequestInfoParcel, zzgkVarZzC, locationZzc, zzbrVar, strZzc, zzgeVar.zzDu.zzar(adRequestInfoParcel.zzCo), zzgeVar.zzDr.zza(adRequestInfoParcel));
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                jSONObjectZza.put("request_id", string2);
            } catch (JSONException e) {
            }
        }
        if (jSONObjectZza == null) {
            return new AdResponseParcel(0);
        }
        final String string3 = jSONObjectZza.toString();
        zzceVar.zza(zzcdVarZzdo, "arc");
        final zzcd zzcdVarZzdo2 = zzceVar.zzdo();
        if (zzbz.zztE.get().booleanValue()) {
            zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.internal.zzgf.1
                @Override // java.lang.Runnable
                public void run() {
                    zzdt.zzd zzdVarZzdU = zzdtVar.zzdU();
                    zzghVar.zzb(zzdVarZzdU);
                    zzceVar.zza(zzcdVarZzdo2, "rwc");
                    final zzcd zzcdVarZzdo3 = zzceVar.zzdo();
                    zzdVarZzdU.zza(new zzhx.zzc<zzbe>() { // from class: com.google.android.gms.internal.zzgf.1.1
                        @Override // com.google.android.gms.internal.zzhx.zzc
                        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
                        public void zzc(zzbe zzbeVar) {
                            zzceVar.zza(zzcdVarZzdo3, "jsf");
                            zzceVar.zzdp();
                            zzbeVar.zza("/invalidRequest", zzghVar.zzDO);
                            zzbeVar.zza("/loadAdURL", zzghVar.zzDP);
                            try {
                                zzbeVar.zza("AFMA_buildAdURL", string3);
                            } catch (Exception e2) {
                                com.google.android.gms.ads.internal.util.client.zzb.zzb("Error requesting an ad url", e2);
                            }
                        }
                    }, new zzhx.zza() { // from class: com.google.android.gms.internal.zzgf.1.2
                        @Override // com.google.android.gms.internal.zzhx.zza
                        public void run() {
                        }
                    });
                }
            });
        } else {
            zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.internal.zzgf.2
                @Override // java.lang.Runnable
                public void run() {
                    zzid zzidVarZza = com.google.android.gms.ads.internal.zzo.zzbw().zza(context, new AdSizeParcel(), false, false, null, adRequestInfoParcel.zzpJ);
                    if (com.google.android.gms.ads.internal.zzo.zzby().zzge()) {
                        zzidVarZza.getWebView().clearCache(true);
                    }
                    zzidVarZza.setWillNotDraw(true);
                    zzghVar.zze(zzidVarZza);
                    zzceVar.zza(zzcdVarZzdo2, "rwc");
                    zzie.zza zzaVarZza = zzgf.zza(string3, zzceVar, zzceVar.zzdo());
                    zzie zzieVarZzgF = zzidVarZza.zzgF();
                    zzieVarZzgF.zza("/invalidRequest", zzghVar.zzDO);
                    zzieVarZzgF.zza("/loadAdURL", zzghVar.zzDP);
                    zzieVarZzgF.zza("/log", zzdf.zzwc);
                    zzieVarZzgF.zza(zzaVarZza);
                    com.google.android.gms.ads.internal.util.client.zzb.zzay("Loading the JS library.");
                    zzidVarZza.loadUrl(zzbrVar.zzcW());
                }
            });
        }
        try {
            zzgj zzgjVar = zzghVar.zzfE().get(10L, TimeUnit.SECONDS);
            if (zzgjVar == null) {
                return new AdResponseParcel(0);
            }
            if (zzgjVar.getErrorCode() != -2) {
                return new AdResponseParcel(zzgjVar.getErrorCode());
            }
            if (zzceVar.zzds() != null) {
                zzceVar.zza(zzceVar.zzds(), "rur");
            }
            String strZzaq = zzgjVar.zzfI() ? zzgeVar.zzDq.zzaq(adRequestInfoParcel.zzCn.packageName) : null;
            zzcd zzcdVarZzdo3 = zzceVar.zzdo();
            AdResponseParcel adResponseParcelZza = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzpJ.zzGG, zzgjVar.getUrl(), strZzaq, strZzc, zzgjVar);
            if (adResponseParcelZza.zzCW == 1) {
                zzgeVar.zzDt.clearToken(context, adRequestInfoParcel.zzCn.packageName);
            }
            zzceVar.zza(zzcdVarZzdo3, "ufe");
            zzceVar.zza(zzcdVarZzdo, "tts");
            if (zzhg.zzfY() != null) {
                zzhg.zzfY().zza(zzceVar);
            }
            return adResponseParcelZza;
        } catch (Exception e2) {
            return new AdResponseParcel(0);
        } finally {
            zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.internal.zzgf.3
                @Override // java.lang.Runnable
                public void run() {
                    zzghVar.zzfF();
                    if (zzghVar.zzfD() != null) {
                        zzghVar.zzfD().release();
                    }
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0103, code lost:
    
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Received error HTTP response code: " + r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
    
        return new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static AdResponseParcel zza(AdRequestInfoParcel adRequestInfoParcel, Context context, String str, String str2, String str3, String str4, zzgj zzgjVar) {
        try {
            zzgi zzgiVar = new zzgi(adRequestInfoParcel);
            com.google.android.gms.ads.internal.util.client.zzb.zzay("AdRequestServiceImpl: Sending request: " + str2);
            URL url = new URL(str2);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            URL url2 = url;
            int i = 0;
            while (true) {
                HttpURLConnection httpURLConnection = (HttpURLConnection) url2.openConnection();
                try {
                    com.google.android.gms.ads.internal.zzo.zzbv().zza(context, str, false, httpURLConnection);
                    if (!TextUtils.isEmpty(str3)) {
                        httpURLConnection.addRequestProperty("x-afma-drt-cookie", str3);
                    }
                    if (!TextUtils.isEmpty(str4)) {
                        httpURLConnection.addRequestProperty("Authorization", "Bearer " + str4);
                    }
                    if (zzgjVar != null && !TextUtils.isEmpty(zzgjVar.zzfH())) {
                        httpURLConnection.setDoOutput(true);
                        byte[] bytes = zzgjVar.zzfH().getBytes();
                        httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                        bufferedOutputStream.write(bytes);
                        bufferedOutputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    if (responseCode >= 200 && responseCode < 300) {
                        String string = url2.toString();
                        String strZza = com.google.android.gms.ads.internal.zzo.zzbv().zza(new InputStreamReader(httpURLConnection.getInputStream()));
                        zza(string, headerFields, strZza, responseCode);
                        zzgiVar.zza(string, headerFields, strZza);
                        return zzgiVar.zzj(jElapsedRealtime);
                    }
                    zza(url2.toString(), headerFields, null, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        break;
                    }
                    String headerField = httpURLConnection.getHeaderField("Location");
                    if (TextUtils.isEmpty(headerField)) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaC("No location header to follow redirect.");
                        return new AdResponseParcel(0);
                    }
                    url2 = new URL(headerField);
                    i++;
                    if (i > 5) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Too many redirects.");
                        return new AdResponseParcel(0);
                    }
                    zzgiVar.zzi(headerFields);
                } finally {
                    httpURLConnection.disconnect();
                }
            }
        } catch (IOException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Error while connecting to ad server: " + e.getMessage());
            return new AdResponseParcel(2);
        }
    }

    public static zzgf zza(Context context, zzbr zzbrVar, zzge zzgeVar) {
        zzgf zzgfVar;
        synchronized (zzoW) {
            if (zzDv == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzDv = new zzgf(context, zzbrVar, zzgeVar);
            }
            zzgfVar = zzDv;
        }
        return zzgfVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzie.zza zza(final String str, final zzce zzceVar, final zzcd zzcdVar) {
        return new zzie.zza() { // from class: com.google.android.gms.internal.zzgf.4
            @Override // com.google.android.gms.internal.zzie.zza
            public void zza(zzid zzidVar, boolean z) {
                zzceVar.zza(zzcdVar, "jsf");
                zzceVar.zzdp();
                zzidVar.zza("AFMA_buildAdURL", str);
            }
        };
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (com.google.android.gms.ads.internal.util.client.zzb.zzL(2)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("Http Response: {\n  URL:\n    " + str + "\n  Headers:");
            if (map != null) {
                for (String str3 : map.keySet()) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB("    " + str3 + ":");
                    Iterator<String> it = map.get(str3).iterator();
                    while (it.hasNext()) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaB("      " + it.next());
                    }
                }
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += 1000) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaB(str2.substring(i2, Math.min(str2.length(), i2 + 1000)));
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.zzaB("    null");
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("  Response Code:\n    " + i + "\n}");
        }
    }

    @Override // com.google.android.gms.ads.internal.request.zzi
    public void zza(final AdRequestInfoParcel adRequestInfoParcel, final com.google.android.gms.ads.internal.request.zzj zzjVar) {
        com.google.android.gms.ads.internal.zzo.zzby().zzb(this.mContext, adRequestInfoParcel.zzpJ);
        new zzhh() { // from class: com.google.android.gms.internal.zzgf.6
            @Override // com.google.android.gms.internal.zzhh
            public void onStop() {
                try {
                    zzjVar.zzb(new AdResponseParcel(-1));
                } catch (RemoteException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to forward ad response.", e);
                }
            }

            @Override // com.google.android.gms.internal.zzhh
            public void zzdP() {
                AdResponseParcel adResponseParcel;
                try {
                    adResponseParcel = zzgf.this.zze(adRequestInfoParcel);
                } catch (Exception e) {
                    com.google.android.gms.ads.internal.zzo.zzby().zzc((Throwable) e, true);
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response due to an Exception.", e);
                    adResponseParcel = null;
                }
                if (adResponseParcel == null) {
                    adResponseParcel = new AdResponseParcel(0);
                }
                try {
                    zzjVar.zzb(adResponseParcel);
                } catch (RemoteException e2) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzd("Fail to forward ad response.", e2);
                }
            }
        }.zzgi();
    }

    @Override // com.google.android.gms.ads.internal.request.zzi
    public AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        zzhg.zze(this.mContext, adRequestInfoParcel.zzpJ.zzGG);
        return zza(this.mContext, this.zzqC, this.zzDx, this.zzDw, adRequestInfoParcel);
    }
}
