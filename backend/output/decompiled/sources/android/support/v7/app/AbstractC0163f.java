package android.support.v7.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.view.AbstractC0179b;
import android.support.v7.view.C0184g;
import android.support.v7.view.WindowCallbackC0186i;
import android.support.v7.view.menu.C0196h;
import android.support.v7.widget.C0263aw;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import java.lang.Thread;

/* JADX INFO: renamed from: android.support.v7.app.f */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractC0163f extends AbstractC0162e {

    /* JADX INFO: renamed from: m */
    private static boolean f911m;

    /* JADX INFO: renamed from: n */
    private static final boolean f912n;

    /* JADX INFO: renamed from: o */
    private static final int[] f913o;

    /* JADX INFO: renamed from: a */
    final Context f914a;

    /* JADX INFO: renamed from: b */
    final Window f915b;

    /* JADX INFO: renamed from: c */
    final Window.Callback f916c;

    /* JADX INFO: renamed from: d */
    final Window.Callback f917d;

    /* JADX INFO: renamed from: e */
    final InterfaceC0161d f918e;

    /* JADX INFO: renamed from: f */
    AbstractC0158a f919f;

    /* JADX INFO: renamed from: g */
    MenuInflater f920g;

    /* JADX INFO: renamed from: h */
    boolean f921h;

    /* JADX INFO: renamed from: i */
    boolean f922i;

    /* JADX INFO: renamed from: j */
    boolean f923j;

    /* JADX INFO: renamed from: k */
    boolean f924k;

    /* JADX INFO: renamed from: l */
    boolean f925l;

    /* JADX INFO: renamed from: p */
    private CharSequence f926p;

    /* JADX INFO: renamed from: q */
    private boolean f927q;

    /* JADX INFO: renamed from: r */
    private boolean f928r;

    /* JADX INFO: renamed from: android.support.v7.app.f$a */
    class a extends WindowCallbackC0186i {
        a(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.view.WindowCallbackC0186i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AbstractC0163f.this.mo1264a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.support.v7.view.WindowCallbackC0186i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AbstractC0163f.this.mo1263a(keyEvent.getKeyCode(), keyEvent);
        }

        @Override // android.support.v7.view.WindowCallbackC0186i, android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // android.support.v7.view.WindowCallbackC0186i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof C0196h)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.support.v7.view.WindowCallbackC0186i, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            AbstractC0163f.this.mo1266b(i, menu);
            return true;
        }

        @Override // android.support.v7.view.WindowCallbackC0186i, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            AbstractC0163f.this.mo1262a(i, menu);
        }

        @Override // android.support.v7.view.WindowCallbackC0186i, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            C0196h c0196h = menu instanceof C0196h ? (C0196h) menu : null;
            if (i == 0 && c0196h == null) {
                return false;
            }
            if (c0196h != null) {
                c0196h.m1555c(true);
            }
            boolean zOnPreparePanel = super.onPreparePanel(i, view, menu);
            if (c0196h != null) {
                c0196h.m1555c(false);
            }
            return zOnPreparePanel;
        }
    }

    static {
        f912n = Build.VERSION.SDK_INT < 21;
        if (f912n && !f911m) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: android.support.v7.app.f.1
                /* JADX INFO: renamed from: a */
                private boolean m1274a(Throwable th) {
                    String message;
                    if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                        return false;
                    }
                    return message.contains("drawable") || message.contains("Drawable");
                }

                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    if (!m1274a(th)) {
                        defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                        return;
                    }
                    Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                    notFoundException.initCause(th.getCause());
                    notFoundException.setStackTrace(th.getStackTrace());
                    defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                }
            });
            f911m = true;
        }
        f913o = new int[]{R.attr.windowBackground};
    }

    AbstractC0163f(Context context, Window window, InterfaceC0161d interfaceC0161d) {
        this.f914a = context;
        this.f915b = window;
        this.f918e = interfaceC0161d;
        this.f916c = this.f915b.getCallback();
        if (this.f916c instanceof a) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f917d = mo1261a(this.f916c);
        this.f915b.setCallback(this.f917d);
        C0263aw c0263awM1977a = C0263aw.m1977a(context, (AttributeSet) null, f913o);
        Drawable drawableM1986b = c0263awM1977a.m1986b(0);
        if (drawableM1986b != null) {
            this.f915b.setBackgroundDrawable(drawableM1986b);
        }
        c0263awM1977a.m1983a();
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: a */
    public AbstractC0158a mo1240a() {
        mo1267l();
        return this.f919f;
    }

    /* JADX INFO: renamed from: a */
    abstract AbstractC0179b mo1260a(AbstractC0179b.a aVar);

    /* JADX INFO: renamed from: a */
    Window.Callback mo1261a(Window.Callback callback) {
        return new a(callback);
    }

    /* JADX INFO: renamed from: a */
    abstract void mo1262a(int i, Menu menu);

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: a */
    public final void mo1246a(CharSequence charSequence) {
        this.f926p = charSequence;
        mo1265b(charSequence);
    }

    /* JADX INFO: renamed from: a */
    abstract boolean mo1263a(int i, KeyEvent keyEvent);

    /* JADX INFO: renamed from: a */
    abstract boolean mo1264a(KeyEvent keyEvent);

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: b */
    public MenuInflater mo1247b() {
        if (this.f920g == null) {
            mo1267l();
            this.f920g = new C0184g(this.f919f != null ? this.f919f.mo1199b() : this.f914a);
        }
        return this.f920g;
    }

    /* JADX INFO: renamed from: b */
    abstract void mo1265b(CharSequence charSequence);

    /* JADX INFO: renamed from: b */
    abstract boolean mo1266b(int i, Menu menu);

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: c */
    public void mo1251c() {
        this.f927q = true;
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: c */
    public void mo1252c(Bundle bundle) {
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: d */
    public void mo1254d() {
        this.f927q = false;
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: g */
    public void mo1257g() {
        this.f928r = true;
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: i */
    public boolean mo1259i() {
        return false;
    }

    /* JADX INFO: renamed from: l */
    abstract void mo1267l();

    /* JADX INFO: renamed from: m */
    final AbstractC0158a m1268m() {
        return this.f919f;
    }

    /* JADX INFO: renamed from: n */
    final Context m1269n() {
        AbstractC0158a abstractC0158aMo1240a = mo1240a();
        Context contextMo1199b = abstractC0158aMo1240a != null ? abstractC0158aMo1240a.mo1199b() : null;
        return contextMo1199b == null ? this.f914a : contextMo1199b;
    }

    /* JADX INFO: renamed from: o */
    public boolean mo1270o() {
        return false;
    }

    /* JADX INFO: renamed from: p */
    final boolean m1271p() {
        return this.f928r;
    }

    /* JADX INFO: renamed from: q */
    final Window.Callback m1272q() {
        return this.f915b.getCallback();
    }

    /* JADX INFO: renamed from: r */
    final CharSequence m1273r() {
        return this.f916c instanceof Activity ? ((Activity) this.f916c).getTitle() : this.f926p;
    }
}
