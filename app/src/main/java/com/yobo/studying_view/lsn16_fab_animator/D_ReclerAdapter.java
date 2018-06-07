package com.yobo.studying_view.lsn16_fab_animator;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yobo.studying_view.R;

import java.util.List;

/**
 * Created by YoBo on 2018/4/9.
 * 1
 */

public class D_ReclerAdapter extends RecyclerView.Adapter<D_ReclerAdapter.BViewHolder> {


    private List<String> list;

    D_ReclerAdapter(List<String> list){
        this.list = list;
    }

    @Override
    public BViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.d_recler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final BViewHolder holder, int position) {
        holder.tv_name.setText(list.get(position));



    }

    @Override
    public int getItemCount() {
        return list.size();
    }




  public   class BViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;
        ImageView iv_pic;

        BViewHolder(View itemView) {
            super(itemView);
            iv_pic = itemView.findViewById(R.id.d_item_iv);
            tv_name = itemView.findViewById(R.id.d_item_name);

        }
    }




}
