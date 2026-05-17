package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p010c.p011a.InterfaceMenuItemC0084b;
import android.support.v4.p010c.p011a.InterfaceSubMenuC0085c;
import android.support.v4.p014f.C0090a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: android.support.v7.view.menu.c */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0191c<T> extends C0192d<T> {

    /* JADX INFO: renamed from: a */
    final Context f1218a;

    /* JADX INFO: renamed from: c */
    private Map<InterfaceMenuItemC0084b, MenuItem> f1219c;

    /* JADX INFO: renamed from: d */
    private Map<InterfaceSubMenuC0085c, SubMenu> f1220d;

    AbstractC0191c(Context context, T t) {
        super(t);
        this.f1218a = context;
    }

    /* JADX INFO: renamed from: a */
    final MenuItem m1482a(MenuItem menuItem) {
        if (!(menuItem instanceof InterfaceMenuItemC0084b)) {
            return menuItem;
        }
        InterfaceMenuItemC0084b interfaceMenuItemC0084b = (InterfaceMenuItemC0084b) menuItem;
        if (this.f1219c == null) {
            this.f1219c = new C0090a();
        }
        MenuItem menuItem2 = this.f1219c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItem menuItemM1626a = C0205q.m1626a(this.f1218a, interfaceMenuItemC0084b);
        this.f1219c.put(interfaceMenuItemC0084b, menuItemM1626a);
        return menuItemM1626a;
    }

    /* JADX INFO: renamed from: a */
    final SubMenu m1483a(SubMenu subMenu) {
        if (!(subMenu instanceof InterfaceSubMenuC0085c)) {
            return subMenu;
        }
        InterfaceSubMenuC0085c interfaceSubMenuC0085c = (InterfaceSubMenuC0085c) subMenu;
        if (this.f1220d == null) {
            this.f1220d = new C0090a();
        }
        SubMenu subMenu2 = this.f1220d.get(interfaceSubMenuC0085c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenu subMenuM1627a = C0205q.m1627a(this.f1218a, interfaceSubMenuC0085c);
        this.f1220d.put(interfaceSubMenuC0085c, subMenuM1627a);
        return subMenuM1627a;
    }

    /* JADX INFO: renamed from: a */
    final void m1484a() {
        if (this.f1219c != null) {
            this.f1219c.clear();
        }
        if (this.f1220d != null) {
            this.f1220d.clear();
        }
    }

    /* JADX INFO: renamed from: a */
    final void m1485a(int i) {
        if (this.f1219c == null) {
            return;
        }
        Iterator<InterfaceMenuItemC0084b> it = this.f1219c.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getGroupId()) {
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    final void m1486b(int i) {
        if (this.f1219c == null) {
            return;
        }
        Iterator<InterfaceMenuItemC0084b> it = this.f1219c.keySet().iterator();
        while (it.hasNext()) {
            if (i == it.next().getItemId()) {
                it.remove();
                return;
            }
        }
    }
}
