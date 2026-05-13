package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;

/* JADX INFO: renamed from: android.support.v7.widget.v */
/* JADX INFO: loaded from: classes.dex */
public class C0291v extends RatingBar {

    /* JADX INFO: renamed from: a */
    private final C0289t f1956a;

    public C0291v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0148a.a.ratingBarStyle);
    }

    public C0291v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1956a = new C0289t(this);
        this.f1956a.mo2137a(attributeSet, i);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmapM2136a = this.f1956a.m2136a();
        if (bitmapM2136a != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapM2136a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
