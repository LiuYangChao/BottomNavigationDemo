package com.cssrc.bottomnavigationdemo.widget.nightimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

import com.cssrc.bottomnavigationdemo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * Author liuyangchao
 * Date on 2017/5/5.9:16
 */

public class NineGridLayout extends ViewGroup {

    private Context context;
    private List<String> mUrlList = new ArrayList<>();      //照片URLS

    private static final float DEFUALT_SPACING = 3f;
    private static final int MAX_COUNT = 9;                 //最大照片数量为9
    private float mSpacing = DEFUALT_SPACING;

    private int mTotalWidth;
    private int mSingleWidth;

    private boolean mIsShowAll = false;
    private boolean mIsFirst = true;

    public NineGridLayout(Context context) {
        super(context);
    }

    public NineGridLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.NineGridLayout);
        mSpacing = typedArray.getDimension(R.styleable.NineGridLayout_sapcing, DEFUALT_SPACING);
        //官方强调，这里一定要recycler()回收掉
        //程序在运行时维护了一个 TypedArray的池，程序调用时，会向该池中请求一个实例，
        // 用完之后，调用 recycle() 方法来释放该实例，从而使其可被其他模块复用。
        //http://blog.csdn.net/Monicabg/article/details/45014327
        typedArray.recycle();
        init(context);
    }

    private void init(Context context){
        this.context = context;
        if(getListSize(mUrlList) == 0){
            setVisibility(GONE);                //没有一张图片就是隐藏自定义ViewGroup
        }
    }

    private int getListSize(List<String> list){
        if(list == null || list.size() ==0){
            return 0;
        }
        return list.size();
    }

    public NineGridLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        mTotalWidth = r - l;
        mSingleWidth = (int) ((mTotalWidth-mSpacing*(3-1))/3);
        if(mIsFirst){
            notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged(){
        post(new TimerTask() {
            @Override
            public void run() {
                refresh();
            }
        });
    }

    private void refresh(){
        removeAllViews();
    }

}
