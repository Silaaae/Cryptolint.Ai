package android.support.v4.p014f;

/* JADX INFO: renamed from: android.support.v4.f.c */
/* JADX INFO: loaded from: classes.dex */
class C0092c {

    /* JADX INFO: renamed from: a */
    static final int[] f588a = new int[0];

    /* JADX INFO: renamed from: b */
    static final long[] f589b = new long[0];

    /* JADX INFO: renamed from: c */
    static final Object[] f590c = new Object[0];

    /* JADX INFO: renamed from: a */
    public static int m779a(int i) {
        return m784c(i * 4) / 4;
    }

    /* JADX INFO: renamed from: a */
    static int m780a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return i4 ^ (-1);
    }

    /* JADX INFO: renamed from: a */
    static int m781a(long[] jArr, int i, long j) {
        int i2 = i - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            long j2 = jArr[i4];
            if (j2 < j) {
                i3 = i4 + 1;
            } else {
                if (j2 <= j) {
                    return i4;
                }
                i2 = i4 - 1;
            }
        }
        return i3 ^ (-1);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m782a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: renamed from: b */
    public static int m783b(int i) {
        return m784c(i * 8) / 8;
    }

    /* JADX INFO: renamed from: c */
    public static int m784c(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }
}
