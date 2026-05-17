package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.p006a.C0033a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: android.support.v4.app.aa */
/* JADX INFO: loaded from: classes.dex */
public final class C0043aa implements Iterable<Intent> {

    /* JADX INFO: renamed from: a */
    private static final c f204a;

    /* JADX INFO: renamed from: b */
    private final ArrayList<Intent> f205b = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    private final Context f206c;

    /* JADX INFO: renamed from: android.support.v4.app.aa$a */
    public interface a {
        /* JADX INFO: renamed from: a_ */
        Intent mo237a_();
    }

    /* JADX INFO: renamed from: android.support.v4.app.aa$b */
    static class b extends c {
        b() {
        }
    }

    /* JADX INFO: renamed from: android.support.v4.app.aa$c */
    static class c {
        c() {
        }
    }

    static {
        f204a = Build.VERSION.SDK_INT >= 16 ? new b() : new c();
    }

    private C0043aa(Context context) {
        this.f206c = context;
    }

    /* JADX INFO: renamed from: a */
    public static C0043aa m231a(Context context) {
        return new C0043aa(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public C0043aa m232a(Activity activity) {
        Intent intentMo237a_ = activity instanceof a ? ((a) activity).mo237a_() : null;
        if (intentMo237a_ == null) {
            intentMo237a_ = C0064v.m629a(activity);
        }
        if (intentMo237a_ != null) {
            ComponentName component = intentMo237a_.getComponent();
            if (component == null) {
                component = intentMo237a_.resolveActivity(this.f206c.getPackageManager());
            }
            m233a(component);
            m234a(intentMo237a_);
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public C0043aa m233a(ComponentName componentName) {
        int size = this.f205b.size();
        try {
            Context context = this.f206c;
            while (true) {
                Intent intentM630a = C0064v.m630a(context, componentName);
                if (intentM630a == null) {
                    return this;
                }
                this.f205b.add(size, intentM630a);
                context = this.f206c;
                componentName = intentM630a.getComponent();
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public C0043aa m234a(Intent intent) {
        this.f205b.add(intent);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m235a() {
        m236a((Bundle) null);
    }

    /* JADX INFO: renamed from: a */
    public void m236a(Bundle bundle) {
        if (this.f205b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f205b.toArray(new Intent[this.f205b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (C0033a.m168a(this.f206c, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f206c.startActivity(intent);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f205b.iterator();
    }
}
