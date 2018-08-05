package com.example.mawaqaamobile.festivity.UIutills;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ServiceCategoryImage extends RelativeLayout {
    public ServiceCategoryImage(Context context) {
        super(context);
    }

    public ServiceCategoryImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ServiceCategoryImage(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);// This is the key that will make the height equivalent to its width
    }
}
