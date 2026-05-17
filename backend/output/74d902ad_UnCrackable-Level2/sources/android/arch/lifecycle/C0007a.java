package android.arch.lifecycle;

import android.arch.lifecycle.AbstractC0009c;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: android.arch.lifecycle.a */
/* JADX INFO: loaded from: classes.dex */
class C0007a {

    /* JADX INFO: renamed from: a */
    static C0007a f41a = new C0007a();

    /* JADX INFO: renamed from: b */
    private final Map<Class, a> f42b = new HashMap();

    /* JADX INFO: renamed from: c */
    private final Map<Class, Boolean> f43c = new HashMap();

    /* JADX INFO: renamed from: android.arch.lifecycle.a$a */
    static class a {

        /* JADX INFO: renamed from: a */
        final Map<AbstractC0009c.a, List<b>> f44a = new HashMap();

        /* JADX INFO: renamed from: b */
        final Map<b, AbstractC0009c.a> f45b;

        a(Map<b, AbstractC0009c.a> map) {
            this.f45b = map;
            for (Map.Entry<b, AbstractC0009c.a> entry : map.entrySet()) {
                AbstractC0009c.a value = entry.getValue();
                List<b> arrayList = this.f44a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f44a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        /* JADX INFO: renamed from: a */
        private static void m50a(List<b> list, InterfaceC0011e interfaceC0011e, AbstractC0009c.a aVar, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).m52a(interfaceC0011e, aVar, obj);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m51a(InterfaceC0011e interfaceC0011e, AbstractC0009c.a aVar, Object obj) {
            m50a(this.f44a.get(aVar), interfaceC0011e, aVar, obj);
            m50a(this.f44a.get(AbstractC0009c.a.ON_ANY), interfaceC0011e, aVar, obj);
        }
    }

    /* JADX INFO: renamed from: android.arch.lifecycle.a$b */
    static class b {

        /* JADX INFO: renamed from: a */
        final int f46a;

        /* JADX INFO: renamed from: b */
        final Method f47b;

        b(int i, Method method) {
            this.f46a = i;
            this.f47b = method;
            this.f47b.setAccessible(true);
        }

        /* JADX INFO: renamed from: a */
        void m52a(InterfaceC0011e interfaceC0011e, AbstractC0009c.a aVar, Object obj) {
            try {
                switch (this.f46a) {
                    case 0:
                        this.f47b.invoke(obj, new Object[0]);
                        return;
                    case 1:
                        this.f47b.invoke(obj, interfaceC0011e);
                        return;
                    case 2:
                        this.f47b.invoke(obj, interfaceC0011e, aVar);
                        return;
                    default:
                        return;
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f46a == bVar.f46a && this.f47b.getName().equals(bVar.f47b.getName());
        }

        public int hashCode() {
            return (this.f46a * 31) + this.f47b.getName().hashCode();
        }
    }

    C0007a() {
    }

    /* JADX INFO: renamed from: a */
    private a m45a(Class cls, Method[] methodArr) {
        int i;
        a aVarM49b;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarM49b = m49b(superclass)) != null) {
            map.putAll(aVarM49b.f45b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<b, AbstractC0009c.a> entry : m49b(cls2).f45b.entrySet()) {
                m46a(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m47c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            InterfaceC0018l interfaceC0018l = (InterfaceC0018l) method.getAnnotation(InterfaceC0018l.class);
            if (interfaceC0018l != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(InterfaceC0011e.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                AbstractC0009c.a aVarM83a = interfaceC0018l.m83a();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(AbstractC0009c.a.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (aVarM83a != AbstractC0009c.a.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                m46a(map, new b(i, method), aVarM83a, cls);
                z = true;
            }
        }
        a aVar = new a(map);
        this.f42b.put(cls, aVar);
        this.f43c.put(cls, Boolean.valueOf(z));
        return aVar;
    }

    /* JADX INFO: renamed from: a */
    private void m46a(Map<b, AbstractC0009c.a> map, b bVar, AbstractC0009c.a aVar, Class cls) {
        AbstractC0009c.a aVar2 = map.get(bVar);
        if (aVar2 == null || aVar == aVar2) {
            if (aVar2 == null) {
                map.put(bVar, aVar);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f47b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + aVar2 + ", new value " + aVar);
    }

    /* JADX INFO: renamed from: c */
    private Method[] m47c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m48a(Class cls) {
        if (this.f43c.containsKey(cls)) {
            return this.f43c.get(cls).booleanValue();
        }
        Method[] methodArrM47c = m47c(cls);
        for (Method method : methodArrM47c) {
            if (((InterfaceC0018l) method.getAnnotation(InterfaceC0018l.class)) != null) {
                m45a(cls, methodArrM47c);
                return true;
            }
        }
        this.f43c.put(cls, false);
        return false;
    }

    /* JADX INFO: renamed from: b */
    a m49b(Class cls) {
        a aVar = this.f42b.get(cls);
        return aVar != null ? aVar : m45a(cls, null);
    }
}
