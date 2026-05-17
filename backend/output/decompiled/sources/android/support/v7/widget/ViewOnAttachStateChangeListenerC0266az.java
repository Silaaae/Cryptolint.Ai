package android.support.v7.widget;

import android.support.v4.p015g.C0124p;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;

/* JADX INFO: renamed from: android.support.v7.widget.az */
/* JADX INFO: loaded from: classes.dex */
class ViewOnAttachStateChangeListenerC0266az implements View.OnAttachStateChangeListener, View.OnHoverListener, View.OnLongClickListener {

    /* JADX INFO: renamed from: i */
    private static ViewOnAttachStateChangeListenerC0266az f1825i;

    /* JADX INFO: renamed from: j */
    private static ViewOnAttachStateChangeListenerC0266az f1826j;

    /* JADX INFO: renamed from: a */
    private final View f1827a;

    /* JADX INFO: renamed from: b */
    private final CharSequence f1828b;

    /* JADX INFO: renamed from: c */
    private final Runnable f1829c = new Runnable() { // from class: android.support.v7.widget.az.1
        @Override // java.lang.Runnable
        public void run() {
            ViewOnAttachStateChangeListenerC0266az.this.m2015a(false);
        }
    };

    /* JADX INFO: renamed from: d */
    private final Runnable f1830d = new Runnable() { // from class: android.support.v7.widget.az.2
        @Override // java.lang.Runnable
        public void run() {
            ViewOnAttachStateChangeListenerC0266az.this.m2011a();
        }
    };

    /* JADX INFO: renamed from: e */
    private int f1831e;

    /* JADX INFO: renamed from: f */
    private int f1832f;

    /* JADX INFO: renamed from: g */
    private C0268ba f1833g;

    /* JADX INFO: renamed from: h */
    private boolean f1834h;

    private ViewOnAttachStateChangeListenerC0266az(View view, CharSequence charSequence) {
        this.f1827a = view;
        this.f1828b = charSequence;
        this.f1827a.setOnLongClickListener(this);
        this.f1827a.setOnHoverListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2011a() {
        if (f1826j == this) {
            f1826j = null;
            if (this.f1833g != null) {
                this.f1833g.m2021a();
                this.f1833g = null;
                this.f1827a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1825i == this) {
            m2017b(null);
        }
        this.f1827a.removeCallbacks(this.f1830d);
    }

    /* JADX INFO: renamed from: a */
    public static void m2014a(View view, CharSequence charSequence) {
        if (f1825i != null && f1825i.f1827a == view) {
            m2017b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new ViewOnAttachStateChangeListenerC0266az(view, charSequence);
            return;
        }
        if (f1826j != null && f1826j.f1827a == view) {
            f1826j.m2011a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2015a(boolean z) {
        long longPressTimeout;
        if (C0124p.m971m(this.f1827a)) {
            m2017b(null);
            if (f1826j != null) {
                f1826j.m2011a();
            }
            f1826j = this;
            this.f1834h = z;
            this.f1833g = new C0268ba(this.f1827a.getContext());
            this.f1833g.m2022a(this.f1827a, this.f1831e, this.f1832f, this.f1834h, this.f1828b);
            this.f1827a.addOnAttachStateChangeListener(this);
            if (this.f1834h) {
                longPressTimeout = 2500;
            } else {
                longPressTimeout = ((C0124p.m964f(this.f1827a) & 1) == 1 ? 3000L : 15000L) - ((long) ViewConfiguration.getLongPressTimeout());
            }
            this.f1827a.removeCallbacks(this.f1830d);
            this.f1827a.postDelayed(this.f1830d, longPressTimeout);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2016b() {
        this.f1827a.postDelayed(this.f1829c, ViewConfiguration.getLongPressTimeout());
    }

    /* JADX INFO: renamed from: b */
    private static void m2017b(ViewOnAttachStateChangeListenerC0266az viewOnAttachStateChangeListenerC0266az) {
        if (f1825i != null) {
            f1825i.m2018c();
        }
        f1825i = viewOnAttachStateChangeListenerC0266az;
        if (f1825i != null) {
            f1825i.m2016b();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m2018c() {
        this.f1827a.removeCallbacks(this.f1829c);
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1833g != null && this.f1834h) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1827a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                m2011a();
            }
        } else if (this.f1827a.isEnabled() && this.f1833g == null) {
            this.f1831e = (int) motionEvent.getX();
            this.f1832f = (int) motionEvent.getY();
            m2017b(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1831e = view.getWidth() / 2;
        this.f1832f = view.getHeight() / 2;
        m2015a(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        m2011a();
    }
}
