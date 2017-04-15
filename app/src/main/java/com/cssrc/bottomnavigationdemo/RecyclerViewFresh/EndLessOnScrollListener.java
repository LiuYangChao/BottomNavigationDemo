package com.cssrc.bottomnavigationdemo.RecyclerViewFresh;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

/**
 * Author liuyangchao
 * Date on 2017/4/15.9:21
 */

public abstract class EndLessOnScrollListener extends RecyclerView.OnScrollListener {

    private LinearLayoutManager linearLayoutManager;

    private int currentPage = 0;            //从0开始
    private boolean loading = true;

    private int visibleItemCount;
    private int totalItemCount;
    private int firstVisibleItem;
    private int previousTotal;

    public EndLessOnScrollListener(LinearLayoutManager linearLayoutManager){
        this.linearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        //屏幕上能看到的条目数量
        visibleItemCount = recyclerView.getChildCount();
        //数据集中加载进的总的条目数量
        totalItemCount = linearLayoutManager.getItemCount();
        //visibleItemCount中的第一条条目
        firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();

        if(loading){
            Log.d("wnwn","firstVisibleItem: " +firstVisibleItem);
            Log.d("wnwn","totalPageCount:" +totalItemCount);
            Log.d("wnwn", "visibleItemCount:" + visibleItemCount);

            if(totalItemCount > previousTotal){
                loading = false;
                previousTotal = totalItemCount;
            }
        }

        //发生在数据还没有更新到adapter中的情况，只有等于的情况下会加载数据，也不排除swipe这个控件产生的数据
        if(!loading && totalItemCount-visibleItemCount <= firstVisibleItem){
            currentPage++;
            onLoadMore(currentPage);
            loading = false;
        }
    }

    public abstract void onLoadMore(int currentPage);
}
