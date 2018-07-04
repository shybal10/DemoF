package com.example.mawaqaamobile.festivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mawaqaamobile.festivity.Adapters.ServiceListingRecViewAdapter;

public class ServiceListingActivity extends AppCompatActivity {
    RecyclerView serviceListingRecyclerView;
    ServiceListingRecViewAdapter serviceListingRecViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_listing);
        serviceListingRecyclerView = (RecyclerView) findViewById(R.id.service_listing_recycler_view);
        serviceListingRecViewAdapter = new ServiceListingRecViewAdapter();

        serviceListingRecyclerView.setHasFixedSize(true);
        serviceListingRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        serviceListingRecyclerView.setAdapter(serviceListingRecViewAdapter);
    }
}
