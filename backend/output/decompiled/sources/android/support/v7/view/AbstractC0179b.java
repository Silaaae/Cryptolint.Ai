package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: renamed from: android.support.v7.view.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0179b {

    /* JADX INFO: renamed from: a */
    private Object f1085a;

    /* JADX INFO: renamed from: b */
    private boolean f1086b;

    /* JADX INFO: renamed from: android.support.v7.view.b$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo1326a(AbstractC0179b abstractC0179b);

        /* JADX INFO: renamed from: a */
        boolean mo1327a(AbstractC0179b abstractC0179b, Menu menu);

        /* JADX INFO: renamed from: a */
        boolean mo1328a(AbstractC0179b abstractC0179b, MenuItem menuItem);

        /* JADX INFO: renamed from: b */
        boolean mo1329b(AbstractC0179b abstractC0179b, Menu menu);
    }

    /* JADX INFO: renamed from: a */
    public abstract MenuInflater mo1373a();

    /* JADX INFO: renamed from: a */
    public abstract void mo1374a(int i);

    /* JADX INFO: renamed from: a */
    public abstract void mo1375a(View view);

    /* JADX INFO: renamed from: a */
    public abstract void mo1376a(CharSequence charSequence);

    /* JADX INFO: renamed from: a */
    public void m1413a(Object obj) {
        this.f1085a = obj;
    }

    /* JADX INFO: renamed from: a */
    public void mo1377a(boolean z) {
        this.f1086b = z;
    }

    /* JADX INFO: renamed from: b */
    public abstract Menu mo1378b();

    /* JADX INFO: renamed from: b */
    public abstract void mo1379b(int i);

    /* JADX INFO: renamed from: b */
    public abstract void mo1380b(CharSequence charSequence);

    /* JADX INFO: renamed from: c */
    public abstract void mo1381c();

    /* JADX INFO: renamed from: d */
    public abstract void mo1382d();

    /* JADX INFO: renamed from: f */
    public abstract CharSequence mo1384f();

    /* JADX INFO: renamed from: g */
    public abstract CharSequence mo1385g();

    /* JADX INFO: renamed from: h */
    public boolean mo1386h() {
        return false;
    }

    /* JADX INFO: renamed from: i */
    public abstract View mo1387i();

    /* JADX INFO: renamed from: j */
    public Object m1414j() {
        return this.f1085a;
    }

    /* JADX INFO: renamed from: k */
    public boolean m1415k() {
        return this.f1086b;
    }
}
