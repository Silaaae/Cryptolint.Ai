package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.p006a.C0033a;
import android.support.v4.p008b.p009a.C0070a;
import android.support.v4.p010c.p011a.InterfaceMenuItemC0084b;
import android.support.v4.p015g.AbstractC0111c;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: renamed from: android.support.v7.view.menu.a */
/* JADX INFO: loaded from: classes.dex */
public class C0189a implements InterfaceMenuItemC0084b {

    /* JADX INFO: renamed from: a */
    private final int f1186a;

    /* JADX INFO: renamed from: b */
    private final int f1187b;

    /* JADX INFO: renamed from: c */
    private final int f1188c;

    /* JADX INFO: renamed from: d */
    private final int f1189d;

    /* JADX INFO: renamed from: e */
    private CharSequence f1190e;

    /* JADX INFO: renamed from: f */
    private CharSequence f1191f;

    /* JADX INFO: renamed from: g */
    private Intent f1192g;

    /* JADX INFO: renamed from: h */
    private char f1193h;

    /* JADX INFO: renamed from: j */
    private char f1195j;

    /* JADX INFO: renamed from: l */
    private Drawable f1197l;

    /* JADX INFO: renamed from: n */
    private Context f1199n;

    /* JADX INFO: renamed from: o */
    private MenuItem.OnMenuItemClickListener f1200o;

    /* JADX INFO: renamed from: p */
    private CharSequence f1201p;

    /* JADX INFO: renamed from: q */
    private CharSequence f1202q;

    /* JADX INFO: renamed from: i */
    private int f1194i = 4096;

    /* JADX INFO: renamed from: k */
    private int f1196k = 4096;

    /* JADX INFO: renamed from: m */
    private int f1198m = 0;

    /* JADX INFO: renamed from: r */
    private ColorStateList f1203r = null;

    /* JADX INFO: renamed from: s */
    private PorterDuff.Mode f1204s = null;

    /* JADX INFO: renamed from: t */
    private boolean f1205t = false;

    /* JADX INFO: renamed from: u */
    private boolean f1206u = false;

    /* JADX INFO: renamed from: v */
    private int f1207v = 16;

    public C0189a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1199n = context;
        this.f1186a = i2;
        this.f1187b = i;
        this.f1188c = i3;
        this.f1189d = i4;
        this.f1190e = charSequence;
    }

    /* JADX INFO: renamed from: b */
    private void m1461b() {
        if (this.f1197l != null) {
            if (this.f1205t || this.f1206u) {
                this.f1197l = C0070a.m658f(this.f1197l);
                this.f1197l = this.f1197l.mutate();
                if (this.f1205t) {
                    C0070a.m648a(this.f1197l, this.f1203r);
                }
                if (this.f1206u) {
                    C0070a.m651a(this.f1197l, this.f1204s);
                }
            }
        }
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0084b setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b
    /* JADX INFO: renamed from: a */
    public InterfaceMenuItemC0084b mo716a(AbstractC0111c abstractC0111c) {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0084b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: a */
    public InterfaceMenuItemC0084b setContentDescription(CharSequence charSequence) {
        this.f1201p = charSequence;
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b
    /* JADX INFO: renamed from: a */
    public AbstractC0111c mo718a() {
        return null;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterfaceMenuItemC0084b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    /* JADX INFO: renamed from: b */
    public InterfaceMenuItemC0084b setTooltipText(CharSequence charSequence) {
        this.f1202q = charSequence;
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f1196k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f1195j;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f1201p;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f1187b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f1197l;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f1203r;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f1204s;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f1192g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f1186a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f1194i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f1193h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f1189d;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f1190e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        return this.f1191f != null ? this.f1191f : this.f1190e;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f1202q;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.f1207v & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.f1207v & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.f1207v & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.f1207v & 8) == 0;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.f1195j = Character.toLowerCase(c);
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.f1195j = Character.toLowerCase(c);
        this.f1196k = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.f1207v = (z ? 1 : 0) | (this.f1207v & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.f1207v = (z ? 2 : 0) | (this.f1207v & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.f1207v = (z ? 16 : 0) | (this.f1207v & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.f1198m = i;
        this.f1197l = C0033a.m167a(this.f1199n, i);
        m1461b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f1197l = drawable;
        this.f1198m = 0;
        m1461b();
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f1203r = colorStateList;
        this.f1205t = true;
        m1461b();
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f1204s = mode;
        this.f1206u = true;
        m1461b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f1192g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.f1193h = c;
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.f1193h = c;
        this.f1194i = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f1200o = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.f1193h = c;
        this.f1195j = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f1193h = c;
        this.f1194i = KeyEvent.normalizeMetaState(i);
        this.f1195j = Character.toLowerCase(c2);
        this.f1196k = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.support.v4.p010c.p011a.InterfaceMenuItemC0084b, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.f1190e = this.f1199n.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f1190e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1191f = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.f1207v = (this.f1207v & 8) | (z ? 0 : 8);
        return this;
    }
}
