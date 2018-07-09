package com.example.mawaqaamobile.festivity.Adapters;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mawaqaamobile.festivity.R;

public class FeaturedServicesRecyclerViewAdapter extends RecyclerView.Adapter<FeaturedServicesRecyclerViewAdapter.ItemViewHolder> {
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_services_recycler_view_item,parent,false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.before_price_text);
        }
    }
}
