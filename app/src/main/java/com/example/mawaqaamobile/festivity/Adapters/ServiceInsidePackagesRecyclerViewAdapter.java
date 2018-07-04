package com.example.mawaqaamobile.festivity.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mawaqaamobile.festivity.R;

public class ServiceInsidePackagesRecyclerViewAdapter extends RecyclerView.Adapter<ServiceInsidePackagesRecyclerViewAdapter.ItemViewHolder> {
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.services_inside_packages_recycler_view_item,parent,false);
        return new ServiceInsidePackagesRecyclerViewAdapter.ItemViewHolder(v);    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
