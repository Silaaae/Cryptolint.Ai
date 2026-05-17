package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzaf extends zzcz {

    /* JADX INFO: renamed from: ID */
    private static final String f25ID = com.google.android.gms.internal.zzad.EQUALS.toString();

    public zzaf() {
        super(f25ID);
    }

    @Override // com.google.android.gms.tagmanager.zzcz
    protected boolean zza(String str, String str2, Map<String, zzag.zza> map) {
        return str.equals(str2);
    }
}
