package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.p015g.InterfaceC0123o;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* JADX INFO: renamed from: android.support.v7.widget.m */
/* JADX INFO: loaded from: classes.dex */
public class C0282m extends EditText implements InterfaceC0123o {

    /* JADX INFO: renamed from: a */
    private final C0276g f1936a;

    /* JADX INFO: renamed from: b */
    private final C0295z f1937b;

    public C0282m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0148a.a.editTextStyle);
    }

    public C0282m(Context context, AttributeSet attributeSet, int i) {
        super(C0260at.m1973a(context), attributeSet, i);
        this.f1936a = new C0276g(this);
        this.f1936a.m2074a(attributeSet, i);
        this.f1937b = C0295z.m2153a(this);
        this.f1937b.mo1796a(attributeSet, i);
        this.f1937b.mo1795a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1936a != null) {
            this.f1936a.m2077c();
        }
        if (this.f1937b != null) {
            this.f1937b.mo1795a();
        }
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1936a != null) {
            return this.f1936a.m2069a();
        }
        return null;
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1936a != null) {
            return this.f1936a.m2075b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0283n.m2120a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1936a != null) {
            this.f1936a.m2073a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1936a != null) {
            this.f1936a.m2070a(i);
        }
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1936a != null) {
            this.f1936a.m2071a(colorStateList);
        }
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1936a != null) {
            this.f1936a.m2072a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1937b != null) {
            this.f1937b.m2161a(context, i);
        }
    }
}
