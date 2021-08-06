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
import android.widget.RadioButton;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;

import kosmo.com.stampgo.service.MemberDTO;
import kosmo.com.stampgo.service.StampService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MemberActivity extends AppCompatActivity {

    private EditText id;
    private EditText pwd;
    private EditText pwd2;
    private EditText name;
    private Button btnJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        initView();

        //버튼에 리스너 부착
        btnJoin.setOnClickListener(listener);
    }


    View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Log.i("kosmo.com.stampgo", "나와라 얍!!!");
            String userid = id.getText().toString();
            String password = pwd.getText().toString();
            String password2 = pwd2.getText().toString();
            String username = name.getText().toString();

            if (!password.equals(password2)) {
                new AlertDialog.Builder(MemberActivity.this)
                        .setIcon(android.R.drawable.ic_menu_info_details)
                        .setTitle("회원가입 결과")
                        .setMessage("비밀번호를 다시 확인해주세요")
                        .show();
            }
            else {////비밀번호 같은지 확인
                StampService stampService = new Retrofit.Builder()
                        .baseUrl("http://192.168.0.20:9090/exer/")
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build()
                        .create(StampService.class);
                Call<Integer> call = stampService.join(userid, password, username);
                call.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        if (response.isSuccessful()) {
                            Log.i("kosmo.com.stampgo", "일단 들어옴");
                            if (response.body() == 1) {

                                Intent intent = new Intent(MemberActivity.this, ProfileActivity.class);
                                startActivity(intent);

                                SharedPreferences preferences = getSharedPreferences("loginInfo",MODE_PRIVATE);
                                SharedPreferences.Editor editor =preferences.edit();

                                editor.putString("id",userid);
                                editor.commit();

                            } else {
                                new AlertDialog.Builder(MemberActivity.this)
                                        .setIcon(android.R.drawable.ic_menu_info_details)
                                        .setTitle("회원가입 결과")
                                        .setMessage("아이디가 중복되었습니다.")
                                        .show();
                            }
                        } else {//200번 아닌거
                            Log.i("kosmo.com.stampgo", "안된다!!!!");
                        }
                    }
                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Log.i("kosmo.com.stampgo", t.getMessage());
                    }
                });
            }
        }
    };

        private void initView() {
            id = (EditText) findViewById(R.id.idInput);
            pwd = (EditText) findViewById(R.id.passwordInput);
            pwd2 = (EditText) findViewById(R.id.passwordInput2);
            name = (EditText) findViewById(R.id.nameInput);
            btnJoin = (Button) findViewById(R.id.registMember);
        }
    }

