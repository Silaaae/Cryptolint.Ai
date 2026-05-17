package android.arch.p000a.p002b;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: android.arch.a.b.b */
/* JADX INFO: loaded from: classes.dex */
public class C0004b<K, V> implements Iterable<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a */
    private c<K, V> f9a;

    /* JADX INFO: renamed from: b */
    private c<K, V> f10b;

    /* JADX INFO: renamed from: c */
    private WeakHashMap<f<K, V>, Boolean> f11c = new WeakHashMap<>();

    /* JADX INFO: renamed from: d */
    private int f12d = 0;

    /* JADX INFO: renamed from: android.arch.a.b.b$a */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.p000a.p002b.C0004b.e
        /* JADX INFO: renamed from: a */
        c<K, V> mo16a(c<K, V> cVar) {
            return cVar.f15c;
        }

        @Override // android.arch.p000a.p002b.C0004b.e
        /* JADX INFO: renamed from: b */
        c<K, V> mo17b(c<K, V> cVar) {
            return cVar.f16d;
        }
    }

    /* JADX INFO: renamed from: android.arch.a.b.b$b */
    private static class b<K, V> extends e<K, V> {
        b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        @Override // android.arch.p000a.p002b.C0004b.e
        /* JADX INFO: renamed from: a */
        c<K, V> mo16a(c<K, V> cVar) {
            return cVar.f16d;
        }

        @Override // android.arch.p000a.p002b.C0004b.e
        /* JADX INFO: renamed from: b */
        c<K, V> mo17b(c<K, V> cVar) {
            return cVar.f15c;
        }
    }

    /* JADX INFO: renamed from: android.arch.a.b.b$c */
    static class c<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a */
        final K f13a;

        /* JADX INFO: renamed from: b */
        final V f14b;

        /* JADX INFO: renamed from: c */
        c<K, V> f15c;

        /* JADX INFO: renamed from: d */
        c<K, V> f16d;

        c(K k, V v) {
            this.f13a = k;
            this.f14b = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f13a.equals(cVar.f13a) && this.f14b.equals(cVar.f14b);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f13a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f14b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f13a + "=" + this.f14b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: android.arch.a.b.b$d */
    public class d implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: b */
        private c<K, V> f18b;

        /* JADX INFO: renamed from: c */
        private boolean f19c;

        private d() {
            this.f19c = true;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar;
            if (this.f19c) {
                this.f19c = false;
                cVar = C0004b.this.f9a;
            } else {
                cVar = this.f18b != null ? this.f18b.f15c : null;
            }
            this.f18b = cVar;
            return this.f18b;
        }

        @Override // android.arch.p000a.p002b.C0004b.f
        /* JADX INFO: renamed from: a_ */
        public void mo19a_(c<K, V> cVar) {
            if (cVar == this.f18b) {
                this.f18b = this.f18b.f16d;
                this.f19c = this.f18b == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19c ? C0004b.this.f9a != null : (this.f18b == null || this.f18b.f15c == null) ? false : true;
        }
    }

    /* JADX INFO: renamed from: android.arch.a.b.b$e */
    private static abstract class e<K, V> implements f<K, V>, Iterator<Map.Entry<K, V>> {

        /* JADX INFO: renamed from: a */
        c<K, V> f20a;

        /* JADX INFO: renamed from: b */
        c<K, V> f21b;

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.f20a = cVar2;
            this.f21b = cVar;
        }

        /* JADX INFO: renamed from: b */
        private c<K, V> m20b() {
            if (this.f21b == this.f20a || this.f20a == null) {
                return null;
            }
            return mo16a(this.f21b);
        }

        /* JADX INFO: renamed from: a */
        abstract c<K, V> mo16a(c<K, V> cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            c<K, V> cVar = this.f21b;
            this.f21b = m20b();
            return cVar;
        }

        @Override // android.arch.p000a.p002b.C0004b.f
        /* JADX INFO: renamed from: a_ */
        public void mo19a_(c<K, V> cVar) {
            if (this.f20a == cVar && cVar == this.f21b) {
                this.f21b = null;
                this.f20a = null;
            }
            if (this.f20a == cVar) {
                this.f20a = mo17b(this.f20a);
            }
            if (this.f21b == cVar) {
                this.f21b = m20b();
            }
        }

        /* JADX INFO: renamed from: b */
        abstract c<K, V> mo17b(c<K, V> cVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f21b != null;
        }
    }

    /* JADX INFO: renamed from: android.arch.a.b.b$f */
    interface f<K, V> {
        /* JADX INFO: renamed from: a_ */
        void mo19a_(c<K, V> cVar);
    }

    /* JADX INFO: renamed from: a */
    public int m10a() {
        return this.f12d;
    }

    /* JADX INFO: renamed from: a */
    protected c<K, V> mo4a(K k) {
        c<K, V> cVar = this.f9a;
        while (cVar != null && !cVar.f13a.equals(k)) {
            cVar = cVar.f15c;
        }
        return cVar;
    }

    /* JADX INFO: renamed from: a */
    public V mo5a(K k, V v) {
        c<K, V> cVarMo4a = mo4a(k);
        if (cVarMo4a != null) {
            return cVarMo4a.f14b;
        }
        m11b(k, v);
        return null;
    }

    /* JADX INFO: renamed from: b */
    protected c<K, V> m11b(K k, V v) {
        c<K, V> cVar = new c<>(k, v);
        this.f12d++;
        if (this.f10b == null) {
            this.f9a = cVar;
            this.f10b = this.f9a;
            return cVar;
        }
        this.f10b.f15c = cVar;
        cVar.f16d = this.f10b;
        this.f10b = cVar;
        return cVar;
    }

    /* JADX INFO: renamed from: b */
    public V mo6b(K k) {
        c<K, V> cVarMo4a = mo4a(k);
        if (cVarMo4a == null) {
            return null;
        }
        this.f12d--;
        if (!this.f11c.isEmpty()) {
            Iterator<f<K, V>> it = this.f11c.keySet().iterator();
            while (it.hasNext()) {
                it.next().mo19a_(cVarMo4a);
            }
        }
        if (cVarMo4a.f16d != null) {
            cVarMo4a.f16d.f15c = cVarMo4a.f15c;
        } else {
            this.f9a = cVarMo4a.f15c;
        }
        if (cVarMo4a.f15c != null) {
            cVarMo4a.f15c.f16d = cVarMo4a.f16d;
        } else {
            this.f10b = cVarMo4a.f16d;
        }
        cVarMo4a.f15c = null;
        cVarMo4a.f16d = null;
        return cVarMo4a.f14b;
    }

    /* JADX INFO: renamed from: b */
    public Iterator<Map.Entry<K, V>> m12b() {
        b bVar = new b(this.f10b, this.f9a);
        this.f11c.put(bVar, false);
        return bVar;
    }

    /* JADX INFO: renamed from: c */
    public C0004b<K, V>.d m13c() {
        C0004b<K, V>.d dVar = new d();
        this.f11c.put(dVar, false);
        return dVar;
    }

    /* JADX INFO: renamed from: d */
    public Map.Entry<K, V> m14d() {
        return this.f9a;
    }

    /* JADX INFO: renamed from: e */
    public Map.Entry<K, V> m15e() {
        return this.f10b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0004b)) {
            return false;
        }
        C0004b c0004b = (C0004b) obj;
        if (m10a() != c0004b.m10a()) {
            return false;
        }
        Iterator<Map.Entry<K, V>> it = iterator();
        Iterator<Map.Entry<K, V>> it2 = c0004b.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry<K, V> next = it.next();
            Map.Entry<K, V> next2 = it2.next();
            if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        a aVar = new a(this.f9a, this.f10b);
        this.f11c.put(aVar, false);
        return aVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<Map.Entry<K, V>> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
