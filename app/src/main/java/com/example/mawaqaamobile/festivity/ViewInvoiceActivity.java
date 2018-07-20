package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.mawaqaamobile.festivity.Adapters.InvoiceConfRecViewAdapter;
import com.example.mawaqaamobile.festivity.Adapters.InvoicePendingRecViewAdapter;
import com.example.mawaqaamobile.festivity.Popup.InfoDialog;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class ViewInvoiceActivity extends AppCompatActivity {

    RecyclerView pendingInvoiceRecView,confInvoiceRecView;
    InvoicePendingRecViewAdapter invoicePendingRecViewAdapter;
    InvoiceConfRecViewAdapter invoiceConfRecViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_invoice);

        pendingInvoiceRecView = (RecyclerView) findViewById(R.id.pending_invoice_rec_view);
        invoicePendingRecViewAdapter = new InvoicePendingRecViewAdapter(this);
        pendingInvoiceRecView.setHasFixedSize(true);
        pendingInvoiceRecView.setNestedScrollingEnabled(false);
        pendingInvoiceRecView.setLayoutManager(new LinearLayoutManager(this));
        pendingInvoiceRecView.setAdapter(invoicePendingRecViewAdapter);

        confInvoiceRecView = (RecyclerView) findViewById(R.id.confirmed_invoice_rec_view);
        invoiceConfRecViewAdapter = new InvoiceConfRecViewAdapter(this);
        confInvoiceRecView.setHasFixedSize(true);
        confInvoiceRecView.setNestedScrollingEnabled(false);
        confInvoiceRecView.setLayoutManager(new LinearLayoutManager(this));
        confInvoiceRecView.setAdapter(invoiceConfRecViewAdapter);
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
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
