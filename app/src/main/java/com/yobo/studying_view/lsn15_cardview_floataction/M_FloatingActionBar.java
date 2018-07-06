package com.yobo.studying_view.lsn15_cardview_floataction;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yobo.studying_view.R;

/**
 * Created by YoBo on 2018/5/31.
 */

public class M_FloatingActionBar extends AppCompatActivity {


    private FloatingActionButton  fab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_floatingactionbutton);
        fab= (FloatingActionButton) findViewById(R.id.m_fab);

    }

    private boolean reverse=false;
    public void rotateFab(View v ){
        float toDegree=reverse? -180f:180f;
        ObjectAnimator animator=ObjectAnimator.ofFloat(v,"rotation",toDegree);
        animator.setDuration(400);
        animator.start();
        reverse=!reverse;
    }
}
