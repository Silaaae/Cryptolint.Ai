package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build;
import android.support.v4.p010c.p011a.InterfaceMenuC0083a;
import android.support.v4.p010c.p011a.InterfaceMenuItemC0084b;
import android.support.v4.p010c.p011a.InterfaceSubMenuC0085c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: renamed from: android.support.v7.view.menu.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0205q {
    /* JADX INFO: renamed from: a */
    public static Menu m1625a(Context context, InterfaceMenuC0083a interfaceMenuC0083a) {
        return new MenuC0206r(context, interfaceMenuC0083a);
    }

    /* JADX INFO: renamed from: a */
    public static MenuItem m1626a(Context context, InterfaceMenuItemC0084b interfaceMenuItemC0084b) {
        return Build.VERSION.SDK_INT >= 16 ? new C0200l(context, interfaceMenuItemC0084b) : new MenuItemC0199k(context, interfaceMenuItemC0084b);
    }

    /* JADX INFO: renamed from: a */
    public static SubMenu m1627a(Context context, InterfaceSubMenuC0085c interfaceSubMenuC0085c) {
        return new SubMenuC0210v(context, interfaceSubMenuC0085c);
    }
}
