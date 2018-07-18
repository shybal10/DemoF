package com.example.mawaqaamobile.festivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AtrributesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atrributes);
    }

    public void applyChanges(View view) {
        AtrributesActivity.this.finish();
    }
}
