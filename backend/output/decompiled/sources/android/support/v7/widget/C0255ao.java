package android.support.v7.widget;

/* JADX INFO: renamed from: android.support.v7.widget.ao */
/* JADX INFO: loaded from: classes.dex */
class C0255ao {

    /* JADX INFO: renamed from: a */
    private int f1733a = 0;

    /* JADX INFO: renamed from: b */
    private int f1734b = 0;

    /* JADX INFO: renamed from: c */
    private int f1735c = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: d */
    private int f1736d = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: e */
    private int f1737e = 0;

    /* JADX INFO: renamed from: f */
    private int f1738f = 0;

    /* JADX INFO: renamed from: g */
    private boolean f1739g = false;

    /* JADX INFO: renamed from: h */
    private boolean f1740h = false;

    C0255ao() {
    }

    /* JADX INFO: renamed from: a */
    public int m1932a() {
        return this.f1733a;
    }

    /* JADX INFO: renamed from: a */
    public void m1933a(int i, int i2) {
        this.f1735c = i;
        this.f1736d = i2;
        this.f1740h = true;
        if (this.f1739g) {
            if (i2 != Integer.MIN_VALUE) {
                this.f1733a = i2;
            }
            if (i != Integer.MIN_VALUE) {
                this.f1734b = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.f1733a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1734b = i2;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1934a(boolean z) {
        int i;
        if (z == this.f1739g) {
            return;
        }
        this.f1739g = z;
        if (this.f1740h) {
            if (z) {
                this.f1733a = this.f1736d != Integer.MIN_VALUE ? this.f1736d : this.f1737e;
                if (this.f1735c != Integer.MIN_VALUE) {
                    i = this.f1735c;
                }
            } else {
                this.f1733a = this.f1735c != Integer.MIN_VALUE ? this.f1735c : this.f1737e;
                if (this.f1736d != Integer.MIN_VALUE) {
                    i = this.f1736d;
                }
            }
            this.f1734b = i;
        }
        this.f1733a = this.f1737e;
        i = this.f1738f;
        this.f1734b = i;
    }

    /* JADX INFO: renamed from: b */
    public int m1935b() {
        return this.f1734b;
    }

    /* JADX INFO: renamed from: b */
    public void m1936b(int i, int i2) {
        this.f1740h = false;
        if (i != Integer.MIN_VALUE) {
            this.f1737e = i;
            this.f1733a = i;
        }
        if (i2 != Integer.MIN_VALUE) {
            this.f1738f = i2;
            this.f1734b = i2;
        }
    }

    /* JADX INFO: renamed from: c */
    public int m1937c() {
        return this.f1739g ? this.f1734b : this.f1733a;
    }

    /* JADX INFO: renamed from: d */
    public int m1938d() {
        return this.f1739g ? this.f1733a : this.f1734b;
    }
}
