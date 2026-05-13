package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.p015g.C0124p;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: android.support.v7.widget.bc */
/* JADX INFO: loaded from: classes.dex */
public class C0270bc {

    /* JADX INFO: renamed from: a */
    private static Method f1846a;

    static {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                f1846a = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                if (f1846a.isAccessible()) {
                    return;
                }
                f1846a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2026a(View view, Rect rect, Rect rect2) {
        if (f1846a != null) {
            try {
                f1846a.invoke(view, rect, rect2);
            } catch (Exception e) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2027a(View view) {
        return C0124p.m960b(view) == 1;
    }

    /* JADX INFO: renamed from: b */
    public static void m2028b(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (IllegalAccessException | InvocationTargetException e) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            }
        }
    }
}
