package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mawaqaamobile.festivity.R;

public class HistoryRecyclerviewAdapter extends RecyclerView.Adapter<HistoryRecyclerviewAdapter.ItemViewHolder> {
    Context mcontext;
    public HistoryRecyclerviewAdapter(Context context) {
        this.mcontext = context;
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_recycler_view_item,parent,false);
        return new HistoryRecyclerviewAdapter.ItemViewHolder(v);    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if(position %2 == 1)
        {
            holder.forground.setBackgroundColor(Color.parseColor("#f6f6f6"));
            //  holder.imageView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        else
        {
            holder.forground.setBackgroundColor(Color.parseColor("#eeedf1"));
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

        holder.info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"clicked",Toast.LENGTH_LONG).show();
            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mcontext,"clicked",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageButton edit,info;
        LinearLayout confirmed,pending,cancelled;
        FrameLayout forground;
        public ItemViewHolder(View itemView) {
            super(itemView);
            confirmed = (LinearLayout) itemView.findViewById(R.id.confirmed_layout);
            pending = (LinearLayout) itemView.findViewById(R.id.pending_confirmation_layout);
            cancelled = (LinearLayout) itemView.findViewById(R.id.cancelled_layout);
            info = (ImageButton) itemView.findViewById(R.id.info_button);
            edit = (ImageButton) itemView.findViewById(R.id.edit_button);
            forground = (FrameLayout) itemView.findViewById(R.id.foreground_layout);
        }
    }
}
