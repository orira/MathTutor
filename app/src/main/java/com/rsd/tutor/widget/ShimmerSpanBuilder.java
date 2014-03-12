package com.rsd.tutor.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Raukawa on 3/9/14.
 */
public class ShimmerSpanBuilder {
    private SpannableString mSpannableString;
    private AccelerateDecelerateInterpolator mSmoothInterpolator;
    private Button mButton;
    private CharSequence mTextToTransform;
    private Set<Object> mSpans = new HashSet<Object>();

    public ShimmerSpanBuilder(Button button) {
        mButton = button;
        mTextToTransform = button.getText();
        mSmoothInterpolator = new AccelerateDecelerateInterpolator();
    }

    public void runShimmerAnimation() {
        initialiseSpan();
        ShimmerSpanGroup spanGroup = buildShimmerSpanGroup(0, mTextToTransform.length() - 1);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(spanGroup, ShimmerSpanGroup.SHIMMER_GROUP_PROGRESS_PROPERTY, 0.0f, 1.0f);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //refresh
                mButton.setText(mSpannableString);
            }
        });

        objectAnimator.setInterpolator(mSmoothInterpolator);
        objectAnimator.setDuration(150);
        objectAnimator.start();
    }

    private void initialiseSpan() {
        mSpannableString = new SpannableString(mTextToTransform);
    }

    private ShimmerSpanGroup buildShimmerSpanGroup(int start, int end) {
        final ShimmerSpanGroup group = new ShimmerSpanGroup(mButton.getContext());
        for(int index = start ; index <= end ; index++) {
            MutableForegroundColorSpan span = new MutableForegroundColorSpan(255, Color.BLACK);
            mSpans.add(span);
            group.addSpan(span);
            mSpannableString.setSpan(span, index, index + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        group.init();
        return group;
    }
}
