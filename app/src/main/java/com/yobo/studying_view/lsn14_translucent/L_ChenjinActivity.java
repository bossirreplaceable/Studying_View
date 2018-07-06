package com.yobo.studying_view.lsn14_translucent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.yobo.studying_view.R;

/**
 * Created by YoBo on 2018/5/31.
 *
 */

public class L_ChenjinActivity extends BaseTranslucentActivity {


    Toolbar toolbar;
    View  nav_bg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.l_activity);
        toolbar= (Toolbar) findViewById(R.id.l_toolbar);
        nav_bg=findViewById(R.id.l_nav_bg);

        setOrChangeTranslucentColor(toolbar,nav_bg,getResources().getColor(R.color.colorPrimary));

    }
}
