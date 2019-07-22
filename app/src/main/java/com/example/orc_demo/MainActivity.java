package com.example.orc_demo;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.orc_demo.adapter.ViewPagerAdapter;
import com.example.orc_demo.base.BaseActivity;
import com.example.orc_demo.ui.main.CameraFragment;
import com.example.orc_demo.ui.main.HomeFragment;
import com.example.orc_demo.ui.main.SettingFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private BottomBar mBottomBar;
    private ViewPager mVpContent;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews() {
        mBottomBar = findViewById(R.id.bottomBar);
        mVpContent = findViewById(R.id.vp_main_content);
    }

    @Override
    public void initData() {
        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new CameraFragment());
        mFragmentList.add(new SettingFragment());
        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mVpContent.setAdapter(mViewPagerAdapter);
        mVpContent.setOffscreenPageLimit(2);
    }

    @Override
    public void initListener() {
        mBottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home:
                        mVpContent.setCurrentItem(0);
                        break;
                    case R.id.tab_camera:
                        mVpContent.setCurrentItem(1);
                        break;
                    case R.id.tab_setting:
                        mVpContent.setCurrentItem(2);
                        break;
                    default:
                        break;
                }
            }
        });

        mVpContent.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBottomBar.selectTabAtPosition(position, true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}