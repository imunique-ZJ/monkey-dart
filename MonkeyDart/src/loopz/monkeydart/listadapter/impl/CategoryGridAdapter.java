package loopz.monkeydart.listadapter.impl;

import java.util.ArrayList;
import java.util.List;

import loopz.monkeydart.R;
import loopz.monkeydart.listadapter.IListAdapter;
import loopz.monkeydart.viewholder.CategoryViewHolder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CategoryGridAdapter extends BaseAdapter implements IListAdapter<String> {

	private List<String> dataList = new ArrayList<String>(0);
	private LayoutInflater layoutInflater;
	
	public CategoryGridAdapter(Context context) {
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
		
		return convertView;
	}

	@Override
	public void updateList(List<String> list) {
		dataList.clear();
		dataList.addAll(list);
		notifyDataSetChanged();
	}

}
