package loopz.monkeydart.listadapter.impl;

import java.util.ArrayList;
import java.util.List;

import loopz.monkeydart.R;
import loopz.monkeydart.domain.Target;
import loopz.monkeydart.listadapter.IListAdapter;
import loopz.monkeydart.viewholder.TargetViewHolder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class ListAdapterImpl extends BaseAdapter implements IListAdapter<Target>, ListAdapter {

	private List<Target> dataList = new ArrayList<Target>(0);
	private LayoutInflater inflater;
	
	public ListAdapterImpl(Context context) {
		this.inflater = LayoutInflater.from(context);
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
		return dataList.get(position).getId();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TargetViewHolder holder;
		
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.list_target, null);
			holder      = new TargetViewHolder();
			holder.targetValue    = (TextView) convertView.findViewById(R.id.target_value);
			holder.targetName     = (TextView) convertView.findViewById(R.id.target_name);
			holder.targetCategory = (TextView) convertView.findViewById(R.id.target_category);
			
			convertView.setTag(holder);
		} else {
			holder = (TargetViewHolder) convertView.getTag();
		}
		
		Target target = dataList.get(position);
		holder.targetValue.setText(target.getValue());
		holder.targetName.setText(target.getName());
		holder.targetCategory.setText(target.getCategory());
		
		return convertView;
	}

	@Override
	public void updateList(List<Target> list) {
		this.dataList.clear();
		dataList.addAll(list);
		notifyDataSetChanged();
	}

}
