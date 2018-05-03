package com.yobo.studying_view.lsn04_recler;

import android.content.Context;
//import android.content.res.TypedArray;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;


/**
 * Created by YoBo on 2018/4/10.\
 * <p>
 * 1.图片的获取可以通过获取系统listDivider来设置分隔线，分隔线的颜色和大小可以通过appTheme中的listDivider来改变
 * 2.第二种方式是通过直接获取drawable来获取
 */

class B_ItemDecoration extends RecyclerView.ItemDecoration {

    private final static int GRID = 111;
    private int mOrientation;
    private Drawable mDivider;


    B_ItemDecoration(Context mContext, int mOrientation) {
        //拿系统本身的分隔线图片1
        int[] attrs = new int[]{android.R.attr.listDivider};
        TypedArray array = mContext.obtainStyledAttributes(attrs);
        mDivider = array.getDrawable(0);
        array.recycle();//记得回收哦
// 2.       if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            mDivider=mContext.getDrawable(R.drawable.b_decoration);
//        }
        setOrientation(mOrientation);
    }

    private void setOrientation(int orientation) {
        if (orientation != LinearLayoutManager.HORIZONTAL && orientation != LinearLayoutManager.VERTICAL && orientation != GRID) {
            throw new IllegalArgumentException("布局方向错误！");//多用抛出异常
        }
        this.mOrientation = orientation;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //1.先调用该方法（获取条目之间的偏移量--Rect矩形区域）
        // 获得条目的偏移量（所有条目都会调用该方法）

        int rightWidth = mDivider.getIntrinsicWidth();
        int bottomHeight = mDivider.getIntrinsicHeight();

        if (mOrientation == LinearLayoutManager.VERTICAL) {
            outRect.set(0, 0, 0, bottomHeight);
            Log.e("B--------------", "VERTICAL==true");
        } else if (mOrientation == LinearLayoutManager.HORIZONTAL) {
            outRect.set(0, 0, rightWidth, 0);
            Log.e("B--------------", "HORIZONTAL==true");
        } else {
            Log.e("B--------------", "Grid==true");
            if (isLastColumn(parent.getChildAdapterPosition(view), parent)) {
                rightWidth = 0;
            }
            if (isLastRow(parent.getChildAdapterPosition(view), parent)) {
                bottomHeight = 0;
            }
            outRect.set(0, 0, rightWidth, bottomHeight);

        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        //2.RecyclerView回调该方法，绘制自己的分隔线
        //super.onDraw(c, parent, state);
        if (mOrientation == LinearLayoutManager.VERTICAL) {
            drawVertical(c, parent);
        } else if (mOrientation == LinearLayoutManager.HORIZONTAL) {
            drawHorizontal(c, parent);
        } else {
            drawGridH(c, parent);
            drawGridV(c, parent);
        }
    }


    /**
     * 判断是否是最后一列
     * @param position
     * @param parent
     * @return
     */

    private boolean isLastColumn(int position, RecyclerView parent) {

        RecyclerView.LayoutManager manager = parent.getLayoutManager();

        if (manager instanceof GridLayoutManager) {
            GridLayoutManager layoutManager = (GridLayoutManager) manager;
            int spanCount = layoutManager.getSpanCount();
            if (position % spanCount == spanCount - 1) {
                return true;
            }
        }
        return false;

    }

    /**
     * 判断是否是最后一行
     * @param position
     * @param parent
     * @return
     */

    private boolean isLastRow(int position, RecyclerView parent) {

        Log.e("B--------------", "position==" + position);
        RecyclerView.LayoutManager manager = parent.getLayoutManager();
        if (manager instanceof GridLayoutManager) {
            GridLayoutManager layoutManager = (GridLayoutManager) manager;
            int childCount = parent.getAdapter().getItemCount();
            Log.e("B--------------", "childCount==" + childCount);
            int spanCount = layoutManager.getSpanCount();
            int lastRow = childCount -(position + 1);
            Log.e("B--------------", "lastRow==" + lastRow);
            if (lastRow < spanCount) {
                return true;
            }
        }

        return false;

    }


    /**
     * 绘制Grid布局的竖分隔线
     *
     * @param c
     * @param parent
     */

    private void drawGridV(Canvas c, RecyclerView parent) {

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {

            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getTop() - params.topMargin;
            int bottom = child.getBottom() + params.bottomMargin;
            int left = child.getRight() + params.leftMargin;
            int right = left + mDivider.getIntrinsicWidth();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);

        }


    }

    /**
     * 绘制Grid布局中的横分隔线
     * @param c
     * @param parent
     */

    private void drawGridH(Canvas c, RecyclerView parent) {

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {

            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.topMargin;
            int bottom = top + mDivider.getIntrinsicWidth();
            int left = child.getLeft() - params.leftMargin;
            int right = child.getRight() + params.rightMargin;
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);

        }


    }

    /**
     * 绘制HORIZATION线性布局的竖分隔线
     * @param c
     * @param parent
     */

    private void drawHorizontal(Canvas c, RecyclerView parent) {

        //记得RecyclerView的padding值
        int top = parent.getPaddingTop();
        int bottom = parent.getHeight() - parent.getPaddingBottom();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {

            View child = parent.getChildAt(i);
            //每个itemView有可能有自己的margin值，分隔线还有动画移动要随着动画移动哦
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int left = child.getRight() + params.rightMargin + Math.round(ViewCompat.getTranslationX(child));
            int right = left + mDivider.getIntrinsicWidth();
            Log.e("B--------------", "right==" + right);
            Log.e("B--------------", "left==" + left);
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);

        }


    }
    /**
     * 绘制线性布局的竖VERTICA横分隔线
     * @param c
     * @param parent
     */


    private void drawVertical(Canvas c, RecyclerView parent) {

        int left = parent.getPaddingStart();
        int right = parent.getWidth() - parent.getPaddingEnd();
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin + Math.round(ViewCompat.getTranslationY(child));
            int bottom = top + mDivider.getIntrinsicHeight();
            Log.e("B--------------", "top==" + top);
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }


    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}
