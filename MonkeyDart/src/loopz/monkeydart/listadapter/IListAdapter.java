package loopz.monkeydart.listadapter;

import java.util.List;

import android.widget.ListAdapter;

public interface IListAdapter<T> extends ListAdapter {

	public void updateList(List<T> list);
}
