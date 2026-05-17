package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqf;

/* JADX INFO: loaded from: classes.dex */
public class zzqe implements Result {
    private final zza zzaPo;

    public static class zza {
        private final Status zzOt;
        private final EnumC1289zza zzaPp;
        private final byte[] zzaPq;
        private final long zzaPr;
        private final zzpy zzaPs;
        private final zzqf.zzc zzaPt;

        /* JADX INFO: renamed from: com.google.android.gms.internal.zzqe$zza$zza, reason: collision with other inner class name */
        public enum EnumC1289zza {
            NETWORK,
            DISK,
            DEFAULT
        }

        public zza(Status status, zzpy zzpyVar, EnumC1289zza enumC1289zza) {
            this(status, zzpyVar, null, null, enumC1289zza, 0L);
        }

        public zza(Status status, zzpy zzpyVar, byte[] bArr, zzqf.zzc zzcVar, EnumC1289zza enumC1289zza, long j) {
            this.zzOt = status;
            this.zzaPs = zzpyVar;
            this.zzaPq = bArr;
            this.zzaPt = zzcVar;
            this.zzaPp = enumC1289zza;
            this.zzaPr = j;
        }

        public Status getStatus() {
            return this.zzOt;
        }

        public EnumC1289zza zzAh() {
            return this.zzaPp;
        }

        public byte[] zzAi() {
            return this.zzaPq;
        }

        public zzpy zzAj() {
            return this.zzaPs;
        }

        public zzqf.zzc zzAk() {
            return this.zzaPt;
        }

        public long zzAl() {
            return this.zzaPr;
        }
    }

    public zzqe(zza zzaVar) {
        this.zzaPo = zzaVar;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.zzaPo.getStatus();
    }

    public zza zzAg() {
        return this.zzaPo;
    }
}
