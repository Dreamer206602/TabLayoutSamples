package com.tq.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tq.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AndroidFragment extends Fragment {

    private String mTitle;
    private AndroidFragment getInstance(String title){
        AndroidFragment instance=new AndroidFragment();
        instance.mTitle=title;
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_android, container, false);
    }

}
