package com.example.mybaseapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sxj on 2019/9/29.
 */
public abstract class BaseFragment extends Fragment {
    protected Context mContext;
    protected Activity mActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutRes(), null);
        initView(view);
        this.mActivity=getActivity();
        this.mContext=getActivity();
        return view;
    }

    /**
     * findViewById
     *
     * @param view View的实例
     */
    public abstract void initView(View view);

    /**
     * 获取fragment的布局资源id
     */
    protected abstract int getLayoutRes();

}
