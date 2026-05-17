package android.support.v7.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.p018a.C0148a;
import android.view.ViewConfiguration;

/* JADX INFO: renamed from: android.support.v7.view.a */
/* JADX INFO: loaded from: classes.dex */
public class C0178a {

    /* JADX INFO: renamed from: a */
    private Context f1084a;

    private C0178a(Context context) {
        this.f1084a = context;
    }

    /* JADX INFO: renamed from: a */
    public static C0178a m1405a(Context context) {
        return new C0178a(context);
    }

    /* JADX INFO: renamed from: a */
    public int m1406a() {
        Configuration configuration = this.f1084a.getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i2 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i > 600) {
            return 5;
        }
        if (i > 960 && i2 > 720) {
            return 5;
        }
        if (i > 720 && i2 > 960) {
            return 5;
        }
        if (i >= 500) {
            return 4;
        }
        if (i > 640 && i2 > 480) {
            return 4;
        }
        if (i <= 480 || i2 <= 640) {
            return i >= 360 ? 3 : 2;
        }
        return 4;
    }

    /* JADX INFO: renamed from: b */
    public boolean m1407b() {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return !ViewConfiguration.get(this.f1084a).hasPermanentMenuKey();
    }

    /* JADX INFO: renamed from: c */
    public int m1408c() {
        return this.f1084a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    /* JADX INFO: renamed from: d */
    public boolean m1409d() {
        return this.f1084a.getResources().getBoolean(C0148a.b.abc_action_bar_embed_tabs);
    }

    /* JADX INFO: renamed from: e */
    public int m1410e() {
        TypedArray typedArrayObtainStyledAttributes = this.f1084a.obtainStyledAttributes(null, C0148a.j.ActionBar, C0148a.a.actionBarStyle, 0);
        int layoutDimension = typedArrayObtainStyledAttributes.getLayoutDimension(C0148a.j.ActionBar_height, 0);
        Resources resources = this.f1084a.getResources();
        if (!m1409d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0148a.d.abc_action_bar_stacked_max_height));
        }
        typedArrayObtainStyledAttributes.recycle();
        return layoutDimension;
    }

    /* JADX INFO: renamed from: f */
    public boolean m1411f() {
        return this.f1084a.getApplicationInfo().targetSdkVersion < 14;
    }

    /* JADX INFO: renamed from: g */
    public int m1412g() {
        return this.f1084a.getResources().getDimensionPixelSize(C0148a.d.abc_action_bar_stacked_tab_max_width);
    }
}
