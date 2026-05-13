package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: renamed from: android.support.v7.widget.e */
/* JADX INFO: loaded from: classes.dex */
class C0274e extends DataSetObservable {

    /* JADX INFO: renamed from: a */
    static final String f1878a = "e";

    /* JADX INFO: renamed from: e */
    private static final Object f1879e = new Object();

    /* JADX INFO: renamed from: f */
    private static final Map<String, C0274e> f1880f = new HashMap();

    /* JADX INFO: renamed from: b */
    final Context f1881b;

    /* JADX INFO: renamed from: c */
    final String f1882c;

    /* JADX INFO: renamed from: d */
    boolean f1883d;

    /* JADX INFO: renamed from: g */
    private final Object f1884g;

    /* JADX INFO: renamed from: h */
    private final List<a> f1885h;

    /* JADX INFO: renamed from: i */
    private final List<c> f1886i;

    /* JADX INFO: renamed from: j */
    private Intent f1887j;

    /* JADX INFO: renamed from: k */
    private b f1888k;

    /* JADX INFO: renamed from: l */
    private int f1889l;

    /* JADX INFO: renamed from: m */
    private boolean f1890m;

    /* JADX INFO: renamed from: n */
    private boolean f1891n;

    /* JADX INFO: renamed from: o */
    private boolean f1892o;

    /* JADX INFO: renamed from: p */
    private d f1893p;

    /* JADX INFO: renamed from: android.support.v7.widget.e$a */
    public static final class a implements Comparable<a> {

        /* JADX INFO: renamed from: a */
        public final ResolveInfo f1894a;

        /* JADX INFO: renamed from: b */
        public float f1895b;

        public a(ResolveInfo resolveInfo) {
            this.f1894a = resolveInfo;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.f1895b) - Float.floatToIntBits(this.f1895b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.f1895b) == Float.floatToIntBits(((a) obj).f1895b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f1895b) + 31;
        }

        public String toString() {
            return "[resolveInfo:" + this.f1894a.toString() + "; weight:" + new BigDecimal(this.f1895b) + "]";
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.e$b */
    public interface b {
        /* JADX INFO: renamed from: a */
        void m2064a(Intent intent, List<a> list, List<c> list2);
    }

    /* JADX INFO: renamed from: android.support.v7.widget.e$c */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final ComponentName f1896a;

        /* JADX INFO: renamed from: b */
        public final long f1897b;

        /* JADX INFO: renamed from: c */
        public final float f1898c;

        public c(ComponentName componentName, long j, float f) {
            this.f1896a = componentName;
            this.f1897b = j;
            this.f1898c = f;
        }

        public c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f1896a == null) {
                if (cVar.f1896a != null) {
                    return false;
                }
            } else if (!this.f1896a.equals(cVar.f1896a)) {
                return false;
            }
            return this.f1897b == cVar.f1897b && Float.floatToIntBits(this.f1898c) == Float.floatToIntBits(cVar.f1898c);
        }

        public int hashCode() {
            return (((((this.f1896a == null ? 0 : this.f1896a.hashCode()) + 31) * 31) + ((int) (this.f1897b ^ (this.f1897b >>> 32)))) * 31) + Float.floatToIntBits(this.f1898c);
        }

        public String toString() {
            return "[; activity:" + this.f1896a + "; time:" + this.f1897b + "; weight:" + new BigDecimal(this.f1898c) + "]";
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.e$d */
    public interface d {
        /* JADX INFO: renamed from: a */
        boolean m2065a(C0274e c0274e, Intent intent);
    }

    /* JADX INFO: renamed from: android.support.v7.widget.e$e */
    private final class e extends AsyncTask<Object, Void, Void> {
        e() {
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Void doInBackground(Object... objArr) {
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                FileOutputStream fileOutputStreamOpenFileOutput = C0274e.this.f1881b.openFileOutput(str, 0);
                XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
                try {
                    try {
                        try {
                            xmlSerializerNewSerializer.setOutput(fileOutputStreamOpenFileOutput, null);
                            xmlSerializerNewSerializer.startDocument("UTF-8", true);
                            xmlSerializerNewSerializer.startTag(null, "historical-records");
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                c cVar = (c) list.remove(0);
                                xmlSerializerNewSerializer.startTag(null, "historical-record");
                                xmlSerializerNewSerializer.attribute(null, "activity", cVar.f1896a.flattenToString());
                                xmlSerializerNewSerializer.attribute(null, "time", String.valueOf(cVar.f1897b));
                                xmlSerializerNewSerializer.attribute(null, "weight", String.valueOf(cVar.f1898c));
                                xmlSerializerNewSerializer.endTag(null, "historical-record");
                            }
                            xmlSerializerNewSerializer.endTag(null, "historical-records");
                            xmlSerializerNewSerializer.endDocument();
                            C0274e.this.f1883d = true;
                        } catch (Throwable th) {
                            C0274e.this.f1883d = true;
                            if (fileOutputStreamOpenFileOutput != null) {
                                try {
                                    fileOutputStreamOpenFileOutput.close();
                                } catch (IOException unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (IllegalStateException e) {
                        Log.e(C0274e.f1878a, "Error writing historical record file: " + C0274e.this.f1882c, e);
                        C0274e.this.f1883d = true;
                        if (fileOutputStreamOpenFileOutput != null) {
                        }
                    }
                } catch (IOException e2) {
                    Log.e(C0274e.f1878a, "Error writing historical record file: " + C0274e.this.f1882c, e2);
                    C0274e.this.f1883d = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                    }
                } catch (IllegalArgumentException e3) {
                    Log.e(C0274e.f1878a, "Error writing historical record file: " + C0274e.this.f1882c, e3);
                    C0274e.this.f1883d = true;
                    if (fileOutputStreamOpenFileOutput != null) {
                    }
                }
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (IOException unused2) {
                    }
                }
                return null;
            } catch (FileNotFoundException e4) {
                Log.e(C0274e.f1878a, "Error writing historical record file: " + str, e4);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m2049a(c cVar) {
        boolean zAdd = this.f1886i.add(cVar);
        if (zAdd) {
            this.f1891n = true;
            m2055h();
            m2050c();
            m2052e();
            notifyChanged();
        }
        return zAdd;
    }

    /* JADX INFO: renamed from: c */
    private void m2050c() {
        if (!this.f1890m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        }
        if (this.f1891n) {
            this.f1891n = false;
            if (TextUtils.isEmpty(this.f1882c)) {
                return;
            }
            new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new ArrayList(this.f1886i), this.f1882c);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m2051d() {
        boolean zM2053f = m2053f() | m2054g();
        m2055h();
        if (zM2053f) {
            m2052e();
            notifyChanged();
        }
    }

    /* JADX INFO: renamed from: e */
    private boolean m2052e() {
        if (this.f1888k == null || this.f1887j == null || this.f1885h.isEmpty() || this.f1886i.isEmpty()) {
            return false;
        }
        this.f1888k.m2064a(this.f1887j, this.f1885h, Collections.unmodifiableList(this.f1886i));
        return true;
    }

    /* JADX INFO: renamed from: f */
    private boolean m2053f() {
        if (!this.f1892o || this.f1887j == null) {
            return false;
        }
        this.f1892o = false;
        this.f1885h.clear();
        List<ResolveInfo> listQueryIntentActivities = this.f1881b.getPackageManager().queryIntentActivities(this.f1887j, 0);
        int size = listQueryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f1885h.add(new a(listQueryIntentActivities.get(i)));
        }
        return true;
    }

    /* JADX INFO: renamed from: g */
    private boolean m2054g() {
        if (!this.f1883d || !this.f1891n || TextUtils.isEmpty(this.f1882c)) {
            return false;
        }
        this.f1883d = false;
        this.f1890m = true;
        m2056i();
        return true;
    }

    /* JADX INFO: renamed from: h */
    private void m2055h() {
        int size = this.f1886i.size() - this.f1889l;
        if (size <= 0) {
            return;
        }
        this.f1891n = true;
        for (int i = 0; i < size; i++) {
            this.f1886i.remove(0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return;
     */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void m2056i() {
        try {
            FileInputStream fileInputStreamOpenFileInput = this.f1881b.openFileInput(this.f1882c);
            try {
                try {
                    try {
                        XmlPullParser xmlPullParserNewPullParser = Xml.newPullParser();
                        xmlPullParserNewPullParser.setInput(fileInputStreamOpenFileInput, "UTF-8");
                        for (int next = 0; next != 1 && next != 2; next = xmlPullParserNewPullParser.next()) {
                        }
                        if (!"historical-records".equals(xmlPullParserNewPullParser.getName())) {
                            throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                        }
                        List<c> list = this.f1886i;
                        list.clear();
                        while (true) {
                            int next2 = xmlPullParserNewPullParser.next();
                            if (next2 == 1) {
                                if (fileInputStreamOpenFileInput == null) {
                                    return;
                                }
                            } else if (next2 != 3 && next2 != 4) {
                                if (!"historical-record".equals(xmlPullParserNewPullParser.getName())) {
                                    throw new XmlPullParserException("Share records file not well-formed.");
                                }
                                list.add(new c(xmlPullParserNewPullParser.getAttributeValue(null, "activity"), Long.parseLong(xmlPullParserNewPullParser.getAttributeValue(null, "time")), Float.parseFloat(xmlPullParserNewPullParser.getAttributeValue(null, "weight"))));
                            }
                        }
                    } catch (Throwable th) {
                        if (fileInputStreamOpenFileInput != null) {
                            try {
                                fileInputStreamOpenFileInput.close();
                            } catch (IOException unused) {
                            }
                        }
                        throw th;
                    }
                } catch (XmlPullParserException e2) {
                    Log.e(f1878a, "Error reading historical recrod file: " + this.f1882c, e2);
                    if (fileInputStreamOpenFileInput == null) {
                    }
                }
            } catch (IOException e3) {
                Log.e(f1878a, "Error reading historical recrod file: " + this.f1882c, e3);
                if (fileInputStreamOpenFileInput == null) {
                }
            }
        } catch (FileNotFoundException unused2) {
        }
    }

    /* JADX INFO: renamed from: a */
    public int m2057a() {
        int size;
        synchronized (this.f1884g) {
            m2051d();
            size = this.f1885h.size();
        }
        return size;
    }

    /* JADX INFO: renamed from: a */
    public int m2058a(ResolveInfo resolveInfo) {
        synchronized (this.f1884g) {
            m2051d();
            List<a> list = this.f1885h;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i).f1894a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: renamed from: a */
    public ResolveInfo m2059a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f1884g) {
            m2051d();
            resolveInfo = this.f1885h.get(i).f1894a;
        }
        return resolveInfo;
    }

    /* JADX INFO: renamed from: b */
    public Intent m2060b(int i) {
        synchronized (this.f1884g) {
            if (this.f1887j == null) {
                return null;
            }
            m2051d();
            a aVar = this.f1885h.get(i);
            ComponentName componentName = new ComponentName(aVar.f1894a.activityInfo.packageName, aVar.f1894a.activityInfo.name);
            Intent intent = new Intent(this.f1887j);
            intent.setComponent(componentName);
            if (this.f1893p != null) {
                if (this.f1893p.m2065a(this, new Intent(intent))) {
                    return null;
                }
            }
            m2049a(new c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    /* JADX INFO: renamed from: b */
    public ResolveInfo m2061b() {
        synchronized (this.f1884g) {
            m2051d();
            if (this.f1885h.isEmpty()) {
                return null;
            }
            return this.f1885h.get(0).f1894a;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m2062c(int i) {
        synchronized (this.f1884g) {
            m2051d();
            a aVar = this.f1885h.get(i);
            a aVar2 = this.f1885h.get(0);
            m2049a(new c(new ComponentName(aVar.f1894a.activityInfo.packageName, aVar.f1894a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.f1895b - aVar.f1895b) + 5.0f : 1.0f));
        }
    }
}
