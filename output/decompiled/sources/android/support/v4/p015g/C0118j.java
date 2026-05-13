package android.support.v4.p015g;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: renamed from: android.support.v4.g.j */
/* JADX INFO: loaded from: classes.dex */
public class C0118j {

    /* JADX INFO: renamed from: a */
    private ViewParent f661a;

    /* JADX INFO: renamed from: b */
    private ViewParent f662b;

    /* JADX INFO: renamed from: c */
    private final View f663c;

    /* JADX INFO: renamed from: d */
    private boolean f664d;

    /* JADX INFO: renamed from: e */
    private int[] f665e;

    public C0118j(View view) {
        this.f663c = view;
    }

    /* JADX INFO: renamed from: a */
    private void m921a(int i, ViewParent viewParent) {
        switch (i) {
            case 0:
                this.f661a = viewParent;
                break;
            case 1:
                this.f662b = viewParent;
                break;
        }
    }

    /* JADX INFO: renamed from: d */
    private ViewParent m922d(int i) {
        switch (i) {
            case 0:
                return this.f661a;
            case 1:
                return this.f662b;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m923a(boolean z) {
        if (this.f664d) {
            C0124p.m969k(this.f663c);
        }
        this.f664d = z;
    }

    /* JADX INFO: renamed from: a */
    public boolean m924a() {
        return this.f664d;
    }

    /* JADX INFO: renamed from: a */
    public boolean m925a(float f, float f2) {
        ViewParent viewParentM922d;
        if (!m924a() || (viewParentM922d = m922d(0)) == null) {
            return false;
        }
        return C0126r.m1004a(viewParentM922d, this.f663c, f, f2);
    }

    /* JADX INFO: renamed from: a */
    public boolean m926a(float f, float f2, boolean z) {
        ViewParent viewParentM922d;
        if (!m924a() || (viewParentM922d = m922d(0)) == null) {
            return false;
        }
        return C0126r.m1005a(viewParentM922d, this.f663c, f, f2, z);
    }

    /* JADX INFO: renamed from: a */
    public boolean m927a(int i) {
        return m922d(i) != null;
    }

    /* JADX INFO: renamed from: a */
    public boolean m928a(int i, int i2) {
        if (m927a(i2)) {
            return true;
        }
        if (!m924a()) {
            return false;
        }
        View view = this.f663c;
        for (ViewParent parent = this.f663c.getParent(); parent != null; parent = parent.getParent()) {
            if (C0126r.m1006a(parent, view, this.f663c, i, i2)) {
                m921a(i2, parent);
                C0126r.m1007b(parent, view, this.f663c, i, i2);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean m929a(int i, int i2, int i3, int i4, int[] iArr) {
        return m930a(i, i2, i3, i4, iArr, 0);
    }

    /* JADX INFO: renamed from: a */
    public boolean m930a(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        ViewParent viewParentM922d;
        int i6;
        int i7;
        if (!m924a() || (viewParentM922d = m922d(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.f663c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        C0126r.m1002a(viewParentM922d, this.f663c, i, i2, i3, i4, i5);
        if (iArr != null) {
            this.f663c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public boolean m931a(int i, int i2, int[] iArr, int[] iArr2) {
        return m932a(i, i2, iArr, iArr2, 0);
    }

    /* JADX INFO: renamed from: a */
    public boolean m932a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent viewParentM922d;
        int i4;
        int i5;
        if (!m924a() || (viewParentM922d = m922d(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.f663c.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.f665e == null) {
                this.f665e = new int[2];
            }
            iArr = this.f665e;
        }
        iArr[0] = 0;
        iArr[1] = 0;
        C0126r.m1003a(viewParentM922d, this.f663c, i, i2, iArr, i3);
        if (iArr2 != null) {
            this.f663c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    public boolean m933b() {
        return m927a(0);
    }

    /* JADX INFO: renamed from: b */
    public boolean m934b(int i) {
        return m928a(i, 0);
    }

    /* JADX INFO: renamed from: c */
    public void m935c() {
        m936c(0);
    }

    /* JADX INFO: renamed from: c */
    public void m936c(int i) {
        ViewParent viewParentM922d = m922d(i);
        if (viewParentM922d != null) {
            C0126r.m1001a(viewParentM922d, this.f663c, i);
            m921a(i, (ViewParent) null);
        }
    }
}
