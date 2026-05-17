package android.support.v4.p008b.p009a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: android.support.v4.b.a.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0070a {

    /* JADX INFO: renamed from: a */
    private static Method f492a;

    /* JADX INFO: renamed from: b */
    private static boolean f493b;

    /* JADX INFO: renamed from: c */
    private static Method f494c;

    /* JADX INFO: renamed from: d */
    private static boolean f495d;

    @Deprecated
    /* JADX INFO: renamed from: a */
    public static void m644a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    /* JADX INFO: renamed from: a */
    public static void m645a(Drawable drawable, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f, f2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m646a(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(i);
        } else if (drawable instanceof InterfaceC0071b) {
            ((InterfaceC0071b) drawable).setTint(i);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m647a(Drawable drawable, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m648a(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof InterfaceC0071b) {
            ((InterfaceC0071b) drawable).setTintList(colorStateList);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m649a(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m650a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public static void m651a(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof InterfaceC0071b) {
            ((InterfaceC0071b) drawable).setTintMode(mode);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m652a(Drawable drawable, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m653b(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m654b(Drawable drawable, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (!f493b) {
                try {
                    f492a = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                    f492a.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e);
                }
                f493b = true;
            }
            if (f492a != null) {
                try {
                    f492a.invoke(drawable, Integer.valueOf(i));
                    return true;
                } catch (Exception e2) {
                    Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e2);
                    f492a = null;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    public static int m655c(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m656d(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    /* JADX INFO: renamed from: e */
    public static ColorFilter m657e(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    /* JADX INFO: renamed from: f */
    public static Drawable m658f(Drawable drawable) {
        return Build.VERSION.SDK_INT >= 23 ? drawable : Build.VERSION.SDK_INT >= 21 ? !(drawable instanceof InterfaceC0071b) ? new C0075f(drawable) : drawable : Build.VERSION.SDK_INT >= 19 ? !(drawable instanceof InterfaceC0071b) ? new C0074e(drawable) : drawable : !(drawable instanceof InterfaceC0071b) ? new C0073d(drawable) : drawable;
    }

    /* JADX INFO: renamed from: g */
    public static int m659g(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (!f495d) {
                try {
                    f494c = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f494c.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e);
                }
                f495d = true;
            }
            if (f494c != null) {
                try {
                    return ((Integer) f494c.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e2) {
                    Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e2);
                    f494c = null;
                }
            }
        }
        return 0;
    }
}
