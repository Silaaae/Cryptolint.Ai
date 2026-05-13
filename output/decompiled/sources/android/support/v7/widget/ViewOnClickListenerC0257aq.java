package android.support.v7.widget;

import android.R;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.p006a.C0033a;
import android.support.v4.widget.AbstractC0145k;
import android.support.v7.p018a.C0148a;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: android.support.v7.widget.aq */
/* JADX INFO: loaded from: classes.dex */
class ViewOnClickListenerC0257aq extends AbstractC0145k implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    private final SearchManager f1761j;

    /* JADX INFO: renamed from: k */
    private final SearchView f1762k;

    /* JADX INFO: renamed from: l */
    private final SearchableInfo f1763l;

    /* JADX INFO: renamed from: m */
    private final Context f1764m;

    /* JADX INFO: renamed from: n */
    private final WeakHashMap<String, Drawable.ConstantState> f1765n;

    /* JADX INFO: renamed from: o */
    private final int f1766o;

    /* JADX INFO: renamed from: p */
    private boolean f1767p;

    /* JADX INFO: renamed from: q */
    private int f1768q;

    /* JADX INFO: renamed from: r */
    private ColorStateList f1769r;

    /* JADX INFO: renamed from: s */
    private int f1770s;

    /* JADX INFO: renamed from: t */
    private int f1771t;

    /* JADX INFO: renamed from: u */
    private int f1772u;

    /* JADX INFO: renamed from: v */
    private int f1773v;

    /* JADX INFO: renamed from: w */
    private int f1774w;

    /* JADX INFO: renamed from: x */
    private int f1775x;

    /* JADX INFO: renamed from: android.support.v7.widget.aq$a */
    private static final class a {

        /* JADX INFO: renamed from: a */
        public final TextView f1776a;

        /* JADX INFO: renamed from: b */
        public final TextView f1777b;

        /* JADX INFO: renamed from: c */
        public final ImageView f1778c;

        /* JADX INFO: renamed from: d */
        public final ImageView f1779d;

        /* JADX INFO: renamed from: e */
        public final ImageView f1780e;

        public a(View view) {
            this.f1776a = (TextView) view.findViewById(R.id.text1);
            this.f1777b = (TextView) view.findViewById(R.id.text2);
            this.f1778c = (ImageView) view.findViewById(R.id.icon1);
            this.f1779d = (ImageView) view.findViewById(R.id.icon2);
            this.f1780e = (ImageView) view.findViewById(C0148a.f.edit_query);
        }
    }

    public ViewOnClickListenerC0257aq(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1767p = false;
        this.f1768q = 1;
        this.f1770s = -1;
        this.f1771t = -1;
        this.f1772u = -1;
        this.f1773v = -1;
        this.f1774w = -1;
        this.f1775x = -1;
        this.f1761j = (SearchManager) this.f758d.getSystemService("search");
        this.f1762k = searchView;
        this.f1763l = searchableInfo;
        this.f1766o = searchView.getSuggestionCommitIconResId();
        this.f1764m = context;
        this.f1765n = weakHashMap;
    }

    /* JADX INFO: renamed from: a */
    private Drawable m1948a(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f1765n.containsKey(strFlattenToShortString)) {
            Drawable drawableM1955b = m1955b(componentName);
            this.f1765n.put(strFlattenToShortString, drawableM1955b != null ? drawableM1955b.getConstantState() : null);
            return drawableM1955b;
        }
        Drawable.ConstantState constantState = this.f1765n.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f1764m.getResources());
    }

    /* JADX INFO: renamed from: a */
    private Drawable m1949a(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1764m.getPackageName() + "/" + i;
            Drawable drawableM1957b = m1957b(str2);
            if (drawableM1957b != null) {
                return drawableM1957b;
            }
            Drawable drawableM167a = C0033a.m167a(this.f1764m, i);
            m1954a(str2, drawableM167a);
            return drawableM167a;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableM1957b2 = m1957b(str);
            if (drawableM1957b2 != null) {
                return drawableM1957b2;
            }
            Drawable drawableM1956b = m1956b(Uri.parse(str));
            m1954a(str, drawableM1956b);
            return drawableM1956b;
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m1950a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m1951a(Cursor cursor, String str) {
        return m1950a(cursor, cursor.getColumnIndex(str));
    }

    /* JADX INFO: renamed from: a */
    private void m1952a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    /* JADX INFO: renamed from: a */
    private void m1953a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    /* JADX INFO: renamed from: a */
    private void m1954a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1765n.put(str, drawable.getConstantState());
        }
    }

    /* JADX INFO: renamed from: b */
    private Drawable m1955b(ComponentName componentName) {
        String str;
        String string;
        ActivityInfo activityInfo;
        int iconResource;
        PackageManager packageManager = this.f758d.getPackageManager();
        try {
            activityInfo = packageManager.getActivityInfo(componentName, 128);
            iconResource = activityInfo.getIconResource();
        } catch (PackageManager.NameNotFoundException e) {
            str = "SuggestionsAdapter";
            string = e.toString();
        }
        if (iconResource == 0) {
            return null;
        }
        Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
        if (drawable != null) {
            return drawable;
        }
        str = "SuggestionsAdapter";
        string = "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString();
        Log.w(str, string);
        return null;
    }

    /* JADX INFO: renamed from: b */
    private Drawable m1956b(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return m1964a(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f1764m.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(inputStreamOpenInputStream, null);
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                }
            }
        } catch (FileNotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
        return null;
    }

    /* JADX INFO: renamed from: b */
    private Drawable m1957b(String str) {
        Drawable.ConstantState constantState = this.f1765n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* JADX INFO: renamed from: b */
    private CharSequence m1958b(CharSequence charSequence) {
        if (this.f1769r == null) {
            TypedValue typedValue = new TypedValue();
            this.f758d.getTheme().resolveAttribute(C0148a.a.textColorSearchUrl, typedValue, true);
            this.f1769r = this.f758d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f1769r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* JADX INFO: renamed from: d */
    private void m1959d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    /* JADX INFO: renamed from: e */
    private Drawable m1960e(Cursor cursor) {
        if (this.f1773v == -1) {
            return null;
        }
        Drawable drawableM1949a = m1949a(cursor.getString(this.f1773v));
        return drawableM1949a != null ? drawableM1949a : m1962g(cursor);
    }

    /* JADX INFO: renamed from: f */
    private Drawable m1961f(Cursor cursor) {
        if (this.f1774w == -1) {
            return null;
        }
        return m1949a(cursor.getString(this.f1774w));
    }

    /* JADX INFO: renamed from: g */
    private Drawable m1962g(Cursor cursor) {
        Drawable drawableM1948a = m1948a(this.f1763l.getSearchActivity());
        return drawableM1948a != null ? drawableM1948a : this.f758d.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX INFO: renamed from: a */
    Cursor m1963a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f758d.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // android.support.v4.widget.AbstractC0138d, android.support.v4.widget.C0139e.a
    /* JADX INFO: renamed from: a */
    public Cursor mo1115a(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f1762k.getVisibility() == 0 && this.f1762k.getWindowVisibility() == 0) {
            try {
                Cursor cursorM1963a = m1963a(this.f1763l, string, 50);
                if (cursorM1963a != null) {
                    cursorM1963a.getCount();
                    return cursorM1963a;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    Drawable m1964a(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f758d.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    @Override // android.support.v4.widget.AbstractC0145k, android.support.v4.widget.AbstractC0138d
    /* JADX INFO: renamed from: a */
    public View mo1116a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewMo1116a = super.mo1116a(context, cursor, viewGroup);
        viewMo1116a.setTag(new a(viewMo1116a));
        ((ImageView) viewMo1116a.findViewById(C0148a.f.edit_query)).setImageResource(this.f1766o);
        return viewMo1116a;
    }

    /* JADX INFO: renamed from: a */
    public void m1965a(int i) {
        this.f1768q = i;
    }

    @Override // android.support.v4.widget.AbstractC0138d, android.support.v4.widget.C0139e.a
    /* JADX INFO: renamed from: a */
    public void mo1118a(Cursor cursor) {
        if (this.f1767p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo1118a(cursor);
            if (cursor != null) {
                this.f1770s = cursor.getColumnIndex("suggest_text_1");
                this.f1771t = cursor.getColumnIndex("suggest_text_2");
                this.f1772u = cursor.getColumnIndex("suggest_text_2_url");
                this.f1773v = cursor.getColumnIndex("suggest_icon_1");
                this.f1774w = cursor.getColumnIndex("suggest_icon_2");
                this.f1775x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // android.support.v4.widget.AbstractC0138d
    /* JADX INFO: renamed from: a */
    public void mo1119a(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i = this.f1775x != -1 ? cursor.getInt(this.f1775x) : 0;
        if (aVar.f1776a != null) {
            m1953a(aVar.f1776a, m1950a(cursor, this.f1770s));
        }
        if (aVar.f1777b != null) {
            String strM1950a = m1950a(cursor, this.f1772u);
            CharSequence charSequenceM1958b = strM1950a != null ? m1958b((CharSequence) strM1950a) : m1950a(cursor, this.f1771t);
            if (TextUtils.isEmpty(charSequenceM1958b)) {
                if (aVar.f1776a != null) {
                    aVar.f1776a.setSingleLine(false);
                    aVar.f1776a.setMaxLines(2);
                }
            } else if (aVar.f1776a != null) {
                aVar.f1776a.setSingleLine(true);
                aVar.f1776a.setMaxLines(1);
            }
            m1953a(aVar.f1777b, charSequenceM1958b);
        }
        if (aVar.f1778c != null) {
            m1952a(aVar.f1778c, m1960e(cursor), 4);
        }
        if (aVar.f1779d != null) {
            m1952a(aVar.f1779d, m1961f(cursor), 8);
        }
        if (this.f1768q != 2 && (this.f1768q != 1 || (i & 1) == 0)) {
            aVar.f1780e.setVisibility(8);
            return;
        }
        aVar.f1780e.setVisibility(0);
        aVar.f1780e.setTag(aVar.f1776a.getText());
        aVar.f1780e.setOnClickListener(this);
    }

    @Override // android.support.v4.widget.AbstractC0138d, android.support.v4.widget.C0139e.a
    /* JADX INFO: renamed from: c */
    public CharSequence mo1123c(Cursor cursor) {
        String strM1951a;
        String strM1951a2;
        if (cursor == null) {
            return null;
        }
        String strM1951a3 = m1951a(cursor, "suggest_intent_query");
        if (strM1951a3 != null) {
            return strM1951a3;
        }
        if (this.f1763l.shouldRewriteQueryFromData() && (strM1951a2 = m1951a(cursor, "suggest_intent_data")) != null) {
            return strM1951a2;
        }
        if (!this.f1763l.shouldRewriteQueryFromText() || (strM1951a = m1951a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strM1951a;
    }

    @Override // android.support.v4.widget.AbstractC0138d, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewB = mo1121b(this.f758d, this.f757c, viewGroup);
            if (viewB != null) {
                ((a) viewB.getTag()).f1776a.setText(e.toString());
            }
            return viewB;
        }
    }

    @Override // android.support.v4.widget.AbstractC0138d, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewMo1116a = mo1116a(this.f758d, this.f757c, viewGroup);
            if (viewMo1116a != null) {
                ((a) viewMo1116a.getTag()).f1776a.setText(e.toString());
            }
            return viewMo1116a;
        }
    }

    @Override // android.support.v4.widget.AbstractC0138d, android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m1959d(mo1114a());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m1959d(mo1114a());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1762k.m1722a((CharSequence) tag);
        }
    }
}
