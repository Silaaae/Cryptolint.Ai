package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p008b.p009a.C0070a;
import android.support.v4.p015g.AbstractC0111c;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.C0178a;
import android.support.v7.view.menu.AbstractC0190b;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0196h;
import android.support.v7.view.menu.C0198j;
import android.support.v7.view.menu.C0202n;
import android.support.v7.view.menu.InterfaceC0203o;
import android.support.v7.view.menu.InterfaceC0204p;
import android.support.v7.view.menu.InterfaceC0207s;
import android.support.v7.view.menu.SubMenuC0209u;
import android.support.v7.widget.ActionMenuView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: renamed from: android.support.v7.widget.d */
/* JADX INFO: loaded from: classes.dex */
class C0273d extends AbstractC0190b implements AbstractC0111c.a {

    /* JADX INFO: renamed from: A */
    private b f1847A;

    /* JADX INFO: renamed from: g */
    d f1848g;

    /* JADX INFO: renamed from: h */
    e f1849h;

    /* JADX INFO: renamed from: i */
    a f1850i;

    /* JADX INFO: renamed from: j */
    c f1851j;

    /* JADX INFO: renamed from: k */
    final f f1852k;

    /* JADX INFO: renamed from: l */
    int f1853l;

    /* JADX INFO: renamed from: m */
    private Drawable f1854m;

    /* JADX INFO: renamed from: n */
    private boolean f1855n;

    /* JADX INFO: renamed from: o */
    private boolean f1856o;

    /* JADX INFO: renamed from: p */
    private boolean f1857p;

    /* JADX INFO: renamed from: q */
    private int f1858q;

    /* JADX INFO: renamed from: r */
    private int f1859r;

    /* JADX INFO: renamed from: s */
    private int f1860s;

    /* JADX INFO: renamed from: t */
    private boolean f1861t;

    /* JADX INFO: renamed from: u */
    private boolean f1862u;

    /* JADX INFO: renamed from: v */
    private boolean f1863v;

    /* JADX INFO: renamed from: w */
    private boolean f1864w;

    /* JADX INFO: renamed from: x */
    private int f1865x;

    /* JADX INFO: renamed from: y */
    private final SparseBooleanArray f1866y;

    /* JADX INFO: renamed from: z */
    private View f1867z;

    /* JADX INFO: renamed from: android.support.v7.widget.d$a */
    private class a extends C0202n {
        public a(Context context, SubMenuC0209u subMenuC0209u, View view) {
            super(context, subMenuC0209u, view, false, C0148a.a.actionOverflowMenuStyle);
            if (!((C0198j) subMenuC0209u.getItem()).m1598j()) {
                m1616a(C0273d.this.f1848g == null ? (View) C0273d.this.f1213f : C0273d.this.f1848g);
            }
            m1615a(C0273d.this.f1852k);
        }

        @Override // android.support.v7.view.menu.C0202n
        /* JADX INFO: renamed from: e */
        protected void mo1623e() {
            C0273d.this.f1850i = null;
            C0273d.this.f1853l = 0;
            super.mo1623e();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.d$b */
    private class b extends ActionMenuItemView.AbstractC0188b {
        b() {
        }

        @Override // android.support.v7.view.menu.ActionMenuItemView.AbstractC0188b
        /* JADX INFO: renamed from: a */
        public InterfaceC0207s mo1454a() {
            if (C0273d.this.f1850i != null) {
                return C0273d.this.f1850i.m1620b();
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.d$c */
    private class c implements Runnable {

        /* JADX INFO: renamed from: b */
        private e f1871b;

        public c(e eVar) {
            this.f1871b = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0273d.this.f1210c != null) {
                C0273d.this.f1210c.m1563f();
            }
            View view = (View) C0273d.this.f1213f;
            if (view != null && view.getWindowToken() != null && this.f1871b.m1621c()) {
                C0273d.this.f1849h = this.f1871b;
            }
            C0273d.this.f1851j = null;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.d$d */
    private class d extends C0286q implements ActionMenuView.InterfaceC0217a {

        /* JADX INFO: renamed from: b */
        private final float[] f1873b;

        public d(Context context) {
            super(context, null, C0148a.a.actionOverflowButtonStyle);
            this.f1873b = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            C0265ay.m2010a(this, getContentDescription());
            setOnTouchListener(new AbstractViewOnAttachStateChangeListenerC0249ai(this) { // from class: android.support.v7.widget.d.d.1
                @Override // android.support.v7.widget.AbstractViewOnAttachStateChangeListenerC0249ai
                /* JADX INFO: renamed from: a */
                public InterfaceC0207s mo1452a() {
                    if (C0273d.this.f1849h == null) {
                        return null;
                    }
                    return C0273d.this.f1849h.m1620b();
                }

                @Override // android.support.v7.widget.AbstractViewOnAttachStateChangeListenerC0249ai
                /* JADX INFO: renamed from: b */
                public boolean mo1453b() {
                    C0273d.this.m2043d();
                    return true;
                }

                @Override // android.support.v7.widget.AbstractViewOnAttachStateChangeListenerC0249ai
                /* JADX INFO: renamed from: c */
                public boolean mo1878c() {
                    if (C0273d.this.f1851j != null) {
                        return false;
                    }
                    C0273d.this.m2044e();
                    return true;
                }
            });
        }

        @Override // android.support.v7.widget.ActionMenuView.InterfaceC0217a
        /* JADX INFO: renamed from: c */
        public boolean mo1450c() {
            return false;
        }

        @Override // android.support.v7.widget.ActionMenuView.InterfaceC0217a
        /* JADX INFO: renamed from: d */
        public boolean mo1451d() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            C0273d.this.m2043d();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C0070a.m647a(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.d$e */
    private class e extends C0202n {
        public e(Context context, C0196h c0196h, View view, boolean z) {
            super(context, c0196h, view, z, C0148a.a.actionOverflowMenuStyle);
            m1614a(8388613);
            m1615a(C0273d.this.f1852k);
        }

        @Override // android.support.v7.view.menu.C0202n
        /* JADX INFO: renamed from: e */
        protected void mo1623e() {
            if (C0273d.this.f1210c != null) {
                C0273d.this.f1210c.close();
            }
            C0273d.this.f1849h = null;
            super.mo1623e();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.d$f */
    private class f implements InterfaceC0203o.a {
        f() {
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o.a
        /* JADX INFO: renamed from: a */
        public void mo1324a(C0196h c0196h, boolean z) {
            if (c0196h instanceof SubMenuC0209u) {
                c0196h.mo1573p().m1544a(false);
            }
            InterfaceC0203o.a aVarA = C0273d.this.m1465a();
            if (aVarA != null) {
                aVarA.mo1324a(c0196h, z);
            }
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o.a
        /* JADX INFO: renamed from: a */
        public boolean mo1325a(C0196h c0196h) {
            if (c0196h == null) {
                return false;
            }
            C0273d.this.f1853l = ((SubMenuC0209u) c0196h).getItem().getItemId();
            InterfaceC0203o.a aVarA = C0273d.this.m1465a();
            if (aVarA != null) {
                return aVarA.mo1325a(c0196h);
            }
            return false;
        }
    }

    public C0273d(Context context) {
        super(context, C0148a.g.abc_action_menu_layout, C0148a.g.abc_action_menu_item_layout);
        this.f1866y = new SparseBooleanArray();
        this.f1852k = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private View m2031a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f1213f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof InterfaceC0204p.a) && ((InterfaceC0204p.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.support.v7.view.menu.AbstractC0190b
    /* JADX INFO: renamed from: a */
    public InterfaceC0204p mo1466a(ViewGroup viewGroup) {
        InterfaceC0204p interfaceC0204p = this.f1213f;
        InterfaceC0204p interfaceC0204pMo1466a = super.mo1466a(viewGroup);
        if (interfaceC0204p != interfaceC0204pMo1466a) {
            ((ActionMenuView) interfaceC0204pMo1466a).setPresenter(this);
        }
        return interfaceC0204pMo1466a;
    }

    @Override // android.support.v7.view.menu.AbstractC0190b
    /* JADX INFO: renamed from: a */
    public View mo1467a(C0198j c0198j, View view, ViewGroup viewGroup) {
        View actionView = c0198j.getActionView();
        if (actionView == null || c0198j.m1602n()) {
            actionView = super.mo1467a(c0198j, view, viewGroup);
        }
        actionView.setVisibility(c0198j.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // android.support.v7.view.menu.AbstractC0190b, android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public void mo1469a(Context context, C0196h c0196h) {
        super.mo1469a(context, c0196h);
        Resources resources = context.getResources();
        C0178a c0178aM1405a = C0178a.m1405a(context);
        if (!this.f1857p) {
            this.f1856o = c0178aM1405a.m1407b();
        }
        if (!this.f1863v) {
            this.f1858q = c0178aM1405a.m1408c();
        }
        if (!this.f1861t) {
            this.f1860s = c0178aM1405a.m1406a();
        }
        int measuredWidth = this.f1858q;
        if (this.f1856o) {
            if (this.f1848g == null) {
                this.f1848g = new d(this.f1208a);
                if (this.f1855n) {
                    this.f1848g.setImageDrawable(this.f1854m);
                    this.f1854m = null;
                    this.f1855n = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f1848g.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f1848g.getMeasuredWidth();
        } else {
            this.f1848g = null;
        }
        this.f1859r = measuredWidth;
        this.f1865x = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.f1867z = null;
    }

    /* JADX INFO: renamed from: a */
    public void m2037a(Configuration configuration) {
        if (!this.f1861t) {
            this.f1860s = C0178a.m1405a(this.f1209b).m1406a();
        }
        if (this.f1210c != null) {
            this.f1210c.m1552b(true);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2038a(Drawable drawable) {
        if (this.f1848g != null) {
            this.f1848g.setImageDrawable(drawable);
        } else {
            this.f1855n = true;
            this.f1854m = drawable;
        }
    }

    @Override // android.support.v7.view.menu.AbstractC0190b, android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public void mo1470a(C0196h c0196h, boolean z) {
        m2045f();
        super.mo1470a(c0196h, z);
    }

    @Override // android.support.v7.view.menu.AbstractC0190b
    /* JADX INFO: renamed from: a */
    public void mo1471a(C0198j c0198j, InterfaceC0204p.a aVar) {
        aVar.mo1447a(c0198j, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f1213f);
        if (this.f1847A == null) {
            this.f1847A = new b();
        }
        actionMenuItemView.setPopupCallback(this.f1847A);
    }

    /* JADX INFO: renamed from: a */
    public void m2039a(ActionMenuView actionMenuView) {
        this.f1213f = actionMenuView;
        actionMenuView.mo1455a(this.f1210c);
    }

    @Override // android.support.v4.p015g.AbstractC0111c.a
    /* JADX INFO: renamed from: a */
    public void mo900a(boolean z) {
        if (z) {
            super.mo1476a((SubMenuC0209u) null);
        } else if (this.f1210c != null) {
            this.f1210c.m1544a(false);
        }
    }

    @Override // android.support.v7.view.menu.AbstractC0190b
    /* JADX INFO: renamed from: a */
    public boolean mo1474a(int i, C0198j c0198j) {
        return c0198j.m1598j();
    }

    @Override // android.support.v7.view.menu.AbstractC0190b, android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public boolean mo1476a(SubMenuC0209u subMenuC0209u) {
        boolean z = false;
        if (!subMenuC0209u.hasVisibleItems()) {
            return false;
        }
        SubMenuC0209u subMenuC0209u2 = subMenuC0209u;
        while (subMenuC0209u2.m1632s() != this.f1210c) {
            subMenuC0209u2 = (SubMenuC0209u) subMenuC0209u2.m1632s();
        }
        View viewM2031a = m2031a(subMenuC0209u2.getItem());
        if (viewM2031a == null) {
            return false;
        }
        this.f1853l = subMenuC0209u.getItem().getItemId();
        int size = subMenuC0209u.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = subMenuC0209u.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.f1850i = new a(this.f1209b, subMenuC0209u, viewM2031a);
        this.f1850i.m1618a(z);
        this.f1850i.m1613a();
        super.mo1476a(subMenuC0209u);
        return true;
    }

    @Override // android.support.v7.view.menu.AbstractC0190b
    /* JADX INFO: renamed from: a */
    public boolean mo1477a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f1848g) {
            return false;
        }
        return super.mo1477a(viewGroup, i);
    }

    @Override // android.support.v7.view.menu.AbstractC0190b, android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: b */
    public void mo1479b(boolean z) {
        super.mo1479b(z);
        ((View) this.f1213f).requestLayout();
        boolean z2 = false;
        if (this.f1210c != null) {
            ArrayList<C0198j> arrayListM1568k = this.f1210c.m1568k();
            int size = arrayListM1568k.size();
            for (int i = 0; i < size; i++) {
                AbstractC0111c abstractC0111cMo718a = arrayListM1568k.get(i).mo718a();
                if (abstractC0111cMo718a != null) {
                    abstractC0111cMo718a.m891a(this);
                }
            }
        }
        ArrayList<C0198j> arrayListM1569l = this.f1210c != null ? this.f1210c.m1569l() : null;
        if (this.f1856o && arrayListM1569l != null) {
            int size2 = arrayListM1569l.size();
            if (size2 == 1) {
                z2 = !arrayListM1569l.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f1848g == null) {
                this.f1848g = new d(this.f1208a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f1848g.getParent();
            if (viewGroup != this.f1213f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f1848g);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f1213f;
                actionMenuView.addView(this.f1848g, actionMenuView.m1675c());
            }
        } else if (this.f1848g != null && this.f1848g.getParent() == this.f1213f) {
            ((ViewGroup) this.f1213f).removeView(this.f1848g);
        }
        ((ActionMenuView) this.f1213f).setOverflowReserved(this.f1856o);
    }

    @Override // android.support.v7.view.menu.AbstractC0190b, android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: b */
    public boolean mo1480b() {
        ArrayList<C0198j> arrayListM1566i;
        int size;
        int iM1665a;
        int i;
        int i2;
        boolean z;
        C0273d c0273d = this;
        int i3 = 0;
        if (c0273d.f1210c != null) {
            arrayListM1566i = c0273d.f1210c.m1566i();
            size = arrayListM1566i.size();
        } else {
            arrayListM1566i = null;
            size = 0;
        }
        int i4 = c0273d.f1860s;
        int i5 = c0273d.f1859r;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) c0273d.f1213f;
        int i6 = i4;
        int i7 = 0;
        boolean z2 = false;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            C0198j c0198j = arrayListM1566i.get(i9);
            if (c0198j.m1600l()) {
                i7++;
            } else if (c0198j.m1599k()) {
                i8++;
            } else {
                z2 = true;
            }
            if (c0273d.f1864w && c0198j.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (c0273d.f1856o && (z2 || i8 + i7 > i6)) {
            i6--;
        }
        int i10 = i6 - i7;
        SparseBooleanArray sparseBooleanArray = c0273d.f1866y;
        sparseBooleanArray.clear();
        if (c0273d.f1862u) {
            iM1665a = i5 / c0273d.f1865x;
            i = ((i5 % c0273d.f1865x) / iM1665a) + c0273d.f1865x;
        } else {
            iM1665a = 0;
            i = 0;
        }
        int i11 = i5;
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            C0198j c0198j2 = arrayListM1566i.get(i12);
            if (c0198j2.m1600l()) {
                View viewMo1467a = c0273d.mo1467a(c0198j2, c0273d.f1867z, viewGroup);
                if (c0273d.f1867z == null) {
                    c0273d.f1867z = viewMo1467a;
                }
                if (c0273d.f1862u) {
                    iM1665a -= ActionMenuView.m1665a(viewMo1467a, i, iM1665a, iMakeMeasureSpec, i3);
                } else {
                    viewMo1467a.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewMo1467a.getMeasuredWidth();
                i11 -= measuredWidth;
                if (i13 != 0) {
                    measuredWidth = i13;
                }
                int groupId = c0198j2.getGroupId();
                if (groupId != 0) {
                    z = true;
                    sparseBooleanArray.put(groupId, true);
                } else {
                    z = true;
                }
                c0198j2.m1591d(z);
                i2 = size;
                i13 = measuredWidth;
            } else if (c0198j2.m1599k()) {
                int groupId2 = c0198j2.getGroupId();
                boolean z3 = sparseBooleanArray.get(groupId2);
                boolean z4 = (i10 > 0 || z3) && i11 > 0 && (!c0273d.f1862u || iM1665a > 0);
                if (z4) {
                    boolean z5 = z4;
                    View viewMo1467a2 = c0273d.mo1467a(c0198j2, c0273d.f1867z, viewGroup);
                    i2 = size;
                    if (c0273d.f1867z == null) {
                        c0273d.f1867z = viewMo1467a2;
                    }
                    if (c0273d.f1862u) {
                        int iM1665a2 = ActionMenuView.m1665a(viewMo1467a2, i, iM1665a, iMakeMeasureSpec, 0);
                        iM1665a -= iM1665a2;
                        if (iM1665a2 == 0) {
                            z5 = false;
                        }
                    } else {
                        viewMo1467a2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    int measuredWidth2 = viewMo1467a2.getMeasuredWidth();
                    i11 -= measuredWidth2;
                    if (i13 == 0) {
                        i13 = measuredWidth2;
                    }
                    z4 = z5 & (!c0273d.f1862u ? i11 + i13 <= 0 : i11 < 0);
                } else {
                    i2 = size;
                }
                if (z4 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z3) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i14 = 0; i14 < i12; i14++) {
                        C0198j c0198j3 = arrayListM1566i.get(i14);
                        if (c0198j3.getGroupId() == groupId2) {
                            if (c0198j3.m1598j()) {
                                i10++;
                            }
                            c0198j3.m1591d(false);
                        }
                    }
                }
                if (z4) {
                    i10--;
                }
                c0198j2.m1591d(z4);
            } else {
                i2 = size;
                c0198j2.m1591d(false);
                i12++;
                size = i2;
                c0273d = this;
                i3 = 0;
            }
            i12++;
            size = i2;
            c0273d = this;
            i3 = 0;
        }
        return true;
    }

    /* JADX INFO: renamed from: c */
    public Drawable m2040c() {
        if (this.f1848g != null) {
            return this.f1848g.getDrawable();
        }
        if (this.f1855n) {
            return this.f1854m;
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public void m2041c(boolean z) {
        this.f1856o = z;
        this.f1857p = true;
    }

    /* JADX INFO: renamed from: d */
    public void m2042d(boolean z) {
        this.f1864w = z;
    }

    /* JADX INFO: renamed from: d */
    public boolean m2043d() {
        if (!this.f1856o || m2047h() || this.f1210c == null || this.f1213f == null || this.f1851j != null || this.f1210c.m1569l().isEmpty()) {
            return false;
        }
        this.f1851j = new c(new e(this.f1209b, this.f1210c, this.f1848g, true));
        ((View) this.f1213f).post(this.f1851j);
        super.mo1476a((SubMenuC0209u) null);
        return true;
    }

    /* JADX INFO: renamed from: e */
    public boolean m2044e() {
        if (this.f1851j != null && this.f1213f != null) {
            ((View) this.f1213f).removeCallbacks(this.f1851j);
            this.f1851j = null;
            return true;
        }
        e eVar = this.f1849h;
        if (eVar == null) {
            return false;
        }
        eVar.m1622d();
        return true;
    }

    /* JADX INFO: renamed from: f */
    public boolean m2045f() {
        return m2044e() | m2046g();
    }

    /* JADX INFO: renamed from: g */
    public boolean m2046g() {
        if (this.f1850i == null) {
            return false;
        }
        this.f1850i.m1622d();
        return true;
    }

    /* JADX INFO: renamed from: h */
    public boolean m2047h() {
        return this.f1849h != null && this.f1849h.m1624f();
    }

    /* JADX INFO: renamed from: i */
    public boolean m2048i() {
        return this.f1851j != null || m2047h();
    }
}
