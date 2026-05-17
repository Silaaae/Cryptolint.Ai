package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.p010c.p011a.InterfaceMenuItemC0084b;
import android.support.v4.p015g.AbstractC0111c;
import android.support.v7.view.InterfaceC0180c;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: android.support.v7.view.menu.k */
/* JADX INFO: loaded from: classes.dex */
public class MenuItemC0199k extends AbstractC0191c<InterfaceMenuItemC0084b> implements MenuItem {

    /* JADX INFO: renamed from: c */
    private Method f1341c;

    /* JADX INFO: renamed from: android.support.v7.view.menu.k$a */
    class a extends AbstractC0111c {

        /* JADX INFO: renamed from: a */
        final ActionProvider f1342a;

        public a(Context context, ActionProvider actionProvider) {
            super(context);
            this.f1342a = actionProvider;
        }

        @Override // android.support.v4.p015g.AbstractC0111c
        /* JADX INFO: renamed from: a */
        public View mo889a() {
            return this.f1342a.onCreateActionView();
        }

        @Override // android.support.v4.p015g.AbstractC0111c
        /* JADX INFO: renamed from: a */
        public void mo893a(SubMenu subMenu) {
            this.f1342a.onPrepareSubMenu(MenuItemC0199k.this.m1483a(subMenu));
        }

        @Override // android.support.v4.p015g.AbstractC0111c
        /* JADX INFO: renamed from: d */
        public boolean mo897d() {
            return this.f1342a.onPerformDefaultAction();
        }

        @Override // android.support.v4.p015g.AbstractC0111c
        /* JADX INFO: renamed from: e */
        public boolean mo898e() {
            return this.f1342a.hasSubMenu();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.view.menu.k$b */
    static class b extends FrameLayout implements InterfaceC0180c {

        /* JADX INFO: renamed from: a */
        final CollapsibleActionView f1344a;

        /* JADX WARN: Multi-variable type inference failed */
        b(View view) {
            super(view.getContext());
            this.f1344a = (CollapsibleActionView) view;
            addView(view);
        }

        @Override // android.support.v7.view.InterfaceC0180c
        /* JADX INFO: renamed from: a */
        public void mo1416a() {
            this.f1344a.onActionViewExpanded();
        }

        @Override // android.support.v7.view.InterfaceC0180c
        /* JADX INFO: renamed from: b */
        public void mo1417b() {
            this.f1344a.onActionViewCollapsed();
        }

        /* JADX INFO: renamed from: c */
        View m1605c() {
            return (View) this.f1344a;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.view.menu.k$c */
    private class c extends C0192d<MenuItem.OnActionExpandListener> implements MenuItem.OnActionExpandListener {
        c(MenuItem.OnActionExpandListener onActionExpandListener) {
            super(onActionExpandListener);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f1221b).onMenuItemActionCollapse(MenuItemC0199k.this.m1482a(menuItem));
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return ((MenuItem.OnActionExpandListener) this.f1221b).onMenuItemActionExpand(MenuItemC0199k.this.m1482a(menuItem));
        }
    }

    /* JADX INFO: renamed from: android.support.v7.view.menu.k$d */
    private class d extends C0192d<MenuItem.OnMenuItemClickListener> implements MenuItem.OnMenuItemClickListener {
        d(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
            super(onMenuItemClickListener);
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((MenuItem.OnMenuItemClickListener) this.f1221b).onMenuItemClick(MenuItemC0199k.this.m1482a(menuItem));
        }
    }

    MenuItemC0199k(Context context, InterfaceMenuItemC0084b interfaceMenuItemC0084b) {
        super(context, interfaceMenuItemC0084b);
    }

    /* JADX INFO: renamed from: a */
    a mo1603a(ActionProvider actionProvider) {
        return new a(this.f1218a, actionProvider);
    }

    /* JADX INFO: renamed from: a */
    public void m1604a(boolean z) {
        try {
            if (this.f1341c == null) {
                this.f1341c = ((InterfaceMenuItemC0084b) this.f1221b).getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
            }
            this.f1341c.invoke(this.f1221b, Boolean.valueOf(z));
        } catch (Exception e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    @Override // android.view.MenuItem
    public boolean collapseActionView() {
        return ((InterfaceMenuItemC0084b) this.f1221b).collapseActionView();
    }

    @Override // android.view.MenuItem
    public boolean expandActionView() {
        return ((InterfaceMenuItemC0084b) this.f1221b).expandActionView();
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        AbstractC0111c abstractC0111cMo718a = ((InterfaceMenuItemC0084b) this.f1221b).mo718a();
        if (abstractC0111cMo718a instanceof a) {
            return ((a) abstractC0111cMo718a).f1342a;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public View getActionView() {
        View actionView = ((InterfaceMenuItemC0084b) this.f1221b).getActionView();
        return actionView instanceof b ? ((b) actionView).m1605c() : actionView;
    }

    @Override // android.view.MenuItem
    public int getAlphabeticModifiers() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public CharSequence getContentDescription() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getContentDescription();
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getGroupId();
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getIcon();
    }

    @Override // android.view.MenuItem
    public ColorStateList getIconTintList() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getIconTintList();
    }

    @Override // android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getIconTintMode();
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getIntent();
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getItemId();
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getMenuInfo();
    }

    @Override // android.view.MenuItem
    public int getNumericModifiers() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getOrder();
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return m1483a(((InterfaceMenuItemC0084b) this.f1221b).getSubMenu());
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getTitle();
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public CharSequence getTooltipText() {
        return ((InterfaceMenuItemC0084b) this.f1221b).getTooltipText();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return ((InterfaceMenuItemC0084b) this.f1221b).hasSubMenu();
    }

    @Override // android.view.MenuItem
    public boolean isActionViewExpanded() {
        return ((InterfaceMenuItemC0084b) this.f1221b).isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return ((InterfaceMenuItemC0084b) this.f1221b).isCheckable();
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return ((InterfaceMenuItemC0084b) this.f1221b).isChecked();
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return ((InterfaceMenuItemC0084b) this.f1221b).isEnabled();
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return ((InterfaceMenuItemC0084b) this.f1221b).isVisible();
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((InterfaceMenuItemC0084b) this.f1221b).mo716a(actionProvider != null ? mo1603a(actionProvider) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(int i) {
        ((InterfaceMenuItemC0084b) this.f1221b).setActionView(i);
        View actionView = ((InterfaceMenuItemC0084b) this.f1221b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((InterfaceMenuItemC0084b) this.f1221b).setActionView(new b(actionView));
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new b(view);
        }
        ((InterfaceMenuItemC0084b) this.f1221b).setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2) {
        ((InterfaceMenuItemC0084b) this.f1221b).setAlphabeticShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c2, int i) {
        ((InterfaceMenuItemC0084b) this.f1221b).setAlphabeticShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        ((InterfaceMenuItemC0084b) this.f1221b).setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        ((InterfaceMenuItemC0084b) this.f1221b).setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        ((InterfaceMenuItemC0084b) this.f1221b).setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        ((InterfaceMenuItemC0084b) this.f1221b).setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        ((InterfaceMenuItemC0084b) this.f1221b).setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        ((InterfaceMenuItemC0084b) this.f1221b).setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        ((InterfaceMenuItemC0084b) this.f1221b).setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        ((InterfaceMenuItemC0084b) this.f1221b).setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        ((InterfaceMenuItemC0084b) this.f1221b).setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2) {
        ((InterfaceMenuItemC0084b) this.f1221b).setNumericShortcut(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c2, int i) {
        ((InterfaceMenuItemC0084b) this.f1221b).setNumericShortcut(c2, i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        ((InterfaceMenuItemC0084b) this.f1221b).setOnActionExpandListener(onActionExpandListener != null ? new c(onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        ((InterfaceMenuItemC0084b) this.f1221b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new d(onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3) {
        ((InterfaceMenuItemC0084b) this.f1221b).setShortcut(c2, c3);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c2, char c3, int i, int i2) {
        ((InterfaceMenuItemC0084b) this.f1221b).setShortcut(c2, c3, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public void setShowAsAction(int i) {
        ((InterfaceMenuItemC0084b) this.f1221b).setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        ((InterfaceMenuItemC0084b) this.f1221b).setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        ((InterfaceMenuItemC0084b) this.f1221b).setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        ((InterfaceMenuItemC0084b) this.f1221b).setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((InterfaceMenuItemC0084b) this.f1221b).setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        ((InterfaceMenuItemC0084b) this.f1221b).setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        return ((InterfaceMenuItemC0084b) this.f1221b).setVisible(z);
    }
}
