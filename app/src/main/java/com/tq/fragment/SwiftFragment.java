package com.tq.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tq.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class SwiftFragment extends BaseFragment {

    @Bind(R.id.tv_card_title)
    TextView tvCardTitle;
    private String mTitle;

    private volatile static SwiftFragment instance;
    public static SwiftFragment getInstance() {
       if (instance==null){
           synchronized (IosFragment.class){
               if(instance==null){
                   instance=new SwiftFragment();
               }
           }
       }
        return instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_swift, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
