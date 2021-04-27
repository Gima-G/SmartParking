package com.example.sp;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class map extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener{
    private Button butt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        butt = findViewById(R.id.bt_park);
        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(map.this, park_list.class);
                startActivity(intent);

            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng akademia = new LatLng(56.857684, 53.195629);
        googleMap.addMarker(new MarkerOptions().position(akademia).title("Neposredsvenno akademia"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(akademia));
        googleMap.setOnMarkerClickListener(this);
    }


    public boolean onMarkerClick(Marker marker) {
        Intent intent = new Intent(this, park_info.class);
        Toast.makeText(this,
                marker.getTitle() + " данные об этой парковке ", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        return false;

    }
}