package multi.android.datamanagementpro.sqlite.exam;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DB_VERSION = 1;
    public DBHelper(Context context){
        super(context,"product.db",null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table if not exists product("
                + "_id integer primary key autoincrement,"
                + "name text not null, "
                + "price integer not null, "
                + "su integer not null, "
                + "totPrice integer not null)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("DB_UPDATE", "onUpgrade: DB가 업데이트 되었습니다.");
    }
}
