package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class frameLayoutExam01 extends AppCompatActivity {
    LinearLayout linelayLogin;
    LinearLayout linelayJoin;
    LinearLayout linelayUserinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout_exam01);
        linelayLogin = findViewById(R.id.layoutLogin);
        linelayJoin = findViewById(R.id.layoutJoin);
        linelayUserinfo = findViewById(R.id.layoutUserInfo);

        /*

        Button btnlogin = findViewById(R.id.btnlogin);
        Button btnjoin = findViewById(R.id.btnjoin);
        Button btnuserinfo = findViewById(R.id.btnmemberinfo);
        final Button btngologin = findViewById(R.id.btngologin);
        Button btngojoin = findViewById(R.id.btngojoin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linelayLogin.setVisibility(View.VISIBLE);
                linelayJoin.setVisibility(View.INVISIBLE);
                linelayUserinfo.setVisibility(View.INVISIBLE);
            }
        });
        btnjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linelayLogin.setVisibility(View.INVISIBLE);
                linelayJoin.setVisibility(View.VISIBLE);
                linelayUserinfo.setVisibility(View.INVISIBLE);
            }
        });
        btnuserinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linelayLogin.setVisibility(View.INVISIBLE);
                linelayJoin.setVisibility(View.INVISIBLE);
                linelayUserinfo.setVisibility(View.VISIBLE);
            }
        });
        btngologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(frameLayoutExam01.this,"로그인 되었습니다",Toast.LENGTH_SHORT).show();

            }
        });
        btngojoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvText = findViewById(R.id.hiddenTextView);
                EditText txt = findViewById(R.id.txtJoinName);
                String msg = "Name : " +txt.getText() + "\n";

                txt = findViewById(R.id.txtJoinID);
                msg = msg + "ID" + txt.getText() + "\n";

                txt = findViewById(R.id.txtJoinPass);
                msg = msg + "Pass" + txt.getText() + "\n";

                tvText.setText(msg);
                tvText.setVisibility(View.VISIBLE);
            }
        });*/
    }
    //Button이 클릭될 때 호출도는 메소드 = View.OnClickListner의
    //public void OnClick(View v) 메소드와 동일한 역할
    public void myclick(View v){
        if(v.getId()==R.id.btnlogin){
            linelayLogin.setVisibility(View.VISIBLE);
            linelayJoin.setVisibility(View.INVISIBLE);
            linelayUserinfo.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.btnjoin){
            linelayLogin.setVisibility(View.INVISIBLE);
            linelayJoin.setVisibility(View.VISIBLE);
            linelayUserinfo.setVisibility(View.INVISIBLE);
        }else if(v.getId()==R.id.btnmemberinfo){
            linelayLogin.setVisibility(View.INVISIBLE);
            linelayJoin.setVisibility(View.INVISIBLE);
            linelayUserinfo.setVisibility(View.VISIBLE);
        }
    }
}
