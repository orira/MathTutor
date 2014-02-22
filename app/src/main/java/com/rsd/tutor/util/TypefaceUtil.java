package com.rsd.tutor.util;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * Created by wadereweti on 9/02/14.
 */
public class TypefaceUtil {
    private static final String PREFIX = "fonts/Roboto-";
    private static final String SUFFIX = ".ttf";

    private static final String BLACK = "Italic";
    private static final String ITALIC = "Italic";
    private static final String BOLD = "Bold";
    private static final String LIGHT = "Light";
    private static final String MEDIUM = "Medium";
    private static final String REGULAR = "Regular";
    private static final String THIN = "Thin";


    public static Typeface getRobotoBold(Context context) {
        return Typeface.createFromAsset(context.getAssets(), PREFIX + BOLD + SUFFIX);
    }

    public static Typeface getThin(Context context) {
        return Typeface.createFromAsset(context.getAssets(), PREFIX + THIN + SUFFIX);
    }
}
