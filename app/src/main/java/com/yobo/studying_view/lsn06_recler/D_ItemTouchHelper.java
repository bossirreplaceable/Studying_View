package com.yobo.studying_view.lsn06_recler;

import android.graphics.Canvas;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.yobo.studying_view.R;

/**
 * Created by YoBo on 2018/4/25.
 * 1
 */

public class D_ItemTouchHelper extends ItemTouchHelper.Callback {

    D_ItemMovedListener mListener;

    public D_ItemTouchHelper(D_ItemMovedListener listener) {
        this.mListener = listener;
    }

    //Callback回调监听时先调用的，用来判断当前是什么动作，比如判断方向（监听哪个方向的拖拽）
    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipFlags = ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;
        return makeMovementFlags(dragFlags, swipFlags);
    }

    //是否可以长按拖拽
    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    //当移动的时候回到此方法--拖拽
    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

        if (viewHolder.getItemViewType() != target.getItemViewType()) {
            return false;
        }
        return mListener.itemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
    }
    //当侧滑的时候会回调此方法
    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        // mListener.itemRemoved(viewHolder.getAdapterPosition());
    }
    /**
     * item拖拽或者侧滑时绘制它的背景颜色或者其他效果
     */
    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);

        if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
            viewHolder.itemView.setBackgroundColor(ContextCompat.getColor(viewHolder.itemView.getContext(), R.color.colorPrimary));

        }
    }
    /**
     * 放开被拖动的item后，设置item恢复后的背景或者其他效果
     */
    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setBackgroundColor(ContextCompat.getColor(viewHolder.itemView.getContext()
                , R.color.colorAccent));
    }
    /**
     * 在item移动过程中重新绘制itemView，以达到透明，缩放，旋转，等效果
     */
    @Override
    public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                            float dX, float dY, int actionState, boolean isCurrentlyActive) {
        //注释掉你会发现侧滑时，itemview不会左右移动
        // super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        if (viewHolder.getAdapterPosition() % 2 == 0) {
//            实现滑动缩小变透明的效果，
            viewHolder.itemView.setTranslationX(dX);
            float alpha = 1 - Math.abs(dX) / viewHolder.itemView.getWidth();
            if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                viewHolder.itemView.setAlpha(alpha);
                viewHolder.itemView.setScaleX(alpha);
                viewHolder.itemView.setScaleY(alpha);
            }
            // 在itemView被滑出删除后，恢复itemview的原样，好被下一个item使用
            if (alpha == 0) {
                viewHolder.itemView.setAlpha(1);
                viewHolder.itemView.setScaleY(1);
                viewHolder.itemView.setScaleX(1);
            }
        } else {
            //滑动超过itemview宽度的一半itemview悬停，实现添加删除按钮的效果
            if (dX <= -viewHolder.itemView.getWidth() / 2) {
                viewHolder.itemView.setTranslationX(-viewHolder.itemView.getWidth() / 2);
            } else if (dX >= viewHolder.itemView.getWidth() / 2)
                viewHolder.itemView.setTranslationX(viewHolder.itemView.getWidth() / 2);
            else {
                viewHolder.itemView.setTranslationX(dX);
            }
        }
    }
}
