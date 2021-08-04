package kosmo.com.stampgo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import kosmo.com.stampgo.service.MemberDTO;
import kosmo.com.stampgo.service.ReviewDTO;
import kosmo.com.stampgo.service.ReviewService;
import kosmo.com.stampgo.service.StampService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ReviewFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ReviewFragment() {
        // Required empty public constructor
    }
 public static ReviewFragment newInstance(String param1, String param2) {
        ReviewFragment fragment = new ReviewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_review,container,false);
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity activity = (HomeActivity) getActivity();
                activity.onFragmentChanged(1);
            }
        });


        //위젯 얻기
        RecyclerView recyclerView= rootView.findViewById(R.id.recyclerView);
        //데이타 준비
        List<Item> items = new Vector<>();



  //  ;
//















        for(int i = 1; i <=50; i++) items.add(new Item(i+"번째 제목",R.drawable.rounded,Integer.toString(i))
        );
        //rootView.findViewById(R.id.itemImage);
        com.makeramen.roundedimageview.RoundedImageView itemImage = rootView.findViewById(R.id.itemImage);
        //  TextView itemTitle = rootView.findViewById(R.id.itemTitle);


        //어댑터 생성
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(rootView.getContext(),items);

        //리사이클뷰와 어댑터 연결
        recyclerView.setAdapter(adapter);
        //레이아웃 설정-세로방향
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //가로방향
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(),1));



       //sample = rootView.findViewById(R.id.sample);
        //IP=getIPAddress(true);
        //sample.setText("IP");
        return rootView;
        //   return inflater.inflate(R.layout.fragment_menu, container, false); // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_review, container, false);
    }
}