package com.UmayYazilim.cocukegitimi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MeslekActivity extends AppCompatActivity implements View.OnClickListener {

    private int imageResources;
    private String string;
    private MediaPlayer mediaPlayer;
    private boolean control;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meslek);

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
                case R.id.asci:
                    string = "AŞÇI";
                    imageResources = R.drawable.asci;
                    mediaPlayer = MediaPlayer.create(this,R.raw.asci);
                    break;
                case R.id.asker:
                    string = "ASKER";
                    imageResources = R.drawable.asker;
                    mediaPlayer = MediaPlayer.create(this,R.raw.asker);
                    break;
                case R.id.bilimAdami:
                    string = "BİLİM İNSANI";
                    imageResources = R.drawable.bilim_adami;
                    mediaPlayer = MediaPlayer.create(this,R.raw.biliminsani);
                    break;
                case R.id.ciftci:
                    string = "ÇİFTÇİ";
                    imageResources = R.drawable.ciftci;
                    mediaPlayer = MediaPlayer.create(this,R.raw.ciftci);
                    break;
                case R.id.dedektif:
                    string = "DEDEKTİF";
                    imageResources = R.drawable.dedektif;
                    mediaPlayer = MediaPlayer.create(this,R.raw.dedektif);
                    break;
                case R.id.doktor:
                    string = "DOKTOR";
                    imageResources = R.drawable.doktor;
                    mediaPlayer = MediaPlayer.create(this,R.raw.doktor);
                    break;
                case R.id.fotografci:
                    string = "FOTOĞRAFÇI";
                    imageResources = R.drawable.fotografci;
                    mediaPlayer = MediaPlayer.create(this,R.raw.fotografci);
                    break;
                case R.id.garson:
                    string = "GARSON";
                    imageResources = R.drawable.garson;
                    mediaPlayer = MediaPlayer.create(this,R.raw.garson);
                    break;
                case R.id.hemsire:
                    string = "HEMŞİRE";
                    imageResources = R.drawable.hemsire;
                    mediaPlayer = MediaPlayer.create(this,R.raw.hemsire);
                    break;
                case R.id.hostes:
                    string = "HOSTES";
                    imageResources = R.drawable.hostes;
                    mediaPlayer = MediaPlayer.create(this,R.raw.hostes);
                    break;
                case R.id.itfaiyeci:
                    string = "İTFAİYECİ";
                    imageResources = R.drawable.itfaiyeci;
                    mediaPlayer = MediaPlayer.create(this,R.raw.itfaiyeci);
                    break;
                case R.id.kuafor:
                    string = "KUAFÖR";
                    imageResources = R.drawable.kuafor;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kuafor);
                    break;
                case R.id.mimar:
                    string = "MİMAR";
                    imageResources = R.drawable.mimar;
                    mediaPlayer = MediaPlayer.create(this,R.raw.mimar);
                    break;
                case R.id.ogretmen:
                    string = "ÖĞRETMEN";
                    imageResources = R.drawable.ogretmen;
                    mediaPlayer = MediaPlayer.create(this,R.raw.ogretmen);
                    break;
                case R.id.pilot:
                    string = "PİLOT";
                    imageResources = R.drawable.pilot;
                    mediaPlayer = MediaPlayer.create(this,R.raw.pilot);
                    break;
                case R.id.polis:
                    string = "POLİS";
                    imageResources = R.drawable.polis;
                    mediaPlayer = MediaPlayer.create(this,R.raw.polis);
                    break;
                case R.id.postaci:
                    string = "POSTACI";
                    imageResources = R.drawable.postaci;
                    mediaPlayer = MediaPlayer.create(this,R.raw.postaci);
                    break;
                case R.id.ressam:
                    string = "RESSAM";
                    imageResources = R.drawable.ressam;
                    mediaPlayer = MediaPlayer.create(this,R.raw.ressam);
                    break;
                case R.id.sarkici:
                    string = "ŞARKICI";
                    imageResources = R.drawable.sarkici;
                    mediaPlayer = MediaPlayer.create(this,R.raw.sarkici);
                    break;
                case R.id.tamirci:
                    string = "TAMİRCİ";
                    imageResources = R.drawable.tamirci;
                    mediaPlayer = MediaPlayer.create(this,R.raw.tamirci);
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

    public void setLinearLayoutAll() {
        ((LinearLayout)findViewById(R.id.asci)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.asker)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.bilimAdami)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.ciftci)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.dedektif)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.doktor)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.fotografci)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.garson)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.hemsire)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.hostes)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.itfaiyeci)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kuafor)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.mimar)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.ogretmen)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.pilot)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.polis)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.postaci)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.ressam)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.sarkici)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.tamirci)).setOnClickListener(this);
    }
}