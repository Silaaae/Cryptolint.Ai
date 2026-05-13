package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.support.v4.p010c.p011a.InterfaceMenuC0083a;
import android.support.v4.p015g.AbstractC0111c;
import android.support.v4.p015g.C0115g;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.menu.C0198j;
import android.support.v7.view.menu.MenuItemC0199k;
import android.support.v7.widget.C0246af;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: android.support.v7.view.g */
/* JADX INFO: loaded from: classes.dex */
public class C0184g extends MenuInflater {

    /* JADX INFO: renamed from: a */
    static final Class<?>[] f1105a = {Context.class};

    /* JADX INFO: renamed from: b */
    static final Class<?>[] f1106b = f1105a;

    /* JADX INFO: renamed from: c */
    final Object[] f1107c;

    /* JADX INFO: renamed from: d */
    final Object[] f1108d;

    /* JADX INFO: renamed from: e */
    Context f1109e;

    /* JADX INFO: renamed from: f */
    private Object f1110f;

    /* JADX INFO: renamed from: android.support.v7.view.g$a */
    private static class a implements MenuItem.OnMenuItemClickListener {

        /* JADX INFO: renamed from: a */
        private static final Class<?>[] f1111a = {MenuItem.class};

        /* JADX INFO: renamed from: b */
        private Object f1112b;

        /* JADX INFO: renamed from: c */
        private Method f1113c;

        public a(Object obj, String str) {
            this.f1112b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f1113c = cls.getMethod(str, f1111a);
            } catch (Exception e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1113c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1113c.invoke(this.f1112b, menuItem)).booleanValue();
                }
                this.f1113c.invoke(this.f1112b, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.view.g$b */
    private class b {

        /* JADX INFO: renamed from: A */
        private String f1114A;

        /* JADX INFO: renamed from: B */
        private String f1115B;

        /* JADX INFO: renamed from: C */
        private CharSequence f1116C;

        /* JADX INFO: renamed from: D */
        private CharSequence f1117D;

        /* JADX INFO: renamed from: E */
        private ColorStateList f1118E = null;

        /* JADX INFO: renamed from: F */
        private PorterDuff.Mode f1119F = null;

        /* JADX INFO: renamed from: a */
        AbstractC0111c f1120a;

        /* JADX INFO: renamed from: c */
        private Menu f1122c;

        /* JADX INFO: renamed from: d */
        private int f1123d;

        /* JADX INFO: renamed from: e */
        private int f1124e;

        /* JADX INFO: renamed from: f */
        private int f1125f;

        /* JADX INFO: renamed from: g */
        private int f1126g;

        /* JADX INFO: renamed from: h */
        private boolean f1127h;

        /* JADX INFO: renamed from: i */
        private boolean f1128i;

        /* JADX INFO: renamed from: j */
        private boolean f1129j;

        /* JADX INFO: renamed from: k */
        private int f1130k;

        /* JADX INFO: renamed from: l */
        private int f1131l;

        /* JADX INFO: renamed from: m */
        private CharSequence f1132m;

        /* JADX INFO: renamed from: n */
        private CharSequence f1133n;

        /* JADX INFO: renamed from: o */
        private int f1134o;

        /* JADX INFO: renamed from: p */
        private char f1135p;

        /* JADX INFO: renamed from: q */
        private int f1136q;

        /* JADX INFO: renamed from: r */
        private char f1137r;

        /* JADX INFO: renamed from: s */
        private int f1138s;

        /* JADX INFO: renamed from: t */
        private int f1139t;

        /* JADX INFO: renamed from: u */
        private boolean f1140u;

        /* JADX INFO: renamed from: v */
        private boolean f1141v;

        /* JADX INFO: renamed from: w */
        private boolean f1142w;

        /* JADX INFO: renamed from: x */
        private int f1143x;

        /* JADX INFO: renamed from: y */
        private int f1144y;

        /* JADX INFO: renamed from: z */
        private String f1145z;

        public b(Menu menu) {
            this.f1122c = menu;
            m1430a();
        }

        /* JADX INFO: renamed from: a */
        private char m1427a(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        /* JADX INFO: renamed from: a */
        private <T> T m1428a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = C0184g.this.f1109e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        /* JADX INFO: renamed from: a */
        private void m1429a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.f1140u).setVisible(this.f1141v).setEnabled(this.f1142w).setCheckable(this.f1139t >= 1).setTitleCondensed(this.f1133n).setIcon(this.f1134o);
            if (this.f1143x >= 0) {
                menuItem.setShowAsAction(this.f1143x);
            }
            if (this.f1115B != null) {
                if (C0184g.this.f1109e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new a(C0184g.this.m1426a(), this.f1115B));
            }
            boolean z2 = menuItem instanceof C0198j;
            if (z2) {
            }
            if (this.f1139t >= 2) {
                if (z2) {
                    ((C0198j) menuItem).m1584a(true);
                } else if (menuItem instanceof MenuItemC0199k) {
                    ((MenuItemC0199k) menuItem).m1604a(true);
                }
            }
            if (this.f1145z != null) {
                menuItem.setActionView((View) m1428a(this.f1145z, C0184g.f1105a, C0184g.this.f1107c));
                z = true;
            }
            if (this.f1144y > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    menuItem.setActionView(this.f1144y);
                }
            }
            if (this.f1120a != null) {
                C0115g.m908a(menuItem, this.f1120a);
            }
            C0115g.m912a(menuItem, this.f1116C);
            C0115g.m914b(menuItem, this.f1117D);
            C0115g.m913b(menuItem, this.f1135p, this.f1136q);
            C0115g.m909a(menuItem, this.f1137r, this.f1138s);
            if (this.f1119F != null) {
                C0115g.m911a(menuItem, this.f1119F);
            }
            if (this.f1118E != null) {
                C0115g.m910a(menuItem, this.f1118E);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m1430a() {
            this.f1123d = 0;
            this.f1124e = 0;
            this.f1125f = 0;
            this.f1126g = 0;
            this.f1127h = true;
            this.f1128i = true;
        }

        /* JADX INFO: renamed from: a */
        public void m1431a(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = C0184g.this.f1109e.obtainStyledAttributes(attributeSet, C0148a.j.MenuGroup);
            this.f1123d = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.MenuGroup_android_id, 0);
            this.f1124e = typedArrayObtainStyledAttributes.getInt(C0148a.j.MenuGroup_android_menuCategory, 0);
            this.f1125f = typedArrayObtainStyledAttributes.getInt(C0148a.j.MenuGroup_android_orderInCategory, 0);
            this.f1126g = typedArrayObtainStyledAttributes.getInt(C0148a.j.MenuGroup_android_checkableBehavior, 0);
            this.f1127h = typedArrayObtainStyledAttributes.getBoolean(C0148a.j.MenuGroup_android_visible, true);
            this.f1128i = typedArrayObtainStyledAttributes.getBoolean(C0148a.j.MenuGroup_android_enabled, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        /* JADX INFO: renamed from: b */
        public void m1432b() {
            this.f1129j = true;
            m1429a(this.f1122c.add(this.f1123d, this.f1130k, this.f1131l, this.f1132m));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: b */
        public void m1433b(AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = C0184g.this.f1109e.obtainStyledAttributes(attributeSet, C0148a.j.MenuItem);
            this.f1130k = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.MenuItem_android_id, 0);
            this.f1131l = (typedArrayObtainStyledAttributes.getInt(C0148a.j.MenuItem_android_menuCategory, this.f1124e) & (-65536)) | (typedArrayObtainStyledAttributes.getInt(C0148a.j.MenuItem_android_orderInCategory, this.f1125f) & 65535);
            this.f1132m = typedArrayObtainStyledAttributes.getText(C0148a.j.MenuItem_android_title);
            this.f1133n = typedArrayObtainStyledAttributes.getText(C0148a.j.MenuItem_android_titleCondensed);
            this.f1134o = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.MenuItem_android_icon, 0);
            this.f1135p = m1427a(typedArrayObtainStyledAttributes.getString(C0148a.j.MenuItem_android_alphabeticShortcut));
            this.f1136q = typedArrayObtainStyledAttributes.getInt(C0148a.j.MenuItem_alphabeticModifiers, 4096);
            this.f1137r = m1427a(typedArrayObtainStyledAttributes.getString(C0148a.j.MenuItem_android_numericShortcut));
            this.f1138s = typedArrayObtainStyledAttributes.getInt(C0148a.j.MenuItem_numericModifiers, 4096);
            this.f1139t = typedArrayObtainStyledAttributes.hasValue(C0148a.j.MenuItem_android_checkable) ? typedArrayObtainStyledAttributes.getBoolean(C0148a.j.MenuItem_android_checkable, false) : this.f1126g;
            this.f1140u = typedArrayObtainStyledAttributes.getBoolean(C0148a.j.MenuItem_android_checked, false);
            this.f1141v = typedArrayObtainStyledAttributes.getBoolean(C0148a.j.MenuItem_android_visible, this.f1127h);
            this.f1142w = typedArrayObtainStyledAttributes.getBoolean(C0148a.j.MenuItem_android_enabled, this.f1128i);
            this.f1143x = typedArrayObtainStyledAttributes.getInt(C0148a.j.MenuItem_showAsAction, -1);
            this.f1115B = typedArrayObtainStyledAttributes.getString(C0148a.j.MenuItem_android_onClick);
            this.f1144y = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.MenuItem_actionLayout, 0);
            this.f1145z = typedArrayObtainStyledAttributes.getString(C0148a.j.MenuItem_actionViewClass);
            this.f1114A = typedArrayObtainStyledAttributes.getString(C0148a.j.MenuItem_actionProviderClass);
            boolean z = this.f1114A != null;
            if (z && this.f1144y == 0 && this.f1145z == null) {
                this.f1120a = (AbstractC0111c) m1428a(this.f1114A, C0184g.f1106b, C0184g.this.f1108d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1120a = null;
            }
            this.f1116C = typedArrayObtainStyledAttributes.getText(C0148a.j.MenuItem_contentDescription);
            this.f1117D = typedArrayObtainStyledAttributes.getText(C0148a.j.MenuItem_tooltipText);
            if (typedArrayObtainStyledAttributes.hasValue(C0148a.j.MenuItem_iconTintMode)) {
                this.f1119F = C0246af.m1853a(typedArrayObtainStyledAttributes.getInt(C0148a.j.MenuItem_iconTintMode, -1), this.f1119F);
            } else {
                this.f1119F = null;
            }
            if (typedArrayObtainStyledAttributes.hasValue(C0148a.j.MenuItem_iconTint)) {
                this.f1118E = typedArrayObtainStyledAttributes.getColorStateList(C0148a.j.MenuItem_iconTint);
            } else {
                this.f1118E = null;
            }
            typedArrayObtainStyledAttributes.recycle();
            this.f1129j = false;
        }

        /* JADX INFO: renamed from: c */
        public SubMenu m1434c() {
            this.f1129j = true;
            SubMenu subMenuAddSubMenu = this.f1122c.addSubMenu(this.f1123d, this.f1130k, this.f1131l, this.f1132m);
            m1429a(subMenuAddSubMenu.getItem());
            return subMenuAddSubMenu;
        }

        /* JADX INFO: renamed from: d */
        public boolean m1435d() {
            return this.f1129j;
        }
    }

    public C0184g(Context context) {
        super(context);
        this.f1109e = context;
        this.f1107c = new Object[]{context};
        this.f1108d = this.f1107c;
    }

    /* JADX INFO: renamed from: a */
    private Object m1424a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m1424a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX INFO: renamed from: a */
    private void m1425a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
                eventType = xmlPullParser.next();
            }
        }
        int next = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            switch (next) {
                case 1:
                    throw new RuntimeException("Unexpected end of document");
                case 2:
                    if (!z2) {
                        String name2 = xmlPullParser.getName();
                        if (name2.equals("group")) {
                            bVar.m1431a(attributeSet);
                        } else if (name2.equals("item")) {
                            bVar.m1433b(attributeSet);
                        } else if (!name2.equals("menu")) {
                            str = name2;
                            z2 = true;
                        } else {
                            m1425a(xmlPullParser, attributeSet, bVar.m1434c());
                        }
                    }
                    break;
                case 3:
                    String name3 = xmlPullParser.getName();
                    if (z2 && name3.equals(str)) {
                        str = null;
                        z2 = false;
                    } else if (name3.equals("group")) {
                        bVar.m1430a();
                    } else if (!name3.equals("item")) {
                        if (name3.equals("menu")) {
                            z = true;
                        }
                    } else if (!bVar.m1435d()) {
                        if (bVar.f1120a != null && bVar.f1120a.mo898e()) {
                            bVar.m1434c();
                        } else {
                            bVar.m1432b();
                        }
                    }
                    break;
            }
            next = xmlPullParser.next();
        }
    }

    /* JADX INFO: renamed from: a */
    Object m1426a() {
        if (this.f1110f == null) {
            this.f1110f = m1424a(this.f1109e);
        }
        return this.f1110f;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) throws Throwable {
        XmlResourceParser layout;
        if (!(menu instanceof InterfaceMenuC0083a)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                layout = this.f1109e.getResources().getLayout(i);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (XmlPullParserException e2) {
            e = e2;
        }
        try {
            m1425a(layout, Xml.asAttributeSet(layout), menu);
            if (layout != null) {
                layout.close();
            }
        } catch (IOException e3) {
            e = e3;
            throw new InflateException("Error inflating menu XML", e);
        } catch (XmlPullParserException e4) {
            e = e4;
            throw new InflateException("Error inflating menu XML", e);
        } catch (Throwable th2) {
            th = th2;
            xmlResourceParser = layout;
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
