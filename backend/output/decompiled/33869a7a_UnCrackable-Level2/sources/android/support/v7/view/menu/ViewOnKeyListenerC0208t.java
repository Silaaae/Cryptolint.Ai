package android.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.menu.InterfaceC0203o;
import android.support.v7.widget.C0253am;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

/* JADX INFO: renamed from: android.support.v7.view.menu.t */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnKeyListenerC0208t extends AbstractC0201m implements InterfaceC0203o, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a */
    final C0253am f1363a;

    /* JADX INFO: renamed from: b */
    View f1364b;

    /* JADX INFO: renamed from: c */
    private final Context f1365c;

    /* JADX INFO: renamed from: d */
    private final C0196h f1366d;

    /* JADX INFO: renamed from: e */
    private final C0195g f1367e;

    /* JADX INFO: renamed from: f */
    private final boolean f1368f;

    /* JADX INFO: renamed from: g */
    private final int f1369g;

    /* JADX INFO: renamed from: h */
    private final int f1370h;

    /* JADX INFO: renamed from: i */
    private final int f1371i;

    /* JADX INFO: renamed from: l */
    private PopupWindow.OnDismissListener f1374l;

    /* JADX INFO: renamed from: m */
    private View f1375m;

    /* JADX INFO: renamed from: n */
    private InterfaceC0203o.a f1376n;

    /* JADX INFO: renamed from: o */
    private ViewTreeObserver f1377o;

    /* JADX INFO: renamed from: p */
    private boolean f1378p;

    /* JADX INFO: renamed from: q */
    private boolean f1379q;

    /* JADX INFO: renamed from: r */
    private int f1380r;

    /* JADX INFO: renamed from: t */
    private boolean f1382t;

    /* JADX INFO: renamed from: j */
    private final ViewTreeObserver.OnGlobalLayoutListener f1372j = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.view.menu.t.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!ViewOnKeyListenerC0208t.this.mo1507d() || ViewOnKeyListenerC0208t.this.f1363a.m1918g()) {
                return;
            }
            View view = ViewOnKeyListenerC0208t.this.f1364b;
            if (view == null || !view.isShown()) {
                ViewOnKeyListenerC0208t.this.mo1504c();
            } else {
                ViewOnKeyListenerC0208t.this.f1363a.mo1497a();
            }
        }
    };

    /* JADX INFO: renamed from: k */
    private final View.OnAttachStateChangeListener f1373k = new View.OnAttachStateChangeListener() { // from class: android.support.v7.view.menu.t.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ViewOnKeyListenerC0208t.this.f1377o != null) {
                if (!ViewOnKeyListenerC0208t.this.f1377o.isAlive()) {
                    ViewOnKeyListenerC0208t.this.f1377o = view.getViewTreeObserver();
                }
                ViewOnKeyListenerC0208t.this.f1377o.removeGlobalOnLayoutListener(ViewOnKeyListenerC0208t.this.f1372j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* JADX INFO: renamed from: s */
    private int f1381s = 0;

    public ViewOnKeyListenerC0208t(Context context, C0196h c0196h, View view, int i, int i2, boolean z) {
        this.f1365c = context;
        this.f1366d = c0196h;
        this.f1368f = z;
        this.f1367e = new C0195g(c0196h, LayoutInflater.from(context), this.f1368f);
        this.f1370h = i;
        this.f1371i = i2;
        Resources resources = context.getResources();
        this.f1369g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0148a.d.abc_config_prefDialogWidth));
        this.f1375m = view;
        this.f1363a = new C0253am(this.f1365c, null, this.f1370h, this.f1371i);
        c0196h.m1541a(this, context);
    }

    /* JADX INFO: renamed from: h */
    private boolean m1631h() {
        if (mo1507d()) {
            return true;
        }
        if (this.f1378p || this.f1375m == null) {
            return false;
        }
        this.f1364b = this.f1375m;
        this.f1363a.m1908a((PopupWindow.OnDismissListener) this);
        this.f1363a.m1906a((AdapterView.OnItemClickListener) this);
        this.f1363a.m1909a(true);
        View view = this.f1364b;
        boolean z = this.f1377o == null;
        this.f1377o = view.getViewTreeObserver();
        if (z) {
            this.f1377o.addOnGlobalLayoutListener(this.f1372j);
        }
        view.addOnAttachStateChangeListener(this.f1373k);
        this.f1363a.m1911b(view);
        this.f1363a.m1915e(this.f1381s);
        if (!this.f1379q) {
            this.f1380r = m1606a(this.f1367e, null, this.f1365c, this.f1369g);
            this.f1379q = true;
        }
        this.f1363a.m1917g(this.f1380r);
        this.f1363a.m1920h(2);
        this.f1363a.m1904a(m1610g());
        this.f1363a.mo1497a();
        ListView listViewE = this.f1363a.mo1508e();
        listViewE.setOnKeyListener(this);
        if (this.f1382t && this.f1366d.m1570m() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1365c).inflate(C0148a.g.abc_popup_menu_header_item_layout, (ViewGroup) listViewE, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.f1366d.m1570m());
            }
            frameLayout.setEnabled(false);
            listViewE.addHeaderView(frameLayout, null, false);
        }
        this.f1363a.mo1907a((ListAdapter) this.f1367e);
        this.f1363a.mo1497a();
        return true;
    }

    @Override // android.support.v7.view.menu.InterfaceC0207s
    /* JADX INFO: renamed from: a */
    public void mo1497a() {
        if (!m1631h()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: a */
    public void mo1498a(int i) {
        this.f1381s = i;
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: a */
    public void mo1499a(C0196h c0196h) {
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public void mo1470a(C0196h c0196h, boolean z) {
        if (c0196h != this.f1366d) {
            return;
        }
        mo1504c();
        if (this.f1376n != null) {
            this.f1376n.mo1324a(c0196h, z);
        }
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public void mo1472a(InterfaceC0203o.a aVar) {
        this.f1376n = aVar;
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: a */
    public void mo1500a(View view) {
        this.f1375m = view;
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: a */
    public void mo1501a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1374l = onDismissListener;
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: a */
    public void mo1502a(boolean z) {
        this.f1367e.m1519a(z);
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public boolean mo1476a(SubMenuC0209u subMenuC0209u) {
        if (subMenuC0209u.hasVisibleItems()) {
            C0202n c0202n = new C0202n(this.f1365c, subMenuC0209u, this.f1364b, this.f1368f, this.f1370h, this.f1371i);
            c0202n.m1615a(this.f1376n);
            c0202n.m1618a(AbstractC0201m.m1608b(subMenuC0209u));
            c0202n.m1614a(this.f1381s);
            c0202n.m1617a(this.f1374l);
            this.f1374l = null;
            this.f1366d.m1544a(false);
            if (c0202n.m1619a(this.f1363a.m1923j(), this.f1363a.m1924k())) {
                if (this.f1376n == null) {
                    return true;
                }
                this.f1376n.mo1325a(subMenuC0209u);
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: b */
    public void mo1503b(int i) {
        this.f1363a.m1913c(i);
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: b */
    public void mo1479b(boolean z) {
        this.f1379q = false;
        if (this.f1367e != null) {
            this.f1367e.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: b */
    public boolean mo1480b() {
        return false;
    }

    @Override // android.support.v7.view.menu.InterfaceC0207s
    /* JADX INFO: renamed from: c */
    public void mo1504c() {
        if (mo1507d()) {
            this.f1363a.mo1504c();
        }
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: c */
    public void mo1505c(int i) {
        this.f1363a.m1914d(i);
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: c */
    public void mo1506c(boolean z) {
        this.f1382t = z;
    }

    @Override // android.support.v7.view.menu.InterfaceC0207s
    /* JADX INFO: renamed from: d */
    public boolean mo1507d() {
        return !this.f1378p && this.f1363a.mo1507d();
    }

    @Override // android.support.v7.view.menu.InterfaceC0207s
    /* JADX INFO: renamed from: e */
    public ListView mo1508e() {
        return this.f1363a.mo1508e();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f1378p = true;
        this.f1366d.close();
        if (this.f1377o != null) {
            if (!this.f1377o.isAlive()) {
                this.f1377o = this.f1364b.getViewTreeObserver();
            }
            this.f1377o.removeGlobalOnLayoutListener(this.f1372j);
            this.f1377o = null;
        }
        this.f1364b.removeOnAttachStateChangeListener(this.f1373k);
        if (this.f1374l != null) {
            this.f1374l.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        mo1504c();
        return true;
    }
}
