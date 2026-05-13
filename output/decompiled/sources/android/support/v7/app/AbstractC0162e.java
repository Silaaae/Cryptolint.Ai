package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* JADX INFO: renamed from: android.support.v7.app.e */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0162e {

    /* JADX INFO: renamed from: a */
    private static int f909a = -1;

    /* JADX INFO: renamed from: b */
    private static boolean f910b = false;

    AbstractC0162e() {
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC0162e m1235a(Activity activity, InterfaceC0161d interfaceC0161d) {
        return m1237a(activity, activity.getWindow(), interfaceC0161d);
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC0162e m1236a(Dialog dialog, InterfaceC0161d interfaceC0161d) {
        return m1237a(dialog.getContext(), dialog.getWindow(), interfaceC0161d);
    }

    /* JADX INFO: renamed from: a */
    private static AbstractC0162e m1237a(Context context, Window window, InterfaceC0161d interfaceC0161d) {
        return Build.VERSION.SDK_INT >= 24 ? new C0164g(context, window, interfaceC0161d) : Build.VERSION.SDK_INT >= 23 ? new C0166i(context, window, interfaceC0161d) : new C0165h(context, window, interfaceC0161d);
    }

    /* JADX INFO: renamed from: j */
    public static int m1238j() {
        return f909a;
    }

    /* JADX INFO: renamed from: k */
    public static boolean m1239k() {
        return f910b;
    }

    /* JADX INFO: renamed from: a */
    public abstract AbstractC0158a mo1240a();

    /* JADX INFO: renamed from: a */
    public abstract <T extends View> T mo1241a(int i);

    /* JADX INFO: renamed from: a */
    public abstract void mo1242a(Configuration configuration);

    /* JADX INFO: renamed from: a */
    public abstract void mo1243a(Bundle bundle);

    /* JADX INFO: renamed from: a */
    public abstract void mo1244a(View view);

    /* JADX INFO: renamed from: a */
    public abstract void mo1245a(View view, ViewGroup.LayoutParams layoutParams);

    /* JADX INFO: renamed from: a */
    public abstract void mo1246a(CharSequence charSequence);

    /* JADX INFO: renamed from: b */
    public abstract MenuInflater mo1247b();

    /* JADX INFO: renamed from: b */
    public abstract void mo1248b(int i);

    /* JADX INFO: renamed from: b */
    public abstract void mo1249b(Bundle bundle);

    /* JADX INFO: renamed from: b */
    public abstract void mo1250b(View view, ViewGroup.LayoutParams layoutParams);

    /* JADX INFO: renamed from: c */
    public abstract void mo1251c();

    /* JADX INFO: renamed from: c */
    public abstract void mo1252c(Bundle bundle);

    /* JADX INFO: renamed from: c */
    public abstract boolean mo1253c(int i);

    /* JADX INFO: renamed from: d */
    public abstract void mo1254d();

    /* JADX INFO: renamed from: e */
    public abstract void mo1255e();

    /* JADX INFO: renamed from: f */
    public abstract void mo1256f();

    /* JADX INFO: renamed from: g */
    public abstract void mo1257g();

    /* JADX INFO: renamed from: h */
    public abstract void mo1258h();

    /* JADX INFO: renamed from: i */
    public abstract boolean mo1259i();
}
