package com.example.wangyue.mymovie;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import java.util.ArrayList;

public class movieInfo extends AppCompatActivity {
    private movie m;
    private movieDetailsFragment mDetailsFragment;
    private timePickerFragment timePickerFragment;
    private videoFragment videoFragment;
    private FrameLayout detailFrame;
    private FrameLayout timeFrame;
    private FrameLayout videoFrame;
    private ArrayList<movie> movieArrayList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_info);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        //customise appbar
        Drawable bg = getResources().getDrawable(R.drawable.tab_menu_bg);
        bar.setBackgroundDrawable(bg);
        bar.setTitle("Movie Information");



        Intent intent = getIntent();
        //init
        m = intent.getParcelableExtra("movie");
        mDetailsFragment = new movieDetailsFragment();
        timePickerFragment = new timePickerFragment();
        videoFragment = new videoFragment();
        detailFrame = findViewById(R.id.details_frame);
        timeFrame = findViewById(R.id.time_frame);
        //videoFrame = findViewById(R.id.video_frame);


        //pass movie object
        mDetailsFragment.initFragment(m);
        videoFragment.initVideo(m);
        timePickerFragment.initTimePicker(m);

        //show fragment
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.details_frame, mDetailsFragment);
        transaction.add(R.id.time_frame, timePickerFragment);
        transaction.add(R.id.video_frame, videoFragment);

        transaction.commit();




    }




}
