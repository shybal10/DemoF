package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.mawaqaamobile.festivity.R;

public class AddressRecyclerViewAdapter extends RecyclerView.Adapter<AddressRecyclerViewAdapter.ItemViewHolder> {
    private Animation animation;
    boolean showAllAdresses;
    private Context mcontext;
    public AddressRecyclerViewAdapter(boolean showAllAdresses, Context context) {
        this.showAllAdresses = showAllAdresses;
        this.mcontext = context;
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adress_recycler_view_item,parent,false);
        return new AddressRecyclerViewAdapter.ItemViewHolder(v);      }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if (!showAllAdresses) {
            if (position == 0) {
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

    public void setShowAllAdresses(boolean showAllAdresses) {
        this.showAllAdresses = showAllAdresses; }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }
}
