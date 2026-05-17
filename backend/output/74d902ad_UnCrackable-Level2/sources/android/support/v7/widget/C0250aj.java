package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.p015g.C0112d;
import android.support.v4.p015g.C0124p;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: renamed from: android.support.v7.widget.aj */
/* JADX INFO: loaded from: classes.dex */
public class C0250aj extends ViewGroup {

    /* JADX INFO: renamed from: a */
    private boolean f1666a;

    /* JADX INFO: renamed from: b */
    private int f1667b;

    /* JADX INFO: renamed from: c */
    private int f1668c;

    /* JADX INFO: renamed from: d */
    private int f1669d;

    /* JADX INFO: renamed from: e */
    private int f1670e;

    /* JADX INFO: renamed from: f */
    private int f1671f;

    /* JADX INFO: renamed from: g */
    private float f1672g;

    /* JADX INFO: renamed from: h */
    private boolean f1673h;

    /* JADX INFO: renamed from: i */
    private int[] f1674i;

    /* JADX INFO: renamed from: j */
    private int[] f1675j;

    /* JADX INFO: renamed from: k */
    private Drawable f1676k;

    /* JADX INFO: renamed from: l */
    private int f1677l;

    /* JADX INFO: renamed from: m */
    private int f1678m;

    /* JADX INFO: renamed from: n */
    private int f1679n;

    /* JADX INFO: renamed from: o */
    private int f1680o;

    /* JADX INFO: renamed from: android.support.v7.widget.aj$a */
    public static class a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: g */
        public float f1681g;

        /* JADX INFO: renamed from: h */
        public int f1682h;

        public a(int i, int i2) {
            super(i, i2);
            this.f1682h = -1;
            this.f1681g = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1682h = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0148a.j.LinearLayoutCompat_Layout);
            this.f1681g = typedArrayObtainStyledAttributes.getFloat(C0148a.j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f1682h = typedArrayObtainStyledAttributes.getInt(C0148a.j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            typedArrayObtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1682h = -1;
        }
    }

    public C0250aj(Context context) {
        this(context, null);
    }

    public C0250aj(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0250aj(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1666a = true;
        this.f1667b = -1;
        this.f1668c = 0;
        this.f1670e = 8388659;
        C0263aw c0263awM1978a = C0263aw.m1978a(context, attributeSet, C0148a.j.LinearLayoutCompat, i, 0);
        int iM1980a = c0263awM1978a.m1980a(C0148a.j.LinearLayoutCompat_android_orientation, -1);
        if (iM1980a >= 0) {
            setOrientation(iM1980a);
        }
        int iM1980a2 = c0263awM1978a.m1980a(C0148a.j.LinearLayoutCompat_android_gravity, -1);
        if (iM1980a2 >= 0) {
            setGravity(iM1980a2);
        }
        boolean zM1984a = c0263awM1978a.m1984a(C0148a.j.LinearLayoutCompat_android_baselineAligned, true);
        if (!zM1984a) {
            setBaselineAligned(zM1984a);
        }
        this.f1672g = c0263awM1978a.m1979a(C0148a.j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f1667b = c0263awM1978a.m1980a(C0148a.j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1673h = c0263awM1978a.m1984a(C0148a.j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(c0263awM1978a.m1982a(C0148a.j.LinearLayoutCompat_divider));
        this.f1679n = c0263awM1978a.m1980a(C0148a.j.LinearLayoutCompat_showDividers, 0);
        this.f1680o = c0263awM1978a.m1991e(C0148a.j.LinearLayoutCompat_dividerPadding, 0);
        c0263awM1978a.m1983a();
    }

    /* JADX INFO: renamed from: a */
    private void m1880a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    /* JADX INFO: renamed from: c */
    private void m1881c(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewM1891b = m1891b(i3);
            if (viewM1891b.getVisibility() != 8) {
                a aVar = (a) viewM1891b.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = viewM1891b.getMeasuredHeight();
                    measureChildWithMargins(viewM1891b, iMakeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m1882d(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View viewM1891b = m1891b(i3);
            if (viewM1891b.getVisibility() != 8) {
                a aVar = (a) viewM1891b.getLayoutParams();
                if (aVar.height == -1) {
                    int i4 = aVar.width;
                    aVar.width = viewM1891b.getMeasuredWidth();
                    measureChildWithMargins(viewM1891b, i2, 0, iMakeMeasureSpec, 0);
                    aVar.width = i4;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    int m1883a(View view) {
        return 0;
    }

    /* JADX INFO: renamed from: a */
    int m1884a(View view, int i) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:136:0x02ea A[PHI: r10
  0x02ea: PHI (r10v19 int) = (r10v16 int), (r10v20 int) binds: [B:135:0x02e8, B:131:0x02dd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0338  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void m1885a(int i, int i2) {
        int i3;
        int i4;
        int iCombineMeasuredStates;
        int i5;
        int iMax;
        float f;
        int i6;
        int i7;
        boolean z;
        int i8;
        int iMax2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int iMax3;
        int i14;
        int i15;
        View view;
        int iMax4;
        boolean z2;
        int iMax5;
        this.f1671f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i16 = this.f1667b;
        boolean z3 = this.f1673h;
        float f2 = 0.0f;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int iM1884a = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            int i22 = 8;
            int i23 = i20;
            if (iM1884a >= virtualChildCount) {
                int i24 = i17;
                int i25 = i19;
                int i26 = i21;
                int i27 = virtualChildCount;
                int i28 = mode2;
                int iMax6 = i18;
                if (this.f1671f > 0) {
                    i3 = i27;
                    if (m1896c(i3)) {
                        this.f1671f += this.f1678m;
                    }
                } else {
                    i3 = i27;
                }
                if (z3) {
                    i4 = i28;
                    if (i4 == Integer.MIN_VALUE || i4 == 0) {
                        this.f1671f = 0;
                        int iM1884a2 = 0;
                        while (iM1884a2 < i3) {
                            View viewM1891b = m1891b(iM1884a2);
                            if (viewM1891b == null) {
                                iMax2 = this.f1671f + m1897d(iM1884a2);
                            } else if (viewM1891b.getVisibility() == i22) {
                                iM1884a2 += m1884a(viewM1891b, iM1884a2);
                                iM1884a2++;
                                i22 = 8;
                            } else {
                                a aVar = (a) viewM1891b.getLayoutParams();
                                int i29 = this.f1671f;
                                iMax2 = Math.max(i29, i29 + i25 + aVar.topMargin + aVar.bottomMargin + m1890b(viewM1891b));
                            }
                            this.f1671f = iMax2;
                            iM1884a2++;
                            i22 = 8;
                        }
                    }
                } else {
                    i4 = i28;
                }
                this.f1671f += getPaddingTop() + getPaddingBottom();
                int iResolveSizeAndState = View.resolveSizeAndState(Math.max(this.f1671f, getSuggestedMinimumHeight()), i2, 0);
                int i30 = (16777215 & iResolveSizeAndState) - this.f1671f;
                if (z4 || (i30 != 0 && f2 > 0.0f)) {
                    if (this.f1672g > 0.0f) {
                        f2 = this.f1672g;
                    }
                    this.f1671f = 0;
                    float f3 = f2;
                    int i31 = 0;
                    int i32 = i26;
                    iCombineMeasuredStates = i24;
                    while (i31 < i3) {
                        View viewM1891b2 = m1891b(i31);
                        if (viewM1891b2.getVisibility() == 8) {
                            i6 = i4;
                            f = f3;
                        } else {
                            a aVar2 = (a) viewM1891b2.getLayoutParams();
                            float f4 = aVar2.f1681g;
                            if (f4 > 0.0f) {
                                int measuredHeight = (int) ((i30 * f4) / f3);
                                float f5 = f3 - f4;
                                int i33 = i30 - measuredHeight;
                                int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + aVar2.leftMargin + aVar2.rightMargin, aVar2.width);
                                if (aVar2.height == 0) {
                                    i8 = 1073741824;
                                    if (i4 == 1073741824) {
                                        if (measuredHeight <= 0) {
                                            measuredHeight = 0;
                                        }
                                        viewM1891b2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i8));
                                        iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewM1891b2.getMeasuredState() & (-256));
                                        i30 = i33;
                                        f = f5;
                                    }
                                } else {
                                    i8 = 1073741824;
                                }
                                measuredHeight = viewM1891b2.getMeasuredHeight() + measuredHeight;
                                if (measuredHeight < 0) {
                                }
                                viewM1891b2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i8));
                                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewM1891b2.getMeasuredState() & (-256));
                                i30 = i33;
                                f = f5;
                            } else {
                                f = f3;
                            }
                            int i34 = iCombineMeasuredStates;
                            int i35 = aVar2.leftMargin + aVar2.rightMargin;
                            int measuredWidth = viewM1891b2.getMeasuredWidth() + i35;
                            iMax6 = Math.max(iMax6, measuredWidth);
                            if (mode != 1073741824) {
                                i6 = i4;
                                i7 = -1;
                                z = aVar2.width == -1;
                                if (!z) {
                                    i35 = measuredWidth;
                                }
                                int iMax7 = Math.max(i32, i35);
                                boolean z7 = !z5 && aVar2.width == i7;
                                int i36 = this.f1671f;
                                this.f1671f = Math.max(i36, i36 + viewM1891b2.getMeasuredHeight() + aVar2.topMargin + aVar2.bottomMargin + m1890b(viewM1891b2));
                                z5 = z7;
                                i32 = iMax7;
                                iCombineMeasuredStates = i34;
                            } else {
                                i6 = i4;
                                i7 = -1;
                            }
                            if (!z) {
                            }
                            int iMax72 = Math.max(i32, i35);
                            if (z5) {
                                int i362 = this.f1671f;
                                this.f1671f = Math.max(i362, i362 + viewM1891b2.getMeasuredHeight() + aVar2.topMargin + aVar2.bottomMargin + m1890b(viewM1891b2));
                                z5 = z7;
                                i32 = iMax72;
                                iCombineMeasuredStates = i34;
                            }
                        }
                        i31++;
                        f3 = f;
                        i4 = i6;
                    }
                    i5 = i;
                    this.f1671f += getPaddingTop() + getPaddingBottom();
                    iMax = i32;
                } else {
                    iMax = Math.max(i26, i23);
                    if (z3 && i4 != 1073741824) {
                        for (int i37 = 0; i37 < i3; i37++) {
                            View viewM1891b3 = m1891b(i37);
                            if (viewM1891b3 != null && viewM1891b3.getVisibility() != 8 && ((a) viewM1891b3.getLayoutParams()).f1681g > 0.0f) {
                                viewM1891b3.measure(View.MeasureSpec.makeMeasureSpec(viewM1891b3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i25, 1073741824));
                            }
                        }
                    }
                    iCombineMeasuredStates = i24;
                    i5 = i;
                }
                if (z5 || mode == 1073741824) {
                    iMax = iMax6;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(iMax + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, iCombineMeasuredStates), iResolveSizeAndState);
                if (z6) {
                    m1881c(i3, i2);
                    return;
                }
                return;
            }
            View viewM1891b4 = m1891b(iM1884a);
            if (viewM1891b4 == null) {
                this.f1671f += m1897d(iM1884a);
                i12 = virtualChildCount;
                i13 = mode2;
                i20 = i23;
            } else {
                int i38 = i17;
                if (viewM1891b4.getVisibility() == 8) {
                    iM1884a += m1884a(viewM1891b4, iM1884a);
                    i12 = virtualChildCount;
                    i13 = mode2;
                    i20 = i23;
                    i17 = i38;
                } else {
                    if (m1896c(iM1884a)) {
                        this.f1671f += this.f1678m;
                    }
                    a aVar3 = (a) viewM1891b4.getLayoutParams();
                    float f6 = f2 + aVar3.f1681g;
                    if (mode2 == 1073741824 && aVar3.height == 0 && aVar3.f1681g > 0.0f) {
                        int i39 = this.f1671f;
                        this.f1671f = Math.max(i39, aVar3.topMargin + i39 + aVar3.bottomMargin);
                        iMax4 = i19;
                        view = viewM1891b4;
                        i14 = i21;
                        i12 = virtualChildCount;
                        i13 = mode2;
                        iMax3 = i23;
                        i10 = i38;
                        i11 = i18;
                        z4 = true;
                        i15 = iM1884a;
                    } else {
                        int i40 = i18;
                        if (aVar3.height != 0 || aVar3.f1681g <= 0.0f) {
                            i9 = Integer.MIN_VALUE;
                        } else {
                            aVar3.height = -2;
                            i9 = 0;
                        }
                        i10 = i38;
                        int i41 = i9;
                        i11 = i40;
                        int i42 = i19;
                        i12 = virtualChildCount;
                        i13 = mode2;
                        iMax3 = i23;
                        i14 = i21;
                        i15 = iM1884a;
                        m1889a(viewM1891b4, iM1884a, i, 0, i2, f6 == 0.0f ? this.f1671f : 0);
                        if (i41 != Integer.MIN_VALUE) {
                            aVar3.height = i41;
                        }
                        int measuredHeight2 = viewM1891b4.getMeasuredHeight();
                        int i43 = this.f1671f;
                        view = viewM1891b4;
                        this.f1671f = Math.max(i43, i43 + measuredHeight2 + aVar3.topMargin + aVar3.bottomMargin + m1890b(view));
                        iMax4 = z3 ? Math.max(measuredHeight2, i42) : i42;
                    }
                    if (i16 >= 0 && i16 == i15 + 1) {
                        this.f1668c = this.f1671f;
                    }
                    if (i15 < i16 && aVar3.f1681g > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || aVar3.width != -1) {
                        z2 = false;
                    } else {
                        z2 = true;
                        z6 = true;
                    }
                    int i44 = aVar3.leftMargin + aVar3.rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i44;
                    int iMax8 = Math.max(i11, measuredWidth2);
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i10, view.getMeasuredState());
                    boolean z8 = z5 && aVar3.width == -1;
                    if (aVar3.f1681g > 0.0f) {
                        if (!z2) {
                            i44 = measuredWidth2;
                        }
                        iMax3 = Math.max(iMax3, i44);
                        iMax5 = i14;
                    } else {
                        if (!z2) {
                            i44 = measuredWidth2;
                        }
                        iMax5 = Math.max(i14, i44);
                    }
                    int iM1884a3 = m1884a(view, i15) + i15;
                    i19 = iMax4;
                    z5 = z8;
                    i20 = iMax3;
                    f2 = f6;
                    i21 = iMax5;
                    i17 = iCombineMeasuredStates2;
                    iM1884a = iM1884a3;
                    i18 = iMax8;
                }
            }
            iM1884a++;
            mode2 = i13;
            virtualChildCount = i12;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a2  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void m1886a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int i7 = i3 - i;
        int paddingRight = i7 - getPaddingRight();
        int paddingRight2 = (i7 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i8 = this.f1670e & 112;
        int i9 = this.f1670e & 8388615;
        int paddingTop = i8 != 16 ? i8 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - this.f1671f : (((i4 - i2) - this.f1671f) / 2) + getPaddingTop();
        int iM1884a = 0;
        while (iM1884a < virtualChildCount) {
            View viewM1891b = m1891b(iM1884a);
            if (viewM1891b == null) {
                paddingTop += m1897d(iM1884a);
            } else if (viewM1891b.getVisibility() != 8) {
                int measuredWidth = viewM1891b.getMeasuredWidth();
                int measuredHeight = viewM1891b.getMeasuredHeight();
                a aVar = (a) viewM1891b.getLayoutParams();
                int i10 = aVar.f1682h;
                if (i10 < 0) {
                    i10 = i9;
                }
                int iM902a = C0112d.m902a(i10, C0124p.m960b(this)) & 7;
                if (iM902a == 1) {
                    i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + aVar.leftMargin;
                } else if (iM902a != 5) {
                    i6 = aVar.leftMargin + paddingLeft;
                    int i11 = i6;
                    if (m1896c(iM1884a)) {
                        paddingTop += this.f1678m;
                    }
                    int i12 = paddingTop + aVar.topMargin;
                    m1880a(viewM1891b, i11, i12 + m1883a(viewM1891b), measuredWidth, measuredHeight);
                    int iM1890b = i12 + measuredHeight + aVar.bottomMargin + m1890b(viewM1891b);
                    iM1884a += m1884a(viewM1891b, iM1884a);
                    paddingTop = iM1890b;
                } else {
                    i5 = paddingRight - measuredWidth;
                }
                i6 = i5 - aVar.rightMargin;
                int i112 = i6;
                if (m1896c(iM1884a)) {
                }
                int i122 = paddingTop + aVar.topMargin;
                m1880a(viewM1891b, i112, i122 + m1883a(viewM1891b), measuredWidth, measuredHeight);
                int iM1890b2 = i122 + measuredHeight + aVar.bottomMargin + m1890b(viewM1891b);
                iM1884a += m1884a(viewM1891b, iM1884a);
                paddingTop = iM1890b2;
            }
            iM1884a++;
        }
    }

    /* JADX INFO: renamed from: a */
    void m1887a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View viewM1891b = m1891b(i);
            if (viewM1891b != null && viewM1891b.getVisibility() != 8 && m1896c(i)) {
                m1888a(canvas, (viewM1891b.getTop() - ((a) viewM1891b.getLayoutParams()).topMargin) - this.f1678m);
            }
        }
        if (m1896c(virtualChildCount)) {
            View viewM1891b2 = m1891b(virtualChildCount - 1);
            m1888a(canvas, viewM1891b2 == null ? (getHeight() - getPaddingBottom()) - this.f1678m : viewM1891b2.getBottom() + ((a) viewM1891b2.getLayoutParams()).bottomMargin);
        }
    }

    /* JADX INFO: renamed from: a */
    void m1888a(Canvas canvas, int i) {
        this.f1676k.setBounds(getPaddingLeft() + this.f1680o, i, (getWidth() - getPaddingRight()) - this.f1680o, this.f1678m + i);
        this.f1676k.draw(canvas);
    }

    /* JADX INFO: renamed from: a */
    void m1889a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX INFO: renamed from: b */
    int m1890b(View view) {
        return 0;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    /* JADX INFO: renamed from: b */
    View m1891b(int i) {
        return getChildAt(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:169:0x03bd A[PHI: r4
  0x03bd: PHI (r4v32 int) = (r4v28 int), (r4v33 int) binds: [B:168:0x03bb, B:164:0x03b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x046d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d7  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void m1892b(int i, int i2) {
        int[] iArr;
        int i3;
        int i4;
        int i5;
        int iMax;
        int i6;
        int i7;
        float f;
        int i8;
        int baseline;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z;
        boolean z2;
        View view;
        int iMax2;
        int i13;
        boolean z3;
        int measuredHeight;
        int baseline2;
        int iMax3;
        this.f1671f = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.f1674i == null || this.f1675j == null) {
            this.f1674i = new int[4];
            this.f1675j = new int[4];
        }
        int[] iArr2 = this.f1674i;
        int[] iArr3 = this.f1675j;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z4 = this.f1666a;
        boolean z5 = this.f1673h;
        int i14 = 1073741824;
        boolean z6 = mode == 1073741824;
        float f2 = 0.0f;
        int iM1884a = 0;
        int iMax4 = 0;
        int i15 = 0;
        boolean z7 = false;
        int iMax5 = 0;
        int iMax6 = 0;
        int i16 = 0;
        boolean z8 = true;
        boolean z9 = false;
        while (true) {
            iArr = iArr3;
            if (iM1884a >= virtualChildCount) {
                break;
            }
            View viewM1891b = m1891b(iM1884a);
            if (viewM1891b == null) {
                this.f1671f += m1897d(iM1884a);
            } else if (viewM1891b.getVisibility() == 8) {
                iM1884a += m1884a(viewM1891b, iM1884a);
            } else {
                if (m1896c(iM1884a)) {
                    this.f1671f += this.f1677l;
                }
                a aVar = (a) viewM1891b.getLayoutParams();
                float f3 = f2 + aVar.f1681g;
                if (mode == i14 && aVar.width == 0 && aVar.f1681g > 0.0f) {
                    if (z6) {
                        iMax3 = this.f1671f + aVar.leftMargin + aVar.rightMargin;
                    } else {
                        int i17 = this.f1671f;
                        iMax3 = Math.max(i17, aVar.leftMargin + i17 + aVar.rightMargin);
                    }
                    this.f1671f = iMax3;
                    if (z4) {
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        viewM1891b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                        i12 = iM1884a;
                        z = z5;
                        z2 = z4;
                        view = viewM1891b;
                    } else {
                        i12 = iM1884a;
                        z = z5;
                        z2 = z4;
                        view = viewM1891b;
                        i13 = 1073741824;
                        z7 = true;
                        if (mode2 == i13 && aVar.height == -1) {
                            z3 = true;
                            z9 = true;
                        } else {
                            z3 = false;
                        }
                        int i18 = aVar.topMargin + aVar.bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i18;
                        int iCombineMeasuredStates = View.combineMeasuredStates(i16, view.getMeasuredState());
                        if (z2 && (baseline2 = view.getBaseline()) != -1) {
                            int i19 = ((((aVar.f1682h >= 0 ? this.f1670e : aVar.f1682h) & 112) >> 4) & (-2)) >> 1;
                            iArr2[i19] = Math.max(iArr2[i19], baseline2);
                            iArr[i19] = Math.max(iArr[i19], measuredHeight - baseline2);
                        }
                        int iMax7 = Math.max(i15, measuredHeight);
                        boolean z10 = !z8 && aVar.height == -1;
                        if (aVar.f1681g <= 0.0f) {
                            if (!z3) {
                                i18 = measuredHeight;
                            }
                            iMax6 = Math.max(iMax6, i18);
                        } else {
                            int i20 = iMax6;
                            if (z3) {
                                measuredHeight = i18;
                            }
                            iMax5 = Math.max(iMax5, measuredHeight);
                            iMax6 = i20;
                        }
                        int i21 = i12;
                        i15 = iMax7;
                        i16 = iCombineMeasuredStates;
                        z8 = z10;
                        iM1884a = m1884a(view, i21) + i21;
                        f2 = f3;
                        iM1884a++;
                        iArr3 = iArr;
                        z5 = z;
                        z4 = z2;
                        i14 = 1073741824;
                    }
                } else {
                    if (aVar.width != 0 || aVar.f1681g <= 0.0f) {
                        i11 = Integer.MIN_VALUE;
                    } else {
                        aVar.width = -2;
                        i11 = 0;
                    }
                    i12 = iM1884a;
                    int i22 = i11;
                    z = z5;
                    z2 = z4;
                    m1889a(viewM1891b, i12, i, f3 == 0.0f ? this.f1671f : 0, i2, 0);
                    if (i22 != Integer.MIN_VALUE) {
                        aVar.width = i22;
                    }
                    int measuredWidth = viewM1891b.getMeasuredWidth();
                    if (z6) {
                        view = viewM1891b;
                        iMax2 = this.f1671f + aVar.leftMargin + measuredWidth + aVar.rightMargin + m1890b(view);
                    } else {
                        view = viewM1891b;
                        int i23 = this.f1671f;
                        iMax2 = Math.max(i23, i23 + measuredWidth + aVar.leftMargin + aVar.rightMargin + m1890b(view));
                    }
                    this.f1671f = iMax2;
                    if (z) {
                        iMax4 = Math.max(measuredWidth, iMax4);
                    }
                }
                i13 = 1073741824;
                if (mode2 == i13) {
                    z3 = false;
                    int i182 = aVar.topMargin + aVar.bottomMargin;
                    measuredHeight = view.getMeasuredHeight() + i182;
                    int iCombineMeasuredStates2 = View.combineMeasuredStates(i16, view.getMeasuredState());
                    if (z2) {
                        int i192 = ((((aVar.f1682h >= 0 ? this.f1670e : aVar.f1682h) & 112) >> 4) & (-2)) >> 1;
                        iArr2[i192] = Math.max(iArr2[i192], baseline2);
                        iArr[i192] = Math.max(iArr[i192], measuredHeight - baseline2);
                    }
                    int iMax72 = Math.max(i15, measuredHeight);
                    if (z8) {
                        if (aVar.f1681g <= 0.0f) {
                        }
                        int i212 = i12;
                        i15 = iMax72;
                        i16 = iCombineMeasuredStates2;
                        z8 = z10;
                        iM1884a = m1884a(view, i212) + i212;
                        f2 = f3;
                    }
                }
                iM1884a++;
                iArr3 = iArr;
                z5 = z;
                z4 = z2;
                i14 = 1073741824;
            }
            z = z5;
            z2 = z4;
            iM1884a++;
            iArr3 = iArr;
            z5 = z;
            z4 = z2;
            i14 = 1073741824;
        }
        boolean z11 = z5;
        boolean z12 = z4;
        int iMax8 = i15;
        int i24 = iMax5;
        int i25 = iMax6;
        int i26 = i16;
        if (this.f1671f > 0 && m1896c(virtualChildCount)) {
            this.f1671f += this.f1677l;
        }
        if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            i3 = i26;
        } else {
            i3 = i26;
            iMax8 = Math.max(iMax8, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z11 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f1671f = 0;
            int iM1884a2 = 0;
            while (iM1884a2 < virtualChildCount) {
                View viewM1891b2 = m1891b(iM1884a2);
                if (viewM1891b2 == null) {
                    this.f1671f += m1897d(iM1884a2);
                } else if (viewM1891b2.getVisibility() == 8) {
                    iM1884a2 += m1884a(viewM1891b2, iM1884a2);
                } else {
                    a aVar2 = (a) viewM1891b2.getLayoutParams();
                    if (z6) {
                        this.f1671f += aVar2.leftMargin + iMax4 + aVar2.rightMargin + m1890b(viewM1891b2);
                    } else {
                        int i27 = this.f1671f;
                        i10 = iMax8;
                        this.f1671f = Math.max(i27, i27 + iMax4 + aVar2.leftMargin + aVar2.rightMargin + m1890b(viewM1891b2));
                        iM1884a2++;
                        iMax8 = i10;
                    }
                }
                i10 = iMax8;
                iM1884a2++;
                iMax8 = i10;
            }
        }
        int iMax9 = iMax8;
        this.f1671f += getPaddingLeft() + getPaddingRight();
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(this.f1671f, getSuggestedMinimumWidth()), i, 0);
        int i28 = (16777215 & iResolveSizeAndState) - this.f1671f;
        if (z7 || (i28 != 0 && f2 > 0.0f)) {
            if (this.f1672g > 0.0f) {
                f2 = this.f1672g;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.f1671f = 0;
            int i29 = i24;
            int iCombineMeasuredStates3 = i3;
            int iMax10 = -1;
            float f4 = f2;
            int i30 = 0;
            while (i30 < virtualChildCount) {
                View viewM1891b3 = m1891b(i30);
                if (viewM1891b3 == null || viewM1891b3.getVisibility() == 8) {
                    i6 = i28;
                    i7 = virtualChildCount;
                } else {
                    a aVar3 = (a) viewM1891b3.getLayoutParams();
                    float f5 = aVar3.f1681g;
                    if (f5 > 0.0f) {
                        int measuredWidth2 = (int) ((i28 * f5) / f4);
                        float f6 = f4 - f5;
                        int i31 = i28 - measuredWidth2;
                        i7 = virtualChildCount;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + aVar3.topMargin + aVar3.bottomMargin, aVar3.height);
                        if (aVar3.width == 0) {
                            i9 = 1073741824;
                            if (mode == 1073741824) {
                                if (measuredWidth2 <= 0) {
                                    measuredWidth2 = 0;
                                }
                                viewM1891b3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i9), childMeasureSpec);
                                iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, viewM1891b3.getMeasuredState() & (-16777216));
                                f4 = f6;
                                i6 = i31;
                            }
                        } else {
                            i9 = 1073741824;
                        }
                        measuredWidth2 = viewM1891b3.getMeasuredWidth() + measuredWidth2;
                        if (measuredWidth2 < 0) {
                        }
                        viewM1891b3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i9), childMeasureSpec);
                        iCombineMeasuredStates3 = View.combineMeasuredStates(iCombineMeasuredStates3, viewM1891b3.getMeasuredState() & (-16777216));
                        f4 = f6;
                        i6 = i31;
                    } else {
                        i6 = i28;
                        i7 = virtualChildCount;
                    }
                    if (z6) {
                        this.f1671f += viewM1891b3.getMeasuredWidth() + aVar3.leftMargin + aVar3.rightMargin + m1890b(viewM1891b3);
                        f = f4;
                    } else {
                        int i32 = this.f1671f;
                        f = f4;
                        this.f1671f = Math.max(i32, viewM1891b3.getMeasuredWidth() + i32 + aVar3.leftMargin + aVar3.rightMargin + m1890b(viewM1891b3));
                    }
                    boolean z13 = mode2 != 1073741824 && aVar3.height == -1;
                    int i33 = aVar3.topMargin + aVar3.bottomMargin;
                    int measuredHeight2 = viewM1891b3.getMeasuredHeight() + i33;
                    iMax10 = Math.max(iMax10, measuredHeight2);
                    if (!z13) {
                        i33 = measuredHeight2;
                    }
                    int iMax11 = Math.max(i29, i33);
                    if (z8) {
                        i8 = -1;
                        boolean z14 = aVar3.height == -1;
                        if (!z12 && (baseline = viewM1891b3.getBaseline()) != i8) {
                            int i34 = ((((aVar3.f1682h < 0 ? this.f1670e : aVar3.f1682h) & 112) >> 4) & (-2)) >> 1;
                            iArr2[i34] = Math.max(iArr2[i34], baseline);
                            iArr[i34] = Math.max(iArr[i34], measuredHeight2 - baseline);
                        }
                        i29 = iMax11;
                        z8 = z14;
                        f4 = f;
                    } else {
                        i8 = -1;
                    }
                    if (!z12) {
                        i29 = iMax11;
                        z8 = z14;
                        f4 = f;
                    }
                }
                i30++;
                i28 = i6;
                virtualChildCount = i7;
            }
            i4 = virtualChildCount;
            i5 = i2;
            this.f1671f += getPaddingLeft() + getPaddingRight();
            iMax9 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? iMax10 : Math.max(iMax10, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            i3 = iCombineMeasuredStates3;
            iMax = i29;
        } else {
            iMax = Math.max(i24, i25);
            if (z11 && mode != 1073741824) {
                for (int i35 = 0; i35 < virtualChildCount; i35++) {
                    View viewM1891b4 = m1891b(i35);
                    if (viewM1891b4 != null && viewM1891b4.getVisibility() != 8 && ((a) viewM1891b4.getLayoutParams()).f1681g > 0.0f) {
                        viewM1891b4.measure(View.MeasureSpec.makeMeasureSpec(iMax4, 1073741824), View.MeasureSpec.makeMeasureSpec(viewM1891b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i4 = virtualChildCount;
            i5 = i2;
        }
        if (!z8 && mode2 != 1073741824) {
            iMax9 = iMax;
        }
        setMeasuredDimension(iResolveSizeAndState | (i3 & (-16777216)), View.resolveSizeAndState(Math.max(iMax9 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i5, i3 << 16));
        if (z9) {
            m1882d(i4, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x010a  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void m1893b(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean zM2027a = C0270bc.m2027a(this);
        int paddingTop = getPaddingTop();
        int i14 = i4 - i2;
        int paddingBottom = i14 - getPaddingBottom();
        int paddingBottom2 = (i14 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i15 = this.f1670e & 8388615;
        int i16 = this.f1670e & 112;
        boolean z = this.f1666a;
        int[] iArr = this.f1674i;
        int[] iArr2 = this.f1675j;
        int iM902a = C0112d.m902a(i15, C0124p.m960b(this));
        int paddingLeft = iM902a != 1 ? iM902a != 5 ? getPaddingLeft() : ((getPaddingLeft() + i3) - i) - this.f1671f : (((i3 - i) - this.f1671f) / 2) + getPaddingLeft();
        if (zM2027a) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int iM1884a = 0;
        while (iM1884a < virtualChildCount) {
            int i17 = i5 + (i6 * iM1884a);
            View viewM1891b = m1891b(i17);
            if (viewM1891b == null) {
                paddingLeft += m1897d(i17);
            } else if (viewM1891b.getVisibility() != 8) {
                int measuredWidth = viewM1891b.getMeasuredWidth();
                int measuredHeight = viewM1891b.getMeasuredHeight();
                a aVar = (a) viewM1891b.getLayoutParams();
                if (z) {
                    i7 = iM1884a;
                    i8 = virtualChildCount;
                    int baseline = aVar.height != -1 ? viewM1891b.getBaseline() : -1;
                    i9 = aVar.f1682h;
                    if (i9 < 0) {
                        i9 = i16;
                    }
                    i10 = i9 & 112;
                    i11 = i16;
                    if (i10 != 16) {
                        i12 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + aVar.topMargin) - aVar.bottomMargin;
                    } else if (i10 == 48) {
                        int i18 = aVar.topMargin + paddingTop;
                        if (baseline != -1) {
                            i18 += iArr[1] - baseline;
                        }
                        i12 = i18;
                    } else if (i10 != 80) {
                        i12 = paddingTop;
                    } else {
                        int measuredHeight2 = (paddingBottom - measuredHeight) - aVar.bottomMargin;
                        if (baseline != -1) {
                            measuredHeight2 -= iArr2[2] - (viewM1891b.getMeasuredHeight() - baseline);
                        }
                        i12 = measuredHeight2;
                    }
                    if (m1896c(i17)) {
                        paddingLeft += this.f1677l;
                    }
                    int i19 = aVar.leftMargin + paddingLeft;
                    i13 = paddingTop;
                    m1880a(viewM1891b, i19 + m1883a(viewM1891b), i12, measuredWidth, measuredHeight);
                    int iM1890b = i19 + measuredWidth + aVar.rightMargin + m1890b(viewM1891b);
                    iM1884a = i7 + m1884a(viewM1891b, i17);
                    paddingLeft = iM1890b;
                    iM1884a++;
                    virtualChildCount = i8;
                    i16 = i11;
                    paddingTop = i13;
                } else {
                    i7 = iM1884a;
                    i8 = virtualChildCount;
                }
                i9 = aVar.f1682h;
                if (i9 < 0) {
                }
                i10 = i9 & 112;
                i11 = i16;
                if (i10 != 16) {
                }
                if (m1896c(i17)) {
                }
                int i192 = aVar.leftMargin + paddingLeft;
                i13 = paddingTop;
                m1880a(viewM1891b, i192 + m1883a(viewM1891b), i12, measuredWidth, measuredHeight);
                int iM1890b2 = i192 + measuredWidth + aVar.rightMargin + m1890b(viewM1891b);
                iM1884a = i7 + m1884a(viewM1891b, i17);
                paddingLeft = iM1890b2;
                iM1884a++;
                virtualChildCount = i8;
                i16 = i11;
                paddingTop = i13;
            }
            i13 = paddingTop;
            i8 = virtualChildCount;
            i11 = i16;
            iM1884a++;
            virtualChildCount = i8;
            i16 = i11;
            paddingTop = i13;
        }
    }

    /* JADX INFO: renamed from: b */
    void m1894b(Canvas canvas) {
        int right;
        int left;
        int paddingRight;
        int virtualChildCount = getVirtualChildCount();
        boolean zM2027a = C0270bc.m2027a(this);
        for (int i = 0; i < virtualChildCount; i++) {
            View viewM1891b = m1891b(i);
            if (viewM1891b != null && viewM1891b.getVisibility() != 8 && m1896c(i)) {
                a aVar = (a) viewM1891b.getLayoutParams();
                m1895b(canvas, zM2027a ? viewM1891b.getRight() + aVar.rightMargin : (viewM1891b.getLeft() - aVar.leftMargin) - this.f1677l);
            }
        }
        if (m1896c(virtualChildCount)) {
            View viewM1891b2 = m1891b(virtualChildCount - 1);
            if (viewM1891b2 != null) {
                a aVar2 = (a) viewM1891b2.getLayoutParams();
                if (zM2027a) {
                    left = viewM1891b2.getLeft();
                    paddingRight = aVar2.leftMargin;
                    right = (left - paddingRight) - this.f1677l;
                } else {
                    right = viewM1891b2.getRight() + aVar2.rightMargin;
                }
            } else if (zM2027a) {
                right = getPaddingLeft();
            } else {
                left = getWidth();
                paddingRight = getPaddingRight();
                right = (left - paddingRight) - this.f1677l;
            }
            m1895b(canvas, right);
        }
    }

    /* JADX INFO: renamed from: b */
    void m1895b(Canvas canvas, int i) {
        this.f1676k.setBounds(i, getPaddingTop() + this.f1680o, this.f1677l + i, (getHeight() - getPaddingBottom()) - this.f1680o);
        this.f1676k.draw(canvas);
    }

    /* JADX INFO: renamed from: c */
    protected boolean m1896c(int i) {
        if (i == 0) {
            return (this.f1679n & 1) != 0;
        }
        if (i == getChildCount()) {
            return (this.f1679n & 4) != 0;
        }
        if ((this.f1679n & 2) == 0) {
            return false;
        }
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (getChildAt(i2).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    /* JADX INFO: renamed from: d */
    int m1897d(int i) {
        return 0;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.f1667b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f1667b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f1667b);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f1667b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f1668c;
        if (this.f1669d == 1 && (i = this.f1670e & 112) != 48) {
            if (i == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1671f) / 2;
            } else if (i == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1671f;
            }
        }
        return bottom + ((a) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1667b;
    }

    public Drawable getDividerDrawable() {
        return this.f1676k;
    }

    public int getDividerPadding() {
        return this.f1680o;
    }

    public int getDividerWidth() {
        return this.f1677l;
    }

    public int getGravity() {
        return this.f1670e;
    }

    public int getOrientation() {
        return this.f1669d;
    }

    public int getShowDividers() {
        return this.f1679n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1672g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public a generateDefaultLayoutParams() {
        if (this.f1669d == 0) {
            return new a(-2, -2);
        }
        if (this.f1669d == 1) {
            return new a(-1, -2);
        }
        return null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f1676k == null) {
            return;
        }
        if (this.f1669d == 1) {
            m1887a(canvas);
        } else {
            m1894b(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(C0250aj.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(C0250aj.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1669d == 1) {
            m1886a(i, i2, i3, i4);
        } else {
            m1893b(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f1669d == 1) {
            m1885a(i, i2);
        } else {
            m1892b(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.f1666a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.f1667b = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f1676k) {
            return;
        }
        this.f1676k = drawable;
        if (drawable != null) {
            this.f1677l = drawable.getIntrinsicWidth();
            this.f1678m = drawable.getIntrinsicHeight();
        } else {
            this.f1677l = 0;
            this.f1678m = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.f1680o = i;
    }

    public void setGravity(int i) {
        if (this.f1670e != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.f1670e = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((8388615 & this.f1670e) != i2) {
            this.f1670e = i2 | (this.f1670e & (-8388616));
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f1673h = z;
    }

    public void setOrientation(int i) {
        if (this.f1669d != i) {
            this.f1669d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f1679n) {
            requestLayout();
        }
        this.f1679n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f1670e & 112) != i2) {
            this.f1670e = i2 | (this.f1670e & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f1672g = Math.max(0.0f, f);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
