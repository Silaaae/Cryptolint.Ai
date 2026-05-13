package android.arch.lifecycle;

import android.arch.lifecycle.AbstractC0009c;
import android.arch.lifecycle.C0007a;

/* JADX INFO: loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {

    /* JADX INFO: renamed from: a */
    private final Object f38a;

    /* JADX INFO: renamed from: b */
    private final C0007a.a f39b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f38a = obj;
        this.f39b = C0007a.f41a.m49b(this.f38a.getClass());
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* JADX INFO: renamed from: a */
    public void mo22a(InterfaceC0011e interfaceC0011e, AbstractC0009c.a aVar) {
        this.f39b.m51a(interfaceC0011e, aVar, this.f38a);
    }
}
