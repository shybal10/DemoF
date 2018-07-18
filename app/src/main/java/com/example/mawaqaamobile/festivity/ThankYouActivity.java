package com.example.mawaqaamobile.festivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ThankYouActivity extends AppCompatActivity {

    Button viewInvoice,goHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
        viewInvoice = (Button) findViewById(R.id.view_invoice_button);
        viewInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThankYouActivity.this,ViewInvoiceActivity.class));
            }
        });
        goHome = (Button) findViewById(R.id.go_home_button);

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ThankYouActivity.this,HomeActivity.class));
                ThankYouActivity.this.finish();
            }
        });
    }
}
