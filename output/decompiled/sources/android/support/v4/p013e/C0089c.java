package android.support.v4.p013e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: android.support.v4.e.c */
/* JADX INFO: loaded from: classes.dex */
public class C0089c {

    /* JADX INFO: renamed from: b */
    private HandlerThread f555b;

    /* JADX INFO: renamed from: c */
    private Handler f556c;

    /* JADX INFO: renamed from: f */
    private final int f559f;

    /* JADX INFO: renamed from: g */
    private final int f560g;

    /* JADX INFO: renamed from: h */
    private final String f561h;

    /* JADX INFO: renamed from: a */
    private final Object f554a = new Object();

    /* JADX INFO: renamed from: e */
    private Handler.Callback f558e = new Handler.Callback() { // from class: android.support.v4.e.c.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    C0089c.this.m750a();
                    break;
                case 1:
                    C0089c.this.m754b((Runnable) message.obj);
                    break;
            }
            return true;
        }
    };

    /* JADX INFO: renamed from: d */
    private int f557d = 0;

    /* JADX INFO: renamed from: android.support.v4.e.c$a */
    public interface a<T> {
        /* JADX INFO: renamed from: a */
        void mo741a(T t);
    }

    public C0089c(String str, int i, int i2) {
        this.f561h = str;
        this.f560g = i;
        this.f559f = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m750a() {
        synchronized (this.f554a) {
            if (this.f556c.hasMessages(1)) {
                return;
            }
            this.f555b.quit();
            this.f555b = null;
            this.f556c = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m753a(Runnable runnable) {
        synchronized (this.f554a) {
            if (this.f555b == null) {
                this.f555b = new HandlerThread(this.f561h, this.f560g);
                this.f555b.start();
                this.f556c = new Handler(this.f555b.getLooper(), this.f558e);
                this.f557d++;
            }
            this.f556c.removeMessages(0);
            this.f556c.sendMessage(this.f556c.obtainMessage(1, runnable));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m754b(Runnable runnable) {
        runnable.run();
        synchronized (this.f554a) {
            this.f556c.removeMessages(0);
            this.f556c.sendMessageDelayed(this.f556c.obtainMessage(0), this.f559f);
        }
    }

    /* JADX INFO: renamed from: a */
    public <T> T m755a(final Callable<T> callable, int i) throws InterruptedException {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition conditionNewCondition = reentrantLock.newCondition();
        final AtomicReference atomicReference = new AtomicReference();
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        m753a(new Runnable() { // from class: android.support.v4.e.c.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    atomicReference.set(callable.call());
                } catch (Exception unused) {
                }
                reentrantLock.lock();
                try {
                    atomicBoolean.set(false);
                    conditionNewCondition.signal();
                } finally {
                    reentrantLock.unlock();
                }
            }
        });
        reentrantLock.lock();
        try {
            if (!atomicBoolean.get()) {
                return (T) atomicReference.get();
            }
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            do {
                try {
                    nanos = conditionNewCondition.awaitNanos(nanos);
                } catch (InterruptedException unused) {
                }
                if (!atomicBoolean.get()) {
                    return (T) atomicReference.get();
                }
            } while (nanos > 0);
            throw new InterruptedException("timeout");
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: renamed from: a */
    public <T> void m756a(final Callable<T> callable, final a<T> aVar) {
        final Handler handler = new Handler();
        m753a(new Runnable() { // from class: android.support.v4.e.c.2
            @Override // java.lang.Runnable
            public void run() {
                final Object objCall;
                try {
                    objCall = callable.call();
                } catch (Exception unused) {
                    objCall = null;
                }
                handler.post(new Runnable() { // from class: android.support.v4.e.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        aVar.mo741a(objCall);
                    }
                });
            }
        });
    }
}
