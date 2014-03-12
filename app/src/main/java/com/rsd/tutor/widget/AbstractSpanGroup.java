package com.rsd.tutor.widget;

/**
 * Created by Raukawa on 2/22/14.
 */

import android.util.Log;
import android.util.Property;

import java.util.ArrayList;
import java.util.Collections;

public abstract class AbstractSpanGroup {

    protected static final boolean DEBUG = false;

    protected final float mProgress;
    protected final ArrayList<MutableForegroundColorSpan> mSpans;
    protected final ArrayList<Integer> mSpanIndexes;

    public AbstractSpanGroup() {
        mProgress = 0;
        mSpans = new ArrayList<MutableForegroundColorSpan>();
        mSpanIndexes = new ArrayList<Integer>();
    }

    public void addSpan(MutableForegroundColorSpan span) {
        mSpanIndexes.add(mSpans.size());
        mSpans.add(span);
    }

    protected abstract void init();

    protected abstract void setProgress(float progress);

    public float getProgress() {
        return mProgress;
    }
}