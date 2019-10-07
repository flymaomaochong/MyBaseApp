package com.example.mybaseapp.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.mybaseapp.BaseActivity;
import com.example.mybaseapp.BaseFragment;
import com.example.mybaseapp.R;
import com.example.mybaseapp.fragment.ContractFragment;
import com.example.mybaseapp.fragment.DiscoveryFragment;
import com.example.mybaseapp.fragment.HomeFragment;
import com.example.mybaseapp.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private FrameLayout fl_content;
    private TextView tv_home;
    private TextView tv_contract;
    private TextView tv_discover;
    private TextView tv_mine;
    private List<BaseFragment> fragments;
    private String[] tags = new String[]{"mHomeFragment", "mContractFragment", "mDiscoveryFragment", "mMineFragment"};
    /**
     *记录哪些已经添加到fragmentTransaction，复原时对这些进行隐藏，
     * 若隐藏没有添加到进去的，则会引起奔溃，导致APP无法进入
     * */
    private ArrayList<String>hasAdd=new ArrayList<>();
    private BaseFragment mContractFragment = new ContractFragment();
    private BaseFragment mDiscoveryFragment = new DiscoveryFragment();
    private BaseFragment mHomeFragment = new HomeFragment();
    private BaseFragment mMineFragment = new MineFragment();
    private BaseFragment mCurrentFragment;
    /**
     * 记录当前fragment的位置，以便在发生异常时避免页面重叠
     */
    private int mIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVIew();
        initEvent();
        initFragment();
        if (savedInstanceState == null) {
            switchFragment(mCurrentFragment, 0);
        } else {
            mIndex = savedInstanceState.getInt("index", 0);
            hasAdd=savedInstanceState.getStringArrayList("hasAdd");
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            for(int i=0;i<hasAdd.size();i++){
                fragmentTransaction.hide(fragmentManager.findFragmentByTag(hasAdd.get(i)));
            }
            fragmentTransaction.commit();
            switchFragment(mCurrentFragment, mIndex);

        }

    }

    private void initEvent() {
        tv_home.setOnClickListener(this);
        tv_contract.setOnClickListener(this);
        tv_discover.setOnClickListener(this);
        tv_mine.setOnClickListener(this);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(mHomeFragment);
        fragments.add(mContractFragment);
        fragments.add(mDiscoveryFragment);
        fragments.add(mMineFragment);
    }

    private void initVIew() {
        fl_content = (FrameLayout) findViewById(R.id.fl_content);
        tv_home = (TextView) findViewById(R.id.tv_home);
        tv_contract = (TextView) findViewById(R.id.tv_contract);
        tv_discover = (TextView) findViewById(R.id.tv_discover);
        tv_mine = (TextView) findViewById(R.id.tv_mine);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_home:
                switchFragment(mCurrentFragment, 0);
                mIndex = 0;
                break;
            case R.id.tv_contract:
                switchFragment(mCurrentFragment, 1);
                mIndex = 1;
                break;
            case R.id.tv_discover:
                switchFragment(mCurrentFragment, 2);
                mIndex = 2;
                break;
            case R.id.tv_mine:
                switchFragment(mCurrentFragment, 3);
                mIndex = 3;
                break;
        }
    }


    private BaseFragment getFragment(int i) {
        if (fragments != null && i < fragments.size()) {
            return fragments.get(i);
        }
        return null;
    }


    /**
     * 切换Fragment
     *
     * @param currentFragment 当前所在的fragment
     * @param position        目标Fragment的位置
     */
    private void switchFragment(BaseFragment currentFragment, int position) {
        BaseFragment targetFragment = getFragment(position);
        if (mCurrentFragment != targetFragment) {
            mCurrentFragment = targetFragment;
            if (targetFragment != null) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                if (!targetFragment.isAdded()) {
                    fragmentTransaction.add(R.id.fl_content, targetFragment, tags[position]);
                    hasAdd.add(tags[position]);
                }
                if (currentFragment != null) {
                    fragmentTransaction.hide(currentFragment).show(targetFragment).commit();
                } else {
                    fragmentTransaction.show(targetFragment).commit();
                }
                switchState(position);

            }

        }
    }

    /**
     * 改变选中状态
     */
    private void switchState(int position) {
        tv_home.setTextColor(position == 0 ? getResources().getColor(R.color.blue) : getResources().getColor(R.color.black));
        tv_contract.setTextColor(position == 1 ? getResources().getColor(R.color.blue) : getResources().getColor(R.color.black));
        tv_discover.setTextColor(position == 2 ? getResources().getColor(R.color.blue) : getResources().getColor(R.color.black));
        tv_mine.setTextColor(position == 3 ? getResources().getColor(R.color.blue) : getResources().getColor(R.color.black));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("index", mIndex);
        outState.putStringArrayList("hasAdd",hasAdd);
        super.onSaveInstanceState(outState);
    }
}
