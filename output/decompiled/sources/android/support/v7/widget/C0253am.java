package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.view.menu.C0195g;
import android.support.v7.view.menu.C0196h;
import android.support.v7.view.menu.C0198j;
import android.support.v7.view.menu.ListMenuItemView;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: android.support.v7.widget.am */
/* JADX INFO: loaded from: classes.dex */
public class C0253am extends C0251ak implements InterfaceC0252al {

    /* JADX INFO: renamed from: a */
    private static Method f1726a;

    /* JADX INFO: renamed from: b */
    private InterfaceC0252al f1727b;

    /* JADX INFO: renamed from: android.support.v7.widget.am$a */
    public static class a extends C0247ag {

        /* JADX INFO: renamed from: a */
        final int f1728a;

        /* JADX INFO: renamed from: b */
        final int f1729b;

        /* JADX INFO: renamed from: c */
        private InterfaceC0252al f1730c;

        /* JADX INFO: renamed from: d */
        private MenuItem f1731d;

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            if (Build.VERSION.SDK_INT < 17 || 1 != configuration.getLayoutDirection()) {
                this.f1728a = 22;
                this.f1729b = 21;
            } else {
                this.f1728a = 21;
                this.f1729b = 22;
            }
        }

        @Override // android.support.v7.widget.C0247ag
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ int mo1867a(int i, int i2, int i3, int i4, int i5) {
            return super.mo1867a(i, i2, i3, i4, i5);
        }

        @Override // android.support.v7.widget.C0247ag
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo1868a(MotionEvent motionEvent, int i) {
            return super.mo1868a(motionEvent, i);
        }

        @Override // android.support.v7.widget.C0247ag, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // android.support.v7.widget.C0247ag, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // android.support.v7.widget.C0247ag, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // android.support.v7.widget.C0247ag, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // android.support.v7.widget.C0247ag, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int headersCount;
            int iPointToPosition;
            int i;
            if (this.f1730c != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    headersCount = headerViewListAdapter.getHeadersCount();
                    adapter = headerViewListAdapter.getWrappedAdapter();
                } else {
                    headersCount = 0;
                }
                C0195g c0195g = (C0195g) adapter;
                C0198j item = null;
                if (motionEvent.getAction() != 10 && (iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i = iPointToPosition - headersCount) >= 0 && i < c0195g.getCount()) {
                    item = c0195g.getItem(i);
                }
                MenuItem menuItem = this.f1731d;
                if (menuItem != item) {
                    C0196h c0196hM1517a = c0195g.m1517a();
                    if (menuItem != null) {
                        this.f1730c.mo1510a(c0196hM1517a, menuItem);
                    }
                    this.f1731d = item;
                    if (item != null) {
                        this.f1730c.mo1511b(c0196hM1517a, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.f1728a) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i != this.f1729b) {
                return super.onKeyDown(i, keyEvent);
            }
            setSelection(-1);
            ((C0195g) getAdapter()).m1517a().m1544a(false);
            return true;
        }

        @Override // android.support.v7.widget.C0247ag, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(InterfaceC0252al interfaceC0252al) {
            this.f1730c = interfaceC0252al;
        }

        @Override // android.support.v7.widget.C0247ag, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            f1726a = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public C0253am(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // android.support.v7.widget.C0251ak
    /* JADX INFO: renamed from: a */
    C0247ag mo1902a(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    @Override // android.support.v7.widget.InterfaceC0252al
    /* JADX INFO: renamed from: a */
    public void mo1510a(C0196h c0196h, MenuItem menuItem) {
        if (this.f1727b != null) {
            this.f1727b.mo1510a(c0196h, menuItem);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1928a(InterfaceC0252al interfaceC0252al) {
        this.f1727b = interfaceC0252al;
    }

    /* JADX INFO: renamed from: a */
    public void m1929a(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1700g.setEnterTransition((Transition) obj);
        }
    }

    @Override // android.support.v7.widget.InterfaceC0252al
    /* JADX INFO: renamed from: b */
    public void mo1511b(C0196h c0196h, MenuItem menuItem) {
        if (this.f1727b != null) {
            this.f1727b.mo1511b(c0196h, menuItem);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1930b(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f1700g.setExitTransition((Transition) obj);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m1931c(boolean z) {
        if (f1726a != null) {
            try {
                f1726a.invoke(this.f1700g, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
            }
        }
    }
}
