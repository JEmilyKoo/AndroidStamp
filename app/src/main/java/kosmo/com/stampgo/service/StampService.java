package kosmo.com.stampgo.service;

import java.util.ArrayList;

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

    //지도에서 스탬프 보여주기
    @GET("stamp/list")
    Call<ArrayList<StampDTO>> stampList();

    //스탬프 찍기
    @Multipart
    @POST("stamp/check")
    Call<Integer> check(@Part("nickName") String nickName,@Part("lat") Double lat,@Part("lng") Double lng);

    @Multipart
    @POST("profile")
    Call<Integer> profile(@Part("nickName") String nickName,@Part("pr") String pr,@Part("openprf") int openprf,@Part("id") String id);

    @Multipart
    @POST("review")
    Call<Integer> review(@Part("nickName") String nickName,@Part("pr") String pr,@Part("openprf") int openprf,@Part("id") String id);
}
