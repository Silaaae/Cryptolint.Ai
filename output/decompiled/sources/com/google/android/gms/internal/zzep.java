package com.google.android.gms.internal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzep extends zzeu {
    static final Set<String> zzyu = new HashSet(Arrays.asList("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"));
    private int zznM;
    private int zznN;
    private final zzid zzoA;
    private final Object zzqt;
    private AdSizeParcel zzxT;
    private int zzyA;
    private final Activity zzyB;
    private ImageView zzyC;
    private LinearLayout zzyD;
    private zzev zzyE;
    private PopupWindow zzyF;
    private RelativeLayout zzyG;
    private ViewGroup zzyH;
    private String zzyv;
    private boolean zzyw;
    private int zzyx;
    private int zzyy;
    private int zzyz;

    public zzep(zzid zzidVar, zzev zzevVar) {
        super(zzidVar, "resize");
        this.zzyv = "top-right";
        this.zzyw = true;
        this.zzyx = 0;
        this.zzyy = 0;
        this.zznN = -1;
        this.zzyz = 0;
        this.zzyA = 0;
        this.zznM = -1;
        this.zzqt = new Object();
        this.zzoA = zzidVar;
        this.zzyB = zzidVar.zzgB();
        this.zzyE = zzevVar;
    }

    private int[] zzed() {
        if (!zzef()) {
            return null;
        }
        if (this.zzyw) {
            return new int[]{this.zzyx + this.zzyz, this.zzyy + this.zzyA};
        }
        int[] iArrZzh = com.google.android.gms.ads.internal.zzo.zzbv().zzh(this.zzyB);
        int[] iArrZzj = com.google.android.gms.ads.internal.zzo.zzbv().zzj(this.zzyB);
        int i = iArrZzh[0];
        int i2 = this.zzyx + this.zzyz;
        int i3 = this.zzyy + this.zzyA;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.zznM + i2 > i) {
            i2 = i - this.zznM;
        }
        if (i3 < iArrZzj[0]) {
            i3 = iArrZzj[0];
        } else if (this.zznN + i3 > iArrZzj[1]) {
            i3 = iArrZzj[1] - this.zznN;
        }
        return new int[]{i2, i3};
    }

    private void zzg(Map<String, String> map) {
        if (!TextUtils.isEmpty(map.get("width"))) {
            this.zznM = com.google.android.gms.ads.internal.zzo.zzbv().zzau(map.get("width"));
        }
        if (!TextUtils.isEmpty(map.get("height"))) {
            this.zznN = com.google.android.gms.ads.internal.zzo.zzbv().zzau(map.get("height"));
        }
        if (!TextUtils.isEmpty(map.get("offsetX"))) {
            this.zzyz = com.google.android.gms.ads.internal.zzo.zzbv().zzau(map.get("offsetX"));
        }
        if (!TextUtils.isEmpty(map.get("offsetY"))) {
            this.zzyA = com.google.android.gms.ads.internal.zzo.zzbv().zzau(map.get("offsetY"));
        }
        if (!TextUtils.isEmpty(map.get("allowOffscreen"))) {
            this.zzyw = Boolean.parseBoolean(map.get("allowOffscreen"));
        }
        String str = map.get("customClosePosition");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.zzyv = str;
    }

    public void zza(int i, int i2, boolean z) {
        synchronized (this.zzqt) {
            this.zzyx = i;
            this.zzyy = i2;
            if (this.zzyF != null && z) {
                int[] iArrZzed = zzed();
                if (iArrZzed != null) {
                    this.zzyF.update(com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(this.zzyB, iArrZzed[0]), com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(this.zzyB, iArrZzed[1]), this.zzyF.getWidth(), this.zzyF.getHeight());
                    zzc(iArrZzed[0], iArrZzed[1]);
                } else {
                    zzn(true);
                }
            }
        }
    }

    void zzb(int i, int i2) {
        if (this.zzyE != null) {
            this.zzyE.zza(i, i2, this.zznM, this.zznN);
        }
    }

    void zzc(int i, int i2) {
        zzb(i, i2 - com.google.android.gms.ads.internal.zzo.zzbv().zzj(this.zzyB)[0], this.zznM, this.zznN);
    }

    public void zzd(int i, int i2) {
        this.zzyx = i;
        this.zzyy = i2;
    }

    boolean zzec() {
        return this.zznM > -1 && this.zznN > -1;
    }

    public boolean zzee() {
        boolean z;
        synchronized (this.zzqt) {
            z = this.zzyF != null;
        }
        return z;
    }

    boolean zzef() {
        int i;
        int i2;
        int[] iArrZzh = com.google.android.gms.ads.internal.zzo.zzbv().zzh(this.zzyB);
        int[] iArrZzj = com.google.android.gms.ads.internal.zzo.zzbv().zzj(this.zzyB);
        int i3 = iArrZzh[0];
        int i4 = iArrZzh[1];
        if (this.zznM < 50 || this.zznM > i3) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Width is too small or too large.");
            return false;
        }
        if (this.zznN < 50 || this.zznN > i4) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Height is too small or too large.");
            return false;
        }
        if (this.zznN == i4 && this.zznM == i3) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Cannot resize to a full-screen ad.");
            return false;
        }
        if (this.zzyw) {
            switch (this.zzyv) {
                case "top-left":
                    i = this.zzyz + this.zzyx;
                    i2 = this.zzyy + this.zzyA;
                    break;
                case "top-center":
                    i = ((this.zzyx + this.zzyz) + (this.zznM / 2)) - 25;
                    i2 = this.zzyy + this.zzyA;
                    break;
                case "center":
                    i = ((this.zzyx + this.zzyz) + (this.zznM / 2)) - 25;
                    i2 = ((this.zzyy + this.zzyA) + (this.zznN / 2)) - 25;
                    break;
                case "bottom-left":
                    i = this.zzyz + this.zzyx;
                    i2 = ((this.zzyy + this.zzyA) + this.zznN) - 50;
                    break;
                case "bottom-center":
                    i = ((this.zzyx + this.zzyz) + (this.zznM / 2)) - 25;
                    i2 = ((this.zzyy + this.zzyA) + this.zznN) - 50;
                    break;
                case "bottom-right":
                    i = ((this.zzyx + this.zzyz) + this.zznM) - 50;
                    i2 = ((this.zzyy + this.zzyA) + this.zznN) - 50;
                    break;
                default:
                    i = ((this.zzyx + this.zzyz) + this.zznM) - 50;
                    i2 = this.zzyy + this.zzyA;
                    break;
            }
            if (i < 0 || i + 50 > i3 || i2 < iArrZzj[0] || i2 + 50 > iArrZzj[1]) {
                return false;
            }
        }
        return true;
    }

    public void zzh(Map<String, String> map) {
        RelativeLayout.LayoutParams layoutParams;
        synchronized (this.zzqt) {
            if (this.zzyB == null) {
                zzae("Not an activity context. Cannot resize.");
                return;
            }
            if (this.zzoA.zzaN() == null) {
                zzae("Webview is not yet available, size is not set.");
                return;
            }
            if (this.zzoA.zzaN().zzsn) {
                zzae("Is interstitial. Cannot resize an interstitial.");
                return;
            }
            if (this.zzoA.zzgJ()) {
                zzae("Cannot resize an expanded banner.");
                return;
            }
            zzg(map);
            if (!zzec()) {
                zzae("Invalid width and height options. Cannot resize.");
                return;
            }
            Window window = this.zzyB.getWindow();
            if (window == null || window.getDecorView() == null) {
                zzae("Activity context is not ready, cannot get window or decor view.");
                return;
            }
            int[] iArrZzed = zzed();
            if (iArrZzed == null) {
                zzae("Resize location out of screen or close button is not visible.");
                return;
            }
            int iZzb = com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(this.zzyB, this.zznM);
            int iZzb2 = com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(this.zzyB, this.zznN);
            ViewParent parent = this.zzoA.getWebView().getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                zzae("Webview is detached, probably in the middle of a resize or expand.");
                return;
            }
            ((ViewGroup) parent).removeView(this.zzoA.getWebView());
            if (this.zzyF == null) {
                this.zzyH = (ViewGroup) parent;
                Bitmap bitmapZzj = com.google.android.gms.ads.internal.zzo.zzbv().zzj(this.zzoA.getWebView());
                this.zzyC = new ImageView(this.zzyB);
                this.zzyC.setImageBitmap(bitmapZzj);
                this.zzxT = this.zzoA.zzaN();
                this.zzyH.addView(this.zzyC);
            } else {
                this.zzyF.dismiss();
            }
            this.zzyG = new RelativeLayout(this.zzyB);
            this.zzyG.setBackgroundColor(0);
            this.zzyG.setLayoutParams(new ViewGroup.LayoutParams(iZzb, iZzb2));
            this.zzyF = com.google.android.gms.ads.internal.zzo.zzbv().zza((View) this.zzyG, iZzb, iZzb2, false);
            this.zzyF.setOutsideTouchable(true);
            this.zzyF.setTouchable(true);
            this.zzyF.setClippingEnabled(!this.zzyw);
            this.zzyG.addView(this.zzoA.getWebView(), -1, -1);
            this.zzyD = new LinearLayout(this.zzyB);
            layoutParams = new RelativeLayout.LayoutParams(com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(this.zzyB, 50), com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(this.zzyB, 50));
            switch (this.zzyv) {
                case "top-left":
                    layoutParams.addRule(10);
                    layoutParams.addRule(9);
                    break;
                case "top-center":
                    layoutParams.addRule(10);
                    layoutParams.addRule(14);
                    break;
                case "center":
                    layoutParams.addRule(13);
                    break;
                case "bottom-left":
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    break;
                case "bottom-center":
                    layoutParams.addRule(12);
                    layoutParams.addRule(14);
                    break;
                case "bottom-right":
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    break;
                default:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    break;
            }
            this.zzyD.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.internal.zzep.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    zzep.this.zzn(true);
                }
            });
            this.zzyD.setContentDescription("Close button");
            this.zzyG.addView(this.zzyD, layoutParams);
            try {
                this.zzyF.showAtLocation(window.getDecorView(), 0, com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(this.zzyB, iArrZzed[0]), com.google.android.gms.ads.internal.client.zzk.zzcA().zzb(this.zzyB, iArrZzed[1]));
                zzb(iArrZzed[0], iArrZzed[1]);
                this.zzoA.zza(new AdSizeParcel(this.zzyB, new AdSize(this.zznM, this.zznN)));
                zzc(iArrZzed[0], iArrZzed[1]);
                zzag("resized");
            } catch (RuntimeException e) {
                zzae("Cannot show popup window: " + e.getMessage());
                this.zzyG.removeView(this.zzoA.getWebView());
                if (this.zzyH != null) {
                    this.zzyH.removeView(this.zzyC);
                    this.zzyH.addView(this.zzoA.getWebView());
                    this.zzoA.zza(this.zzxT);
                }
            }
        }
    }

    public void zzn(boolean z) {
        synchronized (this.zzqt) {
            if (this.zzyF != null) {
                this.zzyF.dismiss();
                this.zzyG.removeView(this.zzoA.getWebView());
                if (this.zzyH != null) {
                    this.zzyH.removeView(this.zzyC);
                    this.zzyH.addView(this.zzoA.getWebView());
                    this.zzoA.zza(this.zzxT);
                }
                if (z) {
                    zzag("default");
                    if (this.zzyE != null) {
                        this.zzyE.zzbc();
                    }
                }
                this.zzyF = null;
                this.zzyG = null;
                this.zzyH = null;
                this.zzyD = null;
            }
        }
    }
}
