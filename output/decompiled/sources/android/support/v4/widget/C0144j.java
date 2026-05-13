package android.support.v4.widget;

import android.os.Build;
import android.support.v4.p015g.C0112d;
import android.support.v4.p015g.C0124p;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: android.support.v4.widget.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0144j {

    /* JADX INFO: renamed from: a */
    static final d f770a;

    /* JADX INFO: renamed from: android.support.v4.widget.j$a */
    static class a extends d {
        a() {
        }

        @Override // android.support.v4.widget.C0144j.d
        /* JADX INFO: renamed from: a */
        public void mo1138a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.widget.j$b */
    static class b extends a {

        /* JADX INFO: renamed from: a */
        private static Field f771a;

        static {
            try {
                f771a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                f771a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
            }
        }

        b() {
        }

        @Override // android.support.v4.widget.C0144j.d
        /* JADX INFO: renamed from: a */
        public void mo1139a(PopupWindow popupWindow, boolean z) {
            if (f771a != null) {
                try {
                    f771a.set(popupWindow, Boolean.valueOf(z));
                } catch (IllegalAccessException e) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
                }
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v4.widget.j$c */
    static class c extends b {
        c() {
        }

        @Override // android.support.v4.widget.C0144j.d
        /* JADX INFO: renamed from: a */
        public void mo1140a(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }

        @Override // android.support.v4.widget.C0144j.b, android.support.v4.widget.C0144j.d
        /* JADX INFO: renamed from: a */
        public void mo1139a(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.widget.j$d */
    static class d {

        /* JADX INFO: renamed from: a */
        private static Method f772a;

        /* JADX INFO: renamed from: b */
        private static boolean f773b;

        d() {
        }

        /* JADX INFO: renamed from: a */
        public void mo1140a(PopupWindow popupWindow, int i) {
            if (!f773b) {
                try {
                    f772a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                    f772a.setAccessible(true);
                } catch (Exception unused) {
                }
                f773b = true;
            }
            if (f772a != null) {
                try {
                    f772a.invoke(popupWindow, Integer.valueOf(i));
                } catch (Exception unused2) {
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo1138a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((C0112d.m902a(i3, C0124p.m960b(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        /* JADX INFO: renamed from: a */
        public void mo1139a(PopupWindow popupWindow, boolean z) {
        }
    }

    static {
        f770a = Build.VERSION.SDK_INT >= 23 ? new c() : Build.VERSION.SDK_INT >= 21 ? new b() : Build.VERSION.SDK_INT >= 19 ? new a() : new d();
    }

    /* JADX INFO: renamed from: a */
    public static void m1135a(PopupWindow popupWindow, int i) {
        f770a.mo1140a(popupWindow, i);
    }

    /* JADX INFO: renamed from: a */
    public static void m1136a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f770a.mo1138a(popupWindow, view, i, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public static void m1137a(PopupWindow popupWindow, boolean z) {
        f770a.mo1139a(popupWindow, z);
    }
}
