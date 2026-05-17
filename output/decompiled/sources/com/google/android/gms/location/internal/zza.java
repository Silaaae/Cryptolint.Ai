package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionApi;

/* JADX INFO: loaded from: classes.dex */
public class zza implements ActivityRecognitionApi {

    /* JADX INFO: renamed from: com.google.android.gms.location.internal.zza$zza, reason: collision with other inner class name */
    private static abstract class AbstractC1299zza extends ActivityRecognition.zza<Status> {
        public AbstractC1299zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.location.ActivityRecognitionApi
    public PendingResult<Status> removeActivityUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.zzb(new AbstractC1299zza(client) { // from class: com.google.android.gms.location.internal.zza.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
            public void zza(zzj zzjVar) throws RemoteException {
                zzjVar.zza(callbackIntent);
                setResult(Status.zzXP);
            }
        });
    }

    @Override // com.google.android.gms.location.ActivityRecognitionApi
    public PendingResult<Status> requestActivityUpdates(GoogleApiClient client, final long detectionIntervalMillis, final PendingIntent callbackIntent) {
        return client.zzb(new AbstractC1299zza(client) { // from class: com.google.android.gms.location.internal.zza.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
            public void zza(zzj zzjVar) throws RemoteException {
                zzjVar.zza(detectionIntervalMillis, callbackIntent);
                setResult(Status.zzXP);
            }
        });
    }
}
