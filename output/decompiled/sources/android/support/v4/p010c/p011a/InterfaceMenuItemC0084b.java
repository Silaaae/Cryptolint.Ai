package android.support.v4.p010c.p011a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.v4.p015g.AbstractC0111c;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: renamed from: android.support.v4.c.a.b */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceMenuItemC0084b extends MenuItem {
    /* JADX INFO: renamed from: a */
    InterfaceMenuItemC0084b mo716a(AbstractC0111c abstractC0111c);

    /* JADX INFO: renamed from: a */
    InterfaceMenuItemC0084b mo717a(CharSequence charSequence);

    /* JADX INFO: renamed from: a */
    AbstractC0111c mo718a();

    /* JADX INFO: renamed from: b */
    InterfaceMenuItemC0084b mo719b(CharSequence charSequence);

    @Override // android.view.MenuItem
    boolean collapseActionView();

    @Override // android.view.MenuItem
    boolean expandActionView();

    @Override // android.view.MenuItem
    View getActionView();

    @Override // android.view.MenuItem
    int getAlphabeticModifiers();

    @Override // android.view.MenuItem
    CharSequence getContentDescription();

    @Override // android.view.MenuItem
    ColorStateList getIconTintList();

    @Override // android.view.MenuItem
    PorterDuff.Mode getIconTintMode();

    @Override // android.view.MenuItem
    int getNumericModifiers();

    @Override // android.view.MenuItem
    CharSequence getTooltipText();

    @Override // android.view.MenuItem
    boolean isActionViewExpanded();

    @Override // android.view.MenuItem
    MenuItem setActionView(int i);

    @Override // android.view.MenuItem
    MenuItem setActionView(View view);

    @Override // android.view.MenuItem
    MenuItem setAlphabeticShortcut(char c, int i);

    @Override // android.view.MenuItem
    MenuItem setIconTintList(ColorStateList colorStateList);

    @Override // android.view.MenuItem
    MenuItem setIconTintMode(PorterDuff.Mode mode);

    @Override // android.view.MenuItem
    MenuItem setNumericShortcut(char c, int i);

    @Override // android.view.MenuItem
    MenuItem setShortcut(char c, char c2, int i, int i2);

    @Override // android.view.MenuItem
    void setShowAsAction(int i);

    @Override // android.view.MenuItem
    MenuItem setShowAsActionFlags(int i);
}
