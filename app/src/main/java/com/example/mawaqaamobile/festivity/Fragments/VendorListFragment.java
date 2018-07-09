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
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.mawaqaamobile.festivity.Adapters.VendorListRecViewAdapter;
import com.example.mawaqaamobile.festivity.DetailActivity;
import com.example.mawaqaamobile.festivity.R;
import com.example.mawaqaamobile.festivity.ServiceCategoryActivity;

public class VendorListFragment extends Fragment implements VendorListRecViewAdapter.ListItemClickListener {
    ImageButton servicesButton;
    private RecyclerView vendorListRecView;
    ServiceListFragment serviceListFragment;
    private VendorListRecViewAdapter vendorListRecViewAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vendor_listing_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vendorListRecView = (RecyclerView) view.findViewById(R.id.vendor_list_rec_view);
        servicesButton = (ImageButton) view.findViewById(R.id.service);
        servicesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ServiceCategoryActivity.class));
            }
        });
        vendorListRecViewAdapter = new VendorListRecViewAdapter(this,getActivity());
        vendorListRecView.setHasFixedSize(true);
        vendorListRecView.setLayoutManager(new LinearLayoutManager(getActivity()));
        vendorListRecView.setAdapter(vendorListRecViewAdapter);
        serviceListFragment = new ServiceListFragment();

    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        getFragmentManager().beginTransaction().replace(R.id.fragment_continer, serviceListFragment).commit();

    }
}
