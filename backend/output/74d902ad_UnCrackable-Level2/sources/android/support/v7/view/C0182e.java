package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.AbstractC0179b;
import android.support.v7.view.menu.C0196h;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: android.support.v7.view.e */
/* JADX INFO: loaded from: classes.dex */
public class C0182e extends AbstractC0179b implements C0196h.a {

    /* JADX INFO: renamed from: a */
    private Context f1092a;

    /* JADX INFO: renamed from: b */
    private ActionBarContextView f1093b;

    /* JADX INFO: renamed from: c */
    private AbstractC0179b.a f1094c;

    /* JADX INFO: renamed from: d */
    private WeakReference<View> f1095d;

    /* JADX INFO: renamed from: e */
    private boolean f1096e;

    /* JADX INFO: renamed from: f */
    private boolean f1097f;

    /* JADX INFO: renamed from: g */
    private C0196h f1098g;

    public C0182e(Context context, ActionBarContextView actionBarContextView, AbstractC0179b.a aVar, boolean z) {
        this.f1092a = context;
        this.f1093b = actionBarContextView;
        this.f1094c = aVar;
        this.f1098g = new C0196h(actionBarContextView.getContext()).m1530a(1);
        this.f1098g.mo1538a(this);
        this.f1097f = z;
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: a */
    public MenuInflater mo1373a() {
        return new C0184g(this.f1093b.getContext());
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: a */
    public void mo1374a(int i) {
        mo1380b(this.f1092a.getString(i));
    }

    @Override // android.support.v7.view.menu.C0196h.a
    /* JADX INFO: renamed from: a */
    public void mo1306a(C0196h c0196h) {
        mo1382d();
        this.f1093b.mo1639a();
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: a */
    public void mo1375a(View view) {
        this.f1093b.setCustomView(view);
        this.f1095d = view != null ? new WeakReference<>(view) : null;
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: a */
    public void mo1376a(CharSequence charSequence) {
        this.f1093b.setSubtitle(charSequence);
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: a */
    public void mo1377a(boolean z) {
        super.mo1377a(z);
        this.f1093b.setTitleOptional(z);
    }

    @Override // android.support.v7.view.menu.C0196h.a
    /* JADX INFO: renamed from: a */
    public boolean mo1308a(C0196h c0196h, MenuItem menuItem) {
        return this.f1094c.mo1328a(this, menuItem);
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: b */
    public Menu mo1378b() {
        return this.f1098g;
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: b */
    public void mo1379b(int i) {
        mo1376a((CharSequence) this.f1092a.getString(i));
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: b */
    public void mo1380b(CharSequence charSequence) {
        this.f1093b.setTitle(charSequence);
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: c */
    public void mo1381c() {
        if (this.f1096e) {
            return;
        }
        this.f1096e = true;
        this.f1093b.sendAccessibilityEvent(32);
        this.f1094c.mo1326a(this);
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: d */
    public void mo1382d() {
        this.f1094c.mo1329b(this, this.f1098g);
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: f */
    public CharSequence mo1384f() {
        return this.f1093b.getTitle();
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: g */
    public CharSequence mo1385g() {
        return this.f1093b.getSubtitle();
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: h */
    public boolean mo1386h() {
        return this.f1093b.m1642d();
    }

    @Override // android.support.v7.view.AbstractC0179b
    /* JADX INFO: renamed from: i */
    public View mo1387i() {
        if (this.f1095d != null) {
            return this.f1095d.get();
        }
        return null;
    }
}
