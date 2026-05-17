package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.plus.PlusShare;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class zzay extends zzak {

    /* JADX INFO: renamed from: ID */
    private static final String f32ID = com.google.android.gms.internal.zzad.JOINER.toString();
    private static final String zzaLE = com.google.android.gms.internal.zzae.ARG0.toString();
    private static final String zzaLW = com.google.android.gms.internal.zzae.ITEM_SEPARATOR.toString();
    private static final String zzaLX = com.google.android.gms.internal.zzae.KEY_VALUE_SEPARATOR.toString();
    private static final String zzaLY = com.google.android.gms.internal.zzae.ESCAPE.toString();

    private enum zza {
        NONE,
        URL,
        BACKSLASH
    }

    public zzay() {
        super(f32ID, zzaLE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        com.google.android.gms.tagmanager.zzbg.zzb("Joiner: unsupported encoding", r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String zza(String str, zza zzaVar, Set<Character> set) {
        switch (zzaVar) {
            case BACKSLASH:
                String strReplace = str.replace("\\", "\\\\");
                Iterator<Character> it = set.iterator();
                while (true) {
                    String str2 = strReplace;
                    if (it.hasNext()) {
                        String string = it.next().toString();
                        strReplace = str2.replace(string, "\\" + string);
                    }
                    break;
                }
                break;
        }
        return str;
    }

    private void zza(StringBuilder sb, String str, zza zzaVar, Set<Character> set) {
        sb.append(zza(str, zzaVar, set));
    }

    private void zza(Set<Character> set, String str) {
        for (int i = 0; i < str.length(); i++) {
            set.add(Character.valueOf(str.charAt(i)));
        }
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public zzag.zza zzE(Map<String, zzag.zza> map) {
        HashSet hashSet;
        zza zzaVar;
        zzag.zza zzaVar2 = map.get(zzaLE);
        if (zzaVar2 == null) {
            return zzdf.zzzQ();
        }
        zzag.zza zzaVar3 = map.get(zzaLW);
        String strZzg = zzaVar3 != null ? zzdf.zzg(zzaVar3) : "";
        zzag.zza zzaVar4 = map.get(zzaLX);
        String strZzg2 = zzaVar4 != null ? zzdf.zzg(zzaVar4) : "=";
        zza zzaVar5 = zza.NONE;
        zzag.zza zzaVar6 = map.get(zzaLY);
        if (zzaVar6 != null) {
            String strZzg3 = zzdf.zzg(zzaVar6);
            if (PlusShare.KEY_CALL_TO_ACTION_URL.equals(strZzg3)) {
                zzaVar = zza.URL;
                hashSet = null;
            } else {
                if (!"backslash".equals(strZzg3)) {
                    zzbg.zzaz("Joiner: unsupported escape type: " + strZzg3);
                    return zzdf.zzzQ();
                }
                zzaVar = zza.BACKSLASH;
                hashSet = new HashSet();
                zza(hashSet, strZzg);
                zza(hashSet, strZzg2);
                hashSet.remove('\\');
            }
        } else {
            hashSet = null;
            zzaVar = zzaVar5;
        }
        StringBuilder sb = new StringBuilder();
        switch (zzaVar2.type) {
            case 2:
                boolean z = true;
                zzag.zza[] zzaVarArr = zzaVar2.zziS;
                int length = zzaVarArr.length;
                int i = 0;
                while (i < length) {
                    zzag.zza zzaVar7 = zzaVarArr[i];
                    if (!z) {
                        sb.append(strZzg);
                    }
                    zza(sb, zzdf.zzg(zzaVar7), zzaVar, hashSet);
                    i++;
                    z = false;
                }
                break;
            case 3:
                for (int i2 = 0; i2 < zzaVar2.zziT.length; i2++) {
                    if (i2 > 0) {
                        sb.append(strZzg);
                    }
                    String strZzg4 = zzdf.zzg(zzaVar2.zziT[i2]);
                    String strZzg5 = zzdf.zzg(zzaVar2.zziU[i2]);
                    zza(sb, strZzg4, zzaVar, hashSet);
                    sb.append(strZzg2);
                    zza(sb, strZzg5, zzaVar, hashSet);
                }
                break;
            default:
                zza(sb, zzdf.zzg(zzaVar2), zzaVar, hashSet);
                break;
        }
        return zzdf.zzI(sb.toString());
    }

    @Override // com.google.android.gms.tagmanager.zzak
    public boolean zzyh() {
        return true;
    }
}
