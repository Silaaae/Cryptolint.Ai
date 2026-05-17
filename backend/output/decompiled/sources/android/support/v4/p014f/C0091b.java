package android.support.v4.p014f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: android.support.v4.f.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0091b<E> implements Collection<E>, Set<E> {

    /* JADX INFO: renamed from: a */
    private static final int[] f577a = new int[0];

    /* JADX INFO: renamed from: b */
    private static final Object[] f578b = new Object[0];

    /* JADX INFO: renamed from: c */
    private static Object[] f579c;

    /* JADX INFO: renamed from: d */
    private static int f580d;

    /* JADX INFO: renamed from: e */
    private static Object[] f581e;

    /* JADX INFO: renamed from: f */
    private static int f582f;

    /* JADX INFO: renamed from: g */
    private int[] f583g;

    /* JADX INFO: renamed from: h */
    private Object[] f584h;

    /* JADX INFO: renamed from: i */
    private int f585i;

    /* JADX INFO: renamed from: j */
    private AbstractC0097h<E, E> f586j;

    public C0091b() {
        this(0);
    }

    public C0091b(int i) {
        if (i == 0) {
            this.f583g = f577a;
            this.f584h = f578b;
        } else {
            m774d(i);
        }
        this.f585i = 0;
    }

    /* JADX INFO: renamed from: a */
    private int m768a() {
        int i = this.f585i;
        if (i == 0) {
            return -1;
        }
        int iM780a = C0092c.m780a(this.f583g, i, 0);
        if (iM780a < 0 || this.f584h[iM780a] == null) {
            return iM780a;
        }
        int i2 = iM780a + 1;
        while (i2 < i && this.f583g[i2] == 0) {
            if (this.f584h[i2] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iM780a - 1; i3 >= 0 && this.f583g[i3] == 0; i3--) {
            if (this.f584h[i3] == null) {
                return i3;
            }
        }
        return i2 ^ (-1);
    }

    /* JADX INFO: renamed from: a */
    private int m770a(Object obj, int i) {
        int i2 = this.f585i;
        if (i2 == 0) {
            return -1;
        }
        int iM780a = C0092c.m780a(this.f583g, i2, i);
        if (iM780a < 0 || obj.equals(this.f584h[iM780a])) {
            return iM780a;
        }
        int i3 = iM780a + 1;
        while (i3 < i2 && this.f583g[i3] == i) {
            if (obj.equals(this.f584h[i3])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iM780a - 1; i4 >= 0 && this.f583g[i4] == i; i4--) {
            if (obj.equals(this.f584h[i4])) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    /* JADX INFO: renamed from: a */
    private static void m771a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (C0091b.class) {
                if (f582f < 10) {
                    objArr[0] = f581e;
                    objArr[1] = iArr;
                    for (int i2 = i - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f581e = objArr;
                    f582f++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (C0091b.class) {
                if (f580d < 10) {
                    objArr[0] = f579c;
                    objArr[1] = iArr;
                    for (int i3 = i - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    f579c = objArr;
                    f580d++;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private AbstractC0097h<E, E> m772b() {
        if (this.f586j == null) {
            this.f586j = new AbstractC0097h<E, E>() { // from class: android.support.v4.f.b.1
                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: a */
                protected int mo759a() {
                    return C0091b.this.f585i;
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: a */
                protected int mo760a(Object obj) {
                    return C0091b.this.m775a(obj);
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: a */
                protected Object mo761a(int i, int i2) {
                    return C0091b.this.f584h[i];
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: a */
                protected E mo762a(int i, E e) {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: a */
                protected void mo763a(int i) {
                    C0091b.this.m778c(i);
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: a */
                protected void mo764a(E e, E e2) {
                    C0091b.this.add(e);
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: b */
                protected int mo765b(Object obj) {
                    return C0091b.this.m775a(obj);
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: b */
                protected Map<E, E> mo766b() {
                    throw new UnsupportedOperationException("not a map");
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: c */
                protected void mo767c() {
                    C0091b.this.clear();
                }
            };
        }
        return this.f586j;
    }

    /* JADX INFO: renamed from: d */
    private void m774d(int i) {
        if (i == 8) {
            synchronized (C0091b.class) {
                if (f581e != null) {
                    Object[] objArr = f581e;
                    this.f584h = objArr;
                    f581e = (Object[]) objArr[0];
                    this.f583g = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f582f--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0091b.class) {
                if (f579c != null) {
                    Object[] objArr2 = f579c;
                    this.f584h = objArr2;
                    f579c = (Object[]) objArr2[0];
                    this.f583g = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f580d--;
                    return;
                }
            }
        }
        this.f583g = new int[i];
        this.f584h = new Object[i];
    }

    /* JADX INFO: renamed from: a */
    public int m775a(Object obj) {
        return obj == null ? m768a() : m770a(obj, obj.hashCode());
    }

    /* JADX INFO: renamed from: a */
    public void m776a(int i) {
        if (this.f583g.length < i) {
            int[] iArr = this.f583g;
            Object[] objArr = this.f584h;
            m774d(i);
            if (this.f585i > 0) {
                System.arraycopy(iArr, 0, this.f583g, 0, this.f585i);
                System.arraycopy(objArr, 0, this.f584h, 0, this.f585i);
            }
            m771a(iArr, objArr, this.f585i);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e) {
        int i;
        int iM770a;
        if (e == null) {
            iM770a = m768a();
            i = 0;
        } else {
            int iHashCode = e.hashCode();
            i = iHashCode;
            iM770a = m770a(e, iHashCode);
        }
        if (iM770a >= 0) {
            return false;
        }
        int i2 = iM770a ^ (-1);
        if (this.f585i >= this.f583g.length) {
            int i3 = 4;
            if (this.f585i >= 8) {
                i3 = (this.f585i >> 1) + this.f585i;
            } else if (this.f585i >= 4) {
                i3 = 8;
            }
            int[] iArr = this.f583g;
            Object[] objArr = this.f584h;
            m774d(i3);
            if (this.f583g.length > 0) {
                System.arraycopy(iArr, 0, this.f583g, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f584h, 0, objArr.length);
            }
            m771a(iArr, objArr, this.f585i);
        }
        if (i2 < this.f585i) {
            int i4 = i2 + 1;
            System.arraycopy(this.f583g, i2, this.f583g, i4, this.f585i - i2);
            System.arraycopy(this.f584h, i2, this.f584h, i4, this.f585i - i2);
        }
        this.f583g[i2] = i;
        this.f584h[i2] = e;
        this.f585i++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        m776a(this.f585i + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    /* JADX INFO: renamed from: b */
    public E m777b(int i) {
        return (E) this.f584h[i];
    }

    /* JADX INFO: renamed from: c */
    public E m778c(int i) {
        E e = (E) this.f584h[i];
        if (this.f585i <= 1) {
            m771a(this.f583g, this.f584h, this.f585i);
            this.f583g = f577a;
            this.f584h = f578b;
            this.f585i = 0;
        } else {
            int i2 = 8;
            if (this.f583g.length <= 8 || this.f585i >= this.f583g.length / 3) {
                this.f585i--;
                if (i < this.f585i) {
                    int i3 = i + 1;
                    System.arraycopy(this.f583g, i3, this.f583g, i, this.f585i - i);
                    System.arraycopy(this.f584h, i3, this.f584h, i, this.f585i - i);
                }
                this.f584h[this.f585i] = null;
            } else {
                if (this.f585i > 8) {
                    i2 = (this.f585i >> 1) + this.f585i;
                }
                int[] iArr = this.f583g;
                Object[] objArr = this.f584h;
                m774d(i2);
                this.f585i--;
                if (i > 0) {
                    System.arraycopy(iArr, 0, this.f583g, 0, i);
                    System.arraycopy(objArr, 0, this.f584h, 0, i);
                }
                if (i < this.f585i) {
                    int i4 = i + 1;
                    System.arraycopy(iArr, i4, this.f583g, i, this.f585i - i);
                    System.arraycopy(objArr, i4, this.f584h, i, this.f585i - i);
                }
            }
        }
        return e;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (this.f585i != 0) {
            m771a(this.f583g, this.f584h, this.f585i);
            this.f583g = f577a;
            this.f584h = f578b;
            this.f585i = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return m775a(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i = 0; i < this.f585i; i++) {
                try {
                    if (!set.contains(m777b(i))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f583g;
        int i = this.f585i;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += iArr[i3];
        }
        return i2;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f585i <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return m772b().m811e().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iM775a = m775a(obj);
        if (iM775a < 0) {
            return false;
        }
        m778c(iM775a);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.f585i - 1; i >= 0; i--) {
            if (!collection.contains(this.f584h[i])) {
                m778c(i);
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f585i;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        Object[] objArr = new Object[this.f585i];
        System.arraycopy(this.f584h, 0, objArr, 0, this.f585i);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f585i) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f585i));
        }
        System.arraycopy(this.f584h, 0, tArr, 0, this.f585i);
        if (tArr.length > this.f585i) {
            tArr[this.f585i] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f585i * 14);
        sb.append('{');
        for (int i = 0; i < this.f585i; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            E eM777b = m777b(i);
            if (eM777b != this) {
                sb.append(eM777b);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
