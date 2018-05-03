package com.yobo.studying_view.lsn04_recler;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;

import com.blankj.utilcode.util.ToastUtils;
import com.yobo.studying_view.R;

/**
 * Created by YoBo on 2018/4/9.
 * 1
 */

public class A_Activity extends AppCompatActivity {


    private SwipeRefreshLayout refresh;
    private ProgressBar progress;
    private ListPopupWindow popup;
    private ArrayAdapter<String> adapter;
    private Button bt_popup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_activity);
        initView();

    }


    private void initView() {

        bt_popup = (Button) findViewById(R.id.a_popup);
        progress = (ProgressBar) findViewById(R.id.a_progress);
        progress.setMax(100);
        progress.setProgress(33);

        refresh = (SwipeRefreshLayout) findViewById(R.id.a_refresh);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                ToastUtils.showShort("完成了刷新");
            }
        });
        refresh.setSize(200);
        refresh.setColorSchemeColors(Color.BLUE, Color.GRAY, Color.RED);

        String[] popupList = {"小子1", "小子2", "小子3", "小子4"};
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, popupList);

        popup = new ListPopupWindow(this);
        popup.setAdapter(adapter);
        popup.setAnchorView(bt_popup);
        popup.setWidth(200);
        popup.setHeight(200);
        popup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ToastUtils.showShort("点击了" + i + "小子");
                popup.dismiss();
            }
        });

    }

    public void showPopup(View v) {
        popup.show();
    }

    public void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.getMenuInflater().inflate(R.menu.main, popupMenu.getMenu());
        popupMenu.show();
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                return false;
            }
        });

    }
}
