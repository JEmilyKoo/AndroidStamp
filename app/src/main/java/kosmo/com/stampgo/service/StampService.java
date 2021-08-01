package kosmo.com.stampgo.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface StampService {

    @GET("member/login")
    Call<MemberDTO> login(@Query("id") String id, @Query("pwd") String pwd);

    @Multipart
    @POST("member/join")
    Call<Integer> join(@Part("id") String id,@Part("pwd") String pwd,@Part("name") String name);

}
