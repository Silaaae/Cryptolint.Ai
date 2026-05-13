package android.support.v7.view.menu;

import android.support.v7.p018a.C0148a;
import android.support.v7.view.menu.InterfaceC0204p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: renamed from: android.support.v7.view.menu.g */
/* JADX INFO: loaded from: classes.dex */
public class C0195g extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    static final int f1269a = C0148a.g.abc_popup_menu_item_layout;

    /* JADX INFO: renamed from: b */
    C0196h f1270b;

    /* JADX INFO: renamed from: c */
    private int f1271c = -1;

    /* JADX INFO: renamed from: d */
    private boolean f1272d;

    /* JADX INFO: renamed from: e */
    private final boolean f1273e;

    /* JADX INFO: renamed from: f */
    private final LayoutInflater f1274f;

    public C0195g(C0196h c0196h, LayoutInflater layoutInflater, boolean z) {
        this.f1273e = z;
        this.f1274f = layoutInflater;
        this.f1270b = c0196h;
        m1520b();
    }

    /* JADX INFO: renamed from: a */
    public C0196h m1517a() {
        return this.f1270b;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0198j getItem(int i) {
        ArrayList<C0198j> arrayListM1569l = this.f1273e ? this.f1270b.m1569l() : this.f1270b.m1566i();
        if (this.f1271c >= 0 && i >= this.f1271c) {
            i++;
        }
        return arrayListM1569l.get(i);
    }

    /* JADX INFO: renamed from: a */
    public void m1519a(boolean z) {
        this.f1272d = z;
    }

    /* JADX INFO: renamed from: b */
    void m1520b() {
        C0198j c0198jM1575r = this.f1270b.m1575r();
        if (c0198jM1575r != null) {
            ArrayList<C0198j> arrayListM1569l = this.f1270b.m1569l();
            int size = arrayListM1569l.size();
            for (int i = 0; i < size; i++) {
                if (arrayListM1569l.get(i) == c0198jM1575r) {
                    this.f1271c = i;
                    return;
                }
            }
        }
        this.f1271c = -1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f1271c < 0 ? (this.f1273e ? this.f1270b.m1569l() : this.f1270b.m1566i()).size() : r0.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f1274f.inflate(f1269a, viewGroup, false);
        }
        InterfaceC0204p.a aVar = (InterfaceC0204p.a) view;
        if (this.f1272d) {
            ((ListMenuItemView) view).setForceShowIcon(true);
        }
        aVar.mo1447a(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        m1520b();
        super.notifyDataSetChanged();
    }
}
