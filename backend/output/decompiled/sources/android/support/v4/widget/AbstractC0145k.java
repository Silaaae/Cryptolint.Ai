package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: android.support.v4.widget.k */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0145k extends AbstractC0138d {

    /* JADX INFO: renamed from: j */
    private int f774j;

    /* JADX INFO: renamed from: k */
    private int f775k;

    /* JADX INFO: renamed from: l */
    private LayoutInflater f776l;

    @Deprecated
    public AbstractC0145k(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f775k = i;
        this.f774j = i;
        this.f776l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.support.v4.widget.AbstractC0138d
    /* JADX INFO: renamed from: a */
    public View mo1116a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f776l.inflate(this.f774j, viewGroup, false);
    }

    @Override // android.support.v4.widget.AbstractC0138d
    /* JADX INFO: renamed from: b */
    public View mo1121b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f776l.inflate(this.f775k, viewGroup, false);
    }
}
