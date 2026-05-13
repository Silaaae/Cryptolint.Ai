package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AbstractC0162e;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: android.support.v7.widget.bb */
/* JADX INFO: loaded from: classes.dex */
public class C0269bb extends Resources {

    /* JADX INFO: renamed from: a */
    private final WeakReference<Context> f1845a;

    public C0269bb(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f1845a = new WeakReference<>(context);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2024a() {
        return AbstractC0162e.m1239k() && Build.VERSION.SDK_INT <= 20;
    }

    /* JADX INFO: renamed from: a */
    final Drawable m2025a(int i) {
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Context context = this.f1845a.get();
        return context != null ? C0281l.m2092a().m2113a(context, this, i) : super.getDrawable(i);
    }
}
