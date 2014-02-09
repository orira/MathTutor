package com.rsd.tutor.custom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by wadereweti on 9/02/14.
 */
public class DeleteEditText extends EditText implements TextWatcher, View.OnTouchListener {

    private Drawable mDeleteDrawable;
    private TextWatcherCallBack mCallBack;

    public DeleteEditText(Context context) {
        super(context);
        setupDrawable(context);
        this.setOnTouchListener(this);
    }

    public DeleteEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setupDrawable(context);
        this.setOnTouchListener(this);
    }

    public DeleteEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setupDrawable(context);
        this.setOnTouchListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() > 0) {
            this.setCompoundDrawablesWithIntrinsicBounds(null, null, mDeleteDrawable, null);
        } else {
            this.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        }

        if (mCallBack != null) {
            mCallBack.textLengthChanged();
        }
    }

    @Override
    public void afterTextChanged(Editable s) {}

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (withinDrawableBounds(event.getX())) {
                    clearText();
                }

                break;
        }

        return false;
    }

    private void setupDrawable(Context context) {
        mDeleteDrawable = context.getResources().getDrawable(android.R.drawable.ic_delete);
    }

    private boolean withinDrawableBounds(float x) {
        float parentWidth = this.getWidth();
        float width = mDeleteDrawable.getIntrinsicWidth();
        float slop = 10;
        float horizontalThreshold = parentWidth - width - slop;

        boolean withinBounds;

        if (x >= horizontalThreshold) {
            withinBounds = true;
        } else {
            withinBounds = false;
        }

        return withinBounds;
    }

    private void clearText() {
        this.setText("");
    }

    public void setTextWatcherCallBack(TextWatcherCallBack callBack) {
        mCallBack = callBack;
    }
}
