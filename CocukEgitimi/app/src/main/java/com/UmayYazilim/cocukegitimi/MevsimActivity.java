package com.UmayYazilim.cocukegitimi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MevsimActivity extends AppCompatActivity implements View.OnClickListener {

    private int imageResources;
    private MediaPlayer mediaPlayer;
    private boolean control;
    private AdView mAdView;
    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mevsim);

        MobileAds.initialize(this, "ca-app-pub-3138086272868027/5021123785");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        control = true;
        setImageViewAll();
    }

    @Override
    public void onClick(View view) {
        if(control) {
            control = false;
            if(mediaPlayer!=null) {
                mediaPlayer.release();
            }
            switch (view.getId()) {
                case R.id.sonbahar:
                    string = "SONBAHAR";
                    imageResources = R.drawable.sonbahar;
                    mediaPlayer = MediaPlayer.create(this,R.raw.sonbahar);
                    break;
                case R.id.ilkbahar:
                    string = "İLKBAHAR";
                    imageResources = R.drawable.ilkbahar;
                    mediaPlayer = MediaPlayer.create(this,R.raw.ilkbahar);
                    break;
                case R.id.yaz:
                    string = "YAZ";
                    imageResources = R.drawable.yaz;
                    mediaPlayer = MediaPlayer.create(this,R.raw.yaz);
                    break;
                case R.id.kis:
                    string = "KIŞ";
                    imageResources = R.drawable.kis;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kis);
                    break;
            }
            final ToastLayoutActivity toastLayoutActivity = new ToastLayoutActivity(imageResources,string);
            toastLayoutActivity.show(getSupportFragmentManager(),"ToastLayoutActivity");
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    toastLayoutActivity.dismiss();
                    control = true;
                }
            });
            mediaPlayer.start();
        }
    }

    private void setImageViewAll() {
        ((ImageView)findViewById(R.id.sonbahar)).setOnClickListener(this);
        ((ImageView)findViewById(R.id.kis)).setOnClickListener(this);
        ((ImageView)findViewById(R.id.ilkbahar)).setOnClickListener(this);
        ((ImageView)findViewById(R.id.yaz)).setOnClickListener(this);
    }
}