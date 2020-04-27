package multi.android.matertial_design_pro.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import multi.android.matertial_design_pro.R;

public class OptionMenuTest extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_menu_test);
        textView = findViewById(R.id.result);
    }
    //액티비티가 만들어질때 자동으로 호출되는 메소드 - 이 메소드 안에서 메뉴를 생성
    //true만 리턴하면 메뉴를 만든다.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //xml로 만든 메뉴를 화면에 출력할 수 있도록 구성하는 객체
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        //코드로 메뉴를 만드는 방법
        /*menu.add(Menu.NONE,Menu.FIRST,Menu.NONE,"코드로 추가 1");
        menu.add(Menu.NONE,Menu.FIRST+1,Menu.NONE,"코드로 추가 2");*/
        return true;
    }
    //옵션 메뉴의 아이템을 선택하면 자동으로 호출되는 메소드
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("menu", item.getItemId()+"");
        int id = item.getItemId();
        String msg = "";
        switch (id){
            case R.id.option_1:
                msg = "첫번째 메뉴선택";
                break;
            case R.id.option_2:
                msg = "두번째 메뉴선택";
                break;
            case R.id.option_3:
                msg = "세번째 메뉴선택";
                break;
        }
        textView.setText(msg);
        return super.onOptionsItemSelected(item);
    }
}
