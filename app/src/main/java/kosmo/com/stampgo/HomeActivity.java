package kosmo.com.stampgo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
public class HomeActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    MenuFragment menuFragment;
    NearStampFragment nearStampFragment;
    ReviewFragment reviewFragment;
    StampListFragment stampListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeFragment = (HomeFragment)getSupportFragmentManager().findFragmentById(R.id.homeFragment);
        menuFragment = new MenuFragment();
        nearStampFragment = new NearStampFragment();
        reviewFragment = new ReviewFragment();
        stampListFragment = new StampListFragment();


    }

    public void onFragmentChanged(int index){

        if(index==0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();

        }else if(index ==1){

            getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
        }

        else if(index ==2){

            getSupportFragmentManager().beginTransaction().replace(R.id.container,nearStampFragment).commit();
        }
        else if(index ==3){

            getSupportFragmentManager().beginTransaction().replace(R.id.container,reviewFragment).commit();
        }
        else if(index ==4){

            getSupportFragmentManager().beginTransaction().replace(R.id.container,stampListFragment).commit();
        }


    }
}