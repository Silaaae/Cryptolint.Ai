package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.p015g.C0124p;
import android.support.v4.p015g.C0127s;
import android.support.v4.p015g.InterfaceC0128t;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: android.support.v7.widget.a */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0240a extends ViewGroup {

    /* JADX INFO: renamed from: a */
    protected final a f1610a;

    /* JADX INFO: renamed from: b */
    protected final Context f1611b;

    /* JADX INFO: renamed from: c */
    protected ActionMenuView f1612c;

    /* JADX INFO: renamed from: d */
    protected C0273d f1613d;

    /* JADX INFO: renamed from: e */
    protected int f1614e;

    /* JADX INFO: renamed from: f */
    protected C0127s f1615f;

    /* JADX INFO: renamed from: g */
    private boolean f1616g;

    /* JADX INFO: renamed from: h */
    private boolean f1617h;

    /* JADX INFO: renamed from: android.support.v7.widget.a$a */
    protected class a implements InterfaceC0128t {

        /* JADX INFO: renamed from: a */
        int f1618a;

        /* JADX INFO: renamed from: c */
        private boolean f1620c = false;

        protected a() {
        }

        /* JADX INFO: renamed from: a */
        public a m1794a(C0127s c0127s, int i) {
            AbstractC0240a.this.f1615f = c0127s;
            this.f1618a = i;
            return this;
        }

        @Override // android.support.v4.p015g.InterfaceC0128t
        /* JADX INFO: renamed from: a */
        public void mo1026a(View view) {
            AbstractC0240a.super.setVisibility(0);
            this.f1620c = false;
        }

        @Override // android.support.v4.p015g.InterfaceC0128t
        /* JADX INFO: renamed from: b */
        public void mo1027b(View view) {
            if (this.f1620c) {
                return;
            }
            AbstractC0240a.this.f1615f = null;
            AbstractC0240a.super.setVisibility(this.f1618a);
        }

        @Override // android.support.v4.p015g.InterfaceC0128t
        /* JADX INFO: renamed from: c */
        public void mo1028c(View view) {
            this.f1620c = true;
        }
    }

    AbstractC0240a(Context context) {
        this(context, null);
    }

    AbstractC0240a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    AbstractC0240a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1610a = new a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0148a.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1611b = context;
        } else {
            this.f1611b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* JADX INFO: renamed from: a */
    protected static int m1789a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    /* JADX INFO: renamed from: a */
    protected int m1792a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    /* JADX INFO: renamed from: a */
    protected int m1793a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* JADX INFO: renamed from: a */
    public C0127s mo1637a(int i, long j) {
        C0127s c0127sM1017a;
        if (this.f1615f != null) {
            this.f1615f.m1024b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(0.0f);
            }
            c0127sM1017a = C0124p.m962d(this).m1017a(1.0f);
        } else {
            c0127sM1017a = C0124p.m962d(this).m1017a(0.0f);
        }
        c0127sM1017a.m1018a(j);
        c0127sM1017a.m1019a(this.f1610a.m1794a(c0127sM1017a, i));
        return c0127sM1017a;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo1639a() {
        if (this.f1613d != null) {
            return this.f1613d.m2043d();
        }
        return false;
    }

    public int getAnimatedVisibility() {
        return this.f1615f != null ? this.f1610a.f1618a : getVisibility();
    }

    public int getContentHeight() {
        return this.f1614e;
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, C0148a.j.ActionBar, C0148a.a.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(C0148a.j.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        if (this.f1613d != null) {
            this.f1613d.m2037a(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1617h = false;
        }
        if (!this.f1617h) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f1617h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1617h = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1616g = false;
        }
        if (!this.f1616g) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f1616g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1616g = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1614e = i;
        requestLayout();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1615f != null) {
                this.f1615f.m1024b();
            }
            super.setVisibility(i);
        }
    }
}
