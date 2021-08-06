package kosmo.com.stampgo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;


public class WriteFragment extends Fragment implements MapView.MapViewEventListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private SharedPreferences preferences;
    private String nickName;

    private EditText title;
    private EditText rvctt;
    private Button btn;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WriteFragment() {
        // Required empty public constructor
    }


    public static WriteFragment newInstance(String param1, String param2) {
        WriteFragment fragment = new WriteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_write,container,false);

        preferences = rootView.getContext().getSharedPreferences("loginInfo", Activity.MODE_PRIVATE);
        nickName = preferences.getString("nickName", null);
        Log.i("kosmo.com.stampgo","들어오나?"+nickName);

        MapView mapView = new MapView(rootView.getContext());

        ViewGroup mapViewContainer = (ViewGroup) rootView.findViewById(R.id.map_view);
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


        title = (EditText) rootView.findViewById(R.id.writeTitle);
        rvctt = (EditText) rootView.findViewById(R.id.writeRvCtt);
        btn = (Button) rootView.findViewById(R.id.writeButton);

        btn.setOnClickListener(listener);



        return rootView; }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String title1 = title.getText().toString();
            String rvctt1 = rvctt.getText().toString();
        }
    };

    @Override
    public void onMapViewInitialized(MapView mapView) {

    }

    @Override
    public void onMapViewCenterPointMoved(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewZoomLevelChanged(MapView mapView, int i) {

    }

    @Override
    public void onMapViewSingleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDoubleTapped(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewLongPressed(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragStarted(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewDragEnded(MapView mapView, MapPoint mapPoint) {

    }

    @Override
    public void onMapViewMoveFinished(MapView mapView, MapPoint mapPoint) {

    }
}