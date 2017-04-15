package com.cssrc.bottomnavigationdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cssrc.bottomnavigationdemo.RecyclerViewFresh.EndLessOnScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.layout_swipe_refresh)
    SwipeRefreshLayout mRefreshLayout;
    @Bind(R.id.recycler)
    RecyclerView recycler;

    List<Item> itemList = new ArrayList<Item>();
    MainAdapter mainAdapter;

    public FragmentOne() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_one, container, false);
        ButterKnife.bind(this, view);
        initData();
        initView();
        return view;
    }

    private void initData(){
        for(int i=0; i<10; i++){
            Item item = new Item();
            item.setTitle("标题 "+ i);
            item.setContent("内容 "+ i);
            itemList.add(item);
        }
    }

    private void initView(){
        mainAdapter = new MainAdapter(this.getContext(), itemList);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(mLinearLayoutManager);
        recycler.setAdapter(mainAdapter);
        mRefreshLayout.setOnRefreshListener(this);
        recycler.addOnScrollListener(new EndLessOnScrollListener(mLinearLayoutManager) {
            @Override
            public void onLoadMore(int currentPage) {
                loadMoreData();
            }
        });
    }

    private void loadMoreData(){
        int currentCount =itemList.size();
        for(int i=currentCount; i<currentCount+10; i++){
            Item item = new Item();
            item.setTitle("标题 "+ i);
            item.setContent("内容 "+ i);
            itemList.add(item);
            mainAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onRefresh() {
        updateData();
        mainAdapter.notifyDataSetChanged();
        mRefreshLayout.setRefreshing(false);
    }

    private void updateData(){
        Item item = new Item();
        item.setTitle("作者:js_liuyangchao@163.com");
        item.setContent("内容:享受生活");
        itemList.add(0, item);
    }
}
