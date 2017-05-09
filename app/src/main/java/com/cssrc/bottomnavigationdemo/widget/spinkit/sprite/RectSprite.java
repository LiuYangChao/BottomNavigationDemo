package com.cssrc.bottomnavigationdemo.widget.spinkit.sprite;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Author liuyangchao
 * Date on 2017/5/9.11:06
 */

public class RectSprite extends ShapeSprite {
    /**
     * 这个方法是抽象类ShapeSprite声明的抽象方法
     * 如果边界不为空，就绘制这个View
     * @param canvas
     * @param paint
     */
    @Override
    public void drawShape(Canvas canvas, Paint paint) {
        if(getDrawBounds() != null){
            canvas.drawRect(getDrawBounds(), paint);
        }
    }

    @Override
    public ValueAnimator onCreateAnimation() {
        return null;
    }
}
