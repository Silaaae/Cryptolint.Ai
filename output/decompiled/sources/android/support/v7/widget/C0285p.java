package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v4.widget.C0141g;
import android.support.v7.p018a.C0148a;
import android.support.v7.p019b.p020a.C0175b;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: renamed from: android.support.v7.widget.p */
/* JADX INFO: loaded from: classes.dex */
public class C0285p {

    /* JADX INFO: renamed from: a */
    private final ImageView f1940a;

    /* JADX INFO: renamed from: b */
    private C0261au f1941b;

    /* JADX INFO: renamed from: c */
    private C0261au f1942c;

    /* JADX INFO: renamed from: d */
    private C0261au f1943d;

    public C0285p(ImageView imageView) {
        this.f1940a = imageView;
    }

    /* JADX INFO: renamed from: a */
    private boolean m2121a(Drawable drawable) {
        if (this.f1943d == null) {
            this.f1943d = new C0261au();
        }
        C0261au c0261au = this.f1943d;
        c0261au.m1975a();
        ColorStateList colorStateListM1126a = C0141g.m1126a(this.f1940a);
        if (colorStateListM1126a != null) {
            c0261au.f1798d = true;
            c0261au.f1795a = colorStateListM1126a;
        }
        PorterDuff.Mode modeM1129b = C0141g.m1129b(this.f1940a);
        if (modeM1129b != null) {
            c0261au.f1797c = true;
            c0261au.f1796b = modeM1129b;
        }
        if (!c0261au.f1798d && !c0261au.f1797c) {
            return false;
        }
        C0281l.m2095a(drawable, c0261au, this.f1940a.getDrawableState());
        return true;
    }

    /* JADX INFO: renamed from: e */
    private boolean m2122e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f1941b != null : i == 21;
    }

    /* JADX INFO: renamed from: a */
    public void m2123a(int i) {
        if (i != 0) {
            Drawable drawableM1396b = C0175b.m1396b(this.f1940a.getContext(), i);
            if (drawableM1396b != null) {
                C0246af.m1854a(drawableM1396b);
            }
            this.f1940a.setImageDrawable(drawableM1396b);
        } else {
            this.f1940a.setImageDrawable(null);
        }
        m2130d();
    }

    /* JADX INFO: renamed from: a */
    void m2124a(ColorStateList colorStateList) {
        if (this.f1942c == null) {
            this.f1942c = new C0261au();
        }
        this.f1942c.f1795a = colorStateList;
        this.f1942c.f1798d = true;
        m2130d();
    }

    /* JADX INFO: renamed from: a */
    void m2125a(PorterDuff.Mode mode) {
        if (this.f1942c == null) {
            this.f1942c = new C0261au();
        }
        this.f1942c.f1796b = mode;
        this.f1942c.f1797c = true;
        m2130d();
    }

    /* JADX INFO: renamed from: a */
    public void m2126a(AttributeSet attributeSet, int i) {
        int iM1995g;
        C0263aw c0263awM1978a = C0263aw.m1978a(this.f1940a.getContext(), attributeSet, C0148a.j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f1940a.getDrawable();
            if (drawable == null && (iM1995g = c0263awM1978a.m1995g(C0148a.j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = C0175b.m1396b(this.f1940a.getContext(), iM1995g)) != null) {
                this.f1940a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                C0246af.m1854a(drawable);
            }
            if (c0263awM1978a.m1996g(C0148a.j.AppCompatImageView_tint)) {
                C0141g.m1127a(this.f1940a, c0263awM1978a.m1992e(C0148a.j.AppCompatImageView_tint));
            }
            if (c0263awM1978a.m1996g(C0148a.j.AppCompatImageView_tintMode)) {
                C0141g.m1128a(this.f1940a, C0246af.m1853a(c0263awM1978a.m1980a(C0148a.j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            c0263awM1978a.m1983a();
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m2127a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f1940a.getBackground() instanceof RippleDrawable);
    }

    /* JADX INFO: renamed from: b */
    ColorStateList m2128b() {
        if (this.f1942c != null) {
            return this.f1942c.f1795a;
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    PorterDuff.Mode m2129c() {
        if (this.f1942c != null) {
            return this.f1942c.f1796b;
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    void m2130d() {
        C0261au c0261au;
        Drawable drawable = this.f1940a.getDrawable();
        if (drawable != null) {
            C0246af.m1854a(drawable);
        }
        if (drawable != null) {
            if (m2122e() && m2121a(drawable)) {
                return;
            }
            if (this.f1942c != null) {
                c0261au = this.f1942c;
            } else if (this.f1941b == null) {
                return;
            } else {
                c0261au = this.f1941b;
            }
            C0281l.m2095a(drawable, c0261au, this.f1940a.getDrawableState());
        }
    }
}
