package android.support.v4.p014f;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: android.support.v4.f.a */
/* JADX INFO: loaded from: classes.dex */
public class C0090a<K, V> extends C0100k<K, V> implements Map<K, V> {

    /* JADX INFO: renamed from: a */
    AbstractC0097h<K, V> f575a;

    public C0090a() {
    }

    public C0090a(int i) {
        super(i);
    }

    /* JADX INFO: renamed from: b */
    private AbstractC0097h<K, V> m757b() {
        if (this.f575a == null) {
            this.f575a = new AbstractC0097h<K, V>() { // from class: android.support.v4.f.a.1
                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: a */
                protected int mo759a() {
                    return C0090a.this.f629h;
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: a */
                protected int mo760a(Object obj) {
                    return C0090a.this.m821a(obj);
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: a */
                protected Object mo761a(int i, int i2) {
                    return C0090a.this.f628g[(i << 1) + i2];
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: a */
                protected V mo762a(int i, V v) {
                    return C0090a.this.m823a(i, v);
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: a */
                protected void mo763a(int i) {
                    C0090a.this.m828d(i);
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: a */
                protected void mo764a(K k, V v) {
                    C0090a.this.put(k, v);
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: b */
                protected int mo765b(Object obj) {
                    return C0090a.this.m825b(obj);
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: b */
                protected Map<K, V> mo766b() {
                    return C0090a.this;
                }

                @Override // android.support.v4.p014f.AbstractC0097h
                /* JADX INFO: renamed from: c */
                protected void mo767c() {
                    C0090a.this.clear();
                }
            };
        }
        return this.f575a;
    }

    /* JADX INFO: renamed from: a */
    public boolean m758a(Collection<?> collection) {
        return AbstractC0097h.m807c(this, collection);
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m757b().m810d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m757b().m811e();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        m824a(this.f629h + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m757b().m812f();
    }
}
