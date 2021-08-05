package kosmo.com.stampgo;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.Vector;
import kosmo.com.stampgo.service.ReviewDTO;
import kosmo.com.stampgo.service.ReviewService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
public class ReviewFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static List<ReviewDTO> items = null;
    public ReviewFragment() {
        // Required empty public constructor
    }
 public static ReviewFragment newInstance(String param1, String param2) {
        ReviewFragment fragment = new ReviewFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_review,container,false);
        //mLayoutManager = new LinearLayoutManager(rootView.getContext());
        //recyclerView.setLayoutManager(mLayoutManager);
        //위젯 얻기
        recyclerView= rootView.findViewById(R.id.recyclerView);
        //데이타 준비
        items = new Vector<>();

         Log.i("kosmo.com.stampgo", "나와라 얍!!!");
         ReviewService reviewService = new Retrofit.Builder()
                            .baseUrl("http://10.0.2.2:9090/exer/")
                            .addConverterFactory(JacksonConverterFactory.create())
                            .build()
                            .create(ReviewService.class);

         Call<List<ReviewDTO>> call = reviewService.TripBoard();

        Log.i("kosmo.com.stampgo", "call");
         call.enqueue(new Callback<List<ReviewDTO>>() {
            @Override
             public  void onResponse(Call<List<ReviewDTO>> call, Response<List<ReviewDTO>> response) {
                 System.out.println("respoo"+response);
                 if (response.isSuccessful()) {
                         List<ReviewDTO> list =response.body();
                         Log.i("kosmo.com.stampgo", "결과값: "+list.get(1).getRvTitle());
                         int size=list.size();
                     com.makeramen.roundedimageview.RoundedImageView itemImage = rootView.findViewById(R.id.itemImage);

                     for (int i=0 ; i<size;i++) {
                            //  itemImage.setImageURI(list.get(i).getImage());


                        String bitmap =  (list.get(i).getImage());
                        if(bitmap!=null){
                            System.out.println("값들어옴");
                            System.out.println(bitmap);
                        }
                         System.out.println(list.get(i));
                             items.add(new ReviewDTO(list.get(i).getRvNo(),
                                     list.get(i).getNickName(),
                                     list.get(i).getRvTitle(),
                                     list.get(i).getRvCtt(),
                                     list.get(i).getRvLikeCnt(),
                                     list.get(i).getRvDate(),
                                     list.get(i).getRvCategory1(),
                                     list.get(i).getRvCategory2(),
                                             list.get(i).getRvLat(),
                                             list.get(i).getRvLng(),
                                             list.get(i).getRvVisitCnt(),
                                             list.get(i).getRvFile(),
                                             list.get(i).getRvLikeCheck(),
                                             list.get(i).getRvlDate(),
                                             list.get(i).getRvcNo(),
                                             list.get(i).getRvCmnt(),
                                             list.get(i).getRvcDate(),
                                             list.get(i).getFullName(),
                                             list.get(i).getRvfdate(),
                                             bitmap));



                     }

                     adapter = new MyRecyclerAdapter(rootView.getContext(),items);
                     recyclerView.setAdapter(adapter);
                     recyclerView.setLayoutManager(new GridLayoutManager(rootView.getContext(),1));

                 }
                        else{//200번 아닌거
                            Log.i("kosmo.com.stampgo", "안된다!!!!");
                        }
                    }
             @Override
             public void onFailure(Call<List<ReviewDTO>> call, Throwable t) {
                        Log.i("kosmo.com.stampgo", t.getMessage());
                    }
                });

        //rootView.findViewById(R.id.itemImage);
        //  TextView itemTitle = rootView.findViewById(R.id.itemTitle);
         //어댑터 생성
        //리사이클뷰와 어댑터 연결
       //레이아웃 설정-세로방향
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //가로방향
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        return rootView;

        //   return inflater.inflate(R.layout.fragment_menu, container, false); // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_review, container, false);
    }
}