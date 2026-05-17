package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.p015g.AbstractC0111c;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* JADX INFO: renamed from: a */
    final C0222a f1461a;

    /* JADX INFO: renamed from: b */
    final FrameLayout f1462b;

    /* JADX INFO: renamed from: c */
    final FrameLayout f1463c;

    /* JADX INFO: renamed from: d */
    AbstractC0111c f1464d;

    /* JADX INFO: renamed from: e */
    final DataSetObserver f1465e;

    /* JADX INFO: renamed from: f */
    PopupWindow.OnDismissListener f1466f;

    /* JADX INFO: renamed from: g */
    boolean f1467g;

    /* JADX INFO: renamed from: h */
    int f1468h;

    /* JADX INFO: renamed from: i */
    private final ViewOnClickListenerC0223b f1469i;

    /* JADX INFO: renamed from: j */
    private final View f1470j;

    /* JADX INFO: renamed from: k */
    private final ImageView f1471k;

    /* JADX INFO: renamed from: l */
    private final int f1472l;

    /* JADX INFO: renamed from: m */
    private final ViewTreeObserver.OnGlobalLayoutListener f1473m;

    /* JADX INFO: renamed from: n */
    private C0251ak f1474n;

    /* JADX INFO: renamed from: o */
    private boolean f1475o;

    /* JADX INFO: renamed from: p */
    private int f1476p;

    public static class InnerLayout extends LinearLayout {

        /* JADX INFO: renamed from: a */
        private static final int[] f1477a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            C0263aw c0263awM1977a = C0263aw.m1977a(context, attributeSet, f1477a);
            setBackgroundDrawable(c0263awM1977a.m1982a(0));
            c0263awM1977a.m1983a();
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActivityChooserView$a */
    private class C0222a extends BaseAdapter {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ ActivityChooserView f1478a;

        /* JADX INFO: renamed from: b */
        private C0274e f1479b;

        /* JADX INFO: renamed from: c */
        private int f1480c;

        /* JADX INFO: renamed from: d */
        private boolean f1481d;

        /* JADX INFO: renamed from: e */
        private boolean f1482e;

        /* JADX INFO: renamed from: f */
        private boolean f1483f;

        /* JADX INFO: renamed from: a */
        public int m1688a() {
            int i = this.f1480c;
            this.f1480c = Integer.MAX_VALUE;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int iMax = 0;
            for (int i2 = 0; i2 < count; i2++) {
                view = getView(i2, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.f1480c = i;
            return iMax;
        }

        /* JADX INFO: renamed from: a */
        public void m1689a(int i) {
            if (this.f1480c != i) {
                this.f1480c = i;
                notifyDataSetChanged();
            }
        }

        /* JADX INFO: renamed from: a */
        public void m1690a(C0274e c0274e) {
            C0274e c0274eM1695d = this.f1478a.f1461a.m1695d();
            if (c0274eM1695d != null && this.f1478a.isShown()) {
                c0274eM1695d.unregisterObserver(this.f1478a.f1465e);
            }
            this.f1479b = c0274e;
            if (c0274e != null && this.f1478a.isShown()) {
                c0274e.registerObserver(this.f1478a.f1465e);
            }
            notifyDataSetChanged();
        }

        /* JADX INFO: renamed from: a */
        public void m1691a(boolean z) {
            if (this.f1483f != z) {
                this.f1483f = z;
                notifyDataSetChanged();
            }
        }

        /* JADX INFO: renamed from: a */
        public void m1692a(boolean z, boolean z2) {
            if (this.f1481d == z && this.f1482e == z2) {
                return;
            }
            this.f1481d = z;
            this.f1482e = z2;
            notifyDataSetChanged();
        }

        /* JADX INFO: renamed from: b */
        public ResolveInfo m1693b() {
            return this.f1479b.m2061b();
        }

        /* JADX INFO: renamed from: c */
        public int m1694c() {
            return this.f1479b.m2057a();
        }

        /* JADX INFO: renamed from: d */
        public C0274e m1695d() {
            return this.f1479b;
        }

        /* JADX INFO: renamed from: e */
        public boolean m1696e() {
            return this.f1481d;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iM2057a = this.f1479b.m2057a();
            if (!this.f1481d && this.f1479b.m2061b() != null) {
                iM2057a--;
            }
            int iMin = Math.min(iM2057a, this.f1480c);
            return this.f1483f ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!this.f1481d && this.f1479b.m2061b() != null) {
                        i++;
                    }
                    return this.f1479b.m2059a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.f1483f && i == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != C0148a.f.list_item) {
                        view = LayoutInflater.from(this.f1478a.getContext()).inflate(C0148a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f1478a.getContext().getPackageManager();
                    ImageView imageView = (ImageView) view.findViewById(C0148a.f.icon);
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(C0148a.f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.f1481d && i == 0 && this.f1482e) {
                        view.setActivated(true);
                    } else {
                        view.setActivated(false);
                    }
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    View viewInflate = LayoutInflater.from(this.f1478a.getContext()).inflate(C0148a.g.abc_activity_chooser_view_list_item, viewGroup, false);
                    viewInflate.setId(1);
                    ((TextView) viewInflate.findViewById(C0148a.f.title)).setText(this.f1478a.getContext().getString(C0148a.h.abc_activity_chooser_view_see_all));
                    return viewInflate;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActivityChooserView$b */
    private class ViewOnClickListenerC0223b implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ ActivityChooserView f1484a;

        /* JADX INFO: renamed from: a */
        private void m1697a() {
            if (this.f1484a.f1466f != null) {
                this.f1484a.f1466f.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != this.f1484a.f1463c) {
                if (view != this.f1484a.f1462b) {
                    throw new IllegalArgumentException();
                }
                this.f1484a.f1467g = false;
                this.f1484a.m1684a(this.f1484a.f1468h);
                return;
            }
            this.f1484a.m1686b();
            Intent intentM2060b = this.f1484a.f1461a.m1695d().m2060b(this.f1484a.f1461a.m1695d().m2058a(this.f1484a.f1461a.m1693b()));
            if (intentM2060b != null) {
                intentM2060b.addFlags(524288);
                this.f1484a.getContext().startActivity(intentM2060b);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            m1697a();
            if (this.f1484a.f1464d != null) {
                this.f1484a.f1464d.m894a(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0222a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.f1484a.m1686b();
                    if (this.f1484a.f1467g) {
                        if (i > 0) {
                            this.f1484a.f1461a.m1695d().m2062c(i);
                            return;
                        }
                        return;
                    }
                    if (!this.f1484a.f1461a.m1696e()) {
                        i++;
                    }
                    Intent intentM2060b = this.f1484a.f1461a.m1695d().m2060b(i);
                    if (intentM2060b != null) {
                        intentM2060b.addFlags(524288);
                        this.f1484a.getContext().startActivity(intentM2060b);
                        return;
                    }
                    return;
                case 1:
                    this.f1484a.m1684a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (view != this.f1484a.f1463c) {
                throw new IllegalArgumentException();
            }
            if (this.f1484a.f1461a.getCount() > 0) {
                this.f1484a.f1467g = true;
                this.f1484a.m1684a(this.f1484a.f1468h);
            }
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    void m1684a(int i) {
        C0222a c0222a;
        if (this.f1461a.m1695d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1473m);
        ?? r0 = this.f1463c.getVisibility() == 0 ? 1 : 0;
        int iM1694c = this.f1461a.m1694c();
        if (i == Integer.MAX_VALUE || iM1694c <= i + r0) {
            this.f1461a.m1691a(false);
            c0222a = this.f1461a;
        } else {
            this.f1461a.m1691a(true);
            c0222a = this.f1461a;
            i--;
        }
        c0222a.m1689a(i);
        C0251ak listPopupWindow = getListPopupWindow();
        if (listPopupWindow.mo1507d()) {
            return;
        }
        if (this.f1467g || r0 == 0) {
            this.f1461a.m1692a(true, r0);
        } else {
            this.f1461a.m1692a(false, false);
        }
        listPopupWindow.m1917g(Math.min(this.f1461a.m1688a(), this.f1472l));
        listPopupWindow.mo1497a();
        if (this.f1464d != null) {
            this.f1464d.m894a(true);
        }
        listPopupWindow.mo1508e().setContentDescription(getContext().getString(C0148a.h.abc_activitychooserview_choose_application));
        listPopupWindow.mo1508e().setSelector(new ColorDrawable(0));
    }

    /* JADX INFO: renamed from: a */
    public boolean m1685a() {
        if (m1687c() || !this.f1475o) {
            return false;
        }
        this.f1467g = false;
        m1684a(this.f1468h);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public boolean m1686b() {
        if (!m1687c()) {
            return true;
        }
        getListPopupWindow().mo1504c();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.f1473m);
        return true;
    }

    /* JADX INFO: renamed from: c */
    public boolean m1687c() {
        return getListPopupWindow().mo1507d();
    }

    public C0274e getDataModel() {
        return this.f1461a.m1695d();
    }

    C0251ak getListPopupWindow() {
        if (this.f1474n == null) {
            this.f1474n = new C0251ak(getContext());
            this.f1474n.mo1907a(this.f1461a);
            this.f1474n.m1911b(this);
            this.f1474n.m1909a(true);
            this.f1474n.m1906a((AdapterView.OnItemClickListener) this.f1469i);
            this.f1474n.m1908a((PopupWindow.OnDismissListener) this.f1469i);
        }
        return this.f1474n;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0274e c0274eM1695d = this.f1461a.m1695d();
        if (c0274eM1695d != null) {
            c0274eM1695d.registerObserver(this.f1465e);
        }
        this.f1475o = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0274e c0274eM1695d = this.f1461a.m1695d();
        if (c0274eM1695d != null) {
            c0274eM1695d.unregisterObserver(this.f1465e);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1473m);
        }
        if (m1687c()) {
            m1686b();
        }
        this.f1475o = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1470j.layout(0, 0, i3 - i, i4 - i2);
        if (m1687c()) {
            return;
        }
        m1686b();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.f1470j;
        if (this.f1463c.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0274e c0274e) {
        this.f1461a.m1690a(c0274e);
        if (m1687c()) {
            m1686b();
            m1685a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1476p = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1471k.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1471k.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f1468h = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f1466f = onDismissListener;
    }

    public void setProvider(AbstractC0111c abstractC0111c) {
        this.f1464d = abstractC0111c;
    }
}
