package android.support.v7.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AbstractC0163f;
import android.support.v7.view.AbstractC0179b;
import android.support.v7.view.C0183f;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.view.Window;

/* JADX INFO: renamed from: android.support.v7.app.h */
/* JADX INFO: loaded from: classes.dex */
class C0165h extends LayoutInflaterFactory2C0167j {

    /* JADX INFO: renamed from: t */
    private int f932t;

    /* JADX INFO: renamed from: u */
    private boolean f933u;

    /* JADX INFO: renamed from: v */
    private boolean f934v;

    /* JADX INFO: renamed from: w */
    private b f935w;

    /* JADX INFO: renamed from: android.support.v7.app.h$a */
    class a extends AbstractC0163f.a {
        a(Window.Callback callback) {
            super(C0165h.this, callback);
        }

        /* JADX INFO: renamed from: a */
        final ActionMode m1281a(ActionMode.Callback callback) {
            C0183f.a aVar = new C0183f.a(C0165h.this.f914a, callback);
            AbstractC0179b abstractC0179bB = C0165h.this.m1309b(aVar);
            if (abstractC0179bB != null) {
                return aVar.m1423b(abstractC0179bB);
            }
            return null;
        }

        @Override // android.support.v7.view.WindowCallbackC0186i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return C0165h.this.mo1270o() ? m1281a(callback) : super.onWindowStartingActionMode(callback);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.h$b */
    final class b {

        /* JADX INFO: renamed from: b */
        private C0172o f938b;

        /* JADX INFO: renamed from: c */
        private boolean f939c;

        /* JADX INFO: renamed from: d */
        private BroadcastReceiver f940d;

        /* JADX INFO: renamed from: e */
        private IntentFilter f941e;

        b(C0172o c0172o) {
            this.f938b = c0172o;
            this.f939c = c0172o.m1351a();
        }

        /* JADX INFO: renamed from: a */
        final int m1282a() {
            this.f939c = this.f938b.m1351a();
            return this.f939c ? 2 : 1;
        }

        /* JADX INFO: renamed from: b */
        final void m1283b() {
            boolean zM1351a = this.f938b.m1351a();
            if (zM1351a != this.f939c) {
                this.f939c = zM1351a;
                C0165h.this.mo1259i();
            }
        }

        /* JADX INFO: renamed from: c */
        final void m1284c() {
            m1285d();
            if (this.f940d == null) {
                this.f940d = new BroadcastReceiver() { // from class: android.support.v7.app.h.b.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(Context context, Intent intent) {
                        b.this.m1283b();
                    }
                };
            }
            if (this.f941e == null) {
                this.f941e = new IntentFilter();
                this.f941e.addAction("android.intent.action.TIME_SET");
                this.f941e.addAction("android.intent.action.TIMEZONE_CHANGED");
                this.f941e.addAction("android.intent.action.TIME_TICK");
            }
            C0165h.this.f914a.registerReceiver(this.f940d, this.f941e);
        }

        /* JADX INFO: renamed from: d */
        final void m1285d() {
            if (this.f940d != null) {
                C0165h.this.f914a.unregisterReceiver(this.f940d);
                this.f940d = null;
            }
        }
    }

    C0165h(Context context, Window window, InterfaceC0161d interfaceC0161d) {
        super(context, window, interfaceC0161d);
        this.f932t = -100;
        this.f934v = true;
    }

    /* JADX INFO: renamed from: h */
    private boolean m1275h(int i) {
        Resources resources = this.f914a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        if (m1278y()) {
            ((Activity) this.f914a).recreate();
            return true;
        }
        Configuration configuration2 = new Configuration(configuration);
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        resources.updateConfiguration(configuration2, displayMetrics);
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        C0169l.m1338a(resources);
        return true;
    }

    /* JADX INFO: renamed from: w */
    private int m1276w() {
        return this.f932t != -100 ? this.f932t : m1238j();
    }

    /* JADX INFO: renamed from: x */
    private void m1277x() {
        if (this.f935w == null) {
            this.f935w = new b(C0172o.m1347a(this.f914a));
        }
    }

    /* JADX INFO: renamed from: y */
    private boolean m1278y() {
        if (!this.f933u || !(this.f914a instanceof Activity)) {
            return false;
        }
        try {
            return (this.f914a.getPackageManager().getActivityInfo(new ComponentName(this.f914a, this.f914a.getClass()), 0).configChanges & 512) == 0;
        } catch (PackageManager.NameNotFoundException e) {
            Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e);
            return true;
        }
    }

    @Override // android.support.v7.app.LayoutInflaterFactory2C0167j
    /* JADX INFO: renamed from: a */
    View mo1279a(View view, String str, Context context, AttributeSet attributeSet) {
        return null;
    }

    @Override // android.support.v7.app.AbstractC0163f
    /* JADX INFO: renamed from: a */
    Window.Callback mo1261a(Window.Callback callback) {
        return new a(callback);
    }

    @Override // android.support.v7.app.LayoutInflaterFactory2C0167j, android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: a */
    public void mo1243a(Bundle bundle) {
        super.mo1243a(bundle);
        if (bundle == null || this.f932t != -100) {
            return;
        }
        this.f932t = bundle.getInt("appcompat:local_night_mode", -100);
    }

    @Override // android.support.v7.app.AbstractC0163f, android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: c */
    public void mo1251c() {
        super.mo1251c();
        mo1259i();
    }

    @Override // android.support.v7.app.AbstractC0163f, android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: c */
    public void mo1252c(Bundle bundle) {
        super.mo1252c(bundle);
        if (this.f932t != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f932t);
        }
    }

    /* JADX INFO: renamed from: d */
    int mo1280d(int i) {
        if (i == -100) {
            return -1;
        }
        if (i != 0) {
            return i;
        }
        m1277x();
        return this.f935w.m1282a();
    }

    @Override // android.support.v7.app.LayoutInflaterFactory2C0167j, android.support.v7.app.AbstractC0163f, android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: d */
    public void mo1254d() {
        super.mo1254d();
        if (this.f935w != null) {
            this.f935w.m1285d();
        }
    }

    @Override // android.support.v7.app.LayoutInflaterFactory2C0167j, android.support.v7.app.AbstractC0163f, android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: g */
    public void mo1257g() {
        super.mo1257g();
        if (this.f935w != null) {
            this.f935w.m1285d();
        }
    }

    @Override // android.support.v7.app.AbstractC0163f, android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: i */
    public boolean mo1259i() {
        int iM1276w = m1276w();
        int iMo1280d = mo1280d(iM1276w);
        boolean zM1275h = iMo1280d != -1 ? m1275h(iMo1280d) : false;
        if (iM1276w == 0) {
            m1277x();
            this.f935w.m1284c();
        }
        this.f933u = true;
        return zM1275h;
    }

    @Override // android.support.v7.app.AbstractC0163f
    /* JADX INFO: renamed from: o */
    public boolean mo1270o() {
        return this.f934v;
    }
}
