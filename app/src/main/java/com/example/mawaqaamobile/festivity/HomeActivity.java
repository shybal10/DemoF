package com.example.mawaqaamobile.festivity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mawaqaamobile.festivity.Adapters.FeaturedServicesRecyclerViewAdapter;
import com.example.mawaqaamobile.festivity.Adapters.HistoryRecyclerviewAdapter;
import com.example.mawaqaamobile.festivity.Adapters.MostSellingRecyclerViewAdapter;
import com.example.mawaqaamobile.festivity.Screens.AreaScreenActivity;
import com.example.mawaqaamobile.festivity.Screens.DateScreenActivity;

public class HomeActivity extends AppCompatActivity {

    RelativeLayout exploreArea,exploreDate,packageArea,packageDate;
    ImageButton menu,cart,service;
    Button packagesSearch,exploreSearch,packagesButton,exploreButton;
    RecyclerView featuredServicesRecyclerView,mostSellingRecyclerView;
    FeaturedServicesRecyclerViewAdapter featuredServicesRecyclerViewAdapter;
    MostSellingRecyclerViewAdapter mostSellingRecyclerViewAdapter;
    LinearLayoutManager featuredServicesLinearLayoutManager,mostSellingLinearLayoutManager;
    LinearLayout profile,exploreOptions,packageOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        exploreOptions = (LinearLayout) findViewById(R.id.explore_options);
        packageOptions = (LinearLayout) findViewById(R.id.packages_options);
        exploreArea = (RelativeLayout) findViewById(R.id.explore_area_layout);
        exploreArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AreaScreenActivity.class));
            }
        });
        packageArea = (RelativeLayout) findViewById(R.id.package_area_layout);
        packageArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AreaScreenActivity.class));
            }
        });
        exploreDate = (RelativeLayout) findViewById(R.id.explore_date_layout);
        exploreDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DateScreenActivity.class));

            }
        });
        packageDate = (RelativeLayout) findViewById(R.id.package_date_layout);
        packageDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DateScreenActivity.class));

            }
        });
        menu = (ImageButton) findViewById(R.id.menu_button);
        cart = (ImageButton) findViewById(R.id.cart_button);
        service = (ImageButton) findViewById(R.id.service);
        packagesSearch = (Button) findViewById(R.id.packages_search_button);
        exploreSearch = (Button) findViewById(R.id.explore_search_button);
        exploreButton = (Button) findViewById(R.id.explore_button);
        packagesButton = (Button) findViewById(R.id.packages_button);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,CartActivity.class));

            }
        });
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ServiceCategoryActivity.class));
            }
        });
        exploreSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ServiceListingActivity.class));
            }
        });
        exploreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exploreOptions.setVisibility(View.VISIBLE);
                packageOptions.setVisibility(View.GONE);
                exploreButton.setBackgroundResource(R.drawable.switchbg);
                exploreButton.setTextColor(HomeActivity.this.getResources().getColor(R.color.white));

                packagesButton.setBackgroundResource(0);
                packagesButton.setTextColor(HomeActivity.this.getResources().getColor(R.color.orange));
            }
        });

        packagesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                packageOptions.setVisibility(View.VISIBLE);
                exploreOptions.setVisibility(View.GONE);

                packagesButton.setBackgroundResource(R.drawable.switchbg);
                packagesButton.setTextColor(HomeActivity.this.getResources().getColor(R.color.white));

                exploreButton.setBackgroundResource(0);
                exploreButton.setTextColor(HomeActivity.this.getResources().getColor(R.color.orange));
            }
        });

        packagesSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,PackageListingActivity.class));
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,MenuActivity.class));
            }
        });

        profile = (LinearLayout) findViewById(R.id.profile_name_layout);
        profile.setClickable(true);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ProfilePageActivity.class));
            }
        });


        //featured services
        featuredServicesRecyclerView = (RecyclerView) findViewById(R.id.featured_services_recycler_view);
        featuredServicesRecyclerView.setHasFixedSize(true);

        featuredServicesLinearLayoutManager = new LinearLayoutManager(this);
        featuredServicesLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        featuredServicesRecyclerView.setLayoutManager(featuredServicesLinearLayoutManager);
        featuredServicesRecyclerViewAdapter = new FeaturedServicesRecyclerViewAdapter();
        featuredServicesRecyclerView.setAdapter(featuredServicesRecyclerViewAdapter);


        //most selling
        mostSellingRecyclerView = (RecyclerView) findViewById(R.id.most_selling_recycler_view);
        mostSellingRecyclerView.setHasFixedSize(true);
        mostSellingLinearLayoutManager = new LinearLayoutManager(this);
        mostSellingLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mostSellingRecyclerView.setLayoutManager(mostSellingLinearLayoutManager);
        mostSellingRecyclerViewAdapter = new MostSellingRecyclerViewAdapter();
        mostSellingRecyclerView.setAdapter(mostSellingRecyclerViewAdapter);
    }

}
