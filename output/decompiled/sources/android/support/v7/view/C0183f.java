package android.support.v7.view;

import android.content.Context;
import android.support.v4.p010c.p011a.InterfaceMenuC0083a;
import android.support.v4.p010c.p011a.InterfaceMenuItemC0084b;
import android.support.v4.p014f.C0100k;
import android.support.v7.view.AbstractC0179b;
import android.support.v7.view.menu.C0205q;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: renamed from: android.support.v7.view.f */
/* JADX INFO: loaded from: classes.dex */
public class C0183f extends ActionMode {

    /* JADX INFO: renamed from: a */
    final Context f1099a;

    /* JADX INFO: renamed from: b */
    final AbstractC0179b f1100b;

    /* JADX INFO: renamed from: android.support.v7.view.f$a */
    public static class a implements AbstractC0179b.a {

        /* JADX INFO: renamed from: a */
        final ActionMode.Callback f1101a;

        /* JADX INFO: renamed from: b */
        final Context f1102b;

        /* JADX INFO: renamed from: c */
        final ArrayList<C0183f> f1103c = new ArrayList<>();

        /* JADX INFO: renamed from: d */
        final C0100k<Menu, Menu> f1104d = new C0100k<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f1102b = context;
            this.f1101a = callback;
        }

        /* JADX INFO: renamed from: a */
        private Menu m1422a(Menu menu) {
            Menu menu2 = this.f1104d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            Menu menuM1625a = C0205q.m1625a(this.f1102b, (InterfaceMenuC0083a) menu);
            this.f1104d.put(menu, menuM1625a);
            return menuM1625a;
        }

        @Override // android.support.v7.view.AbstractC0179b.a
        /* JADX INFO: renamed from: a */
        public void mo1326a(AbstractC0179b abstractC0179b) {
            this.f1101a.onDestroyActionMode(m1423b(abstractC0179b));
        }

        @Override // android.support.v7.view.AbstractC0179b.a
        /* JADX INFO: renamed from: a */
        public boolean mo1327a(AbstractC0179b abstractC0179b, Menu menu) {
            return this.f1101a.onCreateActionMode(m1423b(abstractC0179b), m1422a(menu));
        }

        @Override // android.support.v7.view.AbstractC0179b.a
        /* JADX INFO: renamed from: a */
        public boolean mo1328a(AbstractC0179b abstractC0179b, MenuItem menuItem) {
            return this.f1101a.onActionItemClicked(m1423b(abstractC0179b), C0205q.m1626a(this.f1102b, (InterfaceMenuItemC0084b) menuItem));
        }

        /* JADX INFO: renamed from: b */
        public ActionMode m1423b(AbstractC0179b abstractC0179b) {
            int size = this.f1103c.size();
            for (int i = 0; i < size; i++) {
                C0183f c0183f = this.f1103c.get(i);
                if (c0183f != null && c0183f.f1100b == abstractC0179b) {
                    return c0183f;
                }
            }
            C0183f c0183f2 = new C0183f(this.f1102b, abstractC0179b);
            this.f1103c.add(c0183f2);
            return c0183f2;
        }

        @Override // android.support.v7.view.AbstractC0179b.a
        /* JADX INFO: renamed from: b */
        public boolean mo1329b(AbstractC0179b abstractC0179b, Menu menu) {
            return this.f1101a.onPrepareActionMode(m1423b(abstractC0179b), m1422a(menu));
        }
    }

    public C0183f(Context context, AbstractC0179b abstractC0179b) {
        this.f1099a = context;
        this.f1100b = abstractC0179b;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f1100b.mo1381c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f1100b.mo1387i();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return C0205q.m1625a(this.f1099a, (InterfaceMenuC0083a) this.f1100b.mo1378b());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f1100b.mo1373a();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f1100b.mo1385g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f1100b.m1414j();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f1100b.mo1384f();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f1100b.m1415k();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f1100b.mo1382d();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f1100b.mo1386h();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f1100b.mo1375a(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.f1100b.mo1379b(i);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f1100b.mo1376a(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f1100b.m1413a(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.f1100b.mo1374a(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f1100b.mo1380b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.f1100b.mo1377a(z);
    }
}
