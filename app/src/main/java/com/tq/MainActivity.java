package com.tq;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tq.adapter.SimpleHomeAdapter;
import com.tq.ui.CommonTabActivity;
import com.tq.ui.SegmentTabActivity;
import com.tq.ui.SlidingTabActivity;

public class MainActivity extends AppCompatActivity {

    private Context mContext=this;
    private final String[] mItems={"SlidingTabLayout","CommonTabLayout","SegmentTabLayout"};
    private final Class<?>[]mClass={SlidingTabActivity.class, CommonTabActivity.class, SegmentTabActivity.class};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        ListView lv=new ListView(mContext);
        lv.setCacheColorHint(Color.TRANSPARENT);
        lv.setFadingEdgeLength(0);
        lv.setAdapter(new SimpleHomeAdapter(mContext,mItems));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(mContext,mClass[position]);
                startActivity(intent);
            }
        });

        setContentView(lv);

    }
}
