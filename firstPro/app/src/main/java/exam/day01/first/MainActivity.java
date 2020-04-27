package exam.day01.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
//Activity의 라이프사이클
public class MainActivity extends AppCompatActivity {
    //Activity가 생성될 때 자동으로 호출
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //System.out.println("oncreate호출!");
        Log.d("test", "oncreate()호출");
        setContentView(R.layout.activity_main);
    }
    //onCreate다음으로 호출되는 메소드 - (엑티비티가 실행 : 2 단, pause상태에서 빠져나올때는
    //onCreate가 아니라 onStart부터 호출)
    //일시정지에서 빠져나올 때
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("test","onStart()호출");
    }
    //onStart다음으로 호출되는 메소드 (엑티비티가 실행 :3)
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("test","onResume()호출");
    }
    //일시정지나 종료 상태로 바뀔 때 onPause다음으로 호출되는 메소드
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("test","onPause()호출");

    }
    //앱이 종료될 때 호출되는 메소드
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    //버튼을 클릭했을 때 실행할 메소드 정의
    //메소드의 매개변수에 실행할 버튼을 정의
    //Button의 상위인 View타입으로 정의
    public void myclickMethod(View v){
        Toast.makeText(this, "확인버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
    }
    public void cancelclickMethod(View v){
        Toast.makeText(this, "취소버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
    }
    public void deleteclickMethod(View v){
        Toast.makeText(this, "삭제버튼이 눌렸습니다.", Toast.LENGTH_SHORT).show();
    }

}
