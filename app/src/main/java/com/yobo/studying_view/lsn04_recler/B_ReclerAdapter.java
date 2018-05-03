package com.yobo.studying_view.lsn04_recler;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yobo.studying_view.R;

import java.util.List;

/**
 * Created by YoBo on 2018/4/9.
 * 1
 */

public class B_ReclerAdapter extends RecyclerView.Adapter<B_ReclerAdapter.BViewHolder> {


    private List<String> list;
    private setMyOnclickListener listener;

    public B_ReclerAdapter(List<String> list, setMyOnclickListener listener1) {
        this.listener = listener1;
        this.list = list;
    }

    @Override
    public BViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.b_recler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(BViewHolder holder, int position) {

        Log.e("C--------", "position=" + position);
        holder.tv_name.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;

        BViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.b_item_name);
            tv_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(view, getAdapterPosition());
                }
            });
        }
    }

    public interface setMyOnclickListener {

        void onClick(View v, int position);
    }


}
