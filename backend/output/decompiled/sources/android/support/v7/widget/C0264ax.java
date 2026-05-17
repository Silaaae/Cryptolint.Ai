package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p015g.C0124p;
import android.support.v4.p015g.C0127s;
import android.support.v4.p015g.C0129u;
import android.support.v7.p018a.C0148a;
import android.support.v7.p019b.p020a.C0175b;
import android.support.v7.view.menu.C0189a;
import android.support.v7.view.menu.C0196h;
import android.support.v7.view.menu.InterfaceC0203o;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: renamed from: android.support.v7.widget.ax */
/* JADX INFO: loaded from: classes.dex */
public class C0264ax implements InterfaceC0245ae {

    /* JADX INFO: renamed from: a */
    Toolbar f1803a;

    /* JADX INFO: renamed from: b */
    CharSequence f1804b;

    /* JADX INFO: renamed from: c */
    Window.Callback f1805c;

    /* JADX INFO: renamed from: d */
    boolean f1806d;

    /* JADX INFO: renamed from: e */
    private int f1807e;

    /* JADX INFO: renamed from: f */
    private View f1808f;

    /* JADX INFO: renamed from: g */
    private View f1809g;

    /* JADX INFO: renamed from: h */
    private Drawable f1810h;

    /* JADX INFO: renamed from: i */
    private Drawable f1811i;

    /* JADX INFO: renamed from: j */
    private Drawable f1812j;

    /* JADX INFO: renamed from: k */
    private boolean f1813k;

    /* JADX INFO: renamed from: l */
    private CharSequence f1814l;

    /* JADX INFO: renamed from: m */
    private CharSequence f1815m;

    /* JADX INFO: renamed from: n */
    private C0273d f1816n;

    /* JADX INFO: renamed from: o */
    private int f1817o;

    /* JADX INFO: renamed from: p */
    private int f1818p;

    /* JADX INFO: renamed from: q */
    private Drawable f1819q;

    public C0264ax(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0148a.h.abc_action_bar_up_description, C0148a.e.abc_ic_ab_back_material);
    }

    public C0264ax(Toolbar toolbar, boolean z, int i, int i2) {
        this.f1817o = 0;
        this.f1818p = 0;
        this.f1803a = toolbar;
        this.f1804b = toolbar.getTitle();
        this.f1814l = toolbar.getSubtitle();
        this.f1813k = this.f1804b != null;
        this.f1812j = toolbar.getNavigationIcon();
        C0263aw c0263awM1978a = C0263aw.m1978a(toolbar.getContext(), null, C0148a.j.ActionBar, C0148a.a.actionBarStyle, 0);
        this.f1819q = c0263awM1978a.m1982a(C0148a.j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence charSequenceM1988c = c0263awM1978a.m1988c(C0148a.j.ActionBar_title);
            if (!TextUtils.isEmpty(charSequenceM1988c)) {
                m2004b(charSequenceM1988c);
            }
            CharSequence charSequenceM1988c2 = c0263awM1978a.m1988c(C0148a.j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(charSequenceM1988c2)) {
                m2006c(charSequenceM1988c2);
            }
            Drawable drawableM1982a = c0263awM1978a.m1982a(C0148a.j.ActionBar_logo);
            if (drawableM1982a != null) {
                m2003b(drawableM1982a);
            }
            Drawable drawableM1982a2 = c0263awM1978a.m1982a(C0148a.j.ActionBar_icon);
            if (drawableM1982a2 != null) {
                mo1826a(drawableM1982a2);
            }
            if (this.f1812j == null && this.f1819q != null) {
                m2005c(this.f1819q);
            }
            mo1836c(c0263awM1978a.m1980a(C0148a.j.ActionBar_displayOptions, 0));
            int iM1995g = c0263awM1978a.m1995g(C0148a.j.ActionBar_customNavigationLayout, 0);
            if (iM1995g != 0) {
                m2002a(LayoutInflater.from(this.f1803a.getContext()).inflate(iM1995g, (ViewGroup) this.f1803a, false));
                mo1836c(this.f1807e | 16);
            }
            int iM1993f = c0263awM1978a.m1993f(C0148a.j.ActionBar_height, 0);
            if (iM1993f > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1803a.getLayoutParams();
                layoutParams.height = iM1993f;
                this.f1803a.setLayoutParams(layoutParams);
            }
            int iM1989d = c0263awM1978a.m1989d(C0148a.j.ActionBar_contentInsetStart, -1);
            int iM1989d2 = c0263awM1978a.m1989d(C0148a.j.ActionBar_contentInsetEnd, -1);
            if (iM1989d >= 0 || iM1989d2 >= 0) {
                this.f1803a.m1765a(Math.max(iM1989d, 0), Math.max(iM1989d2, 0));
            }
            int iM1995g2 = c0263awM1978a.m1995g(C0148a.j.ActionBar_titleTextStyle, 0);
            if (iM1995g2 != 0) {
                this.f1803a.m1766a(this.f1803a.getContext(), iM1995g2);
            }
            int iM1995g3 = c0263awM1978a.m1995g(C0148a.j.ActionBar_subtitleTextStyle, 0);
            if (iM1995g3 != 0) {
                this.f1803a.m1770b(this.f1803a.getContext(), iM1995g3);
            }
            int iM1995g4 = c0263awM1978a.m1995g(C0148a.j.ActionBar_popupTheme, 0);
            if (iM1995g4 != 0) {
                this.f1803a.setPopupTheme(iM1995g4);
            }
        } else {
            this.f1807e = m1998r();
        }
        c0263awM1978a.m1983a();
        m2008e(i);
        this.f1815m = this.f1803a.getNavigationContentDescription();
        this.f1803a.setNavigationOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.ax.1

            /* JADX INFO: renamed from: a */
            final C0189a f1820a;

            {
                this.f1820a = new C0189a(C0264ax.this.f1803a.getContext(), 0, R.id.home, 0, 0, C0264ax.this.f1804b);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C0264ax.this.f1805c == null || !C0264ax.this.f1806d) {
                    return;
                }
                C0264ax.this.f1805c.onMenuItemSelected(0, this.f1820a);
            }
        });
    }

    /* JADX INFO: renamed from: e */
    private void m1997e(CharSequence charSequence) {
        this.f1804b = charSequence;
        if ((this.f1807e & 8) != 0) {
            this.f1803a.setTitle(charSequence);
        }
    }

    /* JADX INFO: renamed from: r */
    private int m1998r() {
        if (this.f1803a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1819q = this.f1803a.getNavigationIcon();
        return 15;
    }

    /* JADX INFO: renamed from: s */
    private void m1999s() {
        this.f1803a.setLogo((this.f1807e & 2) != 0 ? ((this.f1807e & 1) == 0 || this.f1811i == null) ? this.f1810h : this.f1811i : null);
    }

    /* JADX INFO: renamed from: t */
    private void m2000t() {
        Toolbar toolbar;
        Drawable drawable;
        if ((this.f1807e & 4) != 0) {
            toolbar = this.f1803a;
            drawable = this.f1812j != null ? this.f1812j : this.f1819q;
        } else {
            toolbar = this.f1803a;
            drawable = null;
        }
        toolbar.setNavigationIcon(drawable);
    }

    /* JADX INFO: renamed from: u */
    private void m2001u() {
        if ((this.f1807e & 4) != 0) {
            if (TextUtils.isEmpty(this.f1815m)) {
                this.f1803a.setNavigationContentDescription(this.f1818p);
            } else {
                this.f1803a.setNavigationContentDescription(this.f1815m);
            }
        }
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: a */
    public C0127s mo1823a(final int i, long j) {
        return C0124p.m962d(this.f1803a).m1017a(i == 0 ? 1.0f : 0.0f).m1018a(j).m1019a(new C0129u() { // from class: android.support.v7.widget.ax.2

            /* JADX INFO: renamed from: c */
            private boolean f1824c = false;

            @Override // android.support.v4.p015g.C0129u, android.support.v4.p015g.InterfaceC0128t
            /* JADX INFO: renamed from: a */
            public void mo1026a(View view) {
                C0264ax.this.f1803a.setVisibility(0);
            }

            @Override // android.support.v4.p015g.C0129u, android.support.v4.p015g.InterfaceC0128t
            /* JADX INFO: renamed from: b */
            public void mo1027b(View view) {
                if (this.f1824c) {
                    return;
                }
                C0264ax.this.f1803a.setVisibility(i);
            }

            @Override // android.support.v4.p015g.C0129u, android.support.v4.p015g.InterfaceC0128t
            /* JADX INFO: renamed from: c */
            public void mo1028c(View view) {
                this.f1824c = true;
            }
        });
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: a */
    public ViewGroup mo1824a() {
        return this.f1803a;
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: a */
    public void mo1825a(int i) {
        mo1826a(i != 0 ? C0175b.m1396b(mo1833b(), i) : null);
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: a */
    public void mo1826a(Drawable drawable) {
        this.f1810h = drawable;
        m1999s();
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: a */
    public void mo1827a(InterfaceC0203o.a aVar, C0196h.a aVar2) {
        this.f1803a.m1768a(aVar, aVar2);
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: a */
    public void mo1828a(C0256ap c0256ap) {
        if (this.f1808f != null && this.f1808f.getParent() == this.f1803a) {
            this.f1803a.removeView(this.f1808f);
        }
        this.f1808f = c0256ap;
        if (c0256ap == null || this.f1817o != 2) {
            return;
        }
        this.f1803a.addView(this.f1808f, 0);
        Toolbar.C0236b c0236b = (Toolbar.C0236b) this.f1808f.getLayoutParams();
        c0236b.width = -2;
        c0236b.height = -2;
        c0236b.f902a = 8388691;
        c0256ap.setAllowCollapse(true);
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: a */
    public void mo1829a(Menu menu, InterfaceC0203o.a aVar) {
        if (this.f1816n == null) {
            this.f1816n = new C0273d(this.f1803a.getContext());
            this.f1816n.m1468a(C0148a.f.action_menu_presenter);
        }
        this.f1816n.mo1472a(aVar);
        this.f1803a.m1767a((C0196h) menu, this.f1816n);
    }

    /* JADX INFO: renamed from: a */
    public void m2002a(View view) {
        if (this.f1809g != null && (this.f1807e & 16) != 0) {
            this.f1803a.removeView(this.f1809g);
        }
        this.f1809g = view;
        if (view == null || (this.f1807e & 16) == 0) {
            return;
        }
        this.f1803a.addView(this.f1809g);
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: a */
    public void mo1830a(Window.Callback callback) {
        this.f1805c = callback;
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: a */
    public void mo1831a(CharSequence charSequence) {
        if (this.f1813k) {
            return;
        }
        m1997e(charSequence);
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: a */
    public void mo1832a(boolean z) {
        this.f1803a.setCollapsible(z);
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: b */
    public Context mo1833b() {
        return this.f1803a.getContext();
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: b */
    public void mo1834b(int i) {
        m2003b(i != 0 ? C0175b.m1396b(mo1833b(), i) : null);
    }

    /* JADX INFO: renamed from: b */
    public void m2003b(Drawable drawable) {
        this.f1811i = drawable;
        m1999s();
    }

    /* JADX INFO: renamed from: b */
    public void m2004b(CharSequence charSequence) {
        this.f1813k = true;
        m1997e(charSequence);
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: b */
    public void mo1835b(boolean z) {
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: c */
    public void mo1836c(int i) {
        CharSequence charSequence;
        Toolbar toolbar;
        int i2 = this.f1807e ^ i;
        this.f1807e = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m2001u();
                }
                m2000t();
            }
            if ((i2 & 3) != 0) {
                m1999s();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f1803a.setTitle(this.f1804b);
                    toolbar = this.f1803a;
                    charSequence = this.f1814l;
                } else {
                    charSequence = null;
                    this.f1803a.setTitle((CharSequence) null);
                    toolbar = this.f1803a;
                }
                toolbar.setSubtitle(charSequence);
            }
            if ((i2 & 16) == 0 || this.f1809g == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.f1803a.addView(this.f1809g);
            } else {
                this.f1803a.removeView(this.f1809g);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m2005c(Drawable drawable) {
        this.f1812j = drawable;
        m2000t();
    }

    /* JADX INFO: renamed from: c */
    public void m2006c(CharSequence charSequence) {
        this.f1814l = charSequence;
        if ((this.f1807e & 8) != 0) {
            this.f1803a.setSubtitle(charSequence);
        }
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: c */
    public boolean mo1837c() {
        return this.f1803a.m1776g();
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: d */
    public void mo1838d() {
        this.f1803a.m1777h();
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: d */
    public void mo1839d(int i) {
        this.f1803a.setVisibility(i);
    }

    /* JADX INFO: renamed from: d */
    public void m2007d(CharSequence charSequence) {
        this.f1815m = charSequence;
        m2001u();
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: e */
    public CharSequence mo1840e() {
        return this.f1803a.getTitle();
    }

    /* JADX INFO: renamed from: e */
    public void m2008e(int i) {
        if (i == this.f1818p) {
            return;
        }
        this.f1818p = i;
        if (TextUtils.isEmpty(this.f1803a.getNavigationContentDescription())) {
            m2009f(this.f1818p);
        }
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: f */
    public void mo1841f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    /* JADX INFO: renamed from: f */
    public void m2009f(int i) {
        m2007d(i == 0 ? null : mo1833b().getString(i));
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: g */
    public void mo1842g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: h */
    public boolean mo1843h() {
        return this.f1803a.m1769a();
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: i */
    public boolean mo1844i() {
        return this.f1803a.m1771b();
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: j */
    public boolean mo1845j() {
        return this.f1803a.m1772c();
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: k */
    public boolean mo1846k() {
        return this.f1803a.m1773d();
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: l */
    public boolean mo1847l() {
        return this.f1803a.m1774e();
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: m */
    public void mo1848m() {
        this.f1806d = true;
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: n */
    public void mo1849n() {
        this.f1803a.m1775f();
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: o */
    public int mo1850o() {
        return this.f1807e;
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: p */
    public int mo1851p() {
        return this.f1817o;
    }

    @Override // android.support.v7.widget.InterfaceC0245ae
    /* JADX INFO: renamed from: q */
    public Menu mo1852q() {
        return this.f1803a.getMenu();
    }
}
