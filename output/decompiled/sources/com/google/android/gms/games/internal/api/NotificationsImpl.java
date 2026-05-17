package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.internal.GamesClientImpl;

/* JADX INFO: loaded from: classes.dex */
public final class NotificationsImpl implements Notifications {

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$1 */
    class C06451 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusChangeResult> {
        final /* synthetic */ String zzarm;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zza.zzb<Notifications.GameMuteStatusChangeResult>) this, this.zzarm, true);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* JADX INFO: renamed from: zzaf, reason: merged with bridge method [inline-methods] */
        public Notifications.GameMuteStatusChangeResult createFailedResult(final Status status) {
            return new Notifications.GameMuteStatusChangeResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.1.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$2 */
    class C06462 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusChangeResult> {
        final /* synthetic */ String zzarm;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zza.zzb<Notifications.GameMuteStatusChangeResult>) this, this.zzarm, false);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* JADX INFO: renamed from: zzaf, reason: merged with bridge method [inline-methods] */
        public Notifications.GameMuteStatusChangeResult createFailedResult(final Status status) {
            return new Notifications.GameMuteStatusChangeResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.2.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$3 */
    class C06473 extends Games.BaseGamesApiMethodImpl<Notifications.GameMuteStatusLoadResult> {
        final /* synthetic */ String zzarm;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzo(this, this.zzarm);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* JADX INFO: renamed from: zzag, reason: merged with bridge method [inline-methods] */
        public Notifications.GameMuteStatusLoadResult createFailedResult(final Status status) {
            return new Notifications.GameMuteStatusLoadResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.3.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$4 */
    class C06484 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean zzaqy;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh(this, this.zzaqy);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$5 */
    class C06495 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean zzarq;
        final /* synthetic */ Bundle zzarr;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzarq, this.zzarr);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$6 */
    class C06506 extends InboxCountImpl {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh(this);
        }
    }

    private static abstract class ContactSettingLoadImpl extends Games.BaseGamesApiMethodImpl<Notifications.ContactSettingLoadResult> {
        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* JADX INFO: renamed from: zzah, reason: merged with bridge method [inline-methods] */
        public Notifications.ContactSettingLoadResult createFailedResult(final Status status) {
            return new Notifications.ContactSettingLoadResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.ContactSettingLoadImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ContactSettingUpdateImpl extends Games.BaseGamesApiMethodImpl<Status> {
        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    private static abstract class InboxCountImpl extends Games.BaseGamesApiMethodImpl<Notifications.InboxCountResult> {
        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* JADX INFO: renamed from: zzai, reason: merged with bridge method [inline-methods] */
        public Notifications.InboxCountResult createFailedResult(final Status status) {
            return new Notifications.InboxCountResult() { // from class: com.google.android.gms.games.internal.api.NotificationsImpl.InboxCountImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @Override // com.google.android.gms.games.Notifications
    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        GamesClientImpl gamesClientImplZzb = Games.zzb(apiClient, false);
        if (gamesClientImplZzb != null) {
            gamesClientImplZzb.zzfD(notificationTypes);
        }
    }

    @Override // com.google.android.gms.games.Notifications
    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
