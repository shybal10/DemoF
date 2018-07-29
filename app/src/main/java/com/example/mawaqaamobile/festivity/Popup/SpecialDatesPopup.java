package com.example.mawaqaamobile.festivity.Popup;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageButton;

import com.example.mawaqaamobile.festivity.R;

public class SpecialDatesPopup extends Dialog  {
    ImageButton close;
    public SpecialDatesPopup(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.special_dates_popup_dialog);
    }
}
