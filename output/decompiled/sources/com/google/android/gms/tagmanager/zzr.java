package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzr extends zzcz {

    /* JADX INFO: renamed from: ID */
    private static final String f61ID = com.google.android.gms.internal.zzad.CONTAINS.toString();

    public zzr() {
        super(f61ID);
    }

    @Override // com.google.android.gms.tagmanager.zzcz
    protected boolean zza(String str, String str2, Map<String, zzag.zza> map) {
        return str.contains(str2);
    }
}
