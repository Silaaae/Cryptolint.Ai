package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: renamed from: android.support.v7.widget.aa */
/* JADX INFO: loaded from: classes.dex */
class C0241aa extends C0295z {

    /* JADX INFO: renamed from: b */
    private C0261au f1621b;

    /* JADX INFO: renamed from: c */
    private C0261au f1622c;

    C0241aa(TextView textView) {
        super(textView);
    }

    @Override // android.support.v7.widget.C0295z
    /* JADX INFO: renamed from: a */
    void mo1795a() {
        super.mo1795a();
        if (this.f1621b == null && this.f1622c == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.f1986a.getCompoundDrawablesRelative();
        m2162a(compoundDrawablesRelative[0], this.f1621b);
        m2162a(compoundDrawablesRelative[2], this.f1622c);
    }

    @Override // android.support.v7.widget.C0295z
    /* JADX INFO: renamed from: a */
    void mo1796a(AttributeSet attributeSet, int i) {
        super.mo1796a(attributeSet, i);
        Context context = this.f1986a.getContext();
        C0281l c0281lM2092a = C0281l.m2092a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0148a.j.AppCompatTextHelper, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(C0148a.j.AppCompatTextHelper_android_drawableStart)) {
            this.f1621b = m2152a(context, c0281lM2092a, typedArrayObtainStyledAttributes.getResourceId(C0148a.j.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (typedArrayObtainStyledAttributes.hasValue(C0148a.j.AppCompatTextHelper_android_drawableEnd)) {
            this.f1622c = m2152a(context, c0281lM2092a, typedArrayObtainStyledAttributes.getResourceId(C0148a.j.AppCompatTextHelper_android_drawableEnd, 0));
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
