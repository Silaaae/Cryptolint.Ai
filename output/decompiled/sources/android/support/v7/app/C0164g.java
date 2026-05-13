package android.support.v7.app;

import android.content.Context;
import android.support.v7.app.C0166i;
import android.support.v7.app.LayoutInflaterFactory2C0167j;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import java.util.List;

/* JADX INFO: renamed from: android.support.v7.app.g */
/* JADX INFO: loaded from: classes.dex */
class C0164g extends C0166i {

    /* JADX INFO: renamed from: android.support.v7.app.g$a */
    class a extends C0166i.a {
        a(Window.Callback callback) {
            super(C0164g.this, callback);
        }

        @Override // android.support.v7.view.WindowCallbackC0186i, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            LayoutInflaterFactory2C0167j.d dVarA = C0164g.this.m1302a(0, true);
            if (dVarA != null && dVarA.f992j != null) {
                menu = dVarA.f992j;
            }
            super.onProvideKeyboardShortcuts(list, menu, i);
        }
    }

    C0164g(Context context, Window window, InterfaceC0161d interfaceC0161d) {
        super(context, window, interfaceC0161d);
    }

    @Override // android.support.v7.app.C0166i, android.support.v7.app.C0165h, android.support.v7.app.AbstractC0163f
    /* JADX INFO: renamed from: a */
    Window.Callback mo1261a(Window.Callback callback) {
        return new a(callback);
    }
}
