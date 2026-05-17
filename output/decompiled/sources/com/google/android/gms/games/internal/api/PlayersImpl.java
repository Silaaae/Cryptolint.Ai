package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.internal.GamesClientImpl;

/* JADX INFO: loaded from: classes.dex */
public final class PlayersImpl implements Players {

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$10 */
    class C065410 extends LoadPlayersImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ int zzarv;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, "nearby", this.zzaqA, this.zzarv, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$11 */
    class C065511 extends LoadPlayersImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ int zzarv;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, "played_with", this.zzaqA, this.zzarv, false, this.zzaqy);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$12 */
    class C065612 extends LoadPlayersImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ int zzarv;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, "played_with", this.zzaqA, this.zzarv, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$13 */
    class C065713 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ int zzarv;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zza.zzb<Players.LoadPlayersResult>) this, this.zzarv, false, this.zzaqy);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$14 */
    class C065814 extends LoadPlayersImpl {
        final /* synthetic */ int zzarv;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zza.zzb<Players.LoadPlayersResult>) this, this.zzarv, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$15 */
    class C065915 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ int zzarv;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zza.zzb<Players.LoadPlayersResult>) this, this.zzarv, false, this.zzaqy);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$16 */
    class C066016 extends LoadPlayersImpl {
        final /* synthetic */ int zzarv;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zza.zzb<Players.LoadPlayersResult>) this, this.zzarv, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$17 */
    class C066117 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ int zzarv;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzarv, false, this.zzaqy);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$18 */
    class C066218 extends LoadPlayersImpl {
        final /* synthetic */ int zzarv;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzarv, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$19 */
    class C066319 extends LoadPlayersImpl {
        final /* synthetic */ String zzaqR;
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ int zzarv;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaqR, this.zzarv, false, this.zzaqy);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$20 */
    class C066520 extends LoadPlayersImpl {
        final /* synthetic */ String zzaqR;
        final /* synthetic */ int zzarv;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzaqR, this.zzarv, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$21 */
    class C066621 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaqy;
        final /* synthetic */ String zzarm;
        final /* synthetic */ int zzarv;
        final /* synthetic */ String zzarw;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zza.zzb<Players.LoadPlayersResult>) this, this.zzarw, this.zzarm, this.zzarv, false, this.zzaqy);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$22 */
    class C066722 extends LoadPlayersImpl {
        final /* synthetic */ String zzarm;
        final /* synthetic */ int zzarv;
        final /* synthetic */ String zzarw;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zza.zzb<Players.LoadPlayersResult>) this, this.zzarw, this.zzarm, this.zzarv, true, false);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$23 */
    class C066823 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String zzarx;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this, this.zzarx);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$24 */
    class C066924 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzarx;
        final /* synthetic */ int zzary;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc(this, this.zzarx, this.zzary);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$25 */
    class C067025 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzarx;
        final /* synthetic */ int zzary;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzarx, this.zzary);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$26 */
    class C067126 extends LoadProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaqy;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf(this, this.zzaqy);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$27 */
    class C067227 extends UpdateProfileSettingsResultImpl {
        final /* synthetic */ boolean zzarz;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg(this, this.zzarz);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$3 */
    class C06733 extends LoadPlayersImpl {
        final /* synthetic */ String[] zzarA;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzarA);
        }
    }

    /* JADX INFO: renamed from: com.google.android.gms.games.internal.api.PlayersImpl$9 */
    class C06799 extends LoadPlayersImpl {
        final /* synthetic */ String zzaqA;
        final /* synthetic */ int zzarv;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, "nearby", this.zzaqA, this.zzarv, false, false);
        }
    }

    private static abstract class LoadPlayersImpl extends Games.BaseGamesApiMethodImpl<Players.LoadPlayersResult> {
        private LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* JADX INFO: renamed from: zzaj, reason: merged with bridge method [inline-methods] */
        public Players.LoadPlayersResult createFailedResult(final Status status) {
            return new Players.LoadPlayersResult() { // from class: com.google.android.gms.games.internal.api.PlayersImpl.LoadPlayersImpl.1
                @Override // com.google.android.gms.games.Players.LoadPlayersResult
                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.zzbi(14));
                }

                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.common.api.Releasable
                public void release() {
                }
            };
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadProfileSettingsResult> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* JADX INFO: renamed from: zzak, reason: merged with bridge method [inline-methods] */
        public Players.LoadProfileSettingsResult createFailedResult(final Status status) {
            return new Players.LoadProfileSettingsResult() { // from class: com.google.android.gms.games.internal.api.PlayersImpl.LoadProfileSettingsResultImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }

                @Override // com.google.android.gms.games.Players.LoadProfileSettingsResult
                public boolean isProfileVisible() {
                    return true;
                }

                @Override // com.google.android.gms.games.Players.LoadProfileSettingsResult
                public boolean isVisibilityExplicitlySet() {
                    return false;
                }
            };
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadXpForGameCategoriesResult> {
        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* JADX INFO: renamed from: zzal, reason: merged with bridge method [inline-methods] */
        public Players.LoadXpForGameCategoriesResult createFailedResult(final Status status) {
            return new Players.LoadXpForGameCategoriesResult() { // from class: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpForGameCategoriesResultImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadXpStreamResultImpl extends Games.BaseGamesApiMethodImpl<Players.LoadXpStreamResult> {
        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* JADX INFO: renamed from: zzam, reason: merged with bridge method [inline-methods] */
        public Players.LoadXpStreamResult createFailedResult(final Status status) {
            return new Players.LoadXpStreamResult() { // from class: com.google.android.gms.games.internal.api.PlayersImpl.LoadXpStreamResultImpl.1
                @Override // com.google.android.gms.common.api.Result
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends Games.BaseGamesApiMethodImpl<Status> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.AbstractPendingResult
        /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
        public Status createFailedResult(Status status) {
            return status;
        }
    }

    @Override // com.google.android.gms.games.Players
    public Intent getCompareProfileIntent(GoogleApiClient apiClient, Player player) {
        return Games.zzd(apiClient).zza(new PlayerEntity(player));
    }

    @Override // com.google.android.gms.games.Players
    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzsx();
    }

    @Override // com.google.android.gms.games.Players
    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzsw();
    }

    @Override // com.google.android.gms.games.Players
    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzsH();
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.8
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, pageSize, false, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, pageSize, true, false);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.7
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, "played_with", pageSize, true, false);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, playerId, false);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(this, playerId, forceReload);
            }
        });
    }

    @Override // com.google.android.gms.games.Players
    public PendingResult<Players.LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) { // from class: com.google.android.gms.games.internal.api.PlayersImpl.6
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.common.api.zza.AbstractC1172zza
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zza.zzb<Players.LoadPlayersResult>) this, "played_with", pageSize, false, forceReload);
            }
        });
    }
}
