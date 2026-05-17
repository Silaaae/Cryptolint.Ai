package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.p015g.C0124p;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private TypedValue f1488a;

    /* JADX INFO: renamed from: b */
    private TypedValue f1489b;

    /* JADX INFO: renamed from: c */
    private TypedValue f1490c;

    /* JADX INFO: renamed from: d */
    private TypedValue f1491d;

    /* JADX INFO: renamed from: e */
    private TypedValue f1492e;

    /* JADX INFO: renamed from: f */
    private TypedValue f1493f;

    /* JADX INFO: renamed from: g */
    private final Rect f1494g;

    /* JADX INFO: renamed from: h */
    private InterfaceC0224a f1495h;

    /* JADX INFO: renamed from: android.support.v7.widget.ContentFrameLayout$a */
    public interface InterfaceC0224a {
        /* JADX INFO: renamed from: a */
        void mo1322a();

        /* JADX INFO: renamed from: b */
        void mo1323b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1494g = new Rect();
    }

    /* JADX INFO: renamed from: a */
    public void m1704a(int i, int i2, int i3, int i4) {
        this.f1494g.set(i, i2, i3, i4);
        if (C0124p.m970l(this)) {
            requestLayout();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1705a(Rect rect) {
        fitSystemWindows(rect);
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f1492e == null) {
            this.f1492e = new TypedValue();
        }
        return this.f1492e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f1493f == null) {
            this.f1493f = new TypedValue();
        }
        return this.f1493f;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f1490c == null) {
            this.f1490c = new TypedValue();
        }
        return this.f1490c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f1491d == null) {
            this.f1491d = new TypedValue();
        }
        return this.f1491d;
    }

    public TypedValue getMinWidthMajor() {
        if (this.f1488a == null) {
            this.f1488a = new TypedValue();
        }
        return this.f1488a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f1489b == null) {
            this.f1489b = new TypedValue();
        }
        return this.f1489b;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1495h != null) {
            this.f1495h.mo1322a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1495h != null) {
            this.f1495h.mo1323b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f5  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        boolean z;
        int i3;
        float fraction;
        int i4;
        float fraction2;
        int i5;
        float fraction3;
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        boolean z2 = true;
        boolean z3 = displayMetrics.widthPixels < displayMetrics.heightPixels;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != Integer.MIN_VALUE) {
            iMakeMeasureSpec = i;
            z = false;
        } else {
            TypedValue typedValue = z3 ? this.f1491d : this.f1490c;
            if (typedValue != null && typedValue.type != 0) {
                if (typedValue.type == 5) {
                    fraction3 = typedValue.getDimension(displayMetrics);
                } else if (typedValue.type == 6) {
                    fraction3 = typedValue.getFraction(displayMetrics.widthPixels, displayMetrics.widthPixels);
                } else {
                    i5 = 0;
                    if (i5 <= 0) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.min(i5 - (this.f1494g.left + this.f1494g.right), View.MeasureSpec.getSize(i)), 1073741824);
                        z = true;
                    }
                }
                i5 = (int) fraction3;
                if (i5 <= 0) {
                }
            }
        }
        if (mode2 == Integer.MIN_VALUE) {
            TypedValue typedValue2 = z3 ? this.f1492e : this.f1493f;
            if (typedValue2 != null && typedValue2.type != 0) {
                if (typedValue2.type == 5) {
                    fraction2 = typedValue2.getDimension(displayMetrics);
                } else if (typedValue2.type == 6) {
                    fraction2 = typedValue2.getFraction(displayMetrics.heightPixels, displayMetrics.heightPixels);
                } else {
                    i4 = 0;
                    if (i4 > 0) {
                        i2 = View.MeasureSpec.makeMeasureSpec(Math.min(i4 - (this.f1494g.top + this.f1494g.bottom), View.MeasureSpec.getSize(i2)), 1073741824);
                    }
                }
                i4 = (int) fraction2;
                if (i4 > 0) {
                }
            }
        }
        super.onMeasure(iMakeMeasureSpec, i2);
        int measuredWidth = getMeasuredWidth();
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        if (z || mode != Integer.MIN_VALUE) {
            z2 = false;
        } else {
            TypedValue typedValue3 = z3 ? this.f1489b : this.f1488a;
            if (typedValue3 != null && typedValue3.type != 0) {
                if (typedValue3.type == 5) {
                    fraction = typedValue3.getDimension(displayMetrics);
                } else if (typedValue3.type == 6) {
                    fraction = typedValue3.getFraction(displayMetrics.widthPixels, displayMetrics.widthPixels);
                } else {
                    i3 = 0;
                    if (i3 > 0) {
                        i3 -= this.f1494g.left + this.f1494g.right;
                    }
                    if (measuredWidth >= i3) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                    }
                }
                i3 = (int) fraction;
                if (i3 > 0) {
                }
                if (measuredWidth >= i3) {
                }
            }
        }
        if (z2) {
            super.onMeasure(iMakeMeasureSpec2, i2);
        }
    }

    public void setAttachListener(InterfaceC0224a interfaceC0224a) {
        this.f1495h = interfaceC0224a;
    }
}
