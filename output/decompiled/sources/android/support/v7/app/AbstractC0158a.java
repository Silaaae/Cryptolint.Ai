package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.AbstractC0179b;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: android.support.v7.app.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0158a {

    /* JADX INFO: renamed from: android.support.v7.app.a$a */
    public static class a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a */
        public int f902a;

        public a(int i, int i2) {
            super(i, i2);
            this.f902a = 0;
            this.f902a = 8388627;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f902a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0148a.j.ActionBarLayout);
            this.f902a = typedArrayObtainStyledAttributes.getInt(C0148a.j.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public a(a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.f902a = 0;
            this.f902a = aVar.f902a;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f902a = 0;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.a$b */
    public interface b {
        /* JADX INFO: renamed from: a */
        void m1209a(boolean z);
    }

    /* JADX INFO: renamed from: android.support.v7.app.a$c */
    @Deprecated
    public static abstract class c {
        /* JADX INFO: renamed from: a */
        public abstract Drawable m1210a();

        /* JADX INFO: renamed from: b */
        public abstract CharSequence m1211b();

        /* JADX INFO: renamed from: c */
        public abstract View m1212c();

        /* JADX INFO: renamed from: d */
        public abstract void m1213d();

        /* JADX INFO: renamed from: e */
        public abstract CharSequence m1214e();
    }

    /* JADX INFO: renamed from: a */
    public abstract int mo1191a();

    /* JADX INFO: renamed from: a */
    public AbstractC0179b mo1192a(AbstractC0179b.a aVar) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void mo1193a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo1194a(Configuration configuration) {
    }

    /* JADX INFO: renamed from: a */
    public void mo1195a(CharSequence charSequence) {
    }

    /* JADX INFO: renamed from: a */
    public void mo1196a(boolean z) {
    }

    /* JADX INFO: renamed from: a */
    public boolean mo1197a(int i, KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo1198a(KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: renamed from: b */
    public Context mo1199b() {
        return null;
    }

    /* JADX INFO: renamed from: b */
    public void mo1200b(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    /* JADX INFO: renamed from: c */
    public void mo1201c(boolean z) {
    }

    /* JADX INFO: renamed from: c */
    public boolean mo1202c() {
        return false;
    }

    /* JADX INFO: renamed from: d */
    public void mo1203d(boolean z) {
    }

    /* JADX INFO: renamed from: d */
    public boolean mo1204d() {
        return false;
    }

    /* JADX INFO: renamed from: e */
    public void mo1205e(boolean z) {
    }

    /* JADX INFO: renamed from: e */
    public boolean mo1206e() {
        return false;
    }

    /* JADX INFO: renamed from: f */
    public boolean mo1207f() {
        return false;
    }

    /* JADX INFO: renamed from: g */
    void mo1208g() {
    }
}
