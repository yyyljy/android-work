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
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import multi.android.datamanagementpro.R;

public class ExternalFileMgr extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external_file_mgr);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==2000 && grantResults.length > 0){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "권한 설정 완료",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(this,"권한 설정을 하지 않으면 사용 불가",Toast.LENGTH_LONG).show();
            }
        }
    }
    public void saveExternalFileSystem(View v){
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            Toast.makeText(this,"외부 저장소 존재",Toast.LENGTH_SHORT).show();
            if(ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "권한 설정 완료",Toast.LENGTH_LONG).show();
                File external = Environment.getExternalStorageDirectory();
                //외부저장소/임의의디렉토리를 생성 - 앱을 삭제해도 데이터는 남아있다.
                //String dirPath = external.getAbsolutePath()+"/myApp";
                //외부저장소/android/data/앱의 패키지명으로 디렉토리 생성
                //=> 앱을 삭제하면 데이터가 같이 삭제된다.
                String dirPath = external.getAbsolutePath();
                String pkg = getPackageName();
                File dir = new File(dirPath+"/android/data/"+pkg);
                //디렉토리 없으면 생성
                //File dir = new File(dirPath);
                if(!dir.exists()){
                    dir.mkdir();
                }
                FileWriter fw = null;
                try {
                    fw = new FileWriter(dir+"/test1.txt");
                    fw.write("외부 저장 테스트");
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if(fw!=null){
                            fw.close();
                        }
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }else {
                Toast.makeText(this,"권한설정하세요",Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2000);
            }
        }else if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            Toast.makeText(this,"외부저장소는 읽기만 가능합니다.",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"외부저장소가 존재하지 않습니다.",Toast.LENGTH_LONG).show();
        }
    }
    public void openInternalFile(View v){

    }
}
