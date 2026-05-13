package android.arch.lifecycle;

import android.arch.lifecycle.AbstractC0009c;

/* JADX INFO: loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {

    /* JADX INFO: renamed from: a */
    private final InterfaceC0008b[] f22a;

    CompositeGeneratedAdaptersObserver(InterfaceC0008b[] interfaceC0008bArr) {
        this.f22a = interfaceC0008bArr;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* JADX INFO: renamed from: a */
    public void mo22a(InterfaceC0011e interfaceC0011e, AbstractC0009c.a aVar) {
        C0015i c0015i = new C0015i();
        for (InterfaceC0008b interfaceC0008b : this.f22a) {
            interfaceC0008b.m53a(interfaceC0011e, aVar, false, c0015i);
        }
        for (InterfaceC0008b interfaceC0008b2 : this.f22a) {
            interfaceC0008b2.m53a(interfaceC0011e, aVar, true, c0015i);
        }
    }
}
