package loopz.monkeydart;

import loopz.monkeydart.async.CategoryAsyncTask;
import loopz.monkeydart.db.DBConstants;
import loopz.monkeydart.db.DBHelper;
import loopz.monkeydart.listadapter.IListAdapter;
import loopz.monkeydart.listadapter.impl.CategoryGridAdapter;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.GridView;

public class PortalActivity extends Activity {
	
	private GridView categoryGrid;
	private IListAdapter<String> gridAdapter;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_portal);
		
		initView();
//		insert();
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		new CategoryAsyncTask(this, gridAdapter).execute();
	}
	
	private void initView() {
		categoryGrid = (GridView) findViewById(R.id.category_grid);
		gridAdapter  = new CategoryGridAdapter(this);
		categoryGrid.setAdapter(gridAdapter);
	}
	
	private void insert() {
		DBHelper helper = new DBHelper(this);
    	SQLiteDatabase db = helper.getWritableDatabase();
    	ContentValues cv = new ContentValues();
		
    	cv.put(DBConstants.TARGET_VALUE, "0050");
    	cv.put(DBConstants.TARGET_NAME, "台灣50");
    	cv.put(DBConstants.TARGET_CATEGORY, "Stock");
		db.insert(DBConstants.TABLE_TARGET, null, cv);
		
    	cv.put(DBConstants.TARGET_VALUE, "2353");
    	cv.put(DBConstants.TARGET_NAME, "Acer");
    	cv.put(DBConstants.TARGET_CATEGORY, "Stock");
		db.insert(DBConstants.TABLE_TARGET, null, cv);
		
    	cv.put(DBConstants.TARGET_VALUE, "F001");
    	cv.put(DBConstants.TARGET_NAME, "小雞飯");
    	cv.put(DBConstants.TARGET_CATEGORY, "Food");
		db.insert(DBConstants.TABLE_TARGET, null, cv);
		
    	cv.put(DBConstants.TARGET_VALUE, "F002");
    	cv.put(DBConstants.TARGET_NAME, "蛋包麵");
    	cv.put(DBConstants.TARGET_CATEGORY, "Food");
		db.insert(DBConstants.TABLE_TARGET, null, cv);

    	cv.put(DBConstants.TARGET_VALUE, "L001");
    	cv.put(DBConstants.TARGET_NAME, "01");
    	cv.put(DBConstants.TARGET_CATEGORY, "Lottery");
		db.insert(DBConstants.TABLE_TARGET, null, cv);
		
    	cv.put(DBConstants.TARGET_VALUE, "L002");
    	cv.put(DBConstants.TARGET_NAME, "02");
    	cv.put(DBConstants.TARGET_CATEGORY, "Lottery");
		db.insert(DBConstants.TABLE_TARGET, null, cv);
		
    	cv.put(DBConstants.TARGET_VALUE, "T001");
    	cv.put(DBConstants.TARGET_NAME, "陽明山");
    	cv.put(DBConstants.TARGET_CATEGORY, "Travel");
		db.insert(DBConstants.TABLE_TARGET, null, cv);
		
    	cv.put(DBConstants.TARGET_VALUE, "T002");
    	cv.put(DBConstants.TARGET_NAME, "猴硐");
    	cv.put(DBConstants.TARGET_CATEGORY, "Travel");
		db.insert(DBConstants.TABLE_TARGET, null, cv);
		
    	cv.put(DBConstants.TARGET_VALUE, "C001");
    	cv.put(DBConstants.TARGET_NAME, "RED");
    	cv.put(DBConstants.TARGET_CATEGORY, "Color");
		db.insert(DBConstants.TABLE_TARGET, null, cv);
		
    	cv.put(DBConstants.TARGET_VALUE, "C002");
    	cv.put(DBConstants.TARGET_NAME, "BLUE");
    	cv.put(DBConstants.TARGET_CATEGORY, "Color");
		db.insert(DBConstants.TABLE_TARGET, null, cv);
    	db.close();
	}
}
