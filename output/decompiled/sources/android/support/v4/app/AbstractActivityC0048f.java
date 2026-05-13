package android.support.v4.app;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;

/* JADX INFO: renamed from: android.support.v4.app.f */
/* JADX INFO: loaded from: classes.dex */
abstract class AbstractActivityC0048f extends AbstractActivityC0047e {

    /* JADX INFO: renamed from: b */
    boolean f247b;

    AbstractActivityC0048f() {
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (!this.f247b && i != -1) {
            m259a(i);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (!this.f246a && i != -1) {
            m259a(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
