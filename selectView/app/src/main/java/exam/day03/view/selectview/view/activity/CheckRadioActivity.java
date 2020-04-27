package exam.day03.view.selectview.view.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;

import exam.day03.view.selectview.R;

public class CheckRadioActivity extends AppCompatActivity {
    CheckBox[] checkArr = new CheckBox[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);
    }
}
