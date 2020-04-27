package multi.android.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ExamSecondActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_secondview);
        final Intent intent = getIntent();
        TextView resultTxt = findViewById(R.id.exam_result_txt);
        resultTxt.setText("입력한ID : "+intent.getStringExtra("name")+"\n입력한 전화번호 : "+intent.getStringExtra("telNum"));
        Button btn = findViewById(R.id.exam_close);
        String id = intent.getStringExtra("name");
        if(id==null){
            User dto = intent.getParcelableExtra("dto");
            resultTxt.setText(dto.name+","+dto.telNum);
        }else {
            String tel = intent.getStringExtra("tel");
            resultTxt.setText("입력한 id:"+id+"입력한 전화번호:"+tel);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.exam_close){
                    CheckBox chkbox = findViewById(R.id.member_state);
                    if(chkbox.isChecked()){
                        intent.putExtra("result","우수회원설정");
                    }else {
                        intent.putExtra("result","");
                    }
                    setResult(RESULT_OK,intent);
                    finish();
                }
            }
        });

    }
}
