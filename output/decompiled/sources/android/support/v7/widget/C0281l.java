package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.p004b.p005a.C0026c;
import android.support.p004b.p005a.C0032i;
import android.support.v4.p006a.C0033a;
import android.support.v4.p008b.C0069a;
import android.support.v4.p008b.p009a.C0070a;
import android.support.v4.p014f.C0090a;
import android.support.v4.p014f.C0095f;
import android.support.v4.p014f.C0096g;
import android.support.v4.p014f.C0101l;
import android.support.v7.p018a.C0148a;
import android.support.v7.p019b.p020a.C0175b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: android.support.v7.widget.l */
/* JADX INFO: loaded from: classes.dex */
public final class C0281l {

    /* JADX INFO: renamed from: b */
    private static C0281l f1921b;

    /* JADX INFO: renamed from: j */
    private WeakHashMap<Context, C0101l<ColorStateList>> f1929j;

    /* JADX INFO: renamed from: k */
    private C0090a<String, c> f1930k;

    /* JADX INFO: renamed from: l */
    private C0101l<String> f1931l;

    /* JADX INFO: renamed from: m */
    private final Object f1932m = new Object();

    /* JADX INFO: renamed from: n */
    private final WeakHashMap<Context, C0095f<WeakReference<Drawable.ConstantState>>> f1933n = new WeakHashMap<>(0);

    /* JADX INFO: renamed from: o */
    private TypedValue f1934o;

    /* JADX INFO: renamed from: p */
    private boolean f1935p;

    /* JADX INFO: renamed from: a */
    private static final PorterDuff.Mode f1920a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c */
    private static final b f1922c = new b(6);

    /* JADX INFO: renamed from: d */
    private static final int[] f1923d = {C0148a.e.abc_textfield_search_default_mtrl_alpha, C0148a.e.abc_textfield_default_mtrl_alpha, C0148a.e.abc_ab_share_pack_mtrl_alpha};

    /* JADX INFO: renamed from: e */
    private static final int[] f1924e = {C0148a.e.abc_ic_commit_search_api_mtrl_alpha, C0148a.e.abc_seekbar_tick_mark_material, C0148a.e.abc_ic_menu_share_mtrl_alpha, C0148a.e.abc_ic_menu_copy_mtrl_am_alpha, C0148a.e.abc_ic_menu_cut_mtrl_alpha, C0148a.e.abc_ic_menu_selectall_mtrl_alpha, C0148a.e.abc_ic_menu_paste_mtrl_am_alpha};

    /* JADX INFO: renamed from: f */
    private static final int[] f1925f = {C0148a.e.abc_textfield_activated_mtrl_alpha, C0148a.e.abc_textfield_search_activated_mtrl_alpha, C0148a.e.abc_cab_background_top_mtrl_alpha, C0148a.e.abc_text_cursor_material, C0148a.e.abc_text_select_handle_left_mtrl_dark, C0148a.e.abc_text_select_handle_middle_mtrl_dark, C0148a.e.abc_text_select_handle_right_mtrl_dark, C0148a.e.abc_text_select_handle_left_mtrl_light, C0148a.e.abc_text_select_handle_middle_mtrl_light, C0148a.e.abc_text_select_handle_right_mtrl_light};

    /* JADX INFO: renamed from: g */
    private static final int[] f1926g = {C0148a.e.abc_popup_background_mtrl_mult, C0148a.e.abc_cab_background_internal_bg, C0148a.e.abc_menu_hardkey_panel_mtrl_mult};

    /* JADX INFO: renamed from: h */
    private static final int[] f1927h = {C0148a.e.abc_tab_indicator_material, C0148a.e.abc_textfield_search_material};

    /* JADX INFO: renamed from: i */
    private static final int[] f1928i = {C0148a.e.abc_btn_check_material, C0148a.e.abc_btn_radio_material};

    /* JADX INFO: renamed from: android.support.v7.widget.l$a */
    private static class a implements c {
        a() {
        }

        @Override // android.support.v7.widget.C0281l.c
        /* JADX INFO: renamed from: a */
        public Drawable mo2116a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0026c.m94a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.l$b */
    private static class b extends C0096g<Integer, PorterDuffColorFilter> {
        public b(int i) {
            super(i);
        }

        /* JADX INFO: renamed from: b */
        private static int m2117b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        /* JADX INFO: renamed from: a */
        PorterDuffColorFilter m2118a(int i, PorterDuff.Mode mode) {
            return m798a(Integer.valueOf(m2117b(i, mode)));
        }

        /* JADX INFO: renamed from: a */
        PorterDuffColorFilter m2119a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return m799a(Integer.valueOf(m2117b(i, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.l$c */
    private interface c {
        /* JADX INFO: renamed from: a */
        Drawable mo2116a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: renamed from: android.support.v7.widget.l$d */
    private static class d implements c {
        d() {
        }

        @Override // android.support.v7.widget.C0281l.c
        /* JADX INFO: renamed from: a */
        public Drawable mo2116a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0032i.m130a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static long m2086a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    /* JADX INFO: renamed from: a */
    static PorterDuff.Mode m2087a(int i) {
        if (i == C0148a.e.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static PorterDuffColorFilter m2088a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterM2118a = f1922c.m2118a(i, mode);
        if (porterDuffColorFilterM2118a != null) {
            return porterDuffColorFilterM2118a;
        }
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
        f1922c.m2119a(i, mode, porterDuffColorFilter);
        return porterDuffColorFilter;
    }

    /* JADX INFO: renamed from: a */
    private static PorterDuffColorFilter m2089a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m2088a(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* JADX INFO: renamed from: a */
    private Drawable m2090a(Context context, int i, boolean z, Drawable drawable) {
        LayerDrawable layerDrawable;
        Drawable drawableFindDrawableByLayerId;
        int i2;
        ColorStateList colorStateListM2115b = m2115b(context, i);
        if (colorStateListM2115b != null) {
            if (C0246af.m1855b(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable drawableM658f = C0070a.m658f(drawable);
            C0070a.m648a(drawableM658f, colorStateListM2115b);
            PorterDuff.Mode modeM2087a = m2087a(i);
            if (modeM2087a == null) {
                return drawableM658f;
            }
            C0070a.m651a(drawableM658f, modeM2087a);
            return drawableM658f;
        }
        if (i == C0148a.e.abc_seekbar_track_material) {
            layerDrawable = (LayerDrawable) drawable;
            m2094a(layerDrawable.findDrawableByLayerId(R.id.background), C0258ar.m1966a(context, C0148a.a.colorControlNormal), f1920a);
            drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.secondaryProgress);
            i2 = C0148a.a.colorControlNormal;
        } else {
            if (i != C0148a.e.abc_ratingbar_material && i != C0148a.e.abc_ratingbar_indicator_material && i != C0148a.e.abc_ratingbar_small_material) {
                if (m2098a(context, i, drawable) || !z) {
                    return drawable;
                }
                return null;
            }
            layerDrawable = (LayerDrawable) drawable;
            m2094a(layerDrawable.findDrawableByLayerId(R.id.background), C0258ar.m1970c(context, C0148a.a.colorControlNormal), f1920a);
            drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.secondaryProgress);
            i2 = C0148a.a.colorControlActivated;
        }
        m2094a(drawableFindDrawableByLayerId, C0258ar.m1966a(context, i2), f1920a);
        m2094a(layerDrawable.findDrawableByLayerId(R.id.progress), C0258ar.m1966a(context, C0148a.a.colorControlActivated), f1920a);
        return drawable;
    }

    /* JADX INFO: renamed from: a */
    private Drawable m2091a(Context context, long j) {
        synchronized (this.f1932m) {
            C0095f<WeakReference<Drawable.ConstantState>> c0095f = this.f1933n.get(context);
            if (c0095f == null) {
                return null;
            }
            WeakReference<Drawable.ConstantState> weakReferenceM790a = c0095f.m790a(j);
            if (weakReferenceM790a != null) {
                Drawable.ConstantState constantState = weakReferenceM790a.get();
                if (constantState != null) {
                    return constantState.newDrawable(context.getResources());
                }
                c0095f.m794b(j);
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static C0281l m2092a() {
        if (f1921b == null) {
            f1921b = new C0281l();
            m2096a(f1921b);
        }
        return f1921b;
    }

    /* JADX INFO: renamed from: a */
    private void m2093a(Context context, int i, ColorStateList colorStateList) {
        if (this.f1929j == null) {
            this.f1929j = new WeakHashMap<>();
        }
        C0101l<ColorStateList> c0101l = this.f1929j.get(context);
        if (c0101l == null) {
            c0101l = new C0101l<>();
            this.f1929j.put(context, c0101l);
        }
        c0101l.m838c(i, colorStateList);
    }

    /* JADX INFO: renamed from: a */
    private static void m2094a(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (C0246af.m1855b(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f1920a;
        }
        drawable.setColorFilter(m2088a(i, mode));
    }

    /* JADX INFO: renamed from: a */
    static void m2095a(Drawable drawable, C0261au c0261au, int[] iArr) {
        if (C0246af.m1855b(drawable) && drawable.mutate() != drawable) {
            Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (c0261au.f1798d || c0261au.f1797c) {
            drawable.setColorFilter(m2089a(c0261au.f1798d ? c0261au.f1795a : null, c0261au.f1797c ? c0261au.f1796b : f1920a, iArr));
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m2096a(C0281l c0281l) {
        if (Build.VERSION.SDK_INT < 24) {
            c0281l.m2097a("vector", new d());
            c0281l.m2097a("animated-vector", new a());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2097a(String str, c cVar) {
        if (this.f1930k == null) {
            this.f1930k = new C0090a<>();
        }
        this.f1930k.put(str, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[RETURN] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static boolean m2098a(Context context, int i, Drawable drawable) {
        boolean z;
        int iRound;
        PorterDuff.Mode mode = f1920a;
        boolean zM2101a = m2101a(f1923d, i);
        int i2 = R.attr.colorBackground;
        if (zM2101a) {
            i2 = C0148a.a.colorControlNormal;
        } else if (m2101a(f1925f, i)) {
            i2 = C0148a.a.colorControlActivated;
        } else {
            if (!m2101a(f1926g, i)) {
                if (i == C0148a.e.abc_list_divider_mtrl_alpha) {
                    i2 = R.attr.colorForeground;
                    iRound = Math.round(40.8f);
                    z = true;
                } else if (i != C0148a.e.abc_dialog_material_background) {
                    z = false;
                    iRound = -1;
                    i2 = 0;
                }
                if (z) {
                    return false;
                }
                if (C0246af.m1855b(drawable)) {
                    drawable = drawable.mutate();
                }
                drawable.setColorFilter(m2088a(C0258ar.m1966a(context, i2), mode));
                if (iRound != -1) {
                    drawable.setAlpha(iRound);
                }
                return true;
            }
            mode = PorterDuff.Mode.MULTIPLY;
        }
        z = true;
        iRound = -1;
        if (z) {
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m2099a(Context context, long j, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.f1932m) {
            C0095f<WeakReference<Drawable.ConstantState>> c0095f = this.f1933n.get(context);
            if (c0095f == null) {
                c0095f = new C0095f<>();
                this.f1933n.put(context, c0095f);
            }
            c0095f.m795b(j, new WeakReference<>(constantState));
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2100a(Drawable drawable) {
        return (drawable instanceof C0032i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2101a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private ColorStateList m2102b(Context context) {
        return m2109f(context, C0258ar.m1966a(context, C0148a.a.colorButtonNormal));
    }

    /* JADX INFO: renamed from: c */
    private ColorStateList m2103c(Context context) {
        return m2109f(context, 0);
    }

    /* JADX INFO: renamed from: c */
    private Drawable m2104c(Context context, int i) {
        if (this.f1934o == null) {
            this.f1934o = new TypedValue();
        }
        TypedValue typedValue = this.f1934o;
        context.getResources().getValue(i, typedValue, true);
        long jM2086a = m2086a(typedValue);
        Drawable drawableM2091a = m2091a(context, jM2086a);
        if (drawableM2091a != null) {
            return drawableM2091a;
        }
        if (i == C0148a.e.abc_cab_background_top_material) {
            drawableM2091a = new LayerDrawable(new Drawable[]{m2111a(context, C0148a.e.abc_cab_background_internal_bg), m2111a(context, C0148a.e.abc_cab_background_top_mtrl_alpha)});
        }
        if (drawableM2091a != null) {
            drawableM2091a.setChangingConfigurations(typedValue.changingConfigurations);
            m2099a(context, jM2086a, drawableM2091a);
        }
        return drawableM2091a;
    }

    /* JADX INFO: renamed from: d */
    private ColorStateList m2105d(Context context) {
        return m2109f(context, C0258ar.m1966a(context, C0148a.a.colorAccent));
    }

    /* JADX INFO: renamed from: d */
    private Drawable m2106d(Context context, int i) {
        int next;
        if (this.f1930k == null || this.f1930k.isEmpty()) {
            return null;
        }
        if (this.f1931l != null) {
            String strM831a = this.f1931l.m831a(i);
            if ("appcompat_skip_skip".equals(strM831a) || (strM831a != null && this.f1930k.get(strM831a) == null)) {
                return null;
            }
        } else {
            this.f1931l = new C0101l<>();
        }
        if (this.f1934o == null) {
            this.f1934o = new TypedValue();
        }
        TypedValue typedValue = this.f1934o;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long jM2086a = m2086a(typedValue);
        Drawable drawableM2091a = m2091a(context, jM2086a);
        if (drawableM2091a != null) {
            return drawableM2091a;
        }
        if (typedValue.string != null && typedValue.string.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f1931l.m838c(i, name);
                c cVar = this.f1930k.get(name);
                if (cVar != null) {
                    drawableM2091a = cVar.mo2116a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableM2091a != null) {
                    drawableM2091a.setChangingConfigurations(typedValue.changingConfigurations);
                    m2099a(context, jM2086a, drawableM2091a);
                }
            } catch (Exception e) {
                Log.e("AppCompatDrawableManag", "Exception while inflating drawable", e);
            }
        }
        if (drawableM2091a == null) {
            this.f1931l.m838c(i, "appcompat_skip_skip");
        }
        return drawableM2091a;
    }

    /* JADX INFO: renamed from: e */
    private ColorStateList m2107e(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListM1969b = C0258ar.m1969b(context, C0148a.a.colorSwitchThumbNormal);
        if (colorStateListM1969b == null || !colorStateListM1969b.isStateful()) {
            iArr[0] = C0258ar.f1781a;
            iArr2[0] = C0258ar.m1970c(context, C0148a.a.colorSwitchThumbNormal);
            iArr[1] = C0258ar.f1785e;
            iArr2[1] = C0258ar.m1966a(context, C0148a.a.colorControlActivated);
            iArr[2] = C0258ar.f1788h;
            iArr2[2] = C0258ar.m1966a(context, C0148a.a.colorSwitchThumbNormal);
        } else {
            iArr[0] = C0258ar.f1781a;
            iArr2[0] = colorStateListM1969b.getColorForState(iArr[0], 0);
            iArr[1] = C0258ar.f1785e;
            iArr2[1] = C0258ar.m1966a(context, C0148a.a.colorControlActivated);
            iArr[2] = C0258ar.f1788h;
            iArr2[2] = colorStateListM1969b.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* JADX INFO: renamed from: e */
    private ColorStateList m2108e(Context context, int i) {
        C0101l<ColorStateList> c0101l;
        if (this.f1929j == null || (c0101l = this.f1929j.get(context)) == null) {
            return null;
        }
        return c0101l.m831a(i);
    }

    /* JADX INFO: renamed from: f */
    private ColorStateList m2109f(Context context, int i) {
        int iM1966a = C0258ar.m1966a(context, C0148a.a.colorControlHighlight);
        return new ColorStateList(new int[][]{C0258ar.f1781a, C0258ar.f1784d, C0258ar.f1782b, C0258ar.f1788h}, new int[]{C0258ar.m1970c(context, C0148a.a.colorButtonNormal), C0069a.m640a(iM1966a, i), C0069a.m640a(iM1966a, i), i});
    }

    /* JADX INFO: renamed from: f */
    private void m2110f(Context context) {
        if (this.f1935p) {
            return;
        }
        this.f1935p = true;
        Drawable drawableM2111a = m2111a(context, C0148a.e.abc_vector_test);
        if (drawableM2111a == null || !m2100a(drawableM2111a)) {
            this.f1935p = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    /* JADX INFO: renamed from: a */
    public Drawable m2111a(Context context, int i) {
        return m2112a(context, i, false);
    }

    /* JADX INFO: renamed from: a */
    Drawable m2112a(Context context, int i, boolean z) {
        m2110f(context);
        Drawable drawableM2106d = m2106d(context, i);
        if (drawableM2106d == null) {
            drawableM2106d = m2104c(context, i);
        }
        if (drawableM2106d == null) {
            drawableM2106d = C0033a.m167a(context, i);
        }
        if (drawableM2106d != null) {
            drawableM2106d = m2090a(context, i, z, drawableM2106d);
        }
        if (drawableM2106d != null) {
            C0246af.m1854a(drawableM2106d);
        }
        return drawableM2106d;
    }

    /* JADX INFO: renamed from: a */
    Drawable m2113a(Context context, C0269bb c0269bb, int i) {
        Drawable drawableM2106d = m2106d(context, i);
        if (drawableM2106d == null) {
            drawableM2106d = c0269bb.m2025a(i);
        }
        if (drawableM2106d != null) {
            return m2090a(context, i, false, drawableM2106d);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m2114a(Context context) {
        synchronized (this.f1932m) {
            C0095f<WeakReference<Drawable.ConstantState>> c0095f = this.f1933n.get(context);
            if (c0095f != null) {
                c0095f.m796c();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    ColorStateList m2115b(Context context, int i) {
        int i2;
        ColorStateList colorStateListM2108e = m2108e(context, i);
        if (colorStateListM2108e == null) {
            if (i == C0148a.e.abc_edit_text_material) {
                i2 = C0148a.c.abc_tint_edittext;
            } else if (i == C0148a.e.abc_switch_track_mtrl_alpha) {
                i2 = C0148a.c.abc_tint_switch_track;
            } else {
                if (i == C0148a.e.abc_switch_thumb_material) {
                    colorStateListM2108e = m2107e(context);
                } else if (i == C0148a.e.abc_btn_default_mtrl_shape) {
                    colorStateListM2108e = m2102b(context);
                } else if (i == C0148a.e.abc_btn_borderless_material) {
                    colorStateListM2108e = m2103c(context);
                } else if (i == C0148a.e.abc_btn_colored_material) {
                    colorStateListM2108e = m2105d(context);
                } else if (i == C0148a.e.abc_spinner_mtrl_am_alpha || i == C0148a.e.abc_spinner_textfield_background_material) {
                    i2 = C0148a.c.abc_tint_spinner;
                } else if (m2101a(f1924e, i)) {
                    colorStateListM2108e = C0258ar.m1969b(context, C0148a.a.colorControlNormal);
                } else if (m2101a(f1927h, i)) {
                    i2 = C0148a.c.abc_tint_default;
                } else if (m2101a(f1928i, i)) {
                    i2 = C0148a.c.abc_tint_btn_checkable;
                } else if (i == C0148a.e.abc_seekbar_thumb_material) {
                    i2 = C0148a.c.abc_tint_seek_thumb;
                }
                if (colorStateListM2108e != null) {
                    m2093a(context, i, colorStateListM2108e);
                }
            }
            colorStateListM2108e = C0175b.m1393a(context, i2);
            if (colorStateListM2108e != null) {
            }
        }
        return colorStateListM2108e;
    }
}
