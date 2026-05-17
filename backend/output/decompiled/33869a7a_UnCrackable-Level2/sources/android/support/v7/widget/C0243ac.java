package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.support.v7.p018a.C0148a;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: renamed from: android.support.v7.widget.ac */
/* JADX INFO: loaded from: classes.dex */
class C0243ac {

    /* JADX INFO: renamed from: a */
    private static final RectF f1625a = new RectF();

    /* JADX INFO: renamed from: b */
    private static ConcurrentHashMap<String, Method> f1626b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c */
    private int f1627c = 0;

    /* JADX INFO: renamed from: d */
    private boolean f1628d = false;

    /* JADX INFO: renamed from: e */
    private float f1629e = -1.0f;

    /* JADX INFO: renamed from: f */
    private float f1630f = -1.0f;

    /* JADX INFO: renamed from: g */
    private float f1631g = -1.0f;

    /* JADX INFO: renamed from: h */
    private int[] f1632h = new int[0];

    /* JADX INFO: renamed from: i */
    private boolean f1633i = false;

    /* JADX INFO: renamed from: j */
    private TextPaint f1634j;

    /* JADX INFO: renamed from: k */
    private final TextView f1635k;

    /* JADX INFO: renamed from: l */
    private final Context f1636l;

    C0243ac(TextView textView) {
        this.f1635k = textView;
        this.f1636l = this.f1635k.getContext();
    }

    /* JADX INFO: renamed from: a */
    private int m1797a(RectF rectF) {
        int length = this.f1632h.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i = length - 1;
        int i2 = 1;
        int i3 = 0;
        while (i2 <= i) {
            int i4 = (i2 + i) / 2;
            if (m1805a(this.f1632h[i4], rectF)) {
                int i5 = i4 + 1;
                i3 = i2;
                i2 = i5;
            } else {
                i3 = i4 - 1;
                i = i3;
            }
        }
        return this.f1632h[i3];
    }

    /* JADX INFO: renamed from: a */
    private StaticLayout m1798a(CharSequence charSequence, Layout.Alignment alignment, int i) {
        float fFloatValue;
        float fFloatValue2;
        boolean zBooleanValue;
        if (Build.VERSION.SDK_INT >= 16) {
            fFloatValue = this.f1635k.getLineSpacingMultiplier();
            fFloatValue2 = this.f1635k.getLineSpacingExtra();
            zBooleanValue = this.f1635k.getIncludeFontPadding();
        } else {
            fFloatValue = ((Float) m1800a(this.f1635k, "getLineSpacingMultiplier", Float.valueOf(1.0f))).floatValue();
            fFloatValue2 = ((Float) m1800a(this.f1635k, "getLineSpacingExtra", Float.valueOf(0.0f))).floatValue();
            zBooleanValue = ((Boolean) m1800a(this.f1635k, "getIncludeFontPadding", true)).booleanValue();
        }
        return new StaticLayout(charSequence, this.f1634j, i, alignment, fFloatValue, fFloatValue2, zBooleanValue);
    }

    /* JADX INFO: renamed from: a */
    private StaticLayout m1799a(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        TextDirectionHeuristic textDirectionHeuristic = (TextDirectionHeuristic) m1800a(this.f1635k, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR);
        StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f1634j, i).setAlignment(alignment).setLineSpacing(this.f1635k.getLineSpacingExtra(), this.f1635k.getLineSpacingMultiplier()).setIncludePad(this.f1635k.getIncludeFontPadding()).setBreakStrategy(this.f1635k.getBreakStrategy()).setHyphenationFrequency(this.f1635k.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        return hyphenationFrequency.setMaxLines(i2).setTextDirection(textDirectionHeuristic).build();
    }

    /* JADX INFO: renamed from: a */
    private <T> T m1800a(Object obj, String str, T t) {
        try {
            return (T) m1801a(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return t;
        }
    }

    /* JADX INFO: renamed from: a */
    private Method m1801a(String str) {
        try {
            Method declaredMethod = f1626b.get(str);
            if (declaredMethod == null && (declaredMethod = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                declaredMethod.setAccessible(true);
                f1626b.put(str, declaredMethod);
            }
            return declaredMethod;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1802a(float f) {
        if (f != this.f1635k.getPaint().getTextSize()) {
            this.f1635k.getPaint().setTextSize(f);
            boolean zIsInLayout = Build.VERSION.SDK_INT >= 18 ? this.f1635k.isInLayout() : false;
            if (this.f1635k.getLayout() != null) {
                this.f1628d = false;
                try {
                    Method methodM1801a = m1801a("nullLayouts");
                    if (methodM1801a != null) {
                        methodM1801a.invoke(this.f1635k, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (zIsInLayout) {
                    this.f1635k.forceLayout();
                } else {
                    this.f1635k.requestLayout();
                }
                this.f1635k.invalidate();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1803a(float f, float f2, float f3) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        }
        if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        }
        if (f3 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
        this.f1627c = 1;
        this.f1630f = f;
        this.f1631g = f2;
        this.f1629e = f3;
        this.f1633i = false;
    }

    /* JADX INFO: renamed from: a */
    private void m1804a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f1632h = m1806a(iArr);
            m1807h();
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m1805a(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1635k.getText();
        TransformationMethod transformationMethod = this.f1635k.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f1635k)) != null) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f1635k.getMaxLines() : -1;
        if (this.f1634j == null) {
            this.f1634j = new TextPaint();
        } else {
            this.f1634j.reset();
        }
        this.f1634j.set(this.f1635k.getPaint());
        this.f1634j.setTextSize(i);
        Layout.Alignment alignment = (Layout.Alignment) m1800a(this.f1635k, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL);
        StaticLayout staticLayoutM1799a = Build.VERSION.SDK_INT >= 23 ? m1799a(text, alignment, Math.round(rectF.right), maxLines) : m1798a(text, alignment, Math.round(rectF.right));
        return (maxLines == -1 || (staticLayoutM1799a.getLineCount() <= maxLines && staticLayoutM1799a.getLineEnd(staticLayoutM1799a.getLineCount() - 1) == text.length())) && ((float) staticLayoutM1799a.getHeight()) <= rectF.bottom;
    }

    /* JADX INFO: renamed from: a */
    private int[] m1806a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    /* JADX INFO: renamed from: h */
    private boolean m1807h() {
        this.f1633i = this.f1632h.length > 0;
        if (this.f1633i) {
            this.f1627c = 1;
            this.f1630f = this.f1632h[0];
            this.f1631g = this.f1632h[r0 - 1];
            this.f1629e = -1.0f;
        }
        return this.f1633i;
    }

    /* JADX INFO: renamed from: i */
    private boolean m1808i() {
        if (m1810k() && this.f1627c == 1) {
            if (!this.f1633i || this.f1632h.length == 0) {
                float fRound = Math.round(this.f1630f);
                int i = 1;
                while (Math.round(this.f1629e + fRound) <= Math.round(this.f1631g)) {
                    i++;
                    fRound += this.f1629e;
                }
                int[] iArr = new int[i];
                float f = this.f1630f;
                for (int i2 = 0; i2 < i; i2++) {
                    iArr[i2] = Math.round(f);
                    f += this.f1629e;
                }
                this.f1632h = m1806a(iArr);
            }
            this.f1628d = true;
        } else {
            this.f1628d = false;
        }
        return this.f1628d;
    }

    /* JADX INFO: renamed from: j */
    private void m1809j() {
        this.f1627c = 0;
        this.f1630f = -1.0f;
        this.f1631g = -1.0f;
        this.f1629e = -1.0f;
        this.f1632h = new int[0];
        this.f1628d = false;
    }

    /* JADX INFO: renamed from: k */
    private boolean m1810k() {
        return !(this.f1635k instanceof C0282m);
    }

    /* JADX INFO: renamed from: a */
    int m1811a() {
        return this.f1627c;
    }

    /* JADX INFO: renamed from: a */
    void m1812a(int i) {
        if (m1810k()) {
            switch (i) {
                case 0:
                    m1809j();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.f1636l.getResources().getDisplayMetrics();
                    m1803a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (m1808i()) {
                        m1821f();
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m1813a(int i, float f) {
        m1802a(TypedValue.applyDimension(i, f, (this.f1636l == null ? Resources.getSystem() : this.f1636l.getResources()).getDisplayMetrics()));
    }

    /* JADX INFO: renamed from: a */
    void m1814a(int i, int i2, int i3, int i4) {
        if (m1810k()) {
            DisplayMetrics displayMetrics = this.f1636l.getResources().getDisplayMetrics();
            m1803a(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (m1808i()) {
                m1821f();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m1815a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f1636l.obtainStyledAttributes(attributeSet, C0148a.j.AppCompatTextView, i, 0);
        if (typedArrayObtainStyledAttributes.hasValue(C0148a.j.AppCompatTextView_autoSizeTextType)) {
            this.f1627c = typedArrayObtainStyledAttributes.getInt(C0148a.j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = typedArrayObtainStyledAttributes.hasValue(C0148a.j.AppCompatTextView_autoSizeStepGranularity) ? typedArrayObtainStyledAttributes.getDimension(C0148a.j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = typedArrayObtainStyledAttributes.hasValue(C0148a.j.AppCompatTextView_autoSizeMinTextSize) ? typedArrayObtainStyledAttributes.getDimension(C0148a.j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = typedArrayObtainStyledAttributes.hasValue(C0148a.j.AppCompatTextView_autoSizeMaxTextSize) ? typedArrayObtainStyledAttributes.getDimension(C0148a.j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (typedArrayObtainStyledAttributes.hasValue(C0148a.j.AppCompatTextView_autoSizePresetSizes) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray typedArrayObtainTypedArray = typedArrayObtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            m1804a(typedArrayObtainTypedArray);
            typedArrayObtainTypedArray.recycle();
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!m1810k()) {
            this.f1627c = 0;
            return;
        }
        if (this.f1627c == 1) {
            if (!this.f1633i) {
                DisplayMetrics displayMetrics = this.f1636l.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                m1803a(dimension2, dimension3, dimension);
            }
            m1808i();
        }
    }

    /* JADX INFO: renamed from: a */
    void m1816a(int[] iArr, int i) {
        if (m1810k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArrCopyOf = new int[length];
                if (i == 0) {
                    iArrCopyOf = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1636l.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArrCopyOf[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                this.f1632h = m1806a(iArrCopyOf);
                if (!m1807h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1633i = false;
            }
            if (m1808i()) {
                m1821f();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    int m1817b() {
        return Math.round(this.f1629e);
    }

    /* JADX INFO: renamed from: c */
    int m1818c() {
        return Math.round(this.f1630f);
    }

    /* JADX INFO: renamed from: d */
    int m1819d() {
        return Math.round(this.f1631g);
    }

    /* JADX INFO: renamed from: e */
    int[] m1820e() {
        return this.f1632h;
    }

    /* JADX INFO: renamed from: f */
    void m1821f() {
        if (m1822g()) {
            if (this.f1628d) {
                if (this.f1635k.getMeasuredHeight() <= 0 || this.f1635k.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = ((Boolean) m1800a(this.f1635k, "getHorizontallyScrolling", false)).booleanValue() ? 1048576 : (this.f1635k.getMeasuredWidth() - this.f1635k.getTotalPaddingLeft()) - this.f1635k.getTotalPaddingRight();
                int height = (this.f1635k.getHeight() - this.f1635k.getCompoundPaddingBottom()) - this.f1635k.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                synchronized (f1625a) {
                    f1625a.setEmpty();
                    f1625a.right = measuredWidth;
                    f1625a.bottom = height;
                    float fM1797a = m1797a(f1625a);
                    if (fM1797a != this.f1635k.getTextSize()) {
                        m1813a(0, fM1797a);
                    }
                }
            }
            this.f1628d = true;
        }
    }

    /* JADX INFO: renamed from: g */
    boolean m1822g() {
        return m1810k() && this.f1627c != 0;
    }
}
