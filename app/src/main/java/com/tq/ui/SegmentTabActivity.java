package com.tq.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.widget.MsgView;
import com.tq.R;
import com.tq.fragment.SimpleCardFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SegmentTabActivity extends AppCompatActivity {

    @Bind(R.id.tl_1)
    SegmentTabLayout tl1;
    @Bind(R.id.tl_2)
    SegmentTabLayout tl2;
    @Bind(R.id.tl_3)
    SegmentTabLayout tl3;
    @Bind(R.id.vp_2)
    ViewPager vp2;
    @Bind(R.id.tl_4)
    SegmentTabLayout tl4;
    @Bind(R.id.fl_change)
    FrameLayout flChange;
    @Bind(R.id.tl_5)
    SegmentTabLayout tl5;
    @Bind(R.id.fl_change2)
    FrameLayout flChange2;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<Fragment> mFragments2 = new ArrayList<>();
    private ArrayList<Fragment> mFragments3 = new ArrayList<>();
    private String[] mTitles = {"首页", "消息"};
    private String[] mTitles_2 = {"首页", "消息", "联系人"};
    private String[] mTitles_3 = {"首页", "消息", "联系人", "更多"};
    private String[] mTitles_4 = {"首页", "消息", "联系人", "更多", "hehe"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segment_tab);
        ButterKnife.bind(this);


        for (String title : mTitles_3) {
            mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager " + title));
        }
        for (String title : mTitles_2) {
            mFragments2.add(SimpleCardFragment.getInstance("Switch Fragment " + title));
        }
        for (String title : mTitles_4) {
            mFragments3.add(SimpleCardFragment.getInstance("sssssssssssss " + title));
        }


        tl1.setTabData(mTitles);
        tl2.setTabData(mTitles);
        tl_3();

        //TODO  和FrameLayout相关联
        tl4.setTabData(mTitles_2, this, R.id.fl_change, mFragments2);


        //TODO　同上
        tl5.setTabData(mTitles_4, this, R.id.fl_change2, mFragments3);


        //TODO 显示未读的红点
        tl1.showDot(1);
        tl2.showDot(2);
        tl3.showDot(1);
        tl4.showDot(1);

        //TODO　设置未读消息红点
        tl3.showDot(2);
        MsgView rtv_3_2 = tl3.getMsgView(2);
        if (rtv_3_2 != null) {
            rtv_3_2.setBackgroundColor(Color.parseColor("#6D8FB0"));
        }

    }

    private void tl_3() {

        vp2.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        tl3.setTabData(mTitles_3);
        tl3.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp2.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        vp2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                tl3.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp2.setCurrentItem(1);

    }

    private class MyPageAdapter extends FragmentPagerAdapter {

        public MyPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles_3[position];
        }
    }
}
