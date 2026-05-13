package android.support.v4.p014f;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: renamed from: android.support.v4.f.g */
/* JADX INFO: loaded from: classes.dex */
public class C0096g<K, V> {

    /* JADX INFO: renamed from: a */
    private final LinkedHashMap<K, V> f598a;

    /* JADX INFO: renamed from: b */
    private int f599b;

    /* JADX INFO: renamed from: c */
    private int f600c;

    /* JADX INFO: renamed from: d */
    private int f601d;

    /* JADX INFO: renamed from: e */
    private int f602e;

    /* JADX INFO: renamed from: f */
    private int f603f;

    /* JADX INFO: renamed from: g */
    private int f604g;

    /* JADX INFO: renamed from: h */
    private int f605h;

    public C0096g(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f600c = i;
        this.f598a = new LinkedHashMap<>(0, 0.75f, true);
    }

    /* JADX INFO: renamed from: c */
    private int m797c(K k, V v) {
        int iM802b = m802b(k, v);
        if (iM802b >= 0) {
            return iM802b;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    /* JADX INFO: renamed from: a */
    public final V m798a(K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.f598a.get(k);
            if (v != null) {
                this.f604g++;
                return v;
            }
            this.f605h++;
            V vM803b = m803b(k);
            if (vM803b == null) {
                return null;
            }
            synchronized (this) {
                this.f602e++;
                vPut = this.f598a.put(k, vM803b);
                if (vPut != null) {
                    this.f598a.put(k, vPut);
                } else {
                    this.f599b += m797c(k, vM803b);
                }
            }
            if (vPut != null) {
                m801a(false, k, vM803b, vPut);
                return vPut;
            }
            m800a(this.f600c);
            return vM803b;
        }
    }

    /* JADX INFO: renamed from: a */
    public final V m799a(K k, V v) {
        V vPut;
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.f601d++;
            this.f599b += m797c(k, v);
            vPut = this.f598a.put(k, v);
            if (vPut != null) {
                this.f599b -= m797c(k, vPut);
            }
        }
        if (vPut != null) {
            m801a(false, k, vPut, v);
        }
        m800a(this.f600c);
        return vPut;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m800a(int i) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.f599b >= 0 && (!this.f598a.isEmpty() || this.f599b == 0)) {
                    if (this.f599b <= i || this.f598a.isEmpty()) {
                        break;
                    }
                    Map.Entry<K, V> next = this.f598a.entrySet().iterator().next();
                    key = next.getKey();
                    value = next.getValue();
                    this.f598a.remove(key);
                    this.f599b -= m797c(key, value);
                    this.f603f++;
                } else {
                    break;
                }
            }
            m801a(true, key, value, null);
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m801a(boolean z, K k, V v, V v2) {
    }

    /* JADX INFO: renamed from: b */
    protected int m802b(K k, V v) {
        return 1;
    }

    /* JADX INFO: renamed from: b */
    protected V m803b(K k) {
        return null;
    }

    public final synchronized String toString() {
        int i;
        i = this.f604g + this.f605h;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f600c), Integer.valueOf(this.f604g), Integer.valueOf(this.f605h), Integer.valueOf(i != 0 ? (this.f604g * 100) / i : 0));
    }
}
