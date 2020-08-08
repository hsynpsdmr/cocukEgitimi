package com.UmayYazilim.cocukegitimi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AracActivity extends AppCompatActivity implements View.OnClickListener {

    private int imageResources;
    private String string;
    private MediaPlayer mediaPlayer;
    private boolean control;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac);

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
            if(mediaPlayer != null) {
                mediaPlayer.release();
            }
            switch (view.getId()) {
                case R.id.ambulans:
                    string = "AMBULANS";
                    imageResources = R.drawable.ambulans;
                    mediaPlayer = MediaPlayer.create(this,R.raw.ambulans);
                    break;
                case R.id.araba:
                    string = "ARABA";
                    imageResources = R.drawable.araba;
                    mediaPlayer = MediaPlayer.create(this,R.raw.araba);
                    break;
                case R.id.bisiklet:
                    string = "BİSİKLET";
                    imageResources = R.drawable.bisiklet;
                    mediaPlayer = MediaPlayer.create(this,R.raw.bisiklet);
                    break;
                case R.id.copKamyonu:
                    string = "ÇÖP KAMYONU";
                    imageResources = R.drawable.cop_kamyon;
                    mediaPlayer = MediaPlayer.create(this,R.raw.copkamyonu);
                    break;
                case R.id.gemi:
                    string = "GEMİ";
                    imageResources = R.drawable.gemi;
                    mediaPlayer = MediaPlayer.create(this,R.raw.gemi);
                    break;
                case R.id.helikopter:
                    string = "HELİKOPTER";
                    imageResources = R.drawable.helikopter;
                    mediaPlayer = MediaPlayer.create(this,R.raw.helikopter);
                    break;
                case R.id.kamyon:
                    string = "KAMYON";
                    imageResources = R.drawable.kamyon;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kamyon);
                    break;
                case R.id.motosiklet:
                    string = "MOTOSİKLET";
                    imageResources = R.drawable.motosiklet;
                    mediaPlayer = MediaPlayer.create(this,R.raw.motosiklet);
                    break;
                case R.id.otobus:
                    string = "OTOBÜS";
                    imageResources = R.drawable.otobus;
                    mediaPlayer = MediaPlayer.create(this,R.raw.otobus);
                    break;
                case R.id.taksi:
                    string = "TAKSİ";
                    imageResources = R.drawable.taksi;
                    mediaPlayer = MediaPlayer.create(this,R.raw.taksi);
                    break;
                case R.id.tren:
                    string = "TREN";
                    imageResources = R.drawable.tren;
                    mediaPlayer = MediaPlayer.create(this,R.raw.tren);
                    break;
                case R.id.ucak:
                    string = "UÇAK";
                    imageResources = R.drawable.ucak;
                    mediaPlayer = MediaPlayer.create(this,R.raw.ucak);
                    break;
                case R.id.tramvay:
                    string = "TRAMVAY";
                    imageResources = R.drawable.tramvay;
                    mediaPlayer = MediaPlayer.create(this,R.raw.tramvay);
                    break;
                case R.id.uzayMekigi:
                    string = "UZAY MEKİĞİ";
                    imageResources = R.drawable.uzay_mekigi;
                    mediaPlayer = MediaPlayer.create(this,R.raw.uzaymakigi);
                    break;
                case R.id.vinc:
                    string = "VİNÇ";
                    imageResources = R.drawable.vinc;
                    mediaPlayer = MediaPlayer.create(this,R.raw.vinc);
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

    private void setLinearLayoutAll() {
        ((LinearLayout)findViewById(R.id.ambulans)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.araba)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.bisiklet)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.copKamyonu)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.gemi)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.helikopter)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kamyon)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.motosiklet)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.otobus)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.taksi)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.tren)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.ucak)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.tramvay)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.uzayMekigi)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.vinc)).setOnClickListener(this);

    }
}