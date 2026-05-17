package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0196h;
import android.support.v7.view.menu.C0198j;
import android.support.v7.view.menu.InterfaceC0203o;
import android.support.v7.view.menu.InterfaceC0204p;
import android.support.v7.widget.C0250aj;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends C0250aj implements C0196h.b, InterfaceC0204p {

    /* JADX INFO: renamed from: a */
    C0196h.a f1442a;

    /* JADX INFO: renamed from: b */
    InterfaceC0221e f1443b;

    /* JADX INFO: renamed from: c */
    private C0196h f1444c;

    /* JADX INFO: renamed from: d */
    private Context f1445d;

    /* JADX INFO: renamed from: e */
    private int f1446e;

    /* JADX INFO: renamed from: f */
    private boolean f1447f;

    /* JADX INFO: renamed from: g */
    private C0273d f1448g;

    /* JADX INFO: renamed from: h */
    private InterfaceC0203o.a f1449h;

    /* JADX INFO: renamed from: i */
    private boolean f1450i;

    /* JADX INFO: renamed from: j */
    private int f1451j;

    /* JADX INFO: renamed from: k */
    private int f1452k;

    /* JADX INFO: renamed from: l */
    private int f1453l;

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuView$a */
    public interface InterfaceC0217a {
        /* JADX INFO: renamed from: c */
        boolean mo1450c();

        /* JADX INFO: renamed from: d */
        boolean mo1451d();
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuView$b */
    private static class C0218b implements InterfaceC0203o.a {
        C0218b() {
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o.a
        /* JADX INFO: renamed from: a */
        public void mo1324a(C0196h c0196h, boolean z) {
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o.a
        /* JADX INFO: renamed from: a */
        public boolean mo1325a(C0196h c0196h) {
            return false;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuView$c */
    public static class C0219c extends C0250aj.a {

        /* JADX INFO: renamed from: a */
        @ViewDebug.ExportedProperty
        public boolean f1454a;

        /* JADX INFO: renamed from: b */
        @ViewDebug.ExportedProperty
        public int f1455b;

        /* JADX INFO: renamed from: c */
        @ViewDebug.ExportedProperty
        public int f1456c;

        /* JADX INFO: renamed from: d */
        @ViewDebug.ExportedProperty
        public boolean f1457d;

        /* JADX INFO: renamed from: e */
        @ViewDebug.ExportedProperty
        public boolean f1458e;

        /* JADX INFO: renamed from: f */
        boolean f1459f;

        public C0219c(int i, int i2) {
            super(i, i2);
            this.f1454a = false;
        }

        public C0219c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0219c(C0219c c0219c) {
            super(c0219c);
            this.f1454a = c0219c.f1454a;
        }

        public C0219c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuView$d */
    private class C0220d implements C0196h.a {
        C0220d() {
        }

        @Override // android.support.v7.view.menu.C0196h.a
        /* JADX INFO: renamed from: a */
        public void mo1306a(C0196h c0196h) {
            if (ActionMenuView.this.f1442a != null) {
                ActionMenuView.this.f1442a.mo1306a(c0196h);
            }
        }

        @Override // android.support.v7.view.menu.C0196h.a
        /* JADX INFO: renamed from: a */
        public boolean mo1308a(C0196h c0196h, MenuItem menuItem) {
            return ActionMenuView.this.f1443b != null && ActionMenuView.this.f1443b.mo1683a(menuItem);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuView$e */
    public interface InterfaceC0221e {
        /* JADX INFO: renamed from: a */
        boolean mo1683a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1452k = (int) (56.0f * f);
        this.f1453l = (int) (f * 4.0f);
        this.f1445d = context;
        this.f1446e = 0;
    }

    /* JADX INFO: renamed from: a */
    static int m1665a(View view, int i, int i2, int i3, int i4) {
        C0219c c0219c = (C0219c) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = actionMenuItemView != null && actionMenuItemView.m1449b();
        int i5 = 2;
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z || i6 >= 2) {
                i5 = i6;
            }
        }
        c0219c.f1457d = !c0219c.f1454a && z;
        c0219c.f1455b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), iMakeMeasureSpec);
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x024f A[ADDED_TO_REGION, LOOP:5: B:139:0x024f->B:144:0x0272, LOOP_START, PHI: r3 r32
  0x024f: PHI (r3v8 int) = (r3v7 int), (r3v9 int) binds: [B:138:0x024d, B:144:0x0272] A[DONT_GENERATE, DONT_INLINE]
  0x024f: PHI (r32v1 int) = (r32v0 int), (r32v2 int) binds: [B:138:0x024d, B:144:0x0272] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x027e  */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m1666c(int i, int i2) {
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        ?? r6;
        int i9;
        int i10;
        ?? r2;
        int i11;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i12 = size - paddingLeft;
        int i13 = i12 / this.f1452k;
        int i14 = i12 % this.f1452k;
        if (i13 == 0) {
            setMeasuredDimension(i12, 0);
            return;
        }
        int i15 = this.f1452k + (i14 / i13);
        int childCount = getChildCount();
        int i16 = i13;
        int i17 = 0;
        int iMax = 0;
        boolean z2 = false;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        long j = 0;
        while (i17 < childCount) {
            View childAt = getChildAt(i17);
            int i21 = size2;
            if (childAt.getVisibility() == 8) {
                i9 = i12;
            } else {
                boolean z3 = childAt instanceof ActionMenuItemView;
                int i22 = i18 + 1;
                if (z3) {
                    i10 = i22;
                    i9 = i12;
                    r2 = 0;
                    childAt.setPadding(this.f1453l, 0, this.f1453l, 0);
                } else {
                    i9 = i12;
                    i10 = i22;
                    r2 = 0;
                }
                C0219c c0219c = (C0219c) childAt.getLayoutParams();
                c0219c.f1459f = r2;
                c0219c.f1456c = r2;
                c0219c.f1455b = r2;
                c0219c.f1457d = r2;
                c0219c.leftMargin = r2;
                c0219c.rightMargin = r2;
                c0219c.f1458e = z3 && ((ActionMenuItemView) childAt).m1449b();
                int iM1665a = m1665a(childAt, i15, c0219c.f1454a ? 1 : i16, childMeasureSpec, paddingTop);
                int iMax2 = Math.max(i19, iM1665a);
                if (c0219c.f1457d) {
                    i20++;
                }
                if (c0219c.f1454a) {
                    z2 = true;
                }
                i16 -= iM1665a;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (iM1665a == 1) {
                    i11 = iMax2;
                    j |= (long) (1 << i17);
                } else {
                    i11 = iMax2;
                }
                i18 = i10;
                i19 = i11;
            }
            i17++;
            size2 = i21;
            i12 = i9;
        }
        int i23 = i12;
        int i24 = size2;
        boolean z4 = z2 && i18 == 2;
        boolean z5 = false;
        while (i20 > 0 && i16 > 0) {
            int i25 = 0;
            int i26 = 0;
            int i27 = Integer.MAX_VALUE;
            long j2 = 0;
            while (i25 < childCount) {
                C0219c c0219c2 = (C0219c) getChildAt(i25).getLayoutParams();
                boolean z6 = z5;
                if (c0219c2.f1457d) {
                    if (c0219c2.f1455b < i27) {
                        j2 = 1 << i25;
                        i27 = c0219c2.f1455b;
                        i26 = 1;
                    } else if (c0219c2.f1455b == i27) {
                        j2 |= 1 << i25;
                        i26++;
                    }
                }
                i25++;
                z5 = z6;
            }
            z = z5;
            j |= j2;
            if (i26 > i16) {
                break;
            }
            int i28 = i27 + 1;
            int i29 = 0;
            while (i29 < childCount) {
                View childAt2 = getChildAt(i29);
                C0219c c0219c3 = (C0219c) childAt2.getLayoutParams();
                int i30 = iMax;
                int i31 = childMeasureSpec;
                int i32 = childCount;
                long j3 = 1 << i29;
                if ((j2 & j3) != 0) {
                    if (z4 && c0219c3.f1458e) {
                        r6 = 1;
                        r6 = 1;
                        if (i16 == 1) {
                            childAt2.setPadding(this.f1453l + i15, 0, this.f1453l, 0);
                        }
                    } else {
                        r6 = 1;
                    }
                    c0219c3.f1455b += r6;
                    c0219c3.f1459f = r6;
                    i16--;
                } else if (c0219c3.f1455b == i28) {
                    j |= j3;
                }
                i29++;
                iMax = i30;
                childMeasureSpec = i31;
                childCount = i32;
            }
            z5 = true;
        }
        z = z5;
        int i33 = childMeasureSpec;
        int i34 = childCount;
        int i35 = iMax;
        if (!z2) {
            i3 = 1;
            boolean z7 = i18 == 1;
            if (i16 > 0 || j == 0 || (i16 >= i18 - i3 && !z7 && i19 <= i3)) {
                i4 = i34;
                i5 = 0;
            } else {
                float fBitCount = Long.bitCount(j);
                if (z7) {
                    i5 = 0;
                } else {
                    if ((j & 1) != 0) {
                        i5 = 0;
                        if (!((C0219c) getChildAt(0).getLayoutParams()).f1458e) {
                            fBitCount -= 0.5f;
                        }
                    } else {
                        i5 = 0;
                    }
                    int i36 = i34 - 1;
                    if ((j & ((long) (1 << i36))) != 0 && !((C0219c) getChildAt(i36).getLayoutParams()).f1458e) {
                        fBitCount -= 0.5f;
                    }
                }
                int i37 = fBitCount > 0.0f ? (int) ((i16 * i15) / fBitCount) : 0;
                boolean z8 = z;
                i4 = i34;
                for (int i38 = 0; i38 < i4; i38++) {
                    if ((j & ((long) (1 << i38))) != 0) {
                        View childAt3 = getChildAt(i38);
                        C0219c c0219c4 = (C0219c) childAt3.getLayoutParams();
                        if (childAt3 instanceof ActionMenuItemView) {
                            c0219c4.f1456c = i37;
                            c0219c4.f1459f = true;
                            if (i38 == 0 && !c0219c4.f1458e) {
                                c0219c4.leftMargin = (-i37) / 2;
                            }
                        } else if (c0219c4.f1454a) {
                            c0219c4.f1456c = i37;
                            c0219c4.f1459f = true;
                            c0219c4.rightMargin = (-i37) / 2;
                        } else {
                            if (i38 != 0) {
                                c0219c4.leftMargin = i37 / 2;
                            }
                            if (i38 != i4 - 1) {
                                c0219c4.rightMargin = i37 / 2;
                            }
                        }
                        z8 = true;
                    }
                }
                z = z8;
            }
            if (z) {
                while (i5 < i4) {
                    View childAt4 = getChildAt(i5);
                    C0219c c0219c5 = (C0219c) childAt4.getLayoutParams();
                    if (c0219c5.f1459f) {
                        i8 = i33;
                        childAt4.measure(View.MeasureSpec.makeMeasureSpec((c0219c5.f1455b * i15) + c0219c5.f1456c, 1073741824), i8);
                    } else {
                        i8 = i33;
                    }
                    i5++;
                    i33 = i8;
                }
            }
            if (mode == 1073741824) {
                i7 = i23;
                i6 = i35;
            } else {
                i6 = i24;
                i7 = i23;
            }
            setMeasuredDimension(i7, i6);
        }
        i3 = 1;
        if (i16 > 0) {
            i4 = i34;
            i5 = 0;
        }
        if (z) {
        }
        if (mode == 1073741824) {
        }
        setMeasuredDimension(i7, i6);
    }

    @Override // android.support.v7.widget.C0250aj, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0219c generateLayoutParams(AttributeSet attributeSet) {
        return new C0219c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.C0250aj, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0219c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        C0219c c0219c = layoutParams instanceof C0219c ? new C0219c((C0219c) layoutParams) : new C0219c(layoutParams);
        if (c0219c.f1682h <= 0) {
            c0219c.f1682h = 16;
        }
        return c0219c;
    }

    @Override // android.support.v7.view.menu.InterfaceC0204p
    /* JADX INFO: renamed from: a */
    public void mo1455a(C0196h c0196h) {
        this.f1444c = c0196h;
    }

    /* JADX INFO: renamed from: a */
    public void m1669a(InterfaceC0203o.a aVar, C0196h.a aVar2) {
        this.f1449h = aVar;
        this.f1442a = aVar2;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1670a() {
        return this.f1447f;
    }

    /* JADX INFO: renamed from: a */
    protected boolean m1671a(int i) {
        boolean zMo1451d = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof InterfaceC0217a)) {
            zMo1451d = false | ((InterfaceC0217a) childAt).mo1451d();
        }
        return (i <= 0 || !(childAt2 instanceof InterfaceC0217a)) ? zMo1451d : zMo1451d | ((InterfaceC0217a) childAt2).mo1450c();
    }

    @Override // android.support.v7.view.menu.C0196h.b
    /* JADX INFO: renamed from: a */
    public boolean mo1456a(C0198j c0198j) {
        return this.f1444c.m1546a(c0198j, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.C0250aj
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0219c generateDefaultLayoutParams() {
        C0219c c0219c = new C0219c(-2, -2);
        c0219c.f1682h = 16;
        return c0219c;
    }

    /* JADX INFO: renamed from: c */
    public C0219c m1675c() {
        C0219c c0219cGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        c0219cGenerateDefaultLayoutParams.f1454a = true;
        return c0219cGenerateDefaultLayoutParams;
    }

    @Override // android.support.v7.widget.C0250aj, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0219c);
    }

    /* JADX INFO: renamed from: d */
    public C0196h m1676d() {
        return this.f1444c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* JADX INFO: renamed from: e */
    public boolean m1677e() {
        return this.f1448g != null && this.f1448g.m2043d();
    }

    /* JADX INFO: renamed from: f */
    public boolean m1678f() {
        return this.f1448g != null && this.f1448g.m2044e();
    }

    /* JADX INFO: renamed from: g */
    public boolean m1679g() {
        return this.f1448g != null && this.f1448g.m2047h();
    }

    public Menu getMenu() {
        if (this.f1444c == null) {
            Context context = getContext();
            this.f1444c = new C0196h(context);
            this.f1444c.mo1538a(new C0220d());
            this.f1448g = new C0273d(context);
            this.f1448g.m2041c(true);
            this.f1448g.mo1472a(this.f1449h != null ? this.f1449h : new C0218b());
            this.f1444c.m1541a(this.f1448g, this.f1445d);
            this.f1448g.m2039a(this);
        }
        return this.f1444c;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1448g.m2040c();
    }

    public int getPopupTheme() {
        return this.f1446e;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* JADX INFO: renamed from: h */
    public boolean m1680h() {
        return this.f1448g != null && this.f1448g.m2048i();
    }

    /* JADX INFO: renamed from: i */
    public void m1681i() {
        if (this.f1448g != null) {
            this.f1448g.m2045f();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f1448g != null) {
            this.f1448g.mo1479b(false);
            if (this.f1448g.m2047h()) {
                this.f1448g.m2044e();
                this.f1448g.m2043d();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m1681i();
    }

    @Override // android.support.v7.widget.C0250aj, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int paddingLeft;
        if (!this.f1450i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i3 - i;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean zM2027a = C0270bc.m2027a(this);
        int measuredWidth = paddingRight;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                C0219c c0219c = (C0219c) childAt.getLayoutParams();
                if (c0219c.f1454a) {
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    if (m1671a(i11)) {
                        measuredWidth2 += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zM2027a) {
                        paddingLeft = getPaddingLeft() + c0219c.leftMargin;
                        width = paddingLeft + measuredWidth2;
                    } else {
                        width = (getWidth() - getPaddingRight()) - c0219c.rightMargin;
                        paddingLeft = width - measuredWidth2;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i12, width, measuredHeight + i12);
                    measuredWidth -= measuredWidth2;
                    i9 = 1;
                } else {
                    measuredWidth -= (childAt.getMeasuredWidth() + c0219c.leftMargin) + c0219c.rightMargin;
                    m1671a(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth3 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth3 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth3 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        if (i15 > 0) {
            i6 = measuredWidth / i15;
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int iMax = Math.max(i5, i6);
        if (zM2027a) {
            int width2 = getWidth() - getPaddingRight();
            while (i5 < childCount) {
                View childAt3 = getChildAt(i5);
                C0219c c0219c2 = (C0219c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !c0219c2.f1454a) {
                    int i16 = width2 - c0219c2.rightMargin;
                    int measuredWidth4 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth4, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth4 + c0219c2.leftMargin) + iMax);
                }
                i5++;
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        while (i5 < childCount) {
            View childAt4 = getChildAt(i5);
            C0219c c0219c3 = (C0219c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !c0219c3.f1454a) {
                int i18 = paddingLeft2 + c0219c3.leftMargin;
                int measuredWidth5 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth5, measuredHeight4 + i19);
                paddingLeft2 = i18 + measuredWidth5 + c0219c3.rightMargin + iMax;
            }
            i5++;
        }
    }

    @Override // android.support.v7.widget.C0250aj, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z = this.f1450i;
        this.f1450i = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f1450i) {
            this.f1451j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.f1450i && this.f1444c != null && size != this.f1451j) {
            this.f1451j = size;
            this.f1444c.m1552b(true);
        }
        int childCount = getChildCount();
        if (this.f1450i && childCount > 0) {
            m1666c(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            C0219c c0219c = (C0219c) getChildAt(i3).getLayoutParams();
            c0219c.rightMargin = 0;
            c0219c.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1448g.m2042d(z);
    }

    public void setOnMenuItemClickListener(InterfaceC0221e interfaceC0221e) {
        this.f1443b = interfaceC0221e;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1448g.m2038a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f1447f = z;
    }

    public void setPopupTheme(int i) {
        if (this.f1446e != i) {
            this.f1446e = i;
            if (i == 0) {
                this.f1445d = getContext();
            } else {
                this.f1445d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(C0273d c0273d) {
        this.f1448g = c0273d;
        this.f1448g.m2039a(this);
    }
}
