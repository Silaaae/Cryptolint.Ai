package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzcr extends zzak {

    /* JADX INFO: renamed from: ID */
    private static final String f47ID = com.google.android.gms.internal.zzad.SDK_VERSION.toString();

    public zzcr() {
        super(f47ID, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        return zzdf.zzI(Integer.valueOf(Build.VERSION.SDK_INT));
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
