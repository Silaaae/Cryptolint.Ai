package android.support.p004b.p005a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.support.v4.p006a.p007a.C0036c;
import android.support.v4.p008b.C0076b;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: android.support.b.a.e */
/* JADX INFO: loaded from: classes.dex */
public class C0028e {

    /* JADX INFO: renamed from: android.support.b.a.e$a */
    private static class a implements TypeEvaluator<C0076b.b[]> {

        /* JADX INFO: renamed from: a */
        private C0076b.b[] f95a;

        private a() {
        }

        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0076b.b[] evaluate(float f, C0076b.b[] bVarArr, C0076b.b[] bVarArr2) {
            if (!C0076b.m672a(bVarArr, bVarArr2)) {
                throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
            }
            if (this.f95a == null || !C0076b.m672a(this.f95a, bVarArr)) {
                this.f95a = C0076b.m674a(bVarArr);
            }
            for (int i = 0; i < bVarArr.length; i++) {
                this.f95a[i].m682a(bVarArr[i], bVarArr2[i], f);
            }
            return this.f95a;
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m102a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray typedArrayM195a = C0036c.m195a(resources, theme, attributeSet, C0024a.f79j);
        int i = 0;
        TypedValue typedValueM200b = C0036c.m200b(typedArrayM195a, xmlPullParser, "value", 0);
        if ((typedValueM200b != null) && m119a(typedValueM200b.type)) {
            i = 3;
        }
        typedArrayM195a.recycle();
        return i;
    }

    /* JADX INFO: renamed from: a */
    private static int m103a(TypedArray typedArray, int i, int i2) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i);
        boolean z = typedValuePeekValue != null;
        int i3 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i2);
        boolean z2 = typedValuePeekValue2 != null;
        return ((z && m119a(i3)) || (z2 && m119a(z2 ? typedValuePeekValue2.type : 0))) ? 3 : 0;
    }

    /* JADX INFO: renamed from: a */
    public static Animator m104a(Context context, int i) {
        return Build.VERSION.SDK_INT >= 24 ? AnimatorInflater.loadAnimator(context, i) : m105a(context, context.getResources(), context.getTheme(), i);
    }

    /* JADX INFO: renamed from: a */
    public static Animator m105a(Context context, Resources resources, Resources.Theme theme, int i) {
        return m106a(context, resources, theme, i, 1.0f);
    }

    /* JADX INFO: renamed from: a */
    public static Animator m106a(Context context, Resources resources, Resources.Theme theme, int i, float f) throws Throwable {
        XmlResourceParser animation;
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                animation = resources.getAnimation(i);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (XmlPullParserException e2) {
            e = e2;
        }
        try {
            Animator animatorM107a = m107a(context, resources, theme, animation, f);
            if (animation != null) {
                animation.close();
            }
            return animatorM107a;
        } catch (IOException e3) {
            e = e3;
            Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException.initCause(e);
            throw notFoundException;
        } catch (XmlPullParserException e4) {
            e = e4;
            Resources.NotFoundException notFoundException2 = new Resources.NotFoundException("Can't load animation resource ID #0x" + Integer.toHexString(i));
            notFoundException2.initCause(e);
            throw notFoundException2;
        } catch (Throwable th2) {
            th = th2;
            xmlResourceParser = animation;
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private static Animator m107a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f) {
        return m108a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser), null, 0, f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e1, code lost:
    
        if (r23 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e3, code lost:
    
        if (r13 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e5, code lost:
    
        r1 = new android.animation.Animator[r13.size()];
        r2 = r13.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f3, code lost:
    
        if (r2.hasNext() == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00f5, code lost:
    
        r1[r14] = (android.animation.Animator) r2.next();
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0101, code lost:
    
        if (r24 != 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0103, code lost:
    
        r23.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0107, code lost:
    
        r23.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x010a, code lost:
    
        return r0;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Animator m108a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet, AnimatorSet animatorSet, int i, float f) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        Animator animatorM114a = null;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            int i2 = 0;
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                break;
            }
            if (next == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("objectAnimator")) {
                    animatorM114a = m111a(context, resources, theme, attributeSet, f, xmlPullParser);
                } else if (name.equals("animator")) {
                    animatorM114a = m114a(context, resources, theme, attributeSet, null, f, xmlPullParser);
                } else {
                    if (name.equals("set")) {
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        TypedArray typedArrayM195a = C0036c.m195a(resources, theme, attributeSet, C0024a.f77h);
                        m108a(context, resources, theme, xmlPullParser, attributeSet, animatorSet2, C0036c.m194a(typedArrayM195a, xmlPullParser, "ordering", 0, 0), f);
                        typedArrayM195a.recycle();
                        animatorM114a = animatorSet2;
                    } else {
                        if (!name.equals("propertyValuesHolder")) {
                            throw new RuntimeException("Unknown animator name: " + xmlPullParser.getName());
                        }
                        PropertyValuesHolder[] propertyValuesHolderArrM120a = m120a(context, resources, theme, xmlPullParser, Xml.asAttributeSet(xmlPullParser));
                        if (propertyValuesHolderArrM120a != null && animatorM114a != null && (animatorM114a instanceof ValueAnimator)) {
                            ((ValueAnimator) animatorM114a).setValues(propertyValuesHolderArrM120a);
                        }
                        i2 = 1;
                    }
                    if (animatorSet == null && i2 == 0) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(animatorM114a);
                    }
                }
                if (animatorSet == null) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static Keyframe m109a(Keyframe keyframe, float f) {
        return keyframe.getType() == Float.TYPE ? Keyframe.ofFloat(f) : keyframe.getType() == Integer.TYPE ? Keyframe.ofInt(f) : Keyframe.ofObject(f);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Keyframe m110a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, int i, XmlPullParser xmlPullParser) {
        Keyframe keyframeOfFloat;
        TypedArray typedArrayM195a = C0036c.m195a(resources, theme, attributeSet, C0024a.f79j);
        float fM193a = C0036c.m193a(typedArrayM195a, xmlPullParser, "fraction", 3, -1.0f);
        TypedValue typedValueM200b = C0036c.m200b(typedArrayM195a, xmlPullParser, "value", 0);
        boolean z = typedValueM200b != null;
        if (i == 4) {
            i = (z && m119a(typedValueM200b.type)) ? 3 : 0;
        }
        if (!z) {
            keyframeOfFloat = i == 0 ? Keyframe.ofFloat(fM193a) : Keyframe.ofInt(fM193a);
        } else if (i != 3) {
            switch (i) {
                case 0:
                    keyframeOfFloat = Keyframe.ofFloat(fM193a, C0036c.m193a(typedArrayM195a, xmlPullParser, "value", 0, 0.0f));
                    break;
                case 1:
                    keyframeOfFloat = Keyframe.ofInt(fM193a, C0036c.m194a(typedArrayM195a, xmlPullParser, "value", 0, 0));
                    break;
                default:
                    keyframeOfFloat = null;
                    break;
            }
        }
        int iM201c = C0036c.m201c(typedArrayM195a, xmlPullParser, "interpolator", 1, 0);
        if (iM201c > 0) {
            keyframeOfFloat.setInterpolator(C0027d.m100a(context, iM201c));
        }
        typedArrayM195a.recycle();
        return keyframeOfFloat;
    }

    /* JADX INFO: renamed from: a */
    private static ObjectAnimator m111a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        m114a(context, resources, theme, attributeSet, objectAnimator, f, xmlPullParser);
        return objectAnimator;
    }

    /* JADX INFO: renamed from: a */
    private static PropertyValuesHolder m112a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, String str, int i) throws XmlPullParserException, IOException {
        int size;
        PropertyValuesHolder propertyValuesHolderOfKeyframe = null;
        int iM102a = i;
        ArrayList arrayList = null;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 3 || next == 1) {
                break;
            }
            if (xmlPullParser.getName().equals("keyframe")) {
                if (iM102a == 4) {
                    iM102a = m102a(resources, theme, Xml.asAttributeSet(xmlPullParser), xmlPullParser);
                }
                Keyframe keyframeM110a = m110a(context, resources, theme, Xml.asAttributeSet(xmlPullParser), iM102a, xmlPullParser);
                if (keyframeM110a != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(keyframeM110a);
                }
                xmlPullParser.next();
            }
        }
        if (arrayList != null && (size = arrayList.size()) > 0) {
            Keyframe keyframe = (Keyframe) arrayList.get(0);
            Keyframe keyframe2 = (Keyframe) arrayList.get(size - 1);
            float fraction = keyframe2.getFraction();
            if (fraction < 1.0f) {
                if (fraction < 0.0f) {
                    keyframe2.setFraction(1.0f);
                } else {
                    arrayList.add(arrayList.size(), m109a(keyframe2, 1.0f));
                    size++;
                }
            }
            float fraction2 = keyframe.getFraction();
            if (fraction2 != 0.0f) {
                if (fraction2 < 0.0f) {
                    keyframe.setFraction(0.0f);
                } else {
                    arrayList.add(0, m109a(keyframe, 0.0f));
                    size++;
                }
            }
            Keyframe[] keyframeArr = new Keyframe[size];
            arrayList.toArray(keyframeArr);
            for (int i2 = 0; i2 < size; i2++) {
                Keyframe keyframe3 = keyframeArr[i2];
                if (keyframe3.getFraction() < 0.0f) {
                    if (i2 == 0) {
                        keyframe3.setFraction(0.0f);
                    } else {
                        int i3 = size - 1;
                        if (i2 == i3) {
                            keyframe3.setFraction(1.0f);
                        } else {
                            int i4 = i2;
                            for (int i5 = i2 + 1; i5 < i3 && keyframeArr[i5].getFraction() < 0.0f; i5++) {
                                i4 = i5;
                            }
                            m118a(keyframeArr, keyframeArr[i4 + 1].getFraction() - keyframeArr[i2 - 1].getFraction(), i2, i4);
                        }
                    }
                }
            }
            propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(str, keyframeArr);
            if (iM102a == 3) {
                propertyValuesHolderOfKeyframe.setEvaluator(C0029f.m122a());
            }
        }
        return propertyValuesHolderOfKeyframe;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private static PropertyValuesHolder m113a(TypedArray typedArray, int i, int i2, int i3, String str) {
        PropertyValuesHolder propertyValuesHolderOfFloat;
        Object[] objArr;
        TypedValue typedValuePeekValue = typedArray.peekValue(i2);
        boolean z = typedValuePeekValue != null;
        int i4 = z ? typedValuePeekValue.type : 0;
        TypedValue typedValuePeekValue2 = typedArray.peekValue(i3);
        boolean z2 = typedValuePeekValue2 != null;
        int i5 = z2 ? typedValuePeekValue2.type : 0;
        if (i == 4) {
            i = ((z && m119a(i4)) || (z2 && m119a(i5))) ? 3 : 0;
        }
        boolean z3 = i == 0;
        PropertyValuesHolder propertyValuesHolderOfInt = null;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (i != 2) {
            C0029f c0029fM122a = i == 3 ? C0029f.m122a() : null;
            if (z3) {
                if (z) {
                    float dimension = i4 == 5 ? typedArray.getDimension(i2, 0.0f) : typedArray.getFloat(i2, 0.0f);
                    if (z2) {
                        propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                    } else {
                        propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, dimension);
                    }
                } else {
                    propertyValuesHolderOfFloat = PropertyValuesHolder.ofFloat(str, i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f));
                }
                propertyValuesHolderOfInt = propertyValuesHolderOfFloat;
            } else if (z) {
                int dimension2 = i4 == 5 ? (int) typedArray.getDimension(i2, 0.0f) : m119a(i4) ? typedArray.getColor(i2, 0) : typedArray.getInt(i2, 0);
                if (z2) {
                    propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, dimension2, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : m119a(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
                } else {
                    propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, dimension2);
                }
            } else if (z2) {
                propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(str, i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : m119a(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0));
            }
            if (propertyValuesHolderOfInt == null || c0029fM122a == null) {
                return propertyValuesHolderOfInt;
            }
            propertyValuesHolderOfInt.setEvaluator(c0029fM122a);
            return propertyValuesHolderOfInt;
        }
        String string = typedArray.getString(i2);
        String string2 = typedArray.getString(i3);
        C0076b.b[] bVarArrM676b = C0076b.m676b(string);
        C0076b.b[] bVarArrM676b2 = C0076b.m676b(string2);
        if (bVarArrM676b == null && bVarArrM676b2 == null) {
            return null;
        }
        if (bVarArrM676b == null) {
            if (bVarArrM676b2 != null) {
                return PropertyValuesHolder.ofObject(str, new a(), bVarArrM676b2);
            }
            return null;
        }
        a aVar = new a();
        if (bVarArrM676b2 == null) {
            objArr = new Object[]{bVarArrM676b};
        } else {
            if (!C0076b.m672a(bVarArrM676b, bVarArrM676b2)) {
                throw new InflateException(" Can't morph from " + string + " to " + string2);
            }
            objArr = new Object[]{bVarArrM676b, bVarArrM676b2};
        }
        return PropertyValuesHolder.ofObject(str, aVar, objArr);
    }

    /* JADX INFO: renamed from: a */
    private static ValueAnimator m114a(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ValueAnimator valueAnimator, float f, XmlPullParser xmlPullParser) {
        TypedArray typedArrayM195a = C0036c.m195a(resources, theme, attributeSet, C0024a.f76g);
        TypedArray typedArrayM195a2 = C0036c.m195a(resources, theme, attributeSet, C0024a.f80k);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        m116a(valueAnimator, typedArrayM195a, typedArrayM195a2, f, xmlPullParser);
        int iM201c = C0036c.m201c(typedArrayM195a, xmlPullParser, "interpolator", 0, 0);
        if (iM201c > 0) {
            valueAnimator.setInterpolator(C0027d.m100a(context, iM201c));
        }
        typedArrayM195a.recycle();
        if (typedArrayM195a2 != null) {
            typedArrayM195a2.recycle();
        }
        return valueAnimator;
    }

    /* JADX INFO: renamed from: a */
    private static void m115a(ValueAnimator valueAnimator, TypedArray typedArray, int i, float f, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = (ObjectAnimator) valueAnimator;
        String strM196a = C0036c.m196a(typedArray, xmlPullParser, "pathData", 1);
        if (strM196a == null) {
            objectAnimator.setPropertyName(C0036c.m196a(typedArray, xmlPullParser, "propertyName", 0));
            return;
        }
        String strM196a2 = C0036c.m196a(typedArray, xmlPullParser, "propertyXName", 2);
        String strM196a3 = C0036c.m196a(typedArray, xmlPullParser, "propertyYName", 3);
        if (i != 2) {
        }
        if (strM196a2 != null || strM196a3 != null) {
            m117a(C0076b.m669a(strM196a), objectAnimator, f * 0.5f, strM196a2, strM196a3);
            return;
        }
        throw new InflateException(typedArray.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
    }

    /* JADX INFO: renamed from: a */
    private static void m116a(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f, XmlPullParser xmlPullParser) {
        long jM194a = C0036c.m194a(typedArray, xmlPullParser, "duration", 1, 300);
        long jM194a2 = C0036c.m194a(typedArray, xmlPullParser, "startOffset", 2, 0);
        int iM194a = C0036c.m194a(typedArray, xmlPullParser, "valueType", 7, 4);
        if (C0036c.m198a(xmlPullParser, "valueFrom") && C0036c.m198a(xmlPullParser, "valueTo")) {
            if (iM194a == 4) {
                iM194a = m103a(typedArray, 5, 6);
            }
            PropertyValuesHolder propertyValuesHolderM113a = m113a(typedArray, iM194a, 5, 6, "");
            if (propertyValuesHolderM113a != null) {
                valueAnimator.setValues(propertyValuesHolderM113a);
            }
        }
        valueAnimator.setDuration(jM194a);
        valueAnimator.setStartDelay(jM194a2);
        valueAnimator.setRepeatCount(C0036c.m194a(typedArray, xmlPullParser, "repeatCount", 3, 0));
        valueAnimator.setRepeatMode(C0036c.m194a(typedArray, xmlPullParser, "repeatMode", 4, 1));
        if (typedArray2 != null) {
            m115a(valueAnimator, typedArray2, iM194a, f, xmlPullParser);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m117a(Path path, ObjectAnimator objectAnimator, float f, String str, String str2) {
        char c = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Float.valueOf(0.0f));
        float length = 0.0f;
        do {
            length += pathMeasure.getLength();
            arrayList.add(Float.valueOf(length));
        } while (pathMeasure.nextContour());
        PathMeasure pathMeasure2 = new PathMeasure(path, false);
        int iMin = Math.min(100, ((int) (length / f)) + 1);
        float[] fArr = new float[iMin];
        float[] fArr2 = new float[iMin];
        float[] fArr3 = new float[2];
        float f2 = length / (iMin - 1);
        int i = 0;
        float fFloatValue = 0.0f;
        int i2 = 0;
        while (true) {
            if (i >= iMin) {
                break;
            }
            pathMeasure2.getPosTan(fFloatValue, fArr3, null);
            fArr[i] = fArr3[c];
            fArr2[i] = fArr3[1];
            fFloatValue += f2;
            int i3 = i2 + 1;
            if (i3 < arrayList.size() && fFloatValue > ((Float) arrayList.get(i3)).floatValue()) {
                fFloatValue -= ((Float) arrayList.get(i3)).floatValue();
                pathMeasure2.nextContour();
                i2 = i3;
            }
            i++;
            c = 0;
        }
        PropertyValuesHolder propertyValuesHolderOfFloat = str != null ? PropertyValuesHolder.ofFloat(str, fArr) : null;
        PropertyValuesHolder propertyValuesHolderOfFloat2 = str2 != null ? PropertyValuesHolder.ofFloat(str2, fArr2) : null;
        if (propertyValuesHolderOfFloat == null) {
            objectAnimator.setValues(propertyValuesHolderOfFloat2);
        } else {
            objectAnimator.setValues(propertyValuesHolderOfFloat2 == null ? new PropertyValuesHolder[]{propertyValuesHolderOfFloat} : new PropertyValuesHolder[]{propertyValuesHolderOfFloat, propertyValuesHolderOfFloat2});
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m118a(Keyframe[] keyframeArr, float f, int i, int i2) {
        float f2 = f / ((i2 - i) + 2);
        while (i <= i2) {
            keyframeArr[i].setFraction(keyframeArr[i - 1].getFraction() + f2);
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m119a(int i) {
        return i >= 28 && i <= 31;
    }

    /* JADX INFO: renamed from: a */
    private static PropertyValuesHolder[] m120a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        int i;
        PropertyValuesHolder[] propertyValuesHolderArr = null;
        ArrayList arrayList = null;
        while (true) {
            int eventType = xmlPullParser.getEventType();
            if (eventType == 3 || eventType == 1) {
                break;
            }
            if (eventType == 2 && xmlPullParser.getName().equals("propertyValuesHolder")) {
                TypedArray typedArrayM195a = C0036c.m195a(resources, theme, attributeSet, C0024a.f78i);
                String strM196a = C0036c.m196a(typedArrayM195a, xmlPullParser, "propertyName", 3);
                int iM194a = C0036c.m194a(typedArrayM195a, xmlPullParser, "valueType", 2, 4);
                PropertyValuesHolder propertyValuesHolderM112a = m112a(context, resources, theme, xmlPullParser, strM196a, iM194a);
                if (propertyValuesHolderM112a == null) {
                    propertyValuesHolderM112a = m113a(typedArrayM195a, iM194a, 0, 1, strM196a);
                }
                if (propertyValuesHolderM112a != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(propertyValuesHolderM112a);
                }
                typedArrayM195a.recycle();
            }
            xmlPullParser.next();
        }
        if (arrayList != null) {
            int size = arrayList.size();
            propertyValuesHolderArr = new PropertyValuesHolder[size];
            for (i = 0; i < size; i++) {
                propertyValuesHolderArr[i] = (PropertyValuesHolder) arrayList.get(i);
            }
        }
        return propertyValuesHolderArr;
    }
}
