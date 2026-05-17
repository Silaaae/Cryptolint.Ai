package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzh extends zzak {

    /* JADX INFO: renamed from: ID */
    private static final String f56ID = com.google.android.gms.internal.zzad.APP_VERSION.toString();
    private final Context mContext;

    public zzh(Context context) {
        super(f56ID, new String[0]);
        this.mContext = context;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        try {
            return zzdf.zzI(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
        } catch (PackageManager.NameNotFoundException e) {
            zzbg.zzaz("Package name " + this.mContext.getPackageName() + " not found. " + e.getMessage());
            return zzdf.zzzQ();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
