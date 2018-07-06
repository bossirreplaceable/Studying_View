package com.yobo.studying_view.lsn16_fab_animator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.yobo.studying_view.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoBo on 2018/5/31.
 * yobo
 */

public class N_FabAnimator_Activity extends AppCompatActivity implements N_VisibleListener {

    private RecyclerView recler;
    private Toolbar toolbar;
    private ImageButton fab;
    private List<String> reclerList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.n_fab_animator);
        initView();

    }

    private void initView() {
        recler = (RecyclerView) findViewById(R.id.n_relcer);
        toolbar = (Toolbar) findViewById(R.id.n_toolbar);
        fab = (ImageButton) findViewById(R.id.n_fab);
        reclerList = new ArrayList<>();
        setSupportActionBar(toolbar);
        for (int i = 0; i < 30; i++) {
            reclerList.add("齐天大圣-" + i);
        }
        D_ReclerAdapter mAdapter = new D_ReclerAdapter(reclerList);
        recler.setLayoutManager(new LinearLayoutManager(this));
        recler.setAdapter(mAdapter);
        recler.setOnScrollListener(new N_ScrollLisntener(this));
    }


    @Override
    public void onHide() {
        RelativeLayout.LayoutParams toolbarParam = (RelativeLayout.LayoutParams) toolbar.getLayoutParams();
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) fab.getLayoutParams();
        int height = params.height + params.bottomMargin;
        fab.animate().translationY(height).setInterpolator(new AccelerateInterpolator(3)).start();
        toolbar.animate().translationY(-toolbarParam.height).setInterpolator(new AccelerateInterpolator(3)).start();
    }

    @Override
    public void onVisible() {

        fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3)).start();
        toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3)).start();
    }
}
