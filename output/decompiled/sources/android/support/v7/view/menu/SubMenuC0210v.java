package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p010c.p011a.InterfaceSubMenuC0085c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: renamed from: android.support.v7.view.menu.v */
/* JADX INFO: loaded from: classes.dex */
class SubMenuC0210v extends MenuC0206r implements SubMenu {
    SubMenuC0210v(Context context, InterfaceSubMenuC0085c interfaceSubMenuC0085c) {
        super(context, interfaceSubMenuC0085c);
    }

    /* JADX INFO: renamed from: b */
    public InterfaceSubMenuC0085c m1633b() {
        return (InterfaceSubMenuC0085c) this.f1221b;
    }

    @Override // android.view.SubMenu
    public void clearHeader() {
        m1633b().clearHeader();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return m1482a(m1633b().getItem());
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        m1633b().setHeaderIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        m1633b().setHeaderIcon(drawable);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        m1633b().setHeaderTitle(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m1633b().setHeaderTitle(charSequence);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        m1633b().setHeaderView(view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        m1633b().setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        m1633b().setIcon(drawable);
        return this;
    }
}
