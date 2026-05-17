package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbk;
import com.google.android.gms.internal.zzdy;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhh;
import com.google.android.gms.internal.zzhl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzb extends zzhh implements zzc.zza {
    private final Context mContext;
    AdResponseParcel zzBt;
    private final zza.InterfaceC1157zza zzCd;
    private final AdRequestInfoParcel.zza zzCe;
    zzhh zzCf;
    private final zzan zzvA;
    zzdy zzxn;
    private final Object zzBr = new Object();
    Object zzqt = new Object();

    @zzgd
    static final class zza extends Exception {
        private final int zzBv;

        public zza(String str, int i) {
            super(str);
            this.zzBv = i;
        }

        public int getErrorCode() {
            return this.zzBv;
        }
    }

    public zzb(Context context, AdRequestInfoParcel.zza zzaVar, zzan zzanVar, zza.InterfaceC1157zza interfaceC1157zza) {
        this.zzCd = interfaceC1157zza;
        this.mContext = context;
        this.zzCe = zzaVar;
        this.zzvA = zzanVar;
    }

    @Override // com.google.android.gms.internal.zzhh
    public void onStop() {
        synchronized (this.zzBr) {
            if (this.zzCf != null) {
                this.zzCf.cancel();
            }
        }
    }

    zzhh zzb(AdRequestInfoParcel adRequestInfoParcel) {
        return zzc.zza(this.mContext, adRequestInfoParcel, this);
    }

    @Override // com.google.android.gms.ads.internal.request.zzc.zza
    public void zzb(AdResponseParcel adResponseParcel) {
        synchronized (this.zzqt) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Received ad response.");
            this.zzBt = adResponseParcel;
            this.zzqt.notify();
        }
    }

    protected AdSizeParcel zzc(AdRequestInfoParcel adRequestInfoParcel) throws zza {
        if (this.zzBt.zzCN == null) {
            throw new zza("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] strArrSplit = this.zzBt.zzCN.split("x");
        if (strArrSplit.length != 2) {
            throw new zza("Invalid ad size format from the ad response: " + this.zzBt.zzCN, 0);
        }
        try {
            int i = Integer.parseInt(strArrSplit[0]);
            int i2 = Integer.parseInt(strArrSplit[1]);
            for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzpN.zzso) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i3 = adSizeParcel.width == -1 ? (int) (adSizeParcel.widthPixels / f) : adSizeParcel.width;
                int i4 = adSizeParcel.height == -2 ? (int) (adSizeParcel.heightPixels / f) : adSizeParcel.height;
                if (i == i3 && i2 == i4) {
                    return new AdSizeParcel(adSizeParcel, adRequestInfoParcel.zzpN.zzso);
                }
            }
            throw new zza("The ad size from the ad response was not one of the requested sizes: " + this.zzBt.zzCN, 0);
        } catch (NumberFormatException e) {
            throw new zza("Invalid ad size number from the ad response: " + this.zzBt.zzCN, 0);
        }
    }

    @Override // com.google.android.gms.internal.zzhh
    public void zzdP() {
        AdSizeParcel adSizeParcelZzc;
        long j;
        JSONObject jSONObject;
        synchronized (this.zzqt) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("AdLoaderBackgroundTask started.");
            AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.zzCe, this.zzvA.zzab().zzb(this.mContext), com.google.android.gms.ads.internal.zzl.zzq(this.mContext).getClientId());
            int errorCode = -2;
            long jElapsedRealtime = -1;
            try {
                long jElapsedRealtime2 = zzo.zzbz().elapsedRealtime();
                zzhh zzhhVarZzb = zzb(adRequestInfoParcel);
                synchronized (this.zzBr) {
                    this.zzCf = zzhhVarZzb;
                    if (this.zzCf == null) {
                        throw new zza("Could not start the ad request service.", 0);
                    }
                }
                zzi(jElapsedRealtime2);
                jElapsedRealtime = zzo.zzbz().elapsedRealtime();
                zzfu();
                adSizeParcelZzc = adRequestInfoParcel.zzpN.zzso != null ? zzc(adRequestInfoParcel) : null;
            } catch (zza e) {
                e = e;
                adSizeParcelZzc = null;
            }
            try {
                zzw(this.zzBt.zzCU);
                j = jElapsedRealtime;
            } catch (zza e2) {
                e = e2;
                errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaA(e.getMessage());
                } else {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaC(e.getMessage());
                }
                if (this.zzBt == null) {
                    this.zzBt = new AdResponseParcel(errorCode);
                } else {
                    this.zzBt = new AdResponseParcel(errorCode, this.zzBt.zzxJ);
                }
                zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.ads.internal.request.zzb.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zzb.this.onStop();
                    }
                });
                j = jElapsedRealtime;
            }
            if (TextUtils.isEmpty(this.zzBt.zzCS)) {
                jSONObject = null;
            } else {
                try {
                    jSONObject = new JSONObject(this.zzBt.zzCS);
                } catch (Exception e3) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzb("Error parsing the JSON for Active View.", e3);
                    jSONObject = null;
                }
            }
            final zzha.zza zzaVar = new zzha.zza(adRequestInfoParcel, this.zzBt, this.zzxn, adSizeParcelZzc, errorCode, j, this.zzBt.zzCO, jSONObject);
            zzhl.zzGk.post(new Runnable() { // from class: com.google.android.gms.ads.internal.request.zzb.2
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (zzb.this.zzqt) {
                        zzb.this.zzCd.zza(zzaVar);
                    }
                }
            });
        }
    }

    protected boolean zze(long j) throws zza {
        long jElapsedRealtime = 60000 - (zzo.zzbz().elapsedRealtime() - j);
        if (jElapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzqt.wait(jElapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            throw new zza("Ad request cancelled.", -1);
        }
    }

    protected void zzfu() throws zza {
        if (this.zzBt.errorCode == -3) {
            return;
        }
        if (TextUtils.isEmpty(this.zzBt.zzCI)) {
            throw new zza("No fill from ad server.", 3);
        }
        zzo.zzby().zza(this.mContext, this.zzBt.zzCu);
        if (this.zzBt.zzCK) {
            try {
                this.zzxn = new zzdy(this.zzBt.zzCI);
            } catch (JSONException e) {
                throw new zza("Could not parse mediation config: " + this.zzBt.zzCI, 0);
            }
        }
    }

    protected void zzi(long j) throws zza {
        while (zze(j)) {
            if (this.zzBt != null) {
                synchronized (this.zzBr) {
                    this.zzCf = null;
                }
                if (this.zzBt.errorCode != -2 && this.zzBt.errorCode != -3) {
                    throw new zza("There was a problem getting an ad response. ErrorCode: " + this.zzBt.errorCode, this.zzBt.errorCode);
                }
                return;
            }
        }
        throw new zza("Timed out waiting for ad response.", 2);
    }

    protected void zzw(boolean z) {
        zzo.zzby().zzA(z);
        zzbk zzbkVarZzD = zzo.zzby().zzD(this.mContext);
        if (zzbkVarZzD == null || zzbkVarZzD.isAlive()) {
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzay("start fetching content...");
        zzbkVarZzD.zzcp();
    }
}
