package com.example.wangyue.mymovie;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MapControlFragment extends Fragment implements OnMapReadyCallback,
        GoogleMap.OnMapLongClickListener {
    private GoogleMap mMap;
    private OnMapClicked mListener;

    private ArrayList<LocDetails> mSavedLocations;
    private LatLng mCurrentLoc;

    private MapFragment mapFragment;



    public MapControlFragment() {
        // Required empty public constructor
        mSavedLocations = new ArrayList<>();
        mCurrentLoc = new LatLng(-37.8770, 145.0443);
    }

    public void initFragment(OnMapClicked listener,
                             ArrayList<LocDetails> locations) {
        mListener = listener;
        mSavedLocations = locations;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_map_control, container, false);
        /*
        SupportMapFragment mapFrag = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFrag.getMapAsync(this);

        MapFragment mapfrag = (MapFragment)getChildFragmentManager().findFragmentById(R.id.mapFragment);
        mapfrag.getMapAsync(this);
        */
        if (mapFragment == null) {
            mapFragment = MapFragment.newInstance();

            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    //set marker
                    LatLng latLng = new LatLng(-37.814122, 144.963937);
                    googleMap.addMarker(new MarkerOptions().position(new LatLng(-37.814122, 144.963937))
                            .title("HOYTS Melbourne Central"));
                    googleMap.addMarker(new MarkerOptions().position(new LatLng(-37.823154, 144.957480))
                            .title("Village Cinema Crown"));
                    googleMap.addMarker(new MarkerOptions().position(new LatLng(-37.838635, 144.996947))
                            .title("Palace Cinema Como"));

                    float zoomLevel = 13; //This goes up to 21
                    googleMap.animateCamera((CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel)));


                }
            });
        }

        // R.id.mapFragment is a FrameLayout, not a Fragment
        getChildFragmentManager().beginTransaction().replace(R.id.mapFragment, mapFragment).commit();

        return v;
    }

    @Override
    public void onMapLongClick(LatLng latLng) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapLongClickListener(this);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                mCurrentLoc, 15));
        updateMapMarkers();
    }

    public void updateMapMarkers() {
        if (mMap != null) {
            mMap.clear();
            for (LocDetails location : mSavedLocations) {
                mMap.addMarker(new MarkerOptions()
                        .position(location.mLatLng)
                        .title(location.mLocName));
            }
        }
    }

    public void setFocus(LatLng loc) {
        mCurrentLoc = loc;
        if(mMap != null) {
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 15));
        }
    }




    public interface OnMapClicked {
        void onMapClicked(String locName, LatLng position);
    }
}
