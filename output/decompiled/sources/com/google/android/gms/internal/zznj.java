package com.google.android.gms.internal;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface zznj {

    public static final class zza extends zzrh<zza> {
        public C1273zza[] zzawk;

        /* JADX INFO: renamed from: com.google.android.gms.internal.zznj$zza$zza, reason: collision with other inner class name */
        public static final class C1273zza extends zzrh<C1273zza> {
            private static volatile C1273zza[] zzawl;
            public int viewId;
            public String zzawm;
            public String zzawn;

            public C1273zza() {
                zztW();
            }

            public static C1273zza[] zztV() {
                if (zzawl == null) {
                    synchronized (zzrl.zzaWe) {
                        if (zzawl == null) {
                            zzawl = new C1273zza[0];
                        }
                    }
                }
                return zzawl;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof C1273zza)) {
                    return false;
                }
                C1273zza c1273zza = (C1273zza) o;
                if (this.zzawm == null) {
                    if (c1273zza.zzawm != null) {
                        return false;
                    }
                } else if (!this.zzawm.equals(c1273zza.zzawm)) {
                    return false;
                }
                if (this.zzawn == null) {
                    if (c1273zza.zzawn != null) {
                        return false;
                    }
                } else if (!this.zzawn.equals(c1273zza.zzawn)) {
                    return false;
                }
                if (this.viewId == c1273zza.viewId) {
                    return zza(c1273zza);
                }
                return false;
            }

            public int hashCode() {
                return (((((((this.zzawm == null ? 0 : this.zzawm.hashCode()) + 527) * 31) + (this.zzawn != null ? this.zzawn.hashCode() : 0)) * 31) + this.viewId) * 31) + zzBI();
            }

            @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
            protected int zzB() {
                int iZzB = super.zzB();
                if (!this.zzawm.equals("")) {
                    iZzB += zzrg.zzk(1, this.zzawm);
                }
                if (!this.zzawn.equals("")) {
                    iZzB += zzrg.zzk(2, this.zzawn);
                }
                return this.viewId != 0 ? iZzB + zzrg.zzA(3, this.viewId) : iZzB;
            }

            @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
            public void zza(zzrg zzrgVar) throws IOException {
                if (!this.zzawm.equals("")) {
                    zzrgVar.zzb(1, this.zzawm);
                }
                if (!this.zzawn.equals("")) {
                    zzrgVar.zzb(2, this.zzawn);
                }
                if (this.viewId != 0) {
                    zzrgVar.zzy(3, this.viewId);
                }
                super.zza(zzrgVar);
            }

            @Override // com.google.android.gms.internal.zzrn
            /* JADX INFO: renamed from: zzq, reason: merged with bridge method [inline-methods] */
            public C1273zza zzb(zzrf zzrfVar) throws IOException {
                while (true) {
                    int iZzBr = zzrfVar.zzBr();
                    switch (iZzBr) {
                        case 0:
                            break;
                        case 10:
                            this.zzawm = zzrfVar.readString();
                            break;
                        case 18:
                            this.zzawn = zzrfVar.readString();
                            break;
                        case 24:
                            this.viewId = zzrfVar.zzBu();
                            break;
                        default:
                            if (!zza(zzrfVar, iZzBr)) {
                            }
                            break;
                    }
                }
                return this;
            }

            public C1273zza zztW() {
                this.zzawm = "";
                this.zzawn = "";
                this.viewId = 0;
                this.zzaVU = null;
                this.zzaWf = -1;
                return this;
            }
        }

        public zza() {
            zztU();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) o;
            if (zzrl.equals(this.zzawk, zzaVar.zzawk)) {
                return zza(zzaVar);
            }
            return false;
        }

        public int hashCode() {
            return ((zzrl.hashCode(this.zzawk) + 527) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            if (this.zzawk != null && this.zzawk.length > 0) {
                for (int i = 0; i < this.zzawk.length; i++) {
                    C1273zza c1273zza = this.zzawk[i];
                    if (c1273zza != null) {
                        iZzB += zzrg.zzc(1, c1273zza);
                    }
                }
            }
            return iZzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (this.zzawk != null && this.zzawk.length > 0) {
                for (int i = 0; i < this.zzawk.length; i++) {
                    C1273zza c1273zza = this.zzawk[i];
                    if (c1273zza != null) {
                        zzrgVar.zza(1, c1273zza);
                    }
                }
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzp, reason: merged with bridge method [inline-methods] */
        public zza zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                switch (iZzBr) {
                    case 0:
                        break;
                    case 10:
                        int iZzb = zzrq.zzb(zzrfVar, 10);
                        int length = this.zzawk == null ? 0 : this.zzawk.length;
                        C1273zza[] c1273zzaArr = new C1273zza[iZzb + length];
                        if (length != 0) {
                            System.arraycopy(this.zzawk, 0, c1273zzaArr, 0, length);
                        }
                        while (length < c1273zzaArr.length - 1) {
                            c1273zzaArr[length] = new C1273zza();
                            zzrfVar.zza(c1273zzaArr[length]);
                            zzrfVar.zzBr();
                            length++;
                        }
                        c1273zzaArr[length] = new C1273zza();
                        zzrfVar.zza(c1273zzaArr[length]);
                        this.zzawk = c1273zzaArr;
                        break;
                    default:
                        if (!zza(zzrfVar, iZzBr)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zza zztU() {
            this.zzawk = C1273zza.zztV();
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzb extends zzrh<zzb> {
        private static volatile zzb[] zzawo;
        public String name;
        public zzd zzawp;

        public zzb() {
            zztY();
        }

        public static zzb[] zztX() {
            if (zzawo == null) {
                synchronized (zzrl.zzaWe) {
                    if (zzawo == null) {
                        zzawo = new zzb[0];
                    }
                }
            }
            return zzawo;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzb)) {
                return false;
            }
            zzb zzbVar = (zzb) o;
            if (this.name == null) {
                if (zzbVar.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzbVar.name)) {
                return false;
            }
            if (this.zzawp == null) {
                if (zzbVar.zzawp != null) {
                    return false;
                }
            } else if (!this.zzawp.equals(zzbVar.zzawp)) {
                return false;
            }
            return zza(zzbVar);
        }

        public int hashCode() {
            return (((((this.name == null ? 0 : this.name.hashCode()) + 527) * 31) + (this.zzawp != null ? this.zzawp.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            if (!this.name.equals("")) {
                iZzB += zzrg.zzk(1, this.name);
            }
            return this.zzawp != null ? iZzB + zzrg.zzc(2, this.zzawp) : iZzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!this.name.equals("")) {
                zzrgVar.zzb(1, this.name);
            }
            if (this.zzawp != null) {
                zzrgVar.zza(2, this.zzawp);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzr, reason: merged with bridge method [inline-methods] */
        public zzb zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                switch (iZzBr) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzrfVar.readString();
                        break;
                    case 18:
                        if (this.zzawp == null) {
                            this.zzawp = new zzd();
                        }
                        zzrfVar.zza(this.zzawp);
                        break;
                    default:
                        if (!zza(zzrfVar, iZzBr)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzb zztY() {
            this.name = "";
            this.zzawp = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzc extends zzrh<zzc> {
        public String type;
        public zzb[] zzawq;

        public zzc() {
            zztZ();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzc)) {
                return false;
            }
            zzc zzcVar = (zzc) o;
            if (this.type == null) {
                if (zzcVar.type != null) {
                    return false;
                }
            } else if (!this.type.equals(zzcVar.type)) {
                return false;
            }
            if (zzrl.equals(this.zzawq, zzcVar.zzawq)) {
                return zza(zzcVar);
            }
            return false;
        }

        public int hashCode() {
            return (((((this.type == null ? 0 : this.type.hashCode()) + 527) * 31) + zzrl.hashCode(this.zzawq)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            if (!this.type.equals("")) {
                iZzB += zzrg.zzk(1, this.type);
            }
            if (this.zzawq == null || this.zzawq.length <= 0) {
                return iZzB;
            }
            int iZzc = iZzB;
            for (int i = 0; i < this.zzawq.length; i++) {
                zzb zzbVar = this.zzawq[i];
                if (zzbVar != null) {
                    iZzc += zzrg.zzc(2, zzbVar);
                }
            }
            return iZzc;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (!this.type.equals("")) {
                zzrgVar.zzb(1, this.type);
            }
            if (this.zzawq != null && this.zzawq.length > 0) {
                for (int i = 0; i < this.zzawq.length; i++) {
                    zzb zzbVar = this.zzawq[i];
                    if (zzbVar != null) {
                        zzrgVar.zza(2, zzbVar);
                    }
                }
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzs, reason: merged with bridge method [inline-methods] */
        public zzc zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                switch (iZzBr) {
                    case 0:
                        break;
                    case 10:
                        this.type = zzrfVar.readString();
                        break;
                    case 18:
                        int iZzb = zzrq.zzb(zzrfVar, 18);
                        int length = this.zzawq == null ? 0 : this.zzawq.length;
                        zzb[] zzbVarArr = new zzb[iZzb + length];
                        if (length != 0) {
                            System.arraycopy(this.zzawq, 0, zzbVarArr, 0, length);
                        }
                        while (length < zzbVarArr.length - 1) {
                            zzbVarArr[length] = new zzb();
                            zzrfVar.zza(zzbVarArr[length]);
                            zzrfVar.zzBr();
                            length++;
                        }
                        zzbVarArr[length] = new zzb();
                        zzrfVar.zza(zzbVarArr[length]);
                        this.zzawq = zzbVarArr;
                        break;
                    default:
                        if (!zza(zzrfVar, iZzBr)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzc zztZ() {
            this.type = "";
            this.zzawq = zzb.zztX();
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }

    public static final class zzd extends zzrh<zzd> {
        public String zzabE;
        public boolean zzawr;
        public long zzaws;
        public double zzawt;
        public zzc zzawu;

        public zzd() {
            zzua();
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof zzd)) {
                return false;
            }
            zzd zzdVar = (zzd) o;
            if (this.zzawr != zzdVar.zzawr) {
                return false;
            }
            if (this.zzabE == null) {
                if (zzdVar.zzabE != null) {
                    return false;
                }
            } else if (!this.zzabE.equals(zzdVar.zzabE)) {
                return false;
            }
            if (this.zzaws != zzdVar.zzaws || Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(zzdVar.zzawt)) {
                return false;
            }
            if (this.zzawu == null) {
                if (zzdVar.zzawu != null) {
                    return false;
                }
            } else if (!this.zzawu.equals(zzdVar.zzawu)) {
                return false;
            }
            return zza(zzdVar);
        }

        public int hashCode() {
            int iHashCode = (((this.zzabE == null ? 0 : this.zzabE.hashCode()) + (((this.zzawr ? 1231 : 1237) + 527) * 31)) * 31) + ((int) (this.zzaws ^ (this.zzaws >>> 32)));
            long jDoubleToLongBits = Double.doubleToLongBits(this.zzawt);
            return (((((iHashCode * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)))) * 31) + (this.zzawu != null ? this.zzawu.hashCode() : 0)) * 31) + zzBI();
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        protected int zzB() {
            int iZzB = super.zzB();
            if (this.zzawr) {
                iZzB += zzrg.zzc(1, this.zzawr);
            }
            if (!this.zzabE.equals("")) {
                iZzB += zzrg.zzk(2, this.zzabE);
            }
            if (this.zzaws != 0) {
                iZzB += zzrg.zzd(3, this.zzaws);
            }
            if (Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(0.0d)) {
                iZzB += zzrg.zzb(4, this.zzawt);
            }
            return this.zzawu != null ? iZzB + zzrg.zzc(5, this.zzawu) : iZzB;
        }

        @Override // com.google.android.gms.internal.zzrh, com.google.android.gms.internal.zzrn
        public void zza(zzrg zzrgVar) throws IOException {
            if (this.zzawr) {
                zzrgVar.zzb(1, this.zzawr);
            }
            if (!this.zzabE.equals("")) {
                zzrgVar.zzb(2, this.zzabE);
            }
            if (this.zzaws != 0) {
                zzrgVar.zzb(3, this.zzaws);
            }
            if (Double.doubleToLongBits(this.zzawt) != Double.doubleToLongBits(0.0d)) {
                zzrgVar.zza(4, this.zzawt);
            }
            if (this.zzawu != null) {
                zzrgVar.zza(5, this.zzawu);
            }
            super.zza(zzrgVar);
        }

        @Override // com.google.android.gms.internal.zzrn
        /* JADX INFO: renamed from: zzt, reason: merged with bridge method [inline-methods] */
        public zzd zzb(zzrf zzrfVar) throws IOException {
            while (true) {
                int iZzBr = zzrfVar.zzBr();
                switch (iZzBr) {
                    case 0:
                        break;
                    case 8:
                        this.zzawr = zzrfVar.zzBv();
                        break;
                    case 18:
                        this.zzabE = zzrfVar.readString();
                        break;
                    case 24:
                        this.zzaws = zzrfVar.zzBt();
                        break;
                    case 33:
                        this.zzawt = zzrfVar.readDouble();
                        break;
                    case 42:
                        if (this.zzawu == null) {
                            this.zzawu = new zzc();
                        }
                        zzrfVar.zza(this.zzawu);
                        break;
                    default:
                        if (!zza(zzrfVar, iZzBr)) {
                        }
                        break;
                }
            }
            return this;
        }

        public zzd zzua() {
            this.zzawr = false;
            this.zzabE = "";
            this.zzaws = 0L;
            this.zzawt = 0.0d;
            this.zzawu = null;
            this.zzaVU = null;
            this.zzaWf = -1;
            return this;
        }
    }
}
