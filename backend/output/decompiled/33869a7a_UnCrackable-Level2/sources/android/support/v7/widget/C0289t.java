package android.support.v7.widget;

import android.R;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.v4.p008b.p009a.InterfaceC0072c;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/* JADX INFO: renamed from: android.support.v7.widget.t */
/* JADX INFO: loaded from: classes.dex */
class C0289t {

    /* JADX INFO: renamed from: a */
    private static final int[] f1951a = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* JADX INFO: renamed from: b */
    private final ProgressBar f1952b;

    /* JADX INFO: renamed from: c */
    private Bitmap f1953c;

    C0289t(ProgressBar progressBar) {
        this.f1952b = progressBar;
    }

    /* JADX INFO: renamed from: a */
    private Drawable m2133a(Drawable drawable) {
        if (!(drawable instanceof AnimationDrawable)) {
            return drawable;
        }
        AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        AnimationDrawable animationDrawable2 = new AnimationDrawable();
        animationDrawable2.setOneShot(animationDrawable.isOneShot());
        for (int i = 0; i < numberOfFrames; i++) {
            Drawable drawableM2134a = m2134a(animationDrawable.getFrame(i), true);
            drawableM2134a.setLevel(10000);
            animationDrawable2.addFrame(drawableM2134a, animationDrawable.getDuration(i));
        }
        animationDrawable2.setLevel(10000);
        return animationDrawable2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private Drawable m2134a(Drawable drawable, boolean z) {
        if (drawable instanceof InterfaceC0072c) {
            InterfaceC0072c interfaceC0072c = (InterfaceC0072c) drawable;
            Drawable drawableMo660a = interfaceC0072c.mo660a();
            if (drawableMo660a == null) {
                return drawable;
            }
            interfaceC0072c.mo661a(m2134a(drawableMo660a, z));
            return drawable;
        }
        if (!(drawable instanceof LayerDrawable)) {
            if (!(drawable instanceof BitmapDrawable)) {
                return drawable;
            }
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            if (this.f1953c == null) {
                this.f1953c = bitmap;
            }
            ShapeDrawable shapeDrawable = new ShapeDrawable(m2135b());
            shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
            shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
            return z ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        int numberOfLayers = layerDrawable.getNumberOfLayers();
        Drawable[] drawableArr = new Drawable[numberOfLayers];
        for (int i = 0; i < numberOfLayers; i++) {
            int id = layerDrawable.getId(i);
            drawableArr[i] = m2134a(layerDrawable.getDrawable(i), id == 16908301 || id == 16908303);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
        for (int i2 = 0; i2 < numberOfLayers; i2++) {
            layerDrawable2.setId(i2, layerDrawable.getId(i2));
        }
        return layerDrawable2;
    }

    /* JADX INFO: renamed from: b */
    private Shape m2135b() {
        return new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null);
    }

    /* JADX INFO: renamed from: a */
    Bitmap m2136a() {
        return this.f1953c;
    }

    /* JADX INFO: renamed from: a */
    void mo2137a(AttributeSet attributeSet, int i) {
        C0263aw c0263awM1978a = C0263aw.m1978a(this.f1952b.getContext(), attributeSet, f1951a, i, 0);
        Drawable drawableM1986b = c0263awM1978a.m1986b(0);
        if (drawableM1986b != null) {
            this.f1952b.setIndeterminateDrawable(m2133a(drawableM1986b));
        }
        Drawable drawableM1986b2 = c0263awM1978a.m1986b(1);
        if (drawableM1986b2 != null) {
            this.f1952b.setProgressDrawable(m2134a(drawableM1986b2, false));
        }
        c0263awM1978a.m1983a();
    }
}
