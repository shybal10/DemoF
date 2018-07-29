package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.example.mawaqaamobile.festivity.Adapters.CategoryGridViewAdapter;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class CategoryActivity extends AppCompatActivity {
    private int[] CategoryImages = {
            R.drawable.birthday, R.drawable.award,
            R.drawable.music, R.drawable.teacup,
            R.drawable.wedding, R.drawable.party
    };
    private String[] CategoryText = {
            "Birthday\nCelebration", "Award\nFestival",
            "Music\nFestival", "Holy Ramadan\nGathering",
            "Wedding", "Special\nParty"
    };
    Button skip,LetStart;
    GridView categoryGridview;
    CategoryGridViewAdapter categoryGridViewAdapter;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout .activity_category);

//        initialize grids
        categoryGridViewAdapter = new CategoryGridViewAdapter(CategoryActivity.this,CategoryImages,CategoryText);
        categoryGridview = (GridView) findViewById(R.id.category_gridview);
        categoryGridview.setAdapter(categoryGridViewAdapter);

//        handle grid click
        categoryGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                categoryGridViewAdapter.selectCategories(position);
                categoryGridViewAdapter.notifyDataSetChanged();
                if (categoryGridViewAdapter.isCategoriesSelected()) {
                    skip.setVisibility(View.GONE);
                    LetStart.setVisibility(View.VISIBLE);
                }
                else{
                    LetStart.setVisibility(View.GONE);
                    skip.setVisibility(View.VISIBLE);
                }
            }
        });


//        handle button clicks
        skip = (Button) findViewById(R.id.skip_button_category);
        LetStart = (Button) findViewById(R.id.lets_start_button_category);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this,LoginActivity.class));
            }
        });

        LetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CategoryActivity.this,LoginActivity.class));
            }
        });
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
