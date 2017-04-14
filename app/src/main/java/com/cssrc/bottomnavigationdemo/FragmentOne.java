package com.cssrc.bottomnavigationdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentOne extends Fragment {

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
        for(int i=0; i<50; i++){
            Item item = new Item();
            item.setTitle("标题 "+ i);
            item.setContent("内容 "+ i);
            itemList.add(item);
        }
    }

    private void initView(){
        mainAdapter = new MainAdapter(this.getContext(), itemList);
        recycler.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false));
        recycler.setAdapter(mainAdapter);
    }

}
