package android.support.v4.p008b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.p006a.p007a.C0034a;
import android.support.v4.p013e.C0088b;
import android.support.v4.p014f.C0100k;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: renamed from: android.support.v4.b.e */
/* JADX INFO: loaded from: classes.dex */
class C0079e extends C0081g {

    /* JADX INFO: renamed from: a */
    private static final Class f514a;

    /* JADX INFO: renamed from: b */
    private static final Constructor f515b;

    /* JADX INFO: renamed from: c */
    private static final Method f516c;

    /* JADX INFO: renamed from: d */
    private static final Method f517d;

    static {
        Class<?> cls;
        Method method;
        Method method2;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi24Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            method2 = null;
        }
        f515b = constructor;
        f514a = cls;
        f516c = method2;
        f517d = method;
    }

    C0079e() {
    }

    /* JADX INFO: renamed from: a */
    private static Typeface m692a(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) f514a, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) f517d.invoke(null, objNewInstance);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m693a() {
        if (f516c == null) {
            Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return f516c != null;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m694a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f516c.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    private static Object m695b() {
        try {
            return f515b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // android.support.v4.p008b.C0081g, android.support.v4.p008b.C0077c.a
    /* JADX INFO: renamed from: a */
    public Typeface mo689a(Context context, CancellationSignal cancellationSignal, C0088b.b[] bVarArr, int i) throws Throwable {
        Object objM695b = m695b();
        C0100k c0100k = new C0100k();
        for (C0088b.b bVar : bVarArr) {
            Uri uriM745a = bVar.m745a();
            ByteBuffer byteBufferM711a = (ByteBuffer) c0100k.get(uriM745a);
            if (byteBufferM711a == null) {
                byteBufferM711a = C0082h.m711a(context, cancellationSignal, uriM745a);
                c0100k.put(uriM745a, byteBufferM711a);
            }
            if (!m694a(objM695b, byteBufferM711a, bVar.m746b(), bVar.m747c(), bVar.m748d())) {
                return null;
            }
        }
        return Typeface.create(m692a(objM695b), i);
    }

    @Override // android.support.v4.p008b.C0081g, android.support.v4.p008b.C0077c.a
    /* JADX INFO: renamed from: a */
    public Typeface mo690a(Context context, C0034a.b bVar, Resources resources, int i) {
        Object objM695b = m695b();
        for (C0034a.c cVar : bVar.m177a()) {
            ByteBuffer byteBufferM710a = C0082h.m710a(context, resources, cVar.m181d());
            if (byteBufferM710a == null || !m694a(objM695b, byteBufferM710a, 0, cVar.m179b(), cVar.m180c())) {
                return null;
            }
        }
        return m692a(objM695b);
    }
}
