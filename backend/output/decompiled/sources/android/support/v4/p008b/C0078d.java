package android.support.v4.p008b;

import android.content.Context;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.p013e.C0088b;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* JADX INFO: renamed from: android.support.v4.b.d */
/* JADX INFO: loaded from: classes.dex */
class C0078d extends C0081g {
    C0078d() {
    }

    /* JADX INFO: renamed from: a */
    private File m691a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String str = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(str).st_mode)) {
                return new File(str);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0059 A[Catch: all -> 0x005d, Throwable -> 0x0060, TryCatch #4 {Throwable -> 0x0060, blocks: (B:7:0x0018, B:9:0x001e, B:12:0x0025, B:16:0x002f, B:18:0x003c, B:34:0x005c, B:33:0x0059, B:32:0x0055), top: B:55:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[Catch: IOException -> 0x0077, SYNTHETIC, TRY_LEAVE, TryCatch #1 {IOException -> 0x0077, blocks: (B:6:0x000e, B:14:0x002b, B:20:0x0041, B:43:0x006a, B:47:0x0073, B:46:0x006f, B:48:0x0076), top: B:52:0x000e, inners: #2 }] */
    @Override // android.support.v4.p008b.C0081g, android.support.v4.p008b.C0077c.a
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Typeface mo689a(Context context, CancellationSignal cancellationSignal, C0088b.b[] bVarArr, int i) throws Throwable {
        Throwable th;
        Throwable th2;
        Throwable th3;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(m706a(bVarArr, i).m745a(), "r", cancellationSignal);
            try {
                try {
                    File fileM691a = m691a(parcelFileDescriptorOpenFileDescriptor);
                    if (fileM691a != null && fileM691a.canRead()) {
                        Typeface typefaceCreateFromFile = Typeface.createFromFile(fileM691a);
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        return typefaceCreateFromFile;
                    }
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        Typeface typefaceM705a = super.m705a(context, fileInputStream);
                        fileInputStream.close();
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        return typefaceM705a;
                    } catch (Throwable th4) {
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            th2 = th4;
                            th3 = th5;
                            if (th2 != null) {
                                fileInputStream.close();
                                throw th3;
                            }
                            try {
                                fileInputStream.close();
                                throw th3;
                            } catch (Throwable th6) {
                                th2.addSuppressed(th6);
                                throw th3;
                            }
                        }
                    }
                } catch (Throwable th7) {
                    try {
                        throw th7;
                    } catch (Throwable th8) {
                        th = th7;
                        th = th8;
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            throw th;
                        }
                        if (th == null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                            throw th;
                        }
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                            throw th;
                        } catch (Throwable th9) {
                            th.addSuppressed(th9);
                            throw th;
                        }
                    }
                }
            } catch (Throwable th10) {
                th = th10;
                th = null;
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
