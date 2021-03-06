package com.rsd.tutor.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.rsd.tutor.util.TypefaceUtil;

/**
 * Created by wadereweti on 26/02/14.
 */
public class RobotoThinTextView extends TextView {
    public RobotoThinTextView(Context context) {
        super(context);
        if (!isInEditMode()) {
            init(context);
        }
    }

public RobotoThinTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            init(context);
        }
    }

    public RobotoThinTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (!isInEditMode()) {
            init(context);
        }
    }

    private void init(Context context) {
        setTypeface(TypefaceUtil.getRobotoThin(context));
    }

    @Override
    public boolean isInEditMode () {
        return true;
    }
}
