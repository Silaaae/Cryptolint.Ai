package android.support.v4.p015g;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: renamed from: android.support.v4.g.r */
/* JADX INFO: loaded from: classes.dex */
public final class C0126r {

    /* JADX INFO: renamed from: a */
    static final c f678a;

    /* JADX INFO: renamed from: android.support.v4.g.r$a */
    static class a extends c {
        a() {
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.r$b */
    static class b extends a {
        b() {
        }

        @Override // android.support.v4.p015g.C0126r.c
        /* JADX INFO: renamed from: a */
        public void mo1008a(ViewParent viewParent, View view) {
            try {
                viewParent.onStopNestedScroll(view);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e);
            }
        }

        @Override // android.support.v4.p015g.C0126r.c
        /* JADX INFO: renamed from: a */
        public void mo1009a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            try {
                viewParent.onNestedScroll(view, i, i2, i3, i4);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e);
            }
        }

        @Override // android.support.v4.p015g.C0126r.c
        /* JADX INFO: renamed from: a */
        public void mo1010a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            try {
                viewParent.onNestedPreScroll(view, i, i2, iArr);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e);
            }
        }

        @Override // android.support.v4.p015g.C0126r.c
        /* JADX INFO: renamed from: a */
        public boolean mo1011a(ViewParent viewParent, View view, float f, float f2) {
            try {
                return viewParent.onNestedPreFling(view, f, f2);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e);
                return false;
            }
        }

        @Override // android.support.v4.p015g.C0126r.c
        /* JADX INFO: renamed from: a */
        public boolean mo1012a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            try {
                return viewParent.onNestedFling(view, f, f2, z);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e);
                return false;
            }
        }

        @Override // android.support.v4.p015g.C0126r.c
        /* JADX INFO: renamed from: a */
        public boolean mo1013a(ViewParent viewParent, View view, View view2, int i) {
            try {
                return viewParent.onStartNestedScroll(view, view2, i);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e);
                return false;
            }
        }

        @Override // android.support.v4.p015g.C0126r.c
        /* JADX INFO: renamed from: b */
        public void mo1014b(ViewParent viewParent, View view, View view2, int i) {
            try {
                viewParent.onNestedScrollAccepted(view, view2, i);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.r$c */
    static class c {
        c() {
        }

        /* JADX INFO: renamed from: a */
        public void mo1008a(ViewParent viewParent, View view) {
            if (viewParent instanceof InterfaceC0119k) {
                ((InterfaceC0119k) viewParent).onStopNestedScroll(view);
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo1009a(ViewParent viewParent, View view, int i, int i2, int i3, int i4) {
            if (viewParent instanceof InterfaceC0119k) {
                ((InterfaceC0119k) viewParent).onNestedScroll(view, i, i2, i3, i4);
            }
        }

        /* JADX INFO: renamed from: a */
        public void mo1010a(ViewParent viewParent, View view, int i, int i2, int[] iArr) {
            if (viewParent instanceof InterfaceC0119k) {
                ((InterfaceC0119k) viewParent).onNestedPreScroll(view, i, i2, iArr);
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean mo1011a(ViewParent viewParent, View view, float f, float f2) {
            if (viewParent instanceof InterfaceC0119k) {
                return ((InterfaceC0119k) viewParent).onNestedPreFling(view, f, f2);
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo1012a(ViewParent viewParent, View view, float f, float f2, boolean z) {
            if (viewParent instanceof InterfaceC0119k) {
                return ((InterfaceC0119k) viewParent).onNestedFling(view, f, f2, z);
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo1013a(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof InterfaceC0119k) {
                return ((InterfaceC0119k) viewParent).onStartNestedScroll(view, view2, i);
            }
            return false;
        }

        /* JADX INFO: renamed from: b */
        public void mo1014b(ViewParent viewParent, View view, View view2, int i) {
            if (viewParent instanceof InterfaceC0119k) {
                ((InterfaceC0119k) viewParent).onNestedScrollAccepted(view, view2, i);
            }
        }
    }

    static {
        f678a = Build.VERSION.SDK_INT >= 21 ? new b() : Build.VERSION.SDK_INT >= 19 ? new a() : new c();
    }

    /* JADX INFO: renamed from: a */
    public static void m1001a(ViewParent viewParent, View view, int i) {
        if (viewParent instanceof InterfaceC0120l) {
            ((InterfaceC0120l) viewParent).m937a(view, i);
        } else if (i == 0) {
            f678a.mo1008a(viewParent, view);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1002a(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5) {
        if (viewParent instanceof InterfaceC0120l) {
            ((InterfaceC0120l) viewParent).m938a(view, i, i2, i3, i4, i5);
        } else if (i5 == 0) {
            f678a.mo1009a(viewParent, view, i, i2, i3, i4);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m1003a(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        if (viewParent instanceof InterfaceC0120l) {
            ((InterfaceC0120l) viewParent).m939a(view, i, i2, iArr, i3);
        } else if (i3 == 0) {
            f678a.mo1010a(viewParent, view, i, i2, iArr);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1004a(ViewParent viewParent, View view, float f, float f2) {
        return f678a.mo1011a(viewParent, view, f, f2);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1005a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        return f678a.mo1012a(viewParent, view, f, f2, z);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1006a(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof InterfaceC0120l) {
            return ((InterfaceC0120l) viewParent).m940a(view, view2, i, i2);
        }
        if (i2 == 0) {
            return f678a.mo1013a(viewParent, view, view2, i);
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public static void m1007b(ViewParent viewParent, View view, View view2, int i, int i2) {
        if (viewParent instanceof InterfaceC0120l) {
            ((InterfaceC0120l) viewParent).m941b(view, view2, i, i2);
        } else if (i2 == 0) {
            f678a.mo1014b(viewParent, view, view2, i);
        }
    }
}
