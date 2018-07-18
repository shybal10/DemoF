package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.mawaqaamobile.festivity.R;

import java.util.Random;

public class ServiceCategoryGridAdapter extends BaseAdapter {

    private Context context;

    public ServiceCategoryGridAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 15;
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
            imageView = inflater.inflate(R.layout.service_cat_grid_layout, null);
            int[] androidColors = context.getResources().getIntArray(R.array.androidcolors);
            int randomAndroidColor = androidColors[new Random().nextInt(androidColors.length)];
            imageView.setBackgroundColor(randomAndroidColor);

        }
        else {

            imageView = (View) convertView;

        }
        return imageView;

    }
}
