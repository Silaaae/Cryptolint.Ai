package android.support.v7.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: renamed from: android.support.v7.app.l */
/* JADX INFO: loaded from: classes.dex */
class C0169l {

    /* JADX INFO: renamed from: a */
    private static Field f1004a;

    /* JADX INFO: renamed from: b */
    private static boolean f1005b;

    /* JADX INFO: renamed from: c */
    private static Class f1006c;

    /* JADX INFO: renamed from: d */
    private static boolean f1007d;

    /* JADX INFO: renamed from: e */
    private static Field f1008e;

    /* JADX INFO: renamed from: f */
    private static boolean f1009f;

    /* JADX INFO: renamed from: g */
    private static Field f1010g;

    /* JADX INFO: renamed from: h */
    private static boolean f1011h;

    /* JADX INFO: renamed from: a */
    static boolean m1338a(Resources resources) {
        if (Build.VERSION.SDK_INT >= 24) {
            return m1342d(resources);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return m1341c(resources);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return m1340b(resources);
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1339a(Object obj) {
        LongSparseArray longSparseArray;
        if (!f1007d) {
            try {
                f1006c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e);
            }
            f1007d = true;
        }
        if (f1006c == null) {
            return false;
        }
        if (!f1009f) {
            try {
                f1008e = f1006c.getDeclaredField("mUnthemedEntries");
                f1008e.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e2);
            }
            f1009f = true;
        }
        if (f1008e == null) {
            return false;
        }
        try {
            longSparseArray = (LongSparseArray) f1008e.get(obj);
        } catch (IllegalAccessException e3) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e3);
            longSparseArray = null;
        }
        if (longSparseArray == null) {
            return false;
        }
        longSparseArray.clear();
        return true;
    }

    /* JADX INFO: renamed from: b */
    private static boolean m1340b(Resources resources) {
        Map map;
        if (!f1005b) {
            try {
                f1004a = Resources.class.getDeclaredField("mDrawableCache");
                f1004a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f1005b = true;
        }
        if (f1004a == null) {
            return false;
        }
        try {
            map = (Map) f1004a.get(resources);
        } catch (IllegalAccessException e2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
            map = null;
        }
        if (map == null) {
            return false;
        }
        map.clear();
        return true;
    }

    /* JADX INFO: renamed from: c */
    private static boolean m1341c(Resources resources) {
        Object obj;
        if (!f1005b) {
            try {
                f1004a = Resources.class.getDeclaredField("mDrawableCache");
                f1004a.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mDrawableCache field", e);
            }
            f1005b = true;
        }
        if (f1004a != null) {
            try {
                obj = f1004a.get(resources);
            } catch (IllegalAccessException e2) {
                Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mDrawableCache", e2);
                obj = null;
            }
        } else {
            obj = null;
        }
        return (obj == null || obj == null || !m1339a(obj)) ? false : true;
    }

    /* JADX INFO: renamed from: d */
    private static boolean m1342d(Resources resources) {
        Object obj;
        Object obj2;
        if (!f1011h) {
            try {
                f1010g = Resources.class.getDeclaredField("mResourcesImpl");
                f1010g.setAccessible(true);
            } catch (NoSuchFieldException e) {
                Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
            }
            f1011h = true;
        }
        if (f1010g == null) {
            return false;
        }
        try {
            obj = f1010g.get(resources);
        } catch (IllegalAccessException e2) {
            Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
            obj = null;
        }
        if (obj == null) {
            return false;
        }
        if (!f1005b) {
            try {
                f1004a = obj.getClass().getDeclaredField("mDrawableCache");
                f1004a.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
            }
            f1005b = true;
        }
        if (f1004a != null) {
            try {
                obj2 = f1004a.get(obj);
            } catch (IllegalAccessException e4) {
                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
                obj2 = null;
            }
        } else {
            obj2 = null;
        }
        return obj2 != null && m1339a(obj2);
    }
}
