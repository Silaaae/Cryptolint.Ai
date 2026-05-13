package android.arch.lifecycle;

import android.arch.lifecycle.AbstractC0009c;
import android.arch.p000a.p002b.C0003a;
import android.arch.p000a.p002b.C0004b;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: android.arch.lifecycle.f */
/* JADX INFO: loaded from: classes.dex */
public class C0012f extends AbstractC0009c {

    /* JADX INFO: renamed from: c */
    private final WeakReference<InterfaceC0011e> f56c;

    /* JADX INFO: renamed from: a */
    private C0003a<InterfaceC0010d, a> f54a = new C0003a<>();

    /* JADX INFO: renamed from: d */
    private int f57d = 0;

    /* JADX INFO: renamed from: e */
    private boolean f58e = false;

    /* JADX INFO: renamed from: f */
    private boolean f59f = false;

    /* JADX INFO: renamed from: g */
    private ArrayList<AbstractC0009c.b> f60g = new ArrayList<>();

    /* JADX INFO: renamed from: b */
    private AbstractC0009c.b f55b = AbstractC0009c.b.INITIALIZED;

    /* JADX INFO: renamed from: android.arch.lifecycle.f$a */
    static class a {

        /* JADX INFO: renamed from: a */
        AbstractC0009c.b f63a;

        /* JADX INFO: renamed from: b */
        GenericLifecycleObserver f64b;

        a(InterfaceC0010d interfaceC0010d, AbstractC0009c.b bVar) {
            this.f64b = C0014h.m75a(interfaceC0010d);
            this.f63a = bVar;
        }

        /* JADX INFO: renamed from: a */
        void m73a(InterfaceC0011e interfaceC0011e, AbstractC0009c.a aVar) {
            AbstractC0009c.b bVarM61b = C0012f.m61b(aVar);
            this.f63a = C0012f.m59a(this.f63a, bVarM61b);
            this.f64b.mo22a(interfaceC0011e, aVar);
            this.f63a = bVarM61b;
        }
    }

    public C0012f(InterfaceC0011e interfaceC0011e) {
        this.f56c = new WeakReference<>(interfaceC0011e);
    }

    /* JADX INFO: renamed from: a */
    static AbstractC0009c.b m59a(AbstractC0009c.b bVar, AbstractC0009c.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    /* JADX INFO: renamed from: a */
    private void m60a(InterfaceC0011e interfaceC0011e) {
        C0004b<InterfaceC0010d, a>.d dVarC = this.f54a.m13c();
        while (dVarC.hasNext() && !this.f59f) {
            Map.Entry next = dVarC.next();
            a aVar = (a) next.getValue();
            while (aVar.f63a.compareTo(this.f55b) < 0 && !this.f59f && this.f54a.m7c((InterfaceC0010d) next.getKey())) {
                m67c(aVar.f63a);
                aVar.m73a(interfaceC0011e, m70e(aVar.f63a));
                m66c();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    static AbstractC0009c.b m61b(AbstractC0009c.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return AbstractC0009c.b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return AbstractC0009c.b.STARTED;
            case ON_RESUME:
                return AbstractC0009c.b.RESUMED;
            case ON_DESTROY:
                return AbstractC0009c.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m62b(AbstractC0009c.b bVar) {
        if (this.f55b == bVar) {
            return;
        }
        this.f55b = bVar;
        if (this.f58e || this.f57d != 0) {
            this.f59f = true;
            return;
        }
        this.f58e = true;
        m69d();
        this.f58e = false;
    }

    /* JADX INFO: renamed from: b */
    private void m63b(InterfaceC0011e interfaceC0011e) {
        Iterator<Map.Entry<InterfaceC0010d, a>> itB = this.f54a.m12b();
        while (itB.hasNext() && !this.f59f) {
            Map.Entry<InterfaceC0010d, a> next = itB.next();
            a value = next.getValue();
            while (value.f63a.compareTo(this.f55b) > 0 && !this.f59f && this.f54a.m7c(next.getKey())) {
                AbstractC0009c.a aVarM68d = m68d(value.f63a);
                m67c(m61b(aVarM68d));
                value.m73a(interfaceC0011e, aVarM68d);
                m66c();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m64b() {
        if (this.f54a.m10a() == 0) {
            return true;
        }
        AbstractC0009c.b bVar = this.f54a.m14d().getValue().f63a;
        AbstractC0009c.b bVar2 = this.f54a.m15e().getValue().f63a;
        return bVar == bVar2 && this.f55b == bVar2;
    }

    /* JADX INFO: renamed from: c */
    private AbstractC0009c.b m65c(InterfaceC0010d interfaceC0010d) {
        Map.Entry<InterfaceC0010d, a> entryM8d = this.f54a.m8d(interfaceC0010d);
        return m59a(m59a(this.f55b, entryM8d != null ? entryM8d.getValue().f63a : null), this.f60g.isEmpty() ? null : this.f60g.get(this.f60g.size() - 1));
    }

    /* JADX INFO: renamed from: c */
    private void m66c() {
        this.f60g.remove(this.f60g.size() - 1);
    }

    /* JADX INFO: renamed from: c */
    private void m67c(AbstractC0009c.b bVar) {
        this.f60g.add(bVar);
    }

    /* JADX INFO: renamed from: d */
    private static AbstractC0009c.a m68d(AbstractC0009c.b bVar) {
        switch (bVar) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return AbstractC0009c.a.ON_DESTROY;
            case STARTED:
                return AbstractC0009c.a.ON_STOP;
            case RESUMED:
                return AbstractC0009c.a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m69d() {
        InterfaceC0011e interfaceC0011e = this.f56c.get();
        if (interfaceC0011e == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!m64b()) {
            this.f59f = false;
            if (this.f55b.compareTo(this.f54a.m14d().getValue().f63a) < 0) {
                m63b(interfaceC0011e);
            }
            Map.Entry<InterfaceC0010d, a> entryE = this.f54a.m15e();
            if (!this.f59f && entryE != null && this.f55b.compareTo(entryE.getValue().f63a) > 0) {
                m60a(interfaceC0011e);
            }
        }
        this.f59f = false;
    }

    /* JADX INFO: renamed from: e */
    private static AbstractC0009c.a m70e(AbstractC0009c.b bVar) {
        switch (bVar) {
            case INITIALIZED:
            case DESTROYED:
                return AbstractC0009c.a.ON_CREATE;
            case CREATED:
                return AbstractC0009c.a.ON_START;
            case STARTED:
                return AbstractC0009c.a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    @Override // android.arch.lifecycle.AbstractC0009c
    /* JADX INFO: renamed from: a */
    public AbstractC0009c.b mo54a() {
        return this.f55b;
    }

    /* JADX INFO: renamed from: a */
    public void m71a(AbstractC0009c.a aVar) {
        m62b(m61b(aVar));
    }

    /* JADX INFO: renamed from: a */
    public void m72a(AbstractC0009c.b bVar) {
        m62b(bVar);
    }

    @Override // android.arch.lifecycle.AbstractC0009c
    /* JADX INFO: renamed from: a */
    public void mo55a(InterfaceC0010d interfaceC0010d) {
        InterfaceC0011e interfaceC0011e;
        a aVar = new a(interfaceC0010d, this.f55b == AbstractC0009c.b.DESTROYED ? AbstractC0009c.b.DESTROYED : AbstractC0009c.b.INITIALIZED);
        if (this.f54a.mo5a(interfaceC0010d, aVar) == null && (interfaceC0011e = this.f56c.get()) != null) {
            boolean z = this.f57d != 0 || this.f58e;
            AbstractC0009c.b bVarM65c = m65c(interfaceC0010d);
            this.f57d++;
            while (aVar.f63a.compareTo(bVarM65c) < 0 && this.f54a.m7c(interfaceC0010d)) {
                m67c(aVar.f63a);
                aVar.m73a(interfaceC0011e, m70e(aVar.f63a));
                m66c();
                bVarM65c = m65c(interfaceC0010d);
            }
            if (!z) {
                m69d();
            }
            this.f57d--;
        }
    }

    @Override // android.arch.lifecycle.AbstractC0009c
    /* JADX INFO: renamed from: b */
    public void mo56b(InterfaceC0010d interfaceC0010d) {
        this.f54a.mo6b(interfaceC0010d);
    }
}
