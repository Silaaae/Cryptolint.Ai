package android.support.v7.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.p014f.C0090a;
import android.support.v4.p015g.C0124p;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.C0181d;
import android.support.v7.widget.C0242ab;
import android.support.v7.widget.C0260at;
import android.support.v7.widget.C0275f;
import android.support.v7.widget.C0277h;
import android.support.v7.widget.C0278i;
import android.support.v7.widget.C0279j;
import android.support.v7.widget.C0282m;
import android.support.v7.widget.C0284o;
import android.support.v7.widget.C0286q;
import android.support.v7.widget.C0287r;
import android.support.v7.widget.C0290u;
import android.support.v7.widget.C0291v;
import android.support.v7.widget.C0292w;
import android.support.v7.widget.C0294y;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatViewInflater {

    /* JADX INFO: renamed from: a */
    private static final Class<?>[] f893a = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: b */
    private static final int[] f894b = {R.attr.onClick};

    /* JADX INFO: renamed from: c */
    private static final String[] f895c = {"android.widget.", "android.view.", "android.webkit."};

    /* JADX INFO: renamed from: d */
    private static final Map<String, Constructor<? extends View>> f896d = new C0090a();

    /* JADX INFO: renamed from: e */
    private final Object[] f897e = new Object[2];

    /* JADX INFO: renamed from: android.support.v7.app.AppCompatViewInflater$a */
    private static class ViewOnClickListenerC0157a implements View.OnClickListener {

        /* JADX INFO: renamed from: a */
        private final View f898a;

        /* JADX INFO: renamed from: b */
        private final String f899b;

        /* JADX INFO: renamed from: c */
        private Method f900c;

        /* JADX INFO: renamed from: d */
        private Context f901d;

        public ViewOnClickListenerC0157a(View view, String str) {
            this.f898a = view;
            this.f899b = str;
        }

        /* JADX INFO: renamed from: a */
        private void m1190a(Context context, String str) {
            String str2;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f899b, View.class)) != null) {
                        this.f900c = method;
                        this.f901d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f898a.getId();
            if (id == -1) {
                str2 = "";
            } else {
                str2 = " with id '" + this.f898a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f899b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f898a.getClass() + str2);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f900c == null) {
                m1190a(this.f898a.getContext(), this.f899b);
            }
            try {
                this.f900c.invoke(this.f901d, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static Context m1170a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0148a.j.View, 0, 0);
        int resourceId = z ? typedArrayObtainStyledAttributes.getResourceId(C0148a.j.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.View_theme, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        return resourceId != 0 ? ((context instanceof C0181d) && ((C0181d) context).m1420a() == resourceId) ? context : new C0181d(context, resourceId) : context;
    }

    /* JADX INFO: renamed from: a */
    private View m1171a(Context context, String str, String str2) {
        String str3;
        Constructor<? extends View> constructor = f896d.get(str);
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (str2 != null) {
                    str3 = str2 + str;
                } else {
                    str3 = str;
                }
                constructor = classLoader.loadClass(str3).asSubclass(View.class).getConstructor(f893a);
                f896d.put(str, constructor);
            } catch (Exception unused) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f897e);
    }

    /* JADX INFO: renamed from: a */
    private void m1172a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (context instanceof ContextWrapper) {
            if (Build.VERSION.SDK_INT < 15 || C0124p.m972n(view)) {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f894b);
                String string = typedArrayObtainStyledAttributes.getString(0);
                if (string != null) {
                    view.setOnClickListener(new ViewOnClickListenerC0157a(view, string));
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1173a(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    /* JADX INFO: renamed from: b */
    private View m1174b(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f897e[0] = context;
            this.f897e[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return m1171a(context, str, (String) null);
            }
            for (int i = 0; i < f895c.length; i++) {
                View viewM1171a = m1171a(context, str, f895c[i]);
                if (viewM1171a != null) {
                    return viewM1171a;
                }
            }
            return null;
        } catch (Exception unused) {
            return null;
        } finally {
            this.f897e[0] = null;
            this.f897e[1] = null;
        }
    }

    /* JADX INFO: renamed from: a */
    protected C0242ab m1175a(Context context, AttributeSet attributeSet) {
        return new C0242ab(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    protected View m1176a(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    final View m1177a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2;
        View viewM1175a;
        context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = m1170a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = C0260at.m1973a(context2);
        }
        switch (str) {
            case "TextView":
                viewM1175a = m1175a(context2, attributeSet);
                m1173a(viewM1175a, str);
                break;
            case "ImageView":
                viewM1175a = m1178b(context2, attributeSet);
                m1173a(viewM1175a, str);
                break;
            case "Button":
                viewM1175a = m1179c(context2, attributeSet);
                m1173a(viewM1175a, str);
                break;
            case "EditText":
                viewM1175a = m1180d(context2, attributeSet);
                m1173a(viewM1175a, str);
                break;
            case "Spinner":
                viewM1175a = m1181e(context2, attributeSet);
                m1173a(viewM1175a, str);
                break;
            case "ImageButton":
                viewM1175a = m1182f(context2, attributeSet);
                m1173a(viewM1175a, str);
                break;
            case "CheckBox":
                viewM1175a = m1183g(context2, attributeSet);
                m1173a(viewM1175a, str);
                break;
            case "RadioButton":
                viewM1175a = m1184h(context2, attributeSet);
                m1173a(viewM1175a, str);
                break;
            case "CheckedTextView":
                viewM1175a = m1185i(context2, attributeSet);
                m1173a(viewM1175a, str);
                break;
            case "AutoCompleteTextView":
                viewM1175a = m1186j(context2, attributeSet);
                m1173a(viewM1175a, str);
                break;
            case "MultiAutoCompleteTextView":
                viewM1175a = m1187k(context2, attributeSet);
                m1173a(viewM1175a, str);
                break;
            case "RatingBar":
                viewM1175a = m1188l(context2, attributeSet);
                m1173a(viewM1175a, str);
                break;
            case "SeekBar":
                viewM1175a = m1189m(context2, attributeSet);
                m1173a(viewM1175a, str);
                break;
            default:
                viewM1175a = m1176a(context2, str, attributeSet);
                break;
        }
        if (viewM1175a == null && context != context2) {
            viewM1175a = m1174b(context2, str, attributeSet);
        }
        if (viewM1175a != null) {
            m1172a(viewM1175a, attributeSet);
        }
        return viewM1175a;
    }

    /* JADX INFO: renamed from: b */
    protected C0286q m1178b(Context context, AttributeSet attributeSet) {
        return new C0286q(context, attributeSet);
    }

    /* JADX INFO: renamed from: c */
    protected C0277h m1179c(Context context, AttributeSet attributeSet) {
        return new C0277h(context, attributeSet);
    }

    /* JADX INFO: renamed from: d */
    protected C0282m m1180d(Context context, AttributeSet attributeSet) {
        return new C0282m(context, attributeSet);
    }

    /* JADX INFO: renamed from: e */
    protected C0294y m1181e(Context context, AttributeSet attributeSet) {
        return new C0294y(context, attributeSet);
    }

    /* JADX INFO: renamed from: f */
    protected C0284o m1182f(Context context, AttributeSet attributeSet) {
        return new C0284o(context, attributeSet);
    }

    /* JADX INFO: renamed from: g */
    protected C0278i m1183g(Context context, AttributeSet attributeSet) {
        return new C0278i(context, attributeSet);
    }

    /* JADX INFO: renamed from: h */
    protected C0290u m1184h(Context context, AttributeSet attributeSet) {
        return new C0290u(context, attributeSet);
    }

    /* JADX INFO: renamed from: i */
    protected C0279j m1185i(Context context, AttributeSet attributeSet) {
        return new C0279j(context, attributeSet);
    }

    /* JADX INFO: renamed from: j */
    protected C0275f m1186j(Context context, AttributeSet attributeSet) {
        return new C0275f(context, attributeSet);
    }

    /* JADX INFO: renamed from: k */
    protected C0287r m1187k(Context context, AttributeSet attributeSet) {
        return new C0287r(context, attributeSet);
    }

    /* JADX INFO: renamed from: l */
    protected C0291v m1188l(Context context, AttributeSet attributeSet) {
        return new C0291v(context, attributeSet);
    }

    /* JADX INFO: renamed from: m */
    protected C0292w m1189m(Context context, AttributeSet attributeSet) {
        return new C0292w(context, attributeSet);
    }
}
