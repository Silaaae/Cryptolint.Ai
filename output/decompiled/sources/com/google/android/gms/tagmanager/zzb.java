package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzb extends zzak {

    /* JADX INFO: renamed from: ID */
    private static final String f33ID = com.google.android.gms.internal.zzad.ADVERTISER_ID.toString();
    private final zza zzaKo;

    public zzb(Context context) {
        this(zza.zzaE(context));
    }

    zzb(zza zzaVar) {
        super(f33ID, new String[0]);
        this.zzaKo = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        String strZzyd = this.zzaKo.zzyd();
        return strZzyd == null ? zzdf.zzzQ() : zzdf.zzI(strZzyd);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return false;
    }
}
