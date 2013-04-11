package loopz.monkeydart.async;

import java.util.List;

import loopz.monkeydart.listadapter.IListAdapter;
import loopz.monkeydart.service.impl.TargetService;
import android.content.Context;
import android.os.AsyncTask;

public class CategoryAsyncTask extends AsyncTask<String, Integer, List<String>> {
	
	private TargetService targetService;
	private IListAdapter<String> adapter;
	
	public CategoryAsyncTask(Context context, IListAdapter<String> adapter) {
		this.targetService = new TargetService(context);
		this.adapter       = adapter;
	}

	@Override
	protected List<String> doInBackground(String... params) {
		return targetService.findAllCategory();
	}

	@Override
	protected void onPostExecute(List<String> result) {
		adapter.updateList(result);
	}
}
