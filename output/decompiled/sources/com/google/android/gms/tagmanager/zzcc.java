package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzcc extends zzak {

    /* JADX INFO: renamed from: ID */
    private static final String f42ID = com.google.android.gms.internal.zzad.RANDOM.toString();
    private static final String zzaMM = com.google.android.gms.internal.zzae.MIN.toString();
    private static final String zzaMN = com.google.android.gms.internal.zzae.MAX.toString();

    public zzcc() {
        super(f42ID, new String[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005c  */
    @Override // com.google.android.gms.tagmanager.zzak
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        double dDoubleValue;
        double d;
        zzag.zza zzaVar = map.get(zzaMM);
        zzag.zza zzaVar2 = map.get(zzaMN);
        if (zzaVar == null || zzaVar == zzdf.zzzQ() || zzaVar2 == null || zzaVar2 == zzdf.zzzQ()) {
            dDoubleValue = 2.147483647E9d;
            d = 0.0d;
        } else {
            zzde zzdeVarZzh = zzdf.zzh(zzaVar);
            zzde zzdeVarZzh2 = zzdf.zzh(zzaVar2);
            if (zzdeVarZzh != zzdf.zzzO() && zzdeVarZzh2 != zzdf.zzzO()) {
                double dDoubleValue2 = zzdeVarZzh.doubleValue();
                dDoubleValue = zzdeVarZzh2.doubleValue();
                if (dDoubleValue2 <= dDoubleValue) {
                    d = dDoubleValue2;
                }
            }
        }
        return zzdf.zzI(Long.valueOf(Math.round(((dDoubleValue - d) * Math.random()) + d)));
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return false;
    }
}
