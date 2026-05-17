package android.support.p004b.p005a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.v4.p006a.p007a.C0035b;
import android.support.v4.p006a.p007a.C0036c;
import android.support.v4.p008b.C0076b;
import android.support.v4.p008b.p009a.C0070a;
import android.support.v4.p014f.C0090a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: android.support.b.a.i */
/* JADX INFO: loaded from: classes.dex */
public class C0032i extends AbstractC0031h {

    /* JADX INFO: renamed from: a */
    static final PorterDuff.Mode f100a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c */
    private f f101c;

    /* JADX INFO: renamed from: d */
    private PorterDuffColorFilter f102d;

    /* JADX INFO: renamed from: e */
    private ColorFilter f103e;

    /* JADX INFO: renamed from: f */
    private boolean f104f;

    /* JADX INFO: renamed from: g */
    private boolean f105g;

    /* JADX INFO: renamed from: h */
    private Drawable.ConstantState f106h;

    /* JADX INFO: renamed from: i */
    private final float[] f107i;

    /* JADX INFO: renamed from: j */
    private final Matrix f108j;

    /* JADX INFO: renamed from: k */
    private final Rect f109k;

    /* JADX INFO: renamed from: android.support.b.a.i$a */
    private static class a extends d {
        public a() {
        }

        public a(a aVar) {
            super(aVar);
        }

        /* JADX INFO: renamed from: a */
        private void m137a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f137n = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f136m = C0076b.m676b(string2);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m138a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (C0036c.m198a(xmlPullParser, "pathData")) {
                TypedArray typedArrayM195a = C0036c.m195a(resources, theme, attributeSet, C0024a.f73d);
                m137a(typedArrayM195a);
                typedArrayM195a.recycle();
            }
        }

        @Override // android.support.p004b.p005a.C0032i.d
        /* JADX INFO: renamed from: a */
        public boolean mo139a() {
            return true;
        }
    }

    /* JADX INFO: renamed from: android.support.b.a.i$b */
    private static class b extends d {

        /* JADX INFO: renamed from: a */
        int f110a;

        /* JADX INFO: renamed from: b */
        float f111b;

        /* JADX INFO: renamed from: c */
        int f112c;

        /* JADX INFO: renamed from: d */
        float f113d;

        /* JADX INFO: renamed from: e */
        int f114e;

        /* JADX INFO: renamed from: f */
        float f115f;

        /* JADX INFO: renamed from: g */
        float f116g;

        /* JADX INFO: renamed from: h */
        float f117h;

        /* JADX INFO: renamed from: i */
        float f118i;

        /* JADX INFO: renamed from: j */
        Paint.Cap f119j;

        /* JADX INFO: renamed from: k */
        Paint.Join f120k;

        /* JADX INFO: renamed from: l */
        float f121l;

        /* JADX INFO: renamed from: p */
        private int[] f122p;

        public b() {
            this.f110a = 0;
            this.f111b = 0.0f;
            this.f112c = 0;
            this.f113d = 1.0f;
            this.f114e = 0;
            this.f115f = 1.0f;
            this.f116g = 0.0f;
            this.f117h = 1.0f;
            this.f118i = 0.0f;
            this.f119j = Paint.Cap.BUTT;
            this.f120k = Paint.Join.MITER;
            this.f121l = 4.0f;
        }

        public b(b bVar) {
            super(bVar);
            this.f110a = 0;
            this.f111b = 0.0f;
            this.f112c = 0;
            this.f113d = 1.0f;
            this.f114e = 0;
            this.f115f = 1.0f;
            this.f116g = 0.0f;
            this.f117h = 1.0f;
            this.f118i = 0.0f;
            this.f119j = Paint.Cap.BUTT;
            this.f120k = Paint.Join.MITER;
            this.f121l = 4.0f;
            this.f122p = bVar.f122p;
            this.f110a = bVar.f110a;
            this.f111b = bVar.f111b;
            this.f113d = bVar.f113d;
            this.f112c = bVar.f112c;
            this.f114e = bVar.f114e;
            this.f115f = bVar.f115f;
            this.f116g = bVar.f116g;
            this.f117h = bVar.f117h;
            this.f118i = bVar.f118i;
            this.f119j = bVar.f119j;
            this.f120k = bVar.f120k;
            this.f121l = bVar.f121l;
        }

        /* JADX INFO: renamed from: a */
        private Paint.Cap m140a(int i, Paint.Cap cap) {
            switch (i) {
                case 0:
                    return Paint.Cap.BUTT;
                case 1:
                    return Paint.Cap.ROUND;
                case 2:
                    return Paint.Cap.SQUARE;
                default:
                    return cap;
            }
        }

        /* JADX INFO: renamed from: a */
        private Paint.Join m141a(int i, Paint.Join join) {
            switch (i) {
                case 0:
                    return Paint.Join.MITER;
                case 1:
                    return Paint.Join.ROUND;
                case 2:
                    return Paint.Join.BEVEL;
                default:
                    return join;
            }
        }

        /* JADX INFO: renamed from: a */
        private void m142a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f122p = null;
            if (C0036c.m198a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f137n = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f136m = C0076b.m676b(string2);
                }
                this.f112c = C0036c.m199b(typedArray, xmlPullParser, "fillColor", 1, this.f112c);
                this.f115f = C0036c.m193a(typedArray, xmlPullParser, "fillAlpha", 12, this.f115f);
                this.f119j = m140a(C0036c.m194a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f119j);
                this.f120k = m141a(C0036c.m194a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f120k);
                this.f121l = C0036c.m193a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f121l);
                this.f110a = C0036c.m199b(typedArray, xmlPullParser, "strokeColor", 3, this.f110a);
                this.f113d = C0036c.m193a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f113d);
                this.f111b = C0036c.m193a(typedArray, xmlPullParser, "strokeWidth", 4, this.f111b);
                this.f117h = C0036c.m193a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f117h);
                this.f118i = C0036c.m193a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f118i);
                this.f116g = C0036c.m193a(typedArray, xmlPullParser, "trimPathStart", 5, this.f116g);
                this.f114e = C0036c.m194a(typedArray, xmlPullParser, "fillType", 13, this.f114e);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m143a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayM195a = C0036c.m195a(resources, theme, attributeSet, C0024a.f72c);
            m142a(typedArrayM195a, xmlPullParser);
            typedArrayM195a.recycle();
        }

        float getFillAlpha() {
            return this.f115f;
        }

        int getFillColor() {
            return this.f112c;
        }

        float getStrokeAlpha() {
            return this.f113d;
        }

        int getStrokeColor() {
            return this.f110a;
        }

        float getStrokeWidth() {
            return this.f111b;
        }

        float getTrimPathEnd() {
            return this.f117h;
        }

        float getTrimPathOffset() {
            return this.f118i;
        }

        float getTrimPathStart() {
            return this.f116g;
        }

        void setFillAlpha(float f) {
            this.f115f = f;
        }

        void setFillColor(int i) {
            this.f112c = i;
        }

        void setStrokeAlpha(float f) {
            this.f113d = f;
        }

        void setStrokeColor(int i) {
            this.f110a = i;
        }

        void setStrokeWidth(float f) {
            this.f111b = f;
        }

        void setTrimPathEnd(float f) {
            this.f117h = f;
        }

        void setTrimPathOffset(float f) {
            this.f118i = f;
        }

        void setTrimPathStart(float f) {
            this.f116g = f;
        }
    }

    /* JADX INFO: renamed from: android.support.b.a.i$c */
    private static class c {

        /* JADX INFO: renamed from: a */
        final ArrayList<Object> f123a;

        /* JADX INFO: renamed from: b */
        float f124b;

        /* JADX INFO: renamed from: c */
        int f125c;

        /* JADX INFO: renamed from: d */
        private final Matrix f126d;

        /* JADX INFO: renamed from: e */
        private float f127e;

        /* JADX INFO: renamed from: f */
        private float f128f;

        /* JADX INFO: renamed from: g */
        private float f129g;

        /* JADX INFO: renamed from: h */
        private float f130h;

        /* JADX INFO: renamed from: i */
        private float f131i;

        /* JADX INFO: renamed from: j */
        private float f132j;

        /* JADX INFO: renamed from: k */
        private final Matrix f133k;

        /* JADX INFO: renamed from: l */
        private int[] f134l;

        /* JADX INFO: renamed from: m */
        private String f135m;

        public c() {
            this.f126d = new Matrix();
            this.f123a = new ArrayList<>();
            this.f124b = 0.0f;
            this.f127e = 0.0f;
            this.f128f = 0.0f;
            this.f129g = 1.0f;
            this.f130h = 1.0f;
            this.f131i = 0.0f;
            this.f132j = 0.0f;
            this.f133k = new Matrix();
            this.f135m = null;
        }

        public c(c cVar, C0090a<String, Object> c0090a) {
            d aVar;
            this.f126d = new Matrix();
            this.f123a = new ArrayList<>();
            this.f124b = 0.0f;
            this.f127e = 0.0f;
            this.f128f = 0.0f;
            this.f129g = 1.0f;
            this.f130h = 1.0f;
            this.f131i = 0.0f;
            this.f132j = 0.0f;
            this.f133k = new Matrix();
            this.f135m = null;
            this.f124b = cVar.f124b;
            this.f127e = cVar.f127e;
            this.f128f = cVar.f128f;
            this.f129g = cVar.f129g;
            this.f130h = cVar.f130h;
            this.f131i = cVar.f131i;
            this.f132j = cVar.f132j;
            this.f134l = cVar.f134l;
            this.f135m = cVar.f135m;
            this.f125c = cVar.f125c;
            if (this.f135m != null) {
                c0090a.put(this.f135m, this);
            }
            this.f133k.set(cVar.f133k);
            ArrayList<Object> arrayList = cVar.f123a;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof c) {
                    this.f123a.add(new c((c) obj, c0090a));
                } else {
                    if (obj instanceof b) {
                        aVar = new b((b) obj);
                    } else {
                        if (!(obj instanceof a)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        aVar = new a((a) obj);
                    }
                    this.f123a.add(aVar);
                    if (aVar.f137n != null) {
                        c0090a.put(aVar.f137n, aVar);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m145a() {
            this.f133k.reset();
            this.f133k.postTranslate(-this.f127e, -this.f128f);
            this.f133k.postScale(this.f129g, this.f130h);
            this.f133k.postRotate(this.f124b, 0.0f, 0.0f);
            this.f133k.postTranslate(this.f131i + this.f127e, this.f132j + this.f128f);
        }

        /* JADX INFO: renamed from: a */
        private void m146a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f134l = null;
            this.f124b = C0036c.m193a(typedArray, xmlPullParser, "rotation", 5, this.f124b);
            this.f127e = typedArray.getFloat(1, this.f127e);
            this.f128f = typedArray.getFloat(2, this.f128f);
            this.f129g = C0036c.m193a(typedArray, xmlPullParser, "scaleX", 3, this.f129g);
            this.f130h = C0036c.m193a(typedArray, xmlPullParser, "scaleY", 4, this.f130h);
            this.f131i = C0036c.m193a(typedArray, xmlPullParser, "translateX", 6, this.f131i);
            this.f132j = C0036c.m193a(typedArray, xmlPullParser, "translateY", 7, this.f132j);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f135m = string;
            }
            m145a();
        }

        /* JADX INFO: renamed from: a */
        public void m148a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayM195a = C0036c.m195a(resources, theme, attributeSet, C0024a.f71b);
            m146a(typedArrayM195a, xmlPullParser);
            typedArrayM195a.recycle();
        }

        public String getGroupName() {
            return this.f135m;
        }

        public Matrix getLocalMatrix() {
            return this.f133k;
        }

        public float getPivotX() {
            return this.f127e;
        }

        public float getPivotY() {
            return this.f128f;
        }

        public float getRotation() {
            return this.f124b;
        }

        public float getScaleX() {
            return this.f129g;
        }

        public float getScaleY() {
            return this.f130h;
        }

        public float getTranslateX() {
            return this.f131i;
        }

        public float getTranslateY() {
            return this.f132j;
        }

        public void setPivotX(float f) {
            if (f != this.f127e) {
                this.f127e = f;
                m145a();
            }
        }

        public void setPivotY(float f) {
            if (f != this.f128f) {
                this.f128f = f;
                m145a();
            }
        }

        public void setRotation(float f) {
            if (f != this.f124b) {
                this.f124b = f;
                m145a();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f129g) {
                this.f129g = f;
                m145a();
            }
        }

        public void setScaleY(float f) {
            if (f != this.f130h) {
                this.f130h = f;
                m145a();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.f131i) {
                this.f131i = f;
                m145a();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.f132j) {
                this.f132j = f;
                m145a();
            }
        }
    }

    /* JADX INFO: renamed from: android.support.b.a.i$d */
    private static class d {

        /* JADX INFO: renamed from: m */
        protected C0076b.b[] f136m;

        /* JADX INFO: renamed from: n */
        String f137n;

        /* JADX INFO: renamed from: o */
        int f138o;

        public d() {
            this.f136m = null;
        }

        public d(d dVar) {
            this.f136m = null;
            this.f137n = dVar.f137n;
            this.f138o = dVar.f138o;
            this.f136m = C0076b.m674a(dVar.f136m);
        }

        /* JADX INFO: renamed from: a */
        public void m149a(Path path) {
            path.reset();
            if (this.f136m != null) {
                C0076b.b.m681a(this.f136m, path);
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean mo139a() {
            return false;
        }

        public C0076b.b[] getPathData() {
            return this.f136m;
        }

        public String getPathName() {
            return this.f137n;
        }

        public void setPathData(C0076b.b[] bVarArr) {
            if (C0076b.m672a(this.f136m, bVarArr)) {
                C0076b.m675b(this.f136m, bVarArr);
            } else {
                this.f136m = C0076b.m674a(bVarArr);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.b.a.i$e */
    private static class e {

        /* JADX INFO: renamed from: k */
        private static final Matrix f139k = new Matrix();

        /* JADX INFO: renamed from: a */
        final c f140a;

        /* JADX INFO: renamed from: b */
        float f141b;

        /* JADX INFO: renamed from: c */
        float f142c;

        /* JADX INFO: renamed from: d */
        float f143d;

        /* JADX INFO: renamed from: e */
        float f144e;

        /* JADX INFO: renamed from: f */
        int f145f;

        /* JADX INFO: renamed from: g */
        String f146g;

        /* JADX INFO: renamed from: h */
        final C0090a<String, Object> f147h;

        /* JADX INFO: renamed from: i */
        private final Path f148i;

        /* JADX INFO: renamed from: j */
        private final Path f149j;

        /* JADX INFO: renamed from: l */
        private final Matrix f150l;

        /* JADX INFO: renamed from: m */
        private Paint f151m;

        /* JADX INFO: renamed from: n */
        private Paint f152n;

        /* JADX INFO: renamed from: o */
        private PathMeasure f153o;

        /* JADX INFO: renamed from: p */
        private int f154p;

        public e() {
            this.f150l = new Matrix();
            this.f141b = 0.0f;
            this.f142c = 0.0f;
            this.f143d = 0.0f;
            this.f144e = 0.0f;
            this.f145f = 255;
            this.f146g = null;
            this.f147h = new C0090a<>();
            this.f140a = new c();
            this.f148i = new Path();
            this.f149j = new Path();
        }

        public e(e eVar) {
            this.f150l = new Matrix();
            this.f141b = 0.0f;
            this.f142c = 0.0f;
            this.f143d = 0.0f;
            this.f144e = 0.0f;
            this.f145f = 255;
            this.f146g = null;
            this.f147h = new C0090a<>();
            this.f140a = new c(eVar.f140a, this.f147h);
            this.f148i = new Path(eVar.f148i);
            this.f149j = new Path(eVar.f149j);
            this.f141b = eVar.f141b;
            this.f142c = eVar.f142c;
            this.f143d = eVar.f143d;
            this.f144e = eVar.f144e;
            this.f154p = eVar.f154p;
            this.f145f = eVar.f145f;
            this.f146g = eVar.f146g;
            if (eVar.f146g != null) {
                this.f147h.put(eVar.f146g, this);
            }
        }

        /* JADX INFO: renamed from: a */
        private static float m150a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        /* JADX INFO: renamed from: a */
        private float m151a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fM150a = m150a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fM150a) / fMax;
            }
            return 0.0f;
        }

        /* JADX INFO: renamed from: a */
        private void m154a(c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.f126d.set(matrix);
            cVar.f126d.preConcat(cVar.f133k);
            canvas.save();
            for (int i3 = 0; i3 < cVar.f123a.size(); i3++) {
                Object obj = cVar.f123a.get(i3);
                if (obj instanceof c) {
                    m154a((c) obj, cVar.f126d, canvas, i, i2, colorFilter);
                } else if (obj instanceof d) {
                    m155a(cVar, (d) obj, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        /* JADX INFO: renamed from: a */
        private void m155a(c cVar, d dVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.f143d;
            float f2 = i2 / this.f144e;
            float fMin = Math.min(f, f2);
            Matrix matrix = cVar.f126d;
            this.f150l.set(matrix);
            this.f150l.postScale(f, f2);
            float fM151a = m151a(matrix);
            if (fM151a == 0.0f) {
                return;
            }
            dVar.m149a(this.f148i);
            Path path = this.f148i;
            this.f149j.reset();
            if (dVar.mo139a()) {
                this.f149j.addPath(path, this.f150l);
                canvas.clipPath(this.f149j);
                return;
            }
            b bVar = (b) dVar;
            if (bVar.f116g != 0.0f || bVar.f117h != 1.0f) {
                float f3 = (bVar.f116g + bVar.f118i) % 1.0f;
                float f4 = (bVar.f117h + bVar.f118i) % 1.0f;
                if (this.f153o == null) {
                    this.f153o = new PathMeasure();
                }
                this.f153o.setPath(this.f148i, false);
                float length = this.f153o.getLength();
                float f5 = f3 * length;
                float f6 = f4 * length;
                path.reset();
                if (f5 > f6) {
                    this.f153o.getSegment(f5, length, path, true);
                    this.f153o.getSegment(0.0f, f6, path, true);
                } else {
                    this.f153o.getSegment(f5, f6, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f149j.addPath(path, this.f150l);
            if (bVar.f112c != 0) {
                if (this.f152n == null) {
                    this.f152n = new Paint();
                    this.f152n.setStyle(Paint.Style.FILL);
                    this.f152n.setAntiAlias(true);
                }
                Paint paint = this.f152n;
                paint.setColor(C0032i.m127a(bVar.f112c, bVar.f115f));
                paint.setColorFilter(colorFilter);
                this.f149j.setFillType(bVar.f114e == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f149j, paint);
            }
            if (bVar.f110a != 0) {
                if (this.f151m == null) {
                    this.f151m = new Paint();
                    this.f151m.setStyle(Paint.Style.STROKE);
                    this.f151m.setAntiAlias(true);
                }
                Paint paint2 = this.f151m;
                if (bVar.f120k != null) {
                    paint2.setStrokeJoin(bVar.f120k);
                }
                if (bVar.f119j != null) {
                    paint2.setStrokeCap(bVar.f119j);
                }
                paint2.setStrokeMiter(bVar.f121l);
                paint2.setColor(C0032i.m127a(bVar.f110a, bVar.f113d));
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(bVar.f111b * fMin * fM151a);
                canvas.drawPath(this.f149j, paint2);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m158a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m154a(this.f140a, f139k, canvas, i, i2, colorFilter);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f145f;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.f145f = i;
        }
    }

    /* JADX INFO: renamed from: android.support.b.a.i$f */
    private static class f extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        int f155a;

        /* JADX INFO: renamed from: b */
        e f156b;

        /* JADX INFO: renamed from: c */
        ColorStateList f157c;

        /* JADX INFO: renamed from: d */
        PorterDuff.Mode f158d;

        /* JADX INFO: renamed from: e */
        boolean f159e;

        /* JADX INFO: renamed from: f */
        Bitmap f160f;

        /* JADX INFO: renamed from: g */
        ColorStateList f161g;

        /* JADX INFO: renamed from: h */
        PorterDuff.Mode f162h;

        /* JADX INFO: renamed from: i */
        int f163i;

        /* JADX INFO: renamed from: j */
        boolean f164j;

        /* JADX INFO: renamed from: k */
        boolean f165k;

        /* JADX INFO: renamed from: l */
        Paint f166l;

        public f() {
            this.f157c = null;
            this.f158d = C0032i.f100a;
            this.f156b = new e();
        }

        public f(f fVar) {
            this.f157c = null;
            this.f158d = C0032i.f100a;
            if (fVar != null) {
                this.f155a = fVar.f155a;
                this.f156b = new e(fVar.f156b);
                if (fVar.f156b.f152n != null) {
                    this.f156b.f152n = new Paint(fVar.f156b.f152n);
                }
                if (fVar.f156b.f151m != null) {
                    this.f156b.f151m = new Paint(fVar.f156b.f151m);
                }
                this.f157c = fVar.f157c;
                this.f158d = fVar.f158d;
                this.f159e = fVar.f159e;
            }
        }

        /* JADX INFO: renamed from: a */
        public Paint m159a(ColorFilter colorFilter) {
            if (!m162a() && colorFilter == null) {
                return null;
            }
            if (this.f166l == null) {
                this.f166l = new Paint();
                this.f166l.setFilterBitmap(true);
            }
            this.f166l.setAlpha(this.f156b.getRootAlpha());
            this.f166l.setColorFilter(colorFilter);
            return this.f166l;
        }

        /* JADX INFO: renamed from: a */
        public void m160a(int i, int i2) {
            this.f160f.eraseColor(0);
            this.f156b.m158a(new Canvas(this.f160f), i, i2, (ColorFilter) null);
        }

        /* JADX INFO: renamed from: a */
        public void m161a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f160f, (Rect) null, rect, m159a(colorFilter));
        }

        /* JADX INFO: renamed from: a */
        public boolean m162a() {
            return this.f156b.getRootAlpha() < 255;
        }

        /* JADX INFO: renamed from: b */
        public void m163b(int i, int i2) {
            if (this.f160f == null || !m166c(i, i2)) {
                this.f160f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.f165k = true;
            }
        }

        /* JADX INFO: renamed from: b */
        public boolean m164b() {
            return !this.f165k && this.f161g == this.f157c && this.f162h == this.f158d && this.f164j == this.f159e && this.f163i == this.f156b.getRootAlpha();
        }

        /* JADX INFO: renamed from: c */
        public void m165c() {
            this.f161g = this.f157c;
            this.f162h = this.f158d;
            this.f163i = this.f156b.getRootAlpha();
            this.f164j = this.f159e;
            this.f165k = false;
        }

        /* JADX INFO: renamed from: c */
        public boolean m166c(int i, int i2) {
            return i == this.f160f.getWidth() && i2 == this.f160f.getHeight();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f155a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C0032i(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C0032i(this);
        }
    }

    /* JADX INFO: renamed from: android.support.b.a.i$g */
    private static class g extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        private final Drawable.ConstantState f167a;

        public g(Drawable.ConstantState constantState) {
            this.f167a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f167a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f167a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            C0032i c0032i = new C0032i();
            c0032i.f99b = (VectorDrawable) this.f167a.newDrawable();
            return c0032i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            C0032i c0032i = new C0032i();
            c0032i.f99b = (VectorDrawable) this.f167a.newDrawable(resources);
            return c0032i;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C0032i c0032i = new C0032i();
            c0032i.f99b = (VectorDrawable) this.f167a.newDrawable(resources, theme);
            return c0032i;
        }
    }

    C0032i() {
        this.f105g = true;
        this.f107i = new float[9];
        this.f108j = new Matrix();
        this.f109k = new Rect();
        this.f101c = new f();
    }

    C0032i(f fVar) {
        this.f105g = true;
        this.f107i = new float[9];
        this.f108j = new Matrix();
        this.f109k = new Rect();
        this.f101c = fVar;
        this.f102d = m134a(this.f102d, fVar.f157c, fVar.f158d);
    }

    /* JADX INFO: renamed from: a */
    static int m127a(int i, float f2) {
        return (i & 16777215) | (((int) (Color.alpha(i) * f2)) << 24);
    }

    /* JADX INFO: renamed from: a */
    private static PorterDuff.Mode m128a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* JADX INFO: renamed from: a */
    public static C0032i m129a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            C0032i c0032i = new C0032i();
            c0032i.f99b = C0035b.m188a(resources, i, theme);
            c0032i.f106h = new g(c0032i.f99b.getConstantState());
            return c0032i;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return m130a(resources, xml, attributeSetAsAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException | XmlPullParserException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static C0032i m130a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C0032i c0032i = new C0032i();
        c0032i.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0032i;
    }

    /* JADX INFO: renamed from: a */
    private void m131a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        f fVar = this.f101c;
        e eVar = fVar.f156b;
        fVar.f158d = m128a(C0036c.m194a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            fVar.f157c = colorStateList;
        }
        fVar.f159e = C0036c.m197a(typedArray, xmlPullParser, "autoMirrored", 5, fVar.f159e);
        eVar.f143d = C0036c.m193a(typedArray, xmlPullParser, "viewportWidth", 7, eVar.f143d);
        eVar.f144e = C0036c.m193a(typedArray, xmlPullParser, "viewportHeight", 8, eVar.f144e);
        if (eVar.f143d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (eVar.f144e <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        eVar.f141b = typedArray.getDimension(3, eVar.f141b);
        eVar.f142c = typedArray.getDimension(2, eVar.f142c);
        if (eVar.f141b <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (eVar.f142c <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        eVar.setAlpha(C0036c.m193a(typedArray, xmlPullParser, "alpha", 4, eVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            eVar.f146g = string;
            eVar.f147h.put(string, eVar);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m132a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && C0070a.m659g(this) == 1;
    }

    /* JADX INFO: renamed from: b */
    private void m133b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int i;
        int i2;
        f fVar = this.f101c;
        e eVar = fVar.f156b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(eVar.f140a);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                c cVar = (c) arrayDeque.peek();
                if ("path".equals(name)) {
                    b bVar = new b();
                    bVar.m143a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f123a.add(bVar);
                    if (bVar.getPathName() != null) {
                        eVar.f147h.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    i = fVar.f155a;
                    i2 = bVar.f138o;
                } else if ("clip-path".equals(name)) {
                    a aVar = new a();
                    aVar.m138a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f123a.add(aVar);
                    if (aVar.getPathName() != null) {
                        eVar.f147h.put(aVar.getPathName(), aVar);
                    }
                    i = fVar.f155a;
                    i2 = aVar.f138o;
                } else if ("group".equals(name)) {
                    c cVar2 = new c();
                    cVar2.m148a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f123a.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        eVar.f147h.put(cVar2.getGroupName(), cVar2);
                    }
                    i = fVar.f155a;
                    i2 = cVar2.f125c;
                }
                fVar.f155a = i2 | i;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* JADX INFO: renamed from: a */
    PorterDuffColorFilter m134a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* JADX INFO: renamed from: a */
    Object m135a(String str) {
        return this.f101c.f156b.f147h.get(str);
    }

    /* JADX INFO: renamed from: a */
    void m136a(boolean z) {
        this.f105g = z;
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f99b == null) {
            return false;
        }
        C0070a.m656d(this.f99b);
        return false;
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f99b != null) {
            this.f99b.draw(canvas);
            return;
        }
        copyBounds(this.f109k);
        if (this.f109k.width() <= 0 || this.f109k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f103e == null ? this.f102d : this.f103e;
        canvas.getMatrix(this.f108j);
        this.f108j.getValues(this.f107i);
        float fAbs = Math.abs(this.f107i[0]);
        float fAbs2 = Math.abs(this.f107i[4]);
        float fAbs3 = Math.abs(this.f107i[1]);
        float fAbs4 = Math.abs(this.f107i[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(2048, (int) (this.f109k.width() * fAbs));
        int iMin2 = Math.min(2048, (int) (this.f109k.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.f109k.left, this.f109k.top);
        if (m132a()) {
            canvas.translate(this.f109k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f109k.offsetTo(0, 0);
        this.f101c.m163b(iMin, iMin2);
        if (!this.f105g) {
            this.f101c.m160a(iMin, iMin2);
        } else if (!this.f101c.m164b()) {
            this.f101c.m160a(iMin, iMin2);
            this.f101c.m165c();
        }
        this.f101c.m161a(canvas, colorFilter, this.f109k);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f99b != null ? C0070a.m655c(this.f99b) : this.f101c.f156b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f99b != null ? this.f99b.getChangingConfigurations() : super.getChangingConfigurations() | this.f101c.getChangingConfigurations();
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f99b != null && Build.VERSION.SDK_INT >= 24) {
            return new g(this.f99b.getConstantState());
        }
        this.f101c.f155a = getChangingConfigurations();
        return this.f101c;
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f99b != null ? this.f99b.getIntrinsicHeight() : (int) this.f101c.f156b.f142c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f99b != null ? this.f99b.getIntrinsicWidth() : (int) this.f101c.f156b.f141b;
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f99b != null) {
            return this.f99b.getOpacity();
        }
        return -3;
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.f99b != null) {
            this.f99b.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.f99b != null) {
            C0070a.m650a(this.f99b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        f fVar = this.f101c;
        fVar.f156b = new e();
        TypedArray typedArrayM195a = C0036c.m195a(resources, theme, attributeSet, C0024a.f70a);
        m131a(typedArrayM195a, xmlPullParser);
        typedArrayM195a.recycle();
        fVar.f155a = getChangingConfigurations();
        fVar.f165k = true;
        m133b(resources, xmlPullParser, attributeSet, theme);
        this.f102d = m134a(this.f102d, fVar.f157c, fVar.f158d);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f99b != null) {
            this.f99b.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f99b != null ? C0070a.m653b(this.f99b) : this.f101c.f159e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f99b != null ? this.f99b.isStateful() : super.isStateful() || !(this.f101c == null || this.f101c.f157c == null || !this.f101c.f157c.isStateful());
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f99b != null) {
            this.f99b.mutate();
            return this;
        }
        if (!this.f104f && super.mutate() == this) {
            this.f101c = new f(this.f101c);
            this.f104f = true;
        }
        return this;
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f99b != null) {
            this.f99b.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f99b != null) {
            return this.f99b.setState(iArr);
        }
        f fVar = this.f101c;
        if (fVar.f157c == null || fVar.f158d == null) {
            return false;
        }
        this.f102d = m134a(this.f102d, fVar.f157c, fVar.f158d);
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.f99b != null) {
            this.f99b.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f99b != null) {
            this.f99b.setAlpha(i);
        } else if (this.f101c.f156b.getRootAlpha() != i) {
            this.f101c.f156b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f99b != null) {
            C0070a.m652a(this.f99b, z);
        } else {
            this.f101c.f159e = z;
        }
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f99b != null) {
            this.f99b.setColorFilter(colorFilter);
        } else {
            this.f103e = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.p008b.p009a.InterfaceC0071b
    public void setTint(int i) {
        if (this.f99b != null) {
            C0070a.m646a(this.f99b, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.p008b.p009a.InterfaceC0071b
    public void setTintList(ColorStateList colorStateList) {
        if (this.f99b != null) {
            C0070a.m648a(this.f99b, colorStateList);
            return;
        }
        f fVar = this.f101c;
        if (fVar.f157c != colorStateList) {
            fVar.f157c = colorStateList;
            this.f102d = m134a(this.f102d, colorStateList, fVar.f158d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.p008b.p009a.InterfaceC0071b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f99b != null) {
            C0070a.m651a(this.f99b, mode);
            return;
        }
        f fVar = this.f101c;
        if (fVar.f158d != mode) {
            fVar.f158d = mode;
            this.f102d = m134a(this.f102d, fVar.f157c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.f99b != null ? this.f99b.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.f99b != null) {
            this.f99b.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
