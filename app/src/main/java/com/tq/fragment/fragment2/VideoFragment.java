package com.tq.fragment.fragment2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tq.R;
import com.tq.fragment.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends BaseFragment {
    private volatile static VideoFragment instance;
    public static  VideoFragment getInstance(){
        if(instance==null){
            synchronized (VideoFragment.class){
                if(instance==null){
                    instance=new VideoFragment();
                }
            }
        }
        return instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_video, container, false);
    }

}
