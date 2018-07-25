package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.mawaqaamobile.festivity.Adapters.CartConfRecViewAdapter;
import com.example.mawaqaamobile.festivity.Adapters.CartPendingRecViewAdapter;
import com.example.mawaqaamobile.festivity.Popup.InfoDialog;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class CartActivity extends AppCompatActivity {

    Button continueShopping,checkout;
    RecyclerView pendingCartRecView,confCartRecView;
    CartPendingRecViewAdapter cartPendingRecViewAdapter;
    CartConfRecViewAdapter cartConfRecViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

//        handle button clicks
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

//        pending cart items
        pendingCartRecView = (RecyclerView) findViewById(R.id.pending_cart_rec_view);
        cartPendingRecViewAdapter = new CartPendingRecViewAdapter(this);
        pendingCartRecView.setHasFixedSize(true);
        pendingCartRecView.setNestedScrollingEnabled(false);
        pendingCartRecView.setLayoutManager(new LinearLayoutManager(this));
        pendingCartRecView.setAdapter(cartPendingRecViewAdapter);

//        conf cart items
        confCartRecView = (RecyclerView) findViewById(R.id.confirmed_cart_rec_view);
        cartConfRecViewAdapter = new CartConfRecViewAdapter(this);
        confCartRecView.setNestedScrollingEnabled(false);
        confCartRecView.setHasFixedSize(true);
        confCartRecView.setLayoutManager(new LinearLayoutManager(this));
        confCartRecView.setAdapter(cartConfRecViewAdapter);
    }

    public void showInfoPopup(View view) {
        final InfoDialog dialog = new InfoDialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.info_popup_dialog);
        dialog.setCanceledOnTouchOutside(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        //lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }

    public void ReopenCart(View view) {
        finish();
        startActivity(getIntent());
    }

    public void showMenu(View view) {
        startActivity(new Intent(CartActivity.this,MenuActivity.class));
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
