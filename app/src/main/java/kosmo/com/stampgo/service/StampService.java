package kosmo.com.stampgo.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StampService {

    @GET("member/login")
    Call<MemberDTO> login(@Query("id") String id, @Query("pwd") String pwd);

}
