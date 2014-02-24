package com.rsd.tutor.util;

import android.util.DisplayMetrics;

import com.rsd.tutor.KaiakoApplication;

/**
 * Created by Raukawa on 2/24/14.
 */
public class DisplayUtil {
    private static final int HDPI = 240;
    private static final int XHDPI = 320;
    private static final int XXHDPI = 400;

    public static boolean isHdpi() {
        DisplayMetrics metrics = KaiakoApplication.getInstance().getResources().getDisplayMetrics();
        return metrics.density * 160f >= HDPI;
    }

    public static boolean isXhdpi() {
        DisplayMetrics metrics = KaiakoApplication.getInstance().getResources().getDisplayMetrics();
        return metrics.density * 160f >= XHDPI;
    }

    public static boolean isXxhdpi() {
        DisplayMetrics metrics = KaiakoApplication.getInstance().getResources().getDisplayMetrics();
        return metrics.density * 160f >= XXHDPI;
    }
}
