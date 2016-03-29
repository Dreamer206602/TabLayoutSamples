package com.tq.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.utils.UnreadMsgUtils;
import com.flyco.tablayout.widget.MsgView;
import com.tq.R;
import com.tq.entity.TabEntity;
import com.tq.fragment.SimpleCardFragment;

import java.util.ArrayList;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CommonTabActivity extends AppCompatActivity {

    @Bind(R.id.tl_1)
    CommonTabLayout tl1;
    @Bind(R.id.vp_2)
    ViewPager vp2;
    @Bind(R.id.tl_2)
    CommonTabLayout tl2;
    @Bind(R.id.fl_change)
    FrameLayout flChange;
    @Bind(R.id.tl_3)
    CommonTabLayout tl3;
    @Bind(R.id.tl_4)
    CommonTabLayout tl4;
    @Bind(R.id.tl_5)
    CommonTabLayout tl5;
    @Bind(R.id.tl_6)
    CommonTabLayout tl6;
    @Bind(R.id.tl_7)
    CommonTabLayout tl7;
    @Bind(R.id.tl_8)
    CommonTabLayout tl8;

    private Context mContext = this;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<Fragment> mFragments2 = new ArrayList<>();

    private String[] mTitles = {"首页", "消息", "联系人", "更多"};
    private int[] mIConUnSelectIds = {R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_tab);
        ButterKnife.bind(this);


        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager" + title));
            mFragments2.add(SimpleCardFragment.getInstance("Switch Fragment" + title));
        }

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIConUnSelectIds[i]));
        }
        vp2.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        tl1.setTabData(mTabEntities);
        tl_2();
        tl3.setTabData(mTabEntities, this, R.id.fl_change, mFragments2);

        tl4.setTabData(mTabEntities);
        tl5.setTabData(mTabEntities);
        tl6.setTabData(mTabEntities);
        tl7.setTabData(mTabEntities);
        tl8.setTabData(mTabEntities);

        tl3.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                tl1.setCurrentTab(position);
                tl2.setCurrentTab(position);
                tl4.setCurrentTab(position);
                tl5.setCurrentTab(position);
                tl6.setCurrentTab(position);
                tl7.setCurrentTab(position);
                tl8.setCurrentTab(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        tl8.setCurrentTab(2);
        tl3.setCurrentTab(1);

        //TODO 显示未读的红点
        tl1.showDot(2);
        tl3.showDot(1);
        tl4.showDot(1);

        //TODO 显示两位数的红点
        tl2.showMsg(0,55);
        tl2.setMsgMargin(0,-5,5);

        //TODO 显示三位数的红点
        tl2.showMsg(1,100);
        tl2.setMsgMargin(1,-5,5);

        //TODO　设置未读的红点
        MsgView rtz_2_2 =tl2.getMsgView(2);
        if (rtz_2_2 != null) {
            UnreadMsgUtils.setSize(rtz_2_2,dp2px(7.5f));
        }

        //TODO 设置未读的消息背景
        tl2.showMsg(3,5);
        tl2.setMsgMargin(3,0,5);
        MsgView rtv_2_3 = tl2.getMsgView(3);
        if (rtv_2_3 != null) {
            rtv_2_3.setBackgroundColor(Color.parseColor("#6D8FB0"));
        }


    }

    private int dp2px(float dp) {

        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dp*scale+0.5f);

    }

    Random mRandom = new Random();

    private void tl_2() {
        tl2.setTabData(mTabEntities);
        tl2.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp2.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

                if (position == 0) {
                    tl2.showMsg(0, mRandom.nextInt(100) + 1);
                }
            }
        });
        vp2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tl2.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp2.setCurrentItem(1);
    }


    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
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
            return mTitles[position];
        }
    }
}
