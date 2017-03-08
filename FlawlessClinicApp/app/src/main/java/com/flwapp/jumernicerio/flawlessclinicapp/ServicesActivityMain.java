package com.flwapp.jumernicerio.flawlessclinicapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.flwapp.jumernicerio.flawlessclinicapp.body_services.BodyActivity;
import com.flwapp.jumernicerio.flawlessclinicapp.facials_advanced.AdvancedFacialsServicesActivity;
import com.flwapp.jumernicerio.flawlessclinicapp.hair_removal.HairActivity;
import com.flwapp.jumernicerio.flawlessclinicapp.medical_services.MedicalActivity;
import com.flwapp.jumernicerio.flawlessclinicapp.microdermabrasions.MicrodermabrasionActivity;
import com.flwapp.jumernicerio.flawlessclinicapp.peels.PeelsActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Jumer Nicerio on 3/8/2016.
 */
public class ServicesActivityMain extends BaseActivity implements View.OnClickListener {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                        .setDefaultFontPath("fonts/MelbourneRegularBasic.otf")
                        .setFontAttrId(R.attr.fontPath)
                        .build()
                );
                setContentView(R.layout.activity_services_main);

                ImageButton services_facials = (ImageButton) findViewById(R.id.imgbtn_services_facials);
                services_facials.setOnClickListener(this);
                ImageButton services_micro = (ImageButton) findViewById(R.id.imgbtn_services_micro);
                services_micro.setOnClickListener(this);
                ImageButton services_hair = (ImageButton) findViewById(R.id.imgbtn_services_hair);
                services_hair.setOnClickListener(this);
                ImageButton services_body = (ImageButton) findViewById(R.id.imgbtn_services_body);
                services_body.setOnClickListener(this);
                ImageButton services_peels = (ImageButton) findViewById(R.id.imgbtn_services_peels);
                services_peels.setOnClickListener(this);
                ImageButton services_medical = (ImageButton) findViewById(R.id.imgbtn_services_medical);
                services_medical.setOnClickListener(this);
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
                                        switch (id) {

                                                case R.id.imgbtn_services_facials:
                                                        Intent facials_advanced = new Intent(ServicesActivityMain.this, AdvancedFacialsServicesActivity.class);
                                                        startActivity(facials_advanced);
                                                        break;

                                                case R.id.imgbtn_services_micro:
                                                        Intent micro_service = new Intent(ServicesActivityMain.this, MicrodermabrasionActivity.class);
                                                        startActivity(micro_service);
                                                        break;

                                                case R.id.imgbtn_services_hair:
                                                        Intent hair_service = new Intent(ServicesActivityMain.this, HairActivity.class);
                                                        startActivity(hair_service);
                                                        break;

                                                case R.id.imgbtn_services_body:
                                                        Intent body_service = new Intent(ServicesActivityMain.this, BodyActivity.class);
                                                        startActivity(body_service);
                                                        break;

                                                case R.id.imgbtn_services_peels:
                                                        Intent peels_service = new Intent(ServicesActivityMain.this, PeelsActivity.class);
                                                        startActivity(peels_service);
                                                        break;

                                                case R.id.imgbtn_services_medical:
                                                        Intent medical_service = new Intent(ServicesActivityMain.this, MedicalActivity.class);
                                                        startActivity(medical_service);
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

