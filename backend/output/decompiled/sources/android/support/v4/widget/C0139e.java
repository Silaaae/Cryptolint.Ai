package android.support.v4.widget;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: renamed from: android.support.v4.widget.e */
/* JADX INFO: loaded from: classes.dex */
class C0139e extends Filter {

    /* JADX INFO: renamed from: a */
    a f766a;

    /* JADX INFO: renamed from: android.support.v4.widget.e$a */
    interface a {
        /* JADX INFO: renamed from: a */
        Cursor mo1114a();

        /* JADX INFO: renamed from: a */
        Cursor mo1115a(CharSequence charSequence);

        /* JADX INFO: renamed from: a */
        void mo1118a(Cursor cursor);

        /* JADX INFO: renamed from: c */
        CharSequence mo1123c(Cursor cursor);
    }

    C0139e(a aVar) {
        this.f766a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f766a.mo1123c((Cursor) obj);
    }

    @Override // android.widget.Filter
    protected Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorMo1115a = this.f766a.mo1115a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorMo1115a != null) {
            filterResults.count = cursorMo1115a.getCount();
        } else {
            filterResults.count = 0;
            cursorMo1115a = null;
        }
        filterResults.values = cursorMo1115a;
        return filterResults;
    }

    @Override // android.widget.Filter
    protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorMo1114a = this.f766a.mo1114a();
        if (filterResults.values == null || filterResults.values == cursorMo1114a) {
            return;
        }
        this.f766a.mo1118a((Cursor) filterResults.values);
    }
}
