package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.p015g.C0124p;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContainer extends FrameLayout {

    /* JADX INFO: renamed from: a */
    Drawable f1387a;

    /* JADX INFO: renamed from: b */
    Drawable f1388b;

    /* JADX INFO: renamed from: c */
    Drawable f1389c;

    /* JADX INFO: renamed from: d */
    boolean f1390d;

    /* JADX INFO: renamed from: e */
    boolean f1391e;

    /* JADX INFO: renamed from: f */
    private boolean f1392f;

    /* JADX INFO: renamed from: g */
    private View f1393g;

    /* JADX INFO: renamed from: h */
    private View f1394h;

    /* JADX INFO: renamed from: i */
    private View f1395i;

    /* JADX INFO: renamed from: j */
    private int f1396j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C0124p.m954a(this, Build.VERSION.SDK_INT >= 21 ? new C0272c(this) : new C0267b(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0148a.j.ActionBar);
        this.f1387a = typedArrayObtainStyledAttributes.getDrawable(C0148a.j.ActionBar_background);
        this.f1388b = typedArrayObtainStyledAttributes.getDrawable(C0148a.j.ActionBar_backgroundStacked);
        this.f1396j = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0148a.j.ActionBar_height, -1);
        if (getId() == C0148a.f.split_action_bar) {
            this.f1390d = true;
            this.f1389c = typedArrayObtainStyledAttributes.getDrawable(C0148a.j.ActionBar_backgroundSplit);
        }
        typedArrayObtainStyledAttributes.recycle();
        boolean z = false;
        if (!this.f1390d ? !(this.f1387a != null || this.f1388b != null) : this.f1389c == null) {
            z = true;
        }
        setWillNotDraw(z);
    }

    /* JADX INFO: renamed from: a */
    private boolean m1634a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    /* JADX INFO: renamed from: b */
    private int m1635b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1387a != null && this.f1387a.isStateful()) {
            this.f1387a.setState(getDrawableState());
        }
        if (this.f1388b != null && this.f1388b.isStateful()) {
            this.f1388b.setState(getDrawableState());
        }
        if (this.f1389c == null || !this.f1389c.isStateful()) {
            return;
        }
        this.f1389c.setState(getDrawableState());
    }

    public View getTabContainer() {
        return this.f1393g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f1387a != null) {
            this.f1387a.jumpToCurrentState();
        }
        if (this.f1388b != null) {
            this.f1388b.jumpToCurrentState();
        }
        if (this.f1389c != null) {
            this.f1389c.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1394h = findViewById(C0148a.f.action_bar);
        this.f1395i = findViewById(C0148a.f.action_context_bar);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        super.onHoverEvent(motionEvent);
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1392f || super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Drawable drawable;
        int left;
        int top;
        int right;
        View view;
        super.onLayout(z, i, i2, i3, i4);
        View view2 = this.f1393g;
        boolean z2 = true;
        boolean z3 = false;
        boolean z4 = (view2 == null || view2.getVisibility() == 8) ? false : true;
        if (view2 != null && view2.getVisibility() != 8) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
            view2.layout(i, (measuredHeight - view2.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1390d) {
            if (this.f1387a != null) {
                if (this.f1394h.getVisibility() == 0) {
                    drawable = this.f1387a;
                    left = this.f1394h.getLeft();
                    top = this.f1394h.getTop();
                    right = this.f1394h.getRight();
                    view = this.f1394h;
                } else if (this.f1395i == null || this.f1395i.getVisibility() != 0) {
                    this.f1387a.setBounds(0, 0, 0, 0);
                    z3 = true;
                } else {
                    drawable = this.f1387a;
                    left = this.f1395i.getLeft();
                    top = this.f1395i.getTop();
                    right = this.f1395i.getRight();
                    view = this.f1395i;
                }
                drawable.setBounds(left, top, right, view.getBottom());
                z3 = true;
            }
            this.f1391e = z4;
            if (!z4 || this.f1388b == null) {
                z2 = z3;
            } else {
                this.f1388b.setBounds(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            }
        } else if (this.f1389c != null) {
            this.f1389c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            z2 = false;
        }
        if (z2) {
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int iM1635b;
        View view;
        if (this.f1394h == null && View.MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f1396j >= 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(this.f1396j, View.MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1394h == null) {
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        if (this.f1393g == null || this.f1393g.getVisibility() == 8 || mode == 1073741824) {
            return;
        }
        if (!m1634a(this.f1394h)) {
            view = this.f1394h;
        } else {
            if (m1634a(this.f1395i)) {
                iM1635b = 0;
                setMeasuredDimension(getMeasuredWidth(), Math.min(iM1635b + m1635b(this.f1393g), mode != Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
            view = this.f1395i;
        }
        iM1635b = m1635b(view);
        setMeasuredDimension(getMeasuredWidth(), Math.min(iM1635b + m1635b(this.f1393g), mode != Integer.MIN_VALUE ? View.MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setPrimaryBackground(Drawable drawable) {
        if (this.f1387a != null) {
            this.f1387a.setCallback(null);
            unscheduleDrawable(this.f1387a);
        }
        this.f1387a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1394h != null) {
                this.f1387a.setBounds(this.f1394h.getLeft(), this.f1394h.getTop(), this.f1394h.getRight(), this.f1394h.getBottom());
            }
        }
        boolean z = false;
        if (!this.f1390d ? !(this.f1387a != null || this.f1388b != null) : this.f1389c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        if (this.f1389c != null) {
            this.f1389c.setCallback(null);
            unscheduleDrawable(this.f1389c);
        }
        this.f1389c = drawable;
        boolean z = false;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1390d && this.f1389c != null) {
                this.f1389c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (!this.f1390d ? !(this.f1387a != null || this.f1388b != null) : this.f1389c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        if (this.f1388b != null) {
            this.f1388b.setCallback(null);
            unscheduleDrawable(this.f1388b);
        }
        this.f1388b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1391e && this.f1388b != null) {
                this.f1388b.setBounds(this.f1393g.getLeft(), this.f1393g.getTop(), this.f1393g.getRight(), this.f1393g.getBottom());
            }
        }
        boolean z = false;
        if (!this.f1390d ? !(this.f1387a != null || this.f1388b != null) : this.f1389c == null) {
            z = true;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setTabContainer(C0256ap c0256ap) {
        if (this.f1393g != null) {
            removeView(this.f1393g);
        }
        this.f1393g = c0256ap;
        if (c0256ap != null) {
            addView(c0256ap);
            ViewGroup.LayoutParams layoutParams = c0256ap.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            c0256ap.setAllowCollapse(false);
        }
    }

    public void setTransitioning(boolean z) {
        this.f1392f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f1387a != null) {
            this.f1387a.setVisible(z, false);
        }
        if (this.f1388b != null) {
            this.f1388b.setVisible(z, false);
        }
        if (this.f1389c != null) {
            this.f1389c.setVisible(z, false);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ActionMode startActionModeForChild(View view, ActionMode.Callback callback, int i) {
        if (i != 0) {
            return super.startActionModeForChild(view, callback, i);
        }
        return null;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1387a && !this.f1390d) || (drawable == this.f1388b && this.f1391e) || ((drawable == this.f1389c && this.f1390d) || super.verifyDrawable(drawable));
    }
}
