package android.support.v7.app;

/* JADX INFO: renamed from: android.support.v7.app.n */
/* JADX INFO: loaded from: classes.dex */
class C0171n {

    /* JADX INFO: renamed from: d */
    private static C0171n f1021d;

    /* JADX INFO: renamed from: a */
    public long f1022a;

    /* JADX INFO: renamed from: b */
    public long f1023b;

    /* JADX INFO: renamed from: c */
    public int f1024c;

    C0171n() {
    }

    /* JADX INFO: renamed from: a */
    static C0171n m1344a() {
        if (f1021d == null) {
            f1021d = new C0171n();
        }
        return f1021d;
    }

    /* JADX INFO: renamed from: a */
    public void m1345a(long j, double d, double d2) {
        float f = (j - 946728000000L) / 8.64E7f;
        double d3 = (0.01720197f * f) + 6.24006f;
        double dSin = Math.sin(d3) * 0.03341960161924362d;
        Double.isNaN(d3);
        double dSin2 = dSin + d3 + (Math.sin(2.0f * r4) * 3.4906598739326E-4d) + (Math.sin(r4 * 3.0f) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        Double.isNaN(f - 9.0E-4f);
        double dRound = Math.round(r11 - r9) + 9.0E-4f;
        Double.isNaN(dRound);
        double dSin3 = dRound + ((-d2) / 360.0d) + (Math.sin(d3) * 0.0053d) + (Math.sin(2.0d * dSin2) * (-0.0069d));
        double dAsin = Math.asin(Math.sin(dSin2) * Math.sin(0.4092797040939331d));
        double d4 = 0.01745329238474369d * d;
        double dSin4 = (Math.sin(-0.10471975803375244d) - (Math.sin(d4) * Math.sin(dAsin))) / (Math.cos(d4) * Math.cos(dAsin));
        if (dSin4 >= 1.0d) {
            this.f1024c = 1;
        } else {
            if (dSin4 > -1.0d) {
                double dAcos = (float) (Math.acos(dSin4) / 6.283185307179586d);
                Double.isNaN(dAcos);
                this.f1022a = Math.round((dSin3 + dAcos) * 8.64E7d) + 946728000000L;
                Double.isNaN(dAcos);
                this.f1023b = Math.round((dSin3 - dAcos) * 8.64E7d) + 946728000000L;
                if (this.f1023b >= j || this.f1022a <= j) {
                    this.f1024c = 1;
                    return;
                } else {
                    this.f1024c = 0;
                    return;
                }
            }
            this.f1024c = 0;
        }
        this.f1022a = -1L;
        this.f1023b = -1L;
    }
}
