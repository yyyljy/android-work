package exam.day03.view.selectview.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SimpleAdapterTestActivity extends ListActivity {
    //두줄 텍스트로 리스트뷰를 구성하기
    ArrayList<HashMap<String,String>> listdata= new ArrayList<HashMap<String, String>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //리스트를 구성할 심플 데이터 준비
        HashMap<String,String> item = new HashMap<String, String>();
        item.put("name","가가가");
        item.put("telNum","010-1111-2222");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name","나나나");
        item.put("telNum","010-3333-4444");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name","이다다");
        item.put("telNum","010-5555-6666");
        listdata.add(item);

        item = new HashMap<String, String>();
        item.put("name","김라라");
        item.put("telNum","010-7777-8888");
        listdata.add(item);

        SimpleAdapter adapter = new SimpleAdapter(this,listdata,android.R.layout.simple_list_item_2,new String[]{"name","telNum"}, new int[]{android.R.id.text1,android.R.id.text2});
        //HashMap으로 구성된 데이터가 저장된 리스트
        //row의 디자인
        //HashMap에 저장된 키 리스트
        //의에서 정의한 맵 데이터를 어떤 view에 출력할 것인지

        setListAdapter(adapter);
    }
}
