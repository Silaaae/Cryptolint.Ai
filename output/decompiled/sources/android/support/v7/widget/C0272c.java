package android.support.v7.widget;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: android.support.v7.widget.c */
/* JADX INFO: loaded from: classes.dex */
class C0272c extends C0267b {
    public C0272c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable;
        if (this.f1837a.f1390d) {
            if (this.f1837a.f1389c == null) {
                return;
            } else {
                drawable = this.f1837a.f1389c;
            }
        } else if (this.f1837a.f1387a == null) {
            return;
        } else {
            drawable = this.f1837a.f1387a;
        }
        drawable.getOutline(outline);
    }
}
