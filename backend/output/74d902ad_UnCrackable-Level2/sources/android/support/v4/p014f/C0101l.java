package android.support.v4.p014f;

/* JADX INFO: renamed from: android.support.v4.f.l */
/* JADX INFO: loaded from: classes.dex */
public class C0101l<E> implements Cloneable {

    /* JADX INFO: renamed from: a */
    private static final Object f630a = new Object();

    /* JADX INFO: renamed from: b */
    private boolean f631b;

    /* JADX INFO: renamed from: c */
    private int[] f632c;

    /* JADX INFO: renamed from: d */
    private Object[] f633d;

    /* JADX INFO: renamed from: e */
    private int f634e;

    public C0101l() {
        this(10);
    }

    public C0101l(int i) {
        Object[] objArr;
        this.f631b = false;
        if (i == 0) {
            this.f632c = C0092c.f588a;
            objArr = C0092c.f590c;
        } else {
            int iM779a = C0092c.m779a(i);
            this.f632c = new int[iM779a];
            objArr = new Object[iM779a];
        }
        this.f633d = objArr;
        this.f634e = 0;
    }

    /* JADX INFO: renamed from: d */
    private void m829d() {
        int i = this.f634e;
        int[] iArr = this.f632c;
        Object[] objArr = this.f633d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f630a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f631b = false;
        this.f634e = i2;
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0101l<E> clone() {
        try {
            C0101l<E> c0101l = (C0101l) super.clone();
            try {
                c0101l.f632c = (int[]) this.f632c.clone();
                c0101l.f633d = (Object[]) this.f633d.clone();
                return c0101l;
            } catch (CloneNotSupportedException unused) {
                return c0101l;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public E m831a(int i) {
        return m832a(i, null);
    }

    /* JADX INFO: renamed from: a */
    public E m832a(int i, E e) {
        int iM780a = C0092c.m780a(this.f632c, this.f634e, i);
        return (iM780a < 0 || this.f633d[iM780a] == f630a) ? e : (E) this.f633d[iM780a];
    }

    /* JADX INFO: renamed from: b */
    public int m833b() {
        if (this.f631b) {
            m829d();
        }
        return this.f634e;
    }

    /* JADX INFO: renamed from: b */
    public void m834b(int i) {
        int iM780a = C0092c.m780a(this.f632c, this.f634e, i);
        if (iM780a < 0 || this.f633d[iM780a] == f630a) {
            return;
        }
        this.f633d[iM780a] = f630a;
        this.f631b = true;
    }

    /* JADX INFO: renamed from: b */
    public void m835b(int i, E e) {
        int iM780a = C0092c.m780a(this.f632c, this.f634e, i);
        if (iM780a >= 0) {
            this.f633d[iM780a] = e;
            return;
        }
        int iM780a2 = iM780a ^ (-1);
        if (iM780a2 < this.f634e && this.f633d[iM780a2] == f630a) {
            this.f632c[iM780a2] = i;
            this.f633d[iM780a2] = e;
            return;
        }
        if (this.f631b && this.f634e >= this.f632c.length) {
            m829d();
            iM780a2 = C0092c.m780a(this.f632c, this.f634e, i) ^ (-1);
        }
        if (this.f634e >= this.f632c.length) {
            int iM779a = C0092c.m779a(this.f634e + 1);
            int[] iArr = new int[iM779a];
            Object[] objArr = new Object[iM779a];
            System.arraycopy(this.f632c, 0, iArr, 0, this.f632c.length);
            System.arraycopy(this.f633d, 0, objArr, 0, this.f633d.length);
            this.f632c = iArr;
            this.f633d = objArr;
        }
        if (this.f634e - iM780a2 != 0) {
            int i2 = iM780a2 + 1;
            System.arraycopy(this.f632c, iM780a2, this.f632c, i2, this.f634e - iM780a2);
            System.arraycopy(this.f633d, iM780a2, this.f633d, i2, this.f634e - iM780a2);
        }
        this.f632c[iM780a2] = i;
        this.f633d[iM780a2] = e;
        this.f634e++;
    }

    /* JADX INFO: renamed from: c */
    public void m836c() {
        int i = this.f634e;
        Object[] objArr = this.f633d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f634e = 0;
        this.f631b = false;
    }

    /* JADX INFO: renamed from: c */
    public void m837c(int i) {
        m834b(i);
    }

    /* JADX INFO: renamed from: c */
    public void m838c(int i, E e) {
        if (this.f634e != 0 && i <= this.f632c[this.f634e - 1]) {
            m835b(i, e);
            return;
        }
        if (this.f631b && this.f634e >= this.f632c.length) {
            m829d();
        }
        int i2 = this.f634e;
        if (i2 >= this.f632c.length) {
            int iM779a = C0092c.m779a(i2 + 1);
            int[] iArr = new int[iM779a];
            Object[] objArr = new Object[iM779a];
            System.arraycopy(this.f632c, 0, iArr, 0, this.f632c.length);
            System.arraycopy(this.f633d, 0, objArr, 0, this.f633d.length);
            this.f632c = iArr;
            this.f633d = objArr;
        }
        this.f632c[i2] = i;
        this.f633d[i2] = e;
        this.f634e = i2 + 1;
    }

    /* JADX INFO: renamed from: d */
    public int m839d(int i) {
        if (this.f631b) {
            m829d();
        }
        return this.f632c[i];
    }

    /* JADX INFO: renamed from: e */
    public E m840e(int i) {
        if (this.f631b) {
            m829d();
        }
        return (E) this.f633d[i];
    }

    public String toString() {
        if (m833b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f634e * 28);
        sb.append('{');
        for (int i = 0; i < this.f634e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m839d(i));
            sb.append('=');
            E eM840e = m840e(i);
            if (eM840e != this) {
                sb.append(eM840e);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
