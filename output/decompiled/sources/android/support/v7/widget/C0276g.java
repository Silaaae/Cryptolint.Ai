package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.p015g.C0124p;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: renamed from: android.support.v7.widget.g */
/* JADX INFO: loaded from: classes.dex */
class C0276g {

    /* JADX INFO: renamed from: a */
    private final View f1903a;

    /* JADX INFO: renamed from: d */
    private C0261au f1906d;

    /* JADX INFO: renamed from: e */
    private C0261au f1907e;

    /* JADX INFO: renamed from: f */
    private C0261au f1908f;

    /* JADX INFO: renamed from: c */
    private int f1905c = -1;

    /* JADX INFO: renamed from: b */
    private final C0281l f1904b = C0281l.m2092a();

    C0276g(View view) {
        this.f1903a = view;
    }

    /* JADX INFO: renamed from: b */
    private boolean m2067b(Drawable drawable) {
        if (this.f1908f == null) {
            this.f1908f = new C0261au();
        }
        C0261au c0261au = this.f1908f;
        c0261au.m1975a();
        ColorStateList colorStateListM967i = C0124p.m967i(this.f1903a);
        if (colorStateListM967i != null) {
            c0261au.f1798d = true;
            c0261au.f1795a = colorStateListM967i;
        }
        PorterDuff.Mode modeM968j = C0124p.m968j(this.f1903a);
        if (modeM968j != null) {
            c0261au.f1797c = true;
            c0261au.f1796b = modeM968j;
        }
        if (!c0261au.f1798d && !c0261au.f1797c) {
            return false;
        }
        C0281l.m2095a(drawable, c0261au, this.f1903a.getDrawableState());
        return true;
    }

    /* JADX INFO: renamed from: d */
    private boolean m2068d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f1906d != null : i == 21;
    }

    /* JADX INFO: renamed from: a */
    ColorStateList m2069a() {
        if (this.f1907e != null) {
            return this.f1907e.f1795a;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    void m2070a(int i) {
        this.f1905c = i;
        m2076b(this.f1904b != null ? this.f1904b.m2115b(this.f1903a.getContext(), i) : null);
        m2077c();
    }

    /* JADX INFO: renamed from: a */
    void m2071a(ColorStateList colorStateList) {
        if (this.f1907e == null) {
            this.f1907e = new C0261au();
        }
        this.f1907e.f1795a = colorStateList;
        this.f1907e.f1798d = true;
        m2077c();
    }

    /* JADX INFO: renamed from: a */
    void m2072a(PorterDuff.Mode mode) {
        if (this.f1907e == null) {
            this.f1907e = new C0261au();
        }
        this.f1907e.f1796b = mode;
        this.f1907e.f1797c = true;
        m2077c();
    }

    /* JADX INFO: renamed from: a */
    void m2073a(Drawable drawable) {
        this.f1905c = -1;
        m2076b((ColorStateList) null);
        m2077c();
    }

    /* JADX INFO: renamed from: a */
    void m2074a(AttributeSet attributeSet, int i) {
        C0263aw c0263awM1978a = C0263aw.m1978a(this.f1903a.getContext(), attributeSet, C0148a.j.ViewBackgroundHelper, i, 0);
        try {
            if (c0263awM1978a.m1996g(C0148a.j.ViewBackgroundHelper_android_background)) {
                this.f1905c = c0263awM1978a.m1995g(C0148a.j.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListM2115b = this.f1904b.m2115b(this.f1903a.getContext(), this.f1905c);
                if (colorStateListM2115b != null) {
                    m2076b(colorStateListM2115b);
                }
            }
            if (c0263awM1978a.m1996g(C0148a.j.ViewBackgroundHelper_backgroundTint)) {
                C0124p.m952a(this.f1903a, c0263awM1978a.m1992e(C0148a.j.ViewBackgroundHelper_backgroundTint));
            }
            if (c0263awM1978a.m1996g(C0148a.j.ViewBackgroundHelper_backgroundTintMode)) {
                C0124p.m953a(this.f1903a, C0246af.m1853a(c0263awM1978a.m1980a(C0148a.j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            c0263awM1978a.m1983a();
        }
    }

    /* JADX INFO: renamed from: b */
    PorterDuff.Mode m2075b() {
        if (this.f1907e != null) {
            return this.f1907e.f1796b;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    void m2076b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f1906d == null) {
                this.f1906d = new C0261au();
            }
            this.f1906d.f1795a = colorStateList;
            this.f1906d.f1798d = true;
        } else {
            this.f1906d = null;
        }
        m2077c();
    }

    /* JADX INFO: renamed from: c */
    void m2077c() {
        C0261au c0261au;
        Drawable background = this.f1903a.getBackground();
        if (background != null) {
            if (m2068d() && m2067b(background)) {
                return;
            }
            if (this.f1907e != null) {
                c0261au = this.f1907e;
            } else if (this.f1906d == null) {
                return;
            } else {
                c0261au = this.f1906d;
            }
            C0281l.m2095a(background, c0261au, this.f1903a.getDrawableState());
        }
    }
}
