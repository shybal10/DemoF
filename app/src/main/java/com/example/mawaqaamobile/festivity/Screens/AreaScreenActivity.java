package com.example.mawaqaamobile.festivity.Screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.mawaqaamobile.festivity.Adapters.EventAreaRecViewAdapter;
import com.example.mawaqaamobile.festivity.R;

public class AreaScreenActivity extends AppCompatActivity {

    RecyclerView eventAreaRecyclerView;
    EventAreaRecViewAdapter eventAreaRecViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_screen);
        eventAreaRecyclerView = (RecyclerView) findViewById(R.id.event_area_rec_view);
        eventAreaRecyclerView.setHasFixedSize(true);
        eventAreaRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        eventAreaRecViewAdapter = new EventAreaRecViewAdapter();
        eventAreaRecyclerView.setAdapter(eventAreaRecViewAdapter);

    }
}
