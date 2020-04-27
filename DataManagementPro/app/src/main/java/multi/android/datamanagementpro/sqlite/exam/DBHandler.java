package multi.android.datamanagementpro.sqlite.exam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

public class DBHandler {
    Cursor cursor;
    ContentValues contentValues;
    DBHelper dbHelper;
    SQLiteDatabase db;
    Context context;

    public DBHandler(Context context) {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        this.context = context;
    }

    public void insertItem(item item){
        contentValues = new ContentValues();
        contentValues.put("name",item.name);
        contentValues.put("price",item.price);
        contentValues.put("su",item.quantity);
        contentValues.put("totPrice",item.totPrice);
        db.insert("product",null,contentValues);
        Toast.makeText(context,"Insert완료",Toast.LENGTH_SHORT).show();
    }

    public Cursor showResult(){
        Cursor cursor = db.query("product",null,null,null,null,null,null);
        return cursor;
    }

    public Cursor showResult2(){
        Cursor cursor = db.query("product",null,null,null,null,null,null);
        return cursor;
    }

    public Cursor searchItem(item item){
        Toast.makeText(context,item.toString(),Toast.LENGTH_SHORT).show();
        Cursor cursor = db.query("product",null,"name like ?",new String[]{"%"+item.name+"%"},null,null,null);
        return cursor;
    }

}
