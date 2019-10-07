package com.example.mybaseapp.fragment;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mybaseapp.BaseFragment;
import com.example.mybaseapp.R;

/**
 * Created by sxj on 2019/9/29.
 */
public class HomeFragment extends BaseFragment {

    private TextView tv_jni;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        tv_jni =(TextView)view.findViewById(R.id.tv_jni);
        tv_jni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,getHello(),Toast.LENGTH_SHORT).show();
            }
        });
    }




    public native String getHello();
}
