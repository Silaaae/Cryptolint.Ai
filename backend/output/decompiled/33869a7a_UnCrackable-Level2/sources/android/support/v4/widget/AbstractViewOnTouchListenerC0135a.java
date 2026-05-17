package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.p015g.C0124p;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: renamed from: android.support.v4.widget.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC0135a implements View.OnTouchListener {

    /* JADX INFO: renamed from: r */
    private static final int f721r = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: b */
    final View f723b;

    /* JADX INFO: renamed from: c */
    boolean f724c;

    /* JADX INFO: renamed from: d */
    boolean f725d;

    /* JADX INFO: renamed from: e */
    boolean f726e;

    /* JADX INFO: renamed from: g */
    private Runnable f728g;

    /* JADX INFO: renamed from: j */
    private int f731j;

    /* JADX INFO: renamed from: k */
    private int f732k;

    /* JADX INFO: renamed from: o */
    private boolean f736o;

    /* JADX INFO: renamed from: p */
    private boolean f737p;

    /* JADX INFO: renamed from: q */
    private boolean f738q;

    /* JADX INFO: renamed from: a */
    final a f722a = new a();

    /* JADX INFO: renamed from: f */
    private final Interpolator f727f = new AccelerateInterpolator();

    /* JADX INFO: renamed from: h */
    private float[] f729h = {0.0f, 0.0f};

    /* JADX INFO: renamed from: i */
    private float[] f730i = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: l */
    private float[] f733l = {0.0f, 0.0f};

    /* JADX INFO: renamed from: m */
    private float[] f734m = {0.0f, 0.0f};

    /* JADX INFO: renamed from: n */
    private float[] f735n = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: android.support.v4.widget.a$a */
    private static class a {

        /* JADX INFO: renamed from: a */
        private int f739a;

        /* JADX INFO: renamed from: b */
        private int f740b;

        /* JADX INFO: renamed from: c */
        private float f741c;

        /* JADX INFO: renamed from: d */
        private float f742d;

        /* JADX INFO: renamed from: j */
        private float f748j;

        /* JADX INFO: renamed from: k */
        private int f749k;

        /* JADX INFO: renamed from: e */
        private long f743e = Long.MIN_VALUE;

        /* JADX INFO: renamed from: i */
        private long f747i = -1;

        /* JADX INFO: renamed from: f */
        private long f744f = 0;

        /* JADX INFO: renamed from: g */
        private int f745g = 0;

        /* JADX INFO: renamed from: h */
        private int f746h = 0;

        a() {
        }

        /* JADX INFO: renamed from: a */
        private float m1095a(float f) {
            return ((-4.0f) * f * f) + (f * 4.0f);
        }

        /* JADX INFO: renamed from: a */
        private float m1096a(long j) {
            if (j < this.f743e) {
                return 0.0f;
            }
            if (this.f747i < 0 || j < this.f747i) {
                return AbstractViewOnTouchListenerC0135a.m1073a((j - this.f743e) / this.f739a, 0.0f, 1.0f) * 0.5f;
            }
            return (1.0f - this.f748j) + (this.f748j * AbstractViewOnTouchListenerC0135a.m1073a((j - this.f747i) / this.f749k, 0.0f, 1.0f));
        }

        /* JADX INFO: renamed from: a */
        public void m1097a() {
            this.f743e = AnimationUtils.currentAnimationTimeMillis();
            this.f747i = -1L;
            this.f744f = this.f743e;
            this.f748j = 0.5f;
            this.f745g = 0;
            this.f746h = 0;
        }

        /* JADX INFO: renamed from: a */
        public void m1098a(float f, float f2) {
            this.f741c = f;
            this.f742d = f2;
        }

        /* JADX INFO: renamed from: a */
        public void m1099a(int i) {
            this.f739a = i;
        }

        /* JADX INFO: renamed from: b */
        public void m1100b() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f749k = AbstractViewOnTouchListenerC0135a.m1076a((int) (jCurrentAnimationTimeMillis - this.f743e), 0, this.f740b);
            this.f748j = m1096a(jCurrentAnimationTimeMillis);
            this.f747i = jCurrentAnimationTimeMillis;
        }

        /* JADX INFO: renamed from: b */
        public void m1101b(int i) {
            this.f740b = i;
        }

        /* JADX INFO: renamed from: c */
        public boolean m1102c() {
            return this.f747i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f747i + ((long) this.f749k);
        }

        /* JADX INFO: renamed from: d */
        public void m1103d() {
            if (this.f744f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fM1095a = m1095a(m1096a(jCurrentAnimationTimeMillis));
            long j = jCurrentAnimationTimeMillis - this.f744f;
            this.f744f = jCurrentAnimationTimeMillis;
            float f = j * fM1095a;
            this.f745g = (int) (this.f741c * f);
            this.f746h = (int) (f * this.f742d);
        }

        /* JADX INFO: renamed from: e */
        public int m1104e() {
            return (int) (this.f741c / Math.abs(this.f741c));
        }

        /* JADX INFO: renamed from: f */
        public int m1105f() {
            return (int) (this.f742d / Math.abs(this.f742d));
        }

        /* JADX INFO: renamed from: g */
        public int m1106g() {
            return this.f745g;
        }

        /* JADX INFO: renamed from: h */
        public int m1107h() {
            return this.f746h;
        }
    }

    /* JADX INFO: renamed from: android.support.v4.widget.a$b */
    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AbstractViewOnTouchListenerC0135a.this.f726e) {
                if (AbstractViewOnTouchListenerC0135a.this.f724c) {
                    AbstractViewOnTouchListenerC0135a.this.f724c = false;
                    AbstractViewOnTouchListenerC0135a.this.f722a.m1097a();
                }
                a aVar = AbstractViewOnTouchListenerC0135a.this.f722a;
                if (aVar.m1102c() || !AbstractViewOnTouchListenerC0135a.this.m1084a()) {
                    AbstractViewOnTouchListenerC0135a.this.f726e = false;
                    return;
                }
                if (AbstractViewOnTouchListenerC0135a.this.f725d) {
                    AbstractViewOnTouchListenerC0135a.this.f725d = false;
                    AbstractViewOnTouchListenerC0135a.this.m1087b();
                }
                aVar.m1103d();
                AbstractViewOnTouchListenerC0135a.this.mo1083a(aVar.m1106g(), aVar.m1107h());
                C0124p.m957a(AbstractViewOnTouchListenerC0135a.this.f723b, this);
            }
        }
    }

    public AbstractViewOnTouchListenerC0135a(View view) {
        this.f723b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((displayMetrics.density * 1575.0f) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = i;
        m1080a(f, f);
        float f2 = i2;
        m1085b(f2, f2);
        m1081a(1);
        m1092e(Float.MAX_VALUE, Float.MAX_VALUE);
        m1090d(0.2f, 0.2f);
        m1088c(1.0f, 1.0f);
        m1086b(f721r);
        m1089c(500);
        m1091d(500);
    }

    /* JADX INFO: renamed from: a */
    static float m1073a(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* JADX INFO: renamed from: a */
    private float m1074a(float f, float f2, float f3, float f4) {
        float interpolation;
        float fM1073a = m1073a(f * f2, 0.0f, f3);
        float fM1079f = m1079f(f2 - f4, fM1073a) - m1079f(f4, fM1073a);
        if (fM1079f < 0.0f) {
            interpolation = -this.f727f.getInterpolation(-fM1079f);
        } else {
            if (fM1079f <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f727f.getInterpolation(fM1079f);
        }
        return m1073a(interpolation, -1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    private float m1075a(int i, float f, float f2, float f3) {
        float fM1074a = m1074a(this.f729h[i], f2, this.f730i[i], f);
        if (fM1074a == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f733l[i];
        float f5 = this.f734m[i];
        float f6 = this.f735n[i];
        float f7 = f4 * f3;
        return fM1074a > 0.0f ? m1073a(fM1074a * f7, f5, f6) : -m1073a((-fM1074a) * f7, f5, f6);
    }

    /* JADX INFO: renamed from: a */
    static int m1076a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* JADX INFO: renamed from: c */
    private void m1077c() {
        if (this.f728g == null) {
            this.f728g = new b();
        }
        this.f726e = true;
        this.f724c = true;
        if (this.f736o || this.f732k <= 0) {
            this.f728g.run();
        } else {
            C0124p.m958a(this.f723b, this.f728g, this.f732k);
        }
        this.f736o = true;
    }

    /* JADX INFO: renamed from: d */
    private void m1078d() {
        if (this.f724c) {
            this.f726e = false;
        } else {
            this.f722a.m1100b();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: renamed from: f */
    private float m1079f(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f731j) {
            case 0:
            case 1:
                if (f < f2) {
                    if (f >= 0.0f) {
                        return 1.0f - (f / f2);
                    }
                    if (this.f726e && this.f731j == 1) {
                        return 1.0f;
                    }
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    /* JADX INFO: renamed from: a */
    public AbstractViewOnTouchListenerC0135a m1080a(float f, float f2) {
        this.f735n[0] = f / 1000.0f;
        this.f735n[1] = f2 / 1000.0f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public AbstractViewOnTouchListenerC0135a m1081a(int i) {
        this.f731j = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public AbstractViewOnTouchListenerC0135a m1082a(boolean z) {
        if (this.f737p && !z) {
            m1078d();
        }
        this.f737p = z;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo1083a(int i, int i2);

    /* JADX INFO: renamed from: a */
    boolean m1084a() {
        a aVar = this.f722a;
        int iM1105f = aVar.m1105f();
        int iM1104e = aVar.m1104e();
        return (iM1105f != 0 && mo1094f(iM1105f)) || (iM1104e != 0 && mo1093e(iM1104e));
    }

    /* JADX INFO: renamed from: b */
    public AbstractViewOnTouchListenerC0135a m1085b(float f, float f2) {
        this.f734m[0] = f / 1000.0f;
        this.f734m[1] = f2 / 1000.0f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public AbstractViewOnTouchListenerC0135a m1086b(int i) {
        this.f732k = i;
        return this;
    }

    /* JADX INFO: renamed from: b */
    void m1087b() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f723b.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* JADX INFO: renamed from: c */
    public AbstractViewOnTouchListenerC0135a m1088c(float f, float f2) {
        this.f733l[0] = f / 1000.0f;
        this.f733l[1] = f2 / 1000.0f;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public AbstractViewOnTouchListenerC0135a m1089c(int i) {
        this.f722a.m1099a(i);
        return this;
    }

    /* JADX INFO: renamed from: d */
    public AbstractViewOnTouchListenerC0135a m1090d(float f, float f2) {
        this.f729h[0] = f;
        this.f729h[1] = f2;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public AbstractViewOnTouchListenerC0135a m1091d(int i) {
        this.f722a.m1101b(i);
        return this;
    }

    /* JADX INFO: renamed from: e */
    public AbstractViewOnTouchListenerC0135a m1092e(float f, float f2) {
        this.f730i[0] = f;
        this.f730i[1] = f2;
        return this;
    }

    /* JADX INFO: renamed from: e */
    public abstract boolean mo1093e(int i);

    /* JADX INFO: renamed from: f */
    public abstract boolean mo1094f(int i);

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f737p) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f725d = true;
                this.f736o = false;
                this.f722a.m1098a(m1075a(0, motionEvent.getX(), view.getWidth(), this.f723b.getWidth()), m1075a(1, motionEvent.getY(), view.getHeight(), this.f723b.getHeight()));
                if (!this.f726e && m1084a()) {
                    m1077c();
                }
                break;
            case 1:
            case 3:
                m1078d();
                break;
            case 2:
                this.f722a.m1098a(m1075a(0, motionEvent.getX(), view.getWidth(), this.f723b.getWidth()), m1075a(1, motionEvent.getY(), view.getHeight(), this.f723b.getHeight()));
                if (!this.f726e) {
                    m1077c();
                }
                break;
        }
        return this.f738q && this.f726e;
    }
}
