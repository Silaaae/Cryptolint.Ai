package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.HasFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.OwnedByMeFilter;

/* JADX INFO: loaded from: classes.dex */
public class Filters {
    public static Filter and(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.zzaim, filter, additionalFilters);
    }

    public static Filter and(Iterable<Filter> filters) {
        return new LogicalFilter(Operator.zzaim, filters);
    }

    public static Filter contains(SearchableMetadataField<String> field, String value) {
        return new ComparisonFilter(Operator.zzaip, field, value);
    }

    /* JADX INFO: renamed from: eq */
    public static Filter m13eq(CustomPropertyKey key, String value) {
        return new HasFilter(SearchableField.zzahN, new AppVisibleCustomProperties.zza().zza(key, value).zzpU());
    }

    /* JADX INFO: renamed from: eq */
    public static <T> Filter m14eq(SearchableMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzaih, field, value);
    }

    public static <T extends Comparable<T>> Filter greaterThan(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzaik, field, value);
    }

    public static <T extends Comparable<T>> Filter greaterThanEquals(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzail, field, value);
    }

    /* JADX INFO: renamed from: in */
    public static <T> Filter m15in(SearchableCollectionMetadataField<T> field, T value) {
        return new InFilter(field, value);
    }

    public static <T extends Comparable<T>> Filter lessThan(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzaii, field, value);
    }

    public static <T extends Comparable<T>> Filter lessThanEquals(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzaij, field, value);
    }

    public static Filter not(Filter toNegate) {
        return new NotFilter(toNegate);
    }

    public static Filter openedByMe() {
        return new FieldOnlyFilter(SearchableField.LAST_VIEWED_BY_ME);
    }

    /* JADX INFO: renamed from: or */
    public static Filter m16or(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.zzain, filter, additionalFilters);
    }

    /* JADX INFO: renamed from: or */
    public static Filter m17or(Iterable<Filter> filters) {
        return new LogicalFilter(Operator.zzain, filters);
    }

    public static Filter ownedByMe() {
        return new OwnedByMeFilter();
    }

    public static Filter sharedWithMe() {
        return new FieldOnlyFilter(SearchableField.zzahM);
    }
}
