package com.example.mawaqaamobile.festivity.Adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mawaqaamobile.festivity.R;

public class HistoryRecyclerviewAdapter extends RecyclerView.Adapter<HistoryRecyclerviewAdapter.ItemViewHolder> {
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_recycler_view_item,parent,false);
        return new HistoryRecyclerviewAdapter.ItemViewHolder(v);    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if(position %2 == 1)
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#f6f6f6"));
            //  holder.imageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        else
        {
            holder.itemView.setBackgroundColor(Color.parseColor("#eeedf1"));
            //  holder.imageView.setBackgroundColor(Color.parseColor("#FFFAF8FD"));
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}