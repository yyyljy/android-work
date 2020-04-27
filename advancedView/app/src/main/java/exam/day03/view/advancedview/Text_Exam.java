package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Text_Exam extends AppCompatActivity {
    TextView tvTextView;
    EditText etInputText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text__exam);

        tvTextView = findViewById(R.id.tvTextView);
        etInputText = findViewById(R.id.etInputText);
        Button btnTransfer = findViewById(R.id.btnTransfer);
        btnTransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = etInputText.getText()+"\n";
                tvTextView.append(msg);
                etInputText.setText("");
            }
        });
    }


}
