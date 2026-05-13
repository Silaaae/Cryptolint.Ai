package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityC0050h;
import android.support.v4.app.C0042a;
import android.support.v4.app.C0043aa;
import android.support.v4.app.C0064v;
import android.support.v7.view.AbstractC0179b;
import android.support.v7.widget.C0269bb;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: renamed from: android.support.v7.app.c */
/* JADX INFO: loaded from: classes.dex */
public class ActivityC0160c extends ActivityC0050h implements C0043aa.a, InterfaceC0161d {

    /* JADX INFO: renamed from: m */
    private AbstractC0162e f906m;

    /* JADX INFO: renamed from: n */
    private int f907n = 0;

    /* JADX INFO: renamed from: o */
    private Resources f908o;

    /* JADX INFO: renamed from: a */
    private boolean m1223a(int i, KeyEvent keyEvent) {
        Window window;
        return (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) ? false : true;
    }

    @Override // android.support.v7.app.InterfaceC0161d
    /* JADX INFO: renamed from: a */
    public AbstractC0179b mo1224a(AbstractC0179b.a aVar) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m1225a(C0043aa c0043aa) {
        c0043aa.m232a((Activity) this);
    }

    @Override // android.support.v7.app.InterfaceC0161d
    /* JADX INFO: renamed from: a */
    public void mo1226a(AbstractC0179b abstractC0179b) {
    }

    /* JADX INFO: renamed from: a */
    public boolean m1227a(Intent intent) {
        return C0064v.m631a(this, intent);
    }

    @Override // android.support.v4.app.C0043aa.a
    /* JADX INFO: renamed from: a_ */
    public Intent mo237a_() {
        return C0064v.m629a(this);
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m1234j().mo1250b(view, layoutParams);
    }

    /* JADX INFO: renamed from: b */
    public void m1228b(Intent intent) {
        C0064v.m634b(this, intent);
    }

    /* JADX INFO: renamed from: b */
    public void m1229b(C0043aa c0043aa) {
    }

    @Override // android.support.v7.app.InterfaceC0161d
    /* JADX INFO: renamed from: b */
    public void mo1230b(AbstractC0179b abstractC0179b) {
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        AbstractC0158a abstractC0158aM1231g = m1231g();
        if (getWindow().hasFeature(0)) {
            if (abstractC0158aM1231g == null || !abstractC0158aM1231g.mo1204d()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // android.support.v4.app.ActivityC0050h
    /* JADX INFO: renamed from: d */
    public void mo386d() {
        m1234j().mo1256f();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        AbstractC0158a abstractC0158aM1231g = m1231g();
        if (keyCode == 82 && abstractC0158aM1231g != null && abstractC0158aM1231g.mo1198a(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        return (T) m1234j().mo1241a(i);
    }

    /* JADX INFO: renamed from: g */
    public AbstractC0158a m1231g() {
        return m1234j().mo1240a();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return m1234j().mo1247b();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f908o == null && C0269bb.m2024a()) {
            this.f908o = new C0269bb(this, super.getResources());
        }
        return this.f908o == null ? super.getResources() : this.f908o;
    }

    /* JADX INFO: renamed from: h */
    public boolean m1232h() {
        Intent intentMo237a_ = mo237a_();
        if (intentMo237a_ == null) {
            return false;
        }
        if (!m1227a(intentMo237a_)) {
            m1228b(intentMo237a_);
            return true;
        }
        C0043aa c0043aaM231a = C0043aa.m231a((Context) this);
        m1225a(c0043aaM231a);
        m1229b(c0043aaM231a);
        c0043aaM231a.m235a();
        try {
            C0042a.m229a(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Deprecated
    /* JADX INFO: renamed from: i */
    public void m1233i() {
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        m1234j().mo1256f();
    }

    /* JADX INFO: renamed from: j */
    public AbstractC0162e m1234j() {
        if (this.f906m == null) {
            this.f906m = AbstractC0162e.m1235a(this, this);
        }
        return this.f906m;
    }

    @Override // android.support.v4.app.ActivityC0050h, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m1234j().mo1242a(configuration);
        if (this.f908o != null) {
            this.f908o.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        m1233i();
    }

    @Override // android.support.v4.app.ActivityC0050h, android.support.v4.app.ActivityC0068z, android.app.Activity
    protected void onCreate(Bundle bundle) {
        AbstractC0162e abstractC0162eM1234j = m1234j();
        abstractC0162eM1234j.mo1258h();
        abstractC0162eM1234j.mo1243a(bundle);
        if (abstractC0162eM1234j.mo1259i() && this.f907n != 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f907n, false);
            } else {
                setTheme(this.f907n);
            }
        }
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.ActivityC0050h, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        m1234j().mo1257g();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (m1223a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v4.app.ActivityC0050h, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        AbstractC0158a abstractC0158aM1231g = m1231g();
        if (menuItem.getItemId() != 16908332 || abstractC0158aM1231g == null || (abstractC0158aM1231g.mo1191a() & 4) == 0) {
            return false;
        }
        return m1232h();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // android.support.v4.app.ActivityC0050h, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m1234j().mo1249b(bundle);
    }

    @Override // android.support.v4.app.ActivityC0050h, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        m1234j().mo1255e();
    }

    @Override // android.support.v4.app.ActivityC0050h, android.support.v4.app.ActivityC0068z, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m1234j().mo1252c(bundle);
    }

    @Override // android.support.v4.app.ActivityC0050h, android.app.Activity
    protected void onStart() {
        super.onStart();
        m1234j().mo1251c();
    }

    @Override // android.support.v4.app.ActivityC0050h, android.app.Activity
    protected void onStop() {
        super.onStop();
        m1234j().mo1254d();
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m1234j().mo1246a(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        AbstractC0158a abstractC0158aM1231g = m1231g();
        if (getWindow().hasFeature(0)) {
            if (abstractC0158aM1231g == null || !abstractC0158aM1231g.mo1202c()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        m1234j().mo1248b(i);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        m1234j().mo1244a(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m1234j().mo1245a(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        this.f907n = i;
    }
}
