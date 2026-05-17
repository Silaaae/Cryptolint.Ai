package android.support.v4.p015g;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.v4.p010c.p011a.InterfaceMenuItemC0084b;
import android.util.Log;
import android.view.MenuItem;

/* JADX INFO: renamed from: android.support.v4.g.g */
/* JADX INFO: loaded from: classes.dex */
public final class C0115g {

    /* JADX INFO: renamed from: a */
    static final c f660a;

    /* JADX INFO: renamed from: android.support.v4.g.g$a */
    static class a extends b {
        a() {
        }

        @Override // android.support.v4.p015g.C0115g.b, android.support.v4.p015g.C0115g.c
        /* JADX INFO: renamed from: a */
        public void mo915a(MenuItem menuItem, char c, int i) {
            menuItem.setAlphabeticShortcut(c, i);
        }

        @Override // android.support.v4.p015g.C0115g.b, android.support.v4.p015g.C0115g.c
        /* JADX INFO: renamed from: a */
        public void mo916a(MenuItem menuItem, ColorStateList colorStateList) {
            menuItem.setIconTintList(colorStateList);
        }

        @Override // android.support.v4.p015g.C0115g.b, android.support.v4.p015g.C0115g.c
        /* JADX INFO: renamed from: a */
        public void mo917a(MenuItem menuItem, PorterDuff.Mode mode) {
            menuItem.setIconTintMode(mode);
        }

        @Override // android.support.v4.p015g.C0115g.b, android.support.v4.p015g.C0115g.c
        /* JADX INFO: renamed from: a */
        public void mo918a(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setContentDescription(charSequence);
        }

        @Override // android.support.v4.p015g.C0115g.b, android.support.v4.p015g.C0115g.c
        /* JADX INFO: renamed from: b */
        public void mo919b(MenuItem menuItem, char c, int i) {
            menuItem.setNumericShortcut(c, i);
        }

        @Override // android.support.v4.p015g.C0115g.b, android.support.v4.p015g.C0115g.c
        /* JADX INFO: renamed from: b */
        public void mo920b(MenuItem menuItem, CharSequence charSequence) {
            menuItem.setTooltipText(charSequence);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.g$b */
    static class b implements c {
        b() {
        }

        @Override // android.support.v4.p015g.C0115g.c
        /* JADX INFO: renamed from: a */
        public void mo915a(MenuItem menuItem, char c, int i) {
        }

        @Override // android.support.v4.p015g.C0115g.c
        /* JADX INFO: renamed from: a */
        public void mo916a(MenuItem menuItem, ColorStateList colorStateList) {
        }

        @Override // android.support.v4.p015g.C0115g.c
        /* JADX INFO: renamed from: a */
        public void mo917a(MenuItem menuItem, PorterDuff.Mode mode) {
        }

        @Override // android.support.v4.p015g.C0115g.c
        /* JADX INFO: renamed from: a */
        public void mo918a(MenuItem menuItem, CharSequence charSequence) {
        }

        @Override // android.support.v4.p015g.C0115g.c
        /* JADX INFO: renamed from: b */
        public void mo919b(MenuItem menuItem, char c, int i) {
        }

        @Override // android.support.v4.p015g.C0115g.c
        /* JADX INFO: renamed from: b */
        public void mo920b(MenuItem menuItem, CharSequence charSequence) {
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.g$c */
    interface c {
        /* JADX INFO: renamed from: a */
        void mo915a(MenuItem menuItem, char c, int i);

        /* JADX INFO: renamed from: a */
        void mo916a(MenuItem menuItem, ColorStateList colorStateList);

        /* JADX INFO: renamed from: a */
        void mo917a(MenuItem menuItem, PorterDuff.Mode mode);

        /* JADX INFO: renamed from: a */
        void mo918a(MenuItem menuItem, CharSequence charSequence);

        /* JADX INFO: renamed from: b */
        void mo919b(MenuItem menuItem, char c, int i);

        /* JADX INFO: renamed from: b */
        void mo920b(MenuItem menuItem, CharSequence charSequence);
    }

    static {
        f660a = Build.VERSION.SDK_INT >= 26 ? new a() : new b();
    }

    /* JADX INFO: renamed from: a */
    public static MenuItem m908a(MenuItem menuItem, AbstractC0111c abstractC0111c) {
        if (menuItem instanceof InterfaceMenuItemC0084b) {
            return ((InterfaceMenuItemC0084b) menuItem).mo716a(abstractC0111c);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    /* JADX INFO: renamed from: a */
    public static void m909a(MenuItem menuItem, char c2, int i) {
        if (menuItem instanceof InterfaceMenuItemC0084b) {
            ((InterfaceMenuItemC0084b) menuItem).setNumericShortcut(c2, i);
        } else {
            f660a.mo919b(menuItem, c2, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m910a(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof InterfaceMenuItemC0084b) {
            ((InterfaceMenuItemC0084b) menuItem).setIconTintList(colorStateList);
        } else {
            f660a.mo916a(menuItem, colorStateList);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m911a(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof InterfaceMenuItemC0084b) {
            ((InterfaceMenuItemC0084b) menuItem).setIconTintMode(mode);
        } else {
            f660a.mo917a(menuItem, mode);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m912a(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof InterfaceMenuItemC0084b) {
            ((InterfaceMenuItemC0084b) menuItem).mo717a(charSequence);
        } else {
            f660a.mo918a(menuItem, charSequence);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m913b(MenuItem menuItem, char c2, int i) {
        if (menuItem instanceof InterfaceMenuItemC0084b) {
            ((InterfaceMenuItemC0084b) menuItem).setAlphabeticShortcut(c2, i);
        } else {
            f660a.mo915a(menuItem, c2, i);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m914b(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof InterfaceMenuItemC0084b) {
            ((InterfaceMenuItemC0084b) menuItem).mo719b(charSequence);
        } else {
            f660a.mo920b(menuItem, charSequence);
        }
    }
}
