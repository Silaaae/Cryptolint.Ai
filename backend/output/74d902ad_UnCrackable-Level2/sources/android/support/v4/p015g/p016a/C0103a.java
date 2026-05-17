package android.support.v4.p015g.p016a;

import android.graphics.Rect;
import android.os.Build;
import android.support.v7.p018a.C0148a;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: renamed from: android.support.v4.g.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0103a {

    /* JADX INFO: renamed from: a */
    public int f637a = -1;

    /* JADX INFO: renamed from: b */
    private final AccessibilityNodeInfo f638b;

    private C0103a(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f638b = accessibilityNodeInfo;
    }

    /* JADX INFO: renamed from: a */
    public static C0103a m845a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new C0103a(accessibilityNodeInfo);
    }

    /* JADX INFO: renamed from: b */
    private static String m846b(int i) {
        switch (i) {
            case 1:
                return "ACTION_FOCUS";
            case 2:
                return "ACTION_CLEAR_FOCUS";
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case C0148a.j.AppCompatTheme_activityChooserViewStyle /* 32 */:
                return "ACTION_LONG_CLICK";
            case C0148a.j.AppCompatTheme_dropdownListPreferredItemHeight /* 64 */:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }

    /* JADX INFO: renamed from: a */
    public AccessibilityNodeInfo m847a() {
        return this.f638b;
    }

    /* JADX INFO: renamed from: a */
    public void m848a(int i) {
        this.f638b.addAction(i);
    }

    /* JADX INFO: renamed from: a */
    public void m849a(Rect rect) {
        this.f638b.getBoundsInParent(rect);
    }

    /* JADX INFO: renamed from: a */
    public void m850a(CharSequence charSequence) {
        this.f638b.setClassName(charSequence);
    }

    /* JADX INFO: renamed from: a */
    public void m851a(boolean z) {
        this.f638b.setScrollable(z);
    }

    /* JADX INFO: renamed from: b */
    public int m852b() {
        return this.f638b.getActions();
    }

    /* JADX INFO: renamed from: b */
    public void m853b(Rect rect) {
        this.f638b.getBoundsInScreen(rect);
    }

    /* JADX INFO: renamed from: c */
    public boolean m854c() {
        return this.f638b.isCheckable();
    }

    /* JADX INFO: renamed from: d */
    public boolean m855d() {
        return this.f638b.isChecked();
    }

    /* JADX INFO: renamed from: e */
    public boolean m856e() {
        return this.f638b.isFocusable();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0103a c0103a = (C0103a) obj;
        if (this.f638b == null) {
            if (c0103a.f638b != null) {
                return false;
            }
        } else if (!this.f638b.equals(c0103a.f638b)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    public boolean m857f() {
        return this.f638b.isFocused();
    }

    /* JADX INFO: renamed from: g */
    public boolean m858g() {
        return this.f638b.isSelected();
    }

    /* JADX INFO: renamed from: h */
    public boolean m859h() {
        return this.f638b.isClickable();
    }

    public int hashCode() {
        if (this.f638b == null) {
            return 0;
        }
        return this.f638b.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public boolean m860i() {
        return this.f638b.isLongClickable();
    }

    /* JADX INFO: renamed from: j */
    public boolean m861j() {
        return this.f638b.isEnabled();
    }

    /* JADX INFO: renamed from: k */
    public boolean m862k() {
        return this.f638b.isPassword();
    }

    /* JADX INFO: renamed from: l */
    public boolean m863l() {
        return this.f638b.isScrollable();
    }

    /* JADX INFO: renamed from: m */
    public CharSequence m864m() {
        return this.f638b.getPackageName();
    }

    /* JADX INFO: renamed from: n */
    public CharSequence m865n() {
        return this.f638b.getClassName();
    }

    /* JADX INFO: renamed from: o */
    public CharSequence m866o() {
        return this.f638b.getText();
    }

    /* JADX INFO: renamed from: p */
    public CharSequence m867p() {
        return this.f638b.getContentDescription();
    }

    /* JADX INFO: renamed from: q */
    public String m868q() {
        if (Build.VERSION.SDK_INT >= 18) {
            return this.f638b.getViewIdResourceName();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m849a(rect);
        sb.append("; boundsInParent: " + rect);
        m853b(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(m864m());
        sb.append("; className: ");
        sb.append(m865n());
        sb.append("; text: ");
        sb.append(m866o());
        sb.append("; contentDescription: ");
        sb.append(m867p());
        sb.append("; viewId: ");
        sb.append(m868q());
        sb.append("; checkable: ");
        sb.append(m854c());
        sb.append("; checked: ");
        sb.append(m855d());
        sb.append("; focusable: ");
        sb.append(m856e());
        sb.append("; focused: ");
        sb.append(m857f());
        sb.append("; selected: ");
        sb.append(m858g());
        sb.append("; clickable: ");
        sb.append(m859h());
        sb.append("; longClickable: ");
        sb.append(m860i());
        sb.append("; enabled: ");
        sb.append(m861j());
        sb.append("; password: ");
        sb.append(m862k());
        sb.append("; scrollable: " + m863l());
        sb.append("; [");
        int iM852b = m852b();
        while (iM852b != 0) {
            int iNumberOfTrailingZeros = 1 << Integer.numberOfTrailingZeros(iM852b);
            iM852b &= iNumberOfTrailingZeros ^ (-1);
            sb.append(m846b(iNumberOfTrailingZeros));
            if (iM852b != 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
