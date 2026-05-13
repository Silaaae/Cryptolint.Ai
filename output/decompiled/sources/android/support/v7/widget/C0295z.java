package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.p006a.p007a.C0035b;
import android.support.v4.widget.InterfaceC0136b;
import android.support.v7.p018a.C0148a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: android.support.v7.widget.z */
/* JADX INFO: loaded from: classes.dex */
class C0295z {

    /* JADX INFO: renamed from: a */
    final TextView f1986a;

    /* JADX INFO: renamed from: b */
    private C0261au f1987b;

    /* JADX INFO: renamed from: c */
    private C0261au f1988c;

    /* JADX INFO: renamed from: d */
    private C0261au f1989d;

    /* JADX INFO: renamed from: e */
    private C0261au f1990e;

    /* JADX INFO: renamed from: f */
    private final C0243ac f1991f;

    /* JADX INFO: renamed from: g */
    private int f1992g = 0;

    /* JADX INFO: renamed from: h */
    private Typeface f1993h;

    /* JADX INFO: renamed from: i */
    private boolean f1994i;

    C0295z(TextView textView) {
        this.f1986a = textView;
        this.f1991f = new C0243ac(this.f1986a);
    }

    /* JADX INFO: renamed from: a */
    protected static C0261au m2152a(Context context, C0281l c0281l, int i) {
        ColorStateList colorStateListM2115b = c0281l.m2115b(context, i);
        if (colorStateListM2115b == null) {
            return null;
        }
        C0261au c0261au = new C0261au();
        c0261au.f1798d = true;
        c0261au.f1795a = colorStateListM2115b;
        return c0261au;
    }

    /* JADX INFO: renamed from: a */
    static C0295z m2153a(TextView textView) {
        return Build.VERSION.SDK_INT >= 17 ? new C0241aa(textView) : new C0295z(textView);
    }

    /* JADX INFO: renamed from: a */
    private void m2154a(Context context, C0263aw c0263aw) {
        String strM1990d;
        Typeface typeface;
        this.f1992g = c0263aw.m1980a(C0148a.j.TextAppearance_android_textStyle, this.f1992g);
        boolean z = true;
        if (c0263aw.m1996g(C0148a.j.TextAppearance_android_fontFamily) || c0263aw.m1996g(C0148a.j.TextAppearance_fontFamily)) {
            this.f1993h = null;
            int i = c0263aw.m1996g(C0148a.j.TextAppearance_fontFamily) ? C0148a.j.TextAppearance_fontFamily : C0148a.j.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.f1986a);
                try {
                    this.f1993h = c0263aw.m1981a(i, this.f1992g, new C0035b.a() { // from class: android.support.v7.widget.z.1
                        @Override // android.support.v4.p006a.p007a.C0035b.a
                        /* JADX INFO: renamed from: a */
                        public void mo189a(int i2) {
                        }

                        @Override // android.support.v4.p006a.p007a.C0035b.a
                        /* JADX INFO: renamed from: a */
                        public void mo191a(Typeface typeface2) {
                            C0295z.this.m2156a((WeakReference<TextView>) weakReference, typeface2);
                        }
                    });
                    if (this.f1993h != null) {
                        z = false;
                    }
                    this.f1994i = z;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1993h != null || (strM1990d = c0263aw.m1990d(i)) == null) {
                return;
            }
            this.f1993h = Typeface.create(strM1990d, this.f1992g);
            return;
        }
        if (c0263aw.m1996g(C0148a.j.TextAppearance_android_typeface)) {
            this.f1994i = false;
            switch (c0263aw.m1980a(C0148a.j.TextAppearance_android_typeface, 1)) {
                case 1:
                    typeface = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface = Typeface.SERIF;
                    break;
                case 3:
                    typeface = Typeface.MONOSPACE;
                    break;
                default:
                    return;
            }
            this.f1993h = typeface;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2156a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f1994i) {
            this.f1993h = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f1992g);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2157b(int i, float f) {
        this.f1991f.m1813a(i, f);
    }

    /* JADX INFO: renamed from: a */
    void mo1795a() {
        if (this.f1987b == null && this.f1988c == null && this.f1989d == null && this.f1990e == null) {
            return;
        }
        Drawable[] compoundDrawables = this.f1986a.getCompoundDrawables();
        m2162a(compoundDrawables[0], this.f1987b);
        m2162a(compoundDrawables[1], this.f1988c);
        m2162a(compoundDrawables[2], this.f1989d);
        m2162a(compoundDrawables[3], this.f1990e);
    }

    /* JADX INFO: renamed from: a */
    void m2158a(int i) {
        this.f1991f.m1812a(i);
    }

    /* JADX INFO: renamed from: a */
    void m2159a(int i, float f) {
        if (InterfaceC0136b.f751a || m2167c()) {
            return;
        }
        m2157b(i, f);
    }

    /* JADX INFO: renamed from: a */
    void m2160a(int i, int i2, int i3, int i4) {
        this.f1991f.m1814a(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: a */
    void m2161a(Context context, int i) {
        ColorStateList colorStateListM1992e;
        C0263aw c0263awM1976a = C0263aw.m1976a(context, i, C0148a.j.TextAppearance);
        if (c0263awM1976a.m1996g(C0148a.j.TextAppearance_textAllCaps)) {
            m2163a(c0263awM1976a.m1984a(C0148a.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && c0263awM1976a.m1996g(C0148a.j.TextAppearance_android_textColor) && (colorStateListM1992e = c0263awM1976a.m1992e(C0148a.j.TextAppearance_android_textColor)) != null) {
            this.f1986a.setTextColor(colorStateListM1992e);
        }
        m2154a(context, c0263awM1976a);
        c0263awM1976a.m1983a();
        if (this.f1993h != null) {
            this.f1986a.setTypeface(this.f1993h, this.f1992g);
        }
    }

    /* JADX INFO: renamed from: a */
    final void m2162a(Drawable drawable, C0261au c0261au) {
        if (drawable == null || c0261au == null) {
            return;
        }
        C0281l.m2095a(drawable, c0261au, this.f1986a.getDrawableState());
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    void mo1796a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListM1992e;
        ColorStateList colorStateListM1992e2;
        boolean z;
        boolean zM1984a;
        Context context = this.f1986a.getContext();
        C0281l c0281lM2092a = C0281l.m2092a();
        C0263aw c0263awM1978a = C0263aw.m1978a(context, attributeSet, C0148a.j.AppCompatTextHelper, i, 0);
        int iM1995g = c0263awM1978a.m1995g(C0148a.j.AppCompatTextHelper_android_textAppearance, -1);
        if (c0263awM1978a.m1996g(C0148a.j.AppCompatTextHelper_android_drawableLeft)) {
            this.f1987b = m2152a(context, c0281lM2092a, c0263awM1978a.m1995g(C0148a.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (c0263awM1978a.m1996g(C0148a.j.AppCompatTextHelper_android_drawableTop)) {
            this.f1988c = m2152a(context, c0281lM2092a, c0263awM1978a.m1995g(C0148a.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (c0263awM1978a.m1996g(C0148a.j.AppCompatTextHelper_android_drawableRight)) {
            this.f1989d = m2152a(context, c0281lM2092a, c0263awM1978a.m1995g(C0148a.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (c0263awM1978a.m1996g(C0148a.j.AppCompatTextHelper_android_drawableBottom)) {
            this.f1990e = m2152a(context, c0281lM2092a, c0263awM1978a.m1995g(C0148a.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        c0263awM1978a.m1983a();
        boolean z2 = this.f1986a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z3 = true;
        if (iM1995g != -1) {
            C0263aw c0263awM1976a = C0263aw.m1976a(context, iM1995g, C0148a.j.TextAppearance);
            if (z2 || !c0263awM1976a.m1996g(C0148a.j.TextAppearance_textAllCaps)) {
                z = false;
                zM1984a = false;
            } else {
                zM1984a = c0263awM1976a.m1984a(C0148a.j.TextAppearance_textAllCaps, false);
                z = true;
            }
            m2154a(context, c0263awM1976a);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList colorStateListM1992e3 = c0263awM1976a.m1996g(C0148a.j.TextAppearance_android_textColor) ? c0263awM1976a.m1992e(C0148a.j.TextAppearance_android_textColor) : null;
                colorStateListM1992e2 = c0263awM1976a.m1996g(C0148a.j.TextAppearance_android_textColorHint) ? c0263awM1976a.m1992e(C0148a.j.TextAppearance_android_textColorHint) : null;
                ColorStateList colorStateList = colorStateListM1992e3;
                colorStateListM1992e = c0263awM1976a.m1996g(C0148a.j.TextAppearance_android_textColorLink) ? c0263awM1976a.m1992e(C0148a.j.TextAppearance_android_textColorLink) : null;
                colorStateListM1992e = colorStateList;
            } else {
                colorStateListM1992e = null;
                colorStateListM1992e2 = null;
            }
            c0263awM1976a.m1983a();
        } else {
            colorStateListM1992e = null;
            colorStateListM1992e2 = null;
            z = false;
            zM1984a = false;
        }
        C0263aw c0263awM1978a2 = C0263aw.m1978a(context, attributeSet, C0148a.j.TextAppearance, i, 0);
        if (z2 || !c0263awM1978a2.m1996g(C0148a.j.TextAppearance_textAllCaps)) {
            z3 = z;
        } else {
            zM1984a = c0263awM1978a2.m1984a(C0148a.j.TextAppearance_textAllCaps, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (c0263awM1978a2.m1996g(C0148a.j.TextAppearance_android_textColor)) {
                colorStateListM1992e = c0263awM1978a2.m1992e(C0148a.j.TextAppearance_android_textColor);
            }
            if (c0263awM1978a2.m1996g(C0148a.j.TextAppearance_android_textColorHint)) {
                colorStateListM1992e2 = c0263awM1978a2.m1992e(C0148a.j.TextAppearance_android_textColorHint);
            }
            if (c0263awM1978a2.m1996g(C0148a.j.TextAppearance_android_textColorLink)) {
                colorStateListM1992e = c0263awM1978a2.m1992e(C0148a.j.TextAppearance_android_textColorLink);
            }
        }
        m2154a(context, c0263awM1978a2);
        c0263awM1978a2.m1983a();
        if (colorStateListM1992e != null) {
            this.f1986a.setTextColor(colorStateListM1992e);
        }
        if (colorStateListM1992e2 != null) {
            this.f1986a.setHintTextColor(colorStateListM1992e2);
        }
        if (colorStateListM1992e != null) {
            this.f1986a.setLinkTextColor(colorStateListM1992e);
        }
        if (!z2 && z3) {
            m2163a(zM1984a);
        }
        if (this.f1993h != null) {
            this.f1986a.setTypeface(this.f1993h, this.f1992g);
        }
        this.f1991f.m1815a(attributeSet, i);
        if (!InterfaceC0136b.f751a || this.f1991f.m1811a() == 0) {
            return;
        }
        int[] iArrM1820e = this.f1991f.m1820e();
        if (iArrM1820e.length > 0) {
            if (this.f1986a.getAutoSizeStepGranularity() != -1.0f) {
                this.f1986a.setAutoSizeTextTypeUniformWithConfiguration(this.f1991f.m1818c(), this.f1991f.m1819d(), this.f1991f.m1817b(), 0);
            } else {
                this.f1986a.setAutoSizeTextTypeUniformWithPresetSizes(iArrM1820e, 0);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m2163a(boolean z) {
        this.f1986a.setAllCaps(z);
    }

    /* JADX INFO: renamed from: a */
    void m2164a(boolean z, int i, int i2, int i3, int i4) {
        if (InterfaceC0136b.f751a) {
            return;
        }
        m2166b();
    }

    /* JADX INFO: renamed from: a */
    void m2165a(int[] iArr, int i) {
        this.f1991f.m1816a(iArr, i);
    }

    /* JADX INFO: renamed from: b */
    void m2166b() {
        this.f1991f.m1821f();
    }

    /* JADX INFO: renamed from: c */
    boolean m2167c() {
        return this.f1991f.m1822g();
    }

    /* JADX INFO: renamed from: d */
    int m2168d() {
        return this.f1991f.m1811a();
    }

    /* JADX INFO: renamed from: e */
    int m2169e() {
        return this.f1991f.m1817b();
    }

    /* JADX INFO: renamed from: f */
    int m2170f() {
        return this.f1991f.m1818c();
    }

    /* JADX INFO: renamed from: g */
    int m2171g() {
        return this.f1991f.m1819d();
    }

    /* JADX INFO: renamed from: h */
    int[] m2172h() {
        return this.f1991f.m1820e();
    }
}
