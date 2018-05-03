package com.yobo.studying_view.lsn04_recler;

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

public class B_ReclerAdapter_1 extends RecyclerView.Adapter<B_ReclerAdapter_1.BViewHolder> {


    private List<String> list;
    private setMyOnclickListener listener;

    public B_ReclerAdapter_1(List<String> list, setMyOnclickListener listener1) {
        this.listener = listener1;
        this.list = list;
    }

    @Override
    public BViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.b_recler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(BViewHolder holder, int position) {

      //  holder.itemView.setBackgroundColor(Color.valueOf((float) Math.random()*255,(float) Math.random()*255,(float) Math.random()*255));
        holder.tv_name.setText(list.get(position));
        //新建点击事件监听内部类，并将position引用到指定的view中，防止数据错乱
        holder.tv_name.setOnClickListener(new myOnclickListener(position));

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

        }
    }


   public interface setMyOnclickListener {
        void onClick(View v, int position);
    }

   public class myOnclickListener implements View.OnClickListener {

        private int position;

        public myOnclickListener(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View view) {
            if (listener != null) listener.onClick(view, position);

        }
    }

}
