package com.example.mybaseapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.mybaseapp.BaseActivity;
import com.example.mybaseapp.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(mContext,MainActivity.class);
                startActivity(intent);
            }
        },2000);
    }
}
