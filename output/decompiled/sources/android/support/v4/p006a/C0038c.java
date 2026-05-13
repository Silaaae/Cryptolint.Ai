package android.support.v4.p006a;

import android.content.Context;
import android.os.Process;
import android.support.v4.app.C0044b;

/* JADX INFO: renamed from: android.support.v4.a.c */
/* JADX INFO: loaded from: classes.dex */
public final class C0038c {
    /* JADX INFO: renamed from: a */
    public static int m215a(Context context, String str) {
        return m216a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    /* JADX INFO: renamed from: a */
    public static int m216a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String strM239a = C0044b.m239a(str);
        if (strM239a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return C0044b.m238a(context, strM239a, str2) != 0 ? -2 : 0;
    }
}
