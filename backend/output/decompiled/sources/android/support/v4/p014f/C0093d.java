package android.support.v4.p014f;

/* JADX INFO: renamed from: android.support.v4.f.d */
/* JADX INFO: loaded from: classes.dex */
public class C0093d {
    /* JADX INFO: renamed from: a */
    public static void m785a(Object obj, StringBuilder sb) {
        int iLastIndexOf;
        String hexString;
        if (obj == null) {
            hexString = "null";
        } else {
            String simpleName = obj.getClass().getSimpleName();
            if ((simpleName == null || simpleName.length() <= 0) && (iLastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(iLastIndexOf + 1);
            }
            sb.append(simpleName);
            sb.append('{');
            hexString = Integer.toHexString(System.identityHashCode(obj));
        }
        sb.append(hexString);
    }
}
