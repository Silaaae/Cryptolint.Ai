package android.support.v7.widget;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.p015g.AbstractC0102a;
import android.support.v4.widget.AbstractC0138d;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.InterfaceC0180c;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends C0250aj implements InterfaceC0180c {

    /* JADX INFO: renamed from: i */
    static final C0226a f1498i = new C0226a();

    /* JADX INFO: renamed from: A */
    private View.OnClickListener f1499A;

    /* JADX INFO: renamed from: B */
    private boolean f1500B;

    /* JADX INFO: renamed from: C */
    private boolean f1501C;

    /* JADX INFO: renamed from: D */
    private boolean f1502D;

    /* JADX INFO: renamed from: E */
    private CharSequence f1503E;

    /* JADX INFO: renamed from: F */
    private boolean f1504F;

    /* JADX INFO: renamed from: G */
    private boolean f1505G;

    /* JADX INFO: renamed from: H */
    private int f1506H;

    /* JADX INFO: renamed from: I */
    private boolean f1507I;

    /* JADX INFO: renamed from: J */
    private CharSequence f1508J;

    /* JADX INFO: renamed from: K */
    private boolean f1509K;

    /* JADX INFO: renamed from: L */
    private int f1510L;

    /* JADX INFO: renamed from: M */
    private Bundle f1511M;

    /* JADX INFO: renamed from: N */
    private final Runnable f1512N;

    /* JADX INFO: renamed from: O */
    private Runnable f1513O;

    /* JADX INFO: renamed from: P */
    private final WeakHashMap<String, Drawable.ConstantState> f1514P;

    /* JADX INFO: renamed from: a */
    final SearchAutoComplete f1515a;

    /* JADX INFO: renamed from: b */
    final ImageView f1516b;

    /* JADX INFO: renamed from: c */
    final ImageView f1517c;

    /* JADX INFO: renamed from: d */
    final ImageView f1518d;

    /* JADX INFO: renamed from: e */
    final ImageView f1519e;

    /* JADX INFO: renamed from: f */
    View.OnFocusChangeListener f1520f;

    /* JADX INFO: renamed from: g */
    AbstractC0138d f1521g;

    /* JADX INFO: renamed from: h */
    SearchableInfo f1522h;

    /* JADX INFO: renamed from: j */
    private final View f1523j;

    /* JADX INFO: renamed from: k */
    private final View f1524k;

    /* JADX INFO: renamed from: l */
    private C0231f f1525l;

    /* JADX INFO: renamed from: m */
    private Rect f1526m;

    /* JADX INFO: renamed from: n */
    private Rect f1527n;

    /* JADX INFO: renamed from: o */
    private int[] f1528o;

    /* JADX INFO: renamed from: p */
    private int[] f1529p;

    /* JADX INFO: renamed from: q */
    private final ImageView f1530q;

    /* JADX INFO: renamed from: r */
    private final Drawable f1531r;

    /* JADX INFO: renamed from: s */
    private final int f1532s;

    /* JADX INFO: renamed from: t */
    private final int f1533t;

    /* JADX INFO: renamed from: u */
    private final Intent f1534u;

    /* JADX INFO: renamed from: v */
    private final Intent f1535v;

    /* JADX INFO: renamed from: w */
    private final CharSequence f1536w;

    /* JADX INFO: renamed from: x */
    private InterfaceC0228c f1537x;

    /* JADX INFO: renamed from: y */
    private InterfaceC0227b f1538y;

    /* JADX INFO: renamed from: z */
    private InterfaceC0229d f1539z;

    public static class SearchAutoComplete extends C0275f {

        /* JADX INFO: renamed from: a */
        final Runnable f1540a;

        /* JADX INFO: renamed from: b */
        private int f1541b;

        /* JADX INFO: renamed from: c */
        private SearchView f1542c;

        /* JADX INFO: renamed from: d */
        private boolean f1543d;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0148a.a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1540a = new Runnable() { // from class: android.support.v7.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public void run() {
                    SearchAutoComplete.this.m1730a();
                }
            };
            this.f1541b = getThreshold();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m1730a() {
            if (this.f1543d) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f1543d = false;
            }
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.f1543d = false;
                removeCallbacks(this.f1540a);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f1543d = true;
                    return;
                }
                this.f1543d = false;
                removeCallbacks(this.f1540a);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f1541b <= 0 || super.enoughToFilter();
        }

        @Override // android.support.v7.widget.C0275f, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f1543d) {
                removeCallbacks(this.f1540a);
                post(this.f1540a);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1542c.m1728g();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1542c.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1542c.hasFocus() && getVisibility() == 0) {
                this.f1543d = true;
                if (SearchView.m1709a(getContext())) {
                    SearchView.f1498i.m1734a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        void setSearchView(SearchView searchView) {
            this.f1542c = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1541b = i;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.SearchView$a */
    private static class C0226a {

        /* JADX INFO: renamed from: a */
        private Method f1545a;

        /* JADX INFO: renamed from: b */
        private Method f1546b;

        /* JADX INFO: renamed from: c */
        private Method f1547c;

        C0226a() {
            try {
                this.f1545a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1545a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.f1546b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1546b.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                this.f1547c = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f1547c.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        /* JADX INFO: renamed from: a */
        void m1733a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1545a != null) {
                try {
                    this.f1545a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m1734a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f1547c != null) {
                try {
                    this.f1547c.invoke(autoCompleteTextView, Boolean.valueOf(z));
                } catch (Exception unused) {
                }
            }
        }

        /* JADX INFO: renamed from: b */
        void m1735b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1546b != null) {
                try {
                    this.f1546b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.SearchView$b */
    public interface InterfaceC0227b {
        /* JADX INFO: renamed from: a */
        boolean m1736a();
    }

    /* JADX INFO: renamed from: android.support.v7.widget.SearchView$c */
    public interface InterfaceC0228c {
        /* JADX INFO: renamed from: a */
        boolean m1737a(String str);
    }

    /* JADX INFO: renamed from: android.support.v7.widget.SearchView$d */
    public interface InterfaceC0229d {
    }

    /* JADX INFO: renamed from: android.support.v7.widget.SearchView$e */
    static class C0230e extends AbstractC0102a {
        public static final Parcelable.Creator<C0230e> CREATOR = new Parcelable.ClassLoaderCreator<C0230e>() { // from class: android.support.v7.widget.SearchView.e.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0230e createFromParcel(Parcel parcel) {
                return new C0230e(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0230e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new C0230e(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public C0230e[] newArray(int i) {
                return new C0230e[i];
            }
        };

        /* JADX INFO: renamed from: b */
        boolean f1548b;

        public C0230e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1548b = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        C0230e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1548b + "}";
        }

        @Override // android.support.v4.p015g.AbstractC0102a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1548b));
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.SearchView$f */
    private static class C0231f extends TouchDelegate {

        /* JADX INFO: renamed from: a */
        private final View f1549a;

        /* JADX INFO: renamed from: b */
        private final Rect f1550b;

        /* JADX INFO: renamed from: c */
        private final Rect f1551c;

        /* JADX INFO: renamed from: d */
        private final Rect f1552d;

        /* JADX INFO: renamed from: e */
        private final int f1553e;

        /* JADX INFO: renamed from: f */
        private boolean f1554f;

        public C0231f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1553e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1550b = new Rect();
            this.f1552d = new Rect();
            this.f1551c = new Rect();
            m1741a(rect, rect2);
            this.f1549a = view;
        }

        /* JADX INFO: renamed from: a */
        public void m1741a(Rect rect, Rect rect2) {
            this.f1550b.set(rect);
            this.f1552d.set(rect);
            this.f1552d.inset(-this.f1553e, -this.f1553e);
            this.f1551c.set(rect2);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
        @Override // android.view.TouchDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z;
            float width;
            int height;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            boolean z2 = true;
            switch (motionEvent.getAction()) {
                case 0:
                    if (!this.f1550b.contains(x, y)) {
                        z = false;
                    } else {
                        this.f1554f = true;
                        z = true;
                    }
                    break;
                case 1:
                case 2:
                    z = this.f1554f;
                    if (z && !this.f1552d.contains(x, y)) {
                        z2 = false;
                    }
                    break;
                case 3:
                    z = this.f1554f;
                    this.f1554f = false;
                    break;
            }
            if (!z) {
                return false;
            }
            if (!z2 || this.f1551c.contains(x, y)) {
                width = x - this.f1551c.left;
                height = y - this.f1551c.top;
            } else {
                width = this.f1549a.getWidth() / 2;
                height = this.f1549a.getHeight() / 2;
            }
            motionEvent.setLocation(width, height);
            return this.f1549a.dispatchTouchEvent(motionEvent);
        }
    }

    /* JADX INFO: renamed from: a */
    private Intent m1706a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1508J);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f1511M != null) {
            intent.putExtra("app_data", this.f1511M);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f1522h.getSearchActivity());
        return intent;
    }

    /* JADX INFO: renamed from: a */
    private void m1707a(View view, Rect rect) {
        view.getLocationInWindow(this.f1528o);
        getLocationInWindow(this.f1529p);
        int i = this.f1528o[1] - this.f1529p[1];
        int i2 = this.f1528o[0] - this.f1529p[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    /* JADX INFO: renamed from: a */
    private void m1708a(boolean z) {
        this.f1501C = z;
        int i = 8;
        int i2 = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.f1515a.getText());
        this.f1516b.setVisibility(i2);
        m1711b(z2);
        this.f1523j.setVisibility(z ? 8 : 0);
        if (this.f1530q.getDrawable() != null && !this.f1500B) {
            i = 0;
        }
        this.f1530q.setVisibility(i);
        m1716m();
        m1712c(z2 ? false : true);
        m1715l();
    }

    /* JADX INFO: renamed from: a */
    static boolean m1709a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* JADX INFO: renamed from: b */
    private CharSequence m1710b(CharSequence charSequence) {
        if (!this.f1500B || this.f1531r == null) {
            return charSequence;
        }
        double textSize = this.f1515a.getTextSize();
        Double.isNaN(textSize);
        int i = (int) (textSize * 1.25d);
        this.f1531r.setBounds(0, 0, i, i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f1531r), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    /* JADX INFO: renamed from: b */
    private void m1711b(boolean z) {
        this.f1517c.setVisibility((this.f1502D && m1714k() && hasFocus() && (z || !this.f1507I)) ? 0 : 8);
    }

    /* JADX INFO: renamed from: c */
    private void m1712c(boolean z) {
        int i;
        if (this.f1507I && !m1724c() && z) {
            i = 0;
            this.f1517c.setVisibility(8);
        } else {
            i = 8;
        }
        this.f1519e.setVisibility(i);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(C0148a.d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0148a.d.abc_search_view_preferred_width);
    }

    /* JADX INFO: renamed from: i */
    private boolean m1713i() {
        if (this.f1522h == null || !this.f1522h.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1522h.getVoiceSearchLaunchWebSearch()) {
            intent = this.f1534u;
        } else if (this.f1522h.getVoiceSearchLaunchRecognizer()) {
            intent = this.f1535v;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    /* JADX INFO: renamed from: k */
    private boolean m1714k() {
        return (this.f1502D || this.f1507I) && !m1724c();
    }

    /* JADX INFO: renamed from: l */
    private void m1715l() {
        this.f1524k.setVisibility((m1714k() && (this.f1517c.getVisibility() == 0 || this.f1519e.getVisibility() == 0)) ? 0 : 8);
    }

    /* JADX INFO: renamed from: m */
    private void m1716m() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f1515a.getText());
        if (!z2 && (!this.f1500B || this.f1509K)) {
            z = false;
        }
        this.f1518d.setVisibility(z ? 0 : 8);
        Drawable drawable = this.f1518d.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    /* JADX INFO: renamed from: n */
    private void m1717n() {
        post(this.f1512N);
    }

    /* JADX INFO: renamed from: o */
    private void m1718o() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1515a;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(m1710b(queryHint));
    }

    /* JADX INFO: renamed from: p */
    private void m1719p() {
        this.f1515a.setThreshold(this.f1522h.getSuggestThreshold());
        this.f1515a.setImeOptions(this.f1522h.getImeOptions());
        int inputType = this.f1522h.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1522h.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.f1515a.setInputType(inputType);
        if (this.f1521g != null) {
            this.f1521g.mo1118a((Cursor) null);
        }
        if (this.f1522h.getSuggestAuthority() != null) {
            this.f1521g = new ViewOnClickListenerC0257aq(getContext(), this, this.f1522h, this.f1514P);
            this.f1515a.setAdapter(this.f1521g);
            ((ViewOnClickListenerC0257aq) this.f1521g).m1965a(this.f1504F ? 2 : 1);
        }
    }

    /* JADX INFO: renamed from: q */
    private void m1720q() {
        this.f1515a.dismissDropDown();
    }

    private void setQuery(CharSequence charSequence) {
        this.f1515a.setText(charSequence);
        this.f1515a.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // android.support.v7.view.InterfaceC0180c
    /* JADX INFO: renamed from: a */
    public void mo1416a() {
        if (this.f1509K) {
            return;
        }
        this.f1509K = true;
        this.f1510L = this.f1515a.getImeOptions();
        this.f1515a.setImeOptions(this.f1510L | 33554432);
        this.f1515a.setText("");
        setIconified(false);
    }

    /* JADX INFO: renamed from: a */
    void m1721a(int i, String str, String str2) {
        getContext().startActivity(m1706a("android.intent.action.SEARCH", (Uri) null, (String) null, str2, i, str));
    }

    /* JADX INFO: renamed from: a */
    void m1722a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    /* JADX INFO: renamed from: a */
    public void m1723a(CharSequence charSequence, boolean z) {
        this.f1515a.setText(charSequence);
        if (charSequence != null) {
            this.f1515a.setSelection(this.f1515a.length());
            this.f1508J = charSequence;
        }
        if (!z || TextUtils.isEmpty(charSequence)) {
            return;
        }
        m1725d();
    }

    @Override // android.support.v7.view.InterfaceC0180c
    /* JADX INFO: renamed from: b */
    public void mo1417b() {
        m1723a("", false);
        clearFocus();
        m1708a(true);
        this.f1515a.setImeOptions(this.f1510L);
        this.f1509K = false;
    }

    /* JADX INFO: renamed from: c */
    public boolean m1724c() {
        return this.f1501C;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f1505G = true;
        super.clearFocus();
        this.f1515a.clearFocus();
        this.f1515a.setImeVisibility(false);
        this.f1505G = false;
    }

    /* JADX INFO: renamed from: d */
    void m1725d() {
        Editable text = this.f1515a.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f1537x == null || !this.f1537x.m1737a(text.toString())) {
            if (this.f1522h != null) {
                m1721a(0, null, text.toString());
            }
            this.f1515a.setImeVisibility(false);
            m1720q();
        }
    }

    /* JADX INFO: renamed from: e */
    void m1726e() {
        if (!TextUtils.isEmpty(this.f1515a.getText())) {
            this.f1515a.setText("");
            this.f1515a.requestFocus();
            this.f1515a.setImeVisibility(true);
        } else if (this.f1500B) {
            if (this.f1538y == null || !this.f1538y.m1736a()) {
                clearFocus();
                m1708a(true);
            }
        }
    }

    /* JADX INFO: renamed from: f */
    void m1727f() {
        m1708a(false);
        this.f1515a.requestFocus();
        this.f1515a.setImeVisibility(true);
        if (this.f1499A != null) {
            this.f1499A.onClick(this);
        }
    }

    /* JADX INFO: renamed from: g */
    void m1728g() {
        m1708a(m1724c());
        m1717n();
        if (this.f1515a.hasFocus()) {
            m1729h();
        }
    }

    public int getImeOptions() {
        return this.f1515a.getImeOptions();
    }

    public int getInputType() {
        return this.f1515a.getInputType();
    }

    public int getMaxWidth() {
        return this.f1506H;
    }

    public CharSequence getQuery() {
        return this.f1515a.getText();
    }

    public CharSequence getQueryHint() {
        return this.f1503E != null ? this.f1503E : (this.f1522h == null || this.f1522h.getHintId() == 0) ? this.f1536w : getContext().getText(this.f1522h.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.f1533t;
    }

    int getSuggestionRowLayout() {
        return this.f1532s;
    }

    public AbstractC0138d getSuggestionsAdapter() {
        return this.f1521g;
    }

    /* JADX INFO: renamed from: h */
    void m1729h() {
        f1498i.m1733a(this.f1515a);
        f1498i.m1735b(this.f1515a);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f1512N);
        post(this.f1513O);
        super.onDetachedFromWindow();
    }

    @Override // android.support.v7.widget.C0250aj, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m1707a(this.f1515a, this.f1526m);
            this.f1527n.set(this.f1526m.left, 0, this.f1526m.right, i4 - i2);
            if (this.f1525l != null) {
                this.f1525l.m1741a(this.f1527n, this.f1526m);
            } else {
                this.f1525l = new C0231f(this.f1527n, this.f1526m, this.f1515a);
                setTouchDelegate(this.f1525l);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
    
        if (r3.f1506H <= 0) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0050  */
    @Override // android.support.v7.widget.C0250aj, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        int preferredWidth;
        int mode;
        if (m1724c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode2 = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode2 == Integer.MIN_VALUE) {
            if (this.f1506H <= 0) {
                preferredWidth = getPreferredWidth();
            }
            size = Math.min(preferredWidth, size);
            mode = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            if (mode == Integer.MIN_VALUE) {
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        }
        if (mode2 == 0) {
            size = this.f1506H > 0 ? this.f1506H : getPreferredWidth();
        } else if (mode2 == 1073741824) {
        }
        mode = View.MeasureSpec.getMode(i2);
        int size22 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            size22 = Math.min(getPreferredHeight(), size22);
        } else if (mode == 0) {
            size22 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size22, 1073741824));
        preferredWidth = this.f1506H;
        size = Math.min(preferredWidth, size);
        mode = View.MeasureSpec.getMode(i2);
        int size222 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size222, 1073741824));
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0230e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0230e c0230e = (C0230e) parcelable;
        super.onRestoreInstanceState(c0230e.m841a());
        m1708a(c0230e.f1548b);
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        C0230e c0230e = new C0230e(super.onSaveInstanceState());
        c0230e.f1548b = m1724c();
        return c0230e;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m1717n();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.f1505G || !isFocusable()) {
            return false;
        }
        if (m1724c()) {
            return super.requestFocus(i, rect);
        }
        boolean zRequestFocus = this.f1515a.requestFocus(i, rect);
        if (zRequestFocus) {
            m1708a(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1511M = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m1726e();
        } else {
            m1727f();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1500B == z) {
            return;
        }
        this.f1500B = z;
        m1708a(z);
        m1718o();
    }

    public void setImeOptions(int i) {
        this.f1515a.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f1515a.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f1506H = i;
        requestLayout();
    }

    public void setOnCloseListener(InterfaceC0227b interfaceC0227b) {
        this.f1538y = interfaceC0227b;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f1520f = onFocusChangeListener;
    }

    public void setOnQueryTextListener(InterfaceC0228c interfaceC0228c) {
        this.f1537x = interfaceC0228c;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f1499A = onClickListener;
    }

    public void setOnSuggestionListener(InterfaceC0229d interfaceC0229d) {
        this.f1539z = interfaceC0229d;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1503E = charSequence;
        m1718o();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1504F = z;
        if (this.f1521g instanceof ViewOnClickListenerC0257aq) {
            ((ViewOnClickListenerC0257aq) this.f1521g).m1965a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1522h = searchableInfo;
        if (this.f1522h != null) {
            m1719p();
            m1718o();
        }
        this.f1507I = m1713i();
        if (this.f1507I) {
            this.f1515a.setPrivateImeOptions("nm");
        }
        m1708a(m1724c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1502D = z;
        m1708a(m1724c());
    }

    public void setSuggestionsAdapter(AbstractC0138d abstractC0138d) {
        this.f1521g = abstractC0138d;
        this.f1515a.setAdapter(this.f1521g);
    }
}
