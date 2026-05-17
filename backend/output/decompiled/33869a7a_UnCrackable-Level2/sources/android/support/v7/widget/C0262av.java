package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: android.support.v7.widget.av */
/* JADX INFO: loaded from: classes.dex */
class C0262av extends C0254an {

    /* JADX INFO: renamed from: a */
    private final WeakReference<Context> f1799a;

    public C0262av(Context context, Resources resources) {
        super(resources);
        this.f1799a = new WeakReference<>(context);
    }

    @Override // android.support.v7.widget.C0254an, android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = this.f1799a.get();
        if (drawable != null && context != null) {
            C0281l.m2092a();
            C0281l.m2098a(context, i, drawable);
        }
        return drawable;
    }
}
