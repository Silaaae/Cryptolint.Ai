package android.support.v7.widget;

import android.os.Build;
import android.view.View;

/* JADX INFO: renamed from: android.support.v7.widget.ay */
/* JADX INFO: loaded from: classes.dex */
public class C0265ay {
    /* JADX INFO: renamed from: a */
    public static void m2010a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            ViewOnAttachStateChangeListenerC0266az.m2014a(view, charSequence);
        }
    }
}
