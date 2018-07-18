package com.example.mawaqaamobile.festivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateAccountActivity extends AppCompatActivity {
    Button createAccount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

//        handle button click
        createAccount = (Button) findViewById(R.id.create_account_btn);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateAccountActivity.this,HomeActivity.class));
                CreateAccountActivity.this.finish();
            }
        });
    }
}
