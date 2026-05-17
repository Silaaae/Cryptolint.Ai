package android.arch.lifecycle;

import android.arch.lifecycle.AbstractC0009c;

/* JADX INFO: loaded from: classes.dex */
class FullLifecycleObserverAdapter implements GenericLifecycleObserver {

    /* JADX INFO: renamed from: a */
    private final FullLifecycleObserver f23a;

    FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.f23a = fullLifecycleObserver;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* JADX INFO: renamed from: a */
    public void mo22a(InterfaceC0011e interfaceC0011e, AbstractC0009c.a aVar) {
        switch (aVar) {
            case ON_CREATE:
                this.f23a.m23a(interfaceC0011e);
                return;
            case ON_START:
                this.f23a.m24b(interfaceC0011e);
                return;
            case ON_RESUME:
                this.f23a.m25c(interfaceC0011e);
                return;
            case ON_PAUSE:
                this.f23a.m26d(interfaceC0011e);
                return;
            case ON_STOP:
                this.f23a.m27e(interfaceC0011e);
                return;
            case ON_DESTROY:
                this.f23a.m28f(interfaceC0011e);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
