package multi.android.datamanagementpro.filesystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import multi.android.datamanagementpro.R;

public class ExternalExam01 extends AppCompatActivity {
    EditText editText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_exam01);
        editText = findViewById(R.id.editTxt);
        String[] permissionList = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        };
        for(String tmp:permissionList){
            if(ContextCompat.checkSelfPermission(this, tmp)
                    == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "권한 설정 완료",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"권한 설정하세요",Toast.LENGTH_SHORT).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{tmp}, tmp.hashCode()%100);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==Manifest.permission.WRITE_EXTERNAL_STORAGE.hashCode()%100 && grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "파일 쓰기 권한 설정 마무리 완료",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "쓰기 권한 설정 거부.",Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode==Manifest.permission.READ_EXTERNAL_STORAGE.hashCode()%100 && grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "읽기 권한 설정 마무리 완료",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "외부저장소 읽기 권한 설정 거부",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void btnOpenClick(View v){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            File external = Environment.getExternalStorageDirectory();
            String dirPath = external.getAbsolutePath();
            SimpleDateFormat today1 = new SimpleDateFormat("YYYYMMdd");
            Calendar c1 = Calendar.getInstance();
            String today = today1.format(c1.getTime());
            String filename = "/"+today+"_memo.txt";
            File dir = new File(dirPath + "/mynote/");
            if (!dir.exists()) {
                Toast.makeText(this,"경로가 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
            }else {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(dir+filename));
                    try {
                        while (bufferedReader.readLine()!=null){

                        }
                        editText.setText(bufferedReader.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void btnSaveClick(View v){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED) {
            File external = Environment.getExternalStorageDirectory();
            String dirPath = external.getAbsolutePath();
            SimpleDateFormat today1 = new SimpleDateFormat("YYYYMMdd");
            Calendar c1 = Calendar.getInstance();
            String today = today1.format(c1.getTime());
            File dir = new File(dirPath + "/mynote/");
            if (!dir.exists()) {
                dir.mkdir();
            }
            FileWriter fw = null;
            try {
                fw = new FileWriter(dir + "/" + today + "_memo.txt");
                fw.write(editText.getText().toString());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fw != null) {
                        fw.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void btnNewFileClick(View v){
        editText.setText("");
    }
}
