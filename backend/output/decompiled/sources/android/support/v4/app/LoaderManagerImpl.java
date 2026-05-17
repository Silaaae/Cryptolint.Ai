package android.support.v4.app;

import android.arch.lifecycle.AbstractC0020n;
import android.arch.lifecycle.C0016j;
import android.arch.lifecycle.C0021o;
import android.arch.lifecycle.InterfaceC0011e;
import android.arch.lifecycle.InterfaceC0017k;
import android.os.Bundle;
import android.support.v4.app.AbstractC0063u;
import android.support.v4.p006a.C0037b;
import android.support.v4.p014f.C0093d;
import android.support.v4.p014f.C0101l;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
class LoaderManagerImpl extends AbstractC0063u {

    /* JADX INFO: renamed from: a */
    static boolean f189a = false;

    /* JADX INFO: renamed from: b */
    private final InterfaceC0011e f190b;

    /* JADX INFO: renamed from: c */
    private final LoaderViewModel f191c;

    static class LoaderViewModel extends AbstractC0020n {

        /* JADX INFO: renamed from: a */
        private static final C0021o.a f192a = new C0021o.a() { // from class: android.support.v4.app.LoaderManagerImpl.LoaderViewModel.1
        };

        /* JADX INFO: renamed from: b */
        private C0101l<C0040a> f193b = new C0101l<>();

        LoaderViewModel() {
        }

        @Override // android.arch.lifecycle.AbstractC0020n
        /* JADX INFO: renamed from: a */
        protected void mo92a() {
            super.mo92a();
            int iM833b = this.f193b.m833b();
            for (int i = 0; i < iM833b; i++) {
                this.f193b.m840e(i).m221a(true);
            }
            this.f193b.m836c();
        }

        /* JADX INFO: renamed from: a */
        public void m219a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f193b.m833b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f193b.m833b(); i++) {
                    C0040a c0040aM840e = this.f193b.m840e(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f193b.m839d(i));
                    printWriter.print(": ");
                    printWriter.println(c0040aM840e.toString());
                    c0040aM840e.m222a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        /* JADX INFO: renamed from: b */
        void m220b() {
            int iM833b = this.f193b.m833b();
            for (int i = 0; i < iM833b; i++) {
                this.f193b.m840e(i).m224f();
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v4.app.LoaderManagerImpl$a */
    public static class C0040a<D> extends C0016j<D> implements C0037b.a<D> {

        /* JADX INFO: renamed from: a */
        private final int f194a;

        /* JADX INFO: renamed from: b */
        private final Bundle f195b;

        /* JADX INFO: renamed from: c */
        private final C0037b<D> f196c;

        /* JADX INFO: renamed from: d */
        private InterfaceC0011e f197d;

        /* JADX INFO: renamed from: e */
        private C0041b<D> f198e;

        /* JADX INFO: renamed from: f */
        private C0037b<D> f199f;

        /* JADX INFO: renamed from: a */
        C0037b<D> m221a(boolean z) {
            if (LoaderManagerImpl.f189a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f196c.m207c();
            this.f196c.m211g();
            C0041b<D> c0041b = this.f198e;
            if (c0041b != null) {
                mo37a(c0041b);
                if (z) {
                    c0041b.m227b();
                }
            }
            this.f196c.m204a((C0037b.a) this);
            if ((c0041b == null || c0041b.m226a()) && !z) {
                return this.f196c;
            }
            this.f196c.m213i();
            return this.f199f;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.arch.lifecycle.LiveData
        /* JADX INFO: renamed from: a */
        public void mo37a(InterfaceC0017k<D> interfaceC0017k) {
            super.mo37a(interfaceC0017k);
            this.f197d = null;
            this.f198e = null;
        }

        /* JADX INFO: renamed from: a */
        public void m222a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f194a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f195b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f196c);
            this.f196c.m205a(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f198e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f198e);
                this.f198e.m225a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(m223e().m202a(m35a()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(m40d());
        }

        @Override // android.arch.lifecycle.LiveData
        /* JADX INFO: renamed from: b */
        protected void mo38b() {
            if (LoaderManagerImpl.f189a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f196c.m203a();
        }

        @Override // android.arch.lifecycle.LiveData
        /* JADX INFO: renamed from: c */
        protected void mo39c() {
            if (LoaderManagerImpl.f189a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f196c.m209e();
        }

        /* JADX INFO: renamed from: e */
        C0037b<D> m223e() {
            return this.f196c;
        }

        /* JADX INFO: renamed from: f */
        void m224f() {
            InterfaceC0011e interfaceC0011e = this.f197d;
            C0041b<D> c0041b = this.f198e;
            if (interfaceC0011e == null || c0041b == null) {
                return;
            }
            super.mo37a(c0041b);
            m36a(interfaceC0011e, c0041b);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f194a);
            sb.append(" : ");
            C0093d.m785a(this.f196c, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: android.support.v4.app.LoaderManagerImpl$b */
    static class C0041b<D> implements InterfaceC0017k<D> {

        /* JADX INFO: renamed from: a */
        private final C0037b<D> f200a;

        /* JADX INFO: renamed from: b */
        private final AbstractC0063u.a<D> f201b;

        /* JADX INFO: renamed from: c */
        private boolean f202c;

        @Override // android.arch.lifecycle.InterfaceC0017k
        /* JADX INFO: renamed from: a */
        public void mo82a(D d) {
            if (LoaderManagerImpl.f189a) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f200a + ": " + this.f200a.m202a(d));
            }
            this.f201b.m628a(this.f200a, d);
            this.f202c = true;
        }

        /* JADX INFO: renamed from: a */
        public void m225a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f202c);
        }

        /* JADX INFO: renamed from: a */
        boolean m226a() {
            return this.f202c;
        }

        /* JADX INFO: renamed from: b */
        void m227b() {
            if (this.f202c) {
                if (LoaderManagerImpl.f189a) {
                    Log.v("LoaderManager", "  Resetting: " + this.f200a);
                }
                this.f201b.m627a(this.f200a);
            }
        }

        public String toString() {
            return this.f201b.toString();
        }
    }

    /* JADX INFO: renamed from: a */
    void m217a() {
        this.f191c.m220b();
    }

    @Override // android.support.v4.app.AbstractC0063u
    /* JADX INFO: renamed from: a */
    public void mo218a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f191c.m219a(str, fileDescriptor, printWriter, strArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        C0093d.m785a(this.f190b, sb);
        sb.append("}}");
        return sb.toString();
    }
}
