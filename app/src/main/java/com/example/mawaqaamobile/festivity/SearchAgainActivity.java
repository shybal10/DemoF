package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mawaqaamobile.festivity.Fragments.ExploreFragment;
import com.example.mawaqaamobile.festivity.Fragments.PackageFragment;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class SearchAgainActivity extends AppCompatActivity {
    Button packages,explore;
    PackageFragment packageFragment;
    ExploreFragment exploreFragment;
    Boolean searchPackages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_again);
        packages = (Button) findViewById(R.id.packages_button);
        explore = (Button) findViewById(R.id.explore_button);

            showExplore();

    }

    public void openPackagesFragment(View view) {
        showPackages();
    }

    public void openExploreFragment(View view) {
        showExplore();
    }

    private void showPackages() {
        packageFragment = new PackageFragment();
        getFragmentManager().beginTransaction().replace(R.id.search_again_container,packageFragment).commit();
        packages.setBackgroundResource(R.drawable.switchbg);
        packages.setTextColor(SearchAgainActivity.this.getResources().getColor(R.color.white));

        explore.setBackgroundResource(0);
        explore.setTextColor(SearchAgainActivity.this.getResources().getColor(R.color.orange));
    }

    private void showExplore() {
        exploreFragment = new ExploreFragment();
        getFragmentManager().beginTransaction().replace(R.id.search_again_container,exploreFragment).commit();
        explore.setBackgroundResource(R.drawable.switchbg);
        explore.setTextColor(SearchAgainActivity.this.getResources().getColor(R.color.white));

        packages.setBackgroundResource(0);
        packages.setTextColor(SearchAgainActivity.this.getResources().getColor(R.color.orange));
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
