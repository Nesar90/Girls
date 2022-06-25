package com.simpleproject.girls.activity;

import static com.google.android.exoplayer2.util.RepeatModeUtil.REPEAT_TOGGLE_MODE_ALL;
import static com.google.android.exoplayer2.util.RepeatModeUtil.REPEAT_TOGGLE_MODE_NONE;
import static com.google.android.exoplayer2.util.RepeatModeUtil.REPEAT_TOGGLE_MODE_ONE;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

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

    //int number;

    //int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMusicBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bundle = getIntent().getExtras();

        music = bundle.getParcelable("audio");

        //number = Integer.parseInt(bundle.getParcelable("number"));

        //binding.txtArtistMusic.setText(music.getContentDuration());

        player=  new ExoPlayer.Builder(this).build();



        /*for (counter = 0 ; counter < number ; counter++ ) {
            MediaItem mediaItem = MediaItem.fromUri(Uri.parse(music.getContentUrl()));
            player.addMediaItem(mediaItem);
        }*/
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


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}