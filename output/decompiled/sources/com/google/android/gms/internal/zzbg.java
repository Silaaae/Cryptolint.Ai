package com.google.android.gms.internal;

import java.util.AbstractMap;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zzbg implements zzbf {
    private final zzbe zzrh;
    private final HashSet<AbstractMap.SimpleEntry<String, zzdg>> zzri = new HashSet<>();

    public zzbg(zzbe zzbeVar) {
        this.zzrh = zzbeVar;
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zza(String str, zzdg zzdgVar) {
        this.zzrh.zza(str, zzdgVar);
        this.zzri.add(new AbstractMap.SimpleEntry<>(str, zzdgVar));
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zza(String str, String str2) {
        this.zzrh.zza(str, str2);
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zza(String str, JSONObject jSONObject) {
        this.zzrh.zza(str, jSONObject);
    }

    @Override // com.google.android.gms.internal.zzbe
    public void zzb(String str, zzdg zzdgVar) {
        this.zzrh.zzb(str, zzdgVar);
        this.zzri.remove(new AbstractMap.SimpleEntry(str, zzdgVar));
    }

    @Override // com.google.android.gms.internal.zzbf
    public void zzcg() {
        for (AbstractMap.SimpleEntry<String, zzdg> simpleEntry : this.zzri) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaB("Unregistering eventhandler: " + simpleEntry.getValue().toString());
            this.zzrh.zzb(simpleEntry.getKey(), simpleEntry.getValue());
        }
        this.zzri.clear();
    }
}
