package com.example.mawaqaamobile.festivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.mawaqaamobile.festivity.Adapters.ServiceListingRecViewAdapter;
import com.example.mawaqaamobile.festivity.Fragments.ServiceListFragment;
import com.example.mawaqaamobile.festivity.Fragments.VendorListFragment;

public class ServiceListingActivity extends AppCompatActivity {
    ImageButton menu,cart;
    ServiceListFragment serviceListFragment;
    VendorListFragment vendorListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_listing);
        serviceListFragment = new ServiceListFragment();
        vendorListFragment = new VendorListFragment();
        menu = (ImageButton) findViewById(R.id.menu_button);
        cart = (ImageButton) findViewById(R.id.cart_button);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ServiceListingActivity.this,MenuActivity.class));
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ServiceListingActivity.this,CartActivity.class));
            }
        });
        //getFragmentManager().beginTransaction().replace(R.id.fragment_continer,serviceListFragment).commit();

        getFragmentManager().beginTransaction().replace(R.id.fragment_continer,vendorListFragment).commit();


    }
}