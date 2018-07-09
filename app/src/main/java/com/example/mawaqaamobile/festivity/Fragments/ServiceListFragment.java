package com.example.mawaqaamobile.festivity.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.mawaqaamobile.festivity.Adapters.ServiceListingRecViewAdapter;
import com.example.mawaqaamobile.festivity.CartActivity;
import com.example.mawaqaamobile.festivity.DetailActivity;
import com.example.mawaqaamobile.festivity.R;

public class ServiceListFragment extends Fragment implements ServiceListingRecViewAdapter.ListItemClickListener {
    RecyclerView serviceListingRecyclerView;
    RelativeLayout viewCartLayout;
    LinearLayout viewCartButton;
    static final int ADD_TO_CART = 1;
    ServiceListingRecViewAdapter serviceListingRecViewAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.service_listing_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewCartLayout = (RelativeLayout) view.findViewById(R.id.view_cart_layout);
        viewCartButton = (LinearLayout) view.findViewById(R.id.view_cart_button);
        viewCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CartActivity.class));
            }
        });
        serviceListingRecyclerView = (RecyclerView) view.findViewById(R.id.service_listing_recycler_view);
        serviceListingRecViewAdapter = new ServiceListingRecViewAdapter(this,getActivity());

        serviceListingRecyclerView.setHasFixedSize(true);
        serviceListingRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        serviceListingRecyclerView.setAdapter(serviceListingRecViewAdapter);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        startActivityForResult(new Intent(getActivity(), DetailActivity.class),ADD_TO_CART);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        viewCartLayout.setVisibility(View.VISIBLE);
    }
}
