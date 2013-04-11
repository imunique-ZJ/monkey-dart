package loopz.monkeydart.service.impl;

import java.util.ArrayList;
import java.util.List;

import loopz.monkeydart.db.DBConstants;
import loopz.monkeydart.db.DBHelper;
import loopz.monkeydart.domain.Target;
import loopz.monkeydart.service.ITargetService;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TargetService implements ITargetService {

	private DBHelper dbHelper;
	
	public TargetService(Context context) {
		dbHelper = new DBHelper(context);
	}
	
	@Override
	public List<Target> findAllTarget() {
		return findTargetByCat(null);
	}

	@Override
	public List<Target> findTargetByCat(String category) {
		String whereCond = (category != null && category.length() > 0) ?
							DBConstants.TARGET_CATEGORY + "=?" : 
							null;
		
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		Cursor cursor = db.query(DBConstants.TABLE_TARGET, null, whereCond, null, null, null, DBConstants.TARGET_ID);
		
		List<Target> list = new ArrayList<Target>();
		while (cursor.moveToNext()) {
			Target target = new Target();
			target.setId(cursor.getInt(cursor.getColumnIndex(DBConstants.TARGET_ID)));
			target.setValue(cursor.getString(cursor.getColumnIndex(DBConstants.TARGET_VALUE)));
			target.setName(cursor.getString(cursor.getColumnIndex(DBConstants.TARGET_NAME)));
			target.setCategory(cursor.getString(cursor.getColumnIndex(DBConstants.TARGET_CATEGORY)));
			
			list.add(target);
		}
		db.close();
		
		return list;
	}

	@Override
	public List<String> findAllCategory() {
		StringBuilder sb = new StringBuilder("SELECT DISTINCT ");
		sb.append(DBConstants.TARGET_CATEGORY)
		  .append(" FROM ")
		  .append(DBConstants.TABLE_TARGET);
		
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		Cursor cursor = db.rawQuery(sb.toString(), null);
		
		List<String> list = new ArrayList<String>();
		while (cursor.moveToNext()) {
			list.add(cursor.getString(0));
		}
		db.close();
		
		return list;
	}

}
