package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.p008b.C0069a;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: renamed from: android.support.v7.widget.ar */
/* JADX INFO: loaded from: classes.dex */
class C0258ar {

    /* JADX INFO: renamed from: i */
    private static final ThreadLocal<TypedValue> f1789i = new ThreadLocal<>();

    /* JADX INFO: renamed from: a */
    static final int[] f1781a = {-16842910};

    /* JADX INFO: renamed from: b */
    static final int[] f1782b = {R.attr.state_focused};

    /* JADX INFO: renamed from: c */
    static final int[] f1783c = {R.attr.state_activated};

    /* JADX INFO: renamed from: d */
    static final int[] f1784d = {R.attr.state_pressed};

    /* JADX INFO: renamed from: e */
    static final int[] f1785e = {R.attr.state_checked};

    /* JADX INFO: renamed from: f */
    static final int[] f1786f = {R.attr.state_selected};

    /* JADX INFO: renamed from: g */
    static final int[] f1787g = {-16842919, -16842908};

    /* JADX INFO: renamed from: h */
    static final int[] f1788h = new int[0];

    /* JADX INFO: renamed from: j */
    private static final int[] f1790j = new int[1];

    /* JADX INFO: renamed from: a */
    public static int m1966a(Context context, int i) {
        f1790j[0] = i;
        C0263aw c0263awM1977a = C0263aw.m1977a(context, (AttributeSet) null, f1790j);
        try {
            return c0263awM1977a.m1985b(0, 0);
        } finally {
            c0263awM1977a.m1983a();
        }
    }

    /* JADX INFO: renamed from: a */
    static int m1967a(Context context, int i, float f) {
        return C0069a.m642b(m1966a(context, i), Math.round(Color.alpha(r0) * f));
    }

    /* JADX INFO: renamed from: a */
    private static TypedValue m1968a() {
        TypedValue typedValue = f1789i.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f1789i.set(typedValue2);
        return typedValue2;
    }

    /* JADX INFO: renamed from: b */
    public static ColorStateList m1969b(Context context, int i) {
        f1790j[0] = i;
        C0263aw c0263awM1977a = C0263aw.m1977a(context, (AttributeSet) null, f1790j);
        try {
            return c0263awM1977a.m1992e(0);
        } finally {
            c0263awM1977a.m1983a();
        }
    }

    /* JADX INFO: renamed from: c */
    public static int m1970c(Context context, int i) {
        ColorStateList colorStateListM1969b = m1969b(context, i);
        if (colorStateListM1969b != null && colorStateListM1969b.isStateful()) {
            return colorStateListM1969b.getColorForState(f1781a, colorStateListM1969b.getDefaultColor());
        }
        TypedValue typedValueM1968a = m1968a();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueM1968a, true);
        return m1967a(context, i, typedValueM1968a.getFloat());
    }
}
