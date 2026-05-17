package android.arch.lifecycle;

/* JADX INFO: renamed from: android.arch.lifecycle.c */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0009c {

    /* JADX INFO: renamed from: android.arch.lifecycle.c$a */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY
    }

    /* JADX INFO: renamed from: android.arch.lifecycle.c$b */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        /* JADX INFO: renamed from: a */
        public boolean m57a(b bVar) {
            return compareTo(bVar) >= 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract b mo54a();

    /* JADX INFO: renamed from: a */
    public abstract void mo55a(InterfaceC0010d interfaceC0010d);

    /* JADX INFO: renamed from: b */
    public abstract void mo56b(InterfaceC0010d interfaceC0010d);
}
