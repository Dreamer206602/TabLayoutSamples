package com.tq.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.tq.R;
import com.tq.fragment.AndroidFragment;
import com.tq.fragment.BaseFragment;
import com.tq.fragment.IosFragment;
import com.tq.fragment.JavaFragment;
import com.tq.fragment.SwiftFragment;
import com.tq.fragment.fragment2.BeautifulGirlFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Test4Activity extends AppCompatActivity {

    @Bind(R.id.fl_change)
    FrameLayout flChange;
    @Bind(R.id.rb_1)
    RadioButton rb1;
    @Bind(R.id.rb_2)
    RadioButton rb2;
    @Bind(R.id.rb_3)
    RadioButton rb3;
    @Bind(R.id.rb_4)
    RadioButton rb4;

    private Fragment currentSupportFragment;

    public BaseFragment baseFragment1;
    public BaseFragment baseFragment2;
    public BaseFragment baseFragment3;
    public BaseFragment baseFragment4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test4);
        ButterKnife.bind(this);
        baseFragment1= AndroidFragment.getInstance();
        baseFragment2= JavaFragment.getInstance();
        baseFragment3= SwiftFragment.getInstance();
        baseFragment4= IosFragment.getInstance();
        changeFragment(R.id.fl_change,baseFragment1);

      rb1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              changeFragment(R.id.fl_change,baseFragment1);
          }
      });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(R.id.fl_change,baseFragment2);
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(R.id.fl_change,baseFragment3);
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFragment(R.id.fl_change,baseFragment4);
            }
        });
    }

    public void changeFragment(int resView, Fragment targetFragment) {
        if(!targetFragment.equals(this.currentSupportFragment)) {
           FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            if(!targetFragment.isAdded()) {
                transaction.add(resView, targetFragment, targetFragment.getClass().getName());
            }

            if(targetFragment.isHidden()) {
                transaction.show(targetFragment);
            }

            if(this.currentSupportFragment != null && this.currentSupportFragment.isVisible()) {
                transaction.hide(this.currentSupportFragment);
            }

            this.currentSupportFragment = targetFragment;
            transaction.commit();
        }
    }

}
