package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.p015g.C0124p;
import android.support.v4.widget.C0144j;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.menu.InterfaceC0207s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: android.support.v7.widget.ak */
/* JADX INFO: loaded from: classes.dex */
public class C0251ak implements InterfaceC0207s {

    /* JADX INFO: renamed from: a */
    private static Method f1683a;

    /* JADX INFO: renamed from: b */
    private static Method f1684b;

    /* JADX INFO: renamed from: h */
    private static Method f1685h;

    /* JADX INFO: renamed from: A */
    private Drawable f1686A;

    /* JADX INFO: renamed from: B */
    private AdapterView.OnItemClickListener f1687B;

    /* JADX INFO: renamed from: C */
    private AdapterView.OnItemSelectedListener f1688C;

    /* JADX INFO: renamed from: D */
    private final d f1689D;

    /* JADX INFO: renamed from: E */
    private final c f1690E;

    /* JADX INFO: renamed from: F */
    private final a f1691F;

    /* JADX INFO: renamed from: G */
    private Runnable f1692G;

    /* JADX INFO: renamed from: H */
    private final Rect f1693H;

    /* JADX INFO: renamed from: I */
    private Rect f1694I;

    /* JADX INFO: renamed from: J */
    private boolean f1695J;

    /* JADX INFO: renamed from: c */
    C0247ag f1696c;

    /* JADX INFO: renamed from: d */
    int f1697d;

    /* JADX INFO: renamed from: e */
    final e f1698e;

    /* JADX INFO: renamed from: f */
    final Handler f1699f;

    /* JADX INFO: renamed from: g */
    PopupWindow f1700g;

    /* JADX INFO: renamed from: i */
    private Context f1701i;

    /* JADX INFO: renamed from: j */
    private ListAdapter f1702j;

    /* JADX INFO: renamed from: k */
    private int f1703k;

    /* JADX INFO: renamed from: l */
    private int f1704l;

    /* JADX INFO: renamed from: m */
    private int f1705m;

    /* JADX INFO: renamed from: n */
    private int f1706n;

    /* JADX INFO: renamed from: o */
    private int f1707o;

    /* JADX INFO: renamed from: p */
    private boolean f1708p;

    /* JADX INFO: renamed from: q */
    private boolean f1709q;

    /* JADX INFO: renamed from: r */
    private boolean f1710r;

    /* JADX INFO: renamed from: s */
    private boolean f1711s;

    /* JADX INFO: renamed from: t */
    private int f1712t;

    /* JADX INFO: renamed from: u */
    private boolean f1713u;

    /* JADX INFO: renamed from: v */
    private boolean f1714v;

    /* JADX INFO: renamed from: w */
    private View f1715w;

    /* JADX INFO: renamed from: x */
    private int f1716x;

    /* JADX INFO: renamed from: y */
    private DataSetObserver f1717y;

    /* JADX INFO: renamed from: z */
    private View f1718z;

    /* JADX INFO: renamed from: android.support.v7.widget.ak$a */
    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0251ak.this.m1926m();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ak$b */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (C0251ak.this.mo1507d()) {
                C0251ak.this.mo1497a();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            C0251ak.this.mo1504c();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ak$c */
    private class c implements AbsListView.OnScrollListener {
        c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || C0251ak.this.m1927n() || C0251ak.this.f1700g.getContentView() == null) {
                return;
            }
            C0251ak.this.f1699f.removeCallbacks(C0251ak.this.f1698e);
            C0251ak.this.f1698e.run();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ak$d */
    private class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && C0251ak.this.f1700g != null && C0251ak.this.f1700g.isShowing() && x >= 0 && x < C0251ak.this.f1700g.getWidth() && y >= 0 && y < C0251ak.this.f1700g.getHeight()) {
                C0251ak.this.f1699f.postDelayed(C0251ak.this.f1698e, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            C0251ak.this.f1699f.removeCallbacks(C0251ak.this.f1698e);
            return false;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ak$e */
    private class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0251ak.this.f1696c == null || !C0124p.m971m(C0251ak.this.f1696c) || C0251ak.this.f1696c.getCount() <= C0251ak.this.f1696c.getChildCount() || C0251ak.this.f1696c.getChildCount() > C0251ak.this.f1697d) {
                return;
            }
            C0251ak.this.f1700g.setInputMethodMode(2);
            C0251ak.this.mo1497a();
        }
    }

    static {
        try {
            f1683a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f1684b = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, Boolean.TYPE);
        } catch (NoSuchMethodException unused2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
        try {
            f1685h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
        } catch (NoSuchMethodException unused3) {
            Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
        }
    }

    public C0251ak(Context context) {
        this(context, null, C0148a.a.listPopupWindowStyle);
    }

    public C0251ak(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public C0251ak(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f1703k = -2;
        this.f1704l = -2;
        this.f1707o = 1002;
        this.f1709q = true;
        this.f1712t = 0;
        this.f1713u = false;
        this.f1714v = false;
        this.f1697d = Integer.MAX_VALUE;
        this.f1716x = 0;
        this.f1698e = new e();
        this.f1689D = new d();
        this.f1690E = new c();
        this.f1691F = new a();
        this.f1693H = new Rect();
        this.f1701i = context;
        this.f1699f = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0148a.j.ListPopupWindow, i, i2);
        this.f1705m = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C0148a.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f1706n = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C0148a.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f1706n != 0) {
            this.f1708p = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        this.f1700g = new C0288s(context, attributeSet, i, i2);
        this.f1700g.setInputMethodMode(1);
    }

    /* JADX INFO: renamed from: a */
    private int m1898a(View view, int i, boolean z) {
        if (f1684b != null) {
            try {
                return ((Integer) f1684b.invoke(this.f1700g, view, Integer.valueOf(i), Boolean.valueOf(z))).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f1700g.getMaxAvailableHeight(view, i);
    }

    /* JADX INFO: renamed from: b */
    private void m1899b() {
        if (this.f1715w != null) {
            ViewParent parent = this.f1715w.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1715w);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m1900c(boolean z) {
        if (f1683a != null) {
            try {
                f1683a.invoke(this.f1700g, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    /* JADX INFO: renamed from: f */
    private int m1901f() {
        int measuredHeight;
        int i;
        int iMakeMeasureSpec;
        int i2;
        View view;
        int i3;
        int i4;
        if (this.f1696c == null) {
            Context context = this.f1701i;
            this.f1692G = new Runnable() { // from class: android.support.v7.widget.ak.1
                @Override // java.lang.Runnable
                public void run() {
                    View viewM1921i = C0251ak.this.m1921i();
                    if (viewM1921i == null || viewM1921i.getWindowToken() == null) {
                        return;
                    }
                    C0251ak.this.mo1497a();
                }
            };
            this.f1696c = mo1902a(context, !this.f1695J);
            if (this.f1686A != null) {
                this.f1696c.setSelector(this.f1686A);
            }
            this.f1696c.setAdapter(this.f1702j);
            this.f1696c.setOnItemClickListener(this.f1687B);
            this.f1696c.setFocusable(true);
            this.f1696c.setFocusableInTouchMode(true);
            this.f1696c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.ak.2
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view2, int i5, long j) {
                    C0247ag c0247ag;
                    if (i5 == -1 || (c0247ag = C0251ak.this.f1696c) == null) {
                        return;
                    }
                    c0247ag.setListSelectionHidden(false);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
            this.f1696c.setOnScrollListener(this.f1690E);
            if (this.f1688C != null) {
                this.f1696c.setOnItemSelectedListener(this.f1688C);
            }
            C0247ag c0247ag = this.f1696c;
            View view2 = this.f1715w;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                switch (this.f1716x) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(c0247ag, layoutParams);
                        break;
                    case 1:
                        linearLayout.addView(c0247ag, layoutParams);
                        linearLayout.addView(view2);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f1716x);
                        break;
                }
                if (this.f1704l >= 0) {
                    i3 = this.f1704l;
                    i4 = Integer.MIN_VALUE;
                } else {
                    i3 = 0;
                    i4 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i3, i4), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = c0247ag;
            }
            this.f1700g.setContentView(view);
        } else {
            View view3 = this.f1715w;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f1700g.getBackground();
        if (background != null) {
            background.getPadding(this.f1693H);
            i = this.f1693H.top + this.f1693H.bottom;
            if (!this.f1708p) {
                this.f1706n = -this.f1693H.top;
            }
        } else {
            this.f1693H.setEmpty();
            i = 0;
        }
        int iM1898a = m1898a(m1921i(), this.f1706n, this.f1700g.getInputMethodMode() == 2);
        if (this.f1713u || this.f1703k == -1) {
            return iM1898a + i;
        }
        switch (this.f1704l) {
            case -2:
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1701i.getResources().getDisplayMetrics().widthPixels - (this.f1693H.left + this.f1693H.right), Integer.MIN_VALUE);
                break;
            case -1:
                i2 = this.f1701i.getResources().getDisplayMetrics().widthPixels - (this.f1693H.left + this.f1693H.right);
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
                break;
            default:
                i2 = this.f1704l;
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
                break;
        }
        int iMo1867a = this.f1696c.mo1867a(iMakeMeasureSpec, 0, -1, iM1898a - measuredHeight, -1);
        if (iMo1867a > 0) {
            measuredHeight += i + this.f1696c.getPaddingTop() + this.f1696c.getPaddingBottom();
        }
        return iMo1867a + measuredHeight;
    }

    /* JADX INFO: renamed from: a */
    C0247ag mo1902a(Context context, boolean z) {
        return new C0247ag(context, z);
    }

    @Override // android.support.v7.view.menu.InterfaceC0207s
    /* JADX INFO: renamed from: a */
    public void mo1497a() {
        int iM1901f = m1901f();
        boolean zM1927n = m1927n();
        C0144j.m1135a(this.f1700g, this.f1707o);
        if (this.f1700g.isShowing()) {
            if (C0124p.m971m(m1921i())) {
                int width = this.f1704l == -1 ? -1 : this.f1704l == -2 ? m1921i().getWidth() : this.f1704l;
                if (this.f1703k == -1) {
                    if (!zM1927n) {
                        iM1901f = -1;
                    }
                    if (zM1927n) {
                        this.f1700g.setWidth(this.f1704l == -1 ? -1 : 0);
                        this.f1700g.setHeight(0);
                    } else {
                        this.f1700g.setWidth(this.f1704l == -1 ? -1 : 0);
                        this.f1700g.setHeight(-1);
                    }
                } else if (this.f1703k != -2) {
                    iM1901f = this.f1703k;
                }
                this.f1700g.setOutsideTouchable((this.f1714v || this.f1713u) ? false : true);
                this.f1700g.update(m1921i(), this.f1705m, this.f1706n, width < 0 ? -1 : width, iM1901f < 0 ? -1 : iM1901f);
                return;
            }
            return;
        }
        int width2 = this.f1704l == -1 ? -1 : this.f1704l == -2 ? m1921i().getWidth() : this.f1704l;
        if (this.f1703k == -1) {
            iM1901f = -1;
        } else if (this.f1703k != -2) {
            iM1901f = this.f1703k;
        }
        this.f1700g.setWidth(width2);
        this.f1700g.setHeight(iM1901f);
        m1900c(true);
        this.f1700g.setOutsideTouchable((this.f1714v || this.f1713u) ? false : true);
        this.f1700g.setTouchInterceptor(this.f1689D);
        if (this.f1711s) {
            C0144j.m1137a(this.f1700g, this.f1710r);
        }
        if (f1685h != null) {
            try {
                f1685h.invoke(this.f1700g, this.f1694I);
            } catch (Exception e2) {
                Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
            }
        }
        C0144j.m1136a(this.f1700g, m1921i(), this.f1705m, this.f1706n, this.f1712t);
        this.f1696c.setSelection(-1);
        if (!this.f1695J || this.f1696c.isInTouchMode()) {
            m1926m();
        }
        if (this.f1695J) {
            return;
        }
        this.f1699f.post(this.f1691F);
    }

    /* JADX INFO: renamed from: a */
    public void m1903a(int i) {
        this.f1716x = i;
    }

    /* JADX INFO: renamed from: a */
    public void m1904a(Rect rect) {
        this.f1694I = rect;
    }

    /* JADX INFO: renamed from: a */
    public void m1905a(Drawable drawable) {
        this.f1700g.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: renamed from: a */
    public void m1906a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f1687B = onItemClickListener;
    }

    /* JADX INFO: renamed from: a */
    public void mo1907a(ListAdapter listAdapter) {
        if (this.f1717y == null) {
            this.f1717y = new b();
        } else if (this.f1702j != null) {
            this.f1702j.unregisterDataSetObserver(this.f1717y);
        }
        this.f1702j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1717y);
        }
        if (this.f1696c != null) {
            this.f1696c.setAdapter(this.f1702j);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1908a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1700g.setOnDismissListener(onDismissListener);
    }

    /* JADX INFO: renamed from: a */
    public void m1909a(boolean z) {
        this.f1695J = z;
        this.f1700g.setFocusable(z);
    }

    /* JADX INFO: renamed from: b */
    public void m1910b(int i) {
        this.f1700g.setAnimationStyle(i);
    }

    /* JADX INFO: renamed from: b */
    public void m1911b(View view) {
        this.f1718z = view;
    }

    /* JADX INFO: renamed from: b */
    public void m1912b(boolean z) {
        this.f1711s = true;
        this.f1710r = z;
    }

    @Override // android.support.v7.view.menu.InterfaceC0207s
    /* JADX INFO: renamed from: c */
    public void mo1504c() {
        this.f1700g.dismiss();
        m1899b();
        this.f1700g.setContentView(null);
        this.f1696c = null;
        this.f1699f.removeCallbacks(this.f1698e);
    }

    /* JADX INFO: renamed from: c */
    public void m1913c(int i) {
        this.f1705m = i;
    }

    /* JADX INFO: renamed from: d */
    public void m1914d(int i) {
        this.f1706n = i;
        this.f1708p = true;
    }

    @Override // android.support.v7.view.menu.InterfaceC0207s
    /* JADX INFO: renamed from: d */
    public boolean mo1507d() {
        return this.f1700g.isShowing();
    }

    @Override // android.support.v7.view.menu.InterfaceC0207s
    /* JADX INFO: renamed from: e */
    public ListView mo1508e() {
        return this.f1696c;
    }

    /* JADX INFO: renamed from: e */
    public void m1915e(int i) {
        this.f1712t = i;
    }

    /* JADX INFO: renamed from: f */
    public void m1916f(int i) {
        this.f1704l = i;
    }

    /* JADX INFO: renamed from: g */
    public void m1917g(int i) {
        Drawable background = this.f1700g.getBackground();
        if (background == null) {
            m1916f(i);
        } else {
            background.getPadding(this.f1693H);
            this.f1704l = this.f1693H.left + this.f1693H.right + i;
        }
    }

    /* JADX INFO: renamed from: g */
    public boolean m1918g() {
        return this.f1695J;
    }

    /* JADX INFO: renamed from: h */
    public Drawable m1919h() {
        return this.f1700g.getBackground();
    }

    /* JADX INFO: renamed from: h */
    public void m1920h(int i) {
        this.f1700g.setInputMethodMode(i);
    }

    /* JADX INFO: renamed from: i */
    public View m1921i() {
        return this.f1718z;
    }

    /* JADX INFO: renamed from: i */
    public void m1922i(int i) {
        C0247ag c0247ag = this.f1696c;
        if (!mo1507d() || c0247ag == null) {
            return;
        }
        c0247ag.setListSelectionHidden(false);
        c0247ag.setSelection(i);
        if (c0247ag.getChoiceMode() != 0) {
            c0247ag.setItemChecked(i, true);
        }
    }

    /* JADX INFO: renamed from: j */
    public int m1923j() {
        return this.f1705m;
    }

    /* JADX INFO: renamed from: k */
    public int m1924k() {
        if (this.f1708p) {
            return this.f1706n;
        }
        return 0;
    }

    /* JADX INFO: renamed from: l */
    public int m1925l() {
        return this.f1704l;
    }

    /* JADX INFO: renamed from: m */
    public void m1926m() {
        C0247ag c0247ag = this.f1696c;
        if (c0247ag != null) {
            c0247ag.setListSelectionHidden(true);
            c0247ag.requestLayout();
        }
    }

    /* JADX INFO: renamed from: n */
    public boolean m1927n() {
        return this.f1700g.getInputMethodMode() == 2;
    }
}
