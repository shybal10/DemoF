package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mawaqaamobile.festivity.PackageServicesActivity;
import com.example.mawaqaamobile.festivity.R;

public class PackageListingRecyclerViewAdapter extends RecyclerView.Adapter<PackageListingRecyclerViewAdapter.ItemViewHolder> {
    ServiceInsidePackagesRecyclerViewAdapter serviceInsidePackagesRecyclerViewAdapter;
    Context mcontext;

    public PackageListingRecyclerViewAdapter(Context context) {
        this.mcontext = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.package_listing_recycler_view_item,parent,false);
        return new PackageListingRecyclerViewAdapter.ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        serviceInsidePackagesRecyclerViewAdapter = new ServiceInsidePackagesRecyclerViewAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(mcontext, LinearLayoutManager.HORIZONTAL, false);
        holder.recyclerViewServiceInsidePackages.setAdapter(serviceInsidePackagesRecyclerViewAdapter);
        holder.recyclerViewServiceInsidePackages.setLayoutManager(layoutManager);
        holder.viewServices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mcontext.startActivity(new Intent(mcontext, PackageServicesActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        RecyclerView recyclerViewServiceInsidePackages;
        Button viewServices;
        public ItemViewHolder(View itemView) {
            super(itemView);
            recyclerViewServiceInsidePackages = (RecyclerView) itemView.findViewById(R.id.services_inside_packages_recycler_view);
            viewServices = (Button) itemView.findViewById(R.id.view_all_services_button);
        }
    }
}
