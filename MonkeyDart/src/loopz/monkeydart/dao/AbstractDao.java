package loopz.monkeydart.dao;

import java.util.List;

import loopz.monkeydart.db.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class AbstractDao<ENTITY, PK> implements IDao<ENTITY, PK> {
	protected SQLiteOpenHelper dbHelper;
	private SQLiteDatabase db;
	

	public AbstractDao() {
		super();
	}
	
	public AbstractDao(Context context) {
		dbHelper = new DBHelper(context);
	}
	
	public List<ENTITY> findAll() {
		db = dbHelper.getReadableDatabase();
		return createEntityList(db.rawQuery(getSelectAllStatement(), null));
	}
	
	public ENTITY findByPK(PK pk) {
		db = dbHelper.getReadableDatabase();
	    return createEntityList(db.query(getTableName(), getSelectColumn(), getFindClause(), getFindArgs(pk), null, null, null, null)).get(0);
	}
	
	public void insert(ENTITY entity) {
		db = dbHelper.getWritableDatabase();
	    db.insert(getTableName(), null, createContentValues(entity));
	    db.close();
	}
	
	public void update(ENTITY entity) {
	    db = dbHelper.getWritableDatabase();
	    db.update(getTableName(), createContentValues(entity), getUpdateClause(), getUpdateArgs(entity));
	}
	
	public void delete(PK pk) {
		db = dbHelper.getWritableDatabase();
	    db.delete(getTableName(), getDeleteClause(), getDeleteArgs(pk));
	    db.close();
	}
	
	protected abstract String        getSelectAllStatement();
	protected abstract List<ENTITY>  createEntityList(Cursor cursor);
	protected abstract String        getTableName();
	protected abstract String[]      getSelectColumn();
	protected abstract String        getFindClause();
	protected abstract String[]      getFindArgs(PK pk);
	protected abstract String        getUpdateClause();
	protected abstract String[]      getUpdateArgs(ENTITY entity);
	protected abstract String        getDeleteClause();
	protected abstract String[]      getDeleteArgs(PK pk);
	protected abstract ContentValues createContentValues(ENTITY entity);
}

