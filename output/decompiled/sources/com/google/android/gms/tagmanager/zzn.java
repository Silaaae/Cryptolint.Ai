package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzn extends zzak {

    /* JADX INFO: renamed from: ID */
    private static final String f59ID = com.google.android.gms.internal.zzad.CONSTANT.toString();
    private static final String VALUE = com.google.android.gms.internal.zzae.VALUE.toString();

    public zzn() {
        super(f59ID, VALUE);
    }

    public static String zzyk() {
        return f59ID;
    }

    public static String zzyl() {
        return VALUE;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        return map.get(VALUE);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
