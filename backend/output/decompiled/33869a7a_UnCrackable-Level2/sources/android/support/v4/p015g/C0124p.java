package android.support.v4.p015g;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: android.support.v4.g.p */
/* JADX INFO: loaded from: classes.dex */
public class C0124p {

    /* JADX INFO: renamed from: a */
    static final j f668a;

    /* JADX INFO: renamed from: android.support.v4.g.p$a */
    static class a extends j {
        a() {
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: a */
        public boolean mo973a(View view) {
            return view.hasOnClickListeners();
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.p$b */
    static class b extends a {
        b() {
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: a */
        public void mo974a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: a */
        public void mo975a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: a */
        public void mo976a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: b */
        public void mo977b(View view) {
            view.postInvalidateOnAnimation();
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: c */
        public int mo978c(View view) {
            return view.getMinimumHeight();
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: d */
        public void mo979d(View view) {
            view.requestFitSystemWindows();
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: e */
        public boolean mo980e(View view) {
            return view.hasOverlappingRendering();
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.p$c */
    static class c extends b {
        c() {
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: f */
        public int mo981f(View view) {
            return view.getLayoutDirection();
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: g */
        public int mo982g(View view) {
            return view.getWindowSystemUiVisibility();
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.p$d */
    static class d extends c {
        d() {
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.p$e */
    static class e extends d {
        e() {
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: h */
        public boolean mo983h(View view) {
            return view.isLaidOut();
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: i */
        public boolean mo984i(View view) {
            return view.isAttachedToWindow();
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.p$f */
    static class f extends e {
        f() {
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: a */
        public C0131w mo985a(View view, C0131w c0131w) {
            WindowInsets windowInsets = (WindowInsets) C0131w.m1031a(c0131w);
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (windowInsetsOnApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(windowInsetsOnApplyWindowInsets);
            }
            return C0131w.m1030a(windowInsets);
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: a */
        public void mo986a(View view, float f) {
            view.setElevation(f);
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: a */
        public void mo987a(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: a */
        public void mo988a(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background == null || !z) {
                    return;
                }
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: a */
        public void mo989a(View view, final InterfaceC0122n interfaceC0122n) {
            if (interfaceC0122n == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: android.support.v4.g.p.f.1
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        return (WindowInsets) C0131w.m1031a(interfaceC0122n.mo947a(view2, C0131w.m1030a(windowInsets)));
                    }
                });
            }
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: a */
        public void mo990a(View view, String str) {
            view.setTransitionName(str);
        }

        @Override // android.support.v4.p015g.C0124p.b, android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: d */
        public void mo979d(View view) {
            view.requestApplyInsets();
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: j */
        public String mo991j(View view) {
            return view.getTransitionName();
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: k */
        public void mo992k(View view) {
            view.stopNestedScroll();
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: l */
        public ColorStateList mo993l(View view) {
            return view.getBackgroundTintList();
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: m */
        public PorterDuff.Mode mo994m(View view) {
            return view.getBackgroundTintMode();
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.p$g */
    static class g extends f {
        g() {
        }

        @Override // android.support.v4.p015g.C0124p.j
        /* JADX INFO: renamed from: a */
        public void mo995a(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.p$h */
    static class h extends g {
        h() {
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.p$i */
    static class i extends h {
        i() {
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.p$j */
    static class j {

        /* JADX INFO: renamed from: c */
        private static Field f672c;

        /* JADX INFO: renamed from: d */
        private static boolean f673d;

        /* JADX INFO: renamed from: e */
        private static WeakHashMap<View, String> f674e;

        /* JADX INFO: renamed from: a */
        WeakHashMap<View, C0127s> f676a = null;

        /* JADX INFO: renamed from: f */
        private static final AtomicInteger f675f = new AtomicInteger(1);

        /* JADX INFO: renamed from: b */
        static boolean f671b = false;

        j() {
        }

        /* JADX INFO: renamed from: a */
        long m996a() {
            return ValueAnimator.getFrameDelay();
        }

        /* JADX INFO: renamed from: a */
        public C0131w mo985a(View view, C0131w c0131w) {
            return c0131w;
        }

        /* JADX INFO: renamed from: a */
        public void mo986a(View view, float f) {
        }

        /* JADX INFO: renamed from: a */
        public void mo995a(View view, int i, int i2) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: a */
        public void mo987a(View view, ColorStateList colorStateList) {
            if (view instanceof InterfaceC0123o) {
                ((InterfaceC0123o) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: a */
        public void mo988a(View view, PorterDuff.Mode mode) {
            if (view instanceof InterfaceC0123o) {
                ((InterfaceC0123o) view).setSupportBackgroundTintMode(mode);
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo974a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        /* JADX INFO: renamed from: a */
        public void m997a(View view, C0106b c0106b) {
            view.setAccessibilityDelegate(c0106b == null ? null : c0106b.m877a());
        }

        /* JADX INFO: renamed from: a */
        public void mo989a(View view, InterfaceC0122n interfaceC0122n) {
        }

        /* JADX INFO: renamed from: a */
        public void mo975a(View view, Runnable runnable) {
            view.postDelayed(runnable, m996a());
        }

        /* JADX INFO: renamed from: a */
        public void mo976a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, m996a() + j);
        }

        /* JADX INFO: renamed from: a */
        public void mo990a(View view, String str) {
            if (f674e == null) {
                f674e = new WeakHashMap<>();
            }
            f674e.put(view, str);
        }

        /* JADX INFO: renamed from: a */
        public boolean mo973a(View view) {
            return false;
        }

        /* JADX INFO: renamed from: b */
        public void mo977b(View view) {
            view.postInvalidate();
        }

        /* JADX INFO: renamed from: c */
        public int mo978c(View view) {
            if (!f673d) {
                try {
                    f672c = View.class.getDeclaredField("mMinHeight");
                    f672c.setAccessible(true);
                } catch (NoSuchFieldException unused) {
                }
                f673d = true;
            }
            if (f672c == null) {
                return 0;
            }
            try {
                return ((Integer) f672c.get(view)).intValue();
            } catch (Exception unused2) {
                return 0;
            }
        }

        /* JADX INFO: renamed from: d */
        public void mo979d(View view) {
        }

        /* JADX INFO: renamed from: e */
        public boolean mo980e(View view) {
            return true;
        }

        /* JADX INFO: renamed from: f */
        public int mo981f(View view) {
            return 0;
        }

        /* JADX INFO: renamed from: g */
        public int mo982g(View view) {
            return 0;
        }

        /* JADX INFO: renamed from: h */
        public boolean mo983h(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        /* JADX INFO: renamed from: i */
        public boolean mo984i(View view) {
            return view.getWindowToken() != null;
        }

        /* JADX INFO: renamed from: j */
        public String mo991j(View view) {
            if (f674e == null) {
                return null;
            }
            return f674e.get(view);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: k */
        public void mo992k(View view) {
            if (view instanceof InterfaceC0116h) {
                ((InterfaceC0116h) view).stopNestedScroll();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: l */
        public ColorStateList mo993l(View view) {
            if (view instanceof InterfaceC0123o) {
                return ((InterfaceC0123o) view).getSupportBackgroundTintList();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: m */
        public PorterDuff.Mode mo994m(View view) {
            if (view instanceof InterfaceC0123o) {
                return ((InterfaceC0123o) view).getSupportBackgroundTintMode();
            }
            return null;
        }

        /* JADX INFO: renamed from: n */
        public C0127s m998n(View view) {
            if (this.f676a == null) {
                this.f676a = new WeakHashMap<>();
            }
            C0127s c0127s = this.f676a.get(view);
            if (c0127s != null) {
                return c0127s;
            }
            C0127s c0127s2 = new C0127s(view);
            this.f676a.put(view, c0127s2);
            return c0127s2;
        }
    }

    static {
        f668a = Build.VERSION.SDK_INT >= 26 ? new i() : Build.VERSION.SDK_INT >= 24 ? new h() : Build.VERSION.SDK_INT >= 23 ? new g() : Build.VERSION.SDK_INT >= 21 ? new f() : Build.VERSION.SDK_INT >= 19 ? new e() : Build.VERSION.SDK_INT >= 18 ? new d() : Build.VERSION.SDK_INT >= 17 ? new c() : Build.VERSION.SDK_INT >= 16 ? new b() : Build.VERSION.SDK_INT >= 15 ? new a() : new j();
    }

    /* JADX INFO: renamed from: a */
    public static C0131w m948a(View view, C0131w c0131w) {
        return f668a.mo985a(view, c0131w);
    }

    /* JADX INFO: renamed from: a */
    public static void m949a(View view) {
        f668a.mo977b(view);
    }

    /* JADX INFO: renamed from: a */
    public static void m950a(View view, float f2) {
        f668a.mo986a(view, f2);
    }

    /* JADX INFO: renamed from: a */
    public static void m951a(View view, int i2, int i3) {
        f668a.mo995a(view, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    public static void m952a(View view, ColorStateList colorStateList) {
        f668a.mo987a(view, colorStateList);
    }

    /* JADX INFO: renamed from: a */
    public static void m953a(View view, PorterDuff.Mode mode) {
        f668a.mo988a(view, mode);
    }

    /* JADX INFO: renamed from: a */
    public static void m954a(View view, Drawable drawable) {
        f668a.mo974a(view, drawable);
    }

    /* JADX INFO: renamed from: a */
    public static void m955a(View view, C0106b c0106b) {
        f668a.m997a(view, c0106b);
    }

    /* JADX INFO: renamed from: a */
    public static void m956a(View view, InterfaceC0122n interfaceC0122n) {
        f668a.mo989a(view, interfaceC0122n);
    }

    /* JADX INFO: renamed from: a */
    public static void m957a(View view, Runnable runnable) {
        f668a.mo975a(view, runnable);
    }

    /* JADX INFO: renamed from: a */
    public static void m958a(View view, Runnable runnable, long j2) {
        f668a.mo976a(view, runnable, j2);
    }

    /* JADX INFO: renamed from: a */
    public static void m959a(View view, String str) {
        f668a.mo990a(view, str);
    }

    /* JADX INFO: renamed from: b */
    public static int m960b(View view) {
        return f668a.mo981f(view);
    }

    /* JADX INFO: renamed from: c */
    public static int m961c(View view) {
        return f668a.mo978c(view);
    }

    /* JADX INFO: renamed from: d */
    public static C0127s m962d(View view) {
        return f668a.m998n(view);
    }

    /* JADX INFO: renamed from: e */
    public static String m963e(View view) {
        return f668a.mo991j(view);
    }

    /* JADX INFO: renamed from: f */
    public static int m964f(View view) {
        return f668a.mo982g(view);
    }

    /* JADX INFO: renamed from: g */
    public static void m965g(View view) {
        f668a.mo979d(view);
    }

    /* JADX INFO: renamed from: h */
    public static boolean m966h(View view) {
        return f668a.mo980e(view);
    }

    /* JADX INFO: renamed from: i */
    public static ColorStateList m967i(View view) {
        return f668a.mo993l(view);
    }

    /* JADX INFO: renamed from: j */
    public static PorterDuff.Mode m968j(View view) {
        return f668a.mo994m(view);
    }

    /* JADX INFO: renamed from: k */
    public static void m969k(View view) {
        f668a.mo992k(view);
    }

    /* JADX INFO: renamed from: l */
    public static boolean m970l(View view) {
        return f668a.mo983h(view);
    }

    /* JADX INFO: renamed from: m */
    public static boolean m971m(View view) {
        return f668a.mo984i(view);
    }

    /* JADX INFO: renamed from: n */
    public static boolean m972n(View view) {
        return f668a.mo973a(view);
    }
}
