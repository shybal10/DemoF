package com.example.mawaqaamobile.festivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jaeger.library.StatusBarUtil;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class SplashActivity extends AppCompatActivity {
    LinearLayout background;
    ImageView logo;
    private static final int DISPLAY_TIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StatusBarUtil.setTransparent(SplashActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        background = (LinearLayout) findViewById(R.id.splash_bg);
        logo = (ImageView) findViewById(R.id.splash_logo);
        background.setBackground(getResources().getDrawable(R.drawable.splash_bg_animation));
        final AnimationDrawable progressAnimation = (AnimationDrawable) background.getBackground();
        progressAnimation.start();


        final Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(1500);
        logo.setAnimation(fadeIn);


        Animation appearTop = new TranslateAnimation(0, 0,100, 0);
        appearTop.setDuration(1500);
        appearTop.setFillAfter(true);

        AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(fadeIn);
        animation.addAnimation(appearTop);
        logo.setAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressAnimation.stop();
                startActivity(new Intent(SplashActivity.this,IntroPagerActivity.class));
                SplashActivity.this.finish();
            }
        },DISPLAY_TIME);
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
