package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.os.IBinder;
import android.support.v7.app.DialogInterfaceC0159b;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.menu.InterfaceC0203o;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/* JADX INFO: renamed from: android.support.v7.view.menu.i */
/* JADX INFO: loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0197i implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener, InterfaceC0203o.a {

    /* JADX INFO: renamed from: a */
    C0194f f1301a;

    /* JADX INFO: renamed from: b */
    private C0196h f1302b;

    /* JADX INFO: renamed from: c */
    private DialogInterfaceC0159b f1303c;

    /* JADX INFO: renamed from: d */
    private InterfaceC0203o.a f1304d;

    public DialogInterfaceOnClickListenerC0197i(C0196h c0196h) {
        this.f1302b = c0196h;
    }

    /* JADX INFO: renamed from: a */
    public void m1576a() {
        if (this.f1303c != null) {
            this.f1303c.dismiss();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1577a(IBinder iBinder) {
        C0196h c0196h = this.f1302b;
        DialogInterfaceC0159b.a aVar = new DialogInterfaceC0159b.a(c0196h.m1561e());
        this.f1301a = new C0194f(aVar.m1216a(), C0148a.g.abc_list_menu_item_layout);
        this.f1301a.mo1472a(this);
        this.f1302b.m1540a(this.f1301a);
        aVar.m1220a(this.f1301a.m1514a(), this);
        View viewM1572o = c0196h.m1572o();
        if (viewM1572o != null) {
            aVar.m1219a(viewM1572o);
        } else {
            aVar.m1218a(c0196h.m1571n()).m1221a(c0196h.m1570m());
        }
        aVar.m1217a(this);
        this.f1303c = aVar.m1222b();
        this.f1303c.setOnDismissListener(this);
        WindowManager.LayoutParams attributes = this.f1303c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1303c.show();
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o.a
    /* JADX INFO: renamed from: a */
    public void mo1324a(C0196h c0196h, boolean z) {
        if (z || c0196h == this.f1302b) {
            m1576a();
        }
        if (this.f1304d != null) {
            this.f1304d.mo1324a(c0196h, z);
        }
    }

    @Override // android.support.v7.view.menu.InterfaceC0203o.a
    /* JADX INFO: renamed from: a */
    public boolean mo1325a(C0196h c0196h) {
        if (this.f1304d != null) {
            return this.f1304d.mo1325a(c0196h);
        }
        return false;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1302b.m1546a((C0198j) this.f1301a.m1514a().getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.f1301a.mo1470a(this.f1302b, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.f1303c.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.f1303c.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.f1302b.m1544a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.f1302b.performShortcut(i, keyEvent, 0);
    }
}
