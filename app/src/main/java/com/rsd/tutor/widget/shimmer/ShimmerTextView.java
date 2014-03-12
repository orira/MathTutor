package com.rsd.tutor.widget.shimmer;

/**
 * Created by Raukawa on 3/9/14.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import com.rsd.tutor.R;

/**
 * Shimmer
 * User: romainpiel
 * Date: 06/03/2014
 * Time: 10:19
 */
public class ShimmerTextView extends TextView {

    private static final int DEFAULT_REFLECTION_COLOR = 0xFFFFFFFF;

    // center position of the gradient
    private float gradientX;
    private LinearGradientFactory linearGradientFactory;
    private int reflectionColor;

    // true when animating
    private boolean isShimmering;

    // true after first global layout
    private boolean isSetUp;

    // callback called after first global layout
    private AnimationSetupCallback callback;

    public interface AnimationSetupCallback {
        void onSetupAnimation(ShimmerTextView shimmerTextView);
    }

    public ShimmerTextView(Context context) {
        super(context);
        init(context, null);
    }

    public ShimmerTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ShimmerTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs);
    }

    public float getMaskX() {
        return gradientX;
    }

    protected void setMaskX(float maskX) {
        gradientX = maskX;
        invalidate();
    }

    public boolean isShimmering() {
        return isShimmering;
    }

    protected void setShimmering(boolean isShimmering) {
        this.isShimmering = isShimmering;
    }

    public boolean isSetUp() {
        return isSetUp;
    }

    public void setSetUp(boolean isSetUp) {
        this.isSetUp = isSetUp;
    }

    public void setAnimationSetupCallback(AnimationSetupCallback callback) {
        this.callback = callback;
    }

    private void init(Context context, AttributeSet attributeSet) {

        reflectionColor = DEFAULT_REFLECTION_COLOR;

        if (attributeSet != null) {
            TypedArray a = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerTextView, 0, 0);
            if (a != null) {
                try {
                    reflectionColor = a.getColor(R.styleable.ShimmerTextView_reflectionColor, DEFAULT_REFLECTION_COLOR);
                } catch (Exception e) {
                    android.util.Log.e("ShimmerTextView", "Error while creating the view:", e);
                } finally {
                    a.recycle();
                }
            }
        }

        linearGradientFactory = new LinearGradientFactory();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {

                isSetUp = true;

                if (callback != null) {
                    callback.onSetupAnimation(ShimmerTextView.this);
                }

                getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {

        // only draw the shader gradient over the text while animating
        if (isShimmering) {
            getPaint().setShader(linearGradientFactory.resize(getWidth(), getHeight()));
        } else {
            getPaint().setShader(null);
        }

        super.onDraw(canvas);
    }

    /**
     * Factory class creating LinearGradient shaders. The shader is based on current value of gradientX
     */
    private class LinearGradientFactory extends ShapeDrawable.ShaderFactory {

        @Override
        public Shader resize(int width, int height) {

            // our linear gradient's width is 3 times bigger than the view's width
            // it is divided in 4 parts:
            // - text color
            // - gradient text color - reflection color
            // - gradient reflection color - text color
            // - text color
            // addition of two central parts width = view width

            float delta = gradientX / (float) getWidth();
            int textColor = getCurrentTextColor();

            return new LinearGradient(-width, 0, 2 * width, 0,
                    new int[]{
                            textColor,
                            textColor,
                            reflectionColor,
                            textColor,
                            textColor
                    },
                    new float[]{
                            0,
                            delta - 1f / 6f,
                            delta,
                            delta + 1f / 6f,
                            1
                    },
                    Shader.TileMode.CLAMP);
        }
    }
}
