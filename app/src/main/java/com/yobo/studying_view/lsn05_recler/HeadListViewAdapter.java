package com.yobo.studying_view.lsn05_recler;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YoBo on 2018/4/23.
 * 外层Adapter
 */

public class HeadListViewAdapter extends Adapter {

    private final static int HEADER_VIEW_TYPE = -1;
    private final static int FOOTER_VIEW_TYPE = -2;
    private RecyclerView.Adapter mAdapter;
    private List<View> mHeaderViewList;
    private List<View> mFooterViewList;

    public HeadListViewAdapter(ArrayList<View> headerViewList,
                               ArrayList<View> footerViewList, Adapter adapter) {
        mAdapter = adapter;
        if (headerViewList == null) {
            mHeaderViewList = new ArrayList<>();
        } else {
            mHeaderViewList = headerViewList;
        }
        if (footerViewList == null) {
            mFooterViewList = new ArrayList<>();
        } else {
            this.mFooterViewList = footerViewList;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == HEADER_VIEW_TYPE) {
            return new HeadViewHolder(mHeaderViewList.get(0));
        } else if (viewType == FOOTER_VIEW_TYPE) {
            return new HeadViewHolder(mFooterViewList.get(0));
        }
        return mAdapter.onCreateViewHolder(parent, viewType);
    }

    @Override
    public int getItemCount() {
        if (mAdapter != null) {
            Log.e("C--------", "AllCount=" + mAdapter.getItemCount() + getHeaderCount() + getFooterCount());
            return mAdapter.getItemCount() + getHeaderCount() + getFooterCount();
        } else {
            return getHeaderCount() + getFooterCount();
        }
    }

    @Override
    public int getItemViewType(int position) {

        int headCount = getHeaderCount();
        if (position - headCount < 0) {
            return HEADER_VIEW_TYPE;
        }

        final int adjPosition = position - headCount;
        int numbers = 0;
        if (mAdapter != null) {
            numbers = mAdapter.getItemCount();
            if (adjPosition < numbers) {
                return mAdapter.getItemViewType(adjPosition);
            }
        }
        return FOOTER_VIEW_TYPE;
    }

//

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //方式一
// int headCount = getHeaderCount();
//        if (position < headCount) {
//            return;
//        }
//         int adjPosition = position - headCount;
//        int numbers = 0;
//        if (mAdapter != null) {
//            numbers = mAdapter.getItemCount();
//            if (adjPosition < numbers) {
//                mAdapter.onBindViewHolder(holder, adjPosition);
//                return;
//            }
//        }
        //方式二
        if (!(holder instanceof HeadViewHolder)) {
            int headCount = getHeaderCount();
            int adjPosition = position - headCount;
            mAdapter.onBindViewHolder(holder, adjPosition);
        }
    }


    private int getHeaderCount() {
        return mHeaderViewList.size();
    }

    private int getFooterCount() {
        return mFooterViewList.size();
    }

    private static class HeadViewHolder extends ViewHolder {

        HeadViewHolder(View itemView) {
            super(itemView);
        }

    }

}
