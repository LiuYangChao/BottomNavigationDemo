package com.cssrc.bottomnavigationdemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cssrc.bottomnavigationdemo.activity.MyViewActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentThree extends Fragment {

    @Bind(R.id.MyView)
    TextView MyView;
    public FragmentThree() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_three, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.MyView)
    void MyView(){
        Intent intent = new Intent(getActivity(), MyViewActivity.class);
        startActivity(intent);
    }

}
