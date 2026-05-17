package android.support.v4.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: renamed from: android.support.v4.app.e */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractActivityC0047e extends ActivityC0068z {

    /* JADX INFO: renamed from: a */
    boolean f246a;

    AbstractActivityC0047e() {
    }

    /* JADX INFO: renamed from: a */
    static void m259a(int i) {
        if ((i & (-65536)) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    /* JADX INFO: renamed from: a */
    abstract View mo260a(View view, String str, Context context, AttributeSet attributeSet);

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View viewMo260a = mo260a(view, str, context, attributeSet);
        return viewMo260a == null ? super.onCreateView(view, str, context, attributeSet) : viewMo260a;
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View viewMo260a = mo260a(null, str, context, attributeSet);
        return viewMo260a == null ? super.onCreateView(str, context, attributeSet) : viewMo260a;
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!this.f246a && i != -1) {
            m259a(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }
}
