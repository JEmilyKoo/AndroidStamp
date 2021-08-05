package kosmo.com.stampgo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private EditText nickName;
    private EditText intro;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private Button btnProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);
        initView();

        btnProfile.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
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
