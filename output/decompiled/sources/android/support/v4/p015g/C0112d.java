package android.support.v4.p015g;

import android.os.Build;
import android.view.Gravity;

/* JADX INFO: renamed from: android.support.v4.g.d */
/* JADX INFO: loaded from: classes.dex */
public final class C0112d {
    /* JADX INFO: renamed from: a */
    public static int m902a(int i, int i2) {
        return Build.VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(i, i2) : i & (-8388609);
    }
}
