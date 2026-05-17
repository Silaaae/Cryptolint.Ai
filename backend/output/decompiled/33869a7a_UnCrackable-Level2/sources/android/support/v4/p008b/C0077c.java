package android.support.v4.p008b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.p006a.p007a.C0034a;
import android.support.v4.p006a.p007a.C0035b;
import android.support.v4.p013e.C0088b;
import android.support.v4.p014f.C0096g;

/* JADX INFO: renamed from: android.support.v4.b.c */
/* JADX INFO: loaded from: classes.dex */
public class C0077c {

    /* JADX INFO: renamed from: a */
    private static final a f512a;

    /* JADX INFO: renamed from: b */
    private static final C0096g<String, Typeface> f513b;

    /* JADX INFO: renamed from: android.support.v4.b.c$a */
    interface a {
        /* JADX INFO: renamed from: a */
        Typeface mo688a(Context context, Resources resources, int i, String str, int i2);

        /* JADX INFO: renamed from: a */
        Typeface mo689a(Context context, CancellationSignal cancellationSignal, C0088b.b[] bVarArr, int i);

        /* JADX INFO: renamed from: a */
        Typeface mo690a(Context context, C0034a.b bVar, Resources resources, int i);
    }

    static {
        f512a = Build.VERSION.SDK_INT >= 26 ? new C0080f() : (Build.VERSION.SDK_INT < 24 || !C0079e.m693a()) ? Build.VERSION.SDK_INT >= 21 ? new C0078d() : new C0081g() : new C0079e();
        f513b = new C0096g<>(16);
    }

    /* JADX INFO: renamed from: a */
    public static Typeface m683a(Context context, Resources resources, int i, String str, int i2) {
        Typeface typefaceMo688a = f512a.mo688a(context, resources, i, str, i2);
        if (typefaceMo688a != null) {
            f513b.m799a(m687b(resources, i, i2), typefaceMo688a);
        }
        return typefaceMo688a;
    }

    /* JADX INFO: renamed from: a */
    public static Typeface m684a(Context context, CancellationSignal cancellationSignal, C0088b.b[] bVarArr, int i) {
        return f512a.mo689a(context, cancellationSignal, bVarArr, i);
    }

    /* JADX INFO: renamed from: a */
    public static Typeface m685a(Context context, C0034a.a aVar, Resources resources, int i, int i2, C0035b.a aVar2, Handler handler, boolean z) {
        Typeface typefaceMo690a;
        if (aVar instanceof C0034a.d) {
            C0034a.d dVar = (C0034a.d) aVar;
            boolean z2 = false;
            if (!z ? aVar2 == null : dVar.m183b() == 0) {
                z2 = true;
            }
            typefaceMo690a = C0088b.m728a(context, dVar.m182a(), aVar2, handler, z2, z ? dVar.m184c() : -1, i2);
        } else {
            typefaceMo690a = f512a.mo690a(context, (C0034a.b) aVar, resources, i2);
            if (aVar2 != null) {
                if (typefaceMo690a != null) {
                    aVar2.m192a(typefaceMo690a, handler);
                } else {
                    aVar2.m190a(-3, handler);
                }
            }
        }
        if (typefaceMo690a != null) {
            f513b.m799a(m687b(resources, i, i2), typefaceMo690a);
        }
        return typefaceMo690a;
    }

    /* JADX INFO: renamed from: a */
    public static Typeface m686a(Resources resources, int i, int i2) {
        return f513b.m798a(m687b(resources, i, i2));
    }

    /* JADX INFO: renamed from: b */
    private static String m687b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }
}
