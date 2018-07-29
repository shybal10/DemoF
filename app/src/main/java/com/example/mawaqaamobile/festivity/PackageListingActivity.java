package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.mawaqaamobile.festivity.Adapters.MostSellingRecyclerViewAdapter;
import com.example.mawaqaamobile.festivity.Adapters.PackageListingRecyclerViewAdapter;
import com.example.mawaqaamobile.festivity.Fragments.FilterFragment;
import com.example.mawaqaamobile.festivity.Screens.DateScreenActivity;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.Holder;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.ViewHolder;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

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
        showFilterList();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    private void showFilterList() {
        Holder holder;
        holder = new ViewHolder(R.layout.package_filter_options_dialog);
        final DialogPlus dialog = DialogPlus.newDialog(this)
                .setContentHolder(holder)
                .setCancelable(true)
                .setGravity(Gravity.TOP)
                .setBackgroundColorResId(Color.TRANSPARENT)
                .setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(DialogPlus dialog, View view) {
                        Intent i;
                        switch (view.getId()) {
                            case R.id.close_dialog_btn:
                                dialog.dismiss();
                                break;

                            case R.id.search_area:
                                 i = new Intent(PackageListingActivity.this, AreaScreenActivity.class);
                                startActivity(i);
                                break;

                            case R.id.search_date:
                                i = new Intent(PackageListingActivity.this, DateScreenActivity.class);
                                startActivity(i);
                                break;

                            case R.id.search_occasion:
                                dialog.dismiss();
                                break;

                            case R.id.packages_search_button:
                                dialog.dismiss();
                                break;
                        }
                    }
                })
                .create();

        dialog.show();
    }
}
