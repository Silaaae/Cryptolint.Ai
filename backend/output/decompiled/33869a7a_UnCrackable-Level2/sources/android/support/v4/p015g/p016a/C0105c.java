package android.support.v4.p015g.p016a;

import android.os.Build;
import android.view.accessibility.AccessibilityRecord;

/* JADX INFO: renamed from: android.support.v4.g.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0105c {

    /* JADX INFO: renamed from: a */
    private final AccessibilityRecord f641a;

    /* JADX INFO: renamed from: a */
    public static void m874a(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollX(i);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m875b(AccessibilityRecord accessibilityRecord, int i) {
        if (Build.VERSION.SDK_INT >= 15) {
            accessibilityRecord.setMaxScrollY(i);
        }
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0105c c0105c = (C0105c) obj;
        if (this.f641a == null) {
            if (c0105c.f641a != null) {
                return false;
            }
        } else if (!this.f641a.equals(c0105c.f641a)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public int hashCode() {
        if (this.f641a == null) {
            return 0;
        }
        return this.f641a.hashCode();
    }
}
