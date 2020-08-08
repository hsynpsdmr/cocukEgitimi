package com.UmayYazilim.cocukegitimi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class SayiActivity extends AppCompatActivity implements View.OnClickListener {

    private int width;
    private int height;
    private Button btn;
    private MediaPlayer mediaPlayer;
    private boolean control;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sayi);

        MobileAds.initialize(this, "ca-app-pub-3138086272868027/5021123785");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Display display = getWindowManager(). getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        control = true;
        setButtonAll();
    }

    @Override
    public void onClick(View view) {
        if(control) {
            control = false;
            btn = new Button(getApplicationContext());
            if(mediaPlayer!=null){
                mediaPlayer.release();
            }
            switch (view.getId()) {
                case R.id.sifir:
                    mediaPlayer = MediaPlayer.create(this,R.raw.sifir);
                    break;
                case R.id.bir:
                    mediaPlayer = MediaPlayer.create(this,R.raw.bir);
                    break;
                case R.id.iki:
                    mediaPlayer = MediaPlayer.create(this,R.raw.iki);
                    break;
                case R.id.uc:
                    mediaPlayer = MediaPlayer.create(this,R.raw.uc);
                    break;
                case R.id.dort:
                    mediaPlayer = MediaPlayer.create(this,R.raw.dort);
                    break;
                case R.id.bes:
                    mediaPlayer = MediaPlayer.create(this,R.raw.bes);
                    break;
                case R.id.alti:
                    mediaPlayer = MediaPlayer.create(this,R.raw.alti);
                    break;
                case R.id.yedi:
                    mediaPlayer = MediaPlayer.create(this,R.raw.yedi);
                    break;
                case R.id.sekiz:
                    mediaPlayer = MediaPlayer.create(this,R.raw.sekiz);
                    break;
                case R.id.dokuz:
                    mediaPlayer = MediaPlayer.create(this,R.raw.dokuz);
                    break;
                case R.id.on:
                    mediaPlayer = MediaPlayer.create(this,R.raw.on);
                    break;
            }
            btn.setText(((Button)view).getText().toString());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                btn.setBackground(((Button)findViewById(view.getId())).getBackground());
            }
            btn.setTextSize(240);
            btn.setWidth(width);
            btn.setHeight(height-height/5);
            btn.setTextColor(getResources().getColor(R.color.white));
            final ToastButtonActivity toastButtonActivity = new ToastButtonActivity(btn);
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    control = true;
                    toastButtonActivity.dismiss();
                }
            });
            mediaPlayer.start();
            toastButtonActivity.show(getSupportFragmentManager(),"ToastButtonActivity");
        }
    }

    public void setButtonAll(){
        ((Button)findViewById(R.id.sifir)).setOnClickListener(this);
        ((Button)findViewById(R.id.bir)).setOnClickListener(this);
        ((Button)findViewById(R.id.iki)).setOnClickListener(this);
        ((Button)findViewById(R.id.uc)).setOnClickListener(this);
        ((Button)findViewById(R.id.dort)).setOnClickListener(this);
        ((Button)findViewById(R.id.bes)).setOnClickListener(this);
        ((Button)findViewById(R.id.alti)).setOnClickListener(this);
        ((Button)findViewById(R.id.yedi)).setOnClickListener(this);
        ((Button)findViewById(R.id.sekiz)).setOnClickListener(this);
        ((Button)findViewById(R.id.dokuz)).setOnClickListener(this);
        ((Button)findViewById(R.id.on)).setOnClickListener(this);
    }

}