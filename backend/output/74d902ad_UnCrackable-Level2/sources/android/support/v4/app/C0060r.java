package android.support.v4.app;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.app.C0045c;
import android.support.v4.p014f.C0090a;
import android.support.v4.p015g.C0124p;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: android.support.v4.app.r */
/* JADX INFO: loaded from: classes.dex */
class C0060r {

    /* JADX INFO: renamed from: a */
    private static final int[] f422a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8};

    /* JADX INFO: renamed from: b */
    private static final AbstractC0062t f423b;

    /* JADX INFO: renamed from: c */
    private static final AbstractC0062t f424c;

    /* JADX INFO: renamed from: android.support.v4.app.r$a */
    static class a {

        /* JADX INFO: renamed from: a */
        public ComponentCallbacksC0049g f453a;

        /* JADX INFO: renamed from: b */
        public boolean f454b;

        /* JADX INFO: renamed from: c */
        public C0045c f455c;

        /* JADX INFO: renamed from: d */
        public ComponentCallbacksC0049g f456d;

        /* JADX INFO: renamed from: e */
        public boolean f457e;

        /* JADX INFO: renamed from: f */
        public C0045c f458f;

        a() {
        }
    }

    static {
        f423b = Build.VERSION.SDK_INT >= 21 ? new C0061s() : null;
        f424c = m566a();
    }

    /* JADX INFO: renamed from: a */
    private static a m565a(a aVar, SparseArray<a> sparseArray, int i) {
        if (aVar != null) {
            return aVar;
        }
        a aVar2 = new a();
        sparseArray.put(i, aVar2);
        return aVar2;
    }

    /* JADX INFO: renamed from: a */
    private static AbstractC0062t m566a() {
        try {
            return (AbstractC0062t) Class.forName("android.support.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static AbstractC0062t m567a(ComponentCallbacksC0049g componentCallbacksC0049g, ComponentCallbacksC0049g componentCallbacksC0049g2) {
        ArrayList arrayList = new ArrayList();
        if (componentCallbacksC0049g != null) {
            Object objM362w = componentCallbacksC0049g.m362w();
            if (objM362w != null) {
                arrayList.add(objM362w);
            }
            Object objM361v = componentCallbacksC0049g.m361v();
            if (objM361v != null) {
                arrayList.add(objM361v);
            }
            Object objM365z = componentCallbacksC0049g.m365z();
            if (objM365z != null) {
                arrayList.add(objM365z);
            }
        }
        if (componentCallbacksC0049g2 != null) {
            Object objM360u = componentCallbacksC0049g2.m360u();
            if (objM360u != null) {
                arrayList.add(objM360u);
            }
            Object objM363x = componentCallbacksC0049g2.m363x();
            if (objM363x != null) {
                arrayList.add(objM363x);
            }
            Object objM364y = componentCallbacksC0049g2.m364y();
            if (objM364y != null) {
                arrayList.add(objM364y);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (f423b != null && m588a(f423b, arrayList)) {
            return f423b;
        }
        if (f424c != null && m588a(f424c, arrayList)) {
            return f424c;
        }
        if (f423b == null && f424c == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    /* JADX INFO: renamed from: a */
    private static C0090a<String, String> m568a(int i, ArrayList<C0045c> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        C0090a<String, String> c0090a = new C0090a<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            C0045c c0045c = arrayList.get(i4);
            if (c0045c.m253b(i)) {
                boolean zBooleanValue = arrayList2.get(i4).booleanValue();
                if (c0045c.f224r != null) {
                    int size = c0045c.f224r.size();
                    if (zBooleanValue) {
                        arrayList3 = c0045c.f224r;
                        arrayList4 = c0045c.f225s;
                    } else {
                        ArrayList<String> arrayList5 = c0045c.f224r;
                        arrayList3 = c0045c.f225s;
                        arrayList4 = arrayList5;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String strRemove = c0090a.remove(str2);
                        if (strRemove != null) {
                            c0090a.put(str, strRemove);
                        } else {
                            c0090a.put(str, str2);
                        }
                    }
                }
            }
        }
        return c0090a;
    }

    /* JADX INFO: renamed from: a */
    private static Object m571a(AbstractC0062t abstractC0062t, ComponentCallbacksC0049g componentCallbacksC0049g, ComponentCallbacksC0049g componentCallbacksC0049g2, boolean z) {
        if (componentCallbacksC0049g == null || componentCallbacksC0049g2 == null) {
            return null;
        }
        return abstractC0062t.mo614c(abstractC0062t.mo609b(z ? componentCallbacksC0049g2.m365z() : componentCallbacksC0049g.m364y()));
    }

    /* JADX INFO: renamed from: a */
    private static Object m572a(AbstractC0062t abstractC0062t, ComponentCallbacksC0049g componentCallbacksC0049g, boolean z) {
        if (componentCallbacksC0049g == null) {
            return null;
        }
        return abstractC0062t.mo609b(z ? componentCallbacksC0049g.m363x() : componentCallbacksC0049g.m360u());
    }

    /* JADX INFO: renamed from: a */
    private static Object m573a(final AbstractC0062t abstractC0062t, ViewGroup viewGroup, View view, C0090a<String, String> c0090a, a aVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        final View view2;
        final Rect rect;
        final ComponentCallbacksC0049g componentCallbacksC0049g = aVar.f453a;
        final ComponentCallbacksC0049g componentCallbacksC0049g2 = aVar.f456d;
        if (componentCallbacksC0049g != null) {
            componentCallbacksC0049g.m347k().setVisibility(0);
        }
        if (componentCallbacksC0049g == null || componentCallbacksC0049g2 == null) {
            return null;
        }
        final boolean z = aVar.f454b;
        Object objM571a = c0090a.isEmpty() ? null : m571a(abstractC0062t, componentCallbacksC0049g, componentCallbacksC0049g2, z);
        C0090a<String, View> c0090aM589b = m589b(abstractC0062t, c0090a, objM571a, aVar);
        final C0090a<String, View> c0090aM598c = m598c(abstractC0062t, c0090a, objM571a, aVar);
        if (c0090a.isEmpty()) {
            if (c0090aM589b != null) {
                c0090aM589b.clear();
            }
            if (c0090aM598c != null) {
                c0090aM598c.clear();
            }
            obj3 = null;
        } else {
            m587a(arrayList, c0090aM589b, c0090a.keySet());
            m587a(arrayList2, c0090aM598c, c0090a.values());
            obj3 = objM571a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        m595b(componentCallbacksC0049g, componentCallbacksC0049g2, z, c0090aM589b, true);
        if (obj3 != null) {
            arrayList2.add(view);
            abstractC0062t.mo604a(obj3, view, arrayList);
            m584a(abstractC0062t, obj3, obj2, c0090aM589b, aVar.f457e, aVar.f458f);
            Rect rect2 = new Rect();
            View viewM590b = m590b(c0090aM598c, aVar, obj, z);
            if (viewM590b != null) {
                abstractC0062t.mo602a(obj, rect2);
            }
            rect = rect2;
            view2 = viewM590b;
        } else {
            view2 = null;
            rect = null;
        }
        ViewOnAttachStateChangeListenerC0065w.m635a(viewGroup, new Runnable() { // from class: android.support.v4.app.r.3
            @Override // java.lang.Runnable
            public void run() {
                C0060r.m595b(componentCallbacksC0049g, componentCallbacksC0049g2, z, (C0090a<String, View>) c0090aM598c, false);
                if (view2 != null) {
                    abstractC0062t.m621a(view2, rect);
                }
            }
        });
        return obj3;
    }

    /* JADX INFO: renamed from: a */
    private static Object m574a(AbstractC0062t abstractC0062t, Object obj, Object obj2, Object obj3, ComponentCallbacksC0049g componentCallbacksC0049g, boolean z) {
        return (obj == null || obj2 == null || componentCallbacksC0049g == null) ? true : z ? componentCallbacksC0049g.m267B() : componentCallbacksC0049g.m266A() ? abstractC0062t.mo600a(obj2, obj, obj3) : abstractC0062t.mo610b(obj2, obj, obj3);
    }

    /* JADX INFO: renamed from: a */
    private static String m575a(C0090a<String, String> c0090a, String str) {
        int size = c0090a.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(c0090a.m827c(i))) {
                return c0090a.m826b(i);
            }
        }
        return null;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0020. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:47:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x008b  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m577a(C0045c c0045c, C0045c.a aVar, SparseArray<a> sparseArray, boolean z, boolean z2) {
        int i;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        ComponentCallbacksC0049g componentCallbacksC0049g = aVar.f229b;
        if (componentCallbacksC0049g == null || (i = componentCallbacksC0049g.f295z) == 0) {
            return;
        }
        int i2 = z ? f422a[aVar.f228a] : aVar.f228a;
        boolean z7 = false;
        if (i2 != 1) {
            switch (i2) {
                case 3:
                case 6:
                    boolean z8 = !z2 ? !componentCallbacksC0049g.f281l || componentCallbacksC0049g.f251B : componentCallbacksC0049g.f281l || componentCallbacksC0049g.f259J == null || componentCallbacksC0049g.f259J.getVisibility() != 0 || componentCallbacksC0049g.f267R < 0.0f;
                    z5 = z8;
                    z4 = false;
                    z6 = true;
                    break;
                case 4:
                    if (!z2 ? !componentCallbacksC0049g.f281l || componentCallbacksC0049g.f251B : !componentCallbacksC0049g.f266Q || !componentCallbacksC0049g.f281l || !componentCallbacksC0049g.f251B) {
                    }
                    z5 = z8;
                    z4 = false;
                    z6 = true;
                    break;
                case 5:
                    if (!z2) {
                        z3 = componentCallbacksC0049g.f251B;
                        z7 = z3;
                        z4 = true;
                        z6 = false;
                        z5 = false;
                    } else {
                        z3 = componentCallbacksC0049g.f266Q && !componentCallbacksC0049g.f251B && componentCallbacksC0049g.f281l;
                        z7 = z3;
                        z4 = true;
                        z6 = false;
                        z5 = false;
                    }
                    break;
                case 7:
                    if (!z2) {
                        if (componentCallbacksC0049g.f281l || componentCallbacksC0049g.f251B) {
                        }
                        z7 = z3;
                        z4 = true;
                        z6 = false;
                        z5 = false;
                    } else {
                        z3 = componentCallbacksC0049g.f265P;
                        z7 = z3;
                        z4 = true;
                        z6 = false;
                        z5 = false;
                    }
                    break;
                default:
                    z4 = false;
                    z6 = false;
                    z5 = false;
                    break;
            }
        }
        a aVarM565a = sparseArray.get(i);
        if (z7) {
            aVarM565a = m565a(aVarM565a, sparseArray, i);
            aVarM565a.f453a = componentCallbacksC0049g;
            aVarM565a.f454b = z;
            aVarM565a.f455c = c0045c;
        }
        a aVarM565a2 = aVarM565a;
        if (!z2 && z4) {
            if (aVarM565a2 != null && aVarM565a2.f456d == componentCallbacksC0049g) {
                aVarM565a2.f456d = null;
            }
            LayoutInflaterFactory2C0055m layoutInflaterFactory2C0055m = c0045c.f207a;
            if (componentCallbacksC0049g.f271b < 1 && layoutInflaterFactory2C0055m.f361l >= 1 && !c0045c.f226t) {
                layoutInflaterFactory2C0055m.m522f(componentCallbacksC0049g);
                layoutInflaterFactory2C0055m.m489a(componentCallbacksC0049g, 1, 0, 0, false);
            }
        }
        if (z5 && (aVarM565a2 == null || aVarM565a2.f456d == null)) {
            aVarM565a2 = m565a(aVarM565a2, sparseArray, i);
            aVarM565a2.f456d = componentCallbacksC0049g;
            aVarM565a2.f457e = z;
            aVarM565a2.f458f = c0045c;
        }
        if (z2 || !z6 || aVarM565a2 == null || aVarM565a2.f453a != componentCallbacksC0049g) {
            return;
        }
        aVarM565a2.f453a = null;
    }

    /* JADX INFO: renamed from: a */
    public static void m578a(C0045c c0045c, SparseArray<a> sparseArray, boolean z) {
        int size = c0045c.f208b.size();
        for (int i = 0; i < size; i++) {
            m577a(c0045c, c0045c.f208b.get(i), sparseArray, false, z);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m580a(LayoutInflaterFactory2C0055m layoutInflaterFactory2C0055m, int i, a aVar, View view, C0090a<String, String> c0090a) {
        ComponentCallbacksC0049g componentCallbacksC0049g;
        ComponentCallbacksC0049g componentCallbacksC0049g2;
        AbstractC0062t abstractC0062tM567a;
        Object obj;
        ViewGroup viewGroup = layoutInflaterFactory2C0055m.f363n.mo368a() ? (ViewGroup) layoutInflaterFactory2C0055m.f363n.mo367a(i) : null;
        if (viewGroup == null || (abstractC0062tM567a = m567a((componentCallbacksC0049g2 = aVar.f456d), (componentCallbacksC0049g = aVar.f453a))) == null) {
            return;
        }
        boolean z = aVar.f454b;
        boolean z2 = aVar.f457e;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objM572a = m572a(abstractC0062tM567a, componentCallbacksC0049g, z);
        Object objM591b = m591b(abstractC0062tM567a, componentCallbacksC0049g2, z2);
        Object objM573a = m573a(abstractC0062tM567a, viewGroup, view, c0090a, aVar, arrayList2, arrayList, objM572a, objM591b);
        if (objM572a == null && objM573a == null) {
            obj = objM591b;
            if (obj == null) {
                return;
            }
        } else {
            obj = objM591b;
        }
        ArrayList<View> arrayListM593b = m593b(abstractC0062tM567a, obj, componentCallbacksC0049g2, arrayList2, view);
        ArrayList<View> arrayListM593b2 = m593b(abstractC0062tM567a, objM572a, componentCallbacksC0049g, arrayList, view);
        m597b(arrayListM593b2, 4);
        Object objM574a = m574a(abstractC0062tM567a, objM572a, obj, objM573a, componentCallbacksC0049g, z);
        if (objM574a != null) {
            m583a(abstractC0062tM567a, obj, componentCallbacksC0049g2, arrayListM593b);
            ArrayList<String> arrayListM620a = abstractC0062tM567a.m620a(arrayList);
            abstractC0062tM567a.mo605a(objM574a, objM572a, arrayListM593b2, obj, arrayListM593b, objM573a, arrayList);
            abstractC0062tM567a.mo601a(viewGroup, objM574a);
            abstractC0062tM567a.m622a(viewGroup, arrayList2, arrayList, arrayListM620a, c0090a);
            m597b(arrayListM593b2, 0);
            abstractC0062tM567a.mo607a(objM573a, arrayList2, arrayList);
        }
    }

    /* JADX INFO: renamed from: a */
    static void m581a(LayoutInflaterFactory2C0055m layoutInflaterFactory2C0055m, ArrayList<C0045c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (layoutInflaterFactory2C0055m.f361l < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            C0045c c0045c = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                m594b(c0045c, (SparseArray<a>) sparseArray, z);
            } else {
                m578a(c0045c, (SparseArray<a>) sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(layoutInflaterFactory2C0055m.f362m.m424g());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = sparseArray.keyAt(i4);
                C0090a<String, String> c0090aM568a = m568a(iKeyAt, arrayList, arrayList2, i, i2);
                a aVar = (a) sparseArray.valueAt(i4);
                if (z) {
                    m580a(layoutInflaterFactory2C0055m, iKeyAt, aVar, view, c0090aM568a);
                } else {
                    m596b(layoutInflaterFactory2C0055m, iKeyAt, aVar, view, c0090aM568a);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m582a(final AbstractC0062t abstractC0062t, ViewGroup viewGroup, final ComponentCallbacksC0049g componentCallbacksC0049g, final View view, final ArrayList<View> arrayList, final Object obj, final ArrayList<View> arrayList2, final Object obj2, final ArrayList<View> arrayList3) {
        ViewOnAttachStateChangeListenerC0065w.m635a(viewGroup, new Runnable() { // from class: android.support.v4.app.r.2
            @Override // java.lang.Runnable
            public void run() {
                if (obj != null) {
                    abstractC0062t.mo615c(obj, view);
                    arrayList2.addAll(C0060r.m593b(abstractC0062t, obj, componentCallbacksC0049g, (ArrayList<View>) arrayList, view));
                }
                if (arrayList3 != null) {
                    if (obj2 != null) {
                        ArrayList<View> arrayList4 = new ArrayList<>();
                        arrayList4.add(view);
                        abstractC0062t.mo613b(obj2, arrayList3, arrayList4);
                    }
                    arrayList3.clear();
                    arrayList3.add(view);
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    private static void m583a(AbstractC0062t abstractC0062t, Object obj, ComponentCallbacksC0049g componentCallbacksC0049g, final ArrayList<View> arrayList) {
        if (componentCallbacksC0049g != null && obj != null && componentCallbacksC0049g.f281l && componentCallbacksC0049g.f251B && componentCallbacksC0049g.f266Q) {
            componentCallbacksC0049g.m338f(true);
            abstractC0062t.mo612b(obj, componentCallbacksC0049g.m347k(), arrayList);
            ViewOnAttachStateChangeListenerC0065w.m635a(componentCallbacksC0049g.f258I, new Runnable() { // from class: android.support.v4.app.r.1
                @Override // java.lang.Runnable
                public void run() {
                    C0060r.m597b(arrayList, 4);
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m584a(AbstractC0062t abstractC0062t, Object obj, Object obj2, C0090a<String, View> c0090a, boolean z, C0045c c0045c) {
        if (c0045c.f224r == null || c0045c.f224r.isEmpty()) {
            return;
        }
        View view = c0090a.get((z ? c0045c.f225s : c0045c.f224r).get(0));
        abstractC0062t.mo603a(obj, view);
        if (obj2 != null) {
            abstractC0062t.mo603a(obj2, view);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m585a(C0090a<String, String> c0090a, C0090a<String, View> c0090a2) {
        for (int size = c0090a.size() - 1; size >= 0; size--) {
            if (!c0090a2.containsKey(c0090a.m827c(size))) {
                c0090a.m828d(size);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m587a(ArrayList<View> arrayList, C0090a<String, View> c0090a, Collection<String> collection) {
        for (int size = c0090a.size() - 1; size >= 0; size--) {
            View viewC = c0090a.m827c(size);
            if (collection.contains(C0124p.m963e(viewC))) {
                arrayList.add(viewC);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m588a(AbstractC0062t abstractC0062t, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!abstractC0062t.mo608a(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    private static C0090a<String, View> m589b(AbstractC0062t abstractC0062t, C0090a<String, String> c0090a, Object obj, a aVar) {
        AbstractC0066x abstractC0066xM284S;
        ArrayList<String> arrayList;
        if (c0090a.isEmpty() || obj == null) {
            c0090a.clear();
            return null;
        }
        ComponentCallbacksC0049g componentCallbacksC0049g = aVar.f456d;
        C0090a<String, View> c0090a2 = new C0090a<>();
        abstractC0062t.m626a((Map<String, View>) c0090a2, componentCallbacksC0049g.m347k());
        C0045c c0045c = aVar.f458f;
        if (aVar.f457e) {
            abstractC0066xM284S = componentCallbacksC0049g.m283R();
            arrayList = c0045c.f225s;
        } else {
            abstractC0066xM284S = componentCallbacksC0049g.m284S();
            arrayList = c0045c.f224r;
        }
        c0090a2.m758a((Collection<?>) arrayList);
        if (abstractC0066xM284S != null) {
            abstractC0066xM284S.m638a(arrayList, c0090a2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = c0090a2.get(str);
                if (view == null) {
                    c0090a.remove(str);
                } else if (!str.equals(C0124p.m963e(view))) {
                    c0090a.put(C0124p.m963e(view), c0090a.remove(str));
                }
            }
        } else {
            c0090a.m758a((Collection<?>) c0090a2.keySet());
        }
        return c0090a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static View m590b(C0090a<String, View> c0090a, a aVar, Object obj, boolean z) {
        C0045c c0045c = aVar.f455c;
        if (obj == null || c0090a == null || c0045c.f224r == null || c0045c.f224r.isEmpty()) {
            return null;
        }
        return c0090a.get((z ? c0045c.f224r : c0045c.f225s).get(0));
    }

    /* JADX INFO: renamed from: b */
    private static Object m591b(AbstractC0062t abstractC0062t, ComponentCallbacksC0049g componentCallbacksC0049g, boolean z) {
        if (componentCallbacksC0049g == null) {
            return null;
        }
        return abstractC0062t.mo609b(z ? componentCallbacksC0049g.m361v() : componentCallbacksC0049g.m362w());
    }

    /* JADX INFO: renamed from: b */
    private static Object m592b(final AbstractC0062t abstractC0062t, ViewGroup viewGroup, final View view, final C0090a<String, String> c0090a, final a aVar, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final Object obj, Object obj2) {
        Object objM571a;
        C0090a<String, String> c0090a2;
        Object obj3;
        Rect rect;
        final ComponentCallbacksC0049g componentCallbacksC0049g = aVar.f453a;
        final ComponentCallbacksC0049g componentCallbacksC0049g2 = aVar.f456d;
        if (componentCallbacksC0049g == null || componentCallbacksC0049g2 == null) {
            return null;
        }
        final boolean z = aVar.f454b;
        if (c0090a.isEmpty()) {
            c0090a2 = c0090a;
            objM571a = null;
        } else {
            objM571a = m571a(abstractC0062t, componentCallbacksC0049g, componentCallbacksC0049g2, z);
            c0090a2 = c0090a;
        }
        C0090a<String, View> c0090aM589b = m589b(abstractC0062t, c0090a2, objM571a, aVar);
        if (c0090a.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(c0090aM589b.values());
            obj3 = objM571a;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        m595b(componentCallbacksC0049g, componentCallbacksC0049g2, z, c0090aM589b, true);
        if (obj3 != null) {
            rect = new Rect();
            abstractC0062t.mo604a(obj3, view, arrayList);
            m584a(abstractC0062t, obj3, obj2, c0090aM589b, aVar.f457e, aVar.f458f);
            if (obj != null) {
                abstractC0062t.mo602a(obj, rect);
            }
        } else {
            rect = null;
        }
        final Object obj4 = obj3;
        final Rect rect2 = rect;
        ViewOnAttachStateChangeListenerC0065w.m635a(viewGroup, new Runnable() { // from class: android.support.v4.app.r.4
            @Override // java.lang.Runnable
            public void run() {
                C0090a c0090aM598c = C0060r.m598c(abstractC0062t, c0090a, obj4, aVar);
                if (c0090aM598c != null) {
                    arrayList2.addAll(c0090aM598c.values());
                    arrayList2.add(view);
                }
                C0060r.m595b(componentCallbacksC0049g, componentCallbacksC0049g2, z, (C0090a<String, View>) c0090aM598c, false);
                if (obj4 != null) {
                    abstractC0062t.mo607a(obj4, arrayList, arrayList2);
                    View viewM590b = C0060r.m590b((C0090a<String, View>) c0090aM598c, aVar, obj, z);
                    if (viewM590b != null) {
                        abstractC0062t.m621a(viewM590b, rect2);
                    }
                }
            }
        });
        return obj3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static ArrayList<View> m593b(AbstractC0062t abstractC0062t, Object obj, ComponentCallbacksC0049g componentCallbacksC0049g, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View viewM347k = componentCallbacksC0049g.m347k();
        if (viewM347k != null) {
            abstractC0062t.m625a(arrayList2, viewM347k);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        abstractC0062t.mo606a(obj, arrayList2);
        return arrayList2;
    }

    /* JADX INFO: renamed from: b */
    public static void m594b(C0045c c0045c, SparseArray<a> sparseArray, boolean z) {
        if (c0045c.f207a.f363n.mo368a()) {
            for (int size = c0045c.f208b.size() - 1; size >= 0; size--) {
                m577a(c0045c, c0045c.f208b.get(size), sparseArray, true, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m595b(ComponentCallbacksC0049g componentCallbacksC0049g, ComponentCallbacksC0049g componentCallbacksC0049g2, boolean z, C0090a<String, View> c0090a, boolean z2) {
        AbstractC0066x abstractC0066xM283R = z ? componentCallbacksC0049g2.m283R() : componentCallbacksC0049g.m283R();
        if (abstractC0066xM283R != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = c0090a == null ? 0 : c0090a.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(c0090a.m826b(i));
                arrayList.add(c0090a.m827c(i));
            }
            if (z2) {
                abstractC0066xM283R.m637a(arrayList2, arrayList, null);
            } else {
                abstractC0066xM283R.m639b(arrayList2, arrayList, null);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m596b(LayoutInflaterFactory2C0055m layoutInflaterFactory2C0055m, int i, a aVar, View view, C0090a<String, String> c0090a) {
        ComponentCallbacksC0049g componentCallbacksC0049g;
        ComponentCallbacksC0049g componentCallbacksC0049g2;
        AbstractC0062t abstractC0062tM567a;
        Object obj;
        ViewGroup viewGroup = layoutInflaterFactory2C0055m.f363n.mo368a() ? (ViewGroup) layoutInflaterFactory2C0055m.f363n.mo367a(i) : null;
        if (viewGroup == null || (abstractC0062tM567a = m567a((componentCallbacksC0049g2 = aVar.f456d), (componentCallbacksC0049g = aVar.f453a))) == null) {
            return;
        }
        boolean z = aVar.f454b;
        boolean z2 = aVar.f457e;
        Object objM572a = m572a(abstractC0062tM567a, componentCallbacksC0049g, z);
        Object objM591b = m591b(abstractC0062tM567a, componentCallbacksC0049g2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objM592b = m592b(abstractC0062tM567a, viewGroup, view, c0090a, aVar, arrayList, arrayList2, objM572a, objM591b);
        if (objM572a == null && objM592b == null) {
            obj = objM591b;
            if (obj == null) {
                return;
            }
        } else {
            obj = objM591b;
        }
        ArrayList<View> arrayListM593b = m593b(abstractC0062tM567a, obj, componentCallbacksC0049g2, (ArrayList<View>) arrayList, view);
        Object obj2 = (arrayListM593b == null || arrayListM593b.isEmpty()) ? null : obj;
        abstractC0062tM567a.mo611b(objM572a, view);
        Object objM574a = m574a(abstractC0062tM567a, objM572a, obj2, objM592b, componentCallbacksC0049g, aVar.f454b);
        if (objM574a != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            abstractC0062tM567a.mo605a(objM574a, objM572a, arrayList3, obj2, arrayListM593b, objM592b, arrayList2);
            m582a(abstractC0062tM567a, viewGroup, componentCallbacksC0049g, view, arrayList2, objM572a, arrayList3, obj2, arrayListM593b);
            abstractC0062tM567a.m623a((View) viewGroup, arrayList2, (Map<String, String>) c0090a);
            abstractC0062tM567a.mo601a(viewGroup, objM574a);
            abstractC0062tM567a.m624a(viewGroup, arrayList2, (Map<String, String>) c0090a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m597b(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public static C0090a<String, View> m598c(AbstractC0062t abstractC0062t, C0090a<String, String> c0090a, Object obj, a aVar) {
        AbstractC0066x abstractC0066xM283R;
        ArrayList<String> arrayList;
        String strM575a;
        ComponentCallbacksC0049g componentCallbacksC0049g = aVar.f453a;
        View viewM347k = componentCallbacksC0049g.m347k();
        if (c0090a.isEmpty() || obj == null || viewM347k == null) {
            c0090a.clear();
            return null;
        }
        C0090a<String, View> c0090a2 = new C0090a<>();
        abstractC0062t.m626a((Map<String, View>) c0090a2, viewM347k);
        C0045c c0045c = aVar.f455c;
        if (aVar.f454b) {
            abstractC0066xM283R = componentCallbacksC0049g.m284S();
            arrayList = c0045c.f224r;
        } else {
            abstractC0066xM283R = componentCallbacksC0049g.m283R();
            arrayList = c0045c.f225s;
        }
        if (arrayList != null) {
            c0090a2.m758a((Collection<?>) arrayList);
            c0090a2.m758a((Collection<?>) c0090a.values());
        }
        if (abstractC0066xM283R != null) {
            abstractC0066xM283R.m638a(arrayList, c0090a2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = c0090a2.get(str);
                if (view == null) {
                    String strM575a2 = m575a(c0090a, str);
                    if (strM575a2 != null) {
                        c0090a.remove(strM575a2);
                    }
                } else if (!str.equals(C0124p.m963e(view)) && (strM575a = m575a(c0090a, str)) != null) {
                    c0090a.put(strM575a, C0124p.m963e(view));
                }
            }
        } else {
            m585a(c0090a, c0090a2);
        }
        return c0090a2;
    }
}
