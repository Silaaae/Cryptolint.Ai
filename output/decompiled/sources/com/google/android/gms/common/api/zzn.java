package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzu;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class zzn extends Fragment implements DialogInterface.OnCancelListener, LoaderManager.LoaderCallbacks<ConnectionResult> {
    private boolean zzXV;
    private ConnectionResult zzXX;
    private int zzXW = -1;
    private final Handler zzXY = new Handler(Looper.getMainLooper());
    private final SparseArray<zzb> zzXZ = new SparseArray<>();

    static class zza extends Loader<ConnectionResult> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        public final GoogleApiClient zzYb;
        private boolean zzYg;
        private ConnectionResult zzYh;

        public zza(Context context, GoogleApiClient googleApiClient) {
            super(context);
            this.zzYb = googleApiClient;
        }

        private void zzf(ConnectionResult connectionResult) {
            this.zzYh = connectionResult;
            if (!isStarted() || isAbandoned()) {
                return;
            }
            deliverResult(connectionResult);
        }

        @Override // android.support.v4.content.Loader
        public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            super.dump(prefix, fd, writer, args);
            this.zzYb.dump(prefix, fd, writer, args);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnected(Bundle connectionHint) {
            this.zzYg = false;
            zzf(ConnectionResult.zzVG);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(ConnectionResult result) {
            this.zzYg = true;
            zzf(result);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int cause) {
        }

        @Override // android.support.v4.content.Loader
        protected void onReset() {
            this.zzYh = null;
            this.zzYg = false;
            this.zzYb.unregisterConnectionCallbacks(this);
            this.zzYb.unregisterConnectionFailedListener(this);
            this.zzYb.disconnect();
        }

        @Override // android.support.v4.content.Loader
        protected void onStartLoading() {
            super.onStartLoading();
            this.zzYb.registerConnectionCallbacks(this);
            this.zzYb.registerConnectionFailedListener(this);
            if (this.zzYh != null) {
                deliverResult(this.zzYh);
            }
            if (this.zzYb.isConnected() || this.zzYb.isConnecting() || this.zzYg) {
                return;
            }
            this.zzYb.connect();
        }

        @Override // android.support.v4.content.Loader
        protected void onStopLoading() {
            this.zzYb.disconnect();
        }

        public boolean zzmX() {
            return this.zzYg;
        }
    }

    private static class zzb {
        public final GoogleApiClient zzYb;
        public final GoogleApiClient.OnConnectionFailedListener zzYc;

        private zzb(GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zzYb = googleApiClient;
            this.zzYc = onConnectionFailedListener;
        }
    }

    private class zzc implements Runnable {
        private final int zzYe;
        private final ConnectionResult zzYf;

        public zzc(int i, ConnectionResult connectionResult) {
            this.zzYe = i;
            this.zzYf = connectionResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.zzYf.hasResolution()) {
                try {
                    this.zzYf.startResolutionForResult(zzn.this.getActivity(), ((zzn.this.getActivity().getSupportFragmentManager().getFragments().indexOf(zzn.this) + 1) << 16) + 1);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    zzn.this.zzmV();
                    return;
                }
            }
            if (GooglePlayServicesUtil.isUserRecoverableError(this.zzYf.getErrorCode())) {
                GooglePlayServicesUtil.showErrorDialogFragment(this.zzYf.getErrorCode(), zzn.this.getActivity(), zzn.this, 2, zzn.this);
            } else {
                zzn.this.zza(this.zzYe, this.zzYf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLoaderLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        zzb zzbVar = this.zzXZ.get(i);
        if (zzbVar != null) {
            zzbb(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zzbVar.zzYc;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        zzmV();
    }

    public static zzn zzb(FragmentActivity fragmentActivity) {
        zzu.zzbY("Must be called from main thread of process");
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            zzn zznVar = (zzn) supportFragmentManager.findFragmentByTag("GmsSupportLoaderLifecycleFragment");
            if (zznVar != null && !zznVar.isRemoving()) {
                return zznVar;
            }
            zzn zznVar2 = new zzn();
            supportFragmentManager.beginTransaction().add(zznVar2, "GmsSupportLoaderLifecycleFragment").commit();
            supportFragmentManager.executePendingTransactions();
            return zznVar2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", e);
        }
    }

    private void zzb(int i, ConnectionResult connectionResult) {
        if (this.zzXV) {
            return;
        }
        this.zzXV = true;
        this.zzXW = i;
        this.zzXX = connectionResult;
        this.zzXY.post(new zzc(i, connectionResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzmV() {
        this.zzXV = false;
        this.zzXW = -1;
        this.zzXX = null;
        LoaderManager loaderManager = getLoaderManager();
        for (int i = 0; i < this.zzXZ.size(); i++) {
            int iKeyAt = this.zzXZ.keyAt(i);
            zza zzaVarZzbd = zzbd(iKeyAt);
            if (zzaVarZzbd != null && zzaVarZzbd.zzmX()) {
                loaderManager.destroyLoader(iKeyAt);
                loaderManager.initLoader(iKeyAt, null, this);
            }
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

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzXZ.size()) {
                return;
            }
            int iKeyAt = this.zzXZ.keyAt(i2);
            zza zzaVarZzbd = zzbd(iKeyAt);
            if (zzaVarZzbd == null || this.zzXZ.valueAt(i2).zzYb == zzaVarZzbd.zzYb) {
                getLoaderManager().initLoader(iKeyAt, null, this);
            } else {
                getLoaderManager().restartLoader(iKeyAt, null, this);
            }
            i = i2 + 1;
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

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public Loader<ConnectionResult> onCreateLoader(int id, Bundle args) {
        return new zza(getActivity(), this.zzXZ.get(id).zzYb);
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    public void onLoaderReset(Loader<ConnectionResult> loader) {
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
        if (this.zzXV) {
            return;
        }
        for (int i = 0; i < this.zzXZ.size(); i++) {
            getLoaderManager().initLoader(this.zzXZ.keyAt(i), null, this);
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzu.zzb(googleApiClient, "GoogleApiClient instance cannot be null");
        zzu.zza(this.zzXZ.indexOfKey(i) < 0, "Already managing a GoogleApiClient with id " + i);
        this.zzXZ.put(i, new zzb(googleApiClient, onConnectionFailedListener));
        if (getActivity() != null) {
            LoaderManager.enableDebugLogging(false);
            getLoaderManager().initLoader(i, null, this);
        }
    }

    @Override // android.support.v4.app.LoaderManager.LoaderCallbacks
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public void onLoadFinished(Loader<ConnectionResult> loader, ConnectionResult connectionResult) {
        if (connectionResult.isSuccess()) {
            return;
        }
        zzb(loader.getId(), connectionResult);
    }

    public void zzbb(int i) {
        this.zzXZ.remove(i);
        getLoaderManager().destroyLoader(i);
    }

    public GoogleApiClient zzbc(int i) {
        zza zzaVarZzbd;
        if (getActivity() == null || (zzaVarZzbd = zzbd(i)) == null) {
            return null;
        }
        return zzaVarZzbd.zzYb;
    }

    zza zzbd(int i) {
        try {
            return (zza) getLoaderManager().getLoader(i);
        } catch (ClassCastException e) {
            throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", e);
        }
    }
}
