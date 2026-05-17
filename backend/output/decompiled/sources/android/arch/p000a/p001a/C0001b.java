package android.arch.p000a.p001a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: renamed from: android.arch.a.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0001b extends AbstractC0002c {

    /* JADX INFO: renamed from: a */
    private final Object f5a = new Object();

    /* JADX INFO: renamed from: b */
    private ExecutorService f6b = Executors.newFixedThreadPool(2);

    /* JADX INFO: renamed from: c */
    private volatile Handler f7c;

    @Override // android.arch.p000a.p001a.AbstractC0002c
    /* JADX INFO: renamed from: a */
    public void mo1a(Runnable runnable) {
        this.f6b.execute(runnable);
    }

    @Override // android.arch.p000a.p001a.AbstractC0002c
    /* JADX INFO: renamed from: b */
    public void mo2b(Runnable runnable) {
        if (this.f7c == null) {
            synchronized (this.f5a) {
                if (this.f7c == null) {
                    this.f7c = new Handler(Looper.getMainLooper());
                }
            }
        }
        this.f7c.post(runnable);
    }

    @Override // android.arch.p000a.p001a.AbstractC0002c
    /* JADX INFO: renamed from: b */
    public boolean mo3b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
