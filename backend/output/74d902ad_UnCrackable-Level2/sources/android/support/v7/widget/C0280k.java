package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.p008b.p009a.C0070a;
import android.support.v4.widget.C0137c;
import android.support.v7.p018a.C0148a;
import android.support.v7.p019b.p020a.C0175b;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: renamed from: android.support.v7.widget.k */
/* JADX INFO: loaded from: classes.dex */
class C0280k {

    /* JADX INFO: renamed from: a */
    private final CompoundButton f1914a;

    /* JADX INFO: renamed from: b */
    private ColorStateList f1915b = null;

    /* JADX INFO: renamed from: c */
    private PorterDuff.Mode f1916c = null;

    /* JADX INFO: renamed from: d */
    private boolean f1917d = false;

    /* JADX INFO: renamed from: e */
    private boolean f1918e = false;

    /* JADX INFO: renamed from: f */
    private boolean f1919f;

    C0280k(CompoundButton compoundButton) {
        this.f1914a = compoundButton;
    }

    /* JADX INFO: renamed from: a */
    int m2078a(int i) {
        Drawable drawableM1108a;
        return (Build.VERSION.SDK_INT >= 17 || (drawableM1108a = C0137c.m1108a(this.f1914a)) == null) ? i : i + drawableM1108a.getIntrinsicWidth();
    }

    /* JADX INFO: renamed from: a */
    ColorStateList m2079a() {
        return this.f1915b;
    }

    /* JADX INFO: renamed from: a */
    void m2080a(ColorStateList colorStateList) {
        this.f1915b = colorStateList;
        this.f1917d = true;
        m2085d();
    }

    /* JADX INFO: renamed from: a */
    void m2081a(PorterDuff.Mode mode) {
        this.f1916c = mode;
        this.f1918e = true;
        m2085d();
    }

    /* JADX INFO: renamed from: a */
    void m2082a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f1914a.getContext().obtainStyledAttributes(attributeSet, C0148a.j.CompoundButton, i, 0);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(C0148a.j.CompoundButton_android_button) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.CompoundButton_android_button, 0)) != 0) {
                this.f1914a.setButtonDrawable(C0175b.m1396b(this.f1914a.getContext(), resourceId));
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0148a.j.CompoundButton_buttonTint)) {
                C0137c.m1109a(this.f1914a, typedArrayObtainStyledAttributes.getColorStateList(C0148a.j.CompoundButton_buttonTint));
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0148a.j.CompoundButton_buttonTintMode)) {
                C0137c.m1110a(this.f1914a, C0246af.m1853a(typedArrayObtainStyledAttributes.getInt(C0148a.j.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: b */
    PorterDuff.Mode m2083b() {
        return this.f1916c;
    }

    /* JADX INFO: renamed from: c */
    void m2084c() {
        if (this.f1919f) {
            this.f1919f = false;
        } else {
            this.f1919f = true;
            m2085d();
        }
    }

    /* JADX INFO: renamed from: d */
    void m2085d() {
        Drawable drawableM1108a = C0137c.m1108a(this.f1914a);
        if (drawableM1108a != null) {
            if (this.f1917d || this.f1918e) {
                Drawable drawableMutate = C0070a.m658f(drawableM1108a).mutate();
                if (this.f1917d) {
                    C0070a.m648a(drawableMutate, this.f1915b);
                }
                if (this.f1918e) {
                    C0070a.m651a(drawableMutate, this.f1916c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f1914a.getDrawableState());
                }
                this.f1914a.setButtonDrawable(drawableMutate);
            }
        }
    }
}
