package com.rsd.tutor.util;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;

import com.rsd.tutor.R;
import com.rsd.tutor.activity.UserInteraction;

/**
 * Created by wadereweti on 9/02/14.
 */
public class AnimationUtil {
    public static Bundle getNewNodeAnimation(Context context) {
        return ActivityOptions.makeCustomAnimation(context, R.anim.slide_in_bottom, R.anim.slide_out_top_parallax).toBundle();
    }

    public static void runOvershootAnimationOnClick(final View view, final UserInteraction userInteraction, final int position) {
        final int animationDuration = view.getContext().getResources().getInteger(R.integer.duration_animation_click);
        float scaleFactor = TypeValueUtil.getFloatValue(R.dimen.scale_factor_click, view.getContext());
        final int tension = view.getContext().getResources().getInteger(R.integer.animation_tension);

        view.animate().setDuration(animationDuration).scaleY(scaleFactor).scaleX(scaleFactor).withEndAction(new Runnable() {
            @Override
            public void run() {
                view.animate().setDuration(animationDuration).scaleY(1).scaleX(1).setInterpolator(new OvershootInterpolator(tension)).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        userInteraction.workItemSelected(position);
                    }
                });
            }
        });
    }
}
