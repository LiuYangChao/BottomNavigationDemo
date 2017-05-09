package com.cssrc.bottomnavigationdemo.adapterModule.item;

import android.view.View;

/**
 * Author liuyangchao
 * Date on 2017/4/22.16:11
 */

public interface AdapterItem<T> {

    int getLayoutResId();

    void bindViews(View root);

    void setViews();

    /**
     * Item内的View点击事件
     * @param t
     * @param position  当前点击位置
     */
    void handleData(T t, int position);
}
