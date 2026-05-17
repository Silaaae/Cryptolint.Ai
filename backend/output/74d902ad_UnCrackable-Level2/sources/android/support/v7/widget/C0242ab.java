package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.p015g.InterfaceC0123o;
import android.support.v4.widget.InterfaceC0136b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;

/* JADX INFO: renamed from: android.support.v7.widget.ab */
/* JADX INFO: loaded from: classes.dex */
public class C0242ab extends TextView implements InterfaceC0123o, InterfaceC0136b {

    /* JADX INFO: renamed from: b */
    private final C0276g f1623b;

    /* JADX INFO: renamed from: c */
    private final C0295z f1624c;

    public C0242ab(Context context) {
        this(context, null);
    }

    public C0242ab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public C0242ab(Context context, AttributeSet attributeSet, int i) {
        super(C0260at.m1973a(context), attributeSet, i);
        this.f1623b = new C0276g(this);
        this.f1623b.m2074a(attributeSet, i);
        this.f1624c = C0295z.m2153a(this);
        this.f1624c.mo1796a(attributeSet, i);
        this.f1624c.mo1795a();
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1623b != null) {
            this.f1623b.m2077c();
        }
        if (this.f1624c != null) {
            this.f1624c.mo1795a();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (f751a) {
            return super.getAutoSizeMaxTextSize();
        }
        if (this.f1624c != null) {
            return this.f1624c.m2171g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (f751a) {
            return super.getAutoSizeMinTextSize();
        }
        if (this.f1624c != null) {
            return this.f1624c.m2170f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (f751a) {
            return super.getAutoSizeStepGranularity();
        }
        if (this.f1624c != null) {
            return this.f1624c.m2169e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        return f751a ? super.getAutoSizeTextAvailableSizes() : this.f1624c != null ? this.f1624c.m2172h() : new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        if (f751a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        if (this.f1624c != null) {
            return this.f1624c.m2168d();
        }
        return 0;
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1623b != null) {
            return this.f1623b.m2069a();
        }
        return null;
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1623b != null) {
            return this.f1623b.m2075b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0283n.m2120a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f1624c != null) {
            this.f1624c.m2164a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f1624c == null || f751a || !this.f1624c.m2167c()) {
            return;
        }
        this.f1624c.m2166b();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (f751a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.f1624c != null) {
            this.f1624c.m2160a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (f751a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.f1624c != null) {
            this.f1624c.m2165a(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (f751a) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.f1624c != null) {
            this.f1624c.m2158a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1623b != null) {
            this.f1623b.m2073a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1623b != null) {
            this.f1623b.m2070a(i);
        }
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1623b != null) {
            this.f1623b.m2071a(colorStateList);
        }
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1623b != null) {
            this.f1623b.m2072a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1624c != null) {
            this.f1624c.m2161a(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (f751a) {
            super.setTextSize(i, f);
        } else if (this.f1624c != null) {
            this.f1624c.m2159a(i, f);
        }
    }
}
