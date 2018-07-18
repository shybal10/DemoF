package com.example.mawaqaamobile.festivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mawaqaamobile.festivity.Adapters.PackageServicesRecyclerViewAdapter;

public class PackageServicesActivity extends AppCompatActivity {

    PackageServicesRecyclerViewAdapter packageServicesRecyclerViewAdapter;
    RecyclerView packageServicesRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_services);
        packageServicesRecyclerViewAdapter = new PackageServicesRecyclerViewAdapter();
        packageServicesRecyclerView  = (RecyclerView) findViewById(R.id.services_recycler_view);
        packageServicesRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        packageServicesRecyclerView.setLayoutManager(linearLayoutManager);
        packageServicesRecyclerView.setAdapter(packageServicesRecyclerViewAdapter);
    }

    public void addPackageToCart(View view) {
        finish();
    }
}
