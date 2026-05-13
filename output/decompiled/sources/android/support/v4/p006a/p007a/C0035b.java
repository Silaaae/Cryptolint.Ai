package android.support.v4.p006a.p007a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.p006a.p007a.C0034a;
import android.support.v4.p008b.C0077c;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: android.support.v4.a.a.b */
/* JADX INFO: loaded from: classes.dex */
public final class C0035b {

    /* JADX INFO: renamed from: android.support.v4.a.a.b$a */
    public static abstract class a {
        /* JADX INFO: renamed from: a */
        public abstract void mo189a(int i);

        /* JADX INFO: renamed from: a */
        public final void m190a(final int i, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: android.support.v4.a.a.b.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.this.mo189a(i);
                }
            });
        }

        /* JADX INFO: renamed from: a */
        public abstract void mo191a(Typeface typeface);

        /* JADX INFO: renamed from: a */
        public final void m192a(final Typeface typeface, Handler handler) {
            if (handler == null) {
                handler = new Handler(Looper.getMainLooper());
            }
            handler.post(new Runnable() { // from class: android.support.v4.a.a.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.mo191a(typeface);
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    public static Typeface m185a(Context context, int i, TypedValue typedValue, int i2, a aVar) {
        if (context.isRestricted()) {
            return null;
        }
        return m186a(context, i, typedValue, i2, aVar, null, true);
    }

    /* JADX INFO: renamed from: a */
    private static Typeface m186a(Context context, int i, TypedValue typedValue, int i2, a aVar, Handler handler, boolean z) {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface typefaceM187a = m187a(context, resources, typedValue, i, i2, aVar, handler, z);
        if (typefaceM187a != null || aVar != null) {
            return typefaceM187a;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009a  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Typeface m187a(Context context, Resources resources, TypedValue typedValue, int i, int i2, a aVar, Handler handler, boolean z) {
        String str;
        StringBuilder sb;
        String str2;
        if (typedValue.string == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String string = typedValue.string.toString();
        if (!string.startsWith("res/")) {
            if (aVar != null) {
                aVar.m190a(-3, handler);
            }
            return null;
        }
        Typeface typefaceM686a = C0077c.m686a(resources, i, i2);
        if (typefaceM686a != null) {
            if (aVar != null) {
                aVar.m192a(typefaceM686a, handler);
            }
            return typefaceM686a;
        }
        try {
            if (!string.toLowerCase().endsWith(".xml")) {
                Typeface typefaceM683a = C0077c.m683a(context, resources, i, string, i2);
                if (aVar != null) {
                    if (typefaceM683a != null) {
                        aVar.m192a(typefaceM683a, handler);
                    } else {
                        aVar.m190a(-3, handler);
                    }
                }
                return typefaceM683a;
            }
            C0034a.a aVarM170a = C0034a.m170a(resources.getXml(i), resources);
            if (aVarM170a != null) {
                return C0077c.m685a(context, aVarM170a, resources, i, i2, aVar, handler, z);
            }
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (aVar != null) {
                aVar.m190a(-3, handler);
            }
            return null;
        } catch (IOException e) {
            e = e;
            str = "ResourcesCompat";
            sb = new StringBuilder();
            str2 = "Failed to read xml resource ";
            sb.append(str2);
            sb.append(string);
            Log.e(str, sb.toString(), e);
            if (aVar != null) {
                aVar.m190a(-3, handler);
            }
            return null;
        } catch (XmlPullParserException e2) {
            e = e2;
            str = "ResourcesCompat";
            sb = new StringBuilder();
            str2 = "Failed to parse xml resource ";
            sb.append(str2);
            sb.append(string);
            Log.e(str, sb.toString(), e);
            if (aVar != null) {
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Drawable m188a(Resources resources, int i, Resources.Theme theme) {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i, theme) : resources.getDrawable(i);
    }
}
