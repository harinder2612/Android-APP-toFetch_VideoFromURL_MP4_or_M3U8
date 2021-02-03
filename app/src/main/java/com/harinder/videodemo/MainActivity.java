package com.harinder.videodemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;
    EditText link;
    Button fetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.videoView);
        link = findViewById(R.id.link);
        fetch = findViewById(R.id.fetch);

        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.setVideoPath(link.getText().toString());
                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mp) {
                        mp.start();

                        float videoRatio = mp.getVideoWidth()/(float) mp.getVideoHeight();
                        float screenRatio = videoView.getWidth()/(float) videoView.getHeight();

                        float scale = videoRatio/screenRatio;

                        if(scale >= 1f)
                        {
                            videoView.setScaleX(scale);
                        }else
                        {
                            videoView.setScaleY(1f / scale);
                        }
                    }
                });
            }
        });

    }

}
