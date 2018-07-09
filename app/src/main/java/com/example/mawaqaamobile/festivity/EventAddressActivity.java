package com.example.mawaqaamobile.festivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class EventAddressActivity extends AppCompatActivity {

    Button addAddress;
    LinearLayout chooseLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_address);
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
}
