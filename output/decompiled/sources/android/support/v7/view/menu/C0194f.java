package android.support.v7.view.menu;

import android.content.Context;
import android.os.IBinder;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.menu.InterfaceC0203o;
import android.support.v7.view.menu.InterfaceC0204p;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

/* JADX INFO: renamed from: android.support.v7.view.menu.f */
/* JADX INFO: loaded from: classes.dex */
public class C0194f implements InterfaceC0203o, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a */
    Context f1258a;

    /* JADX INFO: renamed from: b */
    LayoutInflater f1259b;

    /* JADX INFO: renamed from: c */
    C0196h f1260c;

    /* JADX INFO: renamed from: d */
    ExpandedMenuView f1261d;

    /* JADX INFO: renamed from: e */
    int f1262e;

    /* JADX INFO: renamed from: f */
    int f1263f;

    /* JADX INFO: renamed from: g */
    int f1264g;

    /* JADX INFO: renamed from: h */
    a f1265h;

    /* JADX INFO: renamed from: i */
    private InterfaceC0203o.a f1266i;

    /* JADX INFO: renamed from: android.support.v7.view.menu.f$a */
    private class a extends BaseAdapter {

        /* JADX INFO: renamed from: b */
        private int f1268b = -1;

        public a() {
            m1516a();
        }

        @Override // android.widget.Adapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0198j getItem(int i) {
            ArrayList<C0198j> arrayListM1569l = C0194f.this.f1260c.m1569l();
            int i2 = i + C0194f.this.f1262e;
            if (this.f1268b >= 0 && i2 >= this.f1268b) {
                i2++;
            }
            return arrayListM1569l.get(i2);
        }

        /* JADX INFO: renamed from: a */
        void m1516a() {
            C0198j c0198jM1575r = C0194f.this.f1260c.m1575r();
            if (c0198jM1575r != null) {
                ArrayList<C0198j> arrayListM1569l = C0194f.this.f1260c.m1569l();
                int size = arrayListM1569l.size();
                for (int i = 0; i < size; i++) {
                    if (arrayListM1569l.get(i) == c0198jM1575r) {
                        this.f1268b = i;
                        return;
                    }
                }
            }
            this.f1268b = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = C0194f.this.f1260c.m1569l().size() - C0194f.this.f1262e;
            return this.f1268b < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = C0194f.this.f1259b.inflate(C0194f.this.f1264g, viewGroup, false);
            }
            ((InterfaceC0204p.a) view).mo1447a(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            m1516a();
            super.notifyDataSetChanged();
        }
    }

    public C0194f(int i, int i2) {
        this.f1264g = i;
        this.f1263f = i2;
    }

    public C0194f(Context context, int i) {
        this(i, 0);
        this.f1258a = context;
        this.f1259b = LayoutInflater.from(this.f1258a);
    }

    /* JADX INFO: renamed from: a */
    public InterfaceC0204p m1513a(ViewGroup viewGroup) {
        if (this.f1261d == null) {
            this.f1261d = (ExpandedMenuView) this.f1259b.inflate(C0148a.g.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1265h == null) {
                this.f1265h = new a();
            }
            this.f1261d.setAdapter((ListAdapter) this.f1265h);
            this.f1261d.setOnItemClickListener(this);
        }
        return this.f1261d;
    }

    /* JADX INFO: renamed from: a */
    public ListAdapter m1514a() {
        if (this.f1265h == null) {
            this.f1265h = new a();
        }
        return this.f1265h;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo1469a(Context context, C0196h c0196h) {
        if (this.f1263f == 0) {
            if (this.f1258a != null) {
                this.f1258a = context;
                if (this.f1259b == null) {
                }
            }
            this.f1260c = c0196h;
            if (this.f1265h == null) {
                this.f1265h.notifyDataSetChanged();
                return;
            }
            return;
        }
        this.f1258a = new ContextThemeWrapper(context, this.f1263f);
        this.f1259b = LayoutInflater.from(this.f1258a);
        this.f1260c = c0196h;
        if (this.f1265h == null) {
        }
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public void mo1470a(C0196h c0196h, boolean z) {
        if (this.f1266i != null) {
            this.f1266i.mo1324a(c0196h, z);
        }
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public void mo1472a(InterfaceC0203o.a aVar) {
        this.f1266i = aVar;
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public boolean mo1475a(C0196h c0196h, C0198j c0198j) {
        return false;
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public boolean mo1476a(SubMenuC0209u subMenuC0209u) {
        if (!subMenuC0209u.hasVisibleItems()) {
            return false;
        }
        new DialogInterfaceOnClickListenerC0197i(subMenuC0209u).m1577a((IBinder) null);
        if (this.f1266i == null) {
            return true;
        }
        this.f1266i.mo1325a(subMenuC0209u);
        return true;
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: b */
    public void mo1479b(boolean z) {
        if (this.f1265h != null) {
            this.f1265h.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: b */
    public boolean mo1480b() {
        return false;
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: b */
    public boolean mo1481b(C0196h c0196h, C0198j c0198j) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1260c.m1547a(this.f1265h.getItem(i), this, 0);
    }
}
