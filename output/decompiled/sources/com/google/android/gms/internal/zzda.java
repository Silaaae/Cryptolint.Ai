package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.internal.zzcv;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzda extends zzcv.zza {
    private final NativeContentAd.OnContentAdLoadedListener zzvR;

    public zzda(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzvR = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.zzcv
    public void zza(zzcq zzcqVar) {
        this.zzvR.onContentAdLoaded(zzb(zzcqVar));
    }

    zzcr zzb(zzcq zzcqVar) {
        return new zzcr(zzcqVar);
    }
}
