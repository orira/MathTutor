package com.rsd.tutor.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.Property;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.rsd.tutor.R;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Raukawa on 2/22/14.
 */
public class FireworksSpanBuilder {

    private SpannableString mSpannableString;
    private AccelerateDecelerateInterpolator mSmoothInterpolator;
    private CharSequence mTextToTransform;
    private final Activity mTargetActivity;
    private Set<Object> mSpans = new HashSet<Object>();

    public FireworksSpanBuilder(Activity targetActivity) {
        mTargetActivity = targetActivity;
        mTextToTransform = targetActivity.getTitle();
        mSmoothInterpolator = new AccelerateDecelerateInterpolator();
    }

    public void runFireworksAnimation() {
        initialiseSpan();
        FireworksSpanGroup spanGroup = buildFireworksSpanGroup(0, mTextToTransform.length() - 1);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(spanGroup, FireworksSpanGroup.FIREWORKS_GROUP_PROGRESS_PROPERTY, 0.0f, 1.0f);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //refresh
                mTargetActivity.setTitle(mSpannableString);
            }
        });

        objectAnimator.setInterpolator(mSmoothInterpolator);
        objectAnimator.setDuration(mTargetActivity.getResources().getInteger(R.integer.animation_duration_fireworks));
        objectAnimator.start();
    }

    private void initialiseSpan() {
        mSpannableString = new SpannableString(mTextToTransform);
    }

    private FireworksSpanGroup buildFireworksSpanGroup(int start, int end) {
        final FireworksSpanGroup group = new FireworksSpanGroup();
        for(int index = start ; index <= end ; index++) {
            MutableForegroundColorSpan span = new MutableForegroundColorSpan(0, Color.WHITE);
            mSpans.add(span);
            group.addSpan(span);
            mSpannableString.setSpan(span, index, index + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        group.init();
        return group;
    }
}
