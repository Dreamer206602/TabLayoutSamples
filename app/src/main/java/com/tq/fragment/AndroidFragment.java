package com.tq.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.tq.R;
import com.tq.fragment.fragment2.BeautifulGirlFragment;
import com.tq.fragment.fragment2.FunnyFragment;
import com.tq.fragment.fragment2.GentlemanFragment;
import com.tq.fragment.fragment2.VideoFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidFragment extends BaseFragment {

    private volatile static AndroidFragment instance;
    @Bind(R.id.tl)
    SlidingTabLayout tl;
    @Bind(R.id.vp)
    ViewPager vp;

    private String[]mTitles={"美女", "帅哥", "搞笑", "视频"};
    private ArrayList<BaseFragment>mFragments=new ArrayList<>();


    public static AndroidFragment getInstance() {
        if (instance == null) {
            synchronized (AndroidFragment.class) {
                if (instance == null) {
                    instance = new AndroidFragment();
                }
            }
        }
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mFragments.add(BeautifulGirlFragment.getInstance());
        mFragments.add(GentlemanFragment.genInstance());
        mFragments.add(FunnyFragment.getInstance());
        mFragments.add(VideoFragment.getInstance());

        vp.setAdapter(new MyPagerAdapter(getChildFragmentManager()));
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
        tl.setCurrentTab(1);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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
