package exam.day03.view.selectview.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import exam.day03.view.selectview.R;
import exam.day03.view.selectview.view.adapter.MyAdapter;
import exam.day03.view.selectview.view.adapter.MyAdapter2;
import exam.day03.view.selectview.view.adapter.User;

public class CustomAdapterTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter_test);
        TextView info = findViewById(R.id.txtInfo_cust);
        ListView listView = findViewById(R.id.cust_listview);

        //1.리스트에 출력할 데이터
        ArrayList<User> datalist = new ArrayList<User>();
        for(int i=1;i<100;i++){
            User user = new User(R.drawable.ic_launcher_foreground,"name"+i,"0000"+i);
            datalist.add(user);
        }
        //2. 사용자정의 어댑터 객체생성
        //3. ListView에 어댑터 연결
        MyAdapter2 adapter = new MyAdapter2(this, R.layout.custrow2,datalist);
        listView.setAdapter(adapter);
    }
}
