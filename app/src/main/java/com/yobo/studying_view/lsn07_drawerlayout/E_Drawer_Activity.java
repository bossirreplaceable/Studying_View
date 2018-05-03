package com.yobo.studying_view.lsn07_drawerlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.yobo.studying_view.R;

/**
 * Created by YoBo on 2018/4/27.
 * 1
 */

public class E_Drawer_Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e_drawer);
        initView();
    }

    private void initView() {
        drawer = (DrawerLayout) findViewById(R.id.e_drawer);
        toolbar = (Toolbar) findViewById(R.id.e_toolbar);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerToggle.syncState();
        drawer.addDrawerListener(drawerToggle);
    }


}
