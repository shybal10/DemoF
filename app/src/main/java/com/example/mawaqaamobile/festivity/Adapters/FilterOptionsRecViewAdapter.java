package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mawaqaamobile.festivity.Fragments.FilterFragment;
import com.example.mawaqaamobile.festivity.Model.FilterOption;
import com.example.mawaqaamobile.festivity.R;
import com.plumillonforge.android.chipview.ChipView;

import java.util.List;

public class FilterOptionsRecViewAdapter extends RecyclerView.Adapter<FilterOptionsRecViewAdapter.ItemViewHolder> {
    private Context context;
    private List<FilterOption> filterOptions;
    public FilterOptionsRecViewAdapter( Context context, List<FilterOption> filterOptions) {
        this.context = context;
        this.filterOptions = filterOptions;
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.filter_options_rec_view_item,parent,false);
        return new FilterOptionsRecViewAdapter.ItemViewHolder(v);     }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int position) {
        //set alternate colours for filter
        if (position %2 == 1) {
            holder.itemView.setBackgroundResource(R.color.actionbarcolor);
        }
        else {
            holder.itemView.setBackgroundResource(R.color.historyshade);
        }
        final FilterOption filterOption = filterOptions.get(position);
        holder.filterText.setText(filterOptions.get(position).getText());
        if (filterOption.isSelected()) {
            FilterFragment.chipView.add(filterOption);
            holder.layout. setBackgroundResource(R.color.orange);
            holder.filterText.setTextColor(ContextCompat.getColor(context,R.color.white));
            holder.filterSelect.setImageResource(R.drawable.filterselectactive);
        } else {
            FilterFragment.chipView.remove(filterOption);
            holder.filterSelect.setImageResource(R.drawable.filterselect);
            holder.filterText.setTextColor(ContextCompat.getColor(context,R.color.blackbold));
        }

        //handle click event
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                filterOption.setSelected(!filterOption.isSelected());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return filterOptions.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        TextView filterText;
        ImageView filterSelect;
        LinearLayout layout;
        public ItemViewHolder(View itemView) {
            super(itemView);
            filterText = (TextView) itemView.findViewById(R.id.filter_text);
            filterSelect = (ImageView) itemView.findViewById(R.id.filter_select);
            layout = (LinearLayout) itemView.findViewById(R.id.selected_layout);
        }
    }
}
