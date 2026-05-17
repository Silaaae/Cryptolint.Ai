package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.p008b.p009a.C0070a;
import android.support.v4.p010c.p011a.InterfaceMenuItemC0084b;
import android.support.v4.p015g.AbstractC0111c;
import android.support.v7.p019b.p020a.C0175b;
import android.support.v7.view.menu.InterfaceC0204p;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: android.support.v7.view.menu.j */
/* JADX INFO: loaded from: classes.dex */
public final class C0198j implements InterfaceMenuItemC0084b {

    /* JADX INFO: renamed from: F */
    private static String f1305F;

    /* JADX INFO: renamed from: G */
    private static String f1306G;

    /* JADX INFO: renamed from: H */
    private static String f1307H;

    /* JADX INFO: renamed from: I */
    private static String f1308I;

    /* JADX INFO: renamed from: A */
    private View f1309A;

    /* JADX INFO: renamed from: B */
    private AbstractC0111c f1310B;

    /* JADX INFO: renamed from: C */
    private MenuItem.OnActionExpandListener f1311C;

    /* JADX INFO: renamed from: E */
    private ContextMenu.ContextMenuInfo f1313E;

    /* JADX INFO: renamed from: a */
    C0196h f1314a;

    /* JADX INFO: renamed from: b */
    private final int f1315b;

    /* JADX INFO: renamed from: c */
    private final int f1316c;

    /* JADX INFO: renamed from: d */
    private final int f1317d;

    /* JADX INFO: renamed from: e */
    private final int f1318e;

    /* JADX INFO: renamed from: f */
    private CharSequence f1319f;

    /* JADX INFO: renamed from: g */
    private CharSequence f1320g;

    /* JADX INFO: renamed from: h */
    private Intent f1321h;

    /* JADX INFO: renamed from: i */
    private char f1322i;

    /* JADX INFO: renamed from: k */
    private char f1324k;

    /* JADX INFO: renamed from: m */
    private Drawable f1326m;

    /* JADX INFO: renamed from: o */
    private SubMenuC0209u f1328o;

    /* JADX INFO: renamed from: p */
    private Runnable f1329p;

    /* JADX INFO: renamed from: q */
    private MenuItem.OnMenuItemClickListener f1330q;

    /* JADX INFO: renamed from: r */
    private CharSequence f1331r;

    /* JADX INFO: renamed from: s */
    private CharSequence f1332s;

    /* JADX INFO: renamed from: z */
    private int f1339z;

    /* JADX INFO: renamed from: j */
    private int f1323j = 4096;

    /* JADX INFO: renamed from: l */
    private int f1325l = 4096;

    /* JADX INFO: renamed from: n */
    private int f1327n = 0;

    /* JADX INFO: renamed from: t */
    private ColorStateList f1333t = null;

    /* JADX INFO: renamed from: u */
    private PorterDuff.Mode f1334u = null;

    /* JADX INFO: renamed from: v */
    private boolean f1335v = false;

    /* JADX INFO: renamed from: w */
    private boolean f1336w = false;

    /* JADX INFO: renamed from: x */
    private boolean f1337x = false;

    /* JADX INFO: renamed from: y */
    private int f1338y = 16;

    /* JADX INFO: renamed from: D */
    private boolean f1312D = false;

    C0198j(C0196h c0196h, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1339z = 0;
        this.f1314a = c0196h;
        this.f1315b = i2;
        this.f1316c = i;
        this.f1317d = i3;
        this.f1318e = i4;
        this.f1319f = charSequence;
        this.f1339z = i5;
    }

    /* JADX INFO: renamed from: a */
    private Drawable m1578a(Drawable drawable) {
        if (drawable != null && this.f1337x && (this.f1335v || this.f1336w)) {
            drawable = C0070a.m658f(drawable).mutate();
            if (this.f1335v) {
                C0070a.m648a(drawable, this.f1333t);
            }
            if (this.f1336w) {
                C0070a.m651a(drawable, this.f1334u);
            }
            this.f1337x = false;
        }
        return drawable;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0084b setActionView(int i) {
        Context contextM1561e = this.f1314a.m1561e();
        setActionView(LayoutInflater.from(contextM1561e).inflate(i, (ViewGroup) new LinearLayout(contextM1561e), false));
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b
    /* JADX INFO: renamed from: a */
    public InterfaceMenuItemC0084b mo716a(AbstractC0111c abstractC0111c) {
        if (this.f1310B != null) {
            this.f1310B.m899f();
        }
        this.f1309A = null;
        this.f1310B = abstractC0111c;
        this.f1314a.m1552b(true);
        if (this.f1310B != null) {
            this.f1310B.mo892a(new AbstractC0111c.b() { // from class: android.support.v7.view.menu.j.1
                @Override // android.support.v4.p015g.AbstractC0111c.b
                /* JADX INFO: renamed from: a */
                public void mo901a(boolean z) {
                    C0198j.this.f1314a.m1539a(C0198j.this);
                }
            });
        }
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0084b setActionView(View view) {
        this.f1309A = view;
        this.f1310B = null;
        if (view != null && view.getId() == -1 && this.f1315b > 0) {
            view.setId(this.f1315b);
        }
        this.f1314a.m1550b(this);
        return this;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0084b setContentDescription(CharSequence charSequence) {
        this.f1331r = charSequence;
        this.f1314a.m1552b(false);
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b
    /* JADX INFO: renamed from: a */
    public AbstractC0111c mo718a() {
        return this.f1310B;
    }

    /* JADX INFO: renamed from: a */
    CharSequence m1581a(InterfaceC0204p.a aVar) {
        return (aVar == null || !aVar.mo1448a()) ? getTitle() : getTitleCondensed();
    }

    /* JADX INFO: renamed from: a */
    public void m1582a(SubMenuC0209u subMenuC0209u) {
        this.f1328o = subMenuC0209u;
        subMenuC0209u.setHeaderTitle(getTitle());
    }

    /* JADX INFO: renamed from: a */
    void m1583a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f1313E = contextMenuInfo;
    }

    /* JADX INFO: renamed from: a */
    public void m1584a(boolean z) {
        this.f1338y = (z ? 4 : 0) | (this.f1338y & (-5));
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0084b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0084b setTooltipText(CharSequence charSequence) {
        this.f1332s = charSequence;
        this.f1314a.m1552b(false);
        return this;
    }

    /* JADX INFO: renamed from: b */
    void m1586b(boolean z) {
        int i = this.f1338y;
        this.f1338y = (z ? 2 : 0) | (this.f1338y & (-3));
        if (i != this.f1338y) {
            this.f1314a.m1552b(false);
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m1587b() {
        if ((this.f1330q != null && this.f1330q.onMenuItemClick(this)) || this.f1314a.mo1545a(this.f1314a, this)) {
            return true;
        }
        if (this.f1329p != null) {
            this.f1329p.run();
            return true;
        }
        if (this.f1321h != null) {
            try {
                this.f1314a.m1561e().startActivity(this.f1321h);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.f1310B != null && this.f1310B.mo897d();
    }

    /* JADX INFO: renamed from: c */
    public int m1588c() {
        return this.f1318e;
    }

    /* JADX INFO: renamed from: c */
    boolean m1589c(boolean z) {
        int i = this.f1338y;
        this.f1338y = (z ? 0 : 8) | (this.f1338y & (-9));
        return i != this.f1338y;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f1339z & 8) == 0) {
            return false;
        }
        if (this.f1309A == null) {
            return true;
        }
        if (this.f1311C == null || this.f1311C.onMenuItemActionCollapse(this)) {
            return this.f1314a.mo1560d(this);
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    char m1590d() {
        return this.f1314a.mo1553b() ? this.f1324k : this.f1322i;
    }

    /* JADX INFO: renamed from: d */
    public void m1591d(boolean z) {
        this.f1338y = z ? this.f1338y | 32 : this.f1338y & (-33);
    }

    /* JADX INFO: renamed from: e */
    String m1592e() {
        String str;
        char cM1590d = m1590d();
        if (cM1590d == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(f1305F);
        if (cM1590d == '\b') {
            str = f1307H;
        } else if (cM1590d == '\n') {
            str = f1306G;
        } else {
            if (cM1590d != ' ') {
                sb.append(cM1590d);
                return sb.toString();
            }
            str = f1308I;
        }
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: e */
    public void m1593e(boolean z) {
        this.f1312D = z;
        this.f1314a.m1552b(false);
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public boolean expandActionView() {
        if (!m1602n()) {
            return false;
        }
        if (this.f1311C == null || this.f1311C.onMenuItemActionExpand(this)) {
            return this.f1314a.mo1557c(this);
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    boolean m1594f() {
        return this.f1314a.mo1556c() && m1590d() != 0;
    }

    /* JADX INFO: renamed from: g */
    public boolean m1595g() {
        return (this.f1338y & 4) != 0;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public View getActionView() {
        if (this.f1309A != null) {
            return this.f1309A;
        }
        if (this.f1310B == null) {
            return null;
        }
        this.f1309A = this.f1310B.mo890a(this);
        return this.f1309A;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1325l;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1324k;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1331r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1316c;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawableM1396b;
        if (this.f1326m != null) {
            drawableM1396b = this.f1326m;
        } else {
            if (this.f1327n == 0) {
                return null;
            }
            drawableM1396b = C0175b.m1396b(this.f1314a.m1561e(), this.f1327n);
            this.f1327n = 0;
            this.f1326m = drawableM1396b;
        }
        return m1578a(drawableM1396b);
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1333t;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1334u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1321h;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.f1315b;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f1313E;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1323j;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1322i;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1317d;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f1328o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1319f;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1320g != null ? this.f1320g : this.f1319f;
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1332s;
    }

    /* JADX INFO: renamed from: h */
    public void m1596h() {
        this.f1314a.m1550b(this);
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.f1328o != null;
    }

    /* JADX INFO: renamed from: i */
    public boolean m1597i() {
        return this.f1314a.m1574q();
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.f1312D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1338y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1338y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1338y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f1310B == null || !this.f1310B.mo895b()) ? (this.f1338y & 8) == 0 : (this.f1338y & 8) == 0 && this.f1310B.mo896c();
    }

    /* JADX INFO: renamed from: j */
    public boolean m1598j() {
        return (this.f1338y & 32) == 32;
    }

    /* JADX INFO: renamed from: k */
    public boolean m1599k() {
        return (this.f1339z & 1) == 1;
    }

    /* JADX INFO: renamed from: l */
    public boolean m1600l() {
        return (this.f1339z & 2) == 2;
    }

    /* JADX INFO: renamed from: m */
    public boolean m1601m() {
        return (this.f1339z & 4) == 4;
    }

    /* JADX INFO: renamed from: n */
    public boolean m1602n() {
        if ((this.f1339z & 8) == 0) {
            return false;
        }
        if (this.f1309A == null && this.f1310B != null) {
            this.f1309A = this.f1310B.mo890a(this);
        }
        return this.f1309A != null;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1324k == c) {
            return this;
        }
        this.f1324k = Character.toLowerCase(c);
        this.f1314a.m1552b(false);
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.f1324k == c && this.f1325l == i) {
            return this;
        }
        this.f1324k = Character.toLowerCase(c);
        this.f1325l = KeyEvent.normalizeMetaState(i);
        this.f1314a.m1552b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.f1338y;
        this.f1338y = (z ? 1 : 0) | (this.f1338y & (-2));
        if (i != this.f1338y) {
            this.f1314a.m1552b(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.f1338y & 4) != 0) {
            this.f1314a.m1542a((MenuItem) this);
        } else {
            m1586b(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f1338y = z ? this.f1338y | 16 : this.f1338y & (-17);
        this.f1314a.m1552b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f1326m = null;
        this.f1327n = i;
        this.f1337x = true;
        this.f1314a.m1552b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1327n = 0;
        this.f1326m = drawable;
        this.f1337x = true;
        this.f1314a.m1552b(false);
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1333t = colorStateList;
        this.f1335v = true;
        this.f1337x = true;
        this.f1314a.m1552b(false);
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1334u = mode;
        this.f1336w = true;
        this.f1337x = true;
        this.f1314a.m1552b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1321h = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.f1322i == c) {
            return this;
        }
        this.f1322i = c;
        this.f1314a.m1552b(false);
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        if (this.f1322i == c && this.f1323j == i) {
            return this;
        }
        this.f1322i = c;
        this.f1323j = KeyEvent.normalizeMetaState(i);
        this.f1314a.m1552b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f1311C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1330q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f1322i = c;
        this.f1324k = Character.toLowerCase(c2);
        this.f1314a.m1552b(false);
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f1322i = c;
        this.f1323j = KeyEvent.normalizeMetaState(i);
        this.f1324k = Character.toLowerCase(c2);
        this.f1325l = KeyEvent.normalizeMetaState(i2);
        this.f1314a.m1552b(false);
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f1339z = i;
                this.f1314a.m1550b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        return setTitle(this.f1314a.m1561e().getString(i));
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1319f = charSequence;
        this.f1314a.m1552b(false);
        if (this.f1328o != null) {
            this.f1328o.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1320g = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1319f;
        }
        this.f1314a.m1552b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (m1589c(z)) {
            this.f1314a.m1539a(this);
        }
        return this;
    }

    public String toString() {
        if (this.f1319f != null) {
            return this.f1319f.toString();
        }
        return null;
    }
}
