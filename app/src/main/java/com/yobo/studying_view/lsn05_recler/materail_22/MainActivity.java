package com.yobo.studying_view.lsn05_recler.materail_22;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

import com.yobo.studying_view.R;
import com.yobo.studying_view.lsn05_recler.C_WrapRecyclerView;

public class MainActivity extends Activity {

	private C_WrapRecyclerView recyclerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c_recyclerview);
		recyclerView = findViewById(R.id.c_recler);
		
		
//		View headerView = View.inflate(this, resource, root);
		TextView headerView = new TextView(this);
		//		TextView tv = headerView.findViewById(id);
		LayoutParams params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		headerView.setLayoutParams(params);
		headerView.setText("����HeaderView");
		recyclerView.addHeadView(headerView);
		
		TextView footerView = new TextView(this);
		params = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		footerView.setLayoutParams(params);
		footerView.setText("����FooterView");
		recyclerView.addFootView(footerView);
		
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add("item "+i); 
		}
		
		MyAdapter adapter = new MyAdapter(list);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		recyclerView.setAdapter(adapter);
		
	}

}
