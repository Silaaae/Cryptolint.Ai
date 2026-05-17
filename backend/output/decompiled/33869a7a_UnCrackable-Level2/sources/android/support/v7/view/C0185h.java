package android.support.v7.view;

import android.support.v4.p015g.C0127s;
import android.support.v4.p015g.C0129u;
import android.support.v4.p015g.InterfaceC0128t;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: android.support.v7.view.h */
/* JADX INFO: loaded from: classes.dex */
public class C0185h {

    /* JADX INFO: renamed from: b */
    InterfaceC0128t f1147b;

    /* JADX INFO: renamed from: d */
    private Interpolator f1149d;

    /* JADX INFO: renamed from: e */
    private boolean f1150e;

    /* JADX INFO: renamed from: c */
    private long f1148c = -1;

    /* JADX INFO: renamed from: f */
    private final C0129u f1151f = new C0129u() { // from class: android.support.v7.view.h.1

        /* JADX INFO: renamed from: b */
        private boolean f1153b = false;

        /* JADX INFO: renamed from: c */
        private int f1154c = 0;

        /* JADX INFO: renamed from: a */
        void m1444a() {
            this.f1154c = 0;
            this.f1153b = false;
            C0185h.this.m1442b();
        }

        @Override // android.support.v4.p015g.C0129u, android.support.v4.p015g.InterfaceC0128t
        /* JADX INFO: renamed from: a */
        public void mo1026a(View view) {
            if (this.f1153b) {
                return;
            }
            this.f1153b = true;
            if (C0185h.this.f1147b != null) {
                C0185h.this.f1147b.mo1026a(null);
            }
        }

        @Override // android.support.v4.p015g.C0129u, android.support.v4.p015g.InterfaceC0128t
        /* JADX INFO: renamed from: b */
        public void mo1027b(View view) {
            int i = this.f1154c + 1;
            this.f1154c = i;
            if (i == C0185h.this.f1146a.size()) {
                if (C0185h.this.f1147b != null) {
                    C0185h.this.f1147b.mo1027b(null);
                }
                m1444a();
            }
        }
    };

    /* JADX INFO: renamed from: a */
    final ArrayList<C0127s> f1146a = new ArrayList<>();

    /* JADX INFO: renamed from: a */
    public C0185h m1436a(long j) {
        if (!this.f1150e) {
            this.f1148c = j;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0185h m1437a(C0127s c0127s) {
        if (!this.f1150e) {
            this.f1146a.add(c0127s);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0185h m1438a(C0127s c0127s, C0127s c0127s2) {
        this.f1146a.add(c0127s);
        c0127s2.m1023b(c0127s.m1016a());
        this.f1146a.add(c0127s2);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0185h m1439a(InterfaceC0128t interfaceC0128t) {
        if (!this.f1150e) {
            this.f1147b = interfaceC0128t;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0185h m1440a(Interpolator interpolator) {
        if (!this.f1150e) {
            this.f1149d = interpolator;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m1441a() {
        if (this.f1150e) {
            return;
        }
        for (C0127s c0127s : this.f1146a) {
            if (this.f1148c >= 0) {
                c0127s.m1018a(this.f1148c);
            }
            if (this.f1149d != null) {
                c0127s.m1021a(this.f1149d);
            }
            if (this.f1147b != null) {
                c0127s.m1019a(this.f1151f);
            }
            c0127s.m1025c();
        }
        this.f1150e = true;
    }

    /* JADX INFO: renamed from: b */
    void m1442b() {
        this.f1150e = false;
    }

    /* JADX INFO: renamed from: c */
    public void m1443c() {
        if (this.f1150e) {
            Iterator<C0127s> it = this.f1146a.iterator();
            while (it.hasNext()) {
                it.next().m1024b();
            }
            this.f1150e = false;
        }
    }
}
