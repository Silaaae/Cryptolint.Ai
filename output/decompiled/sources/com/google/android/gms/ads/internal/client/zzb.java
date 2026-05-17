package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.internal.zzgd;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public final class zzb extends zzm.zza {
    private final zza zzrU;

    public zzb(zza zzaVar) {
        this.zzrU = zzaVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzm
    public void onAdClicked() {
        this.zzrU.onAdClicked();
    }
}
