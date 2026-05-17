package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzu;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class zzm extends Fragment implements DialogInterface.OnCancelListener {
    private boolean mStarted;
    private boolean zzXV;
    private ConnectionResult zzXX;
    private int zzXW = -1;
    private final Handler zzXY = new Handler(Looper.getMainLooper());
    private final SparseArray<zza> zzXZ = new SparseArray<>();

    private class zza implements GoogleApiClient.OnConnectionFailedListener {
        public final int zzYa;
        public final GoogleApiClient zzYb;
        public final GoogleApiClient.OnConnectionFailedListener zzYc;

        public zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zzYa = i;
            this.zzYb = googleApiClient;
            this.zzYc = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            writer.append((CharSequence) prefix).append("GoogleApiClient #").print(this.zzYa);
            writer.println(":");
            this.zzYb.dump(prefix + "  ", fd, writer, args);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult result) {
            zzm.this.zzXY.post(zzm.this.new zzb(this.zzYa, result));
        }

        public void zzmW() {
            this.zzYb.unregisterConnectionFailedListener(this);
            this.zzYb.disconnect();
        }
    }

    private class zzb implements Runnable {
        private final int zzYe;
        private final ConnectionResult zzYf;

        public zzb(int i, ConnectionResult connectionResult) {
            this.zzYe = i;
            this.zzYf = connectionResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!zzm.this.mStarted || zzm.this.zzXV) {
                return;
            }
            zzm.this.zzXV = true;
            zzm.this.zzXW = this.zzYe;
            zzm.this.zzXX = this.zzYf;
            if (this.zzYf.hasResolution()) {
                try {
                    this.zzYf.startResolutionForResult(zzm.this.getActivity(), ((zzm.this.getActivity().getSupportFragmentManager().getFragments().indexOf(zzm.this) + 1) << 16) + 1);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    zzm.this.zzmV();
                    return;
                }
            }
            if (GooglePlayServicesUtil.isUserRecoverableError(this.zzYf.getErrorCode())) {
                GooglePlayServicesUtil.showErrorDialogFragment(this.zzYf.getErrorCode(), zzm.this.getActivity(), zzm.this, 2, zzm.this);
            } else {
                zzm.this.zza(this.zzYe, this.zzYf);
            }
        }
    }

    public static zzm zza(FragmentActivity fragmentActivity) {
        zzu.zzbY("Must be called from main thread of process");
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            zzm zzmVar = (zzm) supportFragmentManager.findFragmentByTag("GmsSupportLifecycleFragment");
            if (zzmVar != null && !zzmVar.isRemoving()) {
                return zzmVar;
            }
            zzm zzmVar2 = new zzm();
            supportFragmentManager.beginTransaction().add(zzmVar2, "GmsSupportLifecycleFragment").commit();
            supportFragmentManager.executePendingTransactions();
            return zzmVar2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        zza zzaVar = this.zzXZ.get(i);
        if (zzaVar != null) {
            zzbb(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zzaVar.zzYc;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        zzmV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzmV() {
        int i = 0;
        this.zzXV = false;
        this.zzXW = -1;
        this.zzXX = null;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzXZ.size()) {
                return;
            }
            this.zzXZ.valueAt(i2).zzYb.connect();
            i = i2 + 1;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzXZ.size()) {
                return;
            }
            this.zzXZ.valueAt(i2).dump(prefix, fd, writer, args);
            i = i2 + 1;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        boolean z = true;
        switch (requestCode) {
            case 1:
                if (resultCode != -1) {
                    z = false;
                }
                break;
            case 2:
                if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) != 0) {
                    z = false;
                }
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            zzmV();
        } else {
            zza(this.zzXW, this.zzXX);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        zza(this.zzXW, new ConnectionResult(13, null));
    }

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.zzXV = savedInstanceState.getBoolean("resolving_error", false);
            this.zzXW = savedInstanceState.getInt("failed_client_id", -1);
            if (this.zzXW >= 0) {
                this.zzXX = new ConnectionResult(savedInstanceState.getInt("failed_status"), (PendingIntent) savedInstanceState.getParcelable("failed_resolution"));
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("resolving_error", this.zzXV);
        if (this.zzXW >= 0) {
            outState.putInt("failed_client_id", this.zzXW);
            outState.putInt("failed_status", this.zzXX.getErrorCode());
            outState.putParcelable("failed_resolution", this.zzXX.getResolution());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.mStarted = true;
        if (this.zzXV) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzXZ.size()) {
                return;
            }
            this.zzXZ.valueAt(i2).zzYb.connect();
            i = i2 + 1;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        int i = 0;
        super.onStop();
        this.mStarted = false;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzXZ.size()) {
                return;
            }
            this.zzXZ.valueAt(i2).zzYb.disconnect();
            i = i2 + 1;
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzu.zzb(googleApiClient, "GoogleApiClient instance cannot be null");
        zzu.zza(this.zzXZ.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        this.zzXZ.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (!this.mStarted || this.zzXV) {
            return;
        }
        googleApiClient.connect();
    }

    public void zzbb(int i) {
        zza zzaVar = this.zzXZ.get(i);
        this.zzXZ.remove(i);
        if (zzaVar != null) {
            zzaVar.zzmW();
        }
    }
}
