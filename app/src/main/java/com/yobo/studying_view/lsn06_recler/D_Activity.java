package com.yobo.studying_view.lsn06_recler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.yobo.studying_view.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoBo on 2018/4/25.
 * 1
 */

public class D_Activity extends AppCompatActivity implements D_ReclerAdapter.setMyOnclickListener {

    private RecyclerView recler;
    private D_ReclerAdapter mAdapter;
    private List<String> reclerList = new ArrayList<>();
    private ItemTouchHelper touchHelper;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.d_recyclerview);
        initView();
    }

    private void initView() {
        recler = (RecyclerView) findViewById(R.id.d_recler);


        for (int i = 0; i < 20; i++) {
            reclerList.add("齐天大圣-" + i);
        }
        mAdapter = new D_ReclerAdapter(reclerList, this);
        recler.setLayoutManager(new LinearLayoutManager(this));
        recler.setAdapter(mAdapter);

        //将触摸回调事件绑定到RecyclerView上
        D_ItemTouchHelper callback = new D_ItemTouchHelper(mAdapter);
        touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recler);


    }

    @Override
    public void onClick(View v, int position) {
    }

    /**
     * 实现点击图片就可拖拽的事件回调
     *
     * @param viewHolder
     */
    @Override
    public void startDrag(RecyclerView.ViewHolder viewHolder) {
        touchHelper.startDrag(viewHolder);
    }
}
