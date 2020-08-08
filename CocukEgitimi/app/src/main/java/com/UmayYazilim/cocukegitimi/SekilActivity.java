package com.UmayYazilim.cocukegitimi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class SekilActivity extends AppCompatActivity implements View.OnClickListener {

    private int imageResources;
    private String string;
    private MediaPlayer mediaPlayer;
    private boolean control;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekil);

        MobileAds.initialize(this, "ca-app-pub-3138086272868027/5021123785");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        control = true;
        setLinearLayoutAll();
    }

    @Override
    public void onClick(View view) {
        if(control) {
            control = false;
            if(mediaPlayer!=null) {
                mediaPlayer.release();
            }
            switch (view.getId()) {
                case R.id.yildiz:
                    string = "YILDIZ";
                    imageResources = R.drawable.yildiz;
                    mediaPlayer = MediaPlayer.create(this,R.raw.yildiz);
                    break;
                case R.id.ucgen:
                    string = "ÜÇGEN";
                    imageResources = R.drawable.ucgen;
                    mediaPlayer = MediaPlayer.create(this,R.raw.ucgen);
                    break;
                case R.id.kalp:
                    string = "KALP";
                    imageResources = R.drawable.kalp;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kalp);
                    break;
                case R.id.daire:
                    string = "DAİRE";
                    imageResources = R.drawable.daire;
                    mediaPlayer = MediaPlayer.create(this,R.raw.daire);
                    break;
                case R.id.kare:
                    string = "KARE";
                    imageResources = R.drawable.kare;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kare);
                    break;
                case R.id.eskenardortgen:
                    string = "EŞKENAR DÖRTGEN";
                    imageResources = R.drawable.eskenardortgen;
                    mediaPlayer = MediaPlayer.create(this,R.raw.eskenardortgen);
                    break;
                case R.id.dikdortgen:
                    string = "DİKDÖRTGEN";
                    imageResources = R.drawable.dikdortgen;
                    mediaPlayer = MediaPlayer.create(this,R.raw.dikdortgen);
                    break;
            }
            final ToastLayoutActivity toastLayoutActivity = new ToastLayoutActivity(imageResources,string);
            toastLayoutActivity.show(getSupportFragmentManager(),"ToastLayoutActivity");
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    control = true;
                    toastLayoutActivity.dismiss();
                }
            });
            mediaPlayer.start();
        }
    }

    public void setLinearLayoutAll(){
        ((LinearLayout)findViewById(R.id.yildiz)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.ucgen)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kalp)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.daire)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kare)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.eskenardortgen)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.dikdortgen)).setOnClickListener(this);
    }


}