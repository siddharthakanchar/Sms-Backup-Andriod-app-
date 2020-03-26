package siddhartha.smsbackup;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ViewInboxAdapter extends BaseAdapter {

	Context con;
	ArrayList<String> senderdata,messagedata,datedata;
	LayoutInflater li;
	public ViewInboxAdapter(Context con, ArrayList<String> senderdata,
			ArrayList<String> messagedata, ArrayList<String> datedata) {
		super();
		this.con = con;
		this.senderdata = senderdata;
		this.messagedata = messagedata;
		this.datedata = datedata;
		li=(LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return senderdata.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return senderdata;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}
TextView s,m,d;
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		convertView=li.inflate(R.layout.viewinbox,null);
		s=(TextView)convertView.findViewById(R.id.textView1);
		m=(TextView)convertView.findViewById(R.id.textView2);
		d=(TextView)convertView.findViewById(R.id.textView3);
		s.setText(senderdata.get(position).toString());
		m.setText(messagedata.get(position).toString());
		d.setText(datedata.get(position).toString());
		
		return convertView;
	}

}
