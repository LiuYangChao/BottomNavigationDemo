package com.cssrc.bottomnavigationdemo.widget.spinkit;

import com.cssrc.bottomnavigationdemo.widget.spinkit.sprite.Sprite;
import com.cssrc.bottomnavigationdemo.widget.spinkit.style.RotatingPlane;

/**
 * Author liuyangchao
 * Date on 2017/5/9.9:35
 */

public class SpriteFactory {

    public static Sprite create(Style style){
        Sprite sprite = null;
        switch (style){
            case ROTATING_PLANE:
                sprite = new RotatingPlane();
                break;




        }




    }

}
