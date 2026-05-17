package com.google.android.gms.tagmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.text.TextUtils;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.tagmanager.DataLayer;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
class zzw implements DataLayer.zzc {
    private static final String zzaLp = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' STRING NOT NULL, '%s' BLOB NOT NULL, '%s' INTEGER NOT NULL);", "datalayer", "ID", "key", "value", "expires");
    private final Context mContext;
    private final Executor zzaLq;
    private zza zzaLr;
    private int zzaLs;
    private zzlb zzpw;

    class zza extends SQLiteOpenHelper {
        zza(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
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
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("SELECT * FROM datalayer WHERE 0", null);
            HashSet hashSet = new HashSet();
            try {
                for (String str : cursorRawQuery.getColumnNames()) {
                    hashSet.add(str);
                }
                cursorRawQuery.close();
                if (!hashSet.remove("key") || !hashSet.remove("value") || !hashSet.remove("ID") || !hashSet.remove("expires")) {
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
            SQLiteDatabase writableDatabase = null;
            try {
                writableDatabase = super.getWritableDatabase();
            } catch (SQLiteException e) {
                zzw.this.mContext.getDatabasePath("google_tagmanager.db").delete();
            }
            return writableDatabase == null ? super.getWritableDatabase() : writableDatabase;
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
            if (zza("datalayer", db)) {
                zzc(db);
            } else {
                db.execSQL(zzw.zzaLp);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }
    }

    private static class zzb {
        final byte[] zzaLy;
        final String zztw;

        zzb(String str, byte[] bArr) {
            this.zztw = str;
            this.zzaLy = bArr;
        }

        public String toString() {
            return "KeyAndSerialized: key = " + this.zztw + " serialized hash = " + Arrays.hashCode(this.zzaLy);
        }
    }

    public zzw(Context context) {
        this(context, zzld.zzoQ(), "google_tagmanager.db", 2000, Executors.newSingleThreadExecutor());
    }

    zzw(Context context, zzlb zzlbVar, String str, int i, Executor executor) {
        this.mContext = context;
        this.zzpw = zzlbVar;
        this.zzaLs = i;
        this.zzaLq = executor;
        this.zzaLr = new zza(this.mContext, str);
    }

    private byte[] zzA(Object obj) throws Throwable {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        byte[] byteArray = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                byteArray = byteArrayOutputStream.toByteArray();
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (IOException e2) {
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th = th2;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e4) {
                        throw th;
                    }
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException e5) {
            objectOutputStream = null;
        } catch (Throwable th3) {
            objectOutputStream = null;
            th = th3;
        }
        return byteArray;
    }

    private void zzS(long j) {
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for deleteOlderThan.");
        if (sQLiteDatabaseZzer == null) {
            return;
        }
        try {
            zzbg.zzaB("Deleted " + sQLiteDatabaseZzer.delete("datalayer", "expires <= ?", new String[]{Long.toString(j)}) + " expired items");
        } catch (SQLiteException e) {
            zzbg.zzaC("Error deleting old entries.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void zzb(List<zzb> list, long j) {
        try {
            long jCurrentTimeMillis = this.zzpw.currentTimeMillis();
            zzS(jCurrentTimeMillis);
            zziS(list.size());
            zzc(list, jCurrentTimeMillis + j);
        } finally {
            zzyF();
        }
    }

    private void zzc(List<zzb> list, long j) {
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for writeEntryToDatabase.");
        if (sQLiteDatabaseZzer == null) {
            return;
        }
        for (zzb zzbVar : list) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("expires", Long.valueOf(j));
            contentValues.put("key", zzbVar.zztw);
            contentValues.put("value", zzbVar.zzaLy);
            sQLiteDatabaseZzer.insert("datalayer", null, contentValues);
        }
    }

    private void zze(String[] strArr) {
        SQLiteDatabase sQLiteDatabaseZzer;
        if (strArr == null || strArr.length == 0 || (sQLiteDatabaseZzer = zzer("Error opening database for deleteEntries.")) == null) {
            return;
        }
        try {
            sQLiteDatabaseZzer.delete("datalayer", String.format("%s in (%s)", "ID", TextUtils.join(",", Collections.nCopies(strArr.length, "?"))), strArr);
        } catch (SQLiteException e) {
            zzbg.zzaC("Error deleting entries " + Arrays.toString(strArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzeq(String str) {
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for clearKeysWithPrefix.");
        try {
        } catch (SQLiteException e) {
            zzbg.zzaC("Error deleting entries with key prefix: " + str + " (" + e + ").");
        } finally {
            zzyF();
        }
        if (sQLiteDatabaseZzer == null) {
            return;
        }
        zzbg.zzaB("Cleared " + sQLiteDatabaseZzer.delete("datalayer", "key = ? OR key LIKE ?", new String[]{str, str + ".%"}) + " items");
    }

    private SQLiteDatabase zzer(String str) {
        try {
            return this.zzaLr.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbg.zzaC(str);
            return null;
        }
    }

    private void zziS(int i) throws Throwable {
        int iZzyE = (zzyE() - this.zzaLs) + i;
        if (iZzyE > 0) {
            List<String> listZziT = zziT(iZzyE);
            zzbg.zzaA("DataLayer store full, deleting " + listZziT.size() + " entries to make room.");
            zze((String[]) listZziT.toArray(new String[0]));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<String> zziT(int i) throws Throwable {
        Cursor cursorQuery;
        ArrayList arrayList = new ArrayList();
        if (i <= 0) {
            zzbg.zzaC("Invalid maxEntries specified. Skipping.");
            return arrayList;
        }
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for peekEntryIds.");
        if (sQLiteDatabaseZzer == null) {
            return arrayList;
        }
        try {
            cursorQuery = sQLiteDatabaseZzer.query("datalayer", new String[]{"ID"}, null, null, null, null, String.format("%s ASC", "ID"), Integer.toString(i));
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
                    zzbg.zzaC("Error in peekEntries fetching entryIds: " + e.getMessage());
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

    private List<DataLayer.zza> zzp(List<zzb> list) {
        ArrayList arrayList = new ArrayList();
        for (zzb zzbVar : list) {
            arrayList.add(new DataLayer.zza(zzbVar.zztw, zzq(zzbVar.zzaLy)));
        }
        return arrayList;
    }

    private Object zzq(byte[] bArr) throws Throwable {
        ObjectInputStream objectInputStream;
        Throwable th;
        Object object = null;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                object = objectInputStream.readObject();
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                    }
                }
                byteArrayInputStream.close();
            } catch (IOException e2) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                byteArrayInputStream.close();
            } catch (ClassNotFoundException e4) {
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th = th2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e6) {
                        throw th;
                    }
                }
                byteArrayInputStream.close();
                throw th;
            }
        } catch (IOException e7) {
            objectInputStream = null;
        } catch (ClassNotFoundException e8) {
            objectInputStream = null;
        } catch (Throwable th3) {
            objectInputStream = null;
            th = th3;
        }
        return object;
    }

    private List<zzb> zzq(List<DataLayer.zza> list) {
        ArrayList arrayList = new ArrayList();
        for (DataLayer.zza zzaVar : list) {
            arrayList.add(new zzb(zzaVar.zztw, zzA(zzaVar.zzGK)));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<DataLayer.zza> zzyC() {
        try {
            zzS(this.zzpw.currentTimeMillis());
            return zzp(zzyD());
        } finally {
            zzyF();
        }
    }

    private List<zzb> zzyD() {
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for loadSerialized.");
        ArrayList arrayList = new ArrayList();
        if (sQLiteDatabaseZzer == null) {
            return arrayList;
        }
        Cursor cursorQuery = sQLiteDatabaseZzer.query("datalayer", new String[]{"key", "value"}, null, null, null, null, "ID", null);
        while (cursorQuery.moveToNext()) {
            try {
                arrayList.add(new zzb(cursorQuery.getString(0), cursorQuery.getBlob(1)));
            } finally {
                cursorQuery.close();
            }
        }
        return arrayList;
    }

    private int zzyE() {
        Cursor cursorRawQuery = null;
        SQLiteDatabase sQLiteDatabaseZzer = zzer("Error opening database for getNumStoredEntries.");
        try {
            if (sQLiteDatabaseZzer != null) {
                try {
                    cursorRawQuery = sQLiteDatabaseZzer.rawQuery("SELECT COUNT(*) from datalayer", null);
                    i = cursorRawQuery.moveToFirst() ? (int) cursorRawQuery.getLong(0) : 0;
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (SQLiteException e) {
                    zzbg.zzaC("Error getting numStoredEntries");
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

    private void zzyF() {
        try {
            this.zzaLr.close();
        } catch (SQLiteException e) {
        }
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zza(final DataLayer.zzc.zza zzaVar) {
        this.zzaLq.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzw.2
            @Override // java.lang.Runnable
            public void run() {
                zzaVar.zzo(zzw.this.zzyC());
            }
        });
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zza(List<DataLayer.zza> list, final long j) {
        final List<zzb> listZzq = zzq(list);
        this.zzaLq.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzw.1
            @Override // java.lang.Runnable
            public void run() {
                zzw.this.zzb(listZzq, j);
            }
        });
    }

    @Override // com.google.android.gms.tagmanager.DataLayer.zzc
    public void zzep(final String str) {
        this.zzaLq.execute(new Runnable() { // from class: com.google.android.gms.tagmanager.zzw.3
            @Override // java.lang.Runnable
            public void run() {
                zzw.this.zzeq(str);
            }
        });
    }
}
