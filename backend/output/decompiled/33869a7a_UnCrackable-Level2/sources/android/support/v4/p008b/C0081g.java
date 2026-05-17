package android.support.v4.p008b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.support.v4.p006a.p007a.C0034a;
import android.support.v4.p008b.C0077c;
import android.support.v4.p013e.C0088b;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: android.support.v4.b.g */
/* JADX INFO: loaded from: classes.dex */
class C0081g implements C0077c.a {

    /* JADX INFO: renamed from: android.support.v4.b.g$a */
    private interface a<T> {
        /* JADX INFO: renamed from: a */
        boolean mo707a(T t);

        /* JADX INFO: renamed from: b */
        int mo708b(T t);
    }

    C0081g() {
    }

    /* JADX INFO: renamed from: a */
    private C0034a.c m703a(C0034a.b bVar, int i) {
        return (C0034a.c) m704a(bVar.m177a(), i, new a<C0034a.c>() { // from class: android.support.v4.b.g.2
            @Override // android.support.v4.p008b.C0081g.a
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int mo708b(C0034a.c cVar) {
                return cVar.m179b();
            }

            @Override // android.support.v4.p008b.C0081g.a
            /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo707a(C0034a.c cVar) {
                return cVar.m180c();
            }
        });
    }

    /* JADX INFO: renamed from: a */
    private static <T> T m704a(T[] tArr, int i, a<T> aVar) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        T t = null;
        int i3 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int iAbs = (Math.abs(aVar.mo708b(t2) - i2) * 2) + (aVar.mo707a(t2) == z ? 0 : 1);
            if (t == null || i3 > iAbs) {
                t = t2;
                i3 = iAbs;
            }
        }
        return t;
    }

    @Override // android.support.v4.p008b.C0077c.a
    /* JADX INFO: renamed from: a */
    public Typeface mo688a(Context context, Resources resources, int i, String str, int i2) {
        File fileM709a = C0082h.m709a(context);
        if (fileM709a == null) {
            return null;
        }
        try {
            if (C0082h.m714a(fileM709a, resources, i)) {
                return Typeface.createFromFile(fileM709a.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileM709a.delete();
        }
    }

    @Override // android.support.v4.p008b.C0077c.a
    /* JADX INFO: renamed from: a */
    public Typeface mo689a(Context context, CancellationSignal cancellationSignal, C0088b.b[] bVarArr, int i) throws Throwable {
        InputStream inputStreamOpenInputStream;
        InputStream inputStream = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStreamOpenInputStream = context.getContentResolver().openInputStream(m706a(bVarArr, i).m745a());
        } catch (IOException unused) {
            inputStreamOpenInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            Typeface typefaceM705a = m705a(context, inputStreamOpenInputStream);
            C0082h.m713a(inputStreamOpenInputStream);
            return typefaceM705a;
        } catch (IOException unused2) {
            C0082h.m713a(inputStreamOpenInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = inputStreamOpenInputStream;
            C0082h.m713a(inputStream);
            throw th;
        }
    }

    @Override // android.support.v4.p008b.C0077c.a
    /* JADX INFO: renamed from: a */
    public Typeface mo690a(Context context, C0034a.b bVar, Resources resources, int i) {
        C0034a.c cVarM703a = m703a(bVar, i);
        if (cVarM703a == null) {
            return null;
        }
        return C0077c.m683a(context, resources, cVarM703a.m181d(), cVarM703a.m178a(), i);
    }

    /* JADX INFO: renamed from: a */
    protected Typeface m705a(Context context, InputStream inputStream) {
        File fileM709a = C0082h.m709a(context);
        if (fileM709a == null) {
            return null;
        }
        try {
            if (C0082h.m715a(fileM709a, inputStream)) {
                return Typeface.createFromFile(fileM709a.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileM709a.delete();
        }
    }

    /* JADX INFO: renamed from: a */
    protected C0088b.b m706a(C0088b.b[] bVarArr, int i) {
        return (C0088b.b) m704a(bVarArr, i, new a<C0088b.b>() { // from class: android.support.v4.b.g.1
            @Override // android.support.v4.p008b.C0081g.a
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public int mo708b(C0088b.b bVar) {
                return bVar.m747c();
            }

            @Override // android.support.v4.p008b.C0081g.a
            /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public boolean mo707a(C0088b.b bVar) {
                return bVar.m748d();
            }
        });
    }
}
