package com.example.instatvideo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    private String urlVideo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);

        getIntentMain();

        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse(urlVideo));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus(0);
        videoView.start(); // начинаем воспроизведение автоматически
    }

    private void getIntentMain() {
        Intent i = getIntent();
        if (i != null) {
            urlVideo = i.getStringExtra(Constant.INTENT);
        }
    }

}
