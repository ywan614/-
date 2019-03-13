package com.example.wangyue.mymovie;

import com.google.android.gms.maps.model.LatLng;

public class LocDetails {
    String mLocName;
    LatLng mLatLng;
    public LocDetails(String name) {
        this.mLocName = name;
        //this.mLatLng = l;
    }
    @Override
    public String toString(){
        String s;
        s = mLocName;
        return s;
    }
}
