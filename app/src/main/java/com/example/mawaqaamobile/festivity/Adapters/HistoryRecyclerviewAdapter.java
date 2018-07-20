package com.example.mawaqaamobile.festivity.Adapters;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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

        if (position == 0) {
            holder.pending.setVisibility(View.GONE);
            holder.confirmed.setVisibility(View.GONE);
            holder.cancelled.setVisibility(View.VISIBLE);
        }else if (position == 1){
            holder.pending.setVisibility(View.VISIBLE);
            holder.confirmed.setVisibility(View.GONE);
            holder.cancelled.setVisibility(View.GONE);
        }
        else {
            holder.pending.setVisibility(View.GONE);
            holder.confirmed.setVisibility(View.VISIBLE);
            holder.cancelled.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout confirmed,pending,cancelled;
        public ItemViewHolder(View itemView) {
            super(itemView);
            confirmed = (LinearLayout) itemView.findViewById(R.id.confirmed_layout);
            pending = (LinearLayout) itemView.findViewById(R.id.pending_confirmation_layout);
            cancelled = (LinearLayout) itemView.findViewById(R.id.cancelled_layout);
        }
    }
}
