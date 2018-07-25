package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mawaqaamobile.festivity.R;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.List;

public class CategoryGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private int[] images;
    private String[] headers;
    public HashMap<Integer, Boolean> hashMapSelected;

    public CategoryGridViewAdapter(Context context, int[] images, String[] headers) {
        this.mContext = context;
        this.images = images;
        this.headers = headers;
        hashMapSelected = new HashMap<>();
        for (int i = 0; i < headers.length; i++) {
            hashMapSelected.put(i, false);
        }
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return  images.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public void selectCategories(int position) {
        if (hashMapSelected.get(position)) {
            hashMapSelected.put(position, false);
        }
        else {
            hashMapSelected.put(position, true);
        }
        //for selecting just one category
/*        for (int i = 0; i < hashMapSelected.size(); i++) {
            if (i != position)
                hashMapSelected.put(i, false);
        }*/
    }

    public boolean isCategoriesSelected() {
        for (int i = 0; i < hashMapSelected.size(); i++) {
            if (hashMapSelected.get(i))
                return true;
        }
        return false;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.category_grid_view_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else
            viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.textView.setText(headers[position]);
            viewHolder.imageView.setImageResource(images[position]);


        if (hashMapSelected.get(position)) {
            convertView.setBackgroundResource(R.drawable.category_button_border);
            viewHolder.imageView.setColorFilter(ContextCompat.getColor(mContext, R.color.white));
            viewHolder.textView.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        } else {
            convertView.setBackgroundResource(0);
            viewHolder.imageView.setColorFilter(ContextCompat.getColor(mContext, R.color.orange));
            viewHolder.textView.setTextColor(ContextCompat.getColor(mContext, R.color.blue));
        }
        return convertView;
    }


    private class ViewHolder {
        TextView textView;
        ImageView imageView;

        public ViewHolder(View view) {
            textView = (TextView) view.findViewById(R.id.category_text);
            imageView = (ImageView) view.findViewById(R.id.category_image);
        }
    }
}
