package com.yobo.studying_view.lsn11_translucent_toolbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * Created by YoBo on 2018/5/10.
 *
 */

public class I_ScrollView extends ScrollView {

    I_TranslucentListener listener;

    public I_ScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setTranslucentListener(I_TranslucentListener listener) {
        this.listener = listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        int scrollY = getScrollY();
        float screenHeight = getContext().getResources().getDisplayMetrics().heightPixels;

        if (scrollY <= screenHeight / 3f && listener != null) {
            float alpha = scrollY / (screenHeight / 3f);
            listener.onTranslucent(1 - alpha);
        }
    }
}
