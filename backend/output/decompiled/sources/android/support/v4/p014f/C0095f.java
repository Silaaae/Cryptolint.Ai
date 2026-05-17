package android.support.v4.p014f;

/* JADX INFO: renamed from: android.support.v4.f.f */
/* JADX INFO: loaded from: classes.dex */
public class C0095f<E> implements Cloneable {

    /* JADX INFO: renamed from: a */
    private static final Object f593a = new Object();

    /* JADX INFO: renamed from: b */
    private boolean f594b;

    /* JADX INFO: renamed from: c */
    private long[] f595c;

    /* JADX INFO: renamed from: d */
    private Object[] f596d;

    /* JADX INFO: renamed from: e */
    private int f597e;

    public C0095f() {
        this(10);
    }

    public C0095f(int i) {
        Object[] objArr;
        this.f594b = false;
        if (i == 0) {
            this.f595c = C0092c.f589b;
            objArr = C0092c.f590c;
        } else {
            int iM783b = C0092c.m783b(i);
            this.f595c = new long[iM783b];
            objArr = new Object[iM783b];
        }
        this.f596d = objArr;
        this.f597e = 0;
    }

    /* JADX INFO: renamed from: d */
    private void m787d() {
        int i = this.f597e;
        long[] jArr = this.f595c;
        Object[] objArr = this.f596d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f593a) {
                if (i3 != i2) {
                    jArr[i2] = jArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f594b = false;
        this.f597e = i2;
    }

    /* JADX INFO: renamed from: a */
    public long m788a(int i) {
        if (this.f594b) {
            m787d();
        }
        return this.f595c[i];
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0095f<E> clone() {
        try {
            C0095f<E> c0095f = (C0095f) super.clone();
            try {
                c0095f.f595c = (long[]) this.f595c.clone();
                c0095f.f596d = (Object[]) this.f596d.clone();
                return c0095f;
            } catch (CloneNotSupportedException unused) {
                return c0095f;
            }
        } catch (CloneNotSupportedException unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public E m790a(long j) {
        return m791a(j, null);
    }

    /* JADX INFO: renamed from: a */
    public E m791a(long j, E e) {
        int iM781a = C0092c.m781a(this.f595c, this.f597e, j);
        return (iM781a < 0 || this.f596d[iM781a] == f593a) ? e : (E) this.f596d[iM781a];
    }

    /* JADX INFO: renamed from: b */
    public int m792b() {
        if (this.f594b) {
            m787d();
        }
        return this.f597e;
    }

    /* JADX INFO: renamed from: b */
    public E m793b(int i) {
        if (this.f594b) {
            m787d();
        }
        return (E) this.f596d[i];
    }

    /* JADX INFO: renamed from: b */
    public void m794b(long j) {
        int iM781a = C0092c.m781a(this.f595c, this.f597e, j);
        if (iM781a < 0 || this.f596d[iM781a] == f593a) {
            return;
        }
        this.f596d[iM781a] = f593a;
        this.f594b = true;
    }

    /* JADX INFO: renamed from: b */
    public void m795b(long j, E e) {
        int iM781a = C0092c.m781a(this.f595c, this.f597e, j);
        if (iM781a >= 0) {
            this.f596d[iM781a] = e;
            return;
        }
        int iM781a2 = iM781a ^ (-1);
        if (iM781a2 < this.f597e && this.f596d[iM781a2] == f593a) {
            this.f595c[iM781a2] = j;
            this.f596d[iM781a2] = e;
            return;
        }
        if (this.f594b && this.f597e >= this.f595c.length) {
            m787d();
            iM781a2 = C0092c.m781a(this.f595c, this.f597e, j) ^ (-1);
        }
        if (this.f597e >= this.f595c.length) {
            int iM783b = C0092c.m783b(this.f597e + 1);
            long[] jArr = new long[iM783b];
            Object[] objArr = new Object[iM783b];
            System.arraycopy(this.f595c, 0, jArr, 0, this.f595c.length);
            System.arraycopy(this.f596d, 0, objArr, 0, this.f596d.length);
            this.f595c = jArr;
            this.f596d = objArr;
        }
        if (this.f597e - iM781a2 != 0) {
            int i = iM781a2 + 1;
            System.arraycopy(this.f595c, iM781a2, this.f595c, i, this.f597e - iM781a2);
            System.arraycopy(this.f596d, iM781a2, this.f596d, i, this.f597e - iM781a2);
        }
        this.f595c[iM781a2] = j;
        this.f596d[iM781a2] = e;
        this.f597e++;
    }

    /* JADX INFO: renamed from: c */
    public void m796c() {
        int i = this.f597e;
        Object[] objArr = this.f596d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f597e = 0;
        this.f594b = false;
    }

    public String toString() {
        if (m792b() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f597e * 28);
        sb.append('{');
        for (int i = 0; i < this.f597e; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(m788a(i));
            sb.append('=');
            E eM793b = m793b(i);
            if (eM793b != this) {
                sb.append(eM793b);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
