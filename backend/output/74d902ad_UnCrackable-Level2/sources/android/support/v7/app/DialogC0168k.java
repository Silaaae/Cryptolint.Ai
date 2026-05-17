package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.AbstractC0179b;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: android.support.v7.app.k */
/* JADX INFO: loaded from: classes.dex */
public class DialogC0168k extends Dialog implements InterfaceC0161d {

    /* JADX INFO: renamed from: a */
    private AbstractC0162e f1003a;

    public DialogC0168k(Context context, int i) {
        super(context, m1335a(context, i));
        m1336a().mo1243a((Bundle) null);
        m1336a().mo1259i();
    }

    /* JADX INFO: renamed from: a */
    private static int m1335a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0148a.a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0162e m1336a() {
        if (this.f1003a == null) {
            this.f1003a = AbstractC0162e.m1236a(this, this);
        }
        return this.f1003a;
    }

    @Override // android.support.v7.app.InterfaceC0161d
    /* JADX INFO: renamed from: a */
    public AbstractC0179b mo1224a(AbstractC0179b.a aVar) {
        return null;
    }

    @Override // android.support.v7.app.InterfaceC0161d
    /* JADX INFO: renamed from: a */
    public void mo1226a(AbstractC0179b abstractC0179b) {
    }

    /* JADX INFO: renamed from: a */
    public boolean m1337a(int i) {
        return m1336a().mo1253c(i);
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m1336a().mo1250b(view, layoutParams);
    }

    @Override // android.support.v7.app.InterfaceC0161d
    /* JADX INFO: renamed from: b */
    public void mo1230b(AbstractC0179b abstractC0179b) {
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) m1336a().mo1241a(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        m1336a().mo1256f();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        m1336a().mo1258h();
        super.onCreate(bundle);
        m1336a().mo1243a(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        m1336a().mo1254d();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        m1336a().mo1248b(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        m1336a().mo1244a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m1336a().mo1245a(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        m1336a().mo1246a(getContext().getString(i));
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m1336a().mo1246a(charSequence);
    }
}
