package com.google.android.gms.ads.internal.purchase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import com.google.android.gms.internal.zzgd;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzh {
    private static zzh zzAZ;
    private final zza zzAY;
    private static final String zzAX = String.format("CREATE TABLE IF NOT EXISTS %s ( %s INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, %s TEXT NOT NULL, %s TEXT NOT NULL, %s INTEGER)", "InAppPurchase", "purchase_id", "product_id", "developer_payload", "record_time");
    private static final Object zzqt = new Object();

    public class zza extends SQLiteOpenHelper {
        public zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(zzh.zzAX);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaA("Database updated from version " + oldVersion + " to version " + newVersion);
            db.execSQL("DROP TABLE IF EXISTS InAppPurchase");
            onCreate(db);
        }
    }

    zzh(Context context) {
        this.zzAY = new zza(context, "google_inapp_purchase.db");
    }

    public static zzh zzy(Context context) {
        zzh zzhVar;
        synchronized (zzqt) {
            if (zzAZ == null) {
                zzAZ = new zzh(context);
            }
            zzhVar = zzAZ;
        }
        return zzhVar;
    }

    public int getRecordCount() {
        Cursor cursorRawQuery = null;
        int i = 0;
        synchronized (zzqt) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            try {
                if (writableDatabase != null) {
                    try {
                        cursorRawQuery = writableDatabase.rawQuery("select count(*) from InAppPurchase", null);
                        if (cursorRawQuery.moveToFirst()) {
                            i = cursorRawQuery.getInt(0);
                        } else if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    } catch (SQLiteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Error getting record count" + e.getMessage());
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                    }
                }
            } finally {
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            }
        }
        return i;
    }

    public SQLiteDatabase getWritableDatabase() {
        try {
            return this.zzAY.getWritableDatabase();
        } catch (SQLiteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Error opening writable conversion tracking database");
            return null;
        }
    }

    public zzf zza(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        return new zzf(cursor.getLong(0), cursor.getString(1), cursor.getString(2));
    }

    public void zza(zzf zzfVar) {
        if (zzfVar == null) {
            return;
        }
        synchronized (zzqt) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("InAppPurchase", String.format("%s = %d", "purchase_id", Long.valueOf(zzfVar.zzAR)), null);
            }
        }
    }

    public void zzb(zzf zzfVar) {
        if (zzfVar == null) {
            return;
        }
        synchronized (zzqt) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("product_id", zzfVar.zzAT);
            contentValues.put("developer_payload", zzfVar.zzAS);
            contentValues.put("record_time", Long.valueOf(SystemClock.elapsedRealtime()));
            zzfVar.zzAR = writableDatabase.insert("InAppPurchase", null, contentValues);
            if (getRecordCount() > 20000) {
                zzfg();
            }
        }
    }

    public List<zzf> zzf(long j) {
        Cursor cursorQuery;
        Cursor cursor = null;
        synchronized (zzqt) {
            LinkedList linkedList = new LinkedList();
            if (j <= 0) {
                return linkedList;
            }
            SQLiteDatabase writableDatabase = getWritableDatabase();
            try {
                if (writableDatabase == null) {
                    return linkedList;
                }
                try {
                    cursorQuery = writableDatabase.query("InAppPurchase", null, null, null, null, null, "record_time ASC", String.valueOf(j));
                    try {
                        if (cursorQuery.moveToFirst()) {
                            do {
                                linkedList.add(zza(cursorQuery));
                            } while (cursorQuery.moveToNext());
                        }
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    } catch (SQLiteException e) {
                        e = e;
                        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Error extracing purchase info: " + e.getMessage());
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                } catch (SQLiteException e2) {
                    e = e2;
                    cursorQuery = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor.close();
                    }
                    throw th;
                }
                return linkedList;
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005a A[Catch: all -> 0x0031, TryCatch #0 {, blocks: (B:4:0x0004, B:6:0x000a, B:14:0x002c, B:15:0x002f, B:28:0x005a, B:29:0x005d, B:24:0x0052), top: B:34:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void zzfg() {
        Cursor cursorQuery;
        synchronized (zzqt) {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (writableDatabase == null) {
                return;
            }
            try {
                cursorQuery = writableDatabase.query("InAppPurchase", null, null, null, null, null, "record_time ASC", "1");
                if (cursorQuery != null) {
                    try {
                        try {
                            if (cursorQuery.moveToFirst()) {
                                zza(zza(cursorQuery));
                            }
                        } catch (SQLiteException e) {
                            e = e;
                            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Error remove oldest record" + e.getMessage());
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        throw th;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (SQLiteException e2) {
                e = e2;
                cursorQuery = null;
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
                if (cursorQuery != null) {
                }
                throw th;
            }
        }
    }
}
