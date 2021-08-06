package kosmo.com.stampgo.service;


import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ReviewService {


    @GET("review/tripBoard")
    Call<List<ReviewDTO>> TripBoard();

    @GET("review/post")
    Call<ReviewDTO> Post(String rvNo);

}
