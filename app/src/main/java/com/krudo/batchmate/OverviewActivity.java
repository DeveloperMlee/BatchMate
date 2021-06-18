package com.krudo.batchmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.util.Util;
import com.krudo.batchmate.Model.OverViewModel;

import java.util.ArrayList;

public class OverviewActivity extends AppCompatActivity {
    private PlayerView playerView;
    private SimpleExoPlayer player;
    private TextView oveOne,oveTwo,oveThree;
    private String cName,tName,objOne,objTwo,objThree,url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        oveOne=findViewById(R.id.overViewOne);
        oveTwo=findViewById(R.id.overViewTwo);
        oveThree=findViewById(R.id.overViewThree);

        player=new SimpleExoPlayer.Builder(this).build();
        playerView=findViewById(R.id.playerView);
        playerView.setPlayer(player);
        url=getIntent().getExtras().getString("url");
        objOne=getIntent().getExtras().getString("objOne");
        objTwo=getIntent().getExtras().getString("objTwo");
        objThree=getIntent().getExtras().getString("objThree");

        oveOne.setText(objOne);
        oveTwo.setText(objTwo);
        oveThree.setText(objThree);

        MediaItem mediaItem = MediaItem.fromUri(url);
// Set the media item to be played.
        player.setMediaItem(mediaItem);
// Prepare the player.
        player.prepare();
// Start the playback.
//        player.play();
    }




}