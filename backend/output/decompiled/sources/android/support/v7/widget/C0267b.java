package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: android.support.v7.widget.b */
/* JADX INFO: loaded from: classes.dex */
class C0267b extends Drawable {

    /* JADX INFO: renamed from: a */
    final ActionBarContainer f1837a;

    public C0267b(ActionBarContainer actionBarContainer) {
        this.f1837a = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        if (!this.f1837a.f1390d) {
            if (this.f1837a.f1387a != null) {
                this.f1837a.f1387a.draw(canvas);
            }
            if (this.f1837a.f1388b == null || !this.f1837a.f1391e) {
                return;
            } else {
                drawable = this.f1837a.f1388b;
            }
        } else if (this.f1837a.f1389c == null) {
            return;
        } else {
            drawable = this.f1837a.f1389c;
        }
        drawable.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
