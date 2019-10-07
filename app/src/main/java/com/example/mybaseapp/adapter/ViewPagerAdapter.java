package com.example.mybaseapp.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by sxj on 2019/10/4.
 */
public class ViewPagerAdapter extends PagerAdapter {
    public ViewPagerAdapter() {
    }


    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return false;
    }


}
