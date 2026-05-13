package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: renamed from: android.support.v4.app.j */
/* JADX INFO: loaded from: classes.dex */
public class C0052j {

    /* JADX INFO: renamed from: a */
    private final AbstractC0053k<?> f333a;

    private C0052j(AbstractC0053k<?> abstractC0053k) {
        this.f333a = abstractC0053k;
    }

    /* JADX INFO: renamed from: a */
    public static C0052j m396a(AbstractC0053k<?> abstractC0053k) {
        return new C0052j(abstractC0053k);
    }

    /* JADX INFO: renamed from: a */
    public ComponentCallbacksC0049g m397a(String str) {
        return this.f333a.f337d.m502b(str);
    }

    /* JADX INFO: renamed from: a */
    public AbstractC0054l m398a() {
        return this.f333a.m426i();
    }

    /* JADX INFO: renamed from: a */
    public View m399a(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f333a.f337d.onCreateView(view, str, context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    public void m400a(Configuration configuration) {
        this.f333a.f337d.m484a(configuration);
    }

    /* JADX INFO: renamed from: a */
    public void m401a(Parcelable parcelable, C0056n c0056n) {
        this.f333a.f337d.m486a(parcelable, c0056n);
    }

    /* JADX INFO: renamed from: a */
    public void m402a(ComponentCallbacksC0049g componentCallbacksC0049g) {
        this.f333a.f337d.m494a(this.f333a, this.f333a, componentCallbacksC0049g);
    }

    /* JADX INFO: renamed from: a */
    public void m403a(boolean z) {
        this.f333a.f337d.m495a(z);
    }

    /* JADX INFO: renamed from: a */
    public boolean m404a(Menu menu) {
        return this.f333a.f337d.m497a(menu);
    }

    /* JADX INFO: renamed from: a */
    public boolean m405a(Menu menu, MenuInflater menuInflater) {
        return this.f333a.f337d.m498a(menu, menuInflater);
    }

    /* JADX INFO: renamed from: a */
    public boolean m406a(MenuItem menuItem) {
        return this.f333a.f337d.m499a(menuItem);
    }

    /* JADX INFO: renamed from: b */
    public void m407b() {
        this.f333a.f337d.m534k();
    }

    /* JADX INFO: renamed from: b */
    public void m408b(Menu menu) {
        this.f333a.f337d.m507b(menu);
    }

    /* JADX INFO: renamed from: b */
    public void m409b(boolean z) {
        this.f333a.f337d.m508b(z);
    }

    /* JADX INFO: renamed from: b */
    public boolean m410b(MenuItem menuItem) {
        return this.f333a.f337d.m509b(menuItem);
    }

    /* JADX INFO: renamed from: c */
    public Parcelable m411c() {
        return this.f333a.f337d.m532j();
    }

    /* JADX INFO: renamed from: d */
    public C0056n m412d() {
        return this.f333a.f337d.m527h();
    }

    /* JADX INFO: renamed from: e */
    public void m413e() {
        this.f333a.f337d.m536l();
    }

    /* JADX INFO: renamed from: f */
    public void m414f() {
        this.f333a.f337d.m538m();
    }

    /* JADX INFO: renamed from: g */
    public void m415g() {
        this.f333a.f337d.m541n();
    }

    /* JADX INFO: renamed from: h */
    public void m416h() {
        this.f333a.f337d.m542o();
    }

    /* JADX INFO: renamed from: i */
    public void m417i() {
        this.f333a.f337d.m544p();
    }

    /* JADX INFO: renamed from: j */
    public void m418j() {
        this.f333a.f337d.m545q();
    }

    /* JADX INFO: renamed from: k */
    public void m419k() {
        this.f333a.f337d.m546r();
    }

    /* JADX INFO: renamed from: l */
    public void m420l() {
        this.f333a.f337d.m548t();
    }

    /* JADX INFO: renamed from: m */
    public void m421m() {
        this.f333a.f337d.m549u();
    }

    /* JADX INFO: renamed from: n */
    public boolean m422n() {
        return this.f333a.f337d.m520e();
    }
}
