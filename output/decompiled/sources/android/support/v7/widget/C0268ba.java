package android.support.v7.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.p018a.C0148a;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* JADX INFO: renamed from: android.support.v7.widget.ba */
/* JADX INFO: loaded from: classes.dex */
class C0268ba {

    /* JADX INFO: renamed from: a */
    private final Context f1838a;

    /* JADX INFO: renamed from: b */
    private final View f1839b;

    /* JADX INFO: renamed from: c */
    private final TextView f1840c;

    /* JADX INFO: renamed from: d */
    private final WindowManager.LayoutParams f1841d = new WindowManager.LayoutParams();

    /* JADX INFO: renamed from: e */
    private final Rect f1842e = new Rect();

    /* JADX INFO: renamed from: f */
    private final int[] f1843f = new int[2];

    /* JADX INFO: renamed from: g */
    private final int[] f1844g = new int[2];

    C0268ba(Context context) {
        this.f1838a = context;
        this.f1839b = LayoutInflater.from(this.f1838a).inflate(C0148a.g.abc_tooltip, (ViewGroup) null);
        this.f1840c = (TextView) this.f1839b.findViewById(C0148a.f.message);
        this.f1841d.setTitle(getClass().getSimpleName());
        this.f1841d.packageName = this.f1838a.getPackageName();
        this.f1841d.type = 1002;
        this.f1841d.width = -2;
        this.f1841d.height = -2;
        this.f1841d.format = -3;
        this.f1841d.windowAnimations = C0148a.i.Animation_AppCompat_Tooltip;
        this.f1841d.flags = 24;
    }

    /* JADX INFO: renamed from: a */
    private static View m2019a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    /* JADX INFO: renamed from: a */
    private void m2020a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f1838a.getResources().getDimensionPixelOffset(C0148a.d.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f1838a.getResources().getDimensionPixelOffset(C0148a.d.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f1838a.getResources().getDimensionPixelOffset(z ? C0148a.d.tooltip_y_offset_touch : C0148a.d.tooltip_y_offset_non_touch);
        View viewM2019a = m2019a(view);
        if (viewM2019a == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewM2019a.getWindowVisibleDisplayFrame(this.f1842e);
        if (this.f1842e.left < 0 && this.f1842e.top < 0) {
            Resources resources = this.f1838a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f1842e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewM2019a.getLocationOnScreen(this.f1844g);
        view.getLocationOnScreen(this.f1843f);
        int[] iArr = this.f1843f;
        iArr[0] = iArr[0] - this.f1844g[0];
        int[] iArr2 = this.f1843f;
        iArr2[1] = iArr2[1] - this.f1844g[1];
        layoutParams.x = (this.f1843f[0] + i) - (viewM2019a.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f1839b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f1839b.getMeasuredHeight();
        int i4 = ((this.f1843f[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i5 = this.f1843f[1] + height + dimensionPixelOffset3;
        if (!z ? measuredHeight + i5 <= this.f1842e.height() : i4 < 0) {
            layoutParams.y = i4;
        } else {
            layoutParams.y = i5;
        }
    }

    /* JADX INFO: renamed from: a */
    void m2021a() {
        if (m2023b()) {
            ((WindowManager) this.f1838a.getSystemService("window")).removeView(this.f1839b);
        }
    }

    /* JADX INFO: renamed from: a */
    void m2022a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (m2023b()) {
            m2021a();
        }
        this.f1840c.setText(charSequence);
        m2020a(view, i, i2, z, this.f1841d);
        ((WindowManager) this.f1838a.getSystemService("window")).addView(this.f1839b, this.f1841d);
    }

    /* JADX INFO: renamed from: b */
    boolean m2023b() {
        return this.f1839b.getParent() != null;
    }
}
