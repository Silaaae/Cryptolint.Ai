package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: android.support.v4.widget.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0137c {

    /* JADX INFO: renamed from: a */
    private static final c f752a;

    /* JADX INFO: renamed from: android.support.v4.widget.c$a */
    static class a extends c {
        a() {
        }

        @Override // android.support.v4.widget.C0137c.c
        /* JADX INFO: renamed from: a */
        public void mo1111a(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        @Override // android.support.v4.widget.C0137c.c
        /* JADX INFO: renamed from: a */
        public void mo1112a(CompoundButton compoundButton, PorterDuff.Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.widget.c$b */
    static class b extends a {
        b() {
        }

        @Override // android.support.v4.widget.C0137c.c
        /* JADX INFO: renamed from: a */
        public Drawable mo1113a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    /* JADX INFO: renamed from: android.support.v4.widget.c$c */
    static class c {

        /* JADX INFO: renamed from: a */
        private static Field f753a;

        /* JADX INFO: renamed from: b */
        private static boolean f754b;

        c() {
        }

        /* JADX INFO: renamed from: a */
        public Drawable mo1113a(CompoundButton compoundButton) {
            if (!f754b) {
                try {
                    f753a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                    f753a.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", e);
                }
                f754b = true;
            }
            if (f753a != null) {
                try {
                    return (Drawable) f753a.get(compoundButton);
                } catch (IllegalAccessException e2) {
                    Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", e2);
                    f753a = null;
                }
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: a */
        public void mo1111a(CompoundButton compoundButton, ColorStateList colorStateList) {
            if (compoundButton instanceof InterfaceC0146l) {
                ((InterfaceC0146l) compoundButton).setSupportButtonTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: a */
        public void mo1112a(CompoundButton compoundButton, PorterDuff.Mode mode) {
            if (compoundButton instanceof InterfaceC0146l) {
                ((InterfaceC0146l) compoundButton).setSupportButtonTintMode(mode);
            }
        }
    }

    static {
        f752a = Build.VERSION.SDK_INT >= 23 ? new b() : Build.VERSION.SDK_INT >= 21 ? new a() : new c();
    }

    /* JADX INFO: renamed from: a */
    public static Drawable m1108a(CompoundButton compoundButton) {
        return f752a.mo1113a(compoundButton);
    }

    /* JADX INFO: renamed from: a */
    public static void m1109a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f752a.mo1111a(compoundButton, colorStateList);
    }

    /* JADX INFO: renamed from: a */
    public static void m1110a(CompoundButton compoundButton, PorterDuff.Mode mode) {
        f752a.mo1112a(compoundButton, mode);
    }
}
