package com.yobo.studying_view.lsn16_fab_animator;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * Created by YoBo on 2018/5/31.
 */

public class N_ScrollLisntener extends RecyclerView.OnScrollListener {


    private int distance = 20;
    private boolean isVisible = true;
    private N_VisibleListener listener;

    public N_ScrollLisntener(N_VisibleListener listener) {
        this.listener = listener;
    }


    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        Log.e("N--------------","dx==="+dy);
        if (dy > distance && isVisible) {
            listener.onHide();
            isVisible = false;
            dy=0;
            Log.e("N--------------","dx===1"+dy);
        } else if (dy < -distance && !isVisible) {
            listener.onVisible();
            isVisible = true;
            dy=0;
            Log.e("N--------------","dx===2"+dy);
        }


    }
}
