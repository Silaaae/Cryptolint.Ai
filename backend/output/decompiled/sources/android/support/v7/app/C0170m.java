package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.support.v4.p015g.C0124p;
import android.support.v7.app.AbstractC0158a;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.menu.C0196h;
import android.support.v7.view.menu.InterfaceC0203o;
import android.support.v7.widget.InterfaceC0245ae;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import java.util.ArrayList;

/* JADX INFO: renamed from: android.support.v7.app.m */
/* JADX INFO: loaded from: classes.dex */
class C0170m extends AbstractC0158a {

    /* JADX INFO: renamed from: a */
    InterfaceC0245ae f1012a;

    /* JADX INFO: renamed from: b */
    Window.Callback f1013b;

    /* JADX INFO: renamed from: c */
    private boolean f1014c;

    /* JADX INFO: renamed from: d */
    private boolean f1015d;

    /* JADX INFO: renamed from: e */
    private ArrayList<AbstractC0158a.b> f1016e;

    /* JADX INFO: renamed from: f */
    private final Runnable f1017f;

    /* JADX INFO: renamed from: android.support.v7.app.m$a */
    private final class a implements InterfaceC0203o.a {

        /* JADX INFO: renamed from: b */
        private boolean f1019b;

        a() {
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o.a
        /* JADX INFO: renamed from: a */
        public void mo1324a(C0196h c0196h, boolean z) {
            if (this.f1019b) {
                return;
            }
            this.f1019b = true;
            C0170m.this.f1012a.mo1849n();
            if (C0170m.this.f1013b != null) {
                C0170m.this.f1013b.onPanelClosed(C0148a.j.AppCompatTheme_tooltipFrameBackground, c0196h);
            }
            this.f1019b = false;
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o.a
        /* JADX INFO: renamed from: a */
        public boolean mo1325a(C0196h c0196h) {
            if (C0170m.this.f1013b == null) {
                return false;
            }
            C0170m.this.f1013b.onMenuOpened(C0148a.j.AppCompatTheme_tooltipFrameBackground, c0196h);
            return true;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.m$b */
    private final class b implements C0196h.a {
        b() {
        }

        @Override // android.support.v7.view.menu.C0196h.a
        /* JADX INFO: renamed from: a */
        public void mo1306a(C0196h c0196h) {
            if (C0170m.this.f1013b != null) {
                if (C0170m.this.f1012a.mo1844i()) {
                    C0170m.this.f1013b.onPanelClosed(C0148a.j.AppCompatTheme_tooltipFrameBackground, c0196h);
                } else if (C0170m.this.f1013b.onPreparePanel(0, null, c0196h)) {
                    C0170m.this.f1013b.onMenuOpened(C0148a.j.AppCompatTheme_tooltipFrameBackground, c0196h);
                }
            }
        }

        @Override // android.support.v7.view.menu.C0196h.a
        /* JADX INFO: renamed from: a */
        public boolean mo1308a(C0196h c0196h, MenuItem menuItem) {
            return false;
        }
    }

    /* JADX INFO: renamed from: h */
    private Menu m1343h() {
        if (!this.f1014c) {
            this.f1012a.mo1827a(new a(), new b());
            this.f1014c = true;
        }
        return this.f1012a.mo1852q();
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public int mo1191a() {
        return this.f1012a.mo1850o();
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public void mo1193a(float f) {
        C0124p.m950a(this.f1012a.mo1824a(), f);
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public void mo1194a(Configuration configuration) {
        super.mo1194a(configuration);
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public void mo1195a(CharSequence charSequence) {
        this.f1012a.mo1831a(charSequence);
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public void mo1196a(boolean z) {
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public boolean mo1197a(int i, KeyEvent keyEvent) {
        Menu menuM1343h = m1343h();
        if (menuM1343h == null) {
            return false;
        }
        menuM1343h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuM1343h.performShortcut(i, keyEvent, 0);
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public boolean mo1198a(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            mo1202c();
        }
        return true;
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: b */
    public Context mo1199b() {
        return this.f1012a.mo1833b();
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: c */
    public void mo1201c(boolean z) {
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: c */
    public boolean mo1202c() {
        return this.f1012a.mo1846k();
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: d */
    public void mo1203d(boolean z) {
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: d */
    public boolean mo1204d() {
        return this.f1012a.mo1847l();
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: e */
    public void mo1205e(boolean z) {
        if (z == this.f1015d) {
            return;
        }
        this.f1015d = z;
        int size = this.f1016e.size();
        for (int i = 0; i < size; i++) {
            this.f1016e.get(i).m1209a(z);
        }
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: e */
    public boolean mo1206e() {
        this.f1012a.mo1824a().removeCallbacks(this.f1017f);
        C0124p.m957a(this.f1012a.mo1824a(), this.f1017f);
        return true;
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: f */
    public boolean mo1207f() {
        if (!this.f1012a.mo1837c()) {
            return false;
        }
        this.f1012a.mo1838d();
        return true;
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: g */
    void mo1208g() {
        this.f1012a.mo1824a().removeCallbacks(this.f1017f);
    }
}
