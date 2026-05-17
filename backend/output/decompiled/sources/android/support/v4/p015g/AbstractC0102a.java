package android.support.v4.p015g;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: renamed from: android.support.v4.g.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0102a implements Parcelable {

    /* JADX INFO: renamed from: b */
    private final Parcelable f636b;

    /* JADX INFO: renamed from: a */
    public static final AbstractC0102a f635a = new AbstractC0102a() { // from class: android.support.v4.g.a.1
    };
    public static final Parcelable.Creator<AbstractC0102a> CREATOR = new Parcelable.ClassLoaderCreator<AbstractC0102a>() { // from class: android.support.v4.g.a.2
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC0102a createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC0102a createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbstractC0102a.f635a;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC0102a[] newArray(int i) {
            return new AbstractC0102a[i];
        }
    };

    private AbstractC0102a() {
        this.f636b = null;
    }

    protected AbstractC0102a(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f636b = parcelable == null ? f635a : parcelable;
    }

    protected AbstractC0102a(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.f636b = parcelable == f635a ? null : parcelable;
    }

    /* JADX INFO: renamed from: a */
    public final Parcelable m841a() {
        return this.f636b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f636b, i);
    }
}
