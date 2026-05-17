package android.arch.lifecycle;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.arch.lifecycle.AbstractC0009c;
import android.content.ComponentCallbacks2;
import android.os.Bundle;

/* JADX INFO: renamed from: android.arch.lifecycle.m */
/* JADX INFO: loaded from: classes.dex */
public class FragmentC0019m extends Fragment {

    /* JADX INFO: renamed from: a */
    private a f68a;

    /* JADX INFO: renamed from: android.arch.lifecycle.m$a */
    interface a {
        /* JADX INFO: renamed from: a */
        void m89a();

        /* JADX INFO: renamed from: b */
        void m90b();

        /* JADX INFO: renamed from: c */
        void m91c();
    }

    /* JADX INFO: renamed from: a */
    public static void m84a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new FragmentC0019m(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m85a(AbstractC0009c.a aVar) {
        ComponentCallbacks2 activity = getActivity();
        if (activity instanceof InterfaceC0013g) {
            ((InterfaceC0013g) activity).m74b().m71a(aVar);
        } else if (activity instanceof InterfaceC0011e) {
            AbstractC0009c abstractC0009cMo58a = ((InterfaceC0011e) activity).mo58a();
            if (abstractC0009cMo58a instanceof C0012f) {
                ((C0012f) abstractC0009cMo58a).m71a(aVar);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m86a(a aVar) {
        if (aVar != null) {
            aVar.m89a();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m87b(a aVar) {
        if (aVar != null) {
            aVar.m90b();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m88c(a aVar) {
        if (aVar != null) {
            aVar.m91c();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m86a(this.f68a);
        m85a(AbstractC0009c.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m85a(AbstractC0009c.a.ON_DESTROY);
        this.f68a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        m85a(AbstractC0009c.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m88c(this.f68a);
        m85a(AbstractC0009c.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        m87b(this.f68a);
        m85a(AbstractC0009c.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        m85a(AbstractC0009c.a.ON_STOP);
    }
}
