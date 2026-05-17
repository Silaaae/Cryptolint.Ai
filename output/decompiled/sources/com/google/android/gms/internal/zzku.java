package com.google.android.gms.internal;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzku<K, V> {
    private int size;
    private final LinkedHashMap<K, V> zzabn;
    private int zzabo;
    private int zzabp;
    private int zzabq;
    private int zzabr;
    private int zzabs;
    private int zzabt;

    public zzku(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.zzabo = i;
        this.zzabn = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int zzc(K k, V v) {
        int iSizeOf = sizeOf(k, v);
        if (iSizeOf < 0) {
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return iSizeOf;
    }

    protected V create(K key) {
        return null;
    }

    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final V get(K k) {
        V vPut;
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.zzabn.get(k);
            if (v != null) {
                this.zzabs++;
                return v;
            }
            this.zzabt++;
            V vCreate = create(k);
            if (vCreate == null) {
                return null;
            }
            synchronized (this) {
                this.zzabq++;
                vPut = this.zzabn.put(k, vCreate);
                if (vPut != null) {
                    this.zzabn.put(k, vPut);
                } else {
                    this.size += zzc(k, vCreate);
                }
            }
            if (vPut != null) {
                entryRemoved(false, k, vCreate, vPut);
                return vPut;
            }
            trimToSize(this.zzabo);
            return vCreate;
        }
    }

    public final V put(K key, V value) {
        V vPut;
        if (key == null || value == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            this.zzabp++;
            this.size += zzc(key, value);
            vPut = this.zzabn.put(key, value);
            if (vPut != null) {
                this.size -= zzc(key, vPut);
            }
        }
        if (vPut != null) {
            entryRemoved(false, key, vPut, value);
        }
        trimToSize(this.zzabo);
        return vPut;
    }

    public final synchronized int size() {
        return this.size;
    }

    protected int sizeOf(K key, V value) {
        return 1;
    }

    public final synchronized String toString() {
        String str;
        synchronized (this) {
            int i = this.zzabs + this.zzabt;
            str = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.zzabo), Integer.valueOf(this.zzabs), Integer.valueOf(this.zzabt), Integer.valueOf(i != 0 ? (this.zzabs * 100) / i : 0));
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0031, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trimToSize(int maxSize) {
        K key;
        V value;
        while (true) {
            synchronized (this) {
                if (this.size < 0 || (this.zzabn.isEmpty() && this.size != 0)) {
                    break;
                }
                if (this.size <= maxSize || this.zzabn.isEmpty()) {
                    break;
                }
                Map.Entry<K, V> next = this.zzabn.entrySet().iterator().next();
                key = next.getKey();
                value = next.getValue();
                this.zzabn.remove(key);
                this.size -= zzc(key, value);
                this.zzabr++;
            }
            entryRemoved(true, key, value, null);
        }
    }
}
