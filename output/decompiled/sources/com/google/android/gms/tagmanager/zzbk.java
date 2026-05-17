package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzbk extends zzak {

    /* JADX INFO: renamed from: ID */
    private static final String f38ID = com.google.android.gms.internal.zzad.MOBILE_ADWORDS_UNIQUE_ID.toString();
    private final Context mContext;

    public zzbk(Context context) {
        super(f38ID, new String[0]);
        this.mContext = context;
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        String strZzaG = zzaG(this.mContext);
        return strZzaG == null ? zzdf.zzzQ() : zzdf.zzI(strZzaG);
    }

    protected String zzaG(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
