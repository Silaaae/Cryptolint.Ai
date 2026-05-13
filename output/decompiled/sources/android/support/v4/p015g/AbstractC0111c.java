package android.support.v4.p015g;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: renamed from: android.support.v4.g.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0111c {

    /* JADX INFO: renamed from: a */
    private final Context f654a;

    /* JADX INFO: renamed from: b */
    private a f655b;

    /* JADX INFO: renamed from: c */
    private b f656c;

    /* JADX INFO: renamed from: android.support.v4.g.c$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo900a(boolean z);
    }

    /* JADX INFO: renamed from: android.support.v4.g.c$b */
    public interface b {
        /* JADX INFO: renamed from: a */
        void mo901a(boolean z);
    }

    public AbstractC0111c(Context context) {
        this.f654a = context;
    }

    /* JADX INFO: renamed from: a */
    public abstract View mo889a();

    /* JADX INFO: renamed from: a */
    public View mo890a(MenuItem menuItem) {
        return mo889a();
    }

    /* JADX INFO: renamed from: a */
    public void m891a(a aVar) {
        this.f655b = aVar;
    }

    /* JADX INFO: renamed from: a */
    public void mo892a(b bVar) {
        if (this.f656c != null && bVar != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f656c = bVar;
    }

    /* JADX INFO: renamed from: a */
    public void mo893a(SubMenu subMenu) {
    }

    /* JADX INFO: renamed from: a */
    public void m894a(boolean z) {
        if (this.f655b != null) {
            this.f655b.mo900a(z);
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean mo895b() {
        return false;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo896c() {
        return true;
    }

    /* JADX INFO: renamed from: d */
    public boolean mo897d() {
        return false;
    }

    /* JADX INFO: renamed from: e */
    public boolean mo898e() {
        return false;
    }

    /* JADX INFO: renamed from: f */
    public void m899f() {
        this.f656c = null;
        this.f655b = null;
    }
}
