package android.support.v4.app;

import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: android.support.v4.app.w */
/* JADX INFO: loaded from: classes.dex */
class ViewOnAttachStateChangeListenerC0065w implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a */
    private final View f485a;

    /* JADX INFO: renamed from: b */
    private ViewTreeObserver f486b;

    /* JADX INFO: renamed from: c */
    private final Runnable f487c;

    private ViewOnAttachStateChangeListenerC0065w(View view, Runnable runnable) {
        this.f485a = view;
        this.f486b = view.getViewTreeObserver();
        this.f487c = runnable;
    }

    /* JADX INFO: renamed from: a */
    public static ViewOnAttachStateChangeListenerC0065w m635a(View view, Runnable runnable) {
        ViewOnAttachStateChangeListenerC0065w viewOnAttachStateChangeListenerC0065w = new ViewOnAttachStateChangeListenerC0065w(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(viewOnAttachStateChangeListenerC0065w);
        view.addOnAttachStateChangeListener(viewOnAttachStateChangeListenerC0065w);
        return viewOnAttachStateChangeListenerC0065w;
    }

    /* JADX INFO: renamed from: a */
    public void m636a() {
        (this.f486b.isAlive() ? this.f486b : this.f485a.getViewTreeObserver()).removeOnPreDrawListener(this);
        this.f485a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        m636a();
        this.f487c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f486b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m636a();
    }
}
