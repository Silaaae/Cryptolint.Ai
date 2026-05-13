package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.support.v7.p019b.p020a.C0175b;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;

/* JADX INFO: renamed from: android.support.v7.widget.j */
/* JADX INFO: loaded from: classes.dex */
public class C0279j extends CheckedTextView {

    /* JADX INFO: renamed from: a */
    private static final int[] f1912a = {R.attr.checkMark};

    /* JADX INFO: renamed from: b */
    private final C0295z f1913b;

    public C0279j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkedTextViewStyle);
    }

    public C0279j(Context context, AttributeSet attributeSet, int i) {
        super(C0260at.m1973a(context), attributeSet, i);
        this.f1913b = C0295z.m2153a(this);
        this.f1913b.mo1796a(attributeSet, i);
        this.f1913b.mo1795a();
        C0263aw c0263awM1978a = C0263aw.m1978a(getContext(), attributeSet, f1912a, i, 0);
        setCheckMarkDrawable(c0263awM1978a.m1982a(0));
        c0263awM1978a.m1983a();
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1913b != null) {
            this.f1913b.mo1795a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C0283n.m2120a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(C0175b.m1396b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1913b != null) {
            this.f1913b.m2161a(context, i);
        }
    }
}
