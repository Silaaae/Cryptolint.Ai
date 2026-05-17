package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.p015g.AbstractC0102a;
import android.support.v4.p015g.C0112d;
import android.support.v4.p015g.C0114f;
import android.support.v4.p015g.C0124p;
import android.support.v7.app.AbstractC0158a;
import android.support.v7.p018a.C0148a;
import android.support.v7.p019b.p020a.C0175b;
import android.support.v7.view.C0184g;
import android.support.v7.view.InterfaceC0180c;
import android.support.v7.view.menu.C0196h;
import android.support.v7.view.menu.C0198j;
import android.support.v7.view.menu.InterfaceC0203o;
import android.support.v7.view.menu.SubMenuC0209u;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Toolbar extends ViewGroup {

    /* JADX INFO: renamed from: A */
    private int f1555A;

    /* JADX INFO: renamed from: B */
    private int f1556B;

    /* JADX INFO: renamed from: C */
    private boolean f1557C;

    /* JADX INFO: renamed from: D */
    private boolean f1558D;

    /* JADX INFO: renamed from: E */
    private final ArrayList<View> f1559E;

    /* JADX INFO: renamed from: F */
    private final ArrayList<View> f1560F;

    /* JADX INFO: renamed from: G */
    private final int[] f1561G;

    /* JADX INFO: renamed from: H */
    private final ActionMenuView.InterfaceC0221e f1562H;

    /* JADX INFO: renamed from: I */
    private C0264ax f1563I;

    /* JADX INFO: renamed from: J */
    private C0273d f1564J;

    /* JADX INFO: renamed from: K */
    private C0235a f1565K;

    /* JADX INFO: renamed from: L */
    private InterfaceC0203o.a f1566L;

    /* JADX INFO: renamed from: M */
    private C0196h.a f1567M;

    /* JADX INFO: renamed from: N */
    private boolean f1568N;

    /* JADX INFO: renamed from: O */
    private final Runnable f1569O;

    /* JADX INFO: renamed from: a */
    ImageButton f1570a;

    /* JADX INFO: renamed from: b */
    View f1571b;

    /* JADX INFO: renamed from: c */
    int f1572c;

    /* JADX INFO: renamed from: d */
    InterfaceC0237c f1573d;

    /* JADX INFO: renamed from: e */
    private ActionMenuView f1574e;

    /* JADX INFO: renamed from: f */
    private TextView f1575f;

    /* JADX INFO: renamed from: g */
    private TextView f1576g;

    /* JADX INFO: renamed from: h */
    private ImageButton f1577h;

    /* JADX INFO: renamed from: i */
    private ImageView f1578i;

    /* JADX INFO: renamed from: j */
    private Drawable f1579j;

    /* JADX INFO: renamed from: k */
    private CharSequence f1580k;

    /* JADX INFO: renamed from: l */
    private Context f1581l;

    /* JADX INFO: renamed from: m */
    private int f1582m;

    /* JADX INFO: renamed from: n */
    private int f1583n;

    /* JADX INFO: renamed from: o */
    private int f1584o;

    /* JADX INFO: renamed from: p */
    private int f1585p;

    /* JADX INFO: renamed from: q */
    private int f1586q;

    /* JADX INFO: renamed from: r */
    private int f1587r;

    /* JADX INFO: renamed from: s */
    private int f1588s;

    /* JADX INFO: renamed from: t */
    private int f1589t;

    /* JADX INFO: renamed from: u */
    private C0255ao f1590u;

    /* JADX INFO: renamed from: v */
    private int f1591v;

    /* JADX INFO: renamed from: w */
    private int f1592w;

    /* JADX INFO: renamed from: x */
    private int f1593x;

    /* JADX INFO: renamed from: y */
    private CharSequence f1594y;

    /* JADX INFO: renamed from: z */
    private CharSequence f1595z;

    /* JADX INFO: renamed from: android.support.v7.widget.Toolbar$a */
    private class C0235a implements InterfaceC0203o {

        /* JADX INFO: renamed from: a */
        C0196h f1599a;

        /* JADX INFO: renamed from: b */
        C0198j f1600b;

        C0235a() {
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o
        /* JADX INFO: renamed from: a */
        public void mo1469a(Context context, C0196h c0196h) {
            if (this.f1599a != null && this.f1600b != null) {
                this.f1599a.mo1560d(this.f1600b);
            }
            this.f1599a = c0196h;
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o
        /* JADX INFO: renamed from: a */
        public void mo1470a(C0196h c0196h, boolean z) {
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o
        /* JADX INFO: renamed from: a */
        public void mo1472a(InterfaceC0203o.a aVar) {
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o
        /* JADX INFO: renamed from: a */
        public boolean mo1475a(C0196h c0196h, C0198j c0198j) {
            Toolbar.this.m1778i();
            ViewParent parent = Toolbar.this.f1570a.getParent();
            if (parent != Toolbar.this) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(Toolbar.this.f1570a);
                }
                Toolbar.this.addView(Toolbar.this.f1570a);
            }
            Toolbar.this.f1571b = c0198j.getActionView();
            this.f1600b = c0198j;
            ViewParent parent2 = Toolbar.this.f1571b.getParent();
            if (parent2 != Toolbar.this) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(Toolbar.this.f1571b);
                }
                C0236b c0236bGenerateDefaultLayoutParams = Toolbar.this.generateDefaultLayoutParams();
                c0236bGenerateDefaultLayoutParams.f902a = 8388611 | (Toolbar.this.f1572c & 112);
                c0236bGenerateDefaultLayoutParams.f1602b = 2;
                Toolbar.this.f1571b.setLayoutParams(c0236bGenerateDefaultLayoutParams);
                Toolbar.this.addView(Toolbar.this.f1571b);
            }
            Toolbar.this.m1780k();
            Toolbar.this.requestLayout();
            c0198j.m1593e(true);
            if (Toolbar.this.f1571b instanceof InterfaceC0180c) {
                ((InterfaceC0180c) Toolbar.this.f1571b).mo1416a();
            }
            return true;
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o
        /* JADX INFO: renamed from: a */
        public boolean mo1476a(SubMenuC0209u subMenuC0209u) {
            return false;
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o
        /* JADX INFO: renamed from: b */
        public void mo1479b(boolean z) {
            if (this.f1600b != null) {
                boolean z2 = false;
                if (this.f1599a != null) {
                    int size = this.f1599a.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        if (this.f1599a.getItem(i) == this.f1600b) {
                            z2 = true;
                            break;
                        }
                        i++;
                    }
                }
                if (z2) {
                    return;
                }
                mo1481b(this.f1599a, this.f1600b);
            }
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o
        /* JADX INFO: renamed from: b */
        public boolean mo1480b() {
            return false;
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o
        /* JADX INFO: renamed from: b */
        public boolean mo1481b(C0196h c0196h, C0198j c0198j) {
            if (Toolbar.this.f1571b instanceof InterfaceC0180c) {
                ((InterfaceC0180c) Toolbar.this.f1571b).mo1417b();
            }
            Toolbar.this.removeView(Toolbar.this.f1571b);
            Toolbar.this.removeView(Toolbar.this.f1570a);
            Toolbar.this.f1571b = null;
            Toolbar.this.m1781l();
            this.f1600b = null;
            Toolbar.this.requestLayout();
            c0198j.m1593e(false);
            return true;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.Toolbar$b */
    public static class C0236b extends AbstractC0158a.a {

        /* JADX INFO: renamed from: b */
        int f1602b;

        public C0236b(int i, int i2) {
            super(i, i2);
            this.f1602b = 0;
            this.f902a = 8388627;
        }

        public C0236b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1602b = 0;
        }

        public C0236b(AbstractC0158a.a aVar) {
            super(aVar);
            this.f1602b = 0;
        }

        public C0236b(C0236b c0236b) {
            super((AbstractC0158a.a) c0236b);
            this.f1602b = 0;
            this.f1602b = c0236b.f1602b;
        }

        public C0236b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1602b = 0;
        }

        public C0236b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1602b = 0;
            m1782a(marginLayoutParams);
        }

        /* JADX INFO: renamed from: a */
        void m1782a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.Toolbar$c */
    public interface InterfaceC0237c {
        /* JADX INFO: renamed from: a */
        boolean m1783a(MenuItem menuItem);
    }

    /* JADX INFO: renamed from: android.support.v7.widget.Toolbar$d */
    public static class C0238d extends AbstractC0102a {
        public static final Parcelable.Creator<C0238d> CREATOR = new Parcelable.ClassLoaderCreator<C0238d>() { // from class: android.support.v7.widget.Toolbar.d.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0238d createFromParcel(Parcel parcel) {
                return new C0238d(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0238d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0238d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0238d[] newArray(int i) {
                return new C0238d[i];
            }
        };

        /* JADX INFO: renamed from: b */
        int f1603b;

        /* JADX INFO: renamed from: c */
        boolean f1604c;

        public C0238d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1603b = parcel.readInt();
            this.f1604c = parcel.readInt() != 0;
        }

        public C0238d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.p015g.AbstractC0102a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1603b);
            parcel.writeInt(this.f1604c ? 1 : 0);
        }
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0148a.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1593x = 8388627;
        this.f1559E = new ArrayList<>();
        this.f1560F = new ArrayList<>();
        this.f1561G = new int[2];
        this.f1562H = new ActionMenuView.InterfaceC0221e() { // from class: android.support.v7.widget.Toolbar.1
            @Override // android.support.v7.widget.ActionMenuView.InterfaceC0221e
            /* JADX INFO: renamed from: a */
            public boolean mo1683a(MenuItem menuItem) {
                if (Toolbar.this.f1573d != null) {
                    return Toolbar.this.f1573d.m1783a(menuItem);
                }
                return false;
            }
        };
        this.f1569O = new Runnable() { // from class: android.support.v7.widget.Toolbar.2
            @Override // java.lang.Runnable
            public void run() {
                Toolbar.this.m1773d();
            }
        };
        C0263aw c0263awM1978a = C0263aw.m1978a(getContext(), attributeSet, C0148a.j.Toolbar, i, 0);
        this.f1583n = c0263awM1978a.m1995g(C0148a.j.Toolbar_titleTextAppearance, 0);
        this.f1584o = c0263awM1978a.m1995g(C0148a.j.Toolbar_subtitleTextAppearance, 0);
        this.f1593x = c0263awM1978a.m1987c(C0148a.j.Toolbar_android_gravity, this.f1593x);
        this.f1572c = c0263awM1978a.m1987c(C0148a.j.Toolbar_buttonGravity, 48);
        int iM1989d = c0263awM1978a.m1989d(C0148a.j.Toolbar_titleMargin, 0);
        iM1989d = c0263awM1978a.m1996g(C0148a.j.Toolbar_titleMargins) ? c0263awM1978a.m1989d(C0148a.j.Toolbar_titleMargins, iM1989d) : iM1989d;
        this.f1589t = iM1989d;
        this.f1588s = iM1989d;
        this.f1587r = iM1989d;
        this.f1586q = iM1989d;
        int iM1989d2 = c0263awM1978a.m1989d(C0148a.j.Toolbar_titleMarginStart, -1);
        if (iM1989d2 >= 0) {
            this.f1586q = iM1989d2;
        }
        int iM1989d3 = c0263awM1978a.m1989d(C0148a.j.Toolbar_titleMarginEnd, -1);
        if (iM1989d3 >= 0) {
            this.f1587r = iM1989d3;
        }
        int iM1989d4 = c0263awM1978a.m1989d(C0148a.j.Toolbar_titleMarginTop, -1);
        if (iM1989d4 >= 0) {
            this.f1588s = iM1989d4;
        }
        int iM1989d5 = c0263awM1978a.m1989d(C0148a.j.Toolbar_titleMarginBottom, -1);
        if (iM1989d5 >= 0) {
            this.f1589t = iM1989d5;
        }
        this.f1585p = c0263awM1978a.m1991e(C0148a.j.Toolbar_maxButtonHeight, -1);
        int iM1989d6 = c0263awM1978a.m1989d(C0148a.j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int iM1989d7 = c0263awM1978a.m1989d(C0148a.j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int iM1991e = c0263awM1978a.m1991e(C0148a.j.Toolbar_contentInsetLeft, 0);
        int iM1991e2 = c0263awM1978a.m1991e(C0148a.j.Toolbar_contentInsetRight, 0);
        m1762s();
        this.f1590u.m1936b(iM1991e, iM1991e2);
        if (iM1989d6 != Integer.MIN_VALUE || iM1989d7 != Integer.MIN_VALUE) {
            this.f1590u.m1933a(iM1989d6, iM1989d7);
        }
        this.f1591v = c0263awM1978a.m1989d(C0148a.j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.f1592w = c0263awM1978a.m1989d(C0148a.j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1579j = c0263awM1978a.m1982a(C0148a.j.Toolbar_collapseIcon);
        this.f1580k = c0263awM1978a.m1988c(C0148a.j.Toolbar_collapseContentDescription);
        CharSequence charSequenceM1988c = c0263awM1978a.m1988c(C0148a.j.Toolbar_title);
        if (!TextUtils.isEmpty(charSequenceM1988c)) {
            setTitle(charSequenceM1988c);
        }
        CharSequence charSequenceM1988c2 = c0263awM1978a.m1988c(C0148a.j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(charSequenceM1988c2)) {
            setSubtitle(charSequenceM1988c2);
        }
        this.f1581l = getContext();
        setPopupTheme(c0263awM1978a.m1995g(C0148a.j.Toolbar_popupTheme, 0));
        Drawable drawableM1982a = c0263awM1978a.m1982a(C0148a.j.Toolbar_navigationIcon);
        if (drawableM1982a != null) {
            setNavigationIcon(drawableM1982a);
        }
        CharSequence charSequenceM1988c3 = c0263awM1978a.m1988c(C0148a.j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(charSequenceM1988c3)) {
            setNavigationContentDescription(charSequenceM1988c3);
        }
        Drawable drawableM1982a2 = c0263awM1978a.m1982a(C0148a.j.Toolbar_logo);
        if (drawableM1982a2 != null) {
            setLogo(drawableM1982a2);
        }
        CharSequence charSequenceM1988c4 = c0263awM1978a.m1988c(C0148a.j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(charSequenceM1988c4)) {
            setLogoDescription(charSequenceM1988c4);
        }
        if (c0263awM1978a.m1996g(C0148a.j.Toolbar_titleTextColor)) {
            setTitleTextColor(c0263awM1978a.m1985b(C0148a.j.Toolbar_titleTextColor, -1));
        }
        if (c0263awM1978a.m1996g(C0148a.j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(c0263awM1978a.m1985b(C0148a.j.Toolbar_subtitleTextColor, -1));
        }
        c0263awM1978a.m1983a();
    }

    /* JADX INFO: renamed from: a */
    private int m1742a(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.f1593x & 112;
    }

    /* JADX INFO: renamed from: a */
    private int m1743a(View view, int i) {
        C0236b c0236b = (C0236b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int iM1742a = m1742a(c0236b.f902a);
        if (iM1742a == 48) {
            return getPaddingTop() - i2;
        }
        if (iM1742a == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - c0236b.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (iMax < c0236b.topMargin) {
            iMax = c0236b.topMargin;
        } else {
            int i3 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            if (i3 < c0236b.bottomMargin) {
                iMax = Math.max(0, iMax - (c0236b.bottomMargin - i3));
            }
        }
        return paddingTop + iMax;
    }

    /* JADX INFO: renamed from: a */
    private int m1744a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    /* JADX INFO: renamed from: a */
    private int m1745a(View view, int i, int[] iArr, int i2) {
        C0236b c0236b = (C0236b) view.getLayoutParams();
        int i3 = c0236b.leftMargin - iArr[0];
        int iMax = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int iM1743a = m1743a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iM1743a, iMax + measuredWidth, view.getMeasuredHeight() + iM1743a);
        return iMax + measuredWidth + c0236b.rightMargin;
    }

    /* JADX INFO: renamed from: a */
    private int m1746a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = 0;
        int measuredWidth = 0;
        while (i4 < size) {
            View view = list.get(i4);
            C0236b c0236b = (C0236b) view.getLayoutParams();
            int i5 = c0236b.leftMargin - i;
            int i6 = c0236b.rightMargin - i3;
            int iMax = Math.max(0, i5);
            int iMax2 = Math.max(0, i6);
            int iMax3 = Math.max(0, -i5);
            int iMax4 = Math.max(0, -i6);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i4++;
            i3 = iMax4;
            i = iMax3;
        }
        return measuredWidth;
    }

    /* JADX INFO: renamed from: a */
    private void m1747a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    /* JADX INFO: renamed from: a */
    private void m1748a(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        C0236b c0236bGenerateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (C0236b) layoutParams;
        c0236bGenerateDefaultLayoutParams.f1602b = 1;
        if (!z || this.f1571b == null) {
            addView(view, c0236bGenerateDefaultLayoutParams);
        } else {
            view.setLayoutParams(c0236bGenerateDefaultLayoutParams);
            this.f1560F.add(view);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1749a(List<View> list, int i) {
        boolean z = C0124p.m960b(this) == 1;
        int childCount = getChildCount();
        int iM902a = C0112d.m902a(i, C0124p.m960b(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                C0236b c0236b = (C0236b) childAt.getLayoutParams();
                if (c0236b.f1602b == 0 && m1750a(childAt) && m1751b(c0236b.f902a) == iM902a) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            C0236b c0236b2 = (C0236b) childAt2.getLayoutParams();
            if (c0236b2.f1602b == 0 && m1750a(childAt2) && m1751b(c0236b2.f902a) == iM902a) {
                list.add(childAt2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m1750a(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    private int m1751b(int i) {
        int iM960b = C0124p.m960b(this);
        int iM902a = C0112d.m902a(i, iM960b) & 7;
        return (iM902a == 1 || iM902a == 3 || iM902a == 5) ? iM902a : iM960b == 1 ? 5 : 3;
    }

    /* JADX INFO: renamed from: b */
    private int m1752b(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return C0114f.m906a(marginLayoutParams) + C0114f.m907b(marginLayoutParams);
    }

    /* JADX INFO: renamed from: b */
    private int m1753b(View view, int i, int[] iArr, int i2) {
        C0236b c0236b = (C0236b) view.getLayoutParams();
        int i3 = c0236b.rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int iM1743a = m1743a(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iM1743a, iMax, view.getMeasuredHeight() + iM1743a);
        return iMax - (measuredWidth + c0236b.leftMargin);
    }

    /* JADX INFO: renamed from: c */
    private int m1754c(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* JADX INFO: renamed from: d */
    private boolean m1755d(View view) {
        return view.getParent() == this || this.f1560F.contains(view);
    }

    private MenuInflater getMenuInflater() {
        return new C0184g(getContext());
    }

    /* JADX INFO: renamed from: m */
    private void m1756m() {
        if (this.f1578i == null) {
            this.f1578i = new C0286q(getContext());
        }
    }

    /* JADX INFO: renamed from: n */
    private void m1757n() {
        m1758o();
        if (this.f1574e.m1676d() == null) {
            C0196h c0196h = (C0196h) this.f1574e.getMenu();
            if (this.f1565K == null) {
                this.f1565K = new C0235a();
            }
            this.f1574e.setExpandedActionViewsExclusive(true);
            c0196h.m1541a(this.f1565K, this.f1581l);
        }
    }

    /* JADX INFO: renamed from: o */
    private void m1758o() {
        if (this.f1574e == null) {
            this.f1574e = new ActionMenuView(getContext());
            this.f1574e.setPopupTheme(this.f1582m);
            this.f1574e.setOnMenuItemClickListener(this.f1562H);
            this.f1574e.m1669a(this.f1566L, this.f1567M);
            C0236b c0236bGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            c0236bGenerateDefaultLayoutParams.f902a = 8388613 | (this.f1572c & 112);
            this.f1574e.setLayoutParams(c0236bGenerateDefaultLayoutParams);
            m1748a((View) this.f1574e, false);
        }
    }

    /* JADX INFO: renamed from: p */
    private void m1759p() {
        if (this.f1577h == null) {
            this.f1577h = new C0284o(getContext(), null, C0148a.a.toolbarNavigationButtonStyle);
            C0236b c0236bGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            c0236bGenerateDefaultLayoutParams.f902a = 8388611 | (this.f1572c & 112);
            this.f1577h.setLayoutParams(c0236bGenerateDefaultLayoutParams);
        }
    }

    /* JADX INFO: renamed from: q */
    private void m1760q() {
        removeCallbacks(this.f1569O);
        post(this.f1569O);
    }

    /* JADX INFO: renamed from: r */
    private boolean m1761r() {
        if (!this.f1568N) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m1750a(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: s */
    private void m1762s() {
        if (this.f1590u == null) {
            this.f1590u = new C0255ao();
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0236b generateLayoutParams(AttributeSet attributeSet) {
        return new C0236b(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0236b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0236b ? new C0236b((C0236b) layoutParams) : layoutParams instanceof AbstractC0158a.a ? new C0236b((AbstractC0158a.a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0236b((ViewGroup.MarginLayoutParams) layoutParams) : new C0236b(layoutParams);
    }

    /* JADX INFO: renamed from: a */
    public void m1765a(int i, int i2) {
        m1762s();
        this.f1590u.m1933a(i, i2);
    }

    /* JADX INFO: renamed from: a */
    public void m1766a(Context context, int i) {
        this.f1583n = i;
        if (this.f1575f != null) {
            this.f1575f.setTextAppearance(context, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1767a(C0196h c0196h, C0273d c0273d) {
        if (c0196h == null && this.f1574e == null) {
            return;
        }
        m1758o();
        C0196h c0196hM1676d = this.f1574e.m1676d();
        if (c0196hM1676d == c0196h) {
            return;
        }
        if (c0196hM1676d != null) {
            c0196hM1676d.m1551b(this.f1564J);
            c0196hM1676d.m1551b(this.f1565K);
        }
        if (this.f1565K == null) {
            this.f1565K = new C0235a();
        }
        c0273d.m2042d(true);
        if (c0196h != null) {
            c0196h.m1541a(c0273d, this.f1581l);
            c0196h.m1541a(this.f1565K, this.f1581l);
        } else {
            c0273d.mo1469a(this.f1581l, (C0196h) null);
            this.f1565K.mo1469a(this.f1581l, (C0196h) null);
            c0273d.mo1479b(true);
            this.f1565K.mo1479b(true);
        }
        this.f1574e.setPopupTheme(this.f1582m);
        this.f1574e.setPresenter(c0273d);
        this.f1564J = c0273d;
    }

    /* JADX INFO: renamed from: a */
    public void m1768a(InterfaceC0203o.a aVar, C0196h.a aVar2) {
        this.f1566L = aVar;
        this.f1567M = aVar2;
        if (this.f1574e != null) {
            this.f1574e.m1669a(aVar, aVar2);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m1769a() {
        return getVisibility() == 0 && this.f1574e != null && this.f1574e.m1670a();
    }

    /* JADX INFO: renamed from: b */
    public void m1770b(Context context, int i) {
        this.f1584o = i;
        if (this.f1576g != null) {
            this.f1576g.setTextAppearance(context, i);
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m1771b() {
        return this.f1574e != null && this.f1574e.m1679g();
    }

    /* JADX INFO: renamed from: c */
    public boolean m1772c() {
        return this.f1574e != null && this.f1574e.m1680h();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C0236b);
    }

    /* JADX INFO: renamed from: d */
    public boolean m1773d() {
        return this.f1574e != null && this.f1574e.m1677e();
    }

    /* JADX INFO: renamed from: e */
    public boolean m1774e() {
        return this.f1574e != null && this.f1574e.m1678f();
    }

    /* JADX INFO: renamed from: f */
    public void m1775f() {
        if (this.f1574e != null) {
            this.f1574e.m1681i();
        }
    }

    /* JADX INFO: renamed from: g */
    public boolean m1776g() {
        return (this.f1565K == null || this.f1565K.f1600b == null) ? false : true;
    }

    public int getContentInsetEnd() {
        if (this.f1590u != null) {
            return this.f1590u.m1938d();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        return this.f1592w != Integer.MIN_VALUE ? this.f1592w : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        if (this.f1590u != null) {
            return this.f1590u.m1932a();
        }
        return 0;
    }

    public int getContentInsetRight() {
        if (this.f1590u != null) {
            return this.f1590u.m1935b();
        }
        return 0;
    }

    public int getContentInsetStart() {
        if (this.f1590u != null) {
            return this.f1590u.m1937c();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        return this.f1591v != Integer.MIN_VALUE ? this.f1591v : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        C0196h c0196hM1676d;
        return this.f1574e != null && (c0196hM1676d = this.f1574e.m1676d()) != null && c0196hM1676d.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.f1592w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return C0124p.m960b(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return C0124p.m960b(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.f1591v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        if (this.f1578i != null) {
            return this.f1578i.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        if (this.f1578i != null) {
            return this.f1578i.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        m1757n();
        return this.f1574e.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        if (this.f1577h != null) {
            return this.f1577h.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        if (this.f1577h != null) {
            return this.f1577h.getDrawable();
        }
        return null;
    }

    C0273d getOuterActionMenuPresenter() {
        return this.f1564J;
    }

    public Drawable getOverflowIcon() {
        m1757n();
        return this.f1574e.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f1581l;
    }

    public int getPopupTheme() {
        return this.f1582m;
    }

    public CharSequence getSubtitle() {
        return this.f1595z;
    }

    public CharSequence getTitle() {
        return this.f1594y;
    }

    public int getTitleMarginBottom() {
        return this.f1589t;
    }

    public int getTitleMarginEnd() {
        return this.f1587r;
    }

    public int getTitleMarginStart() {
        return this.f1586q;
    }

    public int getTitleMarginTop() {
        return this.f1588s;
    }

    public InterfaceC0245ae getWrapper() {
        if (this.f1563I == null) {
            this.f1563I = new C0264ax(this, true);
        }
        return this.f1563I;
    }

    /* JADX INFO: renamed from: h */
    public void m1777h() {
        C0198j c0198j = this.f1565K == null ? null : this.f1565K.f1600b;
        if (c0198j != null) {
            c0198j.collapseActionView();
        }
    }

    /* JADX INFO: renamed from: i */
    void m1778i() {
        if (this.f1570a == null) {
            this.f1570a = new C0284o(getContext(), null, C0148a.a.toolbarNavigationButtonStyle);
            this.f1570a.setImageDrawable(this.f1579j);
            this.f1570a.setContentDescription(this.f1580k);
            C0236b c0236bGenerateDefaultLayoutParams = generateDefaultLayoutParams();
            c0236bGenerateDefaultLayoutParams.f902a = 8388611 | (this.f1572c & 112);
            c0236bGenerateDefaultLayoutParams.f1602b = 2;
            this.f1570a.setLayoutParams(c0236bGenerateDefaultLayoutParams);
            this.f1570a.setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Toolbar.this.m1777h();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public C0236b generateDefaultLayoutParams() {
        return new C0236b(-2, -2);
    }

    /* JADX INFO: renamed from: k */
    void m1780k() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((C0236b) childAt.getLayoutParams()).f1602b != 2 && childAt != this.f1574e) {
                removeViewAt(childCount);
                this.f1560F.add(childAt);
            }
        }
    }

    /* JADX INFO: renamed from: l */
    void m1781l() {
        for (int size = this.f1560F.size() - 1; size >= 0; size--) {
            addView(this.f1560F.get(size));
        }
        this.f1560F.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.f1569O);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.f1558D = false;
        }
        if (!this.f1558D) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.f1558D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.f1558D = false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02aa A[LOOP:0: B:104:0x02a8->B:105:0x02aa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02cc A[LOOP:1: B:107:0x02ca->B:108:0x02cc, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0306 A[LOOP:2: B:116:0x0304->B:117:0x0306, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iM1745a;
        int iM1753b;
        boolean zM1750a;
        boolean zM1750a2;
        int i5;
        int measuredHeight;
        int i6;
        int i7;
        boolean z2;
        int i8;
        int i9;
        int i10;
        int paddingTop;
        int i11;
        int i12;
        int i13;
        int i14;
        char c;
        int i15;
        int i16;
        int i17;
        int size;
        int iM1745a2;
        int i18;
        int size2;
        int i19;
        int i20;
        int size3;
        boolean z3 = C0124p.m960b(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i21 = width - paddingRight;
        int[] iArr = this.f1561G;
        iArr[1] = 0;
        iArr[0] = 0;
        int iM961c = C0124p.m961c(this);
        int iMin = iM961c >= 0 ? Math.min(iM961c, i4 - i2) : 0;
        if (!m1750a(this.f1577h)) {
            iM1745a = paddingLeft;
        } else {
            if (z3) {
                iM1753b = m1753b(this.f1577h, i21, iArr, iMin);
                iM1745a = paddingLeft;
                if (m1750a(this.f1570a)) {
                    if (z3) {
                        iM1753b = m1753b(this.f1570a, iM1753b, iArr, iMin);
                    } else {
                        iM1745a = m1745a(this.f1570a, iM1745a, iArr, iMin);
                    }
                }
                if (m1750a(this.f1574e)) {
                    if (z3) {
                        iM1745a = m1745a(this.f1574e, iM1745a, iArr, iMin);
                    } else {
                        iM1753b = m1753b(this.f1574e, iM1753b, iArr, iMin);
                    }
                }
                int currentContentInsetLeft = getCurrentContentInsetLeft();
                int currentContentInsetRight = getCurrentContentInsetRight();
                iArr[0] = Math.max(0, currentContentInsetLeft - iM1745a);
                iArr[1] = Math.max(0, currentContentInsetRight - (i21 - iM1753b));
                int iMax = Math.max(iM1745a, currentContentInsetLeft);
                int iMin2 = Math.min(iM1753b, i21 - currentContentInsetRight);
                if (m1750a(this.f1571b)) {
                    if (z3) {
                        iMin2 = m1753b(this.f1571b, iMin2, iArr, iMin);
                    } else {
                        iMax = m1745a(this.f1571b, iMax, iArr, iMin);
                    }
                }
                if (m1750a(this.f1578i)) {
                    if (z3) {
                        iMin2 = m1753b(this.f1578i, iMin2, iArr, iMin);
                    } else {
                        iMax = m1745a(this.f1578i, iMax, iArr, iMin);
                    }
                }
                zM1750a = m1750a(this.f1575f);
                zM1750a2 = m1750a(this.f1576g);
                if (zM1750a) {
                    i5 = paddingRight;
                    measuredHeight = 0;
                } else {
                    C0236b c0236b = (C0236b) this.f1575f.getLayoutParams();
                    i5 = paddingRight;
                    measuredHeight = c0236b.topMargin + this.f1575f.getMeasuredHeight() + c0236b.bottomMargin + 0;
                }
                if (zM1750a2) {
                    i6 = width;
                } else {
                    C0236b c0236b2 = (C0236b) this.f1576g.getLayoutParams();
                    i6 = width;
                    measuredHeight += c0236b2.topMargin + this.f1576g.getMeasuredHeight() + c0236b2.bottomMargin;
                }
                if (!zM1750a || zM1750a2) {
                    TextView textView = !zM1750a ? this.f1575f : this.f1576g;
                    TextView textView2 = !zM1750a2 ? this.f1576g : this.f1575f;
                    C0236b c0236b3 = (C0236b) textView.getLayoutParams();
                    C0236b c0236b4 = (C0236b) textView2.getLayoutParams();
                    if ((zM1750a || this.f1575f.getMeasuredWidth() <= 0) && (!zM1750a2 || this.f1576g.getMeasuredWidth() <= 0)) {
                        i7 = paddingLeft;
                        z2 = false;
                    } else {
                        i7 = paddingLeft;
                        z2 = true;
                    }
                    i8 = this.f1593x & 112;
                    i9 = iMin;
                    if (i8 == 48) {
                        i10 = iMax;
                        paddingTop = getPaddingTop() + c0236b3.topMargin + this.f1588s;
                    } else if (i8 != 80) {
                        int iMax2 = (((height - paddingTop2) - paddingBottom) - measuredHeight) / 2;
                        i10 = iMax;
                        if (iMax2 < c0236b3.topMargin + this.f1588s) {
                            iMax2 = c0236b3.topMargin + this.f1588s;
                        } else {
                            int i22 = (((height - paddingBottom) - measuredHeight) - iMax2) - paddingTop2;
                            if (i22 < c0236b3.bottomMargin + this.f1589t) {
                                iMax2 = Math.max(0, iMax2 - ((c0236b4.bottomMargin + this.f1589t) - i22));
                            }
                        }
                        paddingTop = paddingTop2 + iMax2;
                    } else {
                        i10 = iMax;
                        paddingTop = (((height - paddingBottom) - c0236b4.bottomMargin) - this.f1589t) - measuredHeight;
                    }
                    if (!z3) {
                        if (z2) {
                            i12 = this.f1586q;
                            i11 = 0;
                        } else {
                            i11 = 0;
                            i12 = 0;
                        }
                        int i23 = i12 - iArr[i11];
                        iMax = i10 + Math.max(i11, i23);
                        iArr[i11] = Math.max(i11, -i23);
                        if (zM1750a) {
                            C0236b c0236b5 = (C0236b) this.f1575f.getLayoutParams();
                            int measuredWidth = this.f1575f.getMeasuredWidth() + iMax;
                            int measuredHeight2 = this.f1575f.getMeasuredHeight() + paddingTop;
                            this.f1575f.layout(iMax, paddingTop, measuredWidth, measuredHeight2);
                            i13 = measuredWidth + this.f1587r;
                            paddingTop = measuredHeight2 + c0236b5.bottomMargin;
                        } else {
                            i13 = iMax;
                        }
                        if (zM1750a2) {
                            C0236b c0236b6 = (C0236b) this.f1576g.getLayoutParams();
                            int i24 = paddingTop + c0236b6.topMargin;
                            int measuredWidth2 = this.f1576g.getMeasuredWidth() + iMax;
                            this.f1576g.layout(iMax, i24, measuredWidth2, this.f1576g.getMeasuredHeight() + i24);
                            i14 = measuredWidth2 + this.f1587r;
                            int i25 = c0236b6.bottomMargin;
                        } else {
                            i14 = iMax;
                        }
                        if (z2) {
                            iMax = Math.max(i13, i14);
                        }
                        m1749a(this.f1559E, 3);
                        size = this.f1559E.size();
                        iM1745a2 = iMax;
                        for (i18 = 0; i18 < size; i18++) {
                            iM1745a2 = m1745a(this.f1559E.get(i18), iM1745a2, iArr, i9);
                        }
                        int i26 = i9;
                        m1749a(this.f1559E, 5);
                        size2 = this.f1559E.size();
                        for (i19 = 0; i19 < size2; i19++) {
                            iMin2 = m1753b(this.f1559E.get(i19), iMin2, iArr, i26);
                        }
                        m1749a(this.f1559E, 1);
                        int iM1746a = m1746a(this.f1559E, iArr);
                        i20 = (i7 + (((i6 - i7) - i5) / 2)) - (iM1746a / 2);
                        int i27 = iM1746a + i20;
                        if (i20 >= iM1745a2) {
                            iM1745a2 = i27 > iMin2 ? i20 - (i27 - iMin2) : i20;
                        }
                        size3 = this.f1559E.size();
                        while (i11 < size3) {
                            iM1745a2 = m1745a(this.f1559E.get(i11), iM1745a2, iArr, i26);
                            i11++;
                        }
                        this.f1559E.clear();
                    }
                    if (z2) {
                        i15 = this.f1586q;
                        c = 1;
                    } else {
                        c = 1;
                        i15 = 0;
                    }
                    int i28 = i15 - iArr[c];
                    iMin2 -= Math.max(0, i28);
                    iArr[c] = Math.max(0, -i28);
                    if (zM1750a) {
                        C0236b c0236b7 = (C0236b) this.f1575f.getLayoutParams();
                        int measuredWidth3 = iMin2 - this.f1575f.getMeasuredWidth();
                        int measuredHeight3 = this.f1575f.getMeasuredHeight() + paddingTop;
                        this.f1575f.layout(measuredWidth3, paddingTop, iMin2, measuredHeight3);
                        i16 = measuredWidth3 - this.f1587r;
                        paddingTop = measuredHeight3 + c0236b7.bottomMargin;
                    } else {
                        i16 = iMin2;
                    }
                    if (zM1750a2) {
                        C0236b c0236b8 = (C0236b) this.f1576g.getLayoutParams();
                        int i29 = paddingTop + c0236b8.topMargin;
                        this.f1576g.layout(iMin2 - this.f1576g.getMeasuredWidth(), i29, iMin2, this.f1576g.getMeasuredHeight() + i29);
                        i17 = iMin2 - this.f1587r;
                        int i30 = c0236b8.bottomMargin;
                    } else {
                        i17 = iMin2;
                    }
                    if (z2) {
                        iMin2 = Math.min(i16, i17);
                    }
                    iMax = i10;
                } else {
                    i7 = paddingLeft;
                    i9 = iMin;
                }
                i11 = 0;
                m1749a(this.f1559E, 3);
                size = this.f1559E.size();
                iM1745a2 = iMax;
                while (i18 < size) {
                }
                int i262 = i9;
                m1749a(this.f1559E, 5);
                size2 = this.f1559E.size();
                while (i19 < size2) {
                }
                m1749a(this.f1559E, 1);
                int iM1746a2 = m1746a(this.f1559E, iArr);
                i20 = (i7 + (((i6 - i7) - i5) / 2)) - (iM1746a2 / 2);
                int i272 = iM1746a2 + i20;
                if (i20 >= iM1745a2) {
                }
                size3 = this.f1559E.size();
                while (i11 < size3) {
                }
                this.f1559E.clear();
            }
            iM1745a = m1745a(this.f1577h, paddingLeft, iArr, iMin);
        }
        iM1753b = i21;
        if (m1750a(this.f1570a)) {
        }
        if (m1750a(this.f1574e)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - iM1745a);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i21 - iM1753b));
        int iMax3 = Math.max(iM1745a, currentContentInsetLeft2);
        int iMin22 = Math.min(iM1753b, i21 - currentContentInsetRight2);
        if (m1750a(this.f1571b)) {
        }
        if (m1750a(this.f1578i)) {
        }
        zM1750a = m1750a(this.f1575f);
        zM1750a2 = m1750a(this.f1576g);
        if (zM1750a) {
        }
        if (zM1750a2) {
        }
        if (zM1750a) {
            if (!zM1750a) {
            }
            if (!zM1750a2) {
            }
            C0236b c0236b32 = (C0236b) textView.getLayoutParams();
            C0236b c0236b42 = (C0236b) textView2.getLayoutParams();
            if (zM1750a) {
                i7 = paddingLeft;
                z2 = false;
                i8 = this.f1593x & 112;
                i9 = iMin;
                if (i8 == 48) {
                }
                if (!z3) {
                }
            } else {
                i7 = paddingLeft;
                z2 = false;
                i8 = this.f1593x & 112;
                i9 = iMin;
                if (i8 == 48) {
                }
                if (!z3) {
                }
            }
        }
        m1749a(this.f1559E, 3);
        size = this.f1559E.size();
        iM1745a2 = iMax3;
        while (i18 < size) {
        }
        int i2622 = i9;
        m1749a(this.f1559E, 5);
        size2 = this.f1559E.size();
        while (i19 < size2) {
        }
        m1749a(this.f1559E, 1);
        int iM1746a22 = m1746a(this.f1559E, iArr);
        i20 = (i7 + (((i6 - i7) - i5) / 2)) - (iM1746a22 / 2);
        int i2722 = iM1746a22 + i20;
        if (i20 >= iM1745a2) {
        }
        size3 = this.f1559E.size();
        while (i11 < size3) {
        }
        this.f1559E.clear();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c;
        char c2;
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int iCombineMeasuredStates2;
        int iMax2;
        int measuredHeight;
        int[] iArr = this.f1561G;
        if (C0270bc.m2027a(this)) {
            c = 1;
            c2 = 0;
        } else {
            c = 0;
            c2 = 1;
        }
        if (m1750a(this.f1577h)) {
            m1747a(this.f1577h, i, 0, i2, 0, this.f1585p);
            measuredWidth = this.f1577h.getMeasuredWidth() + m1752b(this.f1577h);
            iMax = Math.max(0, this.f1577h.getMeasuredHeight() + m1754c(this.f1577h));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1577h.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (m1750a(this.f1570a)) {
            m1747a(this.f1570a, i, 0, i2, 0, this.f1585p);
            measuredWidth = this.f1570a.getMeasuredWidth() + m1752b(this.f1570a);
            iMax = Math.max(iMax, this.f1570a.getMeasuredHeight() + m1754c(this.f1570a));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1570a.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth) + 0;
        iArr[c] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (m1750a(this.f1574e)) {
            m1747a(this.f1574e, i, iMax3, i2, 0, this.f1585p);
            measuredWidth2 = this.f1574e.getMeasuredWidth() + m1752b(this.f1574e);
            iMax = Math.max(iMax, this.f1574e.getMeasuredHeight() + m1754c(this.f1574e));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1574e.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[c2] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (m1750a(this.f1571b)) {
            iMax4 += m1744a(this.f1571b, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.f1571b.getMeasuredHeight() + m1754c(this.f1571b));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1571b.getMeasuredState());
        }
        if (m1750a(this.f1578i)) {
            iMax4 += m1744a(this.f1578i, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.f1578i.getMeasuredHeight() + m1754c(this.f1578i));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1578i.getMeasuredState());
        }
        int childCount = getChildCount();
        int iMax5 = iMax;
        int iM1744a = iMax4;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (((C0236b) childAt.getLayoutParams()).f1602b == 0 && m1750a(childAt)) {
                iM1744a += m1744a(childAt, i, iM1744a, i2, 0, iArr);
                iMax5 = Math.max(iMax5, childAt.getMeasuredHeight() + m1754c(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i4 = this.f1588s + this.f1589t;
        int i5 = this.f1586q + this.f1587r;
        if (m1750a(this.f1575f)) {
            m1744a(this.f1575f, i, iM1744a + i5, i2, i4, iArr);
            int measuredWidth3 = this.f1575f.getMeasuredWidth() + m1752b(this.f1575f);
            measuredHeight = this.f1575f.getMeasuredHeight() + m1754c(this.f1575f);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1575f.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            measuredHeight = 0;
        }
        if (m1750a(this.f1576g)) {
            iMax2 = Math.max(iMax2, m1744a(this.f1576g, i, iM1744a + i5, i2, measuredHeight + i4, iArr));
            measuredHeight += this.f1576g.getMeasuredHeight() + m1754c(this.f1576g);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f1576g.getMeasuredState());
        }
        int iMax6 = Math.max(iMax5, measuredHeight);
        int paddingLeft = iM1744a + iMax2 + getPaddingLeft() + getPaddingRight();
        int paddingTop = iMax6 + getPaddingTop() + getPaddingBottom();
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16);
        if (m1761r()) {
            iResolveSizeAndState2 = 0;
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof C0238d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0238d c0238d = (C0238d) parcelable;
        super.onRestoreInstanceState(c0238d.m841a());
        C0196h c0196hM1676d = this.f1574e != null ? this.f1574e.m1676d() : null;
        if (c0238d.f1603b != 0 && this.f1565K != null && c0196hM1676d != null && (menuItemFindItem = c0196hM1676d.findItem(c0238d.f1603b)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (c0238d.f1604c) {
            m1760q();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        m1762s();
        this.f1590u.m1934a(i == 1);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        C0238d c0238d = new C0238d(super.onSaveInstanceState());
        if (this.f1565K != null && this.f1565K.f1600b != null) {
            c0238d.f1603b = this.f1565K.f1600b.getItemId();
        }
        c0238d.f1604c = m1771b();
        return c0238d;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f1557C = false;
        }
        if (!this.f1557C) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.f1557C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.f1557C = false;
        }
        return true;
    }

    public void setCollapsible(boolean z) {
        this.f1568N = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f1592w) {
            this.f1592w = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.f1591v) {
            this.f1591v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(C0175b.m1396b(getContext(), i));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            m1756m();
            if (!m1755d(this.f1578i)) {
                m1748a((View) this.f1578i, true);
            }
        } else if (this.f1578i != null && m1755d(this.f1578i)) {
            removeView(this.f1578i);
            this.f1560F.remove(this.f1578i);
        }
        if (this.f1578i != null) {
            this.f1578i.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m1756m();
        }
        if (this.f1578i != null) {
            this.f1578i.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            m1759p();
        }
        if (this.f1577h != null) {
            this.f1577h.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(C0175b.m1396b(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            m1759p();
            if (!m1755d(this.f1577h)) {
                m1748a((View) this.f1577h, true);
            }
        } else if (this.f1577h != null && m1755d(this.f1577h)) {
            removeView(this.f1577h);
            this.f1560F.remove(this.f1577h);
        }
        if (this.f1577h != null) {
            this.f1577h.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        m1759p();
        this.f1577h.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(InterfaceC0237c interfaceC0237c) {
        this.f1573d = interfaceC0237c;
    }

    public void setOverflowIcon(Drawable drawable) {
        m1757n();
        this.f1574e.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.f1582m != i) {
            this.f1582m = i;
            if (i == 0) {
                this.f1581l = getContext();
            } else {
                this.f1581l = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1576g == null) {
                Context context = getContext();
                this.f1576g = new C0242ab(context);
                this.f1576g.setSingleLine();
                this.f1576g.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f1584o != 0) {
                    this.f1576g.setTextAppearance(context, this.f1584o);
                }
                if (this.f1556B != 0) {
                    this.f1576g.setTextColor(this.f1556B);
                }
            }
            if (!m1755d(this.f1576g)) {
                m1748a((View) this.f1576g, true);
            }
        } else if (this.f1576g != null && m1755d(this.f1576g)) {
            removeView(this.f1576g);
            this.f1560F.remove(this.f1576g);
        }
        if (this.f1576g != null) {
            this.f1576g.setText(charSequence);
        }
        this.f1595z = charSequence;
    }

    public void setSubtitleTextColor(int i) {
        this.f1556B = i;
        if (this.f1576g != null) {
            this.f1576g.setTextColor(i);
        }
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1575f == null) {
                Context context = getContext();
                this.f1575f = new C0242ab(context);
                this.f1575f.setSingleLine();
                this.f1575f.setEllipsize(TextUtils.TruncateAt.END);
                if (this.f1583n != 0) {
                    this.f1575f.setTextAppearance(context, this.f1583n);
                }
                if (this.f1555A != 0) {
                    this.f1575f.setTextColor(this.f1555A);
                }
            }
            if (!m1755d(this.f1575f)) {
                m1748a((View) this.f1575f, true);
            }
        } else if (this.f1575f != null && m1755d(this.f1575f)) {
            removeView(this.f1575f);
            this.f1560F.remove(this.f1575f);
        }
        if (this.f1575f != null) {
            this.f1575f.setText(charSequence);
        }
        this.f1594y = charSequence;
    }

    public void setTitleMarginBottom(int i) {
        this.f1589t = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.f1587r = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.f1586q = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.f1588s = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        this.f1555A = i;
        if (this.f1575f != null) {
            this.f1575f.setTextColor(i);
        }
    }
}
