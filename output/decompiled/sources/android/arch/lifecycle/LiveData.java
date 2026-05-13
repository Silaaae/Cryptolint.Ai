package android.arch.lifecycle;

import android.arch.lifecycle.AbstractC0009c;
import android.arch.p000a.p001a.C0000a;
import android.arch.p000a.p002b.C0004b;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {

    /* JADX INFO: renamed from: a */
    private static final Object f25a = new Object();

    /* JADX INFO: renamed from: b */
    private C0004b<InterfaceC0017k<T>, LiveData<T>.AbstractC0006a> f26b;

    /* JADX INFO: renamed from: c */
    private int f27c;

    /* JADX INFO: renamed from: d */
    private volatile Object f28d;

    /* JADX INFO: renamed from: e */
    private int f29e;

    /* JADX INFO: renamed from: f */
    private boolean f30f;

    /* JADX INFO: renamed from: g */
    private boolean f31g;

    class LifecycleBoundObserver extends LiveData<T>.AbstractC0006a implements GenericLifecycleObserver {

        /* JADX INFO: renamed from: a */
        final InterfaceC0011e f32a;

        LifecycleBoundObserver(InterfaceC0011e interfaceC0011e, InterfaceC0017k<T> interfaceC0017k) {
            super(interfaceC0017k);
            this.f32a = interfaceC0011e;
        }

        @Override // android.arch.lifecycle.GenericLifecycleObserver
        /* JADX INFO: renamed from: a */
        public void mo22a(InterfaceC0011e interfaceC0011e, AbstractC0009c.a aVar) {
            if (this.f32a.mo58a().mo54a() == AbstractC0009c.b.DESTROYED) {
                LiveData.this.mo37a(this.f34c);
            } else {
                m44a(mo41a());
            }
        }

        @Override // android.arch.lifecycle.LiveData.AbstractC0006a
        /* JADX INFO: renamed from: a */
        boolean mo41a() {
            return this.f32a.mo58a().mo54a().m57a(AbstractC0009c.b.STARTED);
        }

        @Override // android.arch.lifecycle.LiveData.AbstractC0006a
        /* JADX INFO: renamed from: a */
        boolean mo42a(InterfaceC0011e interfaceC0011e) {
            return this.f32a == interfaceC0011e;
        }

        @Override // android.arch.lifecycle.LiveData.AbstractC0006a
        /* JADX INFO: renamed from: b */
        void mo43b() {
            this.f32a.mo58a().mo56b(this);
        }
    }

    /* JADX INFO: renamed from: android.arch.lifecycle.LiveData$a */
    private abstract class AbstractC0006a {

        /* JADX INFO: renamed from: c */
        final InterfaceC0017k<T> f34c;

        /* JADX INFO: renamed from: d */
        boolean f35d;

        /* JADX INFO: renamed from: e */
        int f36e = -1;

        AbstractC0006a(InterfaceC0017k<T> interfaceC0017k) {
            this.f34c = interfaceC0017k;
        }

        /* JADX INFO: renamed from: a */
        void m44a(boolean z) {
            if (z == this.f35d) {
                return;
            }
            this.f35d = z;
            boolean z2 = LiveData.this.f27c == 0;
            LiveData.this.f27c += this.f35d ? 1 : -1;
            if (z2 && this.f35d) {
                LiveData.this.mo38b();
            }
            if (LiveData.this.f27c == 0 && !this.f35d) {
                LiveData.this.mo39c();
            }
            if (this.f35d) {
                LiveData.this.m34b(this);
            }
        }

        /* JADX INFO: renamed from: a */
        abstract boolean mo41a();

        /* JADX INFO: renamed from: a */
        boolean mo42a(InterfaceC0011e interfaceC0011e) {
            return false;
        }

        /* JADX INFO: renamed from: b */
        void mo43b() {
        }
    }

    /* JADX INFO: renamed from: a */
    private void m31a(LiveData<T>.AbstractC0006a abstractC0006a) {
        if (abstractC0006a.f35d) {
            if (!abstractC0006a.mo41a()) {
                abstractC0006a.m44a(false);
            } else {
                if (abstractC0006a.f36e >= this.f29e) {
                    return;
                }
                abstractC0006a.f36e = this.f29e;
                abstractC0006a.f34c.mo82a((T) this.f28d);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m33a(String str) {
        if (C0000a.m0a().mo3b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m34b(LiveData<T>.AbstractC0006a abstractC0006a) {
        if (this.f30f) {
            this.f31g = true;
            return;
        }
        this.f30f = true;
        do {
            this.f31g = false;
            if (abstractC0006a != null) {
                m31a(abstractC0006a);
                abstractC0006a = null;
            } else {
                C0004b<InterfaceC0017k<T>, LiveData<T>.AbstractC0006a>.d dVarM13c = this.f26b.m13c();
                while (dVarM13c.hasNext()) {
                    m31a((AbstractC0006a) dVarM13c.next().getValue());
                    if (this.f31g) {
                        break;
                    }
                }
            }
        } while (this.f31g);
        this.f30f = false;
    }

    /* JADX INFO: renamed from: a */
    public T m35a() {
        T t = (T) this.f28d;
        if (t != f25a) {
            return t;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m36a(InterfaceC0011e interfaceC0011e, InterfaceC0017k<T> interfaceC0017k) {
        if (interfaceC0011e.mo58a().mo54a() == AbstractC0009c.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(interfaceC0011e, interfaceC0017k);
        LiveData<T>.AbstractC0006a abstractC0006aMo5a = this.f26b.mo5a(interfaceC0017k, lifecycleBoundObserver);
        if (abstractC0006aMo5a != null && !abstractC0006aMo5a.mo42a(interfaceC0011e)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (abstractC0006aMo5a != null) {
            return;
        }
        interfaceC0011e.mo58a().mo55a(lifecycleBoundObserver);
    }

    /* JADX INFO: renamed from: a */
    public void mo37a(InterfaceC0017k<T> interfaceC0017k) {
        m33a("removeObserver");
        LiveData<T>.AbstractC0006a abstractC0006aMo6b = this.f26b.mo6b(interfaceC0017k);
        if (abstractC0006aMo6b == null) {
            return;
        }
        abstractC0006aMo6b.mo43b();
        abstractC0006aMo6b.m44a(false);
    }

    /* JADX INFO: renamed from: b */
    protected void mo38b() {
    }

    /* JADX INFO: renamed from: c */
    protected void mo39c() {
    }

    /* JADX INFO: renamed from: d */
    public boolean m40d() {
        return this.f27c > 0;
    }
}
