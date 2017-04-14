package com.cssrc.bottomnavigationdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    @Bind(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    TextView scrollableText;
    BadgeItem numberBadgeItem;
    int lastSelectedPosition = 0;

    FragmentOne fragmentOne;
    FragmentTwo fragmentTwo;
    FragmentThree fragmentThree;
    FragmentFour fragmentFour;
    FragmentFive fragmentFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomNavigationBar.setTabSelectedListener(this);
        refresh();
    }

    private void refresh() {
        bottomNavigationBar.clearAll();
        bottomNavigationBar
                .setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Home").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.ic_book_white_24dp, "Books").setActiveColorResource(R.color.teal))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "Music").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "Movies & TV").setActiveColorResource(R.color.brown))
                .addItem(new BottomNavigationItem(R.drawable.ic_videogame_asset_white_24dp, "Games").setActiveColorResource(R.color.grey))
                .setFirstSelectedPosition(lastSelectedPosition)
                .initialise();
        setDefaultFragment();
    }

    private void setDefaultFragment(){
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        fragmentOne = new FragmentOne();
        transaction.replace(R.id.nested_scroll_child, fragmentOne);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        switchFragment(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {
        switchFragment(position);
    }

    private void switchFragment(int position){
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (position) {
            case 0:
                if(fragmentOne == null){
                    fragmentOne = new FragmentOne();
                    transaction.add(R.id.nested_scroll_child, fragmentOne);
                }else{
                    transaction.show(fragmentOne);
                }
                break;
            case 1:
                if(fragmentTwo == null){
                    fragmentTwo = new FragmentTwo();
                    transaction.add(R.id.nested_scroll_child, fragmentTwo);
                }else{
                    transaction.show(fragmentTwo);
                }
                break;
            case 2:
                if(fragmentThree == null){
                    fragmentThree = new FragmentThree();
                    transaction.add(R.id.nested_scroll_child, fragmentThree);
                }else{
                    transaction.show(fragmentThree);
                }
                break;
            case 3:
                if(fragmentFour == null){
                    fragmentFour = new FragmentFour();
                    transaction.add(R.id.nested_scroll_child, fragmentFour);
                }else{
                    transaction.show(fragmentFour);
                }
                break;
            case 4:
                if(fragmentFive == null){
                    fragmentFive = new FragmentFive();
                    transaction.add(R.id.nested_scroll_child, fragmentFive);
                }else{
                    transaction.show(fragmentFive);
                }
                break;
            default:
                if(fragmentOne == null){
                    fragmentOne = new FragmentOne();
                    transaction.add(R.id.nested_scroll_child, fragmentOne);
                }else{
                    transaction.show(fragmentOne);
                }
                break;
        }
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (fragmentOne != null) {
            transaction.hide(fragmentOne);
        }
        if (fragmentTwo != null) {
            transaction.hide(fragmentTwo);
        }
        if (fragmentThree != null) {
            transaction.hide(fragmentThree);
        }
        if (fragmentFour != null) {
            transaction.hide(fragmentFour);
        }
        if (fragmentFive != null) {
            transaction.hide(fragmentFive);
        }
    }

}
