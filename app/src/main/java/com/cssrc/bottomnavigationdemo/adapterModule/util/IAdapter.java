package com.cssrc.bottomnavigationdemo.adapterModule.util;

import com.cssrc.bottomnavigationdemo.adapterModule.item.AdapterItem;

import java.util.List;

/**
 * Author liuyangchao
 * Date on 2017/4/22.15:59
 */

public interface IAdapter<T> {

    /**
     * 设置数据源
     * @param data
     */
    void setData(List<T> data);

    /**
     * 获取数据源
     * @return
     */
    List<T> getData();


    AdapterItem createItem(Object type);


}
