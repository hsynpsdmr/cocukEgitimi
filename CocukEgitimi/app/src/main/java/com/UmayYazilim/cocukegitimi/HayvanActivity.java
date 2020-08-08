package com.UmayYazilim.cocukegitimi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class HayvanActivity extends AppCompatActivity implements View.OnClickListener{

    private int imageResources;
    private String string;
    private MediaPlayer mediaPlayer;
    private boolean control;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hayvan);

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
                case R.id.karinca:
                    string = "KARINCA";
                    imageResources = R.drawable.ant;
                    mediaPlayer = MediaPlayer.create(this,R.raw.karinca);
                    break;
                case R.id.kelebek:
                    string = "KELEBEK";
                    imageResources = R.drawable.butterfly;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kelebek);
                    break;
                case R.id.kedi:
                    string = "KEDİ";
                    imageResources = R.drawable.cat;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kedi);
                    break;
                case R.id.horoz:
                    string = "HOROZ";
                    imageResources = R.drawable.cock;
                    mediaPlayer = MediaPlayer.create(this,R.raw.horoz);
                    break;
                case R.id.kopek:
                    string = "KÖPEK";
                    imageResources = R.drawable.dog;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kopek);
                    break;
                case R.id.ordek:
                    string = "ÖRDEK";
                    imageResources = R.drawable.duck;
                    mediaPlayer = MediaPlayer.create(this,R.raw.ordek);
                    break;
                case R.id.fil:
                    string = "FİL";
                    imageResources = R.drawable.elephant;
                    mediaPlayer = MediaPlayer.create(this,R.raw.fil);
                    break;
                case R.id.balik:
                    string = "BALIK";
                    imageResources = R.drawable.fish;
                    mediaPlayer = MediaPlayer.create(this,R.raw.balik);
                    break;
                case R.id.kurbaga:
                    string = "KURBAĞA";
                    imageResources = R.drawable.frog;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kurbaga);
                    break;
                case R.id.zurafa:
                    string = "ZÜRAFA";
                    imageResources = R.drawable.giraffe;
                    mediaPlayer = MediaPlayer.create(this,R.raw.zurafa);
                    break;
                case R.id.kirpi:
                    string = "KİRPİ";
                    imageResources = R.drawable.hedgehog;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kirpi);
                    break;
                case R.id.at:
                    string = "AT";
                    imageResources = R.drawable.horse;
                    mediaPlayer = MediaPlayer.create(this,R.raw.at);
                    break;
                case R.id.kanguru:
                    string = "KANGURU";
                    imageResources = R.drawable.kangaroo;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kanguru);
                    break;
                case R.id.aslan:
                    string = "ASLAN";
                    imageResources = R.drawable.lion;
                    mediaPlayer = MediaPlayer.create(this,R.raw.aslan);
                    break;
                case R.id.maymun:
                    string = "MAYMUN";
                    imageResources = R.drawable.monkey;
                    mediaPlayer = MediaPlayer.create(this,R.raw.maymun);
                    break;
                case R.id.panda:
                    string = "PANDA";
                    imageResources = R.drawable.panda;
                    mediaPlayer = MediaPlayer.create(this,R.raw.panda);
                    break;
                case R.id.penguen:
                    string = "PENGUEN";
                    imageResources = R.drawable.penguin;
                    mediaPlayer = MediaPlayer.create(this,R.raw.penguen);
                    break;
                case R.id.tavsan:
                    string = "TAVŞAN";
                    imageResources = R.drawable.rabbit;
                    mediaPlayer = MediaPlayer.create(this,R.raw.tavsan);
                    break;
                case R.id.kaplan:
                    string = "KAPLAN";
                    imageResources = R.drawable.tiger;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kaplan);
                    break;
                case R.id.kablumbaga:
                    string = "KAPLUMBAĞA";
                    imageResources = R.drawable.turtle;
                    mediaPlayer = MediaPlayer.create(this,R.raw.kaplumbaga);
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

    public void setLinearLayoutAll(){
        ((LinearLayout)findViewById(R.id.karinca)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kelebek)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kedi)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.horoz)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kopek)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.ordek)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.fil)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.balik)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kurbaga)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.zurafa)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kirpi)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.at)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kanguru)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.aslan)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.maymun)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.panda)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.penguen)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.tavsan)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kaplan)).setOnClickListener(this);
        ((LinearLayout)findViewById(R.id.kablumbaga)).setOnClickListener(this);
    }
}