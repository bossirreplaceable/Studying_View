package com.yobo.studying_view.lsn10_searchview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.yobo.studying_view.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoBo on 2018/5/10.
 * h
 */

public class H_SearchView_Activity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView listView;
    List<String> goods;
//    private SearchView

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.h_searchview_activity);
        toolbar = (Toolbar) findViewById(R.id.h_toolbar);
        listView = (ListView) findViewById(R.id.h_recler);
        initDatas();
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.h_menu, menu);
        MenuItem item = menu.findItem(R.id.h_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setIconified(false); //直接先显示搜索框
        searchView.setIconifiedByDefault(false);//将搜索icon放在搜索框的外边
//        searchView.onActionViewExpanded();//设置搜索框不可关闭
        searchView.setQueryHint("请输入商品名");//设置提示文字
        searchView.setSubmitButtonEnabled(true);//显示搜索按钮 默认 >
//        ImageView bt_go=searchView.findViewById(R.id.search_go_btn);//将搜索按钮改为自己的按钮
//        bt_go.setImageResource(R.mipmap.voice);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //点击搜索按钮回调在此
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                //监听文字变化
                queryGoods(newText);
                return true;
            }
        });
        return true;
    }
    private void queryGoods(String key) {
        List<String>  showGoods=new ArrayList<>();
        for (String good:goods){
            if (key.length()<=good.length()) {
                if (good.contains(key)){
                    showGoods.add(good);
                }
            }
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, showGoods);
        listView.setAdapter(adapter);
    }

    private void initDatas(){
        goods = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            goods.add(i+"小子");
        }
    }

}
