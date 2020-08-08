package com.UmayYazilim.cocukegitimi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDialogFragment;

public class ToastButtonActivity extends AppCompatDialogFragment {

    private View view;

    public ToastButtonActivity(View view) {
        this.view = view;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(view);

        return builder.create();
    }

}
