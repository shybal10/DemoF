package com.example.mawaqaamobile.festivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mawaqaamobile.festivity.Adapters.CategoryGridViewAdapter;

import org.w3c.dom.Text;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {
    private int[] CategoryImages = {
            R.drawable.birthday, R.drawable.award,
            R.drawable.music, R.drawable.teacup,
            R.drawable.wedding, R.drawable.party
    };
    private String[] CategoryText = {
            "Birthday Celebration", "Award Festival",
            "Music Festival", "Holy Ramadan Gathering",
            "Wedding", "Special Party"
    };
    int previousPosition = -1;
    Button skip,LetStart;
    GridView categoryGridview;
    CategoryGridViewAdapter categoryGridViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        skip = (Button) findViewById(R.id.skip_button_category);
        LetStart = (Button) findViewById(R.id.lets_start_button_category);
        categoryGridViewAdapter = new CategoryGridViewAdapter(CategoryActivity.this,CategoryImages,CategoryText);
        categoryGridview = (GridView) findViewById(R.id.category_gridview);
        categoryGridview.setAdapter(categoryGridViewAdapter);
        categoryGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                skip.setVisibility(View.GONE);
                LetStart.setVisibility(View.VISIBLE);
                categoryGridViewAdapter.makeAllUnselect(position);
                categoryGridViewAdapter.notifyDataSetChanged();
            }
        });

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
}
