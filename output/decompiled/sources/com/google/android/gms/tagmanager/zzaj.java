package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class zzaj {
    private static void zza(DataLayer dataLayer, zzaf.zzd zzdVar) {
        for (zzag.zza zzaVar : zzdVar.zzhX) {
            dataLayer.zzen(zzdf.zzg(zzaVar));
        }
    }

    public static void zza(DataLayer dataLayer, zzaf.zzi zziVar) {
        if (zziVar.zziM == null) {
            zzbg.zzaC("supplemental missing experimentSupplemental");
            return;
        }
        zza(dataLayer, zziVar.zziM);
        zzb(dataLayer, zziVar.zziM);
        zzc(dataLayer, zziVar.zziM);
    }

    private static void zzb(DataLayer dataLayer, zzaf.zzd zzdVar) {
        for (zzag.zza zzaVar : zzdVar.zzhW) {
            Map<String, Object> mapZzc = zzc(zzaVar);
            if (mapZzc != null) {
                dataLayer.push(mapZzc);
            }
        }
    }

    private static Map<String, Object> zzc(zzag.zza zzaVar) {
        Object objZzl = zzdf.zzl(zzaVar);
        if (objZzl instanceof Map) {
            return (Map) objZzl;
        }
        zzbg.zzaC("value: " + objZzl + " is not a map value, ignored.");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zzc(DataLayer dataLayer, zzaf.zzd zzdVar) {
        for (zzaf.zzc zzcVar : zzdVar.zzhY) {
            if (zzcVar.zzaC == null) {
                zzbg.zzaC("GaExperimentRandom: No key");
            } else {
                Object objValueOf = dataLayer.get(zzcVar.zzaC);
                Long lValueOf = !(objValueOf instanceof Number) ? null : Long.valueOf(((Number) objValueOf).longValue());
                long j = zzcVar.zzhS;
                long j2 = zzcVar.zzhT;
                if (zzcVar.zzhU && lValueOf != null && lValueOf.longValue() >= j && lValueOf.longValue() <= j2) {
                    dataLayer.zzen(zzcVar.zzaC);
                    Map<String, Object> mapZzj = dataLayer.zzj(zzcVar.zzaC, objValueOf);
                    if (zzcVar.zzhV > 0) {
                    }
                    dataLayer.push(mapZzj);
                } else if (j <= j2) {
                    objValueOf = Long.valueOf(Math.round((Math.random() * (j2 - j)) + j));
                    dataLayer.zzen(zzcVar.zzaC);
                    Map<String, Object> mapZzj2 = dataLayer.zzj(zzcVar.zzaC, objValueOf);
                    if (zzcVar.zzhV > 0) {
                        if (mapZzj2.containsKey("gtm")) {
                            Object obj = mapZzj2.get("gtm");
                            if (obj instanceof Map) {
                                ((Map) obj).put("lifetime", Long.valueOf(zzcVar.zzhV));
                            } else {
                                zzbg.zzaC("GaExperimentRandom: gtm not a map");
                            }
                        } else {
                            mapZzj2.put("gtm", DataLayer.mapOf("lifetime", Long.valueOf(zzcVar.zzhV)));
                        }
                    }
                    dataLayer.push(mapZzj2);
                } else {
                    zzbg.zzaC("GaExperimentRandom: random range invalid");
                }
            }
        }
    }
}
