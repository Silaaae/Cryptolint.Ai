package android.support.v7.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: a */
    private int f1605a;

    /* JADX INFO: renamed from: b */
    private int f1606b;

    /* JADX INFO: renamed from: c */
    private WeakReference<View> f1607c;

    /* JADX INFO: renamed from: d */
    private LayoutInflater f1608d;

    /* JADX INFO: renamed from: e */
    private InterfaceC0239a f1609e;

    /* JADX INFO: renamed from: android.support.v7.widget.ViewStubCompat$a */
    public interface InterfaceC0239a {
        /* JADX INFO: renamed from: a */
        void m1788a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1605a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0148a.j.ViewStubCompat, i, 0);
        this.f1606b = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.ViewStubCompat_android_inflatedId, -1);
        this.f1605a = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.ViewStubCompat_android_layout, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(C0148a.j.ViewStubCompat_android_id, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    /* JADX INFO: renamed from: a */
    public View m1787a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.f1605a == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        View viewInflate = (this.f1608d != null ? this.f1608d : LayoutInflater.from(getContext())).inflate(this.f1605a, viewGroup, false);
        if (this.f1606b != -1) {
            viewInflate.setId(this.f1606b);
        }
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(viewInflate, iIndexOfChild);
        }
        this.f1607c = new WeakReference<>(viewInflate);
        if (this.f1609e != null) {
            this.f1609e.m1788a(this, viewInflate);
        }
        return viewInflate;
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f1606b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f1608d;
    }

    public int getLayoutResource() {
        return this.f1605a;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f1606b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f1608d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f1605a = i;
    }

    public void setOnInflateListener(InterfaceC0239a interfaceC0239a) {
        this.f1609e = interfaceC0239a;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.f1607c != null) {
            View view = this.f1607c.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m1787a();
        }
    }
}
