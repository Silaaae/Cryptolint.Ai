package android.support.v4.app;

import android.graphics.Rect;
import android.support.v4.p015g.C0124p;
import android.support.v4.p015g.C0125q;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: android.support.v4.app.t */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0062t {
    /* JADX INFO: renamed from: a */
    static String m616a(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    protected static void m617a(List<View> list, View view) {
        int size = list.size();
        if (m619a(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i = size; i < list.size(); i++) {
            View view2 = list.get(i);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!m619a(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected static boolean m618a(List list) {
        return list == null || list.isEmpty();
    }

    /* JADX INFO: renamed from: a */
    private static boolean m619a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public abstract Object mo600a(Object obj, Object obj2, Object obj3);

    /* JADX INFO: renamed from: a */
    ArrayList<String> m620a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(C0124p.m963e(view));
            C0124p.m959a(view, (String) null);
        }
        return arrayList2;
    }

    /* JADX INFO: renamed from: a */
    protected void m621a(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    /* JADX INFO: renamed from: a */
    void m622a(View view, final ArrayList<View> arrayList, final ArrayList<View> arrayList2, final ArrayList<String> arrayList3, Map<String, String> map) {
        final int size = arrayList2.size();
        final ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String strM963e = C0124p.m963e(view2);
            arrayList4.add(strM963e);
            if (strM963e != null) {
                C0124p.m959a(view2, (String) null);
                String str = map.get(strM963e);
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i2))) {
                        C0124p.m959a(arrayList2.get(i2), strM963e);
                        break;
                    }
                    i2++;
                }
            }
        }
        ViewOnAttachStateChangeListenerC0065w.m635a(view, new Runnable() { // from class: android.support.v4.app.t.1
            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < size; i3++) {
                    C0124p.m959a((View) arrayList2.get(i3), (String) arrayList3.get(i3));
                    C0124p.m959a((View) arrayList.get(i3), (String) arrayList4.get(i3));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    void m623a(View view, final ArrayList<View> arrayList, final Map<String, String> map) {
        ViewOnAttachStateChangeListenerC0065w.m635a(view, new Runnable() { // from class: android.support.v4.app.t.2
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view2 = (View) arrayList.get(i);
                    String strM963e = C0124p.m963e(view2);
                    if (strM963e != null) {
                        C0124p.m959a(view2, AbstractC0062t.m616a((Map<String, String>) map, strM963e));
                    }
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo601a(ViewGroup viewGroup, Object obj);

    /* JADX INFO: renamed from: a */
    void m624a(ViewGroup viewGroup, final ArrayList<View> arrayList, final Map<String, String> map) {
        ViewOnAttachStateChangeListenerC0065w.m635a(viewGroup, new Runnable() { // from class: android.support.v4.app.t.3
            @Override // java.lang.Runnable
            public void run() {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    View view = (View) arrayList.get(i);
                    C0124p.m959a(view, (String) map.get(C0124p.m963e(view)));
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo602a(Object obj, Rect rect);

    /* JADX INFO: renamed from: a */
    public abstract void mo603a(Object obj, View view);

    /* JADX INFO: renamed from: a */
    public abstract void mo604a(Object obj, View view, ArrayList<View> arrayList);

    /* JADX INFO: renamed from: a */
    public abstract void mo605a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* JADX INFO: renamed from: a */
    public abstract void mo606a(Object obj, ArrayList<View> arrayList);

    /* JADX INFO: renamed from: a */
    public abstract void mo607a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* JADX INFO: renamed from: a */
    void m625a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            boolean z = view instanceof ViewGroup;
            View view2 = view;
            if (z) {
                ViewGroup viewGroup = (ViewGroup) view;
                boolean zM999a = C0125q.m999a(viewGroup);
                view2 = viewGroup;
                if (!zM999a) {
                    int childCount = viewGroup.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        m625a(arrayList, viewGroup.getChildAt(i));
                    }
                    return;
                }
            }
            arrayList.add(view2);
        }
    }

    /* JADX INFO: renamed from: a */
    void m626a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String strM963e = C0124p.m963e(view);
            if (strM963e != null) {
                map.put(strM963e, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m626a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo608a(Object obj);

    /* JADX INFO: renamed from: b */
    public abstract Object mo609b(Object obj);

    /* JADX INFO: renamed from: b */
    public abstract Object mo610b(Object obj, Object obj2, Object obj3);

    /* JADX INFO: renamed from: b */
    public abstract void mo611b(Object obj, View view);

    /* JADX INFO: renamed from: b */
    public abstract void mo612b(Object obj, View view, ArrayList<View> arrayList);

    /* JADX INFO: renamed from: b */
    public abstract void mo613b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* JADX INFO: renamed from: c */
    public abstract Object mo614c(Object obj);

    /* JADX INFO: renamed from: c */
    public abstract void mo615c(Object obj, View view);
}
