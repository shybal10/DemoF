package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mawaqaamobile.festivity.R;
import com.example.mawaqaamobile.festivity.UIutills.ViewDetailsGridView;

public class CartPendingRecViewAdapter extends RecyclerView.Adapter<CartPendingRecViewAdapter.ItemViewHolder> {
    private ViewDetailsGridViewAdapter viewDetailsGridViewAdapter;
    private Context context;
    public CartPendingRecViewAdapter(Context context) {
        this.context = context;
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.pending_cart_rec_view_item,parent,false);
        return new CartPendingRecViewAdapter.ItemViewHolder(v);    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        viewDetailsGridViewAdapter = new ViewDetailsGridViewAdapter(context);
        holder.viewDetailsGridView.setAdapter(viewDetailsGridViewAdapter);
        holder.viewDetailsGridView.setVisibility(View.GONE);
        holder.viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.viewDetailsGridView.setVisibility(View.VISIBLE);
                holder.viewDetails.setVisibility(View.INVISIBLE);
                holder.closeDetails.setVisibility(View.VISIBLE);
            }
        });
        holder.closeDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.viewDetailsGridView.setVisibility(View.GONE);
                holder.viewDetails.setVisibility(View.VISIBLE);
                holder.closeDetails.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout viewDetails,closeDetails;
        ViewDetailsGridView viewDetailsGridView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            viewDetails = (LinearLayout) itemView.findViewById(R.id.view_details_layout);
            closeDetails = (LinearLayout) itemView.findViewById(R.id.close_view_detail_layout);
            viewDetailsGridView = (ViewDetailsGridView) itemView.findViewById(R.id.pending_cart_view_details_grid_view);        }
    }
}
