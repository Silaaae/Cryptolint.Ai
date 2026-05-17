package android.support.v4.app;

import android.support.v4.app.ComponentCallbacksC0049g;
import android.support.v4.app.LayoutInflaterFactory2C0055m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: renamed from: android.support.v4.app.c */
/* JADX INFO: loaded from: classes.dex */
final class C0045c extends AbstractC0059q implements LayoutInflaterFactory2C0055m.g {

    /* JADX INFO: renamed from: a */
    final LayoutInflaterFactory2C0055m f207a;

    /* JADX INFO: renamed from: c */
    int f209c;

    /* JADX INFO: renamed from: d */
    int f210d;

    /* JADX INFO: renamed from: e */
    int f211e;

    /* JADX INFO: renamed from: f */
    int f212f;

    /* JADX INFO: renamed from: g */
    int f213g;

    /* JADX INFO: renamed from: h */
    int f214h;

    /* JADX INFO: renamed from: i */
    boolean f215i;

    /* JADX INFO: renamed from: k */
    String f217k;

    /* JADX INFO: renamed from: l */
    boolean f218l;

    /* JADX INFO: renamed from: n */
    int f220n;

    /* JADX INFO: renamed from: o */
    CharSequence f221o;

    /* JADX INFO: renamed from: p */
    int f222p;

    /* JADX INFO: renamed from: q */
    CharSequence f223q;

    /* JADX INFO: renamed from: r */
    ArrayList<String> f224r;

    /* JADX INFO: renamed from: s */
    ArrayList<String> f225s;

    /* JADX INFO: renamed from: u */
    ArrayList<Runnable> f227u;

    /* JADX INFO: renamed from: b */
    ArrayList<a> f208b = new ArrayList<>();

    /* JADX INFO: renamed from: j */
    boolean f216j = true;

    /* JADX INFO: renamed from: m */
    int f219m = -1;

    /* JADX INFO: renamed from: t */
    boolean f226t = false;

    /* JADX INFO: renamed from: android.support.v4.app.c$a */
    static final class a {

        /* JADX INFO: renamed from: a */
        int f228a;

        /* JADX INFO: renamed from: b */
        ComponentCallbacksC0049g f229b;

        /* JADX INFO: renamed from: c */
        int f230c;

        /* JADX INFO: renamed from: d */
        int f231d;

        /* JADX INFO: renamed from: e */
        int f232e;

        /* JADX INFO: renamed from: f */
        int f233f;

        a() {
        }

        a(int i, ComponentCallbacksC0049g componentCallbacksC0049g) {
            this.f228a = i;
            this.f229b = componentCallbacksC0049g;
        }
    }

    public C0045c(LayoutInflaterFactory2C0055m layoutInflaterFactory2C0055m) {
        this.f207a = layoutInflaterFactory2C0055m;
    }

    /* JADX INFO: renamed from: b */
    private static boolean m240b(a aVar) {
        ComponentCallbacksC0049g componentCallbacksC0049g = aVar.f229b;
        return (componentCallbacksC0049g == null || !componentCallbacksC0049g.f281l || componentCallbacksC0049g.f259J == null || componentCallbacksC0049g.f252C || componentCallbacksC0049g.f251B || !componentCallbacksC0049g.m288W()) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    ComponentCallbacksC0049g m241a(ArrayList<ComponentCallbacksC0049g> arrayList, ComponentCallbacksC0049g componentCallbacksC0049g) {
        ComponentCallbacksC0049g componentCallbacksC0049g2 = componentCallbacksC0049g;
        int i = 0;
        while (i < this.f208b.size()) {
            a aVar = this.f208b.get(i);
            switch (aVar.f228a) {
                case 1:
                case 7:
                    arrayList.add(aVar.f229b);
                    break;
                case 2:
                    ComponentCallbacksC0049g componentCallbacksC0049g3 = aVar.f229b;
                    int i2 = componentCallbacksC0049g3.f295z;
                    ComponentCallbacksC0049g componentCallbacksC0049g4 = componentCallbacksC0049g2;
                    int i3 = i;
                    boolean z = false;
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ComponentCallbacksC0049g componentCallbacksC0049g5 = arrayList.get(size);
                        if (componentCallbacksC0049g5.f295z == i2) {
                            if (componentCallbacksC0049g5 == componentCallbacksC0049g3) {
                                z = true;
                            } else {
                                if (componentCallbacksC0049g5 == componentCallbacksC0049g4) {
                                    this.f208b.add(i3, new a(9, componentCallbacksC0049g5));
                                    i3++;
                                    componentCallbacksC0049g4 = null;
                                }
                                a aVar2 = new a(3, componentCallbacksC0049g5);
                                aVar2.f230c = aVar.f230c;
                                aVar2.f232e = aVar.f232e;
                                aVar2.f231d = aVar.f231d;
                                aVar2.f233f = aVar.f233f;
                                this.f208b.add(i3, aVar2);
                                arrayList.remove(componentCallbacksC0049g5);
                                i3++;
                            }
                        }
                    }
                    if (z) {
                        this.f208b.remove(i3);
                        i3--;
                    } else {
                        aVar.f228a = 1;
                        arrayList.add(componentCallbacksC0049g3);
                    }
                    i = i3;
                    componentCallbacksC0049g2 = componentCallbacksC0049g4;
                    break;
                case 3:
                case 6:
                    arrayList.remove(aVar.f229b);
                    if (aVar.f229b == componentCallbacksC0049g2) {
                        this.f208b.add(i, new a(9, aVar.f229b));
                        i++;
                        componentCallbacksC0049g2 = null;
                    }
                    break;
                case 8:
                    this.f208b.add(i, new a(9, componentCallbacksC0049g2));
                    i++;
                    componentCallbacksC0049g2 = aVar.f229b;
                    break;
            }
            i++;
        }
        return componentCallbacksC0049g2;
    }

    /* JADX INFO: renamed from: a */
    public void m242a() {
        if (this.f227u != null) {
            int size = this.f227u.size();
            for (int i = 0; i < size; i++) {
                this.f227u.get(i).run();
            }
            this.f227u = null;
        }
    }

    /* JADX INFO: renamed from: a */
    void m243a(int i) {
        if (this.f215i) {
            if (LayoutInflaterFactory2C0055m.f343a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f208b.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.f208b.get(i2);
                if (aVar.f229b != null) {
                    aVar.f229b.f287r += i;
                    if (LayoutInflaterFactory2C0055m.f343a) {
                        Log.v("FragmentManager", "Bump nesting of " + aVar.f229b + " to " + aVar.f229b.f287r);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m244a(a aVar) {
        this.f208b.add(aVar);
        aVar.f230c = this.f209c;
        aVar.f231d = this.f210d;
        aVar.f232e = this.f211e;
        aVar.f233f = this.f212f;
    }

    /* JADX INFO: renamed from: a */
    void m245a(ComponentCallbacksC0049g.c cVar) {
        for (int i = 0; i < this.f208b.size(); i++) {
            a aVar = this.f208b.get(i);
            if (m240b(aVar)) {
                aVar.f229b.m305a(cVar);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m246a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m247a(str, printWriter, true);
    }

    /* JADX INFO: renamed from: a */
    public void m247a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f217k);
            printWriter.print(" mIndex=");
            printWriter.print(this.f219m);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f218l);
            if (this.f213g != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f213g));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f214h));
            }
            if (this.f209c != 0 || this.f210d != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f209c));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f210d));
            }
            if (this.f211e != 0 || this.f212f != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f211e));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f212f));
            }
            if (this.f220n != 0 || this.f221o != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f220n));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f221o);
            }
            if (this.f222p != 0 || this.f223q != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f222p));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f223q);
            }
        }
        if (this.f208b.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        String str3 = str + "    ";
        int size = this.f208b.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f208b.get(i);
            switch (aVar.f228a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                default:
                    str2 = "cmd=" + aVar.f228a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(aVar.f229b);
            if (z) {
                if (aVar.f230c != 0 || aVar.f231d != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f230c));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f231d));
                }
                if (aVar.f232e != 0 || aVar.f233f != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(aVar.f232e));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(aVar.f233f));
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m248a(boolean z) {
        for (int size = this.f208b.size() - 1; size >= 0; size--) {
            a aVar = this.f208b.get(size);
            ComponentCallbacksC0049g componentCallbacksC0049g = aVar.f229b;
            if (componentCallbacksC0049g != null) {
                componentCallbacksC0049g.m294a(LayoutInflaterFactory2C0055m.m473d(this.f213g), this.f214h);
            }
            int i = aVar.f228a;
            if (i != 1) {
                switch (i) {
                    case 3:
                        componentCallbacksC0049g.m293a(aVar.f232e);
                        this.f207a.m493a(componentCallbacksC0049g, false);
                        break;
                    case 4:
                        componentCallbacksC0049g.m293a(aVar.f232e);
                        this.f207a.m533j(componentCallbacksC0049g);
                        break;
                    case 5:
                        componentCallbacksC0049g.m293a(aVar.f233f);
                        this.f207a.m531i(componentCallbacksC0049g);
                        break;
                    case 6:
                        componentCallbacksC0049g.m293a(aVar.f232e);
                        this.f207a.m537l(componentCallbacksC0049g);
                        break;
                    case 7:
                        componentCallbacksC0049g.m293a(aVar.f233f);
                        this.f207a.m535k(componentCallbacksC0049g);
                        break;
                    case 8:
                        this.f207a.m543o(null);
                        break;
                    case 9:
                        this.f207a.m543o(componentCallbacksC0049g);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.f228a);
                }
            } else {
                componentCallbacksC0049g.m293a(aVar.f233f);
                this.f207a.m528h(componentCallbacksC0049g);
            }
            if (!this.f226t && aVar.f228a != 3 && componentCallbacksC0049g != null) {
                this.f207a.m518e(componentCallbacksC0049g);
            }
        }
        if (this.f226t || !z) {
            return;
        }
        this.f207a.m483a(this.f207a.f361l, true);
    }

    /* JADX INFO: renamed from: a */
    boolean m249a(ArrayList<C0045c> arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f208b.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            a aVar = this.f208b.get(i4);
            int i5 = aVar.f229b != null ? aVar.f229b.f295z : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    C0045c c0045c = arrayList.get(i6);
                    int size2 = c0045c.f208b.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        a aVar2 = c0045c.f208b.get(i7);
                        if ((aVar2.f229b != null ? aVar2.f229b.f295z : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    @Override // android.support.v4.app.LayoutInflaterFactory2C0055m.g
    /* JADX INFO: renamed from: a */
    public boolean mo250a(ArrayList<C0045c> arrayList, ArrayList<Boolean> arrayList2) {
        if (LayoutInflaterFactory2C0055m.f343a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(false);
        if (!this.f215i) {
            return true;
        }
        this.f207a.m487a(this);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    ComponentCallbacksC0049g m251b(ArrayList<ComponentCallbacksC0049g> arrayList, ComponentCallbacksC0049g componentCallbacksC0049g) {
        for (int i = 0; i < this.f208b.size(); i++) {
            a aVar = this.f208b.get(i);
            int i2 = aVar.f228a;
            if (i2 == 1) {
                arrayList.remove(aVar.f229b);
            } else if (i2 != 3) {
                switch (i2) {
                    case 6:
                        arrayList.add(aVar.f229b);
                        break;
                    case 8:
                        componentCallbacksC0049g = null;
                        break;
                    case 9:
                        componentCallbacksC0049g = aVar.f229b;
                        break;
                }
            }
        }
        return componentCallbacksC0049g;
    }

    /* JADX INFO: renamed from: b */
    void m252b() {
        int size = this.f208b.size();
        for (int i = 0; i < size; i++) {
            a aVar = this.f208b.get(i);
            ComponentCallbacksC0049g componentCallbacksC0049g = aVar.f229b;
            if (componentCallbacksC0049g != null) {
                componentCallbacksC0049g.m294a(this.f213g, this.f214h);
            }
            int i2 = aVar.f228a;
            if (i2 != 1) {
                switch (i2) {
                    case 3:
                        componentCallbacksC0049g.m293a(aVar.f231d);
                        this.f207a.m528h(componentCallbacksC0049g);
                        break;
                    case 4:
                        componentCallbacksC0049g.m293a(aVar.f231d);
                        this.f207a.m531i(componentCallbacksC0049g);
                        break;
                    case 5:
                        componentCallbacksC0049g.m293a(aVar.f230c);
                        this.f207a.m533j(componentCallbacksC0049g);
                        break;
                    case 6:
                        componentCallbacksC0049g.m293a(aVar.f231d);
                        this.f207a.m535k(componentCallbacksC0049g);
                        break;
                    case 7:
                        componentCallbacksC0049g.m293a(aVar.f230c);
                        this.f207a.m537l(componentCallbacksC0049g);
                        break;
                    case 8:
                        this.f207a.m543o(componentCallbacksC0049g);
                        break;
                    case 9:
                        this.f207a.m543o(null);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + aVar.f228a);
                }
            } else {
                componentCallbacksC0049g.m293a(aVar.f230c);
                this.f207a.m493a(componentCallbacksC0049g, false);
            }
            if (!this.f226t && aVar.f228a != 1 && componentCallbacksC0049g != null) {
                this.f207a.m518e(componentCallbacksC0049g);
            }
        }
        if (this.f226t) {
            return;
        }
        this.f207a.m483a(this.f207a.f361l, true);
    }

    /* JADX INFO: renamed from: b */
    boolean m253b(int i) {
        int size = this.f208b.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.f208b.get(i2);
            int i3 = aVar.f229b != null ? aVar.f229b.f295z : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    boolean m254c() {
        for (int i = 0; i < this.f208b.size(); i++) {
            if (m240b(this.f208b.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    public String m255d() {
        return this.f217k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f219m >= 0) {
            sb.append(" #");
            sb.append(this.f219m);
        }
        if (this.f217k != null) {
            sb.append(" ");
            sb.append(this.f217k);
        }
        sb.append("}");
        return sb.toString();
    }
}
