package android.support.v7.p019b.p020a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.p008b.C0069a;
import android.support.v7.p018a.C0148a;
import android.util.AttributeSet;
import android.util.StateSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: android.support.v7.b.a.a */
/* JADX INFO: loaded from: classes.dex */
final class C0174a {
    /* JADX INFO: renamed from: a */
    private static int m1388a(int i, float f) {
        return C0069a.m642b(i, Math.round(Color.alpha(i) * f));
    }

    /* JADX INFO: renamed from: a */
    public static ColorStateList m1389a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return m1390a(resources, xmlPullParser, attributeSetAsAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX INFO: renamed from: a */
    private static ColorStateList m1390a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return m1392b(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    /* JADX INFO: renamed from: a */
    private static TypedArray m1391a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ColorStateList m1392b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int i;
        int attributeCount;
        int i2;
        int i3 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArrM1401a = new int[iArr.length];
        int i4 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i3 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayM1391a = m1391a(resources, theme, attributeSet, C0148a.j.ColorStateListItem);
                int color = typedArrayM1391a.getColor(C0148a.j.ColorStateListItem_android_color, -65281);
                float f = 1.0f;
                if (typedArrayM1391a.hasValue(C0148a.j.ColorStateListItem_android_alpha)) {
                    i = C0148a.j.ColorStateListItem_android_alpha;
                } else {
                    if (typedArrayM1391a.hasValue(C0148a.j.ColorStateListItem_alpha)) {
                        i = C0148a.j.ColorStateListItem_alpha;
                    }
                    typedArrayM1391a.recycle();
                    attributeCount = attributeSet.getAttributeCount();
                    int[] iArr2 = new int[attributeCount];
                    int i5 = 0;
                    for (i2 = 0; i2 < attributeCount; i2++) {
                        int attributeNameResource = attributeSet.getAttributeNameResource(i2);
                        if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != C0148a.a.alpha) {
                            int i6 = i5 + 1;
                            if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                                attributeNameResource = -attributeNameResource;
                            }
                            iArr2[i5] = attributeNameResource;
                            i5 = i6;
                        }
                    }
                    int[] iArrTrimStateSet = StateSet.trimStateSet(iArr2, i5);
                    int iM1388a = m1388a(color, f);
                    if (i4 != 0) {
                        int length = iArrTrimStateSet.length;
                    }
                    iArrM1401a = C0176c.m1401a(iArrM1401a, i4, iM1388a);
                    iArr = (int[][]) C0176c.m1402a(iArr, i4, iArrTrimStateSet);
                    i4++;
                }
                f = typedArrayM1391a.getFloat(i, 1.0f);
                typedArrayM1391a.recycle();
                attributeCount = attributeSet.getAttributeCount();
                int[] iArr22 = new int[attributeCount];
                int i52 = 0;
                while (i2 < attributeCount) {
                }
                int[] iArrTrimStateSet2 = StateSet.trimStateSet(iArr22, i52);
                int iM1388a2 = m1388a(color, f);
                if (i4 != 0) {
                }
                iArrM1401a = C0176c.m1401a(iArrM1401a, i4, iM1388a2);
                iArr = (int[][]) C0176c.m1402a(iArr, i4, iArrTrimStateSet2);
                i4++;
            }
            i3 = 1;
        }
        int[] iArr3 = new int[i4];
        int[][] iArr4 = new int[i4][];
        System.arraycopy(iArrM1401a, 0, iArr3, 0, i4);
        System.arraycopy(iArr, 0, iArr4, 0, i4);
        return new ColorStateList(iArr4, iArr3);
    }
}
