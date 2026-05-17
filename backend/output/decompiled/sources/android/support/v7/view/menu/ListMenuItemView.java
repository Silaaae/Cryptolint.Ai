package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p015g.C0124p;
import android.support.v7.p018a.C0148a;
import android.support.v7.view.menu.InterfaceC0204p;
import android.support.v7.widget.C0263aw;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements InterfaceC0204p.a {

    /* JADX INFO: renamed from: a */
    private C0198j f1171a;

    /* JADX INFO: renamed from: b */
    private ImageView f1172b;

    /* JADX INFO: renamed from: c */
    private RadioButton f1173c;

    /* JADX INFO: renamed from: d */
    private TextView f1174d;

    /* JADX INFO: renamed from: e */
    private CheckBox f1175e;

    /* JADX INFO: renamed from: f */
    private TextView f1176f;

    /* JADX INFO: renamed from: g */
    private ImageView f1177g;

    /* JADX INFO: renamed from: h */
    private Drawable f1178h;

    /* JADX INFO: renamed from: i */
    private int f1179i;

    /* JADX INFO: renamed from: j */
    private Context f1180j;

    /* JADX INFO: renamed from: k */
    private boolean f1181k;

    /* JADX INFO: renamed from: l */
    private Drawable f1182l;

    /* JADX INFO: renamed from: m */
    private int f1183m;

    /* JADX INFO: renamed from: n */
    private LayoutInflater f1184n;

    /* JADX INFO: renamed from: o */
    private boolean f1185o;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0148a.a.listMenuViewStyle);
    }

    public ListMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        C0263aw c0263awM1978a = C0263aw.m1978a(getContext(), attributeSet, C0148a.j.MenuView, i, 0);
        this.f1178h = c0263awM1978a.m1982a(C0148a.j.MenuView_android_itemBackground);
        this.f1179i = c0263awM1978a.m1995g(C0148a.j.MenuView_android_itemTextAppearance, -1);
        this.f1181k = c0263awM1978a.m1984a(C0148a.j.MenuView_preserveIconSpacing, false);
        this.f1180j = context;
        this.f1182l = c0263awM1978a.m1982a(C0148a.j.MenuView_subMenuArrow);
        c0263awM1978a.m1983a();
    }

    /* JADX INFO: renamed from: b */
    private void m1457b() {
        this.f1172b = (ImageView) getInflater().inflate(C0148a.g.abc_list_menu_item_icon, (ViewGroup) this, false);
        addView(this.f1172b, 0);
    }

    /* JADX INFO: renamed from: c */
    private void m1458c() {
        this.f1173c = (RadioButton) getInflater().inflate(C0148a.g.abc_list_menu_item_radio, (ViewGroup) this, false);
        addView(this.f1173c);
    }

    /* JADX INFO: renamed from: d */
    private void m1459d() {
        this.f1175e = (CheckBox) getInflater().inflate(C0148a.g.abc_list_menu_item_checkbox, (ViewGroup) this, false);
        addView(this.f1175e);
    }

    private LayoutInflater getInflater() {
        if (this.f1184n == null) {
            this.f1184n = LayoutInflater.from(getContext());
        }
        return this.f1184n;
    }

    private void setSubMenuArrowVisible(boolean z) {
        if (this.f1177g != null) {
            this.f1177g.setVisibility(z ? 0 : 8);
        }
    }

    @Override // android.support.v7.view.menu.InterfaceC0204p.a
    /* JADX INFO: renamed from: a */
    public void mo1447a(C0198j c0198j, int i) {
        this.f1171a = c0198j;
        this.f1183m = i;
        setVisibility(c0198j.isVisible() ? 0 : 8);
        setTitle(c0198j.m1581a((InterfaceC0204p.a) this));
        setCheckable(c0198j.isCheckable());
        m1460a(c0198j.m1594f(), c0198j.m1590d());
        setIcon(c0198j.getIcon());
        setEnabled(c0198j.isEnabled());
        setSubMenuArrowVisible(c0198j.hasSubMenu());
        setContentDescription(c0198j.getContentDescription());
    }

    /* JADX INFO: renamed from: a */
    public void m1460a(boolean z, char c) {
        int i = (z && this.f1171a.m1594f()) ? 0 : 8;
        if (i == 0) {
            this.f1176f.setText(this.f1171a.m1592e());
        }
        if (this.f1176f.getVisibility() != i) {
            this.f1176f.setVisibility(i);
        }
    }

    @Override // android.support.v7.view.menu.InterfaceC0204p.a
    /* JADX INFO: renamed from: a */
    public boolean mo1448a() {
        return false;
    }

    @Override // android.support.v7.view.menu.InterfaceC0204p.a
    public C0198j getItemData() {
        return this.f1171a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        C0124p.m954a(this, this.f1178h);
        this.f1174d = (TextView) findViewById(C0148a.f.title);
        if (this.f1179i != -1) {
            this.f1174d.setTextAppearance(this.f1180j, this.f1179i);
        }
        this.f1176f = (TextView) findViewById(C0148a.f.shortcut);
        this.f1177g = (ImageView) findViewById(C0148a.f.submenuarrow);
        if (this.f1177g != null) {
            this.f1177g.setImageDrawable(this.f1182l);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.f1172b != null && this.f1181k) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f1172b.getLayoutParams();
            if (layoutParams.height > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = layoutParams.height;
            }
        }
        super.onMeasure(i, i2);
    }

    public void setCheckable(boolean z) {
        CompoundButton compoundButton;
        CompoundButton compoundButton2;
        if (!z && this.f1173c == null && this.f1175e == null) {
            return;
        }
        if (this.f1171a.m1595g()) {
            if (this.f1173c == null) {
                m1458c();
            }
            compoundButton = this.f1173c;
            compoundButton2 = this.f1175e;
        } else {
            if (this.f1175e == null) {
                m1459d();
            }
            compoundButton = this.f1175e;
            compoundButton2 = this.f1173c;
        }
        if (!z) {
            if (this.f1175e != null) {
                this.f1175e.setVisibility(8);
            }
            if (this.f1173c != null) {
                this.f1173c.setVisibility(8);
                return;
            }
            return;
        }
        compoundButton.setChecked(this.f1171a.isChecked());
        int i = z ? 0 : 8;
        if (compoundButton.getVisibility() != i) {
            compoundButton.setVisibility(i);
        }
        if (compoundButton2 == null || compoundButton2.getVisibility() == 8) {
            return;
        }
        compoundButton2.setVisibility(8);
    }

    public void setChecked(boolean z) {
        CompoundButton compoundButton;
        if (this.f1171a.m1595g()) {
            if (this.f1173c == null) {
                m1458c();
            }
            compoundButton = this.f1173c;
        } else {
            if (this.f1175e == null) {
                m1459d();
            }
            compoundButton = this.f1175e;
        }
        compoundButton.setChecked(z);
    }

    public void setForceShowIcon(boolean z) {
        this.f1185o = z;
        this.f1181k = z;
    }

    public void setIcon(Drawable drawable) {
        boolean z = this.f1171a.m1597i() || this.f1185o;
        if (z || this.f1181k) {
            if (this.f1172b == null && drawable == null && !this.f1181k) {
                return;
            }
            if (this.f1172b == null) {
                m1457b();
            }
            if (drawable == null && !this.f1181k) {
                this.f1172b.setVisibility(8);
                return;
            }
            ImageView imageView = this.f1172b;
            if (!z) {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            if (this.f1172b.getVisibility() != 0) {
                this.f1172b.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        int i;
        TextView textView;
        if (charSequence != null) {
            this.f1174d.setText(charSequence);
            if (this.f1174d.getVisibility() == 0) {
                return;
            }
            textView = this.f1174d;
            i = 0;
        } else {
            i = 8;
            if (this.f1174d.getVisibility() == 8) {
                return;
            } else {
                textView = this.f1174d;
            }
        }
        textView.setVisibility(i);
    }
}
