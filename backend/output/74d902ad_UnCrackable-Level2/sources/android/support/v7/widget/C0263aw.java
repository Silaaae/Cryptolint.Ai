package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.p006a.p007a.C0035b;
import android.support.v7.p019b.p020a.C0175b;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: renamed from: android.support.v7.widget.aw */
/* JADX INFO: loaded from: classes.dex */
public class C0263aw {

    /* JADX INFO: renamed from: a */
    private final Context f1800a;

    /* JADX INFO: renamed from: b */
    private final TypedArray f1801b;

    /* JADX INFO: renamed from: c */
    private TypedValue f1802c;

    private C0263aw(Context context, TypedArray typedArray) {
        this.f1800a = context;
        this.f1801b = typedArray;
    }

    /* JADX INFO: renamed from: a */
    public static C0263aw m1976a(Context context, int i, int[] iArr) {
        return new C0263aw(context, context.obtainStyledAttributes(i, iArr));
    }

    /* JADX INFO: renamed from: a */
    public static C0263aw m1977a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C0263aw(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* JADX INFO: renamed from: a */
    public static C0263aw m1978a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new C0263aw(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* JADX INFO: renamed from: a */
    public float m1979a(int i, float f) {
        return this.f1801b.getFloat(i, f);
    }

    /* JADX INFO: renamed from: a */
    public int m1980a(int i, int i2) {
        return this.f1801b.getInt(i, i2);
    }

    /* JADX INFO: renamed from: a */
    public Typeface m1981a(int i, int i2, C0035b.a aVar) {
        int resourceId = this.f1801b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1802c == null) {
            this.f1802c = new TypedValue();
        }
        return C0035b.m185a(this.f1800a, resourceId, this.f1802c, i2, aVar);
    }

    /* JADX INFO: renamed from: a */
    public Drawable m1982a(int i) {
        int resourceId;
        return (!this.f1801b.hasValue(i) || (resourceId = this.f1801b.getResourceId(i, 0)) == 0) ? this.f1801b.getDrawable(i) : C0175b.m1396b(this.f1800a, resourceId);
    }

    /* JADX INFO: renamed from: a */
    public void m1983a() {
        this.f1801b.recycle();
    }

    /* JADX INFO: renamed from: a */
    public boolean m1984a(int i, boolean z) {
        return this.f1801b.getBoolean(i, z);
    }

    /* JADX INFO: renamed from: b */
    public int m1985b(int i, int i2) {
        return this.f1801b.getColor(i, i2);
    }

    /* JADX INFO: renamed from: b */
    public Drawable m1986b(int i) {
        int resourceId;
        if (!this.f1801b.hasValue(i) || (resourceId = this.f1801b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return C0281l.m2092a().m2112a(this.f1800a, resourceId, true);
    }

    /* JADX INFO: renamed from: c */
    public int m1987c(int i, int i2) {
        return this.f1801b.getInteger(i, i2);
    }

    /* JADX INFO: renamed from: c */
    public CharSequence m1988c(int i) {
        return this.f1801b.getText(i);
    }

    /* JADX INFO: renamed from: d */
    public int m1989d(int i, int i2) {
        return this.f1801b.getDimensionPixelOffset(i, i2);
    }

    /* JADX INFO: renamed from: d */
    public String m1990d(int i) {
        return this.f1801b.getString(i);
    }

    /* JADX INFO: renamed from: e */
    public int m1991e(int i, int i2) {
        return this.f1801b.getDimensionPixelSize(i, i2);
    }

    /* JADX INFO: renamed from: e */
    public ColorStateList m1992e(int i) {
        int resourceId;
        ColorStateList colorStateListM1393a;
        return (!this.f1801b.hasValue(i) || (resourceId = this.f1801b.getResourceId(i, 0)) == 0 || (colorStateListM1393a = C0175b.m1393a(this.f1800a, resourceId)) == null) ? this.f1801b.getColorStateList(i) : colorStateListM1393a;
    }

    /* JADX INFO: renamed from: f */
    public int m1993f(int i, int i2) {
        return this.f1801b.getLayoutDimension(i, i2);
    }

    /* JADX INFO: renamed from: f */
    public CharSequence[] m1994f(int i) {
        return this.f1801b.getTextArray(i);
    }

    /* JADX INFO: renamed from: g */
    public int m1995g(int i, int i2) {
        return this.f1801b.getResourceId(i, i2);
    }

    /* JADX INFO: renamed from: g */
    public boolean m1996g(int i) {
        return this.f1801b.hasValue(i);
    }
}
