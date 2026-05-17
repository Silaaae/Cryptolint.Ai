package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.tagmanager.zzcx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.apache.http.impl.client.DefaultHttpClient;

/* JADX INFO: loaded from: classes.dex */
class zzby implements zzau {
    private static final String zzKg = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL,'%s' INTEGER NOT NULL);", "gtm_hits", "hit_id", "hit_time", "hit_url", "hit_first_send_time");
    private final Context mContext;
    private final zzb zzaMs;
    private volatile zzac zzaMt;
    private final zzav zzaMu;
    private final String zzaMv;
    private long zzaMw;
    private final int zzaMx;
    private zzlb zzpw;

    class zza implements zzcx.zza {
        zza() {
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zza(zzaq zzaqVar) {
            zzby.this.zzq(zzaqVar.zzyO());
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zzb(zzaq zzaqVar) {
            zzby.this.zzq(zzaqVar.zzyO());
            zzbg.zzaB("Permanent failure dispatching hitId: " + zzaqVar.zzyO());
        }

        @Override // com.google.android.gms.tagmanager.zzcx.zza
        public void zzc(zzaq zzaqVar) {
            long jZzyP = zzaqVar.zzyP();
            if (jZzyP == 0) {
                zzby.this.zzd(zzaqVar.zzyO(), zzby.this.zzpw.currentTimeMillis());
            } else if (jZzyP + 14400000 < zzby.this.zzpw.currentTimeMillis()) {
                zzby.this.zzq(zzaqVar.zzyO());
                zzbg.zzaB("Giving up on failed hitId: " + zzaqVar.zzyO());
            }
        }
    }

    class zzb extends SQLiteOpenHelper {
        private long zzaMA;
        private boolean zzaMz;

        zzb(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
            this.zzaMA = 0L;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean zza(String str, SQLiteDatabase sQLiteDatabase) throws Throwable {
            Cursor cursor;
            Cursor cursor2 = null;
            try {
                Cursor cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                try {
                    boolean zMoveToFirst = cursorQuery.moveToFirst();
                    if (cursorQuery == null) {
                        return zMoveToFirst;
                    }
                    cursorQuery.close();
                    return zMoveToFirst;
                } catch (SQLiteException e) {
                    cursor = cursorQuery;
                    try {
                        zzbg.zzaC("Error querying for table " + str);
                        if (cursor != null) {
                            cursor.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        cursor2 = cursor;
                        th = th;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursorQuery;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            } catch (SQLiteException e2) {
                cursor = null;
            } catch (Throwable th3) {
                th = th3;
            }
        }

        private void zzc(SQLiteDatabase sQLiteDatabase) {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM gtm_hits WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str : cursorRawQuery.getColumnNames()) {
                    hashSet.add(str);
                }
                cursorRawQuery.close();
                if (!hashSet.remove("hit_id") || !hashSet.remove("hit_url") || !hashSet.remove("hit_time") || !hashSet.remove("hit_first_send_time")) {
                    throw new SQLiteException("Database column missing");
                }
                if (!hashSet.isEmpty()) {
                    throw new SQLiteException("Database has extra columns");
                }
            } catch (Throwable th) {
                cursorRawQuery.close();
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public SQLiteDatabase getWritableDatabase() {
            if (this.zzaMz && this.zzaMA + 3600000 > zzby.this.zzpw.currentTimeMillis()) {
                throw new SQLiteException("Database creation failed");
            }
            SQLiteDatabase writableDatabase = null;
            this.zzaMz = true;
            this.zzaMA = zzby.this.zzpw.currentTimeMillis();
            try {
                writableDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzby.this.mContext.getDatabasePath(zzby.this.zzaMv).delete();
            }
            if (writableDatabase == null) {
                writableDatabase = super.getWritableDatabase();
            }
            this.zzaMz = false;
            return writableDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase db) {
            zzal.zzbe(db.getPath());
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase db) {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor cursorRawQuery = db.rawQuery("PRAGMA journal_mode=memory", null);
                try {
                    cursorRawQuery.moveToFirst();
                } finally {
                    cursorRawQuery.close();
                }
            }
            if (zza("gtm_hits", db)) {
                zzc(db);
            } else {
                db.execSQL(zzby.zzKg);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    zzby(zzav zzavVar, Context context) {
        this(zzavVar, context, "gtm_urls.db", 2000);
    }

    zzby(zzav zzavVar, Context context, String str, int i) {
        this.mContext = context.getApplicationContext();
        this.zzaMv = str;
        this.zzaMu = zzavVar;
        this.zzpw = zzld.zzoQ();
        this.zzaMs = new zzb(this.mContext, this.zzaMv);
        this.zzaMt = new zzcx(new DefaultHttpClient(), this.mContext, new zza());
        this.zzaMw = 0L;
        this.zzaMx = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzd(long j, long j2) {
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for getNumStoredHits.");
        if (sQLiteDatabaseZzer == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_first_send_time", Long.valueOf(j2));
        try {
            sQLiteDatabaseZzer.update("gtm_hits", contentValues, "hit_id=?", new String[]{String.valueOf(j)});
        } catch (SQLiteException e) {
            zzbg.zzaC("Error setting HIT_FIRST_DISPATCH_TIME for hitId: " + j);
            zzq(j);
        }
    }

    private SQLiteDatabase zzer(String str) {
        try {
            return this.zzaMs.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaC(str);
            return null;
        }
    }

    private void zzh(long j, String str) {
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for putHit");
        if (sQLiteDatabaseZzer == null) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("hit_time", Long.valueOf(j));
        contentValues.put("hit_url", str);
        contentValues.put("hit_first_send_time", (Integer) 0);
        try {
            sQLiteDatabaseZzer.insert("gtm_hits", null, contentValues);
            this.zzaMu.zzan(false);
        } catch (SQLiteException e) {
            zzbg.zzaC("Error storing hit");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzq(long j) {
        zzf(new String[]{String.valueOf(j)});
    }

    private void zzzb() throws Throwable {
        int iZzzc = (zzzc() - this.zzaMx) + 1;
        if (iZzzc > 0) {
            List<String> listZziY = zziY(iZzzc);
            zzbg.zzaB("Store full, deleting " + listZziY.size() + " hits to make room.");
            zzf((String[]) listZziY.toArray(new String[0]));
        }
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public void dispatch() throws Throwable {
        zzbg.zzaB("GTM Dispatch running...");
        if (this.zzaMt.zzyH()) {
            List<zzaq> listZziZ = zziZ(40);
            if (listZziZ.isEmpty()) {
                zzbg.zzaB("...nothing to dispatch");
                this.zzaMu.zzan(true);
            } else {
                this.zzaMt.zzr(listZziZ);
                if (zzzd() > 0) {
                    zzcu.zzzz().dispatch();
                }
            }
        }
    }

    void zzf(String[] strArr) {
        SQLiteDatabase sQLiteDatabaseZzer;
        if (strArr == null || strArr.length == 0 || (sQLiteDatabaseZzer = zzer("Error opening database for deleteHits.")) == null) {
            return;
        }
        try {
            sQLiteDatabaseZzer.delete("gtm_hits", String.format("HIT_ID in (%s)", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
            this.zzaMu.zzan(zzzc() == 0);
        } catch (SQLiteException e) {
            zzbg.zzaC("Error deleting hits");
        }
    }

    @Override // com.google.android.gms.tagmanager.zzau
    public void zzg(long j, String str) throws Throwable {
        zzis();
        zzzb();
        zzh(j, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    List<String> zziY(int i) throws Throwable {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            zzbg.zzaC("Invalid maxHits specified. Skipping");
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for peekHitIds.");
        if (sQLiteDatabaseZzer == null) {
            return arrayList;
        }
        try {
            cursorQuery = sQLiteDatabaseZzer.query("gtm_hits", new String[]{"hit_id"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(i));
            try {
                try {
                    if (cursorQuery.moveToFirst()) {
                        do {
                            arrayList.add(String.valueOf(cursorQuery.getLong(0)));
                        } while (cursorQuery.moveToNext());
                    }
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                } catch (SQLiteException e) {
                    e = e;
                    zzbg.zzaC("Error in peekHits fetching hitIds: " + e.getMessage());
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
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<zzaq> zziZ(int i) throws Throwable {
        SQLiteException sQLiteException;
        Cursor cursor;
        ArrayList arrayList;
        Cursor cursorQuery;
        ArrayList arrayList2 = new ArrayList();
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for peekHits");
        if (sQLiteDatabaseZzer == null) {
            return arrayList2;
        }
        Cursor cursor2 = null;
        try {
            Cursor cursorQuery2 = sQLiteDatabaseZzer.query("gtm_hits", new String[]{"hit_id", "hit_time", "hit_first_send_time"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(i));
            try {
                try {
                    ArrayList<zzaq> arrayList3 = new ArrayList();
                    try {
                        if (cursorQuery2.moveToFirst()) {
                            do {
                                arrayList3.add(new zzaq(cursorQuery2.getLong(0), cursorQuery2.getLong(1), cursorQuery2.getLong(2)));
                            } while (cursorQuery2.moveToNext());
                        }
                        if (cursorQuery2 != null) {
                            cursorQuery2.close();
                        }
                        try {
                            try {
                                cursorQuery = sQLiteDatabaseZzer.query("gtm_hits", new String[]{"hit_id", "hit_url"}, null, null, null, null, String.format("%s ASC", "hit_id"), Integer.toString(i));
                            } catch (SQLiteException e) {
                                e = e;
                            }
                        } catch (Throwable th) {
                            th = th;
                        }
                        try {
                            if (cursorQuery.moveToFirst()) {
                                int i2 = 0;
                                while (true) {
                                    if (((SQLiteCursor) cursorQuery).getWindow().getNumRows() > 0) {
                                        ((zzaq) arrayList3.get(i2)).zzev(cursorQuery.getString(1));
                                    } else {
                                        zzbg.zzaC(String.format("HitString for hitId %d too large.  Hit will be deleted.", Long.valueOf(((zzaq) arrayList3.get(i2)).zzyO())));
                                    }
                                    int i3 = i2 + 1;
                                    if (!cursorQuery.moveToNext()) {
                                        break;
                                    }
                                    i2 = i3;
                                }
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return arrayList3;
                        } catch (SQLiteException e2) {
                            e = e2;
                            cursorQuery2 = cursorQuery;
                            zzbg.zzaC("Error in peekHits fetching hit url: " + e.getMessage());
                            ArrayList arrayList4 = new ArrayList();
                            boolean z = false;
                            for (zzaq zzaqVar : arrayList3) {
                                if (TextUtils.isEmpty(zzaqVar.zzyQ())) {
                                    if (z) {
                                        break;
                                    }
                                    z = true;
                                }
                                arrayList4.add(zzaqVar);
                            }
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                            return arrayList4;
                        } catch (Throwable th2) {
                            th = th2;
                            cursorQuery2 = cursorQuery;
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                            }
                            throw th;
                        }
                    } catch (SQLiteException e3) {
                        sQLiteException = e3;
                        cursor = cursorQuery2;
                        arrayList = arrayList3;
                        try {
                            zzbg.zzaC("Error in peekHits fetching hitIds: " + sQLiteException.getMessage());
                            if (cursor == null) {
                                return arrayList;
                            }
                            cursor.close();
                            return arrayList;
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                            }
                            throw th;
                        }
                    }
                } catch (SQLiteException e4) {
                    sQLiteException = e4;
                    cursor = cursorQuery2;
                    arrayList = arrayList2;
                }
            } catch (Throwable th4) {
                th = th4;
                cursor2 = cursorQuery2;
                if (cursor2 != null) {
                    cursor2.close();
                }
                throw th;
            }
        } catch (SQLiteException e5) {
            sQLiteException = e5;
            cursor = null;
            arrayList = arrayList2;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    int zzis() {
        long jCurrentTimeMillis = this.zzpw.currentTimeMillis();
        if (jCurrentTimeMillis <= this.zzaMw + 86400000) {
            return 0;
        }
        this.zzaMw = jCurrentTimeMillis;
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for deleteStaleHits.");
        if (sQLiteDatabaseZzer == null) {
            return 0;
        }
        int iDelete = sQLiteDatabaseZzer.delete("gtm_hits", "HIT_TIME < ?", new String[]{Long.toString(this.zzpw.currentTimeMillis() - 2592000000L)});
        this.zzaMu.zzan(zzzc() == 0);
        return iDelete;
    }

    int zzzc() {
        Cursor cursorRawQuery = null;
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for getNumStoredHits.");
        try {
            if (sQLiteDatabaseZzer != null) {
                try {
                    cursorRawQuery = sQLiteDatabaseZzer.rawQuery("SELECT COUNT(*) from gtm_hits", null);
                    i = cursorRawQuery.moveToFirst() ? (int) cursorRawQuery.getLong(0) : 0;
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (SQLiteException e) {
                    zzbg.zzaC("Error getting numStoredHits");
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                }
            }
            return i;
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    int zzzd() throws Throwable {
        Cursor cursor;
        int count;
        Cursor cursor2 = null;
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for getNumStoredHits.");
        if (sQLiteDatabaseZzer == null) {
            return 0;
        }
        try {
            Cursor cursorQuery = sQLiteDatabaseZzer.query("gtm_hits", new String[]{"hit_id", "hit_first_send_time"}, "hit_first_send_time=0", null, null, null, null);
            try {
                count = cursorQuery.getCount();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (SQLiteException e) {
                cursor = cursorQuery;
                try {
                    zzbg.zzaC("Error getting num untried hits");
                    if (cursor != null) {
                        cursor.close();
                        count = 0;
                    } else {
                        count = 0;
                    }
                } catch (Throwable th) {
                    cursor2 = cursor;
                    th = th;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                cursor2 = cursorQuery;
                if (cursor2 != null) {
                }
                throw th;
            }
        } catch (SQLiteException e2) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
        return count;
    }
}
