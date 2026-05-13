package android.support.v4.p008b;

import android.graphics.Color;

/* JADX INFO: renamed from: android.support.v4.b.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0069a {

    /* JADX INFO: renamed from: a */
    private static final ThreadLocal<double[]> f491a = new ThreadLocal<>();

    /* JADX INFO: renamed from: a */
    public static int m640a(int i, int i2) {
        int iAlpha = Color.alpha(i2);
        int iAlpha2 = Color.alpha(i);
        int iM643c = m643c(iAlpha2, iAlpha);
        return Color.argb(iM643c, m641a(Color.red(i), iAlpha2, Color.red(i2), iAlpha, iM643c), m641a(Color.green(i), iAlpha2, Color.green(i2), iAlpha, iM643c), m641a(Color.blue(i), iAlpha2, Color.blue(i2), iAlpha, iM643c));
    }

    /* JADX INFO: renamed from: a */
    private static int m641a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    /* JADX INFO: renamed from: b */
    public static int m642b(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & 16777215) | (i2 << 24);
    }

    /* JADX INFO: renamed from: c */
    private static int m643c(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }
}
