package multi.android.support_lib.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import multi.android.support_lib.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty public constructor
    }
    //프래그먼트가 액티비티에 Attach될 때 호출
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d("lifecycle", "onAttach: ");
    }
    //초기화작업 - View초기화 작업X, 값을 초기화해서 넘겨주거나 해야할 때 초기화
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("lifecycle", "onCreate: ");
    }
    //fragment뷰가 만들어질때 호출되는 메소드
    //액티비티에 배치될때 호출되는 메소드 - view를 그리기 위해서 호출하는 메소드
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("lifecycle", "onCreateView: ");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("lifecycle", "onViewCreated: ");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("lifecycle", "onActivityCreated: ");
    }

    //사용자가 프레그먼트를 볼 수 있는 시점
    @Override
    public void onStart() {
        super.onStart();
        Log.d("lifecycle", "onStart: ");
    }
    //사용자와 상호작용이 가능한 상태
    @Override
    public void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResume: ");
    }
    //프레그먼트를 다른 액티비티가 가리기 시작할 때 호출
    @Override
    public void onPause() {
        super.onPause();
        Log.d("lifecycle", "onPause: ");
    }
    //완전히 덮어서 안보일 때
    @Override
    public void onStop() {
        super.onStop();
        Log.d("lifecycle", "onStop: ");
    }
    //프레그먼트에서 뷰를 지우는 작업
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("lifecycle", "onDestroyView: ");
    }
    //모두 지워진 후
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle", "onDestroy: ");
    }
    //액티비티에서 프레그먼트가 교체될 때
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("lifecycle", "onDetach: ");
    }


}
