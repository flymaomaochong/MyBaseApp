package com.example.mybaseapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by sxj on 2019/9/29.
 */
public class BaseActivity extends FragmentActivity {
protected Context mContext;
protected Activity mActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext=this;
        this.mActivity=this;
    }



}
