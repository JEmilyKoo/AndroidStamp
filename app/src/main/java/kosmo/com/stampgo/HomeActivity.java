package kosmo.com.stampgo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.ViewGroup;

import net.daum.mf.map.api.MapView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


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
        getHashKey();



        homeFragment = (HomeFragment)getSupportFragmentManager().findFragmentById(R.id.homeFragment);
        menuFragment = new MenuFragment();
        nearStampFragment = new NearStampFragment();
        reviewFragment = new ReviewFragment();
        stampListFragment = new StampListFragment();


    }
    private void getHashKey(){
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
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