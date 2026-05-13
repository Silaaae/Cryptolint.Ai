package android.support.v4.p006a;

import android.support.v4.p014f.C0093d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: renamed from: android.support.v4.a.b */
/* JADX INFO: loaded from: classes.dex */
public class C0037b<D> {

    /* JADX INFO: renamed from: a */
    int f182a;

    /* JADX INFO: renamed from: b */
    a<D> f183b;

    /* JADX INFO: renamed from: c */
    boolean f184c;

    /* JADX INFO: renamed from: d */
    boolean f185d;

    /* JADX INFO: renamed from: e */
    boolean f186e;

    /* JADX INFO: renamed from: f */
    boolean f187f;

    /* JADX INFO: renamed from: g */
    boolean f188g;

    /* JADX INFO: renamed from: android.support.v4.a.b$a */
    public interface a<D> {
    }

    /* JADX INFO: renamed from: a */
    public String m202a(D d) {
        StringBuilder sb = new StringBuilder(64);
        C0093d.m785a(d, sb);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public final void m203a() {
        this.f184c = true;
        this.f186e = false;
        this.f185d = false;
        m206b();
    }

    /* JADX INFO: renamed from: a */
    public void m204a(a<D> aVar) {
        if (this.f183b == null) {
            throw new IllegalStateException("No listener register");
        }
        if (this.f183b != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        this.f183b = null;
    }

    /* JADX INFO: renamed from: a */
    public void m205a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f182a);
        printWriter.print(" mListener=");
        printWriter.println(this.f183b);
        if (this.f184c || this.f187f || this.f188g) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f184c);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f187f);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f188g);
        }
        if (this.f185d || this.f186e) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f185d);
            printWriter.print(" mReset=");
            printWriter.println(this.f186e);
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m206b() {
    }

    /* JADX INFO: renamed from: c */
    public boolean m207c() {
        return m208d();
    }

    /* JADX INFO: renamed from: d */
    protected boolean m208d() {
        return false;
    }

    /* JADX INFO: renamed from: e */
    public void m209e() {
        this.f184c = false;
        m210f();
    }

    /* JADX INFO: renamed from: f */
    protected void m210f() {
    }

    /* JADX INFO: renamed from: g */
    public void m211g() {
        this.f185d = true;
        m212h();
    }

    /* JADX INFO: renamed from: h */
    protected void m212h() {
    }

    /* JADX INFO: renamed from: i */
    public void m213i() {
        m214j();
        this.f186e = true;
        this.f184c = false;
        this.f185d = false;
        this.f187f = false;
        this.f188g = false;
    }

    /* JADX INFO: renamed from: j */
    protected void m214j() {
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        C0093d.m785a(this, sb);
        sb.append(" id=");
        sb.append(this.f182a);
        sb.append("}");
        return sb.toString();
    }
}
