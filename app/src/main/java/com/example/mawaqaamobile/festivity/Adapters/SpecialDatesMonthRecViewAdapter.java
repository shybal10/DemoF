package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.mawaqaamobile.festivity.R;
import com.example.mawaqaamobile.festivity.UIutills.ViewDetailsGridView;

public class SpecialDatesMonthRecViewAdapter extends RecyclerView.Adapter<SpecialDatesMonthRecViewAdapter.ItemViewHolder>{
    SpecialDatesGridViewAdapter specialDatesGridViewAdapter;
    private boolean showAllMonths;
    Context mcontext;

    public SpecialDatesMonthRecViewAdapter(Context context, boolean show) {
        this.mcontext = context;
        this.showAllMonths = show;

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.special_dates_month_rec_view,parent,false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        specialDatesGridViewAdapter = new SpecialDatesGridViewAdapter(mcontext);
        holder.specialDatesForMonth.setAdapter(specialDatesGridViewAdapter);

        if (!showAllMonths) {
            if (position == 0) {
                holder.itemView.setVisibility(View.VISIBLE);
            }
            else {
                holder.itemView.setVisibility(View.GONE);
                holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
            }
        }else {
            holder.itemView.setVisibility(View.VISIBLE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            //animation = AnimationUtils.loadAnimation(mcontext, R.anim.address_slide_animation);
            // holder.itemView.startAnimation(animation);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public void setShowAllMonths(boolean showAllMonths) {
        this.showAllMonths = showAllMonths;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ViewDetailsGridView specialDatesForMonth;
        public ItemViewHolder(View itemView) {
            super(itemView);
            specialDatesForMonth = (ViewDetailsGridView) itemView.findViewById(R.id.add_special_dates_grid_view);
        }
    }
}
