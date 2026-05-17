package com.google.android.gms.internal;

import android.view.View;
import android.webkit.WebChromeClient;

/* JADX INFO: loaded from: classes.dex */
@zzgd
public final class zzik extends zzii {
    public zzik(zzid zzidVar) {
        super(zzidVar);
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback customViewCallback) {
        zza(view, requestedOrientation, customViewCallback);
    }
}
