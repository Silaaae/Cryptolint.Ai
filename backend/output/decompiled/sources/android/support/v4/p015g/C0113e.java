package android.support.v4.p015g;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: android.support.v4.g.e */
/* JADX INFO: loaded from: classes.dex */
public final class C0113e {

    /* JADX INFO: renamed from: a */
    static final b f657a;

    /* JADX INFO: renamed from: b */
    private static Field f658b;

    /* JADX INFO: renamed from: c */
    private static boolean f659c;

    /* JADX INFO: renamed from: android.support.v4.g.e$a */
    static class a extends b {
        a() {
        }

        @Override // android.support.v4.p015g.C0113e.b
        /* JADX INFO: renamed from: a */
        public void mo905a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.e$b */
    static class b {
        b() {
        }

        /* JADX INFO: renamed from: a */
        public void mo905a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
            layoutInflater.setFactory2(factory2);
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                C0113e.m903a(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                C0113e.m903a(layoutInflater, factory2);
            }
        }
    }

    static {
        f657a = Build.VERSION.SDK_INT >= 21 ? new a() : new b();
    }

    /* JADX INFO: renamed from: a */
    static void m903a(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        if (!f659c) {
            try {
                f658b = LayoutInflater.class.getDeclaredField("mFactory2");
                f658b.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f659c = true;
        }
        if (f658b != null) {
            try {
                f658b.set(layoutInflater, factory2);
            } catch (IllegalAccessException e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m904b(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        f657a.mo905a(layoutInflater, factory2);
    }
}
