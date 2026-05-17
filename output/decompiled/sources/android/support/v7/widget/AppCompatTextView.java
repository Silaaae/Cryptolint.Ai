package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.appcompat.C0139R;
import android.support.v7.internal.text.AllCapsTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView {
    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.textViewStyle);
    }

    public AppCompatTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, C0139R.styleable.AppCompatTextView, defStyle, 0);
        int ap = a.getResourceId(C0139R.styleable.AppCompatTextView_android_textAppearance, -1);
        a.recycle();
        if (ap != -1) {
            TypedArray appearance = context.obtainStyledAttributes(ap, C0139R.styleable.TextAppearance);
            if (appearance.hasValue(C0139R.styleable.TextAppearance_textAllCaps)) {
                setAllCaps(appearance.getBoolean(C0139R.styleable.TextAppearance_textAllCaps, false));
            }
            appearance.recycle();
        }
        TypedArray a2 = context.obtainStyledAttributes(attrs, C0139R.styleable.AppCompatTextView, defStyle, 0);
        if (a2.hasValue(C0139R.styleable.AppCompatTextView_textAllCaps)) {
            setAllCaps(a2.getBoolean(C0139R.styleable.AppCompatTextView_textAllCaps, false));
        }
        a2.recycle();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean allCaps) {
        setTransformationMethod(allCaps ? new AllCapsTransformationMethod(getContext()) : null);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int resId) {
        super.setTextAppearance(context, resId);
        TypedArray appearance = context.obtainStyledAttributes(resId, C0139R.styleable.TextAppearance);
        if (appearance.hasValue(C0139R.styleable.TextAppearance_textAllCaps)) {
            setAllCaps(appearance.getBoolean(C0139R.styleable.TextAppearance_textAllCaps, false));
        }
        appearance.recycle();
    }
}
