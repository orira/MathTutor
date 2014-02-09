package com.rsd.tutor.util;

import android.content.Context;
import android.util.TypedValue;

import com.rsd.tutor.R;

/**
 * Created by wadereweti on 9/02/14.
 */
public class TypeValueUtil {
    public static float getFloatValue(int id, Context context) {
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(id, typedValue, true);
        return typedValue.getFloat();
    }
}
