package com.rsd.tutor.util;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Raukawa on 2/24/14.
 */
public final class LogUtil {

    public static final SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss-SS");

    public static void logTime(String TAG, String text) {
        Log.d(TAG, text + " " + formatter.format(new Date()));
    }
}
