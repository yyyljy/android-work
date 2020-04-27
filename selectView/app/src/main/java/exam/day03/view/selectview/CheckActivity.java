package exam.day03.view.selectview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CheckActivity extends AppCompatActivity {
    // 뷰의 주소값을 담을 참조변수
    TextView text1;
    CheckBox[] checkArr = new CheckBox[3];
    Switch myswitch ;
    Button showStatus;
    Button setCheckBtn;
    Button clearCheckBtn;
    Button reverseCheckStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);
        // 뷰의 주소 값을 가지고 온다. - 26버전부터는 캐스팅 클래스를 정의하지 않아도 된다.
        text1 = findViewById(R.id.checkTxt);
        checkArr[0] = findViewById(R.id.check1);
        checkArr[1] = findViewById(R.id.check2);
        checkArr[2] = findViewById(R.id.check3);
        showStatus = findViewById(R.id.btnCheck1);
        setCheckBtn = findViewById(R.id.btnCheck2);
        clearCheckBtn = findViewById(R.id.btnCheck3);
        reverseCheckStats = findViewById(R.id.btnCheck4);

        myswitch = findViewById(R.id.switch1);
        CheckBoxListener listener = new CheckBoxListener();
        // 체크박스에 리스너를 설정한다.
        for (int i = 0; i < checkArr.length; i++) {
            checkArr[i].setOnCheckedChangeListener(listener);
        }
        myswitch.setOnCheckedChangeListener(listener);
        showStatus.setOnClickListener(listener);
        setCheckBtn.setOnClickListener(listener);
        clearCheckBtn.setOnClickListener(listener);
        reverseCheckStats.setOnClickListener(listener);
    }
    //체크박스들의 상태를 TextView에 출력하기
    public void getCheckStatus(){
        text1.setText("");
        for(int i=0;i<checkArr.length;i++){
            //isChecked()는 체크박스가 선택되어 있으면 true 리턴
            if(checkArr[i].isChecked()){
                text1.append(checkArr[i].getTag()+"번째 체크박스\n");
            }
        }
    }
    public void setCheckVal(boolean chkVal){
        for(int i=0;i<checkArr.length;i++){
            checkArr[i].setChecked(chkVal);
        }
    }
    //체크박스 상태 반전
    public void toggle(){
        for(int i=0;i<checkArr.length;i++){
            checkArr[i].toggle();
        }
    }

    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener, View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnCheck1:
                    setCheckVal(true);
                    break;
                case R.id.btnCheck2:
                    getCheckStatus();
                    break;
                case R.id.btnCheck3:
                    setCheckVal(false);
                    break;
                case R.id.btnCheck4:
                    toggle();
                    break;

            }
        }
        //체크박스의 상태가 변경될 때 호출되는 메소드
        //Toast
        //display(체크박스 순서,텍스트 뷰,체크 상태)
        public void display(int index,TextView txtView, boolean isChecked){
            if(isChecked){
                txtView.setText(index+"번째 체크박스가 선택");
            }else {
                txtView.setText(index+"번째 체크박스가 해제");
            }
        }
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            //Log.d("onCheckedChanged", buttonView.toString()+"::::"+isChecked);
            if(buttonView instanceof CheckBox){
                display(Integer.parseInt(buttonView.getTag().toString()),text1,isChecked);

                /*Log.d("check", "체크박스");
                switch (buttonView.getId()) {
                    case R.id.check1:
                        if (isChecked) {
                            Toast.makeText(CheckActivity.this, "1번 체크박스 선택", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(CheckActivity.this, "1번 체크박스 해제", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.check2:
                        if (isChecked) {
                            Toast.makeText(CheckActivity.this, "2번 체크박스 선택", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(CheckActivity.this, "2번 체크박스 해제", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.check3:
                        if (isChecked) {
                            Toast.makeText(CheckActivity.this, "3번 체크박스 선택", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(CheckActivity.this, "3번 체크박스 해제", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }*/
            }else {
                Log.d("check","switch");
                switch (buttonView.getId()){
                    case R.id.switch1:
                        if(isChecked) {
                            Toast.makeText(CheckActivity.this, "스위치 선택", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(CheckActivity.this, "스위치 해제", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        }
    }
}
