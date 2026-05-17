package android.arch.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: android.arch.lifecycle.h */
/* JADX INFO: loaded from: classes.dex */
public class C0014h {

    /* JADX INFO: renamed from: a */
    private static Map<Class, Integer> f65a = new HashMap();

    /* JADX INFO: renamed from: b */
    private static Map<Class, List<Constructor<? extends InterfaceC0008b>>> f66b = new HashMap();

    /* JADX INFO: renamed from: a */
    static GenericLifecycleObserver m75a(Object obj) {
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class<?> cls = obj.getClass();
        if (m79b(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List<Constructor<? extends InterfaceC0008b>> list = f66b.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(m76a(list.get(0), obj));
        }
        InterfaceC0008b[] interfaceC0008bArr = new InterfaceC0008b[list.size()];
        for (int i = 0; i < list.size(); i++) {
            interfaceC0008bArr[i] = m76a(list.get(i), obj);
        }
        return new CompositeGeneratedAdaptersObserver(interfaceC0008bArr);
    }

    /* JADX INFO: renamed from: a */
    private static InterfaceC0008b m76a(Constructor<? extends InterfaceC0008b> constructor, Object obj) {
        try {
            return constructor.newInstance(obj);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m77a(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }

    /* JADX INFO: renamed from: a */
    private static Constructor<? extends InterfaceC0008b> m78a(Class<?> cls) {
        try {
            Package r0 = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = r0 != null ? r0.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String strM77a = m77a(canonicalName);
            if (!name.isEmpty()) {
                strM77a = name + "." + strM77a;
            }
            Constructor declaredConstructor = Class.forName(strM77a).getDeclaredConstructor(cls);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: renamed from: b */
    private static int m79b(Class<?> cls) {
        if (f65a.containsKey(cls)) {
            return f65a.get(cls).intValue();
        }
        int iM80c = m80c(cls);
        f65a.put(cls, Integer.valueOf(iM80c));
        return iM80c;
    }

    /* JADX INFO: renamed from: c */
    private static int m80c(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends InterfaceC0008b> constructorM78a = m78a(cls);
        if (constructorM78a != null) {
            f66b.put(cls, Collections.singletonList(constructorM78a));
            return 2;
        }
        if (C0007a.f41a.m48a(cls)) {
            return 1;
        }
        Class<? super Object> superclass = cls.getSuperclass();
        ArrayList arrayList = null;
        if (m81d(superclass)) {
            if (m79b(superclass) == 1) {
                return 1;
            }
            arrayList = new ArrayList(f66b.get(superclass));
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (m81d(cls2)) {
                if (m79b(cls2) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.addAll(f66b.get(cls2));
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f66b.put(cls, arrayList);
        return 2;
    }

    /* JADX INFO: renamed from: d */
    private static boolean m81d(Class<?> cls) {
        return cls != null && InterfaceC0010d.class.isAssignableFrom(cls);
    }
}
