package com.yobo.studying_view.lsn07_drawerlayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;

import com.yobo.studying_view.R;

/**
 * Created by YoBo on 2018/4/30.
 * 1
 */

public class E_Navigation_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private NavigationView navigation;
    private DrawerLayout drawer;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.e_navigation);
        intiView();
    }

    private void intiView() {
        drawer = (DrawerLayout) findViewById(R.id.e_drawer_navigation);
        navigation = (NavigationView) findViewById(R.id.e_navigation);
        navigation.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case 1:
                break;
            default:
                drawer.closeDrawer(GravityCompat.START);
                break;
        }
        return true;
    }
}
