package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

//이벤트를 발생시킬 소스객체가 있는 액티비티에서 이벤트를 처리하느 작업도 같이할 수 있도록 구현
//1. 이벤트에 반응하는(미리 정해져있다) 클래스를 상속받는다.
//2. 메소드를 오버라이딩 한다.
//  ex) 버튼을 클릭할 때
//      실행될 리스너 -> View.OnClickListener의 onClick메소드가 호출
public class ImageViewExam01 extends AppCompatActivity implements View.OnClickListener {
    ImageView imgTop;
    ImageView imgBottom;
    Button btnfirst;
    Button btnsecond;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_exam01);
        //layout에 디자인한 ImageView와 Button객체를 받아오기
        imgTop = findViewById(R.id.topImg);
        imgBottom = findViewById(R.id.bottomImg);
        btnfirst = findViewById(R.id.btnup);
        btnsecond = findViewById(R.id.btndown);
        //setOnClickListener라는 메소드를 이용해서 이벤트 소스에 이벤트가 발생했을 때
        //처리할 기능이 구현된 리스너 객체가 어떤 것인지 등록
        btnfirst.setOnClickListener(this);
        btnsecond.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //ImageView에 이미지리소스를 추가
        //setImageResource메소드를 이용해서 이미지를 변경했다고 하더라도
        //화면이 갱신이 자동으로 되지 않기 때문에 변경되지 않는다.
        //애니메이션을 적용하는 경우는 바로바로 반영이 되어야 하므로
        //화면을 갱신해야 한다.
        if(v.getId() == btnfirst.getId()){
            imageUp();
        }else if(v.getId() == btnsecond.getId()){
            imageDown();
        }
    }
    public void imageUp(){
        Log.d("myevent","UP 이벤트가 발생");
        imgTop.setImageResource(R.drawable.beach);
        imgBottom.setImageResource(0);
    }
    public void imageDown(){
        Log.d("myevent","DOWN 이벤트가 발생");
        imgTop.setImageResource(0);
        imgBottom.setImageResource(R.drawable.beach);
    }
}