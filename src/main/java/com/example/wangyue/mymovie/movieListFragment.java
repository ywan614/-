package com.example.wangyue.mymovie;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.constraint.solver.widgets.Snapshot;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;

public class movieListFragment extends Fragment implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private movieAdapter mAdapter;
    private ArrayList<movie> movieList = new ArrayList<>();
    private DatabaseReference ref;
    private FirebaseAuth mAuth;
    View v;



    public movieListFragment() {

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_list_fargment,container,false);


        return view;
    }
//create default value. cinema name = Hoyts
    @Override
    public void onViewCreated(View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        this.v = view;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String data = prefs.getString("name", "Hoyts");
        init();
        load(data);
        mListView.setOnItemClickListener(this);

    }
    //load data from firebase
    private void load(String s) {
        //init firebase
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        //String userID = user.getUid();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference(s);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                movieList.clear();

                for (DataSnapshot ds: dataSnapshot.getChildren()){
                    movie m = ds.getValue(movie.class);

                    movieList.add(m);
                }
                mAdapter = new movieAdapter(getActivity(), movieList);
                mListView.setAdapter(mAdapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                //Log.d("dddd", "Cancelled");

            }
        });




    }

    private void init() {
        mListView = v.findViewById(R.id.movieListView);
    }

/*
    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        movie m = movieList.get(position);
        intent = new Intent(getActivity(),movieInfo.class);
        intent.putExtra("movie",m);
        startActivity(intent);
        return false;
    }
    */



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent;
        movie m = movieList.get(position);
        intent = new Intent(getActivity(),movieInfo.class);
        intent.putExtra("movie",m);
        startActivity(intent);
    }
}
