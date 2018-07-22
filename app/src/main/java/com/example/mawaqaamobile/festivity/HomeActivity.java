package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.content.Intent;
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
import com.example.mawaqaamobile.festivity.Adapters.MostSellingRecyclerViewAdapter;
import com.example.mawaqaamobile.festivity.Screens.DateScreenActivity;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class HomeActivity extends AppCompatActivity implements FeaturedServicesRecyclerViewAdapter.FeaturedServicesListItemClickListener,MostSellingRecyclerViewAdapter.MostSellingListItemClickListener {

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

//        explore options
        exploreArea = (RelativeLayout) findViewById(R.id.explore_area_layout);
        exploreArea.setOnClickListener(new View.OnClickListener() {
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
        exploreSearch = (Button) findViewById(R.id.explore_search_button);
        exploreSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ServiceCategoryActivity.class));
            }
        });
        exploreButton = (Button) findViewById(R.id.explore_button);
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

//        package options
        packageArea = (RelativeLayout) findViewById(R.id.package_area_layout);
        packageArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, AreaScreenActivity.class));
            }
        });
        packageDate = (RelativeLayout) findViewById(R.id.package_date_layout);
        packageDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, DateScreenActivity.class));

            }
        });
        packagesSearch = (Button) findViewById(R.id.packages_search_button);
        packagesSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,PackageListingActivity.class));
            }
        });
        packagesButton = (Button) findViewById(R.id.packages_button);
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

//        other button options
        menu = (ImageButton) findViewById(R.id.menu_button);
        cart = (ImageButton) findViewById(R.id.cart_button);
        service = (ImageButton) findViewById(R.id.service);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,CartActivity.class));

            }
        });
//        opens service categories
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,ServiceCategoryActivity.class));
            }
        });


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this,MenuActivity.class));
            }
        });

        profile = (LinearLayout) findViewById(R.id.user_prfile_layout);
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
        featuredServicesRecyclerViewAdapter = new FeaturedServicesRecyclerViewAdapter(this,this);
        featuredServicesRecyclerView.setAdapter(featuredServicesRecyclerViewAdapter);

        //most selling
        mostSellingRecyclerView = (RecyclerView) findViewById(R.id.most_selling_recycler_view);
        mostSellingRecyclerView.setHasFixedSize(true);
        mostSellingLinearLayoutManager = new LinearLayoutManager(this);
        mostSellingLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mostSellingRecyclerView.setLayoutManager(mostSellingLinearLayoutManager);
        mostSellingRecyclerViewAdapter = new MostSellingRecyclerViewAdapter(this,this);
        mostSellingRecyclerView.setAdapter(mostSellingRecyclerViewAdapter);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        startActivity(new Intent(HomeActivity.this,DetailActivity.class));
    }
}
