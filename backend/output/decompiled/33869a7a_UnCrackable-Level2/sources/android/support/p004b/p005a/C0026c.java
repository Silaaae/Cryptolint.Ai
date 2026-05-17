package android.support.p004b.p005a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.p006a.p007a.C0036c;
import android.support.v4.p008b.p009a.C0070a;
import android.support.v4.p014f.C0090a;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: renamed from: android.support.b.a.c */
/* JADX INFO: loaded from: classes.dex */
public class C0026c extends AbstractC0031h implements InterfaceC0025b {

    /* JADX INFO: renamed from: a */
    final Drawable.Callback f82a;

    /* JADX INFO: renamed from: c */
    private a f83c;

    /* JADX INFO: renamed from: d */
    private Context f84d;

    /* JADX INFO: renamed from: e */
    private ArgbEvaluator f85e;

    /* JADX INFO: renamed from: f */
    private Animator.AnimatorListener f86f;

    /* JADX INFO: renamed from: g */
    private ArrayList<Object> f87g;

    /* JADX INFO: renamed from: android.support.b.a.c$a */
    private static class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        int f89a;

        /* JADX INFO: renamed from: b */
        C0032i f90b;

        /* JADX INFO: renamed from: c */
        AnimatorSet f91c;

        /* JADX INFO: renamed from: d */
        C0090a<Animator, String> f92d;

        /* JADX INFO: renamed from: e */
        private ArrayList<Animator> f93e;

        public a(Context context, a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f89a = aVar.f89a;
                if (aVar.f90b != null) {
                    Drawable.ConstantState constantState = aVar.f90b.getConstantState();
                    this.f90b = (C0032i) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    this.f90b = (C0032i) this.f90b.mutate();
                    this.f90b.setCallback(callback);
                    this.f90b.setBounds(aVar.f90b.getBounds());
                    this.f90b.m136a(false);
                }
                if (aVar.f93e != null) {
                    int size = aVar.f93e.size();
                    this.f93e = new ArrayList<>(size);
                    this.f92d = new C0090a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.f93e.get(i);
                        Animator animatorClone = animator.clone();
                        String str = aVar.f92d.get(animator);
                        animatorClone.setTarget(this.f90b.m135a(str));
                        this.f93e.add(animatorClone);
                        this.f92d.put(animatorClone, str);
                    }
                    m99a();
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public void m99a() {
            if (this.f91c == null) {
                this.f91c = new AnimatorSet();
            }
            this.f91c.playTogether(this.f93e);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f89a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* JADX INFO: renamed from: android.support.b.a.c$b */
    private static class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        private final Drawable.ConstantState f94a;

        public b(Drawable.ConstantState constantState) {
            this.f94a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f94a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f94a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            C0026c c0026c = new C0026c();
            c0026c.f99b = this.f94a.newDrawable();
            c0026c.f99b.setCallback(c0026c.f82a);
            return c0026c;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            C0026c c0026c = new C0026c();
            c0026c.f99b = this.f94a.newDrawable(resources);
            c0026c.f99b.setCallback(c0026c.f82a);
            return c0026c;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C0026c c0026c = new C0026c();
            c0026c.f99b = this.f94a.newDrawable(resources, theme);
            c0026c.f99b.setCallback(c0026c.f82a);
            return c0026c;
        }
    }

    C0026c() {
        this(null, null, null);
    }

    private C0026c(Context context) {
        this(context, null, null);
    }

    private C0026c(Context context, a aVar, Resources resources) {
        this.f85e = null;
        this.f86f = null;
        this.f87g = null;
        this.f82a = new Drawable.Callback() { // from class: android.support.b.a.c.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                C0026c.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                C0026c.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                C0026c.this.unscheduleSelf(runnable);
            }
        };
        this.f84d = context;
        if (aVar != null) {
            this.f83c = aVar;
        } else {
            this.f83c = new a(context, aVar, this.f82a, resources);
        }
    }

    /* JADX INFO: renamed from: a */
    public static C0026c m94a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C0026c c0026c = new C0026c(context);
        c0026c.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0026c;
    }

    /* JADX INFO: renamed from: a */
    private void m95a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                m95a(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f85e == null) {
                    this.f85e = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f85e);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m96a(String str, Animator animator) {
        animator.setTarget(this.f83c.f90b.m135a(str));
        if (Build.VERSION.SDK_INT < 21) {
            m95a(animator);
        }
        if (this.f83c.f93e == null) {
            this.f83c.f93e = new ArrayList();
            this.f83c.f92d = new C0090a<>();
        }
        this.f83c.f93e.add(animator);
        this.f83c.f92d.put(animator, str);
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        if (this.f99b != null) {
            C0070a.m649a(this.f99b, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f99b != null) {
            return C0070a.m656d(this.f99b);
        }
        return false;
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f99b != null) {
            this.f99b.draw(canvas);
            return;
        }
        this.f83c.f90b.draw(canvas);
        if (this.f83c.f91c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f99b != null ? C0070a.m655c(this.f99b) : this.f83c.f90b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return this.f99b != null ? this.f99b.getChangingConfigurations() : super.getChangingConfigurations() | this.f83c.f89a;
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f99b == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new b(this.f99b.getConstantState());
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f99b != null ? this.f99b.getIntrinsicHeight() : this.f83c.f90b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f99b != null ? this.f99b.getIntrinsicWidth() : this.f83c.f90b.getIntrinsicWidth();
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f99b != null ? this.f99b.getOpacity() : this.f83c.f90b.getOpacity();
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes;
        if (this.f99b != null) {
            C0070a.m650a(this.f99b, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    typedArrayObtainAttributes = C0036c.m195a(resources, theme, attributeSet, C0024a.f74e);
                    int resourceId = typedArrayObtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C0032i c0032iM129a = C0032i.m129a(resources, resourceId, theme);
                        c0032iM129a.m136a(false);
                        c0032iM129a.setCallback(this.f82a);
                        if (this.f83c.f90b != null) {
                            this.f83c.f90b.setCallback(null);
                        }
                        this.f83c.f90b = c0032iM129a;
                    }
                } else if ("target".equals(name)) {
                    typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, C0024a.f75f);
                    String string = typedArrayObtainAttributes.getString(0);
                    int resourceId2 = typedArrayObtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f84d == null) {
                            typedArrayObtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                        m96a(string, C0028e.m104a(this.f84d, resourceId2));
                    }
                } else {
                    continue;
                }
                typedArrayObtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.f83c.m99a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f99b != null ? C0070a.m653b(this.f99b) : this.f83c.f90b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f99b != null ? ((AnimatedVectorDrawable) this.f99b).isRunning() : this.f83c.f91c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f99b != null ? this.f99b.isStateful() : this.f83c.f90b.isStateful();
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f99b != null) {
            this.f99b.mutate();
        }
        return this;
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f99b != null) {
            this.f99b.setBounds(rect);
        } else {
            this.f83c.f90b.setBounds(rect);
        }
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        return this.f99b != null ? this.f99b.setLevel(i) : this.f83c.f90b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return this.f99b != null ? this.f99b.setState(iArr) : this.f83c.f90b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f99b != null) {
            this.f99b.setAlpha(i);
        } else {
            this.f83c.f90b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f99b != null) {
            C0070a.m652a(this.f99b, z);
        } else {
            this.f83c.f90b.setAutoMirrored(z);
        }
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f99b != null) {
            this.f99b.setColorFilter(colorFilter);
        } else {
            this.f83c.f90b.setColorFilter(colorFilter);
        }
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.support.p004b.p005a.AbstractC0031h, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.p008b.p009a.InterfaceC0071b
    public void setTint(int i) {
        if (this.f99b != null) {
            C0070a.m646a(this.f99b, i);
        } else {
            this.f83c.f90b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.p008b.p009a.InterfaceC0071b
    public void setTintList(ColorStateList colorStateList) {
        if (this.f99b != null) {
            C0070a.m648a(this.f99b, colorStateList);
        } else {
            this.f83c.f90b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.p008b.p009a.InterfaceC0071b
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f99b != null) {
            C0070a.m651a(this.f99b, mode);
        } else {
            this.f83c.f90b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.f99b != null) {
            return this.f99b.setVisible(z, z2);
        }
        this.f83c.f90b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f99b != null) {
            ((AnimatedVectorDrawable) this.f99b).start();
        } else {
            if (this.f83c.f91c.isStarted()) {
                return;
            }
            this.f83c.f91c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f99b != null) {
            ((AnimatedVectorDrawable) this.f99b).stop();
        } else {
            this.f83c.f91c.end();
        }
    }
}
