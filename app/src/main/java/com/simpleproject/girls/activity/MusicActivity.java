package com.simpleproject.girls.activity;

import static com.google.android.exoplayer2.util.RepeatModeUtil.REPEAT_TOGGLE_MODE_ALL;
import static com.google.android.exoplayer2.util.RepeatModeUtil.REPEAT_TOGGLE_MODE_NONE;
import static com.google.android.exoplayer2.util.RepeatModeUtil.REPEAT_TOGGLE_MODE_ONE;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import com.simpleproject.girls.R;
import com.simpleproject.girls.databinding.ActivityMusicBinding;
import com.simpleproject.girls.models.Content;

public class MusicActivity extends AppCompatActivity {

    ActivityMusicBinding binding;

    Bundle bundle;

    Content music;

    ExoPlayer player;

    String musicUri;

    String fileName;

    DownloadManager downloadManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bundle = getIntent().getExtras();

        music = bundle.getParcelable("audio");

        musicUri = bundle.getString("musicUri");

        fileName = bundle.getString("fileName");

        player=  new ExoPlayer.Builder(this).build();

        Log.e("" , "");


        MediaItem mediaItem = MediaItem.fromUri(Uri.parse(music.getContentUrl()));
        player.setMediaItem(mediaItem);

        player.prepare();
        player.play();
        binding.videoView.setPlayer(player);

        binding.videoView.getControllerHideOnTouch();
        binding.videoView.getSubtitleView();
        //binding.videoView.setRepeatToggleModes(REPEAT_TOGGLE_MODE_ALL);

        binding.videoView.setRepeatToggleModes(REPEAT_TOGGLE_MODE_ONE);
        //binding.videoView.setRepeatToggleModes(REPEAT_TOGGLE_MODE_NONE);
        //binding.videoView.setShowMultiWindowTimeBar(true);

        binding.videoView.setShowNextButton(true);
        binding.videoView.setShowPreviousButton(true);
        binding.videoView.setShowShuffleButton(true);

        binding.imgDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(musicUri);
                DownloadManager.Request request = new DownloadManager.Request(uri);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                downloadManager.enqueue(request);

            }
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}