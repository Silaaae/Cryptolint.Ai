package android.support.v4.p015g;

import android.os.Build;
import android.view.WindowInsets;

/* JADX INFO: renamed from: android.support.v4.g.w */
/* JADX INFO: loaded from: classes.dex */
public class C0131w {

    /* JADX INFO: renamed from: a */
    private final Object f691a;

    private C0131w(Object obj) {
        this.f691a = obj;
    }

    /* JADX INFO: renamed from: a */
    static C0131w m1030a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C0131w(obj);
    }

    /* JADX INFO: renamed from: a */
    static Object m1031a(C0131w c0131w) {
        if (c0131w == null) {
            return null;
        }
        return c0131w.f691a;
    }

    /* JADX INFO: renamed from: a */
    public int m1032a() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f691a).getSystemWindowInsetLeft();
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public C0131w m1033a(int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new C0131w(((WindowInsets) this.f691a).replaceSystemWindowInsets(i, i2, i3, i4));
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public int m1034b() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f691a).getSystemWindowInsetTop();
        }
        return 0;
    }

    /* JADX INFO: renamed from: c */
    public int m1035c() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f691a).getSystemWindowInsetRight();
        }
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public int m1036d() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.f691a).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0131w c0131w = (C0131w) obj;
        return this.f691a == null ? c0131w.f691a == null : this.f691a.equals(c0131w.f691a);
    }

    public int hashCode() {
        if (this.f691a == null) {
            return 0;
        }
        return this.f691a.hashCode();
    }
}
