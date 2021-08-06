package kosmo.com.stampgo;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import net.daum.android.map.coord.MapCoordLatLng;
import net.daum.mf.map.api.MapCircle;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import kosmo.com.stampgo.service.MemberDTO;
import kosmo.com.stampgo.service.StampDTO;
import kosmo.com.stampgo.service.StampService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class MapAcitivity extends AppCompatActivity {

    //권한요청시 구분하기위한 요청코드
    public static final int MY_REQUEST_PERMISSION_LOCATION =1;
    //위치 서비스를 사용사용하기 위한 변수
    private LocationManager locationManager;
    private LocationListener locationListener;
    private MapView.POIItemEventListener eventListener;
    //현재 앱에서 필요한 권한들
    private String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION};
    //허용이 안된 권한들을 저장할 컬렉션
    List<String> denyPermissions = new Vector<>();

    private SharedPreferences preferences;

    private String nickName;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        preferences = this.getSharedPreferences("loginInfo", Activity.MODE_PRIVATE);
        nickName = preferences.getString("nickName", null);

        MapView mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        // 중심점 변경
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.4782002496149, 126.87930867502912), true);

        // 줌 인
        mapView.zoomIn(true);

        // 줌 아웃
        mapView.zoomOut(true);

        mapView.setCurrentLocationTrackingMode(MapView.CurrentLocationTrackingMode.TrackingModeOnWithoutHeadingWithoutMapMoving);
        mapView.setShowCurrentLocationMarker(true);
        mapView.isShowingCurrentLocationMarker();

        StampService stampService = new Retrofit.Builder()
                .baseUrl("http://192.168.0.20:9090/exer/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(StampService.class);
        Call<ArrayList<StampDTO>> call = stampService.stampList();
        call.enqueue(new Callback<ArrayList<StampDTO>>() {
            @Override
            public void onResponse(Call<ArrayList<StampDTO>> call, Response<ArrayList<StampDTO>> response) {
                if (response.isSuccessful()) {
                    List<StampDTO> list = response.body();
                    for(StampDTO item : list){
                        MapPoint MARKER_POINT = MapPoint.mapPointWithGeoCoord
                                (Double.valueOf(item.getRvLat()),Double.valueOf(item.getRvLng()));
                        MapPOIItem marker = new MapPOIItem();
                        marker.setItemName(item.getRvTitle());
                        marker.setTag(0);
                        marker.setMapPoint(MARKER_POINT);
                        marker.setMarkerType(MapPOIItem.MarkerType.CustomImage);
                        marker.setCustomImageResourceId(R.drawable.stamp1);
                        marker.setCustomImageAutoscale(true);
                        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
                        mapView.addPOIItem(marker);
                        MapCircle circle2 = new MapCircle(MARKER_POINT, 1000,
                                Color.argb(128, 0, 160, 233),
                                Color.argb(128, 0, 160, 233));
                        mapView.addCircle(circle2);
                        mapView.setPOIItemEventListener(eventListener);
                    }
                }
                else{//200번 아닌거
                }
            }
            @Override
            public void onFailure(Call<ArrayList<StampDTO>> call, Throwable t) {
                Log.i("kosmo.com.stampgo", "5555555555"+t.getMessage());

            }
        });

        preferences = getSharedPreferences("checkDeny",MODE_PRIVATE);
        //LocationManager 생성]
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);


        eventListener = new MapView.POIItemEventListener(){

            @Override
            public void onPOIItemSelected(MapView mapView, MapPOIItem marker) {
                Log.i("kosmo.com.stampgo","11111111");
            }

            @Override
            public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem marker) {
                Log.i("kosmo.com.stampgo","2222222222");

            }

            @Override
            public void onCalloutBalloonOfPOIItemTouched(MapView mapView, MapPOIItem marker, MapPOIItem.CalloutBalloonButtonType calloutBalloonButtonType) {
                Log.i("kosmo.com.stampgo","4444444444");

            }

            @Override
            public void onDraggablePOIItemMoved(MapView mapView, MapPOIItem marker, MapPoint mapPoint) {
                Log.i("kosmo.com.stampgo","33333333333");

            }
        };


        //리스너 생성]
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                Double lat = location.getLatitude();
                Double lng = location.getLongitude();
                if(nickName != null){
                    StampService stampService = new Retrofit.Builder()
                            .baseUrl("http://192.168.0.20:9090/exer/")
                            .addConverterFactory(JacksonConverterFactory.create())
                            .build()
                            .create(StampService.class);
                    Call<Integer> call = stampService.check(nickName,lat,lng);
                    call.enqueue(new Callback<Integer>() {
                        @Override
                        public void onResponse(Call<Integer> call, Response<Integer> response) {
                            if (response.isSuccessful()) {
                                Log.i("kosmo.com.stampgo","위도경도 바뀌낭???"+nickName);
                                if(response.body() == 1){ //스탬프 얻기 성공
                                    new androidx.appcompat.app.AlertDialog.Builder(MapAcitivity.this)
                                            .setIcon(android.R.drawable.ic_menu_info_details)
                                            .setTitle("스탬프")
                                           .setMessage("축하드립니다. ! 스탬프를 획득했습니다. 경험치 20 획득했습니다.")
                                            .show();
                                }
                            }
                            else{//200번 아닌거
                                Log.i("kosmo.com.stampgo","2222222222222");
                            }
                        }
                        @Override
                        public void onFailure(Call<Integer> call, Throwable t) {
                            Log.i("kosmo.com.stampgo",t.getMessage());

                        }
                    });
                }


            }
        };

        if(locationManager !=null){
            try {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,5000,0,locationListener);
            }
            catch(SecurityException e){e.printStackTrace();}
        }


        //3]권한 요청하기
        //마쉬멜로우 이후 버전부터 사용자에게 권한 요청보낸다
        if(Build.VERSION.SDK_INT >=23){
            boolean isCheck = preferences.getBoolean("AGAIN",false);
            if(isCheck){//다시 묻지 않음 체크시 즉 권한 요청창이 절대 안뜸
                new AlertDialog.Builder(this)
                        .setTitle("앱 권한 설정")
                        .setMessage("권한을 설정해야 앱을 사용하실 수 있습니다\r\n설정 하시겠습니까?")
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //권한 설정화면으로 이동시키기(화면 전환)
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                Uri uri = Uri.fromParts("package",getPackageName(),null);
                                intent.setData(uri);
                                startActivity(intent);
                                //다시 false로 초기화
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putBoolean("AGAIN",false);
                                editor.commit();

                            }
                        })
                        .setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).show();
            }//if(isCheck)
            else//사용자에게 권한 요청 보내기
                requestUserPermissions();
        }// if(Build.VERSION.SDK_INT >=23)
    }//////////////////////onCreate





    private boolean requestUserPermissions() {
        for(String permission : permissions){
            //권한 획득시 0,없을시 -1
            int checkSelfPermission= ActivityCompat.checkSelfPermission(this,permission);
            //권한이 없는 경우
            if(checkSelfPermission == PackageManager.PERMISSION_DENIED){
                denyPermissions.add(permission);
            }
            if(denyPermissions.size() !=0){//권한이 없는게 있다면
                new AlertDialog.Builder(this)
                        .setCancelable(false)
                        .setTitle("권한 요청")
                        .setMessage("권한을 허용해야 앱을 정상적으로 사용할 수 있습니다")
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //사용자에게 권한 요청 코드 작성
                                //두번째 인자:요청할 권한들의 String[]
                                ActivityCompat.requestPermissions(
                                        MapAcitivity.this,
                                        denyPermissions.toArray(new String[denyPermissions.size()]),
                                        MY_REQUEST_PERMISSION_LOCATION);
                            }
                        })
                        .setNegativeButton("종료", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .show();
                return false;
            }
        }///for
        return true;//모든 권한이 있는 경우
        //※ onRequestPermissionsResult오버라이딩 하자
    }///////////requestUserPermissions

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull  String[] permissions,  int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch(requestCode){
            case MY_REQUEST_PERMISSION_LOCATION:
                if(grantResults.length > 0){//사용자가  allow(허용)나 deny를 누른 경우
                    for(int i=0; i < permissions.length;i++){
                        //허용한 경우
                        if(grantResults[i]==PackageManager.PERMISSION_GRANTED){}
                        else{//사용자가  deny(거부)를 누른 경우
                            //boolean shouldShowRequestPermissionRationale(컨텍스트,권한명)
                            //사용자가 이전에 권한 요청을 거부(deny)한 이력이 있는 경우에 true반환.
                            //다시 앱 실행시 권한 요청 대화창에는 '다시 묻지 않기' 표시됨.
                            //사용자가 '다시 묻지 않기'를 클릭하면 이후에 앱이  ActivityCompat.requestPermissions()메서드를
                            //호출해도 권한 요청 대화창이 뜨지 않는다
                            //단,onRequestPermissionsResult()콜백함수는 호출된다.
                            if(!ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.ACCESS_FINE_LOCATION)){
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putBoolean("AGAIN",true);//사용자 권한 설장창으로 이동시키기 위한 설정
                                editor.commit();
                            }
                            Toast.makeText(this,"권한을 허용해야만 앱을 사용할 수 있습니다\r\n앱을 종료합니다",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                }////if
                break;
        }
    }//////////////onRequestPermissionsResult



}////////////
