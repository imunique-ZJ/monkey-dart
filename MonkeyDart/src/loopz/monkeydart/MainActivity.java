package loopz.monkeydart;

import loopz.monkeydart.async.TargetAsyncTask;
import loopz.monkeydart.domain.Target;
import loopz.monkeydart.listadapter.IListAdapter;
import loopz.monkeydart.listadapter.impl.TargetListAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private ListView targetLV;
	private IListAdapter<Target> listAdapter;
	private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
        	category = bundle.getString("category");
        }
        initView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    public void onResume() {
    	super.onResume();
    	new TargetAsyncTask(this, listAdapter).execute(new String[] {category});
    }
    
    private void initView() {
    	listAdapter = new TargetListAdapter(this);
    	targetLV = (ListView) findViewById(R.id.target_list);
    	targetLV.setAdapter(listAdapter);
    }
}
