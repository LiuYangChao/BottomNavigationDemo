package com.cssrc.bottomnavigationdemo.widget.spinkit;

/**
 * Author liuyangchao
 * Date on 2017/5/9.9:38
 */

public enum Style {

    ROTATING_PLANE(0),              //旋转平面
    DOUBLE_BOUNCE(1),               //双反弹
    WAVE(2),                                //波浪
    WANDERING_CUBES(3),         //宽松
    PULSE(4),                               //脉冲
    CHASING_DOTS(5),                    //变形
    THREE_BOUNCE(6),                    //三次反弹
    CIRCLE(7),                                  //圆
    CUBE_GRID(8),                           //正方形格子
    FADING_CIRCLE(9),                   //渐变圆
    FOLDING_CUBE(10),                   //折叠方形
    ROTATING_CIRCLE(11),                    //旋转圆
    MULTIPLE_PULSE(12),                 //多脉冲
    PULSE_RING(13),                          //脉冲环
    MULTIPLE_PULSE_RING(14);        //多脉冲环


    private int value;
    Style(int value){
        this.value = value;
    }

}
