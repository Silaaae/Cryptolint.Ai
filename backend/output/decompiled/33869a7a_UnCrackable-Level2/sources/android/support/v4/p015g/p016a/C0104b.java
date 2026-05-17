package android.support.v4.p015g.p016a;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: android.support.v4.g.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0104b {

    /* JADX INFO: renamed from: a */
    private final Object f639a;

    /* JADX INFO: renamed from: android.support.v4.g.a.b$a */
    static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a */
        final C0104b f640a;

        a(C0104b c0104b) {
            this.f640a = c0104b;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            C0103a c0103aM869a = this.f640a.m869a(i);
            if (c0103aM869a == null) {
                return null;
            }
            return c0103aM869a.m847a();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<C0103a> listM871a = this.f640a.m871a(str, i);
            if (listM871a == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listM871a.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(listM871a.get(i2).m847a());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f640a.m872a(i, i2, bundle);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.a.b$b */
    static class b extends a {
        b(C0104b c0104b) {
            super(c0104b);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            C0103a c0103aM873b = this.f640a.m873b(i);
            if (c0103aM873b == null) {
                return null;
            }
            return c0103aM873b.m847a();
        }
    }

    public C0104b() {
        this.f639a = Build.VERSION.SDK_INT >= 19 ? new b(this) : Build.VERSION.SDK_INT >= 16 ? new a(this) : null;
    }

    public C0104b(Object obj) {
        this.f639a = obj;
    }

    /* JADX INFO: renamed from: a */
    public C0103a m869a(int i) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public Object m870a() {
        return this.f639a;
    }

    /* JADX INFO: renamed from: a */
    public List<C0103a> m871a(String str, int i) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public boolean m872a(int i, int i2, Bundle bundle) {
        return false;
    }

    /* JADX INFO: renamed from: b */
    public C0103a m873b(int i) {
        return null;
    }
}
