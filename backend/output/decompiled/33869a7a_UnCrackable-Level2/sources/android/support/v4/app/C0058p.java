package android.support.v4.app;

import android.arch.lifecycle.C0022p;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/* JADX INFO: renamed from: android.support.v4.app.p */
/* JADX INFO: loaded from: classes.dex */
final class C0058p implements Parcelable {
    public static final Parcelable.Creator<C0058p> CREATOR = new Parcelable.Creator<C0058p>() { // from class: android.support.v4.app.p.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0058p createFromParcel(Parcel parcel) {
            return new C0058p(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0058p[] newArray(int i) {
            return new C0058p[i];
        }
    };

    /* JADX INFO: renamed from: a */
    final String f410a;

    /* JADX INFO: renamed from: b */
    final int f411b;

    /* JADX INFO: renamed from: c */
    final boolean f412c;

    /* JADX INFO: renamed from: d */
    final int f413d;

    /* JADX INFO: renamed from: e */
    final int f414e;

    /* JADX INFO: renamed from: f */
    final String f415f;

    /* JADX INFO: renamed from: g */
    final boolean f416g;

    /* JADX INFO: renamed from: h */
    final boolean f417h;

    /* JADX INFO: renamed from: i */
    final Bundle f418i;

    /* JADX INFO: renamed from: j */
    final boolean f419j;

    /* JADX INFO: renamed from: k */
    Bundle f420k;

    /* JADX INFO: renamed from: l */
    ComponentCallbacksC0049g f421l;

    C0058p(Parcel parcel) {
        this.f410a = parcel.readString();
        this.f411b = parcel.readInt();
        this.f412c = parcel.readInt() != 0;
        this.f413d = parcel.readInt();
        this.f414e = parcel.readInt();
        this.f415f = parcel.readString();
        this.f416g = parcel.readInt() != 0;
        this.f417h = parcel.readInt() != 0;
        this.f418i = parcel.readBundle();
        this.f419j = parcel.readInt() != 0;
        this.f420k = parcel.readBundle();
    }

    C0058p(ComponentCallbacksC0049g componentCallbacksC0049g) {
        this.f410a = componentCallbacksC0049g.getClass().getName();
        this.f411b = componentCallbacksC0049g.f275f;
        this.f412c = componentCallbacksC0049g.f283n;
        this.f413d = componentCallbacksC0049g.f294y;
        this.f414e = componentCallbacksC0049g.f295z;
        this.f415f = componentCallbacksC0049g.f250A;
        this.f416g = componentCallbacksC0049g.f253D;
        this.f417h = componentCallbacksC0049g.f252C;
        this.f418i = componentCallbacksC0049g.f277h;
        this.f419j = componentCallbacksC0049g.f251B;
    }

    /* JADX INFO: renamed from: a */
    public ComponentCallbacksC0049g m562a(AbstractC0053k abstractC0053k, AbstractC0051i abstractC0051i, ComponentCallbacksC0049g componentCallbacksC0049g, C0056n c0056n, C0022p c0022p) {
        if (this.f421l == null) {
            Context contextM424g = abstractC0053k.m424g();
            if (this.f418i != null) {
                this.f418i.setClassLoader(contextM424g.getClassLoader());
            }
            this.f421l = abstractC0051i != null ? abstractC0051i.mo366a(contextM424g, this.f410a, this.f418i) : ComponentCallbacksC0049g.m263a(contextM424g, this.f410a, this.f418i);
            if (this.f420k != null) {
                this.f420k.setClassLoader(contextM424g.getClassLoader());
                this.f421l.f272c = this.f420k;
            }
            this.f421l.m296a(this.f411b, componentCallbacksC0049g);
            this.f421l.f283n = this.f412c;
            this.f421l.f285p = true;
            this.f421l.f294y = this.f413d;
            this.f421l.f295z = this.f414e;
            this.f421l.f250A = this.f415f;
            this.f421l.f253D = this.f416g;
            this.f421l.f252C = this.f417h;
            this.f421l.f251B = this.f419j;
            this.f421l.f288s = abstractC0053k.f337d;
            if (LayoutInflaterFactory2C0055m.f343a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.f421l);
            }
        }
        this.f421l.f291v = c0056n;
        this.f421l.f292w = c0022p;
        return this.f421l;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f410a);
        parcel.writeInt(this.f411b);
        parcel.writeInt(this.f412c ? 1 : 0);
        parcel.writeInt(this.f413d);
        parcel.writeInt(this.f414e);
        parcel.writeString(this.f415f);
        parcel.writeInt(this.f416g ? 1 : 0);
        parcel.writeInt(this.f417h ? 1 : 0);
        parcel.writeBundle(this.f418i);
        parcel.writeInt(this.f419j ? 1 : 0);
        parcel.writeBundle(this.f420k);
    }
}
