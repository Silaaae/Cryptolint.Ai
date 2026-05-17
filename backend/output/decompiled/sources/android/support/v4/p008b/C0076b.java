package android.support.v4.p008b;

import android.graphics.Path;
import android.support.v7.p018a.C0148a;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: renamed from: android.support.v4.b.b */
/* JADX INFO: loaded from: classes.dex */
public class C0076b {

    /* JADX INFO: renamed from: android.support.v4.b.b$a */
    private static class a {

        /* JADX INFO: renamed from: a */
        int f508a;

        /* JADX INFO: renamed from: b */
        boolean f509b;

        a() {
        }
    }

    /* JADX INFO: renamed from: android.support.v4.b.b$b */
    public static class b {

        /* JADX INFO: renamed from: a */
        public char f510a;

        /* JADX INFO: renamed from: b */
        public float[] f511b;

        b(char c, float[] fArr) {
            this.f510a = c;
            this.f511b = fArr;
        }

        b(b bVar) {
            this.f510a = bVar.f510a;
            this.f511b = C0076b.m673a(bVar.f511b, 0, bVar.f511b.length);
        }

        /* JADX INFO: renamed from: a */
        private static void m678a(Path path, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
            double d10 = d3;
            int iCeil = (int) Math.ceil(Math.abs((d9 * 4.0d) / 3.141592653589793d));
            double dCos = Math.cos(d7);
            double dSin = Math.sin(d7);
            double dCos2 = Math.cos(d8);
            double dSin2 = Math.sin(d8);
            double d11 = -d10;
            double d12 = d11 * dCos;
            double d13 = d4 * dSin;
            double d14 = (d12 * dSin2) - (d13 * dCos2);
            double d15 = d11 * dSin;
            double d16 = d4 * dCos;
            double d17 = (dSin2 * d15) + (dCos2 * d16);
            double d18 = iCeil;
            Double.isNaN(d18);
            double d19 = d9 / d18;
            int i = 0;
            double d20 = d6;
            double d21 = d17;
            double d22 = d14;
            double d23 = d5;
            double d24 = d8;
            while (i < iCeil) {
                double d25 = d24 + d19;
                double dSin3 = Math.sin(d25);
                double dCos3 = Math.cos(d25);
                double d26 = d19;
                double d27 = (d + ((d10 * dCos) * dCos3)) - (d13 * dSin3);
                double d28 = d2 + (d10 * dSin * dCos3) + (d16 * dSin3);
                double d29 = (d12 * dSin3) - (d13 * dCos3);
                double d30 = (dSin3 * d15) + (dCos3 * d16);
                double d31 = d25 - d24;
                double dTan = Math.tan(d31 / 2.0d);
                double dSin4 = (Math.sin(d31) * (Math.sqrt(((dTan * 3.0d) * dTan) + 4.0d) - 1.0d)) / 3.0d;
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) (d23 + (d22 * dSin4)), (float) (d20 + (d21 * dSin4)), (float) (d27 - (dSin4 * d29)), (float) (d28 - (dSin4 * d30)), (float) d27, (float) d28);
                i++;
                d20 = d28;
                d23 = d27;
                d24 = d25;
                d21 = d30;
                d22 = d29;
                d19 = d26;
                d16 = d16;
                d15 = d15;
                iCeil = iCeil;
                dCos = dCos;
                dSin = dSin;
                d10 = d3;
            }
        }

        /* JADX INFO: renamed from: a */
        private static void m679a(Path path, float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, boolean z2) {
            double d;
            double d2;
            double radians = Math.toRadians(f7);
            double dCos = Math.cos(radians);
            double dSin = Math.sin(radians);
            double d3 = f;
            Double.isNaN(d3);
            double d4 = d3 * dCos;
            double d5 = f2;
            Double.isNaN(d5);
            double d6 = f5;
            Double.isNaN(d6);
            double d7 = (d4 + (d5 * dSin)) / d6;
            double d8 = -f;
            Double.isNaN(d8);
            Double.isNaN(d5);
            double d9 = (d8 * dSin) + (d5 * dCos);
            double d10 = f6;
            Double.isNaN(d10);
            double d11 = d9 / d10;
            double d12 = f3;
            Double.isNaN(d12);
            double d13 = f4;
            Double.isNaN(d13);
            Double.isNaN(d6);
            double d14 = ((d12 * dCos) + (d13 * dSin)) / d6;
            double d15 = -f3;
            Double.isNaN(d15);
            Double.isNaN(d13);
            Double.isNaN(d10);
            double d16 = ((d15 * dSin) + (d13 * dCos)) / d10;
            double d17 = d7 - d14;
            double d18 = d11 - d16;
            double d19 = (d7 + d14) / 2.0d;
            double d20 = (d11 + d16) / 2.0d;
            double d21 = (d17 * d17) + (d18 * d18);
            if (d21 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d22 = (1.0d / d21) - 0.25d;
            if (d22 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d21);
                float fSqrt = (float) (Math.sqrt(d21) / 1.99999d);
                m679a(path, f, f2, f3, f4, f5 * fSqrt, f6 * fSqrt, f7, z, z2);
                return;
            }
            double dSqrt = Math.sqrt(d22);
            double d23 = d17 * dSqrt;
            double d24 = dSqrt * d18;
            if (z == z2) {
                d = d19 - d24;
                d2 = d20 + d23;
            } else {
                d = d19 + d24;
                d2 = d20 - d23;
            }
            double dAtan2 = Math.atan2(d11 - d2, d7 - d);
            double dAtan22 = Math.atan2(d16 - d2, d14 - d) - dAtan2;
            if (z2 != (dAtan22 >= 0.0d)) {
                dAtan22 = dAtan22 > 0.0d ? dAtan22 - 6.283185307179586d : dAtan22 + 6.283185307179586d;
            }
            Double.isNaN(d6);
            double d25 = d * d6;
            Double.isNaN(d10);
            double d26 = d2 * d10;
            m678a(path, (d25 * dCos) - (d26 * dSin), (d25 * dSin) + (d26 * dCos), d6, d10, d3, d5, radians, dAtan2, dAtan22);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX INFO: renamed from: a */
        private static void m680a(Path path, float[] fArr, char c, char c2, float[] fArr2) {
            int i;
            int i2;
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[2];
            float f15 = fArr[3];
            float f16 = fArr[4];
            float f17 = fArr[5];
            switch (c2) {
                case C0148a.j.AppCompatTheme_editTextBackground /* 65 */:
                case C0148a.j.AppCompatTheme_textAppearanceListItemSecondary /* 97 */:
                    i = 7;
                    break;
                case C0148a.j.AppCompatTheme_editTextStyle /* 67 */:
                case C0148a.j.AppCompatTheme_textAppearancePopupMenuHeader /* 99 */:
                    i = 6;
                    break;
                case C0148a.j.AppCompatTheme_listMenuViewStyle /* 72 */:
                case C0148a.j.AppCompatTheme_ratingBarStyleIndicator /* 86 */:
                case C0148a.j.AppCompatTheme_textColorSearchUrl /* 104 */:
                case 'v':
                    i = 1;
                    break;
                case C0148a.j.AppCompatTheme_listPreferredItemHeightSmall /* 76 */:
                case C0148a.j.AppCompatTheme_listPreferredItemPaddingLeft /* 77 */:
                case C0148a.j.AppCompatTheme_radioButtonStyle /* 84 */:
                case C0148a.j.AppCompatTheme_tooltipFrameBackground /* 108 */:
                case 'm':
                case 't':
                default:
                    i = 2;
                    break;
                case C0148a.j.AppCompatTheme_panelMenuListWidth /* 81 */:
                case C0148a.j.AppCompatTheme_popupWindowStyle /* 83 */:
                case 'q':
                case 's':
                    i = 4;
                    break;
                case C0148a.j.AppCompatTheme_selectableItemBackground /* 90 */:
                case 'z':
                    path.close();
                    path.moveTo(f16, f17);
                    f12 = f16;
                    f14 = f12;
                    f13 = f17;
                    f15 = f13;
                    i = 2;
                    break;
            }
            float f18 = f12;
            float f19 = f13;
            float f20 = f16;
            float f21 = f17;
            int i3 = 0;
            char c3 = c;
            while (i3 < fArr2.length) {
                float f22 = 0.0f;
                switch (c2) {
                    case C0148a.j.AppCompatTheme_editTextBackground /* 65 */:
                        i2 = i3;
                        int i4 = i2 + 5;
                        int i5 = i2 + 6;
                        m679a(path, f18, f19, fArr2[i4], fArr2[i5], fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i2 + 2], fArr2[i2 + 3] != 0.0f, fArr2[i2 + 4] != 0.0f);
                        f18 = fArr2[i4];
                        f19 = fArr2[i5];
                        f15 = f19;
                        f14 = f18;
                        break;
                    case C0148a.j.AppCompatTheme_editTextStyle /* 67 */:
                        i2 = i3;
                        int i6 = i2 + 2;
                        int i7 = i2 + 3;
                        int i8 = i2 + 4;
                        int i9 = i2 + 5;
                        path.cubicTo(fArr2[i2 + 0], fArr2[i2 + 1], fArr2[i6], fArr2[i7], fArr2[i8], fArr2[i9]);
                        f18 = fArr2[i8];
                        float f23 = fArr2[i9];
                        float f24 = fArr2[i6];
                        float f25 = fArr2[i7];
                        f19 = f23;
                        f15 = f25;
                        f14 = f24;
                        break;
                    case C0148a.j.AppCompatTheme_listMenuViewStyle /* 72 */:
                        i2 = i3;
                        int i10 = i2 + 0;
                        path.lineTo(fArr2[i10], f19);
                        f18 = fArr2[i10];
                        break;
                    case C0148a.j.AppCompatTheme_listPreferredItemHeightSmall /* 76 */:
                        i2 = i3;
                        int i11 = i2 + 0;
                        int i12 = i2 + 1;
                        path.lineTo(fArr2[i11], fArr2[i12]);
                        f18 = fArr2[i11];
                        f19 = fArr2[i12];
                        break;
                    case C0148a.j.AppCompatTheme_listPreferredItemPaddingLeft /* 77 */:
                        i2 = i3;
                        int i13 = i2 + 0;
                        f18 = fArr2[i13];
                        int i14 = i2 + 1;
                        f19 = fArr2[i14];
                        if (i2 <= 0) {
                            path.moveTo(fArr2[i13], fArr2[i14]);
                            f21 = f19;
                            f20 = f18;
                        } else {
                            path.lineTo(fArr2[i13], fArr2[i14]);
                        }
                        break;
                    case C0148a.j.AppCompatTheme_panelMenuListWidth /* 81 */:
                        i2 = i3;
                        int i15 = i2 + 0;
                        int i16 = i2 + 1;
                        int i17 = i2 + 2;
                        int i18 = i2 + 3;
                        path.quadTo(fArr2[i15], fArr2[i16], fArr2[i17], fArr2[i18]);
                        f = fArr2[i15];
                        f2 = fArr2[i16];
                        f18 = fArr2[i17];
                        f19 = fArr2[i18];
                        f14 = f;
                        f15 = f2;
                        break;
                    case C0148a.j.AppCompatTheme_popupWindowStyle /* 83 */:
                        float f26 = f19;
                        float f27 = f18;
                        i2 = i3;
                        if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                            float f28 = (f27 * 2.0f) - f14;
                            f3 = (f26 * 2.0f) - f15;
                            f4 = f28;
                        } else {
                            f4 = f27;
                            f3 = f26;
                        }
                        int i19 = i2 + 0;
                        int i20 = i2 + 1;
                        int i21 = i2 + 2;
                        int i22 = i2 + 3;
                        path.cubicTo(f4, f3, fArr2[i19], fArr2[i20], fArr2[i21], fArr2[i22]);
                        f = fArr2[i19];
                        f2 = fArr2[i20];
                        f18 = fArr2[i21];
                        f19 = fArr2[i22];
                        f14 = f;
                        f15 = f2;
                        break;
                    case C0148a.j.AppCompatTheme_radioButtonStyle /* 84 */:
                        float f29 = f19;
                        float f30 = f18;
                        i2 = i3;
                        if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                            f29 = (f29 * 2.0f) - f15;
                            f30 = (f30 * 2.0f) - f14;
                        }
                        int i23 = i2 + 0;
                        int i24 = i2 + 1;
                        path.quadTo(f30, f29, fArr2[i23], fArr2[i24]);
                        f18 = fArr2[i23];
                        f19 = fArr2[i24];
                        f14 = f30;
                        f15 = f29;
                        break;
                    case C0148a.j.AppCompatTheme_ratingBarStyleIndicator /* 86 */:
                        i2 = i3;
                        int i25 = i2 + 0;
                        path.lineTo(f18, fArr2[i25]);
                        f19 = fArr2[i25];
                        break;
                    case C0148a.j.AppCompatTheme_textAppearanceListItemSecondary /* 97 */:
                        int i26 = i3 + 5;
                        float f31 = fArr2[i26] + f18;
                        int i27 = i3 + 6;
                        float f32 = fArr2[i27] + f19;
                        float f33 = fArr2[i3 + 0];
                        float f34 = fArr2[i3 + 1];
                        float f35 = fArr2[i3 + 2];
                        float f36 = f18;
                        boolean z = fArr2[i3 + 3] != 0.0f;
                        i2 = i3;
                        m679a(path, f18, f19, f31, f32, f33, f34, f35, z, fArr2[i3 + 4] != 0.0f);
                        f18 = f36 + fArr2[i26];
                        f19 += fArr2[i27];
                        f15 = f19;
                        f14 = f18;
                        break;
                    case C0148a.j.AppCompatTheme_textAppearancePopupMenuHeader /* 99 */:
                        int i28 = i3 + 2;
                        int i29 = i3 + 3;
                        int i30 = i3 + 4;
                        int i31 = i3 + 5;
                        path.rCubicTo(fArr2[i3 + 0], fArr2[i3 + 1], fArr2[i28], fArr2[i29], fArr2[i30], fArr2[i31]);
                        f5 = fArr2[i28] + f18;
                        f6 = fArr2[i29] + f19;
                        f18 += fArr2[i30];
                        f7 = fArr2[i31];
                        f19 += f7;
                        f14 = f5;
                        f15 = f6;
                        i2 = i3;
                        break;
                    case C0148a.j.AppCompatTheme_textColorSearchUrl /* 104 */:
                        int i32 = i3 + 0;
                        path.rLineTo(fArr2[i32], 0.0f);
                        f18 += fArr2[i32];
                        i2 = i3;
                        break;
                    case C0148a.j.AppCompatTheme_tooltipFrameBackground /* 108 */:
                        int i33 = i3 + 0;
                        int i34 = i3 + 1;
                        path.rLineTo(fArr2[i33], fArr2[i34]);
                        f18 += fArr2[i33];
                        f8 = fArr2[i34];
                        f19 += f8;
                        i2 = i3;
                        break;
                    case 'm':
                        int i35 = i3 + 0;
                        f18 += fArr2[i35];
                        int i36 = i3 + 1;
                        f19 += fArr2[i36];
                        if (i3 > 0) {
                            path.rLineTo(fArr2[i35], fArr2[i36]);
                        } else {
                            path.rMoveTo(fArr2[i35], fArr2[i36]);
                            f21 = f19;
                            f20 = f18;
                        }
                        i2 = i3;
                        break;
                    case 'q':
                        int i37 = i3 + 0;
                        int i38 = i3 + 1;
                        int i39 = i3 + 2;
                        int i40 = i3 + 3;
                        path.rQuadTo(fArr2[i37], fArr2[i38], fArr2[i39], fArr2[i40]);
                        f5 = fArr2[i37] + f18;
                        f6 = fArr2[i38] + f19;
                        f18 += fArr2[i39];
                        f7 = fArr2[i40];
                        f19 += f7;
                        f14 = f5;
                        f15 = f6;
                        i2 = i3;
                        break;
                    case 's':
                        if (c3 == 'c' || c3 == 's' || c3 == 'C' || c3 == 'S') {
                            float f37 = f18 - f14;
                            f9 = f19 - f15;
                            f10 = f37;
                        } else {
                            f10 = 0.0f;
                            f9 = 0.0f;
                        }
                        int i41 = i3 + 0;
                        int i42 = i3 + 1;
                        int i43 = i3 + 2;
                        int i44 = i3 + 3;
                        path.rCubicTo(f10, f9, fArr2[i41], fArr2[i42], fArr2[i43], fArr2[i44]);
                        f5 = fArr2[i41] + f18;
                        f6 = fArr2[i42] + f19;
                        f18 += fArr2[i43];
                        f7 = fArr2[i44];
                        f19 += f7;
                        f14 = f5;
                        f15 = f6;
                        i2 = i3;
                        break;
                    case 't':
                        if (c3 == 'q' || c3 == 't' || c3 == 'Q' || c3 == 'T') {
                            f22 = f18 - f14;
                            f11 = f19 - f15;
                        } else {
                            f11 = 0.0f;
                        }
                        int i45 = i3 + 0;
                        int i46 = i3 + 1;
                        path.rQuadTo(f22, f11, fArr2[i45], fArr2[i46]);
                        float f38 = f22 + f18;
                        float f39 = f11 + f19;
                        f18 += fArr2[i45];
                        f19 += fArr2[i46];
                        f15 = f39;
                        f14 = f38;
                        i2 = i3;
                        break;
                    case 'v':
                        int i47 = i3 + 0;
                        path.rLineTo(0.0f, fArr2[i47]);
                        f8 = fArr2[i47];
                        f19 += f8;
                        i2 = i3;
                        break;
                    default:
                        i2 = i3;
                        break;
                }
                i3 = i2 + i;
                c3 = c2;
            }
            fArr[0] = f18;
            fArr[1] = f19;
            fArr[2] = f14;
            fArr[3] = f15;
            fArr[4] = f20;
            fArr[5] = f21;
        }

        /* JADX INFO: renamed from: a */
        public static void m681a(b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c = 'm';
            for (int i = 0; i < bVarArr.length; i++) {
                m680a(path, fArr, c, bVarArr[i].f510a, bVarArr[i].f511b);
                c = bVarArr[i].f510a;
            }
        }

        /* JADX INFO: renamed from: a */
        public void m682a(b bVar, b bVar2, float f) {
            for (int i = 0; i < bVar.f511b.length; i++) {
                this.f511b[i] = (bVar.f511b[i] * (1.0f - f)) + (bVar2.f511b[i] * f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static int m668a(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (((cCharAt - 'A') * (cCharAt - 'Z') <= 0 || (cCharAt - 'a') * (cCharAt - 'z') <= 0) && cCharAt != 'e' && cCharAt != 'E') {
                return i;
            }
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public static Path m669a(String str) {
        Path path = new Path();
        b[] bVarArrM676b = m676b(str);
        if (bVarArrM676b == null) {
            return null;
        }
        try {
            b.m681a(bVarArrM676b, path);
            return path;
        } catch (RuntimeException e) {
            throw new RuntimeException("Error in parsing " + str, e);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002c, code lost:
    
        if (r2 == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0038 A[LOOP:0: B:3:0x0007->B:24:0x0038, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x003b A[SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m670a(String str, int i, a aVar) {
        aVar.f509b = false;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (int i2 = i; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == ' ') {
                z = false;
                z3 = true;
                if (z3) {
                }
            } else {
                if (cCharAt != 'E' && cCharAt != 'e') {
                    switch (cCharAt) {
                        case C0148a.j.AppCompatTheme_buttonStyle /* 44 */:
                            break;
                        case C0148a.j.AppCompatTheme_buttonStyleSmall /* 45 */:
                            if (i2 != i) {
                            }
                            z = false;
                            break;
                        case C0148a.j.AppCompatTheme_checkboxStyle /* 46 */:
                            if (!z2) {
                                z = false;
                                z2 = true;
                            }
                            aVar.f509b = true;
                            z = false;
                            z3 = true;
                            break;
                        default:
                            z = false;
                            break;
                    }
                } else {
                    z = true;
                }
                if (z3) {
                }
            }
            aVar.f508a = i2;
        }
        aVar.f508a = i2;
    }

    /* JADX INFO: renamed from: a */
    private static void m671a(ArrayList<b> arrayList, char c, float[] fArr) {
        arrayList.add(new b(c, fArr));
    }

    /* JADX INFO: renamed from: a */
    public static boolean m672a(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i = 0; i < bVarArr.length; i++) {
            if (bVarArr[i].f510a != bVarArr2[i].f510a || bVarArr[i].f511b.length != bVarArr2[i].f511b.length) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    static float[] m673a(float[] fArr, int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i < 0 || i > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i3 = i2 - i;
        int iMin = Math.min(i3, length - i);
        float[] fArr2 = new float[i3];
        System.arraycopy(fArr, i, fArr2, 0, iMin);
        return fArr2;
    }

    /* JADX INFO: renamed from: a */
    public static b[] m674a(b[] bVarArr) {
        if (bVarArr == null) {
            return null;
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr2[i] = new b(bVarArr[i]);
        }
        return bVarArr2;
    }

    /* JADX INFO: renamed from: b */
    public static void m675b(b[] bVarArr, b[] bVarArr2) {
        for (int i = 0; i < bVarArr2.length; i++) {
            bVarArr[i].f510a = bVarArr2[i].f510a;
            for (int i2 = 0; i2 < bVarArr2[i].f511b.length; i2++) {
                bVarArr[i].f511b[i2] = bVarArr2[i].f511b[i2];
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static b[] m676b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 0;
        while (i < str.length()) {
            int iM668a = m668a(str, i);
            String strTrim = str.substring(i2, iM668a).trim();
            if (strTrim.length() > 0) {
                m671a((ArrayList<b>) arrayList, strTrim.charAt(0), m677c(strTrim));
            }
            i2 = iM668a;
            i = iM668a + 1;
        }
        if (i - i2 == 1 && i2 < str.length()) {
            m671a((ArrayList<b>) arrayList, str.charAt(i2), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[arrayList.size()]);
    }

    /* JADX INFO: renamed from: c */
    private static float[] m677c(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i = 1;
            int i2 = 0;
            while (i < length) {
                m670a(str, i, aVar);
                int i3 = aVar.f508a;
                if (i < i3) {
                    fArr[i2] = Float.parseFloat(str.substring(i, i3));
                    i2++;
                }
                i = aVar.f509b ? i3 : i3 + 1;
            }
            return m673a(fArr, 0, i2);
        } catch (NumberFormatException e) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e);
        }
    }
}
