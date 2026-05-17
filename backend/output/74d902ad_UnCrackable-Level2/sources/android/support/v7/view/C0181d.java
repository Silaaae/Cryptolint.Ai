package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v7.p018a.C0148a;
import android.view.LayoutInflater;

/* JADX INFO: renamed from: android.support.v7.view.d */
/* JADX INFO: loaded from: classes.dex */
public class C0181d extends ContextWrapper {

    /* JADX INFO: renamed from: a */
    private int f1087a;

    /* JADX INFO: renamed from: b */
    private Resources.Theme f1088b;

    /* JADX INFO: renamed from: c */
    private LayoutInflater f1089c;

    /* JADX INFO: renamed from: d */
    private Configuration f1090d;

    /* JADX INFO: renamed from: e */
    private Resources f1091e;

    public C0181d() {
        super(null);
    }

    public C0181d(Context context, int i) {
        super(context);
        this.f1087a = i;
    }

    public C0181d(Context context, Resources.Theme theme) {
        super(context);
        this.f1088b = theme;
    }

    /* JADX INFO: renamed from: b */
    private Resources m1418b() {
        Resources resources;
        if (this.f1091e == null) {
            if (this.f1090d == null) {
                resources = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                resources = createConfigurationContext(this.f1090d).getResources();
            }
            this.f1091e = resources;
        }
        return this.f1091e;
    }

    /* JADX INFO: renamed from: c */
    private void m1419c() {
        boolean z = this.f1088b == null;
        if (z) {
            this.f1088b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1088b.setTo(theme);
            }
        }
        m1421a(this.f1088b, this.f1087a, z);
    }

    /* JADX INFO: renamed from: a */
    public int m1420a() {
        return this.f1087a;
    }

    /* JADX INFO: renamed from: a */
    protected void m1421a(Resources.Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return m1418b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1089c == null) {
            this.f1089c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1089c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        if (this.f1088b != null) {
            return this.f1088b;
        }
        if (this.f1087a == 0) {
            this.f1087a = C0148a.i.Theme_AppCompat_Light;
        }
        m1419c();
        return this.f1088b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f1087a != i) {
            this.f1087a = i;
            m1419c();
        }
    }
}
