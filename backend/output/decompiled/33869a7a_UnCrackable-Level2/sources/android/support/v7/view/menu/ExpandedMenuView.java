package android.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.support.v7.view.menu.C0196h;
import android.support.v7.widget.C0263aw;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements C0196h.b, InterfaceC0204p, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    private static final int[] f1168a = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: b */
    private C0196h f1169b;

    /* JADX INFO: renamed from: c */
    private int f1170c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        C0263aw c0263awM1978a = C0263aw.m1978a(context, attributeSet, f1168a, i, 0);
        if (c0263awM1978a.m1996g(0)) {
            setBackgroundDrawable(c0263awM1978a.m1982a(0));
        }
        if (c0263awM1978a.m1996g(1)) {
            setDivider(c0263awM1978a.m1982a(1));
        }
        c0263awM1978a.m1983a();
    }

    @Override // android.support.v7.view.menu.InterfaceC0204p
    /* JADX INFO: renamed from: a */
    public void mo1455a(C0196h c0196h) {
        this.f1169b = c0196h;
    }

    @Override // android.support.v7.view.menu.C0196h.b
    /* JADX INFO: renamed from: a */
    public boolean mo1456a(C0198j c0198j) {
        return this.f1169b.m1546a(c0198j, 0);
    }

    public int getWindowAnimations() {
        return this.f1170c;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo1456a((C0198j) getAdapter().getItem(i));
    }
}
