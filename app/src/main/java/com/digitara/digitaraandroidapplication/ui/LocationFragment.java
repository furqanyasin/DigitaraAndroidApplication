package com.digitara.digitaraandroidapplication.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import com.digitara.digitaraandroidapplication.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LocationFragment extends Fragment {
    private GoogleMap googleMap;
    MapView mMapView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_location, container, false);
        MapView mapView = (MapView) root.findViewById(R.id.map);
        this.mMapView = mapView;
        mapView.onCreate(savedInstanceState);
        this.mMapView.onResume();
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.mMapView.getMapAsync(new OnMapReadyCallback() {
            /* class com.digitara.digitara.ui.LocationFragment.AnonymousClass1 */

            @Override // com.google.android.gms.maps.OnMapReadyCallback
            public void onMapReady(GoogleMap mMap) {
                LocationFragment.this.googleMap = mMap;
                LatLng sydney = new LatLng(31.492723d, 74.336928d);
                LocationFragment.this.googleMap.addMarker(new MarkerOptions().position(sydney).title("Digitara").snippet("Transforming Digitally"));
                LocationFragment.this.googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(sydney).zoom(12.0f).build()));
            }
        });
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mMapView.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mMapView.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mMapView.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onLowMemory() {
        super.onLowMemory();
        this.mMapView.onLowMemory();
    }
}
