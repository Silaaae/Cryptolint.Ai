package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p015g.C0124p;
import android.support.v4.p015g.C0127s;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.AbstractC0179b;
import android.support.v7.view.menu.C0196h;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends AbstractC0240a {

    /* JADX INFO: renamed from: g */
    private CharSequence f1397g;

    /* JADX INFO: renamed from: h */
    private CharSequence f1398h;

    /* JADX INFO: renamed from: i */
    private View f1399i;

    /* JADX INFO: renamed from: j */
    private View f1400j;

    /* JADX INFO: renamed from: k */
    private LinearLayout f1401k;

    /* JADX INFO: renamed from: l */
    private TextView f1402l;

    /* JADX INFO: renamed from: m */
    private TextView f1403m;

    /* JADX INFO: renamed from: n */
    private int f1404n;

    /* JADX INFO: renamed from: o */
    private int f1405o;

    /* JADX INFO: renamed from: p */
    private boolean f1406p;

    /* JADX INFO: renamed from: q */
    private int f1407q;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0148a.a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C0263aw c0263awM1978a = C0263aw.m1978a(context, attributeSet, C0148a.j.ActionMode, i, 0);
        C0124p.m954a(this, c0263awM1978a.m1982a(C0148a.j.ActionMode_background));
        this.f1404n = c0263awM1978a.m1995g(C0148a.j.ActionMode_titleTextStyle, 0);
        this.f1405o = c0263awM1978a.m1995g(C0148a.j.ActionMode_subtitleTextStyle, 0);
        this.f1614e = c0263awM1978a.m1993f(C0148a.j.ActionMode_height, 0);
        this.f1407q = c0263awM1978a.m1995g(C0148a.j.ActionMode_closeItemLayout, C0148a.g.abc_action_mode_close_item_material);
        c0263awM1978a.m1983a();
    }

    /* JADX INFO: renamed from: e */
    private void m1636e() {
        if (this.f1401k == null) {
            LayoutInflater.from(getContext()).inflate(C0148a.g.abc_action_bar_title_item, this);
            this.f1401k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1402l = (TextView) this.f1401k.findViewById(C0148a.f.action_bar_title);
            this.f1403m = (TextView) this.f1401k.findViewById(C0148a.f.action_bar_subtitle);
            if (this.f1404n != 0) {
                this.f1402l.setTextAppearance(getContext(), this.f1404n);
            }
            if (this.f1405o != 0) {
                this.f1403m.setTextAppearance(getContext(), this.f1405o);
            }
        }
        this.f1402l.setText(this.f1397g);
        this.f1403m.setText(this.f1398h);
        boolean z = !TextUtils.isEmpty(this.f1397g);
        boolean z2 = !TextUtils.isEmpty(this.f1398h);
        this.f1403m.setVisibility(z2 ? 0 : 8);
        this.f1401k.setVisibility((z || z2) ? 0 : 8);
        if (this.f1401k.getParent() == null) {
            addView(this.f1401k);
        }
    }

    @Override // android.support.v7.widget.AbstractC0240a
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ C0127s mo1637a(int i, long j) {
        return super.mo1637a(i, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003e  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1638a(final AbstractC0179b abstractC0179b) {
        if (this.f1399i != null) {
            if (this.f1399i.getParent() == null) {
            }
            this.f1399i.findViewById(C0148a.f.action_mode_close_button).setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.ActionBarContextView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    abstractC0179b.mo1381c();
                }
            });
            C0196h c0196h = (C0196h) abstractC0179b.mo1378b();
            if (this.f1613d != null) {
                this.f1613d.m2045f();
            }
            this.f1613d = new C0273d(getContext());
            this.f1613d.m2041c(true);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
            c0196h.m1541a(this.f1613d, this.f1611b);
            this.f1612c = (ActionMenuView) this.f1613d.mo1466a(this);
            C0124p.m954a(this.f1612c, (Drawable) null);
            addView(this.f1612c, layoutParams);
        }
        this.f1399i = LayoutInflater.from(getContext()).inflate(this.f1407q, (ViewGroup) this, false);
        addView(this.f1399i);
        this.f1399i.findViewById(C0148a.f.action_mode_close_button).setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                abstractC0179b.mo1381c();
            }
        });
        C0196h c0196h2 = (C0196h) abstractC0179b.mo1378b();
        if (this.f1613d != null) {
        }
        this.f1613d = new C0273d(getContext());
        this.f1613d.m2041c(true);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-2, -1);
        c0196h2.m1541a(this.f1613d, this.f1611b);
        this.f1612c = (ActionMenuView) this.f1613d.mo1466a(this);
        C0124p.m954a(this.f1612c, (Drawable) null);
        addView(this.f1612c, layoutParams2);
    }

    @Override // android.support.v7.widget.AbstractC0240a
    /* JADX INFO: renamed from: a */
    public boolean mo1639a() {
        if (this.f1613d != null) {
            return this.f1613d.m2043d();
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public void m1640b() {
        if (this.f1399i == null) {
            m1641c();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m1641c() {
        removeAllViews();
        this.f1400j = null;
        this.f1612c = null;
    }

    /* JADX INFO: renamed from: d */
    public boolean m1642d() {
        return this.f1406p;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.support.v7.widget.AbstractC0240a
    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    @Override // android.support.v7.widget.AbstractC0240a
    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public CharSequence getSubtitle() {
        return this.f1398h;
    }

    public CharSequence getTitle() {
        return this.f1397g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1613d != null) {
            this.f1613d.m2044e();
            this.f1613d.m2046g();
        }
    }

    @Override // android.support.v7.widget.AbstractC0240a, android.view.View
    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() != 32) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            return;
        }
        accessibilityEvent.setSource(this);
        accessibilityEvent.setClassName(getClass().getName());
        accessibilityEvent.setPackageName(getContext().getPackageName());
        accessibilityEvent.setContentDescription(this.f1397g);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iA;
        boolean zM2027a = C0270bc.m2027a(this);
        int paddingRight = zM2027a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f1399i == null || this.f1399i.getVisibility() == 8) {
            iA = paddingRight;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1399i.getLayoutParams();
            int i5 = zM2027a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = zM2027a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int iA2 = m1789a(paddingRight, i5, zM2027a);
            iA = m1789a(iA2 + m1793a(this.f1399i, iA2, paddingTop, paddingTop2, zM2027a), i6, zM2027a);
        }
        if (this.f1401k != null && this.f1400j == null && this.f1401k.getVisibility() != 8) {
            iA += m1793a(this.f1401k, iA, paddingTop, paddingTop2, zM2027a);
        }
        int i7 = iA;
        if (this.f1400j != null) {
            m1793a(this.f1400j, i7, paddingTop, paddingTop2, zM2027a);
        }
        int paddingLeft = zM2027a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.f1612c != null) {
            m1793a(this.f1612c, paddingLeft, paddingTop, paddingTop2, !zM2027a);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_width=\"match_parent\" (or fill_parent)");
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with android:layout_height=\"wrap_content\"");
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.f1614e > 0 ? this.f1614e : View.MeasureSpec.getSize(i2);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingTop;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        if (this.f1399i != null) {
            int iA = m1792a(this.f1399i, paddingLeft, iMakeMeasureSpec, 0);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f1399i.getLayoutParams();
            paddingLeft = iA - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        if (this.f1612c != null && this.f1612c.getParent() == this) {
            paddingLeft = m1792a(this.f1612c, paddingLeft, iMakeMeasureSpec, 0);
        }
        if (this.f1401k != null && this.f1400j == null) {
            if (this.f1406p) {
                this.f1401k.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.f1401k.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.f1401k.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = m1792a(this.f1401k, paddingLeft, iMakeMeasureSpec, 0);
            }
        }
        if (this.f1400j != null) {
            ViewGroup.LayoutParams layoutParams = this.f1400j.getLayoutParams();
            int i3 = layoutParams.width != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (layoutParams.width >= 0) {
                paddingLeft = Math.min(layoutParams.width, paddingLeft);
            }
            int i4 = layoutParams.height == -2 ? Integer.MIN_VALUE : 1073741824;
            if (layoutParams.height >= 0) {
                iMin = Math.min(layoutParams.height, iMin);
            }
            this.f1400j.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i3), View.MeasureSpec.makeMeasureSpec(iMin, i4));
        }
        if (this.f1614e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            int measuredHeight = getChildAt(i6).getMeasuredHeight() + paddingTop;
            if (measuredHeight > i5) {
                i5 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i5);
    }

    @Override // android.support.v7.widget.AbstractC0240a, android.view.View
    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.support.v7.widget.AbstractC0240a
    public void setContentHeight(int i) {
        this.f1614e = i;
    }

    public void setCustomView(View view) {
        if (this.f1400j != null) {
            removeView(this.f1400j);
        }
        this.f1400j = view;
        if (view != null && this.f1401k != null) {
            removeView(this.f1401k);
            this.f1401k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1398h = charSequence;
        m1636e();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1397g = charSequence;
        m1636e();
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1406p) {
            requestLayout();
        }
        this.f1406p = z;
    }

    @Override // android.support.v7.widget.AbstractC0240a, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
