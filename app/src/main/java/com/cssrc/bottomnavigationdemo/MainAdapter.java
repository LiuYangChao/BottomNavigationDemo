package com.cssrc.bottomnavigationdemo;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author liuyangchao
 * Date on 2017/4/8.15:25
 */

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Item> items = new ArrayList<Item>();

    public MainAdapter(Context context, List<Item> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imagelist, parent, false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainHolder mainHolder = (MainHolder) holder;
        Item item = items.get(position);
        mainHolder.title.setText(item.getTitle());
        mainHolder.content.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class MainHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.open_title)
        TextView title;
        @Bind(R.id.open_content)
        TextView content;

        public MainHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
