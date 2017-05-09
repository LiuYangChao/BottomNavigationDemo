package com.cssrc.bottomnavigationdemo.widget.spinkit.animation;

import android.animation.Animator;
import android.animation.ValueAnimator;

import com.cssrc.bottomnavigationdemo.widget.spinkit.sprite.Sprite;

/**
 * 动画监听器工具类
 * Author liuyangchao
 * Date on 2017/5/9.15:42
 */
public class AnimationUtils {

    public static void start(Animator animator){
        if(animator != null && !animator.isStarted()){
            animator.start();
        }
    }

    public static void stop(Animator animator){
        if(animator != null && !animator.isRunning()){
            animator.end();
        }
    }

    /**
     *  遍历实现动画效果
     * @param sprites
     */
    public static void start(Sprite... sprites){
        for(Sprite sprite : sprites){
            sprite.start();
        }
    }

    public static void stop(Sprite... sprites){
        for(Sprite sprite:sprites){
            sprite.stop();
        }
    }

    public static boolean isRunning(Sprite... sprites){
        for(Sprite sprite:sprites){
            if(sprite.isRunning()){
                return true;
            }
        }
        return false;
    }

    public static boolean isRunning(ValueAnimator animator){
        return animator != null && animator.isRunning();
    }

    public static boolean isStarted(ValueAnimator animator){
        return animator != null && animator.isStarted();
    }

}
