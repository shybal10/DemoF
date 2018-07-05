package com.example.mawaqaamobile.festivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mawaqaamobile.festivity.Adapters.CartConfRecViewAdapter;
import com.example.mawaqaamobile.festivity.Adapters.CartPendingRecViewAdapter;

public class CartActivity extends AppCompatActivity {

    RecyclerView pendingCartRecView,confCartRecView;
    CartPendingRecViewAdapter cartPendingRecViewAdapter;
    CartConfRecViewAdapter cartConfRecViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

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
