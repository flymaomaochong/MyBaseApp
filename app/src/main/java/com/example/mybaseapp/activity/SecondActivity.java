package com.example.mybaseapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mybaseapp.R;

public class SecondActivity extends AppCompatActivity {

    private TextView tv_finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        Log.i("我是","B的onCreate");
        tv_finish =(TextView)findViewById(R.id.tv_finish);
        tv_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name="sxj";
                name=null;
                Log.i("打印",name);
            }
        });
    }


}
