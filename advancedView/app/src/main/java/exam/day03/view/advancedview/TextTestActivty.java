package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TextTestActivty extends AppCompatActivity {
    //layout페이지에서 사용할 view에 대한 리소스를 가져와야 하므로 변수 선언
    EditText etInfo;
    TextView tvInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_test);
        tvInfo = findViewById(R.id.myinfo);
        etInfo = findViewById(R.id.mytext);

        Button btngetter = findViewById(R.id.btnget);
        Button btnsetter = findViewById(R.id.btnset);
        btngetter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String msg = etInfo.getText()+"";
                tvInfo.setText(msg);
            }
        });
        btnsetter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etInfo.setText("가져온 문자열:작업완료");
            }
        });

        WatcherListener listener = new WatcherListener();
    }
    //TextChanged이벤트를 처리하는 리스너 작성
    class WatcherListener implements TextWatcher{

        //문자값이 변경되기 전에 호출
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        //문자의 값이 변경되었을 때 호출
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            Log.d("watcher", "s:"+s+ ",start"+start+",");
            etInfo.setText("문자열이 변경되고 있음.."+s);

        }
        //
        @Override
        public void afterTextChanged(Editable s) {

        }
    }
}
