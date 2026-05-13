package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: renamed from: android.support.v7.widget.w */
/* JADX INFO: loaded from: classes.dex */
public class C0292w extends SeekBar {

    /* JADX INFO: renamed from: a */
    private final C0293x f1957a;

    public C0292w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0148a.a.seekBarStyle);
    }

    public C0292w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1957a = new C0293x(this);
        this.f1957a.mo2137a(attributeSet, i);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f1957a.m2142c();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f1957a.m2141b();
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f1957a.m2139a(canvas);
    }
}
