package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.p015g.C0124p;
import android.support.v4.p015g.InterfaceC0123o;
import android.support.v7.p018a.C0148a;
import android.support.v7.p019b.p020a.C0175b;
import android.support.v7.view.C0181d;
import android.support.v7.view.menu.InterfaceC0207s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

/* JADX INFO: renamed from: android.support.v7.widget.y */
/* JADX INFO: loaded from: classes.dex */
public class C0294y extends Spinner implements InterfaceC0123o {

    /* JADX INFO: renamed from: a */
    private static final int[] f1964a = {R.attr.spinnerMode};

    /* JADX INFO: renamed from: b */
    private final C0276g f1965b;

    /* JADX INFO: renamed from: c */
    private final Context f1966c;

    /* JADX INFO: renamed from: d */
    private AbstractViewOnAttachStateChangeListenerC0249ai f1967d;

    /* JADX INFO: renamed from: e */
    private SpinnerAdapter f1968e;

    /* JADX INFO: renamed from: f */
    private final boolean f1969f;

    /* JADX INFO: renamed from: g */
    private b f1970g;

    /* JADX INFO: renamed from: h */
    private int f1971h;

    /* JADX INFO: renamed from: i */
    private final Rect f1972i;

    /* JADX INFO: renamed from: android.support.v7.widget.y$a */
    private static class a implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: a */
        private SpinnerAdapter f1975a;

        /* JADX INFO: renamed from: b */
        private ListAdapter f1976b;

        public a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f1975a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1976b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof InterfaceC0259as) {
                    InterfaceC0259as interfaceC0259as = (InterfaceC0259as) spinnerAdapter;
                    if (interfaceC0259as.m1971a() == null) {
                        interfaceC0259as.m1972a(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1976b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f1975a == null) {
                return 0;
            }
            return this.f1975a.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f1975a == null) {
                return null;
            }
            return this.f1975a.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.f1975a == null) {
                return null;
            }
            return this.f1975a.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (this.f1975a == null) {
                return -1L;
            }
            return this.f1975a.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return this.f1975a != null && this.f1975a.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f1976b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f1975a != null) {
                this.f1975a.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f1975a != null) {
                this.f1975a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.y$b */
    private class b extends C0251ak {

        /* JADX INFO: renamed from: a */
        ListAdapter f1977a;

        /* JADX INFO: renamed from: h */
        private CharSequence f1979h;

        /* JADX INFO: renamed from: i */
        private final Rect f1980i;

        public b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1980i = new Rect();
            m1911b(C0294y.this);
            m1909a(true);
            m1903a(0);
            m1906a(new AdapterView.OnItemClickListener() { // from class: android.support.v7.widget.y.b.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    C0294y.this.setSelection(i2);
                    if (C0294y.this.getOnItemClickListener() != null) {
                        C0294y.this.performItemClick(view, i2, b.this.f1977a.getItemId(i2));
                    }
                    b.this.mo1504c();
                }
            });
        }

        @Override // android.support.v7.widget.C0251ak, android.support.v7.view.menu.InterfaceC0207s
        /* JADX INFO: renamed from: a */
        public void mo1497a() {
            ViewTreeObserver viewTreeObserver;
            boolean zD = mo1507d();
            m2151f();
            m1920h(2);
            super.mo1497a();
            mo1508e().setChoiceMode(1);
            m1922i(C0294y.this.getSelectedItemPosition());
            if (zD || (viewTreeObserver = C0294y.this.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.y.b.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (!b.this.m2149a(C0294y.this)) {
                        b.this.mo1504c();
                    } else {
                        b.this.m2151f();
                        b.super.mo1497a();
                    }
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            m1908a(new PopupWindow.OnDismissListener() { // from class: android.support.v7.widget.y.b.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = C0294y.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }

        @Override // android.support.v7.widget.C0251ak
        /* JADX INFO: renamed from: a */
        public void mo1907a(ListAdapter listAdapter) {
            super.mo1907a(listAdapter);
            this.f1977a = listAdapter;
        }

        /* JADX INFO: renamed from: a */
        public void m2148a(CharSequence charSequence) {
            this.f1979h = charSequence;
        }

        /* JADX INFO: renamed from: a */
        boolean m2149a(View view) {
            return C0124p.m971m(view) && view.getGlobalVisibleRect(this.f1980i);
        }

        /* JADX INFO: renamed from: b */
        public CharSequence m2150b() {
            return this.f1979h;
        }

        /* JADX INFO: renamed from: f */
        void m2151f() {
            int iMax;
            Drawable drawableH = m1919h();
            int i = 0;
            if (drawableH != null) {
                drawableH.getPadding(C0294y.this.f1972i);
                i = C0270bc.m2027a(C0294y.this) ? C0294y.this.f1972i.right : -C0294y.this.f1972i.left;
            } else {
                Rect rect = C0294y.this.f1972i;
                C0294y.this.f1972i.right = 0;
                rect.left = 0;
            }
            int paddingLeft = C0294y.this.getPaddingLeft();
            int paddingRight = C0294y.this.getPaddingRight();
            int width = C0294y.this.getWidth();
            if (C0294y.this.f1971h == -2) {
                int iM2146a = C0294y.this.m2146a((SpinnerAdapter) this.f1977a, m1919h());
                int i2 = (C0294y.this.getContext().getResources().getDisplayMetrics().widthPixels - C0294y.this.f1972i.left) - C0294y.this.f1972i.right;
                if (iM2146a > i2) {
                    iM2146a = i2;
                }
                iMax = Math.max(iM2146a, (width - paddingLeft) - paddingRight);
            } else {
                iMax = C0294y.this.f1971h == -1 ? (width - paddingLeft) - paddingRight : C0294y.this.f1971h;
            }
            m1917g(iMax);
            m1913c(C0270bc.m2027a(C0294y.this) ? i + ((width - paddingRight) - m1925l()) : i + paddingLeft);
        }
    }

    public C0294y(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0148a.a.spinnerStyle);
    }

    public C0294y(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public C0294y(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0057 A[PHI: r11 r12
  0x0057: PHI (r11v3 int) = (r11v0 int), (r11v4 int) binds: [B:32:0x0069, B:23:0x0055] A[DONT_GENERATE, DONT_INLINE]
  0x0057: PHI (r12v15 android.content.res.TypedArray) = (r12v14 android.content.res.TypedArray), (r12v17 android.content.res.TypedArray) binds: [B:32:0x0069, B:23:0x0055] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0294y(Context context, AttributeSet attributeSet, int i, int i2, Resources.Theme theme) throws Throwable {
        C0181d c0181d;
        CharSequence[] charSequenceArrM1994f;
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i);
        this.f1972i = new Rect();
        C0263aw c0263awM1978a = C0263aw.m1978a(context, attributeSet, C0148a.j.Spinner, i, 0);
        this.f1965b = new C0276g(this);
        if (theme != null) {
            c0181d = new C0181d(context, theme);
        } else {
            int iM1995g = c0263awM1978a.m1995g(C0148a.j.Spinner_popupTheme, 0);
            if (iM1995g == 0) {
                this.f1966c = Build.VERSION.SDK_INT < 23 ? context : null;
                if (this.f1966c != null) {
                    if (i2 == -1) {
                        try {
                            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1964a, i, 0);
                            try {
                                try {
                                    i2 = typedArrayObtainStyledAttributes.hasValue(0) ? typedArrayObtainStyledAttributes.getInt(0, 0) : i2;
                                } catch (Exception e) {
                                    e = e;
                                    Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                    if (typedArrayObtainStyledAttributes != null) {
                                    }
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (typedArrayObtainStyledAttributes != null) {
                                    typedArrayObtainStyledAttributes.recycle();
                                }
                                throw th;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            typedArrayObtainStyledAttributes = null;
                        } catch (Throwable th2) {
                            th = th2;
                            typedArrayObtainStyledAttributes = null;
                            if (typedArrayObtainStyledAttributes != null) {
                            }
                            throw th;
                        }
                        if (typedArrayObtainStyledAttributes != null) {
                            typedArrayObtainStyledAttributes.recycle();
                        }
                    }
                    if (i2 == 1) {
                        final b bVar = new b(this.f1966c, attributeSet, i);
                        C0263aw c0263awM1978a2 = C0263aw.m1978a(this.f1966c, attributeSet, C0148a.j.Spinner, i, 0);
                        this.f1971h = c0263awM1978a2.m1993f(C0148a.j.Spinner_android_dropDownWidth, -2);
                        bVar.m1905a(c0263awM1978a2.m1982a(C0148a.j.Spinner_android_popupBackground));
                        bVar.m2148a(c0263awM1978a.m1990d(C0148a.j.Spinner_android_prompt));
                        c0263awM1978a2.m1983a();
                        this.f1970g = bVar;
                        this.f1967d = new AbstractViewOnAttachStateChangeListenerC0249ai(this) { // from class: android.support.v7.widget.y.1
                            @Override // android.support.v7.widget.AbstractViewOnAttachStateChangeListenerC0249ai
                            /* JADX INFO: renamed from: a */
                            public InterfaceC0207s mo1452a() {
                                return bVar;
                            }

                            @Override // android.support.v7.widget.AbstractViewOnAttachStateChangeListenerC0249ai
                            /* JADX INFO: renamed from: b */
                            public boolean mo1453b() {
                                if (C0294y.this.f1970g.mo1507d()) {
                                    return true;
                                }
                                C0294y.this.f1970g.mo1497a();
                                return true;
                            }
                        };
                    }
                }
                charSequenceArrM1994f = c0263awM1978a.m1994f(C0148a.j.Spinner_android_entries);
                if (charSequenceArrM1994f != null) {
                    ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrM1994f);
                    arrayAdapter.setDropDownViewResource(C0148a.g.support_simple_spinner_dropdown_item);
                    setAdapter((SpinnerAdapter) arrayAdapter);
                }
                c0263awM1978a.m1983a();
                this.f1969f = true;
                if (this.f1968e != null) {
                    setAdapter(this.f1968e);
                    this.f1968e = null;
                }
                this.f1965b.m2074a(attributeSet, i);
            }
            c0181d = new C0181d(context, iM1995g);
        }
        this.f1966c = c0181d;
        if (this.f1966c != null) {
        }
        charSequenceArrM1994f = c0263awM1978a.m1994f(C0148a.j.Spinner_android_entries);
        if (charSequenceArrM1994f != null) {
        }
        c0263awM1978a.m1983a();
        this.f1969f = true;
        if (this.f1968e != null) {
        }
        this.f1965b.m2074a(attributeSet, i);
    }

    /* JADX INFO: renamed from: a */
    int m2146a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.f1972i);
        return iMax2 + this.f1972i.left + this.f1972i.right;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1965b != null) {
            this.f1965b.m2077c();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        if (this.f1970g != null) {
            return this.f1970g.m1923j();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        if (this.f1970g != null) {
            return this.f1970g.m1924k();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f1970g != null) {
            return this.f1971h;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        if (this.f1970g != null) {
            return this.f1970g.m1919h();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        if (this.f1970g != null) {
            return this.f1966c;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        return this.f1970g != null ? this.f1970g.m2150b() : super.getPrompt();
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f1965b != null) {
            return this.f1965b.m2069a();
        }
        return null;
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f1965b != null) {
            return this.f1965b.m2075b();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1970g == null || !this.f1970g.mo1507d()) {
            return;
        }
        this.f1970g.mo1504c();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1970g == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m2146a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1967d == null || !this.f1967d.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        if (this.f1970g == null) {
            return super.performClick();
        }
        if (this.f1970g.mo1507d()) {
            return true;
        }
        this.f1970g.mo1497a();
        return true;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1969f) {
            this.f1968e = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1970g != null) {
            this.f1970g.mo1907a(new a(spinnerAdapter, (this.f1966c == null ? getContext() : this.f1966c).getTheme()));
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1965b != null) {
            this.f1965b.m2073a(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1965b != null) {
            this.f1965b.m2070a(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        if (this.f1970g != null) {
            this.f1970g.m1913c(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        if (this.f1970g != null) {
            this.f1970g.m1914d(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f1970g != null) {
            this.f1971h = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f1970g != null) {
            this.f1970g.m1905a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0175b.m1396b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        if (this.f1970g != null) {
            this.f1970g.m2148a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1965b != null) {
            this.f1965b.m2071a(colorStateList);
        }
    }

    @Override // android.support.v4.p015g.InterfaceC0123o
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f1965b != null) {
            this.f1965b.m2072a(mode);
        }
    }
}
