package com.example.wangyue.mymovie;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationListFragment extends Fragment implements
        AdapterView.OnItemClickListener{
    private ArrayList<LocDetails> mSavedLocations;
    private OnLocationSelectedListener mListener;
    private ListView mListView;
    private ArrayAdapter<LocDetails> mAdapter;
    private TextView t1;


    public LocationListFragment() {
        // Required empty public constructor
        mSavedLocations = new ArrayList<>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_location_list, container, false);
        mAdapter = new ArrayAdapter<LocDetails>(inflater.getContext(),
                android.R.layout.simple_list_item_1,
                mSavedLocations){
            //change text background
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                // Set the text color of TextView (ListView Item)
                tv.setSelected(false);
                //tv.setTextColor(R.drawable.tab_menu_text_color);
                tv.setTextColor(Color.WHITE);
                // Generate ListView Item using TextView
                return view;

            }


        };

        mListView = v.findViewById(R.id.locationListView);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);



        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        //view.setSelected(true);
        Bundle b = new Bundle();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = prefs.edit();
        switch (i){
            case 0:
                setDefaultColor();
                mListView.getChildAt(0).setBackgroundResource(R.color.colorAccent);
                editor.clear();
                editor.putString("name", "Hoyts");
                editor.commit();
                break;
            case 1:
                setDefaultColor();
                mListView.getChildAt(1).setBackgroundResource(R.color.colorAccent);
                editor.clear();
                editor.putString("name", "Palace");
                editor.commit();
                break;
            case 2:
                setDefaultColor();
                mListView.getChildAt(2).setBackgroundResource(R.color.colorAccent);
                editor.clear();
                editor.putString("name", "Village");
                editor.commit();
                break;

        }

        if(mListener != null) {
            mListener.onLocationSelected(mSavedLocations.get(i).mLatLng);
        }
    }

    public void initFragment(OnLocationSelectedListener listener,
                             ArrayList<LocDetails> locations) {
        mSavedLocations = locations;
        mListener = listener;
    }

    public void refreshList() {
        mAdapter.notifyDataSetChanged();
    }


    public interface OnLocationSelectedListener {
        void onLocationSelected(LatLng loc);
    }

    public void setDefaultColor(){
        for(int i =0;i<=2;i++){
            mListView.getChildAt(i).setBackgroundResource(R.color.dark);
        }
    }
}
