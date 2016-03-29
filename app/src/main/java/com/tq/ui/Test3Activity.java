package com.tq.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.tq.R;
import com.tq.fragment.SimpleCardFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Test3Activity extends AppCompatActivity {

    @Bind(R.id.tl)
    SegmentTabLayout tl;
    @Bind(R.id.vp)
    ViewPager vp;
    private String[] mTitles = {"Java", "Objc"};
    private ArrayList<Fragment> mFragments = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
        ButterKnife.bind(this);

        for (String title:mTitles){
            mFragments.add(SimpleCardFragment.getInstance("Switch ViewPager test3 "+title));
        }

        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        tl.setTabData(mTitles);
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



    }

    private class MyPagerAdapter extends FragmentPagerAdapter{
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
