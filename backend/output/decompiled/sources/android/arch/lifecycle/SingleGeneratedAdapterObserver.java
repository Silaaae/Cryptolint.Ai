package android.arch.lifecycle;

import android.arch.lifecycle.AbstractC0009c;

/* JADX INFO: loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0008b f40a;

    SingleGeneratedAdapterObserver(InterfaceC0008b interfaceC0008b) {
        this.f40a = interfaceC0008b;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* JADX INFO: renamed from: a */
    public void mo22a(InterfaceC0011e interfaceC0011e, AbstractC0009c.a aVar) {
        this.f40a.m53a(interfaceC0011e, aVar, false, null);
        this.f40a.m53a(interfaceC0011e, aVar, true, null);
    }
}
