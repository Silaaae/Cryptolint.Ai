package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: renamed from: android.support.v4.app.k */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0053k<E> extends AbstractC0051i {

    /* JADX INFO: renamed from: a */
    private final Activity f334a;

    /* JADX INFO: renamed from: b */
    final Context f335b;

    /* JADX INFO: renamed from: c */
    final int f336c;

    /* JADX INFO: renamed from: d */
    final LayoutInflaterFactory2C0055m f337d;

    /* JADX INFO: renamed from: e */
    private final Handler f338e;

    AbstractC0053k(Activity activity, Context context, Handler handler, int i) {
        this.f337d = new LayoutInflaterFactory2C0055m();
        this.f334a = activity;
        this.f335b = context;
        this.f338e = handler;
        this.f336c = i;
    }

    AbstractC0053k(ActivityC0050h activityC0050h) {
        this(activityC0050h, activityC0050h, activityC0050h.f317c, 0);
    }

    @Override // android.support.v4.app.AbstractC0051i
    /* JADX INFO: renamed from: a */
    public View mo367a(int i) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void mo389a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // android.support.v4.app.AbstractC0051i
    /* JADX INFO: renamed from: a */
    public boolean mo368a() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo390a(ComponentCallbacksC0049g componentCallbacksC0049g) {
        return true;
    }

    /* JADX INFO: renamed from: b */
    public LayoutInflater mo391b() {
        return LayoutInflater.from(this.f335b);
    }

    /* JADX INFO: renamed from: b */
    void mo392b(ComponentCallbacksC0049g componentCallbacksC0049g) {
    }

    /* JADX INFO: renamed from: c */
    public void mo393c() {
    }

    /* JADX INFO: renamed from: d */
    public boolean mo394d() {
        return true;
    }

    /* JADX INFO: renamed from: e */
    public int mo395e() {
        return this.f336c;
    }

    /* JADX INFO: renamed from: f */
    Activity m423f() {
        return this.f334a;
    }

    /* JADX INFO: renamed from: g */
    Context m424g() {
        return this.f335b;
    }

    /* JADX INFO: renamed from: h */
    Handler m425h() {
        return this.f338e;
    }

    /* JADX INFO: renamed from: i */
    LayoutInflaterFactory2C0055m m426i() {
        return this.f337d;
    }
}
