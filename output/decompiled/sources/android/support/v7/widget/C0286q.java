package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.p015g.InterfaceC0123o;
import android.support.v4.widget.InterfaceC0147m;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: renamed from: android.support.v7.widget.q */
/* JADX INFO: loaded from: classes.dex */
public class C0286q extends ImageView implements InterfaceC0123o, InterfaceC0147m {

    /* JADX INFO: renamed from: a */
    private final C0276g f1944a;

    /* JADX INFO: renamed from: b */
    private final C0285p f1945b;

    public C0286q(Context context) {
        this(context, null);
    }

    public C0286q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0286q(Context context, AttributeSet attributeSet, int i) {
        super(C0260at.m1973a(context), attributeSet, i);
        this.f1944a = new C0276g(this);
        this.f1944a.m2074a(attributeSet, i);
        this.f1945b = new C0285p(this);
        this.f1945b.m2126a(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1944a != null) {
            this.f1944a.m2077c();
        }
        if (this.f1945b != null) {
            this.f1945b.m2130d();
        }
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1944a != null) {
            return this.f1944a.m2069a();
        }
        return null;
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1944a != null) {
            return this.f1944a.m2075b();
        }
        return null;
    }

    @Override // android.support.v4.widget.InterfaceC0147m
    public ColorStateList getSupportImageTintList() {
        if (this.f1945b != null) {
            return this.f1945b.m2128b();
        }
        return null;
    }

    @Override // android.support.v4.widget.InterfaceC0147m
    public PorterDuff.Mode getSupportImageTintMode() {
        if (this.f1945b != null) {
            return this.f1945b.m2129c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f1945b.m2127a() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1944a != null) {
            this.f1944a.m2073a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1944a != null) {
            this.f1944a.m2070a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f1945b != null) {
            this.f1945b.m2130d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f1945b != null) {
            this.f1945b.m2130d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.f1945b != null) {
            this.f1945b.m2123a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f1945b != null) {
            this.f1945b.m2130d();
        }
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1944a != null) {
            this.f1944a.m2071a(colorStateList);
        }
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1944a != null) {
            this.f1944a.m2072a(mode);
        }
    }

    @Override // android.support.v4.widget.InterfaceC0147m
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f1945b != null) {
            this.f1945b.m2124a(colorStateList);
        }
    }

    @Override // android.support.v4.widget.InterfaceC0147m
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f1945b != null) {
            this.f1945b.m2125a(mode);
        }
    }
}
