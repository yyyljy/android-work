package multi.android.datamanagementpro.preference;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import multi.android.datamanagementpro.R;
import multi.android.datamanagementpro.sqlite.DBHelper;

//ContentValues라는 값을 관리하는 객체를 이용해서 안드로이드 메소드를 통해
//SQL문이 실행될 수 있도록 작업
//메소드를 호출하며 적절한 값을 넘겨주면 안드로이드 OS에서 SQL문을 만들어 실행
public class DBMainActivity_ContentValues extends AppCompatActivity {
    EditText id;
    EditText name;
    EditText age;
    TextView result;
    DBHelper dbHelper ; //데이터베이스 파일 생성, 테이블 생성...
    SQLiteDatabase db ; //로컬 디비 연동을 위한 핵심 클래스
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dbjob_main);
        id = findViewById(R.id.id);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        result = findViewById(R.id.result);

        //1. DBHelper생성
        dbHelper = new DBHelper(this);
        //2. SQLiteDatabase 객체 생성
        db = dbHelper.getWritableDatabase();
    }

    public void insert(View v){
        //컬럼에 저장할 값을 관리하는 ContentValues를 이용
        //Map 구조
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id.getText().toString());
        contentValues.put("name",name.getText().toString());
        contentValues.put("age",age.getText().toString());

        db.insert("member",null,contentValues);
        Toast.makeText(this,"삽입성공",Toast.LENGTH_SHORT).show();
    }

    public void selectAll(View v){
        result.setText("");
        String sql = "select * from member";
        /*
        select 컬럼명 from 테이블 where 조건
        group by 컬럼명
        having 조건
        order by 컬럼명
        */
        /*
        * 1.테이블명
        * 2.조회할 컬럼명 문자열배열
        * 3.조건(where다음에 오는 문자열)
        * 4.조건으로 정의된 ?에 바인딩될 값을 배열로 넘긴다
        * 5.group by절 뒤에 정의할 정렬기준
        *
        * */
        Cursor cursor = db.query("member",null,null,null,null,null,null);
        int count = cursor.getCount();
        Toast.makeText(this,"조회갯수 :"+count,Toast.LENGTH_SHORT).show();
        while (cursor.moveToNext()){
            int idx = cursor.getInt(0);
            String id = cursor.getString(1);
            String name = cursor.getString(2);
            int age = cursor.getInt(3);

            result.append("번호:"+idx+"\n"
                    +"아이디:"+id+"\n"
                    +"이름:"+name+"\n"
                    +"나이:"+age+"\n"
                    +"=================\n"
            );
        }
    }

    public void update(View v){
        ContentValues contentValues = new ContentValues();
        //contentValues는 set절 - 변경할 데이터의 name과 value
        contentValues.put("age",age.getText().toString());
        String where = "id like ?";
        String[] whereVal = {"%"+id.getText().toString()+"%"};
        db.update("member",contentValues,where,whereVal);
    }

    public void delete(View v){
        db.delete("member","id=?",new String[]{id.getText().toString()});
    }

    public void search(View v){

    }
}