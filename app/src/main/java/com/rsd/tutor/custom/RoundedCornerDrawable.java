package com.rsd.tutor.custom;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by Raukawa on 3/9/14.
 */
public class RoundedCornerDrawable extends Drawable {

    private static final boolean USE_VIGNETTE = false;

    private final float mConerRadius;
    private final RectF mRect = new RectF();
    private final BitmapShader mBitmapShader;
    private final Paint mPaint;
    private final int mMargin;

    public RoundedCornerDrawable(Bitmap bitmap, float conerRadius, int margin) {
        mConerRadius = conerRadius;

        mBitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(mBitmapShader);

        mMargin = margin;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);

        mRect.set(mMargin, mMargin, bounds.width() - mMargin, bounds.height() - mMargin);

        if (USE_VIGNETTE) {
            RadialGradient vignette = new RadialGradient(
                    mRect.centerX(),
                    mRect.centerY() * 1.0f / 0.7f,
                    mRect.centerX() * 1.3f,
                    new int[]{0, 0, 0x7f000000},
                    new float[] { .0f, 0.7f, 1.0f },
                    Shader.TileMode.CLAMP);

            Matrix oval = new Matrix();
            oval.setScale(1.0f, 0.7f);
            vignette.setLocalMatrix(oval);

            mPaint.setShader(new ComposeShader(mBitmapShader, vignette, PorterDuff.Mode.SRC_OVER));
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(mRect, mConerRadius, mConerRadius, mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}
