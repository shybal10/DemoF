package com.example.mawaqaamobile.festivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import com.example.mawaqaamobile.festivity.Adapters.ServiceCategoryGridAdapter;
import com.example.mawaqaamobile.festivity.Fragments.PackageFragment;
import com.example.mawaqaamobile.festivity.Fragments.ServiceCategoryListFragment;

public class ServiceCategoryActivity extends AppCompatActivity {
    ServiceCategoryListFragment serviceCategoryListFragment;
    PackageFragment packageFragment;
    Button explore,packages;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_category);
        title = (TextView) findViewById(R.id.title);
        serviceCategoryListFragment = new ServiceCategoryListFragment();
        packageFragment = new PackageFragment();

        getFragmentManager().beginTransaction().add(R.id.fragment_continer,serviceCategoryListFragment).commit();

        explore = (Button) findViewById(R.id.explore_button);
        packages = (Button) findViewById(R.id.packages_button);


        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explore.setBackgroundResource(R.drawable.switchbg);
                explore.setTextColor(ServiceCategoryActivity.this.getResources().getColor(R.color.white));

                packages.setBackgroundResource(0);
                packages.setTextColor(ServiceCategoryActivity.this.getResources().getColor(R.color.orange));
                getFragmentManager().beginTransaction().replace(R.id.fragment_continer,serviceCategoryListFragment).commit();
                title.setText("Explore");

            }
        });

        packages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                packages.setBackgroundResource(R.drawable.switchbg);
                packages.setTextColor(ServiceCategoryActivity.this.getResources().getColor(R.color.white));

                explore.setBackgroundResource(0);
                explore.setTextColor(ServiceCategoryActivity.this.getResources().getColor(R.color.orange));
                getFragmentManager().beginTransaction().replace(R.id.fragment_continer,packageFragment).commit();
                title.setText("Packages");

            }
        });

        getFragmentManager().beginTransaction().replace(R.id.fragment_continer,serviceCategoryListFragment).commit();
    }
}
