package android.arch.p000a.p002b;

import android.arch.p000a.p002b.C0004b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: android.arch.a.b.a */
/* JADX INFO: loaded from: classes.dex */
public class C0003a<K, V> extends C0004b<K, V> {

    /* JADX INFO: renamed from: a */
    private HashMap<K, C0004b.c<K, V>> f8a = new HashMap<>();

    @Override // android.arch.p000a.p002b.C0004b
    /* JADX INFO: renamed from: a */
    protected C0004b.c<K, V> mo4a(K k) {
        return this.f8a.get(k);
    }

    @Override // android.arch.p000a.p002b.C0004b
    /* JADX INFO: renamed from: a */
    public V mo5a(K k, V v) {
        C0004b.c<K, V> cVarMo4a = mo4a(k);
        if (cVarMo4a != null) {
            return cVarMo4a.f14b;
        }
        this.f8a.put(k, m11b(k, v));
        return null;
    }

    @Override // android.arch.p000a.p002b.C0004b
    /* JADX INFO: renamed from: b */
    public V mo6b(K k) {
        V v = (V) super.mo6b(k);
        this.f8a.remove(k);
        return v;
    }

    /* JADX INFO: renamed from: c */
    public boolean m7c(K k) {
        return this.f8a.containsKey(k);
    }

    /* JADX INFO: renamed from: d */
    public Map.Entry<K, V> m8d(K k) {
        if (m7c(k)) {
            return this.f8a.get(k).f16d;
        }
        return null;
    }
}
