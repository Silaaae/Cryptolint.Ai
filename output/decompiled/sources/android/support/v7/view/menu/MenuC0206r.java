package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.p010c.p011a.InterfaceMenuC0083a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: renamed from: android.support.v7.view.menu.r */
/* JADX INFO: loaded from: classes.dex */
class MenuC0206r extends AbstractC0191c<InterfaceMenuC0083a> implements Menu {
    MenuC0206r(Context context, InterfaceMenuC0083a interfaceMenuC0083a) {
        super(context, interfaceMenuC0083a);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return m1482a(((InterfaceMenuC0083a) this.f1221b).add(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return m1482a(((InterfaceMenuC0083a) this.f1221b).add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m1482a(((InterfaceMenuC0083a) this.f1221b).add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m1482a(((InterfaceMenuC0083a) this.f1221b).add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = ((InterfaceMenuC0083a) this.f1221b).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = m1482a(menuItemArr2[i5]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return m1483a(((InterfaceMenuC0083a) this.f1221b).addSubMenu(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m1483a(((InterfaceMenuC0083a) this.f1221b).addSubMenu(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m1483a(((InterfaceMenuC0083a) this.f1221b).addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return m1483a(((InterfaceMenuC0083a) this.f1221b).addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        m1484a();
        ((InterfaceMenuC0083a) this.f1221b).clear();
    }

    @Override // android.view.Menu
    public void close() {
        ((InterfaceMenuC0083a) this.f1221b).close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return m1482a(((InterfaceMenuC0083a) this.f1221b).findItem(i));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return m1482a(((InterfaceMenuC0083a) this.f1221b).getItem(i));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return ((InterfaceMenuC0083a) this.f1221b).hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((InterfaceMenuC0083a) this.f1221b).isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return ((InterfaceMenuC0083a) this.f1221b).performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((InterfaceMenuC0083a) this.f1221b).performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        m1485a(i);
        ((InterfaceMenuC0083a) this.f1221b).removeGroup(i);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        m1486b(i);
        ((InterfaceMenuC0083a) this.f1221b).removeItem(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((InterfaceMenuC0083a) this.f1221b).setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        ((InterfaceMenuC0083a) this.f1221b).setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        ((InterfaceMenuC0083a) this.f1221b).setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        ((InterfaceMenuC0083a) this.f1221b).setQwertyMode(z);
    }

    @Override // android.view.Menu
    public int size() {
        return ((InterfaceMenuC0083a) this.f1221b).size();
    }
}
