package android.support.v4.app;

import android.app.Activity;
import android.arch.lifecycle.AbstractC0009c;
import android.arch.lifecycle.C0012f;
import android.arch.lifecycle.FragmentC0019m;
import android.arch.lifecycle.InterfaceC0011e;
import android.os.Bundle;
import android.support.v4.p014f.C0100k;

/* JADX INFO: renamed from: android.support.v4.app.z */
/* JADX INFO: loaded from: classes.dex */
public class ActivityC0068z extends Activity implements InterfaceC0011e {

    /* JADX INFO: renamed from: a */
    private C0100k<Class<? extends Object>, Object> f489a = new C0100k<>();

    /* JADX INFO: renamed from: b */
    private C0012f f490b = new C0012f(this);

    /* JADX INFO: renamed from: a */
    public AbstractC0009c mo58a() {
        return this.f490b;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FragmentC0019m.m84a(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.f490b.m72a(AbstractC0009c.b.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
