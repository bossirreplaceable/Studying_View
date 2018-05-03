package com.yobo.studying_view.lsn05_recler.materail_22;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yobo.studying_view.R;

public class MyAdapter extends Adapter<MyAdapter.ViewHolder> {
	private List<String> list;

	public MyAdapter(List<String> list) {
		// TODO Auto-generated constructor stub
		this.list = list;
	}

	
	public class ViewHolder extends RecyclerView.ViewHolder{

		public TextView tv;
		public ViewHolder(View view) {
			super(view);
			// TODO Auto-generated constructor stub
			tv = (TextView) view.findViewById(R.id.b_item_name);
		}
		
	}

	@Override
	public int getItemCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.tv.setText(list.get(position));
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View view = layoutInflater.inflate(R.layout.b_recler_item, parent, false);
		ViewHolder holder = new ViewHolder(view);
		return holder;
	}
}
