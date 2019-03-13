package com.example.wangyue.mymovie;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class aboutFragment extends Fragment {


    public aboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about, container, false);
        TextView aboutTxt = (TextView)v.findViewById(R.id.txt_des);
        aboutTxt.setText("\nDependencies\n\n" +
                "'com.google.gms:google-services:3.2.0\n" +
                "'com.google.firebase:firebase-database:11.8.0'\n" +
                "'com.google.firebase:firebase-auth:11.8.0'\n" +
                "'com.google.firebase:firebase-crash:11.8.0'\n" +
                "Google API KEY AIzaSyCSQIxm4AXJQ73Ai9nS6grHO72aNCVC84Y\n\n" +
                "Media Resources\n\n" +
                "https://www.youtube.com/watch?v=6ZfuNTqbHE8&t=1s\n" +
                "https://www.youtube.com/watch?v=7Pa_Weidt08\n" +
                "https://www.youtube.com/watch?v=7_YnYrLfjxA&t=1s\n" +
                "https://www.youtube.com/watch?v=cVx9EFK3DWE&t=1s\n" +
                "https://www.youtube.com/watch?v=WR7cc5t7tv8");

        return v;
    }

}
