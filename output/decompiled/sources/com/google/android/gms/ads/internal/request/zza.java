package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzgd;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzhh;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zza {

    /* JADX INFO: renamed from: com.google.android.gms.ads.internal.request.zza$zza, reason: collision with other inner class name */
    public interface InterfaceC1157zza {
        void zza(zzha.zza zzaVar);
    }

    public zzhh zza(Context context, AdRequestInfoParcel.zza zzaVar, zzan zzanVar, InterfaceC1157zza interfaceC1157zza) {
        zzhh zzbVar = (!zzbz.zzuu.get().booleanValue() || zzaVar.zzCm.extras.getBundle("sdk_less_server_data") == null) ? new zzb(context, zzaVar, zzanVar, interfaceC1157zza) : new zzl(context, zzaVar, interfaceC1157zza);
        zzbVar.zzgj();
        return zzbVar;
    }
}
