package com.krudo.batchmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.util.Util;

public class OverviewActivity extends AppCompatActivity {
    private PlayerView playerView;
    private SimpleExoPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        player=new SimpleExoPlayer.Builder(this).build();
        playerView=findViewById(R.id.playerView);
        playerView.setPlayer(player);
        MediaItem mediaItem = MediaItem.fromUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
// Set the media item to be played.
        player.setMediaItem(mediaItem);
// Prepare the player.
        player.prepare();
// Start the playback.
//        player.play();
    }




}