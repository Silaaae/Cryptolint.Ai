package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.C0139e;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* JADX INFO: renamed from: android.support.v4.widget.d */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0138d extends BaseAdapter implements C0139e.a, Filterable {

    /* JADX INFO: renamed from: a */
    protected boolean f755a;

    /* JADX INFO: renamed from: b */
    protected boolean f756b;

    /* JADX INFO: renamed from: c */
    protected Cursor f757c;

    /* JADX INFO: renamed from: d */
    protected Context f758d;

    /* JADX INFO: renamed from: e */
    protected int f759e;

    /* JADX INFO: renamed from: f */
    protected a f760f;

    /* JADX INFO: renamed from: g */
    protected DataSetObserver f761g;

    /* JADX INFO: renamed from: h */
    protected C0139e f762h;

    /* JADX INFO: renamed from: i */
    protected FilterQueryProvider f763i;

    /* JADX INFO: renamed from: android.support.v4.widget.d$a */
    private class a extends ContentObserver {
        a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            AbstractC0138d.this.m1122b();
        }
    }

    /* JADX INFO: renamed from: android.support.v4.widget.d$b */
    private class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            AbstractC0138d.this.f755a = true;
            AbstractC0138d.this.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            AbstractC0138d.this.f755a = false;
            AbstractC0138d.this.notifyDataSetInvalidated();
        }
    }

    public AbstractC0138d(Context context, Cursor cursor, boolean z) {
        m1117a(context, cursor, z ? 1 : 2);
    }

    @Override // android.support.v4.widget.C0139e.a
    /* JADX INFO: renamed from: a */
    public Cursor mo1114a() {
        return this.f757c;
    }

    @Override // android.support.v4.widget.C0139e.a
    /* JADX INFO: renamed from: a */
    public Cursor mo1115a(CharSequence charSequence) {
        return this.f763i != null ? this.f763i.runQuery(charSequence) : this.f757c;
    }

    /* JADX INFO: renamed from: a */
    public abstract View mo1116a(Context context, Cursor cursor, ViewGroup viewGroup);

    /* JADX INFO: renamed from: a */
    void m1117a(Context context, Cursor cursor, int i) {
        b bVar;
        if ((i & 1) == 1) {
            i |= 2;
            this.f756b = true;
        } else {
            this.f756b = false;
        }
        boolean z = cursor != null;
        this.f757c = cursor;
        this.f755a = z;
        this.f758d = context;
        this.f759e = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f760f = new a();
            bVar = new b();
        } else {
            bVar = null;
            this.f760f = null;
        }
        this.f761g = bVar;
        if (z) {
            if (this.f760f != null) {
                cursor.registerContentObserver(this.f760f);
            }
            if (this.f761g != null) {
                cursor.registerDataSetObserver(this.f761g);
            }
        }
    }

    @Override // android.support.v4.widget.C0139e.a
    /* JADX INFO: renamed from: a */
    public void mo1118a(Cursor cursor) {
        Cursor cursorM1120b = m1120b(cursor);
        if (cursorM1120b != null) {
            cursorM1120b.close();
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo1119a(View view, Context context, Cursor cursor);

    /* JADX INFO: renamed from: b */
    public Cursor m1120b(Cursor cursor) {
        if (cursor == this.f757c) {
            return null;
        }
        Cursor cursor2 = this.f757c;
        if (cursor2 != null) {
            if (this.f760f != null) {
                cursor2.unregisterContentObserver(this.f760f);
            }
            if (this.f761g != null) {
                cursor2.unregisterDataSetObserver(this.f761g);
            }
        }
        this.f757c = cursor;
        if (cursor != null) {
            if (this.f760f != null) {
                cursor.registerContentObserver(this.f760f);
            }
            if (this.f761g != null) {
                cursor.registerDataSetObserver(this.f761g);
            }
            this.f759e = cursor.getColumnIndexOrThrow("_id");
            this.f755a = true;
            notifyDataSetChanged();
        } else {
            this.f759e = -1;
            this.f755a = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    /* JADX INFO: renamed from: b */
    public View mo1121b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return mo1116a(context, cursor, viewGroup);
    }

    /* JADX INFO: renamed from: b */
    protected void m1122b() {
        if (!this.f756b || this.f757c == null || this.f757c.isClosed()) {
            return;
        }
        this.f755a = this.f757c.requery();
    }

    @Override // android.support.v4.widget.C0139e.a
    /* JADX INFO: renamed from: c */
    public CharSequence mo1123c(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (!this.f755a || this.f757c == null) {
            return 0;
        }
        return this.f757c.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f755a) {
            return null;
        }
        this.f757c.moveToPosition(i);
        if (view == null) {
            view = mo1121b(this.f758d, this.f757c, viewGroup);
        }
        mo1119a(view, this.f758d, this.f757c);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f762h == null) {
            this.f762h = new C0139e(this);
        }
        return this.f762h;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (!this.f755a || this.f757c == null) {
            return null;
        }
        this.f757c.moveToPosition(i);
        return this.f757c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.f755a && this.f757c != null && this.f757c.moveToPosition(i)) {
            return this.f757c.getLong(this.f759e);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f755a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f757c.moveToPosition(i)) {
            if (view == null) {
                view = mo1116a(this.f758d, this.f757c, viewGroup);
            }
            mo1119a(view, this.f758d, this.f757c);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
