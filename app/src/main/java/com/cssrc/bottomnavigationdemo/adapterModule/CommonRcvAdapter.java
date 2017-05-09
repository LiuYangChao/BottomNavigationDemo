package com.cssrc.bottomnavigationdemo.adapterModule;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cssrc.bottomnavigationdemo.adapterModule.item.AdapterItem;
import com.cssrc.bottomnavigationdemo.adapterModule.util.IAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Author liuyangchao
 * Date on 2017/4/22.16:15
 */

public abstract class CommonRcvAdapter<T> extends RecyclerView.Adapter<CommonRcvAdapter.RcvAdapterItem>
    implements IAdapter<T>{

    private List<T> mDataList;

    public CommonRcvAdapter(List<T> data){
        if(data == null){
            data = new ArrayList<>();
        }
        mDataList = data;

    }

    ///////////////////////////////////////////////////
    //  IAdapter   重写的方法

    @Override
    public List<T> getData() {
        return null;
    }



    ///////////////////////////////////////////////////
    //  RecyclerView   重写的方法

    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class RcvAdapterItem extends RecyclerView.ViewHolder{

        AdapterItem item;

        public RcvAdapterItem(Context context, ViewGroup viewGroup, AdapterItem adapterItem) {
            super(LayoutInflater.from(context).inflate(adapterItem.getLayoutResId(), viewGroup, false));
            this.item = adapterItem;
            this.item.bindViews(itemView);
            this.item.setViews();
        }
    }

}
