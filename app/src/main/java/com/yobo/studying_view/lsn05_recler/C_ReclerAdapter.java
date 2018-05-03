package com.yobo.studying_view.lsn05_recler;

import android.support.v7.widget.RecyclerView;
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

public class C_ReclerAdapter extends RecyclerView.Adapter<C_ReclerAdapter.BViewHolder> {


    private List<String> list;
    private setMyOnclickListener listener;

    public C_ReclerAdapter(List<String> list, setMyOnclickListener listener1) {
        this.listener = listener1;
        this.list = list;
    }

    @Override
    public BViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.b_recler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(BViewHolder holder, int position) {

        holder.tv_name.setText(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;

        public BViewHolder(View itemView) {
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
