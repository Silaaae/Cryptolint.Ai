package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.p006a.C0033a;

/* JADX INFO: renamed from: android.support.v4.app.a */
/* JADX INFO: loaded from: classes.dex */
public class C0042a extends C0033a {

    /* JADX INFO: renamed from: a */
    private static a f203a;

    /* JADX INFO: renamed from: android.support.v4.app.a$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        boolean m230a(Activity activity, int i, int i2, Intent intent);
    }

    /* JADX INFO: renamed from: a */
    public static a m228a() {
        return f203a;
    }

    /* JADX INFO: renamed from: a */
    public static void m229a(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }
}
