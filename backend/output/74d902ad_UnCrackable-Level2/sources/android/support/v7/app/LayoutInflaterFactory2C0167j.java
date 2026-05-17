package android.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.C0064v;
import android.support.v4.p015g.C0113e;
import android.support.v4.p015g.C0124p;
import android.support.v4.p015g.C0127s;
import android.support.v4.p015g.C0129u;
import android.support.v4.p015g.C0131w;
import android.support.v4.p015g.InterfaceC0122n;
import android.support.v4.p015g.InterfaceC0128t;
import android.support.v4.widget.C0144j;
import android.support.v7.p018a.C0148a;
import android.support.v7.p019b.p020a.C0175b;
import android.support.v7.view.AbstractC0179b;
import android.support.v7.view.C0181d;
import android.support.v7.view.C0182e;
import android.support.v7.view.menu.C0194f;
import android.support.v7.view.menu.C0196h;
import android.support.v7.view.menu.InterfaceC0203o;
import android.support.v7.view.menu.InterfaceC0204p;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.C0269bb;
import android.support.v7.widget.C0270bc;
import android.support.v7.widget.C0281l;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.InterfaceC0244ad;
import android.support.v7.widget.InterfaceC0248ah;
import android.support.v7.widget.ViewStubCompat;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: renamed from: android.support.v7.app.j */
/* JADX INFO: loaded from: classes.dex */
class LayoutInflaterFactory2C0167j extends AbstractC0163f implements C0196h.a, LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: t */
    private static final boolean f945t;

    /* JADX INFO: renamed from: A */
    private View f946A;

    /* JADX INFO: renamed from: B */
    private boolean f947B;

    /* JADX INFO: renamed from: C */
    private boolean f948C;

    /* JADX INFO: renamed from: D */
    private boolean f949D;

    /* JADX INFO: renamed from: E */
    private d[] f950E;

    /* JADX INFO: renamed from: F */
    private d f951F;

    /* JADX INFO: renamed from: G */
    private boolean f952G;

    /* JADX INFO: renamed from: H */
    private final Runnable f953H;

    /* JADX INFO: renamed from: I */
    private boolean f954I;

    /* JADX INFO: renamed from: J */
    private Rect f955J;

    /* JADX INFO: renamed from: K */
    private Rect f956K;

    /* JADX INFO: renamed from: L */
    private AppCompatViewInflater f957L;

    /* JADX INFO: renamed from: m */
    AbstractC0179b f958m;

    /* JADX INFO: renamed from: n */
    ActionBarContextView f959n;

    /* JADX INFO: renamed from: o */
    PopupWindow f960o;

    /* JADX INFO: renamed from: p */
    Runnable f961p;

    /* JADX INFO: renamed from: q */
    C0127s f962q;

    /* JADX INFO: renamed from: r */
    boolean f963r;

    /* JADX INFO: renamed from: s */
    int f964s;

    /* JADX INFO: renamed from: u */
    private InterfaceC0244ad f965u;

    /* JADX INFO: renamed from: v */
    private a f966v;

    /* JADX INFO: renamed from: w */
    private e f967w;

    /* JADX INFO: renamed from: x */
    private boolean f968x;

    /* JADX INFO: renamed from: y */
    private ViewGroup f969y;

    /* JADX INFO: renamed from: z */
    private TextView f970z;

    /* JADX INFO: renamed from: android.support.v7.app.j$a */
    private final class a implements InterfaceC0203o.a {
        a() {
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o.a
        /* JADX INFO: renamed from: a */
        public void mo1324a(C0196h c0196h, boolean z) {
            LayoutInflaterFactory2C0167j.this.m1311b(c0196h);
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o.a
        /* JADX INFO: renamed from: a */
        public boolean mo1325a(C0196h c0196h) {
            Window.Callback callbackQ = LayoutInflaterFactory2C0167j.this.m1272q();
            if (callbackQ == null) {
                return true;
            }
            callbackQ.onMenuOpened(C0148a.j.AppCompatTheme_tooltipFrameBackground, c0196h);
            return true;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.j$b */
    class b implements AbstractC0179b.a {

        /* JADX INFO: renamed from: b */
        private AbstractC0179b.a f980b;

        public b(AbstractC0179b.a aVar) {
            this.f980b = aVar;
        }

        @Override // android.support.v7.view.AbstractC0179b.a
        /* JADX INFO: renamed from: a */
        public void mo1326a(AbstractC0179b abstractC0179b) {
            this.f980b.mo1326a(abstractC0179b);
            if (LayoutInflaterFactory2C0167j.this.f960o != null) {
                LayoutInflaterFactory2C0167j.this.f915b.getDecorView().removeCallbacks(LayoutInflaterFactory2C0167j.this.f961p);
            }
            if (LayoutInflaterFactory2C0167j.this.f959n != null) {
                LayoutInflaterFactory2C0167j.this.m1318t();
                LayoutInflaterFactory2C0167j.this.f962q = C0124p.m962d(LayoutInflaterFactory2C0167j.this.f959n).m1017a(0.0f);
                LayoutInflaterFactory2C0167j.this.f962q.m1019a(new C0129u() { // from class: android.support.v7.app.j.b.1
                    @Override // android.support.v4.p015g.C0129u, android.support.v4.p015g.InterfaceC0128t
                    /* JADX INFO: renamed from: b */
                    public void mo1027b(View view) {
                        LayoutInflaterFactory2C0167j.this.f959n.setVisibility(8);
                        if (LayoutInflaterFactory2C0167j.this.f960o != null) {
                            LayoutInflaterFactory2C0167j.this.f960o.dismiss();
                        } else if (LayoutInflaterFactory2C0167j.this.f959n.getParent() instanceof View) {
                            C0124p.m965g((View) LayoutInflaterFactory2C0167j.this.f959n.getParent());
                        }
                        LayoutInflaterFactory2C0167j.this.f959n.removeAllViews();
                        LayoutInflaterFactory2C0167j.this.f962q.m1019a((InterfaceC0128t) null);
                        LayoutInflaterFactory2C0167j.this.f962q = null;
                    }
                });
            }
            if (LayoutInflaterFactory2C0167j.this.f918e != null) {
                LayoutInflaterFactory2C0167j.this.f918e.mo1230b(LayoutInflaterFactory2C0167j.this.f958m);
            }
            LayoutInflaterFactory2C0167j.this.f958m = null;
        }

        @Override // android.support.v7.view.AbstractC0179b.a
        /* JADX INFO: renamed from: a */
        public boolean mo1327a(AbstractC0179b abstractC0179b, Menu menu) {
            return this.f980b.mo1327a(abstractC0179b, menu);
        }

        @Override // android.support.v7.view.AbstractC0179b.a
        /* JADX INFO: renamed from: a */
        public boolean mo1328a(AbstractC0179b abstractC0179b, MenuItem menuItem) {
            return this.f980b.mo1328a(abstractC0179b, menuItem);
        }

        @Override // android.support.v7.view.AbstractC0179b.a
        /* JADX INFO: renamed from: b */
        public boolean mo1329b(AbstractC0179b abstractC0179b, Menu menu) {
            return this.f980b.mo1329b(abstractC0179b, menu);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.j$c */
    private class c extends ContentFrameLayout {
        public c(Context context) {
            super(context);
        }

        /* JADX INFO: renamed from: a */
        private boolean m1330a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return LayoutInflaterFactory2C0167j.this.mo1264a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m1330a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            LayoutInflaterFactory2C0167j.this.m1314e(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C0175b.m1396b(getContext(), i));
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.j$d */
    protected static final class d {

        /* JADX INFO: renamed from: a */
        int f983a;

        /* JADX INFO: renamed from: b */
        int f984b;

        /* JADX INFO: renamed from: c */
        int f985c;

        /* JADX INFO: renamed from: d */
        int f986d;

        /* JADX INFO: renamed from: e */
        int f987e;

        /* JADX INFO: renamed from: f */
        int f988f;

        /* JADX INFO: renamed from: g */
        ViewGroup f989g;

        /* JADX INFO: renamed from: h */
        View f990h;

        /* JADX INFO: renamed from: i */
        View f991i;

        /* JADX INFO: renamed from: j */
        C0196h f992j;

        /* JADX INFO: renamed from: k */
        C0194f f993k;

        /* JADX INFO: renamed from: l */
        Context f994l;

        /* JADX INFO: renamed from: m */
        boolean f995m;

        /* JADX INFO: renamed from: n */
        boolean f996n;

        /* JADX INFO: renamed from: o */
        boolean f997o;

        /* JADX INFO: renamed from: p */
        public boolean f998p;

        /* JADX INFO: renamed from: q */
        boolean f999q = false;

        /* JADX INFO: renamed from: r */
        boolean f1000r;

        /* JADX INFO: renamed from: s */
        Bundle f1001s;

        d(int i) {
            this.f983a = i;
        }

        /* JADX INFO: renamed from: a */
        InterfaceC0204p m1331a(InterfaceC0203o.a aVar) {
            if (this.f992j == null) {
                return null;
            }
            if (this.f993k == null) {
                this.f993k = new C0194f(this.f994l, C0148a.g.abc_list_menu_item_layout);
                this.f993k.mo1472a(aVar);
                this.f992j.m1540a(this.f993k);
            }
            return this.f993k.m1513a(this.f989g);
        }

        /* JADX INFO: renamed from: a */
        void m1332a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(C0148a.a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            themeNewTheme.resolveAttribute(C0148a.a.panelMenuListTheme, typedValue, true);
            themeNewTheme.applyStyle(typedValue.resourceId != 0 ? typedValue.resourceId : C0148a.i.Theme_AppCompat_CompactMenu, true);
            C0181d c0181d = new C0181d(context, 0);
            c0181d.getTheme().setTo(themeNewTheme);
            this.f994l = c0181d;
            TypedArray typedArrayObtainStyledAttributes = c0181d.obtainStyledAttributes(C0148a.j.AppCompatTheme);
            this.f984b = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.AppCompatTheme_panelBackground, 0);
            this.f988f = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* JADX INFO: renamed from: a */
        void m1333a(C0196h c0196h) {
            if (c0196h == this.f992j) {
                return;
            }
            if (this.f992j != null) {
                this.f992j.m1551b(this.f993k);
            }
            this.f992j = c0196h;
            if (c0196h == null || this.f993k == null) {
                return;
            }
            c0196h.m1540a(this.f993k);
        }

        /* JADX INFO: renamed from: a */
        public boolean m1334a() {
            if (this.f990h == null) {
                return false;
            }
            return this.f991i != null || this.f993k.m1514a().getCount() > 0;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.j$e */
    private final class e implements InterfaceC0203o.a {
        e() {
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o.a
        /* JADX INFO: renamed from: a */
        public void mo1324a(C0196h c0196h, boolean z) {
            C0196h c0196hMo1573p = c0196h.mo1573p();
            boolean z2 = c0196hMo1573p != c0196h;
            LayoutInflaterFactory2C0167j layoutInflaterFactory2C0167j = LayoutInflaterFactory2C0167j.this;
            if (z2) {
                c0196h = c0196hMo1573p;
            }
            d dVarM1303a = layoutInflaterFactory2C0167j.m1303a((Menu) c0196h);
            if (dVarM1303a != null) {
                if (!z2) {
                    LayoutInflaterFactory2C0167j.this.m1305a(dVarM1303a, z);
                } else {
                    LayoutInflaterFactory2C0167j.this.m1304a(dVarM1303a.f983a, dVarM1303a, c0196hMo1573p);
                    LayoutInflaterFactory2C0167j.this.m1305a(dVarM1303a, true);
                }
            }
        }

        @Override // android.support.v7.view.menu.InterfaceC0203o.a
        /* JADX INFO: renamed from: a */
        public boolean mo1325a(C0196h c0196h) {
            Window.Callback callbackQ;
            if (c0196h != null || !LayoutInflaterFactory2C0167j.this.f921h || (callbackQ = LayoutInflaterFactory2C0167j.this.m1272q()) == null || LayoutInflaterFactory2C0167j.this.m1271p()) {
                return true;
            }
            callbackQ.onMenuOpened(C0148a.j.AppCompatTheme_tooltipFrameBackground, c0196h);
            return true;
        }
    }

    static {
        f945t = Build.VERSION.SDK_INT < 21;
    }

    LayoutInflaterFactory2C0167j(Context context, Window window, InterfaceC0161d interfaceC0161d) {
        super(context, window, interfaceC0161d);
        this.f962q = null;
        this.f953H = new Runnable() { // from class: android.support.v7.app.j.1
            @Override // java.lang.Runnable
            public void run() {
                if ((LayoutInflaterFactory2C0167j.this.f964s & 1) != 0) {
                    LayoutInflaterFactory2C0167j.this.m1315f(0);
                }
                if ((LayoutInflaterFactory2C0167j.this.f964s & 4096) != 0) {
                    LayoutInflaterFactory2C0167j.this.m1315f(C0148a.j.AppCompatTheme_tooltipFrameBackground);
                }
                LayoutInflaterFactory2C0167j.this.f963r = false;
                LayoutInflaterFactory2C0167j.this.f964s = 0;
            }
        };
    }

    /* JADX INFO: renamed from: a */
    private void m1286a(d dVar, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (dVar.f997o || m1271p()) {
            return;
        }
        if (dVar.f983a == 0) {
            if ((this.f914a.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackQ = m1272q();
        if (callbackQ != null && !callbackQ.onMenuOpened(dVar.f983a, dVar.f992j)) {
            m1305a(dVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f914a.getSystemService("window");
        if (windowManager != null && m1292b(dVar, keyEvent)) {
            if (dVar.f989g != null && !dVar.f999q) {
                if (dVar.f991i != null && (layoutParams = dVar.f991i.getLayoutParams()) != null && layoutParams.width == -1) {
                    i = -1;
                }
                dVar.f996n = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i, -2, dVar.f986d, dVar.f987e, 1002, 8519680, -3);
                layoutParams2.gravity = dVar.f985c;
                layoutParams2.windowAnimations = dVar.f988f;
                windowManager.addView(dVar.f989g, layoutParams2);
                dVar.f997o = true;
            }
            if (dVar.f989g == null) {
                if (!m1288a(dVar) || dVar.f989g == null) {
                    return;
                }
            } else if (dVar.f999q && dVar.f989g.getChildCount() > 0) {
                dVar.f989g.removeAllViews();
            }
            if (!m1293c(dVar) || !dVar.m1334a()) {
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = dVar.f990h.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            dVar.f989g.setBackgroundResource(dVar.f984b);
            ViewParent parent = dVar.f990h.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(dVar.f990h);
            }
            dVar.f989g.addView(dVar.f990h, layoutParams3);
            if (!dVar.f990h.hasFocus()) {
                dVar.f990h.requestFocus();
            }
            i = -2;
            dVar.f996n = false;
            WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i, -2, dVar.f986d, dVar.f987e, 1002, 8519680, -3);
            layoutParams22.gravity = dVar.f985c;
            layoutParams22.windowAnimations = dVar.f988f;
            windowManager.addView(dVar.f989g, layoutParams22);
            dVar.f997o = true;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1287a(C0196h c0196h, boolean z) {
        if (this.f965u == null || !this.f965u.mo1658e() || (ViewConfiguration.get(this.f914a).hasPermanentMenuKey() && !this.f965u.mo1660g())) {
            d dVarM1302a = m1302a(0, true);
            dVarM1302a.f999q = true;
            m1305a(dVarM1302a, false);
            m1286a(dVarM1302a, (KeyEvent) null);
            return;
        }
        Window.Callback callbackQ = m1272q();
        if (this.f965u.mo1659f() && z) {
            this.f965u.mo1662i();
            if (m1271p()) {
                return;
            }
            callbackQ.onPanelClosed(C0148a.j.AppCompatTheme_tooltipFrameBackground, m1302a(0, true).f992j);
            return;
        }
        if (callbackQ == null || m1271p()) {
            return;
        }
        if (this.f963r && (this.f964s & 1) != 0) {
            this.f915b.getDecorView().removeCallbacks(this.f953H);
            this.f953H.run();
        }
        d dVarM1302a2 = m1302a(0, true);
        if (dVarM1302a2.f992j == null || dVarM1302a2.f1000r || !callbackQ.onPreparePanel(0, dVarM1302a2.f991i, dVarM1302a2.f992j)) {
            return;
        }
        callbackQ.onMenuOpened(C0148a.j.AppCompatTheme_tooltipFrameBackground, dVarM1302a2.f992j);
        this.f965u.mo1661h();
    }

    /* JADX INFO: renamed from: a */
    private boolean m1288a(d dVar) {
        dVar.m1332a(m1269n());
        dVar.f989g = new c(dVar.f994l);
        dVar.f985c = 81;
        return true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m1289a(d dVar, int i, KeyEvent keyEvent, int i2) {
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((dVar.f995m || m1292b(dVar, keyEvent)) && dVar.f992j != null) {
            zPerformShortcut = dVar.f992j.performShortcut(i, keyEvent, i2);
        }
        if (zPerformShortcut && (i2 & 1) == 0 && this.f965u == null) {
            m1305a(dVar, true);
        }
        return zPerformShortcut;
    }

    /* JADX INFO: renamed from: a */
    private boolean m1290a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f915b.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || C0124p.m971m((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    private boolean m1291b(d dVar) {
        Context context = this.f914a;
        if ((dVar.f983a == 0 || dVar.f983a == 108) && this.f965u != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(C0148a.a.actionBarTheme, typedValue, true);
            Resources.Theme themeNewTheme = null;
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(C0148a.a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0148a.a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                C0181d c0181d = new C0181d(context, 0);
                c0181d.getTheme().setTo(themeNewTheme);
                context = c0181d;
            }
        }
        C0196h c0196h = new C0196h(context);
        c0196h.mo1538a(this);
        dVar.m1333a(c0196h);
        return true;
    }

    /* JADX INFO: renamed from: b */
    private boolean m1292b(d dVar, KeyEvent keyEvent) {
        if (m1271p()) {
            return false;
        }
        if (dVar.f995m) {
            return true;
        }
        if (this.f951F != null && this.f951F != dVar) {
            m1305a(this.f951F, false);
        }
        Window.Callback callbackQ = m1272q();
        if (callbackQ != null) {
            dVar.f991i = callbackQ.onCreatePanelView(dVar.f983a);
        }
        boolean z = dVar.f983a == 0 || dVar.f983a == 108;
        if (z && this.f965u != null) {
            this.f965u.mo1663j();
        }
        if (dVar.f991i == null && (!z || !(m1268m() instanceof C0170m))) {
            if (dVar.f992j == null || dVar.f1000r) {
                if (dVar.f992j == null && (!m1291b(dVar) || dVar.f992j == null)) {
                    return false;
                }
                if (z && this.f965u != null) {
                    if (this.f966v == null) {
                        this.f966v = new a();
                    }
                    this.f965u.mo1653a(dVar.f992j, this.f966v);
                }
                dVar.f992j.m1564g();
                if (!callbackQ.onCreatePanelMenu(dVar.f983a, dVar.f992j)) {
                    dVar.m1333a((C0196h) null);
                    if (z && this.f965u != null) {
                        this.f965u.mo1653a(null, this.f966v);
                    }
                    return false;
                }
                dVar.f1000r = false;
            }
            dVar.f992j.m1564g();
            if (dVar.f1001s != null) {
                dVar.f992j.m1549b(dVar.f1001s);
                dVar.f1001s = null;
            }
            if (!callbackQ.onPreparePanel(0, dVar.f991i, dVar.f992j)) {
                if (z && this.f965u != null) {
                    this.f965u.mo1653a(null, this.f966v);
                }
                dVar.f992j.m1565h();
                return false;
            }
            dVar.f998p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            dVar.f992j.setQwertyMode(dVar.f998p);
            dVar.f992j.m1565h();
        }
        dVar.f995m = true;
        dVar.f996n = false;
        this.f951F = dVar;
        return true;
    }

    /* JADX INFO: renamed from: c */
    private boolean m1293c(d dVar) {
        if (dVar.f991i != null) {
            dVar.f990h = dVar.f991i;
            return true;
        }
        if (dVar.f992j == null) {
            return false;
        }
        if (this.f967w == null) {
            this.f967w = new e();
        }
        dVar.f990h = (View) dVar.m1331a(this.f967w);
        return dVar.f990h != null;
    }

    /* JADX INFO: renamed from: d */
    private void m1294d(int i) {
        this.f964s = (1 << i) | this.f964s;
        if (this.f963r) {
            return;
        }
        C0124p.m957a(this.f915b.getDecorView(), this.f953H);
        this.f963r = true;
    }

    /* JADX INFO: renamed from: d */
    private boolean m1295d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        d dVarM1302a = m1302a(i, true);
        if (dVarM1302a.f997o) {
            return false;
        }
        return m1292b(dVarM1302a, keyEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0067  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean m1296e(int i, KeyEvent keyEvent) {
        boolean zMo1662i;
        boolean zM1292b;
        if (this.f958m != null) {
            return false;
        }
        d dVarM1302a = m1302a(i, true);
        if (i != 0 || this.f965u == null || !this.f965u.mo1658e() || ViewConfiguration.get(this.f914a).hasPermanentMenuKey()) {
            if (dVarM1302a.f997o || dVarM1302a.f996n) {
                zMo1662i = dVarM1302a.f997o;
                m1305a(dVarM1302a, true);
            } else if (dVarM1302a.f995m) {
                if (dVarM1302a.f1000r) {
                    dVarM1302a.f995m = false;
                    zM1292b = m1292b(dVarM1302a, keyEvent);
                } else {
                    zM1292b = true;
                }
                if (zM1292b) {
                    m1286a(dVarM1302a, keyEvent);
                    zMo1662i = true;
                }
            } else {
                zMo1662i = false;
            }
        } else if (this.f965u.mo1659f()) {
            zMo1662i = this.f965u.mo1662i();
        } else if (!m1271p() && m1292b(dVarM1302a, keyEvent)) {
            zMo1662i = this.f965u.mo1661h();
        }
        if (zMo1662i) {
            AudioManager audioManager = (AudioManager) this.f914a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return zMo1662i;
    }

    /* JADX INFO: renamed from: h */
    private int m1297h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return C0148a.j.AppCompatTheme_tooltipFrameBackground;
        }
        if (i != 9) {
            return i;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    /* JADX INFO: renamed from: w */
    private void m1298w() {
        if (this.f968x) {
            return;
        }
        this.f969y = m1299x();
        CharSequence charSequenceR = m1273r();
        if (!TextUtils.isEmpty(charSequenceR)) {
            mo1265b(charSequenceR);
        }
        m1300y();
        m1307a(this.f969y);
        this.f968x = true;
        d dVarM1302a = m1302a(0, false);
        if (m1271p()) {
            return;
        }
        if (dVarM1302a == null || dVarM1302a.f992j == null) {
            m1294d(C0148a.j.AppCompatTheme_tooltipFrameBackground);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r0v8, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r2v12, types: [android.view.Window] */
    /* JADX INFO: renamed from: x */
    private ViewGroup m1299x() {
        ?? r0;
        TypedArray typedArrayObtainStyledAttributes = this.f914a.obtainStyledAttributes(C0148a.j.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(C0148a.j.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C0148a.j.AppCompatTheme_windowNoTitle, false)) {
            mo1253c(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(C0148a.j.AppCompatTheme_windowActionBar, false)) {
            mo1253c(C0148a.j.AppCompatTheme_tooltipFrameBackground);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C0148a.j.AppCompatTheme_windowActionBarOverlay, false)) {
            mo1253c(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(C0148a.j.AppCompatTheme_windowActionModeOverlay, false)) {
            mo1253c(10);
        }
        this.f924k = typedArrayObtainStyledAttributes.getBoolean(C0148a.j.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        this.f915b.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f914a);
        if (this.f925l) {
            ?? r02 = (ViewGroup) layoutInflaterFrom.inflate(this.f923j ? C0148a.g.abc_screen_simple_overlay_action_mode : C0148a.g.abc_screen_simple, (ViewGroup) null);
            if (Build.VERSION.SDK_INT >= 21) {
                C0124p.m956a((View) r02, new InterfaceC0122n() { // from class: android.support.v7.app.j.2
                    @Override // android.support.v4.p015g.InterfaceC0122n
                    /* JADX INFO: renamed from: a */
                    public C0131w mo947a(View view, C0131w c0131w) {
                        int iM1034b = c0131w.m1034b();
                        int iM1316g = LayoutInflaterFactory2C0167j.this.m1316g(iM1034b);
                        if (iM1034b != iM1316g) {
                            c0131w = c0131w.m1033a(c0131w.m1032a(), iM1316g, c0131w.m1035c(), c0131w.m1036d());
                        }
                        return C0124p.m948a(view, c0131w);
                    }
                });
                r0 = r02;
            } else {
                ((InterfaceC0248ah) r02).setOnFitSystemWindowsListener(new InterfaceC0248ah.a() { // from class: android.support.v7.app.j.3
                    @Override // android.support.v7.widget.InterfaceC0248ah.a
                    /* JADX INFO: renamed from: a */
                    public void mo1321a(Rect rect) {
                        rect.top = LayoutInflaterFactory2C0167j.this.m1316g(rect.top);
                    }
                });
                r0 = r02;
            }
        } else if (this.f924k) {
            ViewGroup viewGroup = (ViewGroup) layoutInflaterFrom.inflate(C0148a.g.abc_dialog_title_material, (ViewGroup) null);
            this.f922i = false;
            this.f921h = false;
            r0 = viewGroup;
        } else if (this.f921h) {
            TypedValue typedValue = new TypedValue();
            this.f914a.getTheme().resolveAttribute(C0148a.a.actionBarTheme, typedValue, true);
            ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C0181d(this.f914a, typedValue.resourceId) : this.f914a).inflate(C0148a.g.abc_screen_toolbar, (ViewGroup) null);
            this.f965u = (InterfaceC0244ad) viewGroup2.findViewById(C0148a.f.decor_content_parent);
            this.f965u.setWindowCallback(m1272q());
            if (this.f922i) {
                this.f965u.mo1652a(109);
            }
            if (this.f947B) {
                this.f965u.mo1652a(2);
            }
            r0 = viewGroup2;
            if (this.f948C) {
                this.f965u.mo1652a(5);
                r0 = viewGroup2;
            }
        } else {
            r0 = 0;
        }
        if (r0 == 0) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f921h + ", windowActionBarOverlay: " + this.f922i + ", android:windowIsFloating: " + this.f924k + ", windowActionModeOverlay: " + this.f923j + ", windowNoTitle: " + this.f925l + " }");
        }
        if (this.f965u == null) {
            this.f970z = (TextView) r0.findViewById(C0148a.f.title);
        }
        C0270bc.m2028b(r0);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) r0.findViewById(C0148a.f.action_bar_activity_content);
        ViewGroup viewGroup3 = (ViewGroup) this.f915b.findViewById(R.id.content);
        if (viewGroup3 != null) {
            while (viewGroup3.getChildCount() > 0) {
                View childAt = viewGroup3.getChildAt(0);
                viewGroup3.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup3.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup3 instanceof FrameLayout) {
                ((FrameLayout) viewGroup3).setForeground(null);
            }
        }
        this.f915b.setContentView(r0);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.InterfaceC0224a() { // from class: android.support.v7.app.j.4
            @Override // android.support.v7.widget.ContentFrameLayout.InterfaceC0224a
            /* JADX INFO: renamed from: a */
            public void mo1322a() {
            }

            @Override // android.support.v7.widget.ContentFrameLayout.InterfaceC0224a
            /* JADX INFO: renamed from: b */
            public void mo1323b() {
                LayoutInflaterFactory2C0167j.this.m1320v();
            }
        });
        return r0;
    }

    /* JADX INFO: renamed from: y */
    private void m1300y() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f969y.findViewById(R.id.content);
        View decorView = this.f915b.getDecorView();
        contentFrameLayout.m1704a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f914a.obtainStyledAttributes(C0148a.j.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(C0148a.j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(C0148a.j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(C0148a.j.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(C0148a.j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(C0148a.j.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(C0148a.j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(C0148a.j.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(C0148a.j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(C0148a.j.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(C0148a.j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* JADX INFO: renamed from: z */
    private void m1301z() {
        if (this.f968x) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* JADX INFO: renamed from: a */
    protected d m1302a(int i, boolean z) {
        d[] dVarArr = this.f950E;
        if (dVarArr == null || dVarArr.length <= i) {
            d[] dVarArr2 = new d[i + 1];
            if (dVarArr != null) {
                System.arraycopy(dVarArr, 0, dVarArr2, 0, dVarArr.length);
            }
            this.f950E = dVarArr2;
            dVarArr = dVarArr2;
        }
        d dVar = dVarArr[i];
        if (dVar != null) {
            return dVar;
        }
        d dVar2 = new d(i);
        dVarArr[i] = dVar2;
        return dVar2;
    }

    /* JADX INFO: renamed from: a */
    d m1303a(Menu menu) {
        d[] dVarArr = this.f950E;
        int length = dVarArr != null ? dVarArr.length : 0;
        for (int i = 0; i < length; i++) {
            d dVar = dVarArr[i];
            if (dVar != null && dVar.f992j == menu) {
                return dVar;
            }
        }
        return null;
    }

    @Override // android.support.v7.app.AbstractC0163f
    /* JADX INFO: renamed from: a */
    AbstractC0179b mo1260a(AbstractC0179b.a aVar) {
        AbstractC0179b abstractC0179bMo1224a;
        Context c0181d;
        m1318t();
        if (this.f958m != null) {
            this.f958m.mo1381c();
        }
        if (!(aVar instanceof b)) {
            aVar = new b(aVar);
        }
        if (this.f918e == null || m1271p()) {
            abstractC0179bMo1224a = null;
        } else {
            try {
                abstractC0179bMo1224a = this.f918e.mo1224a(aVar);
            } catch (AbstractMethodError unused) {
                abstractC0179bMo1224a = null;
            }
        }
        if (abstractC0179bMo1224a != null) {
            this.f958m = abstractC0179bMo1224a;
        } else {
            if (this.f959n == null) {
                if (this.f924k) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f914a.getTheme();
                    theme.resolveAttribute(C0148a.a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f914a.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        c0181d = new C0181d(this.f914a, 0);
                        c0181d.getTheme().setTo(themeNewTheme);
                    } else {
                        c0181d = this.f914a;
                    }
                    this.f959n = new ActionBarContextView(c0181d);
                    this.f960o = new PopupWindow(c0181d, (AttributeSet) null, C0148a.a.actionModePopupWindowStyle);
                    C0144j.m1135a(this.f960o, 2);
                    this.f960o.setContentView(this.f959n);
                    this.f960o.setWidth(-1);
                    c0181d.getTheme().resolveAttribute(C0148a.a.actionBarSize, typedValue, true);
                    this.f959n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c0181d.getResources().getDisplayMetrics()));
                    this.f960o.setHeight(-2);
                    this.f961p = new Runnable() { // from class: android.support.v7.app.j.5
                        @Override // java.lang.Runnable
                        public void run() {
                            LayoutInflaterFactory2C0167j.this.f960o.showAtLocation(LayoutInflaterFactory2C0167j.this.f959n, 55, 0, 0);
                            LayoutInflaterFactory2C0167j.this.m1318t();
                            if (!LayoutInflaterFactory2C0167j.this.m1317s()) {
                                LayoutInflaterFactory2C0167j.this.f959n.setAlpha(1.0f);
                                LayoutInflaterFactory2C0167j.this.f959n.setVisibility(0);
                            } else {
                                LayoutInflaterFactory2C0167j.this.f959n.setAlpha(0.0f);
                                LayoutInflaterFactory2C0167j.this.f962q = C0124p.m962d(LayoutInflaterFactory2C0167j.this.f959n).m1017a(1.0f);
                                LayoutInflaterFactory2C0167j.this.f962q.m1019a(new C0129u() { // from class: android.support.v7.app.j.5.1
                                    @Override // android.support.v4.p015g.C0129u, android.support.v4.p015g.InterfaceC0128t
                                    /* JADX INFO: renamed from: a */
                                    public void mo1026a(View view) {
                                        LayoutInflaterFactory2C0167j.this.f959n.setVisibility(0);
                                    }

                                    @Override // android.support.v4.p015g.C0129u, android.support.v4.p015g.InterfaceC0128t
                                    /* JADX INFO: renamed from: b */
                                    public void mo1027b(View view) {
                                        LayoutInflaterFactory2C0167j.this.f959n.setAlpha(1.0f);
                                        LayoutInflaterFactory2C0167j.this.f962q.m1019a((InterfaceC0128t) null);
                                        LayoutInflaterFactory2C0167j.this.f962q = null;
                                    }
                                });
                            }
                        }
                    };
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f969y.findViewById(C0148a.f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m1269n()));
                        this.f959n = (ActionBarContextView) viewStubCompat.m1787a();
                    }
                }
            }
            if (this.f959n != null) {
                m1318t();
                this.f959n.m1641c();
                C0182e c0182e = new C0182e(this.f959n.getContext(), this.f959n, aVar, this.f960o == null);
                if (aVar.mo1327a(c0182e, c0182e.mo1378b())) {
                    c0182e.mo1382d();
                    this.f959n.m1638a(c0182e);
                    this.f958m = c0182e;
                    if (m1317s()) {
                        this.f959n.setAlpha(0.0f);
                        this.f962q = C0124p.m962d(this.f959n).m1017a(1.0f);
                        this.f962q.m1019a(new C0129u() { // from class: android.support.v7.app.j.6
                            @Override // android.support.v4.p015g.C0129u, android.support.v4.p015g.InterfaceC0128t
                            /* JADX INFO: renamed from: a */
                            public void mo1026a(View view) {
                                LayoutInflaterFactory2C0167j.this.f959n.setVisibility(0);
                                LayoutInflaterFactory2C0167j.this.f959n.sendAccessibilityEvent(32);
                                if (LayoutInflaterFactory2C0167j.this.f959n.getParent() instanceof View) {
                                    C0124p.m965g((View) LayoutInflaterFactory2C0167j.this.f959n.getParent());
                                }
                            }

                            @Override // android.support.v4.p015g.C0129u, android.support.v4.p015g.InterfaceC0128t
                            /* JADX INFO: renamed from: b */
                            public void mo1027b(View view) {
                                LayoutInflaterFactory2C0167j.this.f959n.setAlpha(1.0f);
                                LayoutInflaterFactory2C0167j.this.f962q.m1019a((InterfaceC0128t) null);
                                LayoutInflaterFactory2C0167j.this.f962q = null;
                            }
                        });
                    } else {
                        this.f959n.setAlpha(1.0f);
                        this.f959n.setVisibility(0);
                        this.f959n.sendAccessibilityEvent(32);
                        if (this.f959n.getParent() instanceof View) {
                            C0124p.m965g((View) this.f959n.getParent());
                        }
                    }
                    if (this.f960o != null) {
                        this.f915b.getDecorView().post(this.f961p);
                    }
                } else {
                    this.f958m = null;
                }
            }
        }
        if (this.f958m != null && this.f918e != null) {
            this.f918e.mo1226a(this.f958m);
        }
        return this.f958m;
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: a */
    public <T extends View> T mo1241a(int i) {
        m1298w();
        return (T) this.f915b.findViewById(i);
    }

    /* JADX INFO: renamed from: a */
    View mo1279a(View view, String str, Context context, AttributeSet attributeSet) {
        View viewOnCreateView;
        if (!(this.f916c instanceof LayoutInflater.Factory) || (viewOnCreateView = ((LayoutInflater.Factory) this.f916c).onCreateView(str, context, attributeSet)) == null) {
            return null;
        }
        return viewOnCreateView;
    }

    /* JADX INFO: renamed from: a */
    void m1304a(int i, d dVar, Menu menu) {
        if (menu == null) {
            if (dVar == null && i >= 0 && i < this.f950E.length) {
                dVar = this.f950E[i];
            }
            if (dVar != null) {
                menu = dVar.f992j;
            }
        }
        if ((dVar == null || dVar.f997o) && !m1271p()) {
            this.f916c.onPanelClosed(i, menu);
        }
    }

    @Override // android.support.v7.app.AbstractC0163f
    /* JADX INFO: renamed from: a */
    void mo1262a(int i, Menu menu) {
        if (i == 108) {
            AbstractC0158a abstractC0158aA = mo1240a();
            if (abstractC0158aA != null) {
                abstractC0158aA.mo1205e(false);
                return;
            }
            return;
        }
        if (i == 0) {
            d dVarM1302a = m1302a(i, true);
            if (dVarM1302a.f997o) {
                m1305a(dVarM1302a, false);
            }
        }
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: a */
    public void mo1242a(Configuration configuration) {
        AbstractC0158a abstractC0158aA;
        if (this.f921h && this.f968x && (abstractC0158aA = mo1240a()) != null) {
            abstractC0158aA.mo1194a(configuration);
        }
        C0281l.m2092a().m2114a(this.f914a);
        mo1259i();
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: a */
    public void mo1243a(Bundle bundle) {
        if (!(this.f916c instanceof Activity) || C0064v.m632b((Activity) this.f916c) == null) {
            return;
        }
        AbstractC0158a abstractC0158aM = m1268m();
        if (abstractC0158aM == null) {
            this.f954I = true;
        } else {
            abstractC0158aM.mo1201c(true);
        }
    }

    /* JADX INFO: renamed from: a */
    void m1305a(d dVar, boolean z) {
        if (z && dVar.f983a == 0 && this.f965u != null && this.f965u.mo1659f()) {
            m1311b(dVar.f992j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f914a.getSystemService("window");
        if (windowManager != null && dVar.f997o && dVar.f989g != null) {
            windowManager.removeView(dVar.f989g);
            if (z) {
                m1304a(dVar.f983a, dVar, (Menu) null);
            }
        }
        dVar.f995m = false;
        dVar.f996n = false;
        dVar.f997o = false;
        dVar.f990h = null;
        dVar.f999q = true;
        if (this.f951F == dVar) {
            this.f951F = null;
        }
    }

    @Override // android.support.v7.view.menu.C0196h.a
    /* JADX INFO: renamed from: a */
    public void mo1306a(C0196h c0196h) {
        m1287a(c0196h, true);
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: a */
    public void mo1244a(View view) {
        m1298w();
        ViewGroup viewGroup = (ViewGroup) this.f969y.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f916c.onContentChanged();
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: a */
    public void mo1245a(View view, ViewGroup.LayoutParams layoutParams) {
        m1298w();
        ViewGroup viewGroup = (ViewGroup) this.f969y.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f916c.onContentChanged();
    }

    /* JADX INFO: renamed from: a */
    void m1307a(ViewGroup viewGroup) {
    }

    @Override // android.support.v7.app.AbstractC0163f
    /* JADX INFO: renamed from: a */
    boolean mo1263a(int i, KeyEvent keyEvent) {
        AbstractC0158a abstractC0158aA = mo1240a();
        if (abstractC0158aA != null && abstractC0158aA.mo1197a(i, keyEvent)) {
            return true;
        }
        if (this.f951F != null && m1289a(this.f951F, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f951F != null) {
                this.f951F.f996n = true;
            }
            return true;
        }
        if (this.f951F == null) {
            d dVarM1302a = m1302a(0, true);
            m1292b(dVarM1302a, keyEvent);
            boolean zM1289a = m1289a(dVarM1302a, keyEvent.getKeyCode(), keyEvent, 1);
            dVarM1302a.f995m = false;
            if (zM1289a) {
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.view.menu.C0196h.a
    /* JADX INFO: renamed from: a */
    public boolean mo1308a(C0196h c0196h, MenuItem menuItem) {
        d dVarM1303a;
        Window.Callback callbackQ = m1272q();
        if (callbackQ == null || m1271p() || (dVarM1303a = m1303a((Menu) c0196h.mo1573p())) == null) {
            return false;
        }
        return callbackQ.onMenuItemSelected(dVarM1303a.f983a, menuItem);
    }

    @Override // android.support.v7.app.AbstractC0163f
    /* JADX INFO: renamed from: a */
    boolean mo1264a(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 82 && this.f916c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? m1313c(keyCode, keyEvent) : m1312b(keyCode, keyEvent);
    }

    /* JADX INFO: renamed from: b */
    public AbstractC0179b m1309b(AbstractC0179b.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f958m != null) {
            this.f958m.mo1381c();
        }
        b bVar = new b(aVar);
        AbstractC0158a abstractC0158aA = mo1240a();
        if (abstractC0158aA != null) {
            this.f958m = abstractC0158aA.mo1192a(bVar);
            if (this.f958m != null && this.f918e != null) {
                this.f918e.mo1226a(this.f958m);
            }
        }
        if (this.f958m == null) {
            this.f958m = mo1260a(bVar);
        }
        return this.f958m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    public View m1310b(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        AppCompatViewInflater appCompatViewInflater;
        boolean zM1290a = false;
        if (this.f957L == null) {
            String string = this.f914a.obtainStyledAttributes(C0148a.j.AppCompatTheme).getString(C0148a.j.AppCompatTheme_viewInflaterClass);
            if (string == null || AppCompatViewInflater.class.getName().equals(string)) {
                appCompatViewInflater = new AppCompatViewInflater();
            } else {
                try {
                    this.f957L = (AppCompatViewInflater) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    appCompatViewInflater = new AppCompatViewInflater();
                    this.f957L = appCompatViewInflater;
                }
            }
            this.f957L = appCompatViewInflater;
        }
        if (f945t) {
            if (!(attributeSet instanceof XmlPullParser)) {
                zM1290a = m1290a((ViewParent) view);
            } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                zM1290a = true;
            }
            z = zM1290a;
        } else {
            z = false;
        }
        return this.f957L.m1177a(view, str, context, attributeSet, z, f945t, true, C0269bb.m2024a());
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: b */
    public void mo1248b(int i) {
        m1298w();
        ViewGroup viewGroup = (ViewGroup) this.f969y.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f914a).inflate(i, viewGroup);
        this.f916c.onContentChanged();
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: b */
    public void mo1249b(Bundle bundle) {
        m1298w();
    }

    /* JADX INFO: renamed from: b */
    void m1311b(C0196h c0196h) {
        if (this.f949D) {
            return;
        }
        this.f949D = true;
        this.f965u.mo1664k();
        Window.Callback callbackQ = m1272q();
        if (callbackQ != null && !m1271p()) {
            callbackQ.onPanelClosed(C0148a.j.AppCompatTheme_tooltipFrameBackground, c0196h);
        }
        this.f949D = false;
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: b */
    public void mo1250b(View view, ViewGroup.LayoutParams layoutParams) {
        m1298w();
        ((ViewGroup) this.f969y.findViewById(R.id.content)).addView(view, layoutParams);
        this.f916c.onContentChanged();
    }

    @Override // android.support.v7.app.AbstractC0163f
    /* JADX INFO: renamed from: b */
    void mo1265b(CharSequence charSequence) {
        if (this.f965u != null) {
            this.f965u.setWindowTitle(charSequence);
        } else if (m1268m() != null) {
            m1268m().mo1195a(charSequence);
        } else if (this.f970z != null) {
            this.f970z.setText(charSequence);
        }
    }

    /* JADX INFO: renamed from: b */
    boolean m1312b(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z = this.f952G;
            this.f952G = false;
            d dVarM1302a = m1302a(0, false);
            if (dVarM1302a != null && dVarM1302a.f997o) {
                if (!z) {
                    m1305a(dVarM1302a, true);
                }
                return true;
            }
            if (m1319u()) {
                return true;
            }
        } else if (i == 82) {
            m1296e(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // android.support.v7.app.AbstractC0163f
    /* JADX INFO: renamed from: b */
    boolean mo1266b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        AbstractC0158a abstractC0158aA = mo1240a();
        if (abstractC0158aA != null) {
            abstractC0158aA.mo1205e(true);
        }
        return true;
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: c */
    public boolean mo1253c(int i) {
        int iM1297h = m1297h(i);
        if (this.f925l && iM1297h == 108) {
            return false;
        }
        if (this.f921h && iM1297h == 1) {
            this.f921h = false;
        }
        switch (iM1297h) {
            case 1:
                m1301z();
                this.f925l = true;
                return true;
            case 2:
                m1301z();
                this.f947B = true;
                return true;
            case 5:
                m1301z();
                this.f948C = true;
                return true;
            case 10:
                m1301z();
                this.f923j = true;
                return true;
            case C0148a.j.AppCompatTheme_tooltipFrameBackground /* 108 */:
                m1301z();
                this.f921h = true;
                return true;
            case 109:
                m1301z();
                this.f922i = true;
                return true;
            default:
                return this.f915b.requestFeature(iM1297h);
        }
    }

    /* JADX INFO: renamed from: c */
    boolean m1313c(int i, KeyEvent keyEvent) {
        if (i == 4) {
            this.f952G = (keyEvent.getFlags() & 128) != 0;
        } else if (i == 82) {
            m1295d(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // android.support.v7.app.AbstractC0163f, android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: d */
    public void mo1254d() {
        AbstractC0158a abstractC0158aA = mo1240a();
        if (abstractC0158aA != null) {
            abstractC0158aA.mo1203d(false);
        }
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: e */
    public void mo1255e() {
        AbstractC0158a abstractC0158aA = mo1240a();
        if (abstractC0158aA != null) {
            abstractC0158aA.mo1203d(true);
        }
    }

    /* JADX INFO: renamed from: e */
    void m1314e(int i) {
        m1305a(m1302a(i, true), true);
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: f */
    public void mo1256f() {
        AbstractC0158a abstractC0158aA = mo1240a();
        if (abstractC0158aA == null || !abstractC0158aA.mo1206e()) {
            m1294d(0);
        }
    }

    /* JADX INFO: renamed from: f */
    void m1315f(int i) {
        d dVarM1302a;
        d dVarM1302a2 = m1302a(i, true);
        if (dVarM1302a2.f992j != null) {
            Bundle bundle = new Bundle();
            dVarM1302a2.f992j.m1537a(bundle);
            if (bundle.size() > 0) {
                dVarM1302a2.f1001s = bundle;
            }
            dVarM1302a2.f992j.m1564g();
            dVarM1302a2.f992j.clear();
        }
        dVarM1302a2.f1000r = true;
        dVarM1302a2.f999q = true;
        if ((i != 108 && i != 0) || this.f965u == null || (dVarM1302a = m1302a(0, false)) == null) {
            return;
        }
        dVarM1302a.f995m = false;
        m1292b(dVarM1302a, (KeyEvent) null);
    }

    /* JADX INFO: renamed from: g */
    int m1316g(int i) {
        boolean z;
        boolean z2;
        if (this.f959n == null || !(this.f959n.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f959n.getLayoutParams();
            if (this.f959n.isShown()) {
                if (this.f955J == null) {
                    this.f955J = new Rect();
                    this.f956K = new Rect();
                }
                Rect rect = this.f955J;
                Rect rect2 = this.f956K;
                rect.set(0, i, 0, 0);
                C0270bc.m2026a(this.f969y, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f946A == null) {
                        this.f946A = new View(this.f914a);
                        this.f946A.setBackgroundColor(this.f914a.getResources().getColor(C0148a.c.abc_input_method_navigation_guard));
                        this.f969y.addView(this.f946A, -1, new ViewGroup.LayoutParams(-1, i));
                    } else {
                        ViewGroup.LayoutParams layoutParams = this.f946A.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f946A.setLayoutParams(layoutParams);
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = this.f946A != null;
                if (!this.f923j && z) {
                    i = 0;
                }
            } else {
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z2 = true;
                } else {
                    z2 = false;
                }
                z = false;
            }
            if (z2) {
                this.f959n.setLayoutParams(marginLayoutParams);
            }
        }
        if (this.f946A != null) {
            this.f946A.setVisibility(z ? 0 : 8);
        }
        return i;
    }

    @Override // android.support.v7.app.AbstractC0163f, android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: g */
    public void mo1257g() {
        if (this.f963r) {
            this.f915b.getDecorView().removeCallbacks(this.f953H);
        }
        super.mo1257g();
        if (this.f919f != null) {
            this.f919f.mo1208g();
        }
    }

    @Override // android.support.v7.app.AbstractC0162e
    /* JADX INFO: renamed from: h */
    public void mo1258h() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f914a);
        if (layoutInflaterFrom.getFactory() == null) {
            C0113e.m904b(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof LayoutInflaterFactory2C0167j) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // android.support.v7.app.AbstractC0163f
    /* JADX INFO: renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo1267l() {
        C0173p c0173p;
        m1298w();
        if (!this.f921h || this.f919f != null) {
            return;
        }
        if (!(this.f916c instanceof Activity)) {
            if (this.f916c instanceof Dialog) {
                c0173p = new C0173p((Dialog) this.f916c);
            }
            if (this.f919f == null) {
                this.f919f.mo1201c(this.f954I);
                return;
            }
            return;
        }
        c0173p = new C0173p((Activity) this.f916c, this.f922i);
        this.f919f = c0173p;
        if (this.f919f == null) {
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewMo1279a = mo1279a(view, str, context, attributeSet);
        return viewMo1279a != null ? viewMo1279a : m1310b(view, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX INFO: renamed from: s */
    final boolean m1317s() {
        return this.f968x && this.f969y != null && C0124p.m970l(this.f969y);
    }

    /* JADX INFO: renamed from: t */
    void m1318t() {
        if (this.f962q != null) {
            this.f962q.m1024b();
        }
    }

    /* JADX INFO: renamed from: u */
    boolean m1319u() {
        if (this.f958m != null) {
            this.f958m.mo1381c();
            return true;
        }
        AbstractC0158a abstractC0158aA = mo1240a();
        return abstractC0158aA != null && abstractC0158aA.mo1207f();
    }

    /* JADX INFO: renamed from: v */
    void m1320v() {
        if (this.f965u != null) {
            this.f965u.mo1664k();
        }
        if (this.f960o != null) {
            this.f915b.getDecorView().removeCallbacks(this.f961p);
            if (this.f960o.isShowing()) {
                try {
                    this.f960o.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f960o = null;
        }
        m1318t();
        d dVarM1302a = m1302a(0, false);
        if (dVarM1302a == null || dVarM1302a.f992j == null) {
            return;
        }
        dVarM1302a.f992j.close();
    }
}
