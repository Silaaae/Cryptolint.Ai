package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.widget.C0144j;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: android.support.v7.widget.s */
/* JADX INFO: loaded from: classes.dex */
class C0288s extends PopupWindow {

    /* JADX INFO: renamed from: a */
    private static final boolean f1949a;

    /* JADX INFO: renamed from: b */
    private boolean f1950b;

    static {
        f1949a = Build.VERSION.SDK_INT < 21;
    }

    public C0288s(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m2131a(context, attributeSet, i, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m2131a(Context context, AttributeSet attributeSet, int i, int i2) {
        C0263aw c0263awM1978a = C0263aw.m1978a(context, attributeSet, C0148a.j.PopupWindow, i, i2);
        if (c0263awM1978a.m1996g(C0148a.j.PopupWindow_overlapAnchor)) {
            m2132a(c0263awM1978a.m1984a(C0148a.j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(c0263awM1978a.m1982a(C0148a.j.PopupWindow_android_popupBackground));
        c0263awM1978a.m1983a();
    }

    /* JADX INFO: renamed from: a */
    private void m2132a(boolean z) {
        if (f1949a) {
            this.f1950b = z;
        } else {
            C0144j.m1137a(this, z);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (f1949a && this.f1950b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f1949a && this.f1950b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (f1949a && this.f1950b) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }
}
