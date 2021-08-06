package kosmo.com.stampgo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import kosmo.com.stampgo.service.MemberDTO;
import kosmo.com.stampgo.service.StampService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private EditText id;
    private EditText pwd;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();

        //버튼에 리스너 부착
        btnLogin.setOnClickListener(listener);

        System.out.println("btnLogin"+btnLogin);
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i("kosmo.com.stampgo", "나와라 얍!!!");
            String username = id.getText().toString();
            String password = pwd.getText().toString();

            StampService stampService = new Retrofit.Builder()
                    .baseUrl("http://192.168.0.8:9090/exer/")
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build()
                    .create(StampService.class);
            Call<MemberDTO> call = stampService.login(username,password);
            call.enqueue(new Callback<MemberDTO>() {
                @Override
                public void onResponse(Call<MemberDTO> call, Response<MemberDTO> response) {
                    if (response.isSuccessful()) {
                        MemberDTO member = response.body();
                        Log.i("kosmo.com.stampgo", "결과값: "+member.getId());
                        if(member.getId() != null){

                            Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                            startActivity(intent);

                            SharedPreferences preferences = getSharedPreferences("loginInfo",MODE_PRIVATE);
                            SharedPreferences.Editor editor =preferences.edit();

                            editor.putString("nickName",member.getNickName());
                            editor.commit();
                        }/////////로그인 성공
                        else{
                            //Toast.makeText(LoginActivity.this,"아이디와 비번이 일치하지 않아요",Toast.LENGTH_SHORT).show();
                            new AlertDialog.Builder(LoginActivity.this)
                                    .setIcon(android.R.drawable.ic_menu_info_details)
                                    .setTitle("로그인 결과")
                                    .setMessage("아이디와 비번이 일치하지 않아요")
                                    .show();
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
        }
    };

    public void memberClick(View view) {
        Intent intent = new Intent(this, MemberActivity.class);
        startActivity(intent);
    }

    public void SplashClick(View view) {
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);
    }

    public void mapClick(View view){
        Intent intent = new Intent(this, MapAcitivity.class);
        startActivity(intent);
    }


    private void initView() {
        id = (EditText) findViewById(R.id.idInput);
        pwd = (EditText) findViewById(R.id.passwordInput);
        btnLogin = (Button) findViewById(R.id.registMember);
    }

}/////////class
