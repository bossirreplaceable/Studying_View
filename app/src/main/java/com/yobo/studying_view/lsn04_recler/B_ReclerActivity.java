package com.yobo.studying_view.lsn04_recler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.yobo.studying_view.R;

import java.util.ArrayList;
import java.util.List;

/**
 * b
 * Created by YoBo on 2018/4/9.
 */

public class B_ReclerActivity extends AppCompatActivity implements B_ReclerAdapter.setMyOnclickListener {

    boolean isGrid = false;
    RecyclerView recler;
    B_ItemDecoration decoration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_recyclerview);
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.b_add:
                return true;

            case R.id.b_delete:
                return true;
            case R.id.b_change:
                if (decoration != null) recler.removeItemDecoration(decoration);
                if (!isGrid) {
                    decoration=new B_ItemDecoration(this,111);
                    recler.addItemDecoration(decoration);
                    recler.setLayoutManager(new GridLayoutManager(this, 3));
                } else {
                    recler.setLayoutManager(new LinearLayoutManager(this));
                }
                isGrid = !isGrid;
                return true;
            case R.id.b_change_divider:

                if (decoration != null) recler.removeItemDecoration(decoration);

                if (!isGrid) {
                    decoration = new B_ItemDecoration(this, LinearLayoutManager.VERTICAL);
                    recler.addItemDecoration(decoration);
                    recler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                } else {
                    decoration = new B_ItemDecoration(this, LinearLayoutManager.HORIZONTAL);
                    recler.addItemDecoration(decoration);
                    recler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                }
                isGrid = !isGrid;
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void initView() {
        recler = (RecyclerView) findViewById(R.id.b_recler);
        List<String> reclerList = new ArrayList<>();
        for (int i = 0; i < 102; i++) {
            reclerList.add("齐天大圣-" + i);
        }
        // B_ReclerAdapter_1 adapter_1 = new B_ReclerAdapter_1(reclerList, this);
        B_ReclerAdapter adapter = new B_ReclerAdapter(reclerList, this);
        recler.setLayoutManager(new LinearLayoutManager(this));
        decoration = new B_ItemDecoration(this, LinearLayoutManager.VERTICAL);
        recler.addItemDecoration(decoration);
        recler.setAdapter(adapter);
    }


    @Override
    public void onClick(View v, int position) {
        ToastUtils.showShort("点击了谁？=" + position);
    }
}
