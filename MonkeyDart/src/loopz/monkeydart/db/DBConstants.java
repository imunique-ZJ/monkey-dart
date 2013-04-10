package loopz.monkeydart.db;

public class DBConstants {

	// db info
	public static final String DB_NAME = "MonkeyDart.db";
	public static final int DB_VERSION = 1;
	
	// tables
	public static final String TABLE_TARGET = "target";
	
	// table columns
	public static final String TARGET_ID = "_id";
	public static final String TARGET_VALUE = "value";
	public static final String TARGET_NAME = "name";
	public static final String TARGET_CATEGORY = "category";
	
	// initial sqls
	public static String CREATE_TABLE_TARGET;
	
	// run on initializing
	static {
		CREATE_TABLE_TARGET = initTargetSql();
	}
	
	// create table target sql
	private static String initTargetSql() {
		StringBuilder sb = new StringBuilder("CREATE TABLE ");
		sb.append(TABLE_TARGET)
		  .append("(")
		  .append(TARGET_ID)
		  .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
		  .append(TARGET_VALUE)
		  .append(" VARCHAR(50), ")
		  .append(TARGET_NAME)
		  .append(" VARCHAR(50), ")
		  .append(TARGET_CATEGORY)
		  .append(" VARCHAR(50))");
		
		return sb.toString();
	}
}
