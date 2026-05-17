package android.support.v4.p015g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: android.support.v4.g.s */
/* JADX INFO: loaded from: classes.dex */
public final class C0127s {

    /* JADX INFO: renamed from: a */
    Runnable f679a = null;

    /* JADX INFO: renamed from: b */
    Runnable f680b = null;

    /* JADX INFO: renamed from: c */
    int f681c = -1;

    /* JADX INFO: renamed from: d */
    private WeakReference<View> f682d;

    /* JADX INFO: renamed from: android.support.v4.g.s$a */
    static class a implements InterfaceC0128t {

        /* JADX INFO: renamed from: a */
        C0127s f689a;

        /* JADX INFO: renamed from: b */
        boolean f690b;

        a(C0127s c0127s) {
            this.f689a = c0127s;
        }

        @Override // android.support.v4.p015g.InterfaceC0128t
        /* JADX INFO: renamed from: a */
        public void mo1026a(View view) {
            this.f690b = false;
            if (this.f689a.f681c > -1) {
                view.setLayerType(2, null);
            }
            if (this.f689a.f679a != null) {
                Runnable runnable = this.f689a.f679a;
                this.f689a.f679a = null;
                runnable.run();
            }
            Object tag = view.getTag(2113929216);
            InterfaceC0128t interfaceC0128t = tag instanceof InterfaceC0128t ? (InterfaceC0128t) tag : null;
            if (interfaceC0128t != null) {
                interfaceC0128t.mo1026a(view);
            }
        }

        @Override // android.support.v4.p015g.InterfaceC0128t
        /* JADX INFO: renamed from: b */
        public void mo1027b(View view) {
            if (this.f689a.f681c > -1) {
                view.setLayerType(this.f689a.f681c, null);
                this.f689a.f681c = -1;
            }
            if (Build.VERSION.SDK_INT >= 16 || !this.f690b) {
                if (this.f689a.f680b != null) {
                    Runnable runnable = this.f689a.f680b;
                    this.f689a.f680b = null;
                    runnable.run();
                }
                Object tag = view.getTag(2113929216);
                InterfaceC0128t interfaceC0128t = tag instanceof InterfaceC0128t ? (InterfaceC0128t) tag : null;
                if (interfaceC0128t != null) {
                    interfaceC0128t.mo1027b(view);
                }
                this.f690b = true;
            }
        }

        @Override // android.support.v4.p015g.InterfaceC0128t
        /* JADX INFO: renamed from: c */
        public void mo1028c(View view) {
            Object tag = view.getTag(2113929216);
            InterfaceC0128t interfaceC0128t = tag instanceof InterfaceC0128t ? (InterfaceC0128t) tag : null;
            if (interfaceC0128t != null) {
                interfaceC0128t.mo1028c(view);
            }
        }
    }

    C0127s(View view) {
        this.f682d = new WeakReference<>(view);
    }

    /* JADX INFO: renamed from: a */
    private void m1015a(final View view, final InterfaceC0128t interfaceC0128t) {
        if (interfaceC0128t != null) {
            view.animate().setListener(new AnimatorListenerAdapter() { // from class: android.support.v4.g.s.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    interfaceC0128t.mo1028c(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    interfaceC0128t.mo1027b(view);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    interfaceC0128t.mo1026a(view);
                }
            });
        } else {
            view.animate().setListener(null);
        }
    }

    /* JADX INFO: renamed from: a */
    public long m1016a() {
        View view = this.f682d.get();
        if (view != null) {
            return view.animate().getDuration();
        }
        return 0L;
    }

    /* JADX INFO: renamed from: a */
    public C0127s m1017a(float f) {
        View view = this.f682d.get();
        if (view != null) {
            view.animate().alpha(f);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0127s m1018a(long j) {
        View view = this.f682d.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0127s m1019a(InterfaceC0128t interfaceC0128t) {
        View view = this.f682d.get();
        if (view != null) {
            if (Build.VERSION.SDK_INT < 16) {
                view.setTag(2113929216, interfaceC0128t);
                interfaceC0128t = new a(this);
            }
            m1015a(view, interfaceC0128t);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0127s m1020a(final InterfaceC0130v interfaceC0130v) {
        final View view = this.f682d.get();
        if (view != null && Build.VERSION.SDK_INT >= 19) {
            view.animate().setUpdateListener(interfaceC0130v != null ? new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v4.g.s.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    interfaceC0130v.mo1029a(view);
                }
            } : null);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0127s m1021a(Interpolator interpolator) {
        View view = this.f682d.get();
        if (view != null) {
            view.animate().setInterpolator(interpolator);
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0127s m1022b(float f) {
        View view = this.f682d.get();
        if (view != null) {
            view.animate().translationY(f);
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C0127s m1023b(long j) {
        View view = this.f682d.get();
        if (view != null) {
            view.animate().setStartDelay(j);
        }
        return this;
    }

    /* JADX INFO: renamed from: b */
    public void m1024b() {
        View view = this.f682d.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m1025c() {
        View view = this.f682d.get();
        if (view != null) {
            view.animate().start();
        }
    }
}
