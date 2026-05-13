package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.p008b.p009a.C0070a;
import android.support.v4.p015g.C0127s;
import android.support.v4.widget.C0142h;
import android.support.v7.p018a.C0148a;
import android.support.v7.p021c.p022a.C0177a;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: android.support.v7.widget.ag */
/* JADX INFO: loaded from: classes.dex */
class C0247ag extends ListView {

    /* JADX INFO: renamed from: a */
    private final Rect f1639a;

    /* JADX INFO: renamed from: b */
    private int f1640b;

    /* JADX INFO: renamed from: c */
    private int f1641c;

    /* JADX INFO: renamed from: d */
    private int f1642d;

    /* JADX INFO: renamed from: e */
    private int f1643e;

    /* JADX INFO: renamed from: f */
    private int f1644f;

    /* JADX INFO: renamed from: g */
    private Field f1645g;

    /* JADX INFO: renamed from: h */
    private a f1646h;

    /* JADX INFO: renamed from: i */
    private boolean f1647i;

    /* JADX INFO: renamed from: j */
    private boolean f1648j;

    /* JADX INFO: renamed from: k */
    private boolean f1649k;

    /* JADX INFO: renamed from: l */
    private C0127s f1650l;

    /* JADX INFO: renamed from: m */
    private C0142h f1651m;

    /* JADX INFO: renamed from: n */
    private b f1652n;

    /* JADX INFO: renamed from: android.support.v7.widget.ag$a */
    private static class a extends C0177a {

        /* JADX INFO: renamed from: a */
        private boolean f1653a;

        a(Drawable drawable) {
            super(drawable);
            this.f1653a = true;
        }

        /* JADX INFO: renamed from: a */
        void m1869a(boolean z) {
            this.f1653a = z;
        }

        @Override // android.support.v7.p021c.p022a.C0177a, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1653a) {
                super.draw(canvas);
            }
        }

        @Override // android.support.v7.p021c.p022a.C0177a, android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            if (this.f1653a) {
                super.setHotspot(f, f2);
            }
        }

        @Override // android.support.v7.p021c.p022a.C0177a, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f1653a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        @Override // android.support.v7.p021c.p022a.C0177a, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1653a) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // android.support.v7.p021c.p022a.C0177a, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            if (this.f1653a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ag$b */
    private class b implements Runnable {
        private b() {
        }

        /* JADX INFO: renamed from: a */
        public void m1870a() {
            C0247ag.this.f1652n = null;
            C0247ag.this.removeCallbacks(this);
        }

        /* JADX INFO: renamed from: b */
        public void m1871b() {
            C0247ag.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            C0247ag.this.f1652n = null;
            C0247ag.this.drawableStateChanged();
        }
    }

    C0247ag(Context context, boolean z) {
        super(context, null, C0148a.a.dropDownListViewStyle);
        this.f1639a = new Rect();
        this.f1640b = 0;
        this.f1641c = 0;
        this.f1642d = 0;
        this.f1643e = 0;
        this.f1648j = z;
        setCacheColorHint(0);
        try {
            this.f1645g = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1645g.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1858a() {
        Drawable selector = getSelector();
        if (selector != null && m1866c() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1859a(int i, View view) {
        Drawable selector = getSelector();
        boolean z = (selector == null || i == -1) ? false : true;
        if (z) {
            selector.setVisible(false, false);
        }
        m1865b(i, view);
        if (z) {
            Rect rect = this.f1639a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            C0070a.m645a(selector, fExactCenterX, fExactCenterY);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1860a(int i, View view, float f, float f2) {
        m1859a(i, view);
        Drawable selector = getSelector();
        if (selector == null || i == -1) {
            return;
        }
        C0070a.m645a(selector, f, f2);
    }

    /* JADX INFO: renamed from: a */
    private void m1861a(Canvas canvas) {
        Drawable selector;
        if (this.f1639a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f1639a);
        selector.draw(canvas);
    }

    /* JADX INFO: renamed from: a */
    private void m1862a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    /* JADX INFO: renamed from: a */
    private void m1863a(View view, int i, float f, float f2) {
        View childAt;
        this.f1649k = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f1644f != -1 && (childAt = getChildAt(this.f1644f - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1644f = i;
        float left = f - view.getLeft();
        float top = f2 - view.getTop();
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m1860a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    /* JADX INFO: renamed from: b */
    private void m1864b() {
        this.f1649k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1644f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.f1650l != null) {
            this.f1650l.m1024b();
            this.f1650l = null;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m1865b(int i, View view) {
        Rect rect = this.f1639a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1640b;
        rect.top -= this.f1641c;
        rect.right += this.f1642d;
        rect.bottom += this.f1643e;
        try {
            boolean z = this.f1645g.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f1645g.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m1866c() {
        return this.f1649k;
    }

    private void setSelectorEnabled(boolean z) {
        if (this.f1646h != null) {
            this.f1646h.m1869a(z);
        }
    }

    /* JADX INFO: renamed from: a */
    public int mo1867a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int measuredHeight = i6;
        View view = null;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (i7 < count) {
            int itemViewType = adapter.getItemViewType(i7);
            if (itemViewType != i8) {
                view = null;
                i8 = itemViewType;
            }
            view = adapter.getView(i7, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            view.measure(i, layoutParams.height > 0 ? View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i7 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i4) {
                return (i5 < 0 || i7 <= i5 || i9 <= 0 || measuredHeight == i4) ? i4 : i9;
            }
            if (i5 >= 0 && i7 >= i5) {
                i9 = measuredHeight;
            }
            i7++;
        }
        return measuredHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x000c  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo1868a(MotionEvent motionEvent, int i) {
        boolean z;
        int iFindPointerIndex;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        switch (actionMasked) {
            case 1:
                z = false;
                iFindPointerIndex = motionEvent.findPointerIndex(i);
                if (iFindPointerIndex < 0) {
                    int x = (int) motionEvent.getX(iFindPointerIndex);
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int iPointToPosition = pointToPosition(x, y);
                    if (iPointToPosition != -1) {
                        View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                        m1863a(childAt, iPointToPosition, x, y);
                        if (actionMasked == 1) {
                            m1862a(childAt, iPointToPosition);
                        }
                        z2 = false;
                        z = true;
                    } else {
                        z2 = true;
                    }
                } else {
                    z2 = false;
                    z = false;
                }
                break;
            case 2:
                z = true;
                iFindPointerIndex = motionEvent.findPointerIndex(i);
                if (iFindPointerIndex < 0) {
                }
                break;
            case 3:
                break;
            default:
                z2 = false;
                z = true;
                break;
        }
        if (!z || z2) {
            m1864b();
        }
        if (z) {
            if (this.f1651m == null) {
                this.f1651m = new C0142h(this);
            }
            this.f1651m.m1082a(true);
            this.f1651m.onTouch(this, motionEvent);
        } else if (this.f1651m != null) {
            this.f1651m.m1082a(false);
        }
        return z;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        m1861a(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f1652n != null) {
            return;
        }
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m1858a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1648j || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1648j || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1648j || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1648j && this.f1647i) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f1652n = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1652n == null) {
            this.f1652n = new b();
            this.f1652n.m1871b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                }
                m1858a();
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1644f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (this.f1652n != null) {
            this.f1652n.m1870a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z) {
        this.f1647i = z;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        this.f1646h = drawable != null ? new a(drawable) : null;
        super.setSelector(this.f1646h);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1640b = rect.left;
        this.f1641c = rect.top;
        this.f1642d = rect.right;
        this.f1643e = rect.bottom;
    }
}
