package com.cssrc.bottomnavigationdemo.widget.spinkit.sprite;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;

/**
 * Author liuyangchao
 * Date on 2017/5/9.9:51
 */

public abstract class ShapeSprite extends Sprite {

    private Paint mPaint;
    private int mUseColor;
    private int mBaseColor;

    public ShapeSprite(){
        setColor(Color.WHITE);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);              //打开抗锯齿效果
        mPaint.setColor(mUseColor);
    }

    @Override
    public void setColor(int color) {
        mBaseColor = color;
        updateUseColor();                           //这个位移方法完全懵逼
    }

    @Override
    public int getColor() {
        return mBaseColor;
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public void setAlpha(int alpha) {
        super.setAlpha(alpha);
        updateUseColor();
    }

    @Override
    protected void drawSelf(Canvas canvas) {
        mPaint.setColor(mUseColor);
        drawShape(canvas, mPaint);
    }

    /**
     * 需要子类继承的抽象方法
     */
    public abstract void drawShape(Canvas canvas, Paint paint);

    /**
     * >>  有符号右移   >>>  无符号右移
     */
    private void updateUseColor(){
        int alpha = getAlpha();
        alpha += alpha >> 7;
        final int baseAlpha = mBaseColor >>> 24;
        final int useAlpha = baseAlpha * alpha >> 8;
        mUseColor = (mBaseColor << 8 >>> 8) | (useAlpha << 24);
    }

}
