package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzc extends zzak {

    /* JADX INFO: renamed from: ID */
    private static final String f41ID = com.google.android.gms.internal.zzad.ADVERTISING_TRACKING_ENABLED.toString();
    private final zza zzaKo;

    public zzc(Context context) {
        this(zza.zzaE(context));
    }

    zzc(zza zzaVar) {
        super(f41ID, new String[0]);
        this.zzaKo = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        return zzdf.zzI(Boolean.valueOf(!this.zzaKo.isLimitAdTrackingEnabled()));
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return false;
    }
}
