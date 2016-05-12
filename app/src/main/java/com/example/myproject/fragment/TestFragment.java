package com.example.myproject.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myproject.MainActivity;
import com.example.myproject.R;

/**
 * Created by wangbs on 16/5/12.
 */
public class TestFragment extends BaseFragment{
    private MainActivity context;
    private Object params;
    private int fromIndex;
    private int tabIndex;
    private boolean flash;
    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        context = (MainActivity) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.test_fragment, container, false);
        return rootView;
    }
    public void setParams(Object params) {
        this.params = params;
    }
    public void setStatue(int fromIndex,int tabIndex,boolean flash){
        this.fromIndex=fromIndex;
        this.tabIndex=tabIndex;
        this.flash=flash;
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        if(!hidden){
            if(flash){
                flash();
            }
        }
        super.onHiddenChanged(hidden);
    }
    public void flash(){

    }
}
