package android.support.v7.widget;

import android.os.SystemClock;
import android.support.v7.view.menu.InterfaceC0207s;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* JADX INFO: renamed from: android.support.v7.widget.ai */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractViewOnAttachStateChangeListenerC0249ai implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a */
    private final float f1655a;

    /* JADX INFO: renamed from: b */
    private final int f1656b;

    /* JADX INFO: renamed from: c */
    final View f1657c;

    /* JADX INFO: renamed from: d */
    private final int f1658d;

    /* JADX INFO: renamed from: e */
    private Runnable f1659e;

    /* JADX INFO: renamed from: f */
    private Runnable f1660f;

    /* JADX INFO: renamed from: g */
    private boolean f1661g;

    /* JADX INFO: renamed from: h */
    private int f1662h;

    /* JADX INFO: renamed from: i */
    private final int[] f1663i = new int[2];

    /* JADX INFO: renamed from: android.support.v7.widget.ai$a */
    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = AbstractViewOnAttachStateChangeListenerC0249ai.this.f1657c.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ai$b */
    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractViewOnAttachStateChangeListenerC0249ai.this.m1879d();
        }
    }

    public AbstractViewOnAttachStateChangeListenerC0249ai(View view) {
        this.f1657c = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1655a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f1656b = ViewConfiguration.getTapTimeout();
        this.f1658d = (this.f1656b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: renamed from: a */
    private boolean m1872a(MotionEvent motionEvent) {
        View view = this.f1657c;
        if (!view.isEnabled()) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f1662h = motionEvent.getPointerId(0);
                if (this.f1659e == null) {
                    this.f1659e = new a();
                }
                view.postDelayed(this.f1659e, this.f1656b);
                if (this.f1660f == null) {
                    this.f1660f = new b();
                }
                view.postDelayed(this.f1660f, this.f1658d);
                return false;
            case 1:
            case 3:
                m1877e();
                return false;
            case 2:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f1662h);
                if (iFindPointerIndex >= 0 && !m1873a(view, motionEvent.getX(iFindPointerIndex), motionEvent.getY(iFindPointerIndex), this.f1655a)) {
                    m1877e();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1873a(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    /* JADX INFO: renamed from: a */
    private boolean m1874a(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1663i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }

    /* JADX INFO: renamed from: b */
    private boolean m1875b(MotionEvent motionEvent) {
        C0247ag c0247ag;
        View view = this.f1657c;
        InterfaceC0207s interfaceC0207sMo1452a = mo1452a();
        if (interfaceC0207sMo1452a == null || !interfaceC0207sMo1452a.mo1507d() || (c0247ag = (C0247ag) interfaceC0207sMo1452a.mo1508e()) == null || !c0247ag.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m1876b(view, motionEventObtainNoHistory);
        m1874a(c0247ag, motionEventObtainNoHistory);
        boolean zMo1868a = c0247ag.mo1868a(motionEventObtainNoHistory, this.f1662h);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zMo1868a && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX INFO: renamed from: b */
    private boolean m1876b(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f1663i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    /* JADX INFO: renamed from: e */
    private void m1877e() {
        if (this.f1660f != null) {
            this.f1657c.removeCallbacks(this.f1660f);
        }
        if (this.f1659e != null) {
            this.f1657c.removeCallbacks(this.f1659e);
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract InterfaceC0207s mo1452a();

    /* JADX INFO: renamed from: b */
    protected boolean mo1453b() {
        InterfaceC0207s interfaceC0207sMo1452a = mo1452a();
        if (interfaceC0207sMo1452a == null || interfaceC0207sMo1452a.mo1507d()) {
            return true;
        }
        interfaceC0207sMo1452a.mo1497a();
        return true;
    }

    /* JADX INFO: renamed from: c */
    protected boolean mo1878c() {
        InterfaceC0207s interfaceC0207sMo1452a = mo1452a();
        if (interfaceC0207sMo1452a == null || !interfaceC0207sMo1452a.mo1507d()) {
            return true;
        }
        interfaceC0207sMo1452a.mo1504c();
        return true;
    }

    /* JADX INFO: renamed from: d */
    void m1879d() {
        m1877e();
        View view = this.f1657c;
        if (view.isEnabled() && !view.isLongClickable() && mo1453b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f1661g = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f1661g;
        if (z2) {
            z = m1875b(motionEvent) || !mo1878c();
        } else {
            z = m1872a(motionEvent) && mo1453b();
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1657c.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f1661g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1661g = false;
        this.f1662h = -1;
        if (this.f1659e != null) {
            this.f1657c.removeCallbacks(this.f1659e);
        }
    }
}
