package android.support.v4.p015g;

import android.os.Build;
import android.support.p003a.C0023a;
import android.view.ViewGroup;

/* JADX INFO: renamed from: android.support.v4.g.q */
/* JADX INFO: loaded from: classes.dex */
public final class C0125q {

    /* JADX INFO: renamed from: a */
    static final c f677a;

    /* JADX INFO: renamed from: android.support.v4.g.q$a */
    static class a extends c {
        a() {
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.q$b */
    static class b extends a {
        b() {
        }

        @Override // android.support.v4.p015g.C0125q.c
        /* JADX INFO: renamed from: a */
        public boolean mo1000a(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.q$c */
    static class c {
        c() {
        }

        /* JADX INFO: renamed from: a */
        public boolean mo1000a(ViewGroup viewGroup) {
            Boolean bool = (Boolean) viewGroup.getTag(C0023a.a.tag_transition_group);
            return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && C0124p.m963e(viewGroup) == null) ? false : true;
        }
    }

    static {
        f677a = Build.VERSION.SDK_INT >= 21 ? new b() : Build.VERSION.SDK_INT >= 18 ? new a() : new c();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m999a(ViewGroup viewGroup) {
        return f677a.mo1000a(viewGroup);
    }
}
