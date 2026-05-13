package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.menu.C0196h;
import android.support.v7.view.menu.InterfaceC0204p;
import android.support.v7.widget.AbstractViewOnAttachStateChangeListenerC0249ai;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.C0242ab;
import android.support.v7.widget.C0265ay;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends C0242ab implements InterfaceC0204p.a, ActionMenuView.InterfaceC0217a, View.OnClickListener {

    /* JADX INFO: renamed from: b */
    C0198j f1156b;

    /* JADX INFO: renamed from: c */
    C0196h.b f1157c;

    /* JADX INFO: renamed from: d */
    AbstractC0188b f1158d;

    /* JADX INFO: renamed from: e */
    private CharSequence f1159e;

    /* JADX INFO: renamed from: f */
    private Drawable f1160f;

    /* JADX INFO: renamed from: g */
    private AbstractViewOnAttachStateChangeListenerC0249ai f1161g;

    /* JADX INFO: renamed from: h */
    private boolean f1162h;

    /* JADX INFO: renamed from: i */
    private boolean f1163i;

    /* JADX INFO: renamed from: j */
    private int f1164j;

    /* JADX INFO: renamed from: k */
    private int f1165k;

    /* JADX INFO: renamed from: l */
    private int f1166l;

    /* JADX INFO: renamed from: android.support.v7.view.menu.ActionMenuItemView$a */
    private class C0187a extends AbstractViewOnAttachStateChangeListenerC0249ai {
        public C0187a() {
            super(ActionMenuItemView.this);
        }

        @Override // android.support.v7.widget.AbstractViewOnAttachStateChangeListenerC0249ai
        /* JADX INFO: renamed from: a */
        public InterfaceC0207s mo1452a() {
            if (ActionMenuItemView.this.f1158d != null) {
                return ActionMenuItemView.this.f1158d.mo1454a();
            }
            return null;
        }

        @Override // android.support.v7.widget.AbstractViewOnAttachStateChangeListenerC0249ai
        /* JADX INFO: renamed from: b */
        protected boolean mo1453b() {
            InterfaceC0207s interfaceC0207sMo1452a;
            return ActionMenuItemView.this.f1157c != null && ActionMenuItemView.this.f1157c.mo1456a(ActionMenuItemView.this.f1156b) && (interfaceC0207sMo1452a = mo1452a()) != null && interfaceC0207sMo1452a.mo1507d();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.view.menu.ActionMenuItemView$b */
    public static abstract class AbstractC0188b {
        /* JADX INFO: renamed from: a */
        public abstract InterfaceC0207s mo1454a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f1162h = m1445e();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0148a.j.ActionMenuItemView, i, 0);
        this.f1164j = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0148a.j.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f1166l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f1165k = -1;
        setSaveEnabled(false);
    }

    /* JADX INFO: renamed from: e */
    private boolean m1445e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    /* JADX INFO: renamed from: f */
    private void m1446f() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f1159e);
        if (this.f1160f != null && (!this.f1156b.m1601m() || (!this.f1162h && !this.f1163i))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f1159e : null);
        CharSequence contentDescription = this.f1156b.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z3 ? null : this.f1156b.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.f1156b.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            C0265ay.m2010a(this, z3 ? null : this.f1156b.getTitle());
        } else {
            C0265ay.m2010a(this, tooltipText);
        }
    }

    @Override // android.support.v7.view.menu.InterfaceC0204p.a
    /* JADX INFO: renamed from: a */
    public void mo1447a(C0198j c0198j, int i) {
        this.f1156b = c0198j;
        setIcon(c0198j.getIcon());
        setTitle(c0198j.m1581a((InterfaceC0204p.a) this));
        setId(c0198j.getItemId());
        setVisibility(c0198j.isVisible() ? 0 : 8);
        setEnabled(c0198j.isEnabled());
        if (c0198j.hasSubMenu() && this.f1161g == null) {
            this.f1161g = new C0187a();
        }
    }

    @Override // android.support.v7.view.menu.InterfaceC0204p.a
    /* JADX INFO: renamed from: a */
    public boolean mo1448a() {
        return true;
    }

    /* JADX INFO: renamed from: b */
    public boolean m1449b() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // android.support.v7.widget.ActionMenuView.InterfaceC0217a
    /* JADX INFO: renamed from: c */
    public boolean mo1450c() {
        return m1449b() && this.f1156b.getIcon() == null;
    }

    @Override // android.support.v7.widget.ActionMenuView.InterfaceC0217a
    /* JADX INFO: renamed from: d */
    public boolean mo1451d() {
        return m1449b();
    }

    @Override // android.support.v7.view.menu.InterfaceC0204p.a
    public C0198j getItemData() {
        return this.f1156b;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f1157c != null) {
            this.f1157c.mo1456a(this.f1156b);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f1162h = m1445e();
        m1446f();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean zM1449b = m1449b();
        if (zM1449b && this.f1165k >= 0) {
            super.setPadding(this.f1165k, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f1164j) : this.f1164j;
        if (mode != 1073741824 && this.f1164j > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (zM1449b || this.f1160f == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f1160f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1156b.hasSubMenu() && this.f1161g != null && this.f1161g.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1163i != z) {
            this.f1163i = z;
            if (this.f1156b != null) {
                this.f1156b.m1596h();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1160f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f1166l) {
                float f = this.f1166l / intrinsicWidth;
                intrinsicWidth = this.f1166l;
                intrinsicHeight = (int) (intrinsicHeight * f);
            }
            if (intrinsicHeight > this.f1166l) {
                float f2 = this.f1166l / intrinsicHeight;
                intrinsicHeight = this.f1166l;
                intrinsicWidth = (int) (intrinsicWidth * f2);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m1446f();
    }

    public void setItemInvoker(C0196h.b bVar) {
        this.f1157c = bVar;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.f1165k = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(AbstractC0188b abstractC0188b) {
        this.f1158d = abstractC0188b;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1159e = charSequence;
        m1446f();
    }
}
