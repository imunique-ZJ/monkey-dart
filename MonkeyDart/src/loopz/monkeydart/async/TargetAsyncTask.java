package loopz.monkeydart.async;

import java.util.List;

import loopz.monkeydart.domain.Target;
import loopz.monkeydart.listadapter.IListAdapter;
import loopz.monkeydart.service.impl.TargetService;
import android.content.Context;
import android.os.AsyncTask;

public class TargetAsyncTask extends AsyncTask<String, Integer, List<Target>> {
	
	private TargetService targetService;
	private IListAdapter<Target> adapter;
	
	public TargetAsyncTask(Context context, IListAdapter<Target> adapter) {
		this.targetService = new TargetService(context);
		this.adapter       = adapter;
	}

	@Override
	protected List<Target> doInBackground(String... params) {
		return targetService.findTargetByCat((params.length == 0) ? null : params[0]);
	}

	@Override
	protected void onPostExecute(List<Target> result) {
		adapter.updateList(result);
	}
}
