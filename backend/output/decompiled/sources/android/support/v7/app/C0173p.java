package android.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.p015g.C0124p;
import android.support.v4.p015g.C0127s;
import android.support.v4.p015g.C0129u;
import android.support.v4.p015g.InterfaceC0128t;
import android.support.v4.p015g.InterfaceC0130v;
import android.support.v7.app.AbstractC0158a;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.AbstractC0179b;
import android.support.v7.view.C0178a;
import android.support.v7.view.C0184g;
import android.support.v7.view.C0185h;
import android.support.v7.view.menu.C0196h;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.C0256ap;
import android.support.v7.widget.InterfaceC0245ae;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: renamed from: android.support.v7.app.p */
/* JADX INFO: loaded from: classes.dex */
public class C0173p extends AbstractC0158a implements ActionBarOverlayLayout.InterfaceC0215a {

    /* JADX INFO: renamed from: s */
    static final /* synthetic */ boolean f1035s = !C0173p.class.desiredAssertionStatus();

    /* JADX INFO: renamed from: t */
    private static final Interpolator f1036t = new AccelerateInterpolator();

    /* JADX INFO: renamed from: u */
    private static final Interpolator f1037u = new DecelerateInterpolator();

    /* JADX INFO: renamed from: A */
    private boolean f1038A;

    /* JADX INFO: renamed from: B */
    private boolean f1039B;

    /* JADX INFO: renamed from: D */
    private boolean f1041D;

    /* JADX INFO: renamed from: F */
    private boolean f1043F;

    /* JADX INFO: renamed from: H */
    private boolean f1045H;

    /* JADX INFO: renamed from: a */
    Context f1046a;

    /* JADX INFO: renamed from: b */
    ActionBarOverlayLayout f1047b;

    /* JADX INFO: renamed from: c */
    ActionBarContainer f1048c;

    /* JADX INFO: renamed from: d */
    InterfaceC0245ae f1049d;

    /* JADX INFO: renamed from: e */
    ActionBarContextView f1050e;

    /* JADX INFO: renamed from: f */
    View f1051f;

    /* JADX INFO: renamed from: g */
    C0256ap f1052g;

    /* JADX INFO: renamed from: h */
    a f1053h;

    /* JADX INFO: renamed from: i */
    AbstractC0179b f1054i;

    /* JADX INFO: renamed from: j */
    AbstractC0179b.a f1055j;

    /* JADX INFO: renamed from: l */
    boolean f1057l;

    /* JADX INFO: renamed from: m */
    boolean f1058m;

    /* JADX INFO: renamed from: n */
    C0185h f1059n;

    /* JADX INFO: renamed from: o */
    boolean f1060o;

    /* JADX INFO: renamed from: v */
    private Context f1064v;

    /* JADX INFO: renamed from: w */
    private Activity f1065w;

    /* JADX INFO: renamed from: x */
    private Dialog f1066x;

    /* JADX INFO: renamed from: y */
    private ArrayList<Object> f1067y = new ArrayList<>();

    /* JADX INFO: renamed from: z */
    private int f1068z = -1;

    /* JADX INFO: renamed from: C */
    private ArrayList<AbstractC0158a.b> f1040C = new ArrayList<>();

    /* JADX INFO: renamed from: E */
    private int f1042E = 0;

    /* JADX INFO: renamed from: k */
    boolean f1056k = true;

    /* JADX INFO: renamed from: G */
    private boolean f1044G = true;

    /* JADX INFO: renamed from: p */
    final InterfaceC0128t f1061p = new C0129u() { // from class: android.support.v7.app.p.1
        @Override // android.support.v4.p015g.C0129u, android.support.v4.p015g.InterfaceC0128t
        /* JADX INFO: renamed from: b */
        public void mo1027b(View view) {
            if (C0173p.this.f1056k && C0173p.this.f1051f != null) {
                C0173p.this.f1051f.setTranslationY(0.0f);
                C0173p.this.f1048c.setTranslationY(0.0f);
            }
            C0173p.this.f1048c.setVisibility(8);
            C0173p.this.f1048c.setTransitioning(false);
            C0173p.this.f1059n = null;
            C0173p.this.m1364h();
            if (C0173p.this.f1047b != null) {
                C0124p.m965g(C0173p.this.f1047b);
            }
        }
    };

    /* JADX INFO: renamed from: q */
    final InterfaceC0128t f1062q = new C0129u() { // from class: android.support.v7.app.p.2
        @Override // android.support.v4.p015g.C0129u, android.support.v4.p015g.InterfaceC0128t
        /* JADX INFO: renamed from: b */
        public void mo1027b(View view) {
            C0173p.this.f1059n = null;
            C0173p.this.f1048c.requestLayout();
        }
    };

    /* JADX INFO: renamed from: r */
    final InterfaceC0130v f1063r = new InterfaceC0130v() { // from class: android.support.v7.app.p.3
        @Override // android.support.v4.p015g.InterfaceC0130v
        /* JADX INFO: renamed from: a */
        public void mo1029a(View view) {
            ((View) C0173p.this.f1048c.getParent()).invalidate();
        }
    };

    /* JADX INFO: renamed from: android.support.v7.app.p$a */
    public class a extends AbstractC0179b implements C0196h.a {

        /* JADX INFO: renamed from: b */
        private final Context f1073b;

        /* JADX INFO: renamed from: c */
        private final C0196h f1074c;

        /* JADX INFO: renamed from: d */
        private AbstractC0179b.a f1075d;

        /* JADX INFO: renamed from: e */
        private WeakReference<View> f1076e;

        public a(Context context, AbstractC0179b.a aVar) {
            this.f1073b = context;
            this.f1075d = aVar;
            this.f1074c = new C0196h(context).m1530a(1);
            this.f1074c.mo1538a(this);
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: a */
        public MenuInflater mo1373a() {
            return new C0184g(this.f1073b);
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: a */
        public void mo1374a(int i) {
            mo1380b(C0173p.this.f1046a.getResources().getString(i));
        }

        @Override // android.support.v7.view.menu.C0196h.a
        /* JADX INFO: renamed from: a */
        public void mo1306a(C0196h c0196h) {
            if (this.f1075d == null) {
                return;
            }
            mo1382d();
            C0173p.this.f1050e.mo1639a();
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: a */
        public void mo1375a(View view) {
            C0173p.this.f1050e.setCustomView(view);
            this.f1076e = new WeakReference<>(view);
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: a */
        public void mo1376a(CharSequence charSequence) {
            C0173p.this.f1050e.setSubtitle(charSequence);
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: a */
        public void mo1377a(boolean z) {
            super.mo1377a(z);
            C0173p.this.f1050e.setTitleOptional(z);
        }

        @Override // android.support.v7.view.menu.C0196h.a
        /* JADX INFO: renamed from: a */
        public boolean mo1308a(C0196h c0196h, MenuItem menuItem) {
            if (this.f1075d != null) {
                return this.f1075d.mo1328a(this, menuItem);
            }
            return false;
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: b */
        public Menu mo1378b() {
            return this.f1074c;
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: b */
        public void mo1379b(int i) {
            mo1376a((CharSequence) C0173p.this.f1046a.getResources().getString(i));
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: b */
        public void mo1380b(CharSequence charSequence) {
            C0173p.this.f1050e.setTitle(charSequence);
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: c */
        public void mo1381c() {
            if (C0173p.this.f1053h != this) {
                return;
            }
            if (C0173p.m1353a(C0173p.this.f1057l, C0173p.this.f1058m, false)) {
                this.f1075d.mo1326a(this);
            } else {
                C0173p.this.f1054i = this;
                C0173p.this.f1055j = this.f1075d;
            }
            this.f1075d = null;
            C0173p.this.m1369j(false);
            C0173p.this.f1050e.m1640b();
            C0173p.this.f1049d.mo1824a().sendAccessibilityEvent(32);
            C0173p.this.f1047b.setHideOnContentScrollEnabled(C0173p.this.f1060o);
            C0173p.this.f1053h = null;
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: d */
        public void mo1382d() {
            if (C0173p.this.f1053h != this) {
                return;
            }
            this.f1074c.m1564g();
            try {
                this.f1075d.mo1329b(this, this.f1074c);
            } finally {
                this.f1074c.m1565h();
            }
        }

        /* JADX INFO: renamed from: e */
        public boolean m1383e() {
            this.f1074c.m1564g();
            try {
                return this.f1075d.mo1327a(this, this.f1074c);
            } finally {
                this.f1074c.m1565h();
            }
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: f */
        public CharSequence mo1384f() {
            return C0173p.this.f1050e.getTitle();
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: g */
        public CharSequence mo1385g() {
            return C0173p.this.f1050e.getSubtitle();
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: h */
        public boolean mo1386h() {
            return C0173p.this.f1050e.m1642d();
        }

        @Override // android.support.v7.view.AbstractC0179b
        /* JADX INFO: renamed from: i */
        public View mo1387i() {
            if (this.f1076e != null) {
                return this.f1076e.get();
            }
            return null;
        }
    }

    public C0173p(Activity activity, boolean z) {
        this.f1065w = activity;
        View decorView = activity.getWindow().getDecorView();
        m1352a(decorView);
        if (z) {
            return;
        }
        this.f1051f = decorView.findViewById(R.id.content);
    }

    public C0173p(Dialog dialog) {
        this.f1066x = dialog;
        m1352a(dialog.getWindow().getDecorView());
    }

    /* JADX INFO: renamed from: a */
    private void m1352a(View view) {
        this.f1047b = (ActionBarOverlayLayout) view.findViewById(C0148a.f.decor_content_parent);
        if (this.f1047b != null) {
            this.f1047b.setActionBarVisibilityCallback(this);
        }
        this.f1049d = m1354b(view.findViewById(C0148a.f.action_bar));
        this.f1050e = (ActionBarContextView) view.findViewById(C0148a.f.action_context_bar);
        this.f1048c = (ActionBarContainer) view.findViewById(C0148a.f.action_bar_container);
        if (this.f1049d == null || this.f1050e == null || this.f1048c == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f1046a = this.f1049d.mo1833b();
        boolean z = (this.f1049d.mo1850o() & 4) != 0;
        if (z) {
            this.f1038A = true;
        }
        C0178a c0178aM1405a = C0178a.m1405a(this.f1046a);
        mo1196a(c0178aM1405a.m1411f() || z);
        m1355k(c0178aM1405a.m1409d());
        TypedArray typedArrayObtainStyledAttributes = this.f1046a.obtainStyledAttributes(null, C0148a.j.ActionBar, C0148a.a.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(C0148a.j.ActionBar_hideOnContentScroll, false)) {
            mo1200b(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0148a.j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo1193a(dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: a */
    static boolean m1353a(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        return (z || z2) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    private InterfaceC0245ae m1354b(View view) {
        if (view instanceof InterfaceC0245ae) {
            return (InterfaceC0245ae) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Can't make a decor toolbar out of ");
        sb.append(view);
        throw new IllegalStateException(sb.toString() != null ? view.getClass().getSimpleName() : "null");
    }

    /* JADX INFO: renamed from: k */
    private void m1355k(boolean z) {
        this.f1041D = z;
        if (this.f1041D) {
            this.f1048c.setTabContainer(null);
            this.f1049d.mo1828a(this.f1052g);
        } else {
            this.f1049d.mo1828a((C0256ap) null);
            this.f1048c.setTabContainer(this.f1052g);
        }
        boolean z2 = m1366i() == 2;
        if (this.f1052g != null) {
            if (z2) {
                this.f1052g.setVisibility(0);
                if (this.f1047b != null) {
                    C0124p.m965g(this.f1047b);
                }
            } else {
                this.f1052g.setVisibility(8);
            }
        }
        this.f1049d.mo1832a(!this.f1041D && z2);
        this.f1047b.setHasNonEmbeddedTabs(!this.f1041D && z2);
    }

    /* JADX INFO: renamed from: l */
    private void m1356l(boolean z) {
        if (m1353a(this.f1057l, this.f1058m, this.f1043F)) {
            if (this.f1044G) {
                return;
            }
            this.f1044G = true;
            m1365h(z);
            return;
        }
        if (this.f1044G) {
            this.f1044G = false;
            m1367i(z);
        }
    }

    /* JADX INFO: renamed from: n */
    private void m1357n() {
        if (this.f1043F) {
            return;
        }
        this.f1043F = true;
        if (this.f1047b != null) {
            this.f1047b.setShowingForActionMode(true);
        }
        m1356l(false);
    }

    /* JADX INFO: renamed from: o */
    private void m1358o() {
        if (this.f1043F) {
            this.f1043F = false;
            if (this.f1047b != null) {
                this.f1047b.setShowingForActionMode(false);
            }
            m1356l(false);
        }
    }

    /* JADX INFO: renamed from: p */
    private boolean m1359p() {
        return C0124p.m970l(this.f1048c);
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public int mo1191a() {
        return this.f1049d.mo1850o();
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public AbstractC0179b mo1192a(AbstractC0179b.a aVar) {
        if (this.f1053h != null) {
            this.f1053h.mo1381c();
        }
        this.f1047b.setHideOnContentScrollEnabled(false);
        this.f1050e.m1641c();
        a aVar2 = new a(this.f1050e.getContext(), aVar);
        if (!aVar2.m1383e()) {
            return null;
        }
        this.f1053h = aVar2;
        aVar2.mo1382d();
        this.f1050e.m1638a(aVar2);
        m1369j(true);
        this.f1050e.sendAccessibilityEvent(32);
        return aVar2;
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public void mo1193a(float f) {
        C0124p.m950a(this.f1048c, f);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.InterfaceC0215a
    /* JADX INFO: renamed from: a */
    public void mo1360a(int i) {
        this.f1042E = i;
    }

    /* JADX INFO: renamed from: a */
    public void m1361a(int i, int i2) {
        int iMo1850o = this.f1049d.mo1850o();
        if ((i2 & 4) != 0) {
            this.f1038A = true;
        }
        this.f1049d.mo1836c((i & i2) | ((i2 ^ (-1)) & iMo1850o));
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public void mo1194a(Configuration configuration) {
        m1355k(C0178a.m1405a(this.f1046a).m1409d());
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public void mo1195a(CharSequence charSequence) {
        this.f1049d.mo1831a(charSequence);
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public void mo1196a(boolean z) {
        this.f1049d.mo1835b(z);
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: a */
    public boolean mo1197a(int i, KeyEvent keyEvent) {
        Menu menuMo1378b;
        if (this.f1053h == null || (menuMo1378b = this.f1053h.mo1378b()) == null) {
            return false;
        }
        menuMo1378b.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
        return menuMo1378b.performShortcut(i, keyEvent, 0);
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: b */
    public Context mo1199b() {
        if (this.f1064v == null) {
            TypedValue typedValue = new TypedValue();
            this.f1046a.getTheme().resolveAttribute(C0148a.a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1064v = new ContextThemeWrapper(this.f1046a, i);
            } else {
                this.f1064v = this.f1046a;
            }
        }
        return this.f1064v;
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: b */
    public void mo1200b(boolean z) {
        if (z && !this.f1047b.m1654a()) {
            throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
        }
        this.f1060o = z;
        this.f1047b.setHideOnContentScrollEnabled(z);
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: c */
    public void mo1201c(boolean z) {
        if (this.f1038A) {
            return;
        }
        m1362f(z);
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: d */
    public void mo1203d(boolean z) {
        this.f1045H = z;
        if (z || this.f1059n == null) {
            return;
        }
        this.f1059n.m1443c();
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: e */
    public void mo1205e(boolean z) {
        if (z == this.f1039B) {
            return;
        }
        this.f1039B = z;
        int size = this.f1040C.size();
        for (int i = 0; i < size; i++) {
            this.f1040C.get(i).m1209a(z);
        }
    }

    /* JADX INFO: renamed from: f */
    public void m1362f(boolean z) {
        m1361a(z ? 4 : 0, 4);
    }

    @Override // android.support.v7.app.AbstractC0158a
    /* JADX INFO: renamed from: f */
    public boolean mo1207f() {
        if (this.f1049d == null || !this.f1049d.mo1837c()) {
            return false;
        }
        this.f1049d.mo1838d();
        return true;
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.InterfaceC0215a
    /* JADX INFO: renamed from: g */
    public void mo1363g(boolean z) {
        this.f1056k = z;
    }

    /* JADX INFO: renamed from: h */
    void m1364h() {
        if (this.f1055j != null) {
            this.f1055j.mo1326a(this.f1054i);
            this.f1054i = null;
            this.f1055j = null;
        }
    }

    /* JADX INFO: renamed from: h */
    public void m1365h(boolean z) {
        if (this.f1059n != null) {
            this.f1059n.m1443c();
        }
        this.f1048c.setVisibility(0);
        if (this.f1042E == 0 && (this.f1045H || z)) {
            this.f1048c.setTranslationY(0.0f);
            float f = -this.f1048c.getHeight();
            if (z) {
                this.f1048c.getLocationInWindow(new int[]{0, 0});
                f -= r5[1];
            }
            this.f1048c.setTranslationY(f);
            C0185h c0185h = new C0185h();
            C0127s c0127sM1022b = C0124p.m962d(this.f1048c).m1022b(0.0f);
            c0127sM1022b.m1020a(this.f1063r);
            c0185h.m1437a(c0127sM1022b);
            if (this.f1056k && this.f1051f != null) {
                this.f1051f.setTranslationY(f);
                c0185h.m1437a(C0124p.m962d(this.f1051f).m1022b(0.0f));
            }
            c0185h.m1440a(f1037u);
            c0185h.m1436a(250L);
            c0185h.m1439a(this.f1062q);
            this.f1059n = c0185h;
            c0185h.m1441a();
        } else {
            this.f1048c.setAlpha(1.0f);
            this.f1048c.setTranslationY(0.0f);
            if (this.f1056k && this.f1051f != null) {
                this.f1051f.setTranslationY(0.0f);
            }
            this.f1062q.mo1027b(null);
        }
        if (this.f1047b != null) {
            C0124p.m965g(this.f1047b);
        }
    }

    /* JADX INFO: renamed from: i */
    public int m1366i() {
        return this.f1049d.mo1851p();
    }

    /* JADX INFO: renamed from: i */
    public void m1367i(boolean z) {
        if (this.f1059n != null) {
            this.f1059n.m1443c();
        }
        if (this.f1042E != 0 || (!this.f1045H && !z)) {
            this.f1061p.mo1027b(null);
            return;
        }
        this.f1048c.setAlpha(1.0f);
        this.f1048c.setTransitioning(true);
        C0185h c0185h = new C0185h();
        float f = -this.f1048c.getHeight();
        if (z) {
            this.f1048c.getLocationInWindow(new int[]{0, 0});
            f -= r5[1];
        }
        C0127s c0127sM1022b = C0124p.m962d(this.f1048c).m1022b(f);
        c0127sM1022b.m1020a(this.f1063r);
        c0185h.m1437a(c0127sM1022b);
        if (this.f1056k && this.f1051f != null) {
            c0185h.m1437a(C0124p.m962d(this.f1051f).m1022b(f));
        }
        c0185h.m1440a(f1036t);
        c0185h.m1436a(250L);
        c0185h.m1439a(this.f1061p);
        this.f1059n = c0185h;
        c0185h.m1441a();
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.InterfaceC0215a
    /* JADX INFO: renamed from: j */
    public void mo1368j() {
        if (this.f1058m) {
            this.f1058m = false;
            m1356l(true);
        }
    }

    /* JADX INFO: renamed from: j */
    public void m1369j(boolean z) {
        C0127s c0127sMo1823a;
        C0127s c0127sMo1637a;
        if (z) {
            m1357n();
        } else {
            m1358o();
        }
        if (!m1359p()) {
            if (z) {
                this.f1049d.mo1839d(4);
                this.f1050e.setVisibility(0);
                return;
            } else {
                this.f1049d.mo1839d(0);
                this.f1050e.setVisibility(8);
                return;
            }
        }
        if (z) {
            c0127sMo1637a = this.f1049d.mo1823a(4, 100L);
            c0127sMo1823a = this.f1050e.mo1637a(0, 200L);
        } else {
            c0127sMo1823a = this.f1049d.mo1823a(0, 200L);
            c0127sMo1637a = this.f1050e.mo1637a(8, 100L);
        }
        C0185h c0185h = new C0185h();
        c0185h.m1438a(c0127sMo1637a, c0127sMo1823a);
        c0185h.m1441a();
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.InterfaceC0215a
    /* JADX INFO: renamed from: k */
    public void mo1370k() {
        if (this.f1058m) {
            return;
        }
        this.f1058m = true;
        m1356l(true);
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.InterfaceC0215a
    /* JADX INFO: renamed from: l */
    public void mo1371l() {
        if (this.f1059n != null) {
            this.f1059n.m1443c();
            this.f1059n = null;
        }
    }

    @Override // android.support.v7.widget.ActionBarOverlayLayout.InterfaceC0215a
    /* JADX INFO: renamed from: m */
    public void mo1372m() {
    }
}
