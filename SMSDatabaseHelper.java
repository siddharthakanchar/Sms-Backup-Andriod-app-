package siddhartha.smsbackup;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SMSDatabaseHelper extends SQLiteOpenHelper {

	public SMSDatabaseHelper(Context context) {
		super(context, "SMSBACKUPDB", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
db.execSQL("create table smsData(sno integer primary key autoincrement,senderdata text,messagedata text,datedata text);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
