package com.example.mawaqaamobile.festivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mawaqaamobile.festivity.Adapters.MostSellingRecyclerViewAdapter;
import com.example.mawaqaamobile.festivity.Adapters.PackageListingRecyclerViewAdapter;

public class PackageListingActivity extends AppCompatActivity {

    PackageListingRecyclerViewAdapter packageListingRecyclerViewAdapter;
    RecyclerView packageListingRecyclerView;
    LinearLayoutManager packageListingLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_listing);


        packageListingRecyclerView = (RecyclerView) findViewById(R.id.packages_list_recycler_view);
        packageListingRecyclerView.setHasFixedSize(true);

        packageListingLayoutManager = new LinearLayoutManager(this);
        packageListingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        packageListingRecyclerView.setLayoutManager(packageListingLayoutManager);
        packageListingRecyclerViewAdapter = new PackageListingRecyclerViewAdapter(this);
        packageListingRecyclerView.setAdapter(packageListingRecyclerViewAdapter);
    }
}
