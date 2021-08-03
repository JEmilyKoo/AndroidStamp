package kosmo.com.stampgo;

import android.net.wifi.WifiManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ReviewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ReviewFragment extends Fragment {
    TextView sample;
    String IP;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ReviewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ReviewFragment.
     */
    // TODO: Rename and change types and number of parameters
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
/*




 */
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
        for(int i=1;i <=50;i++) items.add(new Item(i+"번째 제목",R.drawable.rounded));
        //어댑터 생성
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(rootView.getContext(),items);
        //리사이클뷰와 어댑터 연결
        recyclerView.setAdapter(adapter);
        //레이아웃 설정-세로방향
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //가로방향
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));

        recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(),2));



       //sample = rootView.findViewById(R.id.sample);
        //IP=getIPAddress(true);
        //sample.setText("IP");
        return rootView;
        //   return inflater.inflate(R.layout.fragment_menu, container, false); // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_review, container, false);
    }
}