package com.cssrc.bottomnavigationdemo.widget.spinkit.style;

import android.animation.ValueAnimator;
import android.graphics.Rect;

import com.cssrc.bottomnavigationdemo.widget.spinkit.sprite.RectSprite;

/**
 * Author liuyangchao
 * Date on 2017/5/9.9:50
 */

public class RotatingPlane extends RectSprite {

    @Override
    protected void onBoundsChange(Rect bounds) {
        setDrawBounds(clipSquare(bounds));      //剪辑成正方形
    }

    @Override
    public ValueAnimator onCreateAnimation() {
        float fractions[] = new float[]{0f, 0.5f, 1f};
//        return new Spri
        return null;
    }
}
