package com.flwapp.jumernicerio.flawlessclinicapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

/**
 * Created by Jumer Nicerio on 3/3/2016.
 */
public class NewsActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/FertigoProRegular.otf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        setContentView(R.layout.activity_news);

        ImageButton news_one = (ImageButton) findViewById(R.id.imgbtn_news_one);
        news_one.setOnClickListener(this);
        ImageButton news_two = (ImageButton) findViewById(R.id.imgbtn_news_two);
        news_two.setOnClickListener(this);
        ImageButton news_three = (ImageButton) findViewById(R.id.imgbtn_news_three);
        news_three.setOnClickListener(this);
        ImageButton news_four = (ImageButton) findViewById(R.id.imgbtn_news_four);
        news_four.setOnClickListener(this);
        ImageButton news_rejuvelite = (ImageButton) findViewById(R.id.imgbtn_rejuvelite);
        news_rejuvelite.setOnClickListener(this);
        ImageButton news_fab = (ImageButton) findViewById(R.id.imgbtn_news_fabfifteen_jodi);
        news_fab.setOnClickListener(this);
        ImageButton news_booking_app = (ImageButton) findViewById(R.id.imgbtn_news_booking_app);
        news_booking_app.setOnClickListener(this);
        ImageButton news_summer_fun = (ImageButton) findViewById(R.id.imgbtn_news_summer_fun);
        news_summer_fun.setOnClickListener(this);
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

            case R.id.imgbtn_news_one:
                final Dialog dialog =new Dialog(NewsActivity.this);
                   dialog.setContentView(R.layout.dialog_news_one);
                   dialog.show();

                break;
            case R.id.imgbtn_news_two:
                final Dialog dialog_two =new Dialog(NewsActivity.this);
                dialog_two.setContentView(R.layout.dialog_news_two);
                dialog_two.show();
                break;

            case R.id.imgbtn_news_three:
                final Dialog dialog_three =new Dialog(NewsActivity.this);
                dialog_three.setContentView(R.layout.dialog_news_three);
                dialog_three.show();
                break;

            case R.id.imgbtn_news_four:
                final Dialog dialog_four =new Dialog(NewsActivity.this);
                dialog_four.setContentView(R.layout.dialog_news_four);
                dialog_four.show();
                break;

            case R.id.imgbtn_rejuvelite:
                final Dialog dialog_rejuvelite =new Dialog(NewsActivity.this);
                dialog_rejuvelite.setContentView(R.layout.dialog_rejuvelite);
                dialog_rejuvelite.show();
                break;

            case R.id.imgbtn_news_fabfifteen_jodi:
                final Dialog dialog_news_fabfifteen =new Dialog(NewsActivity.this);
                dialog_news_fabfifteen.setContentView(R.layout.dialog_news_fabfifteen);
                dialog_news_fabfifteen.show();
                break;

            case R.id.imgbtn_news_booking_app:
                final Dialog dialog_news_booking_app =new Dialog(NewsActivity.this);
                dialog_news_booking_app.setContentView(R.layout.dialog_news_booking_app);
                dialog_news_booking_app.show();
                break;
            case R.id.imgbtn_news_summer_fun:
                final Dialog dialog_news_summer_fun =new Dialog(NewsActivity.this);
                dialog_news_summer_fun.setContentView(R.layout.dialog_news_summer_fun);
                dialog_news_summer_fun.show();
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

