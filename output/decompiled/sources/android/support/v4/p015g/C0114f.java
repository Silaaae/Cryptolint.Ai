package android.support.v4.p015g;

import android.os.Build;
import android.view.ViewGroup;

/* JADX INFO: renamed from: android.support.v4.g.f */
/* JADX INFO: loaded from: classes.dex */
public final class C0114f {
    /* JADX INFO: renamed from: a */
    public static int m906a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Build.VERSION.SDK_INT >= 17 ? marginLayoutParams.getMarginStart() : marginLayoutParams.leftMargin;
    }

    /* JADX INFO: renamed from: b */
    public static int m907b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Build.VERSION.SDK_INT >= 17 ? marginLayoutParams.getMarginEnd() : marginLayoutParams.rightMargin;
    }
}
