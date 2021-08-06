package kosmo.com.stampgo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import kosmo.com.stampgo.service.MemberDTO;
import kosmo.com.stampgo.service.ReviewDTO;
import kosmo.com.stampgo.service.ReviewService;
import kosmo.com.stampgo.service.StampService;


public class PostFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PostFragment() {
        // Required empty public constructor
    }


    public static PostFragment newInstance(String param1, String param2) {
        PostFragment fragment = new PostFragment();
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
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_post,container,false);
        Log.i("kosmo.com.stampgo", "나와!!!");
        /*String rvNo = item.getRvNo();

        ReviewService reviewService = new Retrofit.Builder()
                .baseUrl("http://192.168.0.20:9090/exer/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(StampService.class);
        Call<ReviewDTO> call = reviewService.Post(rvNo);
        call.enqueue(new Callback<ReviewDTO>() {
            @Override
            public void onResponse(Call<ReviewDTO> call, Response<ReviewDTO> response) {
                if (response.isSuccessful()) {
                    ReviewDTO post = response.body();
                    Log.i("kosmo.com.stampgo", "결과값: "+post.getRvTitle());
                    if(post.getRvTitle() != null){

                        Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(intent);

                        SharedPreferences preferences = getSharedPreferences("loginInfo",MODE_PRIVATE);
                        SharedPreferences.Editor editor =preferences.edit();

                        editor.putString("nickName",member.getNickName());
                        editor.commit();
                    }/////////로그인 성공
                    else{

                        Log.i("kosmo.com.stampgo", "안된다!!rb!!");
                    }
                }
                else{//200번 아닌거
                    Log.i("kosmo.com.stampgo", "안된다!!!!");
                }
            }
            @Override
            public void onFailure(Call<MemberDTO> call, Throwable t) {
                Log.i("kosmo.com.stampgo", t.getMessage());
            }
        });
        /*Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity activity = (HomeActivity) getActivity();
                activity.onFragmentChanged(1);
            }
        });
*/
        return rootView; }
}