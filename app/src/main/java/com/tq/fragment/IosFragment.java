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
public class IosFragment extends Fragment {

    @Bind(R.id.tv_card_title)
    TextView tvCardTitle;
    private String mTitle;

    public static IosFragment getInstance(String title) {
        IosFragment f = new IosFragment();
        f.mTitle = title;
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ios, container, false);
        ButterKnife.bind(this, view);
        tvCardTitle.setText(mTitle);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
