package com.krudo.batchmate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    public String  Days="";
    public String Time="";
    private Animation animation;
    private CardView MonToFri,TueToSat,TenToEle,FiveToSix,SixToSe,enRollNow;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);
        oveOne=findViewById(R.id.overViewOne);
        oveTwo=findViewById(R.id.overViewTwo);
        oveThree=findViewById(R.id.overViewThree);
        MonToFri=findViewById(R.id.cardMonToFri);
        TueToSat=findViewById(R.id.cardTueToSat);
        TenToEle=findViewById(R.id.TenToEle);
        FiveToSix=findViewById(R.id.timeFiveToSix);
        SixToSe=findViewById(R.id.timeSixToSev);
        enRollNow=findViewById(R.id.enrollNow);
        animation= AnimationUtils.loadAnimation(this,R.anim.fadein);

        player=new SimpleExoPlayer.Builder(this).build();
        playerView=findViewById(R.id.playerView);
        playerView.setPlayer(player);
        url=getIntent().getExtras().getString("url");
        objOne=getIntent().getExtras().getString("objOne");
        objTwo=getIntent().getExtras().getString("objTwo");
        objThree=getIntent().getExtras().getString("objThree");
        cName=getIntent().getExtras().getString("cName");
        tName=getIntent().getExtras().getString("tName");

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

        MonToFri.setOnClickListener(v -> {
            v.startAnimation(animation);
            Days="Mon-Wed-Fri";
            TueToSat.setVisibility(View.INVISIBLE);

        });
        TueToSat.setOnClickListener(v -> {
            v.startAnimation(animation);
            Days="Tue-Thu-Sat";
            MonToFri.setVisibility(View.INVISIBLE);
        });

        TenToEle.setOnClickListener(v -> {
            v.startAnimation(animation);
            Time="10 AM : 11 AM";
            FiveToSix.setVisibility(View.INVISIBLE);
            SixToSe.setVisibility(View.INVISIBLE);
        });
        FiveToSix.setOnClickListener(v -> {
            v.startAnimation(animation);
            Time="5 PM : 6 PM";
            TenToEle.setVisibility(View.INVISIBLE);
            SixToSe.setVisibility(View.INVISIBLE);
        });

        SixToSe.setOnClickListener(v -> {
            v.startAnimation(animation);
            Time="6 PM : 7 PM";
            TenToEle.setVisibility(View.INVISIBLE);
            FiveToSix.setVisibility(View.INVISIBLE);
        });

        enRollNow.setOnClickListener(v -> {
            v.startAnimation(animation);
            Intent i =new Intent(getApplicationContext(),PaymentActivity.class);
            i.putExtra("className",cName);
            i.putExtra("teacherName",tName);
            i.putExtra("days",Days);
            i.putExtra("time",Time);
            i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            finish();
            startActivity(i);
        });
    }

}