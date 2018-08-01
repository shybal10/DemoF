package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import com.example.mawaqaamobile.festivity.Adapters.DetailAttributesRecViewAdapter;
import com.example.mawaqaamobile.festivity.Popup.RatingDialog;
import com.example.mawaqaamobile.festivity.Screens.DateScreenActivity;
import com.example.mawaqaamobile.festivity.Screens.TimeActivity;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class DetailActivity extends AppCompatActivity {
    RelativeLayout dateLayout,timeLayout;
    DetailAttributesRecViewAdapter detailAttributesRecViewAdapter;
    RecyclerView detailAttributesRecView;
    CustomSwipeAdapter customSwipeAdapter;
    Button AddtoCart;
    LinearLayout slideDots,rating;
    ViewPager viewPager;
    ImageButton menu,cart;
    private int dotsCount;
    private ImageView[] dots;
    ImageButton like;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        like = (ImageButton) findViewById(R.id.like_btn);
        rating = (LinearLayout) findViewById(R.id.rating_layout);
        rating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final RatingDialog dialog = new RatingDialog(DetailActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.rating_layout);
                dialog.setCanceledOnTouchOutside(true);
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                //lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
                lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.show();
                dialog.getWindow().setAttributes(lp);
            }
        });

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
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isFavourite = readStae();

                if (isFavourite) {
                    like.setImageDrawable(getResources().getDrawable(R.drawable.like));
                    isFavourite = false;
                    saveStae(isFavourite);

                } else {
                    like.setImageDrawable(getResources().getDrawable(R.drawable.coloredlike));
                    isFavourite = true;
                    saveStae(isFavourite);

                }

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

    private void saveStae(boolean isFavourite) {
        SharedPreferences aSharedPreferenes = this.getSharedPreferences(
                "Favourite", Context.MODE_PRIVATE);
        SharedPreferences.Editor aSharedPreferenesEdit = aSharedPreferenes
                .edit();
        aSharedPreferenesEdit.putBoolean("State", isFavourite);
        aSharedPreferenesEdit.commit();
    }

    private boolean readStae() {
        SharedPreferences aSharedPreferenes = this.getSharedPreferences(
                "Favourite", Context.MODE_PRIVATE);
        return aSharedPreferenes.getBoolean("State", true);
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

    public void addToLikes(View view) {
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
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
