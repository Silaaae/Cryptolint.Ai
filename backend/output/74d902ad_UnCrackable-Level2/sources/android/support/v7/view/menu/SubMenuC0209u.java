package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.view.menu.C0196h;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: renamed from: android.support.v7.view.menu.u */
/* JADX INFO: loaded from: classes.dex */
public class SubMenuC0209u extends C0196h implements SubMenu {

    /* JADX INFO: renamed from: d */
    private C0196h f1385d;

    /* JADX INFO: renamed from: e */
    private C0198j f1386e;

    public SubMenuC0209u(Context context, C0196h c0196h, C0198j c0198j) {
        super(context);
        this.f1385d = c0196h;
        this.f1386e = c0198j;
    }

    @Override // android.support.v7.view.menu.C0196h
    /* JADX INFO: renamed from: a */
    public String mo1536a() {
        int itemId = this.f1386e != null ? this.f1386e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo1536a() + ":" + itemId;
    }

    @Override // android.support.v7.view.menu.C0196h
    /* JADX INFO: renamed from: a */
    public void mo1538a(C0196h.a aVar) {
        this.f1385d.mo1538a(aVar);
    }

    @Override // android.support.v7.view.menu.C0196h
    /* JADX INFO: renamed from: a */
    boolean mo1545a(C0196h c0196h, MenuItem menuItem) {
        return super.mo1545a(c0196h, menuItem) || this.f1385d.mo1545a(c0196h, menuItem);
    }

    @Override // android.support.v7.view.menu.C0196h
    /* JADX INFO: renamed from: b */
    public boolean mo1553b() {
        return this.f1385d.mo1553b();
    }

    @Override // android.support.v7.view.menu.C0196h
    /* JADX INFO: renamed from: c */
    public boolean mo1556c() {
        return this.f1385d.mo1556c();
    }

    @Override // android.support.v7.view.menu.C0196h
    /* JADX INFO: renamed from: c */
    public boolean mo1557c(C0198j c0198j) {
        return this.f1385d.mo1557c(c0198j);
    }

    @Override // android.support.v7.view.menu.C0196h
    /* JADX INFO: renamed from: d */
    public boolean mo1560d(C0198j c0198j) {
        return this.f1385d.mo1560d(c0198j);
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.f1386e;
    }

    @Override // android.support.v7.view.menu.C0196h
    /* JADX INFO: renamed from: p */
    public C0196h mo1573p() {
        return this.f1385d.mo1573p();
    }

    /* JADX INFO: renamed from: s */
    public Menu m1632s() {
        return this.f1385d;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        return (SubMenu) super.m1562e(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        return (SubMenu) super.m1531a(drawable);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        return (SubMenu) super.m1559d(i);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        return (SubMenu) super.m1533a(charSequence);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        return (SubMenu) super.m1532a(view);
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.f1386e.setIcon(i);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.f1386e.setIcon(drawable);
        return this;
    }

    @Override // android.support.v7.view.menu.C0196h, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f1385d.setQwertyMode(z);
    }
}
