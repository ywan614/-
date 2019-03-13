package com.example.wangyue.mymovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class movieAdapter extends BaseAdapter {
    private Context mCurrentContext;
    private ArrayList<movie> movieArrayList;
    public movieAdapter(Context con, ArrayList<movie> movie) {
        mCurrentContext = con;
        movieArrayList = movie;
    }

    @Override
    public int getCount() {
        return movieArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return movieArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // Check if view already exists. If not inflate it
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mCurrentContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // Create a list item based off layout definition
            view = inflater.inflate(R.layout.movie_content, null);
        }
        String movieName = movieArrayList.get(i).getName();
        ImageView imageView = (ImageView) view.findViewById(R.id.movieImg);
        switch (movieName){
            case "Avengers: Infinity War":
                imageView.setImageResource(R.mipmap.avengers);
                break;
            case"BREATH":
                imageView.setImageResource(R.mipmap.breath);
                break;
            case"I FEEL PRETTY":
                imageView.setImageResource(R.mipmap.ifeelpretty);
                break;
            case"A Quiet Place":
                imageView.setImageResource(R.mipmap.quiet);
                break;
            case"Rabbit":
                imageView.setImageResource(R.mipmap.rabbit);
                break;
        }
        return view;
    }
}
