package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.InterfaceC0203o;
import android.support.v7.view.menu.InterfaceC0204p;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: renamed from: android.support.v7.view.menu.b */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0190b implements InterfaceC0203o {

    /* JADX INFO: renamed from: a */
    protected Context f1208a;

    /* JADX INFO: renamed from: b */
    protected Context f1209b;

    /* JADX INFO: renamed from: c */
    protected C0196h f1210c;

    /* JADX INFO: renamed from: d */
    protected LayoutInflater f1211d;

    /* JADX INFO: renamed from: e */
    protected LayoutInflater f1212e;

    /* JADX INFO: renamed from: f */
    protected InterfaceC0204p f1213f;

    /* JADX INFO: renamed from: g */
    private InterfaceC0203o.a f1214g;

    /* JADX INFO: renamed from: h */
    private int f1215h;

    /* JADX INFO: renamed from: i */
    private int f1216i;

    /* JADX INFO: renamed from: j */
    private int f1217j;

    public AbstractC0190b(Context context, int i, int i2) {
        this.f1208a = context;
        this.f1211d = LayoutInflater.from(context);
        this.f1215h = i;
        this.f1216i = i2;
    }

    /* JADX INFO: renamed from: a */
    public InterfaceC0203o.a m1465a() {
        return this.f1214g;
    }

    /* JADX INFO: renamed from: a */
    public InterfaceC0204p mo1466a(ViewGroup viewGroup) {
        if (this.f1213f == null) {
            this.f1213f = (InterfaceC0204p) this.f1211d.inflate(this.f1215h, viewGroup, false);
            this.f1213f.mo1455a(this.f1210c);
            mo1479b(true);
        }
        return this.f1213f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public View mo1467a(C0198j c0198j, View view, ViewGroup viewGroup) {
        InterfaceC0204p.a aVarM1478b = view instanceof InterfaceC0204p.a ? (InterfaceC0204p.a) view : m1478b(viewGroup);
        mo1471a(c0198j, aVarM1478b);
        return (View) aVarM1478b;
    }

    /* JADX INFO: renamed from: a */
    public void m1468a(int i) {
        this.f1217j = i;
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public void mo1469a(Context context, C0196h c0196h) {
        this.f1209b = context;
        this.f1212e = LayoutInflater.from(this.f1209b);
        this.f1210c = c0196h;
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public void mo1470a(C0196h c0196h, boolean z) {
        if (this.f1214g != null) {
            this.f1214g.mo1324a(c0196h, z);
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo1471a(C0198j c0198j, InterfaceC0204p.a aVar);

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public void mo1472a(InterfaceC0203o.a aVar) {
        this.f1214g = aVar;
    }

    /* JADX INFO: renamed from: a */
    protected void m1473a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1213f).addView(view, i);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo1474a(int i, C0198j c0198j) {
        return true;
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public boolean mo1475a(C0196h c0196h, C0198j c0198j) {
        return false;
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: a */
    public boolean mo1476a(SubMenuC0209u subMenuC0209u) {
        if (this.f1214g != null) {
            return this.f1214g.mo1325a(subMenuC0209u);
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    protected boolean mo1477a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public InterfaceC0204p.a m1478b(ViewGroup viewGroup) {
        return (InterfaceC0204p.a) this.f1211d.inflate(this.f1216i, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.v7.view.menu.InterfaceC0203o
    /* JADX INFO: renamed from: b */
    public void mo1479b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1213f;
        if (viewGroup == null) {
            return;
        }
        int i = 0;
        if (this.f1210c != null) {
            this.f1210c.m1567j();
            ArrayList<C0198j> arrayListM1566i = this.f1210c.m1566i();
            int size = arrayListM1566i.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                C0198j c0198j = arrayListM1566i.get(i3);
                if (mo1474a(i2, c0198j)) {
                    View childAt = viewGroup.getChildAt(i2);
                    C0198j itemData = childAt instanceof InterfaceC0204p.a ? ((InterfaceC0204p.a) childAt).getItemData() : null;
                    View viewMo1467a = mo1467a(c0198j, childAt, viewGroup);
                    if (c0198j != itemData) {
                        viewMo1467a.setPressed(false);
                        viewMo1467a.jumpDrawablesToCurrentState();
                    }
                    if (viewMo1467a != childAt) {
                        m1473a(viewMo1467a, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!mo1477a(viewGroup, i)) {
                i++;
            }
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
}
