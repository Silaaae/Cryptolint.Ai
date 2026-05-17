package android.support.v4.widget;

import android.os.Build;
import android.widget.EdgeEffect;

/* JADX INFO: renamed from: android.support.v4.widget.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0140f {

    /* JADX INFO: renamed from: a */
    private static final b f767a;

    /* JADX INFO: renamed from: android.support.v4.widget.f$a */
    static class a extends b {
        a() {
        }

        @Override // android.support.v4.widget.C0140f.b
        /* JADX INFO: renamed from: a */
        public void mo1125a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f, f2);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.widget.f$b */
    static class b {
        b() {
        }

        /* JADX INFO: renamed from: a */
        public void mo1125a(EdgeEffect edgeEffect, float f, float f2) {
            edgeEffect.onPull(f);
        }
    }

    static {
        f767a = Build.VERSION.SDK_INT >= 21 ? new a() : new b();
    }

    /* JADX INFO: renamed from: a */
    public static void m1124a(EdgeEffect edgeEffect, float f, float f2) {
        f767a.mo1125a(edgeEffect, f, f2);
    }
}
