package android.support.v4.p006a;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;

/* JADX INFO: renamed from: android.support.v4.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0033a {

    /* JADX INFO: renamed from: a */
    private static final Object f168a = new Object();

    /* JADX INFO: renamed from: b */
    private static TypedValue f169b;

    /* JADX INFO: renamed from: a */
    public static Drawable m167a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        if (Build.VERSION.SDK_INT < 16) {
            synchronized (f168a) {
                if (f169b == null) {
                    f169b = new TypedValue();
                }
                context.getResources().getValue(i, f169b, true);
                i = f169b.resourceId;
            }
        }
        return context.getResources().getDrawable(i);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m168a(Context context, Intent[] intentArr, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            context.startActivities(intentArr, bundle);
            return true;
        }
        context.startActivities(intentArr);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public static ColorStateList m169b(Context context, int i) {
        return Build.VERSION.SDK_INT >= 23 ? context.getColorStateList(i) : context.getResources().getColorStateList(i);
    }
}
