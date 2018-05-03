package com.yobo.studying_view.lsn06_recler;

/**
 * Created by YoBo on 2018/4/25.
 */

public interface D_ItemMovedListener {
    /**
     * 实现item拖拽移动的动画效果，交换位置不要忘了交换数据
     *
     * @param fromPosition
     * @param toPosition
     * @return
     */

    boolean itemMoved(int fromPosition, int toPosition);

    /**
     * 实现item的侧滑删除
     * @param position
     * @return
     */
    boolean itemRemoved(int position);
}
