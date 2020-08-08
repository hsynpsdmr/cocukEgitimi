package com.UmayYazilim.cocukegitimi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MeyvesebzeActivity extends AppCompatActivity implements View.OnClickListener {

    private int imageResources;
    private String string;
    private MediaPlayer mediaPlayer;
    private boolean control;
    private AdView mAdView;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meyvesebze);

        MobileAds.initialize(this, "ca-app-pub-3138086272868027/5021123785");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Display display = getWindowManager(). getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        height = size.y;

        control = true;
        setLinearLayoutAll();
    }

    @Override
    public void onClick(View view) {
        if(control){
            control = false;
            if(mediaPlayer != null){
                mediaPlayer.release();
            }
            switch (view.getId()) {
                case R.id.kivi:
                    string = "KİVİ";
                    imageResources = R.drawable.kivi;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kivi);
                    break;
                case R.id.ananas:
                    string = "ANANAS";
                    imageResources = R.drawable.ananas;
                    mediaPlayer = MediaPlayer.create(this,R.raw.ananas);
                    break;
                case R.id.armut:
                    string = "ARMUT";
                    imageResources = R.drawable.armut;
                    mediaPlayer = MediaPlayer.create(this,R.raw.armut);
                    break;
                case R.id.bezelye:
                    string = "BEZELYE";
                    imageResources = R.drawable.bezelye;
                    mediaPlayer = MediaPlayer.create(this,R.raw.bezelye);
                    break;
                case R.id.biber:
                    string = "BİBER";
                    imageResources = R.drawable.biber;
                    mediaPlayer = MediaPlayer.create(this,R.raw.biber);
                    break;
                case R.id.cilek:
                    string = "ÇİLEK";
                    imageResources = R.drawable.cilek;
                    mediaPlayer = MediaPlayer.create(this,R.raw.cilek);
                    break;
                case R.id.domates:
                    string = "DOMATES";
                    imageResources = R.drawable.domates;
                    mediaPlayer = MediaPlayer.create(this,R.raw.domates);
                    break;
                case R.id.elma:
                    string = "ELMA";
                    imageResources = R.drawable.elma;
                    mediaPlayer = MediaPlayer.create(this,R.raw.elma);
                    break;
                case R.id.havuc:
                    string = "HAVUÇ";
                    imageResources = R.drawable.havuc;
                    mediaPlayer = MediaPlayer.create(this,R.raw.havuc);
                    break;
                case R.id.hindistanCevizi:
                    string = "HİNDİSTAN CEVİZİ";
                    imageResources = R.drawable.hindistan_cevizi;
                    mediaPlayer = MediaPlayer.create(this,R.raw.hindistancevizi);
                    break;
                case R.id.kabak:
                    string = "KABAK";
                    imageResources = R.drawable.kabak;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kabak);
                    break;
                case R.id.karpuz:
                    string = "KARPUZ";
                    imageResources = R.drawable.karpuz;
                    mediaPlayer = MediaPlayer.create(this,R.raw.karpuz);
                    break;
                case R.id.kavun:
                    string = "KAVUN";
                    imageResources = R.drawable.kavun;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kavun);
                    break;
                case R.id.marul:
                    string = "MARUL";
                    imageResources = R.drawable.marul;
                    mediaPlayer = MediaPlayer.create(this,R.raw.marul);
                    break;
                case R.id.portakal:
                    string = "PORTAKAL";
                    imageResources = R.drawable.portakal;
                    mediaPlayer = MediaPlayer.create(this,R.raw.portakal);
                    break;
                case R.id.uzum:
                    string = "ÜZÜM";
                    imageResources = R.drawable.uzum;
                    mediaPlayer = MediaPlayer.create(this,R.raw.uzum);
                    break;
                case R.id.kiraz:
                    string = "KİRAZ";
                    imageResources = R.drawable.kiraz;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kiraz);
                    break;
                case R.id.patlican:
                    string = "PATLICAN";
                    imageResources = R.drawable.patlican;
                    mediaPlayer = MediaPlayer.create(this,R.raw.patlican);
                    break;
                case R.id.limon:
                    string = "LİMON";
                    imageResources = R.drawable.limon;
                    mediaPlayer = MediaPlayer.create(this,R.raw.limon);
                    break;
                case R.id.muz:
                    string = "MUZ";
                    imageResources = R.drawable.muz;
                    mediaPlayer = MediaPlayer.create(this,R.raw.muz);
                    break;
            }
            final ToastLayoutActivity toastLayoutActivity = new ToastLayoutActivity(height,imageResources,string);
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


    public void setLinearLayoutAll(){
        ((LinearLayout)findViewById(R.id.ananas)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.armut)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.bezelye)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.biber)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.cilek)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.domates)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.elma)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.havuc)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.hindistanCevizi)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kabak)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.karpuz)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kavun)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.marul)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.portakal)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kivi)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.uzum)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kiraz)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.patlican)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.limon)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.muz)).setOnClickListener(this);

    }

}