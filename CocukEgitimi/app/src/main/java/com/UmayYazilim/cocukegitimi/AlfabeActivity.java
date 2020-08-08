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

public class AlfabeActivity extends AppCompatActivity implements View.OnClickListener {

    private int width;
    private int height;
    private Button btn;
    private MediaPlayer mediaPlayer;
    private boolean control;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alfabe);

        MobileAds.initialize(this, "ca-app-pub-3138086272868027/5021123785");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Display display = getWindowManager().getDefaultDisplay();
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
            if(mediaPlayer!=null) {
                mediaPlayer.release();
            }
            switch (view.getId()) {
                case R.id.harfA:
                    mediaPlayer = MediaPlayer.create(this,R.raw.a);
                    break;
                case R.id.harfB:
                    mediaPlayer = MediaPlayer.create(this,R.raw.b);
                    break;
                case R.id.harfC:
                    mediaPlayer = MediaPlayer.create(this,R.raw.c);
                    break;
                case R.id.harfÇ:
                    mediaPlayer = MediaPlayer.create(this,R.raw.c2);
                    break;
                case R.id.harfD:
                    mediaPlayer = MediaPlayer.create(this,R.raw.d);
                    break;
                case R.id.harfE:
                    mediaPlayer = MediaPlayer.create(this,R.raw.e);
                    break;
                case R.id.harfF:
                    mediaPlayer = MediaPlayer.create(this,R.raw.f);
                    break;
                case R.id.harfG:
                    mediaPlayer = MediaPlayer.create(this,R.raw.g);
                    break;
                case R.id.harfĞ:
                    mediaPlayer = MediaPlayer.create(this,R.raw.g2);
                    break;
                case R.id.harfH:
                    mediaPlayer = MediaPlayer.create(this,R.raw.h);
                    break;
                case R.id.harfI:
                    mediaPlayer = MediaPlayer.create(this,R.raw.i2);
                    break;
                case R.id.harfİ:
                    mediaPlayer = MediaPlayer.create(this,R.raw.i);
                    break;
                case R.id.harfJ:
                    mediaPlayer = MediaPlayer.create(this,R.raw.j);
                    break;
                case R.id.harfK:
                    mediaPlayer = MediaPlayer.create(this,R.raw.k);
                    break;
                case R.id.harfL:
                    mediaPlayer = MediaPlayer.create(this,R.raw.l);
                    break;
                case R.id.harfM:
                    mediaPlayer = MediaPlayer.create(this,R.raw.m);
                    break;
                case R.id.harfN:
                    mediaPlayer = MediaPlayer.create(this,R.raw.n);
                    break;
                case R.id.harfO:
                    mediaPlayer = MediaPlayer.create(this,R.raw.o);
                    break;
                case R.id.harfÖ:
                    mediaPlayer = MediaPlayer.create(this,R.raw.o2);
                    break;
                case R.id.harfP:
                    mediaPlayer = MediaPlayer.create(this,R.raw.p);
                    break;
                case R.id.harfR:
                    mediaPlayer = MediaPlayer.create(this,R.raw.r);
                    break;
                case R.id.harfS:
                    mediaPlayer = MediaPlayer.create(this,R.raw.s);
                    break;
                case R.id.harfŞ:
                    mediaPlayer = MediaPlayer.create(this,R.raw.s2);
                    break;
                case R.id.harfT:
                    mediaPlayer = MediaPlayer.create(this,R.raw.t);
                    break;
                case R.id.harfU:
                    mediaPlayer = MediaPlayer.create(this,R.raw.u);
                    break;
                case R.id.harfÜ:
                    mediaPlayer = MediaPlayer.create(this,R.raw.u2);
                    break;
                case R.id.harfV:
                    mediaPlayer = MediaPlayer.create(this,R.raw.v);
                    break;
                case R.id.harfY:
                    mediaPlayer = MediaPlayer.create(this,R.raw.y);
                    break;
                case R.id.harfZ:
                    mediaPlayer = MediaPlayer.create(this,R.raw.z);
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

    public void setButtonAll(){
        ((Button)findViewById(R.id.harfA)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfB)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfC)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfÇ)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfD)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfE)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfF)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfG)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfĞ)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfH)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfI)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfİ)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfJ)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfK)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfL)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfM)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfN)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfO)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfÖ)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfP)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfR)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfS)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfŞ)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfT)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfU)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfÜ)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfV)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfY)).setOnClickListener(this);
        ((Button)findViewById(R.id.harfZ)).setOnClickListener(this);
    }
}