package com.rsd.tutor.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.rsd.tutor.util.TypefaceUtil;

/**
 * Created by wadereweti on 26/02/14.
 */
public class RobotoBoldTextView extends TextView
{
    public RobotoBoldTextView(Context context) {
        super(context);
        init(context);
    }

public RobotoBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public RobotoBoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        this.setTypeface(TypefaceUtil.getRobotoBold(context));
    }
}
