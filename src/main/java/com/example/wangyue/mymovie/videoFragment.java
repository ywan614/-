package com.example.wangyue.mymovie;


import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class videoFragment extends Fragment implements YouTubePlayer.OnInitializedListener {
    public static final String DEVELOPER_KEY ="AIzaSyCSQIxm4AXJQ73Ai9nS6grHO72aNCVC84Y";
    public static final String VIDEO_ID ="NWepvH6LnEw&t=2s";
    public static final int RECOVERY_DIALOG_REQUEST =1;
    VideoView mVideoView;
    String path;
    YouTubePlayerFragment mPlayer;
    movie m;

    public videoFragment() {
        // Required empty public constructor
    }

    public void initVideo(movie m){
        this.m = m;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video,container,false);
        // Get VideoView instance and enable media controls
        mVideoView = (VideoView)view.findViewById(R.id.videoView);
        mVideoView.setMediaController(new MediaController(getActivity()));
        //choose video

        switch (m.getName()){
            case "Avengers: Infinity War":
                mVideoView.setVideoPath("android.resource://" + getActivity().getPackageName() +
                        "/" +R.raw.avengers);
                break;
            case "BREATH":
                mVideoView.setVideoPath("android.resource://" + getActivity().getPackageName() +
                        "/" + R.raw.breathe);
                break;
            case "I FEEL PRETTY":
                mVideoView.setVideoPath("android.resource://" + getActivity().getPackageName() +
                        "/" + R.raw.pretty);
            case "A Quiet Place":
                mVideoView.setVideoPath("android.resource://" + getActivity().getPackageName() +
                        "/" + R.raw.quiet);
                break;
            case "Rabbit":
                mVideoView.setVideoPath("android.resource://" + getActivity().getPackageName() +
                        "/" + R.raw.rabbit);
                break;
        }



        mVideoView.start();


        return view;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b){
            youTubePlayer.cueVideo(VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }

}
