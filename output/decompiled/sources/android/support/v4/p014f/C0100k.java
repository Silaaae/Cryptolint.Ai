package android.support.v4.p014f;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: renamed from: android.support.v4.f.k */
/* JADX INFO: loaded from: classes.dex */
public class C0100k<K, V> {

    /* JADX INFO: renamed from: b */
    static Object[] f623b;

    /* JADX INFO: renamed from: c */
    static int f624c;

    /* JADX INFO: renamed from: d */
    static Object[] f625d;

    /* JADX INFO: renamed from: e */
    static int f626e;

    /* JADX INFO: renamed from: f */
    int[] f627f;

    /* JADX INFO: renamed from: g */
    Object[] f628g;

    /* JADX INFO: renamed from: h */
    int f629h;

    public C0100k() {
        this.f627f = C0092c.f588a;
        this.f628g = C0092c.f590c;
        this.f629h = 0;
    }

    public C0100k(int i) {
        if (i == 0) {
            this.f627f = C0092c.f588a;
            this.f628g = C0092c.f590c;
        } else {
            m819e(i);
        }
        this.f629h = 0;
    }

    /* JADX INFO: renamed from: a */
    private static int m817a(int[] iArr, int i, int i2) {
        try {
            return C0092c.m780a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m818a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0090a.class) {
                if (f626e < 10) {
                    objArr[0] = f625d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f625d = objArr;
                    f626e++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C0090a.class) {
                if (f624c < 10) {
                    objArr[0] = f623b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f623b = objArr;
                    f624c++;
                }
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m819e(int i) {
        if (i == 8) {
            synchronized (C0090a.class) {
                if (f625d != null) {
                    Object[] objArr = f625d;
                    this.f628g = objArr;
                    f625d = (Object[]) objArr[0];
                    this.f627f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f626e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0090a.class) {
                if (f623b != null) {
                    Object[] objArr2 = f623b;
                    this.f628g = objArr2;
                    f623b = (Object[]) objArr2[0];
                    this.f627f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f624c--;
                    return;
                }
            }
        }
        this.f627f = new int[i];
        this.f628g = new Object[i << 1];
    }

    /* JADX INFO: renamed from: a */
    int m820a() {
        int i = this.f629h;
        if (i == 0) {
            return -1;
        }
        int iM817a = m817a(this.f627f, i, 0);
        if (iM817a < 0 || this.f628g[iM817a << 1] == null) {
            return iM817a;
        }
        int i2 = iM817a + 1;
        while (i2 < i && this.f627f[i2] == 0) {
            if (this.f628g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iM817a - 1; i3 >= 0 && this.f627f[i3] == 0; i3--) {
            if (this.f628g[i3 << 1] == null) {
                return i3;
            }
        }
        return i2 ^ (-1);
    }

    /* JADX INFO: renamed from: a */
    public int m821a(Object obj) {
        return obj == null ? m820a() : m822a(obj, obj.hashCode());
    }

    /* JADX INFO: renamed from: a */
    int m822a(Object obj, int i) {
        int i2 = this.f629h;
        if (i2 == 0) {
            return -1;
        }
        int iM817a = m817a(this.f627f, i2, i);
        if (iM817a < 0 || obj.equals(this.f628g[iM817a << 1])) {
            return iM817a;
        }
        int i3 = iM817a + 1;
        while (i3 < i2 && this.f627f[i3] == i) {
            if (obj.equals(this.f628g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iM817a - 1; i4 >= 0 && this.f627f[i4] == i; i4--) {
            if (obj.equals(this.f628g[i4 << 1])) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    /* JADX INFO: renamed from: a */
    public V m823a(int i, V v) {
        int i2 = (i << 1) + 1;
        V v2 = (V) this.f628g[i2];
        this.f628g[i2] = v;
        return v2;
    }

    /* JADX INFO: renamed from: a */
    public void m824a(int i) {
        int i2 = this.f629h;
        if (this.f627f.length < i) {
            int[] iArr = this.f627f;
            Object[] objArr = this.f628g;
            m819e(i);
            if (this.f629h > 0) {
                System.arraycopy(iArr, 0, this.f627f, 0, i2);
                System.arraycopy(objArr, 0, this.f628g, 0, i2 << 1);
            }
            m818a(iArr, objArr, i2);
        }
        if (this.f629h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    /* JADX INFO: renamed from: b */
    int m825b(Object obj) {
        int i = this.f629h * 2;
        Object[] objArr = this.f628g;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: b */
    public K m826b(int i) {
        return (K) this.f628g[i << 1];
    }

    /* JADX INFO: renamed from: c */
    public V m827c(int i) {
        return (V) this.f628g[(i << 1) + 1];
    }

    public void clear() {
        if (this.f629h > 0) {
            int[] iArr = this.f627f;
            Object[] objArr = this.f628g;
            int i = this.f629h;
            this.f627f = C0092c.f588a;
            this.f628g = C0092c.f590c;
            this.f629h = 0;
            m818a(iArr, objArr, i);
        }
        if (this.f629h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return m821a(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return m825b(obj) >= 0;
    }

    /* JADX INFO: renamed from: d */
    public V m828d(int i) {
        int i2 = i << 1;
        V v = (V) this.f628g[i2 + 1];
        int i3 = this.f629h;
        int i4 = 0;
        if (i3 <= 1) {
            m818a(this.f627f, this.f628g, i3);
            this.f627f = C0092c.f588a;
            this.f628g = C0092c.f590c;
        } else {
            int i5 = i3 - 1;
            if (this.f627f.length <= 8 || this.f629h >= this.f627f.length / 3) {
                if (i < i5) {
                    int i6 = i + 1;
                    int i7 = i5 - i;
                    System.arraycopy(this.f627f, i6, this.f627f, i, i7);
                    System.arraycopy(this.f628g, i6 << 1, this.f628g, i2, i7 << 1);
                }
                int i8 = i5 << 1;
                this.f628g[i8] = null;
                this.f628g[i8 + 1] = null;
            } else {
                int i9 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                int[] iArr = this.f627f;
                Object[] objArr = this.f628g;
                m819e(i9);
                if (i3 != this.f629h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f627f, 0, i);
                    System.arraycopy(objArr, 0, this.f628g, 0, i2);
                }
                if (i < i5) {
                    int i10 = i + 1;
                    int i11 = i5 - i;
                    System.arraycopy(iArr, i10, this.f627f, i, i11);
                    System.arraycopy(objArr, i10 << 1, this.f628g, i2, i11 << 1);
                }
            }
            i4 = i5;
        }
        if (i3 != this.f629h) {
            throw new ConcurrentModificationException();
        }
        this.f629h = i4;
        return v;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0100k) {
            C0100k c0100k = (C0100k) obj;
            if (size() != c0100k.size()) {
                return false;
            }
            for (int i = 0; i < this.f629h; i++) {
                try {
                    K kM826b = m826b(i);
                    V vM827c = m827c(i);
                    Object obj2 = c0100k.get(kM826b);
                    if (vM827c == null) {
                        if (obj2 != null || !c0100k.containsKey(kM826b)) {
                            return false;
                        }
                    } else if (!vM827c.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.f629h; i2++) {
                try {
                    K kM826b2 = m826b(i2);
                    V vM827c2 = m827c(i2);
                    Object obj3 = map.get(kM826b2);
                    if (vM827c2 == null) {
                        if (obj3 != null || !map.containsKey(kM826b2)) {
                            return false;
                        }
                    } else if (!vM827c2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public V get(Object obj) {
        int iM821a = m821a(obj);
        if (iM821a >= 0) {
            return (V) this.f628g[(iM821a << 1) + 1];
        }
        return null;
    }

    public int hashCode() {
        int[] iArr = this.f627f;
        Object[] objArr = this.f628g;
        int i = this.f629h;
        int i2 = 0;
        int i3 = 1;
        int iHashCode = 0;
        while (i2 < i) {
            Object obj = objArr[i3];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i3 += 2;
        }
        return iHashCode;
    }

    public boolean isEmpty() {
        return this.f629h <= 0;
    }

    public V put(K k, V v) {
        int i;
        int iM822a;
        int i2 = this.f629h;
        if (k == null) {
            iM822a = m820a();
            i = 0;
        } else {
            int iHashCode = k.hashCode();
            i = iHashCode;
            iM822a = m822a(k, iHashCode);
        }
        if (iM822a >= 0) {
            int i3 = (iM822a << 1) + 1;
            V v2 = (V) this.f628g[i3];
            this.f628g[i3] = v;
            return v2;
        }
        int i4 = iM822a ^ (-1);
        if (i2 >= this.f627f.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f627f;
            Object[] objArr = this.f628g;
            m819e(i5);
            if (i2 != this.f629h) {
                throw new ConcurrentModificationException();
            }
            if (this.f627f.length > 0) {
                System.arraycopy(iArr, 0, this.f627f, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f628g, 0, objArr.length);
            }
            m818a(iArr, objArr, i2);
        }
        if (i4 < i2) {
            int i6 = i4 + 1;
            System.arraycopy(this.f627f, i4, this.f627f, i6, i2 - i4);
            System.arraycopy(this.f628g, i4 << 1, this.f628g, i6 << 1, (this.f629h - i4) << 1);
        }
        if (i2 != this.f629h || i4 >= this.f627f.length) {
            throw new ConcurrentModificationException();
        }
        this.f627f[i4] = i;
        int i7 = i4 << 1;
        this.f628g[i7] = k;
        this.f628g[i7 + 1] = v;
        this.f629h++;
        return null;
    }

    public V remove(Object obj) {
        int iM821a = m821a(obj);
        if (iM821a >= 0) {
            return m828d(iM821a);
        }
        return null;
    }

    public int size() {
        return this.f629h;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f629h * 28);
        sb.append('{');
        for (int i = 0; i < this.f629h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K kM826b = m826b(i);
            if (kM826b != this) {
                sb.append(kM826b);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vM827c = m827c(i);
            if (vM827c != this) {
                sb.append(vM827c);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
