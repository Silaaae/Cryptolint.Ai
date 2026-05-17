package android.support.v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.C0045c;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: renamed from: android.support.v4.app.d */
/* JADX INFO: loaded from: classes.dex */
final class C0046d implements Parcelable {
    public static final Parcelable.Creator<C0046d> CREATOR = new Parcelable.Creator<C0046d>() { // from class: android.support.v4.app.d.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0046d createFromParcel(Parcel parcel) {
            return new C0046d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0046d[] newArray(int i) {
            return new C0046d[i];
        }
    };

    /* JADX INFO: renamed from: a */
    final int[] f234a;

    /* JADX INFO: renamed from: b */
    final int f235b;

    /* JADX INFO: renamed from: c */
    final int f236c;

    /* JADX INFO: renamed from: d */
    final String f237d;

    /* JADX INFO: renamed from: e */
    final int f238e;

    /* JADX INFO: renamed from: f */
    final int f239f;

    /* JADX INFO: renamed from: g */
    final CharSequence f240g;

    /* JADX INFO: renamed from: h */
    final int f241h;

    /* JADX INFO: renamed from: i */
    final CharSequence f242i;

    /* JADX INFO: renamed from: j */
    final ArrayList<String> f243j;

    /* JADX INFO: renamed from: k */
    final ArrayList<String> f244k;

    /* JADX INFO: renamed from: l */
    final boolean f245l;

    public C0046d(Parcel parcel) {
        this.f234a = parcel.createIntArray();
        this.f235b = parcel.readInt();
        this.f236c = parcel.readInt();
        this.f237d = parcel.readString();
        this.f238e = parcel.readInt();
        this.f239f = parcel.readInt();
        this.f240g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f241h = parcel.readInt();
        this.f242i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f243j = parcel.createStringArrayList();
        this.f244k = parcel.createStringArrayList();
        this.f245l = parcel.readInt() != 0;
    }

    public C0046d(C0045c c0045c) {
        int size = c0045c.f208b.size();
        this.f234a = new int[size * 6];
        if (!c0045c.f215i) {
            throw new IllegalStateException("Not on back stack");
        }
        int i = 0;
        int i2 = 0;
        while (i < size) {
            C0045c.a aVar = c0045c.f208b.get(i);
            int i3 = i2 + 1;
            this.f234a[i2] = aVar.f228a;
            int i4 = i3 + 1;
            this.f234a[i3] = aVar.f229b != null ? aVar.f229b.f275f : -1;
            int i5 = i4 + 1;
            this.f234a[i4] = aVar.f230c;
            int i6 = i5 + 1;
            this.f234a[i5] = aVar.f231d;
            int i7 = i6 + 1;
            this.f234a[i6] = aVar.f232e;
            this.f234a[i7] = aVar.f233f;
            i++;
            i2 = i7 + 1;
        }
        this.f235b = c0045c.f213g;
        this.f236c = c0045c.f214h;
        this.f237d = c0045c.f217k;
        this.f238e = c0045c.f219m;
        this.f239f = c0045c.f220n;
        this.f240g = c0045c.f221o;
        this.f241h = c0045c.f222p;
        this.f242i = c0045c.f223q;
        this.f243j = c0045c.f224r;
        this.f244k = c0045c.f225s;
        this.f245l = c0045c.f226t;
    }

    /* JADX INFO: renamed from: a */
    public C0045c m256a(LayoutInflaterFactory2C0055m layoutInflaterFactory2C0055m) {
        C0045c c0045c = new C0045c(layoutInflaterFactory2C0055m);
        int i = 0;
        int i2 = 0;
        while (i < this.f234a.length) {
            C0045c.a aVar = new C0045c.a();
            int i3 = i + 1;
            aVar.f228a = this.f234a[i];
            if (LayoutInflaterFactory2C0055m.f343a) {
                Log.v("FragmentManager", "Instantiate " + c0045c + " op #" + i2 + " base fragment #" + this.f234a[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.f234a[i3];
            aVar.f229b = i5 >= 0 ? layoutInflaterFactory2C0055m.f355f.get(i5) : null;
            int i6 = i4 + 1;
            aVar.f230c = this.f234a[i4];
            int i7 = i6 + 1;
            aVar.f231d = this.f234a[i6];
            int i8 = i7 + 1;
            aVar.f232e = this.f234a[i7];
            aVar.f233f = this.f234a[i8];
            c0045c.f209c = aVar.f230c;
            c0045c.f210d = aVar.f231d;
            c0045c.f211e = aVar.f232e;
            c0045c.f212f = aVar.f233f;
            c0045c.m244a(aVar);
            i2++;
            i = i8 + 1;
        }
        c0045c.f213g = this.f235b;
        c0045c.f214h = this.f236c;
        c0045c.f217k = this.f237d;
        c0045c.f219m = this.f238e;
        c0045c.f215i = true;
        c0045c.f220n = this.f239f;
        c0045c.f221o = this.f240g;
        c0045c.f222p = this.f241h;
        c0045c.f223q = this.f242i;
        c0045c.f224r = this.f243j;
        c0045c.f225s = this.f244k;
        c0045c.f226t = this.f245l;
        c0045c.m243a(1);
        return c0045c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f234a);
        parcel.writeInt(this.f235b);
        parcel.writeInt(this.f236c);
        parcel.writeString(this.f237d);
        parcel.writeInt(this.f238e);
        parcel.writeInt(this.f239f);
        TextUtils.writeToParcel(this.f240g, parcel, 0);
        parcel.writeInt(this.f241h);
        TextUtils.writeToParcel(this.f242i, parcel, 0);
        parcel.writeStringList(this.f243j);
        parcel.writeStringList(this.f244k);
        parcel.writeInt(this.f245l ? 1 : 0);
    }
}
