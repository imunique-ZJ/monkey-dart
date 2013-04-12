package loopz.monkeydart.listadapter.impl;

import java.util.ArrayList;
import java.util.List;

import loopz.monkeydart.MainActivity;
import loopz.monkeydart.R;
import loopz.monkeydart.listadapter.IListAdapter;
import loopz.monkeydart.viewholder.CategoryViewHolder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CategoryGridAdapter extends BaseAdapter implements IListAdapter<String> {

	private List<String> dataList = new ArrayList<String>(0);
	private Context context;
	private LayoutInflater layoutInflater;
	
	public CategoryGridAdapter(Context context) {
		this.context   = context;
		layoutInflater = LayoutInflater.from(context);
	}
	
	@Override
	public int getCount() {
		return dataList.size();
	}

	@Override
	public Object getItem(int position) {
		return dataList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		CategoryViewHolder holder = null;
		
		if (convertView == null) {
			convertView 	= layoutInflater.inflate(R.layout.grid_category, null);
			holder			= new CategoryViewHolder();
			holder.category = (TextView) convertView.findViewById(R.id.category);
			
			convertView.setTag(holder);
		} else {
			holder = (CategoryViewHolder) convertView.getTag();
		}
		
		holder.category.setText(dataList.get(position));
		holder.category.setOnClickListener(clickListener);
		
		return convertView;
	}

	@Override
	public void updateList(List<String> list) {
		dataList.clear();
		dataList.addAll(list);
		notifyDataSetChanged();
	}

	private View.OnClickListener clickListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			String category = ((TextView) v).getText().toString();
			Intent intent = new Intent(context, MainActivity.class);
			Bundle bundle = new Bundle();
			bundle.putString("category", category);
			intent.putExtras(bundle);
			context.startActivity(intent);
		}
	};
}
