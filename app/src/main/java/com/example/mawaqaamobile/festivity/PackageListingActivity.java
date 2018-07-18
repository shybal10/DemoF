package com.example.mawaqaamobile.festivity;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.mawaqaamobile.festivity.Adapters.MostSellingRecyclerViewAdapter;
import com.example.mawaqaamobile.festivity.Adapters.PackageListingRecyclerViewAdapter;
import com.example.mawaqaamobile.festivity.Fragments.FilterFragment;

public class PackageListingActivity extends AppCompatActivity {
    FilterFragment filterFragment;
    ImageButton cartButton,menuButton,serviceButton,filterButton;
    PackageListingRecyclerViewAdapter packageListingRecyclerViewAdapter;
    RecyclerView packageListingRecyclerView;
    LinearLayoutManager packageListingLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_listing);
        initialiseResources();

//        handle button clicks
        filterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFilterScreen();
            }
        });
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

        setupPackageListingRecyclerView();
    }
    private void openFilterScreen() {
        filterFragment = new FilterFragment();
        getFragmentManager().beginTransaction().replace(R.id.filter_container,filterFragment).addToBackStack("FilterFragment").commit();

    }
    private void initialiseResources() {
        filterButton = (ImageButton) findViewById(R.id.filter_button);
        cartButton = (ImageButton) findViewById(R.id.cart_button);
        menuButton = (ImageButton) findViewById(R.id.menu_button);
        serviceButton = (ImageButton) findViewById(R.id.service);
    }
    private void setupPackageListingRecyclerView() {
        packageListingRecyclerView = (RecyclerView) findViewById(R.id.packages_list_recycler_view);
        packageListingRecyclerView.setHasFixedSize(true);
        packageListingLayoutManager = new LinearLayoutManager(this);
        packageListingLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        packageListingRecyclerView.setLayoutManager(packageListingLayoutManager);
        packageListingRecyclerViewAdapter = new PackageListingRecyclerViewAdapter(this);
        packageListingRecyclerView.setAdapter(packageListingRecyclerViewAdapter);
    }

    public void searchAgain(View view) {
        Intent i = new Intent(PackageListingActivity.this,SearchAgainActivity.class);
        i.putExtra("searchPackages",true);
        startActivity(i);
    }
}
