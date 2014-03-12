package com.rsd.tutor.widget.shimmer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;

/**
 * Created by Raukawa on 3/9/14.
 */
public class Shimmer {

    public static void animate(final ShimmerTextView shimmerTextView, final Animator.AnimatorListener animatorListener) {
        shimmerTextView.setShimmering(true);

        final Runnable animate = new Runnable() {
            @Override
            public void run() {
                ObjectAnimator animator = ObjectAnimator.ofFloat(shimmerTextView, "maskX", 0, shimmerTextView.getWidth());
                animator.setRepeatCount(0);
                animator.setDuration(20000);
                animator.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {}

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        shimmerTextView.setShimmering(false);
                        shimmerTextView.postInvalidate();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {}

                    @Override
                    public void onAnimationRepeat(Animator animation) {}
                });
                if (animatorListener != null) {
                    animator.addListener(animatorListener);
                }
                animator.start();
            }
        };

        if (!shimmerTextView.isSetUp()) {
            shimmerTextView.setAnimationSetupCallback(new ShimmerTextView.AnimationSetupCallback() {
                @Override
                public void onSetupAnimation(final ShimmerTextView shimmerTextView) {
                    animate.run();
                }
            });
        } else {
            animate.run();
        }
    }
}