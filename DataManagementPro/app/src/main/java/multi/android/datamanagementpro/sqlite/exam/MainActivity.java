package multi.android.datamanagementpro.sqlite.exam;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

import multi.android.datamanagementpro.R;
import multi.android.datamanagementpro.sqlite.exam.DBHandler;
import multi.android.datamanagementpro.sqlite.exam.ReadActivity;

public class MainActivity extends
		AppCompatActivity implements AdapterView.OnItemClickListener,OnClickListener {
	DBHandler handler;
	EditText edtName;
	EditText edtSu;
	EditText edtPrice;
	ListView listview;
	ArrayList<item> itemArrayList;
	item item;
	String name;
	int quantity;
	int price;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		handler = new DBHandler(this);

		findViewById(R.id.btnIns).setOnClickListener(this);
		findViewById(R.id.btnResult).setOnClickListener(this);
		findViewById(R.id.btnResult2).setOnClickListener(this);
		findViewById(R.id.btnSearch).setOnClickListener(this);
		listview = findViewById(R.id.list);
		listview.setOnItemClickListener(this);

		edtName = (EditText)findViewById(R.id.edtName);
		edtSu = (EditText)findViewById(R.id.edtSu);
		edtPrice = (EditText)findViewById(R.id.edtPrice);

	}
	@Override
	public void onClick(View v) {
		item = new item(name,price,quantity);
		Cursor cursor;
		switch (v.getId()){
			case R.id.btnIns:
				name = edtName.getText().toString();
				quantity = Integer.parseInt(edtSu.getText().toString());
				price = Integer.parseInt(edtPrice.getText().toString());
				handler.insertItem(item);
				break;
			case R.id.btnResult:
				showSelectResult(handler.showResult());
				break;
			case R.id.btnResult2:
				showSelectResult2(handler.showResult());
				break;
			case R.id.btnSearch:
				name = edtName.getText().toString();
				item = new item(name,price,quantity);
				showSearchResult(handler.searchItem(item));
				break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = new Intent();
		String str = parent.getItemAtPosition(position).toString();
		Log.d("ARRRR", str.contains("info")+"");
		String[] arr = str.split(",");
		if(!str.contains("info")){//result1
			Toast.makeText(this,arr[1],Toast.LENGTH_SHORT).show();
		}else {
			Toast.makeText(this,arr[0].substring(5),Toast.LENGTH_SHORT).show();
		}
		Log.d("ARRRR", str);
		Log.d("ARRRR", arr[0]);
		//Toast.makeText(this,arr[0],Toast.LENGTH_SHORT).show();
		item.name = arr[0].substring(5);
		handler.searchItem(item);
	}

	public void showSelectResult(Cursor cursor){
		ArrayList<HashMap<String,String>> itemArrayList = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> itemHashMap;
		int i = 0;
		while (cursor.moveToNext()){
			i++;
			itemHashMap = new HashMap<String,String>();
			itemHashMap.put("name", i+","+cursor.getString(1)+","+cursor.getInt(2)+", "+cursor.getInt(3)+"원");
			itemArrayList.add(itemHashMap);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, itemArrayList, android.R.layout.simple_list_item_1,
				new String[] {"name"},
				new int[] {android.R.id.text1});
		listview.setAdapter(simpleAdapter);
	}
	public void showSelectResult2(Cursor cursor){
		ArrayList<HashMap<String,String>> itemArrayList = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> itemHashMap;
		while (cursor.moveToNext()){
			itemHashMap = new HashMap<String,String>();
			itemHashMap.put("name", cursor.getString(1));
			itemHashMap.put("info", cursor.getInt(2)+", "+cursor.getInt(3)+"원");
			itemArrayList.add(itemHashMap);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, itemArrayList, android.R.layout.simple_list_item_2,
				new String[] {"name","info"},
				new int[] {android.R.id.text1, android.R.id.text2});
		listview.setAdapter(simpleAdapter);
	}

	public void showSearchResult(Cursor cursor){
		ArrayList<HashMap<String,String>> itemArrayList = new ArrayList<HashMap<String,String>>();
		HashMap<String,String> itemHashMap;
		while (cursor.moveToNext()){
			itemHashMap = new HashMap<String,String>();
			itemHashMap.put("name", cursor.getString(1));
			itemHashMap.put("info", cursor.getInt(2)+", "+cursor.getInt(3)+"원");
			itemArrayList.add(itemHashMap);
		}
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, itemArrayList, android.R.layout.simple_list_item_2,
				new String[] {"name","info"},
				new int[] {android.R.id.text1, android.R.id.text2});
		listview.setAdapter(simpleAdapter);
	}
}



















