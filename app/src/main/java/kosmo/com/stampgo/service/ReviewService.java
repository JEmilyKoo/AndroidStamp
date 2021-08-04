package kosmo.com.stampgo.service;


import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ReviewService {

    @GET("/Review/TripBoard.do")
    Call<ReviewDTO> TripBoard(@Query("nickName") String nickName, @Query("rvNo") String rvNo);

}
