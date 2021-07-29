package kosmo.com.stampgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //테스트!!


        Button button1 =(Button) findViewById(R.id.button_home);
        button1.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://10.0.2.2:9090/exer/"));
                startActivity(myIntent);
            }

            ;

    });

    }
}