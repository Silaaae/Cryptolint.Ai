package com.google.android.gms.internal;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zzbk extends Thread {
    private final zzbj zzrw;
    private final zzbi zzrx;
    private final zzgc zzry;
    private boolean mStarted = false;
    private boolean zzrv = false;
    private boolean zzam = false;
    private final Object zzqt = new Object();
    private final int zzrj = zzbz.zzud.get().intValue();
    private final int zzrA = zzbz.zzue.get().intValue();
    private final int zzrl = zzbz.zzuf.get().intValue();
    private final int zzrB = zzbz.zzug.get().intValue();
    private final int zzrz = zzbz.zzuh.get().intValue();

    @zzgd
    class zza {
        final int zzrI;
        final int zzrJ;

        zza(int i, int i2) {
            this.zzrI = i;
            this.zzrJ = i2;
        }
    }

    public zzbk(zzbj zzbjVar, zzbi zzbiVar, zzgc zzgcVar) {
        this.zzrw = zzbjVar;
        this.zzrx = zzbiVar;
        this.zzry = zzgcVar;
        setName("ContentFetchTask");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        while (!this.zzam) {
            try {
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzb.zzb("Error in ContentFetchTask", th);
                this.zzry.zza(th, true);
            }
            if (zzcq()) {
                Activity activity = this.zzrw.getActivity();
                if (activity == null) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzay("ContentFetchThread: no activity");
                } else {
                    zza(activity);
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.zzay("ContentFetchTask: sleeping");
                zzcs();
            }
            Thread.sleep(this.zzrz * 1000);
            synchronized (this.zzqt) {
                while (this.zzrv) {
                    try {
                        com.google.android.gms.ads.internal.util.client.zzb.zzay("ContentFetchTask: waiting");
                        this.zzqt.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.zzqt) {
            this.zzrv = false;
            this.zzqt.notifyAll();
            com.google.android.gms.ads.internal.util.client.zzb.zzay("ContentFetchThread: wakeup");
        }
    }

    zza zza(View view, zzbh zzbhVar) {
        if (view == null) {
            return new zza(0, 0);
        }
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zza(0, 0);
            }
            zzbhVar.zzv(text.toString());
            return new zza(1, 0);
        }
        if ((view instanceof WebView) && !(view instanceof zzid)) {
            zzbhVar.zzcl();
            return zza((WebView) view, zzbhVar) ? new zza(0, 1) : new zza(0, 0);
        }
        if (!(view instanceof ViewGroup)) {
            return new zza(0, 0);
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            zza zzaVarZza = zza(viewGroup.getChildAt(i3), zzbhVar);
            i2 += zzaVarZza.zzrI;
            i += zzaVarZza.zzrJ;
        }
        return new zza(i2, i);
    }

    void zza(Activity activity) {
        if (activity == null) {
            return;
        }
        View viewFindViewById = null;
        if (activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            viewFindViewById = activity.getWindow().getDecorView().findViewById(R.id.content);
        }
        if (viewFindViewById != null) {
            zzf(viewFindViewById);
        }
    }

    void zza(zzbh zzbhVar, WebView webView, String str) {
        zzbhVar.zzck();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString("text");
                if (TextUtils.isEmpty(webView.getTitle())) {
                    zzbhVar.zzu(strOptString);
                } else {
                    zzbhVar.zzu(webView.getTitle() + "\n" + strOptString);
                }
            }
            if (zzbhVar.zzch()) {
                this.zzrx.zzb(zzbhVar);
            }
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzay("Json string may be malformed.");
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zza("Failed to get webview content.", th);
            this.zzry.zza(th, true);
        }
    }

    boolean zza(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    boolean zza(final WebView webView, final zzbh zzbhVar) {
        if (!zzlk.zzoX()) {
            return false;
        }
        zzbhVar.zzcl();
        webView.post(new Runnable() { // from class: com.google.android.gms.internal.zzbk.2
            ValueCallback<String> zzrE = new ValueCallback<String>() { // from class: com.google.android.gms.internal.zzbk.2.1
                @Override // android.webkit.ValueCallback
                /* JADX INFO: renamed from: zzx, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(String str) {
                    zzbk.this.zza(zzbhVar, webView, str);
                }
            };

            @Override // java.lang.Runnable
            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzrE);
                    } catch (Throwable th) {
                        this.zzrE.onReceiveValue("");
                    }
                }
            }
        });
        return true;
    }

    public void zzcp() {
        synchronized (this.zzqt) {
            if (this.mStarted) {
                com.google.android.gms.ads.internal.util.client.zzb.zzay("Content hash thread already started, quiting...");
            } else {
                this.mStarted = true;
                start();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        if (zza(r0) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
    
        if (r1.inKeyguardRestrictedInputMode() != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
    
        if (zzr(r3) == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0053, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean zzcq() {
        try {
            Context context = this.zzrw.getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (Process.myPid() == next.pid) {
                    break;
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public zzbh zzcr() {
        return this.zzrx.zzco();
    }

    public void zzcs() {
        synchronized (this.zzqt) {
            this.zzrv = true;
            com.google.android.gms.ads.internal.util.client.zzb.zzay("ContentFetchThread: paused, mPause = " + this.zzrv);
        }
    }

    public boolean zzct() {
        return this.zzrv;
    }

    boolean zzf(final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable() { // from class: com.google.android.gms.internal.zzbk.1
            @Override // java.lang.Runnable
            public void run() {
                zzbk.this.zzg(view);
            }
        });
        return true;
    }

    void zzg(View view) {
        try {
            zzbh zzbhVar = new zzbh(this.zzrj, this.zzrA, this.zzrl, this.zzrB);
            zza zzaVarZza = zza(view, zzbhVar);
            zzbhVar.zzcm();
            if (zzaVarZza.zzrI == 0 && zzaVarZza.zzrJ == 0) {
                return;
            }
            if (zzaVarZza.zzrJ == 0 && zzbhVar.zzcn() == 0) {
                return;
            }
            if (zzaVarZza.zzrJ == 0 && this.zzrx.zza(zzbhVar)) {
                return;
            }
            this.zzrx.zzc(zzbhVar);
        } catch (Exception e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Exception in fetchContentOnUIThread", e);
            this.zzry.zza(e, true);
        }
    }

    boolean zzr(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }
}
