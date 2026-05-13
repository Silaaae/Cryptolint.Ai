package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.p006a.C0038c;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: renamed from: android.support.v7.app.o */
/* JADX INFO: loaded from: classes.dex */
class C0172o {

    /* JADX INFO: renamed from: a */
    private static C0172o f1025a;

    /* JADX INFO: renamed from: b */
    private final Context f1026b;

    /* JADX INFO: renamed from: c */
    private final LocationManager f1027c;

    /* JADX INFO: renamed from: d */
    private final a f1028d = new a();

    /* JADX INFO: renamed from: android.support.v7.app.o$a */
    private static class a {

        /* JADX INFO: renamed from: a */
        boolean f1029a;

        /* JADX INFO: renamed from: b */
        long f1030b;

        /* JADX INFO: renamed from: c */
        long f1031c;

        /* JADX INFO: renamed from: d */
        long f1032d;

        /* JADX INFO: renamed from: e */
        long f1033e;

        /* JADX INFO: renamed from: f */
        long f1034f;

        a() {
        }
    }

    C0172o(Context context, LocationManager locationManager) {
        this.f1026b = context;
        this.f1027c = locationManager;
    }

    /* JADX INFO: renamed from: a */
    private Location m1346a(String str) {
        try {
            if (this.f1027c.isProviderEnabled(str)) {
                return this.f1027c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e) {
            Log.d("TwilightManager", "Failed to get last known location", e);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    static C0172o m1347a(Context context) {
        if (f1025a == null) {
            Context applicationContext = context.getApplicationContext();
            f1025a = new C0172o(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f1025a;
    }

    /* JADX INFO: renamed from: a */
    private void m1348a(Location location) {
        long j;
        a aVar = this.f1028d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0171n c0171nM1344a = C0171n.m1344a();
        c0171nM1344a.m1345a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = c0171nM1344a.f1022a;
        c0171nM1344a.m1345a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = c0171nM1344a.f1024c == 1;
        long j3 = c0171nM1344a.f1023b;
        long j4 = c0171nM1344a.f1022a;
        boolean z2 = z;
        c0171nM1344a.m1345a(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = c0171nM1344a.f1023b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + jCurrentTimeMillis;
        } else {
            j = (jCurrentTimeMillis > j4 ? 0 + j5 : jCurrentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        aVar.f1029a = z2;
        aVar.f1030b = j2;
        aVar.f1031c = j3;
        aVar.f1032d = j4;
        aVar.f1033e = j5;
        aVar.f1034f = j;
    }

    @SuppressLint({"MissingPermission"})
    /* JADX INFO: renamed from: b */
    private Location m1349b() {
        Location locationM1346a = C0038c.m215a(this.f1026b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m1346a("network") : null;
        Location locationM1346a2 = C0038c.m215a(this.f1026b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? m1346a("gps") : null;
        return (locationM1346a2 == null || locationM1346a == null) ? locationM1346a2 != null ? locationM1346a2 : locationM1346a : locationM1346a2.getTime() > locationM1346a.getTime() ? locationM1346a2 : locationM1346a;
    }

    /* JADX INFO: renamed from: c */
    private boolean m1350c() {
        return this.f1028d.f1034f > System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: a */
    boolean m1351a() {
        a aVar = this.f1028d;
        if (m1350c()) {
            return aVar.f1029a;
        }
        Location locationM1349b = m1349b();
        if (locationM1349b != null) {
            m1348a(locationM1349b);
            return aVar.f1029a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
