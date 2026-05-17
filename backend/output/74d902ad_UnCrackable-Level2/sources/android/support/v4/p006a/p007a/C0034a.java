package android.support.v4.p006a.p007a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.p003a.C0023a;
import android.support.v4.p013e.C0087a;
import android.util.Base64;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: android.support.v4.a.a.a */
/* JADX INFO: loaded from: classes.dex */
public class C0034a {

    /* JADX INFO: renamed from: android.support.v4.a.a.a$a */
    public interface a {
    }

    /* JADX INFO: renamed from: android.support.v4.a.a.a$b */
    public static final class b implements a {

        /* JADX INFO: renamed from: a */
        private final c[] f170a;

        public b(c[] cVarArr) {
            this.f170a = cVarArr;
        }

        /* JADX INFO: renamed from: a */
        public c[] m177a() {
            return this.f170a;
        }
    }

    /* JADX INFO: renamed from: android.support.v4.a.a.a$c */
    public static final class c {

        /* JADX INFO: renamed from: a */
        private final String f171a;

        /* JADX INFO: renamed from: b */
        private int f172b;

        /* JADX INFO: renamed from: c */
        private boolean f173c;

        /* JADX INFO: renamed from: d */
        private int f174d;

        public c(String str, int i, boolean z, int i2) {
            this.f171a = str;
            this.f172b = i;
            this.f173c = z;
            this.f174d = i2;
        }

        /* JADX INFO: renamed from: a */
        public String m178a() {
            return this.f171a;
        }

        /* JADX INFO: renamed from: b */
        public int m179b() {
            return this.f172b;
        }

        /* JADX INFO: renamed from: c */
        public boolean m180c() {
            return this.f173c;
        }

        /* JADX INFO: renamed from: d */
        public int m181d() {
            return this.f174d;
        }
    }

    /* JADX INFO: renamed from: android.support.v4.a.a.a$d */
    public static final class d implements a {

        /* JADX INFO: renamed from: a */
        private final C0087a f175a;

        /* JADX INFO: renamed from: b */
        private final int f176b;

        /* JADX INFO: renamed from: c */
        private final int f177c;

        public d(C0087a c0087a, int i, int i2) {
            this.f175a = c0087a;
            this.f177c = i;
            this.f176b = i2;
        }

        /* JADX INFO: renamed from: a */
        public C0087a m182a() {
            return this.f175a;
        }

        /* JADX INFO: renamed from: b */
        public int m183b() {
            return this.f177c;
        }

        /* JADX INFO: renamed from: c */
        public int m184c() {
            return this.f176b;
        }
    }

    /* JADX INFO: renamed from: a */
    public static a m170a(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return m174b(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* JADX INFO: renamed from: a */
    public static List<List<byte[]>> m171a(Resources resources, int i) {
        ArrayList arrayList = null;
        if (i != 0) {
            TypedArray typedArrayObtainTypedArray = resources.obtainTypedArray(i);
            if (typedArrayObtainTypedArray.length() > 0) {
                arrayList = new ArrayList();
                if (typedArrayObtainTypedArray.getResourceId(0, 0) != 0) {
                    for (int i2 = 0; i2 < typedArrayObtainTypedArray.length(); i2++) {
                        arrayList.add(m172a(resources.getStringArray(typedArrayObtainTypedArray.getResourceId(i2, 0))));
                    }
                } else {
                    arrayList.add(m172a(resources.getStringArray(i)));
                }
            }
            typedArrayObtainTypedArray.recycle();
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }

    /* JADX INFO: renamed from: a */
    private static List<byte[]> m172a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private static void m173a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static a m174b(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return m175c(xmlPullParser, resources);
        }
        m173a(xmlPullParser);
        return null;
    }

    /* JADX INFO: renamed from: c */
    private static a m175c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0023a.b.FontFamily);
        String string = typedArrayObtainAttributes.getString(C0023a.b.FontFamily_fontProviderAuthority);
        String string2 = typedArrayObtainAttributes.getString(C0023a.b.FontFamily_fontProviderPackage);
        String string3 = typedArrayObtainAttributes.getString(C0023a.b.FontFamily_fontProviderQuery);
        int resourceId = typedArrayObtainAttributes.getResourceId(C0023a.b.FontFamily_fontProviderCerts, 0);
        int integer = typedArrayObtainAttributes.getInteger(C0023a.b.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = typedArrayObtainAttributes.getInteger(C0023a.b.FontFamily_fontProviderFetchTimeout, 500);
        typedArrayObtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                m173a(xmlPullParser);
            }
            return new d(new C0087a(string, string2, string3, m171a(resources, resourceId)), integer, integer2);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(m176d(xmlPullParser, resources));
                } else {
                    m173a(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((c[]) arrayList.toArray(new c[arrayList.size()]));
    }

    /* JADX INFO: renamed from: d */
    private static c m176d(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0023a.b.FontFamilyFont);
        int i = typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(C0023a.b.FontFamilyFont_fontWeight) ? C0023a.b.FontFamilyFont_fontWeight : C0023a.b.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == typedArrayObtainAttributes.getInt(typedArrayObtainAttributes.hasValue(C0023a.b.FontFamilyFont_fontStyle) ? C0023a.b.FontFamilyFont_fontStyle : C0023a.b.FontFamilyFont_android_fontStyle, 0);
        int i2 = typedArrayObtainAttributes.hasValue(C0023a.b.FontFamilyFont_font) ? C0023a.b.FontFamilyFont_font : C0023a.b.FontFamilyFont_android_font;
        int resourceId = typedArrayObtainAttributes.getResourceId(i2, 0);
        String string = typedArrayObtainAttributes.getString(i2);
        typedArrayObtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            m173a(xmlPullParser);
        }
        return new c(string, i, z, resourceId);
    }
}
