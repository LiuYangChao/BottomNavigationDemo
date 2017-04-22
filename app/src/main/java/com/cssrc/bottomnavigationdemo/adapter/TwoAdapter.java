package com.cssrc.bottomnavigationdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cssrc.bottomnavigationdemo.R;
import com.google.android.flexbox.FlexboxLayoutManager;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Author liuyangchao
 * Date on 2017/4/22.14:09
 */

public class TwoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    private Integer[] images;

    public TwoAdapter(Context context, Integer[] images){
        this.context = context;
        this.images = images;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_layout, parent, false);
        return new TwoAdapter.TwoHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TwoHolder twoHolder = (TwoHolder) holder;
//        Glide.with(context).load(images[position]).into(twoHolder.image_src);
        twoHolder.image_src.setImageResource(images[position]);
        ViewGroup.LayoutParams lp = twoHolder.image_src.getLayoutParams();
        if (lp instanceof FlexboxLayoutManager.LayoutParams) {
            FlexboxLayoutManager.LayoutParams flexboxLp =
                    (FlexboxLayoutManager.LayoutParams) twoHolder.image_src.getLayoutParams();
            flexboxLp.setFlexGrow(1.0f);
        }

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    static class TwoHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.image_src)
        ImageView image_src;

        public TwoHolder(View view){
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
