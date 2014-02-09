package com.rsd.tutor.util;

import android.app.ActivityOptions;
import android.content.Context;
import android.os.Bundle;

import com.rsd.tutor.R;

/**
 * Created by wadereweti on 9/02/14.
 */
public class AnimationUtil {
    public static Bundle getNewNodeAnimation(Context context) {
        return ActivityOptions.makeCustomAnimation(context, R.anim.slide_in_bottom, R.anim.slide_out_top_parallax).toBundle();
    }
}
