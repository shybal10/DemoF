package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mawaqaamobile.festivity.R;
public class ReviewServiceRecViewAdapter extends RecyclerView.Adapter<ReviewServiceRecViewAdapter.ItemViewHolder> {
    private boolean showAllServices;
    private Context mcontext;

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
    public void onBindViewHolder(ItemViewHolder holder, int position) {
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
    }
    @Override
    public int getItemCount() {
        return 3;
    }

    public void setShowAllServices(boolean showAllServices) {
        this.showAllServices = showAllServices;
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
