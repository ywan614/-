package com.example.wangyue.mymovie;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;


public class myMovieList extends AppCompatActivity implements View.OnClickListener {
    private TextView topBar;
    private TextView tabmovie;
    private TextView tabtheatre;
    private TextView tabAbout;

    private FrameLayout ly_content;

    private movieListFragment f1;
    private theatreFragment f2;
    private aboutFragment f3;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_my_movie_list);

        bindView();
        //show moive list fragment
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        selected();
        tabmovie.setSelected(true);
        f1 = new movieListFragment();
        transaction.add(R.id.fragment_container, f1);
        transaction.commit();






    }

    //bind ui and event
    private void bindView() {
        topBar = (TextView) this.findViewById(R.id.txt_top);
        tabmovie = (TextView) this.findViewById(R.id.txt_movie);
        tabtheatre = (TextView) this.findViewById(R.id.txt_theatre);
        tabAbout = (TextView) this.findViewById(R.id.txt_About);
        ly_content = (FrameLayout) this.findViewById(R.id.fragment_container);

        tabmovie.setOnClickListener(this);
        tabtheatre.setOnClickListener(this);
        tabAbout.setOnClickListener(this);
    }
    //start fragment
    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        switch (v.getId()) {
            case R.id.txt_movie:
                selected();
                tabmovie.setSelected(true);

                transaction.replace(R.id.fragment_container, f1);
                transaction.addToBackStack(null);


                break;
            case R.id.txt_theatre:
                selected();
                tabtheatre.setSelected(true);

                f2 = new theatreFragment();
                transaction.replace(R.id.fragment_container, f2);
                transaction.addToBackStack(null);
                break;

            case R.id.txt_About:
                selected();
                tabAbout.setSelected(true);

                f3 = new aboutFragment();
                transaction.replace(R.id.fragment_container, f3);
                transaction.addToBackStack(null);
                break;


        }


            transaction.commit();
        }


    //reset txt status
    private void selected(){
        tabmovie.setSelected(false);
        tabtheatre.setSelected(false);
        tabAbout.setSelected(false);
    }
}

    
