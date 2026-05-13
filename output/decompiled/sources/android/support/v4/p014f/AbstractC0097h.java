package android.support.v4.p014f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: renamed from: android.support.v4.f.h */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0097h<K, V> {

    /* JADX INFO: renamed from: b */
    AbstractC0097h<K, V>.b f606b;

    /* JADX INFO: renamed from: c */
    AbstractC0097h<K, V>.c f607c;

    /* JADX INFO: renamed from: d */
    AbstractC0097h<K, V>.e f608d;

    /* JADX INFO: renamed from: android.support.v4.f.h$a */
    final class a<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a */
        final int f609a;

        /* JADX INFO: renamed from: b */
        int f610b;

        /* JADX INFO: renamed from: c */
        int f611c;

        /* JADX INFO: renamed from: d */
        boolean f612d = false;

        a(int i) {
            this.f609a = i;
            this.f610b = AbstractC0097h.this.mo759a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f611c < this.f610b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) AbstractC0097h.this.mo761a(this.f611c, this.f609a);
            this.f611c++;
            this.f612d = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f612d) {
                throw new IllegalStateException();
            }
            this.f611c--;
            this.f610b--;
            this.f612d = false;
            AbstractC0097h.this.mo763a(this.f611c);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.f.h$b */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int iMo759a = AbstractC0097h.this.mo759a();
            for (Map.Entry<K, V> entry : collection) {
                AbstractC0097h.this.mo764a(entry.getKey(), entry.getValue());
            }
            return iMo759a != AbstractC0097h.this.mo759a();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0097h.this.mo767c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iMo760a = AbstractC0097h.this.mo760a(entry.getKey());
            if (iMo760a < 0) {
                return false;
            }
            return C0092c.m782a(AbstractC0097h.this.mo761a(iMo760a, 1), entry.getValue());
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0097h.m805a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iMo759a = AbstractC0097h.this.mo759a() - 1; iMo759a >= 0; iMo759a--) {
                Object objMo761a = AbstractC0097h.this.mo761a(iMo759a, 0);
                Object objMo761a2 = AbstractC0097h.this.mo761a(iMo759a, 1);
                iHashCode += (objMo761a == null ? 0 : objMo761a.hashCode()) ^ (objMo761a2 == null ? 0 : objMo761a2.hashCode());
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0097h.this.mo759a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0097h.this.mo759a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: renamed from: android.support.v4.f.h$c */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0097h.this.mo767c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0097h.this.mo760a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return AbstractC0097h.m804a((Map) AbstractC0097h.this.mo766b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0097h.m805a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int iMo759a = AbstractC0097h.this.mo759a() - 1; iMo759a >= 0; iMo759a--) {
                Object objMo761a = AbstractC0097h.this.mo761a(iMo759a, 0);
                iHashCode += objMo761a == null ? 0 : objMo761a.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0097h.this.mo759a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iMo760a = AbstractC0097h.this.mo760a(obj);
            if (iMo760a < 0) {
                return false;
            }
            AbstractC0097h.this.mo763a(iMo760a);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return AbstractC0097h.m806b(AbstractC0097h.this.mo766b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return AbstractC0097h.m807c(AbstractC0097h.this.mo766b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0097h.this.mo759a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return AbstractC0097h.this.m809b(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC0097h.this.m808a(tArr, 0);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.f.h$d */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* JADX INFO: renamed from: a */
        int f616a;

        /* JADX INFO: renamed from: c */
        boolean f618c = false;

        /* JADX INFO: renamed from: b */
        int f617b = -1;

        d() {
            this.f616a = AbstractC0097h.this.mo759a() - 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f617b++;
            this.f618c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f618c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return C0092c.m782a(entry.getKey(), AbstractC0097h.this.mo761a(this.f617b, 0)) && C0092c.m782a(entry.getValue(), AbstractC0097h.this.mo761a(this.f617b, 1));
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f618c) {
                return (K) AbstractC0097h.this.mo761a(this.f617b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f618c) {
                return (V) AbstractC0097h.this.mo761a(this.f617b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f617b < this.f616a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f618c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objMo761a = AbstractC0097h.this.mo761a(this.f617b, 0);
            Object objMo761a2 = AbstractC0097h.this.mo761a(this.f617b, 1);
            return (objMo761a == null ? 0 : objMo761a.hashCode()) ^ (objMo761a2 != null ? objMo761a2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f618c) {
                throw new IllegalStateException();
            }
            AbstractC0097h.this.mo763a(this.f617b);
            this.f617b--;
            this.f616a--;
            this.f618c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f618c) {
                return (V) AbstractC0097h.this.mo762a(this.f617b, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* JADX INFO: renamed from: android.support.v4.f.h$e */
    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            AbstractC0097h.this.mo767c();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0097h.this.mo765b(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return AbstractC0097h.this.mo759a() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iMo765b = AbstractC0097h.this.mo765b(obj);
            if (iMo765b < 0) {
                return false;
            }
            AbstractC0097h.this.mo763a(iMo765b);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int iMo759a = AbstractC0097h.this.mo759a();
            int i = 0;
            boolean z = false;
            while (i < iMo759a) {
                if (collection.contains(AbstractC0097h.this.mo761a(i, 1))) {
                    AbstractC0097h.this.mo763a(i);
                    i--;
                    iMo759a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int iMo759a = AbstractC0097h.this.mo759a();
            int i = 0;
            boolean z = false;
            while (i < iMo759a) {
                if (!collection.contains(AbstractC0097h.this.mo761a(i, 1))) {
                    AbstractC0097h.this.mo763a(i);
                    i--;
                    iMo759a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return AbstractC0097h.this.mo759a();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return AbstractC0097h.this.m809b(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC0097h.this.m808a(tArr, 1);
        }
    }

    AbstractC0097h() {
    }

    /* JADX INFO: renamed from: a */
    public static <K, V> boolean m804a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static <T> boolean m805a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static <K, V> boolean m806b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    /* JADX INFO: renamed from: c */
    public static <K, V> boolean m807c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* JADX INFO: renamed from: a */
    protected abstract int mo759a();

    /* JADX INFO: renamed from: a */
    protected abstract int mo760a(Object obj);

    /* JADX INFO: renamed from: a */
    protected abstract Object mo761a(int i, int i2);

    /* JADX INFO: renamed from: a */
    protected abstract V mo762a(int i, V v);

    /* JADX INFO: renamed from: a */
    protected abstract void mo763a(int i);

    /* JADX INFO: renamed from: a */
    protected abstract void mo764a(K k, V v);

    /* JADX INFO: renamed from: a */
    public <T> T[] m808a(T[] tArr, int i) {
        int iMo759a = mo759a();
        if (tArr.length < iMo759a) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iMo759a));
        }
        for (int i2 = 0; i2 < iMo759a; i2++) {
            tArr[i2] = mo761a(i2, i);
        }
        if (tArr.length > iMo759a) {
            tArr[iMo759a] = null;
        }
        return tArr;
    }

    /* JADX INFO: renamed from: b */
    protected abstract int mo765b(Object obj);

    /* JADX INFO: renamed from: b */
    protected abstract Map<K, V> mo766b();

    /* JADX INFO: renamed from: b */
    public Object[] m809b(int i) {
        int iMo759a = mo759a();
        Object[] objArr = new Object[iMo759a];
        for (int i2 = 0; i2 < iMo759a; i2++) {
            objArr[i2] = mo761a(i2, i);
        }
        return objArr;
    }

    /* JADX INFO: renamed from: c */
    protected abstract void mo767c();

    /* JADX INFO: renamed from: d */
    public Set<Map.Entry<K, V>> m810d() {
        if (this.f606b == null) {
            this.f606b = new b();
        }
        return this.f606b;
    }

    /* JADX INFO: renamed from: e */
    public Set<K> m811e() {
        if (this.f607c == null) {
            this.f607c = new c();
        }
        return this.f607c;
    }

    /* JADX INFO: renamed from: f */
    public Collection<V> m812f() {
        if (this.f608d == null) {
            this.f608d = new e();
        }
        return this.f608d;
    }
}
