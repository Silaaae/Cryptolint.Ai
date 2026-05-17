package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: android.support.v4.app.o */
/* JADX INFO: loaded from: classes.dex */
final class C0057o implements Parcelable {
    public static final Parcelable.Creator<C0057o> CREATOR = new Parcelable.Creator<C0057o>() { // from class: android.support.v4.app.o.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0057o createFromParcel(Parcel parcel) {
            return new C0057o(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0057o[] newArray(int i) {
            return new C0057o[i];
        }
    };

    /* JADX INFO: renamed from: a */
    C0058p[] f405a;

    /* JADX INFO: renamed from: b */
    int[] f406b;

    /* JADX INFO: renamed from: c */
    C0046d[] f407c;

    /* JADX INFO: renamed from: d */
    int f408d;

    /* JADX INFO: renamed from: e */
    int f409e;

    public C0057o() {
        this.f408d = -1;
    }

    public C0057o(Parcel parcel) {
        this.f408d = -1;
        this.f405a = (C0058p[]) parcel.createTypedArray(C0058p.CREATOR);
        this.f406b = parcel.createIntArray();
        this.f407c = (C0046d[]) parcel.createTypedArray(C0046d.CREATOR);
        this.f408d = parcel.readInt();
        this.f409e = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f405a, i);
        parcel.writeIntArray(this.f406b);
        parcel.writeTypedArray(this.f407c, i);
        parcel.writeInt(this.f408d);
        parcel.writeInt(this.f409e);
    }
}
