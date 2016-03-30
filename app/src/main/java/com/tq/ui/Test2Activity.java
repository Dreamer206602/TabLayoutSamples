package com.tq.ui;

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
import com.tq.R;
import com.tq.entity.TabEntity;
import com.tq.fragment.AndroidFragment;
import com.tq.fragment.BaseFragment;
import com.tq.fragment.IosFragment;
import com.tq.fragment.JavaFragment;
import com.tq.fragment.SwiftFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Test2Activity extends AppCompatActivity {


    @Bind(R.id.vp)
    ViewPager vp;
    @Bind(R.id.tl)
    CommonTabLayout tl;
    @Bind(R.id.fl_change)
    FrameLayout flChange;
    private ArrayList<BaseFragment> mFragments = new ArrayList<>();
    private String[] mTitles = {"Android", "java", "Swift", "ios"};
    private int[] mIConUnSelectIds = {R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        ButterKnife.bind(this);
        mFragments.add(AndroidFragment.getInstance());
        mFragments.add(JavaFragment.getInstance());
        mFragments.add(SwiftFragment.getInstance());
        mFragments.add(IosFragment.getInstance());
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIConUnSelectIds[i]));
        }

//        vp.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
//
//        //TODO
////        tl.showDot(2);
////        tl.setMsgMargin(2,3,4);
//        tl.setTabData(mTabEntities);
//        tl.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelect(int position) {
//                vp.setCurrentItem(position);
//            }
//
//            @Override
//            public void onTabReselect(int position) {
//
//            }
//        });
//
//        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                    tl.setCurrentTab(position);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        vp.setCurrentItem(1);
//        //tl.setCurrentTab(1);
//
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
            return mTitles[position];
        }
    }
}
