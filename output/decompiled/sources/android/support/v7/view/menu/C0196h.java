package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p006a.C0033a;
import android.support.v4.p010c.p011a.InterfaceMenuC0083a;
import android.support.v4.p015g.AbstractC0111c;
import android.support.v7.p018a.C0148a;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: android.support.v7.view.menu.h */
/* JADX INFO: loaded from: classes.dex */
public class C0196h implements InterfaceMenuC0083a {

    /* JADX INFO: renamed from: d */
    private static final int[] f1275d = {1, 4, 5, 3, 2, 0};

    /* JADX INFO: renamed from: a */
    CharSequence f1276a;

    /* JADX INFO: renamed from: b */
    Drawable f1277b;

    /* JADX INFO: renamed from: c */
    View f1278c;

    /* JADX INFO: renamed from: e */
    private final Context f1279e;

    /* JADX INFO: renamed from: f */
    private final Resources f1280f;

    /* JADX INFO: renamed from: g */
    private boolean f1281g;

    /* JADX INFO: renamed from: h */
    private boolean f1282h;

    /* JADX INFO: renamed from: i */
    private a f1283i;

    /* JADX INFO: renamed from: q */
    private ContextMenu.ContextMenuInfo f1291q;

    /* JADX INFO: renamed from: y */
    private C0198j f1299y;

    /* JADX INFO: renamed from: z */
    private boolean f1300z;

    /* JADX INFO: renamed from: p */
    private int f1290p = 0;

    /* JADX INFO: renamed from: r */
    private boolean f1292r = false;

    /* JADX INFO: renamed from: s */
    private boolean f1293s = false;

    /* JADX INFO: renamed from: t */
    private boolean f1294t = false;

    /* JADX INFO: renamed from: u */
    private boolean f1295u = false;

    /* JADX INFO: renamed from: v */
    private boolean f1296v = false;

    /* JADX INFO: renamed from: w */
    private ArrayList<C0198j> f1297w = new ArrayList<>();

    /* JADX INFO: renamed from: x */
    private CopyOnWriteArrayList<WeakReference<InterfaceC0203o>> f1298x = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: j */
    private ArrayList<C0198j> f1284j = new ArrayList<>();

    /* JADX INFO: renamed from: k */
    private ArrayList<C0198j> f1285k = new ArrayList<>();

    /* JADX INFO: renamed from: l */
    private boolean f1286l = true;

    /* JADX INFO: renamed from: m */
    private ArrayList<C0198j> f1287m = new ArrayList<>();

    /* JADX INFO: renamed from: n */
    private ArrayList<C0198j> f1288n = new ArrayList<>();

    /* JADX INFO: renamed from: o */
    private boolean f1289o = true;

    /* JADX INFO: renamed from: android.support.v7.view.menu.h$a */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo1306a(C0196h c0196h);

        /* JADX INFO: renamed from: a */
        boolean mo1308a(C0196h c0196h, MenuItem menuItem);
    }

    /* JADX INFO: renamed from: android.support.v7.view.menu.h$b */
    public interface b {
        /* JADX INFO: renamed from: a */
        boolean mo1456a(C0198j c0198j);
    }

    public C0196h(Context context) {
        this.f1279e = context;
        this.f1280f = context.getResources();
        m1527e(true);
    }

    /* JADX INFO: renamed from: a */
    private static int m1521a(ArrayList<C0198j> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).m1588c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    private C0198j m1522a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0198j(this, i, i2, i3, i4, charSequence, i5);
    }

    /* JADX INFO: renamed from: a */
    private void m1523a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resourcesM1558d = m1558d();
        if (view != null) {
            this.f1278c = view;
            this.f1276a = null;
            this.f1277b = null;
        } else {
            if (i > 0) {
                this.f1276a = resourcesM1558d.getText(i);
            } else if (charSequence != null) {
                this.f1276a = charSequence;
            }
            if (i2 > 0) {
                this.f1277b = C0033a.m167a(m1561e(), i2);
            } else if (drawable != null) {
                this.f1277b = drawable;
            }
            this.f1278c = null;
        }
        m1552b(false);
    }

    /* JADX INFO: renamed from: a */
    private void m1524a(int i, boolean z) {
        if (i < 0 || i >= this.f1284j.size()) {
            return;
        }
        this.f1284j.remove(i);
        if (z) {
            m1552b(true);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m1525a(SubMenuC0209u subMenuC0209u, InterfaceC0203o interfaceC0203o) {
        if (this.f1298x.isEmpty()) {
            return false;
        }
        boolean zMo1476a = interfaceC0203o != null ? interfaceC0203o.mo1476a(subMenuC0209u) : false;
        for (WeakReference<InterfaceC0203o> weakReference : this.f1298x) {
            InterfaceC0203o interfaceC0203o2 = weakReference.get();
            if (interfaceC0203o2 == null) {
                this.f1298x.remove(weakReference);
            } else if (!zMo1476a) {
                zMo1476a = interfaceC0203o2.mo1476a(subMenuC0209u);
            }
        }
        return zMo1476a;
    }

    /* JADX INFO: renamed from: d */
    private void m1526d(boolean z) {
        if (this.f1298x.isEmpty()) {
            return;
        }
        m1564g();
        for (WeakReference<InterfaceC0203o> weakReference : this.f1298x) {
            InterfaceC0203o interfaceC0203o = weakReference.get();
            if (interfaceC0203o == null) {
                this.f1298x.remove(weakReference);
            } else {
                interfaceC0203o.mo1479b(z);
            }
        }
        m1565h();
    }

    /* JADX INFO: renamed from: e */
    private void m1527e(boolean z) {
        this.f1282h = z && this.f1280f.getConfiguration().keyboard != 1 && this.f1280f.getBoolean(C0148a.b.abc_config_showMenuShortcutsWhenKeyboardPresent);
    }

    /* JADX INFO: renamed from: f */
    private static int m1528f(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 < 0 || i2 >= f1275d.length) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        return (i & 65535) | (f1275d[i2] << 16);
    }

    /* JADX INFO: renamed from: a */
    public int m1529a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < size) {
            if (this.f1284j.get(i2).getGroupId() == i) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public C0196h m1530a(int i) {
        this.f1290p = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    protected C0196h m1531a(Drawable drawable) {
        m1523a(0, null, 0, drawable, null);
        return this;
    }

    /* JADX INFO: renamed from: a */
    protected C0196h m1532a(View view) {
        m1523a(0, null, 0, null, view);
        return this;
    }

    /* JADX INFO: renamed from: a */
    protected C0196h m1533a(CharSequence charSequence) {
        m1523a(0, charSequence, 0, null, null);
        return this;
    }

    /* JADX INFO: renamed from: a */
    C0198j m1534a(int i, KeyEvent keyEvent) {
        ArrayList<C0198j> arrayList = this.f1297w;
        arrayList.clear();
        m1543a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zMo1553b = mo1553b();
        for (int i2 = 0; i2 < size; i2++) {
            C0198j c0198j = arrayList.get(i2);
            char alphabeticShortcut = zMo1553b ? c0198j.getAlphabeticShortcut() : c0198j.getNumericShortcut();
            if ((alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) || (zMo1553b && alphabeticShortcut == '\b' && i == 67))) {
                return c0198j;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    protected MenuItem m1535a(int i, int i2, int i3, CharSequence charSequence) {
        int iM1528f = m1528f(i3);
        C0198j c0198jM1522a = m1522a(i, i2, i3, iM1528f, charSequence, this.f1290p);
        if (this.f1291q != null) {
            c0198jM1522a.m1583a(this.f1291q);
        }
        this.f1284j.add(m1521a(this.f1284j, iM1528f), c0198jM1522a);
        m1552b(true);
        return c0198jM1522a;
    }

    /* JADX INFO: renamed from: a */
    protected String mo1536a() {
        return "android:menu:actionviewstates";
    }

    /* JADX INFO: renamed from: a */
    public void m1537a(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((SubMenuC0209u) item.getSubMenu()).m1537a(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo1536a(), sparseArray);
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo1538a(a aVar) {
        this.f1283i = aVar;
    }

    /* JADX INFO: renamed from: a */
    void m1539a(C0198j c0198j) {
        this.f1286l = true;
        m1552b(true);
    }

    /* JADX INFO: renamed from: a */
    public void m1540a(InterfaceC0203o interfaceC0203o) {
        m1541a(interfaceC0203o, this.f1279e);
    }

    /* JADX INFO: renamed from: a */
    public void m1541a(InterfaceC0203o interfaceC0203o, Context context) {
        this.f1298x.add(new WeakReference<>(interfaceC0203o));
        interfaceC0203o.mo1469a(context, this);
        this.f1289o = true;
    }

    /* JADX INFO: renamed from: a */
    void m1542a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1284j.size();
        m1564g();
        for (int i = 0; i < size; i++) {
            C0198j c0198j = this.f1284j.get(i);
            if (c0198j.getGroupId() == groupId && c0198j.m1595g() && c0198j.isCheckable()) {
                c0198j.m1586b(c0198j == menuItem);
            }
        }
        m1565h();
    }

    /* JADX INFO: renamed from: a */
    void m1543a(List<C0198j> list, int i, KeyEvent keyEvent) {
        boolean zMo1553b = mo1553b();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1284j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0198j c0198j = this.f1284j.get(i2);
                if (c0198j.hasSubMenu()) {
                    ((C0196h) c0198j.getSubMenu()).m1543a(list, i, keyEvent);
                }
                char alphabeticShortcut = zMo1553b ? c0198j.getAlphabeticShortcut() : c0198j.getNumericShortcut();
                if (((modifiers & 69647) == ((zMo1553b ? c0198j.getAlphabeticModifiers() : c0198j.getNumericModifiers()) & 69647)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (zMo1553b && alphabeticShortcut == '\b' && i == 67)) && c0198j.isEnabled())) {
                    list.add(c0198j);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1544a(boolean z) {
        if (this.f1296v) {
            return;
        }
        this.f1296v = true;
        for (WeakReference<InterfaceC0203o> weakReference : this.f1298x) {
            InterfaceC0203o interfaceC0203o = weakReference.get();
            if (interfaceC0203o == null) {
                this.f1298x.remove(weakReference);
            } else {
                interfaceC0203o.mo1470a(this, z);
            }
        }
        this.f1296v = false;
    }

    /* JADX INFO: renamed from: a */
    boolean mo1545a(C0196h c0196h, MenuItem menuItem) {
        return this.f1283i != null && this.f1283i.mo1308a(c0196h, menuItem);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1546a(MenuItem menuItem, int i) {
        return m1547a(menuItem, (InterfaceC0203o) null, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x002d A[PHI: r1
  0x002d: PHI (r1v4 boolean) = (r1v2 boolean), (r1v1 boolean), (r1v5 boolean) binds: [B:35:0x0068, B:23:0x003c, B:16:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m1547a(MenuItem menuItem, InterfaceC0203o interfaceC0203o, int i) {
        C0198j c0198j = (C0198j) menuItem;
        if (c0198j == null || !c0198j.isEnabled()) {
            return false;
        }
        boolean zM1587b = c0198j.m1587b();
        AbstractC0111c abstractC0111cMo718a = c0198j.mo718a();
        boolean z = abstractC0111cMo718a != null && abstractC0111cMo718a.mo898e();
        if (c0198j.m1602n()) {
            zM1587b |= c0198j.expandActionView();
            if (zM1587b) {
                m1544a(true);
            }
        } else if (c0198j.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                m1544a(false);
            }
            if (!c0198j.hasSubMenu()) {
                c0198j.m1582a(new SubMenuC0209u(m1561e(), this, c0198j));
            }
            SubMenuC0209u subMenuC0209u = (SubMenuC0209u) c0198j.getSubMenu();
            if (z) {
                abstractC0111cMo718a.mo893a(subMenuC0209u);
            }
            zM1587b |= m1525a(subMenuC0209u, interfaceC0203o);
            if (!zM1587b) {
            }
        } else if ((i & 1) == 0) {
        }
        return zM1587b;
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return m1535a(0, 0, 0, this.f1280f.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return m1535a(i, i2, i3, this.f1280f.getString(i4));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m1535a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return m1535a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1279e.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1280f.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1280f.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0198j c0198j = (C0198j) m1535a(i, i2, i3, charSequence);
        SubMenuC0209u subMenuC0209u = new SubMenuC0209u(this.f1279e, this, c0198j);
        c0198j.m1582a(subMenuC0209u);
        return subMenuC0209u;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    /* JADX INFO: renamed from: b */
    public int m1548b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f1284j.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: b */
    public void m1549b(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(mo1536a());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((SubMenuC0209u) item.getSubMenu()).m1549b(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (menuItemFindItem = findItem(i2)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    /* JADX INFO: renamed from: b */
    void m1550b(C0198j c0198j) {
        this.f1289o = true;
        m1552b(true);
    }

    /* JADX INFO: renamed from: b */
    public void m1551b(InterfaceC0203o interfaceC0203o) {
        for (WeakReference<InterfaceC0203o> weakReference : this.f1298x) {
            InterfaceC0203o interfaceC0203o2 = weakReference.get();
            if (interfaceC0203o2 == null || interfaceC0203o2 == interfaceC0203o) {
                this.f1298x.remove(weakReference);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1552b(boolean z) {
        if (this.f1292r) {
            this.f1293s = true;
            if (z) {
                this.f1294t = true;
                return;
            }
            return;
        }
        if (z) {
            this.f1286l = true;
            this.f1289o = true;
        }
        m1526d(z);
    }

    /* JADX INFO: renamed from: b */
    boolean mo1553b() {
        return this.f1281g;
    }

    /* JADX INFO: renamed from: c */
    public int m1554c(int i) {
        return m1529a(i, 0);
    }

    /* JADX INFO: renamed from: c */
    public void m1555c(boolean z) {
        this.f1300z = z;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo1556c() {
        return this.f1282h;
    }

    /* JADX INFO: renamed from: c */
    public boolean mo1557c(C0198j c0198j) {
        boolean zMo1475a = false;
        if (this.f1298x.isEmpty()) {
            return false;
        }
        m1564g();
        for (WeakReference<InterfaceC0203o> weakReference : this.f1298x) {
            InterfaceC0203o interfaceC0203o = weakReference.get();
            if (interfaceC0203o != null) {
                zMo1475a = interfaceC0203o.mo1475a(this, c0198j);
                if (zMo1475a) {
                    break;
                }
            } else {
                this.f1298x.remove(weakReference);
            }
        }
        m1565h();
        if (zMo1475a) {
            this.f1299y = c0198j;
        }
        return zMo1475a;
    }

    @Override // android.view.Menu
    public void clear() {
        if (this.f1299y != null) {
            mo1560d(this.f1299y);
        }
        this.f1284j.clear();
        m1552b(true);
    }

    public void clearHeader() {
        this.f1277b = null;
        this.f1276a = null;
        this.f1278c = null;
        m1552b(false);
    }

    @Override // android.view.Menu
    public void close() {
        m1544a(true);
    }

    /* JADX INFO: renamed from: d */
    Resources m1558d() {
        return this.f1280f;
    }

    /* JADX INFO: renamed from: d */
    protected C0196h m1559d(int i) {
        m1523a(i, null, 0, null, null);
        return this;
    }

    /* JADX INFO: renamed from: d */
    public boolean mo1560d(C0198j c0198j) {
        boolean zMo1481b = false;
        if (!this.f1298x.isEmpty() && this.f1299y == c0198j) {
            m1564g();
            for (WeakReference<InterfaceC0203o> weakReference : this.f1298x) {
                InterfaceC0203o interfaceC0203o = weakReference.get();
                if (interfaceC0203o != null) {
                    zMo1481b = interfaceC0203o.mo1481b(this, c0198j);
                    if (zMo1481b) {
                        break;
                    }
                } else {
                    this.f1298x.remove(weakReference);
                }
            }
            m1565h();
            if (zMo1481b) {
                this.f1299y = null;
            }
        }
        return zMo1481b;
    }

    /* JADX INFO: renamed from: e */
    public Context m1561e() {
        return this.f1279e;
    }

    /* JADX INFO: renamed from: e */
    protected C0196h m1562e(int i) {
        m1523a(0, null, i, null, null);
        return this;
    }

    /* JADX INFO: renamed from: f */
    public void m1563f() {
        if (this.f1283i != null) {
            this.f1283i.mo1306a(this);
        }
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0198j c0198j = this.f1284j.get(i2);
            if (c0198j.getItemId() == i) {
                return c0198j;
            }
            if (c0198j.hasSubMenu() && (menuItemFindItem = c0198j.getSubMenu().findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: g */
    public void m1564g() {
        if (this.f1292r) {
            return;
        }
        this.f1292r = true;
        this.f1293s = false;
        this.f1294t = false;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f1284j.get(i);
    }

    /* JADX INFO: renamed from: h */
    public void m1565h() {
        this.f1292r = false;
        if (this.f1293s) {
            this.f1293s = false;
            m1552b(this.f1294t);
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.f1300z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f1284j.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: i */
    public ArrayList<C0198j> m1566i() {
        if (!this.f1286l) {
            return this.f1285k;
        }
        this.f1285k.clear();
        int size = this.f1284j.size();
        for (int i = 0; i < size; i++) {
            C0198j c0198j = this.f1284j.get(i);
            if (c0198j.isVisible()) {
                this.f1285k.add(c0198j);
            }
        }
        this.f1286l = false;
        this.f1289o = true;
        return this.f1285k;
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m1534a(i, keyEvent) != null;
    }

    /* JADX INFO: renamed from: j */
    public void m1567j() {
        ArrayList<C0198j> arrayListM1566i = m1566i();
        if (this.f1289o) {
            boolean zMo1480b = false;
            for (WeakReference<InterfaceC0203o> weakReference : this.f1298x) {
                InterfaceC0203o interfaceC0203o = weakReference.get();
                if (interfaceC0203o == null) {
                    this.f1298x.remove(weakReference);
                } else {
                    zMo1480b |= interfaceC0203o.mo1480b();
                }
            }
            if (zMo1480b) {
                this.f1287m.clear();
                this.f1288n.clear();
                int size = arrayListM1566i.size();
                for (int i = 0; i < size; i++) {
                    C0198j c0198j = arrayListM1566i.get(i);
                    (c0198j.m1598j() ? this.f1287m : this.f1288n).add(c0198j);
                }
            } else {
                this.f1287m.clear();
                this.f1288n.clear();
                this.f1288n.addAll(m1566i());
            }
            this.f1289o = false;
        }
    }

    /* JADX INFO: renamed from: k */
    public ArrayList<C0198j> m1568k() {
        m1567j();
        return this.f1287m;
    }

    /* JADX INFO: renamed from: l */
    public ArrayList<C0198j> m1569l() {
        m1567j();
        return this.f1288n;
    }

    /* JADX INFO: renamed from: m */
    public CharSequence m1570m() {
        return this.f1276a;
    }

    /* JADX INFO: renamed from: n */
    public Drawable m1571n() {
        return this.f1277b;
    }

    /* JADX INFO: renamed from: o */
    public View m1572o() {
        return this.f1278c;
    }

    /* JADX INFO: renamed from: p */
    public C0196h mo1573p() {
        return this;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return m1546a(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        C0198j c0198jM1534a = m1534a(i, keyEvent);
        boolean zM1546a = c0198jM1534a != null ? m1546a(c0198jM1534a, i2) : false;
        if ((i2 & 2) != 0) {
            m1544a(true);
        }
        return zM1546a;
    }

    /* JADX INFO: renamed from: q */
    boolean m1574q() {
        return this.f1295u;
    }

    /* JADX INFO: renamed from: r */
    public C0198j m1575r() {
        return this.f1299y;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iM1554c = m1554c(i);
        if (iM1554c >= 0) {
            int size = this.f1284j.size() - iM1554c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.f1284j.get(iM1554c).getGroupId() != i) {
                    break;
                }
                m1524a(iM1554c, false);
                i2 = i3;
            }
            m1552b(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        m1524a(m1548b(i), true);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1284j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0198j c0198j = this.f1284j.get(i2);
            if (c0198j.getGroupId() == i) {
                c0198j.m1584a(z2);
                c0198j.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1284j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0198j c0198j = this.f1284j.get(i2);
            if (c0198j.getGroupId() == i) {
                c0198j.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f1284j.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            C0198j c0198j = this.f1284j.get(i2);
            if (c0198j.getGroupId() == i && c0198j.m1589c(z)) {
                z2 = true;
            }
        }
        if (z2) {
            m1552b(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.f1281g = z;
        m1552b(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f1284j.size();
    }
}
