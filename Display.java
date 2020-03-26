package ranjith.smsbackup;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Display extends Activity{
	ListView listView;
 SQLiteDatabase db;
 ArrayList<String> s,m,d;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		listView=(ListView)findViewById(R.id.listView1);
		SMSDatabaseHelper smdb=new SMSDatabaseHelper(Display.this);
		db=smdb.getWritableDatabase();
		s=new ArrayList<String>();
		m=new ArrayList<String>();
		d=new ArrayList<String>();
	Cursor cur=db.query("smsData", new String[]{"senderdata","messagedata","datedata"}, null,null, null, null, null);
	if(cur.moveToFirst())
		do
		{
			s.add(cur.getString(0));
			m.add(cur.getString(1));
			d.add(cur.getString(2));
			ViewInboxAdapter va=new ViewInboxAdapter(Display.this, s, m,d);
listView.setAdapter(va);
			
		}while(cur.moveToNext());
	listView.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// TODO Auto-generated method stub
			
			AlertDialog.Builder alert=new AlertDialog.Builder(Display.this);
			alert.setTitle("From :  "+s.get(position).toString());
			alert.setMessage(m.get(position).toString());
			alert.setPositiveButton("Thank You", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dialog.dismiss();
				}
			});

alert.create();
alert.show();
		}
	});
	}

      

}
