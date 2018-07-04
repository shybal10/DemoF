package com.example.mawaqaamobile.festivity.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mawaqaamobile.festivity.R;

public class IntoSwipeAdapter extends PagerAdapter {
    private int[] images = {R.drawable.intro1, R.drawable.intro2,R.drawable.intro3, R.drawable.intro4};
    private String[] text = {"this is the inform about the first functionality of the application festivity, We hope you like it.",
            "This is a test of the text that has to be written and not the actual text that will go into the application i am just writing more to see how long this can go onwithout causing any problems to the application",
            "this is the inform about the third functionality of the application festivity, We hope you like it.",
            "this is the inform about the fourth functionality of the application festivity, We hope you like it."};
    private Context context;
    private LayoutInflater layoutInflater;
    public IntoSwipeAdapter(Context context) {
        this.context = context;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.intro_swipe_layout,container,false);
        ImageView imageView = (ImageView) view.findViewById(R.id.swipe_images);
        TextView textView = (TextView) view.findViewById(R.id.swipe_text_info);
        textView.setText(text[position]);
        imageView.setImageResource(images[position]);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(LinearLayout)object);
    }
}
