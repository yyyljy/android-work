package multi.android.map_location_pro.map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import multi.android.map_location_pro.R;

public class MapLocationTest extends AppCompatActivity implements OnMapReadyCallback {
    GoogleMap map;
    MarkerOptions markerOptions;//마커에대한 정보를 담고 있는 객체
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Map프레그먼트를 추출
        //현재 xml문서에 정의된 Fragment를 추출하는 경우 FragmentManager를
        //이용해서 추출
        FragmentManager manager = getSupportFragmentManager();
        SupportMapFragment mapFragment =
                (SupportMapFragment)manager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d("mymap","준비완료");
        map = googleMap;
        if(map!=null){
            //위도, 경도를 셋팅
            LatLng myloc = new LatLng(37.5866118,126.9726223);
            //구글맵이 v2가 되면 카메라개념이 추가
            //지도는 카메라로 아래를 내려다보는 듯한 내용이 모델링
            //변경사항에 관련된 내용을 담고 있는 객체-CameraUpdate
            //CameraUpdate객체에 변경할 값들을 셋팅해서 매개변수로 전달
            //CameraUpdate객체를 만드는 객체
            //CameraUpdateFactory객체의 여러 메소드를 통해서 CameraUpdate객체를
            //생성
            //map.moveCamera(CameraUpdateFactory.newLatLng(myloc));
            // map.moveCamera(CameraUpdateFactory.newLatLngZoom(myloc,15));
            //카메라의 정보를 담고 있는 객체
            //target() - 화면에 출력되기 위해서 특정 위치의 중앙으로 이동
            //zoom() - 지도의 확대 축소 레벨을 설정
            CameraPosition.Builder builder = new CameraPosition.Builder();
            builder.target(myloc);
            builder.zoom(15);
            CameraPosition position = builder.build();
            map.moveCamera(CameraUpdateFactory.newCameraPosition(position));
        }
    }
    public void setPosition(View view){
        LatLng myloc = new LatLng(37.4976805,127.0303356);
        //카메라가 이동할때 에니메이션이 적용
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(myloc,15));
    }
    //마커출력
    public void setMarker(View view){
        LatLng myloc = new LatLng(37.4976805,127.0303356);
        markerOptions = new MarkerOptions();
        markerOptions.position(myloc); //마커를 출력할 위치
        markerOptions.title("멀티캠퍼스"); //마커를 클릭했을때 보여줄 풍선도움말 타이틀
        markerOptions.snippet("IT교육센터"); //풍선도움말 내용(추가텍스트)
        map.addMarker(markerOptions);//마커가 생성되어 map에 추가
    }
    public void addCircle(View view){
        //반경을 반투명한 원으로 표현
        CircleOptions circleOptions = new CircleOptions();
        circleOptions.strokeWidth(10); //circle의 선 width
        circleOptions.strokeColor(0); //선색
        circleOptions.fillColor(Color.parseColor("#550000ff"));
        circleOptions.center(new LatLng(37.4976805,127.0303356));//circle의 중심
        circleOptions.radius(300);//미터단위
        map.addCircle(circleOptions);
    }
    public void changeMarker(View view){
        //drawable폴더의 resource로 저장되어 있는 이미지 파일을 Bitmap의 형식으로
        //읽어오기
        BitmapDrawable bitmapDrawable =
                (BitmapDrawable)getResources().getDrawable(R.drawable.arrow);
        Bitmap bitmap = bitmapDrawable.getBitmap();
        Bitmap smallMaker =
                Bitmap.createScaledBitmap(bitmap,200,200,
                        false);
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMaker));
        map.addMarker(markerOptions);
    }
}