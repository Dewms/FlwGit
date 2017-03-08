package com.flwapp.jumernicerio.flawlessclinicapp;

import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by Jumer Nicerio on 3/3/2016.
 */
public class BaseActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

private NavigationView navigationView;
private DrawerLayout fullLayout;
private Toolbar toolbar;
private ActionBarDrawerToggle drawerToggle;
private int selectedNavItemId;

@Override
public void setContentView(@LayoutRes int layoutResID) {


        fullLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        /**
         * {@link FrameLayout} to inflate the child's view. We could also use a {@link android.view.ViewStub}
         */
        FrameLayout activityContainer = (FrameLayout) fullLayout.findViewById(R.id.activity_content);
        getLayoutInflater().inflate(layoutResID, activityContainer, true);

        super.setContentView(fullLayout);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.navigationView);

        if (useToolbar())
        {
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                toolbar.setClickable(true);

        }
        else
        {
        toolbar.setVisibility(View.GONE);
        }

        setUpNavView();
        }



/**
 * Helper method that can be used by child classes to
 * specify that they don't want a {@link android.support.v7.widget.Toolbar}
 * @return true
 */
protected boolean useToolbar()
        {
        return true;
        }

protected void setUpNavView()
        {
        navigationView.setNavigationItemSelectedListener(this);

        if( useDrawerToggle()) { // use the hamburger menu
        drawerToggle = new ActionBarDrawerToggle(this, fullLayout, toolbar,
        R.string.nav_drawer_opened,
        R.string.nav_drawer_closed);

        fullLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
        } else if(useToolbar() && getSupportActionBar() != null) {

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(getResources()
        .getDrawable(R.drawable.ic_arrow_left));
        }
        }

/**
 * Helper method to allow child classes to opt-out of having the
 * hamburger menu.
 * @return
 */
protected boolean useDrawerToggle()
        {
        return true;
        }


@Override
public boolean onNavigationItemSelected(MenuItem menuItem) {
        fullLayout.closeDrawer(GravityCompat.START);
        selectedNavItemId = menuItem.getItemId();

        return onOptionsItemSelected(menuItem);
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id)
        {
        case R.id.action_main:
        startActivity(new Intent(this, MainActivity.class));
        return true;

        case R.id.action_products:
        startActivity(new Intent(this, AcneControlActivity.class));
        return true;

        case R.id.action_services:
        startActivity(new Intent(this, AgeDefyActivity.class));
        return true;

        case R.id.action_news:
        startActivity(new Intent(this, OilControlActivity.class));
        return true;

        case R.id.action_lifestyle:
        startActivity(new Intent(this, WhiteningActivity.class));
        return true;

        case R.id.action_clinics:
        startActivity(new Intent(this, BodyServicesActivity.class));
        return true;

        case R.id.action_about:
        startActivity(new Intent(this, AboutActivity.class));
        return true;

}
        return super.onOptionsItemSelected(item);
        }
}
