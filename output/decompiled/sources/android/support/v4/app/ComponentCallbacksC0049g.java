package android.support.v4.app;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.AbstractC0009c;
import android.arch.lifecycle.C0012f;
import android.arch.lifecycle.C0022p;
import android.arch.lifecycle.InterfaceC0011e;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.p014f.C0093d;
import android.support.v4.p014f.C0100k;
import android.support.v4.p015g.C0113e;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: renamed from: android.support.v4.app.g */
/* JADX INFO: loaded from: classes.dex */
public class ComponentCallbacksC0049g implements InterfaceC0011e, ComponentCallbacks, View.OnCreateContextMenuListener {

    /* JADX INFO: renamed from: V */
    private static final C0100k<String, Class<?>> f248V = new C0100k<>();

    /* JADX INFO: renamed from: a */
    static final Object f249a = new Object();

    /* JADX INFO: renamed from: A */
    String f250A;

    /* JADX INFO: renamed from: B */
    boolean f251B;

    /* JADX INFO: renamed from: C */
    boolean f252C;

    /* JADX INFO: renamed from: D */
    boolean f253D;

    /* JADX INFO: renamed from: E */
    boolean f254E;

    /* JADX INFO: renamed from: F */
    boolean f255F;

    /* JADX INFO: renamed from: H */
    boolean f257H;

    /* JADX INFO: renamed from: I */
    ViewGroup f258I;

    /* JADX INFO: renamed from: J */
    View f259J;

    /* JADX INFO: renamed from: K */
    View f260K;

    /* JADX INFO: renamed from: L */
    boolean f261L;

    /* JADX INFO: renamed from: N */
    LoaderManagerImpl f263N;

    /* JADX INFO: renamed from: O */
    a f264O;

    /* JADX INFO: renamed from: P */
    boolean f265P;

    /* JADX INFO: renamed from: Q */
    boolean f266Q;

    /* JADX INFO: renamed from: R */
    float f267R;

    /* JADX INFO: renamed from: S */
    LayoutInflater f268S;

    /* JADX INFO: renamed from: T */
    boolean f269T;

    /* JADX INFO: renamed from: c */
    Bundle f272c;

    /* JADX INFO: renamed from: d */
    SparseArray<Parcelable> f273d;

    /* JADX INFO: renamed from: e */
    Boolean f274e;

    /* JADX INFO: renamed from: g */
    String f276g;

    /* JADX INFO: renamed from: h */
    Bundle f277h;

    /* JADX INFO: renamed from: i */
    ComponentCallbacksC0049g f278i;

    /* JADX INFO: renamed from: k */
    int f280k;

    /* JADX INFO: renamed from: l */
    boolean f281l;

    /* JADX INFO: renamed from: m */
    boolean f282m;

    /* JADX INFO: renamed from: n */
    boolean f283n;

    /* JADX INFO: renamed from: o */
    boolean f284o;

    /* JADX INFO: renamed from: p */
    boolean f285p;

    /* JADX INFO: renamed from: q */
    boolean f286q;

    /* JADX INFO: renamed from: r */
    int f287r;

    /* JADX INFO: renamed from: s */
    LayoutInflaterFactory2C0055m f288s;

    /* JADX INFO: renamed from: t */
    AbstractC0053k f289t;

    /* JADX INFO: renamed from: u */
    LayoutInflaterFactory2C0055m f290u;

    /* JADX INFO: renamed from: v */
    C0056n f291v;

    /* JADX INFO: renamed from: w */
    C0022p f292w;

    /* JADX INFO: renamed from: x */
    ComponentCallbacksC0049g f293x;

    /* JADX INFO: renamed from: y */
    int f294y;

    /* JADX INFO: renamed from: z */
    int f295z;

    /* JADX INFO: renamed from: b */
    int f271b = 0;

    /* JADX INFO: renamed from: f */
    int f275f = -1;

    /* JADX INFO: renamed from: j */
    int f279j = -1;

    /* JADX INFO: renamed from: G */
    boolean f256G = true;

    /* JADX INFO: renamed from: M */
    boolean f262M = true;

    /* JADX INFO: renamed from: U */
    C0012f f270U = new C0012f(this);

    /* JADX INFO: renamed from: android.support.v4.app.g$a */
    static class a {

        /* JADX INFO: renamed from: a */
        View f298a;

        /* JADX INFO: renamed from: b */
        Animator f299b;

        /* JADX INFO: renamed from: c */
        int f300c;

        /* JADX INFO: renamed from: d */
        int f301d;

        /* JADX INFO: renamed from: e */
        int f302e;

        /* JADX INFO: renamed from: f */
        int f303f;

        /* JADX INFO: renamed from: i */
        boolean f306i;

        /* JADX INFO: renamed from: j */
        c f307j;

        /* JADX INFO: renamed from: k */
        boolean f308k;

        /* JADX INFO: renamed from: r */
        private Boolean f315r;

        /* JADX INFO: renamed from: s */
        private Boolean f316s;

        /* JADX INFO: renamed from: l */
        private Object f309l = null;

        /* JADX INFO: renamed from: m */
        private Object f310m = ComponentCallbacksC0049g.f249a;

        /* JADX INFO: renamed from: n */
        private Object f311n = null;

        /* JADX INFO: renamed from: o */
        private Object f312o = ComponentCallbacksC0049g.f249a;

        /* JADX INFO: renamed from: p */
        private Object f313p = null;

        /* JADX INFO: renamed from: q */
        private Object f314q = ComponentCallbacksC0049g.f249a;

        /* JADX INFO: renamed from: g */
        AbstractC0066x f304g = null;

        /* JADX INFO: renamed from: h */
        AbstractC0066x f305h = null;

        a() {
        }
    }

    /* JADX INFO: renamed from: android.support.v4.app.g$b */
    public static class b extends RuntimeException {
        public b(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.app.g$c */
    interface c {
        /* JADX INFO: renamed from: a */
        void mo377a();

        /* JADX INFO: renamed from: b */
        void mo378b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Y */
    public void m261Y() {
        c cVar;
        if (this.f264O == null) {
            cVar = null;
        } else {
            this.f264O.f306i = false;
            cVar = this.f264O.f307j;
            this.f264O.f307j = null;
        }
        if (cVar != null) {
            cVar.mo377a();
        }
    }

    /* JADX INFO: renamed from: Z */
    private a m262Z() {
        if (this.f264O == null) {
            this.f264O = new a();
        }
        return this.f264O;
    }

    /* JADX INFO: renamed from: a */
    public static ComponentCallbacksC0049g m263a(Context context, String str, Bundle bundle) {
        try {
            Class<?> clsLoadClass = f248V.get(str);
            if (clsLoadClass == null) {
                clsLoadClass = context.getClassLoader().loadClass(str);
                f248V.put(str, clsLoadClass);
            }
            ComponentCallbacksC0049g componentCallbacksC0049g = (ComponentCallbacksC0049g) clsLoadClass.getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(componentCallbacksC0049g.getClass().getClassLoader());
                componentCallbacksC0049g.m317b(bundle);
            }
            return componentCallbacksC0049g;
        } catch (ClassNotFoundException e) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (IllegalAccessException e2) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (InstantiationException e3) {
            throw new b("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e3);
        } catch (NoSuchMethodException e4) {
            throw new b("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e4);
        } catch (InvocationTargetException e5) {
            throw new b("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e5);
        }
    }

    /* JADX INFO: renamed from: a */
    static boolean m264a(Context context, String str) {
        try {
            Class<?> clsLoadClass = f248V.get(str);
            if (clsLoadClass == null) {
                clsLoadClass = context.getClassLoader().loadClass(str);
                f248V.put(str, clsLoadClass);
            }
            return ComponentCallbacksC0049g.class.isAssignableFrom(clsLoadClass);
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: A */
    public boolean m266A() {
        if (this.f264O == null || this.f264O.f316s == null) {
            return true;
        }
        return this.f264O.f316s.booleanValue();
    }

    /* JADX INFO: renamed from: B */
    public boolean m267B() {
        if (this.f264O == null || this.f264O.f315r == null) {
            return true;
        }
        return this.f264O.f315r.booleanValue();
    }

    /* JADX INFO: renamed from: C */
    public void m268C() {
        if (this.f288s == null || this.f288s.f362m == null) {
            m262Z().f306i = false;
        } else if (Looper.myLooper() != this.f288s.f362m.m425h().getLooper()) {
            this.f288s.f362m.m425h().postAtFrontOfQueue(new Runnable() { // from class: android.support.v4.app.g.1
                @Override // java.lang.Runnable
                public void run() {
                    ComponentCallbacksC0049g.this.m261Y();
                }
            });
        } else {
            m261Y();
        }
    }

    /* JADX INFO: renamed from: D */
    void m269D() {
        if (this.f289t == null) {
            throw new IllegalStateException("Fragment has not been attached yet.");
        }
        this.f290u = new LayoutInflaterFactory2C0055m();
        this.f290u.m494a(this.f289t, new AbstractC0051i() { // from class: android.support.v4.app.g.2
            @Override // android.support.v4.app.AbstractC0051i
            /* JADX INFO: renamed from: a */
            public ComponentCallbacksC0049g mo366a(Context context, String str, Bundle bundle) {
                return ComponentCallbacksC0049g.this.f289t.mo366a(context, str, bundle);
            }

            @Override // android.support.v4.app.AbstractC0051i
            /* JADX INFO: renamed from: a */
            public View mo367a(int i) {
                if (ComponentCallbacksC0049g.this.f259J != null) {
                    return ComponentCallbacksC0049g.this.f259J.findViewById(i);
                }
                throw new IllegalStateException("Fragment does not have a view");
            }

            @Override // android.support.v4.app.AbstractC0051i
            /* JADX INFO: renamed from: a */
            public boolean mo368a() {
                return ComponentCallbacksC0049g.this.f259J != null;
            }
        }, this);
    }

    /* JADX INFO: renamed from: E */
    void m270E() {
        if (this.f290u != null) {
            this.f290u.m534k();
            this.f290u.m520e();
        }
        this.f271b = 4;
        this.f257H = false;
        m349l();
        if (this.f257H) {
            if (this.f290u != null) {
                this.f290u.m541n();
            }
            this.f270U.m71a(AbstractC0009c.a.ON_START);
        } else {
            throw new C0067y("Fragment " + this + " did not call through to super.onStart()");
        }
    }

    /* JADX INFO: renamed from: F */
    void m271F() {
        if (this.f290u != null) {
            this.f290u.m534k();
            this.f290u.m520e();
        }
        this.f271b = 5;
        this.f257H = false;
        m351m();
        if (this.f257H) {
            if (this.f290u != null) {
                this.f290u.m542o();
                this.f290u.m520e();
            }
            this.f270U.m71a(AbstractC0009c.a.ON_RESUME);
            return;
        }
        throw new C0067y("Fragment " + this + " did not call through to super.onResume()");
    }

    /* JADX INFO: renamed from: G */
    void m272G() {
        if (this.f290u != null) {
            this.f290u.m534k();
        }
    }

    /* JADX INFO: renamed from: H */
    void m273H() {
        onLowMemory();
        if (this.f290u != null) {
            this.f290u.m549u();
        }
    }

    /* JADX INFO: renamed from: I */
    void m274I() {
        this.f270U.m71a(AbstractC0009c.a.ON_PAUSE);
        if (this.f290u != null) {
            this.f290u.m544p();
        }
        this.f271b = 4;
        this.f257H = false;
        m353n();
        if (this.f257H) {
            return;
        }
        throw new C0067y("Fragment " + this + " did not call through to super.onPause()");
    }

    /* JADX INFO: renamed from: J */
    void m275J() {
        this.f270U.m71a(AbstractC0009c.a.ON_STOP);
        if (this.f290u != null) {
            this.f290u.m545q();
        }
        this.f271b = 3;
        this.f257H = false;
        m354o();
        if (this.f257H) {
            return;
        }
        throw new C0067y("Fragment " + this + " did not call through to super.onStop()");
    }

    /* JADX INFO: renamed from: K */
    void m276K() {
        if (this.f290u != null) {
            this.f290u.m546r();
        }
        this.f271b = 2;
    }

    /* JADX INFO: renamed from: L */
    void m277L() {
        if (this.f290u != null) {
            this.f290u.m547s();
        }
        this.f271b = 1;
        this.f257H = false;
        m355p();
        if (this.f257H) {
            if (this.f263N != null) {
                this.f263N.m217a();
            }
            this.f286q = false;
        } else {
            throw new C0067y("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    /* JADX INFO: renamed from: M */
    void m278M() {
        this.f270U.m71a(AbstractC0009c.a.ON_DESTROY);
        if (this.f290u != null) {
            this.f290u.m548t();
        }
        this.f271b = 0;
        this.f257H = false;
        this.f269T = false;
        m356q();
        if (this.f257H) {
            this.f290u = null;
            return;
        }
        throw new C0067y("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* JADX INFO: renamed from: N */
    void m279N() {
        this.f257H = false;
        m358s();
        this.f268S = null;
        if (!this.f257H) {
            throw new C0067y("Fragment " + this + " did not call through to super.onDetach()");
        }
        if (this.f290u != null) {
            if (this.f254E) {
                this.f290u.m548t();
                this.f290u = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not  destroyed and this fragment is not retaining instance");
        }
    }

    /* JADX INFO: renamed from: O */
    int m280O() {
        if (this.f264O == null) {
            return 0;
        }
        return this.f264O.f301d;
    }

    /* JADX INFO: renamed from: P */
    int m281P() {
        if (this.f264O == null) {
            return 0;
        }
        return this.f264O.f302e;
    }

    /* JADX INFO: renamed from: Q */
    int m282Q() {
        if (this.f264O == null) {
            return 0;
        }
        return this.f264O.f303f;
    }

    /* JADX INFO: renamed from: R */
    AbstractC0066x m283R() {
        if (this.f264O == null) {
            return null;
        }
        return this.f264O.f304g;
    }

    /* JADX INFO: renamed from: S */
    AbstractC0066x m284S() {
        if (this.f264O == null) {
            return null;
        }
        return this.f264O.f305h;
    }

    /* JADX INFO: renamed from: T */
    View m285T() {
        if (this.f264O == null) {
            return null;
        }
        return this.f264O.f298a;
    }

    /* JADX INFO: renamed from: U */
    Animator m286U() {
        if (this.f264O == null) {
            return null;
        }
        return this.f264O.f299b;
    }

    /* JADX INFO: renamed from: V */
    int m287V() {
        if (this.f264O == null) {
            return 0;
        }
        return this.f264O.f300c;
    }

    /* JADX INFO: renamed from: W */
    boolean m288W() {
        if (this.f264O == null) {
            return false;
        }
        return this.f264O.f306i;
    }

    /* JADX INFO: renamed from: X */
    boolean m289X() {
        if (this.f264O == null) {
            return false;
        }
        return this.f264O.f308k;
    }

    @Override // android.arch.lifecycle.InterfaceC0011e
    /* JADX INFO: renamed from: a */
    public AbstractC0009c mo58a() {
        return this.f270U;
    }

    /* JADX INFO: renamed from: a */
    ComponentCallbacksC0049g m290a(String str) {
        if (str.equals(this.f276g)) {
            return this;
        }
        if (this.f290u != null) {
            return this.f290u.m502b(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public View m291a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public Animation m292a(int i, boolean z, int i2) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    void m293a(int i) {
        if (this.f264O == null && i == 0) {
            return;
        }
        m262Z().f301d = i;
    }

    /* JADX INFO: renamed from: a */
    void m294a(int i, int i2) {
        if (this.f264O == null && i == 0 && i2 == 0) {
            return;
        }
        m262Z();
        this.f264O.f302e = i;
        this.f264O.f303f = i2;
    }

    /* JADX INFO: renamed from: a */
    public void m295a(int i, int i2, Intent intent) {
    }

    /* JADX INFO: renamed from: a */
    final void m296a(int i, ComponentCallbacksC0049g componentCallbacksC0049g) {
        StringBuilder sb;
        String str;
        this.f275f = i;
        if (componentCallbacksC0049g != null) {
            sb = new StringBuilder();
            sb.append(componentCallbacksC0049g.f276g);
            str = ":";
        } else {
            sb = new StringBuilder();
            str = "android:fragment:";
        }
        sb.append(str);
        sb.append(this.f275f);
        this.f276g = sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public void m297a(int i, String[] strArr, int[] iArr) {
    }

    /* JADX INFO: renamed from: a */
    void m298a(Animator animator) {
        m262Z().f299b = animator;
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public void m299a(Activity activity) {
        this.f257H = true;
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public void m300a(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.f257H = true;
    }

    /* JADX INFO: renamed from: a */
    public void m301a(Context context) {
        this.f257H = true;
        Activity activityM423f = this.f289t == null ? null : this.f289t.m423f();
        if (activityM423f != null) {
            this.f257H = false;
            m299a(activityM423f);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m302a(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.f257H = true;
        Activity activityM423f = this.f289t == null ? null : this.f289t.m423f();
        if (activityM423f != null) {
            this.f257H = false;
            m300a(activityM423f, attributeSet, bundle);
        }
    }

    /* JADX INFO: renamed from: a */
    void m303a(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.f290u != null) {
            this.f290u.m484a(configuration);
        }
    }

    /* JADX INFO: renamed from: a */
    final void m304a(Bundle bundle) {
        if (this.f273d != null) {
            this.f260K.restoreHierarchyState(this.f273d);
            this.f273d = null;
        }
        this.f257H = false;
        m344i(bundle);
        if (this.f257H) {
            return;
        }
        throw new C0067y("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    /* JADX INFO: renamed from: a */
    void m305a(c cVar) {
        m262Z();
        if (cVar == this.f264O.f307j) {
            return;
        }
        if (cVar != null && this.f264O.f307j != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (this.f264O.f306i) {
            this.f264O.f307j = cVar;
        }
        if (cVar != null) {
            cVar.mo378b();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m306a(ComponentCallbacksC0049g componentCallbacksC0049g) {
    }

    /* JADX INFO: renamed from: a */
    public void m307a(Menu menu) {
    }

    /* JADX INFO: renamed from: a */
    public void m308a(Menu menu, MenuInflater menuInflater) {
    }

    /* JADX INFO: renamed from: a */
    void m309a(View view) {
        m262Z().f298a = view;
    }

    /* JADX INFO: renamed from: a */
    public void m310a(View view, Bundle bundle) {
    }

    /* JADX INFO: renamed from: a */
    public void m311a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.f294y));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.f295z));
        printWriter.print(" mTag=");
        printWriter.println(this.f250A);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f271b);
        printWriter.print(" mIndex=");
        printWriter.print(this.f275f);
        printWriter.print(" mWho=");
        printWriter.print(this.f276g);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f287r);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f281l);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f282m);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f283n);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f284o);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.f251B);
        printWriter.print(" mDetached=");
        printWriter.print(this.f252C);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.f256G);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.f255F);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.f253D);
        printWriter.print(" mRetaining=");
        printWriter.print(this.f254E);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.f262M);
        if (this.f288s != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f288s);
        }
        if (this.f289t != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f289t);
        }
        if (this.f293x != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.f293x);
        }
        if (this.f277h != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f277h);
        }
        if (this.f272c != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f272c);
        }
        if (this.f273d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f273d);
        }
        if (this.f278i != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.f278i);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f280k);
        }
        if (m280O() != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(m280O());
        }
        if (this.f258I != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.f258I);
        }
        if (this.f259J != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.f259J);
        }
        if (this.f260K != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.f259J);
        }
        if (m285T() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(m285T());
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(m287V());
        }
        if (this.f263N != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.f263N.mo218a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.f290u != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.f290u + ":");
            this.f290u.mo427a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m312a(boolean z) {
    }

    /* JADX INFO: renamed from: a */
    public boolean m313a(MenuItem menuItem) {
        return false;
    }

    /* JADX INFO: renamed from: b */
    public Animator m314b(int i, boolean z, int i2) {
        return null;
    }

    /* JADX INFO: renamed from: b */
    View m315b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f290u != null) {
            this.f290u.m534k();
        }
        this.f286q = true;
        return m291a(layoutInflater, viewGroup, bundle);
    }

    /* JADX INFO: renamed from: b */
    void m316b(int i) {
        m262Z().f300c = i;
    }

    /* JADX INFO: renamed from: b */
    public void m317b(Bundle bundle) {
        if (this.f275f >= 0 && m325c()) {
            throw new IllegalStateException("Fragment already active and state has been saved");
        }
        this.f277h = bundle;
    }

    /* JADX INFO: renamed from: b */
    public void m318b(Menu menu) {
    }

    /* JADX INFO: renamed from: b */
    public void m319b(boolean z) {
    }

    /* JADX INFO: renamed from: b */
    final boolean m320b() {
        return this.f287r > 0;
    }

    /* JADX INFO: renamed from: b */
    boolean m321b(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.f251B) {
            return false;
        }
        if (this.f255F && this.f256G) {
            z = true;
            m308a(menu, menuInflater);
        }
        return this.f290u != null ? z | this.f290u.m498a(menu, menuInflater) : z;
    }

    /* JADX INFO: renamed from: b */
    public boolean m322b(MenuItem menuItem) {
        return false;
    }

    /* JADX INFO: renamed from: c */
    public LayoutInflater m323c(Bundle bundle) {
        return m334e(bundle);
    }

    /* JADX INFO: renamed from: c */
    public void m324c(boolean z) {
    }

    /* JADX INFO: renamed from: c */
    public final boolean m325c() {
        if (this.f288s == null) {
            return false;
        }
        return this.f288s.mo430c();
    }

    /* JADX INFO: renamed from: c */
    boolean m326c(Menu menu) {
        boolean z = false;
        if (this.f251B) {
            return false;
        }
        if (this.f255F && this.f256G) {
            z = true;
            m307a(menu);
        }
        return this.f290u != null ? z | this.f290u.m497a(menu) : z;
    }

    /* JADX INFO: renamed from: c */
    boolean m327c(MenuItem menuItem) {
        if (this.f251B) {
            return false;
        }
        if (this.f255F && this.f256G && m313a(menuItem)) {
            return true;
        }
        return this.f290u != null && this.f290u.m499a(menuItem);
    }

    /* JADX INFO: renamed from: d */
    public Context m328d() {
        if (this.f289t == null) {
            return null;
        }
        return this.f289t.m424g();
    }

    /* JADX INFO: renamed from: d */
    LayoutInflater m329d(Bundle bundle) {
        this.f268S = m323c(bundle);
        return this.f268S;
    }

    /* JADX INFO: renamed from: d */
    void m330d(Menu menu) {
        if (this.f251B) {
            return;
        }
        if (this.f255F && this.f256G) {
            m318b(menu);
        }
        if (this.f290u != null) {
            this.f290u.m507b(menu);
        }
    }

    /* JADX INFO: renamed from: d */
    void m331d(boolean z) {
        m319b(z);
        if (this.f290u != null) {
            this.f290u.m495a(z);
        }
    }

    /* JADX INFO: renamed from: d */
    boolean m332d(MenuItem menuItem) {
        if (this.f251B) {
            return false;
        }
        if (m322b(menuItem)) {
            return true;
        }
        return this.f290u != null && this.f290u.m509b(menuItem);
    }

    /* JADX INFO: renamed from: e */
    public final Context m333e() {
        Context contextM328d = m328d();
        if (contextM328d != null) {
            return contextM328d;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @Deprecated
    /* JADX INFO: renamed from: e */
    public LayoutInflater m334e(Bundle bundle) {
        if (this.f289t == null) {
            throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
        }
        LayoutInflater layoutInflaterMo391b = this.f289t.mo391b();
        m343i();
        C0113e.m904b(layoutInflaterMo391b, this.f290u.m551w());
        return layoutInflaterMo391b;
    }

    /* JADX INFO: renamed from: e */
    void m335e(boolean z) {
        m324c(z);
        if (this.f290u != null) {
            this.f290u.m508b(z);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX INFO: renamed from: f */
    public final ActivityC0050h m336f() {
        if (this.f289t == null) {
            return null;
        }
        return (ActivityC0050h) this.f289t.m423f();
    }

    /* JADX INFO: renamed from: f */
    public void m337f(Bundle bundle) {
        this.f257H = true;
        m340g(bundle);
        if (this.f290u == null || this.f290u.m496a(1)) {
            return;
        }
        this.f290u.m536l();
    }

    /* JADX INFO: renamed from: f */
    void m338f(boolean z) {
        m262Z().f308k = z;
    }

    /* JADX INFO: renamed from: g */
    public final Resources m339g() {
        return m333e().getResources();
    }

    /* JADX INFO: renamed from: g */
    void m340g(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        if (this.f290u == null) {
            m269D();
        }
        this.f290u.m486a(parcelable, this.f291v);
        this.f291v = null;
        this.f290u.m536l();
    }

    /* JADX INFO: renamed from: h */
    public final AbstractC0054l m341h() {
        return this.f288s;
    }

    /* JADX INFO: renamed from: h */
    public void m342h(Bundle bundle) {
        this.f257H = true;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public final AbstractC0054l m343i() {
        if (this.f290u == null) {
            m269D();
            if (this.f271b >= 5) {
                this.f290u.m542o();
            } else if (this.f271b >= 4) {
                this.f290u.m541n();
            } else if (this.f271b >= 2) {
                this.f290u.m538m();
            } else if (this.f271b >= 1) {
                this.f290u.m536l();
            }
        }
        return this.f290u;
    }

    /* JADX INFO: renamed from: i */
    public void m344i(Bundle bundle) {
        this.f257H = true;
    }

    /* JADX INFO: renamed from: j */
    AbstractC0054l m345j() {
        return this.f290u;
    }

    /* JADX INFO: renamed from: j */
    public void m346j(Bundle bundle) {
    }

    /* JADX INFO: renamed from: k */
    public View m347k() {
        return this.f259J;
    }

    /* JADX INFO: renamed from: k */
    void m348k(Bundle bundle) {
        if (this.f290u != null) {
            this.f290u.m534k();
        }
        this.f271b = 1;
        this.f257H = false;
        m337f(bundle);
        this.f269T = true;
        if (this.f257H) {
            this.f270U.m71a(AbstractC0009c.a.ON_CREATE);
            return;
        }
        throw new C0067y("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* JADX INFO: renamed from: l */
    public void m349l() {
        this.f257H = true;
    }

    /* JADX INFO: renamed from: l */
    void m350l(Bundle bundle) {
        if (this.f290u != null) {
            this.f290u.m534k();
        }
        this.f271b = 2;
        this.f257H = false;
        m342h(bundle);
        if (this.f257H) {
            if (this.f290u != null) {
                this.f290u.m538m();
            }
        } else {
            throw new C0067y("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    /* JADX INFO: renamed from: m */
    public void m351m() {
        this.f257H = true;
    }

    /* JADX INFO: renamed from: m */
    void m352m(Bundle bundle) {
        Parcelable parcelableM532j;
        m346j(bundle);
        if (this.f290u == null || (parcelableM532j = this.f290u.m532j()) == null) {
            return;
        }
        bundle.putParcelable("android:support:fragments", parcelableM532j);
    }

    /* JADX INFO: renamed from: n */
    public void m353n() {
        this.f257H = true;
    }

    /* JADX INFO: renamed from: o */
    public void m354o() {
        this.f257H = true;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.f257H = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        m336f().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.f257H = true;
    }

    /* JADX INFO: renamed from: p */
    public void m355p() {
        this.f257H = true;
    }

    /* JADX INFO: renamed from: q */
    public void m356q() {
        this.f257H = true;
        if (this.f292w == null || this.f289t.f337d.f367s) {
            return;
        }
        this.f292w.m93a();
    }

    /* JADX INFO: renamed from: r */
    void m357r() {
        this.f275f = -1;
        this.f276g = null;
        this.f281l = false;
        this.f282m = false;
        this.f283n = false;
        this.f284o = false;
        this.f285p = false;
        this.f287r = 0;
        this.f288s = null;
        this.f290u = null;
        this.f289t = null;
        this.f294y = 0;
        this.f295z = 0;
        this.f250A = null;
        this.f251B = false;
        this.f252C = false;
        this.f254E = false;
    }

    /* JADX INFO: renamed from: s */
    public void m358s() {
        this.f257H = true;
    }

    /* JADX INFO: renamed from: t */
    public void m359t() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        C0093d.m785a(this, sb);
        if (this.f275f >= 0) {
            sb.append(" #");
            sb.append(this.f275f);
        }
        if (this.f294y != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f294y));
        }
        if (this.f250A != null) {
            sb.append(" ");
            sb.append(this.f250A);
        }
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: renamed from: u */
    public Object m360u() {
        if (this.f264O == null) {
            return null;
        }
        return this.f264O.f309l;
    }

    /* JADX INFO: renamed from: v */
    public Object m361v() {
        if (this.f264O == null) {
            return null;
        }
        return this.f264O.f310m == f249a ? m360u() : this.f264O.f310m;
    }

    /* JADX INFO: renamed from: w */
    public Object m362w() {
        if (this.f264O == null) {
            return null;
        }
        return this.f264O.f311n;
    }

    /* JADX INFO: renamed from: x */
    public Object m363x() {
        if (this.f264O == null) {
            return null;
        }
        return this.f264O.f312o == f249a ? m362w() : this.f264O.f312o;
    }

    /* JADX INFO: renamed from: y */
    public Object m364y() {
        if (this.f264O == null) {
            return null;
        }
        return this.f264O.f313p;
    }

    /* JADX INFO: renamed from: z */
    public Object m365z() {
        if (this.f264O == null) {
            return null;
        }
        return this.f264O.f314q == f249a ? m364y() : this.f264O.f314q;
    }
}
