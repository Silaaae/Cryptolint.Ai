package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzbi extends zzak {

    /* JADX INFO: renamed from: ID */
    private static final String f37ID = com.google.android.gms.internal.zzad.LOWERCASE_STRING.toString();
    private static final String zzaLE = com.google.android.gms.internal.zzae.ARG0.toString();

    public zzbi() {
        super(f37ID, zzaLE);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        return zzdf.zzI(zzdf.zzg(map.get(zzaLE)).toLowerCase());
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
