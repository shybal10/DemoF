package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mawaqaamobile.festivity.R;
public class MostSellingRecyclerViewAdapter extends RecyclerView.Adapter<MostSellingRecyclerViewAdapter.ItemViewHolder> {
    final private MostSellingListItemClickListener mostSellingListItemClickListener;
    private Context context;
    public MostSellingRecyclerViewAdapter(MostSellingListItemClickListener listItemClickListener, Context parent) {
        mostSellingListItemClickListener = listItemClickListener;
        this.context = parent;
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_selling_recycler_view_item,parent,false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

    }
    public interface MostSellingListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }


    @Override
    public int getItemCount() {
        return 5;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textView;
        public ItemViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.before_price_text);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mostSellingListItemClickListener.onListItemClick(clickedPosition);
        }
    }
}
