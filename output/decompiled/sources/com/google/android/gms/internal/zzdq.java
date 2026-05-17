package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzdq implements Iterable<zzdp> {
    private final List<zzdp> zzwE = new LinkedList();

    private zzdp zzc(zzid zzidVar) {
        for (zzdp zzdpVar : com.google.android.gms.ads.internal.zzo.zzbH()) {
            if (zzdpVar.zzoA == zzidVar) {
                return zzdpVar;
            }
        }
        return null;
    }

    @Override // java.lang.Iterable
    public Iterator<zzdp> iterator() {
        return this.zzwE.iterator();
    }

    public void zza(zzdp zzdpVar) {
        this.zzwE.add(zzdpVar);
    }

    public boolean zza(zzid zzidVar) {
        zzdp zzdpVarZzc = zzc(zzidVar);
        if (zzdpVarZzc == null) {
            return false;
        }
        zzdpVarZzc.zzwB.abort();
        return true;
    }

    public void zzb(zzdp zzdpVar) {
        this.zzwE.remove(zzdpVar);
    }

    public boolean zzb(zzid zzidVar) {
        return zzc(zzidVar) != null;
    }
}
