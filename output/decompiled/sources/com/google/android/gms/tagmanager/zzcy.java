package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzcy extends zzcz {

    /* JADX INFO: renamed from: ID */
    private static final String f48ID = com.google.android.gms.internal.zzad.STARTS_WITH.toString();

    public zzcy() {
        super(f48ID);
    }

    @Override // com.google.android.gms.tagmanager.zzcz
    protected boolean zza(String str, String str2, Map<String, zzag.zza> map) {
        return str.startsWith(str2);
    }
}
