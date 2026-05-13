package android.support.v4.p015g.p017b;

import android.view.animation.Interpolator;

/* JADX INFO: renamed from: android.support.v4.g.b.d */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractInterpolatorC0110d implements Interpolator {

    /* JADX INFO: renamed from: a */
    private final float[] f652a;

    /* JADX INFO: renamed from: b */
    private final float f653b;

    protected AbstractInterpolatorC0110d(float[] fArr) {
        this.f652a = fArr;
        this.f653b = 1.0f / (this.f652a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int iMin = Math.min((int) ((this.f652a.length - 1) * f), this.f652a.length - 2);
        return this.f652a[iMin] + (((f - (iMin * this.f653b)) / this.f653b) * (this.f652a[iMin + 1] - this.f652a[iMin]));
    }
}
