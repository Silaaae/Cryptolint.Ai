package android.support.v4.p013e;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.p006a.p007a.C0034a;
import android.support.v4.p006a.p007a.C0035b;
import android.support.v4.p008b.C0077c;
import android.support.v4.p008b.C0082h;
import android.support.v4.p013e.C0089c;
import android.support.v4.p014f.C0096g;
import android.support.v4.p014f.C0099j;
import android.support.v4.p014f.C0100k;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: android.support.v4.e.b */
/* JADX INFO: loaded from: classes.dex */
public class C0088b {

    /* JADX INFO: renamed from: a */
    private static final C0096g<String, Typeface> f533a = new C0096g<>(16);

    /* JADX INFO: renamed from: b */
    private static final C0089c f534b = new C0089c("fonts", 10, 10000);

    /* JADX INFO: renamed from: c */
    private static final Object f535c = new Object();

    /* JADX INFO: renamed from: d */
    private static final C0100k<String, ArrayList<C0089c.a<c>>> f536d = new C0100k<>();

    /* JADX INFO: renamed from: e */
    private static final Comparator<byte[]> f537e = new Comparator<byte[]>() { // from class: android.support.v4.e.b.4
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            int length;
            int length2;
            if (bArr.length == bArr2.length) {
                for (int i = 0; i < bArr.length; i++) {
                    if (bArr[i] != bArr2[i]) {
                        length = bArr[i];
                        length2 = bArr2[i];
                    }
                }
                return 0;
            }
            length = bArr.length;
            length2 = bArr2.length;
            return length - length2;
        }
    };

    /* JADX INFO: renamed from: android.support.v4.e.b$a */
    public static class a {

        /* JADX INFO: renamed from: a */
        private final int f545a;

        /* JADX INFO: renamed from: b */
        private final b[] f546b;

        public a(int i, b[] bVarArr) {
            this.f545a = i;
            this.f546b = bVarArr;
        }

        /* JADX INFO: renamed from: a */
        public int m743a() {
            return this.f545a;
        }

        /* JADX INFO: renamed from: b */
        public b[] m744b() {
            return this.f546b;
        }
    }

    /* JADX INFO: renamed from: android.support.v4.e.b$b */
    public static class b {

        /* JADX INFO: renamed from: a */
        private final Uri f547a;

        /* JADX INFO: renamed from: b */
        private final int f548b;

        /* JADX INFO: renamed from: c */
        private final int f549c;

        /* JADX INFO: renamed from: d */
        private final boolean f550d;

        /* JADX INFO: renamed from: e */
        private final int f551e;

        public b(Uri uri, int i, int i2, boolean z, int i3) {
            this.f547a = (Uri) C0099j.m816a(uri);
            this.f548b = i;
            this.f549c = i2;
            this.f550d = z;
            this.f551e = i3;
        }

        /* JADX INFO: renamed from: a */
        public Uri m745a() {
            return this.f547a;
        }

        /* JADX INFO: renamed from: b */
        public int m746b() {
            return this.f548b;
        }

        /* JADX INFO: renamed from: c */
        public int m747c() {
            return this.f549c;
        }

        /* JADX INFO: renamed from: d */
        public boolean m748d() {
            return this.f550d;
        }

        /* JADX INFO: renamed from: e */
        public int m749e() {
            return this.f551e;
        }
    }

    /* JADX INFO: renamed from: android.support.v4.e.b$c */
    private static final class c {

        /* JADX INFO: renamed from: a */
        final Typeface f552a;

        /* JADX INFO: renamed from: b */
        final int f553b;

        c(Typeface typeface, int i) {
            this.f552a = typeface;
            this.f553b = i;
        }
    }

    /* JADX INFO: renamed from: a */
    public static ProviderInfo m727a(PackageManager packageManager, C0087a c0087a, Resources resources) throws PackageManager.NameNotFoundException {
        String strM721a = c0087a.m721a();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strM721a, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strM721a);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(c0087a.m722b())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strM721a + ", but package was not " + c0087a.m722b());
        }
        List<byte[]> listM733a = m733a(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listM733a, f537e);
        List<List<byte[]>> listM732a = m732a(c0087a, resources);
        for (int i = 0; i < listM732a.size(); i++) {
            ArrayList arrayList = new ArrayList(listM732a.get(i));
            Collections.sort(arrayList, f537e);
            if (m735a(listM733a, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static Typeface m728a(final Context context, final C0087a c0087a, final C0035b.a aVar, final Handler handler, boolean z, int i, final int i2) {
        final String str = c0087a.m726f() + "-" + i2;
        Typeface typefaceM798a = f533a.m798a(str);
        if (typefaceM798a != null) {
            if (aVar != null) {
                aVar.mo191a(typefaceM798a);
            }
            return typefaceM798a;
        }
        if (z && i == -1) {
            c cVarM737b = m737b(context, c0087a, i2);
            if (aVar != null) {
                if (cVarM737b.f553b == 0) {
                    aVar.m192a(cVarM737b.f552a, handler);
                } else {
                    aVar.m190a(cVarM737b.f553b, handler);
                }
            }
            return cVarM737b.f552a;
        }
        Callable<c> callable = new Callable<c>() { // from class: android.support.v4.e.b.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public c call() {
                c cVarM737b2 = C0088b.m737b(context, c0087a, i2);
                if (cVarM737b2.f552a != null) {
                    C0088b.f533a.m799a(str, cVarM737b2.f552a);
                }
                return cVarM737b2;
            }
        };
        if (z) {
            try {
                return ((c) f534b.m755a(callable, i)).f552a;
            } catch (InterruptedException unused) {
                return null;
            }
        }
        C0089c.a<c> aVar2 = aVar == null ? null : new C0089c.a<c>() { // from class: android.support.v4.e.b.2
            @Override // android.support.v4.p013e.C0089c.a
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo741a(c cVar) {
                if (cVar == null) {
                    aVar.m190a(1, handler);
                } else if (cVar.f553b == 0) {
                    aVar.m192a(cVar.f552a, handler);
                } else {
                    aVar.m190a(cVar.f553b, handler);
                }
            }
        };
        synchronized (f535c) {
            if (f536d.containsKey(str)) {
                if (aVar2 != null) {
                    f536d.get(str).add(aVar2);
                }
                return null;
            }
            if (aVar2 != null) {
                ArrayList<C0089c.a<c>> arrayList = new ArrayList<>();
                arrayList.add(aVar2);
                f536d.put(str, arrayList);
            }
            f534b.m756a(callable, new C0089c.a<c>() { // from class: android.support.v4.e.b.3
                @Override // android.support.v4.p013e.C0089c.a
                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public void mo741a(c cVar) {
                    synchronized (C0088b.f535c) {
                        ArrayList arrayList2 = (ArrayList) C0088b.f536d.get(str);
                        if (arrayList2 == null) {
                            return;
                        }
                        C0088b.f536d.remove(str);
                        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                            ((C0089c.a) arrayList2.get(i3)).mo741a(cVar);
                        }
                    }
                }
            });
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static a m729a(Context context, CancellationSignal cancellationSignal, C0087a c0087a) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoM727a = m727a(context.getPackageManager(), c0087a, context.getResources());
        return providerInfoM727a == null ? new a(1, null) : new a(0, m736a(context, c0087a, providerInfoM727a.authority, cancellationSignal));
    }

    /* JADX INFO: renamed from: a */
    private static List<List<byte[]>> m732a(C0087a c0087a, Resources resources) {
        return c0087a.m724d() != null ? c0087a.m724d() : C0034a.m171a(resources, c0087a.m725e());
    }

    /* JADX INFO: renamed from: a */
    private static List<byte[]> m733a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public static Map<Uri, ByteBuffer> m734a(Context context, b[] bVarArr, CancellationSignal cancellationSignal) {
        HashMap map = new HashMap();
        for (b bVar : bVarArr) {
            if (bVar.m749e() == 0) {
                Uri uriM745a = bVar.m745a();
                if (!map.containsKey(uriM745a)) {
                    map.put(uriM745a, C0082h.m711a(context, cancellationSignal, uriM745a));
                }
            }
        }
        return Collections.unmodifiableMap(map);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m735a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    static b[] m736a(Context context, C0087a c0087a, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursorQuery = null;
        try {
            cursorQuery = Build.VERSION.SDK_INT > 16 ? context.getContentResolver().query(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{c0087a.m723c()}, null, cancellationSignal) : context.getContentResolver().query(uriBuild, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{c0087a.m723c()}, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursorQuery.getColumnIndex("_id");
                int columnIndex3 = cursorQuery.getColumnIndex("file_id");
                int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                while (cursorQuery.moveToNext()) {
                    int i = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : 0;
                    arrayList2.add(new b(columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3)), columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : 0, columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursorQuery.getInt(columnIndex6) == 1, i));
                }
                arrayList = arrayList2;
            }
            return (b[]) arrayList.toArray(new b[0]);
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static c m737b(Context context, C0087a c0087a, int i) {
        try {
            a aVarM729a = m729a(context, (CancellationSignal) null, c0087a);
            if (aVarM729a.m743a() != 0) {
                return new c(null, aVarM729a.m743a() == 1 ? -2 : -3);
            }
            Typeface typefaceM684a = C0077c.m684a(context, null, aVarM729a.m744b(), i);
            return new c(typefaceM684a, typefaceM684a != null ? 0 : -3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new c(null, -1);
        }
    }
}
