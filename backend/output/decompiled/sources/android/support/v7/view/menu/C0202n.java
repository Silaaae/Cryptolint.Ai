package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.support.v4.p015g.C0112d;
import android.support.v4.p015g.C0124p;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.menu.InterfaceC0203o;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

/* JADX INFO: renamed from: android.support.v7.view.menu.n */
/* JADX INFO: loaded from: classes.dex */
public class C0202n {

    /* JADX INFO: renamed from: a */
    private final Context f1350a;

    /* JADX INFO: renamed from: b */
    private final C0196h f1351b;

    /* JADX INFO: renamed from: c */
    private final boolean f1352c;

    /* JADX INFO: renamed from: d */
    private final int f1353d;

    /* JADX INFO: renamed from: e */
    private final int f1354e;

    /* JADX INFO: renamed from: f */
    private View f1355f;

    /* JADX INFO: renamed from: g */
    private int f1356g;

    /* JADX INFO: renamed from: h */
    private boolean f1357h;

    /* JADX INFO: renamed from: i */
    private InterfaceC0203o.a f1358i;

    /* JADX INFO: renamed from: j */
    private AbstractC0201m f1359j;

    /* JADX INFO: renamed from: k */
    private PopupWindow.OnDismissListener f1360k;

    /* JADX INFO: renamed from: l */
    private final PopupWindow.OnDismissListener f1361l;

    public C0202n(Context context, C0196h c0196h, View view, boolean z, int i) {
        this(context, c0196h, view, z, i, 0);
    }

    public C0202n(Context context, C0196h c0196h, View view, boolean z, int i, int i2) {
        this.f1356g = 8388611;
        this.f1361l = new PopupWindow.OnDismissListener() { // from class: android.support.v7.view.menu.n.1
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                C0202n.this.mo1623e();
            }
        };
        this.f1350a = context;
        this.f1351b = c0196h;
        this.f1355f = view;
        this.f1352c = z;
        this.f1353d = i;
        this.f1354e = i2;
    }

    /* JADX INFO: renamed from: a */
    private void m1611a(int i, int i2, boolean z, boolean z2) {
        AbstractC0201m abstractC0201mM1620b = m1620b();
        abstractC0201mM1620b.mo1506c(z2);
        if (z) {
            if ((C0112d.m902a(this.f1356g, C0124p.m960b(this.f1355f)) & 7) == 5) {
                i += this.f1355f.getWidth();
            }
            abstractC0201mM1620b.mo1503b(i);
            abstractC0201mM1620b.mo1505c(i2);
            int i3 = (int) ((this.f1350a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            abstractC0201mM1620b.m1609a(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        abstractC0201mM1620b.mo1497a();
    }

    /* JADX INFO: renamed from: g */
    private AbstractC0201m m1612g() {
        Display defaultDisplay = ((WindowManager) this.f1350a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        AbstractC0201m viewOnKeyListenerC0193e = Math.min(point.x, point.y) >= this.f1350a.getResources().getDimensionPixelSize(C0148a.d.abc_cascading_menus_min_smallest_width) ? new ViewOnKeyListenerC0193e(this.f1350a, this.f1355f, this.f1353d, this.f1354e, this.f1352c) : new ViewOnKeyListenerC0208t(this.f1350a, this.f1351b, this.f1355f, this.f1353d, this.f1354e, this.f1352c);
        viewOnKeyListenerC0193e.mo1499a(this.f1351b);
        viewOnKeyListenerC0193e.mo1501a(this.f1361l);
        viewOnKeyListenerC0193e.mo1500a(this.f1355f);
        viewOnKeyListenerC0193e.mo1472a(this.f1358i);
        viewOnKeyListenerC0193e.mo1502a(this.f1357h);
        viewOnKeyListenerC0193e.mo1498a(this.f1356g);
        return viewOnKeyListenerC0193e;
    }

    /* JADX INFO: renamed from: a */
    public void m1613a() {
        if (!m1621c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1614a(int i) {
        this.f1356g = i;
    }

    /* JADX INFO: renamed from: a */
    public void m1615a(InterfaceC0203o.a aVar) {
        this.f1358i = aVar;
        if (this.f1359j != null) {
            this.f1359j.mo1472a(aVar);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1616a(View view) {
        this.f1355f = view;
    }

    /* JADX INFO: renamed from: a */
    public void m1617a(PopupWindow.OnDismissListener onDismissListener) {
        this.f1360k = onDismissListener;
    }

    /* JADX INFO: renamed from: a */
    public void m1618a(boolean z) {
        this.f1357h = z;
        if (this.f1359j != null) {
            this.f1359j.mo1502a(z);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m1619a(int i, int i2) {
        if (m1624f()) {
            return true;
        }
        if (this.f1355f == null) {
            return false;
        }
        m1611a(i, i2, true, true);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public AbstractC0201m m1620b() {
        if (this.f1359j == null) {
            this.f1359j = m1612g();
        }
        return this.f1359j;
    }

    /* JADX INFO: renamed from: c */
    public boolean m1621c() {
        if (m1624f()) {
            return true;
        }
        if (this.f1355f == null) {
            return false;
        }
        m1611a(0, 0, false, false);
        return true;
    }

    /* JADX INFO: renamed from: d */
    public void m1622d() {
        if (m1624f()) {
            this.f1359j.mo1504c();
        }
    }

    /* JADX INFO: renamed from: e */
    protected void mo1623e() {
        this.f1359j = null;
        if (this.f1360k != null) {
            this.f1360k.onDismiss();
        }
    }

    /* JADX INFO: renamed from: f */
    public boolean m1624f() {
        return this.f1359j != null && this.f1359j.mo1507d();
    }
}
