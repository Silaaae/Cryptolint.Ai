package android.support.v4.p014f;

/* JADX INFO: renamed from: android.support.v4.f.i */
/* JADX INFO: loaded from: classes.dex */
public class C0098i<F, S> {

    /* JADX INFO: renamed from: a */
    public final F f621a;

    /* JADX INFO: renamed from: b */
    public final S f622b;

    /* JADX INFO: renamed from: a */
    private static boolean m815a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0098i)) {
            return false;
        }
        C0098i c0098i = (C0098i) obj;
        return m815a(c0098i.f621a, this.f621a) && m815a(c0098i.f622b, this.f622b);
    }

    public int hashCode() {
        return (this.f621a == null ? 0 : this.f621a.hashCode()) ^ (this.f622b != null ? this.f622b.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f621a) + " " + String.valueOf(this.f622b) + "}";
    }
}
