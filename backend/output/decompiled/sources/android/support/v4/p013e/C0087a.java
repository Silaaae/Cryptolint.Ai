package android.support.v4.p013e;

import android.support.v4.p014f.C0099j;
import android.util.Base64;
import java.util.List;

/* JADX INFO: renamed from: android.support.v4.e.a */
/* JADX INFO: loaded from: classes.dex */
public final class C0087a {

    /* JADX INFO: renamed from: a */
    private final String f527a;

    /* JADX INFO: renamed from: b */
    private final String f528b;

    /* JADX INFO: renamed from: c */
    private final String f529c;

    /* JADX INFO: renamed from: d */
    private final List<List<byte[]>> f530d;

    /* JADX INFO: renamed from: e */
    private final int f531e = 0;

    /* JADX INFO: renamed from: f */
    private final String f532f;

    public C0087a(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f527a = (String) C0099j.m816a(str);
        this.f528b = (String) C0099j.m816a(str2);
        this.f529c = (String) C0099j.m816a(str3);
        this.f530d = (List) C0099j.m816a(list);
        this.f532f = this.f527a + "-" + this.f528b + "-" + this.f529c;
    }

    /* JADX INFO: renamed from: a */
    public String m721a() {
        return this.f527a;
    }

    /* JADX INFO: renamed from: b */
    public String m722b() {
        return this.f528b;
    }

    /* JADX INFO: renamed from: c */
    public String m723c() {
        return this.f529c;
    }

    /* JADX INFO: renamed from: d */
    public List<List<byte[]>> m724d() {
        return this.f530d;
    }

    /* JADX INFO: renamed from: e */
    public int m725e() {
        return this.f531e;
    }

    /* JADX INFO: renamed from: f */
    public String m726f() {
        return this.f532f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.f527a + ", mProviderPackage: " + this.f528b + ", mQuery: " + this.f529c + ", mCertificates:");
        for (int i = 0; i < this.f530d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.f530d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f531e);
        return sb.toString();
    }
}
