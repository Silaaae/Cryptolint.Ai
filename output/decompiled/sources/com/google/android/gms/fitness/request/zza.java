package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.zzn;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zza extends zzn.zza {
    private final BleScanCallback zzalI;

    /* JADX INFO: renamed from: com.google.android.gms.fitness.request.zza$zza, reason: collision with other inner class name */
    public static class C1204zza {
        private static final C1204zza zzalJ = new C1204zza();
        private final Map<BleScanCallback, zza> zzalK = new HashMap();

        private C1204zza() {
        }

        public static C1204zza zzqS() {
            return zzalJ;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza zzaVar;
            synchronized (this.zzalK) {
                zzaVar = this.zzalK.get(bleScanCallback);
                if (zzaVar == null) {
                    zzaVar = new zza(bleScanCallback);
                    this.zzalK.put(bleScanCallback, zzaVar);
                }
            }
            return zzaVar;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            zza zzaVar;
            synchronized (this.zzalK) {
                zzaVar = this.zzalK.get(bleScanCallback);
                if (zzaVar == null) {
                    zzaVar = new zza(bleScanCallback);
                }
            }
            return zzaVar;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzalI = (BleScanCallback) com.google.android.gms.common.internal.zzu.zzu(bleScanCallback);
    }

    @Override // com.google.android.gms.fitness.request.zzn
    public void onDeviceFound(BleDevice device) throws RemoteException {
        this.zzalI.onDeviceFound(device);
    }

    @Override // com.google.android.gms.fitness.request.zzn
    public void onScanStopped() throws RemoteException {
        this.zzalI.onScanStopped();
    }
}
