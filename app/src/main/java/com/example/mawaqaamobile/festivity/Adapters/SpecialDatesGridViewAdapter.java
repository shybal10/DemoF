package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.mawaqaamobile.festivity.R;

public class SpecialDatesGridViewAdapter extends BaseAdapter {
    private Context context;
    public SpecialDatesGridViewAdapter(Context context) {
        this.context = context;
    }
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View imageView;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            // if it's not recycled, initialize some attributes
            imageView = new View(context);
            imageView = inflater.inflate(R.layout.special_dates_grid_view_item, null);

        }
        else {

            imageView = (View) convertView;

        }

        return imageView;
    }
    }
