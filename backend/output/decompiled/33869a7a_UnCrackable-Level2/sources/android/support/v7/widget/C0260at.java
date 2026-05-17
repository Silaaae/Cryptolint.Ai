package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: renamed from: android.support.v7.widget.at */
/* JADX INFO: loaded from: classes.dex */
public class C0260at extends ContextWrapper {

    /* JADX INFO: renamed from: a */
    private static final Object f1791a = new Object();

    /* JADX INFO: renamed from: b */
    private static ArrayList<WeakReference<C0260at>> f1792b;

    /* JADX INFO: renamed from: c */
    private final Resources f1793c;

    /* JADX INFO: renamed from: d */
    private final Resources.Theme f1794d;

    private C0260at(Context context) {
        super(context);
        if (!C0269bb.m2024a()) {
            this.f1793c = new C0262av(this, context.getResources());
            this.f1794d = null;
        } else {
            this.f1793c = new C0269bb(this, context.getResources());
            this.f1794d = this.f1793c.newTheme();
            this.f1794d.setTo(context.getTheme());
        }
    }

    /* JADX INFO: renamed from: a */
    public static Context m1973a(Context context) {
        if (!m1974b(context)) {
            return context;
        }
        synchronized (f1791a) {
            if (f1792b == null) {
                f1792b = new ArrayList<>();
            } else {
                for (int size = f1792b.size() - 1; size >= 0; size--) {
                    WeakReference<C0260at> weakReference = f1792b.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1792b.remove(size);
                    }
                }
                for (int size2 = f1792b.size() - 1; size2 >= 0; size2--) {
                    WeakReference<C0260at> weakReference2 = f1792b.get(size2);
                    C0260at c0260at = weakReference2 != null ? weakReference2.get() : null;
                    if (c0260at != null && c0260at.getBaseContext() == context) {
                        return c0260at;
                    }
                }
            }
            C0260at c0260at2 = new C0260at(context);
            f1792b.add(new WeakReference<>(c0260at2));
            return c0260at2;
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m1974b(Context context) {
        if ((context instanceof C0260at) || (context.getResources() instanceof C0262av) || (context.getResources() instanceof C0269bb)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || C0269bb.m2024a();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1793c.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1793c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return this.f1794d == null ? super.getTheme() : this.f1794d;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.f1794d == null) {
            super.setTheme(i);
        } else {
            this.f1794d.applyStyle(i, true);
        }
    }
}
