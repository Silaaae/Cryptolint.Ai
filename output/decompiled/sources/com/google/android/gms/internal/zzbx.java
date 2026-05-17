package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzbx {
    public SharedPreferences zzv(Context context) {
        return context.getSharedPreferences("google_ads_flags", 1);
    }
}
