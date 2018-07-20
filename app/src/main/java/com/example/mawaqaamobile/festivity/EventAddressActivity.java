package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class EventAddressActivity extends AppCompatActivity {

    Button addAddress;
    LinearLayout chooseLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_address);

//        handle button clicks
        addAddress = (Button) findViewById(R.id.add_address);
        chooseLocation = (LinearLayout) findViewById(R.id.choose_location_layout);
        chooseLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventAddressActivity.this,ChooseLocationActivity.class));
            }
        });
        addAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EventAddressActivity.this,ReviewPlaceOrderActivity.class));

            }
        });
    }

    public void showCart(View view) {
        startActivity(new Intent(EventAddressActivity.this,CartActivity.class));
    }

    public void showMenu(View view) {
        startActivity(new Intent(EventAddressActivity.this,MenuActivity.class));
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
