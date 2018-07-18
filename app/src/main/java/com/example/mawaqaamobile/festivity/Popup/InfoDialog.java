package com.example.mawaqaamobile.festivity.Popup;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageButton;

import com.example.mawaqaamobile.festivity.R;

public class InfoDialog extends Dialog {
    ImageButton close;
    public InfoDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_popup_dialog);
    }
}
