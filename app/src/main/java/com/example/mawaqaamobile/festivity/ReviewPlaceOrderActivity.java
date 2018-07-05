package com.example.mawaqaamobile.festivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.mawaqaamobile.festivity.Adapters.ReviewServiceRecViewAdapter;

public class ReviewPlaceOrderActivity extends AppCompatActivity {
    boolean showAllServices = false;
    ImageButton showServices;
    RecyclerView servicesRecView;
    LinearLayoutManager serviceLayoutManager;
    ReviewServiceRecViewAdapter reviewServiceRecViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_place_order);
        servicesRecView = (RecyclerView) findViewById(R.id.review_service_rec_view);
        reviewServiceRecViewAdapter = new ReviewServiceRecViewAdapter(this,showAllServices);

        //servicesRecView.setHasFixedSize(true);
        serviceLayoutManager = new LinearLayoutManager(this);
        serviceLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        servicesRecView.setLayoutManager(serviceLayoutManager);
        servicesRecView.setAdapter(reviewServiceRecViewAdapter);

        showServices = (ImageButton) findViewById(R.id.down_button);
        showServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!showAllServices) {
                    showAllServices = true;
                    showServices.setImageResource(R.drawable.arrowleft);
                    reviewServiceRecViewAdapter.setShowAllServices(showAllServices);
                    reviewServiceRecViewAdapter.notifyDataSetChanged();

                }
                else {
                    showAllServices = false;
                    showServices.setImageResource(R.drawable.dwnaroow);
                    reviewServiceRecViewAdapter.setShowAllServices(showAllServices);
                    reviewServiceRecViewAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
