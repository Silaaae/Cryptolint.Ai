package android.support.v4.p008b;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.p006a.p007a.C0034a;
import android.support.v4.p013e.C0088b;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: renamed from: android.support.v4.b.f */
/* JADX INFO: loaded from: classes.dex */
public class C0080f extends C0078d {

    /* JADX INFO: renamed from: a */
    private static final Class f518a;

    /* JADX INFO: renamed from: b */
    private static final Constructor f519b;

    /* JADX INFO: renamed from: c */
    private static final Method f520c;

    /* JADX INFO: renamed from: d */
    private static final Method f521d;

    /* JADX INFO: renamed from: e */
    private static final Method f522e;

    /* JADX INFO: renamed from: f */
    private static final Method f523f;

    /* JADX INFO: renamed from: g */
    private static final Method f524g;

    static {
        Class<?> cls;
        Method declaredMethod;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class);
            method2 = cls.getMethod("addFontFromBuffer", ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE);
            method3 = cls.getMethod("freeze", new Class[0]);
            method4 = cls.getMethod("abortCreation", new Class[0]);
            declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE);
            declaredMethod.setAccessible(true);
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            cls = null;
            declaredMethod = null;
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
        }
        f519b = constructor;
        f518a = cls;
        f520c = method;
        f521d = method2;
        f522e = method3;
        f523f = method4;
        f524g = declaredMethod;
    }

    /* JADX INFO: renamed from: a */
    private static Typeface m696a(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f518a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f524g.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m697a() {
        if (f520c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return f520c != null;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m698a(Context context, Object obj, String str, int i, int i2, int i3) {
        try {
            return ((Boolean) f520c.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m699a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) f521d.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    private static Object m700b() {
        try {
            return f519b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    private static boolean m701b(Object obj) {
        try {
            return ((Boolean) f522e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m702c(Object obj) {
        try {
            f523f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.support.v4.p008b.C0081g, android.support.v4.p008b.C0077c.a
    /* JADX INFO: renamed from: a */
    public Typeface mo688a(Context context, Resources resources, int i, String str, int i2) {
        if (!m697a()) {
            return super.mo688a(context, resources, i, str, i2);
        }
        Object objM700b = m700b();
        if (!m698a(context, objM700b, str, 0, -1, -1)) {
            m702c(objM700b);
            return null;
        }
        if (m701b(objM700b)) {
            return m696a(objM700b);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[Catch: IOException -> 0x0063, SYNTHETIC, TRY_LEAVE, TryCatch #2 {IOException -> 0x0063, blocks: (B:8:0x0014, B:11:0x0022, B:15:0x0045, B:25:0x0056, B:29:0x005f, B:28:0x005b, B:30:0x0062), top: B:53:0x0014, inners: #0 }] */
    @Override // android.support.v4.p008b.C0078d, android.support.v4.p008b.C0081g, android.support.v4.p008b.C0077c.a
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Typeface mo689a(Context context, CancellationSignal cancellationSignal, C0088b.b[] bVarArr, int i) throws Throwable {
        Throwable th;
        if (bVarArr.length < 1) {
            return null;
        }
        if (m697a()) {
            Map<Uri, ByteBuffer> mapM734a = C0088b.m734a(context, bVarArr, cancellationSignal);
            Object objM700b = m700b();
            boolean z = false;
            for (C0088b.b bVar : bVarArr) {
                ByteBuffer byteBuffer = mapM734a.get(bVar.m745a());
                if (byteBuffer != null) {
                    if (!m699a(objM700b, byteBuffer, bVar.m746b(), bVar.m747c(), bVar.m748d() ? 1 : 0)) {
                        m702c(objM700b);
                        return null;
                    }
                    z = true;
                }
            }
            if (!z) {
                m702c(objM700b);
                return null;
            }
            if (m701b(objM700b)) {
                return Typeface.create(m696a(objM700b), i);
            }
            return null;
        }
        C0088b.b bVarA = m706a(bVarArr, i);
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(bVarA.m745a(), "r", cancellationSignal);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(bVarA.m747c()).setItalic(bVarA.m748d()).build();
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return typefaceBuild;
            } catch (Throwable th2) {
                th = th2;
                th = null;
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // android.support.v4.p008b.C0081g, android.support.v4.p008b.C0077c.a
    /* JADX INFO: renamed from: a */
    public Typeface mo690a(Context context, C0034a.b bVar, Resources resources, int i) {
        if (!m697a()) {
            return super.mo690a(context, bVar, resources, i);
        }
        Object objM700b = m700b();
        for (C0034a.c cVar : bVar.m177a()) {
            if (!m698a(context, objM700b, cVar.m178a(), 0, cVar.m179b(), cVar.m180c() ? 1 : 0)) {
                m702c(objM700b);
                return null;
            }
        }
        if (m701b(objM700b)) {
            return m696a(objM700b);
        }
        return null;
    }
}
