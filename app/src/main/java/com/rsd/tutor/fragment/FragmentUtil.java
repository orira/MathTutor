package com.rsd.tutor.fragment;

import android.content.Context;
import android.content.res.Resources;

import com.rsd.tutor.R;
import com.rsd.tutor.activity.WorksheetAssessmentActivity;
import com.rsd.tutor.activity.WorksheetAssignedActivity;
import com.rsd.tutor.activity.WorksheetCompletedActivity;

/**
 * Created by Raukawa on 2/16/14.
 */
public class FragmentUtil {
    public static String getBookTitle(int position, Context context) {
        String title;

        switch (position) {
            case 0:
                title = context.getString(R.string.title_book_worksheets_assigned);
                break;
            case 1:
                title = context.getString(R.string.title_book_worksheets_completed);
                break;
            case 2:
                title = context.getString(R.string.title_book_assessments);
                break;
            default:
                title = "";
        }

        return title;
    }

    public static Class getDestinationActivity(int position) {
        Class clazz;
        switch (position) {
            case 0:
                clazz = WorksheetCompletedActivity.class;
                break;
            case 1:
                clazz = WorksheetAssignedActivity.class;
                break;
            case 2:
                clazz = WorksheetAssessmentActivity.class;
                break;
            default:
                clazz = null;
        }

        return clazz;
    }
}
