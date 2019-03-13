package com.example.wangyue.mymovie;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

public class theatreFragment extends Fragment implements LocationListFragment.OnLocationSelectedListener,
        MapControlFragment.OnMapClicked{
    private String context;
    private TextView mTextView;
    private boolean mIsTwoPane;
    private ArrayList<LocDetails> mSavedLocations;
    private LocationListFragment mListFragment;
    private MapControlFragment mMapFragment;
    private FrameLayout mPrimaryFrame;
    private FrameLayout mSecondaryFrame;


    public theatreFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mListFragment = new LocationListFragment();
        mMapFragment = new MapControlFragment();


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.theatre_fragment_view,container,false);



        initDefaultLocations();
        mListFragment = new LocationListFragment();
        mMapFragment = new MapControlFragment();
        mListFragment.initFragment(this, mSavedLocations);
        mMapFragment.initFragment(this, mSavedLocations);
        mPrimaryFrame = view.findViewById(R.id.primaryLayout);
        mSecondaryFrame = view.findViewById(R.id.secLayout);

        //show fragment
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(mPrimaryFrame.getId(), mListFragment);
        transaction.add(mSecondaryFrame.getId(), mMapFragment).commit();
        
        return view;
    }



    private void initDefaultLocations() {
        mSavedLocations = new ArrayList<>();
        mSavedLocations.add(new LocDetails("HOYTS Melbourne Central"));
        mSavedLocations.add(new LocDetails("Village Cinema Crown"));
        mSavedLocations.add(new LocDetails("Palace Cinema Como"));
    }

    @Override
    public void onLocationSelected(LatLng loc) {
        
    }

    @Override
    public void onMapClicked(String locName, LatLng position) {
        mSavedLocations.add(new LocDetails(locName));
        mMapFragment.updateMapMarkers();
        mListFragment.refreshList();
    }
}
