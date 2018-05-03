package com.yobo.studying_view.lsn07_drawerlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.yobo.studying_view.R;

/**
 * Created by YoBo on 2018/4/27.
 * 1
 */

public class E_Drawer_QQ_Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e_drawer_qq);
        initView();
    }

    private void initView() {
        drawer = (DrawerLayout) findViewById(R.id.e_drawer);
        toolbar = (Toolbar) findViewById(R.id.e_toolbar);
        setSupportActionBar(toolbar);
//        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.drawer_open, R.string.drawer_close);
//        drawerToggle.syncState();
//        drawer.addDrawerListener(drawerToggle);

        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            //侧滑移动是调用;slidOffset是一个0-1的数值
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                View content = drawer.getChildAt(0);//获取到contentView
                View menu = drawerView;
                float menuScale = 0.7f + 0.3f * slideOffset;//让侧滑View大小从0.7-1.0变化
                float contentScale = 1 - 0.3f * slideOffset;//让内容View大小从1.0-0,7变化
                menu.setScaleX(menuScale);
                menu.setScaleY(menuScale);
                content.setScaleX(contentScale);
                content.setScaleY(contentScale);
                content.setTranslationX(menu.getWidth()*slideOffset);//顺便让内容View跟随menuView向右移动
            }
            @Override
            public void onDrawerOpened(View drawerView) {}
            @Override
            public void onDrawerClosed(View drawerView) {}
            @Override
            public void onDrawerStateChanged(int newState) {}
        });


    }


}
