package com.example.mawaqaamobile.festivity.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mawaqaamobile.festivity.R;

public class SearchAreaRecViewAdapter extends RecyclerView.Adapter<SearchAreaRecViewAdapter.ItemViewHolder> {
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_area_rec_view_item,parent,false);
        return new SearchAreaRecViewAdapter.ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ItemViewHolder holder, int position) {
        if(position %2 == 0){
            holder.itemView.setBackgroundResource(R.color.historyshade);
        }
        else {
            holder.itemView.setBackgroundResource(0);

        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder  {
        TextView area;
        public ItemViewHolder(View itemView) {
            super(itemView);
            area = (TextView) itemView.findViewById(R.id.area_text);
        }

    }
}
