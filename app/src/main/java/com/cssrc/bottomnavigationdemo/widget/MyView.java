package com.cssrc.bottomnavigationdemo.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.cssrc.bottomnavigationdemo.R;

/**
 * 自定义View学习
 * Author liuyangchao
 * Date on 2017/4/25.9:36
 */

public class MyView extends View {

    private int defaultSize;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        TypedArray array = context.obtainStyledAttributes(attributeSet, R.styleable.MyView);
        //param1:styles.xml中的声明属性值；param2：设置的默认值
        defaultSize = array.getDimensionPixelSize(R.styleable.MyView_default_size, 100);
        array.recycle();        //回收TypedArray
    }

    /**
     *  默认宽度和高度为100像素
     * @param defaultSize  默认大小
     * @param measureSpec       三种模式（静态常量）
     * @return
     */
    private int getMySize(int defaultSize, int measureSpec){
        int mySize = defaultSize;

        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch(mode){
            case MeasureSpec.UNSPECIFIED:{
                mySize = defaultSize;
                break;
            }
            case MeasureSpec.AT_MOST:{
                //match_parent模式，数值需要自己赋值
                mySize = size;
                break;
            }
            case MeasureSpec.EXACTLY:{
                mySize = size;
                break;
            }
        }
        return mySize;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMySize(100, widthMeasureSpec);
        int height = getMySize(100, heightMeasureSpec);
        if(width < height){
            height = width;
        }else{
            width = height;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //取得正方形宽度和高度的一半
        int r = getMeasuredWidth() / 2;
        //设置圆心位置坐标，左边距+r
        int centerX = getLeft()+r;
        int centerY = getRight()+r;

        Paint paint = new Paint();
        paint.setColor(Color.BLUE);

        canvas.drawCircle(centerX, centerY, r, paint);

    }
}
