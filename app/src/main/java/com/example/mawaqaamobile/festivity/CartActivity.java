package com.example.mawaqaamobile.festivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.mawaqaamobile.festivity.Adapters.CartConfRecViewAdapter;
import com.example.mawaqaamobile.festivity.Adapters.CartPendingRecViewAdapter;

public class CartActivity extends AppCompatActivity {

    Button continueShopping,checkout;
    RecyclerView pendingCartRecView,confCartRecView;
    CartPendingRecViewAdapter cartPendingRecViewAdapter;
    CartConfRecViewAdapter cartConfRecViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        continueShopping = (Button) findViewById(R.id.continue_shopping_button);
        checkout = (Button) findViewById(R.id.checkout_button);

        continueShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,HomeActivity.class));
            }
        });

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this,EventAddressActivity.class));
            }
        });
        pendingCartRecView = (RecyclerView) findViewById(R.id.pending_cart_rec_view);
        cartPendingRecViewAdapter = new CartPendingRecViewAdapter();
        pendingCartRecView.setHasFixedSize(true);
        pendingCartRecView.setLayoutManager(new LinearLayoutManager(this));
        pendingCartRecView.setAdapter(cartPendingRecViewAdapter);

        confCartRecView = (RecyclerView) findViewById(R.id.confirmed_cart_rec_view);
        cartConfRecViewAdapter = new CartConfRecViewAdapter();
        confCartRecView.setHasFixedSize(true);
        confCartRecView.setLayoutManager(new LinearLayoutManager(this));
        confCartRecView.setAdapter(cartConfRecViewAdapter);
    }
}
