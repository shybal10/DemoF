package com.example.mawaqaamobile.festivity.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.mawaqaamobile.festivity.Adapters.ServiceCategoryGridAdapter;
import com.example.mawaqaamobile.festivity.R;
import com.example.mawaqaamobile.festivity.ServiceListingActivity;

public class ServiceCategoryListFragment extends Fragment {
    GridView serviceGrid;
    ServiceCategoryGridAdapter serviceCategoryGridAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.service_category_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        serviceGrid = (GridView) view.findViewById(R.id.service_category_grid_view);
        serviceCategoryGridAdapter = new ServiceCategoryGridAdapter(getActivity());
        serviceGrid.setAdapter(serviceCategoryGridAdapter);
        serviceGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent i = new Intent(new Intent(getActivity(), ServiceListingActivity.class));
                    i.putExtra("OpenServiceListFragment",false);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(new Intent(getActivity(), ServiceListingActivity.class));
                    i.putExtra("OpenServiceListFragment",true);
                    startActivity(i);
                }
            }
        });
    }
}
