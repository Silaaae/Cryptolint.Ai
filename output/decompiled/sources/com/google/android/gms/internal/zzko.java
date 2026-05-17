package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;

/* JADX INFO: loaded from: classes.dex */
abstract class zzko<R extends Result> extends zza.AbstractC1172zza<R, zzkp> {

    static abstract class zza extends zzko<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    public zzko(GoogleApiClient googleApiClient) {
        super(zzkl.zzNX, googleApiClient);
    }
}
