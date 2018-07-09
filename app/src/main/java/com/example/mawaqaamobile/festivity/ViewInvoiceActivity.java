package com.example.mawaqaamobile.festivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mawaqaamobile.festivity.Adapters.InvoiceConfRecViewAdapter;
import com.example.mawaqaamobile.festivity.Adapters.InvoicePendingRecViewAdapter;

public class ViewInvoiceActivity extends AppCompatActivity {

    RecyclerView pendingInvoiceRecView,confInvoiceRecView;
    InvoicePendingRecViewAdapter invoicePendingRecViewAdapter;
    InvoiceConfRecViewAdapter invoiceConfRecViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_invoice);

        pendingInvoiceRecView = (RecyclerView) findViewById(R.id.pending_invoice_rec_view);
        invoicePendingRecViewAdapter = new InvoicePendingRecViewAdapter();
        pendingInvoiceRecView.setHasFixedSize(true);
        pendingInvoiceRecView.setNestedScrollingEnabled(false);
        pendingInvoiceRecView.setLayoutManager(new LinearLayoutManager(this));
        pendingInvoiceRecView.setAdapter(invoicePendingRecViewAdapter);

        confInvoiceRecView = (RecyclerView) findViewById(R.id.confirmed_invoice_rec_view);
        invoiceConfRecViewAdapter = new InvoiceConfRecViewAdapter();
        confInvoiceRecView.setHasFixedSize(true);
        confInvoiceRecView.setNestedScrollingEnabled(false);
        confInvoiceRecView.setLayoutManager(new LinearLayoutManager(this));
        confInvoiceRecView.setAdapter(invoicePendingRecViewAdapter);
    }
}
