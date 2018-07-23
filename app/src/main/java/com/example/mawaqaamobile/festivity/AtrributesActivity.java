package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class AtrributesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atrributes);
    }

    public void applyChanges(View view) {
        AtrributesActivity.this.finish();
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));


    }
}
