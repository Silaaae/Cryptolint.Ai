package android.support.v7.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.p015g.C0121m;
import android.support.v4.p015g.C0124p;
import android.support.v4.p015g.InterfaceC0119k;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.menu.InterfaceC0203o;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC0119k, InterfaceC0244ad {

    /* JADX INFO: renamed from: e */
    static final int[] f1410e = {C0148a.a.actionBarSize, R.attr.windowContentOverlay};

    /* JADX INFO: renamed from: A */
    private final Runnable f1411A;

    /* JADX INFO: renamed from: B */
    private final Runnable f1412B;

    /* JADX INFO: renamed from: C */
    private final C0121m f1413C;

    /* JADX INFO: renamed from: a */
    ActionBarContainer f1414a;

    /* JADX INFO: renamed from: b */
    boolean f1415b;

    /* JADX INFO: renamed from: c */
    ViewPropertyAnimator f1416c;

    /* JADX INFO: renamed from: d */
    final AnimatorListenerAdapter f1417d;

    /* JADX INFO: renamed from: f */
    private int f1418f;

    /* JADX INFO: renamed from: g */
    private int f1419g;

    /* JADX INFO: renamed from: h */
    private ContentFrameLayout f1420h;

    /* JADX INFO: renamed from: i */
    private InterfaceC0245ae f1421i;

    /* JADX INFO: renamed from: j */
    private Drawable f1422j;

    /* JADX INFO: renamed from: k */
    private boolean f1423k;

    /* JADX INFO: renamed from: l */
    private boolean f1424l;

    /* JADX INFO: renamed from: m */
    private boolean f1425m;

    /* JADX INFO: renamed from: n */
    private boolean f1426n;

    /* JADX INFO: renamed from: o */
    private int f1427o;

    /* JADX INFO: renamed from: p */
    private int f1428p;

    /* JADX INFO: renamed from: q */
    private final Rect f1429q;

    /* JADX INFO: renamed from: r */
    private final Rect f1430r;

    /* JADX INFO: renamed from: s */
    private final Rect f1431s;

    /* JADX INFO: renamed from: t */
    private final Rect f1432t;

    /* JADX INFO: renamed from: u */
    private final Rect f1433u;

    /* JADX INFO: renamed from: v */
    private final Rect f1434v;

    /* JADX INFO: renamed from: w */
    private final Rect f1435w;

    /* JADX INFO: renamed from: x */
    private InterfaceC0215a f1436x;

    /* JADX INFO: renamed from: y */
    private final int f1437y;

    /* JADX INFO: renamed from: z */
    private OverScroller f1438z;

    /* JADX INFO: renamed from: android.support.v7.widget.ActionBarOverlayLayout$a */
    public interface InterfaceC0215a {
        /* JADX INFO: renamed from: a */
        void mo1360a(int i);

        /* JADX INFO: renamed from: g */
        void mo1363g(boolean z);

        /* JADX INFO: renamed from: j */
        void mo1368j();

        /* JADX INFO: renamed from: k */
        void mo1370k();

        /* JADX INFO: renamed from: l */
        void mo1371l();

        /* JADX INFO: renamed from: m */
        void mo1372m();
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionBarOverlayLayout$b */
    public static class C0216b extends ViewGroup.MarginLayoutParams {
        public C0216b(int i, int i2) {
            super(i, i2);
        }

        public C0216b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0216b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1419g = 0;
        this.f1429q = new Rect();
        this.f1430r = new Rect();
        this.f1431s = new Rect();
        this.f1432t = new Rect();
        this.f1433u = new Rect();
        this.f1434v = new Rect();
        this.f1435w = new Rect();
        this.f1437y = 600;
        this.f1417d = new AnimatorListenerAdapter() { // from class: android.support.v7.widget.ActionBarOverlayLayout.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                ActionBarOverlayLayout.this.f1416c = null;
                ActionBarOverlayLayout.this.f1415b = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ActionBarOverlayLayout.this.f1416c = null;
                ActionBarOverlayLayout.this.f1415b = false;
            }
        };
        this.f1411A = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.2
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.m1657d();
                ActionBarOverlayLayout.this.f1416c = ActionBarOverlayLayout.this.f1414a.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.f1417d);
            }
        };
        this.f1412B = new Runnable() { // from class: android.support.v7.widget.ActionBarOverlayLayout.3
            @Override // java.lang.Runnable
            public void run() {
                ActionBarOverlayLayout.this.m1657d();
                ActionBarOverlayLayout.this.f1416c = ActionBarOverlayLayout.this.f1414a.animate().translationY(-ActionBarOverlayLayout.this.f1414a.getHeight()).setListener(ActionBarOverlayLayout.this.f1417d);
            }
        };
        m1644a(context);
        this.f1413C = new C0121m(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private InterfaceC0245ae m1643a(View view) {
        if (view instanceof InterfaceC0245ae) {
            return (InterfaceC0245ae) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    /* JADX INFO: renamed from: a */
    private void m1644a(Context context) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1410e);
        this.f1418f = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1422j = typedArrayObtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1422j == null);
        typedArrayObtainStyledAttributes.recycle();
        this.f1423k = context.getApplicationInfo().targetSdkVersion < 19;
        this.f1438z = new OverScroller(context);
    }

    /* JADX INFO: renamed from: a */
    private boolean m1645a(float f, float f2) {
        this.f1438z.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f1438z.getFinalY() > this.f1414a.getHeight();
    }

    /* JADX INFO: renamed from: a */
    private boolean m1646a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        C0216b c0216b = (C0216b) view.getLayoutParams();
        if (!z || c0216b.leftMargin == rect.left) {
            z5 = false;
        } else {
            c0216b.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && c0216b.topMargin != rect.top) {
            c0216b.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && c0216b.rightMargin != rect.right) {
            c0216b.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || c0216b.bottomMargin == rect.bottom) {
            return z5;
        }
        c0216b.bottomMargin = rect.bottom;
        return true;
    }

    /* JADX INFO: renamed from: l */
    private void m1647l() {
        m1657d();
        postDelayed(this.f1411A, 600L);
    }

    /* JADX INFO: renamed from: m */
    private void m1648m() {
        m1657d();
        postDelayed(this.f1412B, 600L);
    }

    /* JADX INFO: renamed from: n */
    private void m1649n() {
        m1657d();
        this.f1411A.run();
    }

    /* JADX INFO: renamed from: o */
    private void m1650o() {
        m1657d();
        this.f1412B.run();
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0216b generateLayoutParams(AttributeSet attributeSet) {
        return new C0216b(getContext(), attributeSet);
    }

    @Override // android.support.v7.widget.InterfaceC0244ad
    /* JADX INFO: renamed from: a */
    public void mo1652a(int i) {
        m1656c();
        if (i == 2) {
            this.f1421i.mo1841f();
        } else if (i == 5) {
            this.f1421i.mo1842g();
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    @Override // android.support.v7.widget.InterfaceC0244ad
    /* JADX INFO: renamed from: a */
    public void mo1653a(Menu menu, InterfaceC0203o.a aVar) {
        m1656c();
        this.f1421i.mo1829a(menu, aVar);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1654a() {
        return this.f1424l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0216b generateDefaultLayoutParams() {
        return new C0216b(-1, -1);
    }

    /* JADX INFO: renamed from: c */
    void m1656c() {
        if (this.f1420h == null) {
            this.f1420h = (ContentFrameLayout) findViewById(C0148a.f.action_bar_activity_content);
            this.f1414a = (ActionBarContainer) findViewById(C0148a.f.action_bar_container);
            this.f1421i = m1643a(findViewById(C0148a.f.action_bar));
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0216b;
    }

    /* JADX INFO: renamed from: d */
    void m1657d() {
        removeCallbacks(this.f1411A);
        removeCallbacks(this.f1412B);
        if (this.f1416c != null) {
            this.f1416c.cancel();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1422j == null || this.f1423k) {
            return;
        }
        int bottom = this.f1414a.getVisibility() == 0 ? (int) (this.f1414a.getBottom() + this.f1414a.getTranslationY() + 0.5f) : 0;
        this.f1422j.setBounds(0, bottom, getWidth(), this.f1422j.getIntrinsicHeight() + bottom);
        this.f1422j.draw(canvas);
    }

    @Override // android.support.v7.widget.InterfaceC0244ad
    /* JADX INFO: renamed from: e */
    public boolean mo1658e() {
        m1656c();
        return this.f1421i.mo1843h();
    }

    @Override // android.support.v7.widget.InterfaceC0244ad
    /* JADX INFO: renamed from: f */
    public boolean mo1659f() {
        m1656c();
        return this.f1421i.mo1844i();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        m1656c();
        int iM964f = C0124p.m964f(this) & 256;
        boolean zM1646a = m1646a(this.f1414a, rect, true, true, false, true);
        this.f1432t.set(rect);
        C0270bc.m2026a(this, this.f1432t, this.f1429q);
        if (!this.f1433u.equals(this.f1432t)) {
            this.f1433u.set(this.f1432t);
            zM1646a = true;
        }
        if (!this.f1430r.equals(this.f1429q)) {
            this.f1430r.set(this.f1429q);
            zM1646a = true;
        }
        if (zM1646a) {
            requestLayout();
        }
        return true;
    }

    @Override // android.support.v7.widget.InterfaceC0244ad
    /* JADX INFO: renamed from: g */
    public boolean mo1660g() {
        m1656c();
        return this.f1421i.mo1845j();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0216b(layoutParams);
    }

    public int getActionBarHideOffset() {
        if (this.f1414a != null) {
            return -((int) this.f1414a.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f1413C.m942a();
    }

    public CharSequence getTitle() {
        m1656c();
        return this.f1421i.mo1840e();
    }

    @Override // android.support.v7.widget.InterfaceC0244ad
    /* JADX INFO: renamed from: h */
    public boolean mo1661h() {
        m1656c();
        return this.f1421i.mo1846k();
    }

    @Override // android.support.v7.widget.InterfaceC0244ad
    /* JADX INFO: renamed from: i */
    public boolean mo1662i() {
        m1656c();
        return this.f1421i.mo1847l();
    }

    @Override // android.support.v7.widget.InterfaceC0244ad
    /* JADX INFO: renamed from: j */
    public void mo1663j() {
        m1656c();
        this.f1421i.mo1848m();
    }

    @Override // android.support.v7.widget.InterfaceC0244ad
    /* JADX INFO: renamed from: k */
    public void mo1664k() {
        m1656c();
        this.f1421i.mo1849n();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m1644a(getContext());
        C0124p.m965g(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1657d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        getPaddingRight();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0216b c0216b = (C0216b) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = c0216b.leftMargin + paddingLeft;
                int i7 = c0216b.topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        Rect rect;
        m1656c();
        measureChildWithMargins(this.f1414a, i, 0, i2, 0);
        C0216b c0216b = (C0216b) this.f1414a.getLayoutParams();
        int iMax = Math.max(0, this.f1414a.getMeasuredWidth() + c0216b.leftMargin + c0216b.rightMargin);
        int iMax2 = Math.max(0, this.f1414a.getMeasuredHeight() + c0216b.topMargin + c0216b.bottomMargin);
        int iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1414a.getMeasuredState());
        boolean z = (C0124p.m964f(this) & 256) != 0;
        if (z) {
            measuredHeight = this.f1418f;
            if (this.f1425m && this.f1414a.getTabContainer() != null) {
                measuredHeight += this.f1418f;
            }
        } else {
            measuredHeight = this.f1414a.getVisibility() != 8 ? this.f1414a.getMeasuredHeight() : 0;
        }
        this.f1431s.set(this.f1429q);
        this.f1434v.set(this.f1432t);
        if (this.f1424l || z) {
            this.f1434v.top += measuredHeight;
            rect = this.f1434v;
        } else {
            this.f1431s.top += measuredHeight;
            rect = this.f1431s;
        }
        rect.bottom += 0;
        m1646a(this.f1420h, this.f1431s, true, true, true, true);
        if (!this.f1435w.equals(this.f1434v)) {
            this.f1435w.set(this.f1434v);
            this.f1420h.m1705a(this.f1434v);
        }
        measureChildWithMargins(this.f1420h, i, 0, i2, 0);
        C0216b c0216b2 = (C0216b) this.f1420h.getLayoutParams();
        int iMax3 = Math.max(iMax, this.f1420h.getMeasuredWidth() + c0216b2.leftMargin + c0216b2.rightMargin);
        int iMax4 = Math.max(iMax2, this.f1420h.getMeasuredHeight() + c0216b2.topMargin + c0216b2.bottomMargin);
        int iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1420h.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i, iCombineMeasuredStates2), View.resolveSizeAndState(Math.max(iMax4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1426n || !z) {
            return false;
        }
        if (m1645a(f, f2)) {
            m1650o();
        } else {
            m1649n();
        }
        this.f1415b = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1427o += i2;
        setActionBarHideOffset(this.f1427o);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1413C.m945a(view, view2, i);
        this.f1427o = getActionBarHideOffset();
        m1657d();
        if (this.f1436x != null) {
            this.f1436x.mo1371l();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f1414a.getVisibility() != 0) {
            return false;
        }
        return this.f1426n;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public void onStopNestedScroll(View view) {
        if (this.f1426n && !this.f1415b) {
            if (this.f1427o <= this.f1414a.getHeight()) {
                m1647l();
            } else {
                m1648m();
            }
        }
        if (this.f1436x != null) {
            this.f1436x.mo1372m();
        }
    }

    @Override // android.view.View
    public void onWindowSystemUiVisibilityChanged(int i) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m1656c();
        int i2 = this.f1428p ^ i;
        this.f1428p = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & 256) != 0;
        if (this.f1436x != null) {
            this.f1436x.mo1363g(!z2);
            if (z || !z2) {
                this.f1436x.mo1368j();
            } else {
                this.f1436x.mo1370k();
            }
        }
        if ((i2 & 256) == 0 || this.f1436x == null) {
            return;
        }
        C0124p.m965g(this);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1419g = i;
        if (this.f1436x != null) {
            this.f1436x.mo1360a(i);
        }
    }

    public void setActionBarHideOffset(int i) {
        m1657d();
        this.f1414a.setTranslationY(-Math.max(0, Math.min(i, this.f1414a.getHeight())));
    }

    public void setActionBarVisibilityCallback(InterfaceC0215a interfaceC0215a) {
        this.f1436x = interfaceC0215a;
        if (getWindowToken() != null) {
            this.f1436x.mo1360a(this.f1419g);
            if (this.f1428p != 0) {
                onWindowSystemUiVisibilityChanged(this.f1428p);
                C0124p.m965g(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1425m = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1426n) {
            this.f1426n = z;
            if (z) {
                return;
            }
            m1657d();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        m1656c();
        this.f1421i.mo1825a(i);
    }

    public void setIcon(Drawable drawable) {
        m1656c();
        this.f1421i.mo1826a(drawable);
    }

    public void setLogo(int i) {
        m1656c();
        this.f1421i.mo1834b(i);
    }

    public void setOverlayMode(boolean z) {
        this.f1424l = z;
        this.f1423k = z && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // android.support.v7.widget.InterfaceC0244ad
    public void setWindowCallback(Window.Callback callback) {
        m1656c();
        this.f1421i.mo1830a(callback);
    }

    @Override // android.support.v7.widget.InterfaceC0244ad
    public void setWindowTitle(CharSequence charSequence) {
        m1656c();
        this.f1421i.mo1831a(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
