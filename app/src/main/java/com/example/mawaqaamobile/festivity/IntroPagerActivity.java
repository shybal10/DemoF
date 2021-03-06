package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.mawaqaamobile.festivity.Adapters.IntoSwipeAdapter;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class IntroPagerActivity extends AppCompatActivity {
    private IntoSwipeAdapter intoSwipeAdapter;
    private ViewPager viewPager;
    private int dotsCount;
    private ImageView[] dots;
    private LinearLayout slideDots;
    private Button skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_pager);

//        handle button clicks
        skip = (Button) findViewById(R.id.skip_button);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroPagerActivity.this,CategoryActivity.class));
            }
        });

//        set up view pager
        viewPager = (ViewPager) findViewById(R.id.intro_view_pager);
        intoSwipeAdapter = new IntoSwipeAdapter(IntroPagerActivity.this);
        viewPager.setAdapter(intoSwipeAdapter);
        slideDots = (LinearLayout) findViewById(R.id.dot_linear);

//        add slider dots
        dotsCount = intoSwipeAdapter.getCount();
        dots = new ImageView[dotsCount];
        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(IntroPagerActivity.this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(IntroPagerActivity.this, R.drawable.intropagination));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            //layoutParams.setMargins(8,0,8,0);
            slideDots.addView(dots[i], layoutParams);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(IntroPagerActivity.this, R.drawable.intropaginationactive));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(IntroPagerActivity.this, R.drawable.intropagination));

                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(IntroPagerActivity.this, R.drawable.intropaginationactive));

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
