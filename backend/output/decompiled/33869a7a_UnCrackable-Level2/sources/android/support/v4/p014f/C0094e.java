package android.support.v4.p014f;

import android.util.Log;
import java.io.Writer;

/* JADX INFO: renamed from: android.support.v4.f.e */
/* JADX INFO: loaded from: classes.dex */
public class C0094e extends Writer {

    /* JADX INFO: renamed from: a */
    private final String f591a;

    /* JADX INFO: renamed from: b */
    private StringBuilder f592b = new StringBuilder(128);

    public C0094e(String str) {
        this.f591a = str;
    }

    /* JADX INFO: renamed from: a */
    private void m786a() {
        if (this.f592b.length() > 0) {
            Log.d(this.f591a, this.f592b.toString());
            this.f592b.delete(0, this.f592b.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        m786a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        m786a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m786a();
            } else {
                this.f592b.append(c);
            }
        }
    }
}
