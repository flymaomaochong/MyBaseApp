package com.example.mybaseapp.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.mybaseapp.BaseActivity;
import com.example.mybaseapp.R;
import com.example.mybaseapp.adapter.ViewPagerAdapter;

public class WelcomeActivity extends BaseActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        viewPager =(ViewPager)findViewById(R.id.viewPager);
        myAdapter =new ViewPagerAdapter();
        viewPager.setAdapter(myAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }


}
