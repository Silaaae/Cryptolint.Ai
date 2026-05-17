package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.InterfaceC0146l;
import android.support.v7.p018a.C0148a;
import android.support.v7.p019b.p020a.C0175b;
import android.util.AttributeSet;
import android.widget.RadioButton;

/* JADX INFO: renamed from: android.support.v7.widget.u */
/* JADX INFO: loaded from: classes.dex */
public class C0290u extends RadioButton implements InterfaceC0146l {

    /* JADX INFO: renamed from: a */
    private final C0280k f1954a;

    /* JADX INFO: renamed from: b */
    private final C0295z f1955b;

    public C0290u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0148a.a.radioButtonStyle);
    }

    public C0290u(Context context, AttributeSet attributeSet, int i) {
        super(C0260at.m1973a(context), attributeSet, i);
        this.f1954a = new C0280k(this);
        this.f1954a.m2082a(attributeSet, i);
        this.f1955b = new C0295z(this);
        this.f1955b.mo1796a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f1954a != null ? this.f1954a.m2078a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public ColorStateList getSupportButtonTintList() {
        if (this.f1954a != null) {
            return this.f1954a.m2079a();
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f1954a != null) {
            return this.f1954a.m2083b();
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
        if (this.f1954a != null) {
            this.f1954a.m2084c();
        }
    }

    @Override // android.support.v4.widget.InterfaceC0146l
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f1954a != null) {
            this.f1954a.m2080a(colorStateList);
        }
    }

    @Override // android.support.v4.widget.InterfaceC0146l
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.f1954a != null) {
            this.f1954a.m2081a(mode);
        }
    }
}
