package multi.android.matertial_design_pro.appbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import multi.android.matertial_design_pro.R;

public class AppbarTest extends AppCompatActivity {
    Toolbar toolbar;
    ImageView app_bar_image;
    CollapsingToolbarLayout toolbarLayout;
    FloatingActionButton fab;
    ListView listView;
    ArrayList<String> datalist = new ArrayList<String>();
    BottomAppBar bottomAppBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar_test);

        toolbar = findViewById(R.id.toolbar);
        app_bar_image = findViewById(R.id.app_bar_image);
        toolbarLayout = findViewById(R.id.toolbar_layout);
        fab = findViewById(R.id.fab);
        listView = findViewById(R.id.mylistview);
        bottomAppBar = findViewById(R.id.bottom_bar);

        app_bar_image.setImageResource(R.drawable.lee);

        //1. Appbar에 텍스트 추가, 변경
        toolbar.setTitle("툴바입니다.");
        toolbarLayout.setCollapsedTitleTextColor(Color.DKGRAY);
        toolbarLayout.setExpandedTitleColor(Color.WHITE);
/*
        toolbarLayout.setCollapsedTitleGravity(Gravity.CENTER);
        toolbarLayout.setExpandedTitleGravity(Gravity.RIGHT+Gravity.TOP);*/

        bottomAppBar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
        bottomAppBar.setFabCradleRoundedCornerRadius(100);
        bottomAppBar.setFabCradleMargin(20);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                datalist);
        listView.setAdapter(adapter);

        //FloatingActionButton을 눌렀을때 대화상자가 뜨고 입력한 데이터가
        //리스트뷰에 추가되도록 구현
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AppbarTest.this);
                //AlertDialog의 타이틀을 정의
                builder.setTitle("데이터 입력");

                //AlertDialog에 보여질 화면을 inflate
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.input,null);
                //Alert에 추가할 번튼을 정으
                builder.setPositiveButton("확인",new DialogListener());
                builder.setNegativeButton("취소",null);
                builder.setView(dialogView);
                builder.show();
            }
        });
    }
    class DialogListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            //AlertDialog에서 입력하는 내용을 ListView에 추가하기
            AlertDialog inputAlert = (AlertDialog) dialog;
            EditText input = inputAlert.findViewById(R.id.input);
            String data = input.getText().toString();
            datalist.add(data);

            //ArrayList에 데이터를 추가한 후 adapter가 가지고 있는 데이터를 업데이트
            //=> Adapter에게 데이터가 변경되었음을 알려줘야 한다.
            ArrayAdapter<String> adapter = (ArrayAdapter<String>) listView.getAdapter();
            adapter.notifyDataSetChanged();
        }
    }
}
