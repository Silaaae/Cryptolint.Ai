package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.p015g.InterfaceC0123o;
import android.support.v7.p018a.C0148a;
import android.support.v7.p019b.p020a.C0175b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;

/* JADX INFO: renamed from: android.support.v7.widget.f */
/* JADX INFO: loaded from: classes.dex */
public class C0275f extends AutoCompleteTextView implements InterfaceC0123o {

    /* JADX INFO: renamed from: a */
    private static final int[] f1900a = {R.attr.popupBackground};

    /* JADX INFO: renamed from: b */
    private final C0276g f1901b;

    /* JADX INFO: renamed from: c */
    private final C0295z f1902c;

    public C0275f(Context context) {
        this(context, null);
    }

    public C0275f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0148a.a.autoCompleteTextViewStyle);
    }

    public C0275f(Context context, AttributeSet attributeSet, int i) {
        super(C0260at.m1973a(context), attributeSet, i);
        C0263aw c0263awM1978a = C0263aw.m1978a(getContext(), attributeSet, f1900a, i, 0);
        if (c0263awM1978a.m1996g(0)) {
            setDropDownBackgroundDrawable(c0263awM1978a.m1982a(0));
        }
        c0263awM1978a.m1983a();
        this.f1901b = new C0276g(this);
        this.f1901b.m2074a(attributeSet, i);
        this.f1902c = C0295z.m2153a(this);
        this.f1902c.mo1796a(attributeSet, i);
        this.f1902c.mo1795a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1901b != null) {
            this.f1901b.m2077c();
        }
        if (this.f1902c != null) {
            this.f1902c.mo1795a();
        }
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1901b != null) {
            return this.f1901b.m2069a();
        }
        return null;
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1901b != null) {
            return this.f1901b.m2075b();
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
        if (this.f1901b != null) {
            this.f1901b.m2073a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1901b != null) {
            this.f1901b.m2070a(i);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(C0175b.m1396b(getContext(), i));
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1901b != null) {
            this.f1901b.m2071a(colorStateList);
        }
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1901b != null) {
            this.f1901b.m2072a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1902c != null) {
            this.f1902c.m2161a(context, i);
        }
    }
}
