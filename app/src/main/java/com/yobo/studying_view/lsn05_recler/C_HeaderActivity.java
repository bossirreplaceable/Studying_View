package com.yobo.studying_view.lsn05_recler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.yobo.studying_view.R;
import com.yobo.studying_view.lsn04_recler.B_ReclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoBo on 2018/4/23.
 * header and footer
 */

public class C_HeaderActivity extends AppCompatActivity implements B_ReclerAdapter.setMyOnclickListener {

    private C_WrapRecyclerView recler;
    private List<String> reclerList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.c_recyclerview);

        initView();


    }

    private void initView() {


        if (reclerList.size() > 0) reclerList.clear();
        recler = (C_WrapRecyclerView) findViewById(R.id.c_recler);
        for (int i = 0; i < 10; i++) {
            reclerList.add("齐天大圣-" + i);
        }
        ImageView ivHead = new ImageView(this);
        ivHead.setImageResource(R.mipmap.ic_launcher);
        recler.addHeadView(ivHead);
        ImageView ivFoot = new ImageView(this);
        ivFoot.setImageResource(R.mipmap.ic_launcher);
        recler.addFootView(ivFoot);
        // B_ReclerAdapter_1 adapter_1 = new B_ReclerAdapter_1(reclerList, this);
        B_ReclerAdapter adapter = new B_ReclerAdapter(reclerList, this);
        recler.setLayoutManager(new LinearLayoutManager(this));
        recler.setAdapter(adapter);


    }

    @Override
    public void onClick(View v, int position) {

    }
}
