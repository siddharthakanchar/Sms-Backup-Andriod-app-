package siddhartha.smsbackup;

import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.gsm.SmsManager;
import android.telephony.gsm.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MySMSReciever extends BroadcastReceiver {

	   // Get the object of SmsManager
    final SmsManager sms = SmsManager.getDefault();
    SQLiteDatabase db;
     
    public void onReceive(Context context, Intent intent) {
    	SMSDatabaseHelper smdb=new SMSDatabaseHelper(context);
		db=smdb.getWritableDatabase();
        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();
 
        try {
             
            if (bundle != null) {
                 
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                 
                for (int i = 0; i < pdusObj.length; i++) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);//,bundle.getString("format"));
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                     
                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();
 
                    Log.i("SmsReceiver", "senderNum: "+ senderNum + "; message: " + message);
                     
 
                   // Show Alert
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, 
                                 "senderNum: "+ senderNum + ", message: " + message, duration);
                    Date date=new Date();
                    ContentValues cv=new ContentValues();
                    cv.put("senderdata", senderNum);
                    cv.put("messagedata", message);
                    cv.put("datedata", date.toString());
                    db.insert("smsData", null, cv);
                    toast.show();
                     
                } // end for loop
              } // bundle is null
 
        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);
             
        }
	}

}
