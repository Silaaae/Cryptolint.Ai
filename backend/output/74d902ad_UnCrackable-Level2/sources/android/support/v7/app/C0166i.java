package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.app.C0165h;
import android.view.ActionMode;
import android.view.Window;

/* JADX INFO: renamed from: android.support.v7.app.i */
/* JADX INFO: loaded from: classes.dex */
class C0166i extends C0165h {

    /* JADX INFO: renamed from: t */
    private final UiModeManager f943t;

    /* JADX INFO: renamed from: android.support.v7.app.i$a */
    class a extends C0165h.a {
        a(Window.Callback callback) {
            super(callback);
        }

        @Override // android.support.v7.app.C0165h.a, android.support.v7.view.WindowCallbackC0186i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // android.support.v7.view.WindowCallbackC0186i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (C0166i.this.mo1270o() && i == 0) ? m1281a(callback) : super.onWindowStartingActionMode(callback, i);
        }
    }

    C0166i(Context context, Window window, InterfaceC0161d interfaceC0161d) {
        super(context, window, interfaceC0161d);
        this.f943t = (UiModeManager) context.getSystemService("uimode");
    }

    @Override // android.support.v7.app.C0165h, android.support.v7.app.AbstractC0163f
    /* JADX INFO: renamed from: a */
    Window.Callback mo1261a(Window.Callback callback) {
        return new a(callback);
    }

    @Override // android.support.v7.app.C0165h
    /* JADX INFO: renamed from: d */
    int mo1280d(int i) {
        if (i == 0 && this.f943t.getNightMode() == 0) {
            return -1;
        }
        return super.mo1280d(i);
    }
}
