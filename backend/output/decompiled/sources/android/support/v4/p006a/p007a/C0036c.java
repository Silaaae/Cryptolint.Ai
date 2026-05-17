package android.support.v4.p006a.p007a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: renamed from: android.support.v4.a.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0036c {
    /* JADX INFO: renamed from: a */
    public static float m193a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !m198a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    /* JADX INFO: renamed from: a */
    public static int m194a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m198a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    /* JADX INFO: renamed from: a */
    public static TypedArray m195a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* JADX INFO: renamed from: a */
    public static String m196a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m198a(xmlPullParser, str)) {
            return typedArray.getString(i);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m197a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !m198a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m198a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    /* JADX INFO: renamed from: b */
    public static int m199b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m198a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    /* JADX INFO: renamed from: b */
    public static TypedValue m200b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (m198a(xmlPullParser, str)) {
            return typedArray.peekValue(i);
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public static int m201c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m198a(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
    }
}
