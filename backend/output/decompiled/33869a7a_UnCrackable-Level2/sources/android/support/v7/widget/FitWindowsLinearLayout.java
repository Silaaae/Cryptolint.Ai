package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.InterfaceC0248ah;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements InterfaceC0248ah {

    /* JADX INFO: renamed from: a */
    private InterfaceC0248ah.a f1497a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.f1497a != null) {
            this.f1497a.mo1321a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // android.support.v7.widget.InterfaceC0248ah
    public void setOnFitSystemWindowsListener(InterfaceC0248ah.a aVar) {
        this.f1497a = aVar;
    }
}
