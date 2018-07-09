package com.example.mawaqaamobile.festivity;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.mawaqaamobile.festivity.Adapters.MostSellingRecyclerViewAdapter;
import com.example.mawaqaamobile.festivity.Adapters.PackageListingRecyclerViewAdapter;

public class PackageListingActivity extends AppCompatActivity {
    ImageButton cartButton,menuButton,serviceButton;
    PackageListingRecyclerViewAdapter packageListingRecyclerViewAdapter;
    RecyclerView packageListingRecyclerView;
    LinearLayoutManager packageListingLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_listing);

        serviceButton = (ImageButton) findViewById(R.id.service);
        cartButton = (ImageButton) findViewById(R.id.cart_button);
        menuButton = (ImageButton) findViewById(R.id.menu_button);
        serviceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PackageListingActivity.this,ServiceCategoryActivity.class));
            }
        });
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PackageListingActivity.this,CartActivity.class));
            }
        });
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PackageListingActivity.this,MenuActivity.class));

            }
        });
        packageListingRecyclerView = (RecyclerView) findViewById(R.id.packages_list_recycler_view);
        packageListingRecyclerView.setHasFixedSize(true);

        packageListingLayoutManager = new LinearLayoutManager(this);
        packageListingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        packageListingRecyclerView.setLayoutManager(packageListingLayoutManager);
        packageListingRecyclerViewAdapter = new PackageListingRecyclerViewAdapter(this);
        packageListingRecyclerView.setAdapter(packageListingRecyclerViewAdapter);
    }
}
