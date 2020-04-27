package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img01;
    ImageView img02;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img01 = findViewById(R.id.img01);
        img02 = findViewById(R.id.img02);
        //findViewById(R.id.img01);
    }
    //버튼이 클릭될 때 호출되는 메소드
    public void myclick(View v){
        imageChange();
    }

    //버튼을 선택할 때 마다 이미지가 교체되어 보이도록 구현
    public void imageChange(){
        if(img01.getVisibility()==View.VISIBLE){
            img01.setVisibility(View.INVISIBLE);
            img02.setVisibility(View.VISIBLE);
        }else if(img02.getVisibility()==View.VISIBLE){
            img01.setVisibility(View.VISIBLE);
            img02.setVisibility(View.INVISIBLE);
        }
        /*if(index==0){
            img01.setVisibility(View.VISIBLE);
            img02.setVisibility(View.INVISIBLE);
            Log.d("value","현재index값 ==> "+index);
            index = 1;
        }else if(index==1){
            img01.setVisibility(View.INVISIBLE);
            img02.setVisibility(View.VISIBLE);
            Log.d("value","현재index값 ==> "+index);
            index = 0;
        }*/
    }
}
