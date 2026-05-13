package android.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.p015g.C0112d;
import android.support.v4.p015g.C0124p;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.menu.InterfaceC0203o;
import android.support.v7.widget.C0253am;
import android.support.v7.widget.InterfaceC0252al;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: android.support.v7.view.menu.e */
/* JADX INFO: loaded from: classes.dex */
final class ViewOnKeyListenerC0193e extends AbstractC0201m implements InterfaceC0203o, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* JADX INFO: renamed from: a */
    final Handler f1222a;

    /* JADX INFO: renamed from: c */
    View f1224c;

    /* JADX INFO: renamed from: d */
    boolean f1225d;

    /* JADX INFO: renamed from: e */
    private final Context f1226e;

    /* JADX INFO: renamed from: f */
    private final int f1227f;

    /* JADX INFO: renamed from: g */
    private final int f1228g;

    /* JADX INFO: renamed from: h */
    private final int f1229h;

    /* JADX INFO: renamed from: i */
    private final boolean f1230i;

    /* JADX INFO: renamed from: p */
    private View f1237p;

    /* JADX INFO: renamed from: r */
    private boolean f1239r;

    /* JADX INFO: renamed from: s */
    private boolean f1240s;

    /* JADX INFO: renamed from: t */
    private int f1241t;

    /* JADX INFO: renamed from: u */
    private int f1242u;

    /* JADX INFO: renamed from: w */
    private boolean f1244w;

    /* JADX INFO: renamed from: x */
    private InterfaceC0203o.a f1245x;

    /* JADX INFO: renamed from: y */
    private ViewTreeObserver f1246y;

    /* JADX INFO: renamed from: z */
    private PopupWindow.OnDismissListener f1247z;

    /* JADX INFO: renamed from: j */
    private final List<C0196h> f1231j = new ArrayList();

    /* JADX INFO: renamed from: b */
    final List<a> f1223b = new ArrayList();

    /* JADX INFO: renamed from: k */
    private final ViewTreeObserver.OnGlobalLayoutListener f1232k = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.view.menu.e.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!ViewOnKeyListenerC0193e.this.mo1507d() || ViewOnKeyListenerC0193e.this.f1223b.size() <= 0 || ViewOnKeyListenerC0193e.this.f1223b.get(0).f1255a.m1918g()) {
                return;
            }
            View view = ViewOnKeyListenerC0193e.this.f1224c;
            if (view == null || !view.isShown()) {
                ViewOnKeyListenerC0193e.this.mo1504c();
                return;
            }
            Iterator<a> it = ViewOnKeyListenerC0193e.this.f1223b.iterator();
            while (it.hasNext()) {
                it.next().f1255a.mo1497a();
            }
        }
    };

    /* JADX INFO: renamed from: l */
    private final View.OnAttachStateChangeListener f1233l = new View.OnAttachStateChangeListener() { // from class: android.support.v7.view.menu.e.2
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (ViewOnKeyListenerC0193e.this.f1246y != null) {
                if (!ViewOnKeyListenerC0193e.this.f1246y.isAlive()) {
                    ViewOnKeyListenerC0193e.this.f1246y = view.getViewTreeObserver();
                }
                ViewOnKeyListenerC0193e.this.f1246y.removeGlobalOnLayoutListener(ViewOnKeyListenerC0193e.this.f1232k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* JADX INFO: renamed from: m */
    private final InterfaceC0252al f1234m = new InterfaceC0252al() { // from class: android.support.v7.view.menu.e.3
        @Override // android.support.v7.widget.InterfaceC0252al
        /* JADX INFO: renamed from: a */
        public void mo1510a(C0196h c0196h, MenuItem menuItem) {
            ViewOnKeyListenerC0193e.this.f1222a.removeCallbacksAndMessages(c0196h);
        }

        @Override // android.support.v7.widget.InterfaceC0252al
        /* JADX INFO: renamed from: b */
        public void mo1511b(final C0196h c0196h, final MenuItem menuItem) {
            ViewOnKeyListenerC0193e.this.f1222a.removeCallbacksAndMessages(null);
            int size = ViewOnKeyListenerC0193e.this.f1223b.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (c0196h == ViewOnKeyListenerC0193e.this.f1223b.get(i).f1256b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            final a aVar = i2 < ViewOnKeyListenerC0193e.this.f1223b.size() ? ViewOnKeyListenerC0193e.this.f1223b.get(i2) : null;
            ViewOnKeyListenerC0193e.this.f1222a.postAtTime(new Runnable() { // from class: android.support.v7.view.menu.e.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (aVar != null) {
                        ViewOnKeyListenerC0193e.this.f1225d = true;
                        aVar.f1256b.m1544a(false);
                        ViewOnKeyListenerC0193e.this.f1225d = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        c0196h.m1546a(menuItem, 4);
                    }
                }
            }, c0196h, SystemClock.uptimeMillis() + 200);
        }
    };

    /* JADX INFO: renamed from: n */
    private int f1235n = 0;

    /* JADX INFO: renamed from: o */
    private int f1236o = 0;

    /* JADX INFO: renamed from: v */
    private boolean f1243v = false;

    /* JADX INFO: renamed from: q */
    private int f1238q = m1496i();

    /* JADX INFO: renamed from: android.support.v7.view.menu.e$a */
    private static class a {

        /* JADX INFO: renamed from: a */
        public final C0253am f1255a;

        /* JADX INFO: renamed from: b */
        public final C0196h f1256b;

        /* JADX INFO: renamed from: c */
        public final int f1257c;

        public a(C0253am c0253am, C0196h c0196h, int i) {
            this.f1255a = c0253am;
            this.f1256b = c0196h;
            this.f1257c = i;
        }

        /* JADX INFO: renamed from: a */
        public ListView m1512a() {
            return this.f1255a.mo1508e();
        }
    }

    public ViewOnKeyListenerC0193e(Context context, View view, int i, int i2, boolean z) {
        this.f1226e = context;
        this.f1237p = view;
        this.f1228g = i;
        this.f1229h = i2;
        this.f1230i = z;
        Resources resources = context.getResources();
        this.f1227f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0148a.d.abc_config_prefDialogWidth));
        this.f1222a = new Handler();
    }

    /* JADX INFO: renamed from: a */
    private MenuItem m1487a(C0196h c0196h, C0196h c0196h2) {
        int size = c0196h.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0196h.getItem(i);
            if (item.hasSubMenu() && c0196h2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private View m1488a(a aVar, C0196h c0196h) {
        C0195g c0195g;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemM1487a = m1487a(aVar.f1256b, c0196h);
        if (menuItemM1487a == null) {
            return null;
        }
        ListView listViewM1512a = aVar.m1512a();
        ListAdapter adapter = listViewM1512a.getAdapter();
        int i = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            c0195g = (C0195g) headerViewListAdapter.getWrappedAdapter();
        } else {
            c0195g = (C0195g) adapter;
            headersCount = 0;
        }
        int count = c0195g.getCount();
        while (true) {
            if (i >= count) {
                i = -1;
                break;
            }
            if (menuItemM1487a == c0195g.getItem(i)) {
                break;
            }
            i++;
        }
        if (i != -1 && (firstVisiblePosition = (i + headersCount) - listViewM1512a.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listViewM1512a.getChildCount()) {
            return listViewM1512a.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    private void m1492c(C0196h c0196h) {
        a aVar;
        View viewM1488a;
        int i;
        int i2;
        int i3;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f1226e);
        C0195g c0195g = new C0195g(c0196h, layoutInflaterFrom, this.f1230i);
        if (!mo1507d() && this.f1243v) {
            c0195g.m1519a(true);
        } else if (mo1507d()) {
            c0195g.m1519a(AbstractC0201m.m1608b(c0196h));
        }
        int iA = m1606a(c0195g, null, this.f1226e, this.f1227f);
        C0253am c0253amM1495h = m1495h();
        c0253amM1495h.mo1907a((ListAdapter) c0195g);
        c0253amM1495h.m1917g(iA);
        c0253amM1495h.m1915e(this.f1236o);
        if (this.f1223b.size() > 0) {
            aVar = this.f1223b.get(this.f1223b.size() - 1);
            viewM1488a = m1488a(aVar, c0196h);
        } else {
            aVar = null;
            viewM1488a = null;
        }
        if (viewM1488a != null) {
            c0253amM1495h.m1931c(false);
            c0253amM1495h.m1929a((Object) null);
            int iM1493d = m1493d(iA);
            boolean z = iM1493d == 1;
            this.f1238q = iM1493d;
            if (Build.VERSION.SDK_INT >= 26) {
                c0253amM1495h.m1911b(viewM1488a);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.f1237p.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewM1488a.getLocationOnScreen(iArr2);
                if ((this.f1236o & 7) == 5) {
                    iArr[0] = iArr[0] + this.f1237p.getWidth();
                    iArr2[0] = iArr2[0] + viewM1488a.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.f1236o & 5) == 5) {
                if (!z) {
                    iA = viewM1488a.getWidth();
                    i3 = i - iA;
                }
                i3 = i + iA;
            } else {
                if (z) {
                    iA = viewM1488a.getWidth();
                    i3 = i + iA;
                }
                i3 = i - iA;
            }
            c0253amM1495h.m1913c(i3);
            c0253amM1495h.m1912b(true);
            c0253amM1495h.m1914d(i2);
        } else {
            if (this.f1239r) {
                c0253amM1495h.m1913c(this.f1241t);
            }
            if (this.f1240s) {
                c0253amM1495h.m1914d(this.f1242u);
            }
            c0253amM1495h.m1904a(m1610g());
        }
        this.f1223b.add(new a(c0253amM1495h, c0196h, this.f1238q));
        c0253amM1495h.mo1497a();
        ListView listViewE = c0253amM1495h.mo1508e();
        listViewE.setOnKeyListener(this);
        if (aVar == null && this.f1244w && c0196h.m1570m() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(C0148a.g.abc_popup_menu_header_item_layout, (ViewGroup) listViewE, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(c0196h.m1570m());
            listViewE.addHeaderView(frameLayout, null, false);
            c0253amM1495h.mo1497a();
        }
    }

    /* JADX INFO: renamed from: d */
    private int m1493d(int i) {
        ListView listViewM1512a = this.f1223b.get(this.f1223b.size() - 1).m1512a();
        int[] iArr = new int[2];
        listViewM1512a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1224c.getWindowVisibleDisplayFrame(rect);
        return this.f1238q == 1 ? (iArr[0] + listViewM1512a.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    /* JADX INFO: renamed from: d */
    private int m1494d(C0196h c0196h) {
        int size = this.f1223b.size();
        for (int i = 0; i < size; i++) {
            if (c0196h == this.f1223b.get(i).f1256b) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: h */
    private C0253am m1495h() {
        C0253am c0253am = new C0253am(this.f1226e, null, this.f1228g, this.f1229h);
        c0253am.m1928a(this.f1234m);
        c0253am.m1906a((AdapterView.OnItemClickListener) this);
        c0253am.m1908a((PopupWindow.OnDismissListener) this);
        c0253am.m1911b(this.f1237p);
        c0253am.m1915e(this.f1236o);
        c0253am.m1909a(true);
        c0253am.m1920h(2);
        return c0253am;
    }

    /* JADX INFO: renamed from: i */
    private int m1496i() {
        return C0124p.m960b(this.f1237p) == 1 ? 0 : 1;
    }

    @Override // android.support.v7.view.menu.InterfaceC0207s
    /* JADX INFO: renamed from: a */
    public void mo1497a() {
        if (mo1507d()) {
            return;
        }
        Iterator<C0196h> it = this.f1231j.iterator();
        while (it.hasNext()) {
            m1492c(it.next());
        }
        this.f1231j.clear();
        this.f1224c = this.f1237p;
        if (this.f1224c != null) {
            boolean z = this.f1246y == null;
            this.f1246y = this.f1224c.getViewTreeObserver();
            if (z) {
                this.f1246y.addOnGlobalLayoutListener(this.f1232k);
            }
            this.f1224c.addOnAttachStateChangeListener(this.f1233l);
        }
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: a */
    public void mo1498a(int i) {
        if (this.f1235n != i) {
            this.f1235n = i;
            this.f1236o = C0112d.m902a(i, C0124p.m960b(this.f1237p));
        }
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: a */
    public void mo1499a(C0196h c0196h) {
        c0196h.m1541a(this, this.f1226e);
        if (mo1507d()) {
            m1492c(c0196h);
        } else {
            this.f1231j.add(c0196h);
        }
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public void mo1470a(C0196h c0196h, boolean z) {
        int iM1494d = m1494d(c0196h);
        if (iM1494d < 0) {
            return;
        }
        int i = iM1494d + 1;
        if (i < this.f1223b.size()) {
            this.f1223b.get(i).f1256b.m1544a(false);
        }
        a aVarRemove = this.f1223b.remove(iM1494d);
        aVarRemove.f1256b.m1551b(this);
        if (this.f1225d) {
            aVarRemove.f1255a.m1930b((Object) null);
            aVarRemove.f1255a.m1910b(0);
        }
        aVarRemove.f1255a.mo1504c();
        int size = this.f1223b.size();
        this.f1238q = size > 0 ? this.f1223b.get(size - 1).f1257c : m1496i();
        if (size != 0) {
            if (z) {
                this.f1223b.get(0).f1256b.m1544a(false);
                return;
            }
            return;
        }
        mo1504c();
        if (this.f1245x != null) {
            this.f1245x.mo1324a(c0196h, true);
        }
        if (this.f1246y != null) {
            if (this.f1246y.isAlive()) {
                this.f1246y.removeGlobalOnLayoutListener(this.f1232k);
            }
            this.f1246y = null;
        }
        this.f1224c.removeOnAttachStateChangeListener(this.f1233l);
        this.f1247z.onDismiss();
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public void mo1472a(InterfaceC0203o.a aVar) {
        this.f1245x = aVar;
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: a */
    public void mo1500a(View view) {
        if (this.f1237p != view) {
            this.f1237p = view;
            this.f1236o = C0112d.m902a(this.f1235n, C0124p.m960b(this.f1237p));
        }
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: a */
    public void mo1501a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1247z = onDismissListener;
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: a */
    public void mo1502a(boolean z) {
        this.f1243v = z;
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public boolean mo1476a(SubMenuC0209u subMenuC0209u) {
        for (a aVar : this.f1223b) {
            if (subMenuC0209u == aVar.f1256b) {
                aVar.m1512a().requestFocus();
                return true;
            }
        }
        if (!subMenuC0209u.hasVisibleItems()) {
            return false;
        }
        mo1499a((C0196h) subMenuC0209u);
        if (this.f1245x != null) {
            this.f1245x.mo1325a(subMenuC0209u);
        }
        return true;
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: b */
    public void mo1503b(int i) {
        this.f1239r = true;
        this.f1241t = i;
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: b */
    public void mo1479b(boolean z) {
        Iterator<a> it = this.f1223b.iterator();
        while (it.hasNext()) {
            m1607a(it.next().m1512a().getAdapter()).notifyDataSetChanged();
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
        int size = this.f1223b.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.f1223b.toArray(new a[size]);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = aVarArr[i];
                if (aVar.f1255a.mo1507d()) {
                    aVar.f1255a.mo1504c();
                }
            }
        }
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: c */
    public void mo1505c(int i) {
        this.f1240s = true;
        this.f1242u = i;
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: c */
    public void mo1506c(boolean z) {
        this.f1244w = z;
    }

    @Override // android.support.v7.view.menu.InterfaceC0207s
    /* JADX INFO: renamed from: d */
    public boolean mo1507d() {
        return this.f1223b.size() > 0 && this.f1223b.get(0).f1255a.mo1507d();
    }

    @Override // android.support.v7.view.menu.InterfaceC0207s
    /* JADX INFO: renamed from: e */
    public ListView mo1508e() {
        if (this.f1223b.isEmpty()) {
            return null;
        }
        return this.f1223b.get(this.f1223b.size() - 1).m1512a();
    }

    @Override // android.support.v7.view.menu.AbstractC0201m
    /* JADX INFO: renamed from: f */
    protected boolean mo1509f() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        a aVar;
        int size = this.f1223b.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.f1223b.get(i);
            if (!aVar.f1255a.mo1507d()) {
                break;
            } else {
                i++;
            }
        }
        if (aVar != null) {
            aVar.f1256b.m1544a(false);
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
