package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.plus.PlusShare;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzfy implements Callable<zzha> {
    private static final long zzBF = TimeUnit.SECONDS.toMillis(60);
    private final Context mContext;
    private final zzho zzBG;
    private final com.google.android.gms.ads.internal.zzm zzBH;
    private final zzbc zzBI;
    private final zzha.zza zzBs;
    private final zzan zzvA;
    private final Object zzqt = new Object();
    private boolean zzBJ = false;
    private int zzBv = -2;
    private List<String> zzBK = null;

    public interface zza<T extends zzg.zza> {
        T zza(zzfy zzfyVar, JSONObject jSONObject) throws ExecutionException, JSONException, InterruptedException;
    }

    class zzb {
        public zzdg zzBX;

        zzb() {
        }
    }

    public zzfy(Context context, com.google.android.gms.ads.internal.zzm zzmVar, zzbc zzbcVar, zzho zzhoVar, zzan zzanVar, zzha.zza zzaVar) {
        this.mContext = context;
        this.zzBH = zzmVar;
        this.zzBG = zzhoVar;
        this.zzBI = zzbcVar;
        this.zzBs = zzaVar;
        this.zzvA = zzanVar;
    }

    private zzg.zza zza(zzbb zzbbVar, zza zzaVar, JSONObject jSONObject) throws ExecutionException, JSONException, InterruptedException {
        if (zzfr()) {
            return null;
        }
        String[] strArrZzc = zzc(jSONObject.getJSONObject("tracking_urls_and_actions"), "impression_tracking_urls");
        this.zzBK = strArrZzc == null ? null : Arrays.asList(strArrZzc);
        zzg.zza zzaVarZza = zzaVar.zza(this, jSONObject);
        if (zzaVarZza == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaz("Failed to retrieve ad assets.");
            return null;
        }
        zzaVarZza.zza(new com.google.android.gms.ads.internal.formats.zzg(this.mContext, this.zzBH, zzbbVar, this.zzvA, jSONObject, zzaVarZza));
        return zzaVarZza;
    }

    private zzha zza(zzg.zza zzaVar) {
        int i;
        synchronized (this.zzqt) {
            i = this.zzBv;
            if (zzaVar == null && this.zzBv == -2) {
                i = 0;
            }
        }
        return new zzha(this.zzBs.zzFr.zzCm, null, this.zzBs.zzFs.zzxF, i, this.zzBs.zzFs.zzxG, this.zzBK, this.zzBs.zzFs.orientation, this.zzBs.zzFs.zzxJ, this.zzBs.zzFr.zzCp, false, null, null, null, null, null, 0L, this.zzBs.zzpN, this.zzBs.zzFs.zzCJ, this.zzBs.zzFo, this.zzBs.zzFp, this.zzBs.zzFs.zzCP, this.zzBs.zzFl, i != -2 ? null : zzaVar, this.zzBs.zzFr.zzCC);
    }

    private zzhv<com.google.android.gms.ads.internal.formats.zzc> zza(JSONObject jSONObject, final boolean z, boolean z2) throws JSONException {
        final String string = z ? jSONObject.getString(PlusShare.KEY_CALL_TO_ACTION_URL) : jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        if (!TextUtils.isEmpty(string)) {
            return z2 ? new zzht(new com.google.android.gms.ads.internal.formats.zzc(null, Uri.parse(string))) : this.zzBG.zza(string, new zzho.zza<com.google.android.gms.ads.internal.formats.zzc>() { // from class: com.google.android.gms.internal.zzfy.5
                @Override // com.google.android.gms.internal.zzho.zza
                /* JADX INFO: renamed from: zzfs, reason: merged with bridge method [inline-methods] */
                public com.google.android.gms.ads.internal.formats.zzc zzft() {
                    zzfy.this.zza(2, z);
                    return null;
                }

                @Override // com.google.android.gms.internal.zzho.zza
                /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
                public com.google.android.gms.ads.internal.formats.zzc zzh(InputStream inputStream) {
                    byte[] bArrZzk;
                    try {
                        bArrZzk = zzlg.zzk(inputStream);
                    } catch (IOException e) {
                        bArrZzk = null;
                    }
                    if (bArrZzk == null) {
                        zzfy.this.zza(2, z);
                        return null;
                    }
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrZzk, 0, bArrZzk.length);
                    if (bitmapDecodeByteArray != null) {
                        return new com.google.android.gms.ads.internal.formats.zzc(new BitmapDrawable(Resources.getSystem(), bitmapDecodeByteArray), Uri.parse(string));
                    }
                    zzfy.this.zza(2, z);
                    return null;
                }
            });
        }
        zza(0, z);
        return new zzht(null);
    }

    private void zza(zzg.zza zzaVar, zzbb zzbbVar) {
        if (zzaVar instanceof com.google.android.gms.ads.internal.formats.zzf) {
            final com.google.android.gms.ads.internal.formats.zzf zzfVar = (com.google.android.gms.ads.internal.formats.zzf) zzaVar;
            zzb zzbVar = new zzb();
            zzdg zzdgVar = new zzdg() { // from class: com.google.android.gms.internal.zzfy.3
                @Override // com.google.android.gms.internal.zzdg
                public void zza(zzid zzidVar, Map<String, String> map) {
                    zzfy.this.zzb(zzfVar, map.get("asset"));
                }
            };
            zzbVar.zzBX = zzdgVar;
            zzbbVar.zza("/nativeAdCustomClick", zzdgVar);
        }
    }

    private Integer zzb(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException e) {
            return null;
        }
    }

    private JSONObject zzb(final zzbb zzbbVar) throws JSONException, TimeoutException {
        if (zzfr()) {
            return null;
        }
        final zzhs zzhsVar = new zzhs();
        final zzb zzbVar = new zzb();
        zzdg zzdgVar = new zzdg() { // from class: com.google.android.gms.internal.zzfy.1
            @Override // com.google.android.gms.internal.zzdg
            public void zza(zzid zzidVar, Map<String, String> map) {
                zzbbVar.zzb("/nativeAdPreProcess", zzbVar.zzBX);
                try {
                    String str = map.get("success");
                    if (!TextUtils.isEmpty(str)) {
                        zzhsVar.zzf(new JSONObject(str).getJSONArray("ads").getJSONObject(0));
                        return;
                    }
                } catch (JSONException e) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzb("Malformed native JSON response.", e);
                }
                zzfy.this.zzB(0);
                com.google.android.gms.common.internal.zzu.zza(zzfy.this.zzfr(), "Unable to set the ad state error!");
                zzhsVar.zzf(null);
            }
        };
        zzbVar.zzBX = zzdgVar;
        zzbbVar.zza("/nativeAdPreProcess", zzdgVar);
        zzbbVar.zza("google.afma.nativeAds.preProcessJsonGmsg", new JSONObject(this.zzBs.zzFs.zzCI));
        return (JSONObject) zzhsVar.get(zzBF, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(zzcs zzcsVar, String str) {
        try {
            zzcw zzcwVarZzq = this.zzBH.zzq(zzcsVar.getCustomTemplateId());
            if (zzcwVarZzq != null) {
                zzcwVarZzq.zza(zzcsVar, str);
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call onCustomClick for asset " + str + ".", e);
        }
    }

    private String[] zzc(JSONObject jSONObject, String str) throws JSONException {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        if (jSONArrayOptJSONArray == null) {
            return null;
        }
        String[] strArr = new String[jSONArrayOptJSONArray.length()];
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            strArr[i] = jSONArrayOptJSONArray.getString(i);
        }
        return strArr;
    }

    private zzbb zzfq() throws ExecutionException, InterruptedException, CancellationException, TimeoutException {
        if (zzfr()) {
            return null;
        }
        zzbb zzbbVar = this.zzBI.zza(this.mContext, this.zzBs.zzFr.zzpJ, (this.zzBs.zzFs.zzzG.indexOf("https") == 0 ? "https:" : "http:") + zzbz.zzur.get()).get(zzBF, TimeUnit.MILLISECONDS);
        zzbbVar.zza(this.zzBH, this.zzBH, this.zzBH, this.zzBH, false, null, null, null, null);
        return zzbbVar;
    }

    public void zzB(int i) {
        synchronized (this.zzqt) {
            this.zzBJ = true;
            this.zzBv = i;
        }
    }

    public zzhv<com.google.android.gms.ads.internal.formats.zzc> zza(JSONObject jSONObject, String str, boolean z, boolean z2) throws JSONException {
        JSONObject jSONObject2 = z ? jSONObject.getJSONObject(str) : jSONObject.optJSONObject(str);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, z, z2);
    }

    public List<zzhv<com.google.android.gms.ads.internal.formats.zzc>> zza(JSONObject jSONObject, String str, boolean z, boolean z2, boolean z3) throws JSONException {
        JSONArray jSONArray = z ? jSONObject.getJSONArray(str) : jSONObject.optJSONArray(str);
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null || jSONArray.length() == 0) {
            zza(0, z);
            return arrayList;
        }
        int length = z3 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            arrayList.add(zza(jSONObject2, z, z2));
        }
        return arrayList;
    }

    public Future<com.google.android.gms.ads.internal.formats.zzc> zza(JSONObject jSONObject, String str, boolean z) throws JSONException {
        JSONObject jSONObject2 = jSONObject.getJSONObject(str);
        boolean zOptBoolean = jSONObject2.optBoolean("require", true);
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        return zza(jSONObject2, zOptBoolean, z);
    }

    public void zza(int i, boolean z) {
        if (z) {
            zzB(i);
        }
    }

    protected zza zzd(JSONObject jSONObject) throws JSONException, TimeoutException {
        if (zzfr()) {
            return null;
        }
        String string = jSONObject.getString("template_id");
        boolean z = this.zzBs.zzFr.zzqb != null ? this.zzBs.zzFr.zzqb.zzvC : false;
        boolean z2 = this.zzBs.zzFr.zzqb != null ? this.zzBs.zzFr.zzqb.zzvE : false;
        if ("2".equals(string)) {
            return new zzfz(z, z2);
        }
        if ("1".equals(string)) {
            return new zzga(z, z2);
        }
        if ("3".equals(string)) {
            final String string2 = jSONObject.getString("custom_template_id");
            final zzhs zzhsVar = new zzhs();
            zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.internal.zzfy.2
                @Override // java.lang.Runnable
                public void run() {
                    zzhsVar.zzf(zzfy.this.zzBH.zzbo().get(string2));
                }
            });
            if (zzhsVar.get(zzBF, TimeUnit.MILLISECONDS) != null) {
                return new zzgb(z);
            }
            com.google.android.gms.ads.internal.util.client.zzb.zzaz("No handler for custom template: " + jSONObject.getString("custom_template_id"));
        } else {
            zzB(0);
        }
        return null;
    }

    public zzhv<com.google.android.gms.ads.internal.formats.zza> zze(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("attribution");
        if (jSONObjectOptJSONObject == null) {
            return new zzht(null);
        }
        final String strOptString = jSONObjectOptJSONObject.optString("text");
        final int iOptInt = jSONObjectOptJSONObject.optInt("text_size", -1);
        final Integer numZzb = zzb(jSONObjectOptJSONObject, "text_color");
        final Integer numZzb2 = zzb(jSONObjectOptJSONObject, "bg_color");
        return zzhu.zza(zza(jSONObjectOptJSONObject, "image", false, false), new zzhu.zza<com.google.android.gms.ads.internal.formats.zzc, com.google.android.gms.ads.internal.formats.zza>() { // from class: com.google.android.gms.internal.zzfy.4
            /* JADX WARN: Removed duplicated region for block: B:6:0x000b  */
            @Override // com.google.android.gms.internal.zzhu.zza
            /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public com.google.android.gms.ads.internal.formats.zza zze(com.google.android.gms.ads.internal.formats.zzc zzcVar) {
                com.google.android.gms.ads.internal.formats.zza zzaVar;
                if (zzcVar != null) {
                    try {
                        if (TextUtils.isEmpty(strOptString)) {
                            zzaVar = null;
                        } else {
                            zzaVar = new com.google.android.gms.ads.internal.formats.zza(strOptString, (Drawable) com.google.android.gms.dynamic.zze.zzn(zzcVar.zzdw()), numZzb2, numZzb, iOptInt > 0 ? Integer.valueOf(iOptInt) : null);
                        }
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzb("Could not get attribution icon", e);
                        return null;
                    }
                }
                return zzaVar;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: zzfp, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzha call() {
        try {
            zzbb zzbbVarZzfq = zzfq();
            JSONObject jSONObjectZzb = zzb(zzbbVarZzfq);
            zzg.zza zzaVarZza = zza(zzbbVarZzfq, zzd(jSONObjectZzb), jSONObjectZzb);
            zza(zzaVarZza, zzbbVarZzfq);
            return zza(zzaVarZza);
        } catch (InterruptedException e) {
            if (!this.zzBJ) {
                zzB(0);
            }
            return zza((zzg.zza) null);
        } catch (CancellationException e2) {
            if (!this.zzBJ) {
            }
            return zza((zzg.zza) null);
        } catch (ExecutionException e3) {
            if (!this.zzBJ) {
            }
            return zza((zzg.zza) null);
        } catch (TimeoutException e4) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Timeout when loading native ad.", e4);
            if (!this.zzBJ) {
            }
            return zza((zzg.zza) null);
        } catch (JSONException e5) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Malformed native JSON response.", e5);
            if (!this.zzBJ) {
            }
            return zza((zzg.zza) null);
        }
    }

    public boolean zzfr() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzBJ;
        }
        return z;
    }
}
