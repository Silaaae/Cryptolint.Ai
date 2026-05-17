package com.google.android.gms.analytics.internal;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
class zzah extends zzd {
    private static final byte[] zzMs = "\n".getBytes();
    private final String zzFP;
    private final zzaj zzMr;

    private class zza {
        private int zzMt;
        private ByteArrayOutputStream zzMu = new ByteArrayOutputStream();

        public zza() {
        }

        public byte[] getPayload() {
            return this.zzMu.toByteArray();
        }

        public boolean zzj(zzab zzabVar) {
            com.google.android.gms.common.internal.zzu.zzu(zzabVar);
            if (this.zzMt + 1 > zzah.this.zzhR().zzji()) {
                return false;
            }
            String strZza = zzah.this.zza(zzabVar, false);
            if (strZza == null) {
                zzah.this.zzhQ().zza(zzabVar, "Error formatting hit");
                return true;
            }
            byte[] bytes = strZza.getBytes();
            int length = bytes.length;
            if (length > zzah.this.zzhR().zzja()) {
                zzah.this.zzhQ().zza(zzabVar, "Hit size exceeds the maximum size limit");
                return true;
            }
            if (this.zzMu.size() > 0) {
                length++;
            }
            if (length + this.zzMu.size() > zzah.this.zzhR().zzjc()) {
                return false;
            }
            try {
                if (this.zzMu.size() > 0) {
                    this.zzMu.write(zzah.zzMs);
                }
                this.zzMu.write(bytes);
                this.zzMt++;
                return true;
            } catch (IOException e) {
                zzah.this.zze("Failed to write payload when batching hits", e);
                return true;
            }
        }

        public int zzkj() {
            return this.zzMt;
        }
    }

    zzah(zzf zzfVar) {
        super(zzfVar);
        this.zzFP = zza("GoogleAnalytics", zze.VERSION, Build.VERSION.RELEASE, zzam.zza(Locale.getDefault()), Build.MODEL, Build.ID);
        this.zzMr = new zzaj(zzfVar.zzhP());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int zza(URL url, byte[] bArr) throws Throwable {
        HttpURLConnection httpURLConnectionZzc;
        int responseCode;
        OutputStream outputStream = null;
        com.google.android.gms.common.internal.zzu.zzu(url);
        com.google.android.gms.common.internal.zzu.zzu(bArr);
        Integer numValueOf = Integer.valueOf(bArr.length);
        zzb("POST bytes, url", numValueOf, url);
        ?? r2 = numValueOf;
        if (zzhZ()) {
            String str = new String(bArr);
            zza("Post payload\n", str);
            r2 = str;
        }
        try {
            try {
                httpURLConnectionZzc = zzc(url);
                try {
                    httpURLConnectionZzc.setDoOutput(true);
                    httpURLConnectionZzc.setFixedLengthStreamingMode(bArr.length);
                    httpURLConnectionZzc.connect();
                    outputStream = httpURLConnectionZzc.getOutputStream();
                    outputStream.write(bArr);
                    zzb(httpURLConnectionZzc);
                    responseCode = httpURLConnectionZzc.getResponseCode();
                    if (responseCode == 200) {
                        zzhl().zzhL();
                    }
                    zzb("POST status", Integer.valueOf(responseCode));
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e) {
                            zze("Error closing http post connection output stream", e);
                        }
                    }
                    if (httpURLConnectionZzc != null) {
                        httpURLConnectionZzc.disconnect();
                    }
                } catch (IOException e2) {
                    e = e2;
                    zzd("Network POST connection error", e);
                    responseCode = 0;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (IOException e3) {
                            zze("Error closing http post connection output stream", e3);
                        }
                    }
                    if (httpURLConnectionZzc != null) {
                        httpURLConnectionZzc.disconnect();
                    }
                }
            } catch (Throwable th) {
                th = th;
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (IOException e4) {
                        zze("Error closing http post connection output stream", e4);
                    }
                }
                if (r2 != 0) {
                    r2.disconnect();
                }
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            httpURLConnectionZzc = null;
        } catch (Throwable th2) {
            th = th2;
            r2 = 0;
            if (0 != 0) {
            }
            if (r2 != 0) {
            }
            throw th;
        }
        return responseCode;
    }

    private static String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", str, str2, str3, str4, str5, str6);
    }

    private void zza(StringBuilder sb, String str, String str2) throws UnsupportedEncodingException {
        if (sb.length() != 0) {
            sb.append('&');
        }
        sb.append(URLEncoder.encode(str, "UTF-8"));
        sb.append('=');
        sb.append(URLEncoder.encode(str2, "UTF-8"));
    }

    private int zzb(URL url) {
        int responseCode;
        com.google.android.gms.common.internal.zzu.zzu(url);
        zzb("GET request", url);
        HttpURLConnection httpURLConnectionZzc = null;
        try {
            try {
                httpURLConnectionZzc = zzc(url);
                httpURLConnectionZzc.connect();
                zzb(httpURLConnectionZzc);
                responseCode = httpURLConnectionZzc.getResponseCode();
                if (responseCode == 200) {
                    zzhl().zzhL();
                }
                zzb("GET status", Integer.valueOf(responseCode));
            } catch (IOException e) {
                zzd("Network GET connection error", e);
                responseCode = 0;
                if (httpURLConnectionZzc != null) {
                    httpURLConnectionZzc.disconnect();
                }
            }
            return responseCode;
        } finally {
            if (httpURLConnectionZzc != null) {
                httpURLConnectionZzc.disconnect();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int zzb(URL url, byte[] bArr) throws Throwable {
        HttpURLConnection httpURLConnectionZzc;
        HttpURLConnection httpURLConnection;
        int responseCode;
        byte[] bArrZzg;
        OutputStream outputStream;
        OutputStream outputStream2 = null;
        com.google.android.gms.common.internal.zzu.zzu(url);
        com.google.android.gms.common.internal.zzu.zzu(bArr);
        try {
            bArrZzg = zzg(bArr);
            zza("POST compressed size, ratio %, url", Integer.valueOf(bArrZzg.length), Long.valueOf((100 * ((long) bArrZzg.length)) / ((long) bArr.length)), url);
            if (bArrZzg.length > bArr.length) {
                zzc("Compressed payload is larger then uncompressed. compressed, uncompressed", Integer.valueOf(bArrZzg.length), Integer.valueOf(bArr.length));
            }
            if (zzhZ()) {
                zza("Post payload", "\n" + new String(bArr));
            }
            httpURLConnectionZzc = zzc(url);
            try {
                httpURLConnectionZzc.setDoOutput(true);
                httpURLConnectionZzc.addRequestProperty("Content-Encoding", "gzip");
                httpURLConnectionZzc.setFixedLengthStreamingMode(bArrZzg.length);
                httpURLConnectionZzc.connect();
                outputStream = httpURLConnectionZzc.getOutputStream();
            } catch (IOException e) {
                e = e;
                httpURLConnection = httpURLConnectionZzc;
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
            httpURLConnection = null;
        } catch (Throwable th2) {
            th = th2;
            httpURLConnectionZzc = null;
        }
        try {
            outputStream.write(bArrZzg);
            outputStream.close();
            OutputStream outputStream3 = null;
            zzb(httpURLConnectionZzc);
            responseCode = httpURLConnectionZzc.getResponseCode();
            if (responseCode == 200) {
                zzhl().zzhL();
            }
            zzb("POST status", Integer.valueOf(responseCode));
            if (0 != 0) {
                try {
                    outputStream3.close();
                } catch (IOException e3) {
                    zze("Error closing http compressed post connection output stream", e3);
                }
            }
            if (httpURLConnectionZzc != null) {
                httpURLConnectionZzc.disconnect();
            }
        } catch (IOException e4) {
            e = e4;
            outputStream2 = outputStream;
            httpURLConnection = httpURLConnectionZzc;
            try {
                zzd("Network compressed POST connection error", e);
                responseCode = 0;
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e5) {
                        zze("Error closing http compressed post connection output stream", e5);
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnectionZzc = httpURLConnection;
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e6) {
                        zze("Error closing http compressed post connection output stream", e6);
                    }
                }
                if (httpURLConnectionZzc != null) {
                    httpURLConnectionZzc.disconnect();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            outputStream2 = outputStream;
            if (outputStream2 != null) {
            }
            if (httpURLConnectionZzc != null) {
            }
            throw th;
        }
        return responseCode;
    }

    private URL zzb(zzab zzabVar, String str) {
        try {
            return new URL(zzabVar.zzjY() ? zzhR().zzjk() + zzhR().zzjm() + "?" + str : zzhR().zzjl() + zzhR().zzjm() + "?" + str);
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private void zzb(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            do {
            } while (inputStream.read(new byte[1024]) > 0);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    zze("Error closing http connection input stream", e);
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    zze("Error closing http connection input stream", e2);
                }
            }
            throw th;
        }
    }

    private boolean zzg(zzab zzabVar) {
        com.google.android.gms.common.internal.zzu.zzu(zzabVar);
        String strZza = zza(zzabVar, !zzabVar.zzjY());
        if (strZza == null) {
            zzhQ().zza(zzabVar, "Error formatting hit for upload");
            return true;
        }
        if (strZza.length() <= zzhR().zziZ()) {
            URL urlZzb = zzb(zzabVar, strZza);
            if (urlZzb != null) {
                return zzb(urlZzb) == 200;
            }
            zzaX("Failed to build collect GET endpoint url");
            return false;
        }
        String strZza2 = zza(zzabVar, false);
        if (strZza2 == null) {
            zzhQ().zza(zzabVar, "Error formatting hit for POST upload");
            return true;
        }
        byte[] bytes = strZza2.getBytes();
        if (bytes.length > zzhR().zzjb()) {
            zzhQ().zza(zzabVar, "Hit payload exceeds size limit");
            return true;
        }
        URL urlZzh = zzh(zzabVar);
        if (urlZzh != null) {
            return zza(urlZzh, bytes) == 200;
        }
        zzaX("Failed to build collect POST endpoint url");
        return false;
    }

    private static byte[] zzg(byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private URL zzh(zzab zzabVar) {
        try {
            return new URL(zzabVar.zzjY() ? zzhR().zzjk() + zzhR().zzjm() : zzhR().zzjl() + zzhR().zzjm());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    private String zzi(zzab zzabVar) {
        return String.valueOf(zzabVar.zzjV());
    }

    private URL zzkh() {
        try {
            return new URL(zzhR().zzjk() + zzhR().zzjn());
        } catch (MalformedURLException e) {
            zze("Error trying to parse the hardcoded host url", e);
            return null;
        }
    }

    String zza(zzab zzabVar, boolean z) {
        com.google.android.gms.common.internal.zzu.zzu(zzabVar);
        StringBuilder sb = new StringBuilder();
        try {
            for (Map.Entry<String, String> entry : zzabVar.zzn().entrySet()) {
                String key = entry.getKey();
                if (!"ht".equals(key) && !"qt".equals(key) && !"AppUID".equals(key) && !"z".equals(key) && !"_gmsv".equals(key)) {
                    zza(sb, key, entry.getValue());
                }
            }
            zza(sb, "ht", String.valueOf(zzabVar.zzjW()));
            zza(sb, "qt", String.valueOf(zzhP().currentTimeMillis() - zzabVar.zzjW()));
            if (zzhR().zziW()) {
                zza(sb, "_gmsv", zze.VERSION);
            }
            if (z) {
                long jZzjZ = zzabVar.zzjZ();
                zza(sb, "z", jZzjZ != 0 ? String.valueOf(jZzjZ) : zzi(zzabVar));
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            zze("Failed to encode name or value", e);
            return null;
        }
    }

    List<Long> zza(List<zzab> list, boolean z) {
        com.google.android.gms.common.internal.zzu.zzV(!list.isEmpty());
        zza("Uploading batched hits. compression, count", Boolean.valueOf(z), Integer.valueOf(list.size()));
        zza zzaVar = new zza();
        ArrayList arrayList = new ArrayList();
        for (zzab zzabVar : list) {
            if (!zzaVar.zzj(zzabVar)) {
                break;
            }
            arrayList.add(Long.valueOf(zzabVar.zzjV()));
        }
        if (zzaVar.zzkj() == 0) {
            return arrayList;
        }
        URL urlZzkh = zzkh();
        if (urlZzkh == null) {
            zzaX("Failed to build batching endpoint url");
            return Collections.emptyList();
        }
        int iZzb = z ? zzb(urlZzkh, zzaVar.getPayload()) : zza(urlZzkh, zzaVar.getPayload());
        if (200 == iZzb) {
            zza("Batched upload completed. Hits batched", Integer.valueOf(zzaVar.zzkj()));
            return arrayList;
        }
        zza("Network error uploading hits. status code", Integer.valueOf(iZzb));
        if (zzhR().zzjq().contains(Integer.valueOf(iZzb))) {
            zzaW("Server instructed the client to stop batching");
            this.zzMr.start();
        }
        return Collections.emptyList();
    }

    HttpURLConnection zzc(URL url) throws IOException {
        URLConnection uRLConnectionOpenConnection = url.openConnection();
        if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
            throw new IOException("Failed to obtain http connection");
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setConnectTimeout(zzhR().zzjz());
        httpURLConnection.setReadTimeout(zzhR().zzjA());
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestProperty("User-Agent", this.zzFP);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    public List<Long> zzf(List<zzab> list) {
        boolean z;
        boolean z2 = true;
        zzhO();
        zzia();
        com.google.android.gms.common.internal.zzu.zzu(list);
        if (zzhR().zzjq().isEmpty() || !this.zzMr.zzv(zzhR().zzjj() * 1000)) {
            z2 = false;
            z = false;
        } else {
            z = zzhR().zzjo() != zzm.NONE;
            if (zzhR().zzjp() != zzo.GZIP) {
                z2 = false;
            }
        }
        return z ? zza(list, z2) : zzg(list);
    }

    List<Long> zzg(List<zzab> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (zzab zzabVar : list) {
            if (!zzg(zzabVar)) {
                break;
            }
            arrayList.add(Long.valueOf(zzabVar.zzjV()));
            if (arrayList.size() >= zzhR().zzjh()) {
                break;
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.analytics.internal.zzd
    protected void zzhn() {
        zza("Network initialized. User agent", this.zzFP);
    }

    public boolean zzkg() {
        NetworkInfo activeNetworkInfo;
        zzhO();
        zzia();
        try {
            activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzaT("No network connectivity");
        return false;
    }
}
