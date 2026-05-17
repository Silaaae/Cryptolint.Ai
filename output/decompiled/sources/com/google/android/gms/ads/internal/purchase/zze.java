package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzfe;
import com.google.android.gms.internal.zzfg;
import com.google.android.gms.internal.zzgd;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public class zze extends zzfg.zza implements ServiceConnection {
    private final Activity mActivity;
    private zzb zzAE;
    zzh zzAF;
    private zzk zzAH;
    private Context zzAM;
    private zzfe zzAN;
    private zzf zzAO;
    private zzj zzAP;
    private String zzAQ = null;

    public zze(Activity activity) {
        this.mActivity = activity;
        this.zzAF = zzh.zzy(this.mActivity.getApplicationContext());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037 A[Catch: RemoteException -> 0x003f, all -> 0x004d, Merged into TryCatch #1 {all -> 0x004d, RemoteException -> 0x003f, blocks: (B:5:0x0006, B:7:0x0011, B:9:0x0016, B:12:0x0021, B:15:0x0037, B:18:0x0040), top: B:23:0x0006 }, TRY_ENTER, TRY_LEAVE] */
    @Override // com.google.android.gms.internal.zzfg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1001) {
            boolean z = false;
            try {
                int iZzd = zzo.zzbF().zzd(data);
                if (resultCode == -1) {
                    zzo.zzbF();
                    if (iZzd != 0) {
                        this.zzAF.zza(this.zzAO);
                    } else if (this.zzAH.zza(this.zzAQ, resultCode, data)) {
                        z = true;
                    }
                }
                this.zzAN.recordPlayBillingResolution(iZzd);
                this.mActivity.finish();
                zza(this.zzAN.getProductId(), z, resultCode, data);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Fail to process purchase result.");
                this.mActivity.finish();
            } finally {
                this.zzAQ = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzfg
    public void onCreate() {
        GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcelZzc = GInAppPurchaseManagerInfoParcel.zzc(this.mActivity.getIntent());
        this.zzAP = gInAppPurchaseManagerInfoParcelZzc.zzAA;
        this.zzAH = gInAppPurchaseManagerInfoParcelZzc.zzqe;
        this.zzAN = gInAppPurchaseManagerInfoParcelZzc.zzAy;
        this.zzAE = new zzb(this.mActivity.getApplicationContext());
        this.zzAM = gInAppPurchaseManagerInfoParcelZzc.zzAz;
        if (this.mActivity.getResources().getConfiguration().orientation == 2) {
            this.mActivity.setRequestedOrientation(zzo.zzbx().zzgq());
        } else {
            this.mActivity.setRequestedOrientation(zzo.zzbx().zzgr());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        this.mActivity.bindService(intent, this, 1);
    }

    @Override // com.google.android.gms.internal.zzfg
    public void onDestroy() {
        this.mActivity.unbindService(this);
        this.zzAE.destroy();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        this.zzAE.zzK(service);
        try {
            this.zzAQ = this.zzAH.zzfi();
            Bundle bundleZzb = this.zzAE.zzb(this.mActivity.getPackageName(), this.zzAN.getProductId(), this.zzAQ);
            PendingIntent pendingIntent = (PendingIntent) bundleZzb.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int iZzb = zzo.zzbF().zzb(bundleZzb);
                this.zzAN.recordPlayBillingResolution(iZzb);
                zza(this.zzAN.getProductId(), false, iZzb, null);
                this.mActivity.finish();
            } else {
                this.zzAO = new zzf(this.zzAN.getProductId(), this.zzAQ);
                this.zzAF.zzb(this.zzAO);
                Integer num = 0;
                Integer num2 = 0;
                Integer num3 = 0;
                this.mActivity.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), num.intValue(), num2.intValue(), num3.intValue());
            }
        } catch (IntentSender.SendIntentException | RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Error when connecting in-app billing service", e);
            this.mActivity.finish();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaA("In-app billing service disconnected.");
        this.zzAE.destroy();
    }

    protected void zza(String str, boolean z, int i, Intent intent) {
        if (this.zzAP != null) {
            this.zzAP.zza(str, z, i, intent, this.zzAO);
        }
    }
}
