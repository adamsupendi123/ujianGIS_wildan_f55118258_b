package com.example.wildan_f55118258_b;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng warkop = new LatLng(-1.1730088083105452, 119.35054497358142);
        mMap.addMarker(new MarkerOptions().position(warkop).title("Warkop"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(warkop));

        LatLng masjid = new LatLng(-1.1715888638487253, 119.35033683471673);
        mMap.addMarker(new MarkerOptions().position(masjid).title("Masjid Apung"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(masjid));


        mMap.addPolyline(new PolylineOptions().add(
                warkop,
                new LatLng( -1.173004728011396, 119.3505327301188),
                new LatLng(-1.1723804421720088, 119.34949611694955),
                new LatLng(-1.1715888638487253, 119.35033683471673),
                masjid
                ).width(10)
                        .color(Color.BLUE)

        );
    }
}