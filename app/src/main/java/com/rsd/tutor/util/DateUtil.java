package com.rsd.tutor.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wadereweti on 4/03/14.
 */
public class DateUtil {

    private static SimpleDateFormat durationFormatter = new SimpleDateFormat("mm");
    private static SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm");
    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMMM yyyy");

    public static String formatWorksheetDuration(Date time) {
        return durationFormatter.format(time);
    }

    public static String formatTime(Date time) {
        return timeFormatter.format(time);
    }

    public static String formatStandardDate(Date date) {
        return dateFormatter.format(date);
    }
}
