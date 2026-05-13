package android.support.v7.p019b.p020a;

import java.lang.reflect.Array;

/* JADX INFO: renamed from: android.support.v7.b.a.c */
/* JADX INFO: loaded from: classes.dex */
final class C0176c {

    /* JADX INFO: renamed from: a */
    static final /* synthetic */ boolean f1082a = !C0176c.class.desiredAssertionStatus();

    private C0176c() {
    }

    /* JADX INFO: renamed from: a */
    public static int m1400a(int i) {
        if (i <= 4) {
            return 8;
        }
        return i * 2;
    }

    /* JADX INFO: renamed from: a */
    public static int[] m1401a(int[] iArr, int i, int i2) {
        if (!f1082a && i > iArr.length) {
            throw new AssertionError();
        }
        if (i + 1 > iArr.length) {
            int[] iArr2 = new int[m1400a(i)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr = iArr2;
        }
        iArr[i] = i2;
        return iArr;
    }

    /* JADX INFO: renamed from: a */
    public static <T> T[] m1402a(T[] tArr, int i, T t) {
        if (!f1082a && i > tArr.length) {
            throw new AssertionError();
        }
        if (i + 1 > tArr.length) {
            Object[] objArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), m1400a(i));
            System.arraycopy(tArr, 0, objArr, 0, i);
            tArr = (T[]) objArr;
        }
        tArr[i] = t;
        return tArr;
    }
}
