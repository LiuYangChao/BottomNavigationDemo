package com.cssrc.bottomnavigationdemo.widget.spinkit.sprite;

import android.animation.ValueAnimator;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;

import com.cssrc.bottomnavigationdemo.widget.spinkit.animation.AnimationUtils;

/**
 * Author liuyangchao
 * Date on 2017/5/9.9:37
 */

public abstract class Sprite extends Drawable implements
        ValueAnimator.AnimatorUpdateListener,
        Animatable,
        Drawable.Callback{

    private float scale = 1;
    private float scaleX = 1;
    private float scaleY = 1;                               //缩放，倍数
    private float privotX;
    private float privotY;
    private int animationDelay;                         //动画延迟
    private int rotateX;
    private int rotateY;                                      //旋转
    private int translateX;                                  //平移
    private int translateY;
    private int rotate;
    private float translateXPercentage;
    private float translateYPercentage;
    private ValueAnimator animator;
    private int alpha = 255;
    private static final Rect ZERO_BOUNDS_RECT = new Rect();
    protected Rect drawBounds = ZERO_BOUNDS_RECT;
    private Camera mCamera;
    private Matrix mMatrix;

    public Sprite(){
        mCamera = new Camera();
        mMatrix = new Matrix();
    }

    /**
     * 需要子类继承的抽象方法
     * @param canvas
     */
    protected abstract void drawSelf(Canvas canvas);

    public abstract void setColor(int color);

    public abstract int getColor();

    public abstract ValueAnimator onCreateAnimation();

    @Override
    public void draw(Canvas canvas) {
        int tx = getTranslateX();
        tx = tx == 0? (int) (getBounds().width() * getTranslateXPercentage()) :tx;
        int ty = getTranslateY();
        ty = ty == 0? (int)(getBounds().height() * getTranslateYPercentage()) : ty;
        canvas.translate(tx, ty);
        canvas.scale(getScaleX(), getScaleY(), getPrivotX(), getPrivotY());
        canvas.rotate(getRotate(), getPrivotX(), getPrivotY());

        if(getRotateX() !=0 || getRotateY() != 0){
            mCamera.save();
            mCamera.rotateX(getRotateX());
            mCamera.rotateY(getRotateY());
            mCamera.getMatrix(mMatrix);
            //getPrivotX和getPrivotY得到的是图片中心点的坐标(缩放常用)
            mMatrix.preTranslate(-getPrivotX(), -getPrivotY());     //平移到左上角坐标点
            mMatrix.postTranslate(getPrivotX(), getPrivotY());      //平移到右下角坐标点
            mCamera.restore();
            canvas.concat(mMatrix);
        }
        drawSelf(canvas);
    }

    public int getAlpha() {
        return alpha;
    }

    @Override
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    /**
     *  android.graphics.drawable.Animatable下的实现类
     *  *********************************************************************start
     * @return
     */
    @Override
    public void start() {
        if(AnimationUtils.isStarted(animator)){
            return;
        }
        animator = obtainAnimator();
        if(animator == null){
            return;
        }
        AnimationUtils.start(animator);
        invalidateSelf();
    }
    /**
     * 创建一个ValueAnimator类型动画属性
     * @return
     */
    public ValueAnimator obtainAnimator(){
        if(animator == null){
            animator = onCreateAnimation();
        }
        if(animator != null){
            animator.addUpdateListener(this);
            animator.setStartDelay(animationDelay);
        }
        return animator;
    }

    @Override
    public void stop() {
        if(AnimationUtils.isStarted(animator)){
            animator.removeAllUpdateListeners();
            animator.end();
            reset();
        }
    }
    public void reset(){
        scale = 1;
        rotateX = 0;
        rotateY = 0;
        translateX = 0;
        translateY = 0;
        rotate = 0;
        translateXPercentage = 0f;
        translateYPercentage = 0f;
    }

    @Override
    public boolean isRunning() {
        return AnimationUtils.isRunning(animator);
    }
    //************************************************************************end

    @Override
    public int getOpacity() {
        return PixelFormat.RGBA_8888;
    }

    /**
     * 绘制边界
     * @param drawBounds
     */
    public void setDrawBounds(Rect drawBounds){
        setDrawBounds(drawBounds.left,
                drawBounds.top,
                drawBounds.right,
                drawBounds.bottom);
    }

    public void setDrawBounds(int left, int top, int right, int bottom){
        this.drawBounds = new Rect(left, top, right, bottom);
        setPrivotX(getDrawBounds().centerX());
        setPrivotY(getDrawBounds().centerY());
    }

    /**
     * 设置边界
     * @param bounds
     */
    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        setDrawBounds(bounds);
    }

    @Override
    public void invalidateDrawable(Drawable who) {
        invalidateSelf();
    }

    @Override
    public void scheduleDrawable(Drawable who, Runnable what, long when) {

    }

    @Override
    public void unscheduleDrawable(Drawable who, Runnable what) {

    }

    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        final Callback callback = getCallback();
        if(callback != null){
            callback.invalidateDrawable(this);
        }
    }

    /**
     *  具体Shape类型View调用的方法,最后生成一个正方形
     * @return
     */
    public Rect clipSquare(Rect rect){
        int w = rect.width();
        int h = rect.height();
        int min = Math.min(w, h);
        int cx = rect.centerX();
        int cy = rect.centerY();
        int r = min/2;
        return new Rect(cx-r,
                cy - r,
                cx + r,
                cy + r);
    }


    public Rect getDrawBounds() {
        return drawBounds;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public float getScaleX() {
        return scaleX;
    }

    public void setScaleX(float scaleX) {
        this.scaleX = scaleX;
    }

    public float getScaleY() {
        return scaleY;
    }

    public void setScaleY(float scaleY) {
        this.scaleY = scaleY;
    }

    public float getPrivotX() {
        return privotX;
    }

    public void setPrivotX(float privotX) {
        this.privotX = privotX;
    }

    public float getPrivotY() {
        return privotY;
    }

    public void setPrivotY(float privotY) {
        this.privotY = privotY;
    }

    public int getAnimationDelay() {
        return animationDelay;
    }

    public void setAnimationDelay(int animationDelay) {
        this.animationDelay = animationDelay;
    }

    public int getRotateX() {
        return rotateX;
    }

    public void setRotateX(int rotateX) {
        this.rotateX = rotateX;
    }

    public int getRotateY() {
        return rotateY;
    }

    public void setRotateY(int rotateY) {
        this.rotateY = rotateY;
    }

    public int getTranslateX() {
        return translateX;
    }

    public void setTranslateX(int translateX) {
        this.translateX = translateX;
    }

    public int getTranslateY() {
        return translateY;
    }

    public void setTranslateY(int translateY) {
        this.translateY = translateY;
    }

    public int getRotate() {
        return rotate;
    }

    public void setRotate(int rotate) {
        this.rotate = rotate;
    }

    public float getTranslateXPercentage() {
        return translateXPercentage;
    }

    public void setTranslateXPercentage(float translateXPercentage) {
        this.translateXPercentage = translateXPercentage;
    }

    public float getTranslateYPercentage() {
        return translateYPercentage;
    }

    public void setTranslateYPercentage(float translateYPercentage) {
        this.translateYPercentage = translateYPercentage;
    }

    public ValueAnimator getAnimator() {
        return animator;
    }

    public void setAnimator(ValueAnimator animator) {
        this.animator = animator;
    }

    public Camera getmCamera() {
        return mCamera;
    }

    public void setmCamera(Camera mCamera) {
        this.mCamera = mCamera;
    }

    public Matrix getmMatrix() {
        return mMatrix;
    }

    public void setmMatrix(Matrix mMatrix) {
        this.mMatrix = mMatrix;
    }
}
