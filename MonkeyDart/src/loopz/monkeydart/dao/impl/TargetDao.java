package loopz.monkeydart.dao.impl;

import java.util.ArrayList;
import java.util.List;

import loopz.monkeydart.dao.AbstractDao;
import loopz.monkeydart.dao.IDao;
import loopz.monkeydart.db.DBConstants;
import loopz.monkeydart.domain.Target;
import android.content.ContentValues;
import android.database.Cursor;

public class TargetDao extends AbstractDao<Target, Integer> implements IDao<Target, Integer> {

	@Override
	protected String getSelectAllStatement() {
		return "SELECT  * FROM Target";
	}

	@Override
	protected List<Target> createEntityList(Cursor cursor) {
		List<Target> targetList = null;
		if (cursor.moveToFirst()) {
			targetList = new ArrayList<Target>();
			do {
				targetList.add(new Target(
								Integer.valueOf(cursor.getString(0)),
								cursor.getString(1),
								cursor.getString(2), 
								cursor.getString(3)));
			} while (cursor.moveToNext());
		}
		return targetList;
	}

	@Override
	protected String getTableName() {
		return DBConstants.TABLE_TARGET;
	}

	@Override
	protected String[] getSelectColumn() {
		return new String[]{DBConstants.TARGET_ID, DBConstants.TARGET_VALUE, DBConstants.TARGET_NAME, DBConstants.TARGET_CATEGORY};
	}

	@Override
	protected String getFindClause() {
		return DBConstants.TARGET_ID + " = ?";
	}

	@Override
	protected String[] getFindArgs(Integer pk) {
		return new String[] {String.valueOf(pk.intValue())};
	}

	@Override
	protected String getUpdateClause() {
		return DBConstants.TARGET_ID + " = ?";
	}

	@Override
	protected String[] getUpdateArgs(Target entity) {
		return new String[] {String.valueOf(entity.getId())};
	}

	@Override
	protected String getDeleteClause() {
		return DBConstants.TARGET_ID + " = ?";
	}

	@Override
	protected String[] getDeleteArgs(Integer pk) {
		return new String[] {String.valueOf(pk.intValue())};
	}

	@Override
	protected ContentValues createContentValues(Target entity) {
		ContentValues contentValues = new ContentValues();		
		contentValues.put(DBConstants.TARGET_ID, entity.getId());
		contentValues.put(DBConstants.TARGET_VALUE, entity.getValue());
		contentValues.put(DBConstants.TARGET_NAME, entity.getName());
		contentValues.put(DBConstants.TARGET_CATEGORY, entity.getCategory());		
		return contentValues;
	}
}
