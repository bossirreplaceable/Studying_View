package com.yobo.studying_view.lsn05_recler;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by YoBo on 2018/4/23.
 * 自定义recyclerView
 */

public class C_WrapRecyclerView extends RecyclerView {


    private ArrayList<View> mHeaderViewList = new ArrayList<>();
    private ArrayList<View> mFooterViewList = new ArrayList<>();
    private Adapter mAdapter;

    public C_WrapRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public void addHeadView(View view) {
        mHeaderViewList.add(view);
        if (mAdapter != null) {
            if (!(mAdapter instanceof HeadListViewAdapter)) {
                mAdapter = new HeadListViewAdapter(mHeaderViewList, mFooterViewList, mAdapter);
            }
        }
    }
    public void addFootView(View v) {
        mFooterViewList.add(v);
        if (mAdapter != null) {
            if (!(mAdapter instanceof HeadListViewAdapter)) {
                mAdapter = new HeadListViewAdapter(mHeaderViewList, mFooterViewList, mAdapter);
            }
        }
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (mHeaderViewList.size() > 0 || mFooterViewList.size() > 0) {
            mAdapter = new HeadListViewAdapter(mHeaderViewList, mFooterViewList, adapter);
        } else {
            mAdapter = adapter;
        }
        super.setAdapter(mAdapter);
    }
}
