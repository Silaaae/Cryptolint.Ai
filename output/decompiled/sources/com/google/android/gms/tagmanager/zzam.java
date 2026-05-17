package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzam extends zzbv {

    /* JADX INFO: renamed from: ID */
    private static final String f27ID = com.google.android.gms.internal.zzad.GREATER_EQUALS.toString();

    public zzam() {
        super(f27ID);
    }

    @Override // com.google.android.gms.tagmanager.zzbv
    protected boolean zza(zzde zzdeVar, zzde zzdeVar2, Map<String, zzag.zza> map) {
        return zzdeVar.compareTo(zzdeVar2) >= 0;
    }
}
