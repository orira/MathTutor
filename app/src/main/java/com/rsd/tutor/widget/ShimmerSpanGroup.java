package com.rsd.tutor.widget;

/**
 * Created by Raukawa on 2/22/14.
 */

import android.content.Context;
import android.util.Log;
import android.util.Property;

public final class ShimmerSpanGroup extends AbstractSpanGroup{

    private static final String TAG = "ShimmerSpanGroup";
    private final Context mContext;
    private int mDefaultColour;
    private int mReflectedColour;

    public ShimmerSpanGroup(Context context) {
        mContext = context;
        mDefaultColour = context.getResources().getColor(android.R.color.black);
        mReflectedColour = context.getResources().getColor(android.R.color.white);
    }

    public void init() {
        // Do nothing
    }

    public void setProgress(float progress) {
        int size = mSpans.size();
        float total = 1.0f * size * progress;

        if (DEBUG) Log.d(TAG, "progress " + progress + " * 1.0f * size => " + total);

        for (int index = 0 ; index < size; index++) {
            MutableForegroundColorSpan span = mSpans.get(index);

            if(total >= 1.0f) {
                // Set colour back to original
                span.setForegroundColor(mDefaultColour);
                total -= 1.0f;
            } else {
                // Set reflected colour
                span.setForegroundColor(mReflectedColour);
                total = 0.0f;
            }
        }
    }

    public static final Property<ShimmerSpanGroup, Float> SHIMMER_GROUP_PROGRESS_PROPERTY =
            new Property<ShimmerSpanGroup, Float>(Float.class, "SHIMMER_GROUP_PROGRESS_PROPERTY") {

                @Override
                public void set(ShimmerSpanGroup spanGroup, Float value) {
                    spanGroup.setProgress(value);
                }

                @Override
                public Float get(ShimmerSpanGroup spanGroup) {
                    return spanGroup.getProgress();
                }
            };
}