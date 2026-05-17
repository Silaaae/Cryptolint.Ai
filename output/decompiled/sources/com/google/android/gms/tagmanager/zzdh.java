package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzdh extends zzak {

    /* JADX INFO: renamed from: ID */
    private static final String f52ID = com.google.android.gms.internal.zzad.UPPERCASE_STRING.toString();
    private static final String zzaLE = com.google.android.gms.internal.zzae.ARG0.toString();

    public zzdh() {
        super(f52ID, zzaLE);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        return zzdf.zzI(zzdf.zzg(map.get(zzaLE)).toUpperCase());
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
