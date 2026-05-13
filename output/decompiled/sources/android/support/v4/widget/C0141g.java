package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;

/* JADX INFO: renamed from: android.support.v4.widget.g */
/* JADX INFO: loaded from: classes.dex */
public class C0141g {

    /* JADX INFO: renamed from: a */
    static final b f768a;

    /* JADX INFO: renamed from: android.support.v4.widget.g$a */
    static class a implements b {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.widget.C0141g.b
        /* JADX INFO: renamed from: a */
        public ColorStateList mo1130a(ImageView imageView) {
            if (imageView instanceof InterfaceC0147m) {
                return ((InterfaceC0147m) imageView).getSupportImageTintList();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.widget.C0141g.b
        /* JADX INFO: renamed from: a */
        public void mo1131a(ImageView imageView, ColorStateList colorStateList) {
            if (imageView instanceof InterfaceC0147m) {
                ((InterfaceC0147m) imageView).setSupportImageTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.widget.C0141g.b
        /* JADX INFO: renamed from: a */
        public void mo1132a(ImageView imageView, PorterDuff.Mode mode) {
            if (imageView instanceof InterfaceC0147m) {
                ((InterfaceC0147m) imageView).setSupportImageTintMode(mode);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v4.widget.C0141g.b
        /* JADX INFO: renamed from: b */
        public PorterDuff.Mode mo1133b(ImageView imageView) {
            if (imageView instanceof InterfaceC0147m) {
                return ((InterfaceC0147m) imageView).getSupportImageTintMode();
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: android.support.v4.widget.g$b */
    interface b {
        /* JADX INFO: renamed from: a */
        ColorStateList mo1130a(ImageView imageView);

        /* JADX INFO: renamed from: a */
        void mo1131a(ImageView imageView, ColorStateList colorStateList);

        /* JADX INFO: renamed from: a */
        void mo1132a(ImageView imageView, PorterDuff.Mode mode);

        /* JADX INFO: renamed from: b */
        PorterDuff.Mode mo1133b(ImageView imageView);
    }

    /* JADX INFO: renamed from: android.support.v4.widget.g$c */
    static class c extends a {
        c() {
        }

        @Override // android.support.v4.widget.C0141g.a, android.support.v4.widget.C0141g.b
        /* JADX INFO: renamed from: a */
        public ColorStateList mo1130a(ImageView imageView) {
            return imageView.getImageTintList();
        }

        @Override // android.support.v4.widget.C0141g.a, android.support.v4.widget.C0141g.b
        /* JADX INFO: renamed from: a */
        public void mo1131a(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (drawable == null || !z) {
                    return;
                }
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        }

        @Override // android.support.v4.widget.C0141g.a, android.support.v4.widget.C0141g.b
        /* JADX INFO: renamed from: a */
        public void mo1132a(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable drawable = imageView.getDrawable();
                boolean z = (imageView.getImageTintList() == null || imageView.getImageTintMode() == null) ? false : true;
                if (drawable == null || !z) {
                    return;
                }
                if (drawable.isStateful()) {
                    drawable.setState(imageView.getDrawableState());
                }
                imageView.setImageDrawable(drawable);
            }
        }

        @Override // android.support.v4.widget.C0141g.a, android.support.v4.widget.C0141g.b
        /* JADX INFO: renamed from: b */
        public PorterDuff.Mode mo1133b(ImageView imageView) {
            return imageView.getImageTintMode();
        }
    }

    static {
        f768a = Build.VERSION.SDK_INT >= 21 ? new c() : new a();
    }

    /* JADX INFO: renamed from: a */
    public static ColorStateList m1126a(ImageView imageView) {
        return f768a.mo1130a(imageView);
    }

    /* JADX INFO: renamed from: a */
    public static void m1127a(ImageView imageView, ColorStateList colorStateList) {
        f768a.mo1131a(imageView, colorStateList);
    }

    /* JADX INFO: renamed from: a */
    public static void m1128a(ImageView imageView, PorterDuff.Mode mode) {
        f768a.mo1132a(imageView, mode);
    }

    /* JADX INFO: renamed from: b */
    public static PorterDuff.Mode m1129b(ImageView imageView) {
        return f768a.mo1133b(imageView);
    }
}
