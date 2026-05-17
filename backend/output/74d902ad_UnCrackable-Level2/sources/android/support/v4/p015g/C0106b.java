package android.support.v4.p015g;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.p015g.p016a.C0103a;
import android.support.v4.p015g.p016a.C0104b;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* JADX INFO: renamed from: android.support.v4.g.b */
/* JADX INFO: loaded from: classes.dex */
public class C0106b {

    /* JADX INFO: renamed from: b */
    private static final b f642b;

    /* JADX INFO: renamed from: c */
    private static final View.AccessibilityDelegate f643c;

    /* JADX INFO: renamed from: a */
    final View.AccessibilityDelegate f644a = f642b.mo887a(this);

    /* JADX INFO: renamed from: android.support.v4.g.b$a */
    static class a extends b {
        a() {
        }

        @Override // android.support.v4.p015g.C0106b.b
        /* JADX INFO: renamed from: a */
        public C0104b mo886a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            AccessibilityNodeProvider accessibilityNodeProvider = accessibilityDelegate.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return new C0104b(accessibilityNodeProvider);
            }
            return null;
        }

        @Override // android.support.v4.p015g.C0106b.b
        /* JADX INFO: renamed from: a */
        public View.AccessibilityDelegate mo887a(final C0106b c0106b) {
            return new View.AccessibilityDelegate() { // from class: android.support.v4.g.b.a.1
                @Override // android.view.View.AccessibilityDelegate
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return c0106b.m883b(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
                    C0104b c0104bM876a = c0106b.m876a(view);
                    if (c0104bM876a != null) {
                        return (AccessibilityNodeProvider) c0104bM876a.m870a();
                    }
                    return null;
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0106b.mo885d(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    c0106b.mo879a(view, C0103a.m845a(accessibilityNodeInfo));
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0106b.m884c(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0106b.m882a(viewGroup, view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
                    return c0106b.mo881a(view, i, bundle);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEvent(View view, int i) {
                    c0106b.m878a(view, i);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    c0106b.m880a(view, accessibilityEvent);
                }
            };
        }

        @Override // android.support.v4.p015g.C0106b.b
        /* JADX INFO: renamed from: a */
        public boolean mo888a(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i, bundle);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.g.b$b */
    static class b {
        b() {
        }

        /* JADX INFO: renamed from: a */
        public C0104b mo886a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return null;
        }

        /* JADX INFO: renamed from: a */
        public View.AccessibilityDelegate mo887a(final C0106b c0106b) {
            return new View.AccessibilityDelegate() { // from class: android.support.v4.g.b.b.1
                @Override // android.view.View.AccessibilityDelegate
                public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    return c0106b.m883b(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0106b.mo885d(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    c0106b.mo879a(view, C0103a.m845a(accessibilityNodeInfo));
                }

                @Override // android.view.View.AccessibilityDelegate
                public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
                    c0106b.m884c(view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                    return c0106b.m882a(viewGroup, view, accessibilityEvent);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEvent(View view, int i) {
                    c0106b.m878a(view, i);
                }

                @Override // android.view.View.AccessibilityDelegate
                public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
                    c0106b.m880a(view, accessibilityEvent);
                }
            };
        }

        /* JADX INFO: renamed from: a */
        public boolean mo888a(View.AccessibilityDelegate accessibilityDelegate, View view, int i, Bundle bundle) {
            return false;
        }
    }

    static {
        f642b = Build.VERSION.SDK_INT >= 16 ? new a() : new b();
        f643c = new View.AccessibilityDelegate();
    }

    /* JADX INFO: renamed from: a */
    public C0104b m876a(View view) {
        return f642b.mo886a(f643c, view);
    }

    /* JADX INFO: renamed from: a */
    View.AccessibilityDelegate m877a() {
        return this.f644a;
    }

    /* JADX INFO: renamed from: a */
    public void m878a(View view, int i) {
        f643c.sendAccessibilityEvent(view, i);
    }

    /* JADX INFO: renamed from: a */
    public void mo879a(View view, C0103a c0103a) {
        f643c.onInitializeAccessibilityNodeInfo(view, c0103a.m847a());
    }

    /* JADX INFO: renamed from: a */
    public void m880a(View view, AccessibilityEvent accessibilityEvent) {
        f643c.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo881a(View view, int i, Bundle bundle) {
        return f642b.mo888a(f643c, view, i, bundle);
    }

    /* JADX INFO: renamed from: a */
    public boolean m882a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f643c.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    /* JADX INFO: renamed from: b */
    public boolean m883b(View view, AccessibilityEvent accessibilityEvent) {
        return f643c.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* JADX INFO: renamed from: c */
    public void m884c(View view, AccessibilityEvent accessibilityEvent) {
        f643c.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    /* JADX INFO: renamed from: d */
    public void mo885d(View view, AccessibilityEvent accessibilityEvent) {
        f643c.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }
}
