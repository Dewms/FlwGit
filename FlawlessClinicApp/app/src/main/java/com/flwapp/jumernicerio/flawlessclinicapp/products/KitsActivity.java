package com.flwapp.jumernicerio.flawlessclinicapp.products;

import android.app.Dialog;
import android.content.Context;
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
public class KitsActivity extends BaseActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/MelbourneRegularBasic.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_products_kits);

        ImageButton acnekit = (ImageButton) findViewById(R.id.imgbtn_acnekit);
        acnekit.setOnClickListener(this);
        ImageButton wkit = (ImageButton) findViewById(R.id.imgbtn_whiteningkit);
        wkit.setOnClickListener(this);
        ImageButton oilkit = (ImageButton) findViewById(R.id.imgbtn_oilkit);
        oilkit.setOnClickListener(this);
        ImageButton bleachingkit = (ImageButton) findViewById(R.id.imgbtn_bleachingkit);
        bleachingkit.setOnClickListener(this);
        ImageButton agedefykit = (ImageButton) findViewById(R.id.imgbtn_agedefykit);
        agedefykit.setOnClickListener(this);
        ImageButton rgkit = (ImageButton) findViewById(R.id.imgbtn_rgkit);
        rgkit.setOnClickListener(this);
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

            case R.id.imgbtn_acnekit:
                final Dialog dialog_acnekit =new Dialog(KitsActivity.this);
                dialog_acnekit.setContentView(R.layout.dialog_acnekit);
                dialog_acnekit.show();
                break;

            case R.id.imgbtn_whiteningkit:
                final Dialog dialog_wkit =new Dialog(KitsActivity.this);
                dialog_wkit.setContentView(R.layout.dialog_wkit);
                dialog_wkit.show();
                break;

            case R.id.imgbtn_agedefykit:
                final Dialog dialog_agedefykit =new Dialog(KitsActivity.this);
                dialog_agedefykit.setContentView(R.layout.dialog_agedefykit);
                dialog_agedefykit.show();
                break;

            case R.id.imgbtn_oilkit:
                final Dialog dialog_oilkit =new Dialog(KitsActivity.this);
                dialog_oilkit.setContentView(R.layout.dialog_oilcontrolkit);
                dialog_oilkit.show();
                break;

            case R.id.imgbtn_rgkit:
                final Dialog dialog_rgkit =new Dialog(KitsActivity.this);
                dialog_rgkit.setContentView(R.layout.dialog_rgkit);
                dialog_rgkit.show();
                break;

            case R.id.imgbtn_bleachingkit:
                final Dialog dialog_bleachingkit =new Dialog(KitsActivity.this);
                dialog_bleachingkit.setContentView(R.layout.dialog_bleaching);
                dialog_bleachingkit.show();
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

