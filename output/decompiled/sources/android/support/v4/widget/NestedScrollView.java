package android.support.v4.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.p015g.C0106b;
import android.support.v4.p015g.C0118j;
import android.support.v4.p015g.C0121m;
import android.support.v4.p015g.C0124p;
import android.support.v4.p015g.InterfaceC0117i;
import android.support.v4.p015g.InterfaceC0119k;
import android.support.v4.p015g.p016a.C0103a;
import android.support.v4.p015g.p016a.C0105c;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC0117i, InterfaceC0119k {

    /* JADX INFO: renamed from: w */
    private static final C0132a f692w = new C0132a();

    /* JADX INFO: renamed from: x */
    private static final int[] f693x = {R.attr.fillViewport};

    /* JADX INFO: renamed from: A */
    private float f694A;

    /* JADX INFO: renamed from: B */
    private InterfaceC0133b f695B;

    /* JADX INFO: renamed from: a */
    private long f696a;

    /* JADX INFO: renamed from: b */
    private final Rect f697b;

    /* JADX INFO: renamed from: c */
    private OverScroller f698c;

    /* JADX INFO: renamed from: d */
    private EdgeEffect f699d;

    /* JADX INFO: renamed from: e */
    private EdgeEffect f700e;

    /* JADX INFO: renamed from: f */
    private int f701f;

    /* JADX INFO: renamed from: g */
    private boolean f702g;

    /* JADX INFO: renamed from: h */
    private boolean f703h;

    /* JADX INFO: renamed from: i */
    private View f704i;

    /* JADX INFO: renamed from: j */
    private boolean f705j;

    /* JADX INFO: renamed from: k */
    private VelocityTracker f706k;

    /* JADX INFO: renamed from: l */
    private boolean f707l;

    /* JADX INFO: renamed from: m */
    private boolean f708m;

    /* JADX INFO: renamed from: n */
    private int f709n;

    /* JADX INFO: renamed from: o */
    private int f710o;

    /* JADX INFO: renamed from: p */
    private int f711p;

    /* JADX INFO: renamed from: q */
    private int f712q;

    /* JADX INFO: renamed from: r */
    private final int[] f713r;

    /* JADX INFO: renamed from: s */
    private final int[] f714s;

    /* JADX INFO: renamed from: t */
    private int f715t;

    /* JADX INFO: renamed from: u */
    private int f716u;

    /* JADX INFO: renamed from: v */
    private C0134c f717v;

    /* JADX INFO: renamed from: y */
    private final C0121m f718y;

    /* JADX INFO: renamed from: z */
    private final C0118j f719z;

    /* JADX INFO: renamed from: android.support.v4.widget.NestedScrollView$a */
    static class C0132a extends C0106b {
        C0132a() {
        }

        @Override // android.support.v4.p015g.C0106b
        /* JADX INFO: renamed from: a */
        public void mo879a(View view, C0103a c0103a) {
            int scrollRange;
            super.mo879a(view, c0103a);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c0103a.m850a(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            c0103a.m851a(true);
            if (nestedScrollView.getScrollY() > 0) {
                c0103a.m848a(8192);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                c0103a.m848a(4096);
            }
        }

        @Override // android.support.v4.p015g.C0106b
        /* JADX INFO: renamed from: a */
        public boolean mo881a(View view, int i, Bundle bundle) {
            if (super.mo881a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            if (i == 4096) {
                int iMin = Math.min(nestedScrollView.getScrollY() + ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
                if (iMin == nestedScrollView.getScrollY()) {
                    return false;
                }
                nestedScrollView.m1065c(0, iMin);
                return true;
            }
            if (i != 8192) {
                return false;
            }
            int iMax = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
            if (iMax == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.m1065c(0, iMax);
            return true;
        }

        @Override // android.support.v4.p015g.C0106b
        /* JADX INFO: renamed from: d */
        public void mo885d(View view, AccessibilityEvent accessibilityEvent) {
            super.mo885d(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            C0105c.m874a(accessibilityEvent, nestedScrollView.getScrollX());
            C0105c.m875b(accessibilityEvent, nestedScrollView.getScrollRange());
        }
    }

    /* JADX INFO: renamed from: android.support.v4.widget.NestedScrollView$b */
    public interface InterfaceC0133b {
        /* JADX INFO: renamed from: a */
        void mo1070a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    /* JADX INFO: renamed from: android.support.v4.widget.NestedScrollView$c */
    static class C0134c extends View.BaseSavedState {
        public static final Parcelable.Creator<C0134c> CREATOR = new Parcelable.Creator<C0134c>() { // from class: android.support.v4.widget.NestedScrollView.c.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0134c createFromParcel(Parcel parcel) {
                return new C0134c(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0134c[] newArray(int i) {
                return new C0134c[i];
            }
        };

        /* JADX INFO: renamed from: a */
        public int f720a;

        C0134c(Parcel parcel) {
            super(parcel);
            this.f720a = parcel.readInt();
        }

        C0134c(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f720a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f720a);
        }
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f697b = new Rect();
        this.f702g = true;
        this.f703h = false;
        this.f704i = null;
        this.f705j = false;
        this.f708m = true;
        this.f712q = -1;
        this.f713r = new int[2];
        this.f714s = new int[2];
        m1038a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f693x, i, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f718y = new C0121m(this);
        this.f719z = new C0118j(this);
        setNestedScrollingEnabled(true);
        C0124p.m955a(this, f692w);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private View m1037a(boolean z, int i, int i2) {
        ArrayList focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z2 = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) focusables.get(i3);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i < bottom && top < i2) {
                boolean z3 = i < top && bottom < i2;
                if (view == null) {
                    view = view2;
                    z2 = z3;
                } else {
                    boolean z4 = (z && top < view.getTop()) || (!z && bottom > view.getBottom());
                    if (z2) {
                        if (z3 && z4) {
                            view = view2;
                        }
                    } else if (z3) {
                        view = view2;
                        z2 = true;
                    } else if (z4) {
                    }
                }
            }
        }
        return view;
    }

    /* JADX INFO: renamed from: a */
    private void m1038a() {
        this.f698c = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f709n = viewConfiguration.getScaledTouchSlop();
        this.f710o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f711p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    /* JADX INFO: renamed from: a */
    private void m1039a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f712q) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f701f = (int) motionEvent.getY(i);
            this.f712q = motionEvent.getPointerId(i);
            if (this.f706k != null) {
                this.f706k.clear();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m1040a(int i, int i2, int i3) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = height + scrollY;
        boolean z = false;
        boolean z2 = i == 33;
        View viewM1037a = m1037a(z2, i2, i3);
        if (viewM1037a == null) {
            viewM1037a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m1054g(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (viewM1037a != findFocus()) {
            viewM1037a.requestFocus(i);
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    private boolean m1041a(Rect rect, boolean z) {
        int iM1056a = m1056a(rect);
        boolean z2 = iM1056a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, iM1056a);
            } else {
                m1063b(0, iM1056a);
            }
        }
        return z2;
    }

    /* JADX INFO: renamed from: a */
    private boolean m1042a(View view) {
        return !m1043a(view, 0, getHeight());
    }

    /* JADX INFO: renamed from: a */
    private boolean m1043a(View view, int i, int i2) {
        view.getDrawingRect(this.f697b);
        offsetDescendantRectToMyCoords(view, this.f697b);
        return this.f697b.bottom + i >= getScrollY() && this.f697b.top - i <= getScrollY() + i2;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1044a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && m1044a((View) parent, view2);
    }

    /* JADX INFO: renamed from: b */
    private static int m1045b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    /* JADX INFO: renamed from: b */
    private void m1046b(View view) {
        view.getDrawingRect(this.f697b);
        offsetDescendantRectToMyCoords(view, this.f697b);
        int iM1056a = m1056a(this.f697b);
        if (iM1056a != 0) {
            scrollBy(0, iM1056a);
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m1047b() {
        View childAt = getChildAt(0);
        if (childAt != null) {
            return getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom();
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    private void m1048c() {
        if (this.f706k == null) {
            this.f706k = VelocityTracker.obtain();
        } else {
            this.f706k.clear();
        }
    }

    /* JADX INFO: renamed from: d */
    private void m1049d() {
        if (this.f706k == null) {
            this.f706k = VelocityTracker.obtain();
        }
    }

    /* JADX INFO: renamed from: d */
    private boolean m1050d(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i2 >= childAt.getTop() - scrollY && i2 < childAt.getBottom() - scrollY && i >= childAt.getLeft() && i < childAt.getRight();
    }

    /* JADX INFO: renamed from: e */
    private void m1051e() {
        if (this.f706k != null) {
            this.f706k.recycle();
            this.f706k = null;
        }
    }

    /* JADX INFO: renamed from: f */
    private void m1052f() {
        this.f705j = false;
        m1051e();
        m1057a(0);
        if (this.f699d != null) {
            this.f699d.onRelease();
            this.f700e.onRelease();
        }
    }

    /* JADX INFO: renamed from: g */
    private void m1053g() {
        if (getOverScrollMode() == 2) {
            this.f699d = null;
            this.f700e = null;
        } else if (this.f699d == null) {
            Context context = getContext();
            this.f699d = new EdgeEffect(context);
            this.f700e = new EdgeEffect(context);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m1054g(int i) {
        if (i != 0) {
            if (this.f708m) {
                m1063b(0, i);
            } else {
                scrollBy(0, i);
            }
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f694A == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f694A = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f694A;
    }

    /* JADX INFO: renamed from: h */
    private void m1055h(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        float f = i;
        if (dispatchNestedPreFling(0.0f, f)) {
            return;
        }
        dispatchNestedFling(0.0f, f, z);
        m1069f(i);
    }

    /* JADX INFO: renamed from: a */
    protected int m1056a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            return Math.min((rect.height() > height ? rect.top - scrollY : rect.bottom - i) + 0, getChildAt(0).getBottom() - i);
        }
        if (rect.top >= scrollY || rect.bottom >= i) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    /* JADX INFO: renamed from: a */
    public void m1057a(int i) {
        this.f719z.m936c(i);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1058a(int i, int i2) {
        return this.f719z.m928a(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0083 A[ADDED_TO_REGION] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean m1059a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int overScrollMode = getOverScrollMode();
        boolean z4 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z5 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z6 = overScrollMode == 0 || (overScrollMode == 1 && z4);
        boolean z7 = overScrollMode == 0 || (overScrollMode == 1 && z5);
        int i9 = i3 + i;
        int i10 = !z6 ? 0 : i7;
        int i11 = i4 + i2;
        int i12 = !z7 ? 0 : i8;
        int i13 = -i10;
        int i14 = i10 + i5;
        int i15 = -i12;
        int i16 = i12 + i6;
        if (i9 <= i14) {
            if (i9 >= i13) {
                i13 = i9;
                z2 = false;
            }
            if (i11 > i16) {
                if (i11 >= i15) {
                    i15 = i11;
                    z3 = false;
                }
                if (z3 && !m1064b(1)) {
                    this.f698c.springBack(i13, i15, 0, 0, 0, getScrollRange());
                }
                onOverScrolled(i13, i15, z2, z3);
                return !z2 || z3;
            }
            i15 = i16;
            z3 = true;
            if (z3) {
                this.f698c.springBack(i13, i15, 0, 0, 0, getScrollRange());
            }
            onOverScrolled(i13, i15, z2, z3);
            if (z2) {
            }
        }
        i13 = i14;
        z2 = true;
        if (i11 > i16) {
        }
        z3 = true;
        if (z3) {
        }
        onOverScrolled(i13, i15, z2, z3);
        if (z2) {
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m1060a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        return this.f719z.m930a(i, i2, i3, i4, iArr, i5);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1061a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        return this.f719z.m932a(i, i2, iArr, iArr2, i3);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1062a(KeyEvent keyEvent) {
        this.f697b.setEmpty();
        if (!m1047b()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View viewFindFocus = findFocus();
            if (viewFindFocus == this) {
                viewFindFocus = null;
            }
            View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
            return (viewFindNextFocus == null || viewFindNextFocus == this || !viewFindNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 62) {
            m1066c(keyEvent.isShiftPressed() ? 33 : 130);
            return false;
        }
        switch (keyCode) {
            case 19:
                if (!keyEvent.isAltPressed()) {
                }
                break;
            case C0148a.j.AppCompatTheme_actionModeCopyDrawable /* 20 */:
                if (!keyEvent.isAltPressed()) {
                }
                break;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    /* JADX INFO: renamed from: b */
    public final void m1063b(int i, int i2) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f696a > 250) {
            int iMax = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
            int scrollY = getScrollY();
            this.f698c.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i2 + scrollY, iMax)) - scrollY);
            C0124p.m949a(this);
        } else {
            if (!this.f698c.isFinished()) {
                this.f698c.abortAnimation();
            }
            scrollBy(i, i2);
        }
        this.f696a = AnimationUtils.currentAnimationTimeMillis();
    }

    /* JADX INFO: renamed from: b */
    public boolean m1064b(int i) {
        return this.f719z.m927a(i);
    }

    /* JADX INFO: renamed from: c */
    public final void m1065c(int i, int i2) {
        m1063b(i - getScrollX(), i2 - getScrollY());
    }

    /* JADX INFO: renamed from: c */
    public boolean m1066c(int i) {
        Rect rect;
        int bottom = 0;
        boolean z = i == 130;
        int height = getHeight();
        if (z) {
            this.f697b.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                if (this.f697b.top + height > childAt.getBottom()) {
                    rect = this.f697b;
                    bottom = childAt.getBottom() - height;
                    rect.top = bottom;
                }
            }
        } else {
            this.f697b.top = getScrollY() - height;
            if (this.f697b.top < 0) {
                rect = this.f697b;
                rect.top = bottom;
            }
        }
        this.f697b.bottom = this.f697b.top + height;
        return m1040a(i, this.f697b.top, this.f697b.bottom);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        EdgeEffect edgeEffect;
        if (!this.f698c.computeScrollOffset()) {
            if (m1064b(1)) {
                m1057a(1);
            }
            this.f716u = 0;
            return;
        }
        this.f698c.getCurrX();
        int currY = this.f698c.getCurrY();
        int i = currY - this.f716u;
        if (m1061a(0, i, this.f714s, null, 1)) {
            i -= this.f714s[1];
        }
        int i2 = i;
        if (i2 != 0) {
            int scrollRange = getScrollRange();
            int scrollY = getScrollY();
            m1059a(0, i2, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            if (!m1060a(0, scrollY2, 0, i2 - scrollY2, null, 1)) {
                int overScrollMode = getOverScrollMode();
                if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                    m1053g();
                    if (currY <= 0 && scrollY > 0) {
                        edgeEffect = this.f699d;
                    } else if (currY >= scrollRange && scrollY < scrollRange) {
                        edgeEffect = this.f700e;
                    }
                    edgeEffect.onAbsorb((int) this.f698c.getCurrVelocity());
                }
            }
        }
        this.f716u = currY;
        C0124p.m949a(this);
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    /* JADX INFO: renamed from: d */
    public boolean m1067d(int i) {
        int childCount;
        boolean z = i == 130;
        int height = getHeight();
        this.f697b.top = 0;
        this.f697b.bottom = height;
        if (z && (childCount = getChildCount()) > 0) {
            this.f697b.bottom = getChildAt(childCount - 1).getBottom() + getPaddingBottom();
            this.f697b.top = this.f697b.bottom - height;
        }
        return m1040a(i, this.f697b.top, this.f697b.bottom);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m1062a(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f719z.m926a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f719z.m925a(f, f2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f719z.m931a(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f719z.m929a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        if (this.f699d != null) {
            int scrollY = getScrollY();
            int paddingLeft2 = 0;
            if (!this.f699d.isFinished()) {
                int iSave = canvas.save();
                int width = getWidth();
                int height = getHeight();
                int iMin = Math.min(0, scrollY);
                if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                    width -= getPaddingLeft() + getPaddingRight();
                    paddingLeft = getPaddingLeft() + 0;
                } else {
                    paddingLeft = 0;
                }
                if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                    height -= getPaddingTop() + getPaddingBottom();
                    iMin += getPaddingTop();
                }
                canvas.translate(paddingLeft, iMin);
                this.f699d.setSize(width, height);
                if (this.f699d.draw(canvas)) {
                    C0124p.m949a(this);
                }
                canvas.restoreToCount(iSave);
            }
            if (this.f700e.isFinished()) {
                return;
            }
            int iSave2 = canvas.save();
            int width2 = getWidth();
            int height2 = getHeight();
            int iMax = Math.max(getScrollRange(), scrollY) + height2;
            if (Build.VERSION.SDK_INT < 21 || getClipToPadding()) {
                width2 -= getPaddingLeft() + getPaddingRight();
                paddingLeft2 = 0 + getPaddingLeft();
            }
            if (Build.VERSION.SDK_INT >= 21 && getClipToPadding()) {
                height2 -= getPaddingTop() + getPaddingBottom();
                iMax -= getPaddingBottom();
            }
            canvas.translate(paddingLeft2 - width2, iMax);
            canvas.rotate(180.0f, width2, 0.0f);
            this.f700e.setSize(width2, height2);
            if (this.f700e.draw(canvas)) {
                C0124p.m949a(this);
            }
            canvas.restoreToCount(iSave2);
        }
    }

    /* JADX INFO: renamed from: e */
    public boolean m1068e(int i) {
        int bottom;
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !m1043a(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0 && (bottom = getChildAt(0).getBottom() - ((getScrollY() + getHeight()) - getPaddingBottom())) < maxScrollAmount) {
                maxScrollAmount = bottom;
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m1054g(maxScrollAmount);
        } else {
            viewFindNextFocus.getDrawingRect(this.f697b);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f697b);
            m1054g(m1056a(this.f697b));
            viewFindNextFocus.requestFocus(i);
        }
        if (viewFindFocus == null || !viewFindFocus.isFocused() || !m1042a(viewFindFocus)) {
            return true;
        }
        int descendantFocusability = getDescendantFocusability();
        setDescendantFocusability(131072);
        requestFocus();
        setDescendantFocusability(descendantFocusability);
        return true;
    }

    /* JADX INFO: renamed from: f */
    public void m1069f(int i) {
        if (getChildCount() > 0) {
            m1058a(2, 1);
            this.f698c.fling(getScrollX(), getScrollY(), 0, i, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            this.f716u = getScrollY();
            C0124p.m949a(this);
        }
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f718y.m942a();
    }

    int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f719z.m933b();
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f719z.m924a();
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f703h = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && !this.f705j) {
            float axisValue = motionEvent.getAxisValue(9);
            if (axisValue != 0.0f) {
                int verticalScrollFactorCompat = (int) (axisValue * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                int i = scrollY - verticalScrollFactorCompat;
                if (i < 0) {
                    i = 0;
                } else if (i > scrollRange) {
                    i = scrollRange;
                }
                if (i != scrollY) {
                    super.scrollTo(getScrollX(), i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 2 && this.f705j) {
            return true;
        }
        int i = action & 255;
        if (i != 6) {
            switch (i) {
                case 0:
                    int y = (int) motionEvent.getY();
                    if (!m1050d((int) motionEvent.getX(), y)) {
                        this.f705j = false;
                        m1051e();
                    } else {
                        this.f701f = y;
                        this.f712q = motionEvent.getPointerId(0);
                        m1048c();
                        this.f706k.addMovement(motionEvent);
                        this.f698c.computeScrollOffset();
                        this.f705j = !this.f698c.isFinished();
                        m1058a(2, 0);
                    }
                    break;
                case 1:
                case 3:
                    this.f705j = false;
                    this.f712q = -1;
                    m1051e();
                    if (this.f698c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        C0124p.m949a(this);
                    }
                    m1057a(0);
                    break;
                case 2:
                    int i2 = this.f712q;
                    if (i2 != -1) {
                        int iFindPointerIndex = motionEvent.findPointerIndex(i2);
                        if (iFindPointerIndex != -1) {
                            int y2 = (int) motionEvent.getY(iFindPointerIndex);
                            if (Math.abs(y2 - this.f701f) > this.f709n && (2 & getNestedScrollAxes()) == 0) {
                                this.f705j = true;
                                this.f701f = y2;
                                m1049d();
                                this.f706k.addMovement(motionEvent);
                                this.f715t = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        } else {
                            Log.e("NestedScrollView", "Invalid pointerId=" + i2 + " in onInterceptTouchEvent");
                        }
                    }
                    break;
            }
        } else {
            m1039a(motionEvent);
        }
        return this.f705j;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f702g = false;
        if (this.f704i != null && m1044a(this.f704i, this)) {
            m1046b(this.f704i);
        }
        this.f704i = null;
        if (!this.f703h) {
            if (this.f717v != null) {
                scrollTo(getScrollX(), this.f717v.f720a);
                this.f717v = null;
            }
            int iMax = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > iMax) {
                scrollTo(getScrollX(), iMax);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f703h = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f707l && View.MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), View.MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m1055h((int) f2);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f718y.m945a(view, view2, i);
        startNestedScroll(2);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (viewFindNextFocus == null || m1042a(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0134c)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0134c c0134c = (C0134c) parcelable;
        super.onRestoreInstanceState(c0134c.getSuperState());
        this.f717v = c0134c;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        C0134c c0134c = new C0134c(super.onSaveInstanceState());
        c0134c.f720a = getScrollY();
        return c0134c;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f695B != null) {
            this.f695B.mo1070a(this, i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !m1043a(viewFindFocus, 0, i4)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f697b);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f697b);
        m1054g(m1056a(this.f697b));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.p015g.InterfaceC0119k
    public void onStopNestedScroll(View view) {
        this.f718y.m943a(view);
        stopNestedScroll();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0250  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        EdgeEffect edgeEffect;
        m1049d();
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f715t = 0;
        }
        motionEventObtain.offsetLocation(0.0f, this.f715t);
        switch (actionMasked) {
            case 0:
                if (getChildCount() == 0) {
                    return false;
                }
                boolean z = !this.f698c.isFinished();
                this.f705j = z;
                if (z && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                if (!this.f698c.isFinished()) {
                    this.f698c.abortAnimation();
                }
                this.f701f = (int) motionEvent.getY();
                this.f712q = motionEvent.getPointerId(0);
                m1058a(2, 0);
                if (this.f706k != null) {
                    this.f706k.addMovement(motionEventObtain);
                }
                motionEventObtain.recycle();
                return true;
            case 1:
                VelocityTracker velocityTracker = this.f706k;
                velocityTracker.computeCurrentVelocity(1000, this.f711p);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f712q);
                if (Math.abs(yVelocity) > this.f710o) {
                    m1055h(-yVelocity);
                } else if (this.f698c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    C0124p.m949a(this);
                }
                this.f712q = -1;
                m1052f();
                if (this.f706k != null) {
                }
                motionEventObtain.recycle();
                return true;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f712q);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f712q + " in onTouchEvent");
                } else {
                    int y = (int) motionEvent.getY(iFindPointerIndex);
                    int i = this.f701f - y;
                    if (m1061a(0, i, this.f714s, this.f713r, 0)) {
                        i -= this.f714s[1];
                        motionEventObtain.offsetLocation(0.0f, this.f713r[1]);
                        this.f715t += this.f713r[1];
                    }
                    if (!this.f705j && Math.abs(i) > this.f709n) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f705j = true;
                        i = i > 0 ? i - this.f709n : i + this.f709n;
                    }
                    int i2 = i;
                    if (this.f705j) {
                        this.f701f = y - this.f713r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        int overScrollMode = getOverScrollMode();
                        boolean z2 = overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0);
                        if (m1059a(0, i2, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !m1064b(0)) {
                            this.f706k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (m1060a(0, scrollY2, 0, i2 - scrollY2, this.f713r, 0)) {
                            this.f701f -= this.f713r[1];
                            motionEventObtain.offsetLocation(0.0f, this.f713r[1]);
                            this.f715t += this.f713r[1];
                        } else if (z2) {
                            m1053g();
                            int i3 = scrollY + i2;
                            if (i3 < 0) {
                                C0140f.m1124a(this.f699d, i2 / getHeight(), motionEvent.getX(iFindPointerIndex) / getWidth());
                                if (!this.f700e.isFinished()) {
                                    edgeEffect = this.f700e;
                                    edgeEffect.onRelease();
                                }
                                if (this.f699d != null && (!this.f699d.isFinished() || !this.f700e.isFinished())) {
                                    C0124p.m949a(this);
                                }
                            } else {
                                if (i3 > scrollRange) {
                                    C0140f.m1124a(this.f700e, i2 / getHeight(), 1.0f - (motionEvent.getX(iFindPointerIndex) / getWidth()));
                                    if (!this.f699d.isFinished()) {
                                        edgeEffect = this.f699d;
                                        edgeEffect.onRelease();
                                    }
                                }
                                if (this.f699d != null) {
                                    C0124p.m949a(this);
                                }
                            }
                        }
                    }
                }
                if (this.f706k != null) {
                }
                motionEventObtain.recycle();
                return true;
            case 3:
                if (this.f705j && getChildCount() > 0 && this.f698c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                }
                this.f712q = -1;
                m1052f();
                if (this.f706k != null) {
                }
                motionEventObtain.recycle();
                return true;
            case 4:
            default:
                if (this.f706k != null) {
                }
                motionEventObtain.recycle();
                return true;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                this.f701f = (int) motionEvent.getY(actionIndex);
                this.f712q = motionEvent.getPointerId(actionIndex);
                if (this.f706k != null) {
                }
                motionEventObtain.recycle();
                return true;
            case 6:
                m1039a(motionEvent);
                this.f701f = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f712q));
                if (this.f706k != null) {
                }
                motionEventObtain.recycle();
                return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f702g) {
            this.f704i = view2;
        } else {
            m1046b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m1041a(rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m1051e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f702g = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int iM1045b = m1045b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int iM1045b2 = m1045b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (iM1045b == getScrollX() && iM1045b2 == getScrollY()) {
                return;
            }
            super.scrollTo(iM1045b, iM1045b2);
        }
    }

    public void setFillViewport(boolean z) {
        if (z != this.f707l) {
            this.f707l = z;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f719z.m923a(z);
    }

    public void setOnScrollChangeListener(InterfaceC0133b interfaceC0133b) {
        this.f695B = interfaceC0133b;
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f708m = z;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.f719z.m934b(i);
    }

    @Override // android.view.View, android.support.v4.p015g.InterfaceC0116h
    public void stopNestedScroll() {
        this.f719z.m935c();
    }
}
