package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p015g.C0112d;
import android.support.v4.p015g.C0124p;
import android.support.v7.p018a.C0148a;
import android.support.v7.widget.C0250aj;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class AlertDialogLayout extends C0250aj {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m1698a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    /* JADX INFO: renamed from: c */
    private static int m1699c(View view) {
        int iM961c = C0124p.m961c(view);
        if (iM961c > 0) {
            return iM961c;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return m1699c(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: c */
    private boolean m1700c(int i, int i2) {
        int iCombineMeasuredStates;
        int iM1699c;
        int measuredHeight;
        int measuredHeight2;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == C0148a.f.topPanel) {
                    view = childAt;
                } else if (id == C0148a.f.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id != C0148a.f.contentPanel && id != C0148a.f.customPanel) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i, 0);
            paddingTop += view.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            iCombineMeasuredStates = 0;
        }
        if (view2 != null) {
            view2.measure(i, 0);
            iM1699c = m1699c(view2);
            measuredHeight = view2.getMeasuredHeight() - iM1699c;
            paddingTop += iM1699c;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        } else {
            iM1699c = 0;
            measuredHeight = 0;
        }
        if (view3 != null) {
            view3.measure(i, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            measuredHeight2 = view3.getMeasuredHeight();
            paddingTop += measuredHeight2;
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        } else {
            measuredHeight2 = 0;
        }
        int i4 = size - paddingTop;
        if (view2 != null) {
            int i5 = paddingTop - iM1699c;
            int iMin = Math.min(i4, measuredHeight);
            if (iMin > 0) {
                i4 -= iMin;
                iM1699c += iMin;
            }
            view2.measure(i, View.MeasureSpec.makeMeasureSpec(iM1699c, 1073741824));
            paddingTop = i5 + view2.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view2.getMeasuredState());
        }
        if (view3 != null && i4 > 0) {
            view3.measure(i, View.MeasureSpec.makeMeasureSpec(measuredHeight2 + i4, mode));
            paddingTop = (paddingTop - measuredHeight2) + view3.getMeasuredHeight();
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, view3.getMeasuredState());
        }
        int iMax = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = getChildAt(i6);
            if (childAt2.getVisibility() != 8) {
                iMax = Math.max(iMax, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(iMax + getPaddingLeft() + getPaddingRight(), i, iCombineMeasuredStates), View.resolveSizeAndState(paddingTop, i2, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        m1701d(childCount, i2);
        return true;
    }

    /* JADX INFO: renamed from: d */
    private void m1701d(int i, int i2) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                C0250aj.a aVar = (C0250aj.a) childAt.getLayoutParams();
                if (aVar.width == -1) {
                    int i4 = aVar.height;
                    aVar.height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, iMakeMeasureSpec, 0, i2, 0);
                    aVar.height = i4;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00a5  */
    @Override // android.support.v7.widget.C0250aj, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int i7 = i3 - i;
        int paddingRight = i7 - getPaddingRight();
        int paddingRight2 = (i7 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i8 = gravity & 112;
        int i9 = gravity & 8388615;
        int paddingTop = i8 != 16 ? i8 != 80 ? getPaddingTop() : ((getPaddingTop() + i4) - i2) - measuredHeight : (((i4 - i2) - measuredHeight) / 2) + getPaddingTop();
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                C0250aj.a aVar = (C0250aj.a) childAt.getLayoutParams();
                int i11 = aVar.f1682h;
                if (i11 < 0) {
                    i11 = i9;
                }
                int iM902a = C0112d.m902a(i11, C0124p.m960b(this)) & 7;
                if (iM902a == 1) {
                    i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + aVar.leftMargin;
                } else if (iM902a != 5) {
                    i6 = aVar.leftMargin + paddingLeft;
                    if (m1896c(i10)) {
                        paddingTop += intrinsicHeight;
                    }
                    int i12 = paddingTop + aVar.topMargin;
                    m1698a(childAt, i6, i12, measuredWidth, measuredHeight2);
                    paddingTop = i12 + measuredHeight2 + aVar.bottomMargin;
                } else {
                    i5 = paddingRight - measuredWidth;
                }
                i6 = i5 - aVar.rightMargin;
                if (m1896c(i10)) {
                }
                int i122 = paddingTop + aVar.topMargin;
                m1698a(childAt, i6, i122, measuredWidth, measuredHeight2);
                paddingTop = i122 + measuredHeight2 + aVar.bottomMargin;
            }
        }
    }

    @Override // android.support.v7.widget.C0250aj, android.view.View
    protected void onMeasure(int i, int i2) {
        if (m1700c(i, i2)) {
            return;
        }
        super.onMeasure(i, i2);
    }
}
