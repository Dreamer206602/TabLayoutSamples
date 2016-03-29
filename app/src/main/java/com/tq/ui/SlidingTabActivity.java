package com.tq.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayout.widget.MsgView;
import com.tq.R;
import com.tq.fragment.SimpleCardFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SlidingTabActivity extends AppCompatActivity implements OnTabSelectListener {

    @Bind(R.id.tl_1)
    SlidingTabLayout tl1;
    @Bind(R.id.tl_2)
    SlidingTabLayout tl2;
    @Bind(R.id.tl_3)
    SlidingTabLayout tl3;
    @Bind(R.id.tl_4)
    SlidingTabLayout tl4;
    @Bind(R.id.tl_5)
    SlidingTabLayout tl5;
    @Bind(R.id.tl_6)
    SlidingTabLayout tl6;
    @Bind(R.id.tl_7)
    SlidingTabLayout tl7;
    @Bind(R.id.tl_8)
    SlidingTabLayout tl8;
    @Bind(R.id.tl_9)
    SlidingTabLayout tl9;
    @Bind(R.id.tl_10)
    SlidingTabLayout tl10;
    @Bind(R.id.vp)
    ViewPager vp;
    private Context mContext = this;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {"热门", "ios", "Android", "前端", "后端", "设计", "工具资源"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_tab);
        ButterKnife.bind(this);

        for (String title : mTitles) {
            mFragments.add(SimpleCardFragment.getInstance(title));
        }

        //View decorView = getWindow().getDecorView();
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tl1.setViewPager(vp);

        tl2.setViewPager(vp);
        tl2.setOnTabSelectListener(this);

        tl3.setViewPager(vp);
        tl4.setViewPager(vp);
        tl5.setViewPager(vp);
        tl6.setViewPager(vp);

        tl7.setViewPager(vp);
        tl7.setViewPager(vp, mTitles);

        tl8.setViewPager(vp);
        tl8.setViewPager(vp, mTitles, this, mFragments);
        tl9.setViewPager(vp);
        tl10.setViewPager(vp);

        vp.setCurrentItem(4);

        tl1.showDot(4);
        tl3.showDot(4);
        tl2.showDot(4);

        tl2.showMsg(3, 5);
        tl2.setMsgMargin(3, 0, 10);
        MsgView rtv_2_3 = tl2.getMsgView(3);
        if (rtv_2_3 != null) {
            rtv_2_3.setBackgroundColor(Color.parseColor("#6D8FB0"));
        }
        tl2.showMsg(5, 5);
        tl2.setMsgMargin(5, 0, 10);


    }

    @Override
    public void onTabSelect(int position) {
        Toast.makeText(mContext, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselect(int position) {
        Toast.makeText(mContext, "onTabReselect&position--->" + position, Toast.LENGTH_SHORT).show();
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {


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



