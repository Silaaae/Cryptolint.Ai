package android.support.v4.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.arch.lifecycle.C0022p;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.app.AbstractC0054l;
import android.support.v4.app.ComponentCallbacksC0049g;
import android.support.v4.p014f.C0091b;
import android.support.v4.p014f.C0093d;
import android.support.v4.p014f.C0094e;
import android.support.v4.p014f.C0098i;
import android.support.v4.p015g.C0124p;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: renamed from: android.support.v4.app.m */
/* JADX INFO: loaded from: classes.dex */
final class LayoutInflaterFactory2C0055m extends AbstractC0054l implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: F */
    static final Interpolator f339F = new DecelerateInterpolator(2.5f);

    /* JADX INFO: renamed from: G */
    static final Interpolator f340G = new DecelerateInterpolator(1.5f);

    /* JADX INFO: renamed from: H */
    static final Interpolator f341H = new AccelerateInterpolator(2.5f);

    /* JADX INFO: renamed from: I */
    static final Interpolator f342I = new AccelerateInterpolator(1.5f);

    /* JADX INFO: renamed from: a */
    static boolean f343a = false;

    /* JADX INFO: renamed from: q */
    static Field f344q;

    /* JADX INFO: renamed from: C */
    ArrayList<h> f347C;

    /* JADX INFO: renamed from: D */
    C0056n f348D;

    /* JADX INFO: renamed from: b */
    ArrayList<g> f351b;

    /* JADX INFO: renamed from: c */
    boolean f352c;

    /* JADX INFO: renamed from: f */
    SparseArray<ComponentCallbacksC0049g> f355f;

    /* JADX INFO: renamed from: g */
    ArrayList<C0045c> f356g;

    /* JADX INFO: renamed from: h */
    ArrayList<ComponentCallbacksC0049g> f357h;

    /* JADX INFO: renamed from: i */
    ArrayList<C0045c> f358i;

    /* JADX INFO: renamed from: j */
    ArrayList<Integer> f359j;

    /* JADX INFO: renamed from: k */
    ArrayList<AbstractC0054l.b> f360k;

    /* JADX INFO: renamed from: m */
    AbstractC0053k f362m;

    /* JADX INFO: renamed from: n */
    AbstractC0051i f363n;

    /* JADX INFO: renamed from: o */
    ComponentCallbacksC0049g f364o;

    /* JADX INFO: renamed from: p */
    ComponentCallbacksC0049g f365p;

    /* JADX INFO: renamed from: r */
    boolean f366r;

    /* JADX INFO: renamed from: s */
    boolean f367s;

    /* JADX INFO: renamed from: t */
    boolean f368t;

    /* JADX INFO: renamed from: u */
    boolean f369u;

    /* JADX INFO: renamed from: v */
    String f370v;

    /* JADX INFO: renamed from: w */
    boolean f371w;

    /* JADX INFO: renamed from: x */
    ArrayList<C0045c> f372x;

    /* JADX INFO: renamed from: y */
    ArrayList<Boolean> f373y;

    /* JADX INFO: renamed from: z */
    ArrayList<ComponentCallbacksC0049g> f374z;

    /* JADX INFO: renamed from: d */
    int f353d = 0;

    /* JADX INFO: renamed from: e */
    final ArrayList<ComponentCallbacksC0049g> f354e = new ArrayList<>();

    /* JADX INFO: renamed from: J */
    private final CopyOnWriteArrayList<C0098i<AbstractC0054l.a, Boolean>> f350J = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: l */
    int f361l = 0;

    /* JADX INFO: renamed from: A */
    Bundle f345A = null;

    /* JADX INFO: renamed from: B */
    SparseArray<Parcelable> f346B = null;

    /* JADX INFO: renamed from: E */
    Runnable f349E = new Runnable() { // from class: android.support.v4.app.m.1
        @Override // java.lang.Runnable
        public void run() {
            LayoutInflaterFactory2C0055m.this.m520e();
        }
    };

    /* JADX INFO: renamed from: android.support.v4.app.m$a */
    private static class a extends b {

        /* JADX INFO: renamed from: a */
        View f388a;

        a(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.f388a = view;
        }

        @Override // android.support.v4.app.LayoutInflaterFactory2C0055m.b, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (C0124p.m971m(this.f388a) || Build.VERSION.SDK_INT >= 24) {
                this.f388a.post(new Runnable() { // from class: android.support.v4.app.m.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.f388a.setLayerType(0, null);
                    }
                });
            } else {
                this.f388a.setLayerType(0, null);
            }
            super.onAnimationEnd(animation);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.app.m$b */
    private static class b implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a */
        private final Animation.AnimationListener f390a;

        private b(Animation.AnimationListener animationListener) {
            this.f390a = animationListener;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (this.f390a != null) {
                this.f390a.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            if (this.f390a != null) {
                this.f390a.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (this.f390a != null) {
                this.f390a.onAnimationStart(animation);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v4.app.m$c */
    private static class c {

        /* JADX INFO: renamed from: a */
        public final Animation f391a;

        /* JADX INFO: renamed from: b */
        public final Animator f392b;

        private c(Animator animator) {
            this.f391a = null;
            this.f392b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }

        private c(Animation animation) {
            this.f391a = animation;
            this.f392b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v4.app.m$d */
    private static class d extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a */
        View f393a;

        d(View view) {
            this.f393a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f393a.setLayerType(0, null);
            animator.removeListener(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f393a.setLayerType(2, null);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.app.m$e */
    private static class e extends AnimationSet implements Runnable {

        /* JADX INFO: renamed from: a */
        private final ViewGroup f394a;

        /* JADX INFO: renamed from: b */
        private final View f395b;

        /* JADX INFO: renamed from: c */
        private boolean f396c;

        /* JADX INFO: renamed from: d */
        private boolean f397d;

        e(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f394a = viewGroup;
            this.f395b = view;
            addAnimation(animation);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            if (this.f396c) {
                return !this.f397d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f396c = true;
                ViewOnAttachStateChangeListenerC0065w.m635a(this.f394a, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            if (this.f396c) {
                return !this.f397d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.f396c = true;
                ViewOnAttachStateChangeListenerC0065w.m635a(this.f394a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f394a.endViewTransition(this.f395b);
            this.f397d = true;
        }
    }

    /* JADX INFO: renamed from: android.support.v4.app.m$f */
    static class f {

        /* JADX INFO: renamed from: a */
        public static final int[] f398a = {R.attr.name, R.attr.id, R.attr.tag};
    }

    /* JADX INFO: renamed from: android.support.v4.app.m$g */
    interface g {
        /* JADX INFO: renamed from: a */
        boolean mo250a(ArrayList<C0045c> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* JADX INFO: renamed from: android.support.v4.app.m$h */
    static class h implements ComponentCallbacksC0049g.c {

        /* JADX INFO: renamed from: a */
        private final boolean f399a;

        /* JADX INFO: renamed from: b */
        private final C0045c f400b;

        /* JADX INFO: renamed from: c */
        private int f401c;

        h(C0045c c0045c, boolean z) {
            this.f399a = z;
            this.f400b = c0045c;
        }

        @Override // android.support.v4.app.ComponentCallbacksC0049g.c
        /* JADX INFO: renamed from: a */
        public void mo377a() {
            this.f401c--;
            if (this.f401c != 0) {
                return;
            }
            this.f400b.f207a.m477y();
        }

        @Override // android.support.v4.app.ComponentCallbacksC0049g.c
        /* JADX INFO: renamed from: b */
        public void mo378b() {
            this.f401c++;
        }

        /* JADX INFO: renamed from: c */
        public boolean m554c() {
            return this.f401c == 0;
        }

        /* JADX INFO: renamed from: d */
        public void m555d() {
            boolean z = this.f401c > 0;
            LayoutInflaterFactory2C0055m layoutInflaterFactory2C0055m = this.f400b.f207a;
            int size = layoutInflaterFactory2C0055m.f354e.size();
            for (int i = 0; i < size; i++) {
                ComponentCallbacksC0049g componentCallbacksC0049g = layoutInflaterFactory2C0055m.f354e.get(i);
                componentCallbacksC0049g.m305a((ComponentCallbacksC0049g.c) null);
                if (z && componentCallbacksC0049g.m288W()) {
                    componentCallbacksC0049g.m268C();
                }
            }
            this.f400b.f207a.m453a(this.f400b, this.f399a, !z, true);
        }

        /* JADX INFO: renamed from: e */
        public void m556e() {
            this.f400b.f207a.m453a(this.f400b, this.f399a, false, false);
        }
    }

    LayoutInflaterFactory2C0055m() {
    }

    /* JADX INFO: renamed from: A */
    private void m446A() {
        if (this.f347C != null) {
            while (!this.f347C.isEmpty()) {
                this.f347C.remove(0).m555d();
            }
        }
    }

    /* JADX INFO: renamed from: B */
    private void m447B() {
        int size = this.f355f == null ? 0 : this.f355f.size();
        for (int i = 0; i < size; i++) {
            ComponentCallbacksC0049g componentCallbacksC0049gValueAt = this.f355f.valueAt(i);
            if (componentCallbacksC0049gValueAt != null) {
                if (componentCallbacksC0049gValueAt.m285T() != null) {
                    int iM287V = componentCallbacksC0049gValueAt.m287V();
                    View viewM285T = componentCallbacksC0049gValueAt.m285T();
                    Animation animation = viewM285T.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        viewM285T.clearAnimation();
                    }
                    componentCallbacksC0049gValueAt.m309a((View) null);
                    m489a(componentCallbacksC0049gValueAt, iM287V, 0, 0, false);
                } else if (componentCallbacksC0049gValueAt.m286U() != null) {
                    componentCallbacksC0049gValueAt.m286U().end();
                }
            }
        }
    }

    /* JADX INFO: renamed from: C */
    private void m448C() {
        if (this.f355f != null) {
            for (int size = this.f355f.size() - 1; size >= 0; size--) {
                if (this.f355f.valueAt(size) == null) {
                    this.f355f.delete(this.f355f.keyAt(size));
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private int m449a(ArrayList<C0045c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, C0091b<ComponentCallbacksC0049g> c0091b) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            C0045c c0045c = arrayList.get(i4);
            boolean zBooleanValue = arrayList2.get(i4).booleanValue();
            if (c0045c.m254c() && !c0045c.m249a(arrayList, i4 + 1, i2)) {
                if (this.f347C == null) {
                    this.f347C = new ArrayList<>();
                }
                h hVar = new h(c0045c, zBooleanValue);
                this.f347C.add(hVar);
                c0045c.m245a(hVar);
                if (zBooleanValue) {
                    c0045c.m252b();
                } else {
                    c0045c.m248a(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, c0045c);
                }
                m467b(c0091b);
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: a */
    static c m450a(Context context, float f2, float f3) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setInterpolator(f340G);
        alphaAnimation.setDuration(220L);
        return new c(alphaAnimation);
    }

    /* JADX INFO: renamed from: a */
    static c m451a(Context context, float f2, float f3, float f4, float f5) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f2, f3, f2, f3, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f339F);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f4, f5);
        alphaAnimation.setInterpolator(f340G);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new c(animationSet);
    }

    /* JADX INFO: renamed from: a */
    private static Animation.AnimationListener m452a(Animation animation) {
        String str;
        String str2;
        try {
            if (f344q == null) {
                f344q = Animation.class.getDeclaredField("mListener");
                f344q.setAccessible(true);
            }
            return (Animation.AnimationListener) f344q.get(animation);
        } catch (IllegalAccessException e2) {
            e = e2;
            str = "FragmentManager";
            str2 = "Cannot access Animation's mListener field";
            Log.e(str, str2, e);
            return null;
        } catch (NoSuchFieldException e3) {
            e = e3;
            str = "FragmentManager";
            str2 = "No field with the name mListener is found in Animation class";
            Log.e(str, str2, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m453a(C0045c c0045c, boolean z, boolean z2, boolean z3) {
        if (z) {
            c0045c.m248a(z3);
        } else {
            c0045c.m252b();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(c0045c);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            C0060r.m581a(this, (ArrayList<C0045c>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            m483a(this.f361l, true);
        }
        if (this.f355f != null) {
            int size = this.f355f.size();
            for (int i = 0; i < size; i++) {
                ComponentCallbacksC0049g componentCallbacksC0049gValueAt = this.f355f.valueAt(i);
                if (componentCallbacksC0049gValueAt != null && componentCallbacksC0049gValueAt.f259J != null && componentCallbacksC0049gValueAt.f265P && c0045c.m253b(componentCallbacksC0049gValueAt.f295z)) {
                    if (componentCallbacksC0049gValueAt.f267R > 0.0f) {
                        componentCallbacksC0049gValueAt.f259J.setAlpha(componentCallbacksC0049gValueAt.f267R);
                    }
                    if (z3) {
                        componentCallbacksC0049gValueAt.f267R = 0.0f;
                    } else {
                        componentCallbacksC0049gValueAt.f267R = -1.0f;
                        componentCallbacksC0049gValueAt.f265P = false;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m454a(final ComponentCallbacksC0049g componentCallbacksC0049g, c cVar, int i) {
        final View view = componentCallbacksC0049g.f259J;
        final ViewGroup viewGroup = componentCallbacksC0049g.f258I;
        viewGroup.startViewTransition(view);
        componentCallbacksC0049g.m316b(i);
        if (cVar.f391a != null) {
            e eVar = new e(cVar.f391a, viewGroup, view);
            componentCallbacksC0049g.m309a(componentCallbacksC0049g.f259J);
            eVar.setAnimationListener(new b(m452a(eVar)) { // from class: android.support.v4.app.m.2
                @Override // android.support.v4.app.LayoutInflaterFactory2C0055m.b, android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    super.onAnimationEnd(animation);
                    viewGroup.post(new Runnable() { // from class: android.support.v4.app.m.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (componentCallbacksC0049g.m285T() != null) {
                                componentCallbacksC0049g.m309a((View) null);
                                LayoutInflaterFactory2C0055m.this.m489a(componentCallbacksC0049g, componentCallbacksC0049g.m287V(), 0, 0, false);
                            }
                        }
                    });
                }
            });
            m468b(view, cVar);
            componentCallbacksC0049g.f259J.startAnimation(eVar);
            return;
        }
        Animator animator = cVar.f392b;
        componentCallbacksC0049g.m298a(cVar.f392b);
        animator.addListener(new AnimatorListenerAdapter() { // from class: android.support.v4.app.m.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                viewGroup.endViewTransition(view);
                Animator animatorM286U = componentCallbacksC0049g.m286U();
                componentCallbacksC0049g.m298a((Animator) null);
                if (animatorM286U == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                LayoutInflaterFactory2C0055m.this.m489a(componentCallbacksC0049g, componentCallbacksC0049g.m287V(), 0, 0, false);
            }
        });
        animator.setTarget(componentCallbacksC0049g.f259J);
        m468b(componentCallbacksC0049g.f259J, cVar);
        animator.start();
    }

    /* JADX INFO: renamed from: a */
    private static void m457a(C0056n c0056n) {
        if (c0056n == null) {
            return;
        }
        List<ComponentCallbacksC0049g> listM557a = c0056n.m557a();
        if (listM557a != null) {
            Iterator<ComponentCallbacksC0049g> it = listM557a.iterator();
            while (it.hasNext()) {
                it.next().f254E = true;
            }
        }
        List<C0056n> listM558b = c0056n.m558b();
        if (listM558b != null) {
            Iterator<C0056n> it2 = listM558b.iterator();
            while (it2.hasNext()) {
                m457a(it2.next());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m458a(C0091b<ComponentCallbacksC0049g> c0091b) {
        int size = c0091b.size();
        for (int i = 0; i < size; i++) {
            ComponentCallbacksC0049g componentCallbacksC0049gM777b = c0091b.m777b(i);
            if (!componentCallbacksC0049gM777b.f281l) {
                View viewM347k = componentCallbacksC0049gM777b.m347k();
                componentCallbacksC0049gM777b.f267R = viewM347k.getAlpha();
                viewM347k.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m459a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0094e("FragmentManager"));
        try {
            if (this.f362m != null) {
                this.f362m.mo389a("  ", null, printWriter, new String[0]);
            } else {
                mo427a("  ", (FileDescriptor) null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw runtimeException;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038 A[PHI: r0 r2
  0x0038: PHI (r0v9 int) = (r0v6 int), (r0v5 int) binds: [B:29:0x0077, B:15:0x0036] A[DONT_GENERATE, DONT_INLINE]
  0x0038: PHI (r2v4 int) = (r2v2 int), (r2v1 int) binds: [B:29:0x0077, B:15:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m460a(ArrayList<C0045c> arrayList, ArrayList<Boolean> arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        int size = this.f347C == null ? 0 : this.f347C.size();
        int i = 0;
        while (i < size) {
            h hVar = this.f347C.get(i);
            if (arrayList == null || hVar.f399a || (iIndexOf2 = arrayList.indexOf(hVar.f400b)) == -1 || !arrayList2.get(iIndexOf2).booleanValue()) {
                if (hVar.m554c() || (arrayList != null && hVar.f400b.m249a(arrayList, 0, arrayList.size()))) {
                    this.f347C.remove(i);
                    i--;
                    size--;
                    if (arrayList == null || hVar.f399a || (iIndexOf = arrayList.indexOf(hVar.f400b)) == -1 || !arrayList2.get(iIndexOf).booleanValue()) {
                        hVar.m555d();
                    } else {
                        hVar.m556e();
                    }
                }
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m461a(ArrayList<C0045c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4 = i;
        boolean z = arrayList.get(i4).f226t;
        if (this.f374z == null) {
            this.f374z = new ArrayList<>();
        } else {
            this.f374z.clear();
        }
        this.f374z.addAll(this.f354e);
        ComponentCallbacksC0049g componentCallbacksC0049gM550v = m550v();
        boolean z2 = false;
        for (int i5 = i4; i5 < i2; i5++) {
            C0045c c0045c = arrayList.get(i5);
            componentCallbacksC0049gM550v = !arrayList2.get(i5).booleanValue() ? c0045c.m241a(this.f374z, componentCallbacksC0049gM550v) : c0045c.m251b(this.f374z, componentCallbacksC0049gM550v);
            z2 = z2 || c0045c.f215i;
        }
        this.f374z.clear();
        if (!z) {
            C0060r.m581a(this, arrayList, arrayList2, i, i2, false);
        }
        m470b(arrayList, arrayList2, i, i2);
        if (z) {
            C0091b<ComponentCallbacksC0049g> c0091b = new C0091b<>();
            m467b(c0091b);
            int iM449a = m449a(arrayList, arrayList2, i, i2, c0091b);
            m458a(c0091b);
            i3 = iM449a;
        } else {
            i3 = i2;
        }
        if (i3 != i4 && z) {
            C0060r.m581a(this, arrayList, arrayList2, i, i3, true);
            m483a(this.f361l, true);
        }
        while (i4 < i2) {
            C0045c c0045c2 = arrayList.get(i4);
            if (arrayList2.get(i4).booleanValue() && c0045c2.f219m >= 0) {
                m510c(c0045c2.f219m);
                c0045c2.f219m = -1;
            }
            c0045c2.m242a();
            i4++;
        }
        if (z2) {
            m524g();
        }
    }

    /* JADX INFO: renamed from: a */
    static boolean m462a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            for (PropertyValuesHolder propertyValuesHolder : ((ValueAnimator) animator).getValues()) {
                if ("alpha".equals(propertyValuesHolder.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i = 0; i < childAnimations.size(); i++) {
                if (m462a(childAnimations.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    static boolean m463a(c cVar) {
        if (cVar.f391a instanceof AlphaAnimation) {
            return true;
        }
        if (!(cVar.f391a instanceof AnimationSet)) {
            return m462a(cVar.f392b);
        }
        List<Animation> animations = ((AnimationSet) cVar.f391a).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    static boolean m464a(View view, c cVar) {
        return view != null && cVar != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && C0124p.m966h(view) && m463a(cVar);
    }

    /* JADX INFO: renamed from: a */
    private boolean m465a(String str, int i, int i2) {
        AbstractC0054l abstractC0054lM345j;
        m520e();
        m471c(true);
        if (this.f365p != null && i < 0 && str == null && (abstractC0054lM345j = this.f365p.m345j()) != null && abstractC0054lM345j.mo428a()) {
            return true;
        }
        boolean zM500a = m500a(this.f372x, this.f373y, str, i, i2);
        if (zM500a) {
            this.f352c = true;
            try {
                m469b(this.f372x, this.f373y);
            } finally {
                m478z();
            }
        }
        m521f();
        m448C();
        return zM500a;
    }

    /* JADX INFO: renamed from: b */
    public static int m466b(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        }
        if (i == 4099) {
            return z ? 5 : 6;
        }
        if (i != 8194) {
            return -1;
        }
        return z ? 3 : 4;
    }

    /* JADX INFO: renamed from: b */
    private void m467b(C0091b<ComponentCallbacksC0049g> c0091b) {
        if (this.f361l < 1) {
            return;
        }
        int iMin = Math.min(this.f361l, 4);
        int size = this.f354e.size();
        for (int i = 0; i < size; i++) {
            ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(i);
            if (componentCallbacksC0049g.f271b < iMin) {
                m489a(componentCallbacksC0049g, iMin, componentCallbacksC0049g.m280O(), componentCallbacksC0049g.m281P(), false);
                if (componentCallbacksC0049g.f259J != null && !componentCallbacksC0049g.f251B && componentCallbacksC0049g.f265P) {
                    c0091b.add(componentCallbacksC0049g);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m468b(View view, c cVar) {
        if (view == null || cVar == null || !m464a(view, cVar)) {
            return;
        }
        if (cVar.f392b != null) {
            cVar.f392b.addListener(new d(view));
            return;
        }
        Animation.AnimationListener animationListenerM452a = m452a(cVar.f391a);
        view.setLayerType(2, null);
        cVar.f391a.setAnimationListener(new a(view, animationListenerM452a));
    }

    /* JADX INFO: renamed from: b */
    private void m469b(ArrayList<C0045c> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 == null || arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        m460a(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!arrayList.get(i).f226t) {
                if (i2 != i) {
                    m461a(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (arrayList2.get(i).booleanValue()) {
                    while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).f226t) {
                        i2++;
                    }
                }
                m461a(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            m461a(arrayList, arrayList2, i2, size);
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m470b(ArrayList<C0045c> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            C0045c c0045c = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                c0045c.m243a(-1);
                c0045c.m248a(i == i2 + (-1));
            } else {
                c0045c.m243a(1);
                c0045c.m252b();
            }
            i++;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m471c(boolean z) {
        if (this.f352c) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f362m == null) {
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        if (Looper.myLooper() != this.f362m.m425h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z) {
            m476x();
        }
        if (this.f372x == null) {
            this.f372x = new ArrayList<>();
            this.f373y = new ArrayList<>();
        }
        this.f352c = true;
        try {
            m460a((ArrayList<C0045c>) null, (ArrayList<Boolean>) null);
        } finally {
            this.f352c = false;
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m472c(ArrayList<C0045c> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.f351b != null && this.f351b.size() != 0) {
                int size = this.f351b.size();
                boolean zMo250a = false;
                for (int i = 0; i < size; i++) {
                    zMo250a |= this.f351b.get(i).mo250a(arrayList, arrayList2);
                }
                this.f351b.clear();
                this.f362m.m425h().removeCallbacks(this.f349E);
                return zMo250a;
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    public static int m473d(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    /* JADX INFO: renamed from: e */
    private void m474e(int i) {
        try {
            this.f352c = true;
            m483a(i, false);
            this.f352c = false;
            m520e();
        } catch (Throwable th) {
            this.f352c = false;
            throw th;
        }
    }

    /* JADX INFO: renamed from: p */
    private ComponentCallbacksC0049g m475p(ComponentCallbacksC0049g componentCallbacksC0049g) {
        ViewGroup viewGroup = componentCallbacksC0049g.f258I;
        View view = componentCallbacksC0049g.f259J;
        if (viewGroup != null && view != null) {
            for (int iIndexOf = this.f354e.indexOf(componentCallbacksC0049g) - 1; iIndexOf >= 0; iIndexOf--) {
                ComponentCallbacksC0049g componentCallbacksC0049g2 = this.f354e.get(iIndexOf);
                if (componentCallbacksC0049g2.f258I == viewGroup && componentCallbacksC0049g2.f259J != null) {
                    return componentCallbacksC0049g2;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: x */
    private void m476x() {
        if (mo430c()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.f370v == null) {
            return;
        }
        throw new IllegalStateException("Can not perform this action inside of " + this.f370v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: y */
    public void m477y() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.f347C == null || this.f347C.isEmpty()) ? false : true;
            if (this.f351b != null && this.f351b.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.f362m.m425h().removeCallbacks(this.f349E);
                this.f362m.m425h().post(this.f349E);
            }
        }
    }

    /* JADX INFO: renamed from: z */
    private void m478z() {
        this.f352c = false;
        this.f373y.clear();
        this.f372x.clear();
    }

    /* JADX INFO: renamed from: a */
    public ComponentCallbacksC0049g m479a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        ComponentCallbacksC0049g componentCallbacksC0049g = this.f355f.get(i);
        if (componentCallbacksC0049g == null) {
            m459a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        return componentCallbacksC0049g;
    }

    /* JADX INFO: renamed from: a */
    public ComponentCallbacksC0049g m480a(String str) {
        if (str != null) {
            for (int size = this.f354e.size() - 1; size >= 0; size--) {
                ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(size);
                if (componentCallbacksC0049g != null && str.equals(componentCallbacksC0049g.f250A)) {
                    return componentCallbacksC0049g;
                }
            }
        }
        if (this.f355f == null || str == null) {
            return null;
        }
        for (int size2 = this.f355f.size() - 1; size2 >= 0; size2--) {
            ComponentCallbacksC0049g componentCallbacksC0049gValueAt = this.f355f.valueAt(size2);
            if (componentCallbacksC0049gValueAt != null && str.equals(componentCallbacksC0049gValueAt.f250A)) {
                return componentCallbacksC0049gValueAt;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    c m481a(ComponentCallbacksC0049g componentCallbacksC0049g, int i, boolean z, int i2) {
        int iM466b;
        int iM280O = componentCallbacksC0049g.m280O();
        Animation animationM292a = componentCallbacksC0049g.m292a(i, z, iM280O);
        if (animationM292a != null) {
            return new c(animationM292a);
        }
        Animator animatorM314b = componentCallbacksC0049g.m314b(i, z, iM280O);
        if (animatorM314b != null) {
            return new c(animatorM314b);
        }
        if (iM280O != 0) {
            boolean zEquals = "anim".equals(this.f362m.m424g().getResources().getResourceTypeName(iM280O));
            boolean z2 = false;
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(this.f362m.m424g(), iM280O);
                    if (animationLoadAnimation != null) {
                        return new c(animationLoadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(this.f362m.m424g(), iM280O);
                    if (animatorLoadAnimator != null) {
                        return new c(animatorLoadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (zEquals) {
                        throw e3;
                    }
                    Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(this.f362m.m424g(), iM280O);
                    if (animationLoadAnimation2 != null) {
                        return new c(animationLoadAnimation2);
                    }
                }
            }
        }
        if (i == 0 || (iM466b = m466b(i, z)) < 0) {
            return null;
        }
        switch (iM466b) {
            case 1:
                return m451a(this.f362m.m424g(), 1.125f, 1.0f, 0.0f, 1.0f);
            case 2:
                return m451a(this.f362m.m424g(), 1.0f, 0.975f, 1.0f, 0.0f);
            case 3:
                return m451a(this.f362m.m424g(), 0.975f, 1.0f, 0.0f, 1.0f);
            case 4:
                return m451a(this.f362m.m424g(), 1.0f, 1.075f, 1.0f, 0.0f);
            case 5:
                return m450a(this.f362m.m424g(), 0.0f, 1.0f);
            case 6:
                return m450a(this.f362m.m424g(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f362m.mo394d()) {
                    i2 = this.f362m.mo395e();
                }
                if (i2 == 0) {
                }
                return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m482a(int i, C0045c c0045c) {
        synchronized (this) {
            if (this.f358i == null) {
                this.f358i = new ArrayList<>();
            }
            int size = this.f358i.size();
            if (i < size) {
                if (f343a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0045c);
                }
                this.f358i.set(i, c0045c);
            } else {
                while (size < i) {
                    this.f358i.add(null);
                    if (this.f359j == null) {
                        this.f359j = new ArrayList<>();
                    }
                    if (f343a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f359j.add(Integer.valueOf(size));
                    size++;
                }
                if (f343a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0045c);
                }
                this.f358i.add(c0045c);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m483a(int i, boolean z) {
        if (this.f362m == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.f361l) {
            this.f361l = i;
            if (this.f355f != null) {
                int size = this.f354e.size();
                for (int i2 = 0; i2 < size; i2++) {
                    m518e(this.f354e.get(i2));
                }
                int size2 = this.f355f.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    ComponentCallbacksC0049g componentCallbacksC0049gValueAt = this.f355f.valueAt(i3);
                    if (componentCallbacksC0049gValueAt != null && ((componentCallbacksC0049gValueAt.f282m || componentCallbacksC0049gValueAt.f252C) && !componentCallbacksC0049gValueAt.f265P)) {
                        m518e(componentCallbacksC0049gValueAt);
                    }
                }
                m514d();
                if (this.f366r && this.f362m != null && this.f361l == 5) {
                    this.f362m.mo393c();
                    this.f366r = false;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m484a(Configuration configuration) {
        for (int i = 0; i < this.f354e.size(); i++) {
            ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(i);
            if (componentCallbacksC0049g != null) {
                componentCallbacksC0049g.m303a(configuration);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m485a(Bundle bundle, String str, ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (componentCallbacksC0049g.f275f < 0) {
            m459a(new IllegalStateException("Fragment " + componentCallbacksC0049g + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, componentCallbacksC0049g.f275f);
    }

    /* JADX INFO: renamed from: a */
    void m486a(Parcelable parcelable, C0056n c0056n) {
        List<C0056n> listM558b;
        List<C0022p> listM559c;
        if (parcelable == null) {
            return;
        }
        C0057o c0057o = (C0057o) parcelable;
        if (c0057o.f405a == null) {
            return;
        }
        if (c0056n != null) {
            List<ComponentCallbacksC0049g> listM557a = c0056n.m557a();
            listM558b = c0056n.m558b();
            listM559c = c0056n.m559c();
            int size = listM557a != null ? listM557a.size() : 0;
            for (int i = 0; i < size; i++) {
                ComponentCallbacksC0049g componentCallbacksC0049g = listM557a.get(i);
                if (f343a) {
                    Log.v("FragmentManager", "restoreAllState: re-attaching retained " + componentCallbacksC0049g);
                }
                int i2 = 0;
                while (i2 < c0057o.f405a.length && c0057o.f405a[i2].f411b != componentCallbacksC0049g.f275f) {
                    i2++;
                }
                if (i2 == c0057o.f405a.length) {
                    m459a(new IllegalStateException("Could not find active fragment with index " + componentCallbacksC0049g.f275f));
                }
                C0058p c0058p = c0057o.f405a[i2];
                c0058p.f421l = componentCallbacksC0049g;
                componentCallbacksC0049g.f273d = null;
                componentCallbacksC0049g.f287r = 0;
                componentCallbacksC0049g.f284o = false;
                componentCallbacksC0049g.f281l = false;
                componentCallbacksC0049g.f278i = null;
                if (c0058p.f420k != null) {
                    c0058p.f420k.setClassLoader(this.f362m.m424g().getClassLoader());
                    componentCallbacksC0049g.f273d = c0058p.f420k.getSparseParcelableArray("android:view_state");
                    componentCallbacksC0049g.f272c = c0058p.f420k;
                }
            }
        } else {
            listM558b = null;
            listM559c = null;
        }
        this.f355f = new SparseArray<>(c0057o.f405a.length);
        int i3 = 0;
        while (i3 < c0057o.f405a.length) {
            C0058p c0058p2 = c0057o.f405a[i3];
            if (c0058p2 != null) {
                ComponentCallbacksC0049g componentCallbacksC0049gM562a = c0058p2.m562a(this.f362m, this.f363n, this.f364o, (listM558b == null || i3 >= listM558b.size()) ? null : listM558b.get(i3), (listM559c == null || i3 >= listM559c.size()) ? null : listM559c.get(i3));
                if (f343a) {
                    Log.v("FragmentManager", "restoreAllState: active #" + i3 + ": " + componentCallbacksC0049gM562a);
                }
                this.f355f.put(componentCallbacksC0049gM562a.f275f, componentCallbacksC0049gM562a);
                c0058p2.f421l = null;
            }
            i3++;
        }
        if (c0056n != null) {
            List<ComponentCallbacksC0049g> listM557a2 = c0056n.m557a();
            int size2 = listM557a2 != null ? listM557a2.size() : 0;
            for (int i4 = 0; i4 < size2; i4++) {
                ComponentCallbacksC0049g componentCallbacksC0049g2 = listM557a2.get(i4);
                if (componentCallbacksC0049g2.f279j >= 0) {
                    componentCallbacksC0049g2.f278i = this.f355f.get(componentCallbacksC0049g2.f279j);
                    if (componentCallbacksC0049g2.f278i == null) {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + componentCallbacksC0049g2 + " target no longer exists: " + componentCallbacksC0049g2.f279j);
                    }
                }
            }
        }
        this.f354e.clear();
        if (c0057o.f406b != null) {
            for (int i5 = 0; i5 < c0057o.f406b.length; i5++) {
                ComponentCallbacksC0049g componentCallbacksC0049g3 = this.f355f.get(c0057o.f406b[i5]);
                if (componentCallbacksC0049g3 == null) {
                    m459a(new IllegalStateException("No instantiated fragment for index #" + c0057o.f406b[i5]));
                }
                componentCallbacksC0049g3.f281l = true;
                if (f343a) {
                    Log.v("FragmentManager", "restoreAllState: added #" + i5 + ": " + componentCallbacksC0049g3);
                }
                if (this.f354e.contains(componentCallbacksC0049g3)) {
                    throw new IllegalStateException("Already added!");
                }
                synchronized (this.f354e) {
                    this.f354e.add(componentCallbacksC0049g3);
                }
            }
        }
        if (c0057o.f407c != null) {
            this.f356g = new ArrayList<>(c0057o.f407c.length);
            for (int i6 = 0; i6 < c0057o.f407c.length; i6++) {
                C0045c c0045cM256a = c0057o.f407c[i6].m256a(this);
                if (f343a) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i6 + " (index " + c0045cM256a.f219m + "): " + c0045cM256a);
                    PrintWriter printWriter = new PrintWriter(new C0094e("FragmentManager"));
                    c0045cM256a.m247a("  ", printWriter, false);
                    printWriter.close();
                }
                this.f356g.add(c0045cM256a);
                if (c0045cM256a.f219m >= 0) {
                    m482a(c0045cM256a.f219m, c0045cM256a);
                }
            }
        } else {
            this.f356g = null;
        }
        if (c0057o.f408d >= 0) {
            this.f365p = this.f355f.get(c0057o.f408d);
        }
        this.f353d = c0057o.f409e;
    }

    /* JADX INFO: renamed from: a */
    void m487a(C0045c c0045c) {
        if (this.f356g == null) {
            this.f356g = new ArrayList<>();
        }
        this.f356g.add(c0045c);
    }

    /* JADX INFO: renamed from: a */
    public void m488a(ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (componentCallbacksC0049g.f261L) {
            if (this.f352c) {
                this.f371w = true;
            } else {
                componentCallbacksC0049g.f261L = false;
                m489a(componentCallbacksC0049g, this.f361l, 0, 0, false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:219:0x045f A[FALL_THROUGH, PHI: r11
  0x045f: PHI (r11v2 int) = (r11v1 int), (r11v1 int), (r11v1 int), (r11v1 int), (r11v1 int), (r11v1 int), (r11v1 int), (r11v3 int), (r11v3 int) binds: [B:141:0x02fc, B:143:0x0300, B:191:0x03e9, B:213:0x044a, B:217:0x0454, B:216:0x0450, B:41:0x006b, B:135:0x02d2, B:139:0x02ee] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:226:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void m489a(ComponentCallbacksC0049g componentCallbacksC0049g, int i, int i2, int i3, boolean z) {
        int i4;
        ViewGroup viewGroup;
        String resourceName;
        int i5 = 1;
        if (!componentCallbacksC0049g.f281l || componentCallbacksC0049g.f252C) {
            i4 = i;
            if (i4 > 1) {
                i4 = 1;
            }
        } else {
            i4 = i;
        }
        if (componentCallbacksC0049g.f282m && i4 > componentCallbacksC0049g.f271b) {
            i4 = (componentCallbacksC0049g.f271b == 0 && componentCallbacksC0049g.m320b()) ? 1 : componentCallbacksC0049g.f271b;
        }
        int i6 = (!componentCallbacksC0049g.f261L || componentCallbacksC0049g.f271b >= 4 || i4 <= 3) ? i4 : 3;
        if (componentCallbacksC0049g.f271b > i6) {
            if (componentCallbacksC0049g.f271b > i6) {
                switch (componentCallbacksC0049g.f271b) {
                    case 5:
                        if (i6 < 5) {
                            if (f343a) {
                                Log.v("FragmentManager", "movefrom RESUMED: " + componentCallbacksC0049g);
                            }
                            componentCallbacksC0049g.m274I();
                            m517d(componentCallbacksC0049g, false);
                            break;
                        }
                    case 4:
                        if (i6 < 4) {
                            if (f343a) {
                                Log.v("FragmentManager", "movefrom STARTED: " + componentCallbacksC0049g);
                            }
                            componentCallbacksC0049g.m275J();
                            m519e(componentCallbacksC0049g, false);
                            break;
                        }
                    case 3:
                        if (i6 < 3) {
                            if (f343a) {
                                Log.v("FragmentManager", "movefrom STOPPED: " + componentCallbacksC0049g);
                            }
                            componentCallbacksC0049g.m276K();
                            break;
                        }
                    case 2:
                        if (i6 < 2) {
                            if (f343a) {
                                Log.v("FragmentManager", "movefrom ACTIVITY_CREATED: " + componentCallbacksC0049g);
                            }
                            if (componentCallbacksC0049g.f259J != null && this.f362m.mo390a(componentCallbacksC0049g) && componentCallbacksC0049g.f273d == null) {
                                m539m(componentCallbacksC0049g);
                            }
                            componentCallbacksC0049g.m277L();
                            m523f(componentCallbacksC0049g, false);
                            if (componentCallbacksC0049g.f259J != null && componentCallbacksC0049g.f258I != null) {
                                componentCallbacksC0049g.f258I.endViewTransition(componentCallbacksC0049g.f259J);
                                componentCallbacksC0049g.f259J.clearAnimation();
                                c cVarM481a = (this.f361l <= 0 || this.f369u || componentCallbacksC0049g.f259J.getVisibility() != 0 || componentCallbacksC0049g.f267R < 0.0f) ? null : m481a(componentCallbacksC0049g, i2, false, i3);
                                componentCallbacksC0049g.f267R = 0.0f;
                                if (cVarM481a != null) {
                                    m454a(componentCallbacksC0049g, cVarM481a, i6);
                                }
                                componentCallbacksC0049g.f258I.removeView(componentCallbacksC0049g.f259J);
                            }
                            componentCallbacksC0049g.f258I = null;
                            componentCallbacksC0049g.f259J = null;
                            componentCallbacksC0049g.f260K = null;
                            componentCallbacksC0049g.f284o = false;
                            break;
                        }
                    case 1:
                        if (i6 < 1) {
                            if (this.f369u) {
                                if (componentCallbacksC0049g.m285T() != null) {
                                    View viewM285T = componentCallbacksC0049g.m285T();
                                    componentCallbacksC0049g.m309a((View) null);
                                    viewM285T.clearAnimation();
                                } else if (componentCallbacksC0049g.m286U() != null) {
                                    Animator animatorM286U = componentCallbacksC0049g.m286U();
                                    componentCallbacksC0049g.m298a((Animator) null);
                                    animatorM286U.cancel();
                                }
                            }
                            if (componentCallbacksC0049g.m285T() == null && componentCallbacksC0049g.m286U() == null) {
                                if (f343a) {
                                    Log.v("FragmentManager", "movefrom CREATED: " + componentCallbacksC0049g);
                                }
                                if (componentCallbacksC0049g.f254E) {
                                    componentCallbacksC0049g.f271b = 0;
                                } else {
                                    componentCallbacksC0049g.m278M();
                                    m526g(componentCallbacksC0049g, false);
                                }
                                componentCallbacksC0049g.m279N();
                                m529h(componentCallbacksC0049g, false);
                                if (!z) {
                                    if (!componentCallbacksC0049g.f254E) {
                                        m525g(componentCallbacksC0049g);
                                    } else {
                                        componentCallbacksC0049g.f289t = null;
                                        componentCallbacksC0049g.f293x = null;
                                        componentCallbacksC0049g.f288s = null;
                                    }
                                }
                            } else {
                                componentCallbacksC0049g.m316b(i6);
                            }
                            break;
                        }
                }
            }
            if (componentCallbacksC0049g.f271b != i5) {
            }
        } else {
            if (componentCallbacksC0049g.f283n && !componentCallbacksC0049g.f284o) {
                return;
            }
            if (componentCallbacksC0049g.m285T() != null || componentCallbacksC0049g.m286U() != null) {
                componentCallbacksC0049g.m309a((View) null);
                componentCallbacksC0049g.m298a((Animator) null);
                m489a(componentCallbacksC0049g, componentCallbacksC0049g.m287V(), 0, 0, true);
            }
            switch (componentCallbacksC0049g.f271b) {
                case 0:
                    if (i6 > 0) {
                        if (f343a) {
                            Log.v("FragmentManager", "moveto CREATED: " + componentCallbacksC0049g);
                        }
                        if (componentCallbacksC0049g.f272c != null) {
                            componentCallbacksC0049g.f272c.setClassLoader(this.f362m.m424g().getClassLoader());
                            componentCallbacksC0049g.f273d = componentCallbacksC0049g.f272c.getSparseParcelableArray("android:view_state");
                            componentCallbacksC0049g.f278i = m479a(componentCallbacksC0049g.f272c, "android:target_state");
                            if (componentCallbacksC0049g.f278i != null) {
                                componentCallbacksC0049g.f280k = componentCallbacksC0049g.f272c.getInt("android:target_req_state", 0);
                            }
                            if (componentCallbacksC0049g.f274e != null) {
                                componentCallbacksC0049g.f262M = componentCallbacksC0049g.f274e.booleanValue();
                                componentCallbacksC0049g.f274e = null;
                            } else {
                                componentCallbacksC0049g.f262M = componentCallbacksC0049g.f272c.getBoolean("android:user_visible_hint", true);
                            }
                            if (!componentCallbacksC0049g.f262M) {
                                componentCallbacksC0049g.f261L = true;
                                if (i6 > 3) {
                                    i6 = 3;
                                }
                            }
                        }
                        componentCallbacksC0049g.f289t = this.f362m;
                        componentCallbacksC0049g.f293x = this.f364o;
                        componentCallbacksC0049g.f288s = this.f364o != null ? this.f364o.f290u : this.f362m.m426i();
                        if (componentCallbacksC0049g.f278i != null) {
                            if (this.f355f.get(componentCallbacksC0049g.f278i.f275f) != componentCallbacksC0049g.f278i) {
                                throw new IllegalStateException("Fragment " + componentCallbacksC0049g + " declared target fragment " + componentCallbacksC0049g.f278i + " that does not belong to this FragmentManager!");
                            }
                            if (componentCallbacksC0049g.f278i.f271b < 1) {
                                m489a(componentCallbacksC0049g.f278i, 1, 0, 0, true);
                            }
                        }
                        m490a(componentCallbacksC0049g, this.f362m.m424g(), false);
                        componentCallbacksC0049g.f257H = false;
                        componentCallbacksC0049g.m301a(this.f362m.m424g());
                        if (!componentCallbacksC0049g.f257H) {
                            throw new C0067y("Fragment " + componentCallbacksC0049g + " did not call through to super.onAttach()");
                        }
                        if (componentCallbacksC0049g.f293x == null) {
                            this.f362m.mo392b(componentCallbacksC0049g);
                        } else {
                            componentCallbacksC0049g.f293x.m306a(componentCallbacksC0049g);
                        }
                        m504b(componentCallbacksC0049g, this.f362m.m424g(), false);
                        if (componentCallbacksC0049g.f269T) {
                            componentCallbacksC0049g.m340g(componentCallbacksC0049g.f272c);
                            componentCallbacksC0049g.f271b = 1;
                        } else {
                            m491a(componentCallbacksC0049g, componentCallbacksC0049g.f272c, false);
                            componentCallbacksC0049g.m348k(componentCallbacksC0049g.f272c);
                            m505b(componentCallbacksC0049g, componentCallbacksC0049g.f272c, false);
                        }
                        componentCallbacksC0049g.f254E = false;
                        break;
                    }
                case 1:
                    m511c(componentCallbacksC0049g);
                    if (i6 > 1) {
                        if (f343a) {
                            Log.v("FragmentManager", "moveto ACTIVITY_CREATED: " + componentCallbacksC0049g);
                        }
                        if (!componentCallbacksC0049g.f283n) {
                            if (componentCallbacksC0049g.f295z != 0) {
                                if (componentCallbacksC0049g.f295z == -1) {
                                    m459a(new IllegalArgumentException("Cannot create fragment " + componentCallbacksC0049g + " for a container view with no id"));
                                }
                                viewGroup = (ViewGroup) this.f363n.mo367a(componentCallbacksC0049g.f295z);
                                if (viewGroup == null && !componentCallbacksC0049g.f285p) {
                                    try {
                                        resourceName = componentCallbacksC0049g.m339g().getResourceName(componentCallbacksC0049g.f295z);
                                    } catch (Resources.NotFoundException unused) {
                                        resourceName = "unknown";
                                    }
                                    m459a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(componentCallbacksC0049g.f295z) + " (" + resourceName + ") for fragment " + componentCallbacksC0049g));
                                }
                            } else {
                                viewGroup = null;
                            }
                            componentCallbacksC0049g.f258I = viewGroup;
                            componentCallbacksC0049g.f259J = componentCallbacksC0049g.m315b(componentCallbacksC0049g.m329d(componentCallbacksC0049g.f272c), viewGroup, componentCallbacksC0049g.f272c);
                            if (componentCallbacksC0049g.f259J != null) {
                                componentCallbacksC0049g.f260K = componentCallbacksC0049g.f259J;
                                componentCallbacksC0049g.f259J.setSaveFromParentEnabled(false);
                                if (viewGroup != null) {
                                    viewGroup.addView(componentCallbacksC0049g.f259J);
                                }
                                if (componentCallbacksC0049g.f251B) {
                                    componentCallbacksC0049g.f259J.setVisibility(8);
                                }
                                componentCallbacksC0049g.m310a(componentCallbacksC0049g.f259J, componentCallbacksC0049g.f272c);
                                m492a(componentCallbacksC0049g, componentCallbacksC0049g.f259J, componentCallbacksC0049g.f272c, false);
                                componentCallbacksC0049g.f265P = componentCallbacksC0049g.f259J.getVisibility() == 0 && componentCallbacksC0049g.f258I != null;
                            } else {
                                componentCallbacksC0049g.f260K = null;
                            }
                        }
                        componentCallbacksC0049g.m350l(componentCallbacksC0049g.f272c);
                        m512c(componentCallbacksC0049g, componentCallbacksC0049g.f272c, false);
                        if (componentCallbacksC0049g.f259J != null) {
                            componentCallbacksC0049g.m304a(componentCallbacksC0049g.f272c);
                        }
                        componentCallbacksC0049g.f272c = null;
                        break;
                    }
                case 2:
                    if (i6 > 2) {
                        componentCallbacksC0049g.f271b = 3;
                        break;
                    }
                case 3:
                    if (i6 > 3) {
                        if (f343a) {
                            Log.v("FragmentManager", "moveto STARTED: " + componentCallbacksC0049g);
                        }
                        componentCallbacksC0049g.m270E();
                        m506b(componentCallbacksC0049g, false);
                        break;
                    }
                case 4:
                    if (i6 > 4) {
                        if (f343a) {
                            Log.v("FragmentManager", "moveto RESUMED: " + componentCallbacksC0049g);
                        }
                        componentCallbacksC0049g.m271F();
                        m513c(componentCallbacksC0049g, false);
                        componentCallbacksC0049g.f272c = null;
                        componentCallbacksC0049g.f273d = null;
                        break;
                    }
                default:
                    i5 = i6;
                    if (componentCallbacksC0049g.f271b != i5) {
                        Log.w("FragmentManager", "moveToState: Fragment state for " + componentCallbacksC0049g + " not updated inline; expected state " + i5 + " found " + componentCallbacksC0049g.f271b);
                        componentCallbacksC0049g.f271b = i5;
                        return;
                    }
                    return;
            }
        }
        i5 = i6;
        if (componentCallbacksC0049g.f271b != i5) {
        }
    }

    /* JADX INFO: renamed from: a */
    void m490a(ComponentCallbacksC0049g componentCallbacksC0049g, Context context, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m490a(componentCallbacksC0049g, context, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m432a(this, componentCallbacksC0049g, context);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m491a(ComponentCallbacksC0049g componentCallbacksC0049g, Bundle bundle, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m491a(componentCallbacksC0049g, bundle, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m433a(this, componentCallbacksC0049g, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m492a(ComponentCallbacksC0049g componentCallbacksC0049g, View view, Bundle bundle, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m492a(componentCallbacksC0049g, view, bundle, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m434a(this, componentCallbacksC0049g, view, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m493a(ComponentCallbacksC0049g componentCallbacksC0049g, boolean z) {
        if (f343a) {
            Log.v("FragmentManager", "add: " + componentCallbacksC0049g);
        }
        m522f(componentCallbacksC0049g);
        if (componentCallbacksC0049g.f252C) {
            return;
        }
        if (this.f354e.contains(componentCallbacksC0049g)) {
            throw new IllegalStateException("Fragment already added: " + componentCallbacksC0049g);
        }
        synchronized (this.f354e) {
            this.f354e.add(componentCallbacksC0049g);
        }
        componentCallbacksC0049g.f281l = true;
        componentCallbacksC0049g.f282m = false;
        if (componentCallbacksC0049g.f259J == null) {
            componentCallbacksC0049g.f266Q = false;
        }
        if (componentCallbacksC0049g.f255F && componentCallbacksC0049g.f256G) {
            this.f366r = true;
        }
        if (z) {
            m503b(componentCallbacksC0049g);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m494a(AbstractC0053k abstractC0053k, AbstractC0051i abstractC0051i, ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (this.f362m != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f362m = abstractC0053k;
        this.f363n = abstractC0051i;
        this.f364o = componentCallbacksC0049g;
    }

    @Override // android.support.v4.app.AbstractC0054l
    /* JADX INFO: renamed from: a */
    public void mo427a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        if (this.f355f != null && (size5 = this.f355f.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size5; i++) {
                ComponentCallbacksC0049g componentCallbacksC0049gValueAt = this.f355f.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(componentCallbacksC0049gValueAt);
                if (componentCallbacksC0049gValueAt != null) {
                    componentCallbacksC0049gValueAt.m311a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.f354e.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size6; i2++) {
                ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(componentCallbacksC0049g.toString());
            }
        }
        if (this.f357h != null && (size4 = this.f357h.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                ComponentCallbacksC0049g componentCallbacksC0049g2 = this.f357h.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(componentCallbacksC0049g2.toString());
            }
        }
        if (this.f356g != null && (size3 = this.f356g.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                C0045c c0045c = this.f356g.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(c0045c.toString());
                c0045c.m246a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.f358i != null && (size2 = this.f358i.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    Object obj = (C0045c) this.f358i.get(i5);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println(obj);
                }
            }
            if (this.f359j != null && this.f359j.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f359j.toArray()));
            }
        }
        if (this.f351b != null && (size = this.f351b.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                Object obj2 = (g) this.f351b.get(i6);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println(obj2);
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f362m);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f363n);
        if (this.f364o != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f364o);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f361l);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f367s);
        printWriter.print(" mStopped=");
        printWriter.print(this.f368t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f369u);
        if (this.f366r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f366r);
        }
        if (this.f370v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f370v);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m495a(boolean z) {
        for (int size = this.f354e.size() - 1; size >= 0; size--) {
            ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(size);
            if (componentCallbacksC0049g != null) {
                componentCallbacksC0049g.m331d(z);
            }
        }
    }

    @Override // android.support.v4.app.AbstractC0054l
    /* JADX INFO: renamed from: a */
    public boolean mo428a() {
        m476x();
        return m465a((String) null, -1, 0);
    }

    /* JADX INFO: renamed from: a */
    boolean m496a(int i) {
        return this.f361l >= i;
    }

    /* JADX INFO: renamed from: a */
    public boolean m497a(Menu menu) {
        if (this.f361l < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f354e.size(); i++) {
            ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(i);
            if (componentCallbacksC0049g != null && componentCallbacksC0049g.m326c(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public boolean m498a(Menu menu, MenuInflater menuInflater) {
        if (this.f361l < 1) {
            return false;
        }
        ArrayList<ComponentCallbacksC0049g> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.f354e.size(); i++) {
            ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(i);
            if (componentCallbacksC0049g != null && componentCallbacksC0049g.m321b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(componentCallbacksC0049g);
                z = true;
            }
        }
        if (this.f357h != null) {
            for (int i2 = 0; i2 < this.f357h.size(); i2++) {
                ComponentCallbacksC0049g componentCallbacksC0049g2 = this.f357h.get(i2);
                if (arrayList == null || !arrayList.contains(componentCallbacksC0049g2)) {
                    componentCallbacksC0049g2.m359t();
                }
            }
        }
        this.f357h = arrayList;
        return z;
    }

    /* JADX INFO: renamed from: a */
    public boolean m499a(MenuItem menuItem) {
        if (this.f361l < 1) {
            return false;
        }
        for (int i = 0; i < this.f354e.size(); i++) {
            ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(i);
            if (componentCallbacksC0049g != null && componentCallbacksC0049g.m327c(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    boolean m500a(ArrayList<C0045c> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int size;
        if (this.f356g == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size2 = this.f356g.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.f356g.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                size = this.f356g.size() - 1;
                while (size >= 0) {
                    C0045c c0045c = this.f356g.get(size);
                    if ((str != null && str.equals(c0045c.m255d())) || (i >= 0 && i == c0045c.f219m)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        C0045c c0045c2 = this.f356g.get(size);
                        if (str == null || !str.equals(c0045c2.m255d())) {
                            if (i < 0 || i != c0045c2.f219m) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.f356g.size() - 1) {
                return false;
            }
            for (int size3 = this.f356g.size() - 1; size3 > size; size3--) {
                arrayList.add(this.f356g.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public ComponentCallbacksC0049g m501b(int i) {
        for (int size = this.f354e.size() - 1; size >= 0; size--) {
            ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(size);
            if (componentCallbacksC0049g != null && componentCallbacksC0049g.f294y == i) {
                return componentCallbacksC0049g;
            }
        }
        if (this.f355f == null) {
            return null;
        }
        for (int size2 = this.f355f.size() - 1; size2 >= 0; size2--) {
            ComponentCallbacksC0049g componentCallbacksC0049gValueAt = this.f355f.valueAt(size2);
            if (componentCallbacksC0049gValueAt != null && componentCallbacksC0049gValueAt.f294y == i) {
                return componentCallbacksC0049gValueAt;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public ComponentCallbacksC0049g m502b(String str) {
        ComponentCallbacksC0049g componentCallbacksC0049gM290a;
        if (this.f355f == null || str == null) {
            return null;
        }
        for (int size = this.f355f.size() - 1; size >= 0; size--) {
            ComponentCallbacksC0049g componentCallbacksC0049gValueAt = this.f355f.valueAt(size);
            if (componentCallbacksC0049gValueAt != null && (componentCallbacksC0049gM290a = componentCallbacksC0049gValueAt.m290a(str)) != null) {
                return componentCallbacksC0049gM290a;
            }
        }
        return null;
    }

    @Override // android.support.v4.app.AbstractC0054l
    /* JADX INFO: renamed from: b */
    public List<ComponentCallbacksC0049g> mo429b() {
        List<ComponentCallbacksC0049g> list;
        if (this.f354e.isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (this.f354e) {
            list = (List) this.f354e.clone();
        }
        return list;
    }

    /* JADX INFO: renamed from: b */
    void m503b(ComponentCallbacksC0049g componentCallbacksC0049g) {
        m489a(componentCallbacksC0049g, this.f361l, 0, 0, false);
    }

    /* JADX INFO: renamed from: b */
    void m504b(ComponentCallbacksC0049g componentCallbacksC0049g, Context context, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m504b(componentCallbacksC0049g, context, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m436b(this, componentCallbacksC0049g, context);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m505b(ComponentCallbacksC0049g componentCallbacksC0049g, Bundle bundle, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m505b(componentCallbacksC0049g, bundle, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m437b(this, componentCallbacksC0049g, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m506b(ComponentCallbacksC0049g componentCallbacksC0049g, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m506b(componentCallbacksC0049g, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m431a(this, componentCallbacksC0049g);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m507b(Menu menu) {
        if (this.f361l < 1) {
            return;
        }
        for (int i = 0; i < this.f354e.size(); i++) {
            ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(i);
            if (componentCallbacksC0049g != null) {
                componentCallbacksC0049g.m330d(menu);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m508b(boolean z) {
        for (int size = this.f354e.size() - 1; size >= 0; size--) {
            ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(size);
            if (componentCallbacksC0049g != null) {
                componentCallbacksC0049g.m335e(z);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m509b(MenuItem menuItem) {
        if (this.f361l < 1) {
            return false;
        }
        for (int i = 0; i < this.f354e.size(); i++) {
            ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(i);
            if (componentCallbacksC0049g != null && componentCallbacksC0049g.m332d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    public void m510c(int i) {
        synchronized (this) {
            this.f358i.set(i, null);
            if (this.f359j == null) {
                this.f359j = new ArrayList<>();
            }
            if (f343a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f359j.add(Integer.valueOf(i));
        }
    }

    /* JADX INFO: renamed from: c */
    void m511c(ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (!componentCallbacksC0049g.f283n || componentCallbacksC0049g.f286q) {
            return;
        }
        componentCallbacksC0049g.f259J = componentCallbacksC0049g.m315b(componentCallbacksC0049g.m329d(componentCallbacksC0049g.f272c), (ViewGroup) null, componentCallbacksC0049g.f272c);
        if (componentCallbacksC0049g.f259J == null) {
            componentCallbacksC0049g.f260K = null;
            return;
        }
        componentCallbacksC0049g.f260K = componentCallbacksC0049g.f259J;
        componentCallbacksC0049g.f259J.setSaveFromParentEnabled(false);
        if (componentCallbacksC0049g.f251B) {
            componentCallbacksC0049g.f259J.setVisibility(8);
        }
        componentCallbacksC0049g.m310a(componentCallbacksC0049g.f259J, componentCallbacksC0049g.f272c);
        m492a(componentCallbacksC0049g, componentCallbacksC0049g.f259J, componentCallbacksC0049g.f272c, false);
    }

    /* JADX INFO: renamed from: c */
    void m512c(ComponentCallbacksC0049g componentCallbacksC0049g, Bundle bundle, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m512c(componentCallbacksC0049g, bundle, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m439c(this, componentCallbacksC0049g, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    void m513c(ComponentCallbacksC0049g componentCallbacksC0049g, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m513c(componentCallbacksC0049g, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m435b(this, componentCallbacksC0049g);
            }
        }
    }

    @Override // android.support.v4.app.AbstractC0054l
    /* JADX INFO: renamed from: c */
    public boolean mo430c() {
        return this.f367s || this.f368t;
    }

    /* JADX INFO: renamed from: d */
    void m514d() {
        if (this.f355f == null) {
            return;
        }
        for (int i = 0; i < this.f355f.size(); i++) {
            ComponentCallbacksC0049g componentCallbacksC0049gValueAt = this.f355f.valueAt(i);
            if (componentCallbacksC0049gValueAt != null) {
                m488a(componentCallbacksC0049gValueAt);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    void m515d(final ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (componentCallbacksC0049g.f259J != null) {
            c cVarM481a = m481a(componentCallbacksC0049g, componentCallbacksC0049g.m281P(), !componentCallbacksC0049g.f251B, componentCallbacksC0049g.m282Q());
            if (cVarM481a == null || cVarM481a.f392b == null) {
                if (cVarM481a != null) {
                    m468b(componentCallbacksC0049g.f259J, cVarM481a);
                    componentCallbacksC0049g.f259J.startAnimation(cVarM481a.f391a);
                    cVarM481a.f391a.start();
                }
                componentCallbacksC0049g.f259J.setVisibility((!componentCallbacksC0049g.f251B || componentCallbacksC0049g.m289X()) ? 0 : 8);
                if (componentCallbacksC0049g.m289X()) {
                    componentCallbacksC0049g.m338f(false);
                }
            } else {
                cVarM481a.f392b.setTarget(componentCallbacksC0049g.f259J);
                if (!componentCallbacksC0049g.f251B) {
                    componentCallbacksC0049g.f259J.setVisibility(0);
                } else if (componentCallbacksC0049g.m289X()) {
                    componentCallbacksC0049g.m338f(false);
                } else {
                    final ViewGroup viewGroup = componentCallbacksC0049g.f258I;
                    final View view = componentCallbacksC0049g.f259J;
                    viewGroup.startViewTransition(view);
                    cVarM481a.f392b.addListener(new AnimatorListenerAdapter() { // from class: android.support.v4.app.m.4
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            viewGroup.endViewTransition(view);
                            animator.removeListener(this);
                            if (componentCallbacksC0049g.f259J != null) {
                                componentCallbacksC0049g.f259J.setVisibility(8);
                            }
                        }
                    });
                }
                m468b(componentCallbacksC0049g.f259J, cVarM481a);
                cVarM481a.f392b.start();
            }
        }
        if (componentCallbacksC0049g.f281l && componentCallbacksC0049g.f255F && componentCallbacksC0049g.f256G) {
            this.f366r = true;
        }
        componentCallbacksC0049g.f266Q = false;
        componentCallbacksC0049g.m312a(componentCallbacksC0049g.f251B);
    }

    /* JADX INFO: renamed from: d */
    void m516d(ComponentCallbacksC0049g componentCallbacksC0049g, Bundle bundle, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m516d(componentCallbacksC0049g, bundle, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m441d(this, componentCallbacksC0049g, bundle);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    void m517d(ComponentCallbacksC0049g componentCallbacksC0049g, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m517d(componentCallbacksC0049g, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m438c(this, componentCallbacksC0049g);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    void m518e(ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (componentCallbacksC0049g == null) {
            return;
        }
        int iMin = this.f361l;
        if (componentCallbacksC0049g.f282m) {
            iMin = componentCallbacksC0049g.m320b() ? Math.min(iMin, 1) : Math.min(iMin, 0);
        }
        m489a(componentCallbacksC0049g, iMin, componentCallbacksC0049g.m281P(), componentCallbacksC0049g.m282Q(), false);
        if (componentCallbacksC0049g.f259J != null) {
            ComponentCallbacksC0049g componentCallbacksC0049gM475p = m475p(componentCallbacksC0049g);
            if (componentCallbacksC0049gM475p != null) {
                View view = componentCallbacksC0049gM475p.f259J;
                ViewGroup viewGroup = componentCallbacksC0049g.f258I;
                int iIndexOfChild = viewGroup.indexOfChild(view);
                int iIndexOfChild2 = viewGroup.indexOfChild(componentCallbacksC0049g.f259J);
                if (iIndexOfChild2 < iIndexOfChild) {
                    viewGroup.removeViewAt(iIndexOfChild2);
                    viewGroup.addView(componentCallbacksC0049g.f259J, iIndexOfChild);
                }
            }
            if (componentCallbacksC0049g.f265P && componentCallbacksC0049g.f258I != null) {
                if (componentCallbacksC0049g.f267R > 0.0f) {
                    componentCallbacksC0049g.f259J.setAlpha(componentCallbacksC0049g.f267R);
                }
                componentCallbacksC0049g.f267R = 0.0f;
                componentCallbacksC0049g.f265P = false;
                c cVarM481a = m481a(componentCallbacksC0049g, componentCallbacksC0049g.m281P(), true, componentCallbacksC0049g.m282Q());
                if (cVarM481a != null) {
                    m468b(componentCallbacksC0049g.f259J, cVarM481a);
                    if (cVarM481a.f391a != null) {
                        componentCallbacksC0049g.f259J.startAnimation(cVarM481a.f391a);
                    } else {
                        cVarM481a.f392b.setTarget(componentCallbacksC0049g.f259J);
                        cVarM481a.f392b.start();
                    }
                }
            }
        }
        if (componentCallbacksC0049g.f266Q) {
            m515d(componentCallbacksC0049g);
        }
    }

    /* JADX INFO: renamed from: e */
    void m519e(ComponentCallbacksC0049g componentCallbacksC0049g, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m519e(componentCallbacksC0049g, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m440d(this, componentCallbacksC0049g);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public boolean m520e() {
        m471c(true);
        boolean z = false;
        while (m472c(this.f372x, this.f373y)) {
            this.f352c = true;
            try {
                m469b(this.f372x, this.f373y);
                m478z();
                z = true;
            } catch (Throwable th) {
                m478z();
                throw th;
            }
        }
        m521f();
        m448C();
        return z;
    }

    /* JADX INFO: renamed from: f */
    void m521f() {
        if (this.f371w) {
            this.f371w = false;
            m514d();
        }
    }

    /* JADX INFO: renamed from: f */
    void m522f(ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (componentCallbacksC0049g.f275f >= 0) {
            return;
        }
        int i = this.f353d;
        this.f353d = i + 1;
        componentCallbacksC0049g.m296a(i, this.f364o);
        if (this.f355f == null) {
            this.f355f = new SparseArray<>();
        }
        this.f355f.put(componentCallbacksC0049g.f275f, componentCallbacksC0049g);
        if (f343a) {
            Log.v("FragmentManager", "Allocated fragment index " + componentCallbacksC0049g);
        }
    }

    /* JADX INFO: renamed from: f */
    void m523f(ComponentCallbacksC0049g componentCallbacksC0049g, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m523f(componentCallbacksC0049g, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m442e(this, componentCallbacksC0049g);
            }
        }
    }

    /* JADX INFO: renamed from: g */
    void m524g() {
        if (this.f360k != null) {
            for (int i = 0; i < this.f360k.size(); i++) {
                this.f360k.get(i).m445a();
            }
        }
    }

    /* JADX INFO: renamed from: g */
    void m525g(ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (componentCallbacksC0049g.f275f < 0) {
            return;
        }
        if (f343a) {
            Log.v("FragmentManager", "Freeing fragment index " + componentCallbacksC0049g);
        }
        this.f355f.put(componentCallbacksC0049g.f275f, null);
        componentCallbacksC0049g.m357r();
    }

    /* JADX INFO: renamed from: g */
    void m526g(ComponentCallbacksC0049g componentCallbacksC0049g, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m526g(componentCallbacksC0049g, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m443f(this, componentCallbacksC0049g);
            }
        }
    }

    /* JADX INFO: renamed from: h */
    C0056n m527h() {
        m457a(this.f348D);
        return this.f348D;
    }

    /* JADX INFO: renamed from: h */
    public void m528h(ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (f343a) {
            Log.v("FragmentManager", "remove: " + componentCallbacksC0049g + " nesting=" + componentCallbacksC0049g.f287r);
        }
        boolean z = !componentCallbacksC0049g.m320b();
        if (!componentCallbacksC0049g.f252C || z) {
            synchronized (this.f354e) {
                this.f354e.remove(componentCallbacksC0049g);
            }
            if (componentCallbacksC0049g.f255F && componentCallbacksC0049g.f256G) {
                this.f366r = true;
            }
            componentCallbacksC0049g.f281l = false;
            componentCallbacksC0049g.f282m = true;
        }
    }

    /* JADX INFO: renamed from: h */
    void m529h(ComponentCallbacksC0049g componentCallbacksC0049g, boolean z) {
        if (this.f364o != null) {
            AbstractC0054l abstractC0054lM341h = this.f364o.m341h();
            if (abstractC0054lM341h instanceof LayoutInflaterFactory2C0055m) {
                ((LayoutInflaterFactory2C0055m) abstractC0054lM341h).m529h(componentCallbacksC0049g, true);
            }
        }
        for (C0098i<AbstractC0054l.a, Boolean> c0098i : this.f350J) {
            if (!z || c0098i.f622b.booleanValue()) {
                c0098i.f621a.m444g(this, componentCallbacksC0049g);
            }
        }
    }

    /* JADX INFO: renamed from: i */
    void m530i() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        C0056n c0056n;
        if (this.f355f != null) {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
            for (int i = 0; i < this.f355f.size(); i++) {
                ComponentCallbacksC0049g componentCallbacksC0049gValueAt = this.f355f.valueAt(i);
                if (componentCallbacksC0049gValueAt != null) {
                    if (componentCallbacksC0049gValueAt.f253D) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(componentCallbacksC0049gValueAt);
                        componentCallbacksC0049gValueAt.f279j = componentCallbacksC0049gValueAt.f278i != null ? componentCallbacksC0049gValueAt.f278i.f275f : -1;
                        if (f343a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + componentCallbacksC0049gValueAt);
                        }
                    }
                    if (componentCallbacksC0049gValueAt.f290u != null) {
                        componentCallbacksC0049gValueAt.f290u.m530i();
                        c0056n = componentCallbacksC0049gValueAt.f290u.f348D;
                    } else {
                        c0056n = componentCallbacksC0049gValueAt.f291v;
                    }
                    if (arrayList2 == null && c0056n != null) {
                        arrayList2 = new ArrayList(this.f355f.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(c0056n);
                    }
                    if (arrayList3 == null && componentCallbacksC0049gValueAt.f292w != null) {
                        arrayList3 = new ArrayList(this.f355f.size());
                        for (int i3 = 0; i3 < i; i3++) {
                            arrayList3.add(null);
                        }
                    }
                    if (arrayList3 != null) {
                        arrayList3.add(componentCallbacksC0049gValueAt.f292w);
                    }
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
        }
        if (arrayList == null && arrayList2 == null && arrayList3 == null) {
            this.f348D = null;
        } else {
            this.f348D = new C0056n(arrayList, arrayList2, arrayList3);
        }
    }

    /* JADX INFO: renamed from: i */
    public void m531i(ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (f343a) {
            Log.v("FragmentManager", "hide: " + componentCallbacksC0049g);
        }
        if (componentCallbacksC0049g.f251B) {
            return;
        }
        componentCallbacksC0049g.f251B = true;
        componentCallbacksC0049g.f266Q = true ^ componentCallbacksC0049g.f266Q;
    }

    /* JADX INFO: renamed from: j */
    Parcelable m532j() {
        int[] iArr;
        int size;
        m446A();
        m447B();
        m520e();
        this.f367s = true;
        C0046d[] c0046dArr = null;
        this.f348D = null;
        if (this.f355f == null || this.f355f.size() <= 0) {
            return null;
        }
        int size2 = this.f355f.size();
        C0058p[] c0058pArr = new C0058p[size2];
        boolean z = false;
        for (int i = 0; i < size2; i++) {
            ComponentCallbacksC0049g componentCallbacksC0049gValueAt = this.f355f.valueAt(i);
            if (componentCallbacksC0049gValueAt != null) {
                if (componentCallbacksC0049gValueAt.f275f < 0) {
                    m459a(new IllegalStateException("Failure saving state: active " + componentCallbacksC0049gValueAt + " has cleared index: " + componentCallbacksC0049gValueAt.f275f));
                }
                C0058p c0058p = new C0058p(componentCallbacksC0049gValueAt);
                c0058pArr[i] = c0058p;
                if (componentCallbacksC0049gValueAt.f271b <= 0 || c0058p.f420k != null) {
                    c0058p.f420k = componentCallbacksC0049gValueAt.f272c;
                } else {
                    c0058p.f420k = m540n(componentCallbacksC0049gValueAt);
                    if (componentCallbacksC0049gValueAt.f278i != null) {
                        if (componentCallbacksC0049gValueAt.f278i.f275f < 0) {
                            m459a(new IllegalStateException("Failure saving state: " + componentCallbacksC0049gValueAt + " has target not in fragment manager: " + componentCallbacksC0049gValueAt.f278i));
                        }
                        if (c0058p.f420k == null) {
                            c0058p.f420k = new Bundle();
                        }
                        m485a(c0058p.f420k, "android:target_state", componentCallbacksC0049gValueAt.f278i);
                        if (componentCallbacksC0049gValueAt.f280k != 0) {
                            c0058p.f420k.putInt("android:target_req_state", componentCallbacksC0049gValueAt.f280k);
                        }
                    }
                }
                if (f343a) {
                    Log.v("FragmentManager", "Saved state of " + componentCallbacksC0049gValueAt + ": " + c0058p.f420k);
                }
                z = true;
            }
        }
        if (!z) {
            if (f343a) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size3 = this.f354e.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i2 = 0; i2 < size3; i2++) {
                iArr[i2] = this.f354e.get(i2).f275f;
                if (iArr[i2] < 0) {
                    m459a(new IllegalStateException("Failure saving state: active " + this.f354e.get(i2) + " has cleared index: " + iArr[i2]));
                }
                if (f343a) {
                    Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f354e.get(i2));
                }
            }
        } else {
            iArr = null;
        }
        if (this.f356g != null && (size = this.f356g.size()) > 0) {
            c0046dArr = new C0046d[size];
            for (int i3 = 0; i3 < size; i3++) {
                c0046dArr[i3] = new C0046d(this.f356g.get(i3));
                if (f343a) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i3 + ": " + this.f356g.get(i3));
                }
            }
        }
        C0057o c0057o = new C0057o();
        c0057o.f405a = c0058pArr;
        c0057o.f406b = iArr;
        c0057o.f407c = c0046dArr;
        if (this.f365p != null) {
            c0057o.f408d = this.f365p.f275f;
        }
        c0057o.f409e = this.f353d;
        m530i();
        return c0057o;
    }

    /* JADX INFO: renamed from: j */
    public void m533j(ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (f343a) {
            Log.v("FragmentManager", "show: " + componentCallbacksC0049g);
        }
        if (componentCallbacksC0049g.f251B) {
            componentCallbacksC0049g.f251B = false;
            componentCallbacksC0049g.f266Q = !componentCallbacksC0049g.f266Q;
        }
    }

    /* JADX INFO: renamed from: k */
    public void m534k() {
        this.f348D = null;
        this.f367s = false;
        this.f368t = false;
        int size = this.f354e.size();
        for (int i = 0; i < size; i++) {
            ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(i);
            if (componentCallbacksC0049g != null) {
                componentCallbacksC0049g.m272G();
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public void m535k(ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (f343a) {
            Log.v("FragmentManager", "detach: " + componentCallbacksC0049g);
        }
        if (componentCallbacksC0049g.f252C) {
            return;
        }
        componentCallbacksC0049g.f252C = true;
        if (componentCallbacksC0049g.f281l) {
            if (f343a) {
                Log.v("FragmentManager", "remove from detach: " + componentCallbacksC0049g);
            }
            synchronized (this.f354e) {
                this.f354e.remove(componentCallbacksC0049g);
            }
            if (componentCallbacksC0049g.f255F && componentCallbacksC0049g.f256G) {
                this.f366r = true;
            }
            componentCallbacksC0049g.f281l = false;
        }
    }

    /* JADX INFO: renamed from: l */
    public void m536l() {
        this.f367s = false;
        this.f368t = false;
        m474e(1);
    }

    /* JADX INFO: renamed from: l */
    public void m537l(ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (f343a) {
            Log.v("FragmentManager", "attach: " + componentCallbacksC0049g);
        }
        if (componentCallbacksC0049g.f252C) {
            componentCallbacksC0049g.f252C = false;
            if (componentCallbacksC0049g.f281l) {
                return;
            }
            if (this.f354e.contains(componentCallbacksC0049g)) {
                throw new IllegalStateException("Fragment already added: " + componentCallbacksC0049g);
            }
            if (f343a) {
                Log.v("FragmentManager", "add from attach: " + componentCallbacksC0049g);
            }
            synchronized (this.f354e) {
                this.f354e.add(componentCallbacksC0049g);
            }
            componentCallbacksC0049g.f281l = true;
            if (componentCallbacksC0049g.f255F && componentCallbacksC0049g.f256G) {
                this.f366r = true;
            }
        }
    }

    /* JADX INFO: renamed from: m */
    public void m538m() {
        this.f367s = false;
        this.f368t = false;
        m474e(2);
    }

    /* JADX INFO: renamed from: m */
    void m539m(ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (componentCallbacksC0049g.f260K == null) {
            return;
        }
        if (this.f346B == null) {
            this.f346B = new SparseArray<>();
        } else {
            this.f346B.clear();
        }
        componentCallbacksC0049g.f260K.saveHierarchyState(this.f346B);
        if (this.f346B.size() > 0) {
            componentCallbacksC0049g.f273d = this.f346B;
            this.f346B = null;
        }
    }

    /* JADX INFO: renamed from: n */
    Bundle m540n(ComponentCallbacksC0049g componentCallbacksC0049g) {
        Bundle bundle;
        if (this.f345A == null) {
            this.f345A = new Bundle();
        }
        componentCallbacksC0049g.m352m(this.f345A);
        m516d(componentCallbacksC0049g, this.f345A, false);
        if (this.f345A.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f345A;
            this.f345A = null;
        }
        if (componentCallbacksC0049g.f259J != null) {
            m539m(componentCallbacksC0049g);
        }
        if (componentCallbacksC0049g.f273d != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", componentCallbacksC0049g.f273d);
        }
        if (!componentCallbacksC0049g.f262M) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", componentCallbacksC0049g.f262M);
        }
        return bundle;
    }

    /* JADX INFO: renamed from: n */
    public void m541n() {
        this.f367s = false;
        this.f368t = false;
        m474e(4);
    }

    /* JADX INFO: renamed from: o */
    public void m542o() {
        this.f367s = false;
        this.f368t = false;
        m474e(5);
    }

    /* JADX INFO: renamed from: o */
    public void m543o(ComponentCallbacksC0049g componentCallbacksC0049g) {
        if (componentCallbacksC0049g == null || (this.f355f.get(componentCallbacksC0049g.f275f) == componentCallbacksC0049g && (componentCallbacksC0049g.f289t == null || componentCallbacksC0049g.m341h() == this))) {
            this.f365p = componentCallbacksC0049g;
            return;
        }
        throw new IllegalArgumentException("Fragment " + componentCallbacksC0049g + " is not an active fragment of FragmentManager " + this);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        ComponentCallbacksC0049g componentCallbacksC0049g;
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.f398a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(0);
        }
        String str2 = attributeValue;
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        String string = typedArrayObtainStyledAttributes.getString(2);
        typedArrayObtainStyledAttributes.recycle();
        if (!ComponentCallbacksC0049g.m264a(this.f362m.m424g(), str2)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
        }
        ComponentCallbacksC0049g componentCallbacksC0049gM501b = resourceId != -1 ? m501b(resourceId) : null;
        if (componentCallbacksC0049gM501b == null && string != null) {
            componentCallbacksC0049gM501b = m480a(string);
        }
        if (componentCallbacksC0049gM501b == null && id != -1) {
            componentCallbacksC0049gM501b = m501b(id);
        }
        if (f343a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + componentCallbacksC0049gM501b);
        }
        if (componentCallbacksC0049gM501b == null) {
            ComponentCallbacksC0049g componentCallbacksC0049gMo366a = this.f363n.mo366a(context, str2, null);
            componentCallbacksC0049gMo366a.f283n = true;
            componentCallbacksC0049gMo366a.f294y = resourceId != 0 ? resourceId : id;
            componentCallbacksC0049gMo366a.f295z = id;
            componentCallbacksC0049gMo366a.f250A = string;
            componentCallbacksC0049gMo366a.f284o = true;
            componentCallbacksC0049gMo366a.f288s = this;
            componentCallbacksC0049gMo366a.f289t = this.f362m;
            componentCallbacksC0049gMo366a.m302a(this.f362m.m424g(), attributeSet, componentCallbacksC0049gMo366a.f272c);
            m493a(componentCallbacksC0049gMo366a, true);
            componentCallbacksC0049g = componentCallbacksC0049gMo366a;
        } else {
            if (componentCallbacksC0049gM501b.f284o) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
            }
            componentCallbacksC0049gM501b.f284o = true;
            componentCallbacksC0049gM501b.f289t = this.f362m;
            if (!componentCallbacksC0049gM501b.f254E) {
                componentCallbacksC0049gM501b.m302a(this.f362m.m424g(), attributeSet, componentCallbacksC0049gM501b.f272c);
            }
            componentCallbacksC0049g = componentCallbacksC0049gM501b;
        }
        if (this.f361l >= 1 || !componentCallbacksC0049g.f283n) {
            m503b(componentCallbacksC0049g);
        } else {
            m489a(componentCallbacksC0049g, 1, 0, 0, false);
        }
        if (componentCallbacksC0049g.f259J != null) {
            if (resourceId != 0) {
                componentCallbacksC0049g.f259J.setId(resourceId);
            }
            if (componentCallbacksC0049g.f259J.getTag() == null) {
                componentCallbacksC0049g.f259J.setTag(string);
            }
            return componentCallbacksC0049g.f259J;
        }
        throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX INFO: renamed from: p */
    public void m544p() {
        m474e(4);
    }

    /* JADX INFO: renamed from: q */
    public void m545q() {
        this.f368t = true;
        m474e(3);
    }

    /* JADX INFO: renamed from: r */
    public void m546r() {
        m474e(2);
    }

    /* JADX INFO: renamed from: s */
    public void m547s() {
        m474e(1);
    }

    /* JADX INFO: renamed from: t */
    public void m548t() {
        this.f369u = true;
        m520e();
        m474e(0);
        this.f362m = null;
        this.f363n = null;
        this.f364o = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C0093d.m785a(this.f364o != null ? this.f364o : this.f362m, sb);
        sb.append("}}");
        return sb.toString();
    }

    /* JADX INFO: renamed from: u */
    public void m549u() {
        for (int i = 0; i < this.f354e.size(); i++) {
            ComponentCallbacksC0049g componentCallbacksC0049g = this.f354e.get(i);
            if (componentCallbacksC0049g != null) {
                componentCallbacksC0049g.m273H();
            }
        }
    }

    /* JADX INFO: renamed from: v */
    public ComponentCallbacksC0049g m550v() {
        return this.f365p;
    }

    /* JADX INFO: renamed from: w */
    LayoutInflater.Factory2 m551w() {
        return this;
    }
}
