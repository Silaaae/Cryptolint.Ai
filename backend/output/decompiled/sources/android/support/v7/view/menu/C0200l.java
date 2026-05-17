package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p010c.p011a.InterfaceMenuItemC0084b;
import android.support.v4.p015g.AbstractC0111c;
import android.support.v7.view.menu.MenuItemC0199k;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: renamed from: android.support.v7.view.menu.l */
/* JADX INFO: loaded from: classes.dex */
class C0200l extends MenuItemC0199k {

    /* JADX INFO: renamed from: android.support.v7.view.menu.l$a */
    class a extends MenuItemC0199k.a implements ActionProvider.VisibilityListener {

        /* JADX INFO: renamed from: c */
        AbstractC0111c.b f1347c;

        public a(Context context, ActionProvider actionProvider) {
            super(context, actionProvider);
        }

        @Override // android.support.v4.p015g.AbstractC0111c
        /* JADX INFO: renamed from: a */
        public View mo890a(MenuItem menuItem) {
            return this.f1342a.onCreateActionView(menuItem);
        }

        @Override // android.support.v4.p015g.AbstractC0111c
        /* JADX INFO: renamed from: a */
        public void mo892a(AbstractC0111c.b bVar) {
            this.f1347c = bVar;
            this.f1342a.setVisibilityListener(bVar != null ? this : null);
        }

        @Override // android.support.v4.p015g.AbstractC0111c
        /* JADX INFO: renamed from: b */
        public boolean mo895b() {
            return this.f1342a.overridesItemVisibility();
        }

        @Override // android.support.v4.p015g.AbstractC0111c
        /* JADX INFO: renamed from: c */
        public boolean mo896c() {
            return this.f1342a.isVisible();
        }

        @Override // android.view.ActionProvider.VisibilityListener
        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f1347c != null) {
                this.f1347c.mo901a(z);
            }
        }
    }

    C0200l(Context context, InterfaceMenuItemC0084b interfaceMenuItemC0084b) {
        super(context, interfaceMenuItemC0084b);
    }

    @Override // android.support.v7.view.menu.MenuItemC0199k
    /* JADX INFO: renamed from: a */
    MenuItemC0199k.a mo1603a(ActionProvider actionProvider) {
        return new a(this.f1218a, actionProvider);
    }
}
