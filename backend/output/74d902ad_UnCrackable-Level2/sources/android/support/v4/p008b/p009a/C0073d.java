package android.support.v4.p008b.p009a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: android.support.v4.b.a.d */
/* JADX INFO: loaded from: classes.dex */
class C0073d extends Drawable implements Drawable.Callback, InterfaceC0071b, InterfaceC0072c {

    /* JADX INFO: renamed from: a */
    static final PorterDuff.Mode f496a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b */
    a f497b;

    /* JADX INFO: renamed from: c */
    Drawable f498c;

    /* JADX INFO: renamed from: d */
    private int f499d;

    /* JADX INFO: renamed from: e */
    private PorterDuff.Mode f500e;

    /* JADX INFO: renamed from: f */
    private boolean f501f;

    /* JADX INFO: renamed from: g */
    private boolean f502g;

    /* JADX INFO: renamed from: android.support.v4.b.a.d$a */
    protected static abstract class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        int f503a;

        /* JADX INFO: renamed from: b */
        Drawable.ConstantState f504b;

        /* JADX INFO: renamed from: c */
        ColorStateList f505c;

        /* JADX INFO: renamed from: d */
        PorterDuff.Mode f506d;

        a(a aVar, Resources resources) {
            this.f505c = null;
            this.f506d = C0073d.f496a;
            if (aVar != null) {
                this.f503a = aVar.f503a;
                this.f504b = aVar.f504b;
                this.f505c = aVar.f505c;
                this.f506d = aVar.f506d;
            }
        }

        /* JADX INFO: renamed from: a */
        boolean m666a() {
            return this.f504b != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f503a | (this.f504b != null ? this.f504b.getChangingConfigurations() : 0);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return newDrawable(null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public abstract Drawable newDrawable(Resources resources);
    }

    /* JADX INFO: renamed from: android.support.v4.b.a.d$b */
    private static class b extends a {
        b(a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // android.support.v4.p008b.p009a.C0073d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C0073d(this, resources);
        }
    }

    C0073d(Drawable drawable) {
        this.f497b = mo664b();
        mo661a(drawable);
    }

    C0073d(a aVar, Resources resources) {
        this.f497b = aVar;
        m662a(resources);
    }

    /* JADX INFO: renamed from: a */
    private void m662a(Resources resources) {
        if (this.f497b == null || this.f497b.f504b == null) {
            return;
        }
        mo661a(this.f497b.f504b.newDrawable(resources));
    }

    /* JADX INFO: renamed from: a */
    private boolean m663a(int[] iArr) {
        if (!mo665c()) {
            return false;
        }
        ColorStateList colorStateList = this.f497b.f505c;
        PorterDuff.Mode mode = this.f497b.f506d;
        if (colorStateList == null || mode == null) {
            this.f501f = false;
            clearColorFilter();
        } else {
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.f501f || colorForState != this.f499d || mode != this.f500e) {
                setColorFilter(colorForState, mode);
                this.f499d = colorForState;
                this.f500e = mode;
                this.f501f = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v4.p008b.p009a.InterfaceC0072c
    /* JADX INFO: renamed from: a */
    public final Drawable mo660a() {
        return this.f498c;
    }

    @Override // android.support.v4.p008b.p009a.InterfaceC0072c
    /* JADX INFO: renamed from: a */
    public final void mo661a(Drawable drawable) {
        if (this.f498c != null) {
            this.f498c.setCallback(null);
        }
        this.f498c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            if (this.f497b != null) {
                this.f497b.f504b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    /* JADX INFO: renamed from: b */
    a mo664b() {
        return new b(this.f497b, null);
    }

    /* JADX INFO: renamed from: c */
    protected boolean mo665c() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f498c.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | (this.f497b != null ? this.f497b.getChangingConfigurations() : 0) | this.f498c.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f497b == null || !this.f497b.m666a()) {
            return null;
        }
        this.f497b.f503a = getChangingConfigurations();
        return this.f497b;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f498c.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f498c.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f498c.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f498c.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f498c.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f498c.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f498c.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        return this.f498c.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        return this.f498c.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList = (!mo665c() || this.f497b == null) ? null : this.f497b.f505c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f498c.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.f498c.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f502g && super.mutate() == this) {
            this.f497b = mo664b();
            if (this.f498c != null) {
                this.f498c.mutate();
            }
            if (this.f497b != null) {
                this.f497b.f504b = this.f498c != null ? this.f498c.getConstantState() : null;
            }
            this.f502g = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f498c != null) {
            this.f498c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.f498c.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f498c.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        this.f498c.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f498c.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f498c.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f498c.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return m663a(iArr) || this.f498c.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.p008b.p009a.InterfaceC0071b
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.p008b.p009a.InterfaceC0071b
    public void setTintList(ColorStateList colorStateList) {
        this.f497b.f505c = colorStateList;
        m663a(getState());
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.p008b.p009a.InterfaceC0071b
    public void setTintMode(PorterDuff.Mode mode) {
        this.f497b.f506d = mode;
        m663a(getState());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f498c.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
