package multi.android.material_design_pro2.recycler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import multi.android.material_design_pro2.R;


public class CircleImageRecyclerTest extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_recycler_test);
        recyclerView = findViewById(R.id.recycleView);
        List<CircleItem> recyclerCircle = new ArrayList<CircleItem>();
        CircleItem[] resList = new CircleItem[5];
        resList[0] = new CircleItem(R.drawable.lee);
        resList[1] = new CircleItem(R.drawable.gong);
        resList[2] = new CircleItem(R.drawable.jung);
        resList[3] = new CircleItem(R.drawable.jang);
        resList[4] = new CircleItem(R.drawable.so);
        for(int i=0;i<resList.length;i++){
            recyclerCircle.add(resList[i]);
        }
        RecyclerCircleAdapter adapter = new RecyclerCircleAdapter(this,R.layout.circle_item, recyclerCircle);
        GridLayoutManager manager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        //4. Recycler와 adapter를 연결
        recyclerView.setAdapter(adapter);
    }
}
