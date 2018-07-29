package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.mawaqaamobile.festivity.Fragments.ServiceListFragment;
import com.example.mawaqaamobile.festivity.Fragments.VendorListFragment;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class ServiceListingActivity extends AppCompatActivity {
    ServiceListFragment serviceListFragment;
    VendorListFragment vendorListFragment;
    boolean showVendors = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_listing);
        showVendors = getIntent().getBooleanExtra("OpenServiceListFragment",false);
        if (showVendors) {
            vendorListFragment = new VendorListFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragment_continer,vendorListFragment).commit();
        }
        else {
            serviceListFragment = new ServiceListFragment();
            getFragmentManager().beginTransaction().replace(R.id.fragment_continer,serviceListFragment).commit();
        }

    }

    public void searchAgain(View view) {
        Intent i = new Intent(ServiceListingActivity.this,SearchAgainActivity.class);
        i.putExtra("searchPackages",false);
        startActivity(i);
    }

    public void showCart(View view) {
        startActivity(new Intent(ServiceListingActivity.this,CartActivity.class));
    }

    public void showMenu(View view) {
        startActivity(new Intent(ServiceListingActivity.this,MenuActivity.class));

    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }


}
