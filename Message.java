package siddhartha.smsbackup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Message extends Activity {
	Button ssms,view;
	SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message);
		ssms=(Button)findViewById(R.id.button1);
		view=(Button)findViewById(R.id.button2);
		SMSDatabaseHelper smdb=new SMSDatabaseHelper(Message.this);
		db=smdb.getWritableDatabase();
		ssms.setOnClickListener(new OnClickListener() {
			
	
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				AlertDialog.Builder alert=new AlertDialog.Builder(Message.this);
				alert.setTitle("Initiating SMS BACKUP");
				alert.setMessage("Whether You want to Start or Not");
				alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent start=new Intent(Message.this, MySMSReciever.class);
						sendBroadcast(start);
						finish();
					}
				});
alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
					
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
		view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				
				
				Intent i=new Intent(Message.this,Display.class);
				startActivity(i);
			}
		});
	
		
	}
}
