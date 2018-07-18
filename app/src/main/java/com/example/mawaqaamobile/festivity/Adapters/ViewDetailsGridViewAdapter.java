package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mawaqaamobile.festivity.R;

import java.util.Random;

public class ViewDetailsGridViewAdapter extends BaseAdapter {
    private Context context;
    public ViewDetailsGridViewAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View imageView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            // if it's not recycled, initialize some attributes
            imageView = new View(context);
            imageView = inflater.inflate(R.layout.view_details_grid_view_item, null);

        }
        else {

            imageView = (View) convertView;

        }

        return imageView;
    }
}
