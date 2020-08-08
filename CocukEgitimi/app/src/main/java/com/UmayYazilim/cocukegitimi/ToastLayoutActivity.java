package com.UmayYazilim.cocukegitimi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.Timer;
import java.util.TimerTask;

public class ToastLayoutActivity extends AppCompatDialogFragment {

    private int height;
    private int imageResources;
    private String string;

    private Handler handler;
    private float current;

    public ToastLayoutActivity(int height, int imageResources, String string) {
        this.height = height;
        this.imageResources = imageResources;
        this.string = string;
        this.handler = new Handler();
        current = 0;
    }

    public ToastLayoutActivity(int imageResources, String string) {
        this.imageResources = imageResources;
        this.string = string;
        this.handler = new Handler();
        current = 0;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.activity_toast,null);

        if(this.height != -1){
            view.setMinimumHeight(height - height/5);
        }

        ((ImageView)view.findViewById(R.id.toast_image)).setImageResource(imageResources);

        builder.setView(view);

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if(string.length()==current) {
                            view.findViewById(R.id.toast_image).setRotation(360);
                            timer.cancel();
                        }else {
                            if (current == (int)current) {
                                ((TextView)view.findViewById(R.id.toast_text)).setText(((TextView)view.findViewById(R.id.toast_text)).getText().toString()+string.charAt((int)current));
                            }
                            view.findViewById(R.id.toast_image).setRotation(view.findViewById(R.id.toast_image).getRotation()+(0.25f*360/string.length()));
                        }
                        current += 0.25;
                    }
                });
            }
        }, 0, 75);

        return builder.create();
    }
}
