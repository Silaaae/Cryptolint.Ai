package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.p008b.p009a.C0070a;
import android.support.v4.p015g.C0124p;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: renamed from: android.support.v7.widget.x */
/* JADX INFO: loaded from: classes.dex */
class C0293x extends C0289t {

    /* JADX INFO: renamed from: a */
    private final SeekBar f1958a;

    /* JADX INFO: renamed from: b */
    private Drawable f1959b;

    /* JADX INFO: renamed from: c */
    private ColorStateList f1960c;

    /* JADX INFO: renamed from: d */
    private PorterDuff.Mode f1961d;

    /* JADX INFO: renamed from: e */
    private boolean f1962e;

    /* JADX INFO: renamed from: f */
    private boolean f1963f;

    C0293x(SeekBar seekBar) {
        super(seekBar);
        this.f1960c = null;
        this.f1961d = null;
        this.f1962e = false;
        this.f1963f = false;
        this.f1958a = seekBar;
    }

    /* JADX INFO: renamed from: d */
    private void m2138d() {
        if (this.f1959b != null) {
            if (this.f1962e || this.f1963f) {
                this.f1959b = C0070a.m658f(this.f1959b.mutate());
                if (this.f1962e) {
                    C0070a.m648a(this.f1959b, this.f1960c);
                }
                if (this.f1963f) {
                    C0070a.m651a(this.f1959b, this.f1961d);
                }
                if (this.f1959b.isStateful()) {
                    this.f1959b.setState(this.f1958a.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m2139a(Canvas canvas) {
        if (this.f1959b != null) {
            int max = this.f1958a.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f1959b.getIntrinsicWidth();
                int intrinsicHeight = this.f1959b.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f1959b.setBounds(-i, -i2, i, i2);
                float width = ((this.f1958a.getWidth() - this.f1958a.getPaddingLeft()) - this.f1958a.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f1958a.getPaddingLeft(), this.f1958a.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f1959b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m2140a(Drawable drawable) {
        if (this.f1959b != null) {
            this.f1959b.setCallback(null);
        }
        this.f1959b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1958a);
            C0070a.m654b(drawable, C0124p.m960b(this.f1958a));
            if (drawable.isStateful()) {
                drawable.setState(this.f1958a.getDrawableState());
            }
            m2138d();
        }
        this.f1958a.invalidate();
    }

    @Override // android.support.v7.widget.C0289t
    /* JADX INFO: renamed from: a */
    void mo2137a(AttributeSet attributeSet, int i) {
        super.mo2137a(attributeSet, i);
        C0263aw c0263awM1978a = C0263aw.m1978a(this.f1958a.getContext(), attributeSet, C0148a.j.AppCompatSeekBar, i, 0);
        Drawable drawableM1986b = c0263awM1978a.m1986b(C0148a.j.AppCompatSeekBar_android_thumb);
        if (drawableM1986b != null) {
            this.f1958a.setThumb(drawableM1986b);
        }
        m2140a(c0263awM1978a.m1982a(C0148a.j.AppCompatSeekBar_tickMark));
        if (c0263awM1978a.m1996g(C0148a.j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f1961d = C0246af.m1853a(c0263awM1978a.m1980a(C0148a.j.AppCompatSeekBar_tickMarkTintMode, -1), this.f1961d);
            this.f1963f = true;
        }
        if (c0263awM1978a.m1996g(C0148a.j.AppCompatSeekBar_tickMarkTint)) {
            this.f1960c = c0263awM1978a.m1992e(C0148a.j.AppCompatSeekBar_tickMarkTint);
            this.f1962e = true;
        }
        c0263awM1978a.m1983a();
        m2138d();
    }

    /* JADX INFO: renamed from: b */
    void m2141b() {
        if (this.f1959b != null) {
            this.f1959b.jumpToCurrentState();
        }
    }

    /* JADX INFO: renamed from: c */
    void m2142c() {
        Drawable drawable = this.f1959b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1958a.getDrawableState())) {
            this.f1958a.invalidateDrawable(drawable);
        }
    }
}
