package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.InterfaceC0146l;
import android.support.v7.p018a.C0148a;
import android.support.v7.p019b.p020a.C0175b;
import android.util.AttributeSet;
import android.widget.CheckBox;

/* JADX INFO: renamed from: android.support.v7.widget.i */
/* JADX INFO: loaded from: classes.dex */
public class C0278i extends CheckBox implements InterfaceC0146l {

    /* JADX INFO: renamed from: a */
    private final C0280k f1911a;

    public C0278i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0148a.a.checkboxStyle);
    }

    public C0278i(Context context, AttributeSet attributeSet, int i) {
        super(C0260at.m1973a(context), attributeSet, i);
        this.f1911a = new C0280k(this);
        this.f1911a.m2082a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f1911a != null ? this.f1911a.m2078a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.f1911a != null) {
            return this.f1911a.m2079a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f1911a != null) {
            return this.f1911a.m2083b();
        }
        return null;
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(C0175b.m1396b(getContext(), i));
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f1911a != null) {
            this.f1911a.m2084c();
        }
    }

    @Override // android.support.v4.widget.InterfaceC0146l
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f1911a != null) {
            this.f1911a.m2080a(colorStateList);
        }
    }

    @Override // android.support.v4.widget.InterfaceC0146l
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.f1911a != null) {
            this.f1911a.m2081a(mode);
        }
    }
}
