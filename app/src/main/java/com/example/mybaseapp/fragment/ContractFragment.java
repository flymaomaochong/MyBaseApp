package com.example.mybaseapp.fragment;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mybaseapp.BaseFragment;
import com.example.mybaseapp.R;
import com.example.mybaseapp.activity.SecondActivity;

/**
 * Created by sxj on 2019/9/29.
 */
public class ContractFragment extends BaseFragment {

    private TextView tv_contract;
    private TextView tv_add;
    private TextView tv_create;
    private SQLiteDatabase database;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_contract;
    }

    @Override
    public void initView(View view) {
        tv_contract =(TextView)view.findViewById(R.id.tv_contract);
        tv_create =(TextView)view.findViewById(R.id.tv_create);
        tv_add =(TextView)view.findViewById(R.id.tv_add);
        tv_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database = SQLiteDatabase.openOrCreateDatabase("school.db",null);
                if(isTableExist(database,"person")){
                    database.execSQL("create table person (id interger primary key autoincrement,name varchar,age interger)");
                }
            }
        });
        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues contentValues=new ContentValues();
                contentValues.put("name","小明");
                contentValues.put("age",18);
                Log.i("这里是","添加");
                database.insert("person",null,contentValues);
            }
        });




        tv_contract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, SecondActivity.class));

            }
        });
    }

    //判断table是否存在
    public boolean isTableExist(SQLiteDatabase db,String table) {

        Cursor c = db.rawQuery("select count(*) from sqlite_master where type='table' and name='"+table+"'", null);
        if (c != null) {
            while (c.moveToNext()) {
                int count = c.getInt(0);
                if (count > 0) {
                    c.close();
                    return true;
                }
            }
        }else{
            c.close();
        }
        return false;
    }

}
