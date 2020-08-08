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

public class RenkActivity extends AppCompatActivity implements View.OnClickListener {

    private int width;
    private int height;
    private Button btn;
    private MediaPlayer mediaPlayer;
    private boolean control;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renk);

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
            if(mediaPlayer !=null) {
                mediaPlayer.release();
            }
            switch (view.getId()) {
                case R.id.kirmizi:
                    mediaPlayer = MediaPlayer.create(this,R.raw.kirmizi);
                    break;
                case R.id.sari:
                    mediaPlayer = MediaPlayer.create(this,R.raw.sari);
                    break;
                case R.id.yesil:
                    mediaPlayer = MediaPlayer.create(this,R.raw.yesil);
                    break;
                case R.id.kahverengi:
                    mediaPlayer = MediaPlayer.create(this,R.raw.kahverengi);
                    break;
                case R.id.beyaz:
                    mediaPlayer = MediaPlayer.create(this,R.raw.beyaz);
                    break;
                case R.id.siyah:
                    mediaPlayer = MediaPlayer.create(this,R.raw.siyah);
                    break;
                case R.id.turuncu:
                    mediaPlayer = MediaPlayer.create(this,R.raw.turuncu);
                    break;
                case R.id.koyuMavi:
                    mediaPlayer = MediaPlayer.create(this,R.raw.lacivert);
                    break;
                case R.id.pembe:
                    mediaPlayer = MediaPlayer.create(this,R.raw.pembe);
                    break;
                case R.id.mavi:
                    mediaPlayer = MediaPlayer.create(this,R.raw.mavi);
                    break;
                case R.id.mor:
                    mediaPlayer = MediaPlayer.create(this,R.raw.mor);
                    break;
                case R.id.gri:
                    mediaPlayer = MediaPlayer.create(this,R.raw.gri);
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
            toastButtonActivity.show(getSupportFragmentManager(),"ToastButtonActivity");
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    control = true;
                    toastButtonActivity.dismiss();
                }
            });
        }
    }

    private void setButtonAll() {
        ((Button)findViewById(R.id.kirmizi)).setOnClickListener(this);
        ((Button)findViewById(R.id.yesil)).setOnClickListener(this);
        ((Button)findViewById(R.id.mavi)).setOnClickListener(this);
        ((Button)findViewById(R.id.gri)).setOnClickListener(this);
        ((Button)findViewById(R.id.koyuMavi)).setOnClickListener(this);
        ((Button)findViewById(R.id.turuncu)).setOnClickListener(this);
        ((Button)findViewById(R.id.kahverengi)).setOnClickListener(this);
        ((Button)findViewById(R.id.beyaz)).setOnClickListener(this);
        ((Button)findViewById(R.id.pembe)).setOnClickListener(this);
        ((Button)findViewById(R.id.mor)).setOnClickListener(this);
        ((Button)findViewById(R.id.sari)).setOnClickListener(this);
        ((Button)findViewById(R.id.siyah)).setOnClickListener(this);

    }

}
