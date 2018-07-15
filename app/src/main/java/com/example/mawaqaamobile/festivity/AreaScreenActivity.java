package com.example.mawaqaamobile.festivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mawaqaamobile.festivity.Adapters.SearchAreaRecViewAdapter;
import com.example.mawaqaamobile.festivity.R;

public class AreaScreenActivity extends AppCompatActivity {
    RecyclerView searchAreaRecyclerView;
    SearchAreaRecViewAdapter searchAreaRecViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_screen);
        searchAreaRecViewAdapter = new SearchAreaRecViewAdapter();
        searchAreaRecyclerView = (RecyclerView) findViewById(R.id.search_area_rec_view);
        searchAreaRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchAreaRecyclerView.setHasFixedSize(true);
        searchAreaRecyclerView.setAdapter(searchAreaRecViewAdapter);
    }
}
