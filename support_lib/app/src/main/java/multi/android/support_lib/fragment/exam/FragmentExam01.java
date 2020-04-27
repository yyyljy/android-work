package multi.android.support_lib.fragment.exam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import multi.android.support_lib.R;

public class FragmentExam01 extends AppCompatActivity {
    ViewFragment1 viewFragment1;
    ViewFragment2 viewFragment2;
    ViewFragment3 viewFragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_test);
        viewFragment1 = new ViewFragment1();
        viewFragment2 = new ViewFragment2();
        viewFragment3 = new ViewFragment3();
    }
    public void btn_click(View v){
        setFragment(v.getTag().toString());
    }
    public void setFragment(String idx){
        Log.d("fragment", idx);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        switch (idx){
            case "0":
                transaction.replace(R.id.container,viewFragment1);
                break;
            case "1":
                transaction.replace(R.id.container,viewFragment2);
                break;
            case "2":
                transaction.replace(R.id.container,viewFragment3);
                break;

        }
        transaction.commit();
    }
}
