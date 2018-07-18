package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.mawaqaamobile.festivity.R;
import com.example.mawaqaamobile.festivity.UIutills.ViewDetailsGridView;

public class ReviewServiceRecViewAdapter extends RecyclerView.Adapter<ReviewServiceRecViewAdapter.ItemViewHolder> {
    private boolean showAllServices;
    private Context mcontext;
    private ViewDetailsGridViewAdapter viewDetailsGridViewAdapter;

    public ReviewServiceRecViewAdapter(Context context, boolean show) {
        this.mcontext = context;
        this.showAllServices = show;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.review_service_rec_view_item,parent,false);
        return new ReviewServiceRecViewAdapter.ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        //close opened view details
        holder.viewDetailsGridView.setVisibility(View.GONE);
        holder.viewDetails.setVisibility(View.VISIBLE);
        holder.closeDetails.setVisibility(View.GONE);
        if (!showAllServices) {
            if (position == 0||position == 1) {
                holder.itemView.setVisibility(View.VISIBLE);
            }
            else {
                holder.itemView.setVisibility(View.GONE);
                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            }
        }else {
            holder.itemView.setVisibility(View.VISIBLE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            //animation = AnimationUtils.loadAnimation(mcontext, R.anim.address_slide_animation);
            // holder.itemView.startAnimation(animation);
        }
        viewDetailsGridViewAdapter = new ViewDetailsGridViewAdapter(mcontext);
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
        return 3;
    }

    public void setShowAllServices(boolean showAllServices) {
        this.showAllServices = showAllServices;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ViewDetailsGridView viewDetailsGridView;
        LinearLayout viewDetails,closeDetails;
        public ItemViewHolder(View itemView) {
            super(itemView);
            viewDetails = (LinearLayout) itemView.findViewById(R.id.view_details_layout);
            closeDetails = (LinearLayout) itemView.findViewById(R.id.close_view_detail_layout);
            viewDetailsGridView = (ViewDetailsGridView) itemView.findViewById(R.id.review_service_view_details_grid_view);
        }
    }
}
