package com.android1604.mustsee;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.android1604.mustsee.fragment.ExploreFragment;
import com.android1604.mustsee.fragment.InformationFragment;
import com.android1604.mustsee.fragment.MineFragment;

/**
 * 程序入口
 */
public class MainActivity extends BaseActivity {

    private RadioGroup mRadioGroup;
    private FragmentManager manager;
    private InformationFragment mInformationFragment;
    private ExploreFragment mExploreFragment;
    private MineFragment mMineFragment;
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化视图
     */
    private void initView() {
        initFragment();
        mRadioGroup = (RadioGroup) findViewById(R.id.main_bottom_radio_group);
        initListener();
    }

    /**
     * 初始化事件监听
     */
    private void initListener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.main_information_rb:
                        showFragment(mInformationFragment);
                        break;
                    case R.id.main_explore_rb:
                        showFragment(mExploreFragment);
                        break;
                    case R.id.main_mine_rb:
                        showFragment(mMineFragment);
                        break;
                }
            }
        });
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        manager = getSupportFragmentManager();
        mInformationFragment = InformationFragment.newInstance();
        mExploreFragment = ExploreFragment.newInstance();
        mMineFragment = MineFragment.newInstance();
        showFragment(mInformationFragment);
    }

    /**
     * 显示传入的fragment
     * @param fragment 传入的fragment
     */
    private void showFragment(Fragment fragment){
        FragmentTransaction transaction = manager.beginTransaction();
        if(mCurrentFragment != null){
            transaction.hide(mCurrentFragment);
        }
        if(!fragment.isAdded()){
            transaction.add(R.id.main_container_fl,fragment);
        }else{
            transaction.show(fragment);
        }
        mCurrentFragment = fragment;
        transaction.commit();
    }
}
