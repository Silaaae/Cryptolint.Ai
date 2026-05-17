package android.support.v4.p008b;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* JADX INFO: renamed from: android.support.v4.b.h */
/* JADX INFO: loaded from: classes.dex */
public class C0082h {
    /* JADX INFO: renamed from: a */
    public static File m709a(Context context) {
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i = 0; i < 100; i++) {
            File file = new File(context.getCacheDir(), str + i);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static ByteBuffer m710a(Context context, Resources resources, int i) {
        File fileM709a = m709a(context);
        if (fileM709a == null) {
            return null;
        }
        try {
            if (m714a(fileM709a, resources, i)) {
                return m712a(fileM709a);
            }
            return null;
        } finally {
            fileM709a.delete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0049 A[Catch: all -> 0x004d, Throwable -> 0x0050, TryCatch #4 {Throwable -> 0x0050, blocks: (B:8:0x0013, B:10:0x002c, B:26:0x004c, B:25:0x0049, B:24:0x0045), top: B:47:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[Catch: IOException -> 0x0067, SYNTHETIC, TRY_LEAVE, TryCatch #1 {IOException -> 0x0067, blocks: (B:3:0x0005, B:6:0x000f, B:12:0x0031, B:35:0x005a, B:39:0x0063, B:38:0x005f, B:40:0x0066), top: B:44:0x0005, inners: #2 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ByteBuffer m711a(Context context, CancellationSignal cancellationSignal, Uri uri) throws Throwable {
        Throwable th;
        Throwable th2;
        Throwable th3;
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                if (parcelFileDescriptorOpenFileDescriptor != null) {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
                return null;
            }
            try {
                try {
                    FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor());
                    try {
                        FileChannel channel = fileInputStream.getChannel();
                        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                        fileInputStream.close();
                        if (parcelFileDescriptorOpenFileDescriptor != null) {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        }
                        return map;
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e A[Catch: IOException -> 0x0032, TryCatch #1 {IOException -> 0x0032, blocks: (B:3:0x0001, B:5:0x0016, B:14:0x0025, B:19:0x0031, B:18:0x002e, B:17:0x002a), top: B:21:0x0001, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ByteBuffer m712a(File file) throws Throwable {
        Throwable th;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                return map;
            } catch (Throwable th2) {
                th = th2;
                th = null;
                if (th != null) {
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m713a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m714a(File file, Resources resources, int i) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i);
            try {
                boolean zM715a = m715a(file, inputStreamOpenRawResource);
                m713a(inputStreamOpenRawResource);
                return zM715a;
            } catch (Throwable th) {
                th = th;
                m713a(inputStreamOpenRawResource);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m715a(File file, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    m713a(fileOutputStream);
                    return true;
                }
                fileOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            m713a(fileOutputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            m713a(fileOutputStream2);
            throw th;
        }
    }
}
