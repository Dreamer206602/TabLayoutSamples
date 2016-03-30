package com.tq.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.tq.R;
import com.tq.fragment.AndroidFragment;
import com.tq.fragment.BaseFragment;
import com.tq.fragment.IosFragment;
import com.tq.fragment.JavaFragment;
import com.tq.fragment.SimpleCardFragment;
import com.tq.fragment.SwiftFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Test1Activity extends AppCompatActivity {

    @Bind(R.id.tl)
    SlidingTabLayout tl;
    @Bind(R.id.vp)
    ViewPager vp;
    private String[] mTitles = {"Android", "Java", "Swift", "Ios"};
    private ArrayList<BaseFragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
        ButterKnife.bind(this);


        mFragments.add(AndroidFragment.getInstance());
        mFragments.add(JavaFragment.getInstance());
        mFragments.add(SwiftFragment.getInstance());
        mFragments.add(IosFragment.getInstance());
        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        //TODO ViewPager 和TabLayout 相关联
        tl.setViewPager(vp);
        tl.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tl.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        tl.setCurrentTab(0);
        //vp.setCurrentItem(1);


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
