package multi.android.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncExam extends AppCompatActivity {
    Button btn1;
    Button btn2;
    TextView txtview;
    ProgressBar progressBar;
    ImageView imageView;
    AsyncExam01 asyncTaskExam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.async_exam);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        progressBar = findViewById(R.id.progressBar);
        txtview = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageView);

    }

    public void ck_bt(View view) {
        if(view.getId()==btn1.getId()) {
            asyncTaskExam = new AsyncExam01();
            asyncTaskExam.execute();
        }
    }

    class AsyncExam01 extends AsyncTask<Integer, Long, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("test", "onPreExecute: 시작");
            btn1.setEnabled(false);
            btn2.setEnabled(true);
            progressBar.setMax(50);
        }
        @Override
        protected String doInBackground(Integer... integers) {
            int result = 0;
            for(int i=1;i<=50;i++){
                result += i;
                progressBar.incrementProgressBy(1);
                SystemClock.sleep(100);
                publishProgress((long)result);
            }
            return Integer.toString(result);
        }
        @Override
        protected void onProgressUpdate(Long... values) {
            super.onProgressUpdate(values);
            txtview.setText(values[0]+"");
            if(values[0]%2==0){
                imageView.setImageResource(R.drawable.d1);
            }else {
                imageView.setImageResource(R.drawable.d2);
            }
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtview.setText("Result : "+s);
            btn1.setEnabled(true);
            btn2.setEnabled(false);
        }
    }
}