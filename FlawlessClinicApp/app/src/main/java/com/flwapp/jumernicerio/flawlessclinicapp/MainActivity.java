package com.flwapp.jumernicerio.flawlessclinicapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.View;
import android.widget.ImageButton;

import com.flwapp.jumernicerio.flawlessclinicapp.clinics.ClinicsActivity;
import com.flwapp.jumernicerio.flawlessclinicapp.lifestyle_tips.LifestyleActivity;
import com.flwapp.jumernicerio.flawlessclinicapp.products.ProductsActivityMain;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends BaseActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MelbourneRegularBasic.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        ImageButton home_products = (ImageButton) findViewById(R.id.imgbtn_home_products);
        home_products.setOnClickListener(this);
        ImageButton home_services = (ImageButton) findViewById(R.id.imgbtn_home_services);
        home_services.setOnClickListener(this);
        ImageButton home_news = (ImageButton) findViewById(R.id.imgbtn_home_news);
        home_news.setOnClickListener(this);
        ImageButton home_lifestyle = (ImageButton) findViewById(R.id.imgbtn_home_lifestyle);
        home_lifestyle.setOnClickListener(this);
        ImageButton home_clinics = (ImageButton) findViewById(R.id.imgbtn_home_clinics);
        home_clinics.setOnClickListener(this);
        ImageButton home_about = (ImageButton) findViewById(R.id.imgbtn_home_about);
        home_about.setOnClickListener(this);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void onClick(View view) {
        ViewCompat.animate(view)
                .setDuration(200)
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setInterpolator(new CycleInterpolator())
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(final View view) {

                    }

                    @Override
                    public void onAnimationEnd(final View view) {
        int id = view.getId();

        switch (id) {

            case R.id.imgbtn_home_products:
                Intent prod = new Intent(MainActivity.this, ProductsActivityMain.class);
                startActivity(prod);
                break;

            case R.id.imgbtn_home_services:
                Intent serv = new Intent(MainActivity.this, ServicesActivityMain.class);
                startActivity(serv);
                break;

            case R.id.imgbtn_home_news:
                Intent news = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(news);
                break;

            case R.id.imgbtn_home_lifestyle:
                Intent life = new Intent(MainActivity.this, LifestyleActivity.class);
                startActivity(life);
                break;

            case R.id.imgbtn_home_clinics:
                Intent clinic = new Intent(MainActivity.this, ClinicsActivity.class);
                startActivity(clinic);
                break;

            case R.id.imgbtn_home_about:
                Intent about_us = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(about_us);
                break;

        }
                    }
                    @Override
                    public void onAnimationCancel(View view) {

                    }
                })
                .withLayer()
                .start();
    }
    private class CycleInterpolator implements android.view.animation.Interpolator {

        private final float mCycles = 0.5f;

        @Override
        public float getInterpolation(final float input) {
            return (float) Math.sin(2.0f * mCycles * Math.PI * input);
        }
    }
}

