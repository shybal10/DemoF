package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mawaqaamobile.festivity.Adapters.HistoryRecyclerviewAdapter;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class HistoryActivity extends AppCompatActivity {

    HistoryRecyclerviewAdapter historyRecyclerviewAdapter;
    RecyclerView historyRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

//        set up history adapter
        historyRecyclerView = (RecyclerView) findViewById(R.id.history_recycler_view);
        historyRecyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        historyRecyclerView.setLayoutManager(linearLayoutManager);
        historyRecyclerviewAdapter = new HistoryRecyclerviewAdapter(this);
        historyRecyclerView.setAdapter(historyRecyclerviewAdapter);

    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
