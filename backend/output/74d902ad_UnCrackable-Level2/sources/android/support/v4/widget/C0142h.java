package android.support.v4.widget;

import android.widget.ListView;

/* JADX INFO: renamed from: android.support.v4.widget.h */
/* JADX INFO: loaded from: classes.dex */
public class C0142h extends AbstractViewOnTouchListenerC0135a {

    /* JADX INFO: renamed from: f */
    private final ListView f769f;

    public C0142h(ListView listView) {
        super(listView);
        this.f769f = listView;
    }

    @Override // android.support.v4.widget.AbstractViewOnTouchListenerC0135a
    /* JADX INFO: renamed from: a */
    public void mo1083a(int i, int i2) {
        C0143i.m1134a(this.f769f, i2);
    }

    @Override // android.support.v4.widget.AbstractViewOnTouchListenerC0135a
    /* JADX INFO: renamed from: e */
    public boolean mo1093e(int i) {
        return false;
    }

    @Override // android.support.v4.widget.AbstractViewOnTouchListenerC0135a
    /* JADX INFO: renamed from: f */
    public boolean mo1094f(int i) {
        ListView listView = this.f769f;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (i >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
