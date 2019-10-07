package com.example.mybaseapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by sxj on 2019/9/30.
 */
public class MyApplication extends Application {
    private static Context CONTEXT;

    @Override
    public void onCreate() {
        super.onCreate();

    }
    public static Context getContext(){
        if(CONTEXT==null){
            CONTEXT=getContext();
        }
        return CONTEXT;
    }

}
