package com.example.mawaqaamobile.festivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.mawaqaamobile.festivity.Adapters.AddressRecyclerViewAdapter;
import com.example.mawaqaamobile.festivity.Adapters.SpecialDatesRecyclerViewAdapter;
import com.example.mawaqaamobile.festivity.Screens.SpecialDatesScreenActivity;

public class ProfilePageActivity extends AppCompatActivity {
    LinearLayout upcommingEvents,pastEvents;
    boolean showallAdresses = false;
    ImageButton showAddresses,addDates;
    LinearLayoutManager specialDatesLinearLayoutManager,addressLinearLayoutManager;
    RecyclerView specialDatesRecyclerView,addressRecyclerView;
    SpecialDatesRecyclerViewAdapter specialDatesRecyclerViewAdapter;
    AddressRecyclerViewAdapter addressRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        addDates = (ImageButton) findViewById(R.id.add_dates_button);
        addDates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfilePageActivity.this, SpecialDatesScreenActivity.class));
            }
        });
        pastEvents = (LinearLayout) findViewById(R.id.past_events_layout);
        upcommingEvents = (LinearLayout) findViewById(R.id.upcomming_events_layout);
        pastEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfilePageActivity.this,HistoryActivity.class));
            }
        });
        upcommingEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfilePageActivity.this,HistoryActivity.class));
            }
        });

        //recycler view for special dates
        specialDatesRecyclerView = (RecyclerView) findViewById(R.id.special_dates_recycler_view);
        specialDatesRecyclerView.setHasFixedSize(true);

        specialDatesLinearLayoutManager = new LinearLayoutManager(this);
        specialDatesLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        specialDatesRecyclerView.setLayoutManager(specialDatesLinearLayoutManager);
        specialDatesRecyclerViewAdapter = new SpecialDatesRecyclerViewAdapter();
        specialDatesRecyclerView.setAdapter(specialDatesRecyclerViewAdapter);

        //recycler view for address
        addressRecyclerView = (RecyclerView) findViewById(R.id.addess_reycler_view);
        addressLinearLayoutManager = new LinearLayoutManager(this);
        addressLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        addressRecyclerView.setLayoutManager(addressLinearLayoutManager);
        addressRecyclerViewAdapter = new AddressRecyclerViewAdapter(showallAdresses,ProfilePageActivity.this);
        addressRecyclerView.setAdapter(addressRecyclerViewAdapter);

        showAddresses = (ImageButton) findViewById(R.id.show_addresses_button);
        showAddresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!showallAdresses) {
                    showallAdresses = true;
                    showAddresses.setImageResource(R.drawable.uparrow);
                    addressRecyclerViewAdapter.setShowAllAdresses(showallAdresses);
                    addressRecyclerViewAdapter.notifyDataSetChanged();

                }
                else {
                    showallAdresses = false;
                    showAddresses.setImageResource(R.drawable.dwnaroow);
                    addressRecyclerViewAdapter.setShowAllAdresses(showallAdresses);
                    addressRecyclerViewAdapter.notifyDataSetChanged();
                }

            }
        });

    }
}
