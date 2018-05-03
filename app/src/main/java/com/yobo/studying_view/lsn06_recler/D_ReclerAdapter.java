package com.yobo.studying_view.lsn06_recler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yobo.studying_view.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by YoBo on 2018/4/9.
 * 1
 */

public class D_ReclerAdapter extends RecyclerView.Adapter<D_ReclerAdapter.BViewHolder> implements D_ItemMovedListener {


    private List<String> list;
    private setMyOnclickListener listener;

    D_ReclerAdapter(List<String> list, setMyOnclickListener listener1) {
        this.listener = listener1;
        this.list = list;
    }

    @Override
    public BViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.d_recler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final BViewHolder holder, int position) {
        holder.tv_name.setText(list.get(position));
        holder.iv_pic.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN || motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    listener.startDrag(holder);
                }
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    @Override
    public boolean itemMoved(int fromPosition, int toPosition) {
        Collections.swap(list, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public boolean itemRemoved(int position) {

        list.remove(position);
        notifyItemRemoved(position);
        return true;
    }

    class BViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        ImageView iv_pic;

        BViewHolder(View itemView) {
            super(itemView);
            iv_pic = itemView.findViewById(R.id.d_item_iv);
            tv_name = itemView.findViewById(R.id.d_item_name);
            tv_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(view, getAdapterPosition());
                }
            });
        }
    }

    interface setMyOnclickListener {

        void onClick(View v, int position);

        void startDrag(RecyclerView.ViewHolder viewHolder);

    }


}
