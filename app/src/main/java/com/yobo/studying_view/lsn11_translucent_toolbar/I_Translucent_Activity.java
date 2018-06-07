package com.yobo.studying_view.lsn11_translucent_toolbar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.yobo.studying_view.R;

/**
 * Created by YoBo on 2018/5/10.
 * i
 */

public class I_Translucent_Activity extends AppCompatActivity implements I_TranslucentListener {

    private Toolbar toolbar;
    private I_ScrollView scrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.i_translucent_activity);
        initView();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.i_toolbar);
        setSupportActionBar(toolbar);
        scrollView = (I_ScrollView) findViewById(R.id.i_scroll);
        scrollView.setTranslucentListener(this);
    }

    @Override
    public void onTranslucent(float alpha) {
        toolbar.setAlpha(alpha);
    }
}
