package ranjith.smsbackup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Loginpage extends Activity {
	Button login;
	EditText username,password;
SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_loginpage);
    sp=(SharedPreferences)getSharedPreferences("RGUKT",Context.MODE_PRIVATE );
    username=(EditText)findViewById(R.id.editText1);
    password=(EditText)findViewById(R.id.editText2);
    
    login=(Button)findViewById(R.id.button1);
    if(sp.contains("username"))
    {
    	if(sp.getString("username", null).length()!=0)
    	{
    	Intent i=new Intent(Loginpage.this,Message.class);
		startActivity(i);
		finish();
    	}
    }
    else
    {
       login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!TextUtils.isEmpty(username.getText().toString())&&!TextUtils.isEmpty(password.getText().toString()))
				{
				Editor ed=sp.edit();
				ed.putString("username",username.getText().toString() );
				ed.putString("password",password.getText().toString() );
				ed.commit();
				Intent i=new Intent(Loginpage.this,Message.class);
				startActivity(i);
				finish();
			}
				else
				{
					Toast.makeText(Loginpage.this,"No Empty Fields", Toast.LENGTH_LONG).show();
				}
			}
		});
        

    }   
    }

}
