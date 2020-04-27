package multi.android.support_lib.viewpager.exam;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import multi.android.support_lib.R;


/*
화면 전환을 위해서 ViewPager를 사용하는 경우(ListView와 동일)
1. ViewPager에 담을 데이터 - View, Fragment
2. Adapter 커스트마이징
3. ViewPager에 Adapter연결하기
*/
public class ViewPagerExam extends AppCompatActivity{
    //1. ViewPager에 표시할 뷰를 저장할 List
    ViewFragment1 viewFragment1;
    //ViewFragment2 viewFragment2;
    ListTestFragment viewFragment2;
    ViewFragment3 viewFragment3;
    MapFragment viewFragment4;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<Fragment>();
    ViewPager fragment_viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_exam);
        fragment_viewPager = findViewById(R.id.fragment_viewPager);
        viewFragment1 = new ViewFragment1();
        //viewFragment2 = new ViewFragment2();
        viewFragment2 = new ListTestFragment();
        viewFragment3 = new ViewFragment3();
        viewFragment4 = new MapFragment();
        fragmentArrayList.add(viewFragment1);
        fragmentArrayList.add(viewFragment2);
        fragmentArrayList.add(viewFragment3);
        fragmentArrayList.add(viewFragment4);

        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(),fragmentArrayList.size());
        fragment_viewPager.setAdapter(adapter);
        fragment_viewPager.addOnPageChangeListener(new PageListener());
    }
    public void btn_click(View view){
        fragment_viewPager.setCurrentItem(Integer.parseInt(view.getTag().toString()));
    }
    //2. Adapter커스트마이징
    class FragAdapter extends FragmentStatePagerAdapter {
        public FragAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }
        //ViewPager를 통해 보여줄 뷰의 갯수 리턴

    }
    class PageListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            //페이지가 변경됐을때
            Toast.makeText(ViewPagerExam.this,"페이지가 전환",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
