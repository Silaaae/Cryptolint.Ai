package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: renamed from: android.support.v7.view.menu.m */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0201m implements InterfaceC0203o, InterfaceC0207s, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    private Rect f1349a;

    AbstractC0201m() {
    }

    /* JADX INFO: renamed from: a */
    protected static int m1606a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup frameLayout = viewGroup;
        View view = null;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i2) {
                view = null;
                i2 = itemViewType;
            }
            if (frameLayout == null) {
                frameLayout = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, frameLayout);
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i3) {
                i3 = measuredWidth;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: a */
    protected static C0195g m1607a(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (C0195g) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (C0195g) listAdapter;
    }

    /* JADX INFO: renamed from: b */
    protected static boolean m1608b(C0196h c0196h) {
        int size = c0196h.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0196h.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo1498a(int i);

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public void mo1469a(Context context, C0196h c0196h) {
    }

    /* JADX INFO: renamed from: a */
    public void m1609a(Rect rect) {
        this.f1349a = rect;
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo1499a(C0196h c0196h);

    /* JADX INFO: renamed from: a */
    public abstract void mo1500a(View view);

    /* JADX INFO: renamed from: a */
    public abstract void mo1501a(PopupWindow.OnDismissListener onDismissListener);

    /* JADX INFO: renamed from: a */
    public abstract void mo1502a(boolean z);

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public boolean mo1475a(C0196h c0196h, C0198j c0198j) {
        return false;
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo1503b(int i);

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: b */
    public boolean mo1481b(C0196h c0196h, C0198j c0198j) {
        return false;
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo1505c(int i);

    /* JADX INFO: renamed from: c */
    public abstract void mo1506c(boolean z);

    /* JADX INFO: renamed from: f */
    protected boolean mo1509f() {
        return true;
    }

    /* JADX INFO: renamed from: g */
    public Rect m1610g() {
        return this.f1349a;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        m1607a(listAdapter).f1270b.m1547a((MenuItem) listAdapter.getItem(i), this, mo1509f() ? 0 : 4);
    }
}
