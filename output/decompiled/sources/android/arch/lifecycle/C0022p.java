package android.arch.lifecycle;

import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: renamed from: android.arch.lifecycle.p */
/* JADX INFO: loaded from: classes.dex */
public class C0022p {

    /* JADX INFO: renamed from: a */
    private final HashMap<String, AbstractC0020n> f69a = new HashMap<>();

    /* JADX INFO: renamed from: a */
    public final void m93a() {
        Iterator<AbstractC0020n> it = this.f69a.values().iterator();
        while (it.hasNext()) {
            it.next().mo92a();
        }
        this.f69a.clear();
    }
}
