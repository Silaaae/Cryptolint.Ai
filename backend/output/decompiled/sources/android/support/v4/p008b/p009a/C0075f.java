package android.support.v4.p008b.p009a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v4.p008b.p009a.C0073d;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: android.support.v4.b.a.f */
/* JADX INFO: loaded from: classes.dex */
class C0075f extends C0074e {

    /* JADX INFO: renamed from: d */
    private static Method f507d;

    /* JADX INFO: renamed from: android.support.v4.b.a.f$a */
    private static class a extends C0073d.a {
        a(C0073d.a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // android.support.v4.p008b.p009a.C0073d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C0075f(this, resources);
        }
    }

    C0075f(Drawable drawable) {
        super(drawable);
        m667d();
    }

    C0075f(C0073d.a aVar, Resources resources) {
        super(aVar, resources);
        m667d();
    }

    /* JADX INFO: renamed from: d */
    private void m667d() {
        if (f507d == null) {
            try {
                f507d = Drawable.class.getDeclaredMethod("isProjected", new Class[0]);
            } catch (Exception e) {
                Log.w("WrappedDrawableApi21", "Failed to retrieve Drawable#isProjected() method", e);
            }
        }
    }

    @Override // android.support.v4.p008b.p009a.C0074e, android.support.v4.p008b.p009a.C0073d
    /* JADX INFO: renamed from: b */
    C0073d.a mo664b() {
        return new a(this.f497b, null);
    }

    @Override // android.support.v4.p008b.p009a.C0073d
    /* JADX INFO: renamed from: c */
    protected boolean mo665c() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.f498c;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    @Override // android.graphics.drawable.Drawable
    public Rect getDirtyBounds() {
        return this.f498c.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        this.f498c.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        this.f498c.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.f498c.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.support.v4.p008b.p009a.C0073d, android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.support.v4.p008b.p009a.C0073d, android.graphics.drawable.Drawable, android.support.v4.p008b.p009a.InterfaceC0071b
    public void setTint(int i) {
        if (mo665c()) {
            super.setTint(i);
        } else {
            this.f498c.setTint(i);
        }
    }

    @Override // android.support.v4.p008b.p009a.C0073d, android.graphics.drawable.Drawable, android.support.v4.p008b.p009a.InterfaceC0071b
    public void setTintList(ColorStateList colorStateList) {
        if (mo665c()) {
            super.setTintList(colorStateList);
        } else {
            this.f498c.setTintList(colorStateList);
        }
    }

    @Override // android.support.v4.p008b.p009a.C0073d, android.graphics.drawable.Drawable, android.support.v4.p008b.p009a.InterfaceC0071b
    public void setTintMode(PorterDuff.Mode mode) {
        if (mo665c()) {
            super.setTintMode(mode);
        } else {
            this.f498c.setTintMode(mode);
        }
    }
}
