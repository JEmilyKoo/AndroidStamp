package kosmo.com.stampgo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private EditText nickName;
    private EditText intro;
    private RadioGroup radioGroup;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        radioButton1.setOnClickListener(radioButtonClickListener);
        radioButton2.setOnClickListener(radioButtonClickListener);
        radioButton3.setOnClickListener(radioButtonClickListener);
        radioButton4.setOnClickListener(radioButtonClickListener);
        //radioGroup.setOnCheckedChangeListener(radioGroupButtonChangeListener);

        initView();
        //버튼에 리스너 부착
        //btnProfile.setOnClickListener(listener);
    }

    RadioButton.OnClickListener radioButtonClickListener = new RadioButton.OnClickListener(){
        @Override
        public void onClick(View view) {
            Toast.makeText(ProfileActivity.this,
                    "radioButton1 : " + radioButton1.isChecked() +
                            "radioButton2 : " + radioButton2.isChecked() +
                            "radioButton3 : " + radioButton3.isChecked()+
                            "radioButton4 : " + radioButton4.isChecked(),
                    Toast.LENGTH_SHORT).show();
        }
    };



    private void initView() {
        nickName = (EditText) findViewById(R.id.nickNameInput);
        intro = (EditText) findViewById(R.id.introInput);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        btnProfile = (Button) findViewById(R.id.profileMember);
    }


}
