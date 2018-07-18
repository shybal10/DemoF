package com.example.mawaqaamobile.festivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mawaqaamobile.festivity.Adapters.ReviewServiceRecViewAdapter;

public class ReviewPlaceOrderActivity extends AppCompatActivity {
    boolean showAllServices = false;
    ImageButton showServices;
    Button placeOrder;
    RecyclerView servicesRecView;
    LinearLayoutManager serviceLayoutManager;
    ReviewServiceRecViewAdapter reviewServiceRecViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_place_order);
        servicesRecView = (RecyclerView) findViewById(R.id.review_service_rec_view);
        placeOrder = (Button) findViewById(R.id.place_order_button);
        reviewServiceRecViewAdapter = new ReviewServiceRecViewAdapter(this,showAllServices);

        //servicesRecView.setHasFixedSize(true);
        serviceLayoutManager = new LinearLayoutManager(this);
        serviceLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        servicesRecView.setLayoutManager(serviceLayoutManager);
        servicesRecView.setNestedScrollingEnabled(false);
        servicesRecView.setAdapter(reviewServiceRecViewAdapter);

        showServices = (ImageButton) findViewById(R.id.down_button);
        showServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!showAllServices) {
                    showAllServices = true;
                    showServices.setImageResource(R.drawable.uparrow);
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

        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReviewPlaceOrderActivity.this,ThankYouActivity.class));
            }
        });
    }

    public void showCart(View view) {
        startActivity(new Intent(ReviewPlaceOrderActivity.this,CartActivity.class));
    }

    public void showMenu(View view) {
        startActivity(new Intent(ReviewPlaceOrderActivity.this,MenuActivity.class));
    }
}
