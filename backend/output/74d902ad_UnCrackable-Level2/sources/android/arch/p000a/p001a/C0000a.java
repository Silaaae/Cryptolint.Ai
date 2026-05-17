package android.arch.p000a.p001a;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: android.arch.a.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0000a extends AbstractC0002c {

    /* JADX INFO: renamed from: a */
    private static volatile C0000a f0a;

    /* JADX INFO: renamed from: d */
    private static final Executor f1d = new Executor() { // from class: android.arch.a.a.a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            C0000a.m0a().mo2b(runnable);
        }
    };

    /* JADX INFO: renamed from: e */
    private static final Executor f2e = new Executor() { // from class: android.arch.a.a.a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            C0000a.m0a().mo1a(runnable);
        }
    };

    /* JADX INFO: renamed from: c */
    private AbstractC0002c f4c = new C0001b();

    /* JADX INFO: renamed from: b */
    private AbstractC0002c f3b = this.f4c;

    private C0000a() {
    }

    /* JADX INFO: renamed from: a */
    public static C0000a m0a() {
        if (f0a != null) {
            return f0a;
        }
        synchronized (C0000a.class) {
            if (f0a == null) {
                f0a = new C0000a();
            }
        }
        return f0a;
    }

    @Override // android.arch.p000a.p001a.AbstractC0002c
    /* JADX INFO: renamed from: a */
    public void mo1a(Runnable runnable) {
        this.f3b.mo1a(runnable);
    }

    @Override // android.arch.p000a.p001a.AbstractC0002c
    /* JADX INFO: renamed from: b */
    public void mo2b(Runnable runnable) {
        this.f3b.mo2b(runnable);
    }

    @Override // android.arch.p000a.p001a.AbstractC0002c
    /* JADX INFO: renamed from: b */
    public boolean mo3b() {
        return this.f3b.mo3b();
    }
}
