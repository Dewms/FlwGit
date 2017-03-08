package com.flwapp.jumernicerio.flawlessclinicapp.products;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.flwapp.jumernicerio.flawlessclinicapp.BaseActivity;
import com.flwapp.jumernicerio.flawlessclinicapp.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Jumer Nicerio on 3/22/2016.
 */
public class ProductsActivityMain extends BaseActivity implements View.OnClickListener{


@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
        .setDefaultFontPath("fonts/MelbourneRegularBasic.otf")
        .setFontAttrId(R.attr.fontPath)
        .build()
        );
        setContentView(R.layout.activity_products_main);

        ImageButton products_kits = (ImageButton) findViewById(R.id.imgbtn_products_kits);
        products_kits.setOnClickListener(this);
        ImageButton products_individual = (ImageButton) findViewById(R.id.imgbtn_products_individual);
        products_individual.setOnClickListener(this);
        }

@Override
protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
        }

@Override
protected boolean useDrawerToggle() {
        return false;
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_services)
        return true;

        if (item.getItemId() == android.R.id.home)
        onBackPressed();

        return super.onOptionsItemSelected(item);
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
        switch (id){

        case R.id.imgbtn_products_kits:
        Intent kits_products = new Intent(ProductsActivityMain.this, KitsActivity.class);
        startActivity(kits_products);
        break;

        case R.id.imgbtn_products_individual:
       Intent individual_products = new Intent(ProductsActivityMain.this, ProductsActivity.class);
        startActivity(individual_products);
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
