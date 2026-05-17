package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AlertController;
import android.support.v7.p018a.C0148a;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

/* JADX INFO: renamed from: android.support.v7.app.b */
/* JADX INFO: loaded from: classes.dex */
public class DialogInterfaceC0159b extends DialogC0168k implements DialogInterface {

    /* JADX INFO: renamed from: a */
    final AlertController f903a;

    /* JADX INFO: renamed from: android.support.v7.app.b$a */
    public static class a {

        /* JADX INFO: renamed from: a */
        private final AlertController.C0154a f904a;

        /* JADX INFO: renamed from: b */
        private final int f905b;

        public a(Context context) {
            this(context, DialogInterfaceC0159b.m1215a(context, 0));
        }

        public a(Context context, int i) {
            this.f904a = new AlertController.C0154a(new ContextThemeWrapper(context, DialogInterfaceC0159b.m1215a(context, i)));
            this.f905b = i;
        }

        /* JADX INFO: renamed from: a */
        public Context m1216a() {
            return this.f904a.f854a;
        }

        /* JADX INFO: renamed from: a */
        public a m1217a(DialogInterface.OnKeyListener onKeyListener) {
            this.f904a.f874u = onKeyListener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m1218a(Drawable drawable) {
            this.f904a.f857d = drawable;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m1219a(View view) {
            this.f904a.f860g = view;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m1220a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            this.f904a.f876w = listAdapter;
            this.f904a.f877x = onClickListener;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m1221a(CharSequence charSequence) {
            this.f904a.f859f = charSequence;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public DialogInterfaceC0159b m1222b() {
            DialogInterfaceC0159b dialogInterfaceC0159b = new DialogInterfaceC0159b(this.f904a.f854a, this.f905b);
            this.f904a.m1168a(dialogInterfaceC0159b.f903a);
            dialogInterfaceC0159b.setCancelable(this.f904a.f871r);
            if (this.f904a.f871r) {
                dialogInterfaceC0159b.setCanceledOnTouchOutside(true);
            }
            dialogInterfaceC0159b.setOnCancelListener(this.f904a.f872s);
            dialogInterfaceC0159b.setOnDismissListener(this.f904a.f873t);
            if (this.f904a.f874u != null) {
                dialogInterfaceC0159b.setOnKeyListener(this.f904a.f874u);
            }
            return dialogInterfaceC0159b;
        }
    }

    protected DialogInterfaceC0159b(Context context, int i) {
        super(context, m1215a(context, i));
        this.f903a = new AlertController(getContext(), this, getWindow());
    }

    /* JADX INFO: renamed from: a */
    static int m1215a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0148a.a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // android.support.v7.app.DialogC0168k, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f903a.m1153a();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f903a.m1159a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f903a.m1163b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.support.v7.app.DialogC0168k, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f903a.m1158a(charSequence);
    }
}
