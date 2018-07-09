package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mawaqaamobile.festivity.R;

public class ServiceListingRecViewAdapter extends RecyclerView.Adapter<ServiceListingRecViewAdapter.ItemViewHolder> {
    final private ListItemClickListener mOnClickListener;
    private Context context;

    public ServiceListingRecViewAdapter(ListItemClickListener listItemClickListener,Context context) {
        mOnClickListener = listItemClickListener;
        this.context = context;
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_listing_rec_view_item,parent,false);
        return new ServiceListingRecViewAdapter.ItemViewHolder(v);    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

    }
    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }


    @Override
    public int getItemCount() {
        return 4;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.before_price_text);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
