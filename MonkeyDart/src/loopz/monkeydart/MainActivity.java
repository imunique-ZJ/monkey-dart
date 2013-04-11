package loopz.monkeydart;

import loopz.monkeydart.async.TargetAsyncTask;
import loopz.monkeydart.db.DBConstants;
import loopz.monkeydart.db.DBHelper;
import loopz.monkeydart.domain.Target;
import loopz.monkeydart.listadapter.IListAdapter;
import loopz.monkeydart.listadapter.impl.ListAdapterImpl;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private ListView targetLV;
	private IListAdapter<Target> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
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
//        insert();
    	new TargetAsyncTask(this, listAdapter).execute();
    }
    
    private void initView() {
    	listAdapter = new ListAdapterImpl(this);
    	targetLV = (ListView) findViewById(R.id.target_list);
    	targetLV.setAdapter(listAdapter);
    }
    
    private void insert() {
    	String sql = "insert into target values ('0050', '台灣50', 'Stock');";
    	
    	DBHelper helper = new DBHelper(this);
    	SQLiteDatabase db = helper.getWritableDatabase();
    	ContentValues cv = new ContentValues();
    	cv.put(DBConstants.TARGET_VALUE, "0050");
    	cv.put(DBConstants.TARGET_NAME, "台灣50");
    	cv.put(DBConstants.TARGET_CATEGORY, "Stock");
    	
    	for (int i=0; i<10; i++)
    		db.insert(DBConstants.TABLE_TARGET, null, cv);
    	
    	db.close();
    }
}
