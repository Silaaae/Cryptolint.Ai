package android.support.v7.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.p015g.C0124p;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.p018a.C0148a;
import android.support.v7.widget.C0250aj;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class AlertController {

    /* JADX INFO: renamed from: A */
    private int f778A;

    /* JADX INFO: renamed from: C */
    private CharSequence f780C;

    /* JADX INFO: renamed from: D */
    private Drawable f781D;

    /* JADX INFO: renamed from: E */
    private CharSequence f782E;

    /* JADX INFO: renamed from: F */
    private Drawable f783F;

    /* JADX INFO: renamed from: G */
    private CharSequence f784G;

    /* JADX INFO: renamed from: H */
    private Drawable f785H;

    /* JADX INFO: renamed from: J */
    private Drawable f787J;

    /* JADX INFO: renamed from: K */
    private ImageView f788K;

    /* JADX INFO: renamed from: L */
    private TextView f789L;

    /* JADX INFO: renamed from: M */
    private TextView f790M;

    /* JADX INFO: renamed from: N */
    private View f791N;

    /* JADX INFO: renamed from: O */
    private int f792O;

    /* JADX INFO: renamed from: P */
    private int f793P;

    /* JADX INFO: renamed from: Q */
    private boolean f794Q;

    /* JADX INFO: renamed from: a */
    final DialogC0168k f797a;

    /* JADX INFO: renamed from: b */
    ListView f798b;

    /* JADX INFO: renamed from: c */
    Button f799c;

    /* JADX INFO: renamed from: d */
    Message f800d;

    /* JADX INFO: renamed from: e */
    Button f801e;

    /* JADX INFO: renamed from: f */
    Message f802f;

    /* JADX INFO: renamed from: g */
    Button f803g;

    /* JADX INFO: renamed from: h */
    Message f804h;

    /* JADX INFO: renamed from: i */
    NestedScrollView f805i;

    /* JADX INFO: renamed from: j */
    ListAdapter f806j;

    /* JADX INFO: renamed from: l */
    int f808l;

    /* JADX INFO: renamed from: m */
    int f809m;

    /* JADX INFO: renamed from: n */
    int f810n;

    /* JADX INFO: renamed from: o */
    int f811o;

    /* JADX INFO: renamed from: p */
    Handler f812p;

    /* JADX INFO: renamed from: q */
    private final Context f813q;

    /* JADX INFO: renamed from: r */
    private final Window f814r;

    /* JADX INFO: renamed from: s */
    private final int f815s;

    /* JADX INFO: renamed from: t */
    private CharSequence f816t;

    /* JADX INFO: renamed from: u */
    private CharSequence f817u;

    /* JADX INFO: renamed from: v */
    private View f818v;

    /* JADX INFO: renamed from: w */
    private int f819w;

    /* JADX INFO: renamed from: x */
    private int f820x;

    /* JADX INFO: renamed from: y */
    private int f821y;

    /* JADX INFO: renamed from: z */
    private int f822z;

    /* JADX INFO: renamed from: B */
    private boolean f779B = false;

    /* JADX INFO: renamed from: I */
    private int f786I = 0;

    /* JADX INFO: renamed from: k */
    int f807k = -1;

    /* JADX INFO: renamed from: R */
    private int f795R = 0;

    /* JADX INFO: renamed from: S */
    private final View.OnClickListener f796S = new View.OnClickListener() { // from class: android.support.v7.app.AlertController.1
        /* JADX WARN: Removed duplicated region for block: B:20:0x003a  */
        @Override // android.view.View.OnClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view) {
            Message messageObtain;
            Message message;
            if (view == AlertController.this.f799c && AlertController.this.f800d != null) {
                message = AlertController.this.f800d;
            } else if (view == AlertController.this.f801e && AlertController.this.f802f != null) {
                message = AlertController.this.f802f;
            } else {
                if (view != AlertController.this.f803g || AlertController.this.f804h == null) {
                    messageObtain = null;
                    if (messageObtain != null) {
                        messageObtain.sendToTarget();
                    }
                    AlertController.this.f812p.obtainMessage(1, AlertController.this.f797a).sendToTarget();
                }
                message = AlertController.this.f804h;
            }
            messageObtain = Message.obtain(message);
            if (messageObtain != null) {
            }
            AlertController.this.f812p.obtainMessage(1, AlertController.this.f797a).sendToTarget();
        }
    };

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: a */
        private final int f836a;

        /* JADX INFO: renamed from: b */
        private final int f837b;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0148a.j.RecycleListView);
            this.f837b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C0148a.j.RecycleListView_paddingBottomNoButtons, -1);
            this.f836a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(C0148a.j.RecycleListView_paddingTopNoTitle, -1);
        }

        /* JADX INFO: renamed from: a */
        public void m1166a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f836a, getPaddingRight(), z2 ? getPaddingBottom() : this.f837b);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.AlertController$a */
    public static class C0154a {

        /* JADX INFO: renamed from: A */
        public int f838A;

        /* JADX INFO: renamed from: B */
        public int f839B;

        /* JADX INFO: renamed from: C */
        public int f840C;

        /* JADX INFO: renamed from: D */
        public int f841D;

        /* JADX INFO: renamed from: F */
        public boolean[] f843F;

        /* JADX INFO: renamed from: G */
        public boolean f844G;

        /* JADX INFO: renamed from: H */
        public boolean f845H;

        /* JADX INFO: renamed from: J */
        public DialogInterface.OnMultiChoiceClickListener f847J;

        /* JADX INFO: renamed from: K */
        public Cursor f848K;

        /* JADX INFO: renamed from: L */
        public String f849L;

        /* JADX INFO: renamed from: M */
        public String f850M;

        /* JADX INFO: renamed from: N */
        public AdapterView.OnItemSelectedListener f851N;

        /* JADX INFO: renamed from: O */
        public a f852O;

        /* JADX INFO: renamed from: a */
        public final Context f854a;

        /* JADX INFO: renamed from: b */
        public final LayoutInflater f855b;

        /* JADX INFO: renamed from: d */
        public Drawable f857d;

        /* JADX INFO: renamed from: f */
        public CharSequence f859f;

        /* JADX INFO: renamed from: g */
        public View f860g;

        /* JADX INFO: renamed from: h */
        public CharSequence f861h;

        /* JADX INFO: renamed from: i */
        public CharSequence f862i;

        /* JADX INFO: renamed from: j */
        public Drawable f863j;

        /* JADX INFO: renamed from: k */
        public DialogInterface.OnClickListener f864k;

        /* JADX INFO: renamed from: l */
        public CharSequence f865l;

        /* JADX INFO: renamed from: m */
        public Drawable f866m;

        /* JADX INFO: renamed from: n */
        public DialogInterface.OnClickListener f867n;

        /* JADX INFO: renamed from: o */
        public CharSequence f868o;

        /* JADX INFO: renamed from: p */
        public Drawable f869p;

        /* JADX INFO: renamed from: q */
        public DialogInterface.OnClickListener f870q;

        /* JADX INFO: renamed from: s */
        public DialogInterface.OnCancelListener f872s;

        /* JADX INFO: renamed from: t */
        public DialogInterface.OnDismissListener f873t;

        /* JADX INFO: renamed from: u */
        public DialogInterface.OnKeyListener f874u;

        /* JADX INFO: renamed from: v */
        public CharSequence[] f875v;

        /* JADX INFO: renamed from: w */
        public ListAdapter f876w;

        /* JADX INFO: renamed from: x */
        public DialogInterface.OnClickListener f877x;

        /* JADX INFO: renamed from: y */
        public int f878y;

        /* JADX INFO: renamed from: z */
        public View f879z;

        /* JADX INFO: renamed from: c */
        public int f856c = 0;

        /* JADX INFO: renamed from: e */
        public int f858e = 0;

        /* JADX INFO: renamed from: E */
        public boolean f842E = false;

        /* JADX INFO: renamed from: I */
        public int f846I = -1;

        /* JADX INFO: renamed from: P */
        public boolean f853P = true;

        /* JADX INFO: renamed from: r */
        public boolean f871r = true;

        /* JADX INFO: renamed from: android.support.v7.app.AlertController$a$a */
        public interface a {
            /* JADX INFO: renamed from: a */
            void m1169a(ListView listView);
        }

        public C0154a(Context context) {
            this.f854a = context;
            this.f855b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a5  */
        /* JADX INFO: renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void m1167b(final AlertController alertController) {
            ListAdapter simpleCursorAdapter;
            AdapterView.OnItemClickListener onItemClickListener;
            final RecycleListView recycleListView = (RecycleListView) this.f855b.inflate(alertController.f808l, (ViewGroup) null);
            if (this.f844G) {
                simpleCursorAdapter = this.f848K == null ? new ArrayAdapter<CharSequence>(this.f854a, alertController.f809m, R.id.text1, this.f875v) { // from class: android.support.v7.app.AlertController.a.1
                    @Override // android.widget.ArrayAdapter, android.widget.Adapter
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View view2 = super.getView(i, view, viewGroup);
                        if (C0154a.this.f843F != null && C0154a.this.f843F[i]) {
                            recycleListView.setItemChecked(i, true);
                        }
                        return view2;
                    }
                } : new CursorAdapter(this.f854a, this.f848K, false) { // from class: android.support.v7.app.AlertController.a.2

                    /* JADX INFO: renamed from: d */
                    private final int f885d;

                    /* JADX INFO: renamed from: e */
                    private final int f886e;

                    {
                        Cursor cursor = getCursor();
                        this.f885d = cursor.getColumnIndexOrThrow(C0154a.this.f849L);
                        this.f886e = cursor.getColumnIndexOrThrow(C0154a.this.f850M);
                    }

                    @Override // android.widget.CursorAdapter
                    public void bindView(View view, Context context, Cursor cursor) {
                        ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f885d));
                        recycleListView.setItemChecked(cursor.getPosition(), cursor.getInt(this.f886e) == 1);
                    }

                    @Override // android.widget.CursorAdapter
                    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                        return C0154a.this.f855b.inflate(alertController.f809m, viewGroup, false);
                    }
                };
            } else {
                int i = this.f845H ? alertController.f810n : alertController.f811o;
                simpleCursorAdapter = this.f848K != null ? new SimpleCursorAdapter(this.f854a, i, this.f848K, new String[]{this.f849L}, new int[]{R.id.text1}) : this.f876w != null ? this.f876w : new C0156c(this.f854a, i, R.id.text1, this.f875v);
            }
            if (this.f852O != null) {
                this.f852O.m1169a(recycleListView);
            }
            alertController.f806j = simpleCursorAdapter;
            alertController.f807k = this.f846I;
            if (this.f877x == null) {
                if (this.f847J != null) {
                    onItemClickListener = new AdapterView.OnItemClickListener() { // from class: android.support.v7.app.AlertController.a.4
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                            if (C0154a.this.f843F != null) {
                                C0154a.this.f843F[i2] = recycleListView.isItemChecked(i2);
                            }
                            C0154a.this.f847J.onClick(alertController.f797a, i2, recycleListView.isItemChecked(i2));
                        }
                    };
                }
                if (this.f851N != null) {
                    recycleListView.setOnItemSelectedListener(this.f851N);
                }
                if (!this.f845H) {
                    recycleListView.setChoiceMode(1);
                } else if (this.f844G) {
                    recycleListView.setChoiceMode(2);
                }
                alertController.f798b = recycleListView;
            }
            onItemClickListener = new AdapterView.OnItemClickListener() { // from class: android.support.v7.app.AlertController.a.3
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    C0154a.this.f877x.onClick(alertController.f797a, i2);
                    if (C0154a.this.f845H) {
                        return;
                    }
                    alertController.f797a.dismiss();
                }
            };
            recycleListView.setOnItemClickListener(onItemClickListener);
            if (this.f851N != null) {
            }
            if (!this.f845H) {
            }
            alertController.f798b = recycleListView;
        }

        /* JADX INFO: renamed from: a */
        public void m1168a(AlertController alertController) {
            if (this.f860g != null) {
                alertController.m1161b(this.f860g);
            } else {
                if (this.f859f != null) {
                    alertController.m1158a(this.f859f);
                }
                if (this.f857d != null) {
                    alertController.m1156a(this.f857d);
                }
                if (this.f856c != 0) {
                    alertController.m1160b(this.f856c);
                }
                if (this.f858e != 0) {
                    alertController.m1160b(alertController.m1164c(this.f858e));
                }
            }
            if (this.f861h != null) {
                alertController.m1162b(this.f861h);
            }
            if (this.f862i != null || this.f863j != null) {
                alertController.m1155a(-1, this.f862i, this.f864k, (Message) null, this.f863j);
            }
            if (this.f865l != null || this.f866m != null) {
                alertController.m1155a(-2, this.f865l, this.f867n, (Message) null, this.f866m);
            }
            if (this.f868o != null || this.f869p != null) {
                alertController.m1155a(-3, this.f868o, this.f870q, (Message) null, this.f869p);
            }
            if (this.f875v != null || this.f848K != null || this.f876w != null) {
                m1167b(alertController);
            }
            if (this.f879z == null) {
                if (this.f878y != 0) {
                    alertController.m1154a(this.f878y);
                }
            } else if (this.f842E) {
                alertController.m1157a(this.f879z, this.f838A, this.f839B, this.f840C, this.f841D);
            } else {
                alertController.m1165c(this.f879z);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.AlertController$b */
    private static final class HandlerC0155b extends Handler {

        /* JADX INFO: renamed from: a */
        private WeakReference<DialogInterface> f892a;

        public HandlerC0155b(DialogInterface dialogInterface) {
            this.f892a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
            switch (i) {
                case -3:
                case -2:
                case -1:
                    ((DialogInterface.OnClickListener) message.obj).onClick(this.f892a.get(), message.what);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.app.AlertController$c */
    private static class C0156c extends ArrayAdapter<CharSequence> {
        public C0156c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, DialogC0168k dialogC0168k, Window window) {
        this.f813q = context;
        this.f797a = dialogC0168k;
        this.f814r = window;
        this.f812p = new HandlerC0155b(dialogC0168k);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, C0148a.j.AlertDialog, C0148a.a.alertDialogStyle, 0);
        this.f792O = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.AlertDialog_android_layout, 0);
        this.f793P = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.AlertDialog_buttonPanelSideLayout, 0);
        this.f808l = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.AlertDialog_listLayout, 0);
        this.f809m = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.AlertDialog_multiChoiceItemLayout, 0);
        this.f810n = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.AlertDialog_singleChoiceItemLayout, 0);
        this.f811o = typedArrayObtainStyledAttributes.getResourceId(C0148a.j.AlertDialog_listItemLayout, 0);
        this.f794Q = typedArrayObtainStyledAttributes.getBoolean(C0148a.j.AlertDialog_showTitle, true);
        this.f815s = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0148a.j.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        dialogC0168k.m1337a(1);
    }

    /* JADX INFO: renamed from: a */
    private ViewGroup m1141a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    /* JADX INFO: renamed from: a */
    static void m1142a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1143a(ViewGroup viewGroup) {
        View viewInflate = this.f818v != null ? this.f818v : this.f819w != 0 ? LayoutInflater.from(this.f813q).inflate(this.f819w, viewGroup, false) : null;
        boolean z = viewInflate != null;
        if (!z || !m1147a(viewInflate)) {
            this.f814r.setFlags(131072, 131072);
        }
        if (!z) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f814r.findViewById(C0148a.f.custom);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.f779B) {
            frameLayout.setPadding(this.f820x, this.f821y, this.f822z, this.f778A);
        }
        if (this.f798b != null) {
            ((C0250aj.a) viewGroup.getLayoutParams()).f1681g = 0.0f;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1144a(ViewGroup viewGroup, View view, int i, int i2) {
        final View viewFindViewById = this.f814r.findViewById(C0148a.f.scrollIndicatorUp);
        View viewFindViewById2 = this.f814r.findViewById(C0148a.f.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            C0124p.m951a(view, i, i2);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        final View view2 = null;
        if (viewFindViewById != null && (i & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 == null || (i & 2) != 0) {
            view2 = viewFindViewById2;
        } else {
            viewGroup.removeView(viewFindViewById2);
        }
        if (viewFindViewById == null && view2 == null) {
            return;
        }
        if (this.f817u != null) {
            this.f805i.setOnScrollChangeListener(new NestedScrollView.InterfaceC0133b() { // from class: android.support.v7.app.AlertController.2
                @Override // android.support.v4.widget.NestedScrollView.InterfaceC0133b
                /* JADX INFO: renamed from: a */
                public void mo1070a(NestedScrollView nestedScrollView, int i3, int i4, int i5, int i6) {
                    AlertController.m1142a(nestedScrollView, viewFindViewById, view2);
                }
            });
            this.f805i.post(new Runnable() { // from class: android.support.v7.app.AlertController.3
                @Override // java.lang.Runnable
                public void run() {
                    AlertController.m1142a(AlertController.this.f805i, viewFindViewById, view2);
                }
            });
        } else {
            if (this.f798b != null) {
                this.f798b.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: android.support.v7.app.AlertController.4
                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
                        AlertController.m1142a(absListView, viewFindViewById, view2);
                    }

                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScrollStateChanged(AbsListView absListView, int i3) {
                    }
                });
                this.f798b.post(new Runnable() { // from class: android.support.v7.app.AlertController.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AlertController.m1142a(AlertController.this.f798b, viewFindViewById, view2);
                    }
                });
                return;
            }
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (view2 != null) {
                viewGroup.removeView(view2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1145a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m1146a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0148a.a.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    /* JADX INFO: renamed from: a */
    static boolean m1147a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (m1147a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private int m1148b() {
        if (this.f793P != 0 && this.f795R == 1) {
            return this.f793P;
        }
        return this.f792O;
    }

    /* JADX INFO: renamed from: b */
    private void m1149b(ViewGroup viewGroup) {
        if (this.f791N != null) {
            viewGroup.addView(this.f791N, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f814r.findViewById(C0148a.f.title_template).setVisibility(8);
            return;
        }
        this.f788K = (ImageView) this.f814r.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.f816t)) || !this.f794Q) {
            this.f814r.findViewById(C0148a.f.title_template).setVisibility(8);
            this.f788K.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        this.f789L = (TextView) this.f814r.findViewById(C0148a.f.alertTitle);
        this.f789L.setText(this.f816t);
        if (this.f786I != 0) {
            this.f788K.setImageResource(this.f786I);
        } else if (this.f787J != null) {
            this.f788K.setImageDrawable(this.f787J);
        } else {
            this.f789L.setPadding(this.f788K.getPaddingLeft(), this.f788K.getPaddingTop(), this.f788K.getPaddingRight(), this.f788K.getPaddingBottom());
            this.f788K.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: c */
    private void m1150c() {
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3 = this.f814r.findViewById(C0148a.f.parentPanel);
        View viewFindViewById4 = viewFindViewById3.findViewById(C0148a.f.topPanel);
        View viewFindViewById5 = viewFindViewById3.findViewById(C0148a.f.contentPanel);
        View viewFindViewById6 = viewFindViewById3.findViewById(C0148a.f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(C0148a.f.customPanel);
        m1143a(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(C0148a.f.topPanel);
        View viewFindViewById8 = viewGroup.findViewById(C0148a.f.contentPanel);
        View viewFindViewById9 = viewGroup.findViewById(C0148a.f.buttonPanel);
        ViewGroup viewGroupM1141a = m1141a(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupM1141a2 = m1141a(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupM1141a3 = m1141a(viewFindViewById9, viewFindViewById6);
        m1151c(viewGroupM1141a2);
        m1152d(viewGroupM1141a3);
        m1149b(viewGroupM1141a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (viewGroupM1141a == null || viewGroupM1141a.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (viewGroupM1141a3 == null || viewGroupM1141a3.getVisibility() == 8) ? false : true;
        if (!z3 && viewGroupM1141a2 != null && (viewFindViewById2 = viewGroupM1141a2.findViewById(C0148a.f.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            if (this.f805i != null) {
                this.f805i.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f817u == null && this.f798b == null) ? null : viewGroupM1141a.findViewById(C0148a.f.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupM1141a2 != null && (viewFindViewById = viewGroupM1141a2.findViewById(C0148a.f.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (this.f798b instanceof RecycleListView) {
            ((RecycleListView) this.f798b).m1166a(z2, z3);
        }
        if (!z) {
            View view = this.f798b != null ? this.f798b : this.f805i;
            if (view != null) {
                m1144a(viewGroupM1141a2, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView = this.f798b;
        if (listView == null || this.f806j == null) {
            return;
        }
        listView.setAdapter(this.f806j);
        int i = this.f807k;
        if (i > -1) {
            listView.setItemChecked(i, true);
            listView.setSelection(i);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m1151c(ViewGroup viewGroup) {
        this.f805i = (NestedScrollView) this.f814r.findViewById(C0148a.f.scrollView);
        this.f805i.setFocusable(false);
        this.f805i.setNestedScrollingEnabled(false);
        this.f790M = (TextView) viewGroup.findViewById(R.id.message);
        if (this.f790M == null) {
            return;
        }
        if (this.f817u != null) {
            this.f790M.setText(this.f817u);
            return;
        }
        this.f790M.setVisibility(8);
        this.f805i.removeView(this.f790M);
        if (this.f798b == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.f805i.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.f805i);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f798b, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    /* JADX INFO: renamed from: d */
    private void m1152d(ViewGroup viewGroup) {
        int i;
        Button button;
        this.f799c = (Button) viewGroup.findViewById(R.id.button1);
        this.f799c.setOnClickListener(this.f796S);
        if (TextUtils.isEmpty(this.f780C) && this.f781D == null) {
            this.f799c.setVisibility(8);
            i = 0;
        } else {
            this.f799c.setText(this.f780C);
            if (this.f781D != null) {
                this.f781D.setBounds(0, 0, this.f815s, this.f815s);
                this.f799c.setCompoundDrawables(this.f781D, null, null, null);
            }
            this.f799c.setVisibility(0);
            i = 1;
        }
        this.f801e = (Button) viewGroup.findViewById(R.id.button2);
        this.f801e.setOnClickListener(this.f796S);
        if (TextUtils.isEmpty(this.f782E) && this.f783F == null) {
            this.f801e.setVisibility(8);
        } else {
            this.f801e.setText(this.f782E);
            if (this.f783F != null) {
                this.f783F.setBounds(0, 0, this.f815s, this.f815s);
                this.f801e.setCompoundDrawables(this.f783F, null, null, null);
            }
            this.f801e.setVisibility(0);
            i |= 2;
        }
        this.f803g = (Button) viewGroup.findViewById(R.id.button3);
        this.f803g.setOnClickListener(this.f796S);
        if (TextUtils.isEmpty(this.f784G) && this.f785H == null) {
            this.f803g.setVisibility(8);
        } else {
            this.f803g.setText(this.f784G);
            if (this.f781D != null) {
                this.f781D.setBounds(0, 0, this.f815s, this.f815s);
                this.f799c.setCompoundDrawables(this.f781D, null, null, null);
            }
            this.f803g.setVisibility(0);
            i |= 4;
        }
        if (m1146a(this.f813q)) {
            if (i == 1) {
                button = this.f799c;
            } else if (i == 2) {
                button = this.f801e;
            } else if (i == 4) {
                button = this.f803g;
            }
            m1145a(button);
        }
        if (i != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    /* JADX INFO: renamed from: a */
    public void m1153a() {
        this.f797a.setContentView(m1148b());
        m1150c();
    }

    /* JADX INFO: renamed from: a */
    public void m1154a(int i) {
        this.f818v = null;
        this.f819w = i;
        this.f779B = false;
    }

    /* JADX INFO: renamed from: a */
    public void m1155a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.f812p.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f784G = charSequence;
                this.f804h = message;
                this.f785H = drawable;
                return;
            case -2:
                this.f782E = charSequence;
                this.f802f = message;
                this.f783F = drawable;
                return;
            case -1:
                this.f780C = charSequence;
                this.f800d = message;
                this.f781D = drawable;
                return;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1156a(Drawable drawable) {
        this.f787J = drawable;
        this.f786I = 0;
        if (this.f788K != null) {
            if (drawable == null) {
                this.f788K.setVisibility(8);
            } else {
                this.f788K.setVisibility(0);
                this.f788K.setImageDrawable(drawable);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1157a(View view, int i, int i2, int i3, int i4) {
        this.f818v = view;
        this.f819w = 0;
        this.f779B = true;
        this.f820x = i;
        this.f821y = i2;
        this.f822z = i3;
        this.f778A = i4;
    }

    /* JADX INFO: renamed from: a */
    public void m1158a(CharSequence charSequence) {
        this.f816t = charSequence;
        if (this.f789L != null) {
            this.f789L.setText(charSequence);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m1159a(int i, KeyEvent keyEvent) {
        return this.f805i != null && this.f805i.m1062a(keyEvent);
    }

    /* JADX INFO: renamed from: b */
    public void m1160b(int i) {
        this.f787J = null;
        this.f786I = i;
        if (this.f788K != null) {
            if (i == 0) {
                this.f788K.setVisibility(8);
            } else {
                this.f788K.setVisibility(0);
                this.f788K.setImageResource(this.f786I);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1161b(View view) {
        this.f791N = view;
    }

    /* JADX INFO: renamed from: b */
    public void m1162b(CharSequence charSequence) {
        this.f817u = charSequence;
        if (this.f790M != null) {
            this.f790M.setText(charSequence);
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m1163b(int i, KeyEvent keyEvent) {
        return this.f805i != null && this.f805i.m1062a(keyEvent);
    }

    /* JADX INFO: renamed from: c */
    public int m1164c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f813q.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    /* JADX INFO: renamed from: c */
    public void m1165c(View view) {
        this.f818v = view;
        this.f819w = 0;
        this.f779B = false;
    }
}
