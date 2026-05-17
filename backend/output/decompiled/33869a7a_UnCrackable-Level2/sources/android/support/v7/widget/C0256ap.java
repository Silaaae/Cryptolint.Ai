package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AbstractC0158a;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.C0178a;
import android.support.v7.widget.C0250aj;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

/* JADX INFO: renamed from: android.support.v7.widget.ap */
/* JADX INFO: loaded from: classes.dex */
public class C0256ap extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: j */
    private static final Interpolator f1741j = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a */
    Runnable f1742a;

    /* JADX INFO: renamed from: b */
    C0250aj f1743b;

    /* JADX INFO: renamed from: c */
    int f1744c;

    /* JADX INFO: renamed from: d */
    int f1745d;

    /* JADX INFO: renamed from: e */
    private b f1746e;

    /* JADX INFO: renamed from: f */
    private Spinner f1747f;

    /* JADX INFO: renamed from: g */
    private boolean f1748g;

    /* JADX INFO: renamed from: h */
    private int f1749h;

    /* JADX INFO: renamed from: i */
    private int f1750i;

    /* JADX INFO: renamed from: android.support.v7.widget.ap$a */
    private class a extends BaseAdapter {
        a() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return C0256ap.this.f1743b.getChildCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ((c) C0256ap.this.f1743b.getChildAt(i)).m1947b();
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return C0256ap.this.m1943a((AbstractC0158a.c) getItem(i), true);
            }
            ((c) view).m1946a((AbstractC0158a.c) getItem(i));
            return view;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ap$b */
    private class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((c) view).m1947b().m1213d();
            int childCount = C0256ap.this.f1743b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = C0256ap.this.f1743b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ap$c */
    private class c extends LinearLayout {

        /* JADX INFO: renamed from: b */
        private final int[] f1756b;

        /* JADX INFO: renamed from: c */
        private AbstractC0158a.c f1757c;

        /* JADX INFO: renamed from: d */
        private TextView f1758d;

        /* JADX INFO: renamed from: e */
        private ImageView f1759e;

        /* JADX INFO: renamed from: f */
        private View f1760f;

        public c(Context context, AbstractC0158a.c cVar, boolean z) {
            super(context, null, C0148a.a.actionBarTabStyle);
            this.f1756b = new int[]{R.attr.background};
            this.f1757c = cVar;
            C0263aw c0263awM1978a = C0263aw.m1978a(context, null, this.f1756b, C0148a.a.actionBarTabStyle, 0);
            if (c0263awM1978a.m1996g(0)) {
                setBackgroundDrawable(c0263awM1978a.m1982a(0));
            }
            c0263awM1978a.m1983a();
            if (z) {
                setGravity(8388627);
            }
            m1945a();
        }

        /* JADX INFO: renamed from: a */
        public void m1945a() {
            AbstractC0158a.c cVar = this.f1757c;
            View viewM1212c = cVar.m1212c();
            if (viewM1212c != null) {
                ViewParent parent = viewM1212c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(viewM1212c);
                    }
                    addView(viewM1212c);
                }
                this.f1760f = viewM1212c;
                if (this.f1758d != null) {
                    this.f1758d.setVisibility(8);
                }
                if (this.f1759e != null) {
                    this.f1759e.setVisibility(8);
                    this.f1759e.setImageDrawable(null);
                    return;
                }
                return;
            }
            if (this.f1760f != null) {
                removeView(this.f1760f);
                this.f1760f = null;
            }
            Drawable drawableM1210a = cVar.m1210a();
            CharSequence charSequenceM1211b = cVar.m1211b();
            if (drawableM1210a != null) {
                if (this.f1759e == null) {
                    C0286q c0286q = new C0286q(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    c0286q.setLayoutParams(layoutParams);
                    addView(c0286q, 0);
                    this.f1759e = c0286q;
                }
                this.f1759e.setImageDrawable(drawableM1210a);
                this.f1759e.setVisibility(0);
            } else if (this.f1759e != null) {
                this.f1759e.setVisibility(8);
                this.f1759e.setImageDrawable(null);
            }
            boolean z = !TextUtils.isEmpty(charSequenceM1211b);
            if (z) {
                if (this.f1758d == null) {
                    C0242ab c0242ab = new C0242ab(getContext(), null, C0148a.a.actionBarTabTextStyle);
                    c0242ab.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    c0242ab.setLayoutParams(layoutParams2);
                    addView(c0242ab);
                    this.f1758d = c0242ab;
                }
                this.f1758d.setText(charSequenceM1211b);
                this.f1758d.setVisibility(0);
            } else if (this.f1758d != null) {
                this.f1758d.setVisibility(8);
                this.f1758d.setText((CharSequence) null);
            }
            if (this.f1759e != null) {
                this.f1759e.setContentDescription(cVar.m1214e());
            }
            C0265ay.m2010a(this, z ? null : cVar.m1214e());
        }

        /* JADX INFO: renamed from: a */
        public void m1946a(AbstractC0158a.c cVar) {
            this.f1757c = cVar;
            m1945a();
        }

        /* JADX INFO: renamed from: b */
        public AbstractC0158a.c m1947b() {
            return this.f1757c;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(AbstractC0158a.c.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(AbstractC0158a.c.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (C0256ap.this.f1744c <= 0 || getMeasuredWidth() <= C0256ap.this.f1744c) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(C0256ap.this.f1744c, 1073741824), i2);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m1939a() {
        return this.f1747f != null && this.f1747f.getParent() == this;
    }

    /* JADX INFO: renamed from: b */
    private void m1940b() {
        if (m1939a()) {
            return;
        }
        if (this.f1747f == null) {
            this.f1747f = m1942d();
        }
        removeView(this.f1743b);
        addView(this.f1747f, new ViewGroup.LayoutParams(-2, -1));
        if (this.f1747f.getAdapter() == null) {
            this.f1747f.setAdapter((SpinnerAdapter) new a());
        }
        if (this.f1742a != null) {
            removeCallbacks(this.f1742a);
            this.f1742a = null;
        }
        this.f1747f.setSelection(this.f1750i);
    }

    /* JADX INFO: renamed from: c */
    private boolean m1941c() {
        if (!m1939a()) {
            return false;
        }
        removeView(this.f1747f);
        addView(this.f1743b, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1747f.getSelectedItemPosition());
        return false;
    }

    /* JADX INFO: renamed from: d */
    private Spinner m1942d() {
        C0294y c0294y = new C0294y(getContext(), null, C0148a.a.actionDropDownStyle);
        c0294y.setLayoutParams(new C0250aj.a(-2, -1));
        c0294y.setOnItemSelectedListener(this);
        return c0294y;
    }

    /* JADX INFO: renamed from: a */
    c m1943a(AbstractC0158a.c cVar, boolean z) {
        c cVar2 = new c(getContext(), cVar, z);
        if (z) {
            cVar2.setBackgroundDrawable(null);
            cVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1749h));
        } else {
            cVar2.setFocusable(true);
            if (this.f1746e == null) {
                this.f1746e = new b();
            }
            cVar2.setOnClickListener(this.f1746e);
        }
        return cVar2;
    }

    /* JADX INFO: renamed from: a */
    public void m1944a(int i) {
        final View childAt = this.f1743b.getChildAt(i);
        if (this.f1742a != null) {
            removeCallbacks(this.f1742a);
        }
        this.f1742a = new Runnable() { // from class: android.support.v7.widget.ap.1
            @Override // java.lang.Runnable
            public void run() {
                C0256ap.this.smoothScrollTo(childAt.getLeft() - ((C0256ap.this.getWidth() - childAt.getWidth()) / 2), 0);
                C0256ap.this.f1742a = null;
            }
        };
        post(this.f1742a);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f1742a != null) {
            post(this.f1742a);
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0178a c0178aM1405a = C0178a.m1405a(getContext());
        setContentHeight(c0178aM1405a.m1410e());
        this.f1745d = c0178aM1405a.m1412g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1742a != null) {
            removeCallbacks(this.f1742a);
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((c) view).m1947b().m1213d();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int iMin;
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f1743b.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            iMin = -1;
        } else {
            if (childCount > 2) {
                this.f1744c = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.f1744c = View.MeasureSpec.getSize(i) / 2;
            }
            iMin = Math.min(this.f1744c, this.f1745d);
        }
        this.f1744c = iMin;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1749h, 1073741824);
        if (!z && this.f1748g) {
            this.f1743b.measure(0, iMakeMeasureSpec);
            if (this.f1743b.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                m1940b();
            } else {
                m1941c();
            }
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.f1750i);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f1748g = z;
    }

    public void setContentHeight(int i) {
        this.f1749h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f1750i = i;
        int childCount = this.f1743b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f1743b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                m1944a(i);
            }
            i2++;
        }
        if (this.f1747f == null || i < 0) {
            return;
        }
        this.f1747f.setSelection(i);
    }
}
