package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.mawaqaamobile.festivity.Adapters.DetailAttributesRecViewAdapter;
import com.example.mawaqaamobile.festivity.Screens.DateScreenActivity;
import com.example.mawaqaamobile.festivity.Screens.TimeActivity;

public class DetailActivity extends AppCompatActivity {
    RelativeLayout dateLayout,timeLayout;
    DetailAttributesRecViewAdapter detailAttributesRecViewAdapter;
    RecyclerView detailAttributesRecView;
    CustomSwipeAdapter customSwipeAdapter;
    Button AddtoCart;
    LinearLayout slideDots;
    ViewPager viewPager;
    ImageButton menu,cart;
    private int dotsCount;
    private ImageView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        handle button clicks
        AddtoCart = (Button) findViewById(R.id.add_to_cart);
        dateLayout = (RelativeLayout) findViewById(R.id.date_layout);
        timeLayout = (RelativeLayout) findViewById(R.id.time_layout);
        dateLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailActivity.this, DateScreenActivity.class));
            }
        });
        timeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailActivity.this, TimeActivity.class));

            }
        });
        AddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailActivity.this.finish();
            }
        });

//        set attributes recycler view
        detailAttributesRecView = (RecyclerView) findViewById(R.id.detail_attributes_rec_view);
        detailAttributesRecViewAdapter = new DetailAttributesRecViewAdapter();
        detailAttributesRecView.setHasFixedSize(true);
        detailAttributesRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        detailAttributesRecView.setAdapter(detailAttributesRecViewAdapter);

//        set up View Pager
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        customSwipeAdapter = new CustomSwipeAdapter(this);
        viewPager.setAdapter(customSwipeAdapter);

//        setup slider dots
        slideDots = (LinearLayout) findViewById(R.id.slider_dots);
        dotsCount = customSwipeAdapter.getCount();
        dots = new ImageView[dotsCount];
        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.pagination));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            slideDots.addView(dots[i], layoutParams);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(this, R.drawable.paginationactive));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(DetailActivity.this, R.drawable.pagination));

                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(DetailActivity.this, R.drawable.paginationactive));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void openCart(View view) {
        startActivity(new Intent(DetailActivity.this,CartActivity.class));
    }

    public void showMenu(View view) {
        startActivity(new Intent(DetailActivity.this,MenuActivity.class));
    }

    public void setAttributes(View view) {
        startActivity(new Intent(DetailActivity.this,AtrributesActivity.class));
    }

    public class CustomSwipeAdapter extends PagerAdapter {
        private int[] images = {R.drawable.banner1,R.drawable.banner1,R.drawable.banner1};
        private Context context;
        private LayoutInflater layoutInflater;
        public CustomSwipeAdapter(Context context) {
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
            View view = layoutInflater.inflate(R.layout.detail_images_swipe,container,false);
            ImageView imageView = (ImageView) view.findViewById(R.id.image_swipe);
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
}
