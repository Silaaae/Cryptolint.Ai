package com.google.android.gms.internal;

import com.google.android.gms.internal.zzrc;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzrb {

    public static class zza {
        public final zzrc zzaVj;
        public final List<Asset> zzaVk;

        public zza(zzrc zzrcVar, List<Asset> list) {
            this.zzaVj = zzrcVar;
            this.zzaVk = list;
        }
    }

    private static int zza(String str, zzrc.zza.C1296zza[] c1296zzaArr) {
        int i = 14;
        for (zzrc.zza.C1296zza c1296zza : c1296zzaArr) {
            if (i != 14) {
                if (c1296zza.type != i) {
                    throw new IllegalArgumentException("The ArrayList elements should all be the same type, but ArrayList with key " + str + " contains items of type " + i + " and " + c1296zza.type);
                }
            } else if (c1296zza.type == 9 || c1296zza.type == 2 || c1296zza.type == 6) {
                i = c1296zza.type;
            } else if (c1296zza.type != 14) {
                throw new IllegalArgumentException("Unexpected TypedValue type: " + c1296zza.type + " for key " + str);
            }
        }
        return i;
    }

    static int zza(List<Asset> list, Asset asset) {
        list.add(asset);
        return list.size() - 1;
    }

    public static zza zza(DataMap dataMap) {
        zzrc zzrcVar = new zzrc();
        ArrayList arrayList = new ArrayList();
        zzrcVar.zzaVl = zza(dataMap, arrayList);
        return new zza(zzrcVar, arrayList);
    }

    private static zzrc.zza.C1296zza zza(List<Asset> list, Object obj) {
        int i;
        int i2 = 0;
        zzrc.zza.C1296zza c1296zza = new zzrc.zza.C1296zza();
        if (obj == null) {
            c1296zza.type = 14;
            return c1296zza;
        }
        c1296zza.zzaVp = new zzrc.zza.C1296zza.C1297zza();
        if (obj instanceof String) {
            c1296zza.type = 2;
            c1296zza.zzaVp.zzaVr = (String) obj;
        } else if (obj instanceof Integer) {
            c1296zza.type = 6;
            c1296zza.zzaVp.zzaVv = ((Integer) obj).intValue();
        } else if (obj instanceof Long) {
            c1296zza.type = 5;
            c1296zza.zzaVp.zzaVu = ((Long) obj).longValue();
        } else if (obj instanceof Double) {
            c1296zza.type = 3;
            c1296zza.zzaVp.zzaVs = ((Double) obj).doubleValue();
        } else if (obj instanceof Float) {
            c1296zza.type = 4;
            c1296zza.zzaVp.zzaVt = ((Float) obj).floatValue();
        } else if (obj instanceof Boolean) {
            c1296zza.type = 8;
            c1296zza.zzaVp.zzaVx = ((Boolean) obj).booleanValue();
        } else if (obj instanceof Byte) {
            c1296zza.type = 7;
            c1296zza.zzaVp.zzaVw = ((Byte) obj).byteValue();
        } else if (obj instanceof byte[]) {
            c1296zza.type = 1;
            c1296zza.zzaVp.zzaVq = (byte[]) obj;
        } else if (obj instanceof String[]) {
            c1296zza.type = 11;
            c1296zza.zzaVp.zzaVA = (String[]) obj;
        } else if (obj instanceof long[]) {
            c1296zza.type = 12;
            c1296zza.zzaVp.zzaVB = (long[]) obj;
        } else if (obj instanceof float[]) {
            c1296zza.type = 15;
            c1296zza.zzaVp.zzaVC = (float[]) obj;
        } else if (obj instanceof Asset) {
            c1296zza.type = 13;
            c1296zza.zzaVp.zzaVD = zza(list, (Asset) obj);
        } else if (obj instanceof DataMap) {
            c1296zza.type = 9;
            DataMap dataMap = (DataMap) obj;
            Set<String> setKeySet = dataMap.keySet();
            zzrc.zza[] zzaVarArr = new zzrc.zza[setKeySet.size()];
            Iterator<String> it = setKeySet.iterator();
            while (true) {
                int i3 = i2;
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                zzaVarArr[i3] = new zzrc.zza();
                zzaVarArr[i3].name = next;
                zzaVarArr[i3].zzaVn = zza(list, dataMap.get(next));
                i2 = i3 + 1;
            }
            c1296zza.zzaVp.zzaVy = zzaVarArr;
        } else {
            if (!(obj instanceof ArrayList)) {
                throw new RuntimeException("newFieldValueFromValue: unexpected value " + obj.getClass().getSimpleName());
            }
            c1296zza.type = 10;
            ArrayList arrayList = (ArrayList) obj;
            zzrc.zza.C1296zza[] c1296zzaArr = new zzrc.zza.C1296zza[arrayList.size()];
            Object obj2 = null;
            int size = arrayList.size();
            int i4 = 0;
            int i5 = 14;
            while (i4 < size) {
                Object obj3 = arrayList.get(i4);
                zzrc.zza.C1296zza c1296zzaZza = zza(list, obj3);
                if (c1296zzaZza.type != 14 && c1296zzaZza.type != 2 && c1296zzaZza.type != 6 && c1296zzaZza.type != 9) {
                    throw new IllegalArgumentException("The only ArrayList element types supported by DataBundleUtil are String, Integer, Bundle, and null, but this ArrayList contains a " + obj3.getClass());
                }
                if (i5 == 14 && c1296zzaZza.type != 14) {
                    i = c1296zzaZza.type;
                } else {
                    if (c1296zzaZza.type != i5) {
                        throw new IllegalArgumentException("ArrayList elements must all be of the sameclass, but this one contains a " + obj2.getClass() + " and a " + obj3.getClass());
                    }
                    obj3 = obj2;
                    i = i5;
                }
                c1296zzaArr[i4] = c1296zzaZza;
                i4++;
                i5 = i;
                obj2 = obj3;
            }
            c1296zza.zzaVp.zzaVz = c1296zzaArr;
        }
        return c1296zza;
    }

    public static DataMap zza(zza zzaVar) {
        DataMap dataMap = new DataMap();
        for (zzrc.zza zzaVar2 : zzaVar.zzaVj.zzaVl) {
            zza(zzaVar.zzaVk, dataMap, zzaVar2.name, zzaVar2.zzaVn);
        }
        return dataMap;
    }

    private static ArrayList zza(List<Asset> list, zzrc.zza.C1296zza.C1297zza c1297zza, int i) {
        ArrayList arrayList = new ArrayList(c1297zza.zzaVz.length);
        for (zzrc.zza.C1296zza c1296zza : c1297zza.zzaVz) {
            if (c1296zza.type == 14) {
                arrayList.add(null);
            } else if (i == 9) {
                DataMap dataMap = new DataMap();
                zzrc.zza[] zzaVarArr = c1296zza.zzaVp.zzaVy;
                for (zzrc.zza zzaVar : zzaVarArr) {
                    zza(list, dataMap, zzaVar.name, zzaVar.zzaVn);
                }
                arrayList.add(dataMap);
            } else if (i == 2) {
                arrayList.add(c1296zza.zzaVp.zzaVr);
            } else {
                if (i != 6) {
                    throw new IllegalArgumentException("Unexpected typeOfArrayList: " + i);
                }
                arrayList.add(Integer.valueOf(c1296zza.zzaVp.zzaVv));
            }
        }
        return arrayList;
    }

    private static void zza(List<Asset> list, DataMap dataMap, String str, zzrc.zza.C1296zza c1296zza) {
        int i = c1296zza.type;
        if (i == 14) {
            dataMap.putString(str, null);
            return;
        }
        zzrc.zza.C1296zza.C1297zza c1297zza = c1296zza.zzaVp;
        if (i == 1) {
            dataMap.putByteArray(str, c1297zza.zzaVq);
            return;
        }
        if (i == 11) {
            dataMap.putStringArray(str, c1297zza.zzaVA);
            return;
        }
        if (i == 12) {
            dataMap.putLongArray(str, c1297zza.zzaVB);
            return;
        }
        if (i == 15) {
            dataMap.putFloatArray(str, c1297zza.zzaVC);
            return;
        }
        if (i == 2) {
            dataMap.putString(str, c1297zza.zzaVr);
            return;
        }
        if (i == 3) {
            dataMap.putDouble(str, c1297zza.zzaVs);
            return;
        }
        if (i == 4) {
            dataMap.putFloat(str, c1297zza.zzaVt);
            return;
        }
        if (i == 5) {
            dataMap.putLong(str, c1297zza.zzaVu);
            return;
        }
        if (i == 6) {
            dataMap.putInt(str, c1297zza.zzaVv);
            return;
        }
        if (i == 7) {
            dataMap.putByte(str, (byte) c1297zza.zzaVw);
            return;
        }
        if (i == 8) {
            dataMap.putBoolean(str, c1297zza.zzaVx);
            return;
        }
        if (i == 13) {
            if (list == null) {
                throw new RuntimeException("populateBundle: unexpected type for: " + str);
            }
            dataMap.putAsset(str, list.get((int) c1297zza.zzaVD));
            return;
        }
        if (i == 9) {
            DataMap dataMap2 = new DataMap();
            for (zzrc.zza zzaVar : c1297zza.zzaVy) {
                zza(list, dataMap2, zzaVar.name, zzaVar.zzaVn);
            }
            dataMap.putDataMap(str, dataMap2);
            return;
        }
        if (i != 10) {
            throw new RuntimeException("populateBundle: unexpected type " + i);
        }
        int iZza = zza(str, c1297zza.zzaVz);
        ArrayList<Integer> arrayListZza = zza(list, c1297zza, iZza);
        if (iZza == 14) {
            dataMap.putStringArrayList(str, arrayListZza);
            return;
        }
        if (iZza == 9) {
            dataMap.putDataMapArrayList(str, arrayListZza);
        } else if (iZza == 2) {
            dataMap.putStringArrayList(str, arrayListZza);
        } else {
            if (iZza != 6) {
                throw new IllegalStateException("Unexpected typeOfArrayList: " + iZza);
            }
            dataMap.putIntegerArrayList(str, arrayListZza);
        }
    }

    private static zzrc.zza[] zza(DataMap dataMap, List<Asset> list) {
        Set<String> setKeySet = dataMap.keySet();
        zzrc.zza[] zzaVarArr = new zzrc.zza[setKeySet.size()];
        int i = 0;
        Iterator<String> it = setKeySet.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return zzaVarArr;
            }
            String next = it.next();
            Object obj = dataMap.get(next);
            zzaVarArr[i2] = new zzrc.zza();
            zzaVarArr[i2].name = next;
            zzaVarArr[i2].zzaVn = zza(list, obj);
            i = i2 + 1;
        }
    }
}
