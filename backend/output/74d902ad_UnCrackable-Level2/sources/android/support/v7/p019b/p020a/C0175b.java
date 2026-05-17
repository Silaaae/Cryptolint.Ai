package android.support.v7.p019b.p020a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.p006a.C0033a;
import android.support.v7.widget.C0281l;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: android.support.v7.b.a.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0175b {

    /* JADX INFO: renamed from: a */
    private static final ThreadLocal<TypedValue> f1077a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b */
    private static final WeakHashMap<Context, SparseArray<a>> f1078b = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: c */
    private static final Object f1079c = new Object();

    /* JADX INFO: renamed from: android.support.v7.b.a.b$a */
    private static class a {

        /* JADX INFO: renamed from: a */
        final ColorStateList f1080a;

        /* JADX INFO: renamed from: b */
        final Configuration f1081b;

        a(ColorStateList colorStateList, Configuration configuration) {
            this.f1080a = colorStateList;
            this.f1081b = configuration;
        }
    }

    /* JADX INFO: renamed from: a */
    public static ColorStateList m1393a(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList colorStateListM1398d = m1398d(context, i);
        if (colorStateListM1398d != null) {
            return colorStateListM1398d;
        }
        ColorStateList colorStateListM1397c = m1397c(context, i);
        if (colorStateListM1397c == null) {
            return C0033a.m169b(context, i);
        }
        m1395a(context, i, colorStateListM1397c);
        return colorStateListM1397c;
    }

    /* JADX INFO: renamed from: a */
    private static TypedValue m1394a() {
        TypedValue typedValue = f1077a.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f1077a.set(typedValue2);
        return typedValue2;
    }

    /* JADX INFO: renamed from: a */
    private static void m1395a(Context context, int i, ColorStateList colorStateList) {
        synchronized (f1079c) {
            SparseArray<a> sparseArray = f1078b.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                f1078b.put(context, sparseArray);
            }
            sparseArray.append(i, new a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    /* JADX INFO: renamed from: b */
    public static Drawable m1396b(Context context, int i) {
        return C0281l.m2092a().m2111a(context, i);
    }

    /* JADX INFO: renamed from: c */
    private static ColorStateList m1397c(Context context, int i) {
        if (m1399e(context, i)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return C0174a.m1389a(resources, resources.getXml(i), context.getTheme());
        } catch (Exception e) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    private static ColorStateList m1398d(Context context, int i) {
        a aVar;
        synchronized (f1079c) {
            SparseArray<a> sparseArray = f1078b.get(context);
            if (sparseArray != null && sparseArray.size() > 0 && (aVar = sparseArray.get(i)) != null) {
                if (aVar.f1081b.equals(context.getResources().getConfiguration())) {
                    return aVar.f1080a;
                }
                sparseArray.remove(i);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    private static boolean m1399e(Context context, int i) {
        Resources resources = context.getResources();
        TypedValue typedValueM1394a = m1394a();
        resources.getValue(i, typedValueM1394a, true);
        return typedValueM1394a.type >= 28 && typedValueM1394a.type <= 31;
    }
}
