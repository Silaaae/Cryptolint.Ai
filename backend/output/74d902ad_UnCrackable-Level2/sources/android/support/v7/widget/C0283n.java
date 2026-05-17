package android.support.v7.widget;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: renamed from: android.support.v7.widget.n */
/* JADX INFO: loaded from: classes.dex */
class C0283n {
    /* JADX INFO: renamed from: a */
    static InputConnection m2120a(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                }
                if (parent instanceof InterfaceC0271bd) {
                    editorInfo.hintText = ((InterfaceC0271bd) parent).m2029a();
                    break;
                }
                parent = parent.getParent();
            }
        }
        return inputConnection;
    }
}
