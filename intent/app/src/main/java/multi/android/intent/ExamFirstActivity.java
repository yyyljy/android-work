package multi.android.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ExamFirstActivity extends AppCompatActivity{

    public static final int BUTTON_COMPLETE = 100;
    public static final int BUTTON_OBJECT = 200;
    Button btn;
    Button btn2;
    TextView nameTxt;
    TextView telNumTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.firstexam);
        btn = findViewById(R.id.Button01);
        btn2 = findViewById(R.id.Button02);
        nameTxt= findViewById(R.id.EditText01);
        telNumTxt= findViewById(R.id.EditText02);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamFirstActivity.this, ExamSecondActivity.class);
                intent.putExtra("name", nameTxt.getText().toString());
                intent.putExtra("telNum", telNumTxt.getText().toString());
                startActivityForResult(intent, BUTTON_COMPLETE);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamFirstActivity.this, ExamSecondActivity.class);
                User dto = new User(nameTxt.getText().toString(),telNumTxt.getText().toString());
                intent.putExtra("dto",dto);
                startActivityForResult(intent, BUTTON_OBJECT);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==BUTTON_COMPLETE){
            if(resultCode==RESULT_OK){
                TextView txtView = findViewById(R.id.first_return);
                txtView.setText(data.getStringExtra("result"));
            }
        }
    }
}
