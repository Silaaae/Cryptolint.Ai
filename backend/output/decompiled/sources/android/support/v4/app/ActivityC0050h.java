package android.support.v4.app;

import android.arch.lifecycle.AbstractC0009c;
import android.arch.lifecycle.C0022p;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.app.C0042a;
import android.support.v4.p014f.C0101l;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: renamed from: android.support.v4.app.h */
/* JADX INFO: loaded from: classes.dex */
public class ActivityC0050h extends AbstractActivityC0048f {

    /* JADX INFO: renamed from: e */
    AbstractC0063u f319e;

    /* JADX INFO: renamed from: f */
    boolean f320f;

    /* JADX INFO: renamed from: g */
    boolean f321g;

    /* JADX INFO: renamed from: j */
    boolean f324j;

    /* JADX INFO: renamed from: k */
    int f325k;

    /* JADX INFO: renamed from: l */
    C0101l<String> f326l;

    /* JADX INFO: renamed from: m */
    private C0022p f327m;

    /* JADX INFO: renamed from: c */
    final Handler f317c = new Handler() { // from class: android.support.v4.app.h.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (ActivityC0050h.this.f322h) {
                        ActivityC0050h.this.m382a(false);
                    }
                    break;
                case 2:
                    ActivityC0050h.this.m384b();
                    ActivityC0050h.this.f318d.m422n();
                    break;
                default:
                    super.handleMessage(message);
                    break;
            }
        }
    };

    /* JADX INFO: renamed from: d */
    final C0052j f318d = C0052j.m396a(new a());

    /* JADX INFO: renamed from: h */
    boolean f322h = true;

    /* JADX INFO: renamed from: i */
    boolean f323i = true;

    /* JADX INFO: renamed from: android.support.v4.app.h$a */
    class a extends AbstractC0053k<ActivityC0050h> {
        public a() {
            super(ActivityC0050h.this);
        }

        @Override // android.support.v4.app.AbstractC0053k, android.support.v4.app.AbstractC0051i
        /* JADX INFO: renamed from: a */
        public View mo367a(int i) {
            return ActivityC0050h.this.findViewById(i);
        }

        @Override // android.support.v4.app.AbstractC0053k
        /* JADX INFO: renamed from: a */
        public void mo389a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            ActivityC0050h.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // android.support.v4.app.AbstractC0053k, android.support.v4.app.AbstractC0051i
        /* JADX INFO: renamed from: a */
        public boolean mo368a() {
            Window window = ActivityC0050h.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // android.support.v4.app.AbstractC0053k
        /* JADX INFO: renamed from: a */
        public boolean mo390a(ComponentCallbacksC0049g componentCallbacksC0049g) {
            return !ActivityC0050h.this.isFinishing();
        }

        @Override // android.support.v4.app.AbstractC0053k
        /* JADX INFO: renamed from: b */
        public LayoutInflater mo391b() {
            return ActivityC0050h.this.getLayoutInflater().cloneInContext(ActivityC0050h.this);
        }

        @Override // android.support.v4.app.AbstractC0053k
        /* JADX INFO: renamed from: b */
        public void mo392b(ComponentCallbacksC0049g componentCallbacksC0049g) {
            ActivityC0050h.this.m381a(componentCallbacksC0049g);
        }

        @Override // android.support.v4.app.AbstractC0053k
        /* JADX INFO: renamed from: c */
        public void mo393c() {
            ActivityC0050h.this.mo386d();
        }

        @Override // android.support.v4.app.AbstractC0053k
        /* JADX INFO: renamed from: d */
        public boolean mo394d() {
            return ActivityC0050h.this.getWindow() != null;
        }

        @Override // android.support.v4.app.AbstractC0053k
        /* JADX INFO: renamed from: e */
        public int mo395e() {
            Window window = ActivityC0050h.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }
    }

    /* JADX INFO: renamed from: android.support.v4.app.h$b */
    static final class b {

        /* JADX INFO: renamed from: a */
        Object f330a;

        /* JADX INFO: renamed from: b */
        C0022p f331b;

        /* JADX INFO: renamed from: c */
        C0056n f332c;

        b() {
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m379a(AbstractC0054l abstractC0054l, AbstractC0009c.b bVar) {
        boolean zM379a = false;
        for (ComponentCallbacksC0049g componentCallbacksC0049g : abstractC0054l.mo429b()) {
            if (componentCallbacksC0049g != null) {
                if (componentCallbacksC0049g.mo58a().mo54a().m57a(AbstractC0009c.b.STARTED)) {
                    componentCallbacksC0049g.f270U.m72a(bVar);
                    zM379a = true;
                }
                AbstractC0054l abstractC0054lM345j = componentCallbacksC0049g.m345j();
                if (abstractC0054lM345j != null) {
                    zM379a |= m379a(abstractC0054lM345j, bVar);
                }
            }
        }
        return zM379a;
    }

    /* JADX INFO: renamed from: g */
    private void m380g() {
        while (m379a(m388f(), AbstractC0009c.b.CREATED)) {
        }
    }

    @Override // android.support.v4.app.ActivityC0068z, android.arch.lifecycle.InterfaceC0011e
    /* JADX INFO: renamed from: a */
    public AbstractC0009c mo58a() {
        return super.mo58a();
    }

    @Override // android.support.v4.app.AbstractActivityC0047e
    /* JADX INFO: renamed from: a */
    final View mo260a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f318d.m399a(view, str, context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    public void m381a(ComponentCallbacksC0049g componentCallbacksC0049g) {
    }

    /* JADX INFO: renamed from: a */
    void m382a(boolean z) {
        if (this.f323i) {
            return;
        }
        this.f323i = true;
        this.f324j = z;
        this.f317c.removeMessages(1);
        m387e();
    }

    /* JADX INFO: renamed from: a */
    protected boolean m383a(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    /* JADX INFO: renamed from: b */
    protected void m384b() {
        this.f318d.m416h();
    }

    /* JADX INFO: renamed from: c */
    public Object m385c() {
        return null;
    }

    @Deprecated
    /* JADX INFO: renamed from: d */
    public void mo386d() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.f320f);
        printWriter.print("mResumed=");
        printWriter.print(this.f321g);
        printWriter.print(" mStopped=");
        printWriter.print(this.f322h);
        printWriter.print(" mReallyStopped=");
        printWriter.println(this.f323i);
        if (this.f319e != null) {
            this.f319e.mo218a(str2, fileDescriptor, printWriter, strArr);
        }
        this.f318d.m398a().mo427a(str, fileDescriptor, printWriter, strArr);
    }

    /* JADX INFO: renamed from: e */
    void m387e() {
        this.f318d.m419k();
    }

    /* JADX INFO: renamed from: f */
    public AbstractC0054l m388f() {
        return this.f318d.m398a();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        this.f318d.m407b();
        int i3 = i >> 16;
        if (i3 == 0) {
            C0042a.a aVarM228a = C0042a.m228a();
            if (aVarM228a == null || !aVarM228a.m230a(this, i, i2, intent)) {
                super.onActivityResult(i, i2, intent);
                return;
            }
            return;
        }
        int i4 = i3 - 1;
        String strM831a = this.f326l.m831a(i4);
        this.f326l.m837c(i4);
        if (strM831a == null) {
            Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
            return;
        }
        ComponentCallbacksC0049g componentCallbacksC0049gM397a = this.f318d.m397a(strM831a);
        if (componentCallbacksC0049gM397a != null) {
            componentCallbacksC0049gM397a.m295a(i & 65535, i2, intent);
            return;
        }
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + strM831a);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        AbstractC0054l abstractC0054lM398a = this.f318d.m398a();
        boolean zMo430c = abstractC0054lM398a.mo430c();
        if (!zMo430c || Build.VERSION.SDK_INT > 25) {
            if (zMo430c || !abstractC0054lM398a.mo428a()) {
                super.onBackPressed();
            }
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f318d.m407b();
        this.f318d.m400a(configuration);
    }

    @Override // android.support.v4.app.ActivityC0068z, android.app.Activity
    protected void onCreate(Bundle bundle) {
        this.f318d.m402a((ComponentCallbacksC0049g) null);
        super.onCreate(bundle);
        b bVar = (b) getLastNonConfigurationInstance();
        if (bVar != null) {
            this.f327m = bVar.f331b;
        }
        if (bundle != null) {
            this.f318d.m401a(bundle.getParcelable("android:support:fragments"), bVar != null ? bVar.f332c : null);
            if (bundle.containsKey("android:support:next_request_index")) {
                this.f325k = bundle.getInt("android:support:next_request_index");
                int[] intArray = bundle.getIntArray("android:support:request_indicies");
                String[] stringArray = bundle.getStringArray("android:support:request_fragment_who");
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.f326l = new C0101l<>(intArray.length);
                    for (int i = 0; i < intArray.length; i++) {
                        this.f326l.m835b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.f326l == null) {
            this.f326l = new C0101l<>();
            this.f325k = 0;
        }
        this.f318d.m413e();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        return i == 0 ? super.onCreatePanelMenu(i, menu) | this.f318d.m405a(menu, getMenuInflater()) : super.onCreatePanelMenu(i, menu);
    }

    @Override // android.support.v4.app.AbstractActivityC0047e, android.app.Activity, android.view.LayoutInflater.Factory2
    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    @Override // android.support.v4.app.AbstractActivityC0047e, android.app.Activity, android.view.LayoutInflater.Factory
    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        m382a(false);
        if (this.f327m != null && !this.f324j) {
            this.f327m.m93a();
        }
        this.f318d.m420l();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.f318d.m421m();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.f318d.m406a(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.f318d.m410b(menuItem);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        this.f318d.m403a(z);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f318d.m407b();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.f318d.m408b(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f321g = false;
        if (this.f317c.hasMessages(2)) {
            this.f317c.removeMessages(2);
            m384b();
        }
        this.f318d.m417i();
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        this.f318d.m409b(z);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        this.f317c.removeMessages(2);
        m384b();
        this.f318d.m422n();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        return (i != 0 || menu == null) ? super.onPreparePanel(i, view, menu) : m383a(view, menu) | this.f318d.m404a(menu);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.f318d.m407b();
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String strM831a = this.f326l.m831a(i3);
            this.f326l.m837c(i3);
            if (strM831a == null) {
                Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
                return;
            }
            ComponentCallbacksC0049g componentCallbacksC0049gM397a = this.f318d.m397a(strM831a);
            if (componentCallbacksC0049gM397a != null) {
                componentCallbacksC0049gM397a.m297a(i & 65535, strArr, iArr);
                return;
            }
            Log.w("FragmentActivity", "Activity result no fragment exists for who: " + strM831a);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f317c.sendEmptyMessage(2);
        this.f321g = true;
        this.f318d.m422n();
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        if (this.f322h) {
            m382a(true);
        }
        Object objM385c = m385c();
        C0056n c0056nM412d = this.f318d.m412d();
        if (c0056nM412d == null && this.f327m == null && objM385c == null) {
            return null;
        }
        b bVar = new b();
        bVar.f330a = objM385c;
        bVar.f331b = this.f327m;
        bVar.f332c = c0056nM412d;
        return bVar;
    }

    @Override // android.support.v4.app.ActivityC0068z, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m380g();
        Parcelable parcelableM411c = this.f318d.m411c();
        if (parcelableM411c != null) {
            bundle.putParcelable("android:support:fragments", parcelableM411c);
        }
        if (this.f326l.m833b() > 0) {
            bundle.putInt("android:support:next_request_index", this.f325k);
            int[] iArr = new int[this.f326l.m833b()];
            String[] strArr = new String[this.f326l.m833b()];
            for (int i = 0; i < this.f326l.m833b(); i++) {
                iArr[i] = this.f326l.m839d(i);
                strArr[i] = this.f326l.m840e(i);
            }
            bundle.putIntArray("android:support:request_indicies", iArr);
            bundle.putStringArray("android:support:request_fragment_who", strArr);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f322h = false;
        this.f323i = false;
        this.f317c.removeMessages(1);
        if (!this.f320f) {
            this.f320f = true;
            this.f318d.m414f();
        }
        this.f318d.m407b();
        this.f318d.m422n();
        this.f318d.m415g();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.f318d.m407b();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.f322h = true;
        m380g();
        this.f317c.sendEmptyMessage(1);
        this.f318d.m418j();
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        if (!this.f247b && i != -1) {
            m259a(i);
        }
        super.startActivityForResult(intent, i);
    }

    @Override // android.support.v4.app.AbstractActivityC0048f, android.app.Activity
    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.support.v4.app.AbstractActivityC0047e, android.app.Activity
    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.support.v4.app.AbstractActivityC0048f, android.app.Activity
    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
