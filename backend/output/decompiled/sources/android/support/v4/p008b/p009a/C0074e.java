package android.support.v4.p008b.p009a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p008b.p009a.C0073d;

/* JADX INFO: renamed from: android.support.v4.b.a.e */
/* JADX INFO: loaded from: classes.dex */
class C0074e extends C0073d {

    /* JADX INFO: renamed from: android.support.v4.b.a.e$a */
    private static class a extends C0073d.a {
        a(C0073d.a aVar, Resources resources) {
            super(aVar, resources);
        }

        @Override // android.support.v4.p008b.p009a.C0073d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C0074e(this, resources);
        }
    }

    C0074e(Drawable drawable) {
        super(drawable);
    }

    C0074e(C0073d.a aVar, Resources resources) {
        super(aVar, resources);
    }

    @Override // android.support.v4.p008b.p009a.C0073d
    /* JADX INFO: renamed from: b */
    C0073d.a mo664b() {
        return new a(this.f497b, null);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f498c.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        this.f498c.setAutoMirrored(z);
    }
}
