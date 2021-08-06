package kosmo.com.stampgo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import kosmo.com.stampgo.service.MemberDTO;
import kosmo.com.stampgo.service.StampService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ProfileActivity extends AppCompatActivity {

    private EditText nickName;
    private EditText intro;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button btnProfile;

    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initView();

        preferences = this.getSharedPreferences("loginInfo", Activity.MODE_PRIVATE);
        String id = preferences.getString("id", null);

        //버튼에 리스너 부착
        btnProfile.setOnClickListener(listener);



        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userNickname = nickName.getText().toString();
                String pr = intro.getText().toString();
                Boolean r1,r2,r3,r4 = false;
                int radio=1;
                r1=radioButton1.isChecked();
                r2=radioButton2.isChecked();
                r3=radioButton3.isChecked();
                r4=radioButton4.isChecked();
                if(r1){
                    radio = 1;
                }
                else if(r2){
                    radio = 2;
                }
                else if(r3){
                    radio = 3;
                }
                else if(r4){
                    radio = 4;
                }



                StampService stampService = new Retrofit.Builder()
                        .baseUrl("http://192.168.0.20:9090/exer/")
                        .addConverterFactory(JacksonConverterFactory.create())
                        .build()
                        .create(StampService.class);
                Call<Integer> call = stampService.profile(userNickname,pr,radio,id);
                call.enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        if (response.isSuccessful()) {
                            if(response.body()==1) {
                                new AlertDialog.Builder(ProfileActivity.this)
                                        .setIcon(android.R.drawable.ic_menu_info_details)
                                        .setTitle("회원가입 결과")
                                        .setMessage("회원가입 성공 했습니다.")
                                        .show();
                                Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                        }
                        else{
                            Log.i("kosmo.com.stampgo", "222222222222222");
                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        Log.i("kosmo.com.stampgo", t.getMessage());
                    }
                });



            }
        });


    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String userNickname = nickName.getText().toString();
            Boolean r1,r2,r3,r4 = false;
            String radio="1";
            r1=radioButton1.isChecked();
            r2=radioButton2.isChecked();
            r3=radioButton3.isChecked();
            r4=radioButton4.isChecked();
            if(r1){
                radio = "1";
            }
            else if(r2){
                radio = "2";
            }
            else if(r3){
                radio = "3";
            }
            else if(r4){
                radio = "4";
            }
            Log.i(" kosmo.com.stampgo","잘 되나?" + userNickname);
            Log.i(" kosmo.com.stampgo","잘 되나?" + radio);
            Log.i(" kosmo.com.stampgo","잘 되나?" + intro);

        };
    };




    private void initView() {
        nickName = (EditText) findViewById(R.id.nickNameInput);
        intro = (EditText) findViewById(R.id.introInput);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        btnProfile = (Button) findViewById(R.id.profileMember);
    }


}
