package com.example.wangyue.mymovie;


import android.app.ActionBar;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class movieDetailsFragment extends Fragment {
    movie m;
    TextView movieName;
    TextView movieAct;
    TextView movieDir;
    TextView movieGen;
    TextView movieTime;
    TextView movieAdd;
    TextView movieDes;

    public movieDetailsFragment() {
        // Required empty public constructor
    }
    public void initFragment(movie m){
        this.m = m;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view = inflater.inflate(R.layout.fragment_movie_details,container,false);
        movieName = (TextView) view.findViewById(R.id.movieName);
        movieAct = (TextView) view.findViewById(R.id.movieAct);
        movieDir = (TextView) view.findViewById(R.id.movieDir);
        movieGen = (TextView) view.findViewById(R.id.movieGenre);
        movieTime = (TextView) view.findViewById(R.id.movieTime);
        movieAdd = (TextView) view.findViewById(R.id.movieAdd);
        movieDes = (TextView) view.findViewById(R.id.movieDes);

        movieName.setText(m.getName());
        movieAct.setText(m.getActor());
        movieDir.setText(m.getDirector());
        movieGen.setText(m.getGenre());
        movieTime.setText(m.getTime());
        movieAdd.setText(m.getAddress());
        movieDes.setText(m.getDescription());

        return view;
    }

}
