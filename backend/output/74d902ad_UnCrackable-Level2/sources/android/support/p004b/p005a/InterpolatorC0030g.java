package android.support.p004b.p005a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.p006a.p007a.C0036c;
import android.support.v4.p008b.C0076b;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: renamed from: android.support.b.a.g */
/* JADX INFO: loaded from: classes.dex */
public class InterpolatorC0030g implements Interpolator {

    /* JADX INFO: renamed from: a */
    private float[] f97a;

    /* JADX INFO: renamed from: b */
    private float[] f98b;

    public InterpolatorC0030g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public InterpolatorC0030g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayM195a = C0036c.m195a(resources, theme, attributeSet, C0024a.f81l);
        m125a(typedArrayM195a, xmlPullParser);
        typedArrayM195a.recycle();
    }

    /* JADX INFO: renamed from: a */
    private void m123a(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        m126a(path);
    }

    /* JADX INFO: renamed from: a */
    private void m124a(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        m126a(path);
    }

    /* JADX INFO: renamed from: a */
    private void m125a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (C0036c.m198a(xmlPullParser, "pathData")) {
            String strM196a = C0036c.m196a(typedArray, xmlPullParser, "pathData", 4);
            Path pathM669a = C0076b.m669a(strM196a);
            if (pathM669a != null) {
                m126a(pathM669a);
                return;
            }
            throw new InflateException("The path is null, which is created from " + strM196a);
        }
        if (!C0036c.m198a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!C0036c.m198a(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float fM193a = C0036c.m193a(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float fM193a2 = C0036c.m193a(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean zM198a = C0036c.m198a(xmlPullParser, "controlX2");
        if (zM198a != C0036c.m198a(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (zM198a) {
            m124a(fM193a, fM193a2, C0036c.m193a(typedArray, xmlPullParser, "controlX2", 2, 0.0f), C0036c.m193a(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        } else {
            m123a(fM193a, fM193a2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m126a(Path path) {
        int i = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int iMin = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (iMin <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.f97a = new float[iMin];
        this.f98b = new float[iMin];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < iMin; i2++) {
            pathMeasure.getPosTan((i2 * length) / (iMin - 1), fArr, null);
            this.f97a[i2] = fArr[0];
            this.f98b[i2] = fArr[1];
        }
        if (Math.abs(this.f97a[0]) <= 1.0E-5d && Math.abs(this.f98b[0]) <= 1.0E-5d) {
            int i3 = iMin - 1;
            if (Math.abs(this.f97a[i3] - 1.0f) <= 1.0E-5d && Math.abs(this.f98b[i3] - 1.0f) <= 1.0E-5d) {
                int i4 = 0;
                float f = 0.0f;
                while (i < iMin) {
                    int i5 = i4 + 1;
                    float f2 = this.f97a[i4];
                    if (f2 < f) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f2);
                    }
                    this.f97a[i] = f2;
                    i++;
                    f = f2;
                    i4 = i5;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The Path must start at (0,0) and end at (1,1) start: ");
        sb.append(this.f97a[0]);
        sb.append(",");
        sb.append(this.f98b[0]);
        sb.append(" end:");
        int i6 = iMin - 1;
        sb.append(this.f97a[i6]);
        sb.append(",");
        sb.append(this.f98b[i6]);
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int i = 0;
        int length = this.f97a.length - 1;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f97a[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.f97a[length] - this.f97a[i];
        if (f2 == 0.0f) {
            return this.f98b[i];
        }
        float f3 = (f - this.f97a[i]) / f2;
        float f4 = this.f98b[i];
        return f4 + (f3 * (this.f98b[length] - f4));
    }
}
